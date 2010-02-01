/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.pl0.resource.pl0;

// A TokenResolverFactory creates TokenResolvers for a given token name.
// They may be implemented like a registry.
public interface IPl0TokenResolverFactory {
	
	// Creates a token resolver for normal tokens of type 'tokenName'.
	public org.emftext.language.pl0.resource.pl0.IPl0TokenResolver createTokenResolver(String tokenName);
	
	// Creates a token resolver for COLLECT-IN tokens that are stores in
	// feature 'featureName'.
	public org.emftext.language.pl0.resource.pl0.IPl0TokenResolver createCollectInTokenResolver(String featureName);
}
