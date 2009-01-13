package org.emftext.language.c_sharp.resource.cs;

public abstract class CsPrinterBase extends org.emftext.runtime.resource.impl.EMFTextPrinterImpl {

	protected org.emftext.runtime.resource.ITokenResolverFactory tokenResolverFactory = new CsTokenResolverFactory();
	protected org.emftext.runtime.resource.IReferenceResolver treeAnalyser = new CsTreeAnalyser();

	public CsPrinterBase(java.io.OutputStream o, org.emftext.runtime.resource.ITextResource resource) {
		super(o, resource);
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

		if(element instanceof org.emftext.language.c_sharp.CompilationUnit){
			print_org_emftext_language_c_005fsharp_CompilationUnit((org.emftext.language.c_sharp.CompilationUnit) element, globaltab, out);
			return;
		}
		if(element instanceof org.emftext.language.c_sharp.Method){
			print_org_emftext_language_c_005fsharp_Method((org.emftext.language.c_sharp.Method) element, globaltab, out);
			return;
		}
		if(element instanceof org.emftext.language.c_sharp.Variable){
			print_org_emftext_language_c_005fsharp_Variable((org.emftext.language.c_sharp.Variable) element, globaltab, out);
			return;
		}
		if(element instanceof org.emftext.language.c_sharp.Struct){
			print_org_emftext_language_c_005fsharp_Struct((org.emftext.language.c_sharp.Struct) element, globaltab, out);
			return;
		}
		if(element instanceof org.emftext.language.c_sharp.Statement){
			print_org_emftext_language_c_005fsharp_Statement((org.emftext.language.c_sharp.Statement) element, globaltab, out);
			return;
		}

		resource.addWarning("The cs printer can not handle " + element.eClass().getName() + " elements", element);
	}

	public void print_org_emftext_language_c_005fsharp_CompilationUnit(org.emftext.language.c_sharp.CompilationUnit element, java.lang.String outertab, java.io.PrintWriter out){
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature("definitions"));
		printCountingMap.put("definitions", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
// TODO print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("definitions");
		if(count>0){
			java.util.ListIterator<?> it  = ((java.util.List<?>) element.eGet(element.eClass().getEStructuralFeature("definitions"))).listIterator(((java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature("definitions"))).size()-count);
			while(it.hasNext()){
				java.lang.Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("definitions",0);
		}
	}

	public void print_org_emftext_language_c_005fsharp_Method(org.emftext.language.c_sharp.Method element, java.lang.String outertab, java.io.PrintWriter out){
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature("name"));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature("statements"));
		printCountingMap.put("statements", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
// TODO print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("void");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("name");
		if(count>0){
			Object o =element.eGet(element.eClass().getEStructuralFeature("name"));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object)o,element.eClass().getEStructuralFeature("name"),element));
				out.print(" ");
			printCountingMap.put("name",count-1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("(");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (CsString):
		out.print(")");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("{");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("statements");
		if(count>0){
			java.util.ListIterator<?> it  = ((java.util.List<?>) element.eGet(element.eClass().getEStructuralFeature("statements"))).listIterator(((java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature("statements"))).size()-count);
			while(it.hasNext()){
				java.lang.Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("statements",0);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("}");
		out.print(" ");
	}

	public void print_org_emftext_language_c_005fsharp_Variable(org.emftext.language.c_sharp.Variable element, java.lang.String outertab, java.io.PrintWriter out){
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature("name"));
		printCountingMap.put("name", temp == null ? 0 : 1);
// TODO print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("int");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("name");
		if(count>0){
			Object o =element.eGet(element.eClass().getEStructuralFeature("name"));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object)o,element.eClass().getEStructuralFeature("name"),element));
				out.print(" ");
			printCountingMap.put("name",count-1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print(";");
		out.print(" ");
	}

	public void print_org_emftext_language_c_005fsharp_Struct(org.emftext.language.c_sharp.Struct element, java.lang.String outertab, java.io.PrintWriter out){
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature("name"));
		printCountingMap.put("name", temp == null ? 0 : 1);
// TODO print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("struct");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("name");
		if(count>0){
			Object o =element.eGet(element.eClass().getEStructuralFeature("name"));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object)o,element.eClass().getEStructuralFeature("name"),element));
				out.print(" ");
			printCountingMap.put("name",count-1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("{");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("}");
		out.print(" ");
	}

	public void print_org_emftext_language_c_005fsharp_Statement(org.emftext.language.c_sharp.Statement element, java.lang.String outertab, java.io.PrintWriter out){
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
// TODO print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("return");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (CsString):
		out.print(";");
		out.print(" ");
	}

}
