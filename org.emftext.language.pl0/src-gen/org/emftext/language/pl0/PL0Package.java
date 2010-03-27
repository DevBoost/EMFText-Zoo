/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.pl0;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.emftext.language.pl0.PL0Factory
 * @model kind="package"
 * @generated
 */
public interface PL0Package extends EPackage {
	/**
   * The package name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNAME = "pl0";

	/**
   * The package namespace URI.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNS_URI = "http://www.emftext.org/language/pl0";

	/**
   * The package namespace name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNS_PREFIX = "pl0";

	/**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	PL0Package eINSTANCE = org.emftext.language.pl0.impl.PL0PackageImpl.init();

	/**
   * The meta object id for the '{@link org.emftext.language.pl0.impl.BlockOwnerImpl <em>Block Owner</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.pl0.impl.BlockOwnerImpl
   * @see org.emftext.language.pl0.impl.PL0PackageImpl#getBlockOwner()
   * @generated
   */
	int BLOCK_OWNER = 24;

	/**
   * The feature id for the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BLOCK_OWNER__BLOCK = 0;

	/**
   * The number of structural features of the '<em>Block Owner</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BLOCK_OWNER_FEATURE_COUNT = 1;

	/**
   * The meta object id for the '{@link org.emftext.language.pl0.impl.ProgramImpl <em>Program</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.pl0.impl.ProgramImpl
   * @see org.emftext.language.pl0.impl.PL0PackageImpl#getProgram()
   * @generated
   */
	int PROGRAM = 0;

	/**
   * The feature id for the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int PROGRAM__BLOCK = BLOCK_OWNER__BLOCK;

	/**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int PROGRAM__NAME = BLOCK_OWNER_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>Program</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int PROGRAM_FEATURE_COUNT = BLOCK_OWNER_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.pl0.impl.BlockImpl <em>Block</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.pl0.impl.BlockImpl
   * @see org.emftext.language.pl0.impl.PL0PackageImpl#getBlock()
   * @generated
   */
	int BLOCK = 1;

	/**
   * The feature id for the '<em><b>Variables</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BLOCK__VARIABLES = 0;

	/**
   * The feature id for the '<em><b>Constants</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BLOCK__CONSTANTS = 1;

	/**
   * The feature id for the '<em><b>Procedures</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BLOCK__PROCEDURES = 2;

	/**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BLOCK__BODY = 3;

	/**
   * The feature id for the '<em><b>Owner</b></em>' container reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BLOCK__OWNER = 4;

	/**
   * The feature id for the '<em><b>All Owners</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BLOCK__ALL_OWNERS = 5;

	/**
   * The number of structural features of the '<em>Block</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BLOCK_FEATURE_COUNT = 6;

	/**
   * The meta object id for the '{@link org.emftext.language.pl0.impl.DeclarationImpl <em>Declaration</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.pl0.impl.DeclarationImpl
   * @see org.emftext.language.pl0.impl.PL0PackageImpl#getDeclaration()
   * @generated
   */
	int DECLARATION = 5;

	/**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int DECLARATION__NAME = 0;

	/**
   * The number of structural features of the '<em>Declaration</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int DECLARATION_FEATURE_COUNT = 1;

	/**
   * The meta object id for the '{@link org.emftext.language.pl0.impl.VarDeclarationImpl <em>Var Declaration</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.pl0.impl.VarDeclarationImpl
   * @see org.emftext.language.pl0.impl.PL0PackageImpl#getVarDeclaration()
   * @generated
   */
	int VAR_DECLARATION = 2;

	/**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int VAR_DECLARATION__NAME = DECLARATION__NAME;

	/**
   * The number of structural features of the '<em>Var Declaration</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int VAR_DECLARATION_FEATURE_COUNT = DECLARATION_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.pl0.impl.ConstDeclarationImpl <em>Const Declaration</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.pl0.impl.ConstDeclarationImpl
   * @see org.emftext.language.pl0.impl.PL0PackageImpl#getConstDeclaration()
   * @generated
   */
	int CONST_DECLARATION = 3;

	/**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CONST_DECLARATION__NAME = DECLARATION__NAME;

	/**
   * The feature id for the '<em><b>Number</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CONST_DECLARATION__NUMBER = DECLARATION_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>Const Declaration</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CONST_DECLARATION_FEATURE_COUNT = DECLARATION_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.pl0.impl.ProcedureDeclarationImpl <em>Procedure Declaration</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.pl0.impl.ProcedureDeclarationImpl
   * @see org.emftext.language.pl0.impl.PL0PackageImpl#getProcedureDeclaration()
   * @generated
   */
	int PROCEDURE_DECLARATION = 4;

	/**
   * The feature id for the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int PROCEDURE_DECLARATION__BLOCK = BLOCK_OWNER__BLOCK;

	/**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int PROCEDURE_DECLARATION__NAME = BLOCK_OWNER_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>Procedure Declaration</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int PROCEDURE_DECLARATION_FEATURE_COUNT = BLOCK_OWNER_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.pl0.impl.StatementImpl <em>Statement</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.pl0.impl.StatementImpl
   * @see org.emftext.language.pl0.impl.PL0PackageImpl#getStatement()
   * @generated
   */
	int STATEMENT = 6;

	/**
   * The number of structural features of the '<em>Statement</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int STATEMENT_FEATURE_COUNT = 0;

	/**
   * The meta object id for the '{@link org.emftext.language.pl0.impl.CallStatementImpl <em>Call Statement</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.pl0.impl.CallStatementImpl
   * @see org.emftext.language.pl0.impl.PL0PackageImpl#getCallStatement()
   * @generated
   */
	int CALL_STATEMENT = 7;

