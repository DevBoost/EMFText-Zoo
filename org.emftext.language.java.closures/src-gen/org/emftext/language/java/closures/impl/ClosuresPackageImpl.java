/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.java.closures.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.emftext.language.java.annotations.AnnotationsPackage;
import org.emftext.language.java.arrays.ArraysPackage;
import org.emftext.language.java.classifiers.ClassifiersPackage;
import org.emftext.language.java.closures.Closure;
import org.emftext.language.java.closures.ClosuresFactory;
import org.emftext.language.java.closures.ClosuresPackage;
import org.emftext.language.java.commons.CommonsPackage;
import org.emftext.language.java.containers.ContainersPackage;
import org.emftext.language.java.expressions.ExpressionsPackage;
import org.emftext.language.java.generics.GenericsPackage;
import org.emftext.language.java.imports.ImportsPackage;
import org.emftext.language.java.instantiations.InstantiationsPackage;
import org.emftext.language.java.literals.LiteralsPackage;
import org.emftext.language.java.members.MembersPackage;
import org.emftext.language.java.modifiers.ModifiersPackage;
import org.emftext.language.java.operators.OperatorsPackage;
import org.emftext.language.java.parameters.ParametersPackage;
import org.emftext.language.java.references.ReferencesPackage;
import org.emftext.language.java.statements.StatementsPackage;
import org.emftext.language.java.types.TypesPackage;
import org.emftext.language.java.variables.VariablesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ClosuresPackageImpl extends EPackageImpl implements ClosuresPackage {
	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass closureEClass = null;

	/**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.emftext.language.java.closures.ClosuresPackage#eNS_URI
   * @see #init()
   * @generated
   */
	private ClosuresPackageImpl() {
    super(eNS_URI, ClosuresFactory.eINSTANCE);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private static boolean isInited = false;

	/**
   * Creates, registers, and initializes the <b>Package</b> for this
   * model, and for any others upon which it depends.  Simple
   * dependencies are satisfied by calling this method on all
   * dependent packages before doing anything else.  This method drives
   * initialization for interdependent packages directly, in parallel
   * with this package, itself.
   * <p>Of this package and its interdependencies, all packages which
   * have not yet been registered by their URI values are first created
   * and registered.  The packages are then initialized in two steps:
   * meta-model objects for all of the packages are created before any
   * are initialized, since one package's meta-model objects may refer to
   * those of another.
   * <p>Invocation of this method will not affect any packages that have
   * already been initialized.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
	public static ClosuresPackage init() {
    if (isInited) return (ClosuresPackage)EPackage.Registry.INSTANCE.getEPackage(ClosuresPackage.eNS_URI);

    // Obtain or create and register package
    ClosuresPackageImpl theClosuresPackage = (ClosuresPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ClosuresPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ClosuresPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    AnnotationsPackage.eINSTANCE.eClass();
    ArraysPackage.eINSTANCE.eClass();
    ClassifiersPackage.eINSTANCE.eClass();
    CommonsPackage.eINSTANCE.eClass();
    ContainersPackage.eINSTANCE.eClass();
    ExpressionsPackage.eINSTANCE.eClass();
    GenericsPackage.eINSTANCE.eClass();
    ImportsPackage.eINSTANCE.eClass();
    InstantiationsPackage.eINSTANCE.eClass();
    LiteralsPackage.eINSTANCE.eClass();
    MembersPackage.eINSTANCE.eClass();
    ModifiersPackage.eINSTANCE.eClass();
    OperatorsPackage.eINSTANCE.eClass();
    ParametersPackage.eINSTANCE.eClass();
    ReferencesPackage.eINSTANCE.eClass();
    StatementsPackage.eINSTANCE.eClass();
    TypesPackage.eINSTANCE.eClass();
    VariablesPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theClosuresPackage.createPackageContents();

    // Initialize created meta-data
    theClosuresPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theClosuresPackage.freeze();

    return theClosuresPackage;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getClosure() {
    return closureEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ClosuresFactory getClosuresFactory() {
    return (ClosuresFactory)getEFactoryInstance();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private boolean isCreated = false;

	/**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void createPackageContents() {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    closureEClass = createEClass(CLOSURE);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private boolean isInitialized = false;

	/**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void initializePackageContents() {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    ParametersPackage theParametersPackage = (ParametersPackage)EPackage.Registry.INSTANCE.getEPackage(ParametersPackage.eNS_URI);
    StatementsPackage theStatementsPackage = (StatementsPackage)EPackage.Registry.INSTANCE.getEPackage(StatementsPackage.eNS_URI);
    ReferencesPackage theReferencesPackage = (ReferencesPackage)EPackage.Registry.INSTANCE.getEPackage(ReferencesPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    closureEClass.getESuperTypes().add(theParametersPackage.getParametrizable());
    closureEClass.getESuperTypes().add(theStatementsPackage.getStatementListContainer());
    closureEClass.getESuperTypes().add(theReferencesPackage.getReference());

    // Initialize classes and features; add operations and parameters
    initEClass(closureEClass, Closure.class, "Closure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);
  }

} //ClosuresPackageImpl
