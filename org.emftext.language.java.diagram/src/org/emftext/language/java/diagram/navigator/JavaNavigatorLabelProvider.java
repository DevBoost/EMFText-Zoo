package org.emftext.language.java.diagram.navigator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.ui.services.parser.CommonParserHint;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;
import org.emftext.language.java.containers.Package;
import org.emftext.language.java.diagram.edit.parts.Annotation2EditPart;
import org.emftext.language.java.diagram.edit.parts.AnnotationEditPart;
import org.emftext.language.java.diagram.edit.parts.AnnotationMethodEditPart;
import org.emftext.language.java.diagram.edit.parts.AnnotationMethodNameEditPart;
import org.emftext.language.java.diagram.edit.parts.AnnotationName2EditPart;
import org.emftext.language.java.diagram.edit.parts.AnnotationNameEditPart;
import org.emftext.language.java.diagram.edit.parts.BlockEditPart;
import org.emftext.language.java.diagram.edit.parts.BlockNameEditPart;
import org.emftext.language.java.diagram.edit.parts.Class2EditPart;
import org.emftext.language.java.diagram.edit.parts.ClassEditPart;
import org.emftext.language.java.diagram.edit.parts.ClassName2EditPart;
import org.emftext.language.java.diagram.edit.parts.ClassNameEditPart;
import org.emftext.language.java.diagram.edit.parts.ClassifierImportClassifiersEditPart;
import org.emftext.language.java.diagram.edit.parts.ClassifierImportCommentsEditPart;
import org.emftext.language.java.diagram.edit.parts.ClassifierImportEditPart;
import org.emftext.language.java.diagram.edit.parts.CompilationUnitEditPart;
import org.emftext.language.java.diagram.edit.parts.ConstructorEditPart;
import org.emftext.language.java.diagram.edit.parts.ConstructorNameEditPart;
import org.emftext.language.java.diagram.edit.parts.Enumeration2EditPart;
import org.emftext.language.java.diagram.edit.parts.EnumerationEditPart;
import org.emftext.language.java.diagram.edit.parts.EnumerationName2EditPart;
import org.emftext.language.java.diagram.edit.parts.EnumerationNameEditPart;
import org.emftext.language.java.diagram.edit.parts.FieldEditPart;
import org.emftext.language.java.diagram.edit.parts.FieldNameEditPart;
import org.emftext.language.java.diagram.edit.parts.Interface2EditPart;
import org.emftext.language.java.diagram.edit.parts.InterfaceEditPart;
import org.emftext.language.java.diagram.edit.parts.InterfaceName2EditPart;
import org.emftext.language.java.diagram.edit.parts.InterfaceNameEditPart;
import org.emftext.language.java.diagram.edit.parts.MethodEditPart;
import org.emftext.language.java.diagram.edit.parts.MethodNameEditPart;
import org.emftext.language.java.diagram.edit.parts.PackageDescriptor2EditPart;
import org.emftext.language.java.diagram.edit.parts.PackageDescriptorEditPart;
import org.emftext.language.java.diagram.edit.parts.PackageDescriptorName2EditPart;
import org.emftext.language.java.diagram.edit.parts.PackageDescriptorNameEditPart;
import org.emftext.language.java.diagram.edit.parts.PackageEditPart;
import org.emftext.language.java.diagram.edit.parts.StaticImportCommentsEditPart;
import org.emftext.language.java.diagram.edit.parts.StaticImportEditPart;
import org.emftext.language.java.diagram.edit.parts.StaticImportStaticMembersEditPart;
import org.emftext.language.java.diagram.part.JavaDiagramEditorPlugin;
import org.emftext.language.java.diagram.part.JavaVisualIDRegistry;
import org.emftext.language.java.diagram.providers.JavaElementTypes;
import org.emftext.language.java.diagram.providers.JavaParserProvider;

/**
 * @generated
 */
