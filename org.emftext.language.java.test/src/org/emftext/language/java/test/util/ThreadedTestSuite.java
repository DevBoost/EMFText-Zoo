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
			if (threads.size() > maxActiveThreads) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				continue;
			}
			final Test each = tests.nextElement(); 
			if (result.shouldStop()) {
	  			break;
			}
			Thread thread = new Thread(new Runnable() {

				public void run() {
					runTest(each, result);
				}
				
			});
			threads.add(thread);
			thread.start();
			try {
				thread.join(timeout);
				threads.remove(thread);
				if (thread.isAlive()) {
					result.addError(each, new InterruptedException("Test was interrupted by timeout."));
				}
			}
			catch (InterruptedException e1) {
				threads.remove(thread);
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}
		}
	}
}