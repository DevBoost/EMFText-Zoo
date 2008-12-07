package org.emftext.language.simple_c.resource.c;

import org.emftext.runtime.resource.TokenResolverFactory;
import org.emftext.runtime.resource.impl.BasicTokenResolverFactory;

import org.emftext.language.simple_c.resource.c.analysis.*;

public class CTokenResolverFactory extends BasicTokenResolverFactory implements TokenResolverFactory{

	public CTokenResolverFactory(){
		super.registerTokenResolver("TEXT",new CTEXTTokenResolver());
	}
}
