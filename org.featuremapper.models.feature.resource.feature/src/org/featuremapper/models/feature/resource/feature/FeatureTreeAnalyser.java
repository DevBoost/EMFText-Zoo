package org.featuremapper.models.feature.resource.feature; 

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.reuseware.emftextedit.runtime.resource.TextResource;
import org.reuseware.emftextedit.runtime.resource.impl.*;

import org.featuremapper.models.feature.Group;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;
import org.featuremapper.models.feature.Annotation;
import org.featuremapper.models.feature.Attribute;
import org.featuremapper.models.feature.Constraint;
import org.featuremapper.models.feature.resource.feature.analysis.*;

public class FeatureTreeAnalyser extends EMFTextTreeAnalyserImpl {

	protected GroupParentFeatureProxyResolver groupParentFeatureProxyResolver = new GroupParentFeatureProxyResolver();

	protected FeatureConstraintsProxyResolver featureConstraintsProxyResolver = new FeatureConstraintsProxyResolver();

	protected FeatureModelParentProxyResolver featureModelParentProxyResolver = new FeatureModelParentProxyResolver();

	protected FeatureParentGroupProxyResolver featureParentGroupProxyResolver = new FeatureParentGroupProxyResolver();

	protected AnnotationFeatureProxyResolver annotationFeatureProxyResolver = new AnnotationFeatureProxyResolver();

	protected AttributeFeatureProxyResolver attributeFeatureProxyResolver = new AttributeFeatureProxyResolver();

	protected ConstraintConstrainedFeaturesProxyResolver constraintConstrainedFeaturesProxyResolver = new ConstraintConstrainedFeaturesProxyResolver();

	public EObject resolve(InternalEObject proxy, EObject container, EReference reference, TextResource resource, boolean reportErrors) {
		if (container instanceof Group && reference.getFeatureID() == 2) {
			return groupParentFeatureProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof Feature && reference.getFeatureID() == 7) {
			return featureConstraintsProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof FeatureModel && reference.getFeatureID() == 4) {
			return featureModelParentProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof Feature && reference.getFeatureID() == 5) {
			return featureParentGroupProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof Annotation && reference.getFeatureID() == 0) {
			return annotationFeatureProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof Attribute && reference.getFeatureID() == 0) {
			return attributeFeatureProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof Constraint && reference.getFeatureID() == 2) {
			return constraintConstrainedFeaturesProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		return null;
	}

	public String deResolve(EObject refObject, EObject container, EReference reference) {
		if (container instanceof Group && reference.getFeatureID() == 2) {
			return groupParentFeatureProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof Feature && reference.getFeatureID() == 7) {
			return featureConstraintsProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof FeatureModel && reference.getFeatureID() == 4) {
			return featureModelParentProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof Feature && reference.getFeatureID() == 5) {
			return featureParentGroupProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof Annotation && reference.getFeatureID() == 0) {
			return annotationFeatureProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof Attribute && reference.getFeatureID() == 0) {
			return attributeFeatureProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof Constraint && reference.getFeatureID() == 2) {
			return constraintConstrainedFeaturesProxyResolver.deResolve(refObject,container,reference);
		}
		return null;
	}

	public void setOptions(java.util.Map<?, ?> options) {
		groupParentFeatureProxyResolver.setOptions(options);
		featureConstraintsProxyResolver.setOptions(options);
		featureModelParentProxyResolver.setOptions(options);
		featureParentGroupProxyResolver.setOptions(options);
		annotationFeatureProxyResolver.setOptions(options);
		attributeFeatureProxyResolver.setOptions(options);
		constraintConstrainedFeaturesProxyResolver.setOptions(options);
	}
}
