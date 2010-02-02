/*
 * 
 */
package org.emftext.language.secprop.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.emftext.language.secprop.diagram.edit.commands.DataChannelCreateCommand;
import org.emftext.language.secprop.diagram.edit.commands.DataChannelReorientCommand;
import org.emftext.language.secprop.diagram.edit.parts.DataChannelEditPart;
import org.emftext.language.secprop.diagram.providers.SecpropElementTypes;

/**
 * @generated
 */
public class ChannelItemSemanticEditPolicy extends
		SecpropBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ChannelItemSemanticEditPolicy() {
		super(SecpropElementTypes.Channel_4001);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return getGEFWrapper(new DestroyElementCommand(req));
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
		if (SecpropElementTypes.DataChannel_4002 == req.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (SecpropElementTypes.DataChannel_4002 == req.getElementType()) {
			return getGEFWrapper(new DataChannelCreateCommand(req, req
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
		case DataChannelEditPart.VISUAL_ID:
			return getGEFWrapper(new DataChannelReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
