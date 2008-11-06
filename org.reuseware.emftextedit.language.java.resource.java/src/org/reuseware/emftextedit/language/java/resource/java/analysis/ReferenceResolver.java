package org.reuseware.emftextedit.language.java.resource.java.analysis;

import java.lang.reflect.Method;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.reuseware.emftextedit.language.java.Assignment;
import org.reuseware.emftextedit.language.java.Expression;
import org.reuseware.emftextedit.language.java.JavaFactory;
import org.reuseware.emftextedit.language.java.JavaPackage;
import org.reuseware.emftextedit.language.java.NamedElement;
import org.reuseware.emftextedit.language.java.PackageOrClassifierOrMethodOrVariableReference;
import org.reuseware.emftextedit.language.java.PackageOrClassifierReference;
import org.reuseware.emftextedit.language.java.PrimaryReference;
import org.reuseware.emftextedit.language.java.Reference;
import org.reuseware.emftextedit.language.java.ReferenceableElement;
import org.reuseware.emftextedit.language.java.Type;
import org.reuseware.emftextedit.language.java.TypeReference;
import org.reuseware.emftextedit.language.java.TypeReferenceSequence;
import org.reuseware.emftextedit.language.java.TypedElement;
import org.reuseware.emftextedit.resource.TextResource;
import org.reuseware.emftextedit.resource.impl.ProxyResolverImpl;

public abstract class ReferenceResolver extends ProxyResolverImpl {

	//candidates for template methods
	
	protected boolean breakIfNext(EObject element, EClass typeToResolve) {
		if (element instanceof org.reuseware.emftextedit.language.java.Class) {
			return false;
		}
		if (element instanceof org.reuseware.emftextedit.language.java.CompilationUnit) {
			return false;
		}
		return true;
	}
	
	protected boolean breakIfChild(EObject element, EClass typeToResolve)  {
		if (typeToResolve.equals(JavaPackage.Literals.METHOD) &&
				element instanceof org.reuseware.emftextedit.language.java.Class) {
			return true;
		}
		if (element instanceof org.reuseware.emftextedit.language.java.Block) {
			return true;
		}
		return false;
	}
	
	//-------------
	
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
		
