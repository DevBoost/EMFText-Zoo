package org.emftext.language.java;

import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

public class JavaUniquePathConstructor {
	
	private static final String CLASSIFIERS_PATH_PREFIX = "//@classifiers[name='";
	private static final String PATH_SUFIX = "']";
	
	public static final String JAVA_PATHMAP = "pathmap://java/";
	public static final String DEFAULT_PACKAGE_NAME = "default";
	
	public static String convertClassifierURIToFragmentPart(URI proxyURI) {
		return proxyURI.toString().substring(JAVA_PATHMAP.length());
	}
	
	protected static String getClassifierURIFragmentPart(TypeReferenceSequence typeReferenceSequence) {
		Type type = (Type) typeReferenceSequence.eGet(JavaPackage.Literals.PACKAGE_OR_CLASSIFIER_REFERENCE__TARGET, false);
	
		//TODO handle primitive type individually
		if (type != null) {
			if (!type.eIsProxy()) {
				return convertClassifierURIToFragmentPart(type.eResource().getURI());
			}
			else {
				return convertClassifierURIToFragmentPart(((InternalEObject)type).eProxyURI());
			}
		}
		return "undefined";
		
	}
	
	protected static String getClassifierURIFragmentPart(Reference reference) {
		TypeReferenceSequence typeReferenceSequence = null;
		
		//referenced element point to a type
		if (reference instanceof  TypedElement) {
			typeReferenceSequence = ((TypedElement) reference).getType();
		}
		//referenced element points to an element with a type
		else if (reference.getPrimary() instanceof PackageOrClassifierOrMethodOrVariableReference) {
			ReferenceableElement target = (ReferenceableElement) 
				((PackageOrClassifierOrMethodOrVariableReference) reference.getPrimary()).eGet(
					JavaPackage.Literals.PACKAGE_OR_CLASSIFIER_OR_METHOD_OR_VARIABLE_REFERENCE__TARGET, false);
			
			if (target.eIsProxy()) {
				URI proxyURI = ((InternalEObject)target).eProxyURI();
				if(!proxyURI.fragment().startsWith("@")) { //TODO this is an internal proxy, how do we check this best?
					return null;
				}

				return proxyURI.toString();
			}
			if (target instanceof TypedElement) {
				typeReferenceSequence = ((TypedElement) target).getType();
			}
		}
		else {
			//TODO  other cases?
		}	

		return getClassifierURIFragmentPart(typeReferenceSequence);
	}
	
	protected static String getClassifierURIFragmentPart(Expression argument) {
	
		Reference reference = null;
		
		if (argument instanceof Assignment) {
			Assignment assignment = (Assignment) argument;
			reference = assignment.getTarget();
		}
		
		//navigate down the expression tree until we reach a primary
		for(Iterator<EObject> it = argument.eAllContents(); it.hasNext(); ) {
			EObject child = it.next();
			if (child instanceof Primary) {
				Primary primary = (Primary) child;
				reference = primary.getReference();
				break;
			}
		}
		
		
		if (argument instanceof UnaryExpression) {
			reference = ((UnaryExpression)argument).getUnaryExpressionNotPlusMinus().getPrimary().getReference();
		}
		
		//TODO what other cases need to be considered here
		//TODO jjohannes reference can be null here! see bug 581
		//TODO @mseifert why is Reference.next a list?
		while (!reference.getNext().isEmpty()) {
			//find the last reference
			reference = reference.getNext().get(0);
		}

		
		return getClassifierURIFragmentPart(reference);
	}
	

	
	public static URI getClassifierResourceURI(String packageName, String name) {
		//TODO construct different if the packageName contains Classes and name points at an inner class
		URI logicalUriString = 
			URI.createURI(JAVA_PATHMAP + packageName + "/" + name + ".java");
		
		return logicalUriString;
	}
	
	public static URI getClassifierURI(String packageName, String name) {
		URI logicalUriString = getClassifierResourceURI(packageName, name);
		//TODO construct different if the packageName contains Classes and name points at an inner class
		logicalUriString = logicalUriString.appendFragment(CLASSIFIERS_PATH_PREFIX + name + PATH_SUFIX);
		return logicalUriString;
	}
	
	public static boolean pointsAtClassifie(URI proxyURI, String classifierName) {
		if(!proxyURI.fragment().startsWith(CLASSIFIERS_PATH_PREFIX)) {
			return false;
		}
		String nameInProxy = proxyURI.fragment().substring(CLASSIFIERS_PATH_PREFIX.length());
		nameInProxy = nameInProxy.substring(0, nameInProxy.length() - PATH_SUFIX.length());
		return nameInProxy.equals(classifierName);
	}

	public static String packageName(CompilationUnit cu) {
		String packageName = null;
		for(String packageNameFragment : cu.getPackage()) {
			if (packageName == null) {
				packageName = packageNameFragment;
			}
			else {
				packageName = packageName + "." + packageNameFragment;
			}
		}
		
		if (packageName == null) {
			packageName = DEFAULT_PACKAGE_NAME;
		}
		return packageName;
	}
}
