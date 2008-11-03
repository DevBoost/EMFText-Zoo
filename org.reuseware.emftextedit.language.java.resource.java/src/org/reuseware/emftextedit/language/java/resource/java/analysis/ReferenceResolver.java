package org.reuseware.emftextedit.language.java.resource.java.analysis;

import java.lang.reflect.Method;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.reuseware.emftextedit.language.java.JavaFactory;
import org.reuseware.emftextedit.language.java.NamedElement;
import org.reuseware.emftextedit.language.java.PackageOrClassifierOrMethodOrVariableReference;
import org.reuseware.emftextedit.language.java.PackageOrClassifierReference;
import org.reuseware.emftextedit.language.java.PrimaryReference;
import org.reuseware.emftextedit.language.java.Reference;
import org.reuseware.emftextedit.resource.TextResource;
import org.reuseware.emftextedit.resource.impl.ProxyResolverImpl;

public abstract class ReferenceResolver extends ProxyResolverImpl {

	@Override
	protected String doDeResolve(EObject element, EObject container,
			EReference reference) {
		
		if (element instanceof NamedElement) {
			return ((NamedElement) element).getName();
		}
		else {
			return super.deResolve(element, container, reference);
		}
	}

	@Override
	protected EObject doResolve(InternalEObject proxy, EObject container,
			EReference reference, TextResource resource) {
		
		if (!(container.eContainer() instanceof Reference)) return null;
		
		//TODO: @mseifert should TypeReferenceSequence be a subclass of Reference?
		
		Reference ref = (Reference) container.eContainer();
		String id = proxy.eProxyURI().fragment();
		
		if (ref.eContainer() instanceof Reference) {
			//chained references
			PrimaryReference previousRef = ((Reference)ref.eContainer()).getPrimary();
			if (previousRef instanceof PackageOrClassifierOrMethodOrVariableReference) {
				EObject previous = ((PackageOrClassifierOrMethodOrVariableReference) previousRef).getTarget();
				return find(id, null, previous, reference.getEReferenceType());
			}
			else if (previousRef instanceof PackageOrClassifierReference) {
				EObject previous = ((PackageOrClassifierReference) previousRef).getTarget();
				return find(id, null, previous, reference.getEReferenceType());
			}
			else {
				return null;
			}
		}
		else {
			//reference in scope
			return findScoped(id, container, reference.getEReferenceType());
		}
	}
	

	protected EObject findScoped(String id, EObject element,
			EClass type) {
		
		EObject container = element.eContainer();
		
		//termination, no more scope to search in
		if(container == null) {
			//this could be an external reference
			return resolveExternal(id, container, type);
		}
		
		EObject result = find(id, element, container, type);

		if (result != null) {
			return result;
		}
		
		//search in next scope
		return findScoped(id, container, type);
	}

	protected EObject find(String id, EObject element,  EObject container, EClass type) {
		for(EObject cand : container.eContents()) {
			//the reference has to be defined prior to the referencing element
			if(considerOrder(container)) {
				if (cand.equals(element)) {
					break;
				}
			}
			if(hasCorrectType(cand, type)) {
				if (isReferencedElement(id, cand)) {
					return cand;
				}
			}
		}
		return null;
	}
	
	protected boolean considerOrder(EObject container) {
		if (container instanceof org.reuseware.emftextedit.language.java.Class) {
			return false;
		}
		
		
		return true;
	}
	
	protected boolean hasCorrectType(EObject object, EClass eClass) {
		if(object.eClass().equals(eClass)) {
			return true;
		}
		for(EClass superType : object.eClass().getEAllSuperTypes()) {
			if(eClass.equals(superType)) {
				return true;
			}
		}
		return false;
	}
	
	protected boolean isReferencedElement(String id, EObject referencedElement) {
		if(referencedElement instanceof NamedElement) {
			return id.equals(((NamedElement) referencedElement).getName());
		}
		return false;
	}

	
	//External types
	private final static JavaFactory theJavaFactory = (JavaFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.reuseware.org/java"); 
	
	protected EObject resolveExternal(String id, EObject container,
			EClass type) {
		
		String classOrPackageName = id;
		
		//TODO rewrite URI to external URI, which scheme should be used?
		
		
		return null;
	
		/*String qualifiedName = getQualifiedClassName(container, proxy);
		EObject classFromClassPath = doResolveFromClasspathUsingReflection(qualifiedName, className);
		if (classFromClassPath != null) {
			return classFromClassPath;
		}
		org.reuseware.emftextedit.language.java.Class externalClassOrPackage = theJavaFactory.createClass();
		externalClassOrPackage.setName(className);
		return externalClassOrPackage;*/
	}

	protected EObject doResolveFromClasspathUsingReflection(String qualifiedName, String name) {
		
		Class<?> theCLass;
		try {
			theCLass = Class.forName(qualifiedName);
			
			org.reuseware.emftextedit.language.java.Class importedClass = theJavaFactory.createClass();
			importedClass.setName(name);
			
			for(Method aMethod : theCLass.getMethods()) {
				org.reuseware.emftextedit.language.java.Method member = theJavaFactory.createMethod();
				member.setName(aMethod.getName());
				importedClass.getMembers().add(member);
			}
			
			// TODO look up remaining elements of the class
			return importedClass;
		} catch (ClassNotFoundException e) {
			// ignore exception
		}
		
		return null;
	}
}
