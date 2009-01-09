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
import org.emftext.language.java.core.Package;
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
import org.emftext.language.java.diagram.edit.parts.CompilationUnitCommentsEditPart;
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
					"Navigator?Diagram?http://www.emftext.org/java/core?Package", JavaElementTypes.Package_1000); //$NON-NLS-1$
		case CompilationUnitEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://www.emftext.org/java/core?CompilationUnit", JavaElementTypes.CompilationUnit_2001); //$NON-NLS-1$
		case ClassEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.emftext.org/java/core?Class", JavaElementTypes.Class_3001); //$NON-NLS-1$
		case AnnotationMethodEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.emftext.org/java/annotations?AnnotationMethod", JavaElementTypes.AnnotationMethod_3018); //$NON-NLS-1$
		case Class2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.emftext.org/java/core?Class", JavaElementTypes.Class_3019); //$NON-NLS-1$
		case EnumerationEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.emftext.org/java/core?Enumeration", JavaElementTypes.Enumeration_3020); //$NON-NLS-1$
		case InterfaceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.emftext.org/java/core?Interface", JavaElementTypes.Interface_3021); //$NON-NLS-1$
		case FieldEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.emftext.org/java/core?Field", JavaElementTypes.Field_3022); //$NON-NLS-1$
		case MethodEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.emftext.org/java/core?Method", JavaElementTypes.Method_3023); //$NON-NLS-1$
		case AnnotationEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.emftext.org/java/annotations?Annotation", JavaElementTypes.Annotation_3024); //$NON-NLS-1$
		case PackageDescriptorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.emftext.org/java/core?PackageDescriptor", JavaElementTypes.PackageDescriptor_3025); //$NON-NLS-1$
		case ConstructorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.emftext.org/java/core?Constructor", JavaElementTypes.Constructor_3026); //$NON-NLS-1$
		case BlockEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.emftext.org/java/core?Block", JavaElementTypes.Block_3027); //$NON-NLS-1$
		case Enumeration2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.emftext.org/java/core?Enumeration", JavaElementTypes.Enumeration_3012); //$NON-NLS-1$
		case Interface2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.emftext.org/java/core?Interface", JavaElementTypes.Interface_3013); //$NON-NLS-1$
		case Annotation2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.emftext.org/java/annotations?Annotation", JavaElementTypes.Annotation_3014); //$NON-NLS-1$
		case PackageDescriptor2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.emftext.org/java/core?PackageDescriptor", JavaElementTypes.PackageDescriptor_3015); //$NON-NLS-1$
		case ClassifierImportEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.emftext.org/java/core?ClassifierImport", JavaElementTypes.ClassifierImport_3016); //$NON-NLS-1$
		case StaticImportEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.emftext.org/java/core?StaticImport", JavaElementTypes.StaticImport_3017); //$NON-NLS-1$
		case ClassifierImportClassifiersEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.emftext.org/java/core?ClassifierImport?classifiers", JavaElementTypes.ClassifierImportClassifiers_4001); //$NON-NLS-1$
		case StaticImportStaticMembersEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.emftext.org/java/core?StaticImport?staticMembers", JavaElementTypes.StaticImportStaticMembers_4002); //$NON-NLS-1$
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
			return getCompilationUnit_2001Text(view);
		case ClassEditPart.VISUAL_ID:
			return getClass_3001Text(view);
		case AnnotationMethodEditPart.VISUAL_ID:
			return getAnnotationMethod_3018Text(view);
		case Class2EditPart.VISUAL_ID:
			return getClass_3019Text(view);
		case EnumerationEditPart.VISUAL_ID:
			return getEnumeration_3020Text(view);
		case InterfaceEditPart.VISUAL_ID:
			return getInterface_3021Text(view);
		case FieldEditPart.VISUAL_ID:
			return getField_3022Text(view);
		case MethodEditPart.VISUAL_ID:
			return getMethod_3023Text(view);
		case AnnotationEditPart.VISUAL_ID:
			return getAnnotation_3024Text(view);
		case PackageDescriptorEditPart.VISUAL_ID:
			return getPackageDescriptor_3025Text(view);
		case ConstructorEditPart.VISUAL_ID:
			return getConstructor_3026Text(view);
		case BlockEditPart.VISUAL_ID:
			return getBlock_3027Text(view);
		case Enumeration2EditPart.VISUAL_ID:
			return getEnumeration_3012Text(view);
		case Interface2EditPart.VISUAL_ID:
			return getInterface_3013Text(view);
		case Annotation2EditPart.VISUAL_ID:
			return getAnnotation_3014Text(view);
		case PackageDescriptor2EditPart.VISUAL_ID:
			return getPackageDescriptor_3015Text(view);
		case ClassifierImportEditPart.VISUAL_ID:
			return getClassifierImport_3016Text(view);
		case StaticImportEditPart.VISUAL_ID:
			return getStaticImport_3017Text(view);
		case ClassifierImportClassifiersEditPart.VISUAL_ID:
			return getClassifierImportClassifiers_4001Text(view);
		case StaticImportStaticMembersEditPart.VISUAL_ID:
			return getStaticImportStaticMembers_4002Text(view);
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
	private String getCompilationUnit_2001Text(View view) {
		IAdaptable hintAdapter = new JavaParserProvider.HintAdapter(
				JavaElementTypes.CompilationUnit_2001,
				(view.getElement() != null ? view.getElement() : view),
				JavaVisualIDRegistry
						.getType(CompilationUnitCommentsEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			JavaDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5018); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getClass_3001Text(View view) {
		IAdaptable hintAdapter = new JavaParserProvider.HintAdapter(
				JavaElementTypes.Class_3001, (view.getElement() != null ? view
						.getElement() : view), JavaVisualIDRegistry
						.getType(ClassNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			JavaDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5011); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getAnnotationMethod_3018Text(View view) {
		IAdaptable hintAdapter = new JavaParserProvider.HintAdapter(
				JavaElementTypes.AnnotationMethod_3018,
				(view.getElement() != null ? view.getElement() : view),
				JavaVisualIDRegistry
						.getType(AnnotationMethodNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			JavaDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5019); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getClass_3019Text(View view) {
		IAdaptable hintAdapter = new JavaParserProvider.HintAdapter(
				JavaElementTypes.Class_3019, (view.getElement() != null ? view
						.getElement() : view), JavaVisualIDRegistry
						.getType(ClassName2EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			JavaDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5028); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getEnumeration_3020Text(View view) {
		IAdaptable hintAdapter = new JavaParserProvider.HintAdapter(
				JavaElementTypes.Enumeration_3020,
				(view.getElement() != null ? view.getElement() : view),
				JavaVisualIDRegistry.getType(EnumerationNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			JavaDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5027); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getInterface_3021Text(View view) {
		IAdaptable hintAdapter = new JavaParserProvider.HintAdapter(
				JavaElementTypes.Interface_3021,
				(view.getElement() != null ? view.getElement() : view),
				JavaVisualIDRegistry.getType(InterfaceNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			JavaDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5026); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getField_3022Text(View view) {
		IAdaptable hintAdapter = new JavaParserProvider.HintAdapter(
				JavaElementTypes.Field_3022, (view.getElement() != null ? view
						.getElement() : view), JavaVisualIDRegistry
						.getType(FieldNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			JavaDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5020); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getMethod_3023Text(View view) {
		IAdaptable hintAdapter = new JavaParserProvider.HintAdapter(
				JavaElementTypes.Method_3023, (view.getElement() != null ? view
						.getElement() : view), JavaVisualIDRegistry
						.getType(MethodNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			JavaDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5021); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getAnnotation_3024Text(View view) {
		IAdaptable hintAdapter = new JavaParserProvider.HintAdapter(
				JavaElementTypes.Annotation_3024,
				(view.getElement() != null ? view.getElement() : view),
				JavaVisualIDRegistry.getType(AnnotationNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			JavaDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5025); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getPackageDescriptor_3025Text(View view) {
		IAdaptable hintAdapter = new JavaParserProvider.HintAdapter(
				JavaElementTypes.PackageDescriptor_3025,
				(view.getElement() != null ? view.getElement() : view),
				JavaVisualIDRegistry
						.getType(PackageDescriptorNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			JavaDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5022); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getConstructor_3026Text(View view) {
		IAdaptable hintAdapter = new JavaParserProvider.HintAdapter(
				JavaElementTypes.Constructor_3026,
				(view.getElement() != null ? view.getElement() : view),
				JavaVisualIDRegistry.getType(ConstructorNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			JavaDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5023); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getBlock_3027Text(View view) {
		IAdaptable hintAdapter = new JavaParserProvider.HintAdapter(
				JavaElementTypes.Block_3027, (view.getElement() != null ? view
						.getElement() : view), JavaVisualIDRegistry
						.getType(BlockNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			JavaDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5024); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getEnumeration_3012Text(View view) {
		IAdaptable hintAdapter = new JavaParserProvider.HintAdapter(
				JavaElementTypes.Enumeration_3012,
				(view.getElement() != null ? view.getElement() : view),
				JavaVisualIDRegistry
						.getType(EnumerationName2EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			JavaDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5012); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getInterface_3013Text(View view) {
		IAdaptable hintAdapter = new JavaParserProvider.HintAdapter(
				JavaElementTypes.Interface_3013,
				(view.getElement() != null ? view.getElement() : view),
				JavaVisualIDRegistry.getType(InterfaceName2EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			JavaDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5013); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getAnnotation_3014Text(View view) {
		IAdaptable hintAdapter = new JavaParserProvider.HintAdapter(
				JavaElementTypes.Annotation_3014,
				(view.getElement() != null ? view.getElement() : view),
				JavaVisualIDRegistry.getType(AnnotationName2EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			JavaDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5014); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getPackageDescriptor_3015Text(View view) {
		IAdaptable hintAdapter = new JavaParserProvider.HintAdapter(
				JavaElementTypes.PackageDescriptor_3015,
				(view.getElement() != null ? view.getElement() : view),
				JavaVisualIDRegistry
						.getType(PackageDescriptorName2EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			JavaDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5015); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getClassifierImport_3016Text(View view) {
		IAdaptable hintAdapter = new JavaParserProvider.HintAdapter(
				JavaElementTypes.ClassifierImport_3016,
				(view.getElement() != null ? view.getElement() : view),
				JavaVisualIDRegistry
						.getType(ClassifierImportCommentsEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			JavaDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5016); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getStaticImport_3017Text(View view) {
		IAdaptable hintAdapter = new JavaParserProvider.HintAdapter(
				JavaElementTypes.StaticImport_3017,
				(view.getElement() != null ? view.getElement() : view),
				JavaVisualIDRegistry
						.getType(StaticImportCommentsEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			JavaDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5017); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getClassifierImportClassifiers_4001Text(View view) {
		IAdaptable hintAdapter = new JavaParserProvider.HintAdapter(
				JavaElementTypes.ClassifierImportClassifiers_4001, (view
						.getElement() != null ? view.getElement() : view),
				CommonParserHint.DESCRIPTION);
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			JavaDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getStaticImportStaticMembers_4002Text(View view) {
		IAdaptable hintAdapter = new JavaParserProvider.HintAdapter(
				JavaElementTypes.StaticImportStaticMembers_4002, (view
						.getElement() != null ? view.getElement() : view),
				CommonParserHint.DESCRIPTION);
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			JavaDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6002); //$NON-NLS-1$
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
