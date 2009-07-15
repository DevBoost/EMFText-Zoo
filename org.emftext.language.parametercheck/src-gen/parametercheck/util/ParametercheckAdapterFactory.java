/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package parametercheck.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import parametercheck.Check;
import parametercheck.DeclaredParameter;
import parametercheck.Literal;
import parametercheck.Method;
import parametercheck.ParameterCheckModel;
import parametercheck.ParameterDecl;
import parametercheck.ParameterUsage;
import parametercheck.ParametercheckPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see parametercheck.ParametercheckPackage
 * @generated
 */
public class ParametercheckAdapterFactory extends AdapterFactoryImpl {
	/**
   * The cached model package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected static ParametercheckPackage modelPackage;

	/**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ParametercheckAdapterFactory() {
    if (modelPackage == null)
    {
      modelPackage = ParametercheckPackage.eINSTANCE;
    }
  }

	/**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
	@Override
	public boolean isFactoryForType(Object object) {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

	/**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected ParametercheckSwitch<Adapter> modelSwitch =
		new ParametercheckSwitch<Adapter>()
    {
      @Override
      public Adapter caseParameterCheckModel(ParameterCheckModel object)
      {
        return createParameterCheckModelAdapter();
      }
      @Override
      public Adapter caseMethod(Method object)
      {
        return createMethodAdapter();
      }
      @Override
      public Adapter caseParameterDecl(ParameterDecl object)
      {
        return createParameterDeclAdapter();
      }
      @Override
      public Adapter caseParameterUsage(ParameterUsage object)
      {
        return createParameterUsageAdapter();
      }
      @Override
      public Adapter caseDeclaredParameter(DeclaredParameter object)
      {
        return createDeclaredParameterAdapter();
      }
      @Override
      public Adapter caseLiteral(Literal object)
      {
        return createLiteralAdapter();
      }
      @Override
      public Adapter caseCheck(Check object)
      {
        return createCheckAdapter();
      }
      @Override
      public Adapter caseException(parametercheck.Exception object)
      {
        return createExceptionAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

	/**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
	@Override
	public Adapter createAdapter(Notifier target) {
    return modelSwitch.doSwitch((EObject)target);
  }


	/**
   * Creates a new adapter for an object of class '{@link parametercheck.ParameterCheckModel <em>Parameter Check Model</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see parametercheck.ParameterCheckModel
   * @generated
   */
	public Adapter createParameterCheckModelAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link parametercheck.Method <em>Method</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see parametercheck.Method
   * @generated
   */
	public Adapter createMethodAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link parametercheck.ParameterDecl <em>Parameter Decl</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see parametercheck.ParameterDecl
   * @generated
   */
	public Adapter createParameterDeclAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link parametercheck.ParameterUsage <em>Parameter Usage</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see parametercheck.ParameterUsage
   * @generated
   */
	public Adapter createParameterUsageAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link parametercheck.DeclaredParameter <em>Declared Parameter</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see parametercheck.DeclaredParameter
   * @generated
   */
	public Adapter createDeclaredParameterAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link parametercheck.Literal <em>Literal</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see parametercheck.Literal
   * @generated
   */
	public Adapter createLiteralAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link parametercheck.Check <em>Check</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see parametercheck.Check
   * @generated
   */
	public Adapter createCheckAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link parametercheck.Exception <em>Exception</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see parametercheck.Exception
   * @generated
   */
	public Adapter createExceptionAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
	public Adapter createEObjectAdapter() {
    return null;
  }

} //ParametercheckAdapterFactory
