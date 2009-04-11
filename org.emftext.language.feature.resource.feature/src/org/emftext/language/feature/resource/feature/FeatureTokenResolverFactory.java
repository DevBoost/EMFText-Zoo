package org.emftext.language.feature.resource.feature;

public class FeatureTokenResolverFactory extends org.emftext.runtime.resource.impl.AbstractTokenResolverFactory implements org.emftext.runtime.resource.ITokenResolverFactory {
	
	public FeatureTokenResolverFactory() {
		super.registerTokenResolver("INTEGER", new org.emftext.language.feature.resource.feature.analysis.FeatureINTEGERTokenResolver());
		super.registerTokenResolver("TEXT", new org.emftext.language.feature.resource.feature.analysis.FeatureTEXTTokenResolver());
		super.registerTokenResolver("QUOTED_34_34", new org.emftext.language.feature.resource.feature.analysis.FeatureQUOTED_34_34TokenResolver());
	}
}
