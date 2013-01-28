/*******************************************************************************
 * Copyright (C) 2012
 * The Stanford Natural Language Processing Group 
 * http://nlp.stanford.edu/
 * This Eclipse plugin matches the Stanford CoreNLP version 1.3.3
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 ******************************************************************************/
package edu.stanford.nlp.util.logging;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A hierarchical channel based logger. Log messages are arranged hierarchically by depth
 * (e.g. main->tagging->sentence 2) using the startTrack() and endTrack() methods.
 * Furthermore, messages can be flagged with a number of channels, which allow filtering by channel.
 * Log levels are implemented as channels (ERROR, WARNING, etc).
 *
 * Details on the handlers used are documented in their respective classes, which all implement
 * {@link LogRecordHandler}.
 * New handlers should implement this class.
 *
 * Details on configuring Redwood can be found in the {@link RedwoodConfiguration} class.
 * New configuration methods should be implemented in this class, following the standard
 * builder paradigm.
 *
 * There is a <a href="http://nlp.stanford.edu/javanlp/tutorials/Redwood.pdf"> tutorial on Redwood </a> on the
 * NLP website.
 *
 * @author Gabor Angeli (angeli at cs.stanford)
 * @author David McClosky
 */

/* TODO
 *      bug: multithreaded environment breaks RepeatedRecordHandler (doesn't print number of missed lines); this might be a general bug with RepeatedRecordHandler
 *      bug: RepeatedRecordHandler thinks that empty tracks are still seen (prints the "repeated messages" message)
 *      bug: Approximate repeated record prints wrong repeat count on top-level log messages
 *      bug: In multithreaded environment, time a track took is time from begin to print, not begin to end (the latter is, in general, shorter).
 *      feature: stack trace appending should maybe be a handler (for efficiency)
 *      feature: prevent interleaving of stdout/stderr (if doable...maybe via locking)
 *      feature: support for automatically assigning channels from calling class/method
 *      feature: convert the main() method into an ITest
 *      ideas for new handlers:
 *      -   record histogram of messages, tell you about frequent log messages when program ends
 *      -   if messages match certain criteria, dump a stack trace (for tracking down random print statements)
 *      -   basic filtering: filter messages if they match certain channels, source methods, are inside a specific track, etc.
 */

public class Redwood {

  /*
      ---------------------------------------------------------
      VARIABLES
      ---------------------------------------------------------
   */
  // -- UTILITIES --
  public static final Flag ERR    = Flag.ERROR;
  public static final Flag WARN   = Flag.WARN;
  public static final Flag DBG    = Flag.DEBUG;
  public static final Flag FORCE  = Flag.FORCE;
  public static final Flag STDOUT = Flag.STDOUT;
  public static final Flag STDERR = Flag.STDERR;

  // -- STREAMS --
  /**
   * The real System.out stream
   */
  private static final PrintStream realSysOut = System.out;
  /**
   * The real System.err stream
   */
  private static final PrintStream realSysErr = System.err;

  // -- BASIC LOGGING --
  /**
   * The tree of handlers
   */
  private static RecordHandlerTree handlers = new RecordHandlerTree();
  /**
   * The current depth of the logger
   */
  private static int depth = 0;
  /**
   * The stack of track titles, for consistency checking
   * the endTrack() call
   */
  private static Stack<String> titleStack = new Stack<String>();
  /**
   * List of known logging classes.  These get excluded from stack trace selection.
   */
  private static Set<String> loggingClasses;
  /**
   * Signals that no more log messages should be accepted by Redwood
   */
  private static boolean isClosed = false;

  // -- THREADED ENVIRONMENT --
  /**
   * Queue of tasks to be run in various threads
   */
  private static final Map<Long,Queue<Runnable>> threadedLogQueue = new HashMap<Long,Queue<Runnable>>();
  /**
   * Thread id which currently has control of the Redwood
   */
  private static long currentThread = -1L;
  /**
   * Threads which have something they wish to log, but do not yet
   * have control of Redwood
   */
  private static Queue<Long> threadsWaiting = new LinkedList<Long>();
  /**
   * Indicator that messages are coming from multiple threads
   */
  private static boolean isThreaded = false;

  /**
   * Synchronization
   */
  private static ReentrantLock control = new ReentrantLock();

  /*
      ---------------------------------------------------------
      HELPER METHODS
      ---------------------------------------------------------
   */

  private static void queueTask(long threadId, Runnable toRun){
    assert control.isHeldByCurrentThread();
    assert threadId != currentThread;
    //(get queue)
    if(!threadedLogQueue.containsKey(threadId)){
      threadedLogQueue.put(threadId, new LinkedList<Runnable>());
    }
    Queue<Runnable> threadLogQueue = threadedLogQueue.get(threadId);
    //(add to queue)
    threadLogQueue.offer( toRun );
    //(register this thread as waiting)
    if(!threadsWaiting.contains(threadId)){
      threadsWaiting.offer(threadId);
      assert threadedLogQueue.get(threadId) != null && !threadedLogQueue.get(threadId).isEmpty();
    }
  }

  private static void releaseThreadControl(long threadId){
    assert !isThreaded || control.isHeldByCurrentThread();
    assert currentThread < 0L || currentThread == threadId;
    //(release control)
    currentThread = -1L;
  }

  private static void attemptThreadControl(long threadId, Runnable r){
    //(get lock)
    boolean tookLock = false;
    if(!control.isHeldByCurrentThread()){
      control.lock();
      tookLock = true;
    }
    //(perform action)
    attemptThreadControlThreadsafe(threadId);
    if(threadId == currentThread){ 
      r.run(); 
    } else { 
      queueTask(threadId, r);
    }
    //(release lock)
    assert control.isHeldByCurrentThread();
    if(tookLock){
      control.unlock();
    }
  }

  private static void attemptThreadControlThreadsafe(long threadId){
    //--Assertions
    assert control.isHeldByCurrentThread();
    //--Update Current Thread
    boolean hopeless = true;
    if(currentThread < 0L){
      //(case: no one has control)
      if(threadsWaiting.isEmpty()){
        currentThread = threadId;
      } else {
        currentThread = threadsWaiting.poll();
        hopeless = false;
        assert threadedLogQueue.get(currentThread) == null || !threadedLogQueue.get(currentThread).isEmpty();
      }
    } else if(currentThread == threadId) {
      //(case: we have control)
      threadsWaiting.remove(currentThread);
    } else if(currentThread >= 0L){
      //(case: someone else has control
      threadsWaiting.remove(currentThread);
    } else {
      assert false;
    }
    //--Clear Backlog
    long activeThread = currentThread;
    Queue<Runnable> backlog = threadedLogQueue.get(currentThread);
    if(backlog != null){
      //(run backlog)
      while(!backlog.isEmpty() && currentThread >= 0L){
        backlog.poll().run();
      }
      //(requeue, if applicable)
      assert activeThread == currentThread || currentThread < 0L;
      if(currentThread < 0L && !backlog.isEmpty()){
        threadsWaiting.offer(activeThread);
        hopeless = false;
      }
    }
    //--Recursive
    if(!hopeless &&  currentThread != threadId){
      attemptThreadControlThreadsafe(threadId);
    }
    assert !threadsWaiting.contains(currentThread);
    assert control.isHeldByCurrentThread();
  }

