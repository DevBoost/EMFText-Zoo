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


import dk.itu.sdg.language.xwpf.Paragraph;
import dk.itu.sdg.language.xwpf.XwpfFactory;
import dk.itu.sdg.language.xwpf.XwpfPackage;

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

/**
 * This is the item provider adapter for a {@link dk.itu.sdg.language.xwpf.Paragraph} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ParagraphItemProvider
	extends ContentItemProvider
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
	public ParagraphItemProvider(AdapterFactory adapterFactory) {
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

			addAlignmentPropertyDescriptor(object);
			addBorderBottomPropertyDescriptor(object);
			addBorderTopPropertyDescriptor(object);
			addBorderBetweenPropertyDescriptor(object);
			addBorderLeftPropertyDescriptor(object);
			addBorderRightPropertyDescriptor(object);
			addVerticalAlignmentPropertyDescriptor(object);
			addFootnoteTextPropertyDescriptor(object);
			addIndentFstLinePropertyDescriptor(object);
			addIndentHangingPropertyDescriptor(object);
			addIndentLeftPropertyDescriptor(object);
			addIndentRightPropertyDescriptor(object);
			addSpacingAfterPropertyDescriptor(object);
			addSpacingAfterLinesPropertyDescriptor(object);
			addSpacingBeforePropertyDescriptor(object);
			addSpacingBeforeLinesPropertyDescriptor(object);
			addSpacingLineRulePropertyDescriptor(object);
			addStylePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Alignment feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAlignmentPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Paragraph_alignment_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Paragraph_alignment_feature", "_UI_Paragraph_type"),
				 XwpfPackage.Literals.PARAGRAPH__ALIGNMENT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Border Bottom feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBorderBottomPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Paragraph_borderBottom_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Paragraph_borderBottom_feature", "_UI_Paragraph_type"),
				 XwpfPackage.Literals.PARAGRAPH__BORDER_BOTTOM,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Border Top feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBorderTopPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Paragraph_borderTop_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Paragraph_borderTop_feature", "_UI_Paragraph_type"),
				 XwpfPackage.Literals.PARAGRAPH__BORDER_TOP,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Border Between feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBorderBetweenPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Paragraph_borderBetween_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Paragraph_borderBetween_feature", "_UI_Paragraph_type"),
				 XwpfPackage.Literals.PARAGRAPH__BORDER_BETWEEN,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Border Left feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBorderLeftPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Paragraph_borderLeft_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Paragraph_borderLeft_feature", "_UI_Paragraph_type"),
				 XwpfPackage.Literals.PARAGRAPH__BORDER_LEFT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Border Right feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBorderRightPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Paragraph_borderRight_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Paragraph_borderRight_feature", "_UI_Paragraph_type"),
				 XwpfPackage.Literals.PARAGRAPH__BORDER_RIGHT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Vertical Alignment feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVerticalAlignmentPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Paragraph_verticalAlignment_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Paragraph_verticalAlignment_feature", "_UI_Paragraph_type"),
				 XwpfPackage.Literals.PARAGRAPH__VERTICAL_ALIGNMENT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Footnote Text feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFootnoteTextPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Paragraph_footnoteText_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Paragraph_footnoteText_feature", "_UI_Paragraph_type"),
				 XwpfPackage.Literals.PARAGRAPH__FOOTNOTE_TEXT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Indent Fst Line feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIndentFstLinePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Paragraph_indentFstLine_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Paragraph_indentFstLine_feature", "_UI_Paragraph_type"),
				 XwpfPackage.Literals.PARAGRAPH__INDENT_FST_LINE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Indent Hanging feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIndentHangingPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Paragraph_indentHanging_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Paragraph_indentHanging_feature", "_UI_Paragraph_type"),
				 XwpfPackage.Literals.PARAGRAPH__INDENT_HANGING,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Indent Left feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIndentLeftPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Paragraph_indentLeft_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Paragraph_indentLeft_feature", "_UI_Paragraph_type"),
				 XwpfPackage.Literals.PARAGRAPH__INDENT_LEFT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Indent Right feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIndentRightPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Paragraph_indentRight_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Paragraph_indentRight_feature", "_UI_Paragraph_type"),
				 XwpfPackage.Literals.PARAGRAPH__INDENT_RIGHT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Spacing After feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSpacingAfterPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Paragraph_spacingAfter_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Paragraph_spacingAfter_feature", "_UI_Paragraph_type"),
				 XwpfPackage.Literals.PARAGRAPH__SPACING_AFTER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Spacing After Lines feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSpacingAfterLinesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Paragraph_spacingAfterLines_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Paragraph_spacingAfterLines_feature", "_UI_Paragraph_type"),
				 XwpfPackage.Literals.PARAGRAPH__SPACING_AFTER_LINES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Spacing Before feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSpacingBeforePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Paragraph_spacingBefore_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Paragraph_spacingBefore_feature", "_UI_Paragraph_type"),
				 XwpfPackage.Literals.PARAGRAPH__SPACING_BEFORE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Spacing Before Lines feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSpacingBeforeLinesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Paragraph_spacingBeforeLines_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Paragraph_spacingBeforeLines_feature", "_UI_Paragraph_type"),
				 XwpfPackage.Literals.PARAGRAPH__SPACING_BEFORE_LINES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Spacing Line Rule feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSpacingLineRulePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Paragraph_spacingLineRule_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Paragraph_spacingLineRule_feature", "_UI_Paragraph_type"),
				 XwpfPackage.Literals.PARAGRAPH__SPACING_LINE_RULE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Style feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStylePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Paragraph_style_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Paragraph_style_feature", "_UI_Paragraph_type"),
				 XwpfPackage.Literals.PARAGRAPH__STYLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
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
			childrenFeatures.add(XwpfPackage.Literals.PARAGRAPH__RUNS);
			childrenFeatures.add(XwpfPackage.Literals.PARAGRAPH__PART);
			childrenFeatures.add(XwpfPackage.Literals.PARAGRAPH__BODY);
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
	 * This returns Paragraph.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Paragraph"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Paragraph)object).getText();
		return label == null || label.length() == 0 ?
			getString("_UI_Paragraph_type") :
			getString("_UI_Paragraph_type") + " " + label;
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

		switch (notification.getFeatureID(Paragraph.class)) {
			case XwpfPackage.PARAGRAPH__ALIGNMENT:
			case XwpfPackage.PARAGRAPH__BORDER_BOTTOM:
			case XwpfPackage.PARAGRAPH__BORDER_TOP:
			case XwpfPackage.PARAGRAPH__BORDER_BETWEEN:
			case XwpfPackage.PARAGRAPH__BORDER_LEFT:
			case XwpfPackage.PARAGRAPH__BORDER_RIGHT:
			case XwpfPackage.PARAGRAPH__VERTICAL_ALIGNMENT:
			case XwpfPackage.PARAGRAPH__FOOTNOTE_TEXT:
			case XwpfPackage.PARAGRAPH__INDENT_FST_LINE:
			case XwpfPackage.PARAGRAPH__INDENT_HANGING:
			case XwpfPackage.PARAGRAPH__INDENT_LEFT:
			case XwpfPackage.PARAGRAPH__INDENT_RIGHT:
			case XwpfPackage.PARAGRAPH__SPACING_AFTER:
			case XwpfPackage.PARAGRAPH__SPACING_AFTER_LINES:
			case XwpfPackage.PARAGRAPH__SPACING_BEFORE:
			case XwpfPackage.PARAGRAPH__SPACING_BEFORE_LINES:
			case XwpfPackage.PARAGRAPH__SPACING_LINE_RULE:
			case XwpfPackage.PARAGRAPH__STYLE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case XwpfPackage.PARAGRAPH__RUNS:
			case XwpfPackage.PARAGRAPH__PART:
			case XwpfPackage.PARAGRAPH__BODY:
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
				(XwpfPackage.Literals.PARAGRAPH__RUNS,
				 XwpfFactory.eINSTANCE.createRun()));

		newChildDescriptors.add
			(createChildParameter
				(XwpfPackage.Literals.PARAGRAPH__PART,
				 XwpfFactory.eINSTANCE.createPart()));

		newChildDescriptors.add
			(createChildParameter
				(XwpfPackage.Literals.PARAGRAPH__BODY,
				 XwpfFactory.eINSTANCE.createBody()));
	}

}
