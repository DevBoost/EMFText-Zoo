package org.featuremapper.models.feature.resource.feature;

import org.emftext.runtime.resource.TokenResolverFactory;
import org.emftext.runtime.resource.impl.BasicTokenResolverFactory;

import org.featuremapper.models.feature.resource.feature.analysis.*;

public class FeatureTokenResolverFactory extends BasicTokenResolverFactory implements TokenResolverFactory{

	public FeatureTokenResolverFactory(){
		super.registerTokenResolver("TEXT",new FeatureTEXTTokenResolver());
		super.registerTokenResolver("QUOTED_34_34",new FeatureQUOTED_34_34TokenResolver());
		super.registerTokenResolver("INTEGER",new FeatureINTEGERTokenResolver());
	}
}
