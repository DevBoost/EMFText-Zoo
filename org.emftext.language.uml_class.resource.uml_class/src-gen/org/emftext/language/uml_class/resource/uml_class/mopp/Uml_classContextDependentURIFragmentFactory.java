package org.emftext.language.uml_class.resource.uml_class.mopp;

// A factory for ContextDependentURIFragments. Given a feasible reference resolver,
// the factory returns a matching fragment that used the resolver to resolver proxy
// objects.
//
// @param <ContainerType> the type of the class containing the reference to be resolved
// @param <ReferenceType> the type of the reference to be resolved
//
public class Uml_classContextDependentURIFragmentFactory<ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject>  implements org.emftext.language.uml_class.resource.uml_class.IUml_classContextDependentURIFragmentFactory<ContainerType, ReferenceType> {
	
	private final org.emftext.language.uml_class.resource.uml_class.IUml_classReferenceResolver<ContainerType, ReferenceType> resolver;
	
	public Uml_classContextDependentURIFragmentFactory(org.emftext.language.uml_class.resource.uml_class.IUml_classReferenceResolver<ContainerType, ReferenceType> resolver) {
		this.resolver = resolver;
	}
	
	public org.emftext.language.uml_class.resource.uml_class.IUml_classContextDependentURIFragment<?> create(String identifier, ContainerType container, org.eclipse.emf.ecore.EReference reference, int positionInReference, org.eclipse.emf.ecore.EObject proxy) {
		
		return new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classContextDependentURIFragment<ContainerType, ReferenceType>(identifier, container, reference, positionInReference, proxy) {
			public org.emftext.language.uml_class.resource.uml_class.IUml_classReferenceResolver<ContainerType, ReferenceType> getResolver() {
				return resolver;
			}
		};
	}
}
