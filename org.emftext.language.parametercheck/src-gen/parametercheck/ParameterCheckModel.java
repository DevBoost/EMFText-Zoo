/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package parametercheck;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter Check Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link parametercheck.ParameterCheckModel#getMethod <em>Method</em>}</li>
 * </ul>
 * </p>
 *
 * @see parametercheck.ParametercheckPackage#getParameterCheckModel()
 * @model
 * @generated
 */
public interface ParameterCheckModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Method</b></em>' containment reference list.
	 * The list contents are of type {@link parametercheck.Method}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Method</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Method</em>' containment reference list.
	 * @see parametercheck.ParametercheckPackage#getParameterCheckModel_Method()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Method> getMethod();

} // ParameterCheckModel
