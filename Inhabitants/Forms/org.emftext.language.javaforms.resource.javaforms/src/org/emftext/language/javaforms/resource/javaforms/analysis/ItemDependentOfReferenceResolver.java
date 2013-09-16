/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.javaforms.resource.javaforms.analysis;

public class ItemDependentOfReferenceResolver implements org.emftext.language.javaforms.resource.javaforms.IJavaformsReferenceResolver<org.emftext.language.forms.Item, org.emftext.language.forms.Option> {

	private org.emftext.language.forms.resource.forms.analysis.ItemDependentOfReferenceResolver delegate = new org.emftext.language.forms.resource.forms.analysis.ItemDependentOfReferenceResolver();

	public void resolve(String identifier, org.emftext.language.forms.Item container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.javaforms.resource.javaforms.IJavaformsReferenceResolveResult<org.emftext.language.forms.Option> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, new org.emftext.language.forms.resource.forms.IFormsReferenceResolveResult<org.emftext.language.forms.Option>() {

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

			public java.util.Collection<org.emftext.language.forms.resource.forms.IFormsReferenceMapping<org.emftext.language.forms.Option>> getMappings() {
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

			public void addMapping(String identifier, org.emftext.language.forms.Option target) {
				result.addMapping(identifier, target);
			}

			public void addMapping(String identifier, org.emftext.language.forms.Option target, String warning) {
				result.addMapping(identifier, target, warning);
			}

			public java.util.Collection<org.emftext.language.forms.resource.forms.IFormsQuickFix> getQuickFixes() {
				return java.util.Collections.emptySet();
			}

			public void addQuickFix(final org.emftext.language.forms.resource.forms.IFormsQuickFix quickFix) {
				result.addQuickFix(new org.emftext.language.javaforms.resource.javaforms.IJavaformsQuickFix() {

					public String getImageKey() {
						return quickFix.getImageKey();
					}

					public String getDisplayString() {
						return quickFix.getDisplayString();
					}

					public java.util.Collection<org.eclipse.emf.ecore.EObject> getContextObjects() {
						return quickFix.getContextObjects();
					}

					public String getContextAsString() {
						return quickFix.getContextAsString();
					}

					public String apply(String currentText) {
						return quickFix.apply(currentText);
					}
				});
			}
		});

	}

	public String deResolve(org.emftext.language.forms.Option element, org.emftext.language.forms.Item container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}

	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}

}