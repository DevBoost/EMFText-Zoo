/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.pl0.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.emftext.language.pl0.Assignment;
import org.emftext.language.pl0.Block;
import org.emftext.language.pl0.Body;
import org.emftext.language.pl0.CallStatement;
import org.emftext.language.pl0.ConstDeclaration;
import org.emftext.language.pl0.ExpressionFactor;
import org.emftext.language.pl0.IdentReference;
import org.emftext.language.pl0.IfStatement;
import org.emftext.language.pl0.MulDivOperator;
import org.emftext.language.pl0.OddCondition;
import org.emftext.language.pl0.OptionalFactor;
import org.emftext.language.pl0.OptionalTerm;
import org.emftext.language.pl0.PL0Factory;
import org.emftext.language.pl0.PL0Package;
import org.emftext.language.pl0.PlusMinusOperator;
import org.emftext.language.pl0.ProcedureDeclaration;
import org.emftext.language.pl0.Program;
import org.emftext.language.pl0.RelationalCondition;
import org.emftext.language.pl0.RelationalOperator;
import org.emftext.language.pl0.Term;
import org.emftext.language.pl0.TermExpression;
import org.emftext.language.pl0.VarDeclaration;
import org.emftext.language.pl0.WhileStatement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PL0FactoryImpl extends EFactoryImpl implements PL0Factory {
	/**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public static PL0Factory init() {
    try
    {
      PL0Factory thePL0Factory = (PL0Factory)EPackage.Registry.INSTANCE.getEFactory("http://www.emftext.org/language/pl0"); 
      if (thePL0Factory != null)
      {
        return thePL0Factory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new PL0FactoryImpl();
  }

	/**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public PL0FactoryImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public EObject create(EClass eClass) {
    switch (eClass.getClassifierID())
    {
      case PL0Package.PROGRAM: return createProgram();
      case PL0Package.BLOCK: return createBlock();
      case PL0Package.VAR_DECLARATION: return createVarDeclaration();
      case PL0Package.CONST_DECLARATION: return createConstDeclaration();
      case PL0Package.PROCEDURE_DECLARATION: return createProcedureDeclaration();
      case PL0Package.CALL_STATEMENT: return createCallStatement();
      case PL0Package.IF_STATEMENT: return createIfStatement();
      case PL0Package.WHILE_STATEMENT: return createWhileStatement();
      case PL0Package.ASSIGNMENT: return createAssignment();
      case PL0Package.ODD_CONDITION: return createOddCondition();
      case PL0Package.RELATIONAL_CONDITION: return createRelationalCondition();
      case PL0Package.TERM_EXPRESSION: return createTermExpression();
      case PL0Package.TERM: return createTerm();
      case PL0Package.OPTIONAL_TERM: return createOptionalTerm();
      case PL0Package.OPTIONAL_FACTOR: return createOptionalFactor();
      case PL0Package.IDENT_REFERENCE: return createIdentReference();
      case PL0Package.NUMBER: return createNumber();
      case PL0Package.EXPRESSION_FACTOR: return createExpressionFactor();
      case PL0Package.BODY: return createBody();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
    switch (eDataType.getClassifierID())
    {
      case PL0Package.PLUS_MINUS_OPERATOR:
        return createPlusMinusOperatorFromString(eDataType, initialValue);
      case PL0Package.MUL_DIV_OPERATOR:
        return createMulDivOperatorFromString(eDataType, initialValue);
      case PL0Package.RELATIONAL_OPERATOR:
        return createRelationalOperatorFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
    switch (eDataType.getClassifierID())
    {
      case PL0Package.PLUS_MINUS_OPERATOR:
        return convertPlusMinusOperatorToString(eDataType, instanceValue);
      case PL0Package.MUL_DIV_OPERATOR:
        return convertMulDivOperatorToString(eDataType, instanceValue);
      case PL0Package.RELATIONAL_OPERATOR:
        return convertRelationalOperatorToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Program createProgram() {
    ProgramImpl program = new ProgramImpl();
    return program;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Block createBlock() {
    BlockImpl block = new BlockImpl();
    return block;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public VarDeclaration createVarDeclaration() {
    VarDeclarationImpl varDeclaration = new VarDeclarationImpl();
    return varDeclaration;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ConstDeclaration createConstDeclaration() {
    ConstDeclarationImpl constDeclaration = new ConstDeclarationImpl();
    return constDeclaration;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ProcedureDeclaration createProcedureDeclaration() {
    ProcedureDeclarationImpl procedureDeclaration = new ProcedureDeclarationImpl();
    return procedureDeclaration;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public CallStatement createCallStatement() {
    CallStatementImpl callStatement = new CallStatementImpl();
    return callStatement;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public IfStatement createIfStatement() {
    IfStatementImpl ifStatement = new IfStatementImpl();
    return ifStatement;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public WhileStatement createWhileStatement() {
    WhileStatementImpl whileStatement = new WhileStatementImpl();
    return whileStatement;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Assignment createAssignment() {
    AssignmentImpl assignment = new AssignmentImpl();
    return assignment;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public OddCondition createOddCondition() {
    OddConditionImpl oddCondition = new OddConditionImpl();
    return oddCondition;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public RelationalCondition createRelationalCondition() {
    RelationalConditionImpl relationalCondition = new RelationalConditionImpl();
    return relationalCondition;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public TermExpression createTermExpression() {
    TermExpressionImpl termExpression = new TermExpressionImpl();
    return termExpression;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Term createTerm() {
    TermImpl term = new TermImpl();
    return term;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public OptionalTerm createOptionalTerm() {
    OptionalTermImpl optionalTerm = new OptionalTermImpl();
    return optionalTerm;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public OptionalFactor createOptionalFactor() {
    OptionalFactorImpl optionalFactor = new OptionalFactorImpl();
    return optionalFactor;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public IdentReference createIdentReference() {
    IdentReferenceImpl identReference = new IdentReferenceImpl();
    return identReference;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public org.emftext.language.pl0.Number createNumber() {
    NumberImpl number = new NumberImpl();
    return number;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ExpressionFactor createExpressionFactor() {
    ExpressionFactorImpl expressionFactor = new ExpressionFactorImpl();
    return expressionFactor;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Body createBody() {
    BodyImpl body = new BodyImpl();
    return body;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public PlusMinusOperator createPlusMinusOperatorFromString(EDataType eDataType, String initialValue) {
    PlusMinusOperator result = PlusMinusOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String convertPlusMinusOperatorToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public MulDivOperator createMulDivOperatorFromString(EDataType eDataType, String initialValue) {
    MulDivOperator result = MulDivOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String convertMulDivOperatorToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public RelationalOperator createRelationalOperatorFromString(EDataType eDataType, String initialValue) {
    RelationalOperator result = RelationalOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String convertRelationalOperatorToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public PL0Package getPL0Package() {
    return (PL0Package)getEPackage();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
	@Deprecated
	public static PL0Package getPackage() {
    return PL0Package.eINSTANCE;
  }

} //PL0FactoryImpl
