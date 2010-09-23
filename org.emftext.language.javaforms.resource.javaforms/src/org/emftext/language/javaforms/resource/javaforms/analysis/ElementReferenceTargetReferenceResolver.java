/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.javaforms.resource.javaforms.analysis;

import java.util.Collection;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.javaforms.ConditionalItem;
import org.emftext.language.javaforms.JavaformsPackage;
import org.emftext.language.javaforms.resource.javaforms.util.JavaformsEObjectUtil;

public class ElementReferenceTargetReferenceResolver implements org.emftext.language.javaforms.resource.javaforms.IJavaformsReferenceResolver<org.emftext.language.java.references.ElementReference, org.emftext.language.java.references.ReferenceableElement> {
	
	private org.emftext.language.java.resource.java.analysis.ElementReferenceTargetReferenceResolver delegate = new org.emftext.language.java.resource.java.analysis.ElementReferenceTargetReferenceResolver();
	
	public void resolve(String identifier, org.emftext.language.java.references.ElementReference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.javaforms.resource.javaforms.IJavaformsReferenceResolveResult<org.emftext.language.java.references.ReferenceableElement> result) {
		TreeIterator<EObject> allContents = container.eResource().getAllContents();
		Collection<ConditionalItem> items = JavaformsEObjectUtil.getObjectsByType(allContents, JavaformsPackage.eINSTANCE.getConditionalItem());
		for (ConditionalItem item : items) {
			String itemName = item.getName();
			if (resolveFuzzy || identifier.equals(itemName)) {
				result.addMapping(itemName, item);
				if (!resolveFuzzy) {
					return;
				}
			}
		}
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, new org.emftext.language.java.resource.java.IJavaReferenceResolveResult<org.emftext.language.java.references.ReferenceableElement>() {
			
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
			
			public java.util.Collection<org.emftext.language.java.resource.java.IJavaReferenceMapping<org.emftext.language.java.references.ReferenceableElement>> getMappings() {
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
			
			public void addMapping(String identifier, org.emftext.language.java.references.ReferenceableElement target) {
				result.addMapping(identifier, target);
			}
			
			public void addMapping(String identifier, org.emftext.language.java.references.ReferenceableElement target, String warning) {
				result.addMapping(identifier, target, warning);
			}
		});
		
	}
	
	public String deResolve(org.emftext.language.java.references.ReferenceableElement element, org.emftext.language.java.references.ElementReference container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
