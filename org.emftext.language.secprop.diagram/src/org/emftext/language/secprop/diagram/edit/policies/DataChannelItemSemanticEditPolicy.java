/*
 * 
 */
package org.emftext.language.secprop.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.emftext.language.secprop.diagram.providers.SecpropElementTypes;

/**
 * @generated
 */
public class DataChannelItemSemanticEditPolicy extends
		SecpropBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public DataChannelItemSemanticEditPolicy() {
		super(SecpropElementTypes.DataChannel_4002);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req));
	}

}
