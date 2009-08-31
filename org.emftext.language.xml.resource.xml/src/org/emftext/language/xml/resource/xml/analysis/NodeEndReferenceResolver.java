package org.emftext.language.xml.resource.xml.analysis;

public class NodeEndReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.language.exml.Node, org.emftext.language.exml.Tag> {
	
	private org.emftext.language.xml.resource.xml.analysis.XmlDefaultResolverDelegate<org.emftext.language.exml.Node, org.emftext.language.exml.Tag> delegate = new org.emftext.language.xml.resource.xml.analysis.XmlDefaultResolverDelegate<org.emftext.language.exml.Node, org.emftext.language.exml.Tag>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.exml.Node container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.emftext.language.exml.Tag> result) {
		if (container.getStart().getName().equals(identifier)) {
			result.addMapping(identifier, container.getStart());
		}
		if (resolveFuzzy) {
			result.addMapping(container.getStart().getName(), container.getStart());
		}
		//delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.language.exml.Tag element, org.emftext.language.exml.Node container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
