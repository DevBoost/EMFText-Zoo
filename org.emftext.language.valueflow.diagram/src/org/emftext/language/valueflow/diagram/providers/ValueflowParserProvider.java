/*******************************************************************************
 * Copyright (c) 2006-2010 
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
package org.emftext.language.valueflow.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.emftext.language.valueflow.ValueflowPackage;
import org.emftext.language.valueflow.diagram.edit.parts.AgentNameEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.GiveStateValueEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.InitialNameEditPart;
import org.emftext.language.valueflow.diagram.edit.parts.TakeStateNameEditPart;
import org.emftext.language.valueflow.diagram.parsers.MessageFormatParser;
import org.emftext.language.valueflow.diagram.part.ValueflowVisualIDRegistry;

/**
 * @generated
 */
public class ValueflowParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser agentName_4004Parser;

	/**
	 * @generated
	 */
	private IParser getAgentName_4004Parser() {
		if (agentName_4004Parser == null) {
			agentName_4004Parser = createAgentName_4004Parser();
		}
		return agentName_4004Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAgentName_4004Parser() {
		EAttribute[] features = new EAttribute[] { ValueflowPackage.eINSTANCE
				.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser initialName_4001Parser;

	/**
	 * @generated
	 */
	private IParser getInitialName_4001Parser() {
		if (initialName_4001Parser == null) {
			initialName_4001Parser = createInitialName_4001Parser();
		}
		return initialName_4001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createInitialName_4001Parser() {
		EAttribute[] features = new EAttribute[] { ValueflowPackage.eINSTANCE
				.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser giveStateValue_4002Parser;

	/**
	 * @generated
	 */
	private IParser getGiveStateValue_4002Parser() {
		if (giveStateValue_4002Parser == null) {
			giveStateValue_4002Parser = createGiveStateValue_4002Parser();
		}
		return giveStateValue_4002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createGiveStateValue_4002Parser() {
		EAttribute[] features = new EAttribute[] { ValueflowPackage.eINSTANCE
				.getGiveState_Value(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser takeStateName_4003Parser;

	/**
	 * @generated
	 */
	private IParser getTakeStateName_4003Parser() {
		if (takeStateName_4003Parser == null) {
			takeStateName_4003Parser = createTakeStateName_4003Parser();
		}
		return takeStateName_4003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createTakeStateName_4003Parser() {
		EAttribute[] features = new EAttribute[] { ValueflowPackage.eINSTANCE
				.getNamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case AgentNameEditPart.VISUAL_ID:
			return getAgentName_4004Parser();
		case InitialNameEditPart.VISUAL_ID:
			return getInitialName_4001Parser();
		case GiveStateValueEditPart.VISUAL_ID:
			return getGiveStateValue_4002Parser();
		case TakeStateNameEditPart.VISUAL_ID:
			return getTakeStateName_4003Parser();
		}
		return null;
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(ValueflowVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(ValueflowVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (ValueflowElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static class HintAdapter extends ParserHintAdapter {

		/**
		 * @generated
		 */
		private final IElementType elementType;

		/**
		 * @generated
		 */
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		 * @generated
		 */
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
