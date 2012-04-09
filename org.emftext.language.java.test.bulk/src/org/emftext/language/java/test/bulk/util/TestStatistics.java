/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.java.test.bulk.util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.List;

import javancss.Javancss;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.emftext.language.java.test.bulk.GiganticTest;

/**
 * A utility class to extract statistical information from the test
 * sources (e.g., the total number of lines of code).
 */
public class TestStatistics extends GiganticTest {
	
	private long locs = 0;
	private long ncss = 0;
	private long count = 0;

	public static void main(String[] args) throws IOException, CoreException {
		new TestStatistics().doCount();
	}

	private void doCount() throws IOException, CoreException {
		List<String> inputZips = getInputZips("");
		for (String inputZip : inputZips) {
			Collection<URI> streams = getURIsForZipFileEntries(inputZip);
			for (URI next : streams) {
				handle(next);
				count++;
				long mod = count % 100;
				if (mod == 0) {
					System.out.println(count + " -> (" + locs + "," + ncss + ")");
				}
			}
		}
		System.out.println("\nTestStatistics.main() LOCS = " + locs);
		System.out.println("\nTestStatistics.main() NCSS = " + ncss);
	}

	@SuppressWarnings("deprecation")
	private void handle(URI next) throws IOException {
		InputStream is = new ExtensibleURIConverterImpl().createInputStream(next);
		InputStreamReader inr = new InputStreamReader(new BufferedInputStream(is, 1024 * 1024));
		int read = -1;
		StringBuilder content = new StringBuilder();
		while ((read = inr.read()) >= 0) {
			content.append((char) read);
		}
		is.close();
		
		Javancss jn = new Javancss(new java.io.StringBufferInputStream(content.toString()));
		ncss += jn.getNcss();
		locs += jn.getLOC();
		Throwable lastError = jn.getLastError();
		if (lastError != null) {
			System.out.println("Error parsing " + next);
		}
/*
		is = new BufferedInputStream(new ExtensibleURIConverterImpl().createInputStream(next), 1024*1024);
		while (is.read() >= 0) {
			bytes++;
		}
		is.close();*/
	}
}
