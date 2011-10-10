/**
 * Copyright (c) 2006-2011
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
 * 
 */
package org.emftext.language.mecore.provider;


import java.util.Collection;
import java.util.List;
import java.util.MissingResourceException;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.provider.EcoreEditPlugin;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.emftext.language.mecore.MDataType;
import org.emftext.language.mecore.MFeature;
import org.emftext.language.mecore.MNamedElement;
import org.emftext.language.mecore.MecorePackage;

/**
 * This is the item provider adapter for a {@link org.emftext.language.mecore.MDataType} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated NOT
 */
public class MecoreItemProvider
	extends ItemProviderAdapter
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
	public MecoreItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(
			Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			if (object instanceof EObject) {
				EObject eObject = (EObject) object;
				EList<EStructuralFeature> eAllStructuralFeatures = eObject
						.eClass().getEAllStructuralFeatures();
				for (EStructuralFeature eStructuralFeature : eAllStructuralFeatures) {
					if (eStructuralFeature instanceof EReference) {
						EReference eReference = (EReference) eStructuralFeature;
						if (eReference.isContainment()) {
							childrenFeatures.add(eReference);
						}
					}
				}
			}
		}
		return childrenFeatures;
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addEDataTypePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the EData Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEDataTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MDataType_eDataType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MDataType_eDataType_feature", "_UI_MDataType_type"),
				 MecorePackage.Literals.MDATA_TYPE__EDATA_TYPE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns MDataType.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		if (object instanceof EObject) {
			EObject eObject = (EObject) object;
			String className = eObject.eClass().getName().substring(1);
			if (eObject instanceof MFeature) {
				MFeature mFeature = (MFeature) eObject;
				className = "Attribute";
				if (!(mFeature.getType() instanceof MDataType)) {
					className = "Reference";
				}
			}
			try {
				return overlayImage(object, getResourceLocator().getImage("full/obj16/E" + className));
			} catch (MissingResourceException e) {
				return null;
			}
		}
		return null;
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		if (object instanceof EObject) {
			EObject eObject = (EObject) object;
			String className = eObject.eClass().getName().substring(1);
			if (eObject instanceof MNamedElement) {
				MNamedElement mNamedElement = (MNamedElement) eObject;
				className += " " + mNamedElement.getName();
			}
			return className;
		}
		return getString("");
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
/*
		if (object instanceof EObject) {
			EObject eObject = (EObject) object;

			EList<EStructuralFeature> allStructuralFeatures = eObject.eClass().getEAllStructuralFeatures();
			for (EStructuralFeature eStructuralFeature : allStructuralFeatures) {
				EClassifier eType = eStructuralFeature.getEType();
				EList<EClassifier> eClassifiers = MecorePackage.eINSTANCE.getEClassifiers();
				for (EClassifier eClassifier : eClassifiers) {
					
					newChildDescriptors.add(
							createChildParameter(
									eStructuralFeature,
									eClassifier
							)
					);
				}
			}
		}
		*/
	}

	  /**
	   * Get the resource locator for this adapter's resources.
	   */
	  protected ResourceLocator getResourceLocator()
	  {
	    return EcoreEditPlugin.INSTANCE;
	  }
}
