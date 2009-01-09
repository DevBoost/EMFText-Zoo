package org.emftext.language.java.diagram.edit.policies;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.emftext.language.java.containers.ContainersPackage;
import org.emftext.language.java.diagram.edit.parts.ClassifierImportEditPart;
import org.emftext.language.java.diagram.edit.parts.StaticImportEditPart;
import org.emftext.language.java.diagram.part.JavaDiagramUpdater;
import org.emftext.language.java.diagram.part.JavaNodeDescriptor;
import org.emftext.language.java.diagram.part.JavaVisualIDRegistry;

/**
 * @generated
 */
public class CompilationUnitCompilationUnitImportsCompartmentCanonicalEditPolicy
		extends CanonicalEditPolicy {

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
				.getCompilationUnitCompilationUnitImportsCompartment_7011SemanticChildren(
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
		case ClassifierImportEditPart.VISUAL_ID:
		case StaticImportEditPart.VISUAL_ID:
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
			myFeaturesToSynchronize.add(ContainersPackage.eINSTANCE
					.getCompilationUnit_Imports());
		}
		return myFeaturesToSynchronize;
	}

}
