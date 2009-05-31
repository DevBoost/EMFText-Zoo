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
 * A representation of the model object '<em><b>Structural Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmt.am3.dsls.KM3.StructuralFeature#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.eclipse.gmt.am3.dsls.KM3.StructuralFeature#getSubsetOf <em>Subset Of</em>}</li>
 *   <li>{@link org.eclipse.gmt.am3.dsls.KM3.StructuralFeature#getDerivedFrom <em>Derived From</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmt.am3.dsls.KM3.KM3Package#getStructuralFeature()
 * @model
 * @generated
 */
public interface StructuralFeature extends TypedElement {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmt.am3.dsls.KM3.Class#getStructuralFeatures <em>Structural Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(org.eclipse.gmt.am3.dsls.KM3.Class)
	 * @see org.eclipse.gmt.am3.dsls.KM3.KM3Package#getStructuralFeature_Owner()
	 * @see org.eclipse.gmt.am3.dsls.KM3.Class#getStructuralFeatures
	 * @model opposite="structuralFeatures" required="true" transient="false" ordered="false"
	 * @generated
	 */
	org.eclipse.gmt.am3.dsls.KM3.Class getOwner();

	/**
	 * Sets the value of the '{@link org.eclipse.gmt.am3.dsls.KM3.StructuralFeature#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(org.eclipse.gmt.am3.dsls.KM3.Class value);

	/**
	 * Returns the value of the '<em><b>Subset Of</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.gmt.am3.dsls.KM3.StructuralFeature}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmt.am3.dsls.KM3.StructuralFeature#getDerivedFrom <em>Derived From</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subset Of</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subset Of</em>' reference list.
	 * @see org.eclipse.gmt.am3.dsls.KM3.KM3Package#getStructuralFeature_SubsetOf()
	 * @see org.eclipse.gmt.am3.dsls.KM3.StructuralFeature#getDerivedFrom
	 * @model opposite="derivedFrom" ordered="false"
	 * @generated
	 */
	EList<StructuralFeature> getSubsetOf();

	/**
	 * Returns the value of the '<em><b>Derived From</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.gmt.am3.dsls.KM3.StructuralFeature}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmt.am3.dsls.KM3.StructuralFeature#getSubsetOf <em>Subset Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Derived From</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Derived From</em>' reference list.
	 * @see org.eclipse.gmt.am3.dsls.KM3.KM3Package#getStructuralFeature_DerivedFrom()
	 * @see org.eclipse.gmt.am3.dsls.KM3.StructuralFeature#getSubsetOf
	 * @model opposite="subsetOf" ordered="false"
	 * @generated
	 */
	EList<StructuralFeature> getDerivedFrom();

} // StructuralFeature
