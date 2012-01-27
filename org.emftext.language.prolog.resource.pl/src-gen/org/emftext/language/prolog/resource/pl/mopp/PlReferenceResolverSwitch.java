/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl.mopp;

public class PlReferenceResolverSwitch implements org.emftext.language.prolog.resource.pl.IPlReferenceResolverSwitch {
	
	/**
	 * This map stores a copy of the options the were set for loading the resource.
	 */
	private java.util.Map<Object, Object> options;
	
	protected org.emftext.language.prolog.resource.pl.analysis.VariableReferenceVariableReferenceResolver variableReferenceVariableReferenceResolver = new org.emftext.language.prolog.resource.pl.analysis.VariableReferenceVariableReferenceResolver();
	
	public org.emftext.language.prolog.resource.pl.IPlReferenceResolver<org.emftext.language.prolog.VariableReference, org.emftext.language.prolog.Variable> getVariableReferenceVariableReferenceResolver() {
		return getResolverChain(org.emftext.language.prolog.PrologPackage.eINSTANCE.getVariableReference_Variable(), variableReferenceVariableReferenceResolver);
	}
	
	public void setOptions(java.util.Map<?, ?> options) {
		if (options != null) {
			this.options = new java.util.LinkedHashMap<Object, Object>();
			this.options.putAll(options);
		}
		variableReferenceVariableReferenceResolver.setOptions(options);
	}
	
	public void resolveFuzzy(String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, org.emftext.language.prolog.resource.pl.IPlReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		if (container == null) {
			return;
		}
		if (org.emftext.language.prolog.PrologPackage.eINSTANCE.getVariableReference().isInstance(container)) {
			PlFuzzyResolveResult<org.emftext.language.prolog.Variable> frr = new PlFuzzyResolveResult<org.emftext.language.prolog.Variable>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("variable")) {
				variableReferenceVariableReferenceResolver.resolve(identifier, (org.emftext.language.prolog.VariableReference) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
	}
	
	public org.emftext.language.prolog.resource.pl.IPlReferenceResolver<? extends org.eclipse.emf.ecore.EObject, ? extends org.eclipse.emf.ecore.EObject> getResolver(org.eclipse.emf.ecore.EStructuralFeature reference) {
		if (reference == org.emftext.language.prolog.PrologPackage.eINSTANCE.getVariableReference_Variable()) {
			return getResolverChain(reference, variableReferenceVariableReferenceResolver);
		}
		return null;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})	
	public <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> org.emftext.language.prolog.resource.pl.IPlReferenceResolver<ContainerType, ReferenceType> getResolverChain(org.eclipse.emf.ecore.EStructuralFeature reference, org.emftext.language.prolog.resource.pl.IPlReferenceResolver<ContainerType, ReferenceType> originalResolver) {
		if (options == null) {
			return originalResolver;
		}
		Object value = options.get(org.emftext.language.prolog.resource.pl.IPlOptions.ADDITIONAL_REFERENCE_RESOLVERS);
		if (value == null) {
			return originalResolver;
		}
		if (!(value instanceof java.util.Map)) {
			// send this to the error log
			new org.emftext.language.prolog.resource.pl.util.PlRuntimeUtil().logWarning("Found value with invalid type for option " + org.emftext.language.prolog.resource.pl.IPlOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + java.util.Map.class.getName() + ", but was " + value.getClass().getName() + ")", null);
			return originalResolver;
		}
		java.util.Map<?,?> resolverMap = (java.util.Map<?,?>) value;
		Object resolverValue = resolverMap.get(reference);
		if (resolverValue == null) {
			return originalResolver;
		}
		if (resolverValue instanceof org.emftext.language.prolog.resource.pl.IPlReferenceResolver) {
			org.emftext.language.prolog.resource.pl.IPlReferenceResolver replacingResolver = (org.emftext.language.prolog.resource.pl.IPlReferenceResolver) resolverValue;
			if (replacingResolver instanceof org.emftext.language.prolog.resource.pl.IPlDelegatingReferenceResolver) {
				// pass original resolver to the replacing one
				((org.emftext.language.prolog.resource.pl.IPlDelegatingReferenceResolver) replacingResolver).setDelegate(originalResolver);
			}
			return replacingResolver;
		} else if (resolverValue instanceof java.util.Collection) {
			java.util.Collection replacingResolvers = (java.util.Collection) resolverValue;
			org.emftext.language.prolog.resource.pl.IPlReferenceResolver replacingResolver = originalResolver;
			for (Object next : replacingResolvers) {
				if (next instanceof org.emftext.language.prolog.resource.pl.IPlReferenceCache) {
					org.emftext.language.prolog.resource.pl.IPlReferenceResolver nextResolver = (org.emftext.language.prolog.resource.pl.IPlReferenceResolver) next;
					if (nextResolver instanceof org.emftext.language.prolog.resource.pl.IPlDelegatingReferenceResolver) {
						// pass original resolver to the replacing one
						((org.emftext.language.prolog.resource.pl.IPlDelegatingReferenceResolver) nextResolver).setDelegate(replacingResolver);
					}
					replacingResolver = nextResolver;
				} else {
					// The collection contains a non-resolver. Send a warning to the error log.
					new org.emftext.language.prolog.resource.pl.util.PlRuntimeUtil().logWarning("Found value with invalid type in value map for option " + org.emftext.language.prolog.resource.pl.IPlOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + org.emftext.language.prolog.resource.pl.IPlDelegatingReferenceResolver.class.getName() + ", but was " + next.getClass().getName() + ")", null);
				}
			}
			return replacingResolver;
		} else {
			// The value for the option ADDITIONAL_REFERENCE_RESOLVERS has an unknown type.
			new org.emftext.language.prolog.resource.pl.util.PlRuntimeUtil().logWarning("Found value with invalid type in value map for option " + org.emftext.language.prolog.resource.pl.IPlOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + org.emftext.language.prolog.resource.pl.IPlDelegatingReferenceResolver.class.getName() + ", but was " + resolverValue.getClass().getName() + ")", null);
			return originalResolver;
		}
	}
	
}
