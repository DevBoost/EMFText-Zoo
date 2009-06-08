package org.emftext.language.valueflow.diagram.part;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.valueflow.ValueflowPackage;

/**
 * @generated
 */
public class ValueflowDomainModelElementTester extends PropertyTester {

	/**
	 * @generated
	 */
	public boolean test(Object receiver, String method, Object[] args,
			Object expectedValue) {
		if (false == receiver instanceof EObject) {
			return false;
		}
		EObject eObject = (EObject) receiver;
		EClass eClass = eObject.eClass();
		if (eClass == ValueflowPackage.eINSTANCE.getNamedElement()) {
			return true;
		}
		if (eClass == ValueflowPackage.eINSTANCE.getModel()) {
			return true;
		}
		if (eClass == ValueflowPackage.eINSTANCE.getAgent()) {
			return true;
		}
		if (eClass == ValueflowPackage.eINSTANCE.getInitial()) {
			return true;
		}
		if (eClass == ValueflowPackage.eINSTANCE.getState()) {
			return true;
		}
		if (eClass == ValueflowPackage.eINSTANCE.getGiveState()) {
			return true;
		}
		if (eClass == ValueflowPackage.eINSTANCE.getTakeState()) {
			return true;
		}
		return false;
	}

}
