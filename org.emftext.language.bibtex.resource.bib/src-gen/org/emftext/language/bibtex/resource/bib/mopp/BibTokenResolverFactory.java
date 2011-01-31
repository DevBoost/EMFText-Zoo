/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.bibtex.resource.bib.mopp;

/**
 * The BibTokenResolverFactory class provides access to all generated token
 * resolvers. By giving the name of a defined token, the corresponding resolve can
 * be obtained. Despite the fact that this class is called TokenResolverFactory is
 * does NOT create new token resolvers whenever a client calls methods to obtain a
 * resolver. Rather, this class maintains a map of all resolvers and creates each
 * resolver at most once.
 */
public class BibTokenResolverFactory implements org.emftext.language.bibtex.resource.bib.IBibTokenResolverFactory {
	
	private java.util.Map<String, org.emftext.language.bibtex.resource.bib.IBibTokenResolver> tokenName2TokenResolver;
	private java.util.Map<String, org.emftext.language.bibtex.resource.bib.IBibTokenResolver> featureName2CollectInTokenResolver;
	private static org.emftext.language.bibtex.resource.bib.IBibTokenResolver defaultResolver = new org.emftext.language.bibtex.resource.bib.analysis.BibDefaultTokenResolver();
	
	public BibTokenResolverFactory() {
		tokenName2TokenResolver = new java.util.LinkedHashMap<String, org.emftext.language.bibtex.resource.bib.IBibTokenResolver>();
		featureName2CollectInTokenResolver = new java.util.LinkedHashMap<String, org.emftext.language.bibtex.resource.bib.IBibTokenResolver>();
		registerTokenResolver("YEAR", new org.emftext.language.bibtex.resource.bib.analysis.BibYEARTokenResolver());
		registerTokenResolver("INTEGER", new org.emftext.language.bibtex.resource.bib.analysis.BibINTEGERTokenResolver());
		registerTokenResolver("TEXT", new org.emftext.language.bibtex.resource.bib.analysis.BibTEXTTokenResolver());
		registerTokenResolver("QUOTED_34_34", new org.emftext.language.bibtex.resource.bib.analysis.BibQUOTED_34_34TokenResolver());
	}
	
	public org.emftext.language.bibtex.resource.bib.IBibTokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public org.emftext.language.bibtex.resource.bib.IBibTokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected org.emftext.language.bibtex.resource.bib.IBibTokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private org.emftext.language.bibtex.resource.bib.IBibTokenResolver internalCreateResolver(java.util.Map<String, org.emftext.language.bibtex.resource.bib.IBibTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(java.util.Map<String, org.emftext.language.bibtex.resource.bib.IBibTokenResolver> resolverMap, String key, org.emftext.language.bibtex.resource.bib.IBibTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
