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
import org.emftext.language.java.annotations.AnnotationMethod;
import org.emftext.language.java.classifiers.Annotation;
import org.emftext.language.java.classifiers.Class;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.classifiers.Enumeration;
import org.emftext.language.java.classifiers.Interface;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.containers.Package;
import org.emftext.language.java.containers.PackageDescriptor;
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
import org.emftext.language.java.imports.ClassifierImport;
import org.emftext.language.java.imports.Import;
import org.emftext.language.java.imports.ImportsPackage;
import org.emftext.language.java.imports.StaticImport;
import org.emftext.language.java.members.Constructor;
import org.emftext.language.java.members.Field;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.members.Method;
import org.emftext.language.java.statements.Block;

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
			return getCompilationUnitCompilationUnitImportsCompartment_7011SemanticChildren(view);
		case CompilationUnitCompilationUnitClassifiersCompartmentEditPart.VISUAL_ID:
			return getCompilationUnitCompilationUnitClassifiersCompartment_7012SemanticChildren(view);
		case ClassClassMembersCompartmentEditPart.VISUAL_ID:
			return getClassClassMembersCompartment_7013SemanticChildren(view);
		case ClassClassMembersCompartment2EditPart.VISUAL_ID:
			return getClassClassMembersCompartment_7014SemanticChildren(view);
		case EnumerationEnumerationMembersCompartmentEditPart.VISUAL_ID:
			return getEnumerationEnumerationMembersCompartment_7015SemanticChildren(view);
		case InterfaceInterfaceMembersCompartmentEditPart.VISUAL_ID:
			return getInterfaceInterfaceMembersCompartment_7016SemanticChildren(view);
		case AnnotationAnnotationMembersCompartmentEditPart.VISUAL_ID:
			return getAnnotationAnnotationMembersCompartment_7017SemanticChildren(view);
		case EnumerationEnumerationMembersCompartment2EditPart.VISUAL_ID:
			return getEnumerationEnumerationMembersCompartment_7018SemanticChildren(view);
		case InterfaceInterfaceMembersCompartment2EditPart.VISUAL_ID:
			return getInterfaceInterfaceMembersCompartment_7019SemanticChildren(view);
		case AnnotationAnnotationMembersCompartment2EditPart.VISUAL_ID:
			return getAnnotationAnnotationMembersCompartment_7020SemanticChildren(view);
		case PackageEditPart.VISUAL_ID:
			return getPackage_1000SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getCompilationUnitCompilationUnitImportsCompartment_7011SemanticChildren(
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
	public static List getCompilationUnitCompilationUnitClassifiersCompartment_7012SemanticChildren(
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
	public static List getClassClassMembersCompartment_7013SemanticChildren(
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
	public static List getClassClassMembersCompartment_7014SemanticChildren(
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
	public static List getEnumerationEnumerationMembersCompartment_7015SemanticChildren(
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
	public static List getInterfaceInterfaceMembersCompartment_7016SemanticChildren(
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
	public static List getAnnotationAnnotationMembersCompartment_7017SemanticChildren(
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
	public static List getEnumerationEnumerationMembersCompartment_7018SemanticChildren(
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
	public static List getInterfaceInterfaceMembersCompartment_7019SemanticChildren(
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
	public static List getAnnotationAnnotationMembersCompartment_7020SemanticChildren(
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
			return getCompilationUnit_2002ContainedLinks(view);
		case ClassEditPart.VISUAL_ID:
			return getClass_3030ContainedLinks(view);
		case AnnotationMethodEditPart.VISUAL_ID:
			return getAnnotationMethod_3031ContainedLinks(view);
		case Class2EditPart.VISUAL_ID:
			return getClass_3032ContainedLinks(view);
		case EnumerationEditPart.VISUAL_ID:
			return getEnumeration_3033ContainedLinks(view);
		case InterfaceEditPart.VISUAL_ID:
			return getInterface_3034ContainedLinks(view);
		case FieldEditPart.VISUAL_ID:
			return getField_3035ContainedLinks(view);
		case MethodEditPart.VISUAL_ID:
			return getMethod_3036ContainedLinks(view);
		case AnnotationEditPart.VISUAL_ID:
			return getAnnotation_3037ContainedLinks(view);
		case PackageDescriptorEditPart.VISUAL_ID:
			return getPackageDescriptor_3038ContainedLinks(view);
		case ConstructorEditPart.VISUAL_ID:
			return getConstructor_3039ContainedLinks(view);
		case BlockEditPart.VISUAL_ID:
			return getBlock_3040ContainedLinks(view);
		case Enumeration2EditPart.VISUAL_ID:
			return getEnumeration_3041ContainedLinks(view);
		case Interface2EditPart.VISUAL_ID:
			return getInterface_3042ContainedLinks(view);
		case Annotation2EditPart.VISUAL_ID:
			return getAnnotation_3043ContainedLinks(view);
		case PackageDescriptor2EditPart.VISUAL_ID:
			return getPackageDescriptor_3044ContainedLinks(view);
		case ClassifierImportEditPart.VISUAL_ID:
			return getClassifierImport_3045ContainedLinks(view);
		case StaticImportEditPart.VISUAL_ID:
			return getStaticImport_3046ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (JavaVisualIDRegistry.getVisualID(view)) {
		case CompilationUnitEditPart.VISUAL_ID:
			return getCompilationUnit_2002IncomingLinks(view);
		case ClassEditPart.VISUAL_ID:
			return getClass_3030IncomingLinks(view);
		case AnnotationMethodEditPart.VISUAL_ID:
			return getAnnotationMethod_3031IncomingLinks(view);
		case Class2EditPart.VISUAL_ID:
			return getClass_3032IncomingLinks(view);
		case EnumerationEditPart.VISUAL_ID:
			return getEnumeration_3033IncomingLinks(view);
		case InterfaceEditPart.VISUAL_ID:
			return getInterface_3034IncomingLinks(view);
		case FieldEditPart.VISUAL_ID:
			return getField_3035IncomingLinks(view);
		case MethodEditPart.VISUAL_ID:
			return getMethod_3036IncomingLinks(view);
		case AnnotationEditPart.VISUAL_ID:
			return getAnnotation_3037IncomingLinks(view);
		case PackageDescriptorEditPart.VISUAL_ID:
			return getPackageDescriptor_3038IncomingLinks(view);
		case ConstructorEditPart.VISUAL_ID:
			return getConstructor_3039IncomingLinks(view);
		case BlockEditPart.VISUAL_ID:
			return getBlock_3040IncomingLinks(view);
		case Enumeration2EditPart.VISUAL_ID:
			return getEnumeration_3041IncomingLinks(view);
		case Interface2EditPart.VISUAL_ID:
			return getInterface_3042IncomingLinks(view);
		case Annotation2EditPart.VISUAL_ID:
			return getAnnotation_3043IncomingLinks(view);
		case PackageDescriptor2EditPart.VISUAL_ID:
			return getPackageDescriptor_3044IncomingLinks(view);
		case ClassifierImportEditPart.VISUAL_ID:
			return getClassifierImport_3045IncomingLinks(view);
		case StaticImportEditPart.VISUAL_ID:
			return getStaticImport_3046IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (JavaVisualIDRegistry.getVisualID(view)) {
		case CompilationUnitEditPart.VISUAL_ID:
			return getCompilationUnit_2002OutgoingLinks(view);
		case ClassEditPart.VISUAL_ID:
			return getClass_3030OutgoingLinks(view);
		case AnnotationMethodEditPart.VISUAL_ID:
			return getAnnotationMethod_3031OutgoingLinks(view);
		case Class2EditPart.VISUAL_ID:
			return getClass_3032OutgoingLinks(view);
		case EnumerationEditPart.VISUAL_ID:
			return getEnumeration_3033OutgoingLinks(view);
		case InterfaceEditPart.VISUAL_ID:
			return getInterface_3034OutgoingLinks(view);
		case FieldEditPart.VISUAL_ID:
			return getField_3035OutgoingLinks(view);
		case MethodEditPart.VISUAL_ID:
			return getMethod_3036OutgoingLinks(view);
		case AnnotationEditPart.VISUAL_ID:
			return getAnnotation_3037OutgoingLinks(view);
		case PackageDescriptorEditPart.VISUAL_ID:
			return getPackageDescriptor_3038OutgoingLinks(view);
		case ConstructorEditPart.VISUAL_ID:
			return getConstructor_3039OutgoingLinks(view);
		case BlockEditPart.VISUAL_ID:
			return getBlock_3040OutgoingLinks(view);
		case Enumeration2EditPart.VISUAL_ID:
			return getEnumeration_3041OutgoingLinks(view);
		case Interface2EditPart.VISUAL_ID:
			return getInterface_3042OutgoingLinks(view);
		case Annotation2EditPart.VISUAL_ID:
			return getAnnotation_3043OutgoingLinks(view);
		case PackageDescriptor2EditPart.VISUAL_ID:
			return getPackageDescriptor_3044OutgoingLinks(view);
		case ClassifierImportEditPart.VISUAL_ID:
			return getClassifierImport_3045OutgoingLinks(view);
		case StaticImportEditPart.VISUAL_ID:
			return getStaticImport_3046OutgoingLinks(view);
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
	public static List getCompilationUnit_2002ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getClass_3030ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAnnotationMethod_3031ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getClass_3032ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEnumeration_3033ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInterface_3034ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getField_3035ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getMethod_3036ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAnnotation_3037ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPackageDescriptor_3038ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getConstructor_3039ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getBlock_3040ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEnumeration_3041ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInterface_3042ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAnnotation_3043ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPackageDescriptor_3044ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getClassifierImport_3045ContainedLinks(View view) {
		ClassifierImport modelElement = (ClassifierImport) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_ClassifierImport_Classifiers_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getStaticImport_3046ContainedLinks(View view) {
		StaticImport modelElement = (StaticImport) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_StaticImport_StaticMembers_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getCompilationUnit_2002IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getClass_3030IncomingLinks(View view) {
		Class modelElement = (Class) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_ClassifierImport_Classifiers_4003(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_StaticImport_StaticMembers_4004(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAnnotationMethod_3031IncomingLinks(View view) {
		AnnotationMethod modelElement = (AnnotationMethod) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_StaticImport_StaticMembers_4004(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClass_3032IncomingLinks(View view) {
		Class modelElement = (Class) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_ClassifierImport_Classifiers_4003(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_StaticImport_StaticMembers_4004(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEnumeration_3033IncomingLinks(View view) {
		Enumeration modelElement = (Enumeration) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_ClassifierImport_Classifiers_4003(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_StaticImport_StaticMembers_4004(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInterface_3034IncomingLinks(View view) {
		Interface modelElement = (Interface) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_ClassifierImport_Classifiers_4003(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_StaticImport_StaticMembers_4004(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getField_3035IncomingLinks(View view) {
		Field modelElement = (Field) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_StaticImport_StaticMembers_4004(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getMethod_3036IncomingLinks(View view) {
		Method modelElement = (Method) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_StaticImport_StaticMembers_4004(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAnnotation_3037IncomingLinks(View view) {
		Annotation modelElement = (Annotation) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_ClassifierImport_Classifiers_4003(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_StaticImport_StaticMembers_4004(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackageDescriptor_3038IncomingLinks(View view) {
		PackageDescriptor modelElement = (PackageDescriptor) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_ClassifierImport_Classifiers_4003(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_StaticImport_StaticMembers_4004(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConstructor_3039IncomingLinks(View view) {
		Constructor modelElement = (Constructor) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_StaticImport_StaticMembers_4004(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getBlock_3040IncomingLinks(View view) {
		Block modelElement = (Block) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_StaticImport_StaticMembers_4004(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEnumeration_3041IncomingLinks(View view) {
		Enumeration modelElement = (Enumeration) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_ClassifierImport_Classifiers_4003(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_StaticImport_StaticMembers_4004(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInterface_3042IncomingLinks(View view) {
		Interface modelElement = (Interface) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_ClassifierImport_Classifiers_4003(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_StaticImport_StaticMembers_4004(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAnnotation_3043IncomingLinks(View view) {
		Annotation modelElement = (Annotation) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_ClassifierImport_Classifiers_4003(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_StaticImport_StaticMembers_4004(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackageDescriptor_3044IncomingLinks(View view) {
		PackageDescriptor modelElement = (PackageDescriptor) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_ClassifierImport_Classifiers_4003(
						modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_StaticImport_StaticMembers_4004(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClassifierImport_3045IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getStaticImport_3046IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getCompilationUnit_2002OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getClass_3030OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAnnotationMethod_3031OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getClass_3032OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEnumeration_3033OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInterface_3034OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getField_3035OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getMethod_3036OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAnnotation_3037OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPackageDescriptor_3038OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getConstructor_3039OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getBlock_3040OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEnumeration_3041OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInterface_3042OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAnnotation_3043OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPackageDescriptor_3044OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getClassifierImport_3045OutgoingLinks(View view) {
		ClassifierImport modelElement = (ClassifierImport) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_ClassifierImport_Classifiers_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getStaticImport_3046OutgoingLinks(View view) {
		StaticImport modelElement = (StaticImport) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_StaticImport_StaticMembers_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_ClassifierImport_Classifiers_4003(
			Classifier target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == ImportsPackage.eINSTANCE
					.getClassifierImport_Classifiers()) {
				result.add(new JavaLinkDescriptor(setting.getEObject(), target,
						JavaElementTypes.ClassifierImportClassifiers_4003,
						ClassifierImportClassifiersEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_StaticImport_StaticMembers_4004(
			Member target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == ImportsPackage.eINSTANCE
					.getStaticImport_StaticMembers()) {
				result.add(new JavaLinkDescriptor(setting.getEObject(), target,
						JavaElementTypes.StaticImportStaticMembers_4004,
						StaticImportStaticMembersEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_ClassifierImport_Classifiers_4003(
			ClassifierImport source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getClassifiers().iterator(); destinations
				.hasNext();) {
			Classifier destination = (Classifier) destinations.next();
			result.add(new JavaLinkDescriptor(source, destination,
					JavaElementTypes.ClassifierImportClassifiers_4003,
					ClassifierImportClassifiersEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_StaticImport_StaticMembers_4004(
			StaticImport source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getStaticMembers().iterator(); destinations
				.hasNext();) {
			Member destination = (Member) destinations.next();
			result.add(new JavaLinkDescriptor(source, destination,
					JavaElementTypes.StaticImportStaticMembers_4004,
					StaticImportStaticMembersEditPart.VISUAL_ID));
		}
		return result;
	}

}
