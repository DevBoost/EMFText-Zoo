package org.eclipse.uml2.uml.resource.statemachine;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.FinalState;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.Activity;
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

public abstract class StatemachinePrinterBase extends EMFTextPrinterImpl {

	protected TokenResolverFactory tokenResolverFactory = new StatemachineTokenResolverFactory();
	protected EMFTextTreeAnalyser treeAnalyser = new StatemachineTreeAnalyser();

	public StatemachinePrinterBase(OutputStream o, TextResource resource) {

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

		if(element instanceof StateMachine){
			printStateMachine((StateMachine) element,globaltab,out);
			return;
		}
		if(element instanceof Region){
			printRegion((Region) element,globaltab,out);
			return;
		}
		if(element instanceof Pseudostate){
			printPseudostate((Pseudostate) element,globaltab,out);
			return;
		}
		if(element instanceof FinalState){
			printFinalState((FinalState) element,globaltab,out);
			return;
		}
		if(element instanceof Transition){
			printTransition((Transition) element,globaltab,out);
			return;
		}
		if(element instanceof Trigger){
			printTrigger((Trigger) element,globaltab,out);
			return;
		}
		if(element instanceof Activity){
			printActivity((Activity) element,globaltab,out);
			return;
		}
		if(element instanceof State){
			printState((State) element,globaltab,out);
			return;
		}

		resource.addWarning("The cs printer can not handle " + element.eClass().getName() + " elements", element);
	}

