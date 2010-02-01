/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.pl0.resource.pl0.mopp;

public class Pl0TokenResolverFactory implements org.emftext.language.pl0.resource.pl0.IPl0TokenResolverFactory {
	
	private java.util.Map<java.lang.String, org.emftext.language.pl0.resource.pl0.IPl0TokenResolver> tokenName2TokenResolver;
	private java.util.Map<java.lang.String, org.emftext.language.pl0.resource.pl0.IPl0TokenResolver> featureName2CollectInTokenResolver;
	private static org.emftext.language.pl0.resource.pl0.IPl0TokenResolver defaultResolver = new org.emftext.language.pl0.resource.pl0.analysis.Pl0DefaultTokenResolver();
	
	public Pl0TokenResolverFactory() {
		tokenName2TokenResolver = new java.util.HashMap<java.lang.String, org.emftext.language.pl0.resource.pl0.IPl0TokenResolver>();
		featureName2CollectInTokenResolver = new java.util.HashMap<java.lang.String, org.emftext.language.pl0.resource.pl0.IPl0TokenResolver>();
		registerCollectInTokenResolver("comments", new org.emftext.language.pl0.resource.pl0.analysis.Pl0COLLECT_commentsTokenResolver());
		registerCollectInTokenResolver("comments", new org.emftext.language.pl0.resource.pl0.analysis.Pl0COLLECT_commentsTokenResolver());
		registerTokenResolver("PL0ID", new org.emftext.language.pl0.resource.pl0.analysis.Pl0PL0IDTokenResolver());
		registerTokenResolver("NUMBER", new org.emftext.language.pl0.resource.pl0.analysis.Pl0NUMBERTokenResolver());
		registerTokenResolver("REL_OP", new org.emftext.language.pl0.resource.pl0.analysis.Pl0REL_OPTokenResolver());
		registerTokenResolver("PLUS_MINUS", new org.emftext.language.pl0.resource.pl0.analysis.Pl0PLUS_MINUSTokenResolver());
		registerTokenResolver("MUL_DIV", new org.emftext.language.pl0.resource.pl0.analysis.Pl0MUL_DIVTokenResolver());
	}
	
	public org.emftext.language.pl0.resource.pl0.IPl0TokenResolver createTokenResolver(java.lang.String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public org.emftext.language.pl0.resource.pl0.IPl0TokenResolver createCollectInTokenResolver(java.lang.String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(java.lang.String tokenName, org.emftext.language.pl0.resource.pl0.IPl0TokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(java.lang.String featureName, org.emftext.language.pl0.resource.pl0.IPl0TokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected org.emftext.language.pl0.resource.pl0.IPl0TokenResolver deRegisterTokenResolver(java.lang.String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private org.emftext.language.pl0.resource.pl0.IPl0TokenResolver internalCreateResolver(java.util.Map<java.lang.String, org.emftext.language.pl0.resource.pl0.IPl0TokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(java.util.Map<java.lang.String, org.emftext.language.pl0.resource.pl0.IPl0TokenResolver> resolverMap, java.lang.String key, org.emftext.language.pl0.resource.pl0.IPl0TokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
