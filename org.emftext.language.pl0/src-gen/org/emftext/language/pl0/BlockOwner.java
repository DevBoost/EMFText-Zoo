/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.pl0;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Block Owner</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.pl0.BlockOwner#getBlock <em>Block</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.pl0.PL0Package#getBlockOwner()
 * @model abstract="true"
 * @generated
 */
public interface BlockOwner extends EObject {
	/**
   * Returns the value of the '<em><b>Block</b></em>' containment reference.
   * It is bidirectional and its opposite is '{@link org.emftext.language.pl0.Block#getOwner <em>Owner</em>}'.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Block</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Block</em>' containment reference.
   * @see #setBlock(Block)
   * @see org.emftext.language.pl0.PL0Package#getBlockOwner_Block()
   * @see org.emftext.language.pl0.Block#getOwner
   * @model opposite="owner" containment="true" required="true"
   * @generated
   */
	Block getBlock();

	/**
   * Sets the value of the '{@link org.emftext.language.pl0.BlockOwner#getBlock <em>Block</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Block</em>' containment reference.
   * @see #getBlock()
   * @generated
   */
	void setBlock(Block value);

} // BlockOwner
