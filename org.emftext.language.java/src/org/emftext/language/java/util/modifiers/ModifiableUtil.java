package org.emftext.language.java.util.modifiers;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.commons.Commentable;
import org.emftext.language.java.modifiers.AnnotableAndModifiable;
import org.emftext.language.java.modifiers.AnnotationInstanceOrModifier;
import org.emftext.language.java.modifiers.Modifiable;
import org.emftext.language.java.modifiers.Modifier;
import org.emftext.language.java.modifiers.Private;
import org.emftext.language.java.modifiers.Protected;
import org.emftext.language.java.modifiers.Public;
import org.emftext.language.java.util.JavaUtil;

public class ModifiableUtil {

	public static boolean isPrivate(Modifiable _this) {
		for(Modifier modifier : _this.getModifiers()) {
			if(modifier instanceof Private) {
				return true;
			}
		}
		return false;
	}

	public static boolean isHidden(AnnotableAndModifiable _this, Commentable context) {
		for(AnnotationInstanceOrModifier modifier : _this.getAnnotationsAndModifiers()) {
			if(modifier instanceof Private) {
				return true;
			}
			if(modifier instanceof Public) {
				return false;
			}
			if(modifier instanceof Protected) {
				return false;
			}
		}
		//package visibility
		if(context.eIsProxy()) {
			context = (Commentable) EcoreUtil.resolve(context, _this);
		}
		if (JavaUtil.findPackageName(_this) != null && 
				JavaUtil.findPackageName(_this).equals(JavaUtil.findPackageName(context))) {
			return false;
		}
		
		return true;
	}

}
