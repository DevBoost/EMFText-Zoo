package org.emftext.language.sparql.resource.sparql;

public class SparqlTokenResolverFactory extends org.emftext.runtime.resource.impl.AbstractTokenResolverFactory implements org.emftext.runtime.resource.ITokenResolverFactory {
	
	private java.util.Map<java.lang.String, org.emftext.runtime.resource.ITokenResolver> tokenName2TokenResolver;
	private java.util.Map<java.lang.String, org.emftext.runtime.resource.ITokenResolver> featureName2CollectInTokenResolver;
	private static org.emftext.runtime.resource.ITokenResolver defaultResolver = new org.emftext.language.sparql.resource.sparql.SparqlDefaultTokenResolver();
	
	public SparqlTokenResolverFactory() {
		tokenName2TokenResolver = new java.util.HashMap<java.lang.String, org.emftext.runtime.resource.ITokenResolver>();
		featureName2CollectInTokenResolver = new java.util.HashMap<java.lang.String, org.emftext.runtime.resource.ITokenResolver>();
		registerTokenResolver("DEF_IRI_REF", new org.emftext.language.sparql.resource.sparql.analysis.SparqlDEF_IRI_REFTokenResolver());
		registerTokenResolver("DEF_INTEGER", new org.emftext.language.sparql.resource.sparql.analysis.SparqlDEF_INTEGERTokenResolver());
	}
	
	public org.emftext.runtime.resource.ITokenResolver createTokenResolver(java.lang.String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public org.emftext.runtime.resource.ITokenResolver createCollectInTokenResolver(java.lang.String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(java.lang.String tokenName, org.emftext.runtime.resource.ITokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(java.lang.String featureName, org.emftext.runtime.resource.ITokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected org.emftext.runtime.resource.ITokenResolver deRegisterTokenResolver(java.lang.String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private org.emftext.runtime.resource.ITokenResolver internalCreateResolver(java.util.Map<java.lang.String, org.emftext.runtime.resource.ITokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(java.util.Map<java.lang.String, org.emftext.runtime.resource.ITokenResolver> resolverMap, java.lang.String key, org.emftext.runtime.resource.ITokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
