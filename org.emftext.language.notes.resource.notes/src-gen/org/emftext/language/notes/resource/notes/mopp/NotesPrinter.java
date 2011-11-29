/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.notes.resource.notes.mopp;

public class NotesPrinter implements org.emftext.language.notes.resource.notes.INotesTextPrinter {
	
	protected org.emftext.language.notes.resource.notes.INotesTokenResolverFactory tokenResolverFactory = new org.emftext.language.notes.resource.notes.mopp.NotesTokenResolverFactory();
	
	protected java.io.OutputStream outputStream;
	
	/**
	 * Holds the resource that is associated with this printer. This may be null if
	 * the printer is used stand alone.
	 */
	private org.emftext.language.notes.resource.notes.INotesTextResource resource;
	
	private java.util.Map<?, ?> options;
	
	public NotesPrinter(java.io.OutputStream outputStream, org.emftext.language.notes.resource.notes.INotesTextResource resource) {
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
		
		if (element instanceof org.emftext.language.notes.NoteDocument) {
			print_org_emftext_language_notes_NoteDocument((org.emftext.language.notes.NoteDocument) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.notes.Section) {
			print_org_emftext_language_notes_Section((org.emftext.language.notes.Section) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.notes.BulletPoint) {
			print_org_emftext_language_notes_BulletPoint((org.emftext.language.notes.BulletPoint) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.notes.SimpleText) {
			print_org_emftext_language_notes_SimpleText((org.emftext.language.notes.SimpleText) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.notes.Bold) {
			print_org_emftext_language_notes_Bold((org.emftext.language.notes.Bold) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.notes.Italic) {
			print_org_emftext_language_notes_Italic((org.emftext.language.notes.Italic) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.notes.TypeWriter) {
			print_org_emftext_language_notes_TypeWriter((org.emftext.language.notes.TypeWriter) element, globaltab, out);
			return;
		}
		
		addWarningToResource("The printer can not handle " + element.eClass().getName() + " elements", element);
	}
	
	protected org.emftext.language.notes.resource.notes.mopp.NotesReferenceResolverSwitch getReferenceResolverSwitch() {
		return (org.emftext.language.notes.resource.notes.mopp.NotesReferenceResolverSwitch) new org.emftext.language.notes.resource.notes.mopp.NotesMetaInformation().getReferenceResolverSwitch();
	}
	
	protected void addWarningToResource(final String errorMessage, org.eclipse.emf.ecore.EObject cause) {
		org.emftext.language.notes.resource.notes.INotesTextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the printer is used stand alone
			return;
		}
		resource.addProblem(new org.emftext.language.notes.resource.notes.mopp.NotesProblem(errorMessage, org.emftext.language.notes.resource.notes.NotesEProblemType.PRINT_PROBLEM, org.emftext.language.notes.resource.notes.NotesEProblemSeverity.WARNING), cause);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		this.options = options;
	}
	
	public java.util.Map<?,?> getOptions() {
		return options;
	}
	
	public org.emftext.language.notes.resource.notes.INotesTextResource getResource() {
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
	
	public void print_org_emftext_language_notes_NoteDocument(org.emftext.language.notes.NoteDocument element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.NOTE_DOCUMENT__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.NOTE_DOCUMENT__PARTS));
		printCountingMap.put("parts", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.NOTE_DOCUMENT__NAME));
			if (o != null) {
				org.emftext.language.notes.resource.notes.INotesTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.NOTE_DOCUMENT__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("parts");
		if (count > 0) {
			java.util.List<?> list = (java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.NOTE_DOCUMENT__PARTS));
			int index  = list.size() - count;
			if (index < 0) {
				index = 0;
			}
			java.util.ListIterator<?> it  = list.listIterator(index);
			while (it.hasNext()) {
				Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("parts", 0);
		}
	}
	
	
	public void print_org_emftext_language_notes_Section(org.emftext.language.notes.Section element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(4);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.SECTION__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.SECTION__ID));
		printCountingMap.put("id", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.SECTION__SUPER_SECTION));
		printCountingMap.put("superSection", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.SECTION__BULLETS));
		printCountingMap.put("bullets", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("=");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.SECTION__NAME));
			if (o != null) {
				org.emftext.language.notes.resource.notes.INotesTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.SECTION__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("id");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.SECTION__ID));
			if (o != null) {
				org.emftext.language.notes.resource.notes.INotesTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_91_93");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.SECTION__ID), element));
				out.print(" ");
			}
			printCountingMap.put("id", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_org_emftext_language_notes_Section_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("=");
		out.print(" ");
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("bullets");
		if (count > 0) {
			java.util.List<?> list = (java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.SECTION__BULLETS));
			int index  = list.size() - count;
			if (index < 0) {
				index = 0;
			}
			java.util.ListIterator<?> it  = list.listIterator(index);
			while (it.hasNext()) {
				Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("bullets", 0);
		}
	}
	
	public void print_org_emftext_language_notes_Section_0(org.emftext.language.notes.Section element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(">");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("superSection");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.SECTION__SUPER_SECTION));
			if (o != null) {
				org.emftext.language.notes.resource.notes.INotesTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_91_93");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSectionSuperSectionReferenceResolver().deResolve((org.emftext.language.notes.Section) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.SECTION__SUPER_SECTION)), element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.SECTION__SUPER_SECTION), element));
				out.print(" ");
			}
			printCountingMap.put("superSection", count - 1);
		}
	}
	
	
	public void print_org_emftext_language_notes_BulletPoint(org.emftext.language.notes.BulletPoint element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.BULLET_POINT__TEXT_PARTS));
		printCountingMap.put("textParts", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.BULLET_POINT__SUB_POINTS));
		printCountingMap.put("subPoints", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("*");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("textParts");
		if (count > 0) {
			java.util.List<?> list = (java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.BULLET_POINT__TEXT_PARTS));
			int index  = list.size() - count;
			if (index < 0) {
				index = 0;
			}
			java.util.ListIterator<?> it  = list.listIterator(index);
			while (it.hasNext()) {
				Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("textParts", 0);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_org_emftext_language_notes_BulletPoint_0(element, localtab, out1, printCountingMap1);
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
	}
	
	public void print_org_emftext_language_notes_BulletPoint_0(org.emftext.language.notes.BulletPoint element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print(" ");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("subPoints");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.BULLET_POINT__SUB_POINTS));
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
			printCountingMap.put("subPoints", count - 1);
		}
	}
	
	
	public void print_org_emftext_language_notes_SimpleText(org.emftext.language.notes.SimpleText element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.SIMPLE_TEXT__TEXT));
		printCountingMap.put("text", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("text");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.SIMPLE_TEXT__TEXT));
			if (o != null) {
				org.emftext.language.notes.resource.notes.INotesTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.SIMPLE_TEXT__TEXT), element));
				out.print(" ");
			}
			printCountingMap.put("text", count - 1);
		}
	}
	
	
	public void print_org_emftext_language_notes_Bold(org.emftext.language.notes.Bold element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.BOLD__TEXT));
		printCountingMap.put("text", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("text");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.BOLD__TEXT));
			if (o != null) {
				org.emftext.language.notes.resource.notes.INotesTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_95_95");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.BOLD__TEXT), element));
				out.print(" ");
			}
			printCountingMap.put("text", count - 1);
		}
	}
	
	
	public void print_org_emftext_language_notes_Italic(org.emftext.language.notes.Italic element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.ITALIC__TEXT));
		printCountingMap.put("text", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("text");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.ITALIC__TEXT));
			if (o != null) {
				org.emftext.language.notes.resource.notes.INotesTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_35_35");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.ITALIC__TEXT), element));
				out.print(" ");
			}
			printCountingMap.put("text", count - 1);
		}
	}
	
	
	public void print_org_emftext_language_notes_TypeWriter(org.emftext.language.notes.TypeWriter element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.TYPE_WRITER__TEXT));
		printCountingMap.put("text", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("text");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.TYPE_WRITER__TEXT));
			if (o != null) {
				org.emftext.language.notes.resource.notes.INotesTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_64_64");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.language.notes.NotesPackage.TYPE_WRITER__TEXT), element));
				out.print(" ");
			}
			printCountingMap.put("text", count - 1);
		}
	}
	
	
}
