/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.analysis;

public class DependencyGovernorReferenceResolver implements dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfReferenceResolver<org.devboost.stanford.language.Dependency, org.devboost.stanford.language.Word> {
	
	private dk.itu.sdg.language.xwpf.resource.xwpf.analysis.XwpfDefaultResolverDelegate<org.devboost.stanford.language.Dependency, org.devboost.stanford.language.Word> delegate = new dk.itu.sdg.language.xwpf.resource.xwpf.analysis.XwpfDefaultResolverDelegate<org.devboost.stanford.language.Dependency, org.devboost.stanford.language.Word>();
	
	public void resolve(String identifier, org.devboost.stanford.language.Dependency container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfReferenceResolveResult<org.devboost.stanford.language.Word> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.devboost.stanford.language.Word element, org.devboost.stanford.language.Dependency container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
