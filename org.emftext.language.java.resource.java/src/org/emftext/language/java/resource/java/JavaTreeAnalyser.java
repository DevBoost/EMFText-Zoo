package org.emftext.language.java.resource.java; 

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import org.emftext.runtime.resource.impl.*;

import org.emftext.language.java.NewConstructorCall;
import org.emftext.language.java.Import;
import org.emftext.language.java.Method;
import org.emftext.language.java.PackageOrClassifierOrMethodOrVariableReference;
import org.emftext.language.java.Variable;
import org.emftext.language.java.Constructor;
import org.emftext.language.java.Instantiation;
import org.emftext.language.java.AnnotationElementValuePair;
import org.emftext.language.java.PackageOrClassifierReference;
import org.emftext.language.java.Enumeration;
import org.emftext.language.java.resource.java.analysis.*;

public class JavaTreeAnalyser extends EMFTextTreeAnalyserImpl {

	protected NewConstructorCallClassTypeArgumentsReferenceResolver newConstructorCallClassTypeArgumentsReferenceResolver = new NewConstructorCallClassTypeArgumentsReferenceResolver();

	protected ImportClassifiersReferenceResolver importClassifiersReferenceResolver = new ImportClassifiersReferenceResolver();

	protected MethodExceptionsReferenceResolver methodExceptionsReferenceResolver = new MethodExceptionsReferenceResolver();

	protected PackageOrClassifierOrMethodOrVariableReferenceTargetReferenceResolver packageOrClassifierOrMethodOrVariableReferenceTargetReferenceResolver = new PackageOrClassifierOrMethodOrVariableReferenceTargetReferenceResolver();

	protected VariableTypeArgumentsReferenceResolver variableTypeArgumentsReferenceResolver = new VariableTypeArgumentsReferenceResolver();

	protected ConstructorExceptionsReferenceResolver constructorExceptionsReferenceResolver = new ConstructorExceptionsReferenceResolver();

	protected InstantiationTypeArgumentsReferenceResolver instantiationTypeArgumentsReferenceResolver = new InstantiationTypeArgumentsReferenceResolver();

	protected AnnotationElementValuePairKeyReferenceResolver annotationElementValuePairKeyReferenceResolver = new AnnotationElementValuePairKeyReferenceResolver();

	protected PackageOrClassifierReferenceTargetReferenceResolver packageOrClassifierReferenceTargetReferenceResolver = new PackageOrClassifierReferenceTargetReferenceResolver();

	protected EnumerationImplementsReferenceResolver enumerationImplementsReferenceResolver = new EnumerationImplementsReferenceResolver();

	public void resolve(String identifier, EObject container, EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.ResolveResult result) {
		if (resolveFuzzy) {
			resolveFuzzy(identifier, container, position, result);
		} else {
			resolveStrict(identifier, container, reference, position, result);
		}
	}

	public void resolveStrict(String identifier, EObject container, EReference reference, int position, org.emftext.runtime.resource.ResolveResult result) {
		if (container instanceof NewConstructorCall && reference.getFeatureID() == 4) {
			newConstructorCallClassTypeArgumentsReferenceResolver.resolve(identifier, container, reference, position, false, result);
			return;
		}
		if (container instanceof Import && reference.getFeatureID() == 1) {
			importClassifiersReferenceResolver.resolve(identifier, container, reference, position, false, result);
			return;
		}
		if (container instanceof Method && reference.getFeatureID() == 6) {
			methodExceptionsReferenceResolver.resolve(identifier, container, reference, position, false, result);
			return;
		}
		if (container instanceof PackageOrClassifierOrMethodOrVariableReference && reference.getFeatureID() == 0) {
			packageOrClassifierOrMethodOrVariableReferenceTargetReferenceResolver.resolve(identifier, container, reference, position, false, result);
			return;
		}
		if (container instanceof Variable && reference.getFeatureID() == 4) {
			variableTypeArgumentsReferenceResolver.resolve(identifier, container, reference, position, false, result);
			return;
		}
		if (container instanceof Constructor && reference.getFeatureID() == 3) {
			constructorExceptionsReferenceResolver.resolve(identifier, container, reference, position, false, result);
			return;
		}
		if (container instanceof Instantiation && reference.getFeatureID() == 2) {
			instantiationTypeArgumentsReferenceResolver.resolve(identifier, container, reference, position, false, result);
			return;
		}
		if (container instanceof AnnotationElementValuePair && reference.getFeatureID() == 0) {
			annotationElementValuePairKeyReferenceResolver.resolve(identifier, container, reference, position, false, result);
			return;
		}
		if (container instanceof PackageOrClassifierReference && reference.getFeatureID() == 0) {
			packageOrClassifierReferenceTargetReferenceResolver.resolve(identifier, container, reference, position, false, result);
			return;
		}
		if (container instanceof Enumeration && reference.getFeatureID() == 5) {
			enumerationImplementsReferenceResolver.resolve(identifier, container, reference, position, false, result);
			return;
		}
	}

