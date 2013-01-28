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

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Locale;

/**
 * A PrintStream that writes to Redwood logs.
 * The primary use of this class is to override System.out and System.err.
 *
 * @author Gabor Angeli (angeli at cs.stanford)
 */
public class RedwoodPrintStream extends PrintStream {
  private final Redwood.Flag tag;
	private final PrintStream realStream;
  private StringBuilder buffer = new StringBuilder();
  private boolean checkForThrowable = false;

  public RedwoodPrintStream(Redwood.Flag tag, PrintStream realStream) {
    super(new OutputStream() {
      @Override
      public void write(int i) throws IOException {}
    });
    this.tag = tag;
		this.realStream = realStream;
  }

  private void log(Object message){
    if(buffer.length() > 0){
      logB(message);
      logB("\n");
    } else {
      if(tag != null){ Redwood.log(tag, message); } else { Redwood.log(message); }
    }
  }

  private void logf(String format, Object[] args){
    if(tag != null){
      Redwood.channels(tag).logf(format, args);
    } else {
      Redwood.logf(format, args);
    }
  }

  private void logB(Object message){
    char[] str = message.toString().toCharArray();
    for(char c : str){
      if(c == '\n'){
        String msg = buffer.toString();
        if(tag != null){ Redwood.log(tag, msg); } else { Redwood.log(msg); }
        buffer = new StringBuilder();
      } else {
        buffer.append(""+c);
      }
    }

  }


  @Override public void flush() { realStream.flush(); }
  @Override public void close() { }
  @Override public boolean checkError(){ return false; }
  @Override protected void setError() { }
  protected void clearError() { }

  @Override public void write(byte[] bytes) throws IOException { }
  @Override public void write(int i) { }
  @Override public void write(byte[] bytes, int i, int i1) { }

  @Override public void print(boolean b) { logB(b); }
  @Override public void print(char c) { logB(c); }
  @Override public void print(int i) { logB(i); }
  @Override public void print(long l) { logB(l); }
  @Override public void print(float f) { logB(f); }
  @Override public void print(double d) { logB(d); }
  @Override public void print(char[] chars) { logB(new String(chars)); }
  @Override public void print(String s) { logB(s); }
  @Override public void print(Object o) { logB(o); }

  @Override public void println(boolean b) { log(b); }
  @Override public void println(char c) { log(c); }
  @Override public void println(int i) { log(i); }
  @Override public void println(long l) { log(l); }
  @Override public void println(float f) { log(f); }
  @Override public void println(double d) { log(d); }
  @Override public void println(char[] chars) { log(new String(chars)); }
  @Override public void println(String s) {
    if(checkForThrowable){
      //(check if from throwable)
      boolean fromThrowable = false;
      for(StackTraceElement e : Thread.currentThread().getStackTrace()) {
		  	if(e.getClassName().equals(Throwable.class.getName())){
          fromThrowable = true;
        }
      }
      //(handle message appropriately)
      if(fromThrowable){
        realStream.println(s);
      }else{
        log(s);
        checkForThrowable = false;
      }
    } else {
      log(s);
    }
  }
  @Override public void println(Object o) {
    if(o instanceof Throwable){
      realStream.println(o);
      flush();
      checkForThrowable = true;
    } else {
      log(o);
    }
	}
  @Override public void println() { log(""); }

  @Override public PrintStream printf(String s, Object... objects) { logf(s,objects); return this; }
  @Override public PrintStream printf(Locale locale, String s, Object... objects) { logf(s,objects); return this; }
  @Override public PrintStream format(String s, Object... objects) { logf(s,objects); return this; }
  @Override public PrintStream format(Locale locale, String s, Object... objects) { logf(s,objects); return this; }

  @Override public PrintStream append(CharSequence charSequence) { logB(charSequence); return this; }
  @Override public PrintStream append(CharSequence charSequence, int i, int i1) { logB(charSequence.subSequence(i,i1)); return this; }
  @Override public PrintStream append(char c) { logB(c); return this; }
}
