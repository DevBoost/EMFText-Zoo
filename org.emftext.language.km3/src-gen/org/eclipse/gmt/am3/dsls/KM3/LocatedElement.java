/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmt.am3.dsls.KM3;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Located Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmt.am3.dsls.KM3.LocatedElement#getLocation <em>Location</em>}</li>
 *   <li>{@link org.eclipse.gmt.am3.dsls.KM3.LocatedElement#getCommentsBefore <em>Comments Before</em>}</li>
 *   <li>{@link org.eclipse.gmt.am3.dsls.KM3.LocatedElement#getCommentsAfter <em>Comments After</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmt.am3.dsls.KM3.KM3Package#getLocatedElement()
 * @model abstract="true"
 * @generated
 */
public interface LocatedElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see #setLocation(String)
	 * @see org.eclipse.gmt.am3.dsls.KM3.KM3Package#getLocatedElement_Location()
	 * @model unique="false" dataType="org.eclipse.gmt.am3.dsls.PrimitiveTypes.String" required="true" ordered="false"
	 * @generated
	 */
	String getLocation();

	/**
	 * Sets the value of the '{@link org.eclipse.gmt.am3.dsls.KM3.LocatedElement#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' attribute.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(String value);

	/**
	 * Returns the value of the '<em><b>Comments Before</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comments Before</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comments Before</em>' attribute list.
	 * @see org.eclipse.gmt.am3.dsls.KM3.KM3Package#getLocatedElement_CommentsBefore()
	 * @model unique="false" dataType="org.eclipse.gmt.am3.dsls.PrimitiveTypes.String"
	 * @generated
	 */
	EList<String> getCommentsBefore();

	/**
	 * Returns the value of the '<em><b>Comments After</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comments After</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comments After</em>' attribute list.
	 * @see org.eclipse.gmt.am3.dsls.KM3.KM3Package#getLocatedElement_CommentsAfter()
	 * @model unique="false" dataType="org.eclipse.gmt.am3.dsls.PrimitiveTypes.String"
	 * @generated
	 */
	EList<String> getCommentsAfter();

} // LocatedElement
