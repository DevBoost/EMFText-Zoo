/*******************************************************************************
 * Copyright (c) 2006-2011
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/

package org.emftext.language.bibtex.resource.bib.mopp;

public class BibPrinter implements org.emftext.language.bibtex.resource.bib.IBibTextPrinter {
	
	protected org.emftext.language.bibtex.resource.bib.IBibTokenResolverFactory tokenResolverFactory = new org.emftext.language.bibtex.resource.bib.mopp.BibTokenResolverFactory();
	
	protected java.io.OutputStream outputStream;
	
	/**
	 * Holds the resource that is associated with this printer. This may be null if
	 * the printer is used stand alone.
	 */
	private org.emftext.language.bibtex.resource.bib.IBibTextResource resource;
	
	private java.util.Map<?, ?> options;
	
	public BibPrinter(java.io.OutputStream outputStream, org.emftext.language.bibtex.resource.bib.IBibTextResource resource) {
		super();
		this.outputStream = outputStream;
		this.resource = resource;
	}
	
	protected int matchCount(java.util.Map<String, Integer> featureCounter, java.util.Collection<String> needed) {
		int pos = 0;
		int neg = 0;
		
		for (String featureName : featureCounter.keySet()) {
			if (needed.contains(featureName)) {
				int value = featureCounter.get(featureName);
				if (value == 0) {
					neg += 1;
				} else {
					pos += 1;
				}
			}
		}
		return neg > 0 ? -neg : pos;
	}
	
	protected void doPrint(org.eclipse.emf.ecore.EObject element, java.io.PrintWriter out, String globaltab) {
		if (element == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write.");
		}
		if (out == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write on.");
		}
		
		if (element instanceof org.emftext.language.bibtex.Bibliography) {
			print_org_emftext_language_bibtex_Bibliography((org.emftext.language.bibtex.Bibliography) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.bibtex.BibtexKeyField) {
			print_org_emftext_language_bibtex_BibtexKeyField((org.emftext.language.bibtex.BibtexKeyField) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.bibtex.AuthorField) {
			print_org_emftext_language_bibtex_AuthorField((org.emftext.language.bibtex.AuthorField) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.bibtex.Author) {
			print_org_emftext_language_bibtex_Author((org.emftext.language.bibtex.Author) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.bibtex.EditorField) {
			print_org_emftext_language_bibtex_EditorField((org.emftext.language.bibtex.EditorField) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.bibtex.Editor) {
			print_org_emftext_language_bibtex_Editor((org.emftext.language.bibtex.Editor) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.bibtex.KeywordField) {
			print_org_emftext_language_bibtex_KeywordField((org.emftext.language.bibtex.KeywordField) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.bibtex.Keyword) {
			print_org_emftext_language_bibtex_Keyword((org.emftext.language.bibtex.Keyword) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.bibtex.TitleField) {
			print_org_emftext_language_bibtex_TitleField((org.emftext.language.bibtex.TitleField) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.bibtex.BookTitleField) {
			print_org_emftext_language_bibtex_BookTitleField((org.emftext.language.bibtex.BookTitleField) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.bibtex.SeriesField) {
			print_org_emftext_language_bibtex_SeriesField((org.emftext.language.bibtex.SeriesField) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.bibtex.AddressField) {
			print_org_emftext_language_bibtex_AddressField((org.emftext.language.bibtex.AddressField) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.bibtex.MonthField) {
			print_org_emftext_language_bibtex_MonthField((org.emftext.language.bibtex.MonthField) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.bibtex.OrganizationField) {
			print_org_emftext_language_bibtex_OrganizationField((org.emftext.language.bibtex.OrganizationField) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.bibtex.PublisherField) {
			print_org_emftext_language_bibtex_PublisherField((org.emftext.language.bibtex.PublisherField) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.bibtex.JournalField) {
			print_org_emftext_language_bibtex_JournalField((org.emftext.language.bibtex.JournalField) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.bibtex.NoteField) {
			print_org_emftext_language_bibtex_NoteField((org.emftext.language.bibtex.NoteField) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.bibtex.EidField) {
			print_org_emftext_language_bibtex_EidField((org.emftext.language.bibtex.EidField) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.bibtex.AbstractField) {
			print_org_emftext_language_bibtex_AbstractField((org.emftext.language.bibtex.AbstractField) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.bibtex.ReviewField) {
			print_org_emftext_language_bibtex_ReviewField((org.emftext.language.bibtex.ReviewField) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.bibtex.UrlField) {
			print_org_emftext_language_bibtex_UrlField((org.emftext.language.bibtex.UrlField) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.bibtex.YearField) {
			print_org_emftext_language_bibtex_YearField((org.emftext.language.bibtex.YearField) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.bibtex.VolumeField) {
			print_org_emftext_language_bibtex_VolumeField((org.emftext.language.bibtex.VolumeField) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.bibtex.PartField) {
			print_org_emftext_language_bibtex_PartField((org.emftext.language.bibtex.PartField) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.bibtex.NumberField) {
			print_org_emftext_language_bibtex_NumberField((org.emftext.language.bibtex.NumberField) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.bibtex.PageField) {
			print_org_emftext_language_bibtex_PageField((org.emftext.language.bibtex.PageField) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.bibtex.Page) {
			print_org_emftext_language_bibtex_Page((org.emftext.language.bibtex.Page) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.bibtex.InProceedingsEntry) {
			print_org_emftext_language_bibtex_InProceedingsEntry((org.emftext.language.bibtex.InProceedingsEntry) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.bibtex.ArticleEntry) {
			print_org_emftext_language_bibtex_ArticleEntry((org.emftext.language.bibtex.ArticleEntry) element, globaltab, out);
			return;
		}
		
		addWarningToResource("The printer can not handle " + element.eClass().getName() + " elements", element);
	}
	
	protected org.emftext.language.bibtex.resource.bib.mopp.BibReferenceResolverSwitch getReferenceResolverSwitch() {
		return (org.emftext.language.bibtex.resource.bib.mopp.BibReferenceResolverSwitch) new org.emftext.language.bibtex.resource.bib.mopp.BibMetaInformation().getReferenceResolverSwitch();
	}
	
	protected void addWarningToResource(final String errorMessage, org.eclipse.emf.ecore.EObject cause) {
		org.emftext.language.bibtex.resource.bib.IBibTextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the printer is used stand alone
			return;
		}
		resource.addProblem(new org.emftext.language.bibtex.resource.bib.mopp.BibProblem(errorMessage, org.emftext.language.bibtex.resource.bib.BibEProblemType.PRINT_PROBLEM, org.emftext.language.bibtex.resource.bib.BibEProblemSeverity.WARNING), cause);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		this.options = options;
	}
	
	public java.util.Map<?,?> getOptions() {
		return options;
	}
	
	public org.emftext.language.bibtex.resource.bib.IBibTextResource getResource() {
		return resource;
	}
	
	/**
	 * Calls {@link #doPrint(EObject, PrintWriter, String)} and writes the result to
	 * the underlying output stream.
	 */
	public void print(org.eclipse.emf.ecore.EObject element) {
		java.io.PrintWriter out = new java.io.PrintWriter(new java.io.BufferedOutputStream(outputStream));
		doPrint(element, out, "");
		out.flush();
		out.close();
	}
	
	public void print_org_emftext_language_bibtex_Bibliography(org.emftext.language.bibtex.Bibliography element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.BIBLIOGRAPHY__ENTRIES));
		printCountingMap.put("entries", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("entries");
		if (count > 0) {
			java.util.List<?> list = (java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.BIBLIOGRAPHY__ENTRIES));
			int index  = list.size() - count;
			if (index < 0) {
				index = 0;
			}
			java.util.ListIterator<?> it  = list.listIterator(index);
			while (it.hasNext()) {
				Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("entries", 0);
		}
	}
	
	
	public void print_org_emftext_language_bibtex_BibtexKeyField(org.emftext.language.bibtex.BibtexKeyField element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.BIBTEX_KEY_FIELD__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_emftext_language_bibtex_BibtexKeyField_0(element, localtab, out, printCountingMap);
	}
	
	public void print_org_emftext_language_bibtex_BibtexKeyField_0(org.emftext.language.bibtex.BibtexKeyField element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, java.util.Arrays.asList(		"value"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"value"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
				count = printCountingMap.get("value");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.BIBTEX_KEY_FIELD__VALUE));
					if (o != null) {
						org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.BIBTEX_KEY_FIELD__VALUE), element));
						out.print(" ");
					}
					printCountingMap.put("value", count - 1);
				}
			}
			break;
			default:			// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
			count = printCountingMap.get("value");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.BIBTEX_KEY_FIELD__VALUE));
				if (o != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("ID");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.BIBTEX_KEY_FIELD__VALUE), element));
					out.print(" ");
				}
				printCountingMap.put("value", count - 1);
			}
		}
	}
	
	
	public void print_org_emftext_language_bibtex_AuthorField(org.emftext.language.bibtex.AuthorField element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.AUTHOR_FIELD__AUTHORS));
		printCountingMap.put("authors", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CsString)
		out.print("author");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("=");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_emftext_language_bibtex_AuthorField_0(element, localtab, out, printCountingMap);
	}
	
	public void print_org_emftext_language_bibtex_AuthorField_0(org.emftext.language.bibtex.AuthorField element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, java.util.Arrays.asList(		"authors"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"authors"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CompoundDefinition)
				print_org_emftext_language_bibtex_AuthorField_0_1(element, localtab, out, printCountingMap);
			}
			break;
			default:			// DEFINITION PART BEGINS (CompoundDefinition)
			print_org_emftext_language_bibtex_AuthorField_0_0(element, localtab, out, printCountingMap);
		}
	}
	
	public void print_org_emftext_language_bibtex_AuthorField_0_0(org.emftext.language.bibtex.AuthorField element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("\"");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("authors");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.AUTHOR_FIELD__AUTHORS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("authors", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_org_emftext_language_bibtex_AuthorField_0_0_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("\"");
		out.print(" ");
	}
	
	public void print_org_emftext_language_bibtex_AuthorField_0_0_0(org.emftext.language.bibtex.AuthorField element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("and");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("authors");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.AUTHOR_FIELD__AUTHORS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("authors", count - 1);
		}
	}
	
	public void print_org_emftext_language_bibtex_AuthorField_0_1(org.emftext.language.bibtex.AuthorField element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("authors");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.AUTHOR_FIELD__AUTHORS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("authors", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_org_emftext_language_bibtex_AuthorField_0_1_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	public void print_org_emftext_language_bibtex_AuthorField_0_1_0(org.emftext.language.bibtex.AuthorField element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("and");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("authors");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.AUTHOR_FIELD__AUTHORS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("authors", count - 1);
		}
	}
	
	
	public void print_org_emftext_language_bibtex_Author(org.emftext.language.bibtex.Author element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.AUTHOR__FIRST_NAME));
		printCountingMap.put("firstName", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.AUTHOR__SECOND_NAME));
		printCountingMap.put("secondName", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.AUTHOR__LAST_NAME));
		printCountingMap.put("lastName", temp == null ? 0 : 1);
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_emftext_language_bibtex_Author_0(element, localtab, out, printCountingMap);
	}
	
	public void print_org_emftext_language_bibtex_Author_0(org.emftext.language.bibtex.Author element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, java.util.Arrays.asList(		"firstName"		,
		"lastName"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"lastName"		,
		"firstName"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CompoundDefinition)
				print_org_emftext_language_bibtex_Author_0_1(element, localtab, out, printCountingMap);
			}
			break;
			default:			// DEFINITION PART BEGINS (CompoundDefinition)
			print_org_emftext_language_bibtex_Author_0_0(element, localtab, out, printCountingMap);
		}
	}
	
	public void print_org_emftext_language_bibtex_Author_0_0(org.emftext.language.bibtex.Author element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("firstName");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.AUTHOR__FIRST_NAME));
			if (o != null) {
				org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.AUTHOR__FIRST_NAME), element));
				out.print(" ");
			}
			printCountingMap.put("firstName", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_org_emftext_language_bibtex_Author_0_0_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("lastName");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.AUTHOR__LAST_NAME));
			if (o != null) {
				org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.AUTHOR__LAST_NAME), element));
				out.print(" ");
			}
			printCountingMap.put("lastName", count - 1);
		}
	}
	
	public void print_org_emftext_language_bibtex_Author_0_0_0(org.emftext.language.bibtex.Author element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("secondName");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.AUTHOR__SECOND_NAME));
			if (o != null) {
				org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.AUTHOR__SECOND_NAME), element));
				out.print(" ");
			}
			printCountingMap.put("secondName", count - 1);
		}
	}
	
	public void print_org_emftext_language_bibtex_Author_0_1(org.emftext.language.bibtex.Author element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_emftext_language_bibtex_Author_0_1_0(element, localtab, out, printCountingMap);
	}
	
	public void print_org_emftext_language_bibtex_Author_0_1_0(org.emftext.language.bibtex.Author element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("lastName");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.AUTHOR__LAST_NAME));
			if (o != null) {
				org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.AUTHOR__LAST_NAME), element));
				out.print(" ");
			}
			printCountingMap.put("lastName", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("firstName");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.AUTHOR__FIRST_NAME));
			if (o != null) {
				org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.AUTHOR__FIRST_NAME), element));
				out.print(" ");
			}
			printCountingMap.put("firstName", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_org_emftext_language_bibtex_Author_0_1_0_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	
	public void print_org_emftext_language_bibtex_Author_0_1_0_0(org.emftext.language.bibtex.Author element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("secondName");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.AUTHOR__SECOND_NAME));
			if (o != null) {
				org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.AUTHOR__SECOND_NAME), element));
				out.print(" ");
			}
			printCountingMap.put("secondName", count - 1);
		}
	}
	
	
	public void print_org_emftext_language_bibtex_EditorField(org.emftext.language.bibtex.EditorField element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.EDITOR_FIELD__EDITORS));
		printCountingMap.put("editors", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CsString)
		out.print("editor");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("=");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_emftext_language_bibtex_EditorField_0(element, localtab, out, printCountingMap);
	}
	
	public void print_org_emftext_language_bibtex_EditorField_0(org.emftext.language.bibtex.EditorField element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, java.util.Arrays.asList(		"editors"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"editors"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CompoundDefinition)
				print_org_emftext_language_bibtex_EditorField_0_1(element, localtab, out, printCountingMap);
			}
			break;
			default:			// DEFINITION PART BEGINS (CompoundDefinition)
			print_org_emftext_language_bibtex_EditorField_0_0(element, localtab, out, printCountingMap);
		}
	}
	
	public void print_org_emftext_language_bibtex_EditorField_0_0(org.emftext.language.bibtex.EditorField element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("editors");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.EDITOR_FIELD__EDITORS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("editors", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_org_emftext_language_bibtex_EditorField_0_0_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	public void print_org_emftext_language_bibtex_EditorField_0_0_0(org.emftext.language.bibtex.EditorField element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("and");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("editors");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.EDITOR_FIELD__EDITORS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("editors", count - 1);
		}
	}
	
	public void print_org_emftext_language_bibtex_EditorField_0_1(org.emftext.language.bibtex.EditorField element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("\"");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("editors");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.EDITOR_FIELD__EDITORS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("editors", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_org_emftext_language_bibtex_EditorField_0_1_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("\"");
		out.print(" ");
	}
	
	public void print_org_emftext_language_bibtex_EditorField_0_1_0(org.emftext.language.bibtex.EditorField element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("and");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("editors");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.EDITOR_FIELD__EDITORS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("editors", count - 1);
		}
	}
	
	
	public void print_org_emftext_language_bibtex_Editor(org.emftext.language.bibtex.Editor element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.EDITOR__FIRST_NAME));
		printCountingMap.put("firstName", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.EDITOR__SECOND_NAME));
		printCountingMap.put("secondName", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.EDITOR__LAST_NAME));
		printCountingMap.put("lastName", temp == null ? 0 : 1);
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_emftext_language_bibtex_Editor_0(element, localtab, out, printCountingMap);
	}
	
	public void print_org_emftext_language_bibtex_Editor_0(org.emftext.language.bibtex.Editor element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, java.util.Arrays.asList(		"firstName"		,
		"lastName"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"lastName"		,
		"firstName"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CompoundDefinition)
				print_org_emftext_language_bibtex_Editor_0_1(element, localtab, out, printCountingMap);
			}
			break;
			default:			// DEFINITION PART BEGINS (CompoundDefinition)
			print_org_emftext_language_bibtex_Editor_0_0(element, localtab, out, printCountingMap);
		}
	}
	
	public void print_org_emftext_language_bibtex_Editor_0_0(org.emftext.language.bibtex.Editor element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("firstName");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.EDITOR__FIRST_NAME));
			if (o != null) {
				org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.EDITOR__FIRST_NAME), element));
				out.print(" ");
			}
			printCountingMap.put("firstName", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_org_emftext_language_bibtex_Editor_0_0_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("lastName");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.EDITOR__LAST_NAME));
			if (o != null) {
				org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.EDITOR__LAST_NAME), element));
				out.print(" ");
			}
			printCountingMap.put("lastName", count - 1);
		}
	}
	
	public void print_org_emftext_language_bibtex_Editor_0_0_0(org.emftext.language.bibtex.Editor element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("secondName");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.EDITOR__SECOND_NAME));
			if (o != null) {
				org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.EDITOR__SECOND_NAME), element));
				out.print(" ");
			}
			printCountingMap.put("secondName", count - 1);
		}
	}
	
	public void print_org_emftext_language_bibtex_Editor_0_1(org.emftext.language.bibtex.Editor element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("lastName");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.EDITOR__LAST_NAME));
			if (o != null) {
				org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.EDITOR__LAST_NAME), element));
				out.print(" ");
			}
			printCountingMap.put("lastName", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("firstName");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.EDITOR__FIRST_NAME));
			if (o != null) {
				org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.EDITOR__FIRST_NAME), element));
				out.print(" ");
			}
			printCountingMap.put("firstName", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_org_emftext_language_bibtex_Editor_0_1_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	
	public void print_org_emftext_language_bibtex_Editor_0_1_0(org.emftext.language.bibtex.Editor element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("secondName");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.EDITOR__SECOND_NAME));
			if (o != null) {
				org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.EDITOR__SECOND_NAME), element));
				out.print(" ");
			}
			printCountingMap.put("secondName", count - 1);
		}
	}
	
	
	public void print_org_emftext_language_bibtex_KeywordField(org.emftext.language.bibtex.KeywordField element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.KEYWORD_FIELD__KEYWORDS));
		printCountingMap.put("keywords", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CsString)
		out.print("keywords");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("=");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_emftext_language_bibtex_KeywordField_0(element, localtab, out, printCountingMap);
	}
	
	public void print_org_emftext_language_bibtex_KeywordField_0(org.emftext.language.bibtex.KeywordField element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, java.util.Arrays.asList(		"keywords"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"keywords"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				boolean iterate = true;
				java.io.StringWriter sWriter = null;
				java.io.PrintWriter out1 = null;
				java.util.Map<String, Integer> printCountingMap1 = null;
				// DEFINITION PART BEGINS (CsString)
				out.print("\"");
				out.print(" ");
				// DEFINITION PART BEGINS (Containment)
				count = printCountingMap.get("keywords");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.KEYWORD_FIELD__KEYWORDS));
					java.util.List<?> list = (java.util.List<?>) o;
					int index = list.size() - count;
					if (index >= 0) {
						o = list.get(index);
					} else {
						o = null;
					}
					if (o != null) {
						doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
					}
					printCountingMap.put("keywords", count - 1);
				}
				// DEFINITION PART BEGINS (CompoundDefinition)
				iterate = true;
				while (iterate) {
					sWriter = new java.io.StringWriter();
					out1 = new java.io.PrintWriter(sWriter);
					printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
					print_org_emftext_language_bibtex_KeywordField_0_1(element, localtab, out1, printCountingMap1);
					if (printCountingMap.equals(printCountingMap1)) {
						iterate = false;
						out1.close();
					} else {
						out1.flush();
						out1.close();
						out.print(sWriter.toString());
						printCountingMap.putAll(printCountingMap1);
					}
				}
				// DEFINITION PART BEGINS (CsString)
				out.print("\"");
				out.print(" ");
			}
			break;
			default:			boolean iterate = true;
			java.io.StringWriter sWriter = null;
			java.io.PrintWriter out1 = null;
			java.util.Map<String, Integer> printCountingMap1 = null;
			// DEFINITION PART BEGINS (CsString)
			out.print("{");
			out.print(" ");
			// DEFINITION PART BEGINS (Containment)
			count = printCountingMap.get("keywords");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.KEYWORD_FIELD__KEYWORDS));
				java.util.List<?> list = (java.util.List<?>) o;
				int index = list.size() - count;
				if (index >= 0) {
					o = list.get(index);
				} else {
					o = null;
				}
				if (o != null) {
					doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
				}
				printCountingMap.put("keywords", count - 1);
			}
			// DEFINITION PART BEGINS (CompoundDefinition)
			iterate = true;
			while (iterate) {
				sWriter = new java.io.StringWriter();
				out1 = new java.io.PrintWriter(sWriter);
				printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
				print_org_emftext_language_bibtex_KeywordField_0_0(element, localtab, out1, printCountingMap1);
				if (printCountingMap.equals(printCountingMap1)) {
					iterate = false;
					out1.close();
				} else {
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			// DEFINITION PART BEGINS (CsString)
			out.print("}");
			out.print(" ");
		}
	}
	
	public void print_org_emftext_language_bibtex_KeywordField_0_0(org.emftext.language.bibtex.KeywordField element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("keywords");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.KEYWORD_FIELD__KEYWORDS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("keywords", count - 1);
		}
	}
	
	public void print_org_emftext_language_bibtex_KeywordField_0_1(org.emftext.language.bibtex.KeywordField element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("keywords");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.KEYWORD_FIELD__KEYWORDS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("keywords", count - 1);
		}
	}
	
	
	public void print_org_emftext_language_bibtex_Keyword(org.emftext.language.bibtex.Keyword element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.KEYWORD__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_emftext_language_bibtex_Keyword_0(element, localtab, out, printCountingMap);
	}
	
	public void print_org_emftext_language_bibtex_Keyword_0(org.emftext.language.bibtex.Keyword element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, java.util.Arrays.asList(		"value"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"value"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("value");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.KEYWORD__VALUE));
					if (o != null) {
						org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.KEYWORD__VALUE), element));
						out.print(" ");
					}
					printCountingMap.put("value", count - 1);
				}
			}
			break;
			default:			// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
			count = printCountingMap.get("value");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.KEYWORD__VALUE));
				if (o != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.KEYWORD__VALUE), element));
					out.print(" ");
				}
				printCountingMap.put("value", count - 1);
			}
		}
	}
	
	
	public void print_org_emftext_language_bibtex_TitleField(org.emftext.language.bibtex.TitleField element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.TITLE_FIELD__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CsString)
		out.print("title");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("=");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_emftext_language_bibtex_TitleField_0(element, localtab, out, printCountingMap);
	}
	
	public void print_org_emftext_language_bibtex_TitleField_0(org.emftext.language.bibtex.TitleField element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, java.util.Arrays.asList(		"value"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"value"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CompoundDefinition)
				print_org_emftext_language_bibtex_TitleField_0_0(element, localtab, out, printCountingMap);
			}
			break;
			default:			// DEFINITION PART BEGINS (PlaceholderInQuotes)
			count = printCountingMap.get("value");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.TITLE_FIELD__VALUE));
				if (o != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.TITLE_FIELD__VALUE), element));
					out.print(" ");
				}
				printCountingMap.put("value", count - 1);
			}
		}
	}
	
	public void print_org_emftext_language_bibtex_TitleField_0_0(org.emftext.language.bibtex.TitleField element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("value");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.TITLE_FIELD__VALUE));
			if (o != null) {
				org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.TITLE_FIELD__VALUE), element));
				out.print(" ");
			}
			printCountingMap.put("value", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	
	public void print_org_emftext_language_bibtex_BookTitleField(org.emftext.language.bibtex.BookTitleField element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.BOOK_TITLE_FIELD__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CsString)
		out.print("booktitle");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("=");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_emftext_language_bibtex_BookTitleField_0(element, localtab, out, printCountingMap);
	}
	
	public void print_org_emftext_language_bibtex_BookTitleField_0(org.emftext.language.bibtex.BookTitleField element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, java.util.Arrays.asList(		"value"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"value"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("{");
				out.print(" ");
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("value");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.BOOK_TITLE_FIELD__VALUE));
					if (o != null) {
						org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.BOOK_TITLE_FIELD__VALUE), element));
						out.print(" ");
					}
					printCountingMap.put("value", count - 1);
				}
				// DEFINITION PART BEGINS (CsString)
				out.print("}");
				out.print(" ");
			}
			break;
			default:			// DEFINITION PART BEGINS (PlaceholderInQuotes)
			count = printCountingMap.get("value");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.BOOK_TITLE_FIELD__VALUE));
				if (o != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.BOOK_TITLE_FIELD__VALUE), element));
					out.print(" ");
				}
				printCountingMap.put("value", count - 1);
			}
		}
	}
	
	
	public void print_org_emftext_language_bibtex_SeriesField(org.emftext.language.bibtex.SeriesField element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.SERIES_FIELD__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CsString)
		out.print("series");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("=");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_emftext_language_bibtex_SeriesField_0(element, localtab, out, printCountingMap);
	}
	
	public void print_org_emftext_language_bibtex_SeriesField_0(org.emftext.language.bibtex.SeriesField element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, java.util.Arrays.asList(		"value"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"value"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("{");
				out.print(" ");
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("value");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.SERIES_FIELD__VALUE));
					if (o != null) {
						org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.SERIES_FIELD__VALUE), element));
						out.print(" ");
					}
					printCountingMap.put("value", count - 1);
				}
				// DEFINITION PART BEGINS (CsString)
				out.print("}");
				out.print(" ");
			}
			break;
			default:			// DEFINITION PART BEGINS (PlaceholderInQuotes)
			count = printCountingMap.get("value");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.SERIES_FIELD__VALUE));
				if (o != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.SERIES_FIELD__VALUE), element));
					out.print(" ");
				}
				printCountingMap.put("value", count - 1);
			}
		}
	}
	
	
	public void print_org_emftext_language_bibtex_AddressField(org.emftext.language.bibtex.AddressField element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ADDRESS_FIELD__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CsString)
		out.print("address");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("=");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_emftext_language_bibtex_AddressField_0(element, localtab, out, printCountingMap);
	}
	
	public void print_org_emftext_language_bibtex_AddressField_0(org.emftext.language.bibtex.AddressField element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, java.util.Arrays.asList(		"value"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"value"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("{");
				out.print(" ");
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("value");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ADDRESS_FIELD__VALUE));
					if (o != null) {
						org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ADDRESS_FIELD__VALUE), element));
						out.print(" ");
					}
					printCountingMap.put("value", count - 1);
				}
				// DEFINITION PART BEGINS (CsString)
				out.print("}");
				out.print(" ");
			}
			break;
			default:			// DEFINITION PART BEGINS (PlaceholderInQuotes)
			count = printCountingMap.get("value");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ADDRESS_FIELD__VALUE));
				if (o != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ADDRESS_FIELD__VALUE), element));
					out.print(" ");
				}
				printCountingMap.put("value", count - 1);
			}
		}
	}
	
	
	public void print_org_emftext_language_bibtex_MonthField(org.emftext.language.bibtex.MonthField element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.MONTH_FIELD__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CsString)
		out.print("month");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("=");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_emftext_language_bibtex_MonthField_0(element, localtab, out, printCountingMap);
	}
	
	public void print_org_emftext_language_bibtex_MonthField_0(org.emftext.language.bibtex.MonthField element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, java.util.Arrays.asList(		"value"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"value"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("{");
				out.print(" ");
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("value");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.MONTH_FIELD__VALUE));
					if (o != null) {
						org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.MONTH_FIELD__VALUE), element));
						out.print(" ");
					}
					printCountingMap.put("value", count - 1);
				}
				// DEFINITION PART BEGINS (CsString)
				out.print("}");
				out.print(" ");
			}
			break;
			default:			// DEFINITION PART BEGINS (PlaceholderInQuotes)
			count = printCountingMap.get("value");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.MONTH_FIELD__VALUE));
				if (o != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.MONTH_FIELD__VALUE), element));
					out.print(" ");
				}
				printCountingMap.put("value", count - 1);
			}
		}
	}
	
	
	public void print_org_emftext_language_bibtex_OrganizationField(org.emftext.language.bibtex.OrganizationField element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ORGANIZATION_FIELD__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CsString)
		out.print("organization");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("=");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_emftext_language_bibtex_OrganizationField_0(element, localtab, out, printCountingMap);
	}
	
	public void print_org_emftext_language_bibtex_OrganizationField_0(org.emftext.language.bibtex.OrganizationField element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, java.util.Arrays.asList(		"value"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"value"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("{");
				out.print(" ");
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("value");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ORGANIZATION_FIELD__VALUE));
					if (o != null) {
						org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ORGANIZATION_FIELD__VALUE), element));
						out.print(" ");
					}
					printCountingMap.put("value", count - 1);
				}
				// DEFINITION PART BEGINS (CsString)
				out.print("}");
				out.print(" ");
			}
			break;
			default:			// DEFINITION PART BEGINS (PlaceholderInQuotes)
			count = printCountingMap.get("value");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ORGANIZATION_FIELD__VALUE));
				if (o != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ORGANIZATION_FIELD__VALUE), element));
					out.print(" ");
				}
				printCountingMap.put("value", count - 1);
			}
		}
	}
	
	
	public void print_org_emftext_language_bibtex_PublisherField(org.emftext.language.bibtex.PublisherField element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.PUBLISHER_FIELD__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CsString)
		out.print("publisher");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("=");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_emftext_language_bibtex_PublisherField_0(element, localtab, out, printCountingMap);
	}
	
	public void print_org_emftext_language_bibtex_PublisherField_0(org.emftext.language.bibtex.PublisherField element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, java.util.Arrays.asList(		"value"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"value"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("{");
				out.print(" ");
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("value");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.PUBLISHER_FIELD__VALUE));
					if (o != null) {
						org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.PUBLISHER_FIELD__VALUE), element));
						out.print(" ");
					}
					printCountingMap.put("value", count - 1);
				}
				// DEFINITION PART BEGINS (CsString)
				out.print("}");
				out.print(" ");
			}
			break;
			default:			// DEFINITION PART BEGINS (PlaceholderInQuotes)
			count = printCountingMap.get("value");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.PUBLISHER_FIELD__VALUE));
				if (o != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.PUBLISHER_FIELD__VALUE), element));
					out.print(" ");
				}
				printCountingMap.put("value", count - 1);
			}
		}
	}
	
	
	public void print_org_emftext_language_bibtex_JournalField(org.emftext.language.bibtex.JournalField element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.JOURNAL_FIELD__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CsString)
		out.print("journal");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("=");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_emftext_language_bibtex_JournalField_0(element, localtab, out, printCountingMap);
	}
	
	public void print_org_emftext_language_bibtex_JournalField_0(org.emftext.language.bibtex.JournalField element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, java.util.Arrays.asList(		"value"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"value"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("{");
				out.print(" ");
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("value");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.JOURNAL_FIELD__VALUE));
					if (o != null) {
						org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.JOURNAL_FIELD__VALUE), element));
						out.print(" ");
					}
					printCountingMap.put("value", count - 1);
				}
				// DEFINITION PART BEGINS (CsString)
				out.print("}");
				out.print(" ");
			}
			break;
			default:			// DEFINITION PART BEGINS (PlaceholderInQuotes)
			count = printCountingMap.get("value");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.JOURNAL_FIELD__VALUE));
				if (o != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.JOURNAL_FIELD__VALUE), element));
					out.print(" ");
				}
				printCountingMap.put("value", count - 1);
			}
		}
	}
	
	
	public void print_org_emftext_language_bibtex_NoteField(org.emftext.language.bibtex.NoteField element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.NOTE_FIELD__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CsString)
		out.print("note");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("=");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_emftext_language_bibtex_NoteField_0(element, localtab, out, printCountingMap);
	}
	
	public void print_org_emftext_language_bibtex_NoteField_0(org.emftext.language.bibtex.NoteField element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, java.util.Arrays.asList(		"value"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"value"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("{");
				out.print(" ");
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("value");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.NOTE_FIELD__VALUE));
					if (o != null) {
						org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.NOTE_FIELD__VALUE), element));
						out.print(" ");
					}
					printCountingMap.put("value", count - 1);
				}
				// DEFINITION PART BEGINS (CsString)
				out.print("}");
				out.print(" ");
			}
			break;
			default:			// DEFINITION PART BEGINS (PlaceholderInQuotes)
			count = printCountingMap.get("value");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.NOTE_FIELD__VALUE));
				if (o != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.NOTE_FIELD__VALUE), element));
					out.print(" ");
				}
				printCountingMap.put("value", count - 1);
			}
		}
	}
	
	
	public void print_org_emftext_language_bibtex_EidField(org.emftext.language.bibtex.EidField element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.EID_FIELD__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CsString)
		out.print("eid");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("=");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_emftext_language_bibtex_EidField_0(element, localtab, out, printCountingMap);
	}
	
	public void print_org_emftext_language_bibtex_EidField_0(org.emftext.language.bibtex.EidField element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, java.util.Arrays.asList(		"value"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"value"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("{");
				out.print(" ");
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("value");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.EID_FIELD__VALUE));
					if (o != null) {
						org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.EID_FIELD__VALUE), element));
						out.print(" ");
					}
					printCountingMap.put("value", count - 1);
				}
				// DEFINITION PART BEGINS (CsString)
				out.print("}");
				out.print(" ");
			}
			break;
			default:			// DEFINITION PART BEGINS (PlaceholderInQuotes)
			count = printCountingMap.get("value");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.EID_FIELD__VALUE));
				if (o != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.EID_FIELD__VALUE), element));
					out.print(" ");
				}
				printCountingMap.put("value", count - 1);
			}
		}
	}
	
	
	public void print_org_emftext_language_bibtex_AbstractField(org.emftext.language.bibtex.AbstractField element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ABSTRACT_FIELD__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CsString)
		out.print("abstract");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("=");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_emftext_language_bibtex_AbstractField_0(element, localtab, out, printCountingMap);
	}
	
	public void print_org_emftext_language_bibtex_AbstractField_0(org.emftext.language.bibtex.AbstractField element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, java.util.Arrays.asList(		"value"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"value"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("{");
				out.print(" ");
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("value");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ABSTRACT_FIELD__VALUE));
					if (o != null) {
						org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ABSTRACT_FIELD__VALUE), element));
						out.print(" ");
					}
					printCountingMap.put("value", count - 1);
				}
				// DEFINITION PART BEGINS (CsString)
				out.print("}");
				out.print(" ");
			}
			break;
			default:			// DEFINITION PART BEGINS (PlaceholderInQuotes)
			count = printCountingMap.get("value");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ABSTRACT_FIELD__VALUE));
				if (o != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ABSTRACT_FIELD__VALUE), element));
					out.print(" ");
				}
				printCountingMap.put("value", count - 1);
			}
		}
	}
	
	
	public void print_org_emftext_language_bibtex_ReviewField(org.emftext.language.bibtex.ReviewField element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.REVIEW_FIELD__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CsString)
		out.print("review");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("=");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_emftext_language_bibtex_ReviewField_0(element, localtab, out, printCountingMap);
	}
	
	public void print_org_emftext_language_bibtex_ReviewField_0(org.emftext.language.bibtex.ReviewField element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, java.util.Arrays.asList(		"value"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"value"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("{");
				out.print(" ");
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("value");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.REVIEW_FIELD__VALUE));
					if (o != null) {
						org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.REVIEW_FIELD__VALUE), element));
						out.print(" ");
					}
					printCountingMap.put("value", count - 1);
				}
				// DEFINITION PART BEGINS (CsString)
				out.print("}");
				out.print(" ");
			}
			break;
			default:			// DEFINITION PART BEGINS (PlaceholderInQuotes)
			count = printCountingMap.get("value");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.REVIEW_FIELD__VALUE));
				if (o != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.REVIEW_FIELD__VALUE), element));
					out.print(" ");
				}
				printCountingMap.put("value", count - 1);
			}
		}
	}
	
	
	public void print_org_emftext_language_bibtex_UrlField(org.emftext.language.bibtex.UrlField element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.URL_FIELD__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CsString)
		out.print("url");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("=");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_emftext_language_bibtex_UrlField_0(element, localtab, out, printCountingMap);
	}
	
	public void print_org_emftext_language_bibtex_UrlField_0(org.emftext.language.bibtex.UrlField element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, java.util.Arrays.asList(		"value"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"value"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("{");
				out.print(" ");
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("value");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.URL_FIELD__VALUE));
					if (o != null) {
						org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.URL_FIELD__VALUE), element));
						out.print(" ");
					}
					printCountingMap.put("value", count - 1);
				}
				// DEFINITION PART BEGINS (CsString)
				out.print("}");
				out.print(" ");
			}
			break;
			default:			// DEFINITION PART BEGINS (PlaceholderInQuotes)
			count = printCountingMap.get("value");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.URL_FIELD__VALUE));
				if (o != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.URL_FIELD__VALUE), element));
					out.print(" ");
				}
				printCountingMap.put("value", count - 1);
			}
		}
	}
	
	
	public void print_org_emftext_language_bibtex_YearField(org.emftext.language.bibtex.YearField element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.YEAR_FIELD__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CsString)
		out.print("year");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("=");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_emftext_language_bibtex_YearField_0(element, localtab, out, printCountingMap);
	}
	
	public void print_org_emftext_language_bibtex_YearField_0(org.emftext.language.bibtex.YearField element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, java.util.Arrays.asList(		"value"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"value"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("\"");
				out.print(" ");
				// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
				count = printCountingMap.get("value");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.YEAR_FIELD__VALUE));
					if (o != null) {
						org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("YEAR");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.YEAR_FIELD__VALUE), element));
						out.print(" ");
					}
					printCountingMap.put("value", count - 1);
				}
				// DEFINITION PART BEGINS (CsString)
				out.print("\"");
				out.print(" ");
			}
			break;
			default:			// DEFINITION PART BEGINS (CsString)
			out.print("{");
			out.print(" ");
			// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
			count = printCountingMap.get("value");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.YEAR_FIELD__VALUE));
				if (o != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("YEAR");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.YEAR_FIELD__VALUE), element));
					out.print(" ");
				}
				printCountingMap.put("value", count - 1);
			}
			// DEFINITION PART BEGINS (CsString)
			out.print("}");
			out.print(" ");
		}
	}
	
	
	public void print_org_emftext_language_bibtex_VolumeField(org.emftext.language.bibtex.VolumeField element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.VOLUME_FIELD__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CsString)
		out.print("volume");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("=");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_emftext_language_bibtex_VolumeField_0(element, localtab, out, printCountingMap);
	}
	
	public void print_org_emftext_language_bibtex_VolumeField_0(org.emftext.language.bibtex.VolumeField element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, java.util.Arrays.asList(		"value"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"value"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("{");
				out.print(" ");
				// DEFINITION PART BEGINS (CompoundDefinition)
				print_org_emftext_language_bibtex_VolumeField_0_1(element, localtab, out, printCountingMap);
				// DEFINITION PART BEGINS (CsString)
				out.print("}");
				out.print(" ");
			}
			break;
			default:			// DEFINITION PART BEGINS (CsString)
			out.print("\"");
			out.print(" ");
			// DEFINITION PART BEGINS (CompoundDefinition)
			print_org_emftext_language_bibtex_VolumeField_0_0(element, localtab, out, printCountingMap);
			// DEFINITION PART BEGINS (CsString)
			out.print("\"");
			out.print(" ");
		}
	}
	
	public void print_org_emftext_language_bibtex_VolumeField_0_0(org.emftext.language.bibtex.VolumeField element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("value");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.VOLUME_FIELD__VALUE));
			if (o != null) {
				org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("INTEGER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.VOLUME_FIELD__VALUE), element));
				out.print(" ");
			}
			printCountingMap.put("value", count - 1);
		}
	}
	
	public void print_org_emftext_language_bibtex_VolumeField_0_1(org.emftext.language.bibtex.VolumeField element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("value");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.VOLUME_FIELD__VALUE));
			if (o != null) {
				org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("INTEGER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.VOLUME_FIELD__VALUE), element));
				out.print(" ");
			}
			printCountingMap.put("value", count - 1);
		}
	}
	
	
	public void print_org_emftext_language_bibtex_PartField(org.emftext.language.bibtex.PartField element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.PART_FIELD__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CsString)
		out.print("part");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("=");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_emftext_language_bibtex_PartField_0(element, localtab, out, printCountingMap);
	}
	
	public void print_org_emftext_language_bibtex_PartField_0(org.emftext.language.bibtex.PartField element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, java.util.Arrays.asList(		"value"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"value"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("\"");
				out.print(" ");
				// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
				count = printCountingMap.get("value");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.PART_FIELD__VALUE));
					if (o != null) {
						org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("INTEGER");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.PART_FIELD__VALUE), element));
						out.print(" ");
					}
					printCountingMap.put("value", count - 1);
				}
				// DEFINITION PART BEGINS (CsString)
				out.print("\"");
				out.print(" ");
			}
			break;
			default:			// DEFINITION PART BEGINS (CsString)
			out.print("{");
			out.print(" ");
			// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
			count = printCountingMap.get("value");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.PART_FIELD__VALUE));
				if (o != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("INTEGER");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.PART_FIELD__VALUE), element));
					out.print(" ");
				}
				printCountingMap.put("value", count - 1);
			}
			// DEFINITION PART BEGINS (CsString)
			out.print("}");
			out.print(" ");
		}
	}
	
	
	public void print_org_emftext_language_bibtex_NumberField(org.emftext.language.bibtex.NumberField element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.NUMBER_FIELD__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CsString)
		out.print("number");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("=");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_emftext_language_bibtex_NumberField_0(element, localtab, out, printCountingMap);
	}
	
	public void print_org_emftext_language_bibtex_NumberField_0(org.emftext.language.bibtex.NumberField element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, java.util.Arrays.asList(		"value"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"value"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("\"");
				out.print(" ");
				// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
				count = printCountingMap.get("value");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.NUMBER_FIELD__VALUE));
					if (o != null) {
						org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("INTEGER");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.NUMBER_FIELD__VALUE), element));
						out.print(" ");
					}
					printCountingMap.put("value", count - 1);
				}
				// DEFINITION PART BEGINS (CsString)
				out.print("\"");
				out.print(" ");
			}
			break;
			default:			// DEFINITION PART BEGINS (CsString)
			out.print("{");
			out.print(" ");
			// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
			count = printCountingMap.get("value");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.NUMBER_FIELD__VALUE));
				if (o != null) {
					org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("INTEGER");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.NUMBER_FIELD__VALUE), element));
					out.print(" ");
				}
				printCountingMap.put("value", count - 1);
			}
			// DEFINITION PART BEGINS (CsString)
			out.print("}");
			out.print(" ");
		}
	}
	
	
	public void print_org_emftext_language_bibtex_PageField(org.emftext.language.bibtex.PageField element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.PAGE_FIELD__FROM_PAGE));
		printCountingMap.put("fromPage", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.PAGE_FIELD__TO_PAGE));
		printCountingMap.put("toPage", temp == null ? 0 : 1);
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CsString)
		out.print("pages");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("=");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_emftext_language_bibtex_PageField_0(element, localtab, out, printCountingMap);
	}
	
	public void print_org_emftext_language_bibtex_PageField_0(org.emftext.language.bibtex.PageField element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, java.util.Arrays.asList(		"fromPage"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"fromPage"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				java.io.StringWriter sWriter = null;
				java.io.PrintWriter out1 = null;
				java.util.Map<String, Integer> printCountingMap1 = null;
				// DEFINITION PART BEGINS (CsString)
				out.print("\"");
				out.print(" ");
				// DEFINITION PART BEGINS (Containment)
				count = printCountingMap.get("fromPage");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.PAGE_FIELD__FROM_PAGE));
					if (o != null) {
						doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
					}
					printCountingMap.put("fromPage", count - 1);
				}
				// DEFINITION PART BEGINS (CompoundDefinition)
				sWriter = new java.io.StringWriter();
				out1 = new java.io.PrintWriter(sWriter);
				printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
				print_org_emftext_language_bibtex_PageField_0_1(element, localtab, out1, printCountingMap1);
				if (printCountingMap.equals(printCountingMap1)) {
					out1.close();
				} else {
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
				// DEFINITION PART BEGINS (CsString)
				out.print("\"");
				out.print(" ");
			}
			break;
			default:			java.io.StringWriter sWriter = null;
			java.io.PrintWriter out1 = null;
			java.util.Map<String, Integer> printCountingMap1 = null;
			// DEFINITION PART BEGINS (CsString)
			out.print("{");
			out.print(" ");
			// DEFINITION PART BEGINS (Containment)
			count = printCountingMap.get("fromPage");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.PAGE_FIELD__FROM_PAGE));
				if (o != null) {
					doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
				}
				printCountingMap.put("fromPage", count - 1);
			}
			// DEFINITION PART BEGINS (CompoundDefinition)
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_org_emftext_language_bibtex_PageField_0_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			// DEFINITION PART BEGINS (CsString)
			out.print("}");
			out.print(" ");
		}
	}
	
	public void print_org_emftext_language_bibtex_PageField_0_0(org.emftext.language.bibtex.PageField element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_emftext_language_bibtex_PageField_0_0_0(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("toPage");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.PAGE_FIELD__TO_PAGE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("toPage", count - 1);
		}
	}
	
	public void print_org_emftext_language_bibtex_PageField_0_0_0(org.emftext.language.bibtex.PageField element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int alt = -1;
		alt = 0;
		int matches = 		0;
		int tempMatchCount;
		tempMatchCount = 		0;
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("-");
				out.print(" ");
			}
			break;
			default:			// DEFINITION PART BEGINS (CsString)
			out.print("--");
			out.print(" ");
		}
	}
	
	public void print_org_emftext_language_bibtex_PageField_0_1(org.emftext.language.bibtex.PageField element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_emftext_language_bibtex_PageField_0_1_0(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("toPage");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.PAGE_FIELD__TO_PAGE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("toPage", count - 1);
		}
	}
	
	public void print_org_emftext_language_bibtex_PageField_0_1_0(org.emftext.language.bibtex.PageField element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int alt = -1;
		alt = 0;
		int matches = 		0;
		int tempMatchCount;
		tempMatchCount = 		0;
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("-");
				out.print(" ");
			}
			break;
			default:			// DEFINITION PART BEGINS (CsString)
			out.print("--");
			out.print(" ");
		}
	}
	
	
	public void print_org_emftext_language_bibtex_Page(org.emftext.language.bibtex.Page element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.PAGE__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("value");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.PAGE__VALUE));
			if (o != null) {
				org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver = tokenResolverFactory.createTokenResolver("INTEGER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.PAGE__VALUE), element));
				out.print(" ");
			}
			printCountingMap.put("value", count - 1);
		}
	}
	
	
	public void print_org_emftext_language_bibtex_InProceedingsEntry(org.emftext.language.bibtex.InProceedingsEntry element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(19);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__BIBTEX_KEY));
		printCountingMap.put("bibtexKey", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__ABSTRACT));
		printCountingMap.put("abstract", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__URL));
		printCountingMap.put("url", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__KEYWORD));
		printCountingMap.put("keyword", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__REVIEW));
		printCountingMap.put("review", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__AUTHOR));
		printCountingMap.put("author", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__TITLE));
		printCountingMap.put("title", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__BOOK_TITLE));
		printCountingMap.put("bookTitle", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__YEAR));
		printCountingMap.put("year", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__EDITOR));
		printCountingMap.put("editor", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__PAGES));
		printCountingMap.put("pages", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__VOLUME));
		printCountingMap.put("volume", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__NUMBER));
		printCountingMap.put("number", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__SERIES));
		printCountingMap.put("series", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__ADDRESS));
		printCountingMap.put("address", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__MONTH));
		printCountingMap.put("month", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__ORGANIZATION));
		printCountingMap.put("organization", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__NOTE));
		printCountingMap.put("note", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__PUBLISHER));
		printCountingMap.put("publisher", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_emftext_language_bibtex_InProceedingsEntry_0(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("bibtexKey");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__BIBTEX_KEY));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("bibtexKey", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_org_emftext_language_bibtex_InProceedingsEntry_1(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	public void print_org_emftext_language_bibtex_InProceedingsEntry_0(org.emftext.language.bibtex.InProceedingsEntry element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int alt = -1;
		alt = 0;
		int matches = 		0;
		int tempMatchCount;
		tempMatchCount = 		0;
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("@inproceedings");
				out.print(" ");
			}
			break;
			default:			// DEFINITION PART BEGINS (CsString)
			out.print("@INPROCEEDINGS");
			out.print(" ");
		}
	}
	
	public void print_org_emftext_language_bibtex_InProceedingsEntry_1(org.emftext.language.bibtex.InProceedingsEntry element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_emftext_language_bibtex_InProceedingsEntry_1_0(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
	}
	
	public void print_org_emftext_language_bibtex_InProceedingsEntry_1_0(org.emftext.language.bibtex.InProceedingsEntry element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int alt = -1;
		alt = 0;
		int matches = 		0;
		int tempMatchCount;
		tempMatchCount = 		0;
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		tempMatchCount = 		0;
		if (tempMatchCount > matches) {
			alt = 2;
			matches = tempMatchCount;
		}
		tempMatchCount = 		0;
		if (tempMatchCount > matches) {
			alt = 3;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"title"		));
		if (tempMatchCount > matches) {
			alt = 4;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"bookTitle"		));
		if (tempMatchCount > matches) {
			alt = 5;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"year"		));
		if (tempMatchCount > matches) {
			alt = 6;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"author"		));
		if (tempMatchCount > matches) {
			alt = 7;
			matches = tempMatchCount;
		}
		tempMatchCount = 		0;
		if (tempMatchCount > matches) {
			alt = 8;
			matches = tempMatchCount;
		}
		tempMatchCount = 		0;
		if (tempMatchCount > matches) {
			alt = 9;
			matches = tempMatchCount;
		}
		tempMatchCount = 		0;
		if (tempMatchCount > matches) {
			alt = 10;
			matches = tempMatchCount;
		}
		tempMatchCount = 		0;
		if (tempMatchCount > matches) {
			alt = 11;
			matches = tempMatchCount;
		}
		tempMatchCount = 		0;
		if (tempMatchCount > matches) {
			alt = 12;
			matches = tempMatchCount;
		}
		tempMatchCount = 		0;
		if (tempMatchCount > matches) {
			alt = 13;
			matches = tempMatchCount;
		}
		tempMatchCount = 		0;
		if (tempMatchCount > matches) {
			alt = 14;
			matches = tempMatchCount;
		}
		tempMatchCount = 		0;
		if (tempMatchCount > matches) {
			alt = 15;
			matches = tempMatchCount;
		}
		tempMatchCount = 		0;
		if (tempMatchCount > matches) {
			alt = 16;
			matches = tempMatchCount;
		}
		tempMatchCount = 		0;
		if (tempMatchCount > matches) {
			alt = 17;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				java.io.StringWriter sWriter = null;
				java.io.PrintWriter out1 = null;
				java.util.Map<String, Integer> printCountingMap1 = null;
				// DEFINITION PART BEGINS (CompoundDefinition)
				sWriter = new java.io.StringWriter();
				out1 = new java.io.PrintWriter(sWriter);
				printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
				print_org_emftext_language_bibtex_InProceedingsEntry_1_0_1(element, localtab, out1, printCountingMap1);
				if (printCountingMap.equals(printCountingMap1)) {
					out1.close();
				} else {
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			break;
			case 2:			{
				java.io.StringWriter sWriter = null;
				java.io.PrintWriter out1 = null;
				java.util.Map<String, Integer> printCountingMap1 = null;
				// DEFINITION PART BEGINS (CompoundDefinition)
				sWriter = new java.io.StringWriter();
				out1 = new java.io.PrintWriter(sWriter);
				printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
				print_org_emftext_language_bibtex_InProceedingsEntry_1_0_2(element, localtab, out1, printCountingMap1);
				if (printCountingMap.equals(printCountingMap1)) {
					out1.close();
				} else {
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			break;
			case 3:			{
				java.io.StringWriter sWriter = null;
				java.io.PrintWriter out1 = null;
				java.util.Map<String, Integer> printCountingMap1 = null;
				// DEFINITION PART BEGINS (CompoundDefinition)
				sWriter = new java.io.StringWriter();
				out1 = new java.io.PrintWriter(sWriter);
				printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
				print_org_emftext_language_bibtex_InProceedingsEntry_1_0_3(element, localtab, out1, printCountingMap1);
				if (printCountingMap.equals(printCountingMap1)) {
					out1.close();
				} else {
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			break;
			case 4:			{
				// DEFINITION PART BEGINS (CompoundDefinition)
				print_org_emftext_language_bibtex_InProceedingsEntry_1_0_4(element, localtab, out, printCountingMap);
			}
			break;
			case 5:			{
				// DEFINITION PART BEGINS (CompoundDefinition)
				print_org_emftext_language_bibtex_InProceedingsEntry_1_0_5(element, localtab, out, printCountingMap);
			}
			break;
			case 6:			{
				// DEFINITION PART BEGINS (CompoundDefinition)
				print_org_emftext_language_bibtex_InProceedingsEntry_1_0_6(element, localtab, out, printCountingMap);
			}
			break;
			case 7:			{
				// DEFINITION PART BEGINS (CompoundDefinition)
				print_org_emftext_language_bibtex_InProceedingsEntry_1_0_7(element, localtab, out, printCountingMap);
			}
			break;
			case 8:			{
				java.io.StringWriter sWriter = null;
				java.io.PrintWriter out1 = null;
				java.util.Map<String, Integer> printCountingMap1 = null;
				// DEFINITION PART BEGINS (CompoundDefinition)
				sWriter = new java.io.StringWriter();
				out1 = new java.io.PrintWriter(sWriter);
				printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
				print_org_emftext_language_bibtex_InProceedingsEntry_1_0_8(element, localtab, out1, printCountingMap1);
				if (printCountingMap.equals(printCountingMap1)) {
					out1.close();
				} else {
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			break;
			case 9:			{
				java.io.StringWriter sWriter = null;
				java.io.PrintWriter out1 = null;
				java.util.Map<String, Integer> printCountingMap1 = null;
				// DEFINITION PART BEGINS (CompoundDefinition)
				sWriter = new java.io.StringWriter();
				out1 = new java.io.PrintWriter(sWriter);
				printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
				print_org_emftext_language_bibtex_InProceedingsEntry_1_0_9(element, localtab, out1, printCountingMap1);
				if (printCountingMap.equals(printCountingMap1)) {
					out1.close();
				} else {
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			break;
			case 10:			{
				java.io.StringWriter sWriter = null;
				java.io.PrintWriter out1 = null;
				java.util.Map<String, Integer> printCountingMap1 = null;
				// DEFINITION PART BEGINS (CompoundDefinition)
				sWriter = new java.io.StringWriter();
				out1 = new java.io.PrintWriter(sWriter);
				printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
				print_org_emftext_language_bibtex_InProceedingsEntry_1_0_10(element, localtab, out1, printCountingMap1);
				if (printCountingMap.equals(printCountingMap1)) {
					out1.close();
				} else {
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			break;
			case 11:			{
				java.io.StringWriter sWriter = null;
				java.io.PrintWriter out1 = null;
				java.util.Map<String, Integer> printCountingMap1 = null;
				// DEFINITION PART BEGINS (CompoundDefinition)
				sWriter = new java.io.StringWriter();
				out1 = new java.io.PrintWriter(sWriter);
				printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
				print_org_emftext_language_bibtex_InProceedingsEntry_1_0_11(element, localtab, out1, printCountingMap1);
				if (printCountingMap.equals(printCountingMap1)) {
					out1.close();
				} else {
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			break;
			case 12:			{
				java.io.StringWriter sWriter = null;
				java.io.PrintWriter out1 = null;
				java.util.Map<String, Integer> printCountingMap1 = null;
				// DEFINITION PART BEGINS (CompoundDefinition)
				sWriter = new java.io.StringWriter();
				out1 = new java.io.PrintWriter(sWriter);
				printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
				print_org_emftext_language_bibtex_InProceedingsEntry_1_0_12(element, localtab, out1, printCountingMap1);
				if (printCountingMap.equals(printCountingMap1)) {
					out1.close();
				} else {
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			break;
			case 13:			{
				java.io.StringWriter sWriter = null;
				java.io.PrintWriter out1 = null;
				java.util.Map<String, Integer> printCountingMap1 = null;
				// DEFINITION PART BEGINS (CompoundDefinition)
				sWriter = new java.io.StringWriter();
				out1 = new java.io.PrintWriter(sWriter);
				printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
				print_org_emftext_language_bibtex_InProceedingsEntry_1_0_13(element, localtab, out1, printCountingMap1);
				if (printCountingMap.equals(printCountingMap1)) {
					out1.close();
				} else {
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			break;
			case 14:			{
				java.io.StringWriter sWriter = null;
				java.io.PrintWriter out1 = null;
				java.util.Map<String, Integer> printCountingMap1 = null;
				// DEFINITION PART BEGINS (CompoundDefinition)
				sWriter = new java.io.StringWriter();
				out1 = new java.io.PrintWriter(sWriter);
				printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
				print_org_emftext_language_bibtex_InProceedingsEntry_1_0_14(element, localtab, out1, printCountingMap1);
				if (printCountingMap.equals(printCountingMap1)) {
					out1.close();
				} else {
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			break;
			case 15:			{
				java.io.StringWriter sWriter = null;
				java.io.PrintWriter out1 = null;
				java.util.Map<String, Integer> printCountingMap1 = null;
				// DEFINITION PART BEGINS (CompoundDefinition)
				sWriter = new java.io.StringWriter();
				out1 = new java.io.PrintWriter(sWriter);
				printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
				print_org_emftext_language_bibtex_InProceedingsEntry_1_0_15(element, localtab, out1, printCountingMap1);
				if (printCountingMap.equals(printCountingMap1)) {
					out1.close();
				} else {
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			break;
			case 16:			{
				java.io.StringWriter sWriter = null;
				java.io.PrintWriter out1 = null;
				java.util.Map<String, Integer> printCountingMap1 = null;
				// DEFINITION PART BEGINS (CompoundDefinition)
				sWriter = new java.io.StringWriter();
				out1 = new java.io.PrintWriter(sWriter);
				printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
				print_org_emftext_language_bibtex_InProceedingsEntry_1_0_16(element, localtab, out1, printCountingMap1);
				if (printCountingMap.equals(printCountingMap1)) {
					out1.close();
				} else {
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			break;
			case 17:			{
				java.io.StringWriter sWriter = null;
				java.io.PrintWriter out1 = null;
				java.util.Map<String, Integer> printCountingMap1 = null;
				// DEFINITION PART BEGINS (CompoundDefinition)
				sWriter = new java.io.StringWriter();
				out1 = new java.io.PrintWriter(sWriter);
				printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
				print_org_emftext_language_bibtex_InProceedingsEntry_1_0_17(element, localtab, out1, printCountingMap1);
				if (printCountingMap.equals(printCountingMap1)) {
					out1.close();
				} else {
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			break;
			default:			java.io.StringWriter sWriter = null;
			java.io.PrintWriter out1 = null;
			java.util.Map<String, Integer> printCountingMap1 = null;
			// DEFINITION PART BEGINS (CompoundDefinition)
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_org_emftext_language_bibtex_InProceedingsEntry_1_0_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
	}
	
	public void print_org_emftext_language_bibtex_InProceedingsEntry_1_0_0(org.emftext.language.bibtex.InProceedingsEntry element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("url");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__URL));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("url", count - 1);
		}
	}
	
	public void print_org_emftext_language_bibtex_InProceedingsEntry_1_0_1(org.emftext.language.bibtex.InProceedingsEntry element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("abstract");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__ABSTRACT));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("abstract", count - 1);
		}
	}
	
	public void print_org_emftext_language_bibtex_InProceedingsEntry_1_0_2(org.emftext.language.bibtex.InProceedingsEntry element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("keyword");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__KEYWORD));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("keyword", count - 1);
		}
	}
	
	public void print_org_emftext_language_bibtex_InProceedingsEntry_1_0_3(org.emftext.language.bibtex.InProceedingsEntry element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("review");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__REVIEW));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("review", count - 1);
		}
	}
	
	public void print_org_emftext_language_bibtex_InProceedingsEntry_1_0_4(org.emftext.language.bibtex.InProceedingsEntry element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("title");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__TITLE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("title", count - 1);
		}
	}
	
	public void print_org_emftext_language_bibtex_InProceedingsEntry_1_0_5(org.emftext.language.bibtex.InProceedingsEntry element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("bookTitle");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__BOOK_TITLE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("bookTitle", count - 1);
		}
	}
	
	public void print_org_emftext_language_bibtex_InProceedingsEntry_1_0_6(org.emftext.language.bibtex.InProceedingsEntry element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("year");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__YEAR));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("year", count - 1);
		}
	}
	
	public void print_org_emftext_language_bibtex_InProceedingsEntry_1_0_7(org.emftext.language.bibtex.InProceedingsEntry element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("author");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__AUTHOR));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("author", count - 1);
		}
	}
	
	public void print_org_emftext_language_bibtex_InProceedingsEntry_1_0_8(org.emftext.language.bibtex.InProceedingsEntry element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("editor");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__EDITOR));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("editor", count - 1);
		}
	}
	
	public void print_org_emftext_language_bibtex_InProceedingsEntry_1_0_9(org.emftext.language.bibtex.InProceedingsEntry element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("volume");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__VOLUME));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("volume", count - 1);
		}
	}
	
	public void print_org_emftext_language_bibtex_InProceedingsEntry_1_0_10(org.emftext.language.bibtex.InProceedingsEntry element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("number");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__NUMBER));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("number", count - 1);
		}
	}
	
	public void print_org_emftext_language_bibtex_InProceedingsEntry_1_0_11(org.emftext.language.bibtex.InProceedingsEntry element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("series");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__SERIES));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("series", count - 1);
		}
	}
	
	public void print_org_emftext_language_bibtex_InProceedingsEntry_1_0_12(org.emftext.language.bibtex.InProceedingsEntry element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("pages");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__PAGES));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("pages", count - 1);
		}
	}
	
	public void print_org_emftext_language_bibtex_InProceedingsEntry_1_0_13(org.emftext.language.bibtex.InProceedingsEntry element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("address");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__ADDRESS));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("address", count - 1);
		}
	}
	
	public void print_org_emftext_language_bibtex_InProceedingsEntry_1_0_14(org.emftext.language.bibtex.InProceedingsEntry element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("month");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__MONTH));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("month", count - 1);
		}
	}
	
	public void print_org_emftext_language_bibtex_InProceedingsEntry_1_0_15(org.emftext.language.bibtex.InProceedingsEntry element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("organization");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__ORGANIZATION));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("organization", count - 1);
		}
	}
	
	public void print_org_emftext_language_bibtex_InProceedingsEntry_1_0_16(org.emftext.language.bibtex.InProceedingsEntry element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("publisher");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__PUBLISHER));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("publisher", count - 1);
		}
	}
	
	public void print_org_emftext_language_bibtex_InProceedingsEntry_1_0_17(org.emftext.language.bibtex.InProceedingsEntry element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("note");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.IN_PROCEEDINGS_ENTRY__NOTE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("note", count - 1);
		}
	}
	
	
	public void print_org_emftext_language_bibtex_ArticleEntry(org.emftext.language.bibtex.ArticleEntry element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(16);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__BIBTEX_KEY));
		printCountingMap.put("bibtexKey", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__ABSTRACT));
		printCountingMap.put("abstract", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__URL));
		printCountingMap.put("url", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__KEYWORD));
		printCountingMap.put("keyword", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__REVIEW));
		printCountingMap.put("review", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__AUTHOR));
		printCountingMap.put("author", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__TITLE));
		printCountingMap.put("title", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__YEAR));
		printCountingMap.put("year", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__JOURNAL));
		printCountingMap.put("journal", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__PAGES));
		printCountingMap.put("pages", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__VOLUME));
		printCountingMap.put("volume", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__NUMBER));
		printCountingMap.put("number", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__MONTH));
		printCountingMap.put("month", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__NOTE));
		printCountingMap.put("note", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__PART));
		printCountingMap.put("part", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__EID));
		printCountingMap.put("eid", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_emftext_language_bibtex_ArticleEntry_0(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("bibtexKey");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__BIBTEX_KEY));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("bibtexKey", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_org_emftext_language_bibtex_ArticleEntry_1(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	public void print_org_emftext_language_bibtex_ArticleEntry_0(org.emftext.language.bibtex.ArticleEntry element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int alt = -1;
		alt = 0;
		int matches = 		0;
		int tempMatchCount;
		tempMatchCount = 		0;
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("@article");
				out.print(" ");
			}
			break;
			default:			// DEFINITION PART BEGINS (CsString)
			out.print("@ARTICLE");
			out.print(" ");
		}
	}
	
	public void print_org_emftext_language_bibtex_ArticleEntry_1(org.emftext.language.bibtex.ArticleEntry element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_emftext_language_bibtex_ArticleEntry_1_0(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
	}
	
	public void print_org_emftext_language_bibtex_ArticleEntry_1_0(org.emftext.language.bibtex.ArticleEntry element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int alt = -1;
		alt = 0;
		int matches = 		0;
		int tempMatchCount;
		tempMatchCount = 		0;
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		tempMatchCount = 		0;
		if (tempMatchCount > matches) {
			alt = 2;
			matches = tempMatchCount;
		}
		tempMatchCount = 		0;
		if (tempMatchCount > matches) {
			alt = 3;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"title"		));
		if (tempMatchCount > matches) {
			alt = 4;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"journal"		));
		if (tempMatchCount > matches) {
			alt = 5;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"volume"		));
		if (tempMatchCount > matches) {
			alt = 6;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"year"		));
		if (tempMatchCount > matches) {
			alt = 7;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"author"		));
		if (tempMatchCount > matches) {
			alt = 8;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"pages"		));
		if (tempMatchCount > matches) {
			alt = 9;
			matches = tempMatchCount;
		}
		tempMatchCount = 		0;
		if (tempMatchCount > matches) {
			alt = 10;
			matches = tempMatchCount;
		}
		tempMatchCount = 		0;
		if (tempMatchCount > matches) {
			alt = 11;
			matches = tempMatchCount;
		}
		tempMatchCount = 		0;
		if (tempMatchCount > matches) {
			alt = 12;
			matches = tempMatchCount;
		}
		tempMatchCount = 		0;
		if (tempMatchCount > matches) {
			alt = 13;
			matches = tempMatchCount;
		}
		tempMatchCount = 		0;
		if (tempMatchCount > matches) {
			alt = 14;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				java.io.StringWriter sWriter = null;
				java.io.PrintWriter out1 = null;
				java.util.Map<String, Integer> printCountingMap1 = null;
				// DEFINITION PART BEGINS (CompoundDefinition)
				sWriter = new java.io.StringWriter();
				out1 = new java.io.PrintWriter(sWriter);
				printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
				print_org_emftext_language_bibtex_ArticleEntry_1_0_1(element, localtab, out1, printCountingMap1);
				if (printCountingMap.equals(printCountingMap1)) {
					out1.close();
				} else {
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			break;
			case 2:			{
				java.io.StringWriter sWriter = null;
				java.io.PrintWriter out1 = null;
				java.util.Map<String, Integer> printCountingMap1 = null;
				// DEFINITION PART BEGINS (CompoundDefinition)
				sWriter = new java.io.StringWriter();
				out1 = new java.io.PrintWriter(sWriter);
				printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
				print_org_emftext_language_bibtex_ArticleEntry_1_0_2(element, localtab, out1, printCountingMap1);
				if (printCountingMap.equals(printCountingMap1)) {
					out1.close();
				} else {
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			break;
			case 3:			{
				java.io.StringWriter sWriter = null;
				java.io.PrintWriter out1 = null;
				java.util.Map<String, Integer> printCountingMap1 = null;
				// DEFINITION PART BEGINS (CompoundDefinition)
				sWriter = new java.io.StringWriter();
				out1 = new java.io.PrintWriter(sWriter);
				printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
				print_org_emftext_language_bibtex_ArticleEntry_1_0_3(element, localtab, out1, printCountingMap1);
				if (printCountingMap.equals(printCountingMap1)) {
					out1.close();
				} else {
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			break;
			case 4:			{
				// DEFINITION PART BEGINS (CompoundDefinition)
				print_org_emftext_language_bibtex_ArticleEntry_1_0_4(element, localtab, out, printCountingMap);
			}
			break;
			case 5:			{
				// DEFINITION PART BEGINS (CompoundDefinition)
				print_org_emftext_language_bibtex_ArticleEntry_1_0_5(element, localtab, out, printCountingMap);
			}
			break;
			case 6:			{
				// DEFINITION PART BEGINS (CompoundDefinition)
				print_org_emftext_language_bibtex_ArticleEntry_1_0_6(element, localtab, out, printCountingMap);
			}
			break;
			case 7:			{
				// DEFINITION PART BEGINS (CompoundDefinition)
				print_org_emftext_language_bibtex_ArticleEntry_1_0_7(element, localtab, out, printCountingMap);
			}
			break;
			case 8:			{
				// DEFINITION PART BEGINS (CompoundDefinition)
				print_org_emftext_language_bibtex_ArticleEntry_1_0_8(element, localtab, out, printCountingMap);
			}
			break;
			case 9:			{
				// DEFINITION PART BEGINS (CompoundDefinition)
				print_org_emftext_language_bibtex_ArticleEntry_1_0_9(element, localtab, out, printCountingMap);
			}
			break;
			case 10:			{
				java.io.StringWriter sWriter = null;
				java.io.PrintWriter out1 = null;
				java.util.Map<String, Integer> printCountingMap1 = null;
				// DEFINITION PART BEGINS (CompoundDefinition)
				sWriter = new java.io.StringWriter();
				out1 = new java.io.PrintWriter(sWriter);
				printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
				print_org_emftext_language_bibtex_ArticleEntry_1_0_10(element, localtab, out1, printCountingMap1);
				if (printCountingMap.equals(printCountingMap1)) {
					out1.close();
				} else {
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			break;
			case 11:			{
				java.io.StringWriter sWriter = null;
				java.io.PrintWriter out1 = null;
				java.util.Map<String, Integer> printCountingMap1 = null;
				// DEFINITION PART BEGINS (CompoundDefinition)
				sWriter = new java.io.StringWriter();
				out1 = new java.io.PrintWriter(sWriter);
				printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
				print_org_emftext_language_bibtex_ArticleEntry_1_0_11(element, localtab, out1, printCountingMap1);
				if (printCountingMap.equals(printCountingMap1)) {
					out1.close();
				} else {
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			break;
			case 12:			{
				java.io.StringWriter sWriter = null;
				java.io.PrintWriter out1 = null;
				java.util.Map<String, Integer> printCountingMap1 = null;
				// DEFINITION PART BEGINS (CompoundDefinition)
				sWriter = new java.io.StringWriter();
				out1 = new java.io.PrintWriter(sWriter);
				printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
				print_org_emftext_language_bibtex_ArticleEntry_1_0_12(element, localtab, out1, printCountingMap1);
				if (printCountingMap.equals(printCountingMap1)) {
					out1.close();
				} else {
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			break;
			case 13:			{
				java.io.StringWriter sWriter = null;
				java.io.PrintWriter out1 = null;
				java.util.Map<String, Integer> printCountingMap1 = null;
				// DEFINITION PART BEGINS (CompoundDefinition)
				sWriter = new java.io.StringWriter();
				out1 = new java.io.PrintWriter(sWriter);
				printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
				print_org_emftext_language_bibtex_ArticleEntry_1_0_13(element, localtab, out1, printCountingMap1);
				if (printCountingMap.equals(printCountingMap1)) {
					out1.close();
				} else {
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			break;
			case 14:			{
				java.io.StringWriter sWriter = null;
				java.io.PrintWriter out1 = null;
				java.util.Map<String, Integer> printCountingMap1 = null;
				// DEFINITION PART BEGINS (CompoundDefinition)
				sWriter = new java.io.StringWriter();
				out1 = new java.io.PrintWriter(sWriter);
				printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
				print_org_emftext_language_bibtex_ArticleEntry_1_0_14(element, localtab, out1, printCountingMap1);
				if (printCountingMap.equals(printCountingMap1)) {
					out1.close();
				} else {
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			break;
			default:			java.io.StringWriter sWriter = null;
			java.io.PrintWriter out1 = null;
			java.util.Map<String, Integer> printCountingMap1 = null;
			// DEFINITION PART BEGINS (CompoundDefinition)
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_org_emftext_language_bibtex_ArticleEntry_1_0_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
	}
	
	public void print_org_emftext_language_bibtex_ArticleEntry_1_0_0(org.emftext.language.bibtex.ArticleEntry element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("url");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__URL));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("url", count - 1);
		}
	}
	
	public void print_org_emftext_language_bibtex_ArticleEntry_1_0_1(org.emftext.language.bibtex.ArticleEntry element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("abstract");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__ABSTRACT));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("abstract", count - 1);
		}
	}
	
	public void print_org_emftext_language_bibtex_ArticleEntry_1_0_2(org.emftext.language.bibtex.ArticleEntry element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("keyword");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__KEYWORD));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("keyword", count - 1);
		}
	}
	
	public void print_org_emftext_language_bibtex_ArticleEntry_1_0_3(org.emftext.language.bibtex.ArticleEntry element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("review");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__REVIEW));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("review", count - 1);
		}
	}
	
	public void print_org_emftext_language_bibtex_ArticleEntry_1_0_4(org.emftext.language.bibtex.ArticleEntry element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("title");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__TITLE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("title", count - 1);
		}
	}
	
	public void print_org_emftext_language_bibtex_ArticleEntry_1_0_5(org.emftext.language.bibtex.ArticleEntry element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("journal");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__JOURNAL));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("journal", count - 1);
		}
	}
	
	public void print_org_emftext_language_bibtex_ArticleEntry_1_0_6(org.emftext.language.bibtex.ArticleEntry element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("volume");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__VOLUME));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("volume", count - 1);
		}
	}
	
	public void print_org_emftext_language_bibtex_ArticleEntry_1_0_7(org.emftext.language.bibtex.ArticleEntry element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("year");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__YEAR));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("year", count - 1);
		}
	}
	
	public void print_org_emftext_language_bibtex_ArticleEntry_1_0_8(org.emftext.language.bibtex.ArticleEntry element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("author");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__AUTHOR));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("author", count - 1);
		}
	}
	
	public void print_org_emftext_language_bibtex_ArticleEntry_1_0_9(org.emftext.language.bibtex.ArticleEntry element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("pages");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__PAGES));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("pages", count - 1);
		}
	}
	
	public void print_org_emftext_language_bibtex_ArticleEntry_1_0_10(org.emftext.language.bibtex.ArticleEntry element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("number");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__NUMBER));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("number", count - 1);
		}
	}
	
	public void print_org_emftext_language_bibtex_ArticleEntry_1_0_11(org.emftext.language.bibtex.ArticleEntry element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("month");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__MONTH));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("month", count - 1);
		}
	}
	
	public void print_org_emftext_language_bibtex_ArticleEntry_1_0_12(org.emftext.language.bibtex.ArticleEntry element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("part");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__PART));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("part", count - 1);
		}
	}
	
	public void print_org_emftext_language_bibtex_ArticleEntry_1_0_13(org.emftext.language.bibtex.ArticleEntry element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("eid");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__EID));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("eid", count - 1);
		}
	}
	
	public void print_org_emftext_language_bibtex_ArticleEntry_1_0_14(org.emftext.language.bibtex.ArticleEntry element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("note");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.bibtex.BibtexPackage.ARTICLE_ENTRY__NOTE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("note", count - 1);
		}
	}
	
	
}
