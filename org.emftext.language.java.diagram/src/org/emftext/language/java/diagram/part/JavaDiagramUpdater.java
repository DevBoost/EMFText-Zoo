package org.emftext.language.java.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.emftext.language.java.annotations.Annotation;
import org.emftext.language.java.annotations.AnnotationMethod;
import org.emftext.language.java.core.Block;
import org.emftext.language.java.core.Class;
import org.emftext.language.java.core.Classifier;
import org.emftext.language.java.core.ClassifierImport;
import org.emftext.language.java.core.CompilationUnit;
import org.emftext.language.java.core.Constructor;
import org.emftext.language.java.core.CorePackage;
import org.emftext.language.java.core.Enumeration;
import org.emftext.language.java.core.Field;
import org.emftext.language.java.core.Import;
import org.emftext.language.java.core.Interface;
import org.emftext.language.java.core.Member;
import org.emftext.language.java.core.Method;
import org.emftext.language.java.core.Package;
import org.emftext.language.java.core.PackageDescriptor;
import org.emftext.language.java.core.StaticImport;
import org.emftext.language.java.diagram.edit.parts.Annotation2EditPart;
import org.emftext.language.java.diagram.edit.parts.AnnotationAnnotationMembersCompartment2EditPart;
import org.emftext.language.java.diagram.edit.parts.AnnotationAnnotationMembersCompartmentEditPart;
import org.emftext.language.java.diagram.edit.parts.AnnotationEditPart;
import org.emftext.language.java.diagram.edit.parts.AnnotationMethodEditPart;
import org.emftext.language.java.diagram.edit.parts.BlockEditPart;
import org.emftext.language.java.diagram.edit.parts.Class2EditPart;
import org.emftext.language.java.diagram.edit.parts.ClassClassMembersCompartment2EditPart;
import org.emftext.language.java.diagram.edit.parts.ClassClassMembersCompartmentEditPart;
import org.emftext.language.java.diagram.edit.parts.ClassEditPart;
import org.emftext.language.java.diagram.edit.parts.ClassifierImportClassifiersEditPart;
import org.emftext.language.java.diagram.edit.parts.ClassifierImportEditPart;
import org.emftext.language.java.diagram.edit.parts.CompilationUnitCompilationUnitClassifiersCompartmentEditPart;
import org.emftext.language.java.diagram.edit.parts.CompilationUnitCompilationUnitImportsCompartmentEditPart;
import org.emftext.language.java.diagram.edit.parts.CompilationUnitEditPart;
import org.emftext.language.java.diagram.edit.parts.ConstructorEditPart;
import org.emftext.language.java.diagram.edit.parts.Enumeration2EditPart;
import org.emftext.language.java.diagram.edit.parts.EnumerationEditPart;
import org.emftext.language.java.diagram.edit.parts.EnumerationEnumerationMembersCompartment2EditPart;
import org.emftext.language.java.diagram.edit.parts.EnumerationEnumerationMembersCompartmentEditPart;
import org.emftext.language.java.diagram.edit.parts.FieldEditPart;
import org.emftext.language.java.diagram.edit.parts.Interface2EditPart;
import org.emftext.language.java.diagram.edit.parts.InterfaceEditPart;
import org.emftext.language.java.diagram.edit.parts.InterfaceInterfaceMembersCompartment2EditPart;
import org.emftext.language.java.diagram.edit.parts.InterfaceInterfaceMembersCompartmentEditPart;
import org.emftext.language.java.diagram.edit.parts.MethodEditPart;
import org.emftext.language.java.diagram.edit.parts.PackageDescriptor2EditPart;
import org.emftext.language.java.diagram.edit.parts.PackageDescriptorEditPart;
import org.emftext.language.java.diagram.edit.parts.PackageEditPart;
import org.emftext.language.java.diagram.edit.parts.StaticImportEditPart;
import org.emftext.language.java.diagram.edit.parts.StaticImportStaticMembersEditPart;
import org.emftext.language.java.diagram.providers.JavaElementTypes;

/**
 * @generated
 */
public class JavaDiagramUpdater {

