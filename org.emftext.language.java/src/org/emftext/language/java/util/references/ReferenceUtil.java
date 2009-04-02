package org.emftext.language.java.util.references;

import org.emftext.language.java.classifiers.AnonymousClass;
import org.emftext.language.java.classifiers.Enumeration;
import org.emftext.language.java.expressions.NestedExpression;
import org.emftext.language.java.literals.Literal;
import org.emftext.language.java.members.AdditionalField;
import org.emftext.language.java.members.EnumConstant;
import org.emftext.language.java.references.ElementReference;
import org.emftext.language.java.references.Reference;
import org.emftext.language.java.references.ReferenceableElement;
import org.emftext.language.java.references.ReferencesPackage;
import org.emftext.language.java.references.ReflectiveClassReference;
import org.emftext.language.java.references.SelfReference;
import org.emftext.language.java.references.StringReference;
import org.emftext.language.java.types.Type;
import org.emftext.language.java.types.TypeReference;
import org.emftext.language.java.types.TypedElement;
import org.emftext.language.java.util.JavaClasspathUtil;
import org.emftext.language.java.util.JavaUtil;
import org.emftext.language.java.util.expressions.ExpressionUtil;
import org.emftext.language.java.util.literals.LiteralUtil;
import org.emftext.language.java.util.types.TypeReferenceUtil;
import org.emftext.language.java.variables.AdditionalLocalVariable;

public class ReferenceUtil {
	
	/**
	 * Determines the <code>Type</code> of the reference. That is,
	 * either the type to which the reference points directly, or the
	 * type of the element to which the reference points.
	 * 
	 * @param _this
	 * @return the determined type
	 */
	public static Type getType(Reference _this) {
		if (_this instanceof Literal) {
			return LiteralUtil.getType((Literal) _this);
		}

		Type type = null;

		//referenced element point to a type
		if (_this instanceof TypedElement) {
			TypeReference typeRef = ((TypedElement) _this).getType();
			type = TypeReferenceUtil.getTarget(typeRef, _this);
		}
		//element points to this or super
		else if (_this instanceof SelfReference) {
			if (_this.eContainer() instanceof Reference && _this.eContainingFeature().equals(ReferencesPackage.Literals.REFERENCE__NEXT)) {
				return getType((Reference)_this.eContainer());
			}
			else {
				AnonymousClass anonymousContainer = JavaUtil.findContainingAnonymousClass(_this);
				if (anonymousContainer != null) {
					return anonymousContainer;
				}
				else {
					return JavaUtil.findContainingClassifier(_this);	
				}
			}
		}
		//element points to the object's class object
		else if(_this instanceof ReflectiveClassReference) {
			return JavaClasspathUtil.getClassClass(_this);
		}
		//referenced element points to an element with a type
		else if (_this instanceof ElementReference) {
			ReferenceableElement target = 
				(ReferenceableElement) ((ElementReference) _this).getTarget();
			if (target.eIsProxy()) {
				type = null;
			}
			
			//Navigate through AdditionalLocalVariable or Field
			if(target instanceof AdditionalLocalVariable) {
				target = (ReferenceableElement) target.eContainer();
			}
			if(target instanceof AdditionalField) {
				target = (ReferenceableElement) target.eContainer();
			}
			if (target instanceof TypedElement) {
				TypeReference typeRef = ((TypedElement) target).getType();
				type = TypeReferenceUtil.getTarget(typeRef, _this);
			}
			else if (target instanceof Type /*e.g. Annotation*/ ) {
				return (Type) target;
			}
			else if(target instanceof EnumConstant) {
				type = (Enumeration)target.eContainer();
			}	
		}
		//Strings may also appear as reference
		else if (_this instanceof StringReference) {
			return JavaClasspathUtil.getStringClass(_this);
		}
		else if (_this instanceof NestedExpression) {
			type = ExpressionUtil.getType(((NestedExpression) _this).getExpression());
		}
		else {
			assert(false);
		}
		return type;
	}

}
