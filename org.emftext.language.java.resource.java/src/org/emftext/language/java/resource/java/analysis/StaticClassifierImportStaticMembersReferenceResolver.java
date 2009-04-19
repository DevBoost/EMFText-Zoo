package org.emftext.language.java.resource.java.analysis;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.classifiers.Enumeration;
import org.emftext.language.java.commons.NamedElement;
import org.emftext.language.java.imports.StaticClassifierImport;
import org.emftext.language.java.members.EnumConstant;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.members.MemberContainer;
import org.emftext.language.java.references.ReferenceableElement;
import org.emftext.language.java.util.imports.ImportUtil;
import org.emftext.runtime.resource.IReferenceResolveResult;
import org.emftext.runtime.resource.impl.AbstractReferenceResolver;

public class StaticClassifierImportStaticMembersReferenceResolver extends 
	AbstractReferenceResolver<StaticClassifierImport, ReferenceableElement> {
	
	@Override	
	protected java.lang.String doDeResolve(ReferenceableElement element, StaticClassifierImport container, org.eclipse.emf.ecore.EReference reference) {
		EList<?> classifierList = ((EList<?>)container.eGet(reference));
		
		if (classifierList.get(0).equals(element)) {
			return ((NamedElement)element.eContainer()).getName();
		}
		else {
			return ""; // already returned by first element
		}
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, StaticClassifierImport theImport, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, IReferenceResolveResult<ReferenceableElement> result) {
		Classifier classifier = ImportUtil.getClassifier(theImport, identifier);
		classifier = (Classifier) EcoreUtil.resolve(classifier, theImport.eResource());
		if (classifier != null && !classifier.eIsProxy()) {
			for(Member member : ((MemberContainer)classifier).getMembers()) {
				if (member instanceof ReferenceableElement) { 
					result.addMapping(identifier, (ReferenceableElement) member);
				}
			}
		}
		if (classifier instanceof Enumeration) {
			for(EnumConstant enumConstant : ((Enumeration)classifier).getConstants()) {
				result.addMapping(identifier, enumConstant);
			}
		}
	}
}
