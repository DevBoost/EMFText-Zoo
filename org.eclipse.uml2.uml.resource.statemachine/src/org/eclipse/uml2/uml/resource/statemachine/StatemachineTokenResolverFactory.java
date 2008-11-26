package org.eclipse.uml2.uml.resource.statemachine;

import org.reuseware.emftextedit.runtime.resource.TokenResolverFactory;
import org.reuseware.emftextedit.runtime.resource.impl.BasicTokenResolverFactory;

import org.eclipse.uml2.uml.resource.statemachine.analysis.*;

public class StatemachineTokenResolverFactory extends BasicTokenResolverFactory implements TokenResolverFactory{

	public StatemachineTokenResolverFactory(){
		super.registerTokenResolver("TEXT",new StatemachineTEXTTokenResolver());
		super.registerTokenResolver("QUOTED_34_34",new StatemachineQUOTED_34_34TokenResolver());
	}
}
