package org.emftext.language.java.util.modifiers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.classifiers.AnonymousClass;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.commons.Commentable;
import org.emftext.language.java.literals.Self;
import org.emftext.language.java.modifiers.AnnotableAndModifiable;
import org.emftext.language.java.modifiers.AnnotationInstanceOrModifier;
import org.emftext.language.java.modifiers.Private;
import org.emftext.language.java.modifiers.Protected;
import org.emftext.language.java.modifiers.Public;
import org.emftext.language.java.modifiers.Static;
import org.emftext.language.java.references.Reference;
import org.emftext.language.java.references.ReferencesPackage;
import org.emftext.language.java.references.SelfReference;
import org.emftext.language.java.types.Type;
import org.emftext.language.java.util.JavaUtil;
import org.emftext.language.java.util.classifiers.AnonymousClassUtil;
import org.emftext.language.java.util.references.ReferenceUtil;
import org.emftext.language.java.util.types.TypeUtil;

public class ModifiableUtil {

	public static boolean isStatic(AnnotableAndModifiable _this) {
		for(AnnotationInstanceOrModifier modifier : _this.getAnnotationsAndModifiers()) {
			if(modifier instanceof Static) {
				return true;
			}
		}
		return false;
	}

	public static boolean isHidden(AnnotableAndModifiable _this, EObject context) {
		if(context.eIsProxy()) {
			context = (Commentable) EcoreUtil.resolve(context, _this);
		}
		
		ConcreteClassifier contextClassifier = JavaUtil.findContainingClassifier(context);
		ConcreteClassifier myClassifier = JavaUtil.findContainingClassifier(_this);
		
		//special case: self reference to outer instance
		if(context.eContainmentFeature().equals(ReferencesPackage.Literals.REFERENCE__NEXT)) {
			if (context.eContainer() instanceof SelfReference) {
				SelfReference selfReference = (SelfReference) context.eContainer();
				if (selfReference.getSelf() instanceof Self) {
					if(selfReference.eContainmentFeature().equals(ReferencesPackage.Literals.REFERENCE__NEXT)) {
						Type type = ReferenceUtil.getType((Reference) selfReference.eContainer());
						if (type instanceof ConcreteClassifier) {
							contextClassifier = (ConcreteClassifier) type;
						}
					}
				}
			}
		}
		
		for(AnnotationInstanceOrModifier modifier : _this.getAnnotationsAndModifiers()) {
			if(modifier instanceof Private) {
				if (TypeUtil.equalsType(myClassifier, 0, contextClassifier, 0)) {
					return false;
				}
				return true;
			}
			if(modifier instanceof Public) {
				return false;
			}
			if(modifier instanceof Protected) {
				if (TypeUtil.isSuperType(contextClassifier, 0, myClassifier, null)) {
					return false;
				}
				return true;
			}
		}
		//package visibility
		if (JavaUtil.findPackageName(_this) != null && 
				JavaUtil.findPackageName(_this).equals(JavaUtil.findPackageName(context))) {
			return false;
		}
		//package visibility through subclass
		if (TypeUtil.isSuperType(contextClassifier, 0, myClassifier, null)) {
			return false;
		}
		//package visibility through anonymous subclass
		AnonymousClass anonymousClass = JavaUtil.findContainingAnonymousClass(context);
		if (anonymousClass != null) {
			contextClassifier = AnonymousClassUtil.getSuperClassifier(anonymousClass);
			if (TypeUtil.isSuperType(contextClassifier, 0, myClassifier, null)) {
				return false;
			}
		}
		
		return true;
	}

}
