/*
 * 
 */
package org.emftext.language.secprop.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.emftext.language.secprop.diagram.edit.commands.AccessCreateCommand;
import org.emftext.language.secprop.diagram.edit.commands.EncryptionCreateCommand;
import org.emftext.language.secprop.diagram.providers.SecpropElementTypes;

/**
 * @generated
 */
public class DataDataSecurityInformationCompartmentItemSemanticEditPolicy
		extends SecpropBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public DataDataSecurityInformationCompartmentItemSemanticEditPolicy() {
		super(SecpropElementTypes.Data_2002);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (SecpropElementTypes.Access_3001 == req.getElementType()) {
			return getGEFWrapper(new AccessCreateCommand(req));
		}
		if (SecpropElementTypes.Encryption_3002 == req.getElementType()) {
			return getGEFWrapper(new EncryptionCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
