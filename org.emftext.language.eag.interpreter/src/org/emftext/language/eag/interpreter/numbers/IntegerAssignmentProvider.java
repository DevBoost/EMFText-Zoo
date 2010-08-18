package org.emftext.language.eag.interpreter.numbers;

import org.emftext.language.eag.AssignmentOperator;
import org.emftext.language.eag.interpreter.IAssignmentOperationProvider;

public class IntegerAssignmentProvider implements IAssignmentOperationProvider {

	public boolean canHandle(AssignmentOperator operator, Class<?> leftType,
			Class<?> rightType) {
		if (operator == AssignmentOperator.EQUALS) {
			
		}
		return false;
	}

	public Object interpret(AssignmentOperator operator, Object left,
			Object right) {
		// TODO Auto-generated method stub
		return null;
	}

}
