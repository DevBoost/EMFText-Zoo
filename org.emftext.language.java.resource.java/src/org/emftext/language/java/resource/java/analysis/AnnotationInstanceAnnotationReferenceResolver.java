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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.annotations.AnnotationInstance;
import org.emftext.language.java.classifiers.Annotation;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.resource.java.analysis.decider.ConcreteClassifierDecider;
import org.emftext.language.java.resource.java.analysis.decider.IResolutionTargetDecider;
import org.emftext.language.java.resource.java.analysis.helper.ScopedTreeWalker;
import org.emftext.language.java.util.JavaUtil;
import org.emftext.runtime.resource.impl.AbstractReferenceResolver;

public class AnnotationInstanceAnnotationReferenceResolver extends 
	AbstractReferenceResolver<org.emftext.language.java.annotations.AnnotationInstance, org.emftext.language.java.classifiers.Classifier> {
	
	public java.lang.String deResolve(org.emftext.language.java.classifiers.Classifier element, org.emftext.language.java.annotations.AnnotationInstance container, org.eclipse.emf.ecore.EReference reference) {
		return JavaUtil.getName(element);
	}
	
	public void resolve(java.lang.String identifier, org.emftext.language.java.annotations.AnnotationInstance annotationInstance, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.emftext.language.java.classifiers.Classifier> result) {
		List<IResolutionTargetDecider> deciderList = new ArrayList<IResolutionTargetDecider>();
		EObject startingPoint = annotationInstance;
		EObject target =  null; 
		
		if(annotationInstance.getNamespaces().size() > 0) {
			EObject lastClassInNS = ConcreteClassifierDecider.resolveRelativeNamespace(
					annotationInstance, 0, annotationInstance, annotationInstance, reference);
			if (lastClassInNS != null) {
				startingPoint = lastClassInNS;
			}
			else {
				//absolute class starting with package
				target = resolveFullQualifiedAnnotationReferences(identifier, annotationInstance);
			}
		}
		
		if (target == null) {
			deciderList.add(new ConcreteClassifierDecider());		
			ScopedTreeWalker treeWalker = new ScopedTreeWalker(deciderList);
			target = treeWalker.walk(startingPoint, identifier, annotationInstance, reference);
		}
		
		if (target != null) {
			result.addMapping(identifier, (Classifier) target);
		}
	}
	
	private EObject resolveFullQualifiedAnnotationReferences(String identifier,
			AnnotationInstance annotationInstance) {
			
		if (annotationInstance.getNamespaces().size() > 0) {
			String containerName = JavaClasspath.get(annotationInstance).getContainerNameFromNamespace(annotationInstance);
			ConcreteClassifier target = (ConcreteClassifier) EcoreUtil.resolve(
					JavaClasspath.get(annotationInstance).getClassifier(containerName + identifier), annotationInstance.eResource());
		
			if (target instanceof Annotation) {
				return target;
			}
		}
		
		return null;
	}

	public void setOptions(Map<?, ?> options) {
	}
}