	/**
   * The feature id for the '<em><b>Procedure</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CALL_STATEMENT__PROCEDURE = STATEMENT_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>Call Statement</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CALL_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.pl0.impl.IfStatementImpl <em>If Statement</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.pl0.impl.IfStatementImpl
   * @see org.emftext.language.pl0.impl.PL0PackageImpl#getIfStatement()
   * @generated
   */
	int IF_STATEMENT = 8;

	/**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int IF_STATEMENT__CONDITION = STATEMENT_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Then</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int IF_STATEMENT__THEN = STATEMENT_FEATURE_COUNT + 1;

	/**
   * The feature id for the '<em><b>Else</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int IF_STATEMENT__ELSE = STATEMENT_FEATURE_COUNT + 2;

	/**
   * The number of structural features of the '<em>If Statement</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int IF_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 3;

	/**
   * The meta object id for the '{@link org.emftext.language.pl0.impl.ConditionImpl <em>Condition</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.pl0.impl.ConditionImpl
   * @see org.emftext.language.pl0.impl.PL0PackageImpl#getCondition()
   * @generated
   */
	int CONDITION = 9;

	/**
   * The number of structural features of the '<em>Condition</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CONDITION_FEATURE_COUNT = 0;

	/**
   * The meta object id for the '{@link org.emftext.language.pl0.impl.WhileStatementImpl <em>While Statement</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.pl0.impl.WhileStatementImpl
   * @see org.emftext.language.pl0.impl.PL0PackageImpl#getWhileStatement()
   * @generated
   */
	int WHILE_STATEMENT = 10;

	/**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int WHILE_STATEMENT__CONDITION = STATEMENT_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Do</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int WHILE_STATEMENT__DO = STATEMENT_FEATURE_COUNT + 1;

	/**
   * The number of structural features of the '<em>While Statement</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int WHILE_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

	/**
   * The meta object id for the '{@link org.emftext.language.pl0.impl.AssignmentImpl <em>Assignment</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.pl0.impl.AssignmentImpl
   * @see org.emftext.language.pl0.impl.PL0PackageImpl#getAssignment()
   * @generated
   */
	int ASSIGNMENT = 11;

	/**
   * The feature id for the '<em><b>Left</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ASSIGNMENT__LEFT = STATEMENT_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ASSIGNMENT__RIGHT = STATEMENT_FEATURE_COUNT + 1;

	/**
   * The number of structural features of the '<em>Assignment</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ASSIGNMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

	/**
   * The meta object id for the '{@link org.emftext.language.pl0.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.pl0.impl.ExpressionImpl
   * @see org.emftext.language.pl0.impl.PL0PackageImpl#getExpression()
   * @generated
   */
	int EXPRESSION = 12;

	/**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int EXPRESSION_FEATURE_COUNT = 0;

	/**
   * The meta object id for the '{@link org.emftext.language.pl0.impl.OddConditionImpl <em>Odd Condition</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.pl0.impl.OddConditionImpl
   * @see org.emftext.language.pl0.impl.PL0PackageImpl#getOddCondition()
   * @generated
   */
	int ODD_CONDITION = 13;

	/**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ODD_CONDITION__EXPRESSION = CONDITION_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>Odd Condition</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ODD_CONDITION_FEATURE_COUNT = CONDITION_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.pl0.impl.RelationalConditionImpl <em>Relational Condition</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.pl0.impl.RelationalConditionImpl
   * @see org.emftext.language.pl0.impl.PL0PackageImpl#getRelationalCondition()
   * @generated
   */
	int RELATIONAL_CONDITION = 14;

	/**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int RELATIONAL_CONDITION__LEFT = CONDITION_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int RELATIONAL_CONDITION__RIGHT = CONDITION_FEATURE_COUNT + 1;

	/**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int RELATIONAL_CONDITION__OP = CONDITION_FEATURE_COUNT + 2;

	/**
   * The number of structural features of the '<em>Relational Condition</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int RELATIONAL_CONDITION_FEATURE_COUNT = CONDITION_FEATURE_COUNT + 3;

	/**
   * The meta object id for the '{@link org.emftext.language.pl0.impl.TermExpressionImpl <em>Term Expression</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.pl0.impl.TermExpressionImpl
   * @see org.emftext.language.pl0.impl.PL0PackageImpl#getTermExpression()
   * @generated
   */
	int TERM_EXPRESSION = 15;

	/**
   * The feature id for the '<em><b>Obligatory</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int TERM_EXPRESSION__OBLIGATORY = EXPRESSION_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Optional</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int TERM_EXPRESSION__OPTIONAL = EXPRESSION_FEATURE_COUNT + 1;

	/**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int TERM_EXPRESSION__OP = EXPRESSION_FEATURE_COUNT + 2;

	/**
   * The number of structural features of the '<em>Term Expression</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int TERM_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

	/**
   * The meta object id for the '{@link org.emftext.language.pl0.impl.TermImpl <em>Term</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.pl0.impl.TermImpl
   * @see org.emftext.language.pl0.impl.PL0PackageImpl#getTerm()
   * @generated
   */
	int TERM = 16;

	/**
   * The feature id for the '<em><b>Obligatory</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int TERM__OBLIGATORY = 0;

	/**
   * The feature id for the '<em><b>Optional</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int TERM__OPTIONAL = 1;

	/**
   * The number of structural features of the '<em>Term</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int TERM_FEATURE_COUNT = 2;

	/**
   * The meta object id for the '{@link org.emftext.language.pl0.impl.OptionalTermImpl <em>Optional Term</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.pl0.impl.OptionalTermImpl
   * @see org.emftext.language.pl0.impl.PL0PackageImpl#getOptionalTerm()
   * @generated
   */
	int OPTIONAL_TERM = 17;