  /*
      ---------------------------------------------------------
      [PSEUDO]-PUBLIC FACING METHODS
      ---------------------------------------------------------
   */
  /**
   * Remove a handler from the list
   * @param toRemove The handler to remove. Any handler object that
   * matches this class will be removed.
   * @return true if this handler was in the list.
   */
  protected static <E extends LogRecordHandler> boolean removeHandler(Class<E> toRemove) {
    boolean rtn = false;
    Iterator<LogRecordHandler> iter = handlers.iterator();
    while(iter.hasNext()){
      if(iter.next().getClass().equals(toRemove)){
        rtn = true;
        iter.remove();
      }
    }
    return rtn;
  }

  protected static void spliceHandler(LogRecordHandler parent, LogRecordHandler toAdd, LogRecordHandler grandchild){
    RecordHandlerTree p = handlers.find(parent);
    if(p != null){
      //(add child)
      p.addChild(toAdd);
      //(remove spliced child)
      Iterator<RecordHandlerTree> iter = p.children();
      RecordHandlerTree removed = null;
      while(iter.hasNext()){
        RecordHandlerTree cand = iter.next();
        if(cand.head() == grandchild){
          removed = cand;
          iter.remove();
        }
      }
      //(add grandchildren)
      if(removed != null){
        p.find(toAdd).addChildTree(removed);
      }
    } else {
      throw new IllegalArgumentException("No such parent handler: " + parent);
    }
  }

  protected static void spliceHandler(LogRecordHandler parent, LogRecordHandler toAdd, Class<? extends LogRecordHandler> grandchild){
    RecordHandlerTree p = handlers.find(parent);
    if(p != null){
      //(add child)
      p.addChild(toAdd);
      //(remove spliced children)
      Iterator<RecordHandlerTree> iter = p.children();
      List<RecordHandlerTree> lst = new ArrayList<RecordHandlerTree>();
      while(iter.hasNext()){
        RecordHandlerTree cand = iter.next();
        if(grandchild.isAssignableFrom(cand.head().getClass())){
          lst.add(cand);
          iter.remove();
        }
      }
      //(add grandchildren)
      for(RecordHandlerTree gc : lst){
        p.find(toAdd).addChildTree(gc);
      }
    } else {
      throw new IllegalArgumentException("No such parent handler: " + parent);
    }
  }

  protected static void spliceHandler(Class<? extends LogRecordHandler> parent, LogRecordHandler toAdd, Class<? extends LogRecordHandler> grandchild){
    List<LogRecordHandler> lst = new LinkedList<LogRecordHandler>();
    //--Find Parents
    for(LogRecordHandler term : handlers){
      if(parent.isAssignableFrom(term.getClass())){
        lst.add(term);
      }
    }
    //--Add Handler
    for(LogRecordHandler p : lst){
      spliceHandler(p, toAdd, grandchild);
    }
  }

  /**
   * Append a Handler to a portion of the handler tree
   * @param parent The parent to add the child to
   * @param child The Handler to add.
   */
  protected static void appendHandler(LogRecordHandler parent, LogRecordHandler child){
    RecordHandlerTree p = handlers.find(parent);
    if(p != null){
      p.addChild(child);
    } else {
      throw new IllegalArgumentException("No such parent handler: " + parent);
    }
  }

  /**
   * Append a Handler to every parent of the given class
   * @param parent The class of the parents to add the child to
   * @param child The Handler to add.
   */
  protected static void appendHandler(Class<? extends LogRecordHandler> parent, LogRecordHandler child){
    List<LogRecordHandler> toAdd = new LinkedList<LogRecordHandler>();
    //--Find Parents
    for(LogRecordHandler term : handlers){
      if(parent.isAssignableFrom(term.getClass())){
        toAdd.add(term);
      }
    }
    //--Add Handler
    for(LogRecordHandler p : toAdd){
      appendHandler(p, child);
    }
  }

  /**
   * Append a Handler to the end of the root of the Handler tree.
   * @param child The Handler to add.
   */
  protected static void appendHandler(LogRecordHandler child){
    handlers.addChild(child);
  }

  /**
   * Remove all log handlers from Redwood, presumably in order to
   * construct a custom pipeline afterwards
   */
  protected static void clearHandlers(){
    handlers = new RecordHandlerTree();
  }

  /**
   * Get a handler based on its class
   * @param clazz The class of the Handler to return.
   *              If multiple Handlers exist, the first one is returned.
   * @param <E> The class of the handler to return.
   * @return The handler matching the class name.
   */
  @Deprecated
  @SuppressWarnings("unchecked")
  private static <E extends LogRecordHandler> E getHandler(Class<E> clazz){
    for(LogRecordHandler cand : handlers){
      if(clazz == cand.getClass()){
        return (E) cand;
      }
    }
    return null;
  }

  /**
   * Captures System.out and System.err and redirects them
   * to Redwood logging.
   * @param captureOut True is System.out should be captured
   * @param captureErr True if System.err should be captured
   */
  protected static void captureSystemStreams(boolean captureOut, boolean captureErr){
    if(captureOut){
      System.setOut(new RedwoodPrintStream(STDOUT, realSysOut));
    }
    if(captureErr){
      System.setErr(new RedwoodPrintStream(STDERR, realSysErr));
    }
  }

  /**
   * Restores System.out and System.err to their original values
   */
  protected static void restoreSystemStreams(){
    System.setOut(realSysOut);
    System.setErr(realSysErr);
  }


  /**
   * Add a class to the list of known logging classes.  Any stack trace element that starts with these class names is skipped.
   * @param className The class to report as a logging class
   */
  protected static void addLoggingClass(String className) {
    loggingClasses.add(className);
  }

  /**
   * Removes all classes from the list of known logging classes
   */
  protected static void clearLoggingClasses(){
    if(loggingClasses == null){ loggingClasses = new HashSet<String>(); }
    loggingClasses.clear();
  }

  /*
      ---------------------------------------------------------
      TRUE PUBLIC FACING METHODS
      ---------------------------------------------------------
   */

