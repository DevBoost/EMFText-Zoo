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
 * A representation of the model object '<em><b>Exception</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link parametercheck.Exception#getPackage <em>Package</em>}</li>
 *   <li>{@link parametercheck.Exception#getName <em>Name</em>}</li>
 *   <li>{@link parametercheck.Exception#getParameterusage <em>Parameterusage</em>}</li>
 *   <li>{@link parametercheck.Exception#getParentcheck <em>Parentcheck</em>}</li>
 * </ul>
 * </p>
 *
 * @see parametercheck.ParametercheckPackage#getException()
 * @model
 * @generated
 */
public interface Exception extends EObject {
	/**
	 * Returns the value of the '<em><b>Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package</em>' attribute.
	 * @see #setPackage(String)
	 * @see parametercheck.ParametercheckPackage#getException_Package()
	 * @model
	 * @generated
	 */
	String getPackage();

	/**
	 * Sets the value of the '{@link parametercheck.Exception#getPackage <em>Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package</em>' attribute.
	 * @see #getPackage()
	 * @generated
	 */
	void setPackage(String value);

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
	 * @see parametercheck.ParametercheckPackage#getException_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link parametercheck.Exception#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Parameterusage</b></em>' containment reference list.
	 * The list contents are of type {@link parametercheck.ParameterUsage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameterusage</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameterusage</em>' containment reference list.
	 * @see parametercheck.ParametercheckPackage#getException_Parameterusage()
	 * @model containment="true"
	 * @generated
	 */
	EList<ParameterUsage> getParameterusage();

	/**
	 * Returns the value of the '<em><b>Parentcheck</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link parametercheck.Check#getException <em>Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parentcheck</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parentcheck</em>' container reference.
	 * @see #setParentcheck(Check)
	 * @see parametercheck.ParametercheckPackage#getException_Parentcheck()
	 * @see parametercheck.Check#getException
	 * @model opposite="exception" required="true" transient="false"
	 * @generated
	 */
	Check getParentcheck();

	/**
	 * Sets the value of the '{@link parametercheck.Exception#getParentcheck <em>Parentcheck</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parentcheck</em>' container reference.
	 * @see #getParentcheck()
	 * @generated
	 */
	void setParentcheck(Check value);

} // Exception
