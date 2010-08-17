package org.emftext.language.eag.interpreter.impl;

import java.util.Collection;

import org.emftext.language.eag.Assignment;
import org.emftext.language.eag.AssignmentOperator;

public class AssignmentInterpreterProvider {

	public static final AssignmentInterpreterProvider INSTANCE = new AssignmentInterpreterProvider();

	public void interpret(Assignment assigment, IReference left, IReference right) {
		Object elementToAdd = right.getTarget();
		Object leftTarget = left.getTarget();
		if (assigment.getOperator() == AssignmentOperator.EQUALS && leftTarget instanceof Collection) {
			assert leftTarget instanceof Collection;
			addToCollection(leftTarget, elementToAdd);
			return;
		}
		if (assigment.getOperator() == AssignmentOperator.EQUALS) {
			left.setTarget(elementToAdd);
			return;
		}
		if (assigment.getOperator() == AssignmentOperator.EQUALS_PLUS) {
			assert leftTarget instanceof Collection;
			addToCollection(leftTarget, elementToAdd);
			return;
		}
		throw new RuntimeException("Can't find provider to handle assigment " + assigment.getOperator() + " on " + left + ", " + right);
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
