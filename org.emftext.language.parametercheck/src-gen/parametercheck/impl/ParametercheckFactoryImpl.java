/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package parametercheck.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import parametercheck.Check;
import parametercheck.DeclaredParameter;
import parametercheck.Literal;
import parametercheck.Method;
import parametercheck.ParameterCheckModel;
import parametercheck.ParameterDecl;
import parametercheck.ParametercheckFactory;
import parametercheck.ParametercheckPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ParametercheckFactoryImpl extends EFactoryImpl implements ParametercheckFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ParametercheckFactory init() {
		try {
			ParametercheckFactory theParametercheckFactory = (ParametercheckFactory)EPackage.Registry.INSTANCE.getEFactory("http://deftproject.org/parametercheck"); 
			if (theParametercheckFactory != null) {
				return theParametercheckFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ParametercheckFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParametercheckFactoryImpl() {
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
			case ParametercheckPackage.PARAMETER_CHECK_MODEL: return createParameterCheckModel();
			case ParametercheckPackage.METHOD: return createMethod();
			case ParametercheckPackage.PARAMETER_DECL: return createParameterDecl();
			case ParametercheckPackage.DECLARED_PARAMETER: return createDeclaredParameter();
			case ParametercheckPackage.LITERAL: return createLiteral();
			case ParametercheckPackage.CHECK: return createCheck();
			case ParametercheckPackage.EXCEPTION: return createException();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterCheckModel createParameterCheckModel() {
		ParameterCheckModelImpl parameterCheckModel = new ParameterCheckModelImpl();
		return parameterCheckModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Method createMethod() {
		MethodImpl method = new MethodImpl();
		return method;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterDecl createParameterDecl() {
		ParameterDeclImpl parameterDecl = new ParameterDeclImpl();
		return parameterDecl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeclaredParameter createDeclaredParameter() {
		DeclaredParameterImpl declaredParameter = new DeclaredParameterImpl();
		return declaredParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Literal createLiteral() {
		LiteralImpl literal = new LiteralImpl();
		return literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Check createCheck() {
		CheckImpl check = new CheckImpl();
		return check;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public parametercheck.Exception createException() {
		ExceptionImpl exception = new ExceptionImpl();
		return exception;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParametercheckPackage getParametercheckPackage() {
		return (ParametercheckPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ParametercheckPackage getPackage() {
		return ParametercheckPackage.eINSTANCE;
	}

} //ParametercheckFactoryImpl
