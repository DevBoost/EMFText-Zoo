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
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmt.am3.dsls.KM3.Class#getIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link org.eclipse.gmt.am3.dsls.KM3.Class#getSupertypes <em>Supertypes</em>}</li>
 *   <li>{@link org.eclipse.gmt.am3.dsls.KM3.Class#getStructuralFeatures <em>Structural Features</em>}</li>
 *   <li>{@link org.eclipse.gmt.am3.dsls.KM3.Class#getOperations <em>Operations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmt.am3.dsls.KM3.KM3Package#getClass_()
 * @model
 * @generated
 */
public interface Class extends Classifier {
	/**
	 * Returns the value of the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Abstract</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Abstract</em>' attribute.
	 * @see #setIsAbstract(Boolean)
	 * @see org.eclipse.gmt.am3.dsls.KM3.KM3Package#getClass_IsAbstract()
	 * @model unique="false" dataType="org.eclipse.gmt.am3.dsls.PrimitiveTypes.Boolean" required="true" ordered="false"
	 * @generated
	 */
	Boolean getIsAbstract();

	/**
	 * Sets the value of the '{@link org.eclipse.gmt.am3.dsls.KM3.Class#getIsAbstract <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Abstract</em>' attribute.
	 * @see #getIsAbstract()
	 * @generated
	 */
	void setIsAbstract(Boolean value);

	/**
	 * Returns the value of the '<em><b>Supertypes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.gmt.am3.dsls.KM3.Class}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Supertypes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Supertypes</em>' reference list.
	 * @see org.eclipse.gmt.am3.dsls.KM3.KM3Package#getClass_Supertypes()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Class> getSupertypes();

	/**
	 * Returns the value of the '<em><b>Structural Features</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmt.am3.dsls.KM3.StructuralFeature}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmt.am3.dsls.KM3.StructuralFeature#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Structural Features</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Structural Features</em>' containment reference list.
	 * @see org.eclipse.gmt.am3.dsls.KM3.KM3Package#getClass_StructuralFeatures()
	 * @see org.eclipse.gmt.am3.dsls.KM3.StructuralFeature#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<StructuralFeature> getStructuralFeatures();

	/**
	 * Returns the value of the '<em><b>Operations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmt.am3.dsls.KM3.Operation}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmt.am3.dsls.KM3.Operation#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operations</em>' containment reference list.
	 * @see org.eclipse.gmt.am3.dsls.KM3.KM3Package#getClass_Operations()
	 * @see org.eclipse.gmt.am3.dsls.KM3.Operation#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Operation> getOperations();

} // Class
