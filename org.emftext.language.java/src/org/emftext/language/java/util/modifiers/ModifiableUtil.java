package org.emftext.language.java.util.modifiers;

import org.emftext.language.java.modifiers.AnnotableAndModifiable;
import org.emftext.language.java.modifiers.AnnotationInstanceOrModifier;
import org.emftext.language.java.modifiers.Modifiable;
import org.emftext.language.java.modifiers.Modifier;
import org.emftext.language.java.modifiers.Private;

public class ModifiableUtil {

	public static boolean isPrivate(Modifiable _this) {
		for(Modifier modifier : _this.getModifiers()) {
			if(modifier instanceof Private) {
				return true;
			}
		}
		return false;
	}

	public static boolean isPrivate(AnnotableAndModifiable _this) {
		for(AnnotationInstanceOrModifier modifier : _this.getAnnotationsAndModifiers()) {
			if(modifier instanceof Private) {
				return true;
			}
		}
		return false;
	}

}
