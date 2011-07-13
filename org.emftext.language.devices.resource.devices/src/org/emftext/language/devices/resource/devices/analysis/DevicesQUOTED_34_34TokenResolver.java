
package org.emftext.language.devices.resource.devices.analysis;

public class DevicesQUOTED_34_34TokenResolver implements org.emftext.language.devices.resource.devices.IDevicesTokenResolver {
	
	private org.emftext.language.devices.resource.devices.analysis.DevicesDefaultTokenResolver defaultTokenResolver = new org.emftext.language.devices.resource.devices.analysis.DevicesDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		result += "\"";
		result = "\"" + result;
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.devices.resource.devices.IDevicesTokenResolveResult result) {
		lexem = lexem.substring(1);
		lexem = lexem.substring(0, lexem.length() - 1);
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
