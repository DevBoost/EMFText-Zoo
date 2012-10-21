/**
 */
package org.devboost.stanford.language.provider;


import java.util.Collection;
import java.util.List;

import org.devboost.stanford.language.LanguageFactory;
import org.devboost.stanford.language.LanguagePackage;
import org.devboost.stanford.language.Sentence;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link org.devboost.stanford.language.Sentence} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SentenceItemProvider
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
	public SentenceItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(LanguagePackage.Literals.SENTENCE__WORDS);
			childrenFeatures.add(LanguagePackage.Literals.SENTENCE__DEPENDENCIES);
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
	 * This returns Sentence.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Sentence"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_Sentence_type");
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

		switch (notification.getFeatureID(Sentence.class)) {
			case LanguagePackage.SENTENCE__WORDS:
			case LanguagePackage.SENTENCE__DEPENDENCIES:
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
				(LanguagePackage.Literals.SENTENCE__WORDS,
				 LanguageFactory.eINSTANCE.createWord()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__WORDS,
				 LanguageFactory.eINSTANCE.createCC()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__WORDS,
				 LanguageFactory.eINSTANCE.createCD()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__WORDS,
				 LanguageFactory.eINSTANCE.createDT()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__WORDS,
				 LanguageFactory.eINSTANCE.createEX()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__WORDS,
				 LanguageFactory.eINSTANCE.createFW()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__WORDS,
				 LanguageFactory.eINSTANCE.createIN()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__WORDS,
				 LanguageFactory.eINSTANCE.createJJ()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__WORDS,
				 LanguageFactory.eINSTANCE.createJJR()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__WORDS,
				 LanguageFactory.eINSTANCE.createJJS()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__WORDS,
				 LanguageFactory.eINSTANCE.createLS()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__WORDS,
				 LanguageFactory.eINSTANCE.createMD()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__WORDS,
				 LanguageFactory.eINSTANCE.createNN()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__WORDS,
				 LanguageFactory.eINSTANCE.createNNS()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__WORDS,
				 LanguageFactory.eINSTANCE.createNNP()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__WORDS,
				 LanguageFactory.eINSTANCE.createNNPS()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__WORDS,
				 LanguageFactory.eINSTANCE.createPDT()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__WORDS,
				 LanguageFactory.eINSTANCE.createPOS()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__WORDS,
				 LanguageFactory.eINSTANCE.createPRP()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__WORDS,
				 LanguageFactory.eINSTANCE.createPRPS()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__WORDS,
				 LanguageFactory.eINSTANCE.createRB()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__WORDS,
				 LanguageFactory.eINSTANCE.createRBR()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__WORDS,
				 LanguageFactory.eINSTANCE.createRBS()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__WORDS,
				 LanguageFactory.eINSTANCE.createRP()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__WORDS,
				 LanguageFactory.eINSTANCE.createSYM()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__WORDS,
				 LanguageFactory.eINSTANCE.createTO()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__WORDS,
				 LanguageFactory.eINSTANCE.createUH()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__WORDS,
				 LanguageFactory.eINSTANCE.createVB()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__WORDS,
				 LanguageFactory.eINSTANCE.createVBD()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__WORDS,
				 LanguageFactory.eINSTANCE.createVBG()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__WORDS,
				 LanguageFactory.eINSTANCE.createVBN()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__WORDS,
				 LanguageFactory.eINSTANCE.createVBP()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__WORDS,
				 LanguageFactory.eINSTANCE.createVBZ()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__WORDS,
				 LanguageFactory.eINSTANCE.createWDT()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__WORDS,
				 LanguageFactory.eINSTANCE.createWP()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__WORDS,
				 LanguageFactory.eINSTANCE.createWPS()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__WORDS,
				 LanguageFactory.eINSTANCE.createWRB()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDependency()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDabbrev()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDacomp()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDadvcl()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDadvmod()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDagent()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDamod()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDappos()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDattr()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDaux()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDauxpass()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDcc()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDccomp()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDcomplm()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createCollapse()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDconj()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDcop()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDcsubj()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDcsubjpass()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDdep()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDdet()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDdobj()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDexpl()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDinfmod()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDiobj()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDmark()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDmwe()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDneg()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDnn()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDnpadvmod()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDnsubj()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDnsubjpass()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDnum()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDnumber()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDparataxis()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDpartmod()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDpcomp()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDpobj()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDposs()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDpossessive()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDpreconj()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDpredet()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDprep()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDprepc()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDprt()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDpunct()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDpurpcl()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDquantmod()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDrcmod()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDref()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDrel()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDtmod()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDxcomp()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDxsubj()));

		newChildDescriptors.add
			(createChildParameter
				(LanguagePackage.Literals.SENTENCE__DEPENDENCIES,
				 LanguageFactory.eINSTANCE.createDroot()));
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
