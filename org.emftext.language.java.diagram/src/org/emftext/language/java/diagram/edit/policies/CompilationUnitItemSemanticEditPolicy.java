package org.emftext.language.java.diagram.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.emftext.language.java.diagram.edit.parts.Annotation2EditPart;
import org.emftext.language.java.diagram.edit.parts.ClassEditPart;
import org.emftext.language.java.diagram.edit.parts.ClassifierImportEditPart;
import org.emftext.language.java.diagram.edit.parts.CompilationUnitCompilationUnitClassifiersCompartmentEditPart;
import org.emftext.language.java.diagram.edit.parts.CompilationUnitCompilationUnitImportsCompartmentEditPart;
import org.emftext.language.java.diagram.edit.parts.Enumeration2EditPart;
import org.emftext.language.java.diagram.edit.parts.Interface2EditPart;
import org.emftext.language.java.diagram.edit.parts.PackageDescriptor2EditPart;
import org.emftext.language.java.diagram.edit.parts.StaticImportEditPart;
import org.emftext.language.java.diagram.part.JavaVisualIDRegistry;

/**
 * @generated
 */
public class CompilationUnitItemSemanticEditPolicy extends
		JavaBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		CompoundCommand cc = getDestroyEdgesCommand();
		addDestroyChildNodesCommand(cc);
		addDestroyShortcutsCommand(cc);
		View view = (View) getHost().getModel();
		if (view.getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
			req.setElementToDestroy(view);
		}
		cc.add(getGEFWrapper(new DestroyElementCommand(req)));
		return cc.unwrap();
	}

	/**
	 * @generated
	 */
	protected void addDestroyChildNodesCommand(CompoundCommand cmd) {
		View view = (View) getHost().getModel();
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if (annotation != null) {
			return;
		}
		for (Iterator it = view.getChildren().iterator(); it.hasNext();) {
			Node node = (Node) it.next();
			switch (JavaVisualIDRegistry.getVisualID(node)) {
			case CompilationUnitCompilationUnitImportsCompartmentEditPart.VISUAL_ID:
				for (Iterator cit = node.getChildren().iterator(); cit
						.hasNext();) {
					Node cnode = (Node) cit.next();
					switch (JavaVisualIDRegistry.getVisualID(cnode)) {
					case ClassifierImportEditPart.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode));
						break;
					case StaticImportEditPart.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode));
						break;
					}
				}
				break;
			case CompilationUnitCompilationUnitClassifiersCompartmentEditPart.VISUAL_ID:
				for (Iterator cit = node.getChildren().iterator(); cit
						.hasNext();) {
					Node cnode = (Node) cit.next();
					switch (JavaVisualIDRegistry.getVisualID(cnode)) {
					case ClassEditPart.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode));
						break;
					case Enumeration2EditPart.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode));
						break;
					case Interface2EditPart.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode));
						break;
					case Annotation2EditPart.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode));
						break;
					case PackageDescriptor2EditPart.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode));
						break;
					}
				}
				break;
			}
		}
	}

}