  /**
   * Log a message. The last argument to this object is the message to log
   * (usually a String); the first arguments are the channels to log to.
   *
   * For example:
   *
   * log(Redwood.ERR,"tag","this message is tagged with ERROR and tag")
   *
   * @param args The last argument is the message; the first arguments are the channels.
   */
  public static void log(Object... args) {
    //--Argument Check
    if(args.length == 0){ return; }
    if(isClosed){ return; }
    //--Create Record
    final Object content = args[args.length-1];
    final Object[] tags = new Object[args.length-1];
    final StackTraceElement ste = getStackTrace();
    System.arraycopy(args,0,tags,0,args.length-1);
    final long timestamp = System.currentTimeMillis();
    //--Handle Record
    if(isThreaded){
      //(case: multithreaded)
      final Runnable log = new Runnable(){
        public void run(){
          assert !isThreaded || control.isHeldByCurrentThread();
          Record toPass = new Record(content,tags,depth,ste,timestamp);
          handlers.process(toPass, MessageType.SIMPLE,depth, toPass.timesstamp);
          assert !isThreaded || control.isHeldByCurrentThread();
        }
      };
      long threadId = Thread.currentThread().getId();
      attemptThreadControl( threadId, log );
    } else {
      //(case: no threading)
      Record toPass = new Record(content,tags,depth,ste,timestamp);
      handlers.process(toPass, MessageType.SIMPLE,depth, toPass.timesstamp);
    }
  }

  public static void logf(String format, Object... args){ log(new Formatter().format(format, args)); }

  /**
   * Begin a "track;" that is, begin logging at one level deeper.
   * Channels other than the FORCE channel are ignored.
   * @param args The title of the track to begin, with an optional FORCE flag.
   */
  public static void startTrack(final Object... args){
    if(isClosed){ return; }
    //--Create Record
    final int len = args.length == 0 ? 0 : args.length-1;
    final Object content = args.length == 0 ? "" : args[len];
    final Object[] tags = new Object[len];
    final StackTraceElement ste = getStackTrace();
    final long timestamp = System.currentTimeMillis();
    System.arraycopy(args,0,tags,0,len);
    //--Create Task
    final Runnable startTrack = new Runnable(){
      public void run(){
        assert !isThreaded || control.isHeldByCurrentThread();
        Record toPass = new Record(content,tags,depth,ste,timestamp);
        depth += 1;
        titleStack.push(args.length == 0 ? "" : args[len].toString());
        handlers.process(toPass, MessageType.START_TRACK, depth, toPass.timesstamp);
        assert !isThreaded || control.isHeldByCurrentThread();
      }
    };
    //--Run Task
    if(isThreaded){
      //(case: multithreaded)
      long threadId = Thread.currentThread().getId();
      attemptThreadControl( threadId, startTrack );
    } else {
      //(case: no threading)
      startTrack.run();
    }
  }
  
  /**
   * Helper method to start a track on the FORCE channel.
   * @param arg
   */
  public static void forceTrack(Object arg) {
    startTrack(FORCE, arg);
  }
  
  /**
   * Helper method to start an anonymous track on the FORCE channel.
   */
  public static void forceTrack() {
    startTrack(FORCE, "");
  }

  /**
   * End a "track;" that is, return to logging at one level shallower.
   * @param title A title that should match the beginning of this track.
   */
  public static void endTrack(final String title){
    if(isClosed){ return; }
    //--Make Task
    final long timestamp = System.currentTimeMillis();
    Runnable endTrack = new Runnable(){
      public void run(){
        assert !isThreaded || control.isHeldByCurrentThread();
        //(check name match)
        String expected = titleStack.pop();
        if(!expected.equalsIgnoreCase(title)){
          throw new IllegalArgumentException("Track names do not match: expected: " + expected + " found: " + title);
        }
        //(decrement depth)
        depth -= 1;
        //(send signal)
        handlers.process(null, MessageType.END_TRACK, depth, timestamp);
        assert !isThreaded || control.isHeldByCurrentThread();
      }
    };
    //--Run Task
    if(isThreaded){
      //(case: multithreaded)
      long threadId = Thread.currentThread().getId();
      attemptThreadControl( threadId, endTrack );
    } else {
      //(case: no threading)
      endTrack.run();
    }
  }

  /**
   * A utility method for closing calls to the anonymous startTrack() call.
   */
  public static void endTrack(){ endTrack(""); }


  /**
   * Start a multithreaded logging environment. Log messages will be real time
   * from one of the threads; as each thread finishes, another thread begins logging,
   * first by making up the backlog, and then by printing any new log messages.
   * A thread signals that it has finished logging with the finishThread() function;
   * the multithreaded environment is ended with the endThreads() function
   * @param title The name of the thread group being started
   */
  public static void startThreads(String title){
    if(isThreaded){
      throw new IllegalStateException("Cannot nest Redwood threaded environments");
    }
    startTrack(FORCE,"Threads( "+title+" )");
    isThreaded = true;
  }

  /**
   * Signal that this thread will not log any more messages in the multithreaded
   * environment
   */
  public static void finishThread(){
    //--Create Task
    final long threadId = Thread.currentThread().getId();
    Runnable finish = new Runnable(){
      public void run(){
        releaseThreadControl(threadId);
      }
    };
    //--Run Task
    if(isThreaded){
      //(case: multithreaded)
      attemptThreadControl( threadId, finish );
    } else {
      //(case: no threading)
      throw new IllegalStateException("finishThreads() called outside of threaded environment");
    }
  }

  /**
   * Signal that all threads have run to completion, and the multithreaded
   * environment is over.
   * @param check The name of the thread group passed to startThreads()
   */
  public static void endThreads(String check){
    //(error check)
    if(currentThread != -1L){
      throw new IllegalStateException("endThreads() called, but thread " + currentThread + " has not finished (exception in thread?)");
    }
    //(end threaded environment)
    assert !control.isHeldByCurrentThread();
    isThreaded = false;
    //(write remaining threads)
    boolean cleanPass = false;
    while(!cleanPass){
      cleanPass = true;
      for(long thread : threadedLogQueue.keySet()){
        assert currentThread < 0L;
        if(threadedLogQueue.get(thread) != null && !threadedLogQueue.get(thread).isEmpty()){
          //(mark queue as unclean)
          cleanPass = false;
          //(variables)
          Queue<Runnable> backlog = threadedLogQueue.get(thread);
          currentThread = thread;
          //(clear buffer)
          while(currentThread >= 0){
            if(currentThread != thread){ throw new IllegalStateException("Redwood control shifted away from flushing thread"); }
            if(backlog.isEmpty()){ throw new IllegalStateException("Forgot to call finishThread() on thread " + currentThread); }
            assert !control.isHeldByCurrentThread();
            backlog.poll().run();
          }
          //(unregister thread)
          threadsWaiting.remove(thread);
        }
      }
    }
    while(threadsWaiting.size() > 0){
      assert currentThread < 0L;
      assert control.tryLock();
      assert !threadsWaiting.isEmpty();
      control.lock();
      attemptThreadControlThreadsafe(-1);
      control.unlock();
    }
    //(clean up)
    for(long threadId : threadedLogQueue.keySet()){
      assert threadedLogQueue.get(threadId).isEmpty();
    }
    assert threadsWaiting.isEmpty();
    assert currentThread == -1L;
    endTrack("Threads( "+check+" )");
  }

