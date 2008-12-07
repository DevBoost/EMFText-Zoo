package org.emftext.language.simple_c.resource.c;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.simple_c.CompilationUnit;
import org.emftext.language.simple_c.Method;
import org.emftext.language.simple_c.Variable;
import org.emftext.language.simple_c.Struct;
import org.emftext.language.simple_c.Statement;
import java.util.List;
import java.util.Collection;
import java.util.ListIterator;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Map;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.emftext.runtime.resource.*;
import org.emftext.runtime.resource.impl.*;

public abstract class CPrinterBase extends EMFTextPrinterImpl {

	protected TokenResolverFactory tokenResolverFactory = new CTokenResolverFactory();
	protected EMFTextTreeAnalyser treeAnalyser = new CTreeAnalyser();

	public CPrinterBase(OutputStream o, TextResource resource) {

		super(o, resource);
	}

	protected static int matchCount(Map<java.lang.String, java.lang.Integer> featureCounter, Collection<java.lang.String> needed){
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

	protected void doPrint(EObject element,PrintWriter out,String globaltab) {
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

		public void printCompilationUnit(CompilationUnit element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("definitions"));
			printCountingMap.put("definitions", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("definitions");
			if(count>0){
				ListIterator it  = ((List)element.eGet(element.eClass().getEStructuralFeature("definitions"))).listIterator(((List)element.eGet(element.eClass().getEStructuralFeature("definitions"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("definitions",0);
			}
		}
		public void printMethod(Method element,String outertab,PrintWriter out){
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
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
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
				ListIterator it  = ((List)element.eGet(element.eClass().getEStructuralFeature("statements"))).listIterator(((List)element.eGet(element.eClass().getEStructuralFeature("statements"))).size()-count);
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
		public void printVariable(Variable element,String outertab,PrintWriter out){
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
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				out.print(" ");
				printCountingMap.put("name",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(";");
			out.print(" ");
		}
		public void printStruct(Struct element,String outertab,PrintWriter out){
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
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
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
		public void printStatement(Statement element,String outertab,PrintWriter out){
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
