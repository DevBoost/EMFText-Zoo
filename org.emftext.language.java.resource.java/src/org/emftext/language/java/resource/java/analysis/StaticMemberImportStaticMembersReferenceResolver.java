package org.emftext.language.java.resource.java.analysis;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.classifiers.Enumeration;
import org.emftext.language.java.imports.StaticMemberImport;
import org.emftext.language.java.members.EnumConstant;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.modifiers.AnnotableAndModifiable;
import org.emftext.language.java.references.ReferenceableElement;
import org.emftext.language.java.util.JavaUtil;
import org.emftext.language.java.util.classifiers.ClassifierUtil;
import org.emftext.language.java.util.imports.ImportUtil;
import org.emftext.language.java.util.modifiers.ModifiableUtil;
import org.emftext.runtime.resource.IReferenceResolveResult;
import org.emftext.runtime.resource.impl.AbstractReferenceResolver;

public class StaticMemberImportStaticMembersReferenceResolver extends 
	AbstractReferenceResolver<StaticMemberImport, ReferenceableElement> {
	
	@Override	
	protected java.lang.String doDeResolve(ReferenceableElement element, StaticMemberImport container, org.eclipse.emf.ecore.EReference reference) {
		return JavaUtil.getName(element);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, StaticMemberImport theImport, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, IReferenceResolveResult<ReferenceableElement> result) {
		ConcreteClassifier classifier = ImportUtil.getClassifier(theImport);
		classifier = (ConcreteClassifier) EcoreUtil.resolve(classifier, theImport.eResource());
		if (classifier != null && !classifier.eIsProxy()) {
			for(Member member : ClassifierUtil.getAllMembers(classifier, theImport)) {
				if (identifier.equals(JavaUtil.getName(member)) && member instanceof ReferenceableElement) {
					if (member instanceof AnnotableAndModifiable) {
						if(ModifiableUtil.isStatic((AnnotableAndModifiable)member)) {
							result.addMapping(identifier, (ReferenceableElement) member);
						}
					}
				}
			}
			
			if (classifier instanceof Enumeration) {
				for(EnumConstant enumConstant : ((Enumeration)classifier).getConstants()) {
					if (identifier.equals(JavaUtil.getName(enumConstant))) {
						result.addMapping(identifier, enumConstant);
						return;
					}
				}
			}
		}	
	}
}
