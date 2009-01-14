package org.emftext.language.java.resource.java.analysis;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.commons.NamedElement;
import org.emftext.language.java.imports.StaticClassifierImport;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.members.MemberContainer;

public class StaticClassifierImportStaticMembersReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver {

	@Override
	protected java.lang.String doDeResolve(org.eclipse.emf.ecore.EObject element, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference) {
		EList<?> classifierList = ((EList<?>)container.eGet(reference));
		
		if (classifierList.get(0).equals(element)) {
			return ((NamedElement)element.eContainer()).getName();
		}
		else {
			return ""; // already returned by first element
		}
	}

	@Override
	protected void doResolve(java.lang.String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IResolveResult result) {
		StaticClassifierImport theImport = (StaticClassifierImport) container;
		
		Classifier classifier = JavaClasspath.INSTANCE.getClassifier(theImport, identifier);
		classifier = (Classifier) EcoreUtil.resolve(classifier, container.eResource());
		if (classifier != null) {
			for(Member member : ((MemberContainer)classifier).getMembers()) {
				result.addMapping(identifier, member);
			}
		}
	}
}
