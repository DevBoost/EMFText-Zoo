/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.analysis;

public class WordGovernorsReferenceResolver implements dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfReferenceResolver<org.devboost.stanford.language.Word, org.devboost.stanford.language.Dependency> {
	
	private dk.itu.sdg.language.xwpf.resource.xwpf.analysis.XwpfDefaultResolverDelegate<org.devboost.stanford.language.Word, org.devboost.stanford.language.Dependency> delegate = new dk.itu.sdg.language.xwpf.resource.xwpf.analysis.XwpfDefaultResolverDelegate<org.devboost.stanford.language.Word, org.devboost.stanford.language.Dependency>();
	
	public void resolve(String identifier, org.devboost.stanford.language.Word container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfReferenceResolveResult<org.devboost.stanford.language.Dependency> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.devboost.stanford.language.Dependency element, org.devboost.stanford.language.Word container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