	/**
   * The feature id for the '<em><b>Term</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int OPTIONAL_TERM__TERM = 0;

	/**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int OPTIONAL_TERM__OP = 1;

	/**
   * The number of structural features of the '<em>Optional Term</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int OPTIONAL_TERM_FEATURE_COUNT = 2;

	/**
   * The meta object id for the '{@link org.emftext.language.pl0.impl.FactorImpl <em>Factor</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.pl0.impl.FactorImpl
   * @see org.emftext.language.pl0.impl.PL0PackageImpl#getFactor()
   * @generated
   */
	int FACTOR = 18;

	/**
   * The number of structural features of the '<em>Factor</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int FACTOR_FEATURE_COUNT = 0;

	/**
   * The meta object id for the '{@link org.emftext.language.pl0.impl.OptionalFactorImpl <em>Optional Factor</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.pl0.impl.OptionalFactorImpl
   * @see org.emftext.language.pl0.impl.PL0PackageImpl#getOptionalFactor()
   * @generated
   */
	int OPTIONAL_FACTOR = 19;

	/**
   * The feature id for the '<em><b>Factor</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int OPTIONAL_FACTOR__FACTOR = 0;

	/**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int OPTIONAL_FACTOR__OP = 1;

	/**
   * The number of structural features of the '<em>Optional Factor</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int OPTIONAL_FACTOR_FEATURE_COUNT = 2;

	/**
   * The meta object id for the '{@link org.emftext.language.pl0.impl.IdentReferenceImpl <em>Ident Reference</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.pl0.impl.IdentReferenceImpl
   * @see org.emftext.language.pl0.impl.PL0PackageImpl#getIdentReference()
   * @generated
   */
	int IDENT_REFERENCE = 20;

	/**
   * The feature id for the '<em><b>Ident</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int IDENT_REFERENCE__IDENT = FACTOR_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>Ident Reference</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int IDENT_REFERENCE_FEATURE_COUNT = FACTOR_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.pl0.impl.NumberImpl <em>Number</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.pl0.impl.NumberImpl
   * @see org.emftext.language.pl0.impl.PL0PackageImpl#getNumber()
   * @generated
   */
	int NUMBER = 21;

	/**
   * The feature id for the '<em><b>Number</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int NUMBER__NUMBER = FACTOR_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>Number</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int NUMBER_FEATURE_COUNT = FACTOR_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.pl0.impl.ExpressionFactorImpl <em>Expression Factor</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.pl0.impl.ExpressionFactorImpl
   * @see org.emftext.language.pl0.impl.PL0PackageImpl#getExpressionFactor()
   * @generated
   */
	int EXPRESSION_FACTOR = 22;

	/**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int EXPRESSION_FACTOR__EXPRESSION = FACTOR_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>Expression Factor</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int EXPRESSION_FACTOR_FEATURE_COUNT = FACTOR_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.pl0.impl.BodyImpl <em>Body</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.pl0.impl.BodyImpl
   * @see org.emftext.language.pl0.impl.PL0PackageImpl#getBody()
   * @generated
   */
	int BODY = 23;

	/**
   * The feature id for the '<em><b>Statements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BODY__STATEMENTS = 0;

	/**
   * The number of structural features of the '<em>Body</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BODY_FEATURE_COUNT = 1;

	/**
   * The meta object id for the '{@link org.emftext.language.pl0.PlusMinusOperator <em>Plus Minus Operator</em>}' enum.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.pl0.PlusMinusOperator
   * @see org.emftext.language.pl0.impl.PL0PackageImpl#getPlusMinusOperator()
   * @generated
   */
	int PLUS_MINUS_OPERATOR = 25;

	/**
   * The meta object id for the '{@link org.emftext.language.pl0.MulDivOperator <em>Mul Div Operator</em>}' enum.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.pl0.MulDivOperator
   * @see org.emftext.language.pl0.impl.PL0PackageImpl#getMulDivOperator()
   * @generated
   */
	int MUL_DIV_OPERATOR = 26;

	/**
   * The meta object id for the '{@link org.emftext.language.pl0.RelationalOperator <em>Relational Operator</em>}' enum.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.pl0.RelationalOperator
   * @see org.emftext.language.pl0.impl.PL0PackageImpl#getRelationalOperator()
   * @generated
   */
	int RELATIONAL_OPERATOR = 27;


	/**
   * Returns the meta object for class '{@link org.emftext.language.pl0.Program <em>Program</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Program</em>'.
   * @see org.emftext.language.pl0.Program
   * @generated
   */
	EClass getProgram();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.language.pl0.Program#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.emftext.language.pl0.Program#getName()
   * @see #getProgram()
   * @generated
   */
	EAttribute getProgram_Name();

	/**
   * Returns the meta object for class '{@link org.emftext.language.pl0.Block <em>Block</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Block</em>'.
   * @see org.emftext.language.pl0.Block
   * @generated
   */
	EClass getBlock();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.pl0.Block#getVariables <em>Variables</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Variables</em>'.
   * @see org.emftext.language.pl0.Block#getVariables()
   * @see #getBlock()
   * @generated
   */
	EReference getBlock_Variables();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.pl0.Block#getConstants <em>Constants</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Constants</em>'.
   * @see org.emftext.language.pl0.Block#getConstants()
   * @see #getBlock()
   * @generated
   */
	EReference getBlock_Constants();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.pl0.Block#getProcedures <em>Procedures</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Procedures</em>'.
   * @see org.emftext.language.pl0.Block#getProcedures()
   * @see #getBlock()
   * @generated
   */
	EReference getBlock_Procedures();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.pl0.Block#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see org.emftext.language.pl0.Block#getBody()
   * @see #getBlock()
   * @generated
   */
	EReference getBlock_Body();

