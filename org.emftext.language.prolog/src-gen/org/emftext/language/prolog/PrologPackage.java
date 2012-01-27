/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.prolog;

import java.lang.String;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see org.emftext.language.prolog.PrologFactory
 * @model kind="package"
 * @generated
 */
public interface PrologPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "prolog";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.emftext.org/language/prolog";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "prolog";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PrologPackage eINSTANCE = org.emftext.language.prolog.impl.PrologPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.emftext.language.prolog.impl.PrologProgramImpl <em>Program</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.prolog.impl.PrologProgramImpl
	 * @see org.emftext.language.prolog.impl.PrologPackageImpl#getPrologProgram()
	 * @generated
	 */
	int PROLOG_PROGRAM = 0;

	/**
	 * The feature id for the '<em><b>Clause List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROLOG_PROGRAM__CLAUSE_LIST = 0;

	/**
	 * The feature id for the '<em><b>Query</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROLOG_PROGRAM__QUERY = 1;

	/**
	 * The number of structural features of the '<em>Program</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROLOG_PROGRAM_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.emftext.language.prolog.impl.ClauseListImpl <em>Clause List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.prolog.impl.ClauseListImpl
	 * @see org.emftext.language.prolog.impl.PrologPackageImpl#getClauseList()
	 * @generated
	 */
	int CLAUSE_LIST = 1;

	/**
	 * The feature id for the '<em><b>Clause</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLAUSE_LIST__CLAUSE = 0;

	/**
	 * The feature id for the '<em><b>Clause List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLAUSE_LIST__CLAUSE_LIST = 1;

	/**
	 * The number of structural features of the '<em>Clause List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLAUSE_LIST_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.emftext.language.prolog.impl.QueryImpl <em>Query</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.prolog.impl.QueryImpl
	 * @see org.emftext.language.prolog.impl.PrologPackageImpl#getQuery()
	 * @generated
	 */
	int QUERY = 2;

	/**
	 * The number of structural features of the '<em>Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.emftext.language.prolog.impl.ClauseImpl <em>Clause</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.prolog.impl.ClauseImpl
	 * @see org.emftext.language.prolog.impl.PrologPackageImpl#getClause()
	 * @generated
	 */
	int CLAUSE = 3;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLAUSE__PREDICATE = 0;

	/**
	 * The feature id for the '<em><b>Predicate List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLAUSE__PREDICATE_LIST = 1;

	/**
	 * The number of structural features of the '<em>Clause</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLAUSE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.emftext.language.prolog.impl.PredicateImpl <em>Predicate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.prolog.impl.PredicateImpl
	 * @see org.emftext.language.prolog.impl.PrologPackageImpl#getPredicate()
	 * @generated
	 */
	int PREDICATE = 13;

	/**
	 * The meta object id for the '{@link org.emftext.language.prolog.impl.PredicateListImpl <em>Predicate List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.prolog.impl.PredicateListImpl
	 * @see org.emftext.language.prolog.impl.PrologPackageImpl#getPredicateList()
	 * @generated
	 */
	int PREDICATE_LIST = 4;

	/**
	 * The feature id for the '<em><b>Predicate List</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_LIST__PREDICATE_LIST = QUERY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_LIST__PREDICATE = QUERY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Predicate List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_LIST_FEATURE_COUNT = QUERY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.emftext.language.prolog.impl.TermImpl <em>Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.prolog.impl.TermImpl
	 * @see org.emftext.language.prolog.impl.PrologPackageImpl#getTerm()
	 * @generated
	 */
	int TERM = 6;

	/**
	 * The number of structural features of the '<em>Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.emftext.language.prolog.impl.AtomImpl <em>Atom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.prolog.impl.AtomImpl
	 * @see org.emftext.language.prolog.impl.PrologPackageImpl#getAtom()
	 * @generated
	 */
	int ATOM = 5;

	/**
	 * The number of structural features of the '<em>Atom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOM_FEATURE_COUNT = TERM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emftext.language.prolog.impl.TermListImpl <em>Term List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.prolog.impl.TermListImpl
	 * @see org.emftext.language.prolog.impl.PrologPackageImpl#getTermList()
	 * @generated
	 */
	int TERM_LIST = 14;

	/**
	 * The meta object id for the '{@link org.emftext.language.prolog.impl.NumeralImpl <em>Numeral</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.prolog.impl.NumeralImpl
	 * @see org.emftext.language.prolog.impl.PrologPackageImpl#getNumeral()
	 * @generated
	 */
	int NUMERAL = 7;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERAL__VALUE = TERM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Numeral</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERAL_FEATURE_COUNT = TERM_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.emftext.language.prolog.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.prolog.impl.VariableImpl
	 * @see org.emftext.language.prolog.impl.PrologPackageImpl#getVariable()
	 * @generated
	 */
	int VARIABLE = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__NAME = TERM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FEATURE_COUNT = TERM_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.emftext.language.prolog.impl.StructureImpl <em>Structure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.prolog.impl.StructureImpl
	 * @see org.emftext.language.prolog.impl.PrologPackageImpl#getStructure()
	 * @generated
	 */
	int STRUCTURE = 9;

	/**
	 * The feature id for the '<em><b>Atom</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE__ATOM = TERM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Term List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE__TERM_LIST = TERM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_FEATURE_COUNT = TERM_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.emftext.language.prolog.impl.SmallAtomImpl <em>Small Atom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.prolog.impl.SmallAtomImpl
	 * @see org.emftext.language.prolog.impl.PrologPackageImpl#getSmallAtom()
	 * @generated
	 */
	int SMALL_ATOM = 10;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMALL_ATOM__TEXT = ATOM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Small Atom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMALL_ATOM_FEATURE_COUNT = ATOM_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.emftext.language.prolog.impl.StringImpl <em>String</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.prolog.impl.StringImpl
	 * @see org.emftext.language.prolog.impl.PrologPackageImpl#getString()
	 * @generated
	 */
	int STRING = 11;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING__TEXT = ATOM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_FEATURE_COUNT = ATOM_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.emftext.language.prolog.impl.ListImpl <em>List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.prolog.impl.ListImpl
	 * @see org.emftext.language.prolog.impl.PrologPackageImpl#getList()
	 * @generated
	 */
	int LIST = 12;

	/**
	 * The number of structural features of the '<em>List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_FEATURE_COUNT = TERM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Atom</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE__ATOM = 0;

	/**
	 * The feature id for the '<em><b>Term List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE__TERM_LIST = 1;

	/**
	 * The number of structural features of the '<em>Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Term List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_LIST__TERM_LIST = 0;

	/**
	 * The feature id for the '<em><b>Term</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_LIST__TERM = 1;

	/**
	 * The number of structural features of the '<em>Term List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_LIST_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.emftext.language.prolog.impl.VariableReferenceImpl <em>Variable Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.prolog.impl.VariableReferenceImpl
	 * @see org.emftext.language.prolog.impl.PrologPackageImpl#getVariableReference()
	 * @generated
	 */
	int VARIABLE_REFERENCE = 15;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_REFERENCE__VARIABLE = TERM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_REFERENCE_FEATURE_COUNT = TERM_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.emftext.language.prolog.PrologProgram <em>Program</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Program</em>'.
	 * @see org.emftext.language.prolog.PrologProgram
	 * @generated
	 */
	EClass getPrologProgram();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.prolog.PrologProgram#getClauseList <em>Clause List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Clause List</em>'.
	 * @see org.emftext.language.prolog.PrologProgram#getClauseList()
	 * @see #getPrologProgram()
	 * @generated
	 */
	EReference getPrologProgram_ClauseList();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.prolog.PrologProgram#getQuery <em>Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Query</em>'.
	 * @see org.emftext.language.prolog.PrologProgram#getQuery()
	 * @see #getPrologProgram()
	 * @generated
	 */
	EReference getPrologProgram_Query();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.prolog.ClauseList <em>Clause List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Clause List</em>'.
	 * @see org.emftext.language.prolog.ClauseList
	 * @generated
	 */
	EClass getClauseList();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.prolog.ClauseList#getClause <em>Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Clause</em>'.
	 * @see org.emftext.language.prolog.ClauseList#getClause()
	 * @see #getClauseList()
	 * @generated
	 */
	EReference getClauseList_Clause();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.prolog.ClauseList#getClauseList <em>Clause List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Clause List</em>'.
	 * @see org.emftext.language.prolog.ClauseList#getClauseList()
	 * @see #getClauseList()
	 * @generated
	 */
	EReference getClauseList_ClauseList();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.prolog.Query <em>Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Query</em>'.
	 * @see org.emftext.language.prolog.Query
	 * @generated
	 */
	EClass getQuery();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.prolog.Clause <em>Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Clause</em>'.
	 * @see org.emftext.language.prolog.Clause
	 * @generated
	 */
	EClass getClause();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.prolog.Clause#getPredicate <em>Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Predicate</em>'.
	 * @see org.emftext.language.prolog.Clause#getPredicate()
	 * @see #getClause()
	 * @generated
	 */
	EReference getClause_Predicate();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.prolog.Clause#getPredicateList <em>Predicate List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Predicate List</em>'.
	 * @see org.emftext.language.prolog.Clause#getPredicateList()
	 * @see #getClause()
	 * @generated
	 */
	EReference getClause_PredicateList();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.prolog.Predicate <em>Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Predicate</em>'.
	 * @see org.emftext.language.prolog.Predicate
	 * @generated
	 */
	EClass getPredicate();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.prolog.Predicate#getAtom <em>Atom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Atom</em>'.
	 * @see org.emftext.language.prolog.Predicate#getAtom()
	 * @see #getPredicate()
	 * @generated
	 */
	EReference getPredicate_Atom();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.prolog.Predicate#getTermList <em>Term List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Term List</em>'.
	 * @see org.emftext.language.prolog.Predicate#getTermList()
	 * @see #getPredicate()
	 * @generated
	 */
	EReference getPredicate_TermList();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.prolog.PredicateList <em>Predicate List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Predicate List</em>'.
	 * @see org.emftext.language.prolog.PredicateList
	 * @generated
	 */
	EClass getPredicateList();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.prolog.PredicateList#getPredicate <em>Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Predicate</em>'.
	 * @see org.emftext.language.prolog.PredicateList#getPredicate()
	 * @see #getPredicateList()
	 * @generated
	 */
	EReference getPredicateList_Predicate();

	/**
	 * Returns the meta object for the reference '{@link org.emftext.language.prolog.PredicateList#getPredicateList <em>Predicate List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Predicate List</em>'.
	 * @see org.emftext.language.prolog.PredicateList#getPredicateList()
	 * @see #getPredicateList()
	 * @generated
	 */
	EReference getPredicateList_PredicateList();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.prolog.Atom <em>Atom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Atom</em>'.
	 * @see org.emftext.language.prolog.Atom
	 * @generated
	 */
	EClass getAtom();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.prolog.TermList <em>Term List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Term List</em>'.
	 * @see org.emftext.language.prolog.TermList
	 * @generated
	 */
	EClass getTermList();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.prolog.TermList#getTerm <em>Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Term</em>'.
	 * @see org.emftext.language.prolog.TermList#getTerm()
	 * @see #getTermList()
	 * @generated
	 */
	EReference getTermList_Term();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.prolog.TermList#getTermList <em>Term List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Term List</em>'.
	 * @see org.emftext.language.prolog.TermList#getTermList()
	 * @see #getTermList()
	 * @generated
	 */
	EReference getTermList_TermList();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.prolog.Term <em>Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Term</em>'.
	 * @see org.emftext.language.prolog.Term
	 * @generated
	 */
	EClass getTerm();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.prolog.Numeral <em>Numeral</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Numeral</em>'.
	 * @see org.emftext.language.prolog.Numeral
	 * @generated
	 */
	EClass getNumeral();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.language.prolog.Numeral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.emftext.language.prolog.Numeral#getValue()
	 * @see #getNumeral()
	 * @generated
	 */
	EAttribute getNumeral_Value();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.prolog.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see org.emftext.language.prolog.Variable
	 * @generated
	 */
	EClass getVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.language.prolog.Variable#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.emftext.language.prolog.Variable#getName()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_Name();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.prolog.Structure <em>Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structure</em>'.
	 * @see org.emftext.language.prolog.Structure
	 * @generated
	 */
	EClass getStructure();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.prolog.Structure#getAtom <em>Atom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Atom</em>'.
	 * @see org.emftext.language.prolog.Structure#getAtom()
	 * @see #getStructure()
	 * @generated
	 */
	EReference getStructure_Atom();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.prolog.Structure#getTermList <em>Term List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Term List</em>'.
	 * @see org.emftext.language.prolog.Structure#getTermList()
	 * @see #getStructure()
	 * @generated
	 */
	EReference getStructure_TermList();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.prolog.SmallAtom <em>Small Atom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Small Atom</em>'.
	 * @see org.emftext.language.prolog.SmallAtom
	 * @generated
	 */
	EClass getSmallAtom();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.language.prolog.SmallAtom#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.emftext.language.prolog.SmallAtom#getText()
	 * @see #getSmallAtom()
	 * @generated
	 */
	EAttribute getSmallAtom_Text();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.prolog.String <em>String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String</em>'.
	 * @see org.emftext.language.prolog.String
	 * @generated
	 */
	EClass getString();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.language.prolog.String#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.emftext.language.prolog.String#getText()
	 * @see #getString()
	 * @generated
	 */
	EAttribute getString_Text();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.prolog.List <em>List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>List</em>'.
	 * @see org.emftext.language.prolog.List
	 * @generated
	 */
	EClass getList();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.prolog.VariableReference <em>Variable Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Reference</em>'.
	 * @see org.emftext.language.prolog.VariableReference
	 * @generated
	 */
	EClass getVariableReference();

	/**
	 * Returns the meta object for the reference '{@link org.emftext.language.prolog.VariableReference#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see org.emftext.language.prolog.VariableReference#getVariable()
	 * @see #getVariableReference()
	 * @generated
	 */
	EReference getVariableReference_Variable();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PrologFactory getPrologFactory();

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
		 * The meta object literal for the '{@link org.emftext.language.prolog.impl.PrologProgramImpl <em>Program</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.prolog.impl.PrologProgramImpl
		 * @see org.emftext.language.prolog.impl.PrologPackageImpl#getPrologProgram()
		 * @generated
		 */
		EClass PROLOG_PROGRAM = eINSTANCE.getPrologProgram();

		/**
		 * The meta object literal for the '<em><b>Clause List</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROLOG_PROGRAM__CLAUSE_LIST = eINSTANCE.getPrologProgram_ClauseList();

		/**
		 * The meta object literal for the '<em><b>Query</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROLOG_PROGRAM__QUERY = eINSTANCE.getPrologProgram_Query();

		/**
		 * The meta object literal for the '{@link org.emftext.language.prolog.impl.ClauseListImpl <em>Clause List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.prolog.impl.ClauseListImpl
		 * @see org.emftext.language.prolog.impl.PrologPackageImpl#getClauseList()
		 * @generated
		 */
		EClass CLAUSE_LIST = eINSTANCE.getClauseList();

		/**
		 * The meta object literal for the '<em><b>Clause</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLAUSE_LIST__CLAUSE = eINSTANCE.getClauseList_Clause();

		/**
		 * The meta object literal for the '<em><b>Clause List</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLAUSE_LIST__CLAUSE_LIST = eINSTANCE.getClauseList_ClauseList();

		/**
		 * The meta object literal for the '{@link org.emftext.language.prolog.impl.QueryImpl <em>Query</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.prolog.impl.QueryImpl
		 * @see org.emftext.language.prolog.impl.PrologPackageImpl#getQuery()
		 * @generated
		 */
		EClass QUERY = eINSTANCE.getQuery();

		/**
		 * The meta object literal for the '{@link org.emftext.language.prolog.impl.ClauseImpl <em>Clause</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.prolog.impl.ClauseImpl
		 * @see org.emftext.language.prolog.impl.PrologPackageImpl#getClause()
		 * @generated
		 */
		EClass CLAUSE = eINSTANCE.getClause();

		/**
		 * The meta object literal for the '<em><b>Predicate</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLAUSE__PREDICATE = eINSTANCE.getClause_Predicate();

		/**
		 * The meta object literal for the '<em><b>Predicate List</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLAUSE__PREDICATE_LIST = eINSTANCE.getClause_PredicateList();

		/**
		 * The meta object literal for the '{@link org.emftext.language.prolog.impl.PredicateImpl <em>Predicate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.prolog.impl.PredicateImpl
		 * @see org.emftext.language.prolog.impl.PrologPackageImpl#getPredicate()
		 * @generated
		 */
		EClass PREDICATE = eINSTANCE.getPredicate();

		/**
		 * The meta object literal for the '<em><b>Atom</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREDICATE__ATOM = eINSTANCE.getPredicate_Atom();

		/**
		 * The meta object literal for the '<em><b>Term List</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREDICATE__TERM_LIST = eINSTANCE.getPredicate_TermList();

		/**
		 * The meta object literal for the '{@link org.emftext.language.prolog.impl.PredicateListImpl <em>Predicate List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.prolog.impl.PredicateListImpl
		 * @see org.emftext.language.prolog.impl.PrologPackageImpl#getPredicateList()
		 * @generated
		 */
		EClass PREDICATE_LIST = eINSTANCE.getPredicateList();

		/**
		 * The meta object literal for the '<em><b>Predicate</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREDICATE_LIST__PREDICATE = eINSTANCE.getPredicateList_Predicate();

		/**
		 * The meta object literal for the '<em><b>Predicate List</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREDICATE_LIST__PREDICATE_LIST = eINSTANCE.getPredicateList_PredicateList();

		/**
		 * The meta object literal for the '{@link org.emftext.language.prolog.impl.AtomImpl <em>Atom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.prolog.impl.AtomImpl
		 * @see org.emftext.language.prolog.impl.PrologPackageImpl#getAtom()
		 * @generated
		 */
		EClass ATOM = eINSTANCE.getAtom();

		/**
		 * The meta object literal for the '{@link org.emftext.language.prolog.impl.TermListImpl <em>Term List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.prolog.impl.TermListImpl
		 * @see org.emftext.language.prolog.impl.PrologPackageImpl#getTermList()
		 * @generated
		 */
		EClass TERM_LIST = eINSTANCE.getTermList();

		/**
		 * The meta object literal for the '<em><b>Term</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TERM_LIST__TERM = eINSTANCE.getTermList_Term();

		/**
		 * The meta object literal for the '<em><b>Term List</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TERM_LIST__TERM_LIST = eINSTANCE.getTermList_TermList();

		/**
		 * The meta object literal for the '{@link org.emftext.language.prolog.impl.TermImpl <em>Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.prolog.impl.TermImpl
		 * @see org.emftext.language.prolog.impl.PrologPackageImpl#getTerm()
		 * @generated
		 */
		EClass TERM = eINSTANCE.getTerm();

		/**
		 * The meta object literal for the '{@link org.emftext.language.prolog.impl.NumeralImpl <em>Numeral</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.prolog.impl.NumeralImpl
		 * @see org.emftext.language.prolog.impl.PrologPackageImpl#getNumeral()
		 * @generated
		 */
		EClass NUMERAL = eINSTANCE.getNumeral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMERAL__VALUE = eINSTANCE.getNumeral_Value();

		/**
		 * The meta object literal for the '{@link org.emftext.language.prolog.impl.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.prolog.impl.VariableImpl
		 * @see org.emftext.language.prolog.impl.PrologPackageImpl#getVariable()
		 * @generated
		 */
		EClass VARIABLE = eINSTANCE.getVariable();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__NAME = eINSTANCE.getVariable_Name();

		/**
		 * The meta object literal for the '{@link org.emftext.language.prolog.impl.StructureImpl <em>Structure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.prolog.impl.StructureImpl
		 * @see org.emftext.language.prolog.impl.PrologPackageImpl#getStructure()
		 * @generated
		 */
		EClass STRUCTURE = eINSTANCE.getStructure();

		/**
		 * The meta object literal for the '<em><b>Atom</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURE__ATOM = eINSTANCE.getStructure_Atom();

		/**
		 * The meta object literal for the '<em><b>Term List</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURE__TERM_LIST = eINSTANCE.getStructure_TermList();

		/**
		 * The meta object literal for the '{@link org.emftext.language.prolog.impl.SmallAtomImpl <em>Small Atom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.prolog.impl.SmallAtomImpl
		 * @see org.emftext.language.prolog.impl.PrologPackageImpl#getSmallAtom()
		 * @generated
		 */
		EClass SMALL_ATOM = eINSTANCE.getSmallAtom();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SMALL_ATOM__TEXT = eINSTANCE.getSmallAtom_Text();

		/**
		 * The meta object literal for the '{@link org.emftext.language.prolog.impl.StringImpl <em>String</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.prolog.impl.StringImpl
		 * @see org.emftext.language.prolog.impl.PrologPackageImpl#getString()
		 * @generated
		 */
		EClass STRING = eINSTANCE.getString();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING__TEXT = eINSTANCE.getString_Text();

		/**
		 * The meta object literal for the '{@link org.emftext.language.prolog.impl.ListImpl <em>List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.prolog.impl.ListImpl
		 * @see org.emftext.language.prolog.impl.PrologPackageImpl#getList()
		 * @generated
		 */
		EClass LIST = eINSTANCE.getList();

		/**
		 * The meta object literal for the '{@link org.emftext.language.prolog.impl.VariableReferenceImpl <em>Variable Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.prolog.impl.VariableReferenceImpl
		 * @see org.emftext.language.prolog.impl.PrologPackageImpl#getVariableReference()
		 * @generated
		 */
		EClass VARIABLE_REFERENCE = eINSTANCE.getVariableReference();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_REFERENCE__VARIABLE = eINSTANCE.getVariableReference_Variable();

	}

} //PrologPackage
