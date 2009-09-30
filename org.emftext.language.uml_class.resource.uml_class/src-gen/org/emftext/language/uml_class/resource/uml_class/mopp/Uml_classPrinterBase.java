package org.emftext.language.uml_class.resource.uml_class.mopp;

public abstract class Uml_classPrinterBase implements org.emftext.language.uml_class.resource.uml_class.IUml_classTextPrinter {
	
	protected final static java.lang.String NEW_LINE = java.lang.System.getProperties().getProperty("line.separator");
	protected org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolverFactory tokenResolverFactory = new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classTokenResolverFactory();
	protected java.io.OutputStream outputStream;
	/** Holds the resource that is associated with this printer. may be null if the printer is used stand alone. */
	private org.emftext.language.uml_class.resource.uml_class.IUml_classTextResource resource;
	private java.util.Map<?, ?> options;
	
	public Uml_classPrinterBase(java.io.OutputStream outputStream, org.emftext.language.uml_class.resource.uml_class.IUml_classTextResource resource) {
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
		
		if (element instanceof org.emftext.language.uml_class.ClassDiagramm) {
			print_org_emftext_language_uml_005fclass_ClassDiagramm((org.emftext.language.uml_class.ClassDiagramm) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.uml_class.Method) {
			print_org_emftext_language_uml_005fclass_Method((org.emftext.language.uml_class.Method) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.uml_class.Attribute) {
			print_org_emftext_language_uml_005fclass_Attribute((org.emftext.language.uml_class.Attribute) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.uml_class.Parameter) {
			print_org_emftext_language_uml_005fclass_Parameter((org.emftext.language.uml_class.Parameter) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.uml_class.Class) {
			print_org_emftext_language_uml_005fclass_Class((org.emftext.language.uml_class.Class) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.uml_class.Association) {
			print_org_emftext_language_uml_005fclass_Association((org.emftext.language.uml_class.Association) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.uml_class.Boolean) {
			print_org_emftext_language_uml_005fclass_Boolean((org.emftext.language.uml_class.Boolean) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.uml_class.String) {
			print_org_emftext_language_uml_005fclass_String((org.emftext.language.uml_class.String) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.uml_class.Integer) {
			print_org_emftext_language_uml_005fclass_Integer((org.emftext.language.uml_class.Integer) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.uml_class.PrimitiveDataType) {
			print_org_emftext_language_uml_005fclass_PrimitiveDataType((org.emftext.language.uml_class.PrimitiveDataType) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.primitive_types.BooleanObject) {
			print_org_emftext_language_primitive_005ftypes_BooleanObject((org.emftext.language.primitive_types.BooleanObject) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.primitive_types.IntegerObject) {
			print_org_emftext_language_primitive_005ftypes_IntegerObject((org.emftext.language.primitive_types.IntegerObject) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.language.primitive_types.StringObject) {
			print_org_emftext_language_primitive_005ftypes_StringObject((org.emftext.language.primitive_types.StringObject) element, globaltab, out);
			return;
		}
		
		addWarningToResource("The cs printer can not handle " + element.eClass().getName() + " elements", element);
	}
	
	protected org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classReferenceResolverSwitch getReferenceResolverSwitch() {
		org.emftext.language.uml_class.resource.uml_class.IUml_classTextResource resource = getResource();
		if (resource == null) {
			return null;
		}
		return (org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classReferenceResolverSwitch) resource.getMetaInformation().getReferenceResolverSwitch();
	}
	
	protected void addWarningToResource(final java.lang.String errorMessage, org.eclipse.emf.ecore.EObject cause) {
		org.emftext.language.uml_class.resource.uml_class.IUml_classTextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the printer is used stand alone
			return;
		}
		resource.addProblem(new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classProblem(errorMessage, org.emftext.language.uml_class.resource.uml_class.Uml_classEProblemType.ERROR), cause);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		this.options = options;
	}
	
	public java.util.Map<?,?> getOptions() {
		return options;
	}
	
	public org.emftext.language.uml_class.resource.uml_class.IUml_classTextResource getResource() {
		return resource;
	}
	
	/** Calls {@link #doPrint(EObject, String)} and writes the result to the underlying output stream. */
	public void print(org.eclipse.emf.ecore.EObject element)  {
		java.io.PrintWriter out = new java.io.PrintWriter(new java.io.BufferedOutputStream(outputStream));
		doPrint(element,out,"");
		out.flush();
		out.close();
	}
	
	public void print_org_emftext_language_uml_005fclass_ClassDiagramm(org.emftext.language.uml_class.ClassDiagramm element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(4);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.CLASS_DIAGRAMM__ASSOCIATION));
		printCountingMap.put("association", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.CLASS_DIAGRAMM__CLASS));
		printCountingMap.put("class", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.CLASS_DIAGRAMM__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.CLASS_DIAGRAMM__PRIMITIVE_DATATYPES));
		printCountingMap.put("primitiveDatatypes", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("classdiagramm");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (PlaceholderUsingDefaultToken):
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.CLASS_DIAGRAMM__NAME));
			if (o != null) {
				org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.CLASS_DIAGRAMM__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("{");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("primitiveDatatypes");
		if (count > 0) {
			java.util.List<?> list = (java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.CLASS_DIAGRAMM__PRIMITIVE_DATATYPES));
			int index  = list.size() - count;
			if (index < 0) {
				index = 0;
			}
			java.util.ListIterator<?> it  = list.listIterator(index);
			while (it.hasNext()) {
				java.lang.Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("primitiveDatatypes",0);
		}
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("class");
		if (count > 0) {
			java.util.List<?> list = (java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.CLASS_DIAGRAMM__CLASS));
			int index  = list.size() - count;
			if (index < 0) {
				index = 0;
			}
			java.util.ListIterator<?> it  = list.listIterator(index);
			while (it.hasNext()) {
				java.lang.Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("class",0);
		}
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("association");
		if (count > 0) {
			java.util.List<?> list = (java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.CLASS_DIAGRAMM__ASSOCIATION));
			int index  = list.size() - count;
			if (index < 0) {
				index = 0;
			}
			java.util.ListIterator<?> it  = list.listIterator(index);
			while (it.hasNext()) {
				java.lang.Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("association",0);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("}");
		out.print(" ");
	}
	
	public void print_org_emftext_language_uml_005fclass_Method(org.emftext.language.uml_class.Method element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(6);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.METHOD__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.METHOD__ACCESS));
		printCountingMap.put("access", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.METHOD__RETURN));
		printCountingMap.put("return", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.METHOD__PARAMETER));
		printCountingMap.put("parameter", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.METHOD__MODIFIER));
		printCountingMap.put("modifier", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.METHOD__PRETURN));
		printCountingMap.put("p_return", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = null;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("method");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_language_uml_005fclass_Method_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			print_org_emftext_language_uml_005fclass_Method_1(element, localtab, out1, printCountingMap1);
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
		//////////////DEFINITION PART BEGINS (PlaceholderUsingDefaultToken):
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.METHOD__NAME));
			if (o != null) {
				org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.METHOD__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("(");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_language_uml_005fclass_Method_2(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print(")");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (CsString):
		out.print(":");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		print_org_emftext_language_uml_005fclass_Method_3(element, localtab, out, printCountingMap);
	}
	public void print_org_emftext_language_uml_005fclass_Method_0(org.emftext.language.uml_class.Method element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("ac");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (PlaceholderUsingDefaultToken):
		count = printCountingMap.get("access");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.METHOD__ACCESS));
			if (o != null) {
				org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.METHOD__ACCESS), element));
				out.print(" ");
			}
			printCountingMap.put("access", count - 1);
		}
	}
	public void print_org_emftext_language_uml_005fclass_Method_1(org.emftext.language.uml_class.Method element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("md");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (PlaceholderUsingDefaultToken):
		count = printCountingMap.get("modifier");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.METHOD__MODIFIER));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.METHOD__MODIFIER), element));
				out.print(" ");
			}
			printCountingMap.put("modifier", count - 1);
		}
	}
	public void print_org_emftext_language_uml_005fclass_Method_2(org.emftext.language.uml_class.Method element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = null;
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("parameter");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.METHOD__PARAMETER));
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
			printCountingMap.put("parameter", count - 1);
		}
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			print_org_emftext_language_uml_005fclass_Method_2_0(element, localtab, out1, printCountingMap1);
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
	public void print_org_emftext_language_uml_005fclass_Method_2_0(org.emftext.language.uml_class.Method element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print(",");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("parameter");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.METHOD__PARAMETER));
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
			printCountingMap.put("parameter", count - 1);
		}
	}
	public void print_org_emftext_language_uml_005fclass_Method_3(org.emftext.language.uml_class.Method element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		int alt = -1;
		alt=0;
		int matches=		matchCount(printCountingMap, java.util.Arrays.asList(		"return"		));
		int tempMatchCount;
		tempMatchCount=		0;
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		tempMatchCount=		matchCount(printCountingMap, java.util.Arrays.asList(		"p_return"		));
		if (tempMatchCount > matches) {
			alt = 2;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				//////////////DEFINITION PART BEGINS (CsString):
				out.print("void");
				out.print(" ");
			}
			break;
			case 2:			{
				//////////////DEFINITION PART BEGINS (Containment):
				count = printCountingMap.get("p_return");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.METHOD__PRETURN));
					if (o != null) {
						doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
					}
					printCountingMap.put("p_return", count - 1);
				}
			}
			break;
			default:			//////////////DEFINITION PART BEGINS (PlaceholderUsingDefaultToken):
			count = printCountingMap.get("return");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.METHOD__RETURN));
				if (o != null) {
					org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getMethodReturnReferenceResolver().deResolve((org.emftext.language.uml_class.XClass) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.METHOD__RETURN)), element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.METHOD__RETURN), element));
					out.print(" ");
				}
				printCountingMap.put("return", count - 1);
			}
		}
	}
	
	public void print_org_emftext_language_uml_005fclass_Attribute(org.emftext.language.uml_class.Attribute element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(5);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.ATTRIBUTE__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.ATTRIBUTE__ACCESS));
		printCountingMap.put("access", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.ATTRIBUTE__TYPE));
		printCountingMap.put("type", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.ATTRIBUTE__MODIFIER));
		printCountingMap.put("modifier", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.ATTRIBUTE__PTYPE));
		printCountingMap.put("p_type", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = null;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("attribute");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_language_uml_005fclass_Attribute_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			print_org_emftext_language_uml_005fclass_Attribute_1(element, localtab, out1, printCountingMap1);
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
		//////////////DEFINITION PART BEGINS (PlaceholderUsingDefaultToken):
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.ATTRIBUTE__NAME));
			if (o != null) {
				org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.ATTRIBUTE__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print(":");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		print_org_emftext_language_uml_005fclass_Attribute_2(element, localtab, out, printCountingMap);
	}
	public void print_org_emftext_language_uml_005fclass_Attribute_0(org.emftext.language.uml_class.Attribute element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("ac");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (PlaceholderUsingDefaultToken):
		count = printCountingMap.get("access");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.ATTRIBUTE__ACCESS));
			if (o != null) {
				org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.ATTRIBUTE__ACCESS), element));
				out.print(" ");
			}
			printCountingMap.put("access", count - 1);
		}
	}
	public void print_org_emftext_language_uml_005fclass_Attribute_1(org.emftext.language.uml_class.Attribute element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("md");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (PlaceholderUsingDefaultToken):
		count = printCountingMap.get("modifier");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.ATTRIBUTE__MODIFIER));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.ATTRIBUTE__MODIFIER), element));
				out.print(" ");
			}
			printCountingMap.put("modifier", count - 1);
		}
	}
	public void print_org_emftext_language_uml_005fclass_Attribute_2(org.emftext.language.uml_class.Attribute element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		int alt = -1;
		alt=0;
		int matches=		matchCount(printCountingMap, java.util.Arrays.asList(		"type"		));
		int tempMatchCount;
		tempMatchCount=		matchCount(printCountingMap, java.util.Arrays.asList(		"p_type"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				//////////////DEFINITION PART BEGINS (Containment):
				count = printCountingMap.get("p_type");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.ATTRIBUTE__PTYPE));
					if (o != null) {
						doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
					}
					printCountingMap.put("p_type", count - 1);
				}
			}
			break;
			default:			//////////////DEFINITION PART BEGINS (PlaceholderUsingDefaultToken):
			count = printCountingMap.get("type");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.ATTRIBUTE__TYPE));
				if (o != null) {
					org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getAttributeTypeReferenceResolver().deResolve((org.emftext.language.uml_class.XClass) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.ATTRIBUTE__TYPE)), element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.ATTRIBUTE__TYPE), element));
					out.print(" ");
				}
				printCountingMap.put("type", count - 1);
			}
		}
	}
	
	public void print_org_emftext_language_uml_005fclass_Parameter(org.emftext.language.uml_class.Parameter element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(3);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.PARAMETER__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.PARAMETER__TYPE));
		printCountingMap.put("type", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.PARAMETER__PTYPE));
		printCountingMap.put("p_type", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (PlaceholderUsingDefaultToken):
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.PARAMETER__NAME));
			if (o != null) {
				org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.PARAMETER__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print(":");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		print_org_emftext_language_uml_005fclass_Parameter_0(element, localtab, out, printCountingMap);
	}
	public void print_org_emftext_language_uml_005fclass_Parameter_0(org.emftext.language.uml_class.Parameter element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		int alt = -1;
		alt=0;
		int matches=		matchCount(printCountingMap, java.util.Arrays.asList(		"type"		));
		int tempMatchCount;
		tempMatchCount=		matchCount(printCountingMap, java.util.Arrays.asList(		"p_type"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				//////////////DEFINITION PART BEGINS (Containment):
				count = printCountingMap.get("p_type");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.PARAMETER__PTYPE));
					if (o != null) {
						doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
					}
					printCountingMap.put("p_type", count - 1);
				}
			}
			break;
			default:			//////////////DEFINITION PART BEGINS (PlaceholderUsingDefaultToken):
			count = printCountingMap.get("type");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.PARAMETER__TYPE));
				if (o != null) {
					org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getParameterTypeReferenceResolver().deResolve((org.emftext.language.uml_class.XClass) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.PARAMETER__TYPE)), element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.PARAMETER__TYPE), element));
					out.print(" ");
				}
				printCountingMap.put("type", count - 1);
			}
		}
	}
	
	public void print_org_emftext_language_uml_005fclass_Class(org.emftext.language.uml_class.Class element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(6);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.CLASS__PARENT));
		printCountingMap.put("parent", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.CLASS__ATTRIBUTE));
		printCountingMap.put("attribute", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.CLASS__METHOD));
		printCountingMap.put("method", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.CLASS__ACCESS));
		printCountingMap.put("access", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.CLASS__MODIFIER));
		printCountingMap.put("modifier", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.CLASS__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = null;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("class");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_language_uml_005fclass_Class_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			print_org_emftext_language_uml_005fclass_Class_1(element, localtab, out1, printCountingMap1);
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
		//////////////DEFINITION PART BEGINS (PlaceholderUsingDefaultToken):
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.CLASS__NAME));
			if (o != null) {
				org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.CLASS__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_language_uml_005fclass_Class_2(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("{");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("attribute");
		if (count > 0) {
			java.util.List<?> list = (java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.CLASS__ATTRIBUTE));
			int index  = list.size() - count;
			if (index < 0) {
				index = 0;
			}
			java.util.ListIterator<?> it  = list.listIterator(index);
			while (it.hasNext()) {
				java.lang.Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("attribute",0);
		}
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("method");
		if (count > 0) {
			java.util.List<?> list = (java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.CLASS__METHOD));
			int index  = list.size() - count;
			if (index < 0) {
				index = 0;
			}
			java.util.ListIterator<?> it  = list.listIterator(index);
			while (it.hasNext()) {
				java.lang.Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("method",0);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("}");
		out.print(" ");
	}
	public void print_org_emftext_language_uml_005fclass_Class_0(org.emftext.language.uml_class.Class element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("ac");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (PlaceholderUsingDefaultToken):
		count = printCountingMap.get("access");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.CLASS__ACCESS));
			if (o != null) {
				org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.CLASS__ACCESS), element));
				out.print(" ");
			}
			printCountingMap.put("access", count - 1);
		}
	}
	public void print_org_emftext_language_uml_005fclass_Class_1(org.emftext.language.uml_class.Class element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("md");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (PlaceholderUsingDefaultToken):
		count = printCountingMap.get("modifier");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.CLASS__MODIFIER));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.CLASS__MODIFIER), element));
				out.print(" ");
			}
			printCountingMap.put("modifier", count - 1);
		}
	}
	public void print_org_emftext_language_uml_005fclass_Class_2(org.emftext.language.uml_class.Class element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("extends");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (PlaceholderUsingDefaultToken):
		count = printCountingMap.get("parent");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.CLASS__PARENT));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getClassParentReferenceResolver().deResolve((org.emftext.language.uml_class.XClass) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.CLASS__PARENT)), element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.CLASS__PARENT), element));
				out.print(" ");
			}
			printCountingMap.put("parent", count - 1);
		}
	}
	
	public void print_org_emftext_language_uml_005fclass_Association(org.emftext.language.uml_class.Association element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(5);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.ASSOCIATION__SOURCE));
		printCountingMap.put("source", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.ASSOCIATION__TARGET));
		printCountingMap.put("target", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.ASSOCIATION__MIN_CARDINALITY));
		printCountingMap.put("minCardinality", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.ASSOCIATION__MAX_CARDINALITY));
		printCountingMap.put("maxCardinality", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.ASSOCIATION__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("association");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (PlaceholderUsingDefaultToken):
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.ASSOCIATION__NAME));
			if (o != null) {
				org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.ASSOCIATION__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("(");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("source");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.ASSOCIATION__SOURCE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("source", count - 1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("->");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("target");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.ASSOCIATION__TARGET));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("target", count - 1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print(":");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (PlaceholderInQuotes):
		count = printCountingMap.get("minCardinality");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.ASSOCIATION__MIN_CARDINALITY));
			if (o != null) {
				org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.ASSOCIATION__MIN_CARDINALITY), element));
				out.print(" ");
			}
			printCountingMap.put("minCardinality", count - 1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("..");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (PlaceholderInQuotes):
		count = printCountingMap.get("maxCardinality");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.ASSOCIATION__MAX_CARDINALITY));
			if (o != null) {
				org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.ASSOCIATION__MAX_CARDINALITY), element));
				out.print(" ");
			}
			printCountingMap.put("maxCardinality", count - 1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print(")");
		out.print(" ");
	}
	
	public void print_org_emftext_language_uml_005fclass_Boolean(org.emftext.language.uml_class.Boolean element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.BOOLEAN__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.BOOLEAN__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("BOOLEAN");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (PlaceholderUsingDefaultToken):
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.BOOLEAN__NAME));
			if (o != null) {
				org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.BOOLEAN__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("value");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.BOOLEAN__VALUE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("value", count - 1);
		}
	}
	
	public void print_org_emftext_language_uml_005fclass_String(org.emftext.language.uml_class.String element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.STRING__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.STRING__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("STRING");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (PlaceholderUsingDefaultToken):
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.STRING__NAME));
			if (o != null) {
				org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.STRING__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("value");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.STRING__VALUE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("value", count - 1);
		}
	}
	
	public void print_org_emftext_language_uml_005fclass_Integer(org.emftext.language.uml_class.Integer element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.INTEGER__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.INTEGER__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("INTEGER");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (PlaceholderUsingDefaultToken):
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.INTEGER__NAME));
			if (o != null) {
				org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.INTEGER__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("value");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.INTEGER__VALUE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("value", count - 1);
		}
	}
	
	public void print_org_emftext_language_uml_005fclass_PrimitiveDataType(org.emftext.language.uml_class.PrimitiveDataType element, java.lang.String outertab, java.io.PrintWriter out) {
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.PRIMITIVE_DATA_TYPE__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("TYPE");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (PlaceholderUsingDefaultToken):
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.PRIMITIVE_DATA_TYPE__NAME));
			if (o != null) {
				org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.uml_class.Uml_classPackage.PRIMITIVE_DATA_TYPE__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
	}
	
	public void print_org_emftext_language_primitive_005ftypes_BooleanObject(org.emftext.language.primitive_types.BooleanObject element, java.lang.String outertab, java.io.PrintWriter out) {
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.primitive_types.Primitive_typesPackage.BOOLEAN_OBJECT__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (PlaceholderInQuotes):
		count = printCountingMap.get("value");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.primitive_types.Primitive_typesPackage.BOOLEAN_OBJECT__VALUE));
			if (o != null) {
				org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.primitive_types.Primitive_typesPackage.BOOLEAN_OBJECT__VALUE), element));
				out.print(" ");
			}
			printCountingMap.put("value", count - 1);
		}
	}
	
	public void print_org_emftext_language_primitive_005ftypes_IntegerObject(org.emftext.language.primitive_types.IntegerObject element, java.lang.String outertab, java.io.PrintWriter out) {
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.primitive_types.Primitive_typesPackage.INTEGER_OBJECT__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (PlaceholderInQuotes):
		count = printCountingMap.get("value");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.primitive_types.Primitive_typesPackage.INTEGER_OBJECT__VALUE));
			if (o != null) {
				org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.primitive_types.Primitive_typesPackage.INTEGER_OBJECT__VALUE), element));
				out.print(" ");
			}
			printCountingMap.put("value", count - 1);
		}
	}
	
	public void print_org_emftext_language_primitive_005ftypes_StringObject(org.emftext.language.primitive_types.StringObject element, java.lang.String outertab, java.io.PrintWriter out) {
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.primitive_types.Primitive_typesPackage.STRING_OBJECT__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (PlaceholderInQuotes):
		count = printCountingMap.get("value");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.language.primitive_types.Primitive_typesPackage.STRING_OBJECT__VALUE));
			if (o != null) {
				org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.language.primitive_types.Primitive_typesPackage.STRING_OBJECT__VALUE), element));
				out.print(" ");
			}
			printCountingMap.put("value", count - 1);
		}
	}
	
}
