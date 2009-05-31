/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmt.am3.dsls.KM3;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmt.am3.dsls.KM3.Operation#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.eclipse.gmt.am3.dsls.KM3.Operation#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmt.am3.dsls.KM3.KM3Package#getOperation()
 * @model
 * @generated
 */
public interface Operation extends TypedElement {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmt.am3.dsls.KM3.Class#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(org.eclipse.gmt.am3.dsls.KM3.Class)
	 * @see org.eclipse.gmt.am3.dsls.KM3.KM3Package#getOperation_Owner()
	 * @see org.eclipse.gmt.am3.dsls.KM3.Class#getOperations
	 * @model opposite="operations" required="true" transient="false" ordered="false"
	 * @generated
	 */
	org.eclipse.gmt.am3.dsls.KM3.Class getOwner();

	/**
	 * Sets the value of the '{@link org.eclipse.gmt.am3.dsls.KM3.Operation#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(org.eclipse.gmt.am3.dsls.KM3.Class value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmt.am3.dsls.KM3.Parameter}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmt.am3.dsls.KM3.Parameter#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see org.eclipse.gmt.am3.dsls.KM3.KM3Package#getOperation_Parameters()
	 * @see org.eclipse.gmt.am3.dsls.KM3.Parameter#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Parameter> getParameters();

} // Operation