		try {
			String id = proxy.eProxyURI().fragment();
			
			if (!(container.eContainer() instanceof Reference)) {
				//direct primary reference: resolve in scope of the current compilation unit
				return findScoped(id, container, container, reference.getEReferenceType());
			}
			
			Reference ref = (Reference) container.eContainer();

			if (ref.eContainer() instanceof Reference) {
				//chained reference: scope given by previous element in chain
				Type previousType = getTypeOfReferencedElement((Reference)ref.eContainer());
				if (previousType != null) {
					return find(id, container, null, previousType, reference.getEReferenceType());
				}
				else {
					return null;
				}
			}
			else {
				//reference in scope of the current compilation unit
				return findScoped(id, container, container, reference.getEReferenceType());
			}
		} catch (UnresolvedProxiesException e) {
			return null;
		}
	}
	

	protected EObject findScoped(String id, EObject context, EObject endOfScopeElement,
			EClass type) throws UnresolvedProxiesException {
		
		EObject container = endOfScopeElement.eContainer();
		
		//termination, no more scope to search in
		if(container == null) {
			//this could be an external reference
			return resolveExternal(id, container, type);
		}
		
		EObject result = find(id, context, endOfScopeElement, container, type);

		if (result != null) {
			return result;
		}
		
		//search in next scope
		return findScoped(id, context, container, type);
	}

	protected EObject find(String id, EObject context, EObject element,  EObject container, EClass type) throws UnresolvedProxiesException {
		for(EObject cand : container.eContents()) {
			//the reference has to be defined prior to the referencing element
			if(breakIfNext(container, type)) {
				if (cand.equals(element)) {
					break;
				}
			}
			if(hasCorrectType(cand, type)) {
				if (isReferencedElement(id, context, cand)) {
					return cand;
				}
			}
			//consider also children
			for(TreeIterator<EObject> it = cand.eAllContents(); it.hasNext(); ) {
				EObject subCand = it.next();
				if (breakIfChild(subCand, type)) {
					it.prune();
				}
				else {
					if(hasCorrectType(subCand, type)) {
						if (isReferencedElement(id, context, subCand)) {
							return subCand;
						}
					}
				}
			}
		}
		return null;
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
	
	public Type getTypeOfReferencedElement(EObject value) throws UnresolvedProxiesException {
		Type type = null;
		
		if (value instanceof Reference) {
			Reference reference = (Reference) value;
			PrimaryReference primaryRef = reference.getPrimary();
			//referenced element point to a type
			if (primaryRef instanceof TypedElement /*NewConstructorCall*/) {
				TypeReference typeRef = ((TypedElement) primaryRef).getType();
				type = getReferencedType(typeRef);
			}
			//referenced element points to an element with a type
			else if (primaryRef instanceof PackageOrClassifierOrMethodOrVariableReference) {
				ReferenceableElement target = ((PackageOrClassifierOrMethodOrVariableReference) primaryRef).getTarget();
				if (target.eIsProxy()) {
					throw new UnresolvedProxiesException();
				}
				
				if (target instanceof TypedElement) {
					TypeReference typeRef = ((TypedElement) target).getType();
					type = getReferencedType(typeRef);
				}
			}
		}
		else {
			//TODO what other cases?
		}
		
		return type;
	}

	public Type getReferencedType(TypeReference typeRef) throws UnresolvedProxiesException {
		Type type = null;
		if (typeRef instanceof TypeReferenceSequence) {
			//TODO @mseifert is it okay that e.g. a ConstructorCall has a list of types?
			PackageOrClassifierReference classRef = ((TypeReferenceSequence) typeRef).getParts().get(0);
			type = classRef.getTarget();
			
		}

		
		//TODO handle primitive type individually
		
		if (type == null || type.eIsProxy()) {
			throw new UnresolvedProxiesException();
		}
		
		return type;
	}
	
	
	public EList<Type> getArgumentTypes(PackageOrClassifierOrMethodOrVariableReference primaryRef) throws UnresolvedProxiesException {
		
		EList<Type> resultList = new BasicEList<Type>();
		
		for(Expression arg : primaryRef.getArguments()) {
			if (arg instanceof Assignment) {
				Assignment assignment = (Assignment) arg;
				Reference reference = assignment.getTarget();
				//TODO @mseifert why is Reference.next a list?
				while (!reference.getNext().isEmpty()) {
					//find the last reference
					reference = reference.getNext().get(0);
				}
				Type type = getTypeOfReferencedElement(assignment.getTarget());
				resultList.add(type);
			}
			
			//TODO what other cases need to be considered here
		}
		
		
		//TODO handle primitive type indivdually
		
		return resultList;
	}
	
	protected boolean isReferencedElement(String id, EObject context, EObject referencedElement) throws UnresolvedProxiesException {
		boolean result = false;
		
		if(referencedElement instanceof NamedElement) {
			
			result = id.equals(((NamedElement) referencedElement).getName());
			if (result && referencedElement instanceof org.reuseware.emftextedit.language.java.Method) {
				org.reuseware.emftextedit.language.java.Method method = (org.reuseware.emftextedit.language.java.Method) referencedElement;
				if (context instanceof PackageOrClassifierOrMethodOrVariableReference) {
					PackageOrClassifierOrMethodOrVariableReference reference = (PackageOrClassifierOrMethodOrVariableReference)context; 
					EList<Type> argumentTypes = getArgumentTypes(reference);
					if (method.getParameters().size() == argumentTypes.size()) {
						for (int i = 0; i < argumentTypes.size(); i++) {
							Type type = getReferencedType(method.getParameters().get(i).getType());
							Type argumentType = argumentTypes.get(i);
							if (argumentType == null) {
								break;
							}
							if (!argumentType.equals(type)) {
								result = false;
								break;
							}
						}
					}
					else {
						result = false;
					}
				}
			}
		}
		return result;
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
