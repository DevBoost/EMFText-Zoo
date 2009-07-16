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
 * A representation of the model object '<em><b>Check</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link parametercheck.Check#getName <em>Name</em>}</li>
 *   <li>{@link parametercheck.Check#getParameterusage <em>Parameterusage</em>}</li>
 *   <li>{@link parametercheck.Check#getException <em>Exception</em>}</li>
 *   <li>{@link parametercheck.Check#isExceptionIfTrue <em>Exception If True</em>}</li>
 *   <li>{@link parametercheck.Check#getParentmethod <em>Parentmethod</em>}</li>
 * </ul>
 * </p>
 *
 * @see parametercheck.ParametercheckPackage#getCheck()
 * @model
 * @generated
 */
public interface Check extends EObject {
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
	 * @see parametercheck.ParametercheckPackage#getCheck_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link parametercheck.Check#getName <em>Name</em>}' attribute.
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
	 * @see parametercheck.ParametercheckPackage#getCheck_Parameterusage()
	 * @model containment="true"
	 * @generated
	 */
	EList<ParameterUsage> getParameterusage();

	/**
	 * Returns the value of the '<em><b>Exception</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link parametercheck.Exception#getParentcheck <em>Parentcheck</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exception</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exception</em>' containment reference.
	 * @see #setException(parametercheck.Exception)
	 * @see parametercheck.ParametercheckPackage#getCheck_Exception()
	 * @see parametercheck.Exception#getParentcheck
	 * @model opposite="parentcheck" containment="true" required="true"
	 * @generated
	 */
	parametercheck.Exception getException();

	/**
	 * Sets the value of the '{@link parametercheck.Check#getException <em>Exception</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exception</em>' containment reference.
	 * @see #getException()
	 * @generated
	 */
	void setException(parametercheck.Exception value);

	/**
	 * Returns the value of the '<em><b>Exception If True</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exception If True</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exception If True</em>' attribute.
	 * @see #setExceptionIfTrue(boolean)
	 * @see parametercheck.ParametercheckPackage#getCheck_ExceptionIfTrue()
	 * @model default="true"
	 * @generated
	 */
	boolean isExceptionIfTrue();

	/**
	 * Sets the value of the '{@link parametercheck.Check#isExceptionIfTrue <em>Exception If True</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exception If True</em>' attribute.
	 * @see #isExceptionIfTrue()
	 * @generated
	 */
	void setExceptionIfTrue(boolean value);

	/**
	 * Returns the value of the '<em><b>Parentmethod</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link parametercheck.Method#getCheck <em>Check</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parentmethod</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parentmethod</em>' container reference.
	 * @see #setParentmethod(Method)
	 * @see parametercheck.ParametercheckPackage#getCheck_Parentmethod()
	 * @see parametercheck.Method#getCheck
	 * @model opposite="check" required="true" transient="false"
	 * @generated
	 */
	Method getParentmethod();

	/**
	 * Sets the value of the '{@link parametercheck.Check#getParentmethod <em>Parentmethod</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parentmethod</em>' container reference.
	 * @see #getParentmethod()
	 * @generated
	 */
	void setParentmethod(Method value);

} // Check
