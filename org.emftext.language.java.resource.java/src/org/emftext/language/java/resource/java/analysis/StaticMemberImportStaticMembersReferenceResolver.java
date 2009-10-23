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
package org.emftext.language.java.resource.java.analysis;

import java.util.Map;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.classifiers.Enumeration;
import org.emftext.language.java.imports.StaticMemberImport;
import org.emftext.language.java.members.EnumConstant;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.modifiers.AnnotableAndModifiable;
import org.emftext.language.java.references.ReferenceableElement;
import org.emftext.language.java.resource.java.IJavaReferenceResolveResult;
import org.emftext.language.java.resource.java.IJavaReferenceResolver;

public class StaticMemberImportStaticMembersReferenceResolver implements 
	IJavaReferenceResolver<StaticMemberImport, ReferenceableElement> {
	
	public java.lang.String deResolve(ReferenceableElement element, StaticMemberImport container, org.eclipse.emf.ecore.EReference reference) {
		return element.getName();
	}
	
	public void resolve(java.lang.String identifier, StaticMemberImport theImport, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, IJavaReferenceResolveResult<ReferenceableElement> result) {
		ConcreteClassifier classifier = theImport.getClassifierAtNamespaces();
		classifier = (ConcreteClassifier) EcoreUtil.resolve(classifier, theImport.eResource());
		if (classifier != null && !classifier.eIsProxy()) {
			for(Member member : classifier.getAllMembers(theImport)) {
				if (identifier.equals(member.getName()) && member instanceof ReferenceableElement) {
					if (member instanceof AnnotableAndModifiable) {
						if (member.eIsProxy()) {
							member = (Member) EcoreUtil.resolve(member, theImport);
						}
						if(((AnnotableAndModifiable)member).isStatic()) {
							result.addMapping(identifier, (ReferenceableElement) member);
						}
					}
				}
			}
			
			if (classifier instanceof Enumeration) {
				for(EnumConstant enumConstant : ((Enumeration)classifier).getConstants()) {
					if (identifier.equals(enumConstant.getName())) {
						result.addMapping(identifier, enumConstant);
						return;
					}
				}
			}
		}	
	}

	public void setOptions(Map<?, ?> options) {
	}
}
