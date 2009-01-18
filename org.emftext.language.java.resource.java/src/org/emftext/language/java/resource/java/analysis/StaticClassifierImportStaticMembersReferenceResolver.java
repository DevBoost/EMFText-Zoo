package org.emftext.language.java.resource.java.analysis;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.commons.NamedElement;
import org.emftext.language.java.imports.StaticClassifierImport;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.members.MemberContainer;

public class StaticClassifierImportStaticMembersReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<StaticClassifierImport> {

	@Override
	protected java.lang.String doDeResolve(org.eclipse.emf.ecore.EObject element, StaticClassifierImport container, org.eclipse.emf.ecore.EReference reference) {
		EList<?> classifierList = ((EList<?>)container.eGet(reference));
		
		if (classifierList.get(0).equals(element)) {
			return ((NamedElement)element.eContainer()).getName();
		}
		else {
			return ""; // already returned by first element
		}
	}

	@Override
	protected void doResolve(java.lang.String identifier, StaticClassifierImport theImport, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IResolveResult result) {
		
		Classifier classifier = JavaClasspath.INSTANCE.getClassifier(theImport, identifier);
		classifier = (Classifier) EcoreUtil.resolve(classifier, theImport.eResource());
		if (classifier != null) {
			for(Member member : ((MemberContainer)classifier).getMembers()) {
				result.addMapping(identifier, member);
			}
		}
	}
}
