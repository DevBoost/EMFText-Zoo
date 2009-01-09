package org.emftext.language.java.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.emftext.language.java.diagram.edit.commands.StaticImportStaticMembersCreateCommand;
import org.emftext.language.java.diagram.edit.commands.StaticImportStaticMembersReorientCommand;
import org.emftext.language.java.diagram.edit.parts.StaticImportStaticMembersEditPart;
import org.emftext.language.java.diagram.providers.JavaElementTypes;

/**
 * @generated
 */
public class FieldItemSemanticEditPolicy extends JavaBaseItemSemanticEditPolicy {

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
		if (JavaElementTypes.StaticImportStaticMembers_4004 == req
				.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (JavaElementTypes.StaticImportStaticMembers_4004 == req
				.getElementType()) {
			return getGEFWrapper(new StaticImportStaticMembersCreateCommand(
					req, req.getSource(), req.getTarget()));
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
		case StaticImportStaticMembersEditPart.VISUAL_ID:
			return getGEFWrapper(new StaticImportStaticMembersReorientCommand(
					req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
