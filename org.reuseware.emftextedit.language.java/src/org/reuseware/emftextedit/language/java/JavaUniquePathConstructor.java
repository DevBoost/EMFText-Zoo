package org.reuseware.emftextedit.language.java;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.reuseware.emftextedit.language.java.Assignment;
import org.reuseware.emftextedit.language.java.Expression;
import org.reuseware.emftextedit.language.java.Instantiation;
import org.reuseware.emftextedit.language.java.Member;
import org.reuseware.emftextedit.language.java.Method;
import org.reuseware.emftextedit.language.java.PackageOrClassifierOrMethodOrVariableReference;
import org.reuseware.emftextedit.language.java.PackageOrClassifierReference;
import org.reuseware.emftextedit.language.java.Parameter;
import org.reuseware.emftextedit.language.java.PrimaryReference;
import org.reuseware.emftextedit.language.java.Reference;
import org.reuseware.emftextedit.language.java.ReferenceableElement;
import org.reuseware.emftextedit.language.java.Type;
import org.reuseware.emftextedit.language.java.TypeReference;
import org.reuseware.emftextedit.language.java.TypeReferenceSequence;
import org.reuseware.emftextedit.language.java.TypedElement;

public class JavaUniquePathConstructor {
	
	private static final String CLASSIFIERS_PATH_PREFIX = "//@classifiers[name='";
	private static final String PATH_SUFIX = "']";
	
	public static final String JAVA_PATHMAP = "pathmap://java/";
	public static final String DEFAULT_PACKAGE_NAME = "default";
	
	public static String convertClassifierURIToFragmentPart(URI proxyURI) {
		return proxyURI.toString().substring(JAVA_PATHMAP.length());
	}
	
	protected static String getClassifierURIFragmentPart(TypeReference typeReference) {
		Type type = null;
		
		if (typeReference instanceof TypeReferenceSequence) {
			//TODO @mseifert is it okay that e.g. a ConstructorCall has a list of types?
			PackageOrClassifierReference classifierReference = 
				((TypeReferenceSequence) typeReference).getParts().get(0);
			type = classifierReference.getTarget();
		}
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
		TypeReference typeReference = null;
		
		//referenced element point to a type
		if (reference instanceof  TypedElement) {
			typeReference = ((TypedElement) reference).getType();
		}
		//referenced element points to an element with a type
		else if (reference instanceof PackageOrClassifierOrMethodOrVariableReference) {
			ReferenceableElement target = 
				((PackageOrClassifierOrMethodOrVariableReference) reference).getTarget();
			
			if (target.eIsProxy()) {
				URI proxyURI = ((InternalEObject)target).eProxyURI();
				proxyURI.appendFragment(""); //TODO use the uri and only remove some part?
				return proxyURI.toString();
			}
			if (target instanceof TypedElement) {
				typeReference = ((TypedElement) target).getType();
			}
		}
		else {
			//TODO  other cases?
		}	
		
		return getClassifierURIFragmentPart(typeReference);
	}
	
	protected static String getClassifierURIFragmentPart(Expression argument) {
	
		Reference reference = null;
		
		if (argument instanceof Assignment) {
			Assignment assignment = (Assignment) argument;
			reference = assignment.getTarget();
			//TODO @mseifert why is Reference.next a list?
			while (!reference.getNext().isEmpty()) {
				//find the last reference
				reference = reference.getNext().get(0);
			}
		}
		
		//TODO what other cases need to be considered here
		
		return getClassifierURIFragmentPart(reference);
	}
	
	public static String getMemberURIFragmentPart(Member member) {

		String uriFragment = "@member[name='" + member.getName();
		
		if (member instanceof Method) {
			uriFragment = uriFragment + "',parameters='";
			for(Parameter param : ((Method) member).getParameters()) {
				String uriFragmentPart = getClassifierURIFragmentPart(param.getType());
				uriFragment = uriFragment + uriFragmentPart + " ";
			}
		}
		
		uriFragment = uriFragment + PATH_SUFIX;
			
		return uriFragment;
	}
	
	
	public static String getMemberURIFragmentPart(PrimaryReference reference, String id) throws UnresolvedProxiesException {

		String uriFragment = "@members[name='" + id;
		
		EList<Expression> arguments = null;
		
		//referenced element point to a type
		if (reference instanceof  Instantiation) {
			arguments = ((Instantiation) reference).getArguments();
		}
		//referenced element points to an element with a type
		else if (reference instanceof PackageOrClassifierOrMethodOrVariableReference) {
			arguments = ((PackageOrClassifierOrMethodOrVariableReference) reference).getArguments();
		}
		else {
			//TODO  other cases?
		}
		
		for(Expression arg : arguments) {
			String uriFragmentPart = getClassifierURIFragmentPart(arg);
			uriFragment = uriFragment + uriFragmentPart + " ";
		}
		
		uriFragment = uriFragment + PATH_SUFIX;
		
		return uriFragment;
	}
	
	
	public static Member getMember(EObject container, String uriFragment) {
		uriFragment = uriFragment.substring(
				uriFragment.indexOf("parameters=") + "parameters=".length(), uriFragment.indexOf("]"));
		
		String[] parameterTypes = uriFragment.split(" ");
		
		for(EObject eObject : container.eContents()) {
			if (eObject instanceof Method) {
				Method method =  (Method) eObject;
				if (parameterTypes.length == method.getParameters().size()) {
					for(Parameter param : method.getParameters()) {
						String paramType = getClassifierURIFragmentPart(param.getType());
						if (!uriFragment.equals(paramType)) {
							return null;
						}
					}
					return method;
				}
			}
		}
		return null;
		
	}
	
	public static boolean isMemberURIFragmentPart(String uriFragment){
		return uriFragment.contains(",parameters=");
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
