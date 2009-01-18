package org.emftext.language.java.resource.java.analysis;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.commons.NamedElement;
import org.emftext.language.java.imports.StaticClassifierImport;
import org.emftext.language.java.imports.StaticMemberImport;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.members.MemberContainer;
import org.emftext.language.java.modifiers.Static;

public class StaticMemberImportStaticMemberReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<StaticMemberImport> {

	@Override
	protected java.lang.String doDeResolve(org.eclipse.emf.ecore.EObject element, StaticMemberImport container, org.eclipse.emf.ecore.EReference reference) {
		return ((NamedElement)element).getName();
	}

	@Override
	protected void doResolve(java.lang.String identifier, StaticMemberImport container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IResolveResult result) {
		StaticClassifierImport theImport = (StaticClassifierImport) container;
		
		Classifier classifier = JavaClasspath.INSTANCE.getClassifier(theImport);
		classifier = (Classifier) EcoreUtil.resolve(classifier, container.eResource());
		if (classifier != null) {
			for(Member member : ((MemberContainer)classifier).getMembers()) {
				if (identifier.equals(member.getName())) {
					for (EObject modifier : member.eContents()) {
						if (modifier instanceof Static) {
							result.addMapping(identifier, member);
						}
					}
				}
			}
		}
	}
}
