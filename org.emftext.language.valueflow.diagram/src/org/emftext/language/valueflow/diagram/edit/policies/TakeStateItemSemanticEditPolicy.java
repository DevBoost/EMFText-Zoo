package org.emftext.language.valueflow.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.emftext.language.valueflow.diagram.edit.commands.GiveStateGiveToCreateCommand;
import org.emftext.language.valueflow.diagram.edit.commands.GiveStateGiveToReorientCommand;
import org.emftext.language.valueflow.diagram.edit.commands.StateNextStateCreateCommand;
import org.emftext.language.valueflow.diagram.edit.commands.StateNextStateReorientCommand;
import org.emftext.language.valueflow.diagram.edit.parts.GiveStateGiveToEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.StateNextStateEditPart;
import org.emftext.language.valueflow.diagram.providers.ValueflowElementTypes;

/**
 * @generated
 */
public class TakeStateItemSemanticEditPolicy extends
		ValueflowBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		CompoundCommand cc = getDestroyEdgesCommand();
		addDestroyShortcutsCommand(cc);
		cc.add(getGEFWrapper(new DestroyElementCommand(req)));
		return cc.unwrap();
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req)
				: getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super
				.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (ValueflowElementTypes.StateNextState_3001 == req.getElementType()) {
			return getGEFWrapper(new StateNextStateCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		if (ValueflowElementTypes.GiveStateGiveTo_3002 == req.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (ValueflowElementTypes.StateNextState_3001 == req.getElementType()) {
			return getGEFWrapper(new StateNextStateCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		if (ValueflowElementTypes.GiveStateGiveTo_3002 == req.getElementType()) {
			return getGEFWrapper(new GiveStateGiveToCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(
			ReorientReferenceRelationshipRequest req) {
		switch (getVisualID(req)) {
		case StateNextStateEditPart.VISUAL_ID:
			return getGEFWrapper(new StateNextStateReorientCommand(req));
		case GiveStateGiveToEditPart.VISUAL_ID:
			return getGEFWrapper(new GiveStateGiveToReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