	/**
   * Returns the meta object for the container reference '{@link org.emftext.language.pl0.Block#getOwner <em>Owner</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Owner</em>'.
   * @see org.emftext.language.pl0.Block#getOwner()
   * @see #getBlock()
   * @generated
   */
	EReference getBlock_Owner();

	/**
   * Returns the meta object for the reference list '{@link org.emftext.language.pl0.Block#getAllOwners <em>All Owners</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>All Owners</em>'.
   * @see org.emftext.language.pl0.Block#getAllOwners()
   * @see #getBlock()
   * @generated
   */
	EReference getBlock_AllOwners();

	/**
   * Returns the meta object for class '{@link org.emftext.language.pl0.VarDeclaration <em>Var Declaration</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Var Declaration</em>'.
   * @see org.emftext.language.pl0.VarDeclaration
   * @generated
   */
	EClass getVarDeclaration();

	/**
   * Returns the meta object for class '{@link org.emftext.language.pl0.ConstDeclaration <em>Const Declaration</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Const Declaration</em>'.
   * @see org.emftext.language.pl0.ConstDeclaration
   * @generated
   */
	EClass getConstDeclaration();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.language.pl0.ConstDeclaration#getNumber <em>Number</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Number</em>'.
   * @see org.emftext.language.pl0.ConstDeclaration#getNumber()
   * @see #getConstDeclaration()
   * @generated
   */
	EAttribute getConstDeclaration_Number();

	/**
   * Returns the meta object for class '{@link org.emftext.language.pl0.ProcedureDeclaration <em>Procedure Declaration</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Procedure Declaration</em>'.
   * @see org.emftext.language.pl0.ProcedureDeclaration
   * @generated
   */
	EClass getProcedureDeclaration();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.language.pl0.ProcedureDeclaration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.emftext.language.pl0.ProcedureDeclaration#getName()
   * @see #getProcedureDeclaration()
   * @generated
   */
	EAttribute getProcedureDeclaration_Name();

	/**
   * Returns the meta object for class '{@link org.emftext.language.pl0.Declaration <em>Declaration</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Declaration</em>'.
   * @see org.emftext.language.pl0.Declaration
   * @generated
   */
	EClass getDeclaration();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.language.pl0.Declaration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.emftext.language.pl0.Declaration#getName()
   * @see #getDeclaration()
   * @generated
   */
	EAttribute getDeclaration_Name();

	/**
   * Returns the meta object for class '{@link org.emftext.language.pl0.Statement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Statement</em>'.
   * @see org.emftext.language.pl0.Statement
   * @generated
   */
	EClass getStatement();

	/**
   * Returns the meta object for class '{@link org.emftext.language.pl0.CallStatement <em>Call Statement</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Call Statement</em>'.
   * @see org.emftext.language.pl0.CallStatement
   * @generated
   */
	EClass getCallStatement();

	/**
   * Returns the meta object for the reference '{@link org.emftext.language.pl0.CallStatement#getProcedure <em>Procedure</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Procedure</em>'.
   * @see org.emftext.language.pl0.CallStatement#getProcedure()
   * @see #getCallStatement()
   * @generated
   */
	EReference getCallStatement_Procedure();

	/**
   * Returns the meta object for class '{@link org.emftext.language.pl0.IfStatement <em>If Statement</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>If Statement</em>'.
   * @see org.emftext.language.pl0.IfStatement
   * @generated
   */
	EClass getIfStatement();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.pl0.IfStatement#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see org.emftext.language.pl0.IfStatement#getCondition()
   * @see #getIfStatement()
   * @generated
   */
	EReference getIfStatement_Condition();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.pl0.IfStatement#getThen <em>Then</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Then</em>'.
   * @see org.emftext.language.pl0.IfStatement#getThen()
   * @see #getIfStatement()
   * @generated
   */
	EReference getIfStatement_Then();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.pl0.IfStatement#getElse <em>Else</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Else</em>'.
   * @see org.emftext.language.pl0.IfStatement#getElse()
   * @see #getIfStatement()
   * @generated
   */
	EReference getIfStatement_Else();

	/**
   * Returns the meta object for class '{@link org.emftext.language.pl0.Condition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Condition</em>'.
   * @see org.emftext.language.pl0.Condition
   * @generated
   */
	EClass getCondition();

	/**
   * Returns the meta object for class '{@link org.emftext.language.pl0.WhileStatement <em>While Statement</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>While Statement</em>'.
   * @see org.emftext.language.pl0.WhileStatement
   * @generated
   */
	EClass getWhileStatement();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.pl0.WhileStatement#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see org.emftext.language.pl0.WhileStatement#getCondition()
   * @see #getWhileStatement()
   * @generated
   */
	EReference getWhileStatement_Condition();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.pl0.WhileStatement#getDo <em>Do</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Do</em>'.
   * @see org.emftext.language.pl0.WhileStatement#getDo()
   * @see #getWhileStatement()
   * @generated
   */
	EReference getWhileStatement_Do();

	/**
   * Returns the meta object for class '{@link org.emftext.language.pl0.Assignment <em>Assignment</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assignment</em>'.
   * @see org.emftext.language.pl0.Assignment
   * @generated
   */
	EClass getAssignment();

	/**
   * Returns the meta object for the reference '{@link org.emftext.language.pl0.Assignment#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Left</em>'.
   * @see org.emftext.language.pl0.Assignment#getLeft()
   * @see #getAssignment()
   * @generated
   */
	EReference getAssignment_Left();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.pl0.Assignment#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.emftext.language.pl0.Assignment#getRight()
   * @see #getAssignment()
   * @generated
   */
	EReference getAssignment_Right();

	/**
   * Returns the meta object for class '{@link org.emftext.language.pl0.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see org.emftext.language.pl0.Expression
   * @generated
   */
	EClass getExpression();

