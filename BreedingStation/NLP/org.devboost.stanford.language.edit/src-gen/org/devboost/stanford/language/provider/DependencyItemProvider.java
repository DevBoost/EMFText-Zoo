/**
 * Copyright (C) 2012
 * Jan Reimann (TU Dresden, Software Technology Group)
 * Mirko Seifert (DevBoost GmbH)
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.devboost.stanford.language.provider;


import java.util.Collection;
import java.util.List;

import org.devboost.stanford.language.Dependency;
import org.devboost.stanford.language.Droot;
import org.devboost.stanford.language.LanguageFactory;
import org.devboost.stanford.language.LanguagePackage;
import org.devboost.stanford.language.Word;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link org.devboost.stanford.language.Dependency} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DependencyItemProvider
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
	public DependencyItemProvider(AdapterFactory adapterFactory) {
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
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addGovernorPropertyDescriptor(object);
			addDependentPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Governor feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGovernorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Dependency_governor_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Dependency_governor_feature", "_UI_Dependency_type"),
				 LanguagePackage.Literals.DEPENDENCY__GOVERNOR,
				 false,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Dependent feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDependentPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Dependency_dependent_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Dependency_dependent_feature", "_UI_Dependency_type"),
				 LanguagePackage.Literals.DEPENDENCY__DEPENDENT,
				 false,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(LanguagePackage.Literals.DEPENDENCY__GOVERNOR);
			childrenFeatures.add(LanguagePackage.Literals.DEPENDENCY__DEPENDENT);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Dependency.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Dependency"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		Dependency dependency = (Dependency) object;
		String kind = dependency.eClass().getName().substring(1);
		Word governor = dependency.getGovernor();
		Word dependent = dependency.getDependent();
		return kind + "(" + ((dependency instanceof Droot)? "ROOT" : governor.getText()) + "," + dependent.getText() + ")";
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

		switch (notification.getFeatureID(Dependency.class)) {
			case LanguagePackage.DEPENDENCY__GOVERNOR:
			case LanguagePackage.DEPENDENCY__DEPENDENT:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
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

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__GOVERNOR,
				 LanguageFactory.eINSTANCE.createWord()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__GOVERNOR,
				 LanguageFactory.eINSTANCE.createCC()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__GOVERNOR,
				 LanguageFactory.eINSTANCE.createCD()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__GOVERNOR,
				 LanguageFactory.eINSTANCE.createDT()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__GOVERNOR,
				 LanguageFactory.eINSTANCE.createEX()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__GOVERNOR,
				 LanguageFactory.eINSTANCE.createFW()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__GOVERNOR,
				 LanguageFactory.eINSTANCE.createIN()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__GOVERNOR,
				 LanguageFactory.eINSTANCE.createJJ()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__GOVERNOR,
				 LanguageFactory.eINSTANCE.createJJR()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__GOVERNOR,
				 LanguageFactory.eINSTANCE.createJJS()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__GOVERNOR,
				 LanguageFactory.eINSTANCE.createLS()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__GOVERNOR,
				 LanguageFactory.eINSTANCE.createMD()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__GOVERNOR,
				 LanguageFactory.eINSTANCE.createNN()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__GOVERNOR,
				 LanguageFactory.eINSTANCE.createNNS()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__GOVERNOR,
				 LanguageFactory.eINSTANCE.createNNP()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__GOVERNOR,
				 LanguageFactory.eINSTANCE.createNNPS()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__GOVERNOR,
				 LanguageFactory.eINSTANCE.createPDT()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__GOVERNOR,
				 LanguageFactory.eINSTANCE.createPOS()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__GOVERNOR,
				 LanguageFactory.eINSTANCE.createPRP()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__GOVERNOR,
				 LanguageFactory.eINSTANCE.createPRPS()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__GOVERNOR,
				 LanguageFactory.eINSTANCE.createRB()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__GOVERNOR,
				 LanguageFactory.eINSTANCE.createRBR()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__GOVERNOR,
				 LanguageFactory.eINSTANCE.createRBS()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__GOVERNOR,
				 LanguageFactory.eINSTANCE.createRP()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__GOVERNOR,
				 LanguageFactory.eINSTANCE.createSYM()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__GOVERNOR,
				 LanguageFactory.eINSTANCE.createTO()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__GOVERNOR,
				 LanguageFactory.eINSTANCE.createUH()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__GOVERNOR,
				 LanguageFactory.eINSTANCE.createVB()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__GOVERNOR,
				 LanguageFactory.eINSTANCE.createVBD()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__GOVERNOR,
				 LanguageFactory.eINSTANCE.createVBG()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__GOVERNOR,
				 LanguageFactory.eINSTANCE.createVBN()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__GOVERNOR,
				 LanguageFactory.eINSTANCE.createVBP()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__GOVERNOR,
				 LanguageFactory.eINSTANCE.createVBZ()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__GOVERNOR,
				 LanguageFactory.eINSTANCE.createWDT()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__GOVERNOR,
				 LanguageFactory.eINSTANCE.createWP()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__GOVERNOR,
				 LanguageFactory.eINSTANCE.createWPS()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__GOVERNOR,
				 LanguageFactory.eINSTANCE.createWRB()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__DEPENDENT,
				 LanguageFactory.eINSTANCE.createWord()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__DEPENDENT,
				 LanguageFactory.eINSTANCE.createCC()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__DEPENDENT,
				 LanguageFactory.eINSTANCE.createCD()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__DEPENDENT,
				 LanguageFactory.eINSTANCE.createDT()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__DEPENDENT,
				 LanguageFactory.eINSTANCE.createEX()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__DEPENDENT,
				 LanguageFactory.eINSTANCE.createFW()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__DEPENDENT,
				 LanguageFactory.eINSTANCE.createIN()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__DEPENDENT,
				 LanguageFactory.eINSTANCE.createJJ()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__DEPENDENT,
				 LanguageFactory.eINSTANCE.createJJR()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__DEPENDENT,
				 LanguageFactory.eINSTANCE.createJJS()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__DEPENDENT,
				 LanguageFactory.eINSTANCE.createLS()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__DEPENDENT,
				 LanguageFactory.eINSTANCE.createMD()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__DEPENDENT,
				 LanguageFactory.eINSTANCE.createNN()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__DEPENDENT,
				 LanguageFactory.eINSTANCE.createNNS()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__DEPENDENT,
				 LanguageFactory.eINSTANCE.createNNP()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__DEPENDENT,
				 LanguageFactory.eINSTANCE.createNNPS()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__DEPENDENT,
				 LanguageFactory.eINSTANCE.createPDT()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__DEPENDENT,
				 LanguageFactory.eINSTANCE.createPOS()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__DEPENDENT,
				 LanguageFactory.eINSTANCE.createPRP()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__DEPENDENT,
				 LanguageFactory.eINSTANCE.createPRPS()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__DEPENDENT,
				 LanguageFactory.eINSTANCE.createRB()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__DEPENDENT,
				 LanguageFactory.eINSTANCE.createRBR()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__DEPENDENT,
				 LanguageFactory.eINSTANCE.createRBS()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__DEPENDENT,
				 LanguageFactory.eINSTANCE.createRP()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__DEPENDENT,
				 LanguageFactory.eINSTANCE.createSYM()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__DEPENDENT,
				 LanguageFactory.eINSTANCE.createTO()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__DEPENDENT,
				 LanguageFactory.eINSTANCE.createUH()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__DEPENDENT,
				 LanguageFactory.eINSTANCE.createVB()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__DEPENDENT,
				 LanguageFactory.eINSTANCE.createVBD()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__DEPENDENT,
				 LanguageFactory.eINSTANCE.createVBG()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__DEPENDENT,
				 LanguageFactory.eINSTANCE.createVBN()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__DEPENDENT,
				 LanguageFactory.eINSTANCE.createVBP()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__DEPENDENT,
				 LanguageFactory.eINSTANCE.createVBZ()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__DEPENDENT,
				 LanguageFactory.eINSTANCE.createWDT()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__DEPENDENT,
				 LanguageFactory.eINSTANCE.createWP()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__DEPENDENT,
				 LanguageFactory.eINSTANCE.createWPS()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.DEPENDENCY__DEPENDENT,
				 LanguageFactory.eINSTANCE.createWRB()));
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
			childFeature == LanguagePackage.Literals.DEPENDENCY__GOVERNOR ||
			childFeature == LanguagePackage.Literals.DEPENDENCY__DEPENDENT;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return LanguageEditPlugin.INSTANCE;
	}

}
