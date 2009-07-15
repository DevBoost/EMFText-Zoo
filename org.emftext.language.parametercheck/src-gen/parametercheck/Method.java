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
 * A representation of the model object '<em><b>Method</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link parametercheck.Method#getParameter <em>Parameter</em>}</li>
 *   <li>{@link parametercheck.Method#getName <em>Name</em>}</li>
 *   <li>{@link parametercheck.Method#getCheck <em>Check</em>}</li>
 * </ul>
 * </p>
 *
 * @see parametercheck.ParametercheckPackage#getMethod()
 * @model
 * @generated
 */
public interface Method extends EObject {
	/**
   * Returns the value of the '<em><b>Parameter</b></em>' containment reference list.
   * The list contents are of type {@link parametercheck.ParameterDecl}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Parameter</em>' containment reference list.
   * @see parametercheck.ParametercheckPackage#getMethod_Parameter()
   * @model containment="true"
   * @generated
   */
	EList<ParameterDecl> getParameter();

	/**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see parametercheck.ParametercheckPackage#getMethod_Name()
   * @model required="true"
   * @generated
   */
	String getName();

	/**
   * Sets the value of the '{@link parametercheck.Method#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
	void setName(String value);

	/**
   * Returns the value of the '<em><b>Check</b></em>' containment reference list.
   * The list contents are of type {@link parametercheck.Check}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Check</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Check</em>' containment reference list.
   * @see parametercheck.ParametercheckPackage#getMethod_Check()
   * @model containment="true" required="true"
   * @generated
   */
	EList<Check> getCheck();

} // Method
