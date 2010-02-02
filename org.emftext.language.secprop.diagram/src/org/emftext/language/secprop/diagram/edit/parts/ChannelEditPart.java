/*
 * 
 */
package org.emftext.language.secprop.diagram.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.View;
import org.emftext.language.secprop.diagram.edit.policies.ChannelItemSemanticEditPolicy;

/**
 * @generated
 */
public class ChannelEditPart extends ConnectionNodeEditPart implements
		ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4001;

	/**
	 * @generated
	 */
	public ChannelEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new ChannelItemSemanticEditPolicy());
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */

	protected Connection createConnectionFigure() {
		return new ChannelFigure();
	}

	/**
	 * @generated
	 */
	public ChannelFigure getPrimaryShape() {
		return (ChannelFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class ChannelFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		public ChannelFigure() {
			this.setLineWidth(4);

		}

	}

}
