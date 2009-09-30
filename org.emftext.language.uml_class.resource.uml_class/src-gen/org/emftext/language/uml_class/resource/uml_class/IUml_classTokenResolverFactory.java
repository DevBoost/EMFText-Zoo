package org.emftext.language.uml_class.resource.uml_class;

// A TokenResolverFactory creates TokenResolvers for a given token name.
// They may be implemented like a registry.
public interface IUml_classTokenResolverFactory {
	
	// Creates a token resolver for normal tokens of type 'tokenName'.
	public org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver createTokenResolver(String tokenName);
	
	// Creates a token resolver for COLLECT-IN tokens that are stores in
	// feature 'featureName'.
	public org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver createCollectInTokenResolver(String featureName);
}
