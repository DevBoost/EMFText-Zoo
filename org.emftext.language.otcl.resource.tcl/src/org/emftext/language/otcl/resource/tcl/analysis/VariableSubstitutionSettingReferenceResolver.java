package org.emftext.language.otcl.resource.tcl.analysis;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.otcl.Set;
import org.emftext.language.otcl.Word;

public class VariableSubstitutionSettingReferenceResolver implements org.emftext.language.otcl.resource.tcl.ITclReferenceResolver<org.emftext.language.otcl.VariableSubstitution, org.emftext.language.otcl.Set> {
	
	private org.emftext.language.otcl.resource.tcl.analysis.TclDefaultResolverDelegate<org.emftext.language.otcl.VariableSubstitution, org.emftext.language.otcl.Set> delegate = new org.emftext.language.otcl.resource.tcl.analysis.TclDefaultResolverDelegate<org.emftext.language.otcl.VariableSubstitution, org.emftext.language.otcl.Set>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.otcl.VariableSubstitution container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.otcl.resource.tcl.ITclReferenceResolveResult<org.emftext.language.otcl.Set> result) {
		for(Iterator<EObject> i = container.eResource().getAllContents(); i.hasNext();) {
			EObject next = i.next();
			if (next instanceof Set) {
				if (((Set)next).getVariable() instanceof Word) {
					Word w = (Word) ((Set)next).getVariable();
					if (identifier.equals(w.getValue())) {
						result.addMapping(identifier, (Set)next);
						return;
					}
				}
			}
		}
	}
	
	public java.lang.String deResolve(org.emftext.language.otcl.Set element, org.emftext.language.otcl.VariableSubstitution container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
