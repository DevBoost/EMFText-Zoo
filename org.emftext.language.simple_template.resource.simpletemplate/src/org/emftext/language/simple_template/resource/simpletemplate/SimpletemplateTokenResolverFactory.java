package org.emftext.language.simple_template.resource.simpletemplate;

import org.emftext.runtime.resource.TokenResolverFactory;
import org.emftext.runtime.resource.impl.BasicTokenResolverFactory;

import org.emftext.language.simple_template.resource.simpletemplate.analysis.*;

public class SimpletemplateTokenResolverFactory extends BasicTokenResolverFactory implements TokenResolverFactory{

	public SimpletemplateTokenResolverFactory(){
		super.registerTokenResolver("TEXT",new SimpletemplateTEXTTokenResolver());
	}
}
