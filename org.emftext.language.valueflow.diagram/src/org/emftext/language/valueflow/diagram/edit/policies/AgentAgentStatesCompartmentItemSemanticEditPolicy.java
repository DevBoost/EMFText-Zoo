/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.valueflow.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.emftext.language.valueflow.ValueflowPackage;
import org.emftext.language.valueflow.diagram.edit.commands.GiveStateCreateCommand;
import org.emftext.language.valueflow.diagram.edit.commands.InitialCreateCommand;
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
	protected Command getCreateCommand(CreateElementRequest req) {
		if (ValueflowElementTypes.Initial_2001 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(ValueflowPackage.eINSTANCE
						.getAgent_States());
			}
			return getGEFWrapper(new InitialCreateCommand(req));
		}
		if (ValueflowElementTypes.GiveState_2002 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(ValueflowPackage.eINSTANCE
						.getAgent_States());
			}
			return getGEFWrapper(new GiveStateCreateCommand(req));
		}
		if (ValueflowElementTypes.TakeState_2003 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(ValueflowPackage.eINSTANCE
						.getAgent_States());
			}
			return getGEFWrapper(new TakeStateCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
