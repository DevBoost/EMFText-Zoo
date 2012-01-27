/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl.mopp;

/**
 * The PlTokenResolverFactory class provides access to all generated token
 * resolvers. By giving the name of a defined token, the corresponding resolve can
 * be obtained. Despite the fact that this class is called TokenResolverFactory is
 * does NOT create new token resolvers whenever a client calls methods to obtain a
 * resolver. Rather, this class maintains a map of all resolvers and creates each
 * resolver at most once.
 */
public class PlTokenResolverFactory implements org.emftext.language.prolog.resource.pl.IPlTokenResolverFactory {
	
	private java.util.Map<String, org.emftext.language.prolog.resource.pl.IPlTokenResolver> tokenName2TokenResolver;
	private java.util.Map<String, org.emftext.language.prolog.resource.pl.IPlTokenResolver> featureName2CollectInTokenResolver;
	private static org.emftext.language.prolog.resource.pl.IPlTokenResolver defaultResolver = new org.emftext.language.prolog.resource.pl.analysis.PlDefaultTokenResolver();
	
	public PlTokenResolverFactory() {
		tokenName2TokenResolver = new java.util.LinkedHashMap<String, org.emftext.language.prolog.resource.pl.IPlTokenResolver>();
		featureName2CollectInTokenResolver = new java.util.LinkedHashMap<String, org.emftext.language.prolog.resource.pl.IPlTokenResolver>();
		registerTokenResolver("FLOAT", new org.emftext.language.prolog.resource.pl.analysis.PlFLOATTokenResolver());
		registerTokenResolver("CAPITAL_WORD", new org.emftext.language.prolog.resource.pl.analysis.PlCAPITAL_WORDTokenResolver());
		registerTokenResolver("SMALL_WORD", new org.emftext.language.prolog.resource.pl.analysis.PlSMALL_WORDTokenResolver());
		registerTokenResolver("ANONYMOUS", new org.emftext.language.prolog.resource.pl.analysis.PlANONYMOUSTokenResolver());
		registerTokenResolver("QUOTED_39_39", new org.emftext.language.prolog.resource.pl.analysis.PlQUOTED_39_39TokenResolver());
	}
	
	public org.emftext.language.prolog.resource.pl.IPlTokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public org.emftext.language.prolog.resource.pl.IPlTokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, org.emftext.language.prolog.resource.pl.IPlTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, org.emftext.language.prolog.resource.pl.IPlTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected org.emftext.language.prolog.resource.pl.IPlTokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private org.emftext.language.prolog.resource.pl.IPlTokenResolver internalCreateResolver(java.util.Map<String, org.emftext.language.prolog.resource.pl.IPlTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(java.util.Map<String, org.emftext.language.prolog.resource.pl.IPlTokenResolver> resolverMap, String key, org.emftext.language.prolog.resource.pl.IPlTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
