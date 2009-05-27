package org.emftext.language.java.util.modifiers;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.classifiers.AnonymousClass;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.commons.Commentable;
import org.emftext.language.java.instantiations.NewConstructorCall;
import org.emftext.language.java.modifiers.AnnotableAndModifiable;
import org.emftext.language.java.modifiers.AnnotationInstanceOrModifier;
import org.emftext.language.java.modifiers.Private;
import org.emftext.language.java.modifiers.Protected;
import org.emftext.language.java.modifiers.Public;
import org.emftext.language.java.modifiers.Static;
import org.emftext.language.java.types.Type;
import org.emftext.language.java.util.JavaUtil;
import org.emftext.language.java.util.types.TypeReferenceUtil;
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

	public static boolean isHidden(AnnotableAndModifiable _this, Commentable context) {
		if(context.eIsProxy()) {
			context = (Commentable) EcoreUtil.resolve(context, _this);
		}
		
		ConcreteClassifier contextClassifier = null;
		AnonymousClass anonymousClass =  null;//JavaUtil.findContainingAnonymousClass(context);
		if (anonymousClass != null) {
			Type type = TypeReferenceUtil.getTarget(
					((NewConstructorCall)anonymousClass.eContainer()).getType());
			if(type instanceof ConcreteClassifier) {
				contextClassifier = (ConcreteClassifier)type;
			}
		}
		else {
			contextClassifier = JavaUtil.findContainingClassifier(context);
		}

		ConcreteClassifier myClassifier = null;
		anonymousClass = null;//JavaUtil.findContainingAnonymousClass(_this);
		if (anonymousClass != null) {
			Type type = TypeReferenceUtil.getTarget(
					((NewConstructorCall)anonymousClass.eContainer()).getType());
			if(type instanceof ConcreteClassifier) {
				myClassifier = (ConcreteClassifier)type;
			}
		}
		else {
			myClassifier = JavaUtil.findContainingClassifier(_this);
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
		
		return true;
	}

}
