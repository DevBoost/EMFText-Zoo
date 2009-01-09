package org.emftext.language.java.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.emftext.language.java.core.CorePackage;
import org.emftext.language.java.diagram.edit.commands.ClassifierImportCreateCommand;
import org.emftext.language.java.diagram.edit.commands.StaticImportCreateCommand;
import org.emftext.language.java.diagram.providers.JavaElementTypes;

/**
 * @generated
 */
public class CompilationUnitCompilationUnitImportsCompartmentItemSemanticEditPolicy
		extends JavaBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (JavaElementTypes.ClassifierImport_3016 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(CorePackage.eINSTANCE
						.getCompilationUnit_Imports());
			}
			return getGEFWrapper(new ClassifierImportCreateCommand(req));
		}
		if (JavaElementTypes.StaticImport_3017 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(CorePackage.eINSTANCE
						.getCompilationUnit_Imports());
			}
			return getGEFWrapper(new StaticImportCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