  /**
   * Create an object representing a group of channels.
   * {@link RedwoodChannels} contains a more complete description.
   * 
   * @see RedwoodChannels
   */
  public static RedwoodChannels channels(Object... channelNames) {
    return new RedwoodChannels(channelNames);
  }
  
  /**
   * Show only the given channel.
   * @param channels The channels to show
   */
  public static void showOnlyChannels(Object... channels){
    for(LogRecordHandler handler : handlers){
      if(handler instanceof VisibilityHandler){
        VisibilityHandler visHandler = (VisibilityHandler) handler;
        visHandler.hideAll();
        for (Object channel : channels) {
          visHandler.alsoShow(channel);
        }
      }
    }
  }

  /**
   * Hide multiple channels.  All other channels will be shown.
   * @param channels The channels to hide
   */
  public static void hideOnlyChannels(Object... channels){
    for(LogRecordHandler handler : handlers){
      if(handler instanceof VisibilityHandler){
        VisibilityHandler visHandler = (VisibilityHandler) handler;
        visHandler.showAll();
        for (Object channel : channels) {
          visHandler.alsoHide(channel);
        }
      }
    }
  }
  
  /**
   * Show multiple channels.  All other channels will be unaffected.
   * @param channels The channels to show
   */
  public static void showChannels(Object... channels){
    // TODO this could share more code with the other show/hide(Only)Channels methods
    for(LogRecordHandler handler : handlers){
      if(handler instanceof VisibilityHandler){
        VisibilityHandler visHandler = (VisibilityHandler) handler;
        for (Object channel : channels) {
          visHandler.alsoShow(channel);
        }
      }
    }
  }
  
  /**
   * Hide multiple channels.  All other channels will be unaffected.
   * @param channels The channels to hide
   */
  public static void hideChannels(Object... channels){
    // TODO this could share more code with the other show/hide(Only)Channels methods
    for(LogRecordHandler handler : handlers){
      if(handler instanceof VisibilityHandler){
        VisibilityHandler visHandler = (VisibilityHandler) handler;
        for (Object channel : channels) {
          visHandler.alsoHide(channel);
        }
      }
    }
  }
  
  /**
   * Show all channels.
   */
  public static void showAllChannels(){
    for(LogRecordHandler handler : handlers){
      if(handler instanceof VisibilityHandler){
        ((VisibilityHandler) handler).showAll();
      }
    }
  }
  
  /**
   * Hide all channels.
   */
  public static void hideAllChannels(){
    for(LogRecordHandler handler : handlers){
      if(handler instanceof VisibilityHandler){
        ((VisibilityHandler) handler).hideAll();
      }
    }
  }

  /**
   * Stop Redwood, closing all tracks and prohibiting future log messages.
   */
  public static void stop(){
    //--Close logger
    isClosed = true; // <- not a thread-safe boolean
    Thread.yield(); //poor man's synchronization attempt (let everything else log that wants to)
    Thread.yield();
    //--Close Tracks
    while(depth > 0){
      depth -= 1;
      //(send signal to handlers)
      handlers.process(null, MessageType.END_TRACK, depth, System.currentTimeMillis());
    }
    //--Shutdown
    handlers.process(null, MessageType.SHUTDOWN, 0, System.currentTimeMillis());
  }

  /*
      ---------------------------------------------------------
      UTILITY METHODS
      ---------------------------------------------------------
   */

  /**
   * Utility method for formatting a time difference (maybe this should go to a util class?)
   * @param diff Time difference in milliseconds
   * @param b The string builder to append to
   */
  protected static void formatTimeDifference(long diff, StringBuilder b){
    //--Get Values
    int mili = (int) diff % 1000;
    long rest = diff / 1000;
    int sec = (int) rest % 60;
    rest = rest / 60;
    int min = (int) rest % 60;
    rest = rest / 60;
    int hr = (int) rest % 24;
    rest = rest / 24;
    int day = (int) rest;
    //--Make String
    if(day > 0) b.append(day).append(day > 1 ? " days, " : " day, ");
    if(hr > 0) b.append(hr).append(hr > 1 ? " hours, " : " hour, ");
    if(min > 0) {
      if(min < 10){ b.append("0"); }
      b.append(min).append(":");
    }
    if(min > 0 && sec < 10){ b.append("0"); }
    b.append(sec).append(".").append(mili);
    if(min > 0) b.append(" minutes");
    else b.append(" seconds");
  }

  /**
   * Get the current stack trace element, skipping anything from known logging classes.
   * @return The current stack trace for this thread
   */
  private static StackTraceElement getStackTrace() {
    StackTraceElement[] stack = Thread.currentThread().getStackTrace();

    int i = 2; // we can skip the first two (first is getStackTrace(), second is this method)
    while (i < stack.length) {
      boolean isLoggingClass = false;
      for (String loggingClass : loggingClasses) {
        String className = stack[i].getClassName();
        if (className.startsWith(loggingClass)) {
          isLoggingClass = true;
          break;
        }
      }
      if (!isLoggingClass) {
        break;
      }

      i += 1;
    }

    // if we didn't find anything, keep last element (probably shouldn't happen, but could if people add too many logging classes)
    if (i >= stack.length) {
      i = stack.length - 1;
    }
    return stack[i];
  }

  /**
   * Removes logging classes from a stack trace.
   */
  protected static List<StackTraceElement> filterStackTrace(StackTraceElement[] stack) {
    List<StackTraceElement> filteredStack = new ArrayList<StackTraceElement>();

    int i = 2; // we can skip the first two (first is getStackTrace(), second is this method)
    while (i < stack.length) {
      boolean isLoggingClass = false;
      for (String loggingClass : loggingClasses) {
        String className = stack[i].getClassName();
        if (className.startsWith(loggingClass)) {
          isLoggingClass = true;
          break;
        }
      }
      if (!isLoggingClass) {
        filteredStack.add(stack[i]);
      }

      i += 1;
    }

    // if we didn't find anything, keep the full stack
    if (filteredStack.size() == 0) {
      return Arrays.asList(stack);
    }
    return filteredStack;
  }

  protected static boolean supportsAnsi(){
    String os = System.getProperty("os.name").toLowerCase();
    boolean isUnix = os.contains("unix") || os.contains("linux") || os.contains("solaris");
    return Boolean.getBoolean("Ansi") || (isUnix); // TODO Java 1.6 add this: "|| (isUnix && System.console()!=null))"
  }

  /**
   * Set up the default logger.
   */
  static {
    RedwoodConfiguration.standard().apply();
  }

  /**
   * An enumeration of the types of "messages" you can send a handler
   */
  private static enum MessageType{ SIMPLE, START_TRACK, SHUTDOWN, END_TRACK }