	/**
   * Returns the meta object for class '{@link org.emftext.language.pl0.OddCondition <em>Odd Condition</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Odd Condition</em>'.
   * @see org.emftext.language.pl0.OddCondition
   * @generated
   */
	EClass getOddCondition();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.pl0.OddCondition#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.emftext.language.pl0.OddCondition#getExpression()
   * @see #getOddCondition()
   * @generated
   */
	EReference getOddCondition_Expression();

	/**
   * Returns the meta object for class '{@link org.emftext.language.pl0.RelationalCondition <em>Relational Condition</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Relational Condition</em>'.
   * @see org.emftext.language.pl0.RelationalCondition
   * @generated
   */
	EClass getRelationalCondition();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.pl0.RelationalCondition#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.emftext.language.pl0.RelationalCondition#getLeft()
   * @see #getRelationalCondition()
   * @generated
   */
	EReference getRelationalCondition_Left();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.pl0.RelationalCondition#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.emftext.language.pl0.RelationalCondition#getRight()
   * @see #getRelationalCondition()
   * @generated
   */
	EReference getRelationalCondition_Right();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.language.pl0.RelationalCondition#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see org.emftext.language.pl0.RelationalCondition#getOp()
   * @see #getRelationalCondition()
   * @generated
   */
	EAttribute getRelationalCondition_Op();

	/**
   * Returns the meta object for class '{@link org.emftext.language.pl0.TermExpression <em>Term Expression</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Term Expression</em>'.
   * @see org.emftext.language.pl0.TermExpression
   * @generated
   */
	EClass getTermExpression();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.pl0.TermExpression#getObligatory <em>Obligatory</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Obligatory</em>'.
   * @see org.emftext.language.pl0.TermExpression#getObligatory()
   * @see #getTermExpression()
   * @generated
   */
	EReference getTermExpression_Obligatory();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.pl0.TermExpression#getOptional <em>Optional</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Optional</em>'.
   * @see org.emftext.language.pl0.TermExpression#getOptional()
   * @see #getTermExpression()
   * @generated
   */
	EReference getTermExpression_Optional();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.language.pl0.TermExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see org.emftext.language.pl0.TermExpression#getOp()
   * @see #getTermExpression()
   * @generated
   */
	EAttribute getTermExpression_Op();

	/**
   * Returns the meta object for class '{@link org.emftext.language.pl0.Term <em>Term</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Term</em>'.
   * @see org.emftext.language.pl0.Term
   * @generated
   */
	EClass getTerm();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.pl0.Term#getObligatory <em>Obligatory</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Obligatory</em>'.
   * @see org.emftext.language.pl0.Term#getObligatory()
   * @see #getTerm()
   * @generated
   */
	EReference getTerm_Obligatory();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.pl0.Term#getOptional <em>Optional</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Optional</em>'.
   * @see org.emftext.language.pl0.Term#getOptional()
   * @see #getTerm()
   * @generated
   */
	EReference getTerm_Optional();

	/**
   * Returns the meta object for class '{@link org.emftext.language.pl0.OptionalTerm <em>Optional Term</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Optional Term</em>'.
   * @see org.emftext.language.pl0.OptionalTerm
   * @generated
   */
	EClass getOptionalTerm();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.pl0.OptionalTerm#getTerm <em>Term</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Term</em>'.
   * @see org.emftext.language.pl0.OptionalTerm#getTerm()
   * @see #getOptionalTerm()
   * @generated
   */
	EReference getOptionalTerm_Term();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.language.pl0.OptionalTerm#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see org.emftext.language.pl0.OptionalTerm#getOp()
   * @see #getOptionalTerm()
   * @generated
   */
	EAttribute getOptionalTerm_Op();

	/**
   * Returns the meta object for class '{@link org.emftext.language.pl0.Factor <em>Factor</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Factor</em>'.
   * @see org.emftext.language.pl0.Factor
   * @generated
   */
	EClass getFactor();

	/**
   * Returns the meta object for class '{@link org.emftext.language.pl0.OptionalFactor <em>Optional Factor</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Optional Factor</em>'.
   * @see org.emftext.language.pl0.OptionalFactor
   * @generated
   */
	EClass getOptionalFactor();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.pl0.OptionalFactor#getFactor <em>Factor</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Factor</em>'.
   * @see org.emftext.language.pl0.OptionalFactor#getFactor()
   * @see #getOptionalFactor()
   * @generated
   */
	EReference getOptionalFactor_Factor();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.language.pl0.OptionalFactor#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see org.emftext.language.pl0.OptionalFactor#getOp()
   * @see #getOptionalFactor()
   * @generated
   */
	EAttribute getOptionalFactor_Op();

	/**
   * Returns the meta object for class '{@link org.emftext.language.pl0.IdentReference <em>Ident Reference</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Ident Reference</em>'.
   * @see org.emftext.language.pl0.IdentReference
   * @generated
   */
	EClass getIdentReference();

	/**
   * Returns the meta object for the reference '{@link org.emftext.language.pl0.IdentReference#getIdent <em>Ident</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ident</em>'.
   * @see org.emftext.language.pl0.IdentReference#getIdent()
   * @see #getIdentReference()
   * @generated
   */
	EReference getIdentReference_Ident();

	/**
   * Returns the meta object for class '{@link org.emftext.language.pl0.Number <em>Number</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Number</em>'.
   * @see org.emftext.language.pl0.Number
   * @generated
   */
	EClass getNumber();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.language.pl0.Number#getNumber <em>Number</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Number</em>'.
   * @see org.emftext.language.pl0.Number#getNumber()
   * @see #getNumber()
   * @generated
   */
	EAttribute getNumber_Number();

