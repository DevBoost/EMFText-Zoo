package org.emftext.language.conference.resource.conference.analysis;

public class ConferenceOrganizersReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.language.conference.Conference, org.emftext.language.conference.Participant> {
	
	@Override	
	protected java.lang.String doDeResolve(org.emftext.language.conference.Participant element, org.emftext.language.conference.Conference container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, org.emftext.language.conference.Conference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.emftext.language.conference.Participant> result) {
		super.doResolve(identifier, container, reference, position, resolveFuzzy, result);
	}
}
