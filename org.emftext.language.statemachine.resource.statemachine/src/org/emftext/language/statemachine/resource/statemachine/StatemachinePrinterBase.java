package org.emftext.language.statemachine.resource.statemachine;

public abstract class StatemachinePrinterBase extends org.emftext.runtime.resource.impl.AbstractEMFTextPrinter {
	
	protected org.emftext.runtime.resource.ITokenResolverFactory tokenResolverFactory = new StatemachineTokenResolverFactory();
	
	public StatemachinePrinterBase(java.io.OutputStream o, org.emftext.runtime.resource.ITextResource resource) {
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
		
		if (element instanceof org.eclipse.uml2.uml.StateMachine) {
			print_org_eclipse_uml2_uml_StateMachine((org.eclipse.uml2.uml.StateMachine) element, globaltab, out);
			return;
		}
		if (element instanceof org.eclipse.uml2.uml.Region) {
			print_org_eclipse_uml2_uml_Region((org.eclipse.uml2.uml.Region) element, globaltab, out);
			return;
		}
		if (element instanceof org.eclipse.uml2.uml.Pseudostate) {
			print_org_eclipse_uml2_uml_Pseudostate((org.eclipse.uml2.uml.Pseudostate) element, globaltab, out);
			return;
		}
		if (element instanceof org.eclipse.uml2.uml.FinalState) {
			print_org_eclipse_uml2_uml_FinalState((org.eclipse.uml2.uml.FinalState) element, globaltab, out);
			return;
		}
		if (element instanceof org.eclipse.uml2.uml.Transition) {
			print_org_eclipse_uml2_uml_Transition((org.eclipse.uml2.uml.Transition) element, globaltab, out);
			return;
		}
		if (element instanceof org.eclipse.uml2.uml.Trigger) {
			print_org_eclipse_uml2_uml_Trigger((org.eclipse.uml2.uml.Trigger) element, globaltab, out);
			return;
		}
		if (element instanceof org.eclipse.uml2.uml.Activity) {
			print_org_eclipse_uml2_uml_Activity((org.eclipse.uml2.uml.Activity) element, globaltab, out);
			return;
		}
		if (element instanceof org.eclipse.uml2.uml.State) {
			print_org_eclipse_uml2_uml_State((org.eclipse.uml2.uml.State) element, globaltab, out);
			return;
		}
		
		resource.addWarning("The cs printer can not handle " + element.eClass().getName() + " elements", element);
	}
	