	/**
   * Returns the meta object for class '{@link org.emftext.language.pl0.ExpressionFactor <em>Expression Factor</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression Factor</em>'.
   * @see org.emftext.language.pl0.ExpressionFactor
   * @generated
   */
	EClass getExpressionFactor();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.pl0.ExpressionFactor#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.emftext.language.pl0.ExpressionFactor#getExpression()
   * @see #getExpressionFactor()
   * @generated
   */
	EReference getExpressionFactor_Expression();

	/**
   * Returns the meta object for class '{@link org.emftext.language.pl0.Body <em>Body</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Body</em>'.
   * @see org.emftext.language.pl0.Body
   * @generated
   */
	EClass getBody();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.pl0.Body#getStatements <em>Statements</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Statements</em>'.
   * @see org.emftext.language.pl0.Body#getStatements()
   * @see #getBody()
   * @generated
   */
	EReference getBody_Statements();

	/**
   * Returns the meta object for class '{@link org.emftext.language.pl0.BlockOwner <em>Block Owner</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Block Owner</em>'.
   * @see org.emftext.language.pl0.BlockOwner
   * @generated
   */
	EClass getBlockOwner();

	/**
   * Returns the meta object for the containment reference '{@link org.emftext.language.pl0.BlockOwner#getBlock <em>Block</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Block</em>'.
   * @see org.emftext.language.pl0.BlockOwner#getBlock()
   * @see #getBlockOwner()
   * @generated
   */
	EReference getBlockOwner_Block();

	/**
   * Returns the meta object for enum '{@link org.emftext.language.pl0.PlusMinusOperator <em>Plus Minus Operator</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Plus Minus Operator</em>'.
   * @see org.emftext.language.pl0.PlusMinusOperator
   * @generated
   */
	EEnum getPlusMinusOperator();

	/**
   * Returns the meta object for enum '{@link org.emftext.language.pl0.MulDivOperator <em>Mul Div Operator</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Mul Div Operator</em>'.
   * @see org.emftext.language.pl0.MulDivOperator
   * @generated
   */
	EEnum getMulDivOperator();

	/**
   * Returns the meta object for enum '{@link org.emftext.language.pl0.RelationalOperator <em>Relational Operator</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Relational Operator</em>'.
   * @see org.emftext.language.pl0.RelationalOperator
   * @generated
   */
	EEnum getRelationalOperator();

	/**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
	PL0Factory getPL0Factory();

	/**
   * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
   * @generated
   */
	interface Literals {
		/**
     * The meta object literal for the '{@link org.emftext.language.pl0.impl.ProgramImpl <em>Program</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.pl0.impl.ProgramImpl
     * @see org.emftext.language.pl0.impl.PL0PackageImpl#getProgram()
     * @generated
     */
		EClass PROGRAM = eINSTANCE.getProgram();

		/**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute PROGRAM__NAME = eINSTANCE.getProgram_Name();

		/**
     * The meta object literal for the '{@link org.emftext.language.pl0.impl.BlockImpl <em>Block</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.pl0.impl.BlockImpl
     * @see org.emftext.language.pl0.impl.PL0PackageImpl#getBlock()
     * @generated
     */
		EClass BLOCK = eINSTANCE.getBlock();

		/**
     * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference BLOCK__VARIABLES = eINSTANCE.getBlock_Variables();

		/**
     * The meta object literal for the '<em><b>Constants</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference BLOCK__CONSTANTS = eINSTANCE.getBlock_Constants();

		/**
     * The meta object literal for the '<em><b>Procedures</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference BLOCK__PROCEDURES = eINSTANCE.getBlock_Procedures();

		/**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference BLOCK__BODY = eINSTANCE.getBlock_Body();

		/**
     * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference BLOCK__OWNER = eINSTANCE.getBlock_Owner();

		/**
     * The meta object literal for the '<em><b>All Owners</b></em>' reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference BLOCK__ALL_OWNERS = eINSTANCE.getBlock_AllOwners();

		/**
     * The meta object literal for the '{@link org.emftext.language.pl0.impl.VarDeclarationImpl <em>Var Declaration</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.pl0.impl.VarDeclarationImpl
     * @see org.emftext.language.pl0.impl.PL0PackageImpl#getVarDeclaration()
     * @generated
     */
		EClass VAR_DECLARATION = eINSTANCE.getVarDeclaration();

		/**
     * The meta object literal for the '{@link org.emftext.language.pl0.impl.ConstDeclarationImpl <em>Const Declaration</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.pl0.impl.ConstDeclarationImpl
     * @see org.emftext.language.pl0.impl.PL0PackageImpl#getConstDeclaration()
     * @generated
     */
		EClass CONST_DECLARATION = eINSTANCE.getConstDeclaration();

		/**
     * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute CONST_DECLARATION__NUMBER = eINSTANCE.getConstDeclaration_Number();

		/**
     * The meta object literal for the '{@link org.emftext.language.pl0.impl.ProcedureDeclarationImpl <em>Procedure Declaration</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.pl0.impl.ProcedureDeclarationImpl
     * @see org.emftext.language.pl0.impl.PL0PackageImpl#getProcedureDeclaration()
     * @generated
     */
		EClass PROCEDURE_DECLARATION = eINSTANCE.getProcedureDeclaration();

		/**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute PROCEDURE_DECLARATION__NAME = eINSTANCE.getProcedureDeclaration_Name();

		/**
     * The meta object literal for the '{@link org.emftext.language.pl0.impl.DeclarationImpl <em>Declaration</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.pl0.impl.DeclarationImpl
     * @see org.emftext.language.pl0.impl.PL0PackageImpl#getDeclaration()
     * @generated
     */
		EClass DECLARATION = eINSTANCE.getDeclaration();

