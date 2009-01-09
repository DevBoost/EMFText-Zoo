package org.emftext.language.java.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
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
import org.emftext.language.java.members.MembersPackage;

/**
 * @generated
 */
public class AnnotationAnnotationMembersCompartmentItemSemanticEditPolicy
		extends JavaBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (JavaElementTypes.AnnotationMethod_3031 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(MembersPackage.eINSTANCE
						.getMemberContainer_Members());
			}
			return getGEFWrapper(new AnnotationMethodCreateCommand(req));
		}
		if (JavaElementTypes.Class_3032 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(MembersPackage.eINSTANCE
						.getMemberContainer_Members());
			}
			return getGEFWrapper(new Class2CreateCommand(req));
		}
		if (JavaElementTypes.Enumeration_3033 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(MembersPackage.eINSTANCE
						.getMemberContainer_Members());
			}
			return getGEFWrapper(new EnumerationCreateCommand(req));
		}
		if (JavaElementTypes.Interface_3034 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(MembersPackage.eINSTANCE
						.getMemberContainer_Members());
			}
			return getGEFWrapper(new InterfaceCreateCommand(req));
		}
		if (JavaElementTypes.Field_3035 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(MembersPackage.eINSTANCE
						.getMemberContainer_Members());
			}
			return getGEFWrapper(new FieldCreateCommand(req));
		}
		if (JavaElementTypes.Method_3036 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(MembersPackage.eINSTANCE
						.getMemberContainer_Members());
			}
			return getGEFWrapper(new MethodCreateCommand(req));
		}
		if (JavaElementTypes.Annotation_3037 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(MembersPackage.eINSTANCE
						.getMemberContainer_Members());
			}
			return getGEFWrapper(new AnnotationCreateCommand(req));
		}
		if (JavaElementTypes.PackageDescriptor_3038 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(MembersPackage.eINSTANCE
						.getMemberContainer_Members());
			}
			return getGEFWrapper(new PackageDescriptorCreateCommand(req));
		}
		if (JavaElementTypes.Constructor_3039 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(MembersPackage.eINSTANCE
						.getMemberContainer_Members());
			}
			return getGEFWrapper(new ConstructorCreateCommand(req));
		}
		if (JavaElementTypes.Block_3040 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(MembersPackage.eINSTANCE
						.getMemberContainer_Members());
			}
			return getGEFWrapper(new BlockCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
