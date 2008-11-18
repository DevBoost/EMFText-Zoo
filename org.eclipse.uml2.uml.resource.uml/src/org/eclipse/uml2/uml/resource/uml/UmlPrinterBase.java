package org.eclipse.uml2.uml.resource.uml;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
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

public abstract class UmlPrinterBase extends EMFTextPrinterImpl {

	protected TokenResolverFactory tokenResolverFactory = new UmlTokenResolverFactory();
	protected EMFTextTreeAnalyser treeAnalyser = new UmlTreeAnalyser();

	public UmlPrinterBase(OutputStream o, TextResource resource) {

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
			temp = element.getEAnnotations();
			printCountingMap.put("eAnnotations", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwnedElement();
			printCountingMap.put("ownedElement", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwner();
			printCountingMap.put("owner", temp == null ? 0 : 1);
			temp = element.getOwnedComment();
			printCountingMap.put("ownedComment", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getName();
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.getVisibility();
			printCountingMap.put("visibility", temp == null ? 0 : 1);
			temp = element.getQualifiedName();
			printCountingMap.put("qualifiedName", temp == null ? 0 : 1);
			temp = element.getClientDependency();
			printCountingMap.put("clientDependency", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getNamespace();
			printCountingMap.put("namespace", temp == null ? 0 : 1);
			temp = element.getNameExpression();
			printCountingMap.put("nameExpression", temp == null ? 0 : 1);
			temp = element.getElementImport();
			printCountingMap.put("elementImport", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getPackageImport();
			printCountingMap.put("packageImport", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwnedRule();
			printCountingMap.put("ownedRule", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getMember();
			printCountingMap.put("member", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getImportedMember();
			printCountingMap.put("importedMember", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwnedMember();
			printCountingMap.put("ownedMember", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getIsLeaf();
			printCountingMap.put("isLeaf", temp == null ? 0 : 1);
			temp = element.getRedefinedElement();
			printCountingMap.put("redefinedElement", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getRedefinitionContext();
			printCountingMap.put("redefinitionContext", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwningTemplateParameter();
			printCountingMap.put("owningTemplateParameter", temp == null ? 0 : 1);
			temp = element.getTemplateParameter();
			printCountingMap.put("templateParameter", temp == null ? 0 : 1);
			temp = element.getPackage();
			printCountingMap.put("package", temp == null ? 0 : 1);
			temp = element.getTemplateBinding();
			printCountingMap.put("templateBinding", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwnedTemplateSignature();
			printCountingMap.put("ownedTemplateSignature", temp == null ? 0 : 1);
			temp = element.getIsAbstract();
			printCountingMap.put("isAbstract", temp == null ? 0 : 1);
			temp = element.getGeneralization();
			printCountingMap.put("generalization", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getPowertypeExtent();
			printCountingMap.put("powertypeExtent", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getFeature();
			printCountingMap.put("feature", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getInheritedMember();
			printCountingMap.put("inheritedMember", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getRedefinedClassifier();
			printCountingMap.put("redefinedClassifier", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getGeneral();
			printCountingMap.put("general", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getSubstitution();
			printCountingMap.put("substitution", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getAttribute();
			printCountingMap.put("attribute", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getRepresentation();
			printCountingMap.put("representation", temp == null ? 0 : 1);
			temp = element.getCollaborationUse();
			printCountingMap.put("collaborationUse", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwnedUseCase();
			printCountingMap.put("ownedUseCase", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getUseCase();
			printCountingMap.put("useCase", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwnedAttribute();
			printCountingMap.put("ownedAttribute", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getPart();
			printCountingMap.put("part", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getRole();
			printCountingMap.put("role", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwnedConnector();
			printCountingMap.put("ownedConnector", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwnedPort();
			printCountingMap.put("ownedPort", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwnedBehavior();
			printCountingMap.put("ownedBehavior", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getClassifierBehavior();
			printCountingMap.put("classifierBehavior", temp == null ? 0 : 1);
			temp = element.getInterfaceRealization();
			printCountingMap.put("interfaceRealization", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwnedTrigger();
			printCountingMap.put("ownedTrigger", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getNestedClassifier();
			printCountingMap.put("nestedClassifier", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwnedOperation();
			printCountingMap.put("ownedOperation", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getSuperClass();
			printCountingMap.put("superClass", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getIsActive();
			printCountingMap.put("isActive", temp == null ? 0 : 1);
			temp = element.getOwnedReception();
			printCountingMap.put("ownedReception", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getExtension();
			printCountingMap.put("extension", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getIsReentrant();
			printCountingMap.put("isReentrant", temp == null ? 0 : 1);
			temp = element.getRedefinedBehavior();
			printCountingMap.put("redefinedBehavior", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwnedParameter();
			printCountingMap.put("ownedParameter", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getContext();
			printCountingMap.put("context", temp == null ? 0 : 1);
			temp = element.getPrecondition();
			printCountingMap.put("precondition", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getPostcondition();
			printCountingMap.put("postcondition", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwnedParameterSet();
			printCountingMap.put("ownedParameterSet", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getSpecification();
			printCountingMap.put("specification", temp == null ? 0 : 1);
			temp = element.getRegion();
			printCountingMap.put("region", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getSubmachineState();
			printCountingMap.put("submachineState", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getConnectionPoint();
			printCountingMap.put("connectionPoint", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getExtendedStateMachine();
			printCountingMap.put("extendedStateMachine", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("StateMachine");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("name");
			if(count>0){
				Object o =element.getName();
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				
				printCountingMap.put("name",count-1);
			}
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("region");
			if(count>0){
				Object o =element.getRegion();
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("region",count-1);
			}
		}
		public void printRegion(Region element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(24);
			Object temp;
			temp = element.getEAnnotations();
			printCountingMap.put("eAnnotations", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwnedElement();
			printCountingMap.put("ownedElement", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwner();
			printCountingMap.put("owner", temp == null ? 0 : 1);
			temp = element.getOwnedComment();
			printCountingMap.put("ownedComment", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getName();
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.getVisibility();
			printCountingMap.put("visibility", temp == null ? 0 : 1);
			temp = element.getQualifiedName();
			printCountingMap.put("qualifiedName", temp == null ? 0 : 1);
			temp = element.getClientDependency();
			printCountingMap.put("clientDependency", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getNamespace();
			printCountingMap.put("namespace", temp == null ? 0 : 1);
			temp = element.getNameExpression();
			printCountingMap.put("nameExpression", temp == null ? 0 : 1);
			temp = element.getElementImport();
			printCountingMap.put("elementImport", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getPackageImport();
			printCountingMap.put("packageImport", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwnedRule();
			printCountingMap.put("ownedRule", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getMember();
			printCountingMap.put("member", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getImportedMember();
			printCountingMap.put("importedMember", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwnedMember();
			printCountingMap.put("ownedMember", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getIsLeaf();
			printCountingMap.put("isLeaf", temp == null ? 0 : 1);
			temp = element.getRedefinedElement();
			printCountingMap.put("redefinedElement", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getRedefinitionContext();
			printCountingMap.put("redefinitionContext", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getSubvertex();
			printCountingMap.put("subvertex", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getTransition();
			printCountingMap.put("transition", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getState();
			printCountingMap.put("state", temp == null ? 0 : 1);
			temp = element.getExtendedRegion();
			printCountingMap.put("extendedRegion", temp == null ? 0 : 1);
			temp = element.getStateMachine();
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
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("subvertex");
			if(count>0){
				Object o =element.getSubvertex();
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("subvertex",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(";");
		}
		public void printState(State element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(36);
			Object temp;
			temp = element.getEAnnotations();
			printCountingMap.put("eAnnotations", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwnedElement();
			printCountingMap.put("ownedElement", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwner();
			printCountingMap.put("owner", temp == null ? 0 : 1);
			temp = element.getOwnedComment();
			printCountingMap.put("ownedComment", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getName();
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.getVisibility();
			printCountingMap.put("visibility", temp == null ? 0 : 1);
			temp = element.getQualifiedName();
			printCountingMap.put("qualifiedName", temp == null ? 0 : 1);
			temp = element.getClientDependency();
			printCountingMap.put("clientDependency", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getNamespace();
			printCountingMap.put("namespace", temp == null ? 0 : 1);
			temp = element.getNameExpression();
			printCountingMap.put("nameExpression", temp == null ? 0 : 1);
			temp = element.getElementImport();
			printCountingMap.put("elementImport", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getPackageImport();
			printCountingMap.put("packageImport", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwnedRule();
			printCountingMap.put("ownedRule", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getMember();
			printCountingMap.put("member", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getImportedMember();
			printCountingMap.put("importedMember", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwnedMember();
			printCountingMap.put("ownedMember", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getIsLeaf();
			printCountingMap.put("isLeaf", temp == null ? 0 : 1);
			temp = element.getRedefinedElement();
			printCountingMap.put("redefinedElement", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getRedefinitionContext();
			printCountingMap.put("redefinitionContext", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getIncoming();
			printCountingMap.put("incoming", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOutgoing();
			printCountingMap.put("outgoing", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getContainer();
			printCountingMap.put("container", temp == null ? 0 : 1);
			temp = element.getIsComposite();
			printCountingMap.put("isComposite", temp == null ? 0 : 1);
			temp = element.getIsOrthogonal();
			printCountingMap.put("isOrthogonal", temp == null ? 0 : 1);
			temp = element.getIsSimple();
			printCountingMap.put("isSimple", temp == null ? 0 : 1);
			temp = element.getIsSubmachineState();
			printCountingMap.put("isSubmachineState", temp == null ? 0 : 1);
			temp = element.getSubmachine();
			printCountingMap.put("submachine", temp == null ? 0 : 1);
			temp = element.getConnection();
			printCountingMap.put("connection", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getConnectionPoint();
			printCountingMap.put("connectionPoint", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getRedefinedState();
			printCountingMap.put("redefinedState", temp == null ? 0 : 1);
			temp = element.getStateInvariant();
			printCountingMap.put("stateInvariant", temp == null ? 0 : 1);
			temp = element.getEntry();
			printCountingMap.put("entry", temp == null ? 0 : 1);
			temp = element.getExit();
			printCountingMap.put("exit", temp == null ? 0 : 1);
			temp = element.getDoActivity();
			printCountingMap.put("doActivity", temp == null ? 0 : 1);
			temp = element.getDeferrableTrigger();
			printCountingMap.put("deferrableTrigger", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getRegion();
			printCountingMap.put("region", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("state");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("name");
			if(count>0){
				Object o =element.getName();
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
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
				Object o =element.getDoActivity();
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("doActivity",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
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
				Object o =element.getExit();
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("exit",count-1);
			}
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
				Object o =element.getEntry();
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("entry",count-1);
			}
		}
		public void printFinalState(FinalState element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(36);
			Object temp;
			temp = element.getEAnnotations();
			printCountingMap.put("eAnnotations", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwnedElement();
			printCountingMap.put("ownedElement", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwner();
			printCountingMap.put("owner", temp == null ? 0 : 1);
			temp = element.getOwnedComment();
			printCountingMap.put("ownedComment", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getName();
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.getVisibility();
			printCountingMap.put("visibility", temp == null ? 0 : 1);
			temp = element.getQualifiedName();
			printCountingMap.put("qualifiedName", temp == null ? 0 : 1);
			temp = element.getClientDependency();
			printCountingMap.put("clientDependency", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getNamespace();
			printCountingMap.put("namespace", temp == null ? 0 : 1);
			temp = element.getNameExpression();
			printCountingMap.put("nameExpression", temp == null ? 0 : 1);
			temp = element.getElementImport();
			printCountingMap.put("elementImport", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getPackageImport();
			printCountingMap.put("packageImport", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwnedRule();
			printCountingMap.put("ownedRule", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getMember();
			printCountingMap.put("member", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getImportedMember();
			printCountingMap.put("importedMember", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwnedMember();
			printCountingMap.put("ownedMember", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getIsLeaf();
			printCountingMap.put("isLeaf", temp == null ? 0 : 1);
			temp = element.getRedefinedElement();
			printCountingMap.put("redefinedElement", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getRedefinitionContext();
			printCountingMap.put("redefinitionContext", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getIncoming();
			printCountingMap.put("incoming", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOutgoing();
			printCountingMap.put("outgoing", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getContainer();
			printCountingMap.put("container", temp == null ? 0 : 1);
			temp = element.getIsComposite();
			printCountingMap.put("isComposite", temp == null ? 0 : 1);
			temp = element.getIsOrthogonal();
			printCountingMap.put("isOrthogonal", temp == null ? 0 : 1);
			temp = element.getIsSimple();
			printCountingMap.put("isSimple", temp == null ? 0 : 1);
			temp = element.getIsSubmachineState();
			printCountingMap.put("isSubmachineState", temp == null ? 0 : 1);
			temp = element.getSubmachine();
			printCountingMap.put("submachine", temp == null ? 0 : 1);
			temp = element.getConnection();
			printCountingMap.put("connection", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getConnectionPoint();
			printCountingMap.put("connectionPoint", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getRedefinedState();
			printCountingMap.put("redefinedState", temp == null ? 0 : 1);
			temp = element.getStateInvariant();
			printCountingMap.put("stateInvariant", temp == null ? 0 : 1);
			temp = element.getEntry();
			printCountingMap.put("entry", temp == null ? 0 : 1);
			temp = element.getExit();
			printCountingMap.put("exit", temp == null ? 0 : 1);
			temp = element.getDoActivity();
			printCountingMap.put("doActivity", temp == null ? 0 : 1);
			temp = element.getDeferrableTrigger();
			printCountingMap.put("deferrableTrigger", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getRegion();
			printCountingMap.put("region", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("final");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("state");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("name");
			if(count>0){
				Object o =element.getName();
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
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
				Object o =element.getDoActivity();
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("doActivity",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
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
				Object o =element.getEntry();
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("entry",count-1);
			}
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
				Object o =element.getExit();
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("exit",count-1);
			}
		}
		public void printTransition(Transition element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(27);
			Object temp;
			temp = element.getEAnnotations();
			printCountingMap.put("eAnnotations", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwnedElement();
			printCountingMap.put("ownedElement", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwner();
			printCountingMap.put("owner", temp == null ? 0 : 1);
			temp = element.getOwnedComment();
			printCountingMap.put("ownedComment", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getName();
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.getVisibility();
			printCountingMap.put("visibility", temp == null ? 0 : 1);
			temp = element.getQualifiedName();
			printCountingMap.put("qualifiedName", temp == null ? 0 : 1);
			temp = element.getClientDependency();
			printCountingMap.put("clientDependency", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getNamespace();
			printCountingMap.put("namespace", temp == null ? 0 : 1);
			temp = element.getNameExpression();
			printCountingMap.put("nameExpression", temp == null ? 0 : 1);
			temp = element.getElementImport();
			printCountingMap.put("elementImport", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getPackageImport();
			printCountingMap.put("packageImport", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwnedRule();
			printCountingMap.put("ownedRule", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getMember();
			printCountingMap.put("member", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getImportedMember();
			printCountingMap.put("importedMember", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwnedMember();
			printCountingMap.put("ownedMember", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getIsLeaf();
			printCountingMap.put("isLeaf", temp == null ? 0 : 1);
			temp = element.getRedefinedElement();
			printCountingMap.put("redefinedElement", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getRedefinitionContext();
			printCountingMap.put("redefinitionContext", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getKind();
			printCountingMap.put("kind", temp == null ? 0 : 1);
			temp = element.getContainer();
			printCountingMap.put("container", temp == null ? 0 : 1);
			temp = element.getRedefinedTransition();
			printCountingMap.put("redefinedTransition", temp == null ? 0 : 1);
			temp = element.getGuard();
			printCountingMap.put("guard", temp == null ? 0 : 1);
			temp = element.getEffect();
			printCountingMap.put("effect", temp == null ? 0 : 1);
			temp = element.getTrigger();
			printCountingMap.put("trigger", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getTarget();
			printCountingMap.put("target", temp == null ? 0 : 1);
			temp = element.getSource();
			printCountingMap.put("source", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("transition");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("from");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("source");
			if(count>0){
				Object o =element.getSource();
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("source")),element.eClass().getEStructuralFeature("source"),element));
				printCountingMap.put("source",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("to");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("target");
			if(count>0){
				Object o =element.getTarget();
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("target")),element.eClass().getEStructuralFeature("target"),element));
				printCountingMap.put("target",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("when");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("trigger");
			if(count>0){
				Object o =element.getTrigger();
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("trigger",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("do");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("effect");
			if(count>0){
				Object o =element.getEffect();
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("effect",count-1);
			}
		}
		public void printTrigger(Trigger element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(12);
			Object temp;
			temp = element.getEAnnotations();
			printCountingMap.put("eAnnotations", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwnedElement();
			printCountingMap.put("ownedElement", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwner();
			printCountingMap.put("owner", temp == null ? 0 : 1);
			temp = element.getOwnedComment();
			printCountingMap.put("ownedComment", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getName();
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.getVisibility();
			printCountingMap.put("visibility", temp == null ? 0 : 1);
			temp = element.getQualifiedName();
			printCountingMap.put("qualifiedName", temp == null ? 0 : 1);
			temp = element.getClientDependency();
			printCountingMap.put("clientDependency", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getNamespace();
			printCountingMap.put("namespace", temp == null ? 0 : 1);
			temp = element.getNameExpression();
			printCountingMap.put("nameExpression", temp == null ? 0 : 1);
			temp = element.getEvent();
			printCountingMap.put("event", temp == null ? 0 : 1);
			temp = element.getPort();
			printCountingMap.put("port", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("name");
			if(count>0){
				Object o =element.getName();
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
			temp = element.getEAnnotations();
			printCountingMap.put("eAnnotations", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwnedElement();
			printCountingMap.put("ownedElement", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwner();
			printCountingMap.put("owner", temp == null ? 0 : 1);
			temp = element.getOwnedComment();
			printCountingMap.put("ownedComment", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getName();
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.getVisibility();
			printCountingMap.put("visibility", temp == null ? 0 : 1);
			temp = element.getQualifiedName();
			printCountingMap.put("qualifiedName", temp == null ? 0 : 1);
			temp = element.getClientDependency();
			printCountingMap.put("clientDependency", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getNamespace();
			printCountingMap.put("namespace", temp == null ? 0 : 1);
			temp = element.getNameExpression();
			printCountingMap.put("nameExpression", temp == null ? 0 : 1);
			temp = element.getElementImport();
			printCountingMap.put("elementImport", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getPackageImport();
			printCountingMap.put("packageImport", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwnedRule();
			printCountingMap.put("ownedRule", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getMember();
			printCountingMap.put("member", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getImportedMember();
			printCountingMap.put("importedMember", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwnedMember();
			printCountingMap.put("ownedMember", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getIsLeaf();
			printCountingMap.put("isLeaf", temp == null ? 0 : 1);
			temp = element.getRedefinedElement();
			printCountingMap.put("redefinedElement", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getRedefinitionContext();
			printCountingMap.put("redefinitionContext", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwningTemplateParameter();
			printCountingMap.put("owningTemplateParameter", temp == null ? 0 : 1);
			temp = element.getTemplateParameter();
			printCountingMap.put("templateParameter", temp == null ? 0 : 1);
			temp = element.getPackage();
			printCountingMap.put("package", temp == null ? 0 : 1);
			temp = element.getTemplateBinding();
			printCountingMap.put("templateBinding", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwnedTemplateSignature();
			printCountingMap.put("ownedTemplateSignature", temp == null ? 0 : 1);
			temp = element.getIsAbstract();
			printCountingMap.put("isAbstract", temp == null ? 0 : 1);
			temp = element.getGeneralization();
			printCountingMap.put("generalization", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getPowertypeExtent();
			printCountingMap.put("powertypeExtent", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getFeature();
			printCountingMap.put("feature", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getInheritedMember();
			printCountingMap.put("inheritedMember", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getRedefinedClassifier();
			printCountingMap.put("redefinedClassifier", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getGeneral();
			printCountingMap.put("general", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getSubstitution();
			printCountingMap.put("substitution", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getAttribute();
			printCountingMap.put("attribute", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getRepresentation();
			printCountingMap.put("representation", temp == null ? 0 : 1);
			temp = element.getCollaborationUse();
			printCountingMap.put("collaborationUse", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwnedUseCase();
			printCountingMap.put("ownedUseCase", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getUseCase();
			printCountingMap.put("useCase", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwnedAttribute();
			printCountingMap.put("ownedAttribute", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getPart();
			printCountingMap.put("part", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getRole();
			printCountingMap.put("role", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwnedConnector();
			printCountingMap.put("ownedConnector", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwnedPort();
			printCountingMap.put("ownedPort", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwnedBehavior();
			printCountingMap.put("ownedBehavior", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getClassifierBehavior();
			printCountingMap.put("classifierBehavior", temp == null ? 0 : 1);
			temp = element.getInterfaceRealization();
			printCountingMap.put("interfaceRealization", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwnedTrigger();
			printCountingMap.put("ownedTrigger", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getNestedClassifier();
			printCountingMap.put("nestedClassifier", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwnedOperation();
			printCountingMap.put("ownedOperation", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getSuperClass();
			printCountingMap.put("superClass", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getIsActive();
			printCountingMap.put("isActive", temp == null ? 0 : 1);
			temp = element.getOwnedReception();
			printCountingMap.put("ownedReception", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getExtension();
			printCountingMap.put("extension", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getIsReentrant();
			printCountingMap.put("isReentrant", temp == null ? 0 : 1);
			temp = element.getRedefinedBehavior();
			printCountingMap.put("redefinedBehavior", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwnedParameter();
			printCountingMap.put("ownedParameter", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getContext();
			printCountingMap.put("context", temp == null ? 0 : 1);
			temp = element.getPrecondition();
			printCountingMap.put("precondition", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getPostcondition();
			printCountingMap.put("postcondition", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getOwnedParameterSet();
			printCountingMap.put("ownedParameterSet", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getSpecification();
			printCountingMap.put("specification", temp == null ? 0 : 1);
			temp = element.getStructuredNode();
			printCountingMap.put("structuredNode", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getVariable();
			printCountingMap.put("variable", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getNode();
			printCountingMap.put("node", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getIsReadOnly();
			printCountingMap.put("isReadOnly", temp == null ? 0 : 1);
			temp = element.getEdge();
			printCountingMap.put("edge", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getPartition();
			printCountingMap.put("partition", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.getIsSingleExecution();
			printCountingMap.put("isSingleExecution", temp == null ? 0 : 1);
			temp = element.getGroup();
			printCountingMap.put("group", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("name");
			if(count>0){
				Object o =element.getName();
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				
				printCountingMap.put("name",count-1);
			}
		}
		}
