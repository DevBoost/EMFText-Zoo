package org.emftext.language.c_sharp.resource.cs;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.c_sharp.CompilationUnit;
import org.emftext.language.c_sharp.Method;
import org.emftext.language.c_sharp.Variable;
import org.emftext.language.c_sharp.Struct;
import org.emftext.language.c_sharp.Statement;

public abstract class CsPrinterBase extends org.emftext.runtime.resource.impl.EMFTextPrinterImpl {

	protected org.emftext.runtime.resource.ITokenResolverFactory tokenResolverFactory = new CsTokenResolverFactory();
	protected org.emftext.runtime.resource.IReferenceResolver treeAnalyser = new CsTreeAnalyser();

	public CsPrinterBase(java.io.OutputStream o, org.emftext.runtime.resource.ITextResource resource) {

		super(o, resource);
	}

	protected static int matchCount(java.util.Map<java.lang.String, java.lang.Integer> featureCounter, java.util.Collection<java.lang.String> needed){
		int pos = 0;
		int neg = 0;

		for(String featureName:featureCounter.keySet()){
			if(needed.contains(featureName)){
				int value = featureCounter.get(featureName);
				if(value==0)
					neg+=1;
				else
					pos+=1;
			}
		}
		return neg>0?-neg:pos;
	}

	protected void doPrint(EObject element, java.io.PrintWriter out, String globaltab) {
		if (element == null||out == null) throw new NullPointerException("Nothing to write or to write on.");

		if(element instanceof CompilationUnit){
			printCompilationUnit((CompilationUnit) element,globaltab,out);
			return;
		}
		if(element instanceof Method){
			printMethod((Method) element,globaltab,out);
			return;
		}
		if(element instanceof Variable){
			printVariable((Variable) element,globaltab,out);
			return;
		}
		if(element instanceof Struct){
			printStruct((Struct) element,globaltab,out);
			return;
		}
		if(element instanceof Statement){
			printStatement((Statement) element,globaltab,out);
			return;
		}

		resource.addWarning("The cs printer can not handle " + element.eClass().getName() + " elements", element);
	}

		public void printCompilationUnit(CompilationUnit element, String outertab, java.io.PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("definitions"));
			printCountingMap.put("definitions", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("definitions");
			if(count>0){
				java.util.ListIterator it  = ((java.util.List)element.eGet(element.eClass().getEStructuralFeature("definitions"))).listIterator(((java.util.List)element.eGet(element.eClass().getEStructuralFeature("definitions"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("definitions",0);
			}
		}
		public void printMethod(Method element, String outertab, java.io.PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("name"));
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("statements"));
			printCountingMap.put("statements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
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
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
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
				java.util.ListIterator it  = ((java.util.List)element.eGet(element.eClass().getEStructuralFeature("statements"))).listIterator(((java.util.List)element.eGet(element.eClass().getEStructuralFeature("statements"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("statements",0);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
			out.print(" ");
		}
		public void printVariable(Variable element, String outertab, java.io.PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("name"));
			printCountingMap.put("name", temp == null ? 0 : 1);
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
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				out.print(" ");
				printCountingMap.put("name",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(";");
			out.print(" ");
		}
		public void printStruct(Struct element, String outertab, java.io.PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("name"));
			printCountingMap.put("name", temp == null ? 0 : 1);
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
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
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
		public void printStatement(Statement element, String outertab, java.io.PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("return");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(";");
			out.print(" ");
		}
		}
