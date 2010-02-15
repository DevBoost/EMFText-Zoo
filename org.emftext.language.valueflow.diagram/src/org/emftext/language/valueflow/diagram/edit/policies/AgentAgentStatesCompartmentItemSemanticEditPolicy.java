/*
 * 
 */
package org.emftext.language.valueflow.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.emftext.language.valueflow.diagram.edit.commands.GiveStateCreateCommand;
import org.emftext.language.valueflow.diagram.edit.commands.TakeStateCreateCommand;
import org.emftext.language.valueflow.diagram.providers.ValueflowElementTypes;

/**
 * @generated
 */
public class AgentAgentStatesCompartmentItemSemanticEditPolicy extends
		ValueflowBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public AgentAgentStatesCompartmentItemSemanticEditPolicy() {
		super(ValueflowElementTypes.Agent_2001);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (ValueflowElementTypes.GiveState_3001 == req.getElementType()) {
			return getGEFWrapper(new GiveStateCreateCommand(req));
		}
		if (ValueflowElementTypes.TakeState_3002 == req.getElementType()) {
			return getGEFWrapper(new TakeStateCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
