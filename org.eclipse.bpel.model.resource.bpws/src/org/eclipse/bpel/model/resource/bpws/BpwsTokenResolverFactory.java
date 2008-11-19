package org.eclipse.bpel.model.resource.bpws;

import org.reuseware.emftextedit.runtime.resource.TokenResolverFactory;
import org.reuseware.emftextedit.runtime.resource.impl.BasicTokenResolverFactory;

import org.eclipse.bpel.model.resource.bpws.analysis.*;

public class BpwsTokenResolverFactory extends BasicTokenResolverFactory implements TokenResolverFactory{

	public BpwsTokenResolverFactory(){
		super.registerTokenResolver("QUOTED_34_34",new BpwsQUOTED_34_34TokenResolver());
		super.registerTokenResolver("TEXT",new BpwsTEXTTokenResolver());
	}
}
