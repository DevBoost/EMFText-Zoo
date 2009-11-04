/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.custom_sandwich.resource.custom_sandwich.analysis;

public class InstructionUsingReferenceResolver implements org.emftext.language.custom_sandwich.resource.custom_sandwich.ICustom_sandwichReferenceResolver<org.emftext.language.sandwich.Instruction, org.emftext.language.sandwich.FeatureInstructionUsing> {
	
	private org.emftext.language.sandwich.resource.sandwich.analysis.InstructionUsingReferenceResolver delegate = new org.emftext.language.sandwich.resource.sandwich.analysis.InstructionUsingReferenceResolver();
	
	public void resolve(java.lang.String identifier, org.emftext.language.sandwich.Instruction container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.custom_sandwich.resource.custom_sandwich.ICustom_sandwichReferenceResolveResult<org.emftext.language.sandwich.FeatureInstructionUsing> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, new org.emftext.language.sandwich.resource.sandwich.ISandwichReferenceResolveResult<org.emftext.language.sandwich.FeatureInstructionUsing>() {
			
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
			
			public java.util.Collection<org.emftext.language.sandwich.resource.sandwich.ISandwichReferenceMapping<org.emftext.language.sandwich.FeatureInstructionUsing>> getMappings() {
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
			
			public void addMapping(String identifier, org.emftext.language.sandwich.FeatureInstructionUsing target) {
				result.addMapping(identifier, target);
			}
			
			public void addMapping(String identifier, org.emftext.language.sandwich.FeatureInstructionUsing target, String warning) {
				result.addMapping(identifier, target, warning);
			}
		});
		
	}
	
	public java.lang.String deResolve(org.emftext.language.sandwich.FeatureInstructionUsing element, org.emftext.language.sandwich.Instruction container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