		/**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute DECLARATION__NAME = eINSTANCE.getDeclaration_Name();

		/**
     * The meta object literal for the '{@link org.emftext.language.pl0.impl.StatementImpl <em>Statement</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.pl0.impl.StatementImpl
     * @see org.emftext.language.pl0.impl.PL0PackageImpl#getStatement()
     * @generated
     */
		EClass STATEMENT = eINSTANCE.getStatement();

		/**
     * The meta object literal for the '{@link org.emftext.language.pl0.impl.CallStatementImpl <em>Call Statement</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.pl0.impl.CallStatementImpl
     * @see org.emftext.language.pl0.impl.PL0PackageImpl#getCallStatement()
     * @generated
     */
		EClass CALL_STATEMENT = eINSTANCE.getCallStatement();

		/**
     * The meta object literal for the '<em><b>Procedure</b></em>' reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference CALL_STATEMENT__PROCEDURE = eINSTANCE.getCallStatement_Procedure();

		/**
     * The meta object literal for the '{@link org.emftext.language.pl0.impl.IfStatementImpl <em>If Statement</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.pl0.impl.IfStatementImpl
     * @see org.emftext.language.pl0.impl.PL0PackageImpl#getIfStatement()
     * @generated
     */
		EClass IF_STATEMENT = eINSTANCE.getIfStatement();

		/**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference IF_STATEMENT__CONDITION = eINSTANCE.getIfStatement_Condition();

		/**
     * The meta object literal for the '<em><b>Then</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference IF_STATEMENT__THEN = eINSTANCE.getIfStatement_Then();

		/**
     * The meta object literal for the '<em><b>Else</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference IF_STATEMENT__ELSE = eINSTANCE.getIfStatement_Else();

		/**
     * The meta object literal for the '{@link org.emftext.language.pl0.impl.ConditionImpl <em>Condition</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.pl0.impl.ConditionImpl
     * @see org.emftext.language.pl0.impl.PL0PackageImpl#getCondition()
     * @generated
     */
		EClass CONDITION = eINSTANCE.getCondition();

		/**
     * The meta object literal for the '{@link org.emftext.language.pl0.impl.WhileStatementImpl <em>While Statement</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.pl0.impl.WhileStatementImpl
     * @see org.emftext.language.pl0.impl.PL0PackageImpl#getWhileStatement()
     * @generated
     */
		EClass WHILE_STATEMENT = eINSTANCE.getWhileStatement();

		/**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference WHILE_STATEMENT__CONDITION = eINSTANCE.getWhileStatement_Condition();

		/**
     * The meta object literal for the '<em><b>Do</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference WHILE_STATEMENT__DO = eINSTANCE.getWhileStatement_Do();

		/**
     * The meta object literal for the '{@link org.emftext.language.pl0.impl.AssignmentImpl <em>Assignment</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.pl0.impl.AssignmentImpl
     * @see org.emftext.language.pl0.impl.PL0PackageImpl#getAssignment()
     * @generated
     */
		EClass ASSIGNMENT = eINSTANCE.getAssignment();

		/**
     * The meta object literal for the '<em><b>Left</b></em>' reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference ASSIGNMENT__LEFT = eINSTANCE.getAssignment_Left();

		/**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference ASSIGNMENT__RIGHT = eINSTANCE.getAssignment_Right();

		/**
     * The meta object literal for the '{@link org.emftext.language.pl0.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.pl0.impl.ExpressionImpl
     * @see org.emftext.language.pl0.impl.PL0PackageImpl#getExpression()
     * @generated
     */
		EClass EXPRESSION = eINSTANCE.getExpression();

		/**
     * The meta object literal for the '{@link org.emftext.language.pl0.impl.OddConditionImpl <em>Odd Condition</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.pl0.impl.OddConditionImpl
     * @see org.emftext.language.pl0.impl.PL0PackageImpl#getOddCondition()
     * @generated
     */
		EClass ODD_CONDITION = eINSTANCE.getOddCondition();

		/**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference ODD_CONDITION__EXPRESSION = eINSTANCE.getOddCondition_Expression();

		/**
     * The meta object literal for the '{@link org.emftext.language.pl0.impl.RelationalConditionImpl <em>Relational Condition</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.pl0.impl.RelationalConditionImpl
     * @see org.emftext.language.pl0.impl.PL0PackageImpl#getRelationalCondition()
     * @generated
     */
		EClass RELATIONAL_CONDITION = eINSTANCE.getRelationalCondition();

		/**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference RELATIONAL_CONDITION__LEFT = eINSTANCE.getRelationalCondition_Left();

		/**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference RELATIONAL_CONDITION__RIGHT = eINSTANCE.getRelationalCondition_Right();

		/**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute RELATIONAL_CONDITION__OP = eINSTANCE.getRelationalCondition_Op();

		/**
     * The meta object literal for the '{@link org.emftext.language.pl0.impl.TermExpressionImpl <em>Term Expression</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.pl0.impl.TermExpressionImpl
     * @see org.emftext.language.pl0.impl.PL0PackageImpl#getTermExpression()
     * @generated
     */
		EClass TERM_EXPRESSION = eINSTANCE.getTermExpression();

		/**
     * The meta object literal for the '<em><b>Obligatory</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference TERM_EXPRESSION__OBLIGATORY = eINSTANCE.getTermExpression_Obligatory();

		/**
     * The meta object literal for the '<em><b>Optional</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference TERM_EXPRESSION__OPTIONAL = eINSTANCE.getTermExpression_Optional();

		/**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute TERM_EXPRESSION__OP = eINSTANCE.getTermExpression_Op();

		/**
     * The meta object literal for the '{@link org.emftext.language.pl0.impl.TermImpl <em>Term</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.pl0.impl.TermImpl
     * @see org.emftext.language.pl0.impl.PL0PackageImpl#getTerm()
     * @generated
     */
		EClass TERM = eINSTANCE.getTerm();

