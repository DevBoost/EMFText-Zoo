/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package parametercheck;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Declared Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link parametercheck.DeclaredParameter#getParameter <em>Parameter</em>}</li>
 *   <li>{@link parametercheck.DeclaredParameter#getAsString <em>As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see parametercheck.ParametercheckPackage#getDeclaredParameter()
 * @model
 * @generated
 */
public interface DeclaredParameter extends ParameterUsage
{
  /**
   * Returns the value of the '<em><b>Parameter</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameter</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameter</em>' reference.
   * @see #setParameter(ParameterDecl)
   * @see parametercheck.ParametercheckPackage#getDeclaredParameter_Parameter()
   * @model required="true"
   * @generated
   */
  ParameterDecl getParameter();

  /**
   * Sets the value of the '{@link parametercheck.DeclaredParameter#getParameter <em>Parameter</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parameter</em>' reference.
   * @see #getParameter()
   * @generated
   */
  void setParameter(ParameterDecl value);

  /**
   * Returns the value of the '<em><b>As String</b></em>' attribute.
   * The default value is <code>""</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>As String</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>As String</em>' attribute.
   * @see #setAsString(String)
   * @see parametercheck.ParametercheckPackage#getDeclaredParameter_AsString()
   * @model default=""
   * @generated
   */
  String getAsString();

  /**
   * Sets the value of the '{@link parametercheck.DeclaredParameter#getAsString <em>As String</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>As String</em>' attribute.
   * @see #getAsString()
   * @generated
   */
  void setAsString(String value);

} // DeclaredParameter
