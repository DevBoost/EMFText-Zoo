package org.emftext.language.java.util.members;

import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.members.Field;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.members.MemberContainer;
import org.emftext.language.java.members.Method;
import org.emftext.language.java.util.JavaUtil;

public class MemberContainerUtil {
	
	/**
	 * @param _this
	 * @param name
	 * @return classifier with the given name defined in this member container
	 */
	public static ConcreteClassifier getConcreteClassifier(MemberContainer _this, String name) {
		for(Member member : _this.getMembers()) {
			if (member instanceof ConcreteClassifier && name.equals(JavaUtil.getName(member))) {
				return (ConcreteClassifier) member;
			}
 		}
		return null;
	}
	
	/**
	 * @param _this
	 * @param name
	 * @return field with the given name defined in this member container
	 */
	public static Field getField(MemberContainer _this, String name) {
		for(Member member : _this.getMembers()) {
			if (member instanceof Field && name.equals(JavaUtil.getName(member))) {
				return (Field) member;
			}
 		}
		return null;
	}

	/**
	 * @param _this
	 * @param name
	 * @return method with the given name defined in this member container
	 */
	//TODO @jjohannes add signature to parameters or remove method if not needed
	public static Method getMethod(MemberContainer _this, String name) {
		for(Member member : _this.getMembers()) {
			if (member instanceof Method && name.equals(JavaUtil.getName(member))) {
				return (Method) member;
			}
 		}
		return null;
	}
}
