package org.emftext.language.uml_class.resource.uml_class.mopp;

public class Uml_classReferenceResolverSwitch implements org.emftext.language.uml_class.resource.uml_class.IUml_classReferenceResolverSwitch {
	
	protected org.emftext.language.uml_class.resource.uml_class.analysis.MethodReturnReferenceResolver methodReturnReferenceResolver = new org.emftext.language.uml_class.resource.uml_class.analysis.MethodReturnReferenceResolver();
	protected org.emftext.language.uml_class.resource.uml_class.analysis.AttributeTypeReferenceResolver attributeTypeReferenceResolver = new org.emftext.language.uml_class.resource.uml_class.analysis.AttributeTypeReferenceResolver();
	protected org.emftext.language.uml_class.resource.uml_class.analysis.ParameterTypeReferenceResolver parameterTypeReferenceResolver = new org.emftext.language.uml_class.resource.uml_class.analysis.ParameterTypeReferenceResolver();
	protected org.emftext.language.uml_class.resource.uml_class.analysis.ClassParentReferenceResolver classParentReferenceResolver = new org.emftext.language.uml_class.resource.uml_class.analysis.ClassParentReferenceResolver();
	
	public org.emftext.language.uml_class.resource.uml_class.analysis.MethodReturnReferenceResolver getMethodReturnReferenceResolver() {
		return methodReturnReferenceResolver;
	}
	
	public org.emftext.language.uml_class.resource.uml_class.analysis.AttributeTypeReferenceResolver getAttributeTypeReferenceResolver() {
		return attributeTypeReferenceResolver;
	}
	
	public org.emftext.language.uml_class.resource.uml_class.analysis.ParameterTypeReferenceResolver getParameterTypeReferenceResolver() {
		return parameterTypeReferenceResolver;
	}
	
	public org.emftext.language.uml_class.resource.uml_class.analysis.ClassParentReferenceResolver getClassParentReferenceResolver() {
		return classParentReferenceResolver;
	}
	
	public void setOptions(java.util.Map<?, ?> options) {
		methodReturnReferenceResolver.setOptions(options);
		attributeTypeReferenceResolver.setOptions(options);
		parameterTypeReferenceResolver.setOptions(options);
		classParentReferenceResolver.setOptions(options);
	}
	
	public void resolveFuzzy(java.lang.String identifier, org.eclipse.emf.ecore.EObject container, int position, org.emftext.language.uml_class.resource.uml_class.IUml_classReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		if (org.emftext.language.uml_class.Uml_classPackage.eINSTANCE.getMethod().isInstance(container)) {
			Uml_classFuzzyResolveResult<org.emftext.language.uml_class.XClass> frr = new Uml_classFuzzyResolveResult<org.emftext.language.uml_class.XClass>(result);
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature("return");
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				methodReturnReferenceResolver.resolve(identifier, (org.emftext.language.uml_class.Method) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.uml_class.Uml_classPackage.eINSTANCE.getAttribute().isInstance(container)) {
			Uml_classFuzzyResolveResult<org.emftext.language.uml_class.XClass> frr = new Uml_classFuzzyResolveResult<org.emftext.language.uml_class.XClass>(result);
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature("type");
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				attributeTypeReferenceResolver.resolve(identifier, (org.emftext.language.uml_class.Attribute) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.uml_class.Uml_classPackage.eINSTANCE.getParameter().isInstance(container)) {
			Uml_classFuzzyResolveResult<org.emftext.language.uml_class.XClass> frr = new Uml_classFuzzyResolveResult<org.emftext.language.uml_class.XClass>(result);
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature("type");
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				parameterTypeReferenceResolver.resolve(identifier, (org.emftext.language.uml_class.Parameter) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.uml_class.Uml_classPackage.eINSTANCE.getClass().isInstance(container)) {
			Uml_classFuzzyResolveResult<org.emftext.language.uml_class.XClass> frr = new Uml_classFuzzyResolveResult<org.emftext.language.uml_class.XClass>(result);
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature("parent");
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				classParentReferenceResolver.resolve(identifier, (org.emftext.language.uml_class.Class) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
	}
}
