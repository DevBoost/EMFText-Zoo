package org.emftext.language.java.diagram.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.emftext.language.java.diagram.edit.commands.ClassifierImportClassifiersCreateCommand;
import org.emftext.language.java.diagram.edit.commands.ClassifierImportClassifiersReorientCommand;
import org.emftext.language.java.diagram.edit.commands.StaticImportStaticMembersCreateCommand;
import org.emftext.language.java.diagram.edit.commands.StaticImportStaticMembersReorientCommand;
import org.emftext.language.java.diagram.edit.parts.AnnotationEditPart;
import org.emftext.language.java.diagram.edit.parts.AnnotationMethodEditPart;
import org.emftext.language.java.diagram.edit.parts.BlockEditPart;
import org.emftext.language.java.diagram.edit.parts.Class2EditPart;
import org.emftext.language.java.diagram.edit.parts.ClassifierImportClassifiersEditPart;
import org.emftext.language.java.diagram.edit.parts.ConstructorEditPart;
import org.emftext.language.java.diagram.edit.parts.EnumerationEditPart;
import org.emftext.language.java.diagram.edit.parts.EnumerationEnumerationMembersCompartment2EditPart;
import org.emftext.language.java.diagram.edit.parts.FieldEditPart;
import org.emftext.language.java.diagram.edit.parts.InterfaceEditPart;
import org.emftext.language.java.diagram.edit.parts.MethodEditPart;
import org.emftext.language.java.diagram.edit.parts.PackageDescriptorEditPart;
import org.emftext.language.java.diagram.edit.parts.StaticImportStaticMembersEditPart;
import org.emftext.language.java.diagram.part.JavaVisualIDRegistry;
import org.emftext.language.java.diagram.providers.JavaElementTypes;

/**
 * @generated
 */
public class Enumeration2ItemSemanticEditPolicy extends
		JavaBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		CompoundCommand cc = getDestroyEdgesCommand();
		addDestroyChildNodesCommand(cc);
		addDestroyShortcutsCommand(cc);
		cc.add(getGEFWrapper(new DestroyElementCommand(req)));
		return cc.unwrap();
	}

	/**
	 * @generated
	 */
	protected void addDestroyChildNodesCommand(CompoundCommand cmd) {
		View view = (View) getHost().getModel();
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if (annotation != null) {
			return;
		}
		for (Iterator it = view.getChildren().iterator(); it.hasNext();) {
			Node node = (Node) it.next();
			switch (JavaVisualIDRegistry.getVisualID(node)) {
			case EnumerationEnumerationMembersCompartment2EditPart.VISUAL_ID:
				for (Iterator cit = node.getChildren().iterator(); cit
						.hasNext();) {
					Node cnode = (Node) cit.next();
					switch (JavaVisualIDRegistry.getVisualID(cnode)) {
					case AnnotationMethodEditPart.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode));
						break;
					case Class2EditPart.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode));
						break;
					case EnumerationEditPart.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode));
						break;
					case InterfaceEditPart.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode));
						break;
					case FieldEditPart.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode));
						break;
					case MethodEditPart.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode));
						break;
					case AnnotationEditPart.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode));
						break;
					case PackageDescriptorEditPart.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode));
						break;
					case ConstructorEditPart.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode));
						break;
					case BlockEditPart.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode));
						break;
					}
				}
				break;
			}
		}
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
		if (JavaElementTypes.ClassifierImportClassifiers_4003 == req
				.getElementType()) {
			return null;
		}
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
		if (JavaElementTypes.ClassifierImportClassifiers_4003 == req
				.getElementType()) {
			return getGEFWrapper(new ClassifierImportClassifiersCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
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
		case ClassifierImportClassifiersEditPart.VISUAL_ID:
			return getGEFWrapper(new ClassifierImportClassifiersReorientCommand(
					req));
		case StaticImportStaticMembersEditPart.VISUAL_ID:
			return getGEFWrapper(new StaticImportStaticMembersReorientCommand(
					req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
