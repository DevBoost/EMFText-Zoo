package org.emftext.language.java.test.bulk;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;

public class TestStatistics extends GiganticTest {
	
	private long lines = 0;
	private long bytes = 0;
	private long count = 0;

	public static void main(String[] args) throws IOException, CoreException {
		new TestStatistics().doCount();
	}

	private void doCount() throws IOException, CoreException {
		List<String> inputZips = getInputZips();
		for (String inputZip : inputZips) {
			Collection<URI> streams = getURIsForZipFileEntries(inputZip);
			for (URI next : streams) {
				handle(next);
				count++;
				long mod = count % 100;
				if (mod == 0) {
					System.out.println(count);
				}
			}
		}
		System.out.println("\nTestStatistics.main() lines = " + lines);
		System.out.println("TestStatistics.main() bytes = " + bytes);
	}

	private void handle(URI next) throws IOException {
		InputStream is = new ExtensibleURIConverterImpl().createInputStream(next);
		// TODO Auto-generated method stub
		LineNumberReader lnr = new LineNumberReader(new InputStreamReader(new BufferedInputStream(is, 1024 * 1024)));
		while (lnr.readLine() != null) {
			lines++;
		}
		is.close();
/*
		is = new BufferedInputStream(new ExtensibleURIConverterImpl().createInputStream(next), 1024*1024);
		while (is.read() >= 0) {
			bytes++;
		}
		is.close();*/
	}
}
