package org.emftext.language.java.resource.java.analysis.helper;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.annotations.AnnotationElementValuePair;
import org.emftext.language.java.annotations.AnnotationInstance;
import org.emftext.language.java.expressions.Expression;
import org.emftext.language.java.expressions.PrimaryExpression;
import org.emftext.runtime.IResourcePostProcessor;
import org.emftext.runtime.IResourcePostProcessorProvider;
import org.emftext.runtime.resource.ITextResource;

import com.sun.javadoc.AnnotationValue;

public class ExpressionSimplifier implements IResourcePostProcessor, IResourcePostProcessorProvider {

	private static final ExpressionSimplifier theSimplifier = new ExpressionSimplifier();
	
	public IResourcePostProcessor getResourcePostProcessor() {
		return theSimplifier;
	}
	
	public void process(ITextResource resource) {
		simplifyDown(resource.getContents());
	}
	
	public void simplifyDown(EList<EObject> parentList) {
		for(EObject child : new BasicEList<EObject>(parentList)) {
			EObject singleContained = getSingleContained(child);
			EObject next = singleContained;
			while (next != null) {
				next = getSingleContained(singleContained);
				if (next != null) {
					singleContained = next;
				}
			}
			if (singleContained != null) {
				EcoreUtil.replace(child, singleContained);
				child = singleContained;
			}
			simplifyDown(child.eContents());
		}
	}

	
	public EObject getSingleContained(EObject parent) {
		if (parent.eContainer() instanceof AnnotationInstance ||
				parent.eContainer() instanceof AnnotationElementValuePair) {
			//special case. Might be changed in the future.
			return null;
		}
		if (!(parent instanceof Expression)) {
			return null;
		}
		//never kill a primary
		if (parent instanceof PrimaryExpression) {
			return null;
		}
		EObject singleContained = null;
		for(EObject contained : parent.eContents()) {
			if (singleContained != null) {
				return null;
			}
			singleContained = contained;
		}
		if (!(singleContained instanceof Expression)) {
			return null;
		}

		return singleContained;
	}



}
