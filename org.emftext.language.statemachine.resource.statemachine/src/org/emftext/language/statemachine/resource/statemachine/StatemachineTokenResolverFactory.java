package org.emftext.language.statemachine.resource.statemachine;

public class StatemachineTokenResolverFactory extends org.emftext.runtime.resource.impl.AbstractTokenResolverFactory implements org.emftext.runtime.resource.ITokenResolverFactory {
	
	public StatemachineTokenResolverFactory() {
		super.registerTokenResolver("PSEUDOKIND", new org.emftext.language.statemachine.resource.statemachine.analysis.StatemachinePSEUDOKINDTokenResolver());
		super.registerTokenResolver("TEXT", new org.emftext.language.statemachine.resource.statemachine.analysis.StatemachineTEXTTokenResolver());
		super.registerTokenResolver("QUOTED_34_34", new org.emftext.language.statemachine.resource.statemachine.analysis.StatemachineQUOTED_34_34TokenResolver());
	}
}
