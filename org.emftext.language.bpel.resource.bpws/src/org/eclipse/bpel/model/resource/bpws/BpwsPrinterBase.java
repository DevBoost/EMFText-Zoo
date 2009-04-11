package org.eclipse.bpel.model.resource.bpws;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import java.util.List;
import java.util.Collection;
import java.util.ListIterator;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Map;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.reuseware.emftextedit.runtime.resource.*;
import org.reuseware.emftextedit.runtime.resource.impl.*;

public abstract class BpwsPrinterBase extends EMFTextPrinterImpl {

	protected TokenResolverFactory tokenResolverFactory = new BpwsTokenResolverFactory();
	protected EMFTextTreeAnalyser treeAnalyser = new BpwsTreeAnalyser();

	public BpwsPrinterBase(OutputStream o, TextResource resource) {

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

		if(element instanceof Process){
			printProcess((Process) element,globaltab,out);
			return;
		}

		resource.addWarning("The cs printer can not handle " + element.eClass().getName() + " elements", element);
	}

		public void printProcess(Process element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(20);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("documentationElement"));
			printCountingMap.put("documentationElement", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("element"));
			printCountingMap.put("element", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("eExtensibilityElements"));
			printCountingMap.put("eExtensibilityElements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("documentation"));
			printCountingMap.put("documentation", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("name"));
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("targetNamespace"));
			printCountingMap.put("targetNamespace", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("queryLanguage"));
			printCountingMap.put("queryLanguage", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("expressionLanguage"));
			printCountingMap.put("expressionLanguage", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("suppressJoinFailure"));
			printCountingMap.put("suppressJoinFailure", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("variableAccessSerializable"));
			printCountingMap.put("variableAccessSerializable", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("partnerLinks"));
			printCountingMap.put("partnerLinks", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("variables"));
			printCountingMap.put("variables", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("activity"));
			printCountingMap.put("activity", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("faultHandlers"));
			printCountingMap.put("faultHandlers", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("eventHandlers"));
			printCountingMap.put("eventHandlers", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("correlationSets"));
			printCountingMap.put("correlationSets", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("imports"));
			printCountingMap.put("imports", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("extensions"));
			printCountingMap.put("extensions", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("exitOnStandardFault"));
			printCountingMap.put("exitOnStandardFault", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("messageExchanges"));
			printCountingMap.put("messageExchanges", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("Process");
		}
		}
