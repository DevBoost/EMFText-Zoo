/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.java.closures.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.emftext.language.java.annotations.AnnotationsFactory;

import org.emftext.language.java.arrays.ArraysFactory;
import org.emftext.language.java.arrays.ArraysPackage;

import org.emftext.language.java.closures.Closure;
import org.emftext.language.java.closures.ClosuresFactory;
import org.emftext.language.java.closures.ClosuresPackage;

import org.emftext.language.java.expressions.ExpressionsFactory;

import org.emftext.language.java.instantiations.InstantiationsFactory;

import org.emftext.language.java.literals.LiteralsFactory;

import org.emftext.language.java.parameters.ParametersPackage;

import org.emftext.language.java.references.ReferencesFactory;
import org.emftext.language.java.references.ReferencesPackage;

import org.emftext.language.java.statements.StatementsPackage;

import org.emftext.language.java.types.TypesPackage;

/**
 * This is the item provider adapter for a {@link org.emftext.language.java.closures.Closure} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ClosureItemProvider
	extends AbstractClosureItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ClosureItemProvider(AdapterFactory adapterFactory) {
    super(adapterFactory);
  }

	/**
   * This returns the property descriptors for the adapted class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
    if (itemPropertyDescriptors == null)
    {
      super.getPropertyDescriptors(object);

    }
    return itemPropertyDescriptors;
  }

	/**
   * This returns Closure.gif.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public Object getImage(Object object) {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/Closure"));
  }

	/**
   * This returns the label text for the adapted class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public String getText(Object object) {
    String label = ((Closure)object).getName();
    return label == null || label.length() == 0 ?
      getString("_UI_Closure_type") :
      getString("_UI_Closure_type") + " " + label;
  }

	/**
   * This handles model notifications by calling {@link #updateChildren} to update any cached
   * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public void notifyChanged(Notification notification) {
    updateChildren(notification);
    super.notifyChanged(notification);
  }

	/**
   * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
   * that can be created under this object.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
    super.collectNewChildDescriptors(newChildDescriptors, object);
  }

	/**
   * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
    Object childFeature = feature;
    Object childObject = child;

    boolean qualify =
      childFeature == TypesPackage.Literals.TYPED_ELEMENT__TYPE_REFERENCE ||
      childFeature == ClosuresPackage.Literals.ABSTRACT_CLOSURE__PARAMETER_TYPES ||
      childFeature == ClosuresPackage.Literals.ABSTRACT_CLOSURE__VALUE_TYPE ||
      childFeature == ArraysPackage.Literals.ARRAY_TYPEABLE__ARRAY_DIMENSIONS_BEFORE ||
      childFeature == ArraysPackage.Literals.ARRAY_TYPEABLE__ARRAY_DIMENSIONS_AFTER ||
      childFeature == ClosuresPackage.Literals.ABSTRACT_CLOSURE__VALUE_TYPE_ARRAY_DIMENSION ||
      childFeature == ParametersPackage.Literals.PARAMETRIZABLE__PARAMETERS ||
      childFeature == ReferencesPackage.Literals.REFERENCE__NEXT;

    if (qualify)
    {
      return getString
        ("_UI_CreateChild_text2",
         new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
    }
    return super.getCreateChildText(owner, feature, child, selection);
  }

}
