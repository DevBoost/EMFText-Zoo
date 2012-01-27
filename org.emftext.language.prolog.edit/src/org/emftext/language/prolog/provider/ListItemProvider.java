/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.prolog.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.emftext.language.prolog.PrologFactory;
import org.emftext.language.prolog.PrologPackage;
import org.emftext.language.prolog.resource.pl.util.PlResourceUtil;

/**
 * This is the item provider adapter for a {@link org.emftext.language.prolog.List} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ListItemProvider
	extends TermItemProvider
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
	public ListItemProvider(AdapterFactory adapterFactory) {
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

		}
		return itemPropertyDescriptors;
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
			childrenFeatures.add(PrologPackage.Literals.LIST__HEAD_TERMS);
			childrenFeatures.add(PrologPackage.Literals.LIST__TAIL);
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
	 * This returns List.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/List"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		String text = PlResourceUtil.getText((org.emftext.language.prolog.List) object);
		if(text != null && !"".equals(text.trim())){
			return text.trim();
		}
		return getString("_UI_List_type");
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

		switch (notification.getFeatureID(org.emftext.language.prolog.List.class)) {
			case PrologPackage.LIST__HEAD_TERMS:
			case PrologPackage.LIST__TAIL:
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
				(PrologPackage.Literals.LIST__HEAD_TERMS,
				 PrologFactory.eINSTANCE.createNumeral()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.LIST__HEAD_TERMS,
				 PrologFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.LIST__HEAD_TERMS,
				 PrologFactory.eINSTANCE.createSmallAtom()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.LIST__HEAD_TERMS,
				 PrologFactory.eINSTANCE.createString()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.LIST__HEAD_TERMS,
				 PrologFactory.eINSTANCE.createList()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.LIST__HEAD_TERMS,
				 PrologFactory.eINSTANCE.createPredicate()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.LIST__HEAD_TERMS,
				 PrologFactory.eINSTANCE.createVariableReference()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.LIST__HEAD_TERMS,
				 PrologFactory.eINSTANCE.createExpression()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.LIST__HEAD_TERMS,
				 PrologFactory.eINSTANCE.createAnonymousVariable()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.LIST__TAIL,
				 PrologFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add
			(createChildParameter
				(PrologPackage.Literals.LIST__TAIL,
				 PrologFactory.eINSTANCE.createList()));
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
			childFeature == PrologPackage.Literals.LIST__HEAD_TERMS ||
			childFeature == PrologPackage.Literals.LIST__TAIL;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