	/**
	 * @generated
	 */
	public static boolean isShortcutOrphaned(View view) {
		return !view.isSetElement() || view.getElement() == null
				|| view.getElement().eIsProxy();
	}

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (JavaVisualIDRegistry.getVisualID(view)) {
		case CompilationUnitCompilationUnitImportsCompartmentEditPart.VISUAL_ID:
			return getCompilationUnitCompilationUnitImportsCompartment_7001SemanticChildren(view);
		case CompilationUnitCompilationUnitClassifiersCompartmentEditPart.VISUAL_ID:
			return getCompilationUnitCompilationUnitClassifiersCompartment_7002SemanticChildren(view);
		case ClassClassMembersCompartmentEditPart.VISUAL_ID:
			return getClassClassMembersCompartment_7003SemanticChildren(view);
		case ClassClassMembersCompartment2EditPart.VISUAL_ID:
			return getClassClassMembersCompartment_7004SemanticChildren(view);
		case EnumerationEnumerationMembersCompartmentEditPart.VISUAL_ID:
			return getEnumerationEnumerationMembersCompartment_7005SemanticChildren(view);
		case InterfaceInterfaceMembersCompartmentEditPart.VISUAL_ID:
			return getInterfaceInterfaceMembersCompartment_7006SemanticChildren(view);
		case AnnotationAnnotationMembersCompartmentEditPart.VISUAL_ID:
			return getAnnotationAnnotationMembersCompartment_7007SemanticChildren(view);
		case EnumerationEnumerationMembersCompartment2EditPart.VISUAL_ID:
			return getEnumerationEnumerationMembersCompartment_7008SemanticChildren(view);
		case InterfaceInterfaceMembersCompartment2EditPart.VISUAL_ID:
			return getInterfaceInterfaceMembersCompartment_7009SemanticChildren(view);
		case AnnotationAnnotationMembersCompartment2EditPart.VISUAL_ID:
			return getAnnotationAnnotationMembersCompartment_7010SemanticChildren(view);
		case PackageEditPart.VISUAL_ID:
			return getPackage_1000SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getCompilationUnitCompilationUnitImportsCompartment_7001SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		CompilationUnit modelElement = (CompilationUnit) containerView
				.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getImports().iterator(); it.hasNext();) {
			Import childElement = (Import) it.next();
			int visualID = JavaVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == ClassifierImportEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == StaticImportEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getCompilationUnitCompilationUnitClassifiersCompartment_7002SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		CompilationUnit modelElement = (CompilationUnit) containerView
				.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getClassifiers().iterator(); it
				.hasNext();) {
			Classifier childElement = (Classifier) it.next();
			int visualID = JavaVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == ClassEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Enumeration2EditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Interface2EditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Annotation2EditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PackageDescriptor2EditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClassClassMembersCompartment_7003SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Class modelElement = (Class) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getMembers().iterator(); it.hasNext();) {
			Member childElement = (Member) it.next();
			int visualID = JavaVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == AnnotationMethodEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Class2EditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnumerationEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == InterfaceEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FieldEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == MethodEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AnnotationEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PackageDescriptorEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ConstructorEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BlockEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClassClassMembersCompartment_7004SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Class modelElement = (Class) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getMembers().iterator(); it.hasNext();) {
			Member childElement = (Member) it.next();
			int visualID = JavaVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == AnnotationMethodEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Class2EditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnumerationEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == InterfaceEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FieldEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == MethodEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AnnotationEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PackageDescriptorEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ConstructorEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BlockEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEnumerationEnumerationMembersCompartment_7005SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Enumeration modelElement = (Enumeration) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getMembers().iterator(); it.hasNext();) {
			Member childElement = (Member) it.next();
			int visualID = JavaVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == AnnotationMethodEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Class2EditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnumerationEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == InterfaceEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FieldEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == MethodEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AnnotationEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PackageDescriptorEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ConstructorEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BlockEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInterfaceInterfaceMembersCompartment_7006SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Interface modelElement = (Interface) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getMembers().iterator(); it.hasNext();) {
			Member childElement = (Member) it.next();
			int visualID = JavaVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == AnnotationMethodEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Class2EditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnumerationEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == InterfaceEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FieldEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == MethodEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AnnotationEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PackageDescriptorEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ConstructorEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BlockEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAnnotationAnnotationMembersCompartment_7007SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Annotation modelElement = (Annotation) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getMembers().iterator(); it.hasNext();) {
			Member childElement = (Member) it.next();
			int visualID = JavaVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == AnnotationMethodEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Class2EditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnumerationEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == InterfaceEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FieldEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == MethodEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AnnotationEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PackageDescriptorEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ConstructorEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BlockEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEnumerationEnumerationMembersCompartment_7008SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Enumeration modelElement = (Enumeration) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getMembers().iterator(); it.hasNext();) {
			Member childElement = (Member) it.next();
			int visualID = JavaVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == AnnotationMethodEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Class2EditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnumerationEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == InterfaceEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FieldEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == MethodEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AnnotationEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PackageDescriptorEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ConstructorEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BlockEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInterfaceInterfaceMembersCompartment_7009SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Interface modelElement = (Interface) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getMembers().iterator(); it.hasNext();) {
			Member childElement = (Member) it.next();
			int visualID = JavaVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == AnnotationMethodEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Class2EditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnumerationEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == InterfaceEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FieldEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == MethodEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AnnotationEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PackageDescriptorEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ConstructorEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BlockEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAnnotationAnnotationMembersCompartment_7010SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Annotation modelElement = (Annotation) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getMembers().iterator(); it.hasNext();) {
			Member childElement = (Member) it.next();
			int visualID = JavaVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == AnnotationMethodEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Class2EditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EnumerationEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == InterfaceEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FieldEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == MethodEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AnnotationEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == PackageDescriptorEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ConstructorEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == BlockEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackage_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Package modelElement = (Package) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getCompilationUnits().iterator(); it
				.hasNext();) {
			CompilationUnit childElement = (CompilationUnit) it.next();
			int visualID = JavaVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == CompilationUnitEditPart.VISUAL_ID) {
				result.add(new JavaNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch (JavaVisualIDRegistry.getVisualID(view)) {
		case PackageEditPart.VISUAL_ID:
			return getPackage_1000ContainedLinks(view);
		case CompilationUnitEditPart.VISUAL_ID:
			return getCompilationUnit_2001ContainedLinks(view);
		case ClassEditPart.VISUAL_ID:
			return getClass_3001ContainedLinks(view);
		case AnnotationMethodEditPart.VISUAL_ID:
			return getAnnotationMethod_3018ContainedLinks(view);
		case Class2EditPart.VISUAL_ID:
			return getClass_3019ContainedLinks(view);
		case EnumerationEditPart.VISUAL_ID:
			return getEnumeration_3020ContainedLinks(view);
		case InterfaceEditPart.VISUAL_ID:
			return getInterface_3021ContainedLinks(view);
		case FieldEditPart.VISUAL_ID:
			return getField_3022ContainedLinks(view);
		case MethodEditPart.VISUAL_ID:
			return getMethod_3023ContainedLinks(view);
		case AnnotationEditPart.VISUAL_ID:
			return getAnnotation_3024ContainedLinks(view);
		case PackageDescriptorEditPart.VISUAL_ID:
			return getPackageDescriptor_3025ContainedLinks(view);
		case ConstructorEditPart.VISUAL_ID:
			return getConstructor_3026ContainedLinks(view);
		case BlockEditPart.VISUAL_ID:
			return getBlock_3027ContainedLinks(view);
		case Enumeration2EditPart.VISUAL_ID:
			return getEnumeration_3012ContainedLinks(view);
		case Interface2EditPart.VISUAL_ID:
			return getInterface_3013ContainedLinks(view);
		case Annotation2EditPart.VISUAL_ID:
			return getAnnotation_3014ContainedLinks(view);
		case PackageDescriptor2EditPart.VISUAL_ID:
			return getPackageDescriptor_3015ContainedLinks(view);
		case ClassifierImportEditPart.VISUAL_ID:
			return getClassifierImport_3016ContainedLinks(view);
		case StaticImportEditPart.VISUAL_ID:
			return getStaticImport_3017ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (JavaVisualIDRegistry.getVisualID(view)) {
		case CompilationUnitEditPart.VISUAL_ID:
			return getCompilationUnit_2001IncomingLinks(view);
		case ClassEditPart.VISUAL_ID:
			return getClass_3001IncomingLinks(view);
		case AnnotationMethodEditPart.VISUAL_ID:
			return getAnnotationMethod_3018IncomingLinks(view);
		case Class2EditPart.VISUAL_ID:
			return getClass_3019IncomingLinks(view);
		case EnumerationEditPart.VISUAL_ID:
			return getEnumeration_3020IncomingLinks(view);
		case InterfaceEditPart.VISUAL_ID:
			return getInterface_3021IncomingLinks(view);
		case FieldEditPart.VISUAL_ID:
			return getField_3022IncomingLinks(view);
		case MethodEditPart.VISUAL_ID:
			return getMethod_3023IncomingLinks(view);
		case AnnotationEditPart.VISUAL_ID:
			return getAnnotation_3024IncomingLinks(view);
		case PackageDescriptorEditPart.VISUAL_ID:
			return getPackageDescriptor_3025IncomingLinks(view);
		case ConstructorEditPart.VISUAL_ID:
			return getConstructor_3026IncomingLinks(view);
		case BlockEditPart.VISUAL_ID:
			return getBlock_3027IncomingLinks(view);
		case Enumeration2EditPart.VISUAL_ID:
			return getEnumeration_3012IncomingLinks(view);
		case Interface2EditPart.VISUAL_ID:
			return getInterface_3013IncomingLinks(view);
		case Annotation2EditPart.VISUAL_ID:
			return getAnnotation_3014IncomingLinks(view);
		case PackageDescriptor2EditPart.VISUAL_ID:
			return getPackageDescriptor_3015IncomingLinks(view);
		case ClassifierImportEditPart.VISUAL_ID:
			return getClassifierImport_3016IncomingLinks(view);
		case StaticImportEditPart.VISUAL_ID:
			return getStaticImport_3017IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (JavaVisualIDRegistry.getVisualID(view)) {
		case CompilationUnitEditPart.VISUAL_ID:
			return getCompilationUnit_2001OutgoingLinks(view);
		case ClassEditPart.VISUAL_ID:
			return getClass_3001OutgoingLinks(view);
		case AnnotationMethodEditPart.VISUAL_ID:
			return getAnnotationMethod_3018OutgoingLinks(view);
		case Class2EditPart.VISUAL_ID:
			return getClass_3019OutgoingLinks(view);
		case EnumerationEditPart.VISUAL_ID:
			return getEnumeration_3020OutgoingLinks(view);
		case InterfaceEditPart.VISUAL_ID:
			return getInterface_3021OutgoingLinks(view);
		case FieldEditPart.VISUAL_ID:
			return getField_3022OutgoingLinks(view);
		case MethodEditPart.VISUAL_ID:
			return getMethod_3023OutgoingLinks(view);
		case AnnotationEditPart.VISUAL_ID:
			return getAnnotation_3024OutgoingLinks(view);
		case PackageDescriptorEditPart.VISUAL_ID:
			return getPackageDescriptor_3025OutgoingLinks(view);
		case ConstructorEditPart.VISUAL_ID:
			return getConstructor_3026OutgoingLinks(view);
		case BlockEditPart.VISUAL_ID:
			return getBlock_3027OutgoingLinks(view);
		case Enumeration2EditPart.VISUAL_ID:
			return getEnumeration_3012OutgoingLinks(view);
		case Interface2EditPart.VISUAL_ID:
			return getInterface_3013OutgoingLinks(view);
		case Annotation2EditPart.VISUAL_ID:
			return getAnnotation_3014OutgoingLinks(view);
		case PackageDescriptor2EditPart.VISUAL_ID:
			return getPackageDescriptor_3015OutgoingLinks(view);
		case ClassifierImportEditPart.VISUAL_ID:
			return getClassifierImport_3016OutgoingLinks(view);
		case StaticImportEditPart.VISUAL_ID:
			return getStaticImport_3017OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPackage_1000ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getCompilationUnit_2001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getClass_3001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAnnotationMethod_3018ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getClass_3019ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEnumeration_3020ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInterface_3021ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getField_3022ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getMethod_3023ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAnnotation_3024ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPackageDescriptor_3025ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getConstructor_3026ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getBlock_3027ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEnumeration_3012ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInterface_3013ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAnnotation_3014ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPackageDescriptor_3015ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getClassifierImport_3016ContainedLinks(View view) {
		ClassifierImport modelElement = (ClassifierImport) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_ClassifierImport_Classifiers_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getStaticImport_3017ContainedLinks(View view) {
		StaticImport modelElement = (StaticImport) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_StaticImport_StaticMembers_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getCompilationUnit_2001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getClass_3001IncomingLinks(View view) {
		Class modelElement = (Class) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_ClassifierImport_Classifiers_4001(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_StaticImport_StaticMembers_4002(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAnnotationMethod_3018IncomingLinks(View view) {
		AnnotationMethod modelElement = (AnnotationMethod) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_StaticImport_StaticMembers_4002(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClass_3019IncomingLinks(View view) {
		Class modelElement = (Class) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_ClassifierImport_Classifiers_4001(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_StaticImport_StaticMembers_4002(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEnumeration_3020IncomingLinks(View view) {
		Enumeration modelElement = (Enumeration) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_ClassifierImport_Classifiers_4001(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_StaticImport_StaticMembers_4002(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInterface_3021IncomingLinks(View view) {
		Interface modelElement = (Interface) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_ClassifierImport_Classifiers_4001(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_StaticImport_StaticMembers_4002(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getField_3022IncomingLinks(View view) {
		Field modelElement = (Field) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_StaticImport_StaticMembers_4002(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getMethod_3023IncomingLinks(View view) {
		Method modelElement = (Method) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_StaticImport_StaticMembers_4002(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAnnotation_3024IncomingLinks(View view) {
		Annotation modelElement = (Annotation) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_ClassifierImport_Classifiers_4001(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_StaticImport_StaticMembers_4002(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackageDescriptor_3025IncomingLinks(View view) {
		PackageDescriptor modelElement = (PackageDescriptor) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_ClassifierImport_Classifiers_4001(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_StaticImport_StaticMembers_4002(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConstructor_3026IncomingLinks(View view) {
		Constructor modelElement = (Constructor) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_StaticImport_StaticMembers_4002(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getBlock_3027IncomingLinks(View view) {
		Block modelElement = (Block) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_StaticImport_StaticMembers_4002(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEnumeration_3012IncomingLinks(View view) {
		Enumeration modelElement = (Enumeration) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_ClassifierImport_Classifiers_4001(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_StaticImport_StaticMembers_4002(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInterface_3013IncomingLinks(View view) {
		Interface modelElement = (Interface) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_ClassifierImport_Classifiers_4001(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_StaticImport_StaticMembers_4002(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAnnotation_3014IncomingLinks(View view) {
		Annotation modelElement = (Annotation) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_ClassifierImport_Classifiers_4001(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_StaticImport_StaticMembers_4002(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackageDescriptor_3015IncomingLinks(View view) {
		PackageDescriptor modelElement = (PackageDescriptor) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_ClassifierImport_Classifiers_4001(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_StaticImport_StaticMembers_4002(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClassifierImport_3016IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getStaticImport_3017IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getCompilationUnit_2001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getClass_3001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAnnotationMethod_3018OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getClass_3019OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEnumeration_3020OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInterface_3021OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getField_3022OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getMethod_3023OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAnnotation_3024OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPackageDescriptor_3025OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getConstructor_3026OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getBlock_3027OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEnumeration_3012OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInterface_3013OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAnnotation_3014OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPackageDescriptor_3015OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getClassifierImport_3016OutgoingLinks(View view) {
		ClassifierImport modelElement = (ClassifierImport) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_ClassifierImport_Classifiers_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getStaticImport_3017OutgoingLinks(View view) {
		StaticImport modelElement = (StaticImport) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_StaticImport_StaticMembers_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_ClassifierImport_Classifiers_4001(
			Classifier target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == CorePackage.eINSTANCE
					.getClassifierImport_Classifiers()) {
				result.add(new JavaLinkDescriptor(setting.getEObject(), target,
						JavaElementTypes.ClassifierImportClassifiers_4001,
						ClassifierImportClassifiersEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_StaticImport_StaticMembers_4002(
			Member target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == CorePackage.eINSTANCE
					.getStaticImport_StaticMembers()) {
				result.add(new JavaLinkDescriptor(setting.getEObject(), target,
						JavaElementTypes.StaticImportStaticMembers_4002,
						StaticImportStaticMembersEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_ClassifierImport_Classifiers_4001(
			ClassifierImport source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getClassifiers().iterator(); destinations
				.hasNext();) {
			Classifier destination = (Classifier) destinations.next();
			result.add(new JavaLinkDescriptor(source, destination,
					JavaElementTypes.ClassifierImportClassifiers_4001,
					ClassifierImportClassifiersEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_StaticImport_StaticMembers_4002(
			StaticImport source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getStaticMembers().iterator(); destinations
				.hasNext();) {
			Member destination = (Member) destinations.next();
			result.add(new JavaLinkDescriptor(source, destination,
					JavaElementTypes.StaticImportStaticMembers_4002,
					StaticImportStaticMembersEditPart.VISUAL_ID));
		}
		return result;
	}

}
