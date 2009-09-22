package org.emftext.language.conference.resource.conference.analysis;

public class ConferenceOrganizersReferenceResolver implements org.emftext.language.conference.resource.conference.IConferenceReferenceResolver<org.emftext.language.conference.Conference, org.emftext.language.conference.Participant> {
	
	private org.emftext.language.conference.resource.conference.analysis.ConferenceDefaultResolverDelegate<org.emftext.language.conference.Conference, org.emftext.language.conference.Participant> delegate = new org.emftext.language.conference.resource.conference.analysis.ConferenceDefaultResolverDelegate<org.emftext.language.conference.Conference, org.emftext.language.conference.Participant>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.conference.Conference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.language.conference.resource.conference.IConferenceReferenceResolveResult<org.emftext.language.conference.Participant> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.language.conference.Participant element, org.emftext.language.conference.Conference container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
