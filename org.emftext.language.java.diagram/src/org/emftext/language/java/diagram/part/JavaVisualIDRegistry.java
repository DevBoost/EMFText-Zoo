package org.emftext.language.java.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.emftext.language.java.annotations.AnnotationsPackage;
import org.emftext.language.java.core.CorePackage;
import org.emftext.language.java.core.Package;
import org.emftext.language.java.diagram.edit.parts.Annotation2EditPart;
import org.emftext.language.java.diagram.edit.parts.AnnotationAnnotationMembersCompartment2EditPart;
import org.emftext.language.java.diagram.edit.parts.AnnotationAnnotationMembersCompartmentEditPart;
import org.emftext.language.java.diagram.edit.parts.AnnotationEditPart;
import org.emftext.language.java.diagram.edit.parts.AnnotationMethodEditPart;
import org.emftext.language.java.diagram.edit.parts.AnnotationMethodNameEditPart;
import org.emftext.language.java.diagram.edit.parts.AnnotationName2EditPart;
import org.emftext.language.java.diagram.edit.parts.AnnotationNameEditPart;
import org.emftext.language.java.diagram.edit.parts.BlockEditPart;
import org.emftext.language.java.diagram.edit.parts.BlockNameEditPart;
import org.emftext.language.java.diagram.edit.parts.Class2EditPart;
import org.emftext.language.java.diagram.edit.parts.ClassClassMembersCompartment2EditPart;
import org.emftext.language.java.diagram.edit.parts.ClassClassMembersCompartmentEditPart;
import org.emftext.language.java.diagram.edit.parts.ClassEditPart;
import org.emftext.language.java.diagram.edit.parts.ClassName2EditPart;
import org.emftext.language.java.diagram.edit.parts.ClassNameEditPart;
import org.emftext.language.java.diagram.edit.parts.ClassifierImportClassifiersEditPart;
import org.emftext.language.java.diagram.edit.parts.ClassifierImportClassifiersExternalLabelEditPart;
import org.emftext.language.java.diagram.edit.parts.ClassifierImportCommentsEditPart;
import org.emftext.language.java.diagram.edit.parts.ClassifierImportEditPart;
import org.emftext.language.java.diagram.edit.parts.CompilationUnitCommentsEditPart;
import org.emftext.language.java.diagram.edit.parts.CompilationUnitCompilationUnitClassifiersCompartmentEditPart;
import org.emftext.language.java.diagram.edit.parts.CompilationUnitCompilationUnitImportsCompartmentEditPart;
import org.emftext.language.java.diagram.edit.parts.CompilationUnitEditPart;
import org.emftext.language.java.diagram.edit.parts.ConstructorEditPart;
import org.emftext.language.java.diagram.edit.parts.ConstructorNameEditPart;
import org.emftext.language.java.diagram.edit.parts.Enumeration2EditPart;
import org.emftext.language.java.diagram.edit.parts.EnumerationEditPart;
import org.emftext.language.java.diagram.edit.parts.EnumerationEnumerationMembersCompartment2EditPart;
import org.emftext.language.java.diagram.edit.parts.EnumerationEnumerationMembersCompartmentEditPart;
import org.emftext.language.java.diagram.edit.parts.EnumerationName2EditPart;
import org.emftext.language.java.diagram.edit.parts.EnumerationNameEditPart;
import org.emftext.language.java.diagram.edit.parts.FieldEditPart;
import org.emftext.language.java.diagram.edit.parts.FieldNameEditPart;
import org.emftext.language.java.diagram.edit.parts.Interface2EditPart;
import org.emftext.language.java.diagram.edit.parts.InterfaceEditPart;
import org.emftext.language.java.diagram.edit.parts.InterfaceInterfaceMembersCompartment2EditPart;
import org.emftext.language.java.diagram.edit.parts.InterfaceInterfaceMembersCompartmentEditPart;
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
import org.emftext.language.java.diagram.edit.parts.StaticImportStaticMembersExternalLabelEditPart;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class JavaVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "org.emftext.language.java.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (PackageEditPart.MODEL_ID.equals(view.getType())) {
				return PackageEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return org.emftext.language.java.diagram.part.JavaVisualIDRegistry
				.getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(DEBUG_KEY))) {
				JavaDiagramEditorPlugin.getInstance().logError(
						"Unable to parse view type as a visualID number: "
								+ type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return String.valueOf(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (CorePackage.eINSTANCE.getPackage().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((Package) domainElement)) {
			return PackageEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = org.emftext.language.java.diagram.part.JavaVisualIDRegistry
				.getModelID(containerView);
		if (!PackageEditPart.MODEL_ID.equals(containerModelID)
				&& !"java".equals(containerModelID)) { //$NON-NLS-1$
			return -1;
		}
		int containerVisualID;
		if (PackageEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.emftext.language.java.diagram.part.JavaVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = PackageEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case CompilationUnitCompilationUnitImportsCompartmentEditPart.VISUAL_ID:
			if (CorePackage.eINSTANCE.getClassifierImport().isSuperTypeOf(
					domainElement.eClass())) {
				return ClassifierImportEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getStaticImport().isSuperTypeOf(
					domainElement.eClass())) {
				return StaticImportEditPart.VISUAL_ID;
			}
			break;
		case CompilationUnitCompilationUnitClassifiersCompartmentEditPart.VISUAL_ID:
			if (CorePackage.eINSTANCE.getClass_().isSuperTypeOf(
					domainElement.eClass())) {
				return ClassEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getEnumeration().isSuperTypeOf(
					domainElement.eClass())) {
				return Enumeration2EditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getInterface().isSuperTypeOf(
					domainElement.eClass())) {
				return Interface2EditPart.VISUAL_ID;
			}
			if (AnnotationsPackage.eINSTANCE.getAnnotation().isSuperTypeOf(
					domainElement.eClass())) {
				return Annotation2EditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getPackageDescriptor().isSuperTypeOf(
					domainElement.eClass())) {
				return PackageDescriptor2EditPart.VISUAL_ID;
			}
			break;
		case ClassClassMembersCompartmentEditPart.VISUAL_ID:
			if (AnnotationsPackage.eINSTANCE.getAnnotationMethod()
					.isSuperTypeOf(domainElement.eClass())) {
				return AnnotationMethodEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getClass_().isSuperTypeOf(
					domainElement.eClass())) {
				return Class2EditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getEnumeration().isSuperTypeOf(
					domainElement.eClass())) {
				return EnumerationEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getInterface().isSuperTypeOf(
					domainElement.eClass())) {
				return InterfaceEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getField().isSuperTypeOf(
					domainElement.eClass())) {
				return FieldEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getMethod().isSuperTypeOf(
					domainElement.eClass())) {
				return MethodEditPart.VISUAL_ID;
			}
			if (AnnotationsPackage.eINSTANCE.getAnnotation().isSuperTypeOf(
					domainElement.eClass())) {
				return AnnotationEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getPackageDescriptor().isSuperTypeOf(
					domainElement.eClass())) {
				return PackageDescriptorEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getConstructor().isSuperTypeOf(
					domainElement.eClass())) {
				return ConstructorEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getBlock().isSuperTypeOf(
					domainElement.eClass())) {
				return BlockEditPart.VISUAL_ID;
			}
			break;
		case ClassClassMembersCompartment2EditPart.VISUAL_ID:
			if (AnnotationsPackage.eINSTANCE.getAnnotationMethod()
					.isSuperTypeOf(domainElement.eClass())) {
				return AnnotationMethodEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getClass_().isSuperTypeOf(
					domainElement.eClass())) {
				return Class2EditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getEnumeration().isSuperTypeOf(
					domainElement.eClass())) {
				return EnumerationEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getInterface().isSuperTypeOf(
					domainElement.eClass())) {
				return InterfaceEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getField().isSuperTypeOf(
					domainElement.eClass())) {
				return FieldEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getMethod().isSuperTypeOf(
					domainElement.eClass())) {
				return MethodEditPart.VISUAL_ID;
			}
			if (AnnotationsPackage.eINSTANCE.getAnnotation().isSuperTypeOf(
					domainElement.eClass())) {
				return AnnotationEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getPackageDescriptor().isSuperTypeOf(
					domainElement.eClass())) {
				return PackageDescriptorEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getConstructor().isSuperTypeOf(
					domainElement.eClass())) {
				return ConstructorEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getBlock().isSuperTypeOf(
					domainElement.eClass())) {
				return BlockEditPart.VISUAL_ID;
			}
			break;
		case EnumerationEnumerationMembersCompartmentEditPart.VISUAL_ID:
			if (AnnotationsPackage.eINSTANCE.getAnnotationMethod()
					.isSuperTypeOf(domainElement.eClass())) {
				return AnnotationMethodEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getClass_().isSuperTypeOf(
					domainElement.eClass())) {
				return Class2EditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getEnumeration().isSuperTypeOf(
					domainElement.eClass())) {
				return EnumerationEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getInterface().isSuperTypeOf(
					domainElement.eClass())) {
				return InterfaceEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getField().isSuperTypeOf(
					domainElement.eClass())) {
				return FieldEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getMethod().isSuperTypeOf(
					domainElement.eClass())) {
				return MethodEditPart.VISUAL_ID;
			}
			if (AnnotationsPackage.eINSTANCE.getAnnotation().isSuperTypeOf(
					domainElement.eClass())) {
				return AnnotationEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getPackageDescriptor().isSuperTypeOf(
					domainElement.eClass())) {
				return PackageDescriptorEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getConstructor().isSuperTypeOf(
					domainElement.eClass())) {
				return ConstructorEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getBlock().isSuperTypeOf(
					domainElement.eClass())) {
				return BlockEditPart.VISUAL_ID;
			}
			break;
		case InterfaceInterfaceMembersCompartmentEditPart.VISUAL_ID:
			if (AnnotationsPackage.eINSTANCE.getAnnotationMethod()
					.isSuperTypeOf(domainElement.eClass())) {
				return AnnotationMethodEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getClass_().isSuperTypeOf(
					domainElement.eClass())) {
				return Class2EditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getEnumeration().isSuperTypeOf(
					domainElement.eClass())) {
				return EnumerationEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getInterface().isSuperTypeOf(
					domainElement.eClass())) {
				return InterfaceEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getField().isSuperTypeOf(
					domainElement.eClass())) {
				return FieldEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getMethod().isSuperTypeOf(
					domainElement.eClass())) {
				return MethodEditPart.VISUAL_ID;
			}
			if (AnnotationsPackage.eINSTANCE.getAnnotation().isSuperTypeOf(
					domainElement.eClass())) {
				return AnnotationEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getPackageDescriptor().isSuperTypeOf(
					domainElement.eClass())) {
				return PackageDescriptorEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getConstructor().isSuperTypeOf(
					domainElement.eClass())) {
				return ConstructorEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getBlock().isSuperTypeOf(
					domainElement.eClass())) {
				return BlockEditPart.VISUAL_ID;
			}
			break;
		case AnnotationAnnotationMembersCompartmentEditPart.VISUAL_ID:
			if (AnnotationsPackage.eINSTANCE.getAnnotationMethod()
					.isSuperTypeOf(domainElement.eClass())) {
				return AnnotationMethodEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getClass_().isSuperTypeOf(
					domainElement.eClass())) {
				return Class2EditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getEnumeration().isSuperTypeOf(
					domainElement.eClass())) {
				return EnumerationEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getInterface().isSuperTypeOf(
					domainElement.eClass())) {
				return InterfaceEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getField().isSuperTypeOf(
					domainElement.eClass())) {
				return FieldEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getMethod().isSuperTypeOf(
					domainElement.eClass())) {
				return MethodEditPart.VISUAL_ID;
			}
			if (AnnotationsPackage.eINSTANCE.getAnnotation().isSuperTypeOf(
					domainElement.eClass())) {
				return AnnotationEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getPackageDescriptor().isSuperTypeOf(
					domainElement.eClass())) {
				return PackageDescriptorEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getConstructor().isSuperTypeOf(
					domainElement.eClass())) {
				return ConstructorEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getBlock().isSuperTypeOf(
					domainElement.eClass())) {
				return BlockEditPart.VISUAL_ID;
			}
			break;
		case EnumerationEnumerationMembersCompartment2EditPart.VISUAL_ID:
			if (AnnotationsPackage.eINSTANCE.getAnnotationMethod()
					.isSuperTypeOf(domainElement.eClass())) {
				return AnnotationMethodEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getClass_().isSuperTypeOf(
					domainElement.eClass())) {
				return Class2EditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getEnumeration().isSuperTypeOf(
					domainElement.eClass())) {
				return EnumerationEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getInterface().isSuperTypeOf(
					domainElement.eClass())) {
				return InterfaceEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getField().isSuperTypeOf(
					domainElement.eClass())) {
				return FieldEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getMethod().isSuperTypeOf(
					domainElement.eClass())) {
				return MethodEditPart.VISUAL_ID;
			}
			if (AnnotationsPackage.eINSTANCE.getAnnotation().isSuperTypeOf(
					domainElement.eClass())) {
				return AnnotationEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getPackageDescriptor().isSuperTypeOf(
					domainElement.eClass())) {
				return PackageDescriptorEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getConstructor().isSuperTypeOf(
					domainElement.eClass())) {
				return ConstructorEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getBlock().isSuperTypeOf(
					domainElement.eClass())) {
				return BlockEditPart.VISUAL_ID;
			}
			break;
		case InterfaceInterfaceMembersCompartment2EditPart.VISUAL_ID:
			if (AnnotationsPackage.eINSTANCE.getAnnotationMethod()
					.isSuperTypeOf(domainElement.eClass())) {
				return AnnotationMethodEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getClass_().isSuperTypeOf(
					domainElement.eClass())) {
				return Class2EditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getEnumeration().isSuperTypeOf(
					domainElement.eClass())) {
				return EnumerationEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getInterface().isSuperTypeOf(
					domainElement.eClass())) {
				return InterfaceEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getField().isSuperTypeOf(
					domainElement.eClass())) {
				return FieldEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getMethod().isSuperTypeOf(
					domainElement.eClass())) {
				return MethodEditPart.VISUAL_ID;
			}
			if (AnnotationsPackage.eINSTANCE.getAnnotation().isSuperTypeOf(
					domainElement.eClass())) {
				return AnnotationEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getPackageDescriptor().isSuperTypeOf(
					domainElement.eClass())) {
				return PackageDescriptorEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getConstructor().isSuperTypeOf(
					domainElement.eClass())) {
				return ConstructorEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getBlock().isSuperTypeOf(
					domainElement.eClass())) {
				return BlockEditPart.VISUAL_ID;
			}
			break;
		case AnnotationAnnotationMembersCompartment2EditPart.VISUAL_ID:
			if (AnnotationsPackage.eINSTANCE.getAnnotationMethod()
					.isSuperTypeOf(domainElement.eClass())) {
				return AnnotationMethodEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getClass_().isSuperTypeOf(
					domainElement.eClass())) {
				return Class2EditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getEnumeration().isSuperTypeOf(
					domainElement.eClass())) {
				return EnumerationEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getInterface().isSuperTypeOf(
					domainElement.eClass())) {
				return InterfaceEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getField().isSuperTypeOf(
					domainElement.eClass())) {
				return FieldEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getMethod().isSuperTypeOf(
					domainElement.eClass())) {
				return MethodEditPart.VISUAL_ID;
			}
			if (AnnotationsPackage.eINSTANCE.getAnnotation().isSuperTypeOf(
					domainElement.eClass())) {
				return AnnotationEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getPackageDescriptor().isSuperTypeOf(
					domainElement.eClass())) {
				return PackageDescriptorEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getConstructor().isSuperTypeOf(
					domainElement.eClass())) {
				return ConstructorEditPart.VISUAL_ID;
			}
			if (CorePackage.eINSTANCE.getBlock().isSuperTypeOf(
					domainElement.eClass())) {
				return BlockEditPart.VISUAL_ID;
			}
			break;
		case PackageEditPart.VISUAL_ID:
			if (CorePackage.eINSTANCE.getCompilationUnit().isSuperTypeOf(
					domainElement.eClass())) {
				return CompilationUnitEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.emftext.language.java.diagram.part.JavaVisualIDRegistry
				.getModelID(containerView);
		if (!PackageEditPart.MODEL_ID.equals(containerModelID)
				&& !"java".equals(containerModelID)) { //$NON-NLS-1$
			return false;
		}
		int containerVisualID;
		if (PackageEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.emftext.language.java.diagram.part.JavaVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = PackageEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case CompilationUnitEditPart.VISUAL_ID:
			if (CompilationUnitCommentsEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CompilationUnitCompilationUnitImportsCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CompilationUnitCompilationUnitClassifiersCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassEditPart.VISUAL_ID:
			if (ClassNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassClassMembersCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AnnotationMethodEditPart.VISUAL_ID:
			if (AnnotationMethodNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Class2EditPart.VISUAL_ID:
			if (ClassName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassClassMembersCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EnumerationEditPart.VISUAL_ID:
			if (EnumerationNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnumerationEnumerationMembersCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InterfaceEditPart.VISUAL_ID:
			if (InterfaceNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InterfaceInterfaceMembersCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FieldEditPart.VISUAL_ID:
			if (FieldNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MethodEditPart.VISUAL_ID:
			if (MethodNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AnnotationEditPart.VISUAL_ID:
			if (AnnotationNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AnnotationAnnotationMembersCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PackageDescriptorEditPart.VISUAL_ID:
			if (PackageDescriptorNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ConstructorEditPart.VISUAL_ID:
			if (ConstructorNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case BlockEditPart.VISUAL_ID:
			if (BlockNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Enumeration2EditPart.VISUAL_ID:
			if (EnumerationName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnumerationEnumerationMembersCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Interface2EditPart.VISUAL_ID:
			if (InterfaceName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InterfaceInterfaceMembersCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Annotation2EditPart.VISUAL_ID:
			if (AnnotationName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AnnotationAnnotationMembersCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PackageDescriptor2EditPart.VISUAL_ID:
			if (PackageDescriptorName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassifierImportEditPart.VISUAL_ID:
			if (ClassifierImportCommentsEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StaticImportEditPart.VISUAL_ID:
			if (StaticImportCommentsEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CompilationUnitCompilationUnitImportsCompartmentEditPart.VISUAL_ID:
			if (ClassifierImportEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StaticImportEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CompilationUnitCompilationUnitClassifiersCompartmentEditPart.VISUAL_ID:
			if (ClassEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Enumeration2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Interface2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Annotation2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PackageDescriptor2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassClassMembersCompartmentEditPart.VISUAL_ID:
			if (AnnotationMethodEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Class2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnumerationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InterfaceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FieldEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MethodEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AnnotationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PackageDescriptorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConstructorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BlockEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassClassMembersCompartment2EditPart.VISUAL_ID:
			if (AnnotationMethodEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Class2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnumerationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InterfaceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FieldEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MethodEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AnnotationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PackageDescriptorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConstructorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BlockEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EnumerationEnumerationMembersCompartmentEditPart.VISUAL_ID:
			if (AnnotationMethodEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Class2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnumerationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InterfaceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FieldEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MethodEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AnnotationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PackageDescriptorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConstructorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BlockEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InterfaceInterfaceMembersCompartmentEditPart.VISUAL_ID:
			if (AnnotationMethodEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Class2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnumerationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InterfaceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FieldEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MethodEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AnnotationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PackageDescriptorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConstructorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BlockEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AnnotationAnnotationMembersCompartmentEditPart.VISUAL_ID:
			if (AnnotationMethodEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Class2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnumerationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InterfaceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FieldEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MethodEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AnnotationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PackageDescriptorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConstructorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BlockEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EnumerationEnumerationMembersCompartment2EditPart.VISUAL_ID:
			if (AnnotationMethodEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Class2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnumerationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InterfaceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FieldEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MethodEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AnnotationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PackageDescriptorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConstructorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BlockEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InterfaceInterfaceMembersCompartment2EditPart.VISUAL_ID:
			if (AnnotationMethodEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Class2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnumerationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InterfaceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FieldEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MethodEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AnnotationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PackageDescriptorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConstructorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BlockEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AnnotationAnnotationMembersCompartment2EditPart.VISUAL_ID:
			if (AnnotationMethodEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Class2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnumerationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InterfaceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FieldEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MethodEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AnnotationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PackageDescriptorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConstructorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BlockEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PackageEditPart.VISUAL_ID:
			if (CompilationUnitEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassifierImportClassifiersEditPart.VISUAL_ID:
			if (ClassifierImportClassifiersExternalLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StaticImportStaticMembersEditPart.VISUAL_ID:
			if (StaticImportStaticMembersExternalLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(Package element) {
		return true;
	}

}
