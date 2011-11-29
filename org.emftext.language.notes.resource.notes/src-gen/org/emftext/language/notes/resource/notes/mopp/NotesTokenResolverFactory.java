/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.notes.resource.notes.mopp;

/**
 * The NotesTokenResolverFactory class provides access to all generated token
 * resolvers. By giving the name of a defined token, the corresponding resolve can
 * be obtained. Despite the fact that this class is called TokenResolverFactory is
 * does NOT create new token resolvers whenever a client calls methods to obtain a
 * resolver. Rather, this class maintains a map of all resolvers and creates each
 * resolver at most once.
 */
public class NotesTokenResolverFactory implements org.emftext.language.notes.resource.notes.INotesTokenResolverFactory {
	
	private java.util.Map<String, org.emftext.language.notes.resource.notes.INotesTokenResolver> tokenName2TokenResolver;
	private java.util.Map<String, org.emftext.language.notes.resource.notes.INotesTokenResolver> featureName2CollectInTokenResolver;
	private static org.emftext.language.notes.resource.notes.INotesTokenResolver defaultResolver = new org.emftext.language.notes.resource.notes.analysis.NotesDefaultTokenResolver();
	
	public NotesTokenResolverFactory() {
		tokenName2TokenResolver = new java.util.LinkedHashMap<String, org.emftext.language.notes.resource.notes.INotesTokenResolver>();
		featureName2CollectInTokenResolver = new java.util.LinkedHashMap<String, org.emftext.language.notes.resource.notes.INotesTokenResolver>();
		registerTokenResolver("TEXT", new org.emftext.language.notes.resource.notes.analysis.NotesTEXTTokenResolver());
		registerTokenResolver("QUOTED_91_93", new org.emftext.language.notes.resource.notes.analysis.NotesQUOTED_91_93TokenResolver());
		registerTokenResolver("QUOTED_95_95", new org.emftext.language.notes.resource.notes.analysis.NotesQUOTED_95_95TokenResolver());
		registerTokenResolver("QUOTED_35_35", new org.emftext.language.notes.resource.notes.analysis.NotesQUOTED_35_35TokenResolver());
		registerTokenResolver("QUOTED_64_64", new org.emftext.language.notes.resource.notes.analysis.NotesQUOTED_64_64TokenResolver());
	}
	
	public org.emftext.language.notes.resource.notes.INotesTokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public org.emftext.language.notes.resource.notes.INotesTokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, org.emftext.language.notes.resource.notes.INotesTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, org.emftext.language.notes.resource.notes.INotesTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected org.emftext.language.notes.resource.notes.INotesTokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private org.emftext.language.notes.resource.notes.INotesTokenResolver internalCreateResolver(java.util.Map<String, org.emftext.language.notes.resource.notes.INotesTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(java.util.Map<String, org.emftext.language.notes.resource.notes.INotesTokenResolver> resolverMap, String key, org.emftext.language.notes.resource.notes.INotesTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
