package org.emftext.language.uml_class.resource.uml_class;

// An IReferenceResolverSwitch is a object that holds references to multiple
// other reference resolvers and delegates requests to the appropriate resolver.
public interface IUml_classReferenceResolverSwitch extends org.emftext.language.uml_class.resource.uml_class.IUml_classConfigurable {
	
	// Attempts to resolve a reference string fuzzy (returning objects that do not match exactly).
	//
	// @param identifier The identifier for the reference.
	// @param container The object that contains the reference.
	// @param reference The reference that points to the target of the reference.
	// @param result an object to store the result of the resolve operation.
	public void resolveFuzzy(String identifier, org.eclipse.emf.ecore.EObject container, int position, org.emftext.language.uml_class.resource.uml_class.IUml_classReferenceResolveResult<org.eclipse.emf.ecore.EObject> result);
}
