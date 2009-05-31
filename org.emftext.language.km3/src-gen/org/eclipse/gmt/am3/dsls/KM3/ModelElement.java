/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmt.am3.dsls.KM3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmt.am3.dsls.KM3.ModelElement#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.gmt.am3.dsls.KM3.ModelElement#getPackage <em>Package</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmt.am3.dsls.KM3.KM3Package#getModelElement()
 * @model abstract="true"
 * @generated
 */
public interface ModelElement extends LocatedElement {
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
	 * @see org.eclipse.gmt.am3.dsls.KM3.KM3Package#getModelElement_Name()
	 * @model unique="false" dataType="org.eclipse.gmt.am3.dsls.PrimitiveTypes.String" required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.gmt.am3.dsls.KM3.ModelElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Package</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmt.am3.dsls.KM3.Package#getContents <em>Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package</em>' container reference.
	 * @see #setPackage(org.eclipse.gmt.am3.dsls.KM3.Package)
	 * @see org.eclipse.gmt.am3.dsls.KM3.KM3Package#getModelElement_Package()
	 * @see org.eclipse.gmt.am3.dsls.KM3.Package#getContents
	 * @model opposite="contents" required="true" transient="false" ordered="false"
	 * @generated
	 */
	org.eclipse.gmt.am3.dsls.KM3.Package getPackage();

	/**
	 * Sets the value of the '{@link org.eclipse.gmt.am3.dsls.KM3.ModelElement#getPackage <em>Package</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package</em>' container reference.
	 * @see #getPackage()
	 * @generated
	 */
	void setPackage(org.eclipse.gmt.am3.dsls.KM3.Package value);

} // ModelElement
