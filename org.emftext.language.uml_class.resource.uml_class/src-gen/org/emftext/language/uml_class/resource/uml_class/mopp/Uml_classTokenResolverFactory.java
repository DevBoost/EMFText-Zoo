package org.emftext.language.uml_class.resource.uml_class.mopp;

public class Uml_classTokenResolverFactory implements org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolverFactory {
	
	private java.util.Map<java.lang.String, org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver> tokenName2TokenResolver;
	private java.util.Map<java.lang.String, org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver> featureName2CollectInTokenResolver;
	private static org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver defaultResolver = new org.emftext.language.uml_class.resource.uml_class.analysis.Uml_classDefaultTokenResolver();
	
	public Uml_classTokenResolverFactory() {
		tokenName2TokenResolver = new java.util.HashMap<java.lang.String, org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver>();
		featureName2CollectInTokenResolver = new java.util.HashMap<java.lang.String, org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver>();
		registerTokenResolver("TEXT", new org.emftext.language.uml_class.resource.uml_class.analysis.Uml_classTEXTTokenResolver());
		registerTokenResolver("QUOTED_34_34", new org.emftext.language.uml_class.resource.uml_class.analysis.Uml_classQUOTED_34_34TokenResolver());
	}
	
	public org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver createTokenResolver(java.lang.String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver createCollectInTokenResolver(java.lang.String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(java.lang.String tokenName, org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(java.lang.String featureName, org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver deRegisterTokenResolver(java.lang.String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver internalCreateResolver(java.util.Map<java.lang.String, org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(java.util.Map<java.lang.String, org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver> resolverMap, java.lang.String key, org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
