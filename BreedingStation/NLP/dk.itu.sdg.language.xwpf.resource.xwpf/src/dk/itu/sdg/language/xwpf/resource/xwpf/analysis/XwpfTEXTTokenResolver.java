/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.analysis;

public class XwpfTEXTTokenResolver implements dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolver {
	
	private dk.itu.sdg.language.xwpf.resource.xwpf.analysis.XwpfDefaultTokenResolver defaultTokenResolver = new dk.itu.sdg.language.xwpf.resource.xwpf.analysis.XwpfDefaultTokenResolver(true);
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		String result = defaultTokenResolver.deResolve(value, feature, container, null, null, null);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenResolveResult result) {
		// By default token resolving is delegated to the DefaultTokenResolver.
		defaultTokenResolver.resolve(lexem, feature, result, null, null, null);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
