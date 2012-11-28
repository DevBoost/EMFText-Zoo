/**
 * Copyright 2012 
 * Rolf-Helge Pfeiffer (IT University Copenhagen)
 * Jan Reimann (TU Dresden, Software Technology Group)
 * Mirko Seifert (DevBoost GmbH)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dk.itu.sdg.language.xwpf.provider;


import dk.itu.sdg.language.xwpf.Document;
import dk.itu.sdg.language.xwpf.Style;
import dk.itu.sdg.language.xwpf.XwpfFactory;
import dk.itu.sdg.language.xwpf.XwpfPackage;

import java.util.Collection;
import java.util.List;

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
 * This is the item provider adapter for a {@link dk.itu.sdg.language.xwpf.Document} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DocumentItemProvider
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2012 \r\nRolf-Helge Pfeiffer (IT University Copenhagen)\r\nJan Reimann (TU Dresden, Software Technology Group)\r\nMirko Seifert (DevBoost GmbH)\r\n\r\nLicensed under the Apache License, Version 2.0 (the \"License\");\r\nyou may not use this file except in compliance with the License.\r\nYou may obtain a copy of the License at\r\n\r\n  http://www.apache.org/licenses/LICENSE-2.0\r\n\r\nUnless required by applicable law or agreed to in writing, software\r\ndistributed under the License is distributed on an \"AS IS\" BASIS,\r\nWITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\r\nSee the License for the specific language governing permissions and\r\nlimitations under the License.";

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocumentItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(XwpfPackage.Literals.DOCUMENT__BODY_ELEMENTS);
			childrenFeatures.add(XwpfPackage.Literals.DOCUMENT__COMMENTS);
			childrenFeatures.add(XwpfPackage.Literals.DOCUMENT__ENDNOTES);
			childrenFeatures.add(XwpfPackage.Literals.DOCUMENT__FOOTERS);
			childrenFeatures.add(XwpfPackage.Literals.DOCUMENT__FOOTNOTES);
			childrenFeatures.add(XwpfPackage.Literals.DOCUMENT__HEADERS);
			childrenFeatures.add(XwpfPackage.Literals.DOCUMENT__HYPERLINKS);
			childrenFeatures.add(XwpfPackage.Literals.DOCUMENT__NUMBERING);
			childrenFeatures.add(XwpfPackage.Literals.DOCUMENT__PACKAGE_PICTURES);
			childrenFeatures.add(XwpfPackage.Literals.DOCUMENT__PARAGRAPHS);
			childrenFeatures.add(XwpfPackage.Literals.DOCUMENT__PICTURES);
			childrenFeatures.add(XwpfPackage.Literals.DOCUMENT__STYLES);
			childrenFeatures.add(XwpfPackage.Literals.DOCUMENT__TABLES);
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
	 * This returns Document.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Document"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_Document_type");
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

		switch (notification.getFeatureID(Document.class)) {
			case XwpfPackage.DOCUMENT__BODY_ELEMENTS:
			case XwpfPackage.DOCUMENT__COMMENTS:
			case XwpfPackage.DOCUMENT__ENDNOTES:
			case XwpfPackage.DOCUMENT__FOOTERS:
			case XwpfPackage.DOCUMENT__FOOTNOTES:
			case XwpfPackage.DOCUMENT__HEADERS:
			case XwpfPackage.DOCUMENT__HYPERLINKS:
			case XwpfPackage.DOCUMENT__NUMBERING:
			case XwpfPackage.DOCUMENT__PACKAGE_PICTURES:
			case XwpfPackage.DOCUMENT__PARAGRAPHS:
			case XwpfPackage.DOCUMENT__PICTURES:
			case XwpfPackage.DOCUMENT__STYLES:
			case XwpfPackage.DOCUMENT__TABLES:
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
				(XwpfPackage.Literals.DOCUMENT__BODY_ELEMENTS,
				 XwpfFactory.eINSTANCE.createBodyElement()));

		newChildDescriptors.add
			(createChildParameter
				(XwpfPackage.Literals.DOCUMENT__COMMENTS,
				 XwpfFactory.eINSTANCE.createComment()));

		newChildDescriptors.add
			(createChildParameter
				(XwpfPackage.Literals.DOCUMENT__ENDNOTES,
				 XwpfFactory.eINSTANCE.createFootnote()));

		newChildDescriptors.add
			(createChildParameter
				(XwpfPackage.Literals.DOCUMENT__FOOTERS,
				 XwpfFactory.eINSTANCE.createFooter()));

		newChildDescriptors.add
			(createChildParameter
				(XwpfPackage.Literals.DOCUMENT__FOOTNOTES,
				 XwpfFactory.eINSTANCE.createFootnote()));

		newChildDescriptors.add
			(createChildParameter
				(XwpfPackage.Literals.DOCUMENT__HEADERS,
				 XwpfFactory.eINSTANCE.createHeader()));

		newChildDescriptors.add
			(createChildParameter
				(XwpfPackage.Literals.DOCUMENT__HYPERLINKS,
				 XwpfFactory.eINSTANCE.createHyperlink()));

		newChildDescriptors.add
			(createChildParameter
				(XwpfPackage.Literals.DOCUMENT__NUMBERING,
				 XwpfFactory.eINSTANCE.createNumbering()));

		newChildDescriptors.add
			(createChildParameter
				(XwpfPackage.Literals.DOCUMENT__PACKAGE_PICTURES,
				 XwpfFactory.eINSTANCE.createPictureData()));

		newChildDescriptors.add
			(createChildParameter
				(XwpfPackage.Literals.DOCUMENT__PARAGRAPHS,
				 XwpfFactory.eINSTANCE.createParagraph()));

		newChildDescriptors.add
			(createChildParameter
				(XwpfPackage.Literals.DOCUMENT__PICTURES,
				 XwpfFactory.eINSTANCE.createPictureData()));

		newChildDescriptors.add
			(createChildParameter
				(XwpfPackage.Literals.DOCUMENT__STYLES,
				 Style.UNRECOGNIZED));

		newChildDescriptors.add
			(createChildParameter
				(XwpfPackage.Literals.DOCUMENT__TABLES,
				 XwpfFactory.eINSTANCE.createTable()));
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
			childFeature == XwpfPackage.Literals.DOCUMENT__ENDNOTES ||
			childFeature == XwpfPackage.Literals.DOCUMENT__FOOTNOTES ||
			childFeature == XwpfPackage.Literals.DOCUMENT__PACKAGE_PICTURES ||
			childFeature == XwpfPackage.Literals.DOCUMENT__PICTURES;

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
		return xwpfEditPlugin.INSTANCE;
	}

}