public class JavaNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		JavaDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put(
						"Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		JavaDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put(
						"Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof JavaNavigatorItem
				&& !isOwnView(((JavaNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof JavaNavigatorGroup) {
			JavaNavigatorGroup group = (JavaNavigatorGroup) element;
			return JavaDiagramEditorPlugin.getInstance().getBundledImage(
					group.getIcon());
		}

		if (element instanceof JavaNavigatorItem) {
			JavaNavigatorItem navigatorItem = (JavaNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getImage(view);
			}
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (JavaVisualIDRegistry.getVisualID(view)) {
		case PackageEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://www.emftext.org/java/containers?Package", JavaElementTypes.Package_1000); //$NON-NLS-1$
		case CompilationUnitEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://www.emftext.org/java/containers?CompilationUnit", JavaElementTypes.CompilationUnit_2002); //$NON-NLS-1$
		case ClassEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.emftext.org/java/classifiers?Class", JavaElementTypes.Class_3030); //$NON-NLS-1$
		case AnnotationMethodEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.emftext.org/java/annotations?AnnotationMethod", JavaElementTypes.AnnotationMethod_3031); //$NON-NLS-1$
		case Class2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.emftext.org/java/classifiers?Class", JavaElementTypes.Class_3032); //$NON-NLS-1$
		case EnumerationEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.emftext.org/java/classifiers?Enumeration", JavaElementTypes.Enumeration_3033); //$NON-NLS-1$
		case InterfaceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.emftext.org/java/classifiers?Interface", JavaElementTypes.Interface_3034); //$NON-NLS-1$
		case FieldEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.emftext.org/java/members?Field", JavaElementTypes.Field_3035); //$NON-NLS-1$
		case MethodEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.emftext.org/java/members?Method", JavaElementTypes.Method_3036); //$NON-NLS-1$
		case AnnotationEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.emftext.org/java/classifiers?Annotation", JavaElementTypes.Annotation_3037); //$NON-NLS-1$
		case PackageDescriptorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.emftext.org/java/containers?PackageDescriptor", JavaElementTypes.PackageDescriptor_3038); //$NON-NLS-1$
		case ConstructorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.emftext.org/java/members?Constructor", JavaElementTypes.Constructor_3039); //$NON-NLS-1$
		case BlockEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.emftext.org/java/statements?Block", JavaElementTypes.Block_3040); //$NON-NLS-1$
		case Enumeration2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.emftext.org/java/classifiers?Enumeration", JavaElementTypes.Enumeration_3041); //$NON-NLS-1$
		case Interface2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.emftext.org/java/classifiers?Interface", JavaElementTypes.Interface_3042); //$NON-NLS-1$
		case Annotation2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.emftext.org/java/classifiers?Annotation", JavaElementTypes.Annotation_3043); //$NON-NLS-1$
		case PackageDescriptor2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.emftext.org/java/containers?PackageDescriptor", JavaElementTypes.PackageDescriptor_3044); //$NON-NLS-1$
		case ClassifierImportEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.emftext.org/java/imports?ClassifierImport", JavaElementTypes.ClassifierImport_3045); //$NON-NLS-1$
		case StaticImportEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.emftext.org/java/imports?StaticImport", JavaElementTypes.StaticImport_3046); //$NON-NLS-1$
		case ClassifierImportClassifiersEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.emftext.org/java/imports?ClassifierImport?classifiers", JavaElementTypes.ClassifierImportClassifiers_4003); //$NON-NLS-1$
		case StaticImportStaticMembersEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.emftext.org/java/imports?StaticImport?staticMembers", JavaElementTypes.StaticImportStaticMembers_4004); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = JavaDiagramEditorPlugin.getInstance()
				.getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& JavaElementTypes.isKnownElementType(elementType)) {
			image = JavaElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if (element instanceof JavaNavigatorGroup) {
			JavaNavigatorGroup group = (JavaNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof JavaNavigatorItem) {
			JavaNavigatorItem navigatorItem = (JavaNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getText(view);
			}
		}

		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (JavaVisualIDRegistry.getVisualID(view)) {
		case PackageEditPart.VISUAL_ID:
			return getPackage_1000Text(view);
		case CompilationUnitEditPart.VISUAL_ID:
			return getCompilationUnit_2002Text(view);
		case ClassEditPart.VISUAL_ID:
			return getClass_3030Text(view);
		case AnnotationMethodEditPart.VISUAL_ID:
			return getAnnotationMethod_3031Text(view);
		case Class2EditPart.VISUAL_ID:
			return getClass_3032Text(view);
		case EnumerationEditPart.VISUAL_ID:
			return getEnumeration_3033Text(view);
		case InterfaceEditPart.VISUAL_ID:
			return getInterface_3034Text(view);
		case FieldEditPart.VISUAL_ID:
			return getField_3035Text(view);
		case MethodEditPart.VISUAL_ID:
			return getMethod_3036Text(view);
		case AnnotationEditPart.VISUAL_ID:
			return getAnnotation_3037Text(view);
		case PackageDescriptorEditPart.VISUAL_ID:
			return getPackageDescriptor_3038Text(view);
		case ConstructorEditPart.VISUAL_ID:
			return getConstructor_3039Text(view);
		case BlockEditPart.VISUAL_ID:
			return getBlock_3040Text(view);
		case Enumeration2EditPart.VISUAL_ID:
			return getEnumeration_3041Text(view);
		case Interface2EditPart.VISUAL_ID:
			return getInterface_3042Text(view);
		case Annotation2EditPart.VISUAL_ID:
			return getAnnotation_3043Text(view);
		case PackageDescriptor2EditPart.VISUAL_ID:
			return getPackageDescriptor_3044Text(view);
		case ClassifierImportEditPart.VISUAL_ID:
			return getClassifierImport_3045Text(view);
		case StaticImportEditPart.VISUAL_ID:
			return getStaticImport_3046Text(view);
		case ClassifierImportClassifiersEditPart.VISUAL_ID:
			return getClassifierImportClassifiers_4003Text(view);
		case StaticImportStaticMembersEditPart.VISUAL_ID:
			return getStaticImportStaticMembers_4004Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getPackage_1000Text(View view) {
		Package domainModelElement = (Package) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			JavaDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getCompilationUnit_2002Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getClass_3030Text(View view) {
		IAdaptable hintAdapter = new JavaParserProvider.HintAdapter(
				JavaElementTypes.Class_3030, (view.getElement() != null ? view
						.getElement() : view), JavaVisualIDRegistry
						.getType(ClassNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			JavaDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5041); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getAnnotationMethod_3031Text(View view) {
		IAdaptable hintAdapter = new JavaParserProvider.HintAdapter(
				JavaElementTypes.AnnotationMethod_3031,
				(view.getElement() != null ? view.getElement() : view),
				JavaVisualIDRegistry
						.getType(AnnotationMethodNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			JavaDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5031); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getClass_3032Text(View view) {
		IAdaptable hintAdapter = new JavaParserProvider.HintAdapter(
				JavaElementTypes.Class_3032, (view.getElement() != null ? view
						.getElement() : view), JavaVisualIDRegistry
						.getType(ClassName2EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			JavaDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5040); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getEnumeration_3033Text(View view) {
		IAdaptable hintAdapter = new JavaParserProvider.HintAdapter(
				JavaElementTypes.Enumeration_3033,
				(view.getElement() != null ? view.getElement() : view),
				JavaVisualIDRegistry.getType(EnumerationNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			JavaDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5039); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getInterface_3034Text(View view) {
		IAdaptable hintAdapter = new JavaParserProvider.HintAdapter(
				JavaElementTypes.Interface_3034,
				(view.getElement() != null ? view.getElement() : view),
				JavaVisualIDRegistry.getType(InterfaceNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			JavaDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5038); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getField_3035Text(View view) {
		IAdaptable hintAdapter = new JavaParserProvider.HintAdapter(
				JavaElementTypes.Field_3035, (view.getElement() != null ? view
						.getElement() : view), JavaVisualIDRegistry
						.getType(FieldNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			JavaDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5032); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getMethod_3036Text(View view) {
		IAdaptable hintAdapter = new JavaParserProvider.HintAdapter(
				JavaElementTypes.Method_3036, (view.getElement() != null ? view
						.getElement() : view), JavaVisualIDRegistry
						.getType(MethodNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			JavaDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5033); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getAnnotation_3037Text(View view) {
		IAdaptable hintAdapter = new JavaParserProvider.HintAdapter(
				JavaElementTypes.Annotation_3037,
				(view.getElement() != null ? view.getElement() : view),
				JavaVisualIDRegistry.getType(AnnotationNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			JavaDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5037); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getPackageDescriptor_3038Text(View view) {
		IAdaptable hintAdapter = new JavaParserProvider.HintAdapter(
				JavaElementTypes.PackageDescriptor_3038,
				(view.getElement() != null ? view.getElement() : view),
				JavaVisualIDRegistry
						.getType(PackageDescriptorNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			JavaDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5034); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getConstructor_3039Text(View view) {
		IAdaptable hintAdapter = new JavaParserProvider.HintAdapter(
				JavaElementTypes.Constructor_3039,
				(view.getElement() != null ? view.getElement() : view),
				JavaVisualIDRegistry.getType(ConstructorNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			JavaDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5035); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getBlock_3040Text(View view) {
		IAdaptable hintAdapter = new JavaParserProvider.HintAdapter(
				JavaElementTypes.Block_3040, (view.getElement() != null ? view
						.getElement() : view), JavaVisualIDRegistry
						.getType(BlockNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			JavaDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5036); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getEnumeration_3041Text(View view) {
		IAdaptable hintAdapter = new JavaParserProvider.HintAdapter(
				JavaElementTypes.Enumeration_3041,
				(view.getElement() != null ? view.getElement() : view),
				JavaVisualIDRegistry
						.getType(EnumerationName2EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			JavaDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5042); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getInterface_3042Text(View view) {
		IAdaptable hintAdapter = new JavaParserProvider.HintAdapter(
				JavaElementTypes.Interface_3042,
				(view.getElement() != null ? view.getElement() : view),
				JavaVisualIDRegistry.getType(InterfaceName2EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			JavaDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5043); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getAnnotation_3043Text(View view) {
		IAdaptable hintAdapter = new JavaParserProvider.HintAdapter(
				JavaElementTypes.Annotation_3043,
				(view.getElement() != null ? view.getElement() : view),
				JavaVisualIDRegistry.getType(AnnotationName2EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			JavaDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5044); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getPackageDescriptor_3044Text(View view) {
		IAdaptable hintAdapter = new JavaParserProvider.HintAdapter(
				JavaElementTypes.PackageDescriptor_3044,
				(view.getElement() != null ? view.getElement() : view),
				JavaVisualIDRegistry
						.getType(PackageDescriptorName2EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			JavaDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5045); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getClassifierImport_3045Text(View view) {
		IAdaptable hintAdapter = new JavaParserProvider.HintAdapter(
				JavaElementTypes.ClassifierImport_3045,
				(view.getElement() != null ? view.getElement() : view),
				JavaVisualIDRegistry
						.getType(ClassifierImportCommentsEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			JavaDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5046); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getStaticImport_3046Text(View view) {
		IAdaptable hintAdapter = new JavaParserProvider.HintAdapter(
				JavaElementTypes.StaticImport_3046,
				(view.getElement() != null ? view.getElement() : view),
				JavaVisualIDRegistry
						.getType(StaticImportCommentsEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			JavaDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5047); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getClassifierImportClassifiers_4003Text(View view) {
		IAdaptable hintAdapter = new JavaParserProvider.HintAdapter(
				JavaElementTypes.ClassifierImportClassifiers_4003, (view
						.getElement() != null ? view.getElement() : view),
				CommonParserHint.DESCRIPTION);
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			JavaDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getStaticImportStaticMembers_4004Text(View view) {
		IAdaptable hintAdapter = new JavaParserProvider.HintAdapter(
				JavaElementTypes.StaticImportStaticMembers_4004, (view
						.getElement() != null ? view.getElement() : view),
				CommonParserHint.DESCRIPTION);
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			JavaDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return PackageEditPart.MODEL_ID.equals(JavaVisualIDRegistry
				.getModelID(view));
	}

}
