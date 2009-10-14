package org.emftext.language.java.resource.java.analysis;

import java.util.Map;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.classifiers.Enumeration;
import org.emftext.language.java.imports.StaticMemberImport;
import org.emftext.language.java.imports.rtypes.StaticMemberImportStaticMembers;
import org.emftext.language.java.members.EnumConstant;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.modifiers.AnnotableAndModifiable;
import org.emftext.language.java.references.ReferenceableElement;
import org.emftext.language.java.resource.java.IJavaReferenceResolveResult;

public class StaticMemberImportStaticMembersValueReferenceResolver implements org.emftext.language.java.resource.java.IJavaReferenceResolver<org.emftext.language.java.imports.rtypes.StaticMemberImportStaticMembers, org.emftext.language.java.references.ReferenceableElement> {
	
	public java.lang.String deResolve(ReferenceableElement element, StaticMemberImportStaticMembers container, org.eclipse.emf.ecore.EReference reference) {
		return element.getName();
	}
	
	public void resolve(java.lang.String identifier, StaticMemberImportStaticMembers container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, IJavaReferenceResolveResult<ReferenceableElement> result) {
		if (!(container.eContainer() instanceof StaticMemberImport)) {
			return;
		}
		StaticMemberImport theImport = (StaticMemberImport)container.eContainer();
		ConcreteClassifier classifier = theImport.getClassifierAtNamespaces();
		classifier = (ConcreteClassifier) EcoreUtil.resolve(classifier, theImport.eResource());
		if (classifier != null && !classifier.eIsProxy()) {
			for(Member member : classifier.getAllMembers(theImport)) {
				if (identifier.equals(member.getName()) && member instanceof ReferenceableElement) {
					if (member instanceof AnnotableAndModifiable) {
						if (member.eIsProxy()) {
							member = (Member) EcoreUtil.resolve(member, theImport);
						}
						if(((AnnotableAndModifiable)member).isStatic()) {
							result.addMapping(identifier, (ReferenceableElement) member);
						}
					}
				}
			}
			
			if (classifier instanceof Enumeration) {
				for(EnumConstant enumConstant : ((Enumeration)classifier).getConstants()) {
					if (identifier.equals(enumConstant.getName())) {
						result.addMapping(identifier, enumConstant);
						return;
					}
				}
			}
		}	
	}

	public void setOptions(Map<?, ?> options) {
	}

}