		/**
     * The meta object literal for the '<em><b>Obligatory</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference TERM__OBLIGATORY = eINSTANCE.getTerm_Obligatory();

		/**
     * The meta object literal for the '<em><b>Optional</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference TERM__OPTIONAL = eINSTANCE.getTerm_Optional();

		/**
     * The meta object literal for the '{@link org.emftext.language.pl0.impl.OptionalTermImpl <em>Optional Term</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.pl0.impl.OptionalTermImpl
     * @see org.emftext.language.pl0.impl.PL0PackageImpl#getOptionalTerm()
     * @generated
     */
		EClass OPTIONAL_TERM = eINSTANCE.getOptionalTerm();

		/**
     * The meta object literal for the '<em><b>Term</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference OPTIONAL_TERM__TERM = eINSTANCE.getOptionalTerm_Term();

		/**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute OPTIONAL_TERM__OP = eINSTANCE.getOptionalTerm_Op();

		/**
     * The meta object literal for the '{@link org.emftext.language.pl0.impl.FactorImpl <em>Factor</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.pl0.impl.FactorImpl
     * @see org.emftext.language.pl0.impl.PL0PackageImpl#getFactor()
     * @generated
     */
		EClass FACTOR = eINSTANCE.getFactor();

		/**
     * The meta object literal for the '{@link org.emftext.language.pl0.impl.OptionalFactorImpl <em>Optional Factor</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.pl0.impl.OptionalFactorImpl
     * @see org.emftext.language.pl0.impl.PL0PackageImpl#getOptionalFactor()
     * @generated
     */
		EClass OPTIONAL_FACTOR = eINSTANCE.getOptionalFactor();

		/**
     * The meta object literal for the '<em><b>Factor</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference OPTIONAL_FACTOR__FACTOR = eINSTANCE.getOptionalFactor_Factor();

		/**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute OPTIONAL_FACTOR__OP = eINSTANCE.getOptionalFactor_Op();

		/**
     * The meta object literal for the '{@link org.emftext.language.pl0.impl.IdentReferenceImpl <em>Ident Reference</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.pl0.impl.IdentReferenceImpl
     * @see org.emftext.language.pl0.impl.PL0PackageImpl#getIdentReference()
     * @generated
     */
		EClass IDENT_REFERENCE = eINSTANCE.getIdentReference();

		/**
     * The meta object literal for the '<em><b>Ident</b></em>' reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference IDENT_REFERENCE__IDENT = eINSTANCE.getIdentReference_Ident();

		/**
     * The meta object literal for the '{@link org.emftext.language.pl0.impl.NumberImpl <em>Number</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.pl0.impl.NumberImpl
     * @see org.emftext.language.pl0.impl.PL0PackageImpl#getNumber()
     * @generated
     */
		EClass NUMBER = eINSTANCE.getNumber();

		/**
     * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute NUMBER__NUMBER = eINSTANCE.getNumber_Number();

		/**
     * The meta object literal for the '{@link org.emftext.language.pl0.impl.ExpressionFactorImpl <em>Expression Factor</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.pl0.impl.ExpressionFactorImpl
     * @see org.emftext.language.pl0.impl.PL0PackageImpl#getExpressionFactor()
     * @generated
     */
		EClass EXPRESSION_FACTOR = eINSTANCE.getExpressionFactor();

		/**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference EXPRESSION_FACTOR__EXPRESSION = eINSTANCE.getExpressionFactor_Expression();

		/**
     * The meta object literal for the '{@link org.emftext.language.pl0.impl.BodyImpl <em>Body</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.pl0.impl.BodyImpl
     * @see org.emftext.language.pl0.impl.PL0PackageImpl#getBody()
     * @generated
     */
		EClass BODY = eINSTANCE.getBody();

		/**
     * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference BODY__STATEMENTS = eINSTANCE.getBody_Statements();

		/**
     * The meta object literal for the '{@link org.emftext.language.pl0.impl.BlockOwnerImpl <em>Block Owner</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.pl0.impl.BlockOwnerImpl
     * @see org.emftext.language.pl0.impl.PL0PackageImpl#getBlockOwner()
     * @generated
     */
		EClass BLOCK_OWNER = eINSTANCE.getBlockOwner();

		/**
     * The meta object literal for the '<em><b>Block</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference BLOCK_OWNER__BLOCK = eINSTANCE.getBlockOwner_Block();

		/**
     * The meta object literal for the '{@link org.emftext.language.pl0.PlusMinusOperator <em>Plus Minus Operator</em>}' enum.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.pl0.PlusMinusOperator
     * @see org.emftext.language.pl0.impl.PL0PackageImpl#getPlusMinusOperator()
     * @generated
     */
		EEnum PLUS_MINUS_OPERATOR = eINSTANCE.getPlusMinusOperator();

		/**
     * The meta object literal for the '{@link org.emftext.language.pl0.MulDivOperator <em>Mul Div Operator</em>}' enum.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.pl0.MulDivOperator
     * @see org.emftext.language.pl0.impl.PL0PackageImpl#getMulDivOperator()
     * @generated
     */
		EEnum MUL_DIV_OPERATOR = eINSTANCE.getMulDivOperator();

		/**
     * The meta object literal for the '{@link org.emftext.language.pl0.RelationalOperator <em>Relational Operator</em>}' enum.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.pl0.RelationalOperator
     * @see org.emftext.language.pl0.impl.PL0PackageImpl#getRelationalOperator()
     * @generated
     */
		EEnum RELATIONAL_OPERATOR = eINSTANCE.getRelationalOperator();

	}

} //PL0Package
