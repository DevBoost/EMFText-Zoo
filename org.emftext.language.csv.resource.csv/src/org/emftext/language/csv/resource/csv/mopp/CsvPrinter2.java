/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.csv.resource.csv.mopp;

import java.util.Iterator;
import java.util.Map;

import org.emftext.language.csv.CSVDocument;
import org.emftext.language.csv.CsvPackage;
import org.emftext.language.csv.Row;
import org.emftext.language.csv.Value;
import org.emftext.language.csv.resource.csv.ICsvTokenResolver;
import org.emftext.language.csv.resource.csv.analysis.CsvQUOTED_34_34_929292TokenResolver;
import org.emftext.language.csv.resource.csv.analysis.CsvUNQUOTED_VALUETokenResolver;

public class CsvPrinter2 implements org.emftext.language.csv.resource.csv.ICsvTextPrinter {

	public final static String NEW_LINE = java.lang.System.getProperties().getProperty("line.separator");
	
	private java.io.OutputStream outputStream;

	public CsvPrinter2(java.io.OutputStream outputStream, org.emftext.language.csv.resource.csv.ICsvTextResource resource) {
		super();
		this.outputStream = outputStream;
	}
	
	public void print(org.eclipse.emf.ecore.EObject element) throws java.io.IOException {
		if (element instanceof CSVDocument) {
			ICsvTokenResolver tokenResolverQuoted   = new CsvQUOTED_34_34_929292TokenResolver();
			ICsvTokenResolver tokenResolverUnquoted = new CsvUNQUOTED_VALUETokenResolver();
			CSVDocument csvDoc = (CSVDocument) element;
			java.io.PrintWriter writer = new java.io.PrintWriter(new java.io.BufferedOutputStream(outputStream));
			for (Row row : csvDoc.getRows()) {
				for (Iterator<Value> i = row.getValues().iterator(); i.hasNext();) {
					Value value = i.next();
					String resolvedString = null;
					if (value.getText().contains(";") || value.getText().contains(",")) {
						resolvedString = tokenResolverQuoted.deResolve(
								value.getText(), CsvPackage.Literals.VALUE__TEXT, value);
					} else {
						resolvedString = tokenResolverUnquoted.deResolve(
								value.getText(), CsvPackage.Literals.VALUE__TEXT, value);
					}
					writer.append(resolvedString);
					if (i.hasNext()) {
						writer.append(";");
					}
				}
				writer.append(NEW_LINE);
			}
			writer.flush();
		}	
	}

	@Override
	public void setOptions(Map<?, ?> options) { }
}