		public void printStateMachine(StateMachine element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(64);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("eAnnotations"));
			printCountingMap.put("eAnnotations", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedElement"));
			printCountingMap.put("ownedElement", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("owner"));
			printCountingMap.put("owner", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedComment"));
			printCountingMap.put("ownedComment", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("name"));
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("visibility"));
			printCountingMap.put("visibility", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("qualifiedName"));
			printCountingMap.put("qualifiedName", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("clientDependency"));
			printCountingMap.put("clientDependency", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("namespace"));
			printCountingMap.put("namespace", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("nameExpression"));
			printCountingMap.put("nameExpression", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("elementImport"));
			printCountingMap.put("elementImport", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("packageImport"));
			printCountingMap.put("packageImport", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedRule"));
			printCountingMap.put("ownedRule", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("member"));
			printCountingMap.put("member", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("importedMember"));
			printCountingMap.put("importedMember", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedMember"));
			printCountingMap.put("ownedMember", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("isLeaf"));
			printCountingMap.put("isLeaf", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("redefinedElement"));
			printCountingMap.put("redefinedElement", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("redefinitionContext"));
			printCountingMap.put("redefinitionContext", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("owningTemplateParameter"));
			printCountingMap.put("owningTemplateParameter", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("templateParameter"));
			printCountingMap.put("templateParameter", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("package"));
			printCountingMap.put("package", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("templateBinding"));
			printCountingMap.put("templateBinding", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedTemplateSignature"));
			printCountingMap.put("ownedTemplateSignature", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("isAbstract"));
			printCountingMap.put("isAbstract", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("generalization"));
			printCountingMap.put("generalization", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("powertypeExtent"));
			printCountingMap.put("powertypeExtent", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("feature"));
			printCountingMap.put("feature", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("inheritedMember"));
			printCountingMap.put("inheritedMember", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("redefinedClassifier"));
			printCountingMap.put("redefinedClassifier", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("general"));
			printCountingMap.put("general", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("substitution"));
			printCountingMap.put("substitution", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("attribute"));
			printCountingMap.put("attribute", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("representation"));
			printCountingMap.put("representation", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("collaborationUse"));
			printCountingMap.put("collaborationUse", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedUseCase"));
			printCountingMap.put("ownedUseCase", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("useCase"));
			printCountingMap.put("useCase", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedAttribute"));
			printCountingMap.put("ownedAttribute", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("part"));
			printCountingMap.put("part", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("role"));
			printCountingMap.put("role", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedConnector"));
			printCountingMap.put("ownedConnector", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedPort"));
			printCountingMap.put("ownedPort", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedBehavior"));
			printCountingMap.put("ownedBehavior", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("classifierBehavior"));
			printCountingMap.put("classifierBehavior", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("interfaceRealization"));
			printCountingMap.put("interfaceRealization", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedTrigger"));
			printCountingMap.put("ownedTrigger", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("nestedClassifier"));
			printCountingMap.put("nestedClassifier", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedOperation"));
			printCountingMap.put("ownedOperation", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("superClass"));
			printCountingMap.put("superClass", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("isActive"));
			printCountingMap.put("isActive", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedReception"));
			printCountingMap.put("ownedReception", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("extension"));
			printCountingMap.put("extension", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("isReentrant"));
			printCountingMap.put("isReentrant", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("redefinedBehavior"));
			printCountingMap.put("redefinedBehavior", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedParameter"));
			printCountingMap.put("ownedParameter", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("context"));
			printCountingMap.put("context", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("precondition"));
			printCountingMap.put("precondition", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("postcondition"));
			printCountingMap.put("postcondition", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedParameterSet"));
			printCountingMap.put("ownedParameterSet", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("specification"));
			printCountingMap.put("specification", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("region"));
			printCountingMap.put("region", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("submachineState"));
			printCountingMap.put("submachineState", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("connectionPoint"));
			printCountingMap.put("connectionPoint", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("extendedStateMachine"));
			printCountingMap.put("extendedStateMachine", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("StateMachine");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("name");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("name"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				
				printCountingMap.put("name",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("region");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("region"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("region",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printRegion(Region element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(24);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("eAnnotations"));
			printCountingMap.put("eAnnotations", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedElement"));
			printCountingMap.put("ownedElement", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("owner"));
			printCountingMap.put("owner", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedComment"));
			printCountingMap.put("ownedComment", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("name"));
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("visibility"));
			printCountingMap.put("visibility", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("qualifiedName"));
			printCountingMap.put("qualifiedName", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("clientDependency"));
			printCountingMap.put("clientDependency", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("namespace"));
			printCountingMap.put("namespace", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("nameExpression"));
			printCountingMap.put("nameExpression", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("elementImport"));
			printCountingMap.put("elementImport", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("packageImport"));
			printCountingMap.put("packageImport", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedRule"));
			printCountingMap.put("ownedRule", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("member"));
			printCountingMap.put("member", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("importedMember"));
			printCountingMap.put("importedMember", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedMember"));
			printCountingMap.put("ownedMember", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("isLeaf"));
			printCountingMap.put("isLeaf", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("redefinedElement"));
			printCountingMap.put("redefinedElement", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("redefinitionContext"));
			printCountingMap.put("redefinitionContext", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("subvertex"));
			printCountingMap.put("subvertex", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("transition"));
			printCountingMap.put("transition", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("state"));
			printCountingMap.put("state", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("extendedRegion"));
			printCountingMap.put("extendedRegion", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("stateMachine"));
			printCountingMap.put("stateMachine", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printRegion_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
		}
		public void printRegion_0(Region element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("subvertex"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("transition"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("transition");
						if(count>0){
							Object o =element.eGet(element.eClass().getEStructuralFeature("transition"));
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("transition",count-1);
						}
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(";");
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (Containment):
					count = printCountingMap.get("subvertex");
					if(count>0){
						Object o =element.eGet(element.eClass().getEStructuralFeature("subvertex"));
						o = ((List<Object>)o).get(((List<Object>)o).size()-count);
						doPrint((EObject)o,out,localtab);
						printCountingMap.put("subvertex",count-1);
					}
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(";");
			}
		}
		public void printState(State element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(36);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("eAnnotations"));
			printCountingMap.put("eAnnotations", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedElement"));
			printCountingMap.put("ownedElement", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("owner"));
			printCountingMap.put("owner", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedComment"));
			printCountingMap.put("ownedComment", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("name"));
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("visibility"));
			printCountingMap.put("visibility", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("qualifiedName"));
			printCountingMap.put("qualifiedName", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("clientDependency"));
			printCountingMap.put("clientDependency", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("namespace"));
			printCountingMap.put("namespace", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("nameExpression"));
			printCountingMap.put("nameExpression", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("elementImport"));
			printCountingMap.put("elementImport", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("packageImport"));
			printCountingMap.put("packageImport", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedRule"));
			printCountingMap.put("ownedRule", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("member"));
			printCountingMap.put("member", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("importedMember"));
			printCountingMap.put("importedMember", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedMember"));
			printCountingMap.put("ownedMember", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("isLeaf"));
			printCountingMap.put("isLeaf", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("redefinedElement"));
			printCountingMap.put("redefinedElement", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("redefinitionContext"));
			printCountingMap.put("redefinitionContext", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("incoming"));
			printCountingMap.put("incoming", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("outgoing"));
			printCountingMap.put("outgoing", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("container"));
			printCountingMap.put("container", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("isComposite"));
			printCountingMap.put("isComposite", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("isOrthogonal"));
			printCountingMap.put("isOrthogonal", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("isSimple"));
			printCountingMap.put("isSimple", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("isSubmachineState"));
			printCountingMap.put("isSubmachineState", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("submachine"));
			printCountingMap.put("submachine", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("connection"));
			printCountingMap.put("connection", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("connectionPoint"));
			printCountingMap.put("connectionPoint", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("redefinedState"));
			printCountingMap.put("redefinedState", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("stateInvariant"));
			printCountingMap.put("stateInvariant", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("entry"));
			printCountingMap.put("entry", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("exit"));
			printCountingMap.put("exit", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("doActivity"));
			printCountingMap.put("doActivity", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("deferrableTrigger"));
			printCountingMap.put("deferrableTrigger", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("region"));
			printCountingMap.put("region", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("state");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("name");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("name"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				
				printCountingMap.put("name",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printState_0(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			sWriter = new StringWriter();
			out1 = new PrintWriter(sWriter);
			printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printState_1(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("do");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(":");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("doActivity");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("doActivity"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("doActivity",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printState_0(State element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("entry");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(":");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("entry");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("entry"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("entry",count-1);
			}
		}
		public void printState_1(State element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("exit");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(":");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("exit");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("exit"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("exit",count-1);
			}
		}
		public void printPseudostate(Pseudostate element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(16);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("eAnnotations"));
			printCountingMap.put("eAnnotations", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedElement"));
			printCountingMap.put("ownedElement", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("owner"));
			printCountingMap.put("owner", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedComment"));
			printCountingMap.put("ownedComment", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("name"));
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("visibility"));
			printCountingMap.put("visibility", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("qualifiedName"));
			printCountingMap.put("qualifiedName", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("clientDependency"));
			printCountingMap.put("clientDependency", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("namespace"));
			printCountingMap.put("namespace", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("nameExpression"));
			printCountingMap.put("nameExpression", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("incoming"));
			printCountingMap.put("incoming", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("outgoing"));
			printCountingMap.put("outgoing", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("container"));
			printCountingMap.put("container", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("kind"));
			printCountingMap.put("kind", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("stateMachine"));
			printCountingMap.put("stateMachine", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("state"));
			printCountingMap.put("state", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("kind");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("kind"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("kind"),element));
				
				printCountingMap.put("kind",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("state");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("name");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("name"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				
				printCountingMap.put("name",count-1);
			}
		}
		public void printFinalState(FinalState element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(36);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("eAnnotations"));
			printCountingMap.put("eAnnotations", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedElement"));
			printCountingMap.put("ownedElement", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("owner"));
			printCountingMap.put("owner", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedComment"));
			printCountingMap.put("ownedComment", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("name"));
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("visibility"));
			printCountingMap.put("visibility", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("qualifiedName"));
			printCountingMap.put("qualifiedName", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("clientDependency"));
			printCountingMap.put("clientDependency", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("namespace"));
			printCountingMap.put("namespace", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("nameExpression"));
			printCountingMap.put("nameExpression", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("elementImport"));
			printCountingMap.put("elementImport", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("packageImport"));
			printCountingMap.put("packageImport", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedRule"));
			printCountingMap.put("ownedRule", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("member"));
			printCountingMap.put("member", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("importedMember"));
			printCountingMap.put("importedMember", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedMember"));
			printCountingMap.put("ownedMember", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("isLeaf"));
			printCountingMap.put("isLeaf", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("redefinedElement"));
			printCountingMap.put("redefinedElement", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("redefinitionContext"));
			printCountingMap.put("redefinitionContext", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("incoming"));
			printCountingMap.put("incoming", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("outgoing"));
			printCountingMap.put("outgoing", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("container"));
			printCountingMap.put("container", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("isComposite"));
			printCountingMap.put("isComposite", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("isOrthogonal"));
			printCountingMap.put("isOrthogonal", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("isSimple"));
			printCountingMap.put("isSimple", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("isSubmachineState"));
			printCountingMap.put("isSubmachineState", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("submachine"));
			printCountingMap.put("submachine", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("connection"));
			printCountingMap.put("connection", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("connectionPoint"));
			printCountingMap.put("connectionPoint", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("redefinedState"));
			printCountingMap.put("redefinedState", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("stateInvariant"));
			printCountingMap.put("stateInvariant", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("entry"));
			printCountingMap.put("entry", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("exit"));
			printCountingMap.put("exit", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("doActivity"));
			printCountingMap.put("doActivity", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("deferrableTrigger"));
			printCountingMap.put("deferrableTrigger", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("region"));
			printCountingMap.put("region", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("final");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("state");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("name");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("name"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				
				printCountingMap.put("name",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printFinalState_0(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			sWriter = new StringWriter();
			out1 = new PrintWriter(sWriter);
			printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printFinalState_1(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("do");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(":");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("doActivity");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("doActivity"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("doActivity",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printFinalState_1(FinalState element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("exit");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(":");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("exit");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("exit"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("exit",count-1);
			}
		}
		public void printFinalState_0(FinalState element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("entry");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(":");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("entry");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("entry"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("entry",count-1);
			}
		}
		public void printTransition(Transition element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(27);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("eAnnotations"));
			printCountingMap.put("eAnnotations", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedElement"));
			printCountingMap.put("ownedElement", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("owner"));
			printCountingMap.put("owner", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedComment"));
			printCountingMap.put("ownedComment", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("name"));
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("visibility"));
			printCountingMap.put("visibility", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("qualifiedName"));
			printCountingMap.put("qualifiedName", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("clientDependency"));
			printCountingMap.put("clientDependency", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("namespace"));
			printCountingMap.put("namespace", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("nameExpression"));
			printCountingMap.put("nameExpression", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("elementImport"));
			printCountingMap.put("elementImport", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("packageImport"));
			printCountingMap.put("packageImport", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedRule"));
			printCountingMap.put("ownedRule", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("member"));
			printCountingMap.put("member", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("importedMember"));
			printCountingMap.put("importedMember", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedMember"));
			printCountingMap.put("ownedMember", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("isLeaf"));
			printCountingMap.put("isLeaf", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("redefinedElement"));
			printCountingMap.put("redefinedElement", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("redefinitionContext"));
			printCountingMap.put("redefinitionContext", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("kind"));
			printCountingMap.put("kind", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("container"));
			printCountingMap.put("container", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("redefinedTransition"));
			printCountingMap.put("redefinedTransition", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("guard"));
			printCountingMap.put("guard", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("effect"));
			printCountingMap.put("effect", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("trigger"));
			printCountingMap.put("trigger", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("target"));
			printCountingMap.put("target", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("source"));
			printCountingMap.put("source", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("transition");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("from");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("source");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("source"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("source")),element.eClass().getEStructuralFeature("source"),element));
				printCountingMap.put("source",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("to");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("target");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("target"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("target")),element.eClass().getEStructuralFeature("target"),element));
				printCountingMap.put("target",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("when");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("trigger");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("trigger"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("trigger",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printTransition_0(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		public void printTransition_0(Transition element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("do");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(":");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("effect");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("effect"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("effect",count-1);
			}
		}
		public void printTrigger(Trigger element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(12);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("eAnnotations"));
			printCountingMap.put("eAnnotations", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedElement"));
			printCountingMap.put("ownedElement", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("owner"));
			printCountingMap.put("owner", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedComment"));
			printCountingMap.put("ownedComment", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("name"));
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("visibility"));
			printCountingMap.put("visibility", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("qualifiedName"));
			printCountingMap.put("qualifiedName", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("clientDependency"));
			printCountingMap.put("clientDependency", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("namespace"));
			printCountingMap.put("namespace", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("nameExpression"));
			printCountingMap.put("nameExpression", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("event"));
			printCountingMap.put("event", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("port"));
			printCountingMap.put("port", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("name");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("name"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				
				printCountingMap.put("name",count-1);
			}
		}
		public void printActivity(Activity element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(68);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("eAnnotations"));
			printCountingMap.put("eAnnotations", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedElement"));
			printCountingMap.put("ownedElement", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("owner"));
			printCountingMap.put("owner", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedComment"));
			printCountingMap.put("ownedComment", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("name"));
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("visibility"));
			printCountingMap.put("visibility", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("qualifiedName"));
			printCountingMap.put("qualifiedName", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("clientDependency"));
			printCountingMap.put("clientDependency", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("namespace"));
			printCountingMap.put("namespace", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("nameExpression"));
			printCountingMap.put("nameExpression", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("elementImport"));
			printCountingMap.put("elementImport", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("packageImport"));
			printCountingMap.put("packageImport", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedRule"));
			printCountingMap.put("ownedRule", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("member"));
			printCountingMap.put("member", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("importedMember"));
			printCountingMap.put("importedMember", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedMember"));
			printCountingMap.put("ownedMember", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("isLeaf"));
			printCountingMap.put("isLeaf", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("redefinedElement"));
			printCountingMap.put("redefinedElement", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("redefinitionContext"));
			printCountingMap.put("redefinitionContext", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("owningTemplateParameter"));
			printCountingMap.put("owningTemplateParameter", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("templateParameter"));
			printCountingMap.put("templateParameter", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("package"));
			printCountingMap.put("package", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("templateBinding"));
			printCountingMap.put("templateBinding", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedTemplateSignature"));
			printCountingMap.put("ownedTemplateSignature", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("isAbstract"));
			printCountingMap.put("isAbstract", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("generalization"));
			printCountingMap.put("generalization", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("powertypeExtent"));
			printCountingMap.put("powertypeExtent", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("feature"));
			printCountingMap.put("feature", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("inheritedMember"));
			printCountingMap.put("inheritedMember", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("redefinedClassifier"));
			printCountingMap.put("redefinedClassifier", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("general"));
			printCountingMap.put("general", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("substitution"));
			printCountingMap.put("substitution", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("attribute"));
			printCountingMap.put("attribute", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("representation"));
			printCountingMap.put("representation", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("collaborationUse"));
			printCountingMap.put("collaborationUse", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedUseCase"));
			printCountingMap.put("ownedUseCase", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("useCase"));
			printCountingMap.put("useCase", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedAttribute"));
			printCountingMap.put("ownedAttribute", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("part"));
			printCountingMap.put("part", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("role"));
			printCountingMap.put("role", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedConnector"));
			printCountingMap.put("ownedConnector", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedPort"));
			printCountingMap.put("ownedPort", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedBehavior"));
			printCountingMap.put("ownedBehavior", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("classifierBehavior"));
			printCountingMap.put("classifierBehavior", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("interfaceRealization"));
			printCountingMap.put("interfaceRealization", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedTrigger"));
			printCountingMap.put("ownedTrigger", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("nestedClassifier"));
			printCountingMap.put("nestedClassifier", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedOperation"));
			printCountingMap.put("ownedOperation", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("superClass"));
			printCountingMap.put("superClass", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("isActive"));
			printCountingMap.put("isActive", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedReception"));
			printCountingMap.put("ownedReception", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("extension"));
			printCountingMap.put("extension", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("isReentrant"));
			printCountingMap.put("isReentrant", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("redefinedBehavior"));
			printCountingMap.put("redefinedBehavior", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedParameter"));
			printCountingMap.put("ownedParameter", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("context"));
			printCountingMap.put("context", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("precondition"));
			printCountingMap.put("precondition", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("postcondition"));
			printCountingMap.put("postcondition", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("ownedParameterSet"));
			printCountingMap.put("ownedParameterSet", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("specification"));
			printCountingMap.put("specification", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("structuredNode"));
			printCountingMap.put("structuredNode", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("variable"));
			printCountingMap.put("variable", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("node"));
			printCountingMap.put("node", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("isReadOnly"));
			printCountingMap.put("isReadOnly", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("edge"));
			printCountingMap.put("edge", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("partition"));
			printCountingMap.put("partition", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("isSingleExecution"));
			printCountingMap.put("isSingleExecution", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("group"));
			printCountingMap.put("group", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("name");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("name"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				
				printCountingMap.put("name",count-1);
			}
		}
		}
