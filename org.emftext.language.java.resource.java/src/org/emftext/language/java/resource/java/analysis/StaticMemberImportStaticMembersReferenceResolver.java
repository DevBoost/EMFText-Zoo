package org.emftext.language.java.resource.java.analysis;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.classifiers.Enumeration;
import org.emftext.language.java.imports.StaticMemberImport;
import org.emftext.language.java.members.EnumConstant;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.references.ReferenceableElement;
import org.emftext.language.java.util.classifiers.ClassifierUtil;
import org.emftext.language.java.util.imports.ImportUtil;
import org.emftext.runtime.resource.IReferenceResolveResult;
import org.emftext.runtime.resource.impl.AbstractReferenceResolver;

public class StaticMemberImportStaticMembersReferenceResolver extends 
	AbstractReferenceResolver<StaticMemberImport, ReferenceableElement> {
	
	@Override	
	protected java.lang.String doDeResolve(ReferenceableElement element, StaticMemberImport container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, StaticMemberImport theImport, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, IReferenceResolveResult<ReferenceableElement> result) {
		ConcreteClassifier classifier = ImportUtil.getClassifier(theImport);
		classifier = (ConcreteClassifier) EcoreUtil.resolve(classifier, theImport.eResource());
		if (classifier != null && !classifier.eIsProxy()) {
			for(Member member : ClassifierUtil.getAllMembers(classifier)) {
				if (identifier.equals(member.getName()) && member instanceof ReferenceableElement) {
					//for (EObject modifier : member.eContents()) {
						//if (modifier instanceof Static) { TODO @jjohannes reactivate this check when the class file loader supports modifiers
							result.addMapping(identifier, (ReferenceableElement) member);
						//}
					//}
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
}
