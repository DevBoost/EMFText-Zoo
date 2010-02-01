/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.pl0.resource.pl0.mopp;

public class Pl0Printer implements org.emftext.language.pl0.resource.pl0.IPl0TextPrinter {
	
	protected final static java.lang.String NEW_LINE = java.lang.System.getProperties().getProperty("line.separator");
	protected org.emftext.language.pl0.resource.pl0.IPl0TokenResolverFactory tokenResolverFactory = new org.emftext.language.pl0.resource.pl0.mopp.Pl0TokenResolverFactory();
	protected java.io.OutputStream outputStream;
	/** Holds the resource that is associated with this printer. may be null if the printer is used stand alone. */
	private org.emftext.language.pl0.resource.pl0.IPl0TextResource resource;
	private java.util.Map<?, ?> options;
	
	public Pl0Printer(java.io.OutputStream outputStream, org.emftext.language.pl0.resource.pl0.IPl0TextResource resource) {
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
		if (element == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write.");
		}
		if (out == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write on.");
		}
		
		if (element instanceof org.emftext.language.pl0.Program) {
			print_org_emftext_language_pl0_Program((org.emftext.language.pl0.Program) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.pl0.Block) {
			print_org_emftext_language_pl0_Block((org.emftext.language.pl0.Block) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.pl0.ConstDeclaration) {
			print_org_emftext_language_pl0_ConstDeclaration((org.emftext.language.pl0.ConstDeclaration) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.pl0.VarDeclaration) {
			print_org_emftext_language_pl0_VarDeclaration((org.emftext.language.pl0.VarDeclaration) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.pl0.ProcedureDeclaration) {
			print_org_emftext_language_pl0_ProcedureDeclaration((org.emftext.language.pl0.ProcedureDeclaration) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.pl0.Body) {
			print_org_emftext_language_pl0_Body((org.emftext.language.pl0.Body) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.pl0.CallStatement) {
			print_org_emftext_language_pl0_CallStatement((org.emftext.language.pl0.CallStatement) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.pl0.WhileStatement) {
			print_org_emftext_language_pl0_WhileStatement((org.emftext.language.pl0.WhileStatement) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.pl0.IfStatement) {
			print_org_emftext_language_pl0_IfStatement((org.emftext.language.pl0.IfStatement) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.pl0.OddCondition) {
			print_org_emftext_language_pl0_OddCondition((org.emftext.language.pl0.OddCondition) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.pl0.RelationalCondition) {
			print_org_emftext_language_pl0_RelationalCondition((org.emftext.language.pl0.RelationalCondition) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.pl0.Assignment) {
			print_org_emftext_language_pl0_Assignment((org.emftext.language.pl0.Assignment) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.pl0.TermExpression) {
			print_org_emftext_language_pl0_TermExpression((org.emftext.language.pl0.TermExpression) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.pl0.OptionalTerm) {
			print_org_emftext_language_pl0_OptionalTerm((org.emftext.language.pl0.OptionalTerm) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.pl0.Term) {
			print_org_emftext_language_pl0_Term((org.emftext.language.pl0.Term) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.pl0.OptionalFactor) {
			print_org_emftext_language_pl0_OptionalFactor((org.emftext.language.pl0.OptionalFactor) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.pl0.IdentReference) {
			print_org_emftext_language_pl0_IdentReference((org.emftext.language.pl0.IdentReference) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.pl0.Number) {
			print_org_emftext_language_pl0_Number((org.emftext.language.pl0.Number) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.pl0.ExpressionFactor) {
			print_org_emftext_language_pl0_ExpressionFactor((org.emftext.language.pl0.ExpressionFactor) element, globaltab, out);
			return;
		}
		
		addWarningToResource("The cs printer can not handle " + element.eClass().getName() + " elements", element);
	}
	
	protected org.emftext.language.pl0.resource.pl0.mopp.Pl0ReferenceResolverSwitch getReferenceResolverSwitch() {
		return (org.emftext.language.pl0.resource.pl0.mopp.Pl0ReferenceResolverSwitch) new org.emftext.language.pl0.resource.pl0.mopp.Pl0MetaInformation().getReferenceResolverSwitch();
	}
	
	protected void addWarningToResource(final java.lang.String errorMessage, org.eclipse.emf.ecore.EObject cause) {
		org.emftext.language.pl0.resource.pl0.IPl0TextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the printer is used stand alone
			return;
		}
		resource.addProblem(new org.emftext.language.pl0.resource.pl0.mopp.Pl0Problem(errorMessage, org.emftext.language.pl0.resource.pl0.Pl0EProblemType.ERROR), cause);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		this.options = options;
	}
	
	public java.util.Map<?,?> getOptions() {
		return options;
	}
	
	public org.emftext.language.pl0.resource.pl0.IPl0TextResource getResource() {
		return resource;
	}
	
	/** Calls {@link #doPrint(EObject, String)} and writes the result to the underlying output stream. */
	public void print(org.eclipse.emf.ecore.EObject element)  {
		java.io.PrintWriter out = new java.io.PrintWriter(new java.io.BufferedOutputStream(outputStream));
		doPrint(element, out, "");
		out.flush();
		out.close();
	}
	
	public void print_org_emftext_language_pl0_Program(org.emftext.language.pl0.Program element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.PROGRAM__BLOCK));
		printCountingMap.put("block", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.PROGRAM__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_emftext_language_pl0_Program_0(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.PROGRAM__NAME));
			if (o != null) {
				org.emftext.language.pl0.resource.pl0.IPl0TokenResolver resolver = tokenResolverFactory.createTokenResolver("PL0ID");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.PROGRAM__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("block");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.PROGRAM__BLOCK));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("block", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(".");
		out.print(" ");
	}
	public void print_org_emftext_language_pl0_Program_0(org.emftext.language.pl0.Program element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		int alt = -1;
		alt=0;
		int matches=		0;
		int tempMatchCount;
		tempMatchCount=		0;
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("PROGRAM");
				out.print(" ");
			}
			break;
			default:			// DEFINITION PART BEGINS (CsString)
			out.print("program");
			out.print(" ");
		}
	}
	
	public void print_org_emftext_language_pl0_Block(org.emftext.language.pl0.Block element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(4);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.BLOCK__VARIABLES));
		printCountingMap.put("variables", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.BLOCK__CONSTANTS));
		printCountingMap.put("constants", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.BLOCK__PROCEDURES));
		printCountingMap.put("procedures", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.BLOCK__BODY));
		printCountingMap.put("body", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_language_pl0_Block_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_language_pl0_Block_1(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("procedures");
		if (count > 0) {
			java.util.List<?> list = (java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.BLOCK__PROCEDURES));
			int index  = list.size() - count;
			if (index < 0) {
				index = 0;
			}
			java.util.ListIterator<?> it  = list.listIterator(index);
			while (it.hasNext()) {
				java.lang.Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("procedures", 0);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("body");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.BLOCK__BODY));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("body", count - 1);
		}
	}
	public void print_org_emftext_language_pl0_Block_0(org.emftext.language.pl0.Block element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_emftext_language_pl0_Block_0_0(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("constants");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.BLOCK__CONSTANTS));
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
			printCountingMap.put("constants", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			print_org_emftext_language_pl0_Block_0_1(element, localtab, out1, printCountingMap1);
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
		out.print(";");
		out.print(" ");
	}
	public void print_org_emftext_language_pl0_Block_0_0(org.emftext.language.pl0.Block element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		int alt = -1;
		alt=0;
		int matches=		0;
		int tempMatchCount;
		tempMatchCount=		0;
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("CONST");
				out.print(" ");
			}
			break;
			default:			// DEFINITION PART BEGINS (CsString)
			out.print("const");
			out.print(" ");
		}
	}
	public void print_org_emftext_language_pl0_Block_0_1(org.emftext.language.pl0.Block element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("constants");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.BLOCK__CONSTANTS));
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
			printCountingMap.put("constants", count - 1);
		}
	}
	public void print_org_emftext_language_pl0_Block_1(org.emftext.language.pl0.Block element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_emftext_language_pl0_Block_1_0(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("variables");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.BLOCK__VARIABLES));
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
			printCountingMap.put("variables", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			print_org_emftext_language_pl0_Block_1_1(element, localtab, out1, printCountingMap1);
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
		out.print(";");
		out.print(" ");
	}
	public void print_org_emftext_language_pl0_Block_1_0(org.emftext.language.pl0.Block element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		int alt = -1;
		alt=0;
		int matches=		0;
		int tempMatchCount;
		tempMatchCount=		0;
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("VAR");
				out.print(" ");
			}
			break;
			default:			// DEFINITION PART BEGINS (CsString)
			out.print("var");
			out.print(" ");
		}
	}
	public void print_org_emftext_language_pl0_Block_1_1(org.emftext.language.pl0.Block element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("variables");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.BLOCK__VARIABLES));
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
			printCountingMap.put("variables", count - 1);
		}
	}
	
	public void print_org_emftext_language_pl0_ConstDeclaration(org.emftext.language.pl0.ConstDeclaration element, java.lang.String outertab, java.io.PrintWriter out) {
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.CONST_DECLARATION__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.CONST_DECLARATION__NUMBER));
		printCountingMap.put("number", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.CONST_DECLARATION__NAME));
			if (o != null) {
				org.emftext.language.pl0.resource.pl0.IPl0TokenResolver resolver = tokenResolverFactory.createTokenResolver("PL0ID");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.CONST_DECLARATION__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("=");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("number");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.CONST_DECLARATION__NUMBER));
			if (o != null) {
				org.emftext.language.pl0.resource.pl0.IPl0TokenResolver resolver = tokenResolverFactory.createTokenResolver("NUMBER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.CONST_DECLARATION__NUMBER), element));
				out.print(" ");
			}
			printCountingMap.put("number", count - 1);
		}
	}
	
	public void print_org_emftext_language_pl0_VarDeclaration(org.emftext.language.pl0.VarDeclaration element, java.lang.String outertab, java.io.PrintWriter out) {
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.VAR_DECLARATION__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.VAR_DECLARATION__NAME));
			if (o != null) {
				org.emftext.language.pl0.resource.pl0.IPl0TokenResolver resolver = tokenResolverFactory.createTokenResolver("PL0ID");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.VAR_DECLARATION__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
	}
	
	public void print_org_emftext_language_pl0_ProcedureDeclaration(org.emftext.language.pl0.ProcedureDeclaration element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.PROCEDURE_DECLARATION__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.PROCEDURE_DECLARATION__BLOCK));
		printCountingMap.put("block", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_emftext_language_pl0_ProcedureDeclaration_0(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.PROCEDURE_DECLARATION__NAME));
			if (o != null) {
				org.emftext.language.pl0.resource.pl0.IPl0TokenResolver resolver = tokenResolverFactory.createTokenResolver("PL0ID");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.PROCEDURE_DECLARATION__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(";");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("block");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.PROCEDURE_DECLARATION__BLOCK));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("block", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(";");
		out.print(" ");
	}
	public void print_org_emftext_language_pl0_ProcedureDeclaration_0(org.emftext.language.pl0.ProcedureDeclaration element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		int alt = -1;
		alt=0;
		int matches=		0;
		int tempMatchCount;
		tempMatchCount=		0;
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("PROCEDURE");
				out.print(" ");
			}
			break;
			default:			// DEFINITION PART BEGINS (CsString)
			out.print("procedure");
			out.print(" ");
		}
	}
	
	public void print_org_emftext_language_pl0_Body(org.emftext.language.pl0.Body element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.BODY__STATEMENTS));
		printCountingMap.put("statements", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_emftext_language_pl0_Body_0(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_language_pl0_Body_1(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_emftext_language_pl0_Body_2(element, localtab, out, printCountingMap);
	}
	public void print_org_emftext_language_pl0_Body_0(org.emftext.language.pl0.Body element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		int alt = -1;
		alt=0;
		int matches=		0;
		int tempMatchCount;
		tempMatchCount=		0;
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("BEGIN");
				out.print(" ");
			}
			break;
			default:			// DEFINITION PART BEGINS (CsString)
			out.print("begin");
			out.print(" ");
		}
	}
	public void print_org_emftext_language_pl0_Body_1(org.emftext.language.pl0.Body element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("statements");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.BODY__STATEMENTS));
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
			printCountingMap.put("statements", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			print_org_emftext_language_pl0_Body_1_0(element, localtab, out1, printCountingMap1);
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
	public void print_org_emftext_language_pl0_Body_1_0(org.emftext.language.pl0.Body element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(";");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("statements");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.BODY__STATEMENTS));
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
			printCountingMap.put("statements", count - 1);
		}
	}
	public void print_org_emftext_language_pl0_Body_2(org.emftext.language.pl0.Body element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		int alt = -1;
		alt=0;
		int matches=		0;
		int tempMatchCount;
		tempMatchCount=		0;
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("END");
				out.print(" ");
			}
			break;
			default:			// DEFINITION PART BEGINS (CsString)
			out.print("end");
			out.print(" ");
		}
	}
	
	public void print_org_emftext_language_pl0_CallStatement(org.emftext.language.pl0.CallStatement element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.CALL_STATEMENT__PROCEDURE));
		printCountingMap.put("procedure", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_emftext_language_pl0_CallStatement_0(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("procedure");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.CALL_STATEMENT__PROCEDURE));
			if (o != null) {
				org.emftext.language.pl0.resource.pl0.IPl0TokenResolver resolver = tokenResolverFactory.createTokenResolver("PL0ID");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getCallStatementProcedureReferenceResolver().deResolve((org.emftext.language.pl0.ProcedureDeclaration) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.CALL_STATEMENT__PROCEDURE)), element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.CALL_STATEMENT__PROCEDURE), element));
				out.print(" ");
			}
			printCountingMap.put("procedure", count - 1);
		}
	}
	public void print_org_emftext_language_pl0_CallStatement_0(org.emftext.language.pl0.CallStatement element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		int alt = -1;
		alt=0;
		int matches=		0;
		int tempMatchCount;
		tempMatchCount=		0;
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("CALL");
				out.print(" ");
			}
			break;
			default:			// DEFINITION PART BEGINS (CsString)
			out.print("call");
			out.print(" ");
		}
	}
	
	public void print_org_emftext_language_pl0_WhileStatement(org.emftext.language.pl0.WhileStatement element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.WHILE_STATEMENT__CONDITION));
		printCountingMap.put("condition", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.WHILE_STATEMENT__DO));
		printCountingMap.put("do", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_emftext_language_pl0_WhileStatement_0(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("condition");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.WHILE_STATEMENT__CONDITION));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("condition", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_emftext_language_pl0_WhileStatement_1(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("do");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.WHILE_STATEMENT__DO));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("do", count - 1);
		}
	}
	public void print_org_emftext_language_pl0_WhileStatement_0(org.emftext.language.pl0.WhileStatement element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		int alt = -1;
		alt=0;
		int matches=		0;
		int tempMatchCount;
		tempMatchCount=		0;
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("WHILE");
				out.print(" ");
			}
			break;
			default:			// DEFINITION PART BEGINS (CsString)
			out.print("while");
			out.print(" ");
		}
	}
	public void print_org_emftext_language_pl0_WhileStatement_1(org.emftext.language.pl0.WhileStatement element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		int alt = -1;
		alt=0;
		int matches=		0;
		int tempMatchCount;
		tempMatchCount=		0;
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("do");
				out.print(" ");
			}
			break;
			default:			// DEFINITION PART BEGINS (CsString)
			out.print("DO");
			out.print(" ");
		}
	}
	
	public void print_org_emftext_language_pl0_IfStatement(org.emftext.language.pl0.IfStatement element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(3);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.IF_STATEMENT__CONDITION));
		printCountingMap.put("condition", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.IF_STATEMENT__THEN));
		printCountingMap.put("then", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.IF_STATEMENT__ELSE));
		printCountingMap.put("else", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_emftext_language_pl0_IfStatement_0(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("condition");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.IF_STATEMENT__CONDITION));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("condition", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_emftext_language_pl0_IfStatement_1(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("then");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.IF_STATEMENT__THEN));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("then", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_language_pl0_IfStatement_2(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	public void print_org_emftext_language_pl0_IfStatement_0(org.emftext.language.pl0.IfStatement element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		int alt = -1;
		alt=0;
		int matches=		0;
		int tempMatchCount;
		tempMatchCount=		0;
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("IF");
				out.print(" ");
			}
			break;
			default:			// DEFINITION PART BEGINS (CsString)
			out.print("if");
			out.print(" ");
		}
	}
	public void print_org_emftext_language_pl0_IfStatement_1(org.emftext.language.pl0.IfStatement element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		int alt = -1;
		alt=0;
		int matches=		0;
		int tempMatchCount;
		tempMatchCount=		0;
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("THEN");
				out.print(" ");
			}
			break;
			default:			// DEFINITION PART BEGINS (CsString)
			out.print("then");
			out.print(" ");
		}
	}
	public void print_org_emftext_language_pl0_IfStatement_2(org.emftext.language.pl0.IfStatement element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_emftext_language_pl0_IfStatement_2_0(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("else");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.IF_STATEMENT__ELSE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("else", count - 1);
		}
	}
	public void print_org_emftext_language_pl0_IfStatement_2_0(org.emftext.language.pl0.IfStatement element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		int alt = -1;
		alt=0;
		int matches=		0;
		int tempMatchCount;
		tempMatchCount=		0;
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("ELSE");
				out.print(" ");
			}
			break;
			default:			// DEFINITION PART BEGINS (CsString)
			out.print("else");
			out.print(" ");
		}
	}
	
	public void print_org_emftext_language_pl0_OddCondition(org.emftext.language.pl0.OddCondition element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.ODD_CONDITION__EXPRESSION));
		printCountingMap.put("expression", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_emftext_language_pl0_OddCondition_0(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("expression");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.ODD_CONDITION__EXPRESSION));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("expression", count - 1);
		}
	}
	public void print_org_emftext_language_pl0_OddCondition_0(org.emftext.language.pl0.OddCondition element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		int alt = -1;
		alt=0;
		int matches=		0;
		int tempMatchCount;
		tempMatchCount=		0;
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("ODD");
				out.print(" ");
			}
			break;
			default:			// DEFINITION PART BEGINS (CsString)
			out.print("odd");
			out.print(" ");
		}
	}
	
	public void print_org_emftext_language_pl0_RelationalCondition(org.emftext.language.pl0.RelationalCondition element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(3);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.RELATIONAL_CONDITION__LEFT));
		printCountingMap.put("left", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.RELATIONAL_CONDITION__RIGHT));
		printCountingMap.put("right", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.RELATIONAL_CONDITION__OP));
		printCountingMap.put("op", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("left");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.RELATIONAL_CONDITION__LEFT));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("left", count - 1);
		}
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("op");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.RELATIONAL_CONDITION__OP));
			if (o != null) {
				org.emftext.language.pl0.resource.pl0.IPl0TokenResolver resolver = tokenResolverFactory.createTokenResolver("REL_OP");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.RELATIONAL_CONDITION__OP), element));
				out.print(" ");
			}
			printCountingMap.put("op", count - 1);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("right");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.RELATIONAL_CONDITION__RIGHT));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("right", count - 1);
		}
	}
	
	public void print_org_emftext_language_pl0_Assignment(org.emftext.language.pl0.Assignment element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.ASSIGNMENT__LEFT));
		printCountingMap.put("left", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.ASSIGNMENT__RIGHT));
		printCountingMap.put("right", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("left");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.ASSIGNMENT__LEFT));
			if (o != null) {
				org.emftext.language.pl0.resource.pl0.IPl0TokenResolver resolver = tokenResolverFactory.createTokenResolver("PL0ID");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getAssignmentLeftReferenceResolver().deResolve((org.emftext.language.pl0.VarDeclaration) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.ASSIGNMENT__LEFT)), element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.ASSIGNMENT__LEFT), element));
				out.print(" ");
			}
			printCountingMap.put("left", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(":=");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("right");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.ASSIGNMENT__RIGHT));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("right", count - 1);
		}
	}
	
	public void print_org_emftext_language_pl0_TermExpression(org.emftext.language.pl0.TermExpression element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(3);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.TERM_EXPRESSION__OBLIGATORY));
		printCountingMap.put("obligatory", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.TERM_EXPRESSION__OPTIONAL));
		printCountingMap.put("optional", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.TERM_EXPRESSION__OP));
		printCountingMap.put("op", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("op");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.TERM_EXPRESSION__OP));
			if (o != null) {
				org.emftext.language.pl0.resource.pl0.IPl0TokenResolver resolver = tokenResolverFactory.createTokenResolver("PLUS_MINUS");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.TERM_EXPRESSION__OP), element));
				out.print(" ");
			}
			printCountingMap.put("op", count - 1);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("obligatory");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.TERM_EXPRESSION__OBLIGATORY));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("obligatory", count - 1);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("optional");
		if (count > 0) {
			java.util.List<?> list = (java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.TERM_EXPRESSION__OPTIONAL));
			int index  = list.size() - count;
			if (index < 0) {
				index = 0;
			}
			java.util.ListIterator<?> it  = list.listIterator(index);
			while (it.hasNext()) {
				java.lang.Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("optional", 0);
		}
	}
	
	public void print_org_emftext_language_pl0_OptionalTerm(org.emftext.language.pl0.OptionalTerm element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.OPTIONAL_TERM__TERM));
		printCountingMap.put("term", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.OPTIONAL_TERM__OP));
		printCountingMap.put("op", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("op");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.OPTIONAL_TERM__OP));
			if (o != null) {
				org.emftext.language.pl0.resource.pl0.IPl0TokenResolver resolver = tokenResolverFactory.createTokenResolver("PLUS_MINUS");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.OPTIONAL_TERM__OP), element));
				out.print(" ");
			}
			printCountingMap.put("op", count - 1);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("term");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.OPTIONAL_TERM__TERM));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("term", count - 1);
		}
	}
	
	public void print_org_emftext_language_pl0_Term(org.emftext.language.pl0.Term element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.TERM__OBLIGATORY));
		printCountingMap.put("obligatory", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.TERM__OPTIONAL));
		printCountingMap.put("optional", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("obligatory");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.TERM__OBLIGATORY));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("obligatory", count - 1);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("optional");
		if (count > 0) {
			java.util.List<?> list = (java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.TERM__OPTIONAL));
			int index  = list.size() - count;
			if (index < 0) {
				index = 0;
			}
			java.util.ListIterator<?> it  = list.listIterator(index);
			while (it.hasNext()) {
				java.lang.Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("optional", 0);
		}
	}
	
	public void print_org_emftext_language_pl0_OptionalFactor(org.emftext.language.pl0.OptionalFactor element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.OPTIONAL_FACTOR__FACTOR));
		printCountingMap.put("factor", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.OPTIONAL_FACTOR__OP));
		printCountingMap.put("op", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("op");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.OPTIONAL_FACTOR__OP));
			if (o != null) {
				org.emftext.language.pl0.resource.pl0.IPl0TokenResolver resolver = tokenResolverFactory.createTokenResolver("MUL_DIV");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.OPTIONAL_FACTOR__OP), element));
				out.print(" ");
			}
			printCountingMap.put("op", count - 1);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("factor");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.OPTIONAL_FACTOR__FACTOR));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("factor", count - 1);
		}
	}
	
	public void print_org_emftext_language_pl0_IdentReference(org.emftext.language.pl0.IdentReference element, java.lang.String outertab, java.io.PrintWriter out) {
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.IDENT_REFERENCE__IDENT));
		printCountingMap.put("ident", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("ident");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.IDENT_REFERENCE__IDENT));
			if (o != null) {
				org.emftext.language.pl0.resource.pl0.IPl0TokenResolver resolver = tokenResolverFactory.createTokenResolver("PL0ID");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getIdentReferenceIdentReferenceResolver().deResolve((org.emftext.language.pl0.Declaration) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.IDENT_REFERENCE__IDENT)), element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.IDENT_REFERENCE__IDENT), element));
				out.print(" ");
			}
			printCountingMap.put("ident", count - 1);
		}
	}
	
	public void print_org_emftext_language_pl0_Number(org.emftext.language.pl0.Number element, java.lang.String outertab, java.io.PrintWriter out) {
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.NUMBER__NUMBER));
		printCountingMap.put("number", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("number");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.NUMBER__NUMBER));
			if (o != null) {
				org.emftext.language.pl0.resource.pl0.IPl0TokenResolver resolver = tokenResolverFactory.createTokenResolver("NUMBER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.NUMBER__NUMBER), element));
				out.print(" ");
			}
			printCountingMap.put("number", count - 1);
		}
	}
	
	public void print_org_emftext_language_pl0_ExpressionFactor(org.emftext.language.pl0.ExpressionFactor element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.EXPRESSION_FACTOR__EXPRESSION));
		printCountingMap.put("expression", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("expression");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.pl0.PL0Package.EXPRESSION_FACTOR__EXPRESSION));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("expression", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		out.print(" ");
	}
	
}
