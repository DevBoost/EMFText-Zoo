/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.pl0;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.emftext.language.pl0.PL0Package
 * @generated
 */
public interface PL0Factory extends EFactory {
	/**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	PL0Factory eINSTANCE = org.emftext.language.pl0.impl.PL0FactoryImpl.init();

	/**
   * Returns a new object of class '<em>Program</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Program</em>'.
   * @generated
   */
	Program createProgram();

	/**
   * Returns a new object of class '<em>Block</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Block</em>'.
   * @generated
   */
	Block createBlock();

	/**
   * Returns a new object of class '<em>Var Declaration</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Var Declaration</em>'.
   * @generated
   */
	VarDeclaration createVarDeclaration();

	/**
   * Returns a new object of class '<em>Const Declaration</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Const Declaration</em>'.
   * @generated
   */
	ConstDeclaration createConstDeclaration();

	/**
   * Returns a new object of class '<em>Procedure Declaration</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Procedure Declaration</em>'.
   * @generated
   */
	ProcedureDeclaration createProcedureDeclaration();

	/**
   * Returns a new object of class '<em>Call Statement</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Call Statement</em>'.
   * @generated
   */
	CallStatement createCallStatement();

	/**
   * Returns a new object of class '<em>If Statement</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>If Statement</em>'.
   * @generated
   */
	IfStatement createIfStatement();

	/**
   * Returns a new object of class '<em>While Statement</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>While Statement</em>'.
   * @generated
   */
	WhileStatement createWhileStatement();

	/**
   * Returns a new object of class '<em>Assignment</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Assignment</em>'.
   * @generated
   */
	Assignment createAssignment();

	/**
   * Returns a new object of class '<em>Odd Condition</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Odd Condition</em>'.
   * @generated
   */
	OddCondition createOddCondition();

	/**
   * Returns a new object of class '<em>Relational Condition</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Relational Condition</em>'.
   * @generated
   */
	RelationalCondition createRelationalCondition();

	/**
   * Returns a new object of class '<em>Term Expression</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Term Expression</em>'.
   * @generated
   */
	TermExpression createTermExpression();

	/**
   * Returns a new object of class '<em>Term</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Term</em>'.
   * @generated
   */
	Term createTerm();

	/**
   * Returns a new object of class '<em>Optional Term</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Optional Term</em>'.
   * @generated
   */
	OptionalTerm createOptionalTerm();

	/**
   * Returns a new object of class '<em>Optional Factor</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Optional Factor</em>'.
   * @generated
   */
	OptionalFactor createOptionalFactor();

	/**
   * Returns a new object of class '<em>Ident Reference</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Ident Reference</em>'.
   * @generated
   */
	IdentReference createIdentReference();

	/**
   * Returns a new object of class '<em>Number</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Number</em>'.
   * @generated
   */
	Number createNumber();

	/**
   * Returns a new object of class '<em>Expression Factor</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression Factor</em>'.
   * @generated
   */
	ExpressionFactor createExpressionFactor();

	/**
   * Returns a new object of class '<em>Body</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Body</em>'.
   * @generated
   */
	Body createBody();

	/**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
	PL0Package getPL0Package();

} //PL0Factory
