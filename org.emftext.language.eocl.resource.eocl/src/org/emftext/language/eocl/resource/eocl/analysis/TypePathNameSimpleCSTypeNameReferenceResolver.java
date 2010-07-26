/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.eocl.resource.eocl.analysis;

public class TypePathNameSimpleCSTypeNameReferenceResolver implements org.emftext.language.eocl.resource.eocl.IEoclReferenceResolver<tudresden.ocl20.pivot.language.ocl.TypePathNameSimpleCS, tudresden.ocl20.pivot.pivotmodel.Type> {
	
	private tudresden.ocl20.pivot.language.ocl.resource.ocl.analysis.TypePathNameSimpleCSTypeNameReferenceResolver delegate = new tudresden.ocl20.pivot.language.ocl.resource.ocl.analysis.TypePathNameSimpleCSTypeNameReferenceResolver();
	
	public void resolve(java.lang.String identifier, tudresden.ocl20.pivot.language.ocl.TypePathNameSimpleCS container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.eocl.resource.eocl.IEoclReferenceResolveResult<tudresden.ocl20.pivot.pivotmodel.Type> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, new tudresden.ocl20.pivot.language.ocl.resource.ocl.IOclReferenceResolveResult<tudresden.ocl20.pivot.pivotmodel.Type>() {
			
			public boolean wasResolvedUniquely() {
				return result.wasResolvedUniquely();
			}
			
			public boolean wasResolvedMultiple() {
				return result.wasResolvedMultiple();
			}
			
			public boolean wasResolved() {
				return result.wasResolved();
			}
			
			public void setErrorMessage(String message) {
				result.setErrorMessage(message);
			}
			
			public java.util.Collection<tudresden.ocl20.pivot.language.ocl.resource.ocl.IOclReferenceMapping<tudresden.ocl20.pivot.pivotmodel.Type>> getMappings() {
				throw new UnsupportedOperationException();
			}
			
			public String getErrorMessage() {
				return result.getErrorMessage();
			}
			
			public void addMapping(String identifier, org.eclipse.emf.common.util.URI newIdentifier) {
				result.addMapping(identifier, newIdentifier);
			}
			
			public void addMapping(String identifier, org.eclipse.emf.common.util.URI newIdentifier, String warning) {
				result.addMapping(identifier, newIdentifier, warning);
			}
			
			public void addMapping(String identifier, tudresden.ocl20.pivot.pivotmodel.Type target) {
				result.addMapping(identifier, target);
			}
			
			public void addMapping(String identifier, tudresden.ocl20.pivot.pivotmodel.Type target, String warning) {
				result.addMapping(identifier, target, warning);
			}
		});
		
	}
	
	public java.lang.String deResolve(tudresden.ocl20.pivot.pivotmodel.Type element, tudresden.ocl20.pivot.language.ocl.TypePathNameSimpleCS container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}