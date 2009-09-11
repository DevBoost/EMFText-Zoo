/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package parametercheck;

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
 * @see parametercheck.ParametercheckFactory
 * @model kind="package"
 * @generated
 */
public interface ParametercheckPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "parametercheck";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://deftproject.org/parametercheck";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "pcheck";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ParametercheckPackage eINSTANCE = parametercheck.impl.ParametercheckPackageImpl.init();

  /**
   * The meta object id for the '{@link parametercheck.impl.ParameterCheckModelImpl <em>Parameter Check Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see parametercheck.impl.ParameterCheckModelImpl
   * @see parametercheck.impl.ParametercheckPackageImpl#getParameterCheckModel()
   * @generated
   */
  int PARAMETER_CHECK_MODEL = 0;

  /**
   * The feature id for the '<em><b>Method</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_CHECK_MODEL__METHOD = 0;

  /**
   * The number of structural features of the '<em>Parameter Check Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_CHECK_MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link parametercheck.impl.MethodImpl <em>Method</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see parametercheck.impl.MethodImpl
   * @see parametercheck.impl.ParametercheckPackageImpl#getMethod()
   * @generated
   */
  int METHOD = 1;

  /**
   * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD__PARAMETER = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD__NAME = 1;

  /**
   * The feature id for the '<em><b>Check</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD__CHECK = 2;

  /**
   * The number of structural features of the '<em>Method</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link parametercheck.impl.ParameterDeclImpl <em>Parameter Decl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see parametercheck.impl.ParameterDeclImpl
   * @see parametercheck.impl.ParametercheckPackageImpl#getParameterDecl()
   * @generated
   */
  int PARAMETER_DECL = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_DECL__NAME = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_DECL__TYPE = 1;

  /**
   * The number of structural features of the '<em>Parameter Decl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_DECL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link parametercheck.impl.ParameterUsageImpl <em>Parameter Usage</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see parametercheck.impl.ParameterUsageImpl
   * @see parametercheck.impl.ParametercheckPackageImpl#getParameterUsage()
   * @generated
   */
  int PARAMETER_USAGE = 3;

  /**
   * The number of structural features of the '<em>Parameter Usage</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_USAGE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link parametercheck.impl.DeclaredParameterImpl <em>Declared Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see parametercheck.impl.DeclaredParameterImpl
   * @see parametercheck.impl.ParametercheckPackageImpl#getDeclaredParameter()
   * @generated
   */
  int DECLARED_PARAMETER = 4;

  /**
   * The feature id for the '<em><b>Parameter</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARED_PARAMETER__PARAMETER = PARAMETER_USAGE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>As String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARED_PARAMETER__AS_STRING = PARAMETER_USAGE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Declared Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARED_PARAMETER_FEATURE_COUNT = PARAMETER_USAGE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link parametercheck.impl.LiteralImpl <em>Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see parametercheck.impl.LiteralImpl
   * @see parametercheck.impl.ParametercheckPackageImpl#getLiteral()
   * @generated
   */
  int LITERAL = 5;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL__VALUE = PARAMETER_USAGE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_FEATURE_COUNT = PARAMETER_USAGE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link parametercheck.impl.CheckImpl <em>Check</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see parametercheck.impl.CheckImpl
   * @see parametercheck.impl.ParametercheckPackageImpl#getCheck()
   * @generated
   */
  int CHECK = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHECK__NAME = 0;

  /**
   * The feature id for the '<em><b>Parameterusage</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHECK__PARAMETERUSAGE = 1;

  /**
   * The feature id for the '<em><b>Exception</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHECK__EXCEPTION = 2;

  /**
   * The feature id for the '<em><b>Exception If True</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHECK__EXCEPTION_IF_TRUE = 3;

  /**
   * The feature id for the '<em><b>Parentmethod</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHECK__PARENTMETHOD = 4;

  /**
   * The number of structural features of the '<em>Check</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHECK_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link parametercheck.impl.ExceptionImpl <em>Exception</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see parametercheck.impl.ExceptionImpl
   * @see parametercheck.impl.ParametercheckPackageImpl#getException()
   * @generated
   */
  int EXCEPTION = 7;

  /**
   * The feature id for the '<em><b>Package</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXCEPTION__PACKAGE = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXCEPTION__NAME = 1;

  /**
   * The feature id for the '<em><b>Parameterusage</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXCEPTION__PARAMETERUSAGE = 2;

  /**
   * The feature id for the '<em><b>Parentcheck</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXCEPTION__PARENTCHECK = 3;

  /**
   * The number of structural features of the '<em>Exception</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXCEPTION_FEATURE_COUNT = 4;


  /**
   * Returns the meta object for class '{@link parametercheck.ParameterCheckModel <em>Parameter Check Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter Check Model</em>'.
   * @see parametercheck.ParameterCheckModel
   * @generated
   */
  EClass getParameterCheckModel();

  /**
   * Returns the meta object for the containment reference list '{@link parametercheck.ParameterCheckModel#getMethod <em>Method</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Method</em>'.
   * @see parametercheck.ParameterCheckModel#getMethod()
   * @see #getParameterCheckModel()
   * @generated
   */
  EReference getParameterCheckModel_Method();

  /**
   * Returns the meta object for class '{@link parametercheck.Method <em>Method</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Method</em>'.
   * @see parametercheck.Method
   * @generated
   */
  EClass getMethod();

  /**
   * Returns the meta object for the containment reference list '{@link parametercheck.Method#getParameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameter</em>'.
   * @see parametercheck.Method#getParameter()
   * @see #getMethod()
   * @generated
   */
  EReference getMethod_Parameter();

  /**
   * Returns the meta object for the attribute '{@link parametercheck.Method#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see parametercheck.Method#getName()
   * @see #getMethod()
   * @generated
   */
  EAttribute getMethod_Name();

  /**
   * Returns the meta object for the containment reference list '{@link parametercheck.Method#getCheck <em>Check</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Check</em>'.
   * @see parametercheck.Method#getCheck()
   * @see #getMethod()
   * @generated
   */
  EReference getMethod_Check();

  /**
   * Returns the meta object for class '{@link parametercheck.ParameterDecl <em>Parameter Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter Decl</em>'.
   * @see parametercheck.ParameterDecl
   * @generated
   */
  EClass getParameterDecl();

  /**
   * Returns the meta object for the attribute '{@link parametercheck.ParameterDecl#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see parametercheck.ParameterDecl#getName()
   * @see #getParameterDecl()
   * @generated
   */
  EAttribute getParameterDecl_Name();

  /**
   * Returns the meta object for the attribute '{@link parametercheck.ParameterDecl#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see parametercheck.ParameterDecl#getType()
   * @see #getParameterDecl()
   * @generated
   */
  EAttribute getParameterDecl_Type();

  /**
   * Returns the meta object for class '{@link parametercheck.ParameterUsage <em>Parameter Usage</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter Usage</em>'.
   * @see parametercheck.ParameterUsage
   * @generated
   */
  EClass getParameterUsage();

  /**
   * Returns the meta object for class '{@link parametercheck.DeclaredParameter <em>Declared Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Declared Parameter</em>'.
   * @see parametercheck.DeclaredParameter
   * @generated
   */
  EClass getDeclaredParameter();

  /**
   * Returns the meta object for the reference '{@link parametercheck.DeclaredParameter#getParameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Parameter</em>'.
   * @see parametercheck.DeclaredParameter#getParameter()
   * @see #getDeclaredParameter()
   * @generated
   */
  EReference getDeclaredParameter_Parameter();

  /**
   * Returns the meta object for the attribute '{@link parametercheck.DeclaredParameter#getAsString <em>As String</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>As String</em>'.
   * @see parametercheck.DeclaredParameter#getAsString()
   * @see #getDeclaredParameter()
   * @generated
   */
  EAttribute getDeclaredParameter_AsString();

  /**
   * Returns the meta object for class '{@link parametercheck.Literal <em>Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Literal</em>'.
   * @see parametercheck.Literal
   * @generated
   */
  EClass getLiteral();

  /**
   * Returns the meta object for the attribute '{@link parametercheck.Literal#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see parametercheck.Literal#getValue()
   * @see #getLiteral()
   * @generated
   */
  EAttribute getLiteral_Value();

  /**
   * Returns the meta object for class '{@link parametercheck.Check <em>Check</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Check</em>'.
   * @see parametercheck.Check
   * @generated
   */
  EClass getCheck();

  /**
   * Returns the meta object for the attribute '{@link parametercheck.Check#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see parametercheck.Check#getName()
   * @see #getCheck()
   * @generated
   */
  EAttribute getCheck_Name();

  /**
   * Returns the meta object for the containment reference list '{@link parametercheck.Check#getParameterusage <em>Parameterusage</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameterusage</em>'.
   * @see parametercheck.Check#getParameterusage()
   * @see #getCheck()
   * @generated
   */
  EReference getCheck_Parameterusage();

  /**
   * Returns the meta object for the containment reference '{@link parametercheck.Check#getException <em>Exception</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Exception</em>'.
   * @see parametercheck.Check#getException()
   * @see #getCheck()
   * @generated
   */
  EReference getCheck_Exception();

  /**
   * Returns the meta object for the attribute '{@link parametercheck.Check#isExceptionIfTrue <em>Exception If True</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Exception If True</em>'.
   * @see parametercheck.Check#isExceptionIfTrue()
   * @see #getCheck()
   * @generated
   */
  EAttribute getCheck_ExceptionIfTrue();

  /**
   * Returns the meta object for the container reference '{@link parametercheck.Check#getParentmethod <em>Parentmethod</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Parentmethod</em>'.
   * @see parametercheck.Check#getParentmethod()
   * @see #getCheck()
   * @generated
   */
  EReference getCheck_Parentmethod();

  /**
   * Returns the meta object for class '{@link parametercheck.Exception <em>Exception</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Exception</em>'.
   * @see parametercheck.Exception
   * @generated
   */
  EClass getException();

  /**
   * Returns the meta object for the attribute '{@link parametercheck.Exception#getPackage <em>Package</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Package</em>'.
   * @see parametercheck.Exception#getPackage()
   * @see #getException()
   * @generated
   */
  EAttribute getException_Package();

  /**
   * Returns the meta object for the attribute '{@link parametercheck.Exception#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see parametercheck.Exception#getName()
   * @see #getException()
   * @generated
   */
  EAttribute getException_Name();

  /**
   * Returns the meta object for the containment reference list '{@link parametercheck.Exception#getParameterusage <em>Parameterusage</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameterusage</em>'.
   * @see parametercheck.Exception#getParameterusage()
   * @see #getException()
   * @generated
   */
  EReference getException_Parameterusage();

  /**
   * Returns the meta object for the container reference '{@link parametercheck.Exception#getParentcheck <em>Parentcheck</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Parentcheck</em>'.
   * @see parametercheck.Exception#getParentcheck()
   * @see #getException()
   * @generated
   */
  EReference getException_Parentcheck();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ParametercheckFactory getParametercheckFactory();

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
  interface Literals
  {
    /**
     * The meta object literal for the '{@link parametercheck.impl.ParameterCheckModelImpl <em>Parameter Check Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see parametercheck.impl.ParameterCheckModelImpl
     * @see parametercheck.impl.ParametercheckPackageImpl#getParameterCheckModel()
     * @generated
     */
    EClass PARAMETER_CHECK_MODEL = eINSTANCE.getParameterCheckModel();

    /**
     * The meta object literal for the '<em><b>Method</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAMETER_CHECK_MODEL__METHOD = eINSTANCE.getParameterCheckModel_Method();

    /**
     * The meta object literal for the '{@link parametercheck.impl.MethodImpl <em>Method</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see parametercheck.impl.MethodImpl
     * @see parametercheck.impl.ParametercheckPackageImpl#getMethod()
     * @generated
     */
    EClass METHOD = eINSTANCE.getMethod();

    /**
     * The meta object literal for the '<em><b>Parameter</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference METHOD__PARAMETER = eINSTANCE.getMethod_Parameter();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute METHOD__NAME = eINSTANCE.getMethod_Name();

    /**
     * The meta object literal for the '<em><b>Check</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference METHOD__CHECK = eINSTANCE.getMethod_Check();

    /**
     * The meta object literal for the '{@link parametercheck.impl.ParameterDeclImpl <em>Parameter Decl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see parametercheck.impl.ParameterDeclImpl
     * @see parametercheck.impl.ParametercheckPackageImpl#getParameterDecl()
     * @generated
     */
    EClass PARAMETER_DECL = eINSTANCE.getParameterDecl();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARAMETER_DECL__NAME = eINSTANCE.getParameterDecl_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARAMETER_DECL__TYPE = eINSTANCE.getParameterDecl_Type();

    /**
     * The meta object literal for the '{@link parametercheck.impl.ParameterUsageImpl <em>Parameter Usage</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see parametercheck.impl.ParameterUsageImpl
     * @see parametercheck.impl.ParametercheckPackageImpl#getParameterUsage()
     * @generated
     */
    EClass PARAMETER_USAGE = eINSTANCE.getParameterUsage();

    /**
     * The meta object literal for the '{@link parametercheck.impl.DeclaredParameterImpl <em>Declared Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see parametercheck.impl.DeclaredParameterImpl
     * @see parametercheck.impl.ParametercheckPackageImpl#getDeclaredParameter()
     * @generated
     */
    EClass DECLARED_PARAMETER = eINSTANCE.getDeclaredParameter();

    /**
     * The meta object literal for the '<em><b>Parameter</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECLARED_PARAMETER__PARAMETER = eINSTANCE.getDeclaredParameter_Parameter();

    /**
     * The meta object literal for the '<em><b>As String</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DECLARED_PARAMETER__AS_STRING = eINSTANCE.getDeclaredParameter_AsString();

    /**
     * The meta object literal for the '{@link parametercheck.impl.LiteralImpl <em>Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see parametercheck.impl.LiteralImpl
     * @see parametercheck.impl.ParametercheckPackageImpl#getLiteral()
     * @generated
     */
    EClass LITERAL = eINSTANCE.getLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LITERAL__VALUE = eINSTANCE.getLiteral_Value();

    /**
     * The meta object literal for the '{@link parametercheck.impl.CheckImpl <em>Check</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see parametercheck.impl.CheckImpl
     * @see parametercheck.impl.ParametercheckPackageImpl#getCheck()
     * @generated
     */
    EClass CHECK = eINSTANCE.getCheck();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CHECK__NAME = eINSTANCE.getCheck_Name();

    /**
     * The meta object literal for the '<em><b>Parameterusage</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CHECK__PARAMETERUSAGE = eINSTANCE.getCheck_Parameterusage();

    /**
     * The meta object literal for the '<em><b>Exception</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CHECK__EXCEPTION = eINSTANCE.getCheck_Exception();

    /**
     * The meta object literal for the '<em><b>Exception If True</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CHECK__EXCEPTION_IF_TRUE = eINSTANCE.getCheck_ExceptionIfTrue();

    /**
     * The meta object literal for the '<em><b>Parentmethod</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CHECK__PARENTMETHOD = eINSTANCE.getCheck_Parentmethod();

    /**
     * The meta object literal for the '{@link parametercheck.impl.ExceptionImpl <em>Exception</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see parametercheck.impl.ExceptionImpl
     * @see parametercheck.impl.ParametercheckPackageImpl#getException()
     * @generated
     */
    EClass EXCEPTION = eINSTANCE.getException();

    /**
     * The meta object literal for the '<em><b>Package</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXCEPTION__PACKAGE = eINSTANCE.getException_Package();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXCEPTION__NAME = eINSTANCE.getException_Name();

    /**
     * The meta object literal for the '<em><b>Parameterusage</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXCEPTION__PARAMETERUSAGE = eINSTANCE.getException_Parameterusage();

    /**
     * The meta object literal for the '<em><b>Parentcheck</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXCEPTION__PARENTCHECK = eINSTANCE.getException_Parentcheck();

  }

} //ParametercheckPackage
