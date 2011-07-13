
package org.emftext.language.devices.resource.devices.analysis;

public class DeviceSupportedProtocolsReferenceResolver implements org.emftext.language.devices.resource.devices.IDevicesReferenceResolver<org.emftext.language.devices.Device, org.emftext.language.devices.Protocol> {
	
	private org.emftext.language.devices.resource.devices.analysis.DevicesDefaultResolverDelegate<org.emftext.language.devices.Device, org.emftext.language.devices.Protocol> delegate = new org.emftext.language.devices.resource.devices.analysis.DevicesDefaultResolverDelegate<org.emftext.language.devices.Device, org.emftext.language.devices.Protocol>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.devices.Device container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.devices.resource.devices.IDevicesReferenceResolveResult<org.emftext.language.devices.Protocol> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.language.devices.Protocol element, org.emftext.language.devices.Device container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
