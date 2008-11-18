package org.eclipse.uml2.uml.resource.uml;

import org.reuseware.emftextedit.runtime.resource.TokenResolverFactory;
import org.reuseware.emftextedit.runtime.resource.impl.BasicTokenResolverFactory;

import org.eclipse.uml2.uml.resource.uml.analysis.*;

public class UmlTokenResolverFactory extends BasicTokenResolverFactory implements TokenResolverFactory{

	public UmlTokenResolverFactory(){
		super.registerTokenResolver("TEXT",new UmlTEXTTokenResolver());
		super.registerTokenResolver("QUOTED_34_34",new UmlQUOTED_34_34TokenResolver());
	}
}
