/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.java.closures;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.emftext.language.java.closures.ClosuresPackage
 * @generated
 */
public interface ClosuresFactory extends EFactory {
	/**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	ClosuresFactory eINSTANCE = org.emftext.language.java.closures.impl.ClosuresFactoryImpl.init();

	/**
   * Returns a new object of class '<em>Closure</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Closure</em>'.
   * @generated
   */
	Closure createClosure();

	/**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
	ClosuresPackage getClosuresPackage();

} //ClosuresFactory
