package org.emftext.language.conference.resource.conference.analysis;

import java.util.Map;

import org.emftext.language.conference.Conference;
import org.emftext.language.conference.Participant;

public class ConferenceOrganizersReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.language.conference.Conference, org.emftext.language.conference.Participant> {
	
	private ConferenceDefaultResolverDelegate<Conference, Participant> delegate = new ConferenceDefaultResolverDelegate<Conference, Participant>();
	
	public java.lang.String deResolve(org.emftext.language.conference.Participant element, org.emftext.language.conference.Conference container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void resolve(java.lang.String identifier, org.emftext.language.conference.Conference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.emftext.language.conference.Participant> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}

	public void setOptions(Map<?, ?> options) {
	}
}
