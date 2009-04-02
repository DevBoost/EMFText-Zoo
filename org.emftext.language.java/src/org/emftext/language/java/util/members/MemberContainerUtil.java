package org.emftext.language.java.util.members;

import org.emftext.language.java.members.Field;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.members.MemberContainer;
import org.emftext.language.java.members.Method;

public class MemberContainerUtil {
	
	public static Field getField(MemberContainer _this, String name) {
		for(Member member : _this.getMembers()) {
			if (member instanceof Field && name.equals(member.getName())) {
				return (Field) member;
			}
 		}
		return null;
	}

	//TODO add signature
	public static Method getMethod(MemberContainer _this, String name) {
		for(Member member : _this.getMembers()) {
			if (member instanceof Method && name.equals(member.getName())) {
				return (Method) member;
			}
 		}
		return null;
	}
}
