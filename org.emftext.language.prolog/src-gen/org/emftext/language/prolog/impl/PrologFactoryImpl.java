/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.prolog.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.emftext.language.prolog.Clause;
import org.emftext.language.prolog.ClauseList;
import org.emftext.language.prolog.List;
import org.emftext.language.prolog.Numeral;
import org.emftext.language.prolog.Predicate;
import org.emftext.language.prolog.PredicateList;
import org.emftext.language.prolog.PrologFactory;
import org.emftext.language.prolog.PrologPackage;
import org.emftext.language.prolog.PrologProgram;
import org.emftext.language.prolog.SmallAtom;
import org.emftext.language.prolog.Structure;
import org.emftext.language.prolog.TermList;
import org.emftext.language.prolog.Variable;
import org.emftext.language.prolog.VariableReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PrologFactoryImpl extends EFactoryImpl implements PrologFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PrologFactory init() {
		try {
			PrologFactory thePrologFactory = (PrologFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.emftext.org/language/prolog"); 
			if (thePrologFactory != null) {
				return thePrologFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PrologFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrologFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case PrologPackage.PROLOG_PROGRAM: return createPrologProgram();
			case PrologPackage.CLAUSE_LIST: return createClauseList();
			case PrologPackage.CLAUSE: return createClause();
			case PrologPackage.PREDICATE_LIST: return createPredicateList();
			case PrologPackage.NUMERAL: return createNumeral();
			case PrologPackage.VARIABLE: return createVariable();
			case PrologPackage.STRUCTURE: return createStructure();
			case PrologPackage.SMALL_ATOM: return createSmallAtom();
			case PrologPackage.STRING: return createString();
			case PrologPackage.LIST: return createList();
			case PrologPackage.PREDICATE: return createPredicate();
			case PrologPackage.TERM_LIST: return createTermList();
			case PrologPackage.VARIABLE_REFERENCE: return createVariableReference();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrologProgram createPrologProgram() {
		PrologProgramImpl prologProgram = new PrologProgramImpl();
		return prologProgram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClauseList createClauseList() {
		ClauseListImpl clauseList = new ClauseListImpl();
		return clauseList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Clause createClause() {
		ClauseImpl clause = new ClauseImpl();
		return clause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Predicate createPredicate() {
		PredicateImpl predicate = new PredicateImpl();
		return predicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PredicateList createPredicateList() {
		PredicateListImpl predicateList = new PredicateListImpl();
		return predicateList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TermList createTermList() {
		TermListImpl termList = new TermListImpl();
		return termList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Numeral createNumeral() {
		NumeralImpl numeral = new NumeralImpl();
		return numeral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable createVariable() {
		VariableImpl variable = new VariableImpl();
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Structure createStructure() {
		StructureImpl structure = new StructureImpl();
		return structure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SmallAtom createSmallAtom() {
		SmallAtomImpl smallAtom = new SmallAtomImpl();
		return smallAtom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.emftext.language.prolog.String createString() {
		StringImpl string = new StringImpl();
		return string;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List createList() {
		ListImpl list = new ListImpl();
		return list;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableReference createVariableReference() {
		VariableReferenceImpl variableReference = new VariableReferenceImpl();
		return variableReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrologPackage getPrologPackage() {
		return (PrologPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PrologPackage getPackage() {
		return PrologPackage.eINSTANCE;
	}

} //PrologFactoryImpl
