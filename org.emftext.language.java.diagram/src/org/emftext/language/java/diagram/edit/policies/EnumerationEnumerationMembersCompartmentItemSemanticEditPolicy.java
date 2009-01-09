package org.emftext.language.java.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.emftext.language.java.core.CorePackage;
import org.emftext.language.java.diagram.edit.commands.AnnotationCreateCommand;
import org.emftext.language.java.diagram.edit.commands.AnnotationMethodCreateCommand;
import org.emftext.language.java.diagram.edit.commands.BlockCreateCommand;
import org.emftext.language.java.diagram.edit.commands.Class2CreateCommand;
import org.emftext.language.java.diagram.edit.commands.ConstructorCreateCommand;
import org.emftext.language.java.diagram.edit.commands.EnumerationCreateCommand;
import org.emftext.language.java.diagram.edit.commands.FieldCreateCommand;
import org.emftext.language.java.diagram.edit.commands.InterfaceCreateCommand;
import org.emftext.language.java.diagram.edit.commands.MethodCreateCommand;
import org.emftext.language.java.diagram.edit.commands.PackageDescriptorCreateCommand;
import org.emftext.language.java.diagram.providers.JavaElementTypes;

/**
 * @generated
 */
public class EnumerationEnumerationMembersCompartmentItemSemanticEditPolicy
		extends JavaBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (JavaElementTypes.AnnotationMethod_3018 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(CorePackage.eINSTANCE
						.getMemberContainer_Members());
			}
			return getGEFWrapper(new AnnotationMethodCreateCommand(req));
		}
		if (JavaElementTypes.Class_3019 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(CorePackage.eINSTANCE
						.getMemberContainer_Members());
			}
			return getGEFWrapper(new Class2CreateCommand(req));
		}
		if (JavaElementTypes.Enumeration_3020 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(CorePackage.eINSTANCE
						.getMemberContainer_Members());
			}
			return getGEFWrapper(new EnumerationCreateCommand(req));
		}
		if (JavaElementTypes.Interface_3021 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(CorePackage.eINSTANCE
						.getMemberContainer_Members());
			}
			return getGEFWrapper(new InterfaceCreateCommand(req));
		}
		if (JavaElementTypes.Field_3022 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(CorePackage.eINSTANCE
						.getMemberContainer_Members());
			}
			return getGEFWrapper(new FieldCreateCommand(req));
		}
		if (JavaElementTypes.Method_3023 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(CorePackage.eINSTANCE
						.getMemberContainer_Members());
			}
			return getGEFWrapper(new MethodCreateCommand(req));
		}
		if (JavaElementTypes.Annotation_3024 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(CorePackage.eINSTANCE
						.getMemberContainer_Members());
			}
			return getGEFWrapper(new AnnotationCreateCommand(req));
		}
		if (JavaElementTypes.PackageDescriptor_3025 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(CorePackage.eINSTANCE
						.getMemberContainer_Members());
			}
			return getGEFWrapper(new PackageDescriptorCreateCommand(req));
		}
		if (JavaElementTypes.Constructor_3026 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(CorePackage.eINSTANCE
						.getMemberContainer_Members());
			}
			return getGEFWrapper(new ConstructorCreateCommand(req));
		}
		if (JavaElementTypes.Block_3027 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(CorePackage.eINSTANCE
						.getMemberContainer_Members());
			}
			return getGEFWrapper(new BlockCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