	public String deResolve(EObject refObject, EObject container, EReference reference) {
		if (container instanceof NewConstructorCall && reference.getFeatureID() == 4) {
			return newConstructorCallClassTypeArgumentsReferenceResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof Import && reference.getFeatureID() == 1) {
			return importClassifiersReferenceResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof Method && reference.getFeatureID() == 6) {
			return methodExceptionsReferenceResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof PackageOrClassifierOrMethodOrVariableReference && reference.getFeatureID() == 0) {
			return packageOrClassifierOrMethodOrVariableReferenceTargetReferenceResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof Variable && reference.getFeatureID() == 4) {
			return variableTypeArgumentsReferenceResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof Constructor && reference.getFeatureID() == 3) {
			return constructorExceptionsReferenceResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof Instantiation && reference.getFeatureID() == 2) {
			return instantiationTypeArgumentsReferenceResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof AnnotationElementValuePair && reference.getFeatureID() == 0) {
			return annotationElementValuePairKeyReferenceResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof PackageOrClassifierReference && reference.getFeatureID() == 0) {
			return packageOrClassifierReferenceTargetReferenceResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof Enumeration && reference.getFeatureID() == 5) {
			return enumerationImplementsReferenceResolver.deResolve(refObject,container,reference);
		}
		return null;
	}

	public void setOptions(java.util.Map<?, ?> options) {
		newConstructorCallClassTypeArgumentsReferenceResolver.setOptions(options);
		importClassifiersReferenceResolver.setOptions(options);
		methodExceptionsReferenceResolver.setOptions(options);
		packageOrClassifierOrMethodOrVariableReferenceTargetReferenceResolver.setOptions(options);
		variableTypeArgumentsReferenceResolver.setOptions(options);
		constructorExceptionsReferenceResolver.setOptions(options);
		instantiationTypeArgumentsReferenceResolver.setOptions(options);
		annotationElementValuePairKeyReferenceResolver.setOptions(options);
		packageOrClassifierReferenceTargetReferenceResolver.setOptions(options);
		enumerationImplementsReferenceResolver.setOptions(options);
	}

	public void resolveFuzzy(java.lang.String identifier, EObject container, int position, org.emftext.runtime.resource.ResolveResult result) {

		resolveFuzzy(NewConstructorCall.class, identifier, container, position, 4, newConstructorCallClassTypeArgumentsReferenceResolver, result);
		resolveFuzzy(Import.class, identifier, container, position, 1, importClassifiersReferenceResolver, result);
		resolveFuzzy(Method.class, identifier, container, position, 6, methodExceptionsReferenceResolver, result);
		resolveFuzzy(PackageOrClassifierOrMethodOrVariableReference.class, identifier, container, position, 0, packageOrClassifierOrMethodOrVariableReferenceTargetReferenceResolver, result);
		resolveFuzzy(Variable.class, identifier, container, position, 4, variableTypeArgumentsReferenceResolver, result);
		resolveFuzzy(Constructor.class, identifier, container, position, 3, constructorExceptionsReferenceResolver, result);
		resolveFuzzy(Instantiation.class, identifier, container, position, 2, instantiationTypeArgumentsReferenceResolver, result);
		resolveFuzzy(AnnotationElementValuePair.class, identifier, container, position, 0, annotationElementValuePairKeyReferenceResolver, result);
		resolveFuzzy(PackageOrClassifierReference.class, identifier, container, position, 0, packageOrClassifierReferenceTargetReferenceResolver, result);
		resolveFuzzy(Enumeration.class, identifier, container, position, 5, enumerationImplementsReferenceResolver, result);
	}

	protected void resolveFuzzy(Class<?> clazz, String identifier, EObject container, int position, 
			int featureID, 
			org.emftext.runtime.resource.ReferenceResolver resolver, org.emftext.runtime.resource.ResolveResult result
			) {

		//if (clazz.isInstance(container)) {
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(featureID);
			if (!(feature instanceof EReference)) {
				return;
			}
			resolver.resolve(identifier, container, (EReference) feature, position, true, result);
	}

}