  /**
   * A tree structure of record handlers
   */
  protected static class RecordHandlerTree implements Iterable<LogRecordHandler>{
    // -- Overhead --
    private boolean isRoot = false;
    private LogRecordHandler head;
    private ArrayList<RecordHandlerTree> children = new ArrayList<RecordHandlerTree>();
    public RecordHandlerTree(){ isRoot = true; }
    public RecordHandlerTree(LogRecordHandler head){
      this.head = head;
    }
    // -- Core Tree Methods --
    public LogRecordHandler head(){
      return head;
    }
    public Iterator<RecordHandlerTree> children(){
      return children.iterator();
    }
    // -- Utility Methods --
    public void addChild(LogRecordHandler handler){
      if(Redwood.depth != 0){
        throw new IllegalStateException("Cannot modify Redwood when within a track");
      }
      children.add(new RecordHandlerTree(handler));
    }
    private void addChildTree(RecordHandlerTree tree){
      if(Redwood.depth != 0){
        throw new IllegalStateException("Cannot modify Redwood when within a track");
      }
      children.add(tree);
    }
    public LogRecordHandler removeChild(LogRecordHandler handler){
      if(Redwood.depth != 0){
        throw new IllegalStateException("Cannot modify Redwood when within a track");
      }
      Iterator<RecordHandlerTree> iter = children();
      while(iter.hasNext()){
        LogRecordHandler cand = iter.next().head();
        if(cand == handler){
          iter.remove();
          return cand;
        }
      }
      return null;
    }
    public RecordHandlerTree find(LogRecordHandler toFind){
      if(toFind == head()){
        return this;
      } else {
        Iterator<RecordHandlerTree> iter = children();
        while(iter.hasNext()){
          RecordHandlerTree cand = iter.next().find(toFind);
          if(cand != null){ return cand; }
        }
      }
      return null;
    }
    public Iterator<LogRecordHandler> iterator() {
      return new Iterator<LogRecordHandler>(){
        // -- Variables
        private boolean seenHead = isRoot;
        private Iterator<RecordHandlerTree> childrenIter = children();
        private RecordHandlerTree childOnPrix = childrenIter.hasNext() ? childrenIter.next() : null;
        private Iterator<LogRecordHandler> childIter = childOnPrix == null ? null : childOnPrix.iterator();
        private LogRecordHandler lastReturned = null;
        // -- HasNext
        public boolean hasNext() {
          while(childIter != null && !childIter.hasNext()){
            if(!childrenIter.hasNext()) {
              break;
            } else {
              childIter = childrenIter.next().iterator();
            }
          }
          return !seenHead || (childIter != null && childIter.hasNext());
        }
        // -- Next
        public LogRecordHandler next() {
          if(!seenHead){ seenHead = true; return head(); }
          lastReturned = childIter.next();
          return lastReturned;
        }
        // -- Remove
        public void remove() {
          if(!seenHead){ throw new IllegalStateException("INTERNAL: this shouldn't happen..."); }
          if(lastReturned == null){ throw new IllegalStateException("Called remove() before any elements returned"); }
          if(childOnPrix != null && lastReturned == childOnPrix.head()){
            childrenIter.remove();
          } else if(childIter != null){
            childIter.remove();
          } else {
            throw new IllegalStateException("INTERNAL: not sure what we're removing");
          }
        }
      };
    }

    private List<Record> append(List<Record> lst, Record toAppend){
      if(lst == LogRecordHandler.EMPTY){
        lst = new ArrayList<Record>();
      }
      lst.add(toAppend);
      return lst;
    }

    private void process(Record toPass, MessageType type, int newDepth, long timestamp){
      //--Handle Message
      //(records to pass on)
      List<Record> toPassOn = null;
      if(head != null){
        //(case: not root)
        switch(type){
          case SIMPLE:
            //(case: simple log message)
            toPassOn = head.handle(toPass);
            break;
          case START_TRACK:
            //(case: begin a new track)
            toPassOn = head.signalStartTrack(toPass);
            break;
          case END_TRACK:
            //case: end a track)
            toPassOn = head.signalEndTrack(newDepth, timestamp);
            break;
          case SHUTDOWN:
            //case: end a track)
            toPassOn = head.signalShutdown();
            break;
          default:
            throw new IllegalStateException("MessageType was non-exhaustive: " + type);
        }
      } else {
        //(case: is root)
        toPassOn = new ArrayList<Record>();
        switch(type){
          case SIMPLE:
            toPassOn = append(toPassOn, toPass);
            break;
          case START_TRACK: break;
          case END_TRACK: break;
          case SHUTDOWN: break;
          default: throw new IllegalStateException("MessageType was non-exhaustive: " + type);
        }
      }
      //--Propagate Children
      Iterator<RecordHandlerTree> iter = children();
      while(iter.hasNext()){       //for each child...
        RecordHandlerTree child = iter.next();
        //(auxilliary records)
        for(Record r : toPassOn){  //for each record...
          child.process(r, MessageType.SIMPLE, newDepth, timestamp);
        }
        //(special record)
        switch(type){
          case START_TRACK:
          case END_TRACK:
          case SHUTDOWN:
            child.process(toPass, type, newDepth, timestamp);
            break;
          case SIMPLE: break;
          default: throw new IllegalStateException("MessageType was non-exhaustive: " + type);
        }
      }
    }

    private StringBuilder toStringHelper(StringBuilder b, int depth){
      for(int i=0; i<depth; i++){
        b.append("  ");
      }
      b.append(head == null ? "ROOT" : head).append("\n");
      for(RecordHandlerTree child : children){
        child.toStringHelper(b, depth+1);
      }
      return b;
    }
    @Override
    public String toString(){
      return toStringHelper(new StringBuilder(), 0).toString();
    }
  }

  /**
   * A log record, which encapsulates the information needed
   * to eventually display the enclosed message.
   */
  public static class Record {
 
    //(filled in at construction)
    public final Object content;
    private final Object[] channels;
    public final int depth;
    public final String callingClass;
    public final String callingMethod;
    public final long timesstamp;
    //(known at creation)
    public final long thread = Thread.currentThread().getId();
    //(state)
    private boolean channelsSorted = false;

    /**
     * Create a new Record, based on the content of the log, the channels, and
     * the depth
     * @param content An object (usually String) representing the log contents
     * @param channels A set of channels to publish this record to
     * @param depth The depth of the log message
     * @param stackTraceElement The stack trace element to extract the calling class and method from
     * @param timestamp The time this record was created
     */
    protected Record(Object content, Object[] channels, int depth, StackTraceElement stackTraceElement, long timestamp) {
      this(content, channels, depth, stackTraceElement.getClassName(), stackTraceElement.getMethodName(), timestamp);
    }

    /**
     * Create a new Record, based on the content of the log, the channels, and
     * the depth
     * @param content An object (usually String) representing the log contents
     * @param channels A set of channels to publish this record to
     * @param depth The depth of the log message
     * @param callingClass The class this record should claim to be called from
     * @param callingMethod The method this record should claim to be called from
     */
    protected Record(Object content, Object[] channels, int depth, String callingClass, String callingMethod, long timestamp) {
      this.content = content;
      this.channels = channels;
      this.depth = depth;
      this.callingClass = callingClass;
      this.callingMethod = callingMethod;
      this.timesstamp = timestamp;
    }

