/*
 * 
 */
package org.emftext.language.valueflow.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.emftext.language.valueflow.diagram.providers.ValueflowElementTypes;

/**
 * @generated
 */
public class StateNextStateItemSemanticEditPolicy extends
		ValueflowBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public StateNextStateItemSemanticEditPolicy() {
		super(ValueflowElementTypes.StateNextState_4001);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req));
	}

}
