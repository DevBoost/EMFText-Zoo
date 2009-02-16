package org.emftext.language.java.resource.java.analysis;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.commons.NamedElement;
import org.emftext.language.java.imports.StaticMemberImport;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.members.MemberContainer;

public class StaticMemberImportStaticMembersReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.language.java.imports.StaticMemberImport> {

	@Override
	protected java.lang.String doDeResolve(org.eclipse.emf.ecore.EObject element, StaticMemberImport container, org.eclipse.emf.ecore.EReference reference) {
		return ((NamedElement)element).getName();
	}

	@Override
	protected void doResolve(java.lang.String identifier, StaticMemberImport theImport, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult result) {
		Classifier classifier = JavaClasspath.INSTANCE.getClassifier(theImport);
		classifier = (Classifier) EcoreUtil.resolve(classifier, theImport.eResource());
		if (classifier != null && !classifier.eIsProxy()) {
			for(Member member : ((MemberContainer)classifier).getMembers()) {
				if (identifier.equals(member.getName())) {
					//for (EObject modifier : member.eContents()) {
						//if (modifier instanceof Static) { TODO reactivate this check when the class file loader supports modifiers
							result.addMapping(identifier, member);
						//}
					//}
				}
			}
		}
	}
}
