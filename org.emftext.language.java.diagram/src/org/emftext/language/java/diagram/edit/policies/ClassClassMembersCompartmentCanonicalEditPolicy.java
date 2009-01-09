package org.emftext.language.java.diagram.edit.policies;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.emftext.language.java.core.CorePackage;
import org.emftext.language.java.diagram.edit.parts.AnnotationEditPart;
import org.emftext.language.java.diagram.edit.parts.AnnotationMethodEditPart;
import org.emftext.language.java.diagram.edit.parts.BlockEditPart;
import org.emftext.language.java.diagram.edit.parts.Class2EditPart;
import org.emftext.language.java.diagram.edit.parts.ConstructorEditPart;
import org.emftext.language.java.diagram.edit.parts.EnumerationEditPart;
import org.emftext.language.java.diagram.edit.parts.FieldEditPart;
import org.emftext.language.java.diagram.edit.parts.InterfaceEditPart;
import org.emftext.language.java.diagram.edit.parts.MethodEditPart;
import org.emftext.language.java.diagram.edit.parts.PackageDescriptorEditPart;
import org.emftext.language.java.diagram.part.JavaDiagramUpdater;
import org.emftext.language.java.diagram.part.JavaNodeDescriptor;
import org.emftext.language.java.diagram.part.JavaVisualIDRegistry;

/**
 * @generated
 */
public class ClassClassMembersCompartmentCanonicalEditPolicy extends
		CanonicalEditPolicy {

	/**
	 * @generated
	 */
	Set myFeaturesToSynchronize;

	/**
	 * @generated
	 */
	protected List getSemanticChildrenList() {
		View viewObject = (View) getHost().getModel();
		List result = new LinkedList();
		for (Iterator it = JavaDiagramUpdater
				.getClassClassMembersCompartment_7003SemanticChildren(
						viewObject).iterator(); it.hasNext();) {
			result.add(((JavaNodeDescriptor) it.next()).getModelElement());
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected boolean isOrphaned(Collection semanticChildren, final View view) {
		int visualID = JavaVisualIDRegistry.getVisualID(view);
		switch (visualID) {
		case AnnotationMethodEditPart.VISUAL_ID:
		case Class2EditPart.VISUAL_ID:
		case EnumerationEditPart.VISUAL_ID:
		case InterfaceEditPart.VISUAL_ID:
		case FieldEditPart.VISUAL_ID:
		case MethodEditPart.VISUAL_ID:
		case AnnotationEditPart.VISUAL_ID:
		case PackageDescriptorEditPart.VISUAL_ID:
		case ConstructorEditPart.VISUAL_ID:
		case BlockEditPart.VISUAL_ID:
			if (!semanticChildren.contains(view.getElement())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected String getDefaultFactoryHint() {
		return null;
	}

	/**
	 * @generated
	 */
	protected Set getFeaturesToSynchronize() {
		if (myFeaturesToSynchronize == null) {
			myFeaturesToSynchronize = new HashSet();
			myFeaturesToSynchronize.add(CorePackage.eINSTANCE
					.getMemberContainer_Members());
		}
		return myFeaturesToSynchronize;
	}

}
