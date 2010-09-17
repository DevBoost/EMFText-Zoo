/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.formsextension.resource.formsextension.analysis;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.members.ClassMethod;

public class ExtendedFormJavaMethodReferenceResolver
		implements
		org.emftext.language.formsextension.resource.formsextension.IFormsextensionReferenceResolver<org.emftext.language.formsextension.ExtendedForm, org.emftext.language.java.members.ClassMethod> {

	private org.emftext.language.formsextension.resource.formsextension.analysis.FormsextensionDefaultResolverDelegate<org.emftext.language.formsextension.ExtendedForm, org.emftext.language.java.members.ClassMethod> delegate = new org.emftext.language.formsextension.resource.formsextension.analysis.FormsextensionDefaultResolverDelegate<org.emftext.language.formsextension.ExtendedForm, org.emftext.language.java.members.ClassMethod>();

	public void resolve(
			String identifier,
			org.emftext.language.formsextension.ExtendedForm container,
			org.eclipse.emf.ecore.EReference reference,
			int position,
			boolean resolveFuzzy,
			final org.emftext.language.formsextension.resource.formsextension.IFormsextensionReferenceResolveResult<org.emftext.language.java.members.ClassMethod> result) {
		CompilationUnit cu = container.getCompilationUnit();
		TreeIterator<EObject> eAllContents = cu.eAllContents();
		while (eAllContents.hasNext()) {
			EObject eObject = (EObject) eAllContents.next();
			if (eObject instanceof ClassMethod) {
				ClassMethod method = (ClassMethod) eObject;
				if (resolveFuzzy) {
					if (method.getName().startsWith(identifier)) {
						result.addMapping(method.getName(), method);
					}
				} else if (identifier.equals(method.getName())) {
					result.addMapping(identifier, method);
				}
			}
		}
	}

	public String deResolve(
			org.emftext.language.java.members.ClassMethod element,
			org.emftext.language.formsextension.ExtendedForm container,
			org.eclipse.emf.ecore.EReference reference) {
		return element.getName();
	}

	public void setOptions(java.util.Map<?, ?> options) {
		// save options in a field or leave method empty if this resolver does
		// not depend
		// on any option
	}

}
