/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmt.am3.dsls.KM3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typed Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmt.am3.dsls.KM3.TypedElement#getLower <em>Lower</em>}</li>
 *   <li>{@link org.eclipse.gmt.am3.dsls.KM3.TypedElement#getUpper <em>Upper</em>}</li>
 *   <li>{@link org.eclipse.gmt.am3.dsls.KM3.TypedElement#getIsOrdered <em>Is Ordered</em>}</li>
 *   <li>{@link org.eclipse.gmt.am3.dsls.KM3.TypedElement#getIsUnique <em>Is Unique</em>}</li>
 *   <li>{@link org.eclipse.gmt.am3.dsls.KM3.TypedElement#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmt.am3.dsls.KM3.KM3Package#getTypedElement()
 * @model
 * @generated
 */
public interface TypedElement extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower</em>' attribute.
	 * @see #setLower(Integer)
	 * @see org.eclipse.gmt.am3.dsls.KM3.KM3Package#getTypedElement_Lower()
	 * @model unique="false" dataType="org.eclipse.gmt.am3.dsls.PrimitiveTypes.Integer" required="true" ordered="false"
	 * @generated
	 */
	Integer getLower();

	/**
	 * Sets the value of the '{@link org.eclipse.gmt.am3.dsls.KM3.TypedElement#getLower <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower</em>' attribute.
	 * @see #getLower()
	 * @generated
	 */
	void setLower(Integer value);

	/**
	 * Returns the value of the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper</em>' attribute.
	 * @see #setUpper(Integer)
	 * @see org.eclipse.gmt.am3.dsls.KM3.KM3Package#getTypedElement_Upper()
	 * @model unique="false" dataType="org.eclipse.gmt.am3.dsls.PrimitiveTypes.Integer" required="true" ordered="false"
	 * @generated
	 */
	Integer getUpper();

	/**
	 * Sets the value of the '{@link org.eclipse.gmt.am3.dsls.KM3.TypedElement#getUpper <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper</em>' attribute.
	 * @see #getUpper()
	 * @generated
	 */
	void setUpper(Integer value);

	/**
	 * Returns the value of the '<em><b>Is Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Ordered</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Ordered</em>' attribute.
	 * @see #setIsOrdered(Boolean)
	 * @see org.eclipse.gmt.am3.dsls.KM3.KM3Package#getTypedElement_IsOrdered()
	 * @model unique="false" dataType="org.eclipse.gmt.am3.dsls.PrimitiveTypes.Boolean" required="true" ordered="false"
	 * @generated
	 */
	Boolean getIsOrdered();

	/**
	 * Sets the value of the '{@link org.eclipse.gmt.am3.dsls.KM3.TypedElement#getIsOrdered <em>Is Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Ordered</em>' attribute.
	 * @see #getIsOrdered()
	 * @generated
	 */
	void setIsOrdered(Boolean value);

	/**
	 * Returns the value of the '<em><b>Is Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Unique</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Unique</em>' attribute.
	 * @see #setIsUnique(Boolean)
	 * @see org.eclipse.gmt.am3.dsls.KM3.KM3Package#getTypedElement_IsUnique()
	 * @model unique="false" dataType="org.eclipse.gmt.am3.dsls.PrimitiveTypes.Boolean" required="true" ordered="false"
	 * @generated
	 */
	Boolean getIsUnique();

	/**
	 * Sets the value of the '{@link org.eclipse.gmt.am3.dsls.KM3.TypedElement#getIsUnique <em>Is Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Unique</em>' attribute.
	 * @see #getIsUnique()
	 * @generated
	 */
	void setIsUnique(Boolean value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(Classifier)
	 * @see org.eclipse.gmt.am3.dsls.KM3.KM3Package#getTypedElement_Type()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Classifier getType();

	/**
	 * Sets the value of the '{@link org.eclipse.gmt.am3.dsls.KM3.TypedElement#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Classifier value);

} // TypedElement