    /**
     * Sort the channels alphabetically, with the standard channels in front.
     * Note that the special FORCE tag is always first.
     */
    private void sort(){
      //(sort flags)
      if(!channelsSorted && channels.length > 1){
        Arrays.sort(channels, new Comparator<Object>() {
          public int compare(Object a, Object b) {
            if (a == FORCE) {
              return -1;
            } else if (b == FORCE) {
              return 1;
            } else if (a instanceof Flag && !(b instanceof Flag)) {
              return -1;
            } else if (b instanceof Flag && !(a instanceof Flag)) {
              return 1;
            } else {
              return a.toString().compareTo(b.toString());
            }
          }
        });
      }
    }

    /**
     * Returns whether this log message wants to be forced to be printed
     * @return true if the FORCE flag is set on this message
     */
    public boolean force(){ sort(); return this.channels.length > 0 && this.channels[0] == FORCE; }

    /**
     * Returns the channels for this record, in sorted order (special channels first, then alphabetical)
     * @return A sorted list of channels
     */
    public Object[] channels(){ sort(); return this.channels; }
    
    @Override
    public String toString() {
      return "Record [callingClass=" + callingClass + ", callingMethod=" + callingMethod + ", content=" + content + ", depth=" + depth
          + ", channels=" + Arrays.toString(channels()) + ", thread=" + thread + ", timesstamp=" + timesstamp + "]";
    }
  }

  /**
   * Default output handler which actually prints things to the real System.out
   */
  public static class ConsoleHandler extends OutputHandler {
    PrintStream stream;
    private ConsoleHandler(PrintStream stream){
      this.stream = stream;
    }
    /**
     * Print a string to the console, in STDOUT, without the trailing newline
     * @param line The string to be printed.
     */
    @Override
    public void print(String line) {
      stream.print(line); stream.flush();
    }
    public static ConsoleHandler out(){ return new ConsoleHandler(realSysOut); }
    public static ConsoleHandler err(){ return new ConsoleHandler(realSysErr); }
  }

  /**
   * Handler which prints to a specified file
   * TODO: make constructors for other ways of describing files (File, for example!)
   */
  public static class FileHandler extends OutputHandler {
    private PrintWriter printWriter;

