/**
 * 
 */
package org.emftext.language.java.test.util;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.junit.runner.notification.StoppedByUserException;

import junit.framework.Test;
import junit.framework.TestResult;
import junit.framework.TestSuite;

public final class ThreadedTestSuite extends TestSuite {
	
	private List<Thread> threads = new ArrayList<Thread>();
	private final int timeout;
	private final int maxActiveThreads;
	
	public ThreadedTestSuite(String name, int timeout, int maxActiveThreads) {
		super(name);
		this.timeout = timeout;
		this.maxActiveThreads = maxActiveThreads;
	}
	
	public void run(final TestResult result) {
		Enumeration<Test> tests = tests();
		
		while (tests.hasMoreElements()) {
			if (threads.size() > maxActiveThreads) {
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				continue;
			}
			final Test each = tests.nextElement(); 
			if (result.shouldStop()) {
	  			break;
			}
			Runnable runnable = new Runnable() {
				public void run() {
					try {
						runTest(each, result);
					} catch (StoppedByUserException sbue) {
						// do nothing, just end the test
					}
					threads.remove(Thread.currentThread());
				}
			};
			final Thread workerThread = new Thread(runnable);
			threads.add(workerThread);
			
			Thread timeoutThread = new Thread(new Runnable() {

				public void run() {
					try {
						Thread currentThread = Thread.currentThread();
						currentThread.join(timeout);
						threads.remove(workerThread);
						if (workerThread.isAlive()) {
							result.addError(each, new InterruptedException("Test was interrupted by timeout."));
						}
					}
					catch (InterruptedException e1) {
						threads.remove(workerThread);
						// TODO Auto-generated catch block
						//e1.printStackTrace();
					}
				}
				
			});
			
			
			workerThread.start();
			timeoutThread.start();
		}
	}
}