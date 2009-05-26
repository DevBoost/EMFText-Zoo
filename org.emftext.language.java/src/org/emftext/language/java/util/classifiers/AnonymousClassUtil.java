package org.emftext.language.java.util.classifiers;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.emftext.language.java.classifiers.AnonymousClass;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.instantiations.NewConstructorCall;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.modifiers.AnnotableAndModifiable;
import org.emftext.language.java.modifiers.Modifiable;
import org.emftext.language.java.util.JavaClasspathUtil;
import org.emftext.language.java.util.modifiers.ModifiableUtil;
import org.emftext.language.java.util.types.TypeReferenceUtil;

public class AnonymousClassUtil {
	
	/**
	 * @param _this
	 * @return a view on all members including super classifiers' members
	 */
	public static EList<Member> getAllMembers(AnonymousClass _this) {
		EList<Member> memberList = new BasicEList<Member>();
		memberList.addAll(_this.getMembers());
		memberList.addAll(_this.getDefaultMembers());
		
		NewConstructorCall ncCall = (NewConstructorCall) _this.eContainer();
		if (ncCall == null) {
			return memberList;
		}
		else {
			ConcreteClassifier classifier = (ConcreteClassifier) TypeReferenceUtil.getTarget(ncCall.getType());
			if (classifier != null) {
				EList<Member> superMemberList = ClassifierUtil.getAllMembers(classifier);
				for(Member superMember : superMemberList) {
					//exclude private members
					if(superMember instanceof Modifiable) {					
						Modifiable modifiable = (Modifiable) superMember;
						if(!ModifiableUtil.isPrivate(modifiable)) {
							memberList.add(superMember);
						}
					}
					else if(superMember instanceof AnnotableAndModifiable) {					
						AnnotableAndModifiable modifiable = (AnnotableAndModifiable) superMember;
						if(!ModifiableUtil.isPrivate(modifiable)) {
							memberList.add(superMember);
						}
					}
					else {
						memberList.add(superMember);
					}
				}
			}
			return memberList;
		}
	}
	
	/**
	 * @param _this
	 * @return a view on all super classifiers
	 */
	public static EList<ConcreteClassifier> getAllSuperClassifiers(AnonymousClass _this) {
		EList<ConcreteClassifier> superClassifierList = new BasicEList<ConcreteClassifier>();
		
		ConcreteClassifier superClassifier = getSuperClassifier(_this);
		
		if (superClassifier != null) {
			superClassifierList.add(superClassifier);
			superClassifierList.addAll(ClassifierUtil.getAllSuperClassifiers(superClassifier));
		}
		else {
			superClassifierList.add(JavaClasspathUtil.getObjectClass(_this));
		}
		return superClassifierList;
	}
	
	/**
	 * @param _this
	 * @return the direct super classifier
	 */
	public static ConcreteClassifier getSuperClassifier(AnonymousClass _this) {
		NewConstructorCall ncCall = (NewConstructorCall) _this.eContainer();
		ConcreteClassifier superClassifier = (ConcreteClassifier) TypeReferenceUtil.getTarget(ncCall.getType());

		return superClassifier;
	}
}
