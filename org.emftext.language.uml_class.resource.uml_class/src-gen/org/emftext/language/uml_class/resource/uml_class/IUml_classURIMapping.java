package org.emftext.language.uml_class.resource.uml_class;

// Implementors of this interface map identifiers to URIs.
// This is sometime necessary when resolving references depends
// on the resolution of others.
//
// @param <ReferenceType> unused type parameter which is needed to implement IReferenceMapping.
//
public interface IUml_classURIMapping<ReferenceType> extends org.emftext.language.uml_class.resource.uml_class.IUml_classReferenceMapping<ReferenceType> {
	
	// Returns an alternative proxy org.eclipse.emf.common.util.URI that should follow EMF's default naming scheme
	// such that it can be resolved by the default resolution mechanism that will be called
	// on this org.eclipse.emf.common.util.URI (see <code>Resource.getEObject()</code>).
	public org.eclipse.emf.common.util.URI getTargetIdentifier();
}
