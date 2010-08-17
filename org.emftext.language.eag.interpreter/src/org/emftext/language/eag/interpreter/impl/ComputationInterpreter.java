package org.emftext.language.eag.interpreter.impl;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.language.eag.Assignment;
import org.emftext.language.eag.Attribute;
import org.emftext.language.eag.AttributeValue;
import org.emftext.language.eag.BinaryExpression;
import org.emftext.language.eag.Computation;
import org.emftext.language.eag.Expression;
import org.emftext.language.eag.ExpressionChain;
import org.emftext.language.eag.ForLoop;
import org.emftext.language.eag.Reference;
import org.emftext.language.eag.Statement;
import org.emftext.language.eag.ThisReference;
import org.emftext.language.eag.Value;
import org.emftext.language.eag.Variable;
import org.emftext.language.eag.resource.eag.util.AbstractEagInterpreter;

public class ComputationInterpreter extends AbstractEagInterpreter<IReference, ComputationContext> {

	private IReference lastResultInReferenceChain;

	@Override
	public IReference interprete_org_emftext_language_eag_Computation(
			Computation computation, 
			ComputationContext context) {
		System.out.println("==> Computation(" + computation.getTargetAttribute().getName() + "::" + computation.getContext().getName() + ")");
		IReference result = interprete(computation.getBody(), context);
		System.out.println("<== Computation(" + computation.getTargetAttribute().getName() + "::" + computation.getContext().getName() + ")");
		return result;
	}
	
	@Override
	public IReference interprete_org_emftext_language_eag_ForLoop(
			ForLoop forLoop, 
			ComputationContext context) {

		Statement body = forLoop.getBody();
		Variable variable = forLoop.getVariable();

		IReference collectionRef = interprete(forLoop.getCollection(), context);
		Object target = collectionRef.getTarget();
		assert target != null;
		assert target instanceof Collection;
		Collection<?> collection = (Collection<?>) target;
		Iterator<?> iterator = collection.iterator();
		while (iterator.hasNext()) {
			Object next = (Object) iterator.next();
			context.addVariable(variable, next);
			interprete(body, context);
			context.removeVariable(variable);
		}
		return null;
	}

	@Override
	public IReference interprete_org_emftext_language_eag_Assignment(
			Assignment assignment, 
			ComputationContext context) {
		System.out.println("Assignment()");
		Object rightValue = interprete(assignment.getRight(), context);
		Object leftValue = interprete(assignment.getLeft(), context);
		System.out.println("Assignment() left = " + leftValue);
		System.out.println("Assignment() right = " + rightValue);
		assert rightValue instanceof IReference;
		assert leftValue instanceof IReference;
		IReference right = (IReference) rightValue;
		IReference left = (IReference) leftValue;
		AssignmentInterpreterProvider.INSTANCE.interpret(assignment, left, right);
		return null;
	}

	@Override
	public IReference interprete_org_emftext_language_eag_BinaryExpression(
			BinaryExpression expression, 
			ComputationContext context) {
		System.out.println("BinaryExpression()");
		// first do the left and the the right
		Object left = interprete(expression.getLeft(), context);
		Object right = interprete(expression.getRight(), context);
		System.out.println("BinaryExpression() left = " + left);
		System.out.println("BinaryExpression() right = " + right);
		assert left instanceof ObjectReference;
		assert right instanceof ObjectReference;
		ObjectReference leftRef = (ObjectReference) left;
		ObjectReference rightRef = (ObjectReference) right;
		System.out.println("BinaryExpression() leftRef = " + leftRef.getTarget());
		System.out.println("BinaryExpression() rightRef = " + rightRef.getTarget());
		return BinaryExpressionInterpreterProvider.INSTANCE.interpret(expression, leftRef, rightRef);
	}
	
	@Override
	public IReference interprete_org_emftext_language_eag_AttributeValue(
			AttributeValue attributeValue, 
			ComputationContext context) {
		
		Attribute attribute = attributeValue.getTargetAttribute();
		System.out.println("AttributeValue() " + attribute.getName());
		IReference expressionResult = interprete(attributeValue.getExpression(), context);
		System.out.println("AttributeValue() " + expressionResult);
		assert expressionResult instanceof ObjectReference;
		
		//Object expressionValue = expressionResult.getValue();
		//assert expressionValue instanceof ObjectReference;
		
		ObjectReference expressionReference = (ObjectReference) expressionResult;
		// evaluate attribute on the result of interpreting object.getExpression()
		Object result = new EAGInterpreter().interpret((EObject) expressionReference.getTarget(), context.getGrammar(), attribute);
		return ReferenceFactory.INSTANCE.createReference(result);
	}
	
	@Override
	public IReference interprete_org_emftext_language_eag_ExpressionChain(
			ExpressionChain chain, 
			ComputationContext context) {
		Expression previous = chain.getPrevious();
		System.out.println("ExpressionChain() " + previous);
		lastResultInReferenceChain = null;
		lastResultInReferenceChain = interprete(previous, context);
		return interprete(chain.getNext(), context);
		//return lastResultInReferenceChain;
	}
	
	@Override
	public IReference interprete_org_emftext_language_eag_Reference(
			Reference object, ComputationContext context) {
		IReference previous = lastResultInReferenceChain;
		System.out.println("Reference() previous = " + previous);
		EObject target = object.getTarget();
		System.out.println("Reference() target = " + target);
		if (target instanceof EStructuralFeature) {
			assert previous instanceof IComplexReference;
			IComplexReference reference = (IComplexReference) previous;
			assert reference != null;
			EStructuralFeature feature = (EStructuralFeature) target;
			assert feature != null;
			System.out.println("FeatureReference() feature = " + feature);
			String featureName = feature.getName();
			assert featureName != null;
			System.out.println("FeatureReference() getting '" + featureName + "' from " + reference);
			ObjectReference featureReference = reference.getReference(feature);
			return featureReference;
		} else if (target instanceof Variable) {
			Variable variable = (Variable) target;
			Object value = context.getVariableValue(variable);
			return ReferenceFactory.INSTANCE.createReference(value);
		} else {
			throw new RuntimeException("Unknown reference target " + target);
		}
	}
	
	@Override
	public IReference interprete_org_emftext_language_eag_Value(
			Value value,
			ComputationContext context) {
		return new ValueReference(context);
	}

	@Override
	public IReference interprete_org_emftext_language_eag_ThisReference(
			ThisReference thisRef,
			ComputationContext context) {
		EObject thisObject = context.getObject();
		ObjectReference referenceToThisObject = new EObjectReference(thisObject);
		lastResultInReferenceChain = referenceToThisObject;
		return referenceToThisObject;
	}
}
