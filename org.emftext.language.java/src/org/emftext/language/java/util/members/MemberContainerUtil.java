/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
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
	 * @return method with the given name defined in this member container;
	 *         null, if there is no such method 
	 *         or if there are multiple methods with the same name
	 */
	public static Method getOnlyMethodWithName(MemberContainer _this, String name) {
		Method found = null;
		for(Member member : _this.getMembers()) {
			if (member instanceof Method && name.equals(JavaUtil.getName(member))) {
				if(found != null) {
					return null;
				}
				else {
					found = (Method) member;
				}
			}
 		}
		return found;
	}
}
