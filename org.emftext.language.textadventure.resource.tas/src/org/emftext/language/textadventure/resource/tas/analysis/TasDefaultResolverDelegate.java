package org.emftext.language.textadventure.resource.tas.analysis;

public class TasDefaultResolverDelegate<ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> {
	public final static java.lang.String NAME_FEATURE = "name";
	
	// This standard implementation searches the tree for objects of the 
	// correct type with a name attribute matching the identifier.
	protected void resolve(java.lang.String identifier, ContainerType container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<ReferenceType> result) {
		try {
			org.eclipse.emf.ecore.EClass type = reference.getEReferenceType();
			org.eclipse.emf.ecore.EObject root = org.emftext.runtime.util.EObjectUtil.findRootContainer(container);
			// first check whether the root element matches
			boolean continueSearch = checkElement(root, type, identifier, resolveFuzzy, result);
			if (!continueSearch) {
				return;
			}
			// then check the contents
			for (java.util.Iterator<org.eclipse.emf.ecore.EObject> iterator = root.eAllContents(); iterator.hasNext(); ) {
				org.eclipse.emf.ecore.EObject element = iterator.next();
				continueSearch = checkElement(element, type, identifier, resolveFuzzy, result);
				if (!continueSearch) {
					return;
				}
			}
		} catch (java.lang.RuntimeException rte) {
			// catch exception here to prevent EMF proxy resolution from swallowing it
			rte.printStackTrace();
		}
	}
	
	private boolean checkElement(org.eclipse.emf.ecore.EObject element, org.eclipse.emf.ecore.EClass type, java.lang.String identifier, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<ReferenceType> result) {
		if (element.eIsProxy()) {
			return true;
		}
		
		org.eclipse.emf.ecore.EClass eClass = element.eClass();
		boolean hasCorrectType = eClass.equals(type) || eClass.getEAllSuperTypes().contains(type);
		if (!hasCorrectType) {
			return true;
		}
		
		final java.lang.String match = matches(element, identifier, resolveFuzzy);
		if (match == null) {
			return true;
		}
		// we can safely cast 'element' to 'ReferenceType' here,
		// because we've checked the type of 'element' against
		// the type of the reference. unfortunately the compiler
		// does not know that this is sufficient, so we must call
		// cast(), which is not type safe by itself.
		result.addMapping(match, cast(element));
		if (!resolveFuzzy) {
			return false;
		}
		return true;
	}
	
	// This method encapsulates an unchecked cast from EObject to
	// ReferenceType. We can not do this cast strictly type safe,
	// because type parameters are erased by compilation. Thus, an
	// instanceof check can not be performed at runtime.
	@SuppressWarnings("unchecked")	
	private ReferenceType cast(org.eclipse.emf.ecore.EObject element) {
		return (ReferenceType) element;
	}
	
	protected java.lang.String produceDeResolveErrorMessage(org.eclipse.emf.ecore.EObject refObject, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, org.emftext.runtime.resource.ITextResource resource) {
		java.lang.String msg = getClass().getSimpleName() + ": " + reference.getEType().getName() + " \"" + refObject.toString() + "\" not de-resolveable";
		return msg;
	}
	
	protected java.lang.String deResolve(ReferenceType element, ContainerType container, org.eclipse.emf.ecore.EReference reference) {
		return getName(element);
	}
	
	private java.lang.String matches(org.eclipse.emf.ecore.EObject element, java.lang.String identifier, boolean matchFuzzy) {
		org.eclipse.emf.ecore.EStructuralFeature nameAttr = element.eClass().getEStructuralFeature(NAME_FEATURE);
		if (nameAttr instanceof org.eclipse.emf.ecore.EAttribute) {
			java.lang.Object attributeValue = element.eGet(nameAttr);
			return matches(identifier, attributeValue, matchFuzzy);
		} else {
			//try any other string attribute found
			for (org.eclipse.emf.ecore.EAttribute stringAttribute : element.eClass().getEAllAttributes()) {
				if (stringAttribute.getEType().getInstanceClassName().equals(java.lang.String.class.getName())) {
					java.lang.Object attributeValue = element.eGet(stringAttribute);
					java.lang.String match = matches(identifier, attributeValue, matchFuzzy);
					if (match != null) {
						return match;
					}
				}
			}
						for (org.eclipse.emf.ecore.EOperation o : element.eClass().getEAllOperations()) {
				if (o.getName().toLowerCase().endsWith(NAME_FEATURE) && o.getEParameters().size() == 0 ) {
					java.lang.String result = (java.lang.String) org.emftext.runtime.util.EObjectUtil.invokeOperation(element, o);
					java.lang.String match = matches(identifier, result, matchFuzzy);
					if (match != null) {
						return match;
					}
				}
			}
		}
		return null;
	}
	
	private java.lang.String matches(java.lang.String identifier, java.lang.Object attributeValue, boolean matchFuzzy) {
		if (attributeValue != null && attributeValue instanceof java.lang.String) {
			java.lang.String name = (java.lang.String) attributeValue;
			if (name.startsWith(identifier) && matchFuzzy) {
				return name;
			}
			if (name.equals(identifier)) {
				return identifier;
			}
		}
		return null;
	}
	
	private java.lang.String getName(ReferenceType element) {
		org.eclipse.emf.ecore.EStructuralFeature nameAttr = element.eClass().getEStructuralFeature(NAME_FEATURE);
		if(element.eIsProxy()) {
			java.lang.String fragment = ((org.eclipse.emf.ecore.InternalEObject) element).eProxyURI().fragment();
			if (fragment != null && fragment.startsWith(org.emftext.runtime.resource.IContextDependentURIFragment.INTERNAL_URI_FRAGMENT_PREFIX)) {
				fragment = fragment.substring(org.emftext.runtime.resource.IContextDependentURIFragment.INTERNAL_URI_FRAGMENT_PREFIX.length());
			}
			return fragment;
		}
		else if (nameAttr instanceof org.eclipse.emf.ecore.EAttribute) {
			return (java.lang.String) element.eGet(nameAttr);
		} else {
			//try any other string attribute found
			for (org.eclipse.emf.ecore.EAttribute strAttribute : element.eClass().getEAllAttributes()) {
				if (!strAttribute.isMany() &&				strAttribute.getEType().getInstanceClassName().equals(java.lang.String.class.getName())) {
					return (java.lang.String) element.eGet(strAttribute);
				}
			}
			for (org.eclipse.emf.ecore.EOperation o : element.eClass().getEAllOperations()) {
				if (o.getName().toLowerCase().endsWith(NAME_FEATURE) && o.getEParameters().size() == 0 ) {
					java.lang.String result = (java.lang.String) org.emftext.runtime.util.EObjectUtil.invokeOperation(element, o);
					if (result != null) {
						return result;
					}
				}
			}
		}
		return null;
	}
	
}
