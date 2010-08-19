package org.emftext.language.eag.interpreter.impl.providers;

import java.util.Collection;

import org.emftext.language.eag.AssignmentOperator;
import org.emftext.language.eag.interpreter.impl.references.IReference;

public class AssignmentInterpreterProvider {

	public static final AssignmentInterpreterProvider INSTANCE = new AssignmentInterpreterProvider();

	public void interpret(AssignmentOperator operator, IReference left, IReference right) {
		Object elementToAdd = right.getTarget();
		Object leftTarget = left.getTarget();
		
		// TODO move this code to provider classes
		if (operator == AssignmentOperator.EQUALS && leftTarget instanceof Collection) {
			assert leftTarget instanceof Collection;
			addToCollection(leftTarget, elementToAdd);
			return;
		}
		if (operator == AssignmentOperator.EQUALS) {
			left.setTarget(elementToAdd);
			return;
		}
		if (operator == AssignmentOperator.EQUALS_PLUS) {
			assert leftTarget instanceof Collection;
			addToCollection(leftTarget, elementToAdd);
			return;
		}
		throw new RuntimeException("Can't find provider to handle assignment " + operator + " on " + left + ", " + right);
	}

	@SuppressWarnings("unchecked")
	private void addToCollection(Object collection, Object elementToAdd) {
		Collection<Object> leftCollection = (Collection<Object>) collection;
		System.out.println("adding " + elementToAdd + " to " + leftCollection);
		if (elementToAdd instanceof Collection) {
			leftCollection.addAll((Collection<Object>) elementToAdd);
		} else {
			leftCollection.add(elementToAdd);
		}
	}
}
