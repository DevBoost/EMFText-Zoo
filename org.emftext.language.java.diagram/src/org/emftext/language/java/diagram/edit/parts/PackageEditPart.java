package org.emftext.language.java.diagram.edit.parts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramDragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.emftext.language.java.diagram.edit.commands.JavaCreateShortcutDecorationsCommand;
import org.emftext.language.java.diagram.edit.policies.PackageCanonicalEditPolicy;
import org.emftext.language.java.diagram.edit.policies.PackageItemSemanticEditPolicy;

/**
 * @generated
 */
public class PackageEditPart extends DiagramEditPart {

	/**
	 * @generated
	 */
	public final static String MODEL_ID = "Java"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 1000;

	/**
	 * @generated
	 */
	public PackageEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new PackageItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new PackageCanonicalEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE,
				new DiagramDragDropEditPolicy() {
					public Command getDropObjectsCommand(
							DropObjectsRequest dropRequest) {
						List viewDescriptors = new ArrayList();
						for (Iterator it = dropRequest.getObjects().iterator(); it
								.hasNext();) {
							Object nextObject = it.next();
							if (false == nextObject instanceof EObject) {
								continue;
							}
							viewDescriptors
									.add(new CreateViewRequest.ViewDescriptor(
											new EObjectAdapter(
													(EObject) nextObject),
											Node.class, null,
											getDiagramPreferencesHint()));
						}
						return createShortcutsCommand(dropRequest,
								viewDescriptors);
					}

					private Command createShortcutsCommand(
							DropObjectsRequest dropRequest, List viewDescriptors) {
						Command command = createViewsAndArrangeCommand(
								dropRequest, viewDescriptors);
						if (command != null) {
							return command
									.chain(new ICommandProxy(
											new JavaCreateShortcutDecorationsCommand(
													getEditingDomain(),
													(View) getModel(),
													viewDescriptors)));
						}
						return null;
					}
				});
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE);
	}

}