    public FileHandler(String filename) {
      try {
        printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "utf-8")));
      } catch (IOException e) {
        RuntimeException re = new RuntimeException(e);
        throw re;
      }
    }

    /** {@inheritDoc} */
    @Override
    public void print(String line) {
      printWriter.write(line);
      printWriter.flush();
    }
  }

  /**
   * A utility class for Redwood intended for static import
   * (import static edu.stanford.nlp.util.logging.Redwood.Util.*;),
   * providing a wrapper for Redwood functions and adding utility shortcuts
   */
  public static class Util {
    private static Object[] revConcat(Object[] B, Object... A) {
      Object[] C = new Object[A.length+B.length];
      System.arraycopy(A, 0, C, 0, A.length);
      System.arraycopy(B, 0, C, A.length, B.length);
      return C;
    }

    public static final Flag ERR    = Flag.ERROR;
    public static final Flag WARN   = Flag.WARN;
    public static final Flag DBG    = Flag.DEBUG;
    public static final Flag FORCE  = Flag.FORCE;
    public static final Flag STDOUT = Flag.STDOUT;
    public static final Flag STDERR = Flag.STDERR;

    public static void prettyLog(Object obj){ PrettyLogger.log(obj); }
    public static void prettyLog(String description, Object obj){ PrettyLogger.log(description, obj); }
    public static void log(Object...objs){ Redwood.log(objs); }
    public static void logf(String format, Object... args){ Redwood.logf(format, args); }
    public static void warn(Object...objs){ Redwood.log(revConcat(objs, WARN)); }
    public static void debug(Object...objs){ Redwood.log(revConcat(objs, DBG)); }
    public static void err(Object...objs){ Redwood.log(revConcat(objs, ERR, FORCE)); }
    public static void println(Object o){ System.out.println(o); }

    /** Exits with a given status code */
    public static void exit(int exitCode){ Redwood.stop(); System.exit(exitCode); }
    /** Exits with status code 0, stopping Redwood first */
    public static void exit(){ exit(0); }
    /** Create a RuntimeException with arguments */
    public static RuntimeException fail(Object msg){
      if(msg instanceof String){
        return new RuntimeException((String) msg);
      } else if(msg instanceof RuntimeException){
        return (RuntimeException) msg;
      } else if(msg instanceof Throwable){
        return new RuntimeException((Throwable) msg);
      } else {
        throw new RuntimeException(msg.toString());
      }
    }
    /** Create a new RuntimeException with no arguments */
    public static RuntimeException fail(){ return new RuntimeException(); }

    public static void startTrack(Object...objs){ Redwood.startTrack(objs); }
    public static void start_track(Object...objs){ Redwood.startTrack(objs); }
    public static void forceTrack(String title){ Redwood.startTrack(FORCE,title); }
    public static void force_track(String title){ Redwood.startTrack(FORCE,title); }
    public static void endTrack(String check){ Redwood.endTrack(check); }
    public static void end_Track(String check){ Redwood.endTrack(check); }
    public static void endTrack(){ Redwood.endTrack(); }
    public static void end_track(){ Redwood.endTrack(); }

    public static void startThreads(String title){ Redwood.startThreads(title); }
    public static void finishThread(){ Redwood.finishThread(); }
    public static void endThreads(String check){ Redwood.endThreads(check); }
    
    /**
     * Wrap a collection of threads (Runnables) to be logged by Redwood.
     * Each thread will be logged as a continuous chunk; concurrent threads will be queued
     * and logged after the "main" thread has finished.
     * This means that every Runnable passed to this method will run as a chunk, though in possibly
     * random order.
     *
     * The handlers set up will operate on the output as if it were not concurrent -- timing will be preserved
     * but repeated records will be collapsed as per the order the logs are actually output, rather than based
     * on timestamp.
     * @param title A title for the group of threads being run
     * @param runnables The Runnables representing the tasks being run, without the Redwood overhead
     * @return A new collection of Runnables with the Redwood overhead taken care of
     */
    public static ArrayList<Runnable> thread(final String title, Iterable<Runnable> runnables){
      //--Preparation
      //(variables)
      final AtomicBoolean haveStarted = new AtomicBoolean(false);
      final ReentrantLock metaInfoLock = new ReentrantLock();
      int count = 0;
      //(count runnables)
      Iterator<Runnable> iterableRunnables = runnables.iterator();
      while (iterableRunnables.hasNext()) {
        count++;
        iterableRunnables.next();
      }
      final int numToRun = count;
      //--Create Runnables
      ArrayList<Runnable> rtn = new ArrayList<Runnable>(numToRun);
      final AtomicInteger runnablesSeen = new AtomicInteger(0);
      for(final Runnable runnable : runnables){
        rtn.add(new Runnable(){
          public void run(){
            try{
              //(signal start of threads)
              metaInfoLock.lock();
              if(!haveStarted.getAndSet(true)){
                startThreads(title); //<--this must be a blocking operation
              }
              metaInfoLock.unlock();
              //(run runnable)
              try{
                runnable.run();
              } catch (Exception e){
                e.printStackTrace();
                System.exit(1);
              } catch (AssertionError e) {
                e.printStackTrace();
                System.exit(1);
              }
              //(signal end of thread)
              finishThread();
              //(signal end of threads)
              int seen = runnablesSeen.getAndIncrement() + 1;
              if(seen == numToRun){
                endThreads(title);
              }
            } catch(Throwable t){
              t.printStackTrace();
              System.exit(1);
            }
          }
        });
      }
      //--Return
      return rtn;
    }
    public static ArrayList<Runnable> thread(Iterable<Runnable> runnables){ return thread("", runnables); }

    /**
     * Thread a collection of runnables, and run them via a java Executor.
     * This is a utility function; the Redwood-specific changes happen in the
     * thread() method.
     * @param title A title for the group of threads being run
     * @param runnables The Runnables representing the tasks being run, without the Redwood overhead --
     *                  particularly, these should NOT have been passed to thread() yet.
     * @param numThreads The number of threads to run on
     */
    public static void threadAndRun(String title, Iterable<Runnable> runnables, int numThreads){
      //(create executor)
      ExecutorService exec = Executors.newFixedThreadPool(numThreads);
      //(add threads)
      for(Runnable toRun : thread(title,runnables)){
        exec.submit(toRun);
      }
      //(await finish)
      exec.shutdown();
      try {
        exec.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
    public static void threadAndRun(String title, Iterable<Runnable> runnables){
      threadAndRun(title,runnables,Runtime.getRuntime().availableProcessors());
    }
    public static void threadAndRun(Iterable<Runnable> runnables, int numThreads){
      threadAndRun(""+numThreads, runnables, numThreads);
    }
    public static void threadAndRun(Iterable<Runnable> runnables){
      threadAndRun(runnables,Runtime.getRuntime().availableProcessors());
    }

    /**
     * Print (to console) a margin with the channels of a given log message.
     * Note that this does not affect File printing.
     * @param width The width of the margin to print (must be >2)
     */
    public static void printChannels(int width){
      for(LogRecordHandler handler : handlers){
        if(handler instanceof OutputHandler){
          ((OutputHandler) handler).leftMargin = width;
        }
      }
    }
    /**
     * Print (to console) a margin with the channels of a given log message.
     * Note that this does not affect File printing.
     */
    protected static void printChannels(){ printChannels(20); }
    /**
     * Do not print a margin with the channels corresponding to a log entry.
     */
    protected static void dontPrintChannels(){ printChannels(0); }

    public static Style BOLD      = Style.BOLD;
    public static Style DIM       = Style.DIM;
    public static Style ITALIC    = Style.ITALIC;
    public static Style UNDERLINE = Style.UNDERLINE;
    public static Style BLINK     = Style.BLINK;
    public static Style CROSS_OUT = Style.CROSS_OUT;

    public static Color BLACK   = Color.BLACK;
    public static Color RED     = Color.RED;
    public static Color GREEN   = Color.GREEN;
    public static Color YELLOW  = Color.YELLOW;
    public static Color BLUE    = Color.BLUE;
    public static Color MAGENTA = Color.MAGENTA;
    public static Color CYAN    = Color.CYAN;
    public static Color WHITE   = Color.WHITE;
  }

  /**
   * Represents a collection of channels. This lets you decouple selecting
   * channels from logging messages, similar to traditional logging systems.
   * {@link RedwoodChannels} have log and logf methods. Unlike Redwood.log and
   * Redwood.logf, these do not take channel names since those are specified
   * inside {@link RedwoodChannels}.
   * 
   * Required if you want to use logf with a channel. This follows the
   * Builder Pattern so Redwood.channels("chanA", "chanB").log("message") is equivalent to
   * Redwood.channels("chanA").channels("chanB").log("message")
   */
  public static class RedwoodChannels {
    private Object[] channelNames;

    public RedwoodChannels(Object... channelNames) {
      this.channelNames = channelNames;
    }

    /**
     * Creates a new RedwoodChannels object, concatenating the channels from
     * this RedwoodChannels with some additional channels.
     * @param moreChannelNames The channel names to also include
     * @return A RedwoodChannels representing the current and new channels.
     */
    public RedwoodChannels channels(Object... moreChannelNames) {
      //(copy array)
      Object[] result = new Object[channelNames.length + moreChannelNames.length];
      System.arraycopy(channelNames, 0, result, 0, channelNames.length);
      System.arraycopy(moreChannelNames, 0, result, channelNames.length, moreChannelNames.length);
      //(create channels)
      return new RedwoodChannels(result);
    }
    
    /**
     * Log a message to the channels specified in this RedwoodChannels object.
     * @param obj The object to log
     */
    public void log(Object obj) {
      Object[] newArgs = new Object[channelNames.length+1];
      System.arraycopy(channelNames,0,newArgs,0,channelNames.length);
      newArgs[channelNames.length] = obj;
      Redwood.log(newArgs);
    }

    /**
     * Log a printf-style formatted message to the channels specified in this RedwoodChannels object.
     * @param format The format string for the printf function
     * @param args The arguments to the printf function
     */
    public void logf(String format, Object... args) {
      log(new Formatter().format(format, args));
    }
    
    /**
     * PrettyLog an object using these channels.  A default description will be created
     * based on the type of obj.
     */
    public void prettyLog(Object obj) {
      PrettyLogger.log(this, obj);
    }

    /**
     * PrettyLog an object with a description using these channels.
     */
    public void prettyLog(String description, Object obj) {
      PrettyLogger.log(this, description, obj);
    }
    
    /**
     * Hides all of these channels.
     */
    public void hide() {
      Redwood.hideChannels(channelNames);
    }
    

    /**
     * Shows all of these channels.
     */
    public void show() {
      Redwood.showChannels(channelNames);
    }
  }
  
   /**
   * Standard channels; enum for the sake of efficiency
   */
  protected static enum Flag {
    ERROR,
    WARN,
    DEBUG,
    STDOUT,
    STDERR,
    FORCE
  }






  /**
   * Various informal tests of Redwood functionality
   * @param args Unused
   */
  public static void main(String[] args){

    // -- STRESS TEST THREADS --
    LinkedList<Runnable> tasks = new LinkedList<Runnable>();
    for(int i=0; i<1000; i++){
      final int fI = i;
      tasks.add(new Runnable(){
        public void run(){
          startTrack("Runnable " + fI);
          log(Thread.currentThread().getId());
          log("message " + fI + ".1");
          log("message " + fI + ".2");
          log("message " + fI + ".3");
          log(FORCE,"message " + fI + ".4");
          log("message " + fI + ".5");
          forceTrack("Runnable " + fI + ".1");
          endTrack("Runnable " + fI + ".1");
          forceTrack("Runnable " + fI + ".2");
          log("a message");
          endTrack("Runnable " + fI + ".2");
          forceTrack("Runnable " + fI + ".3");
          log("a message");
          log(FORCE,"A forced message");
          endTrack("Runnable " + fI + ".3");
          endTrack("Runnable " + fI);
        }
      });
    }
    startTrack("Wrapper");
    for(int i=0; i<100; i++){
      Util.threadAndRun(tasks, 100);
    }
    endTrack("Wrapper");
    System.exit(1);
    
    
    forceTrack("Track 1");
    log("tag", ERR, "hello world");
    startTrack("Hidden");
    startTrack("Subhidden");
    endTrack("Subhidden");
    endTrack("Hidden");
    startTrack(FORCE, "Shown");
    startTrack(FORCE,"Subshown");
    endTrack("Subshown");
    endTrack("Shown");
    log("^shown should have appeared above");
    startTrack("Track 1.1");
    log(WARN, "some", "something in 1.1");
    log("some",ERR,"something in 1.1");
    log(FORCE,"some",WARN,"something in 1.1");
    log(WARN,FORCE,"some","something in 1.1");
    logf("format string %s then int %d", "hello", 7);
    endTrack("Track 1.1");
    startTrack();
    log("In an anonymous track");
    endTrack();
    endTrack("Track 1");
    log("outside of a track");
    log("these","channels","should","be","in",DBG,"alphabetical","order", "a log item with lots of channels");
    log("these","channels","should","be","in",DBG,"alphabetical","order", "a log item\nthat spans\nmultiple\nlines");
    log(DBG,"a last log item");
    log(ERR,null);

    //--Repeated Records
    RedwoodConfiguration.current().collapseExact().apply();
    //(simple case)
    forceTrack("Strict Equality");
    for(int i=0; i<100; i++){ log("this is a message"); }
    endTrack("Strict Equality");
    //(in-track change)
    forceTrack("Change");
    for(int i=0; i<10; i++){ log("this is a message"); }
    for(int i=0; i<10; i++){ log("this is a another message"); }
    for(int i=0; i<10; i++){ log("this is a third message"); }
    for(int i=0; i<5; i++){ log("this is a fourth message"); }
    log(FORCE,"this is a fourth message");
    for(int i=0; i<5; i++){ log("this is a fourth message"); }
    log("^middle 'fourth message' was forced");
    endTrack("Change");
    //(suppress tracks)
    forceTrack("Repeated Tracks");
    for(int i=0; i<100; i++){ startTrack("Track type 1"); log("a message"); endTrack("Track type 1"); }
    for(int i=0; i<100; i++){ startTrack("Track type 2"); log("a message"); endTrack("Track type 2"); }
    for(int i=0; i<100; i++){ startTrack("Track type 3"); log("a message"); endTrack("Track type 3"); }
    startTrack("Track type 3"); startTrack("nested"); log(FORCE,"this should show up"); endTrack("nested"); endTrack("Track type 3");
    for(int i=0; i<5; i++){ startTrack("Track type 3"); log(FORCE,"this should show up"); endTrack("Track type 3"); }
    log(WARN,"The log message 'this should show up' should show up 6 (5+1) times above");
    endTrack("Repeated Tracks");
    //(tracks with invisible things)
    Redwood.hideOnlyChannels(DBG);
    forceTrack("Hidden Subtracks");
    for(int i=0; i<100; i++){
      startTrack("Only has debug messages");
      log(DBG,"You shouldn't see me");
      endTrack("Only has debug messages");
    }
    log("You shouldn't see any other messages or 'skipped tracks' here");
    endTrack("Hidden Subtracks");
    //(fuzzy repeats)
    RedwoodConfiguration.standard().apply();
    RedwoodConfiguration.current().collapseApproximate().apply();
    forceTrack("Fuzzy Equality");
    for(int i=0; i<100; i++){ log("iter " + i + " ended with value " + (-34587292534.0+Math.sqrt(i)*3000000000.0)); }
    endTrack("Fuzzy Equality");
    forceTrack("Fuzzy Equality (timing)");
    for(int i=0; i<100; i++){
      log("iter " + i + " ended with value " + (-34587292534.0+Math.sqrt(i)*3000000000.0));
      try {
        Thread.sleep(50);
      } catch (InterruptedException e) { }
    }
    endTrack("Fuzzy Equality (timing)");

    //--Util Helper
    Util.log("hello world");
    Util.log(DBG, "hello world");
    Util.debug("hello world");
    Util.debug("atag", "hello world");

    //--Show Name at Track Finish
    Redwood.getHandler(ConsoleHandler.class).minLineCountForTrackNameReminder = 5;
    startTrack("Long Track");
    for(int i=0; i<10; i++){ log(FORCE,"contents of long track"); }
    endTrack("Long TracK");
    startTrack("Long Track");
    startTrack("But really this is the long one");
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) { }
    for(int i=0; i<10; i++){ log(FORCE,"contents of long track"); }
    endTrack("But really this is the long one");
    endTrack("Long TracK");
    Redwood.getHandler(ConsoleHandler.class).minLineCountForTrackNameReminder = 50;

    //--Multithreading
    ExecutorService exec = Executors.newFixedThreadPool(10);
    startThreads("name");
    for(int i=0; i<50; i++){
      final int theI = i;
      exec.execute(new Runnable(){
        public void run() {
          startTrack("Thread " + theI + " (" + Thread.currentThread().getId() + ")");
          for(int time=0; time<5; time++){
            log("tick " + time + " from " + theI + " (" + Thread.currentThread().getId() + ")");
            try {
              Thread.sleep(50);
            } catch (Exception e) {}
          }
          endTrack("Thread " + theI + " (" + Thread.currentThread().getId() + ")");
          finishThread();
        }
      });

    }
    exec.shutdown();
    try {
      exec.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
    } catch (InterruptedException e) {}
    endThreads("name");

    //--System Streams
    Redwood.captureSystemStreams(true, true);
    System.out.println("Hello World");
    System.err.println("This is an error!");

    //--Neat Exit
    RedwoodConfiguration.standard().collapseExact().apply();
    //(on close)
    for(int i=0; i<100; i++){
//      startTrack();
      log("stuff!");
//      endTrack();
    }
    Util.exit(0);
    //(on exception)
    System.out.println("I'm going to exception soon (on purpose)");
    RedwoodConfiguration.current().neatExit().apply();
    startTrack("I should close");
    log(FORCE,"so I'm nonempty...");
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) { }
		throw new IllegalArgumentException();
  }
}