	public void print_org_eclipse_uml2_uml_StateMachine(org.eclipse.uml2.uml.StateMachine element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(64);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__EANNOTATIONS));
		printCountingMap.put("eAnnotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__OWNED_ELEMENT));
		printCountingMap.put("ownedElement", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__OWNER));
		printCountingMap.put("owner", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__OWNED_COMMENT));
		printCountingMap.put("ownedComment", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__VISIBILITY));
		printCountingMap.put("visibility", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__QUALIFIED_NAME));
		printCountingMap.put("qualifiedName", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__CLIENT_DEPENDENCY));
		printCountingMap.put("clientDependency", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__NAMESPACE));
		printCountingMap.put("namespace", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__NAME_EXPRESSION));
		printCountingMap.put("nameExpression", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__ELEMENT_IMPORT));
		printCountingMap.put("elementImport", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__PACKAGE_IMPORT));
		printCountingMap.put("packageImport", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__OWNED_RULE));
		printCountingMap.put("ownedRule", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__MEMBER));
		printCountingMap.put("member", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__IMPORTED_MEMBER));
		printCountingMap.put("importedMember", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__OWNED_MEMBER));
		printCountingMap.put("ownedMember", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__IS_LEAF));
		printCountingMap.put("isLeaf", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__REDEFINED_ELEMENT));
		printCountingMap.put("redefinedElement", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__REDEFINITION_CONTEXT));
		printCountingMap.put("redefinitionContext", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__OWNING_TEMPLATE_PARAMETER));
		printCountingMap.put("owningTemplateParameter", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__TEMPLATE_PARAMETER));
		printCountingMap.put("templateParameter", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__PACKAGE));
		printCountingMap.put("package", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__TEMPLATE_BINDING));
		printCountingMap.put("templateBinding", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__OWNED_TEMPLATE_SIGNATURE));
		printCountingMap.put("ownedTemplateSignature", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__IS_ABSTRACT));
		printCountingMap.put("isAbstract", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__GENERALIZATION));
		printCountingMap.put("generalization", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__POWERTYPE_EXTENT));
		printCountingMap.put("powertypeExtent", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__FEATURE));
		printCountingMap.put("feature", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__INHERITED_MEMBER));
		printCountingMap.put("inheritedMember", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__REDEFINED_CLASSIFIER));
		printCountingMap.put("redefinedClassifier", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__GENERAL));
		printCountingMap.put("general", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__SUBSTITUTION));
		printCountingMap.put("substitution", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__ATTRIBUTE));
		printCountingMap.put("attribute", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__REPRESENTATION));
		printCountingMap.put("representation", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__COLLABORATION_USE));
		printCountingMap.put("collaborationUse", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__OWNED_USE_CASE));
		printCountingMap.put("ownedUseCase", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__USE_CASE));
		printCountingMap.put("useCase", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__OWNED_ATTRIBUTE));
		printCountingMap.put("ownedAttribute", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__PART));
		printCountingMap.put("part", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__ROLE));
		printCountingMap.put("role", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__OWNED_CONNECTOR));
		printCountingMap.put("ownedConnector", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__OWNED_PORT));
		printCountingMap.put("ownedPort", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__OWNED_BEHAVIOR));
		printCountingMap.put("ownedBehavior", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__CLASSIFIER_BEHAVIOR));
		printCountingMap.put("classifierBehavior", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__INTERFACE_REALIZATION));
		printCountingMap.put("interfaceRealization", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__OWNED_TRIGGER));
		printCountingMap.put("ownedTrigger", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__NESTED_CLASSIFIER));
		printCountingMap.put("nestedClassifier", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__OWNED_OPERATION));
		printCountingMap.put("ownedOperation", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__SUPER_CLASS));
		printCountingMap.put("superClass", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__IS_ACTIVE));
		printCountingMap.put("isActive", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__OWNED_RECEPTION));
		printCountingMap.put("ownedReception", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__EXTENSION));
		printCountingMap.put("extension", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__IS_REENTRANT));
		printCountingMap.put("isReentrant", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__REDEFINED_BEHAVIOR));
		printCountingMap.put("redefinedBehavior", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__OWNED_PARAMETER));
		printCountingMap.put("ownedParameter", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__CONTEXT));
		printCountingMap.put("context", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__PRECONDITION));
		printCountingMap.put("precondition", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__POSTCONDITION));
		printCountingMap.put("postcondition", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__OWNED_PARAMETER_SET));
		printCountingMap.put("ownedParameterSet", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__SPECIFICATION));
		printCountingMap.put("specification", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__REGION));
		printCountingMap.put("region", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__SUBMACHINE_STATE));
		printCountingMap.put("submachineState", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__CONNECTION_POINT));
		printCountingMap.put("connectionPoint", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__EXTENDED_STATE_MACHINE));
		printCountingMap.put("extendedStateMachine", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("StateMachine");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (PlaceholderUsingDefaultToken):
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__NAME));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__NAME), element));
			out.print(" ");
			printCountingMap.put("name",count-1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("{");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("region");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE_MACHINE__REGION));
			o = ((java.util.List<?>)o).get(((java.util.List<?>)o).size() - count);
			doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			printCountingMap.put("region",count-1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("}");
		out.print(" ");
	}
	
	public void print_org_eclipse_uml2_uml_Region(org.eclipse.uml2.uml.Region element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(24);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.REGION__EANNOTATIONS));
		printCountingMap.put("eAnnotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.REGION__OWNED_ELEMENT));
		printCountingMap.put("ownedElement", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.REGION__OWNER));
		printCountingMap.put("owner", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.REGION__OWNED_COMMENT));
		printCountingMap.put("ownedComment", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.REGION__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.REGION__VISIBILITY));
		printCountingMap.put("visibility", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.REGION__QUALIFIED_NAME));
		printCountingMap.put("qualifiedName", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.REGION__CLIENT_DEPENDENCY));
		printCountingMap.put("clientDependency", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.REGION__NAMESPACE));
		printCountingMap.put("namespace", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.REGION__NAME_EXPRESSION));
		printCountingMap.put("nameExpression", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.REGION__ELEMENT_IMPORT));
		printCountingMap.put("elementImport", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.REGION__PACKAGE_IMPORT));
		printCountingMap.put("packageImport", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.REGION__OWNED_RULE));
		printCountingMap.put("ownedRule", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.REGION__MEMBER));
		printCountingMap.put("member", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.REGION__IMPORTED_MEMBER));
		printCountingMap.put("importedMember", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.REGION__OWNED_MEMBER));
		printCountingMap.put("ownedMember", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.REGION__IS_LEAF));
		printCountingMap.put("isLeaf", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.REGION__REDEFINED_ELEMENT));
		printCountingMap.put("redefinedElement", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.REGION__REDEFINITION_CONTEXT));
		printCountingMap.put("redefinitionContext", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.REGION__SUBVERTEX));
		printCountingMap.put("subvertex", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.REGION__TRANSITION));
		printCountingMap.put("transition", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.REGION__STATE));
		printCountingMap.put("state", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.REGION__EXTENDED_REGION));
		printCountingMap.put("extendedRegion", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.REGION__STATE_MACHINE));
		printCountingMap.put("stateMachine", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("subvertex");
		if (count > 0) {
			java.util.ListIterator<?> it  = ((java.util.List<?>) element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.REGION__SUBVERTEX))).listIterator(((java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.REGION__SUBVERTEX))).size()-count);
			while(it.hasNext()){
				java.lang.Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("subvertex",0);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("transitions");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("{");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("transition");
		if (count > 0) {
			java.util.ListIterator<?> it  = ((java.util.List<?>) element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.REGION__TRANSITION))).listIterator(((java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.REGION__TRANSITION))).size()-count);
			while(it.hasNext()){
				java.lang.Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("transition",0);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("}");
		out.print(" ");
	}
	
	public void print_org_eclipse_uml2_uml_State(org.eclipse.uml2.uml.State element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(36);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__EANNOTATIONS));
		printCountingMap.put("eAnnotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__OWNED_ELEMENT));
		printCountingMap.put("ownedElement", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__OWNER));
		printCountingMap.put("owner", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__OWNED_COMMENT));
		printCountingMap.put("ownedComment", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__VISIBILITY));
		printCountingMap.put("visibility", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__QUALIFIED_NAME));
		printCountingMap.put("qualifiedName", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__CLIENT_DEPENDENCY));
		printCountingMap.put("clientDependency", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__NAMESPACE));
		printCountingMap.put("namespace", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__NAME_EXPRESSION));
		printCountingMap.put("nameExpression", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__ELEMENT_IMPORT));
		printCountingMap.put("elementImport", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__PACKAGE_IMPORT));
		printCountingMap.put("packageImport", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__OWNED_RULE));
		printCountingMap.put("ownedRule", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__MEMBER));
		printCountingMap.put("member", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__IMPORTED_MEMBER));
		printCountingMap.put("importedMember", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__OWNED_MEMBER));
		printCountingMap.put("ownedMember", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__IS_LEAF));
		printCountingMap.put("isLeaf", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__REDEFINED_ELEMENT));
		printCountingMap.put("redefinedElement", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__REDEFINITION_CONTEXT));
		printCountingMap.put("redefinitionContext", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__INCOMING));
		printCountingMap.put("incoming", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__OUTGOING));
		printCountingMap.put("outgoing", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__CONTAINER));
		printCountingMap.put("container", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__IS_COMPOSITE));
		printCountingMap.put("isComposite", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__IS_ORTHOGONAL));
		printCountingMap.put("isOrthogonal", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__IS_SIMPLE));
		printCountingMap.put("isSimple", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__IS_SUBMACHINE_STATE));
		printCountingMap.put("isSubmachineState", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__SUBMACHINE));
		printCountingMap.put("submachine", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__CONNECTION));
		printCountingMap.put("connection", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__CONNECTION_POINT));
		printCountingMap.put("connectionPoint", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__REDEFINED_STATE));
		printCountingMap.put("redefinedState", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__STATE_INVARIANT));
		printCountingMap.put("stateInvariant", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__ENTRY));
		printCountingMap.put("entry", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__EXIT));
		printCountingMap.put("exit", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__DO_ACTIVITY));
		printCountingMap.put("doActivity", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__DEFERRABLE_TRIGGER));
		printCountingMap.put("deferrableTrigger", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__REGION));
		printCountingMap.put("region", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = null;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("state");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (PlaceholderUsingDefaultToken):
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__NAME));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__NAME), element));
			out.print(" ");
			printCountingMap.put("name",count-1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("{");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_eclipse_uml2_uml_State_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_eclipse_uml2_uml_State_1(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("do");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (CsString):
		out.print(":");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("doActivity");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__DO_ACTIVITY));
			doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			printCountingMap.put("doActivity",count-1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("}");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (CsString):
		out.print(";");
		out.print(" ");
	}
	public void print_org_eclipse_uml2_uml_State_1(org.eclipse.uml2.uml.State element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("exit");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (CsString):
		out.print(":");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("exit");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__EXIT));
			doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			printCountingMap.put("exit",count-1);
		}
	}
	public void print_org_eclipse_uml2_uml_State_0(org.eclipse.uml2.uml.State element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("entry");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (CsString):
		out.print(":");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("entry");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.STATE__ENTRY));
			doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			printCountingMap.put("entry",count-1);
		}
	}
	
	public void print_org_eclipse_uml2_uml_Pseudostate(org.eclipse.uml2.uml.Pseudostate element, java.lang.String outertab, java.io.PrintWriter out) {
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(16);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.PSEUDOSTATE__EANNOTATIONS));
		printCountingMap.put("eAnnotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.PSEUDOSTATE__OWNED_ELEMENT));
		printCountingMap.put("ownedElement", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.PSEUDOSTATE__OWNER));
		printCountingMap.put("owner", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.PSEUDOSTATE__OWNED_COMMENT));
		printCountingMap.put("ownedComment", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.PSEUDOSTATE__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.PSEUDOSTATE__VISIBILITY));
		printCountingMap.put("visibility", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.PSEUDOSTATE__QUALIFIED_NAME));
		printCountingMap.put("qualifiedName", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.PSEUDOSTATE__CLIENT_DEPENDENCY));
		printCountingMap.put("clientDependency", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.PSEUDOSTATE__NAMESPACE));
		printCountingMap.put("namespace", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.PSEUDOSTATE__NAME_EXPRESSION));
		printCountingMap.put("nameExpression", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.PSEUDOSTATE__INCOMING));
		printCountingMap.put("incoming", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.PSEUDOSTATE__OUTGOING));
		printCountingMap.put("outgoing", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.PSEUDOSTATE__CONTAINER));
		printCountingMap.put("container", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.PSEUDOSTATE__KIND));
		printCountingMap.put("kind", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.PSEUDOSTATE__STATE_MACHINE));
		printCountingMap.put("stateMachine", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.PSEUDOSTATE__STATE));
		printCountingMap.put("state", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken):
		count = printCountingMap.get("kind");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.PSEUDOSTATE__KIND));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("PSEUDOKIND");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.PSEUDOSTATE__KIND), element));
			out.print(" ");
			printCountingMap.put("kind",count-1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("state");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (PlaceholderUsingDefaultToken):
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.PSEUDOSTATE__NAME));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.PSEUDOSTATE__NAME), element));
			out.print(" ");
			printCountingMap.put("name",count-1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print(";");
		out.print(" ");
	}
	
	public void print_org_eclipse_uml2_uml_FinalState(org.eclipse.uml2.uml.FinalState element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(36);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__EANNOTATIONS));
		printCountingMap.put("eAnnotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__OWNED_ELEMENT));
		printCountingMap.put("ownedElement", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__OWNER));
		printCountingMap.put("owner", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__OWNED_COMMENT));
		printCountingMap.put("ownedComment", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__VISIBILITY));
		printCountingMap.put("visibility", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__QUALIFIED_NAME));
		printCountingMap.put("qualifiedName", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__CLIENT_DEPENDENCY));
		printCountingMap.put("clientDependency", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__NAMESPACE));
		printCountingMap.put("namespace", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__NAME_EXPRESSION));
		printCountingMap.put("nameExpression", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__ELEMENT_IMPORT));
		printCountingMap.put("elementImport", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__PACKAGE_IMPORT));
		printCountingMap.put("packageImport", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__OWNED_RULE));
		printCountingMap.put("ownedRule", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__MEMBER));
		printCountingMap.put("member", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__IMPORTED_MEMBER));
		printCountingMap.put("importedMember", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__OWNED_MEMBER));
		printCountingMap.put("ownedMember", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__IS_LEAF));
		printCountingMap.put("isLeaf", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__REDEFINED_ELEMENT));
		printCountingMap.put("redefinedElement", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__REDEFINITION_CONTEXT));
		printCountingMap.put("redefinitionContext", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__INCOMING));
		printCountingMap.put("incoming", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__OUTGOING));
		printCountingMap.put("outgoing", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__CONTAINER));
		printCountingMap.put("container", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__IS_COMPOSITE));
		printCountingMap.put("isComposite", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__IS_ORTHOGONAL));
		printCountingMap.put("isOrthogonal", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__IS_SIMPLE));
		printCountingMap.put("isSimple", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__IS_SUBMACHINE_STATE));
		printCountingMap.put("isSubmachineState", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__SUBMACHINE));
		printCountingMap.put("submachine", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__CONNECTION));
		printCountingMap.put("connection", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__CONNECTION_POINT));
		printCountingMap.put("connectionPoint", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__REDEFINED_STATE));
		printCountingMap.put("redefinedState", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__STATE_INVARIANT));
		printCountingMap.put("stateInvariant", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__ENTRY));
		printCountingMap.put("entry", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__EXIT));
		printCountingMap.put("exit", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__DO_ACTIVITY));
		printCountingMap.put("doActivity", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__DEFERRABLE_TRIGGER));
		printCountingMap.put("deferrableTrigger", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__REGION));
		printCountingMap.put("region", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = null;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("final");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("state");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (PlaceholderUsingDefaultToken):
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__NAME));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__NAME), element));
			out.print(" ");
			printCountingMap.put("name",count-1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("{");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_eclipse_uml2_uml_FinalState_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_eclipse_uml2_uml_FinalState_1(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("do");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (CsString):
		out.print(":");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("doActivity");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__DO_ACTIVITY));
			doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			printCountingMap.put("doActivity",count-1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("}");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (CsString):
		out.print(";");
		out.print(" ");
	}
	public void print_org_eclipse_uml2_uml_FinalState_1(org.eclipse.uml2.uml.FinalState element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("exit");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (CsString):
		out.print(":");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("exit");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__EXIT));
			doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			printCountingMap.put("exit",count-1);
		}
	}
	public void print_org_eclipse_uml2_uml_FinalState_0(org.eclipse.uml2.uml.FinalState element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("entry");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (CsString):
		out.print(":");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("entry");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.FINAL_STATE__ENTRY));
			doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			printCountingMap.put("entry",count-1);
		}
	}
	
	public void print_org_eclipse_uml2_uml_Transition(org.eclipse.uml2.uml.Transition element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(27);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__EANNOTATIONS));
		printCountingMap.put("eAnnotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__OWNED_ELEMENT));
		printCountingMap.put("ownedElement", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__OWNER));
		printCountingMap.put("owner", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__OWNED_COMMENT));
		printCountingMap.put("ownedComment", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__VISIBILITY));
		printCountingMap.put("visibility", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__QUALIFIED_NAME));
		printCountingMap.put("qualifiedName", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__CLIENT_DEPENDENCY));
		printCountingMap.put("clientDependency", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__NAMESPACE));
		printCountingMap.put("namespace", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__NAME_EXPRESSION));
		printCountingMap.put("nameExpression", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__ELEMENT_IMPORT));
		printCountingMap.put("elementImport", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__PACKAGE_IMPORT));
		printCountingMap.put("packageImport", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__OWNED_RULE));
		printCountingMap.put("ownedRule", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__MEMBER));
		printCountingMap.put("member", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__IMPORTED_MEMBER));
		printCountingMap.put("importedMember", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__OWNED_MEMBER));
		printCountingMap.put("ownedMember", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__IS_LEAF));
		printCountingMap.put("isLeaf", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__REDEFINED_ELEMENT));
		printCountingMap.put("redefinedElement", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__REDEFINITION_CONTEXT));
		printCountingMap.put("redefinitionContext", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__KIND));
		printCountingMap.put("kind", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__CONTAINER));
		printCountingMap.put("container", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__REDEFINED_TRANSITION));
		printCountingMap.put("redefinedTransition", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__GUARD));
		printCountingMap.put("guard", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__EFFECT));
		printCountingMap.put("effect", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__TRIGGER));
		printCountingMap.put("trigger", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__TARGET));
		printCountingMap.put("target", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__SOURCE));
		printCountingMap.put("source", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = null;
		//////////////DEFINITION PART BEGINS (PlaceholderUsingDefaultToken):
		count = printCountingMap.get("source");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__SOURCE));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve(((org.emftext.language.statemachine.resource.statemachine.StatemachineReferenceResolverSwitch) resource.getReferenceResolverSwitch()).getTransitionSourceReferenceResolver().deResolve((org.eclipse.uml2.uml.Vertex) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__SOURCE)), element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__SOURCE), element));
			out.print(" ");
			printCountingMap.put("source",count-1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("->");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (PlaceholderUsingDefaultToken):
		count = printCountingMap.get("target");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__TARGET));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve(((org.emftext.language.statemachine.resource.statemachine.StatemachineReferenceResolverSwitch) resource.getReferenceResolverSwitch()).getTransitionTargetReferenceResolver().deResolve((org.eclipse.uml2.uml.Vertex) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__TARGET)), element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__TARGET), element));
			out.print(" ");
			printCountingMap.put("target",count-1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("when");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("trigger");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__TRIGGER));
			o = ((java.util.List<?>)o).get(((java.util.List<?>)o).size() - count);
			doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			printCountingMap.put("trigger",count-1);
		}
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_eclipse_uml2_uml_Transition_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print(";");
		out.print(" ");
	}
	public void print_org_eclipse_uml2_uml_Transition_0(org.eclipse.uml2.uml.Transition element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("do");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (CsString):
		out.print(":");
		out.print(" ");
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("effect");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__EFFECT));
			doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			printCountingMap.put("effect",count-1);
		}
	}
	
	public void print_org_eclipse_uml2_uml_Trigger(org.eclipse.uml2.uml.Trigger element, java.lang.String outertab, java.io.PrintWriter out) {
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(12);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRIGGER__EANNOTATIONS));
		printCountingMap.put("eAnnotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRIGGER__OWNED_ELEMENT));
		printCountingMap.put("ownedElement", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRIGGER__OWNER));
		printCountingMap.put("owner", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRIGGER__OWNED_COMMENT));
		printCountingMap.put("ownedComment", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRIGGER__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRIGGER__VISIBILITY));
		printCountingMap.put("visibility", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRIGGER__QUALIFIED_NAME));
		printCountingMap.put("qualifiedName", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRIGGER__CLIENT_DEPENDENCY));
		printCountingMap.put("clientDependency", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRIGGER__NAMESPACE));
		printCountingMap.put("namespace", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRIGGER__NAME_EXPRESSION));
		printCountingMap.put("nameExpression", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRIGGER__EVENT));
		printCountingMap.put("event", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRIGGER__PORT));
		printCountingMap.put("port", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (PlaceholderInQuotes):
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRIGGER__NAME));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRIGGER__NAME), element));
			out.print(" ");
			printCountingMap.put("name",count-1);
		}
	}
	
	public void print_org_eclipse_uml2_uml_Activity(org.eclipse.uml2.uml.Activity element, java.lang.String outertab, java.io.PrintWriter out) {
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(68);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__EANNOTATIONS));
		printCountingMap.put("eAnnotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__OWNED_ELEMENT));
		printCountingMap.put("ownedElement", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__OWNER));
		printCountingMap.put("owner", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__OWNED_COMMENT));
		printCountingMap.put("ownedComment", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__VISIBILITY));
		printCountingMap.put("visibility", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__QUALIFIED_NAME));
		printCountingMap.put("qualifiedName", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__CLIENT_DEPENDENCY));
		printCountingMap.put("clientDependency", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__NAMESPACE));
		printCountingMap.put("namespace", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__NAME_EXPRESSION));
		printCountingMap.put("nameExpression", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__ELEMENT_IMPORT));
		printCountingMap.put("elementImport", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__PACKAGE_IMPORT));
		printCountingMap.put("packageImport", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__OWNED_RULE));
		printCountingMap.put("ownedRule", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__MEMBER));
		printCountingMap.put("member", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__IMPORTED_MEMBER));
		printCountingMap.put("importedMember", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__OWNED_MEMBER));
		printCountingMap.put("ownedMember", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__IS_LEAF));
		printCountingMap.put("isLeaf", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__REDEFINED_ELEMENT));
		printCountingMap.put("redefinedElement", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__REDEFINITION_CONTEXT));
		printCountingMap.put("redefinitionContext", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__OWNING_TEMPLATE_PARAMETER));
		printCountingMap.put("owningTemplateParameter", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__TEMPLATE_PARAMETER));
		printCountingMap.put("templateParameter", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__PACKAGE));
		printCountingMap.put("package", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__TEMPLATE_BINDING));
		printCountingMap.put("templateBinding", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__OWNED_TEMPLATE_SIGNATURE));
		printCountingMap.put("ownedTemplateSignature", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__IS_ABSTRACT));
		printCountingMap.put("isAbstract", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__GENERALIZATION));
		printCountingMap.put("generalization", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__POWERTYPE_EXTENT));
		printCountingMap.put("powertypeExtent", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__FEATURE));
		printCountingMap.put("feature", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__INHERITED_MEMBER));
		printCountingMap.put("inheritedMember", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__REDEFINED_CLASSIFIER));
		printCountingMap.put("redefinedClassifier", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__GENERAL));
		printCountingMap.put("general", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__SUBSTITUTION));
		printCountingMap.put("substitution", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__ATTRIBUTE));
		printCountingMap.put("attribute", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__REPRESENTATION));
		printCountingMap.put("representation", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__COLLABORATION_USE));
		printCountingMap.put("collaborationUse", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__OWNED_USE_CASE));
		printCountingMap.put("ownedUseCase", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__USE_CASE));
		printCountingMap.put("useCase", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__OWNED_ATTRIBUTE));
		printCountingMap.put("ownedAttribute", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__PART));
		printCountingMap.put("part", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__ROLE));
		printCountingMap.put("role", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__OWNED_CONNECTOR));
		printCountingMap.put("ownedConnector", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__OWNED_PORT));
		printCountingMap.put("ownedPort", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__OWNED_BEHAVIOR));
		printCountingMap.put("ownedBehavior", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__CLASSIFIER_BEHAVIOR));
		printCountingMap.put("classifierBehavior", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__INTERFACE_REALIZATION));
		printCountingMap.put("interfaceRealization", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__OWNED_TRIGGER));
		printCountingMap.put("ownedTrigger", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__NESTED_CLASSIFIER));
		printCountingMap.put("nestedClassifier", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__OWNED_OPERATION));
		printCountingMap.put("ownedOperation", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__SUPER_CLASS));
		printCountingMap.put("superClass", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__IS_ACTIVE));
		printCountingMap.put("isActive", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__OWNED_RECEPTION));
		printCountingMap.put("ownedReception", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__EXTENSION));
		printCountingMap.put("extension", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__IS_REENTRANT));
		printCountingMap.put("isReentrant", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__REDEFINED_BEHAVIOR));
		printCountingMap.put("redefinedBehavior", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__OWNED_PARAMETER));
		printCountingMap.put("ownedParameter", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__CONTEXT));
		printCountingMap.put("context", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__PRECONDITION));
		printCountingMap.put("precondition", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__POSTCONDITION));
		printCountingMap.put("postcondition", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__OWNED_PARAMETER_SET));
		printCountingMap.put("ownedParameterSet", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__SPECIFICATION));
		printCountingMap.put("specification", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__STRUCTURED_NODE));
		printCountingMap.put("structuredNode", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__VARIABLE));
		printCountingMap.put("variable", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__NODE));
		printCountingMap.put("node", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__IS_READ_ONLY));
		printCountingMap.put("isReadOnly", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__EDGE));
		printCountingMap.put("edge", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__PARTITION));
		printCountingMap.put("partition", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__IS_SINGLE_EXECUTION));
		printCountingMap.put("isSingleExecution", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__GROUP));
		printCountingMap.put("group", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (PlaceholderInQuotes):
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__NAME));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.ACTIVITY__NAME), element));
			out.print(" ");
			printCountingMap.put("name",count-1);
		}
	}
	
}
