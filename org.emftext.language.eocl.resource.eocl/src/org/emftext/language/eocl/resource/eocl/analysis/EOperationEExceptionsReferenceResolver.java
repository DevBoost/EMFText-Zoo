/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.eocl.resource.eocl.analysis;

import org.eclipse.emf.ecore.EcorePackage;
import org.emftext.language.eocl.resource.eocl.analysis.helper.EMFTypesResolver;

public class EOperationEExceptionsReferenceResolver implements org.emftext.language.eocl.resource.eocl.IEoclReferenceResolver<org.eclipse.emf.ecore.EOperation, org.eclipse.emf.ecore.EClassifier> {
	
	public void resolve(java.lang.String identifier, org.eclipse.emf.ecore.EOperation container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.eocl.resource.eocl.IEoclReferenceResolveResult<org.eclipse.emf.ecore.EClassifier> result) {
		new EMFTypesResolver().doResolve(identifier, container, reference, EcorePackage.eINSTANCE.getEClassifier(), resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.eclipse.emf.ecore.EClassifier element, org.eclipse.emf.ecore.EOperation container, org.eclipse.emf.ecore.EReference reference) {
		return element.getName();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
