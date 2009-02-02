/**
 * 
 */
package org.emftext.language.java.test.util;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

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
			assert threads.size() <= maxActiveThreads;
			if (threads.size() >= maxActiveThreads) {
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
					} catch (Exception sbue) {
						// do nothing, just end the test
					}
					threads.remove(Thread.currentThread());
				}
			};
			final Thread workerThread = new Thread(runnable, "Worker Thread");
			threads.add(workerThread);
			
			Thread timeoutThread = new Thread(new Runnable() {

				public void run() {
					try {
						workerThread.join(timeout);
						boolean wasStillAlive = workerThread.isAlive();
						workerThread.interrupt();
						while (workerThread.isAlive()) {
							Thread.sleep(100);
						}
						if (wasStillAlive) {
							result.addError(each, new InterruptedException("Test was interrupted by timeout."));
						}
					}
					catch (Exception e1) {
					}
					threads.remove(workerThread);
				}
			}, "Timeout Thread");
			
			workerThread.start();
			timeoutThread.start();
		}
		// wait for last thread to end
		while (threads.size() > 0) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}