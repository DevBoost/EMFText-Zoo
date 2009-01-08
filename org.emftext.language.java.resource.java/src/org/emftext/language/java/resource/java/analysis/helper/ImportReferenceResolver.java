package org.emftext.language.java.resource.java.analysis.helper;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.core.Classifier;
import org.emftext.language.java.core.ClassifierImport;
import org.emftext.language.java.core.Import;
import org.emftext.language.java.core.Member;
import org.emftext.language.java.core.MemberContainer;
import org.emftext.language.java.core.NamedElement;
import org.emftext.language.java.core.StaticImport;
import org.emftext.language.java.modifiers.Static;
import org.emftext.runtime.resource.IResolveResult;
import org.emftext.runtime.resource.impl.ReferenceResolverImpl;

public class ImportReferenceResolver extends ReferenceResolverImpl {

	@Override
	protected String doDeResolve(EObject element, EObject container,
			EReference reference) {
		EList<?> classifierList = ((EList<?>)container.eGet(reference));
		
		if (classifierList.get(0).equals(element)) {
			if (classifierList.size() == 1) {
				return ((NamedElement)element).getName();
			}
			else {
				return "*";
			}
		}
		else {
			return ""; // "*" already returned by first element
		}
	}

	@Override
	protected void doResolve(String identifier, EObject container,
			EReference reference, int position, boolean resolveFuzzy, IResolveResult result) {
		
		Import theImport = (Import) container;
		if (identifier.equals(".*")) {
			identifier = "*";
		}
		
		if (theImport instanceof ClassifierImport) {
			EList<Classifier> importedClassifiers =  
				JavaClasspath.INSTANCE.getClassifiers(theImport, identifier);
	
			for (Classifier classifier : importedClassifiers) {
				result.addMapping(identifier, classifier);
			}
		}
		else if (theImport instanceof StaticImport) {
			Classifier classifier = JavaClasspath.INSTANCE.getClassifier(theImport);
			classifier = (Classifier) EcoreUtil.resolve(classifier, container.eResource());
			if (classifier != null) {
				for(Member member : ((MemberContainer)classifier).getMembers()) {
					if (identifier.equals("*") || identifier.equals(member.getName())) {
						for (EObject modifier : member.eContents()) {
							if (modifier instanceof Static) {
								result.addMapping(identifier, member);
							}
						}
					}
				}
			}
		}
		else {
			assert(false);
		}
	}
	

}
