package org.emftext.language.java.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.emftext.language.java.containers.ContainersPackage;
import org.emftext.language.java.diagram.edit.commands.Annotation2CreateCommand;
import org.emftext.language.java.diagram.edit.commands.ClassCreateCommand;
import org.emftext.language.java.diagram.edit.commands.Enumeration2CreateCommand;
import org.emftext.language.java.diagram.edit.commands.Interface2CreateCommand;
import org.emftext.language.java.diagram.edit.commands.PackageDescriptor2CreateCommand;
import org.emftext.language.java.diagram.providers.JavaElementTypes;

/**
 * @generated
 */
public class CompilationUnitCompilationUnitClassifiersCompartmentItemSemanticEditPolicy
		extends JavaBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (JavaElementTypes.Class_3030 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(ContainersPackage.eINSTANCE
						.getCompilationUnit_Classifiers());
			}
			return getGEFWrapper(new ClassCreateCommand(req));
		}
		if (JavaElementTypes.Enumeration_3041 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(ContainersPackage.eINSTANCE
						.getCompilationUnit_Classifiers());
			}
			return getGEFWrapper(new Enumeration2CreateCommand(req));
		}
		if (JavaElementTypes.Interface_3042 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(ContainersPackage.eINSTANCE
						.getCompilationUnit_Classifiers());
			}
			return getGEFWrapper(new Interface2CreateCommand(req));
		}
		if (JavaElementTypes.Annotation_3043 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(ContainersPackage.eINSTANCE
						.getCompilationUnit_Classifiers());
			}
			return getGEFWrapper(new Annotation2CreateCommand(req));
		}
		if (JavaElementTypes.PackageDescriptor_3044 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(ContainersPackage.eINSTANCE
						.getCompilationUnit_Classifiers());
			}
			return getGEFWrapper(new PackageDescriptor2CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
