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

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.emftext.language.valueflow.ValueflowPackage;
import org.emftext.language.valueflow.diagram.part.ValueflowDiagramEditorPlugin;

/**
 * @generated
 */
public class ValueflowElementTypes extends ElementInitializers {

	/**
	 * @generated
	 */
	private ValueflowElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map elements;

	/**
	 * @generated
	 */
	private static ImageRegistry imageRegistry;

	/**
	 * @generated
	 */
	private static Set KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType Model_79 = getElementType("org.emftext.language.valueflow.diagram.Model_79"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Agent_1001 = getElementType("org.emftext.language.valueflow.diagram.Agent_1001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Initial_2001 = getElementType("org.emftext.language.valueflow.diagram.Initial_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType GiveState_2002 = getElementType("org.emftext.language.valueflow.diagram.GiveState_2002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType TakeState_2003 = getElementType("org.emftext.language.valueflow.diagram.TakeState_2003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType StateNextState_3001 = getElementType("org.emftext.language.valueflow.diagram.StateNextState_3001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType GiveStateGiveTo_3002 = getElementType("org.emftext.language.valueflow.diagram.GiveStateGiveTo_3002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static ImageRegistry getImageRegistry() {
		if (imageRegistry == null) {
			imageRegistry = new ImageRegistry();
		}
		return imageRegistry;
	}

	/**
	 * @generated
	 */
	private static String getImageRegistryKey(ENamedElement element) {
		return element.getName();
	}

	/**
	 * @generated
	 */
	private static ImageDescriptor getProvidedImageDescriptor(
			ENamedElement element) {
		if (element instanceof EStructuralFeature) {
			EStructuralFeature feature = ((EStructuralFeature) element);
			EClass eContainingClass = feature.getEContainingClass();
			EClassifier eType = feature.getEType();
			if (eContainingClass != null && !eContainingClass.isAbstract()) {
				element = eContainingClass;
			} else if (eType instanceof EClass
					&& !((EClass) eType).isAbstract()) {
				element = eType;
			}
		}
		if (element instanceof EClass) {
			EClass eClass = (EClass) element;
			if (!eClass.isAbstract()) {
				return ValueflowDiagramEditorPlugin.getInstance()
						.getItemImageDescriptor(
								eClass.getEPackage().getEFactoryInstance()
										.create(eClass));
			}
		}
		// TODO : support structural features
		return null;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		String key = getImageRegistryKey(element);
		ImageDescriptor imageDescriptor = getImageRegistry().getDescriptor(key);
		if (imageDescriptor == null) {
			imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
		}
		return imageDescriptor;
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		String key = getImageRegistryKey(element);
		Image image = getImageRegistry().get(key);
		if (image == null) {
			ImageDescriptor imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
			image = getImageRegistry().get(key);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImage(element);
	}

	/**
	 * Returns 'type' of the ecore object associated with the hint.
	 * 
	 * @generated
	 */
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap();

			elements.put(Model_79, ValueflowPackage.eINSTANCE.getModel());

			elements.put(Agent_1001, ValueflowPackage.eINSTANCE.getAgent());

			elements.put(Initial_2001, ValueflowPackage.eINSTANCE.getInitial());

			elements.put(GiveState_2002, ValueflowPackage.eINSTANCE
					.getGiveState());

			elements.put(TakeState_2003, ValueflowPackage.eINSTANCE
					.getTakeState());

			elements.put(StateNextState_3001, ValueflowPackage.eINSTANCE
					.getState_NextState());

			elements.put(GiveStateGiveTo_3002, ValueflowPackage.eINSTANCE
					.getGiveState_GiveTo());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet();
			KNOWN_ELEMENT_TYPES.add(Model_79);
			KNOWN_ELEMENT_TYPES.add(Agent_1001);
			KNOWN_ELEMENT_TYPES.add(Initial_2001);
			KNOWN_ELEMENT_TYPES.add(GiveState_2002);
			KNOWN_ELEMENT_TYPES.add(TakeState_2003);
			KNOWN_ELEMENT_TYPES.add(StateNextState_3001);
			KNOWN_ELEMENT_TYPES.add(GiveStateGiveTo_3002);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

}
