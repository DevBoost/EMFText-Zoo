package org.emftext.language.sparql.resource.sparql;

public abstract class SparqlPrinterBase extends org.emftext.runtime.resource.impl.AbstractEMFTextPrinter {
	
	protected final static java.lang.String NEW_LINE = java.lang.System.getProperties().getProperty("line.separator");
	protected org.emftext.runtime.resource.ITokenResolverFactory tokenResolverFactory = new org.emftext.language.sparql.resource.sparql.SparqlTokenResolverFactory();
	protected java.io.OutputStream outputStream;
	/** Holds the resource that is associated with this printer. may be null if the printer is used stand alone. */
	private org.emftext.runtime.resource.ITextResource resource;
	private java.util.Map<?, ?> options;
	
	public SparqlPrinterBase(java.io.OutputStream outputStream, org.emftext.runtime.resource.ITextResource resource) {
		super();
		this.outputStream = outputStream;
		this.resource = resource;
	}
	
	protected static int matchCount(java.util.Map<java.lang.String, java.lang.Integer> featureCounter, java.util.Collection<java.lang.String> needed){
		int pos = 0;
		int neg = 0;
		
		for(java.lang.String featureName:featureCounter.keySet()){
			if(needed.contains(featureName)){
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
	
	protected void doPrint(org.eclipse.emf.ecore.EObject element, java.io.PrintWriter out, java.lang.String globaltab) {
		if (element == null || out == null) throw new java.lang.NullPointerException("Nothing to write or to write on.");
		
		if (element instanceof org.emftext.language.sparql.SparqlQueries) {
			print_org_emftext_language_sparql_SparqlQueries((org.emftext.language.sparql.SparqlQueries) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.sparql.Prologue) {
			print_org_emftext_language_sparql_Prologue((org.emftext.language.sparql.Prologue) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.sparql.BaseDecl) {
			print_org_emftext_language_sparql_BaseDecl((org.emftext.language.sparql.BaseDecl) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.sparql.PrefixDecl) {
			print_org_emftext_language_sparql_PrefixDecl((org.emftext.language.sparql.PrefixDecl) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.sparql.IRI_REF_STRING) {
			print_org_emftext_language_sparql_IRI_005fREF_005fSTRING((org.emftext.language.sparql.IRI_REF_STRING) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.sparql.PNAME_NS) {
			print_org_emftext_language_sparql_PNAME_005fNS((org.emftext.language.sparql.PNAME_NS) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.sparql.INTEGER) {
			print_org_emftext_language_sparql_INTEGER((org.emftext.language.sparql.INTEGER) element, globaltab, out);
			return;
		}
		
		addWarningToResource("The cs printer can not handle " + element.eClass().getName() + " elements", element);
	}
	
	protected org.emftext.language.sparql.resource.sparql.SparqlReferenceResolverSwitch getReferenceResolverSwitch() {
		org.emftext.runtime.resource.ITextResource resource = getResource();
		if (resource == null) {
			return null;
		}
		return (org.emftext.language.sparql.resource.sparql.SparqlReferenceResolverSwitch) resource.getMetaInformation().getReferenceResolverSwitch();
	}
	
	protected void addWarningToResource(final java.lang.String errorMessage, org.eclipse.emf.ecore.EObject cause) {
		org.emftext.runtime.resource.ITextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the printer is used stand alone
			return;
		}
		resource.addProblem(new org.emftext.language.sparql.resource.sparql.SparqlProblem(errorMessage, org.emftext.runtime.resource.EProblemType.ERROR), cause);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		this.options = options;
	}
	
	public java.util.Map<?,?> getOptions() {
		return options;
	}
	
	public org.emftext.runtime.resource.ITextResource getResource() {
		return resource;
	}
	
	/** Calls {@link #doPrint(EObject, String)} and writes the result to the underlying output stream. */
	public void print(org.eclipse.emf.ecore.EObject element)  {
		java.io.PrintWriter out = new java.io.PrintWriter(new java.io.BufferedOutputStream(outputStream));
		doPrint(element,out,"");
		out.flush();
		out.close();
	}
	
	public void print_org_emftext_language_sparql_SparqlQueries(org.emftext.language.sparql.SparqlQueries element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(5);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.SPARQL_QUERIES__LOCATION));
		printCountingMap.put("location", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.SPARQL_QUERIES__COMMENTS_BEFORE));
		printCountingMap.put("commentsBefore", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.SPARQL_QUERIES__COMMENTS_AFTER));
		printCountingMap.put("commentsAfter", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.SPARQL_QUERIES__PROLOGUE));
		printCountingMap.put("prologue", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.SPARQL_QUERIES__QUERY));
		printCountingMap.put("query", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("prologue");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.SPARQL_QUERIES__PROLOGUE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("prologue", count - 1);
		}
	}
	
	public void print_org_emftext_language_sparql_Prologue(org.emftext.language.sparql.Prologue element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(5);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.PROLOGUE__LOCATION));
		printCountingMap.put("location", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.PROLOGUE__COMMENTS_BEFORE));
		printCountingMap.put("commentsBefore", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.PROLOGUE__COMMENTS_AFTER));
		printCountingMap.put("commentsAfter", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.PROLOGUE__BASEDECLARATION));
		printCountingMap.put("basedeclaration", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.PROLOGUE__PREFIXDECLARATION));
		printCountingMap.put("prefixdeclaration", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("basedeclaration");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.PROLOGUE__BASEDECLARATION));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("basedeclaration", count - 1);
		}
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("prefixdeclaration");
		if (count > 0) {
			java.util.List<?> list = (java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.PROLOGUE__PREFIXDECLARATION));
			int index  = list.size() - count;
			if (index < 0) {
				index = 0;
			}
			java.util.ListIterator<?> it  = list.listIterator(index);
			while (it.hasNext()) {
				java.lang.Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("prefixdeclaration",0);
		}
	}
	
	public void print_org_emftext_language_sparql_BaseDecl(org.emftext.language.sparql.BaseDecl element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(4);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.BASE_DECL__LOCATION));
		printCountingMap.put("location", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.BASE_DECL__COMMENTS_BEFORE));
		printCountingMap.put("commentsBefore", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.BASE_DECL__COMMENTS_AFTER));
		printCountingMap.put("commentsAfter", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.BASE_DECL__IRIREF));
		printCountingMap.put("iriref", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("BASE");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("iriref");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.BASE_DECL__IRIREF));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("iriref", count - 1);
		}
	}
	
	public void print_org_emftext_language_sparql_PrefixDecl(org.emftext.language.sparql.PrefixDecl element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(5);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.PREFIX_DECL__LOCATION));
		printCountingMap.put("location", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.PREFIX_DECL__COMMENTS_BEFORE));
		printCountingMap.put("commentsBefore", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.PREFIX_DECL__COMMENTS_AFTER));
		printCountingMap.put("commentsAfter", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.PREFIX_DECL__PNAMENS));
		printCountingMap.put("pnamens", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.PREFIX_DECL__IRIREF));
		printCountingMap.put("iriref", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("PREFIX");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("iriref");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.PREFIX_DECL__IRIREF));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("iriref", count - 1);
		}
	}
	
	public void print_org_emftext_language_sparql_IRI_005fREF_005fSTRING(org.emftext.language.sparql.IRI_REF_STRING element, java.lang.String outertab, java.io.PrintWriter out) {
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(4);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.IRI_REF_STRING__LOCATION));
		printCountingMap.put("location", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.IRI_REF_STRING__COMMENTS_BEFORE));
		printCountingMap.put("commentsBefore", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.IRI_REF_STRING__COMMENTS_AFTER));
		printCountingMap.put("commentsAfter", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.IRI_REF_STRING__IRI_REF));
		printCountingMap.put("iri_ref", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken):
		count = printCountingMap.get("iri_ref");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.IRI_REF_STRING__IRI_REF));
			if (o != null) {
				org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("DEF_IRI_REF");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.IRI_REF_STRING__IRI_REF), element));
				out.print(" ");
			}
			printCountingMap.put("iri_ref", count - 1);
		}
	}
	
	public void print_org_emftext_language_sparql_PNAME_005fNS(org.emftext.language.sparql.PNAME_NS element, java.lang.String outertab, java.io.PrintWriter out) {
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(4);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.PNAME_NS__LOCATION));
		printCountingMap.put("location", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.PNAME_NS__COMMENTS_BEFORE));
		printCountingMap.put("commentsBefore", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.PNAME_NS__COMMENTS_AFTER));
		printCountingMap.put("commentsAfter", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.PNAME_NS__PN_PREFIX));
		printCountingMap.put("pn_prefix", temp == null ? 0 : 1);
		// print collected hidden tokens
		//////////////DEFINITION PART BEGINS (CsString):
		out.print(":");
		out.print(" ");
	}
	
	public void print_org_emftext_language_sparql_INTEGER(org.emftext.language.sparql.INTEGER element, java.lang.String outertab, java.io.PrintWriter out) {
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(4);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.INTEGER__LOCATION));
		printCountingMap.put("location", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.INTEGER__COMMENTS_BEFORE));
		printCountingMap.put("commentsBefore", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.INTEGER__COMMENTS_AFTER));
		printCountingMap.put("commentsAfter", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.INTEGER__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken):
		count = printCountingMap.get("value");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.INTEGER__VALUE));
			if (o != null) {
				org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("DEF_INTEGER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.sparql.SparqlPackage.INTEGER__VALUE), element));
				out.print(" ");
			}
			printCountingMap.put("value", count - 1);
		}
	}
	
}
