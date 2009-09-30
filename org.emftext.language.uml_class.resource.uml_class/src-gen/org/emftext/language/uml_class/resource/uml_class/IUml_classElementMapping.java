package org.emftext.language.uml_class.resource.uml_class;

// A mapping from an identifier to an EObject.
//
// @param <ReferenceType> the type of the reference this mapping points to.
public interface IUml_classElementMapping<ReferenceType> extends org.emftext.language.uml_class.resource.uml_class.IUml_classReferenceMapping<ReferenceType> {
	
	// Returns the target object the identifier is mapped to.
	public ReferenceType getTargetElement();
}
