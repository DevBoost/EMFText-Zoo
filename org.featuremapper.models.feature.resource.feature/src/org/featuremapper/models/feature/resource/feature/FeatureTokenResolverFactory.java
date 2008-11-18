package org.featuremapper.models.feature.resource.feature;

import org.reuseware.emftextedit.runtime.resource.TokenResolverFactory;
import org.reuseware.emftextedit.runtime.resource.impl.BasicTokenResolverFactory;

import org.featuremapper.models.feature.resource.feature.analysis.*;

public class FeatureTokenResolverFactory extends BasicTokenResolverFactory implements TokenResolverFactory{

	public FeatureTokenResolverFactory(){
		super.registerTokenResolver("TEXT",new FeatureTEXTTokenResolver());
		super.registerTokenResolver("INTEGER",new FeatureINTEGERTokenResolver());
		super.registerTokenResolver("QUOTED_34_34",new FeatureQUOTED_34_34TokenResolver());
	}
}
