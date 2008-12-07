package org.emftext.language.simple_template.resource.simpletemplate;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.simple_template.Template;
import org.emftext.language.simple_template.Condition;
import org.emftext.language.simple_template.Loop;
import org.emftext.language.simple_template.Placeholder;
import org.emftext.language.simple_template.CompoundSection;
import org.emftext.language.simple_template.Static;
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

public abstract class SimpletemplatePrinterBase extends EMFTextPrinterImpl {

	protected TokenResolverFactory tokenResolverFactory = new SimpletemplateTokenResolverFactory();
	protected EMFTextTreeAnalyser treeAnalyser = new SimpletemplateTreeAnalyser();

	public SimpletemplatePrinterBase(OutputStream o, TextResource resource) {

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

		if(element instanceof Template){
			printTemplate((Template) element,globaltab,out);
			return;
		}
		if(element instanceof Condition){
			printCondition((Condition) element,globaltab,out);
			return;
		}
		if(element instanceof Loop){
			printLoop((Loop) element,globaltab,out);
			return;
		}
		if(element instanceof Placeholder){
			printPlaceholder((Placeholder) element,globaltab,out);
			return;
		}
		if(element instanceof CompoundSection){
			printCompoundSection((CompoundSection) element,globaltab,out);
			return;
		}
		if(element instanceof Static){
			printStatic((Static) element,globaltab,out);
			return;
		}

		resource.addWarning("The cs printer can not handle " + element.eClass().getName() + " elements", element);
	}

		public void printTemplate(Template element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("content"));
			printCountingMap.put("content", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("content");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("content"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("content",count-1);
			}
		}
		public void printCondition(Condition element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("value"));
			printCountingMap.put("value", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("body"));
			printCountingMap.put("body", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("<%");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("if");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("(");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("value");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("value"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("value"),element));
				
				printCountingMap.put("value",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(")");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("%>");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("body");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("body"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("body",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("<%");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("%>");
		}
		public void printLoop(Loop element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("count"));
			printCountingMap.put("count", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("body"));
			printCountingMap.put("body", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("<%");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("for");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("(");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("count");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("count"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("count"),element));
				
				printCountingMap.put("count",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(")");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("%>");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("body");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("body"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("body",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("<%");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("%>");
		}
		public void printPlaceholder(Placeholder element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("pathToInputModelElement"));
			printCountingMap.put("pathToInputModelElement", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("<%=");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("pathToInputModelElement");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("pathToInputModelElement"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("pathToInputModelElement"),element));
				
				printCountingMap.put("pathToInputModelElement",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("%>");
		}
		public void printCompoundSection(CompoundSection element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("contents"));
			printCountingMap.put("contents", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("contents");
			if(count>0){
				ListIterator it  = ((List)element.eGet(element.eClass().getEStructuralFeature("contents"))).listIterator(((List)element.eGet(element.eClass().getEStructuralFeature("contents"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("contents",0);
			}
		}
		public void printStatic(Static element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("text"));
			printCountingMap.put("text", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("text");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("text"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("text"),element));
				
				printCountingMap.put("text",count-1);
			}
		}
		}
