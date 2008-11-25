package org.reuseware.emftextedit.language.java.resource.java.analysis;

import java.util.Iterator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.reuseware.emftextedit.language.java.Assignment;
import org.reuseware.emftextedit.language.java.Classifier;
import org.reuseware.emftextedit.language.java.CompilationUnit;
import org.reuseware.emftextedit.language.java.Expression;
import org.reuseware.emftextedit.language.java.Import;
import org.reuseware.emftextedit.language.java.JavaClasspath;
import org.reuseware.emftextedit.language.java.JavaFactory;
import org.reuseware.emftextedit.language.java.JavaPackage;
import org.reuseware.emftextedit.language.java.JavaUniquePathConstructor;
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
import org.reuseware.emftextedit.language.java.UnresolvedProxiesException;
import org.reuseware.emftextedit.runtime.resource.TextResource;
import org.reuseware.emftextedit.runtime.resource.impl.ProxyResolverImpl;

public abstract class ReferenceResolver extends ProxyResolverImpl {

	
	protected TextResource myResource = null;
	
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
		
		EcoreUtil.resolveAll(element);
		
		if (!element.eIsProxy() && (element instanceof NamedElement)) {
			return ((NamedElement) element).getName();
		}
		else {
			return "UNDEFINED"; 
			//TODO ?
		}
	}

	@Override
	protected EObject doResolve(InternalEObject proxy, EObject container,
			EReference reference, TextResource resource) {
		
		myResource = resource;
		
		try {
			EObject result = null;
			
			if (!(container.eContainer() instanceof Reference)) {
				//direct primary reference: resolve in scope of the current compilation unit
				result =  findScoped(proxy, container, container, reference.getEReferenceType());
			}
			else {
				Reference ref = (Reference) container.eContainer();
	
				if (ref.eContainer() instanceof Reference) {
					//chained reference: scope given by previous element in chain
					Type previousType = getTypeOfReferencedElement((Reference)ref.eContainer());
					if (previousType != null) {
						result = find(proxy, container, null, previousType, reference.getEReferenceType());
					}
				}
				else {
					//reference in scope of the current compilation unit
					result = findScoped(proxy, container, container, reference.getEReferenceType());
				}
			}
			
			if (result == null) {
				result = tryToConvertToExternalProxy(proxy, container);		
			}
			return result;
			
		} catch (UnresolvedProxiesException e) {
			return null;
		}
	}

	protected EObject findScoped(InternalEObject proxy, EObject context, EObject endOfScopeElement,
			EClass type) throws UnresolvedProxiesException {
		
		EObject container = endOfScopeElement.eContainer();
		
		//termination, no more scope to search in
		if(container == null) {
			return null;
		}
		
		EObject result = find(proxy, context, endOfScopeElement, container, type);

		if (result != null) {
			return result;
		}
		
		//search in next scope
		return findScoped(proxy, context, container, type);
	}

	protected EObject find(InternalEObject proxy, EObject context, EObject element,  EObject container, EClass type) throws UnresolvedProxiesException {
		EList<EObject> contentsList = new BasicEList<EObject>();
		contentsList.addAll(container.eContents());
		if (container instanceof CompilationUnit) {
			CompilationUnit cu = (CompilationUnit) container;
			String packageName = JavaUniquePathConstructor.packageName(cu);
			contentsList.addAll(JavaClasspath.INSTANCE.getDefaultImports(packageName));
		}
		
		for(EObject cand : contentsList) {
			//the reference has to be defined prior to the referencing element
			if(breakIfNext(container, type)) {
				if (cand.equals(element)) {
					break;
				}
			}
			if(hasCorrectType(cand, type)) {
				if (isReferencedElement(proxy, context, cand)) {
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
						if (isReferencedElement(proxy, context, subCand)) {
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
				ReferenceableElement target = 
					(ReferenceableElement) ((PackageOrClassifierOrMethodOrVariableReference) primaryRef).eGet(
						JavaPackage.Literals.PACKAGE_OR_CLASSIFIER_OR_METHOD_OR_VARIABLE_REFERENCE__TARGET, false);
				if (target.eIsProxy()) {
					if(isInternalProxy((InternalEObject)target)) {
						throw new UnresolvedProxiesException();
					}
					else {
						System.out.println("c");
						URI proxyURI = ((InternalEObject)target).eProxyURI();
						//TODO ??
					}
				}
				
				else if (target instanceof TypedElement) {
					TypeReference typeRef = ((TypedElement) target).getType();
					type = getReferencedType(typeRef);
				}
			}
		}
		else {
			//TODO what other cases?
			System.out.println("X");
		}
		
		return type;
	}

	public Type getReferencedType(TypeReference typeRef) throws UnresolvedProxiesException {
		Type type = null;
		if (typeRef instanceof TypeReferenceSequence) {
			//TODO @mseifert is it okay that e.g. a ConstructorCall has a list of types?
			PackageOrClassifierReference classRef = ((TypeReferenceSequence) typeRef).getParts().get(0);
			type = (Type) classRef.eGet(JavaPackage.Literals.PACKAGE_OR_CLASSIFIER_REFERENCE__TARGET, false);
			if (isInternalProxy((InternalEObject)type)) {
				throw new UnresolvedProxiesException();
			}
		}

		
		//TODO handle primitive type individually
		
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
	
	
	protected boolean isReferencedElement(InternalEObject proxy, EObject context, EObject referencedElement) throws UnresolvedProxiesException {
		boolean result = false;
		
		if(referencedElement instanceof NamedElement) {
			
			String id = proxy.eProxyURI().fragment();
			
			//is it an external proxy 
			if(referencedElement.eIsProxy() && !isInternalProxy((InternalEObject) referencedElement)) {
				if (JavaUniquePathConstructor.pointsAtClassifie(((InternalEObject)referencedElement).eProxyURI(), id)) { 
					return true;
				}
			}
			
			
			result = id.equals(((NamedElement) referencedElement).getName());
			if (result && referencedElement instanceof org.reuseware.emftextedit.language.java.Method) {
				org.reuseware.emftextedit.language.java.Method method = (org.reuseware.emftextedit.language.java.Method) referencedElement;
				if (context instanceof PackageOrClassifierOrMethodOrVariableReference) {
					PackageOrClassifierOrMethodOrVariableReference reference = (PackageOrClassifierOrMethodOrVariableReference)context; 
					EList<Type> argumentTypes = getArgumentTypes(reference);
					if (method.getParameters().size() == argumentTypes.size()) {
						for (int i = 0; i < argumentTypes.size(); i++) {
							InternalEObject type = (InternalEObject) getReferencedType(method.getParameters().get(i).getType());
							InternalEObject argumentType = (InternalEObject) argumentTypes.get(i);
							if (argumentType == null) {
								break;
							}
							
							if (!type.eIsProxy() || !argumentType.eIsProxy()) {
								if(!type.equals(argumentType)) {
									result = false;
									break;
								}
							}
							else {
								if (!argumentType.eProxyURI().equals(type.eProxyURI())) {
									result = false;
									break;
								}
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
	
	protected EObject tryToConvertToExternalProxy(InternalEObject proxy, EObject context) throws UnresolvedProxiesException {
		String id = proxy.eProxyURI().fragment();
		if (!(context instanceof PackageOrClassifierOrMethodOrVariableReference ||
				context instanceof PackageOrClassifierReference)) {
			return null;
		}

		
		Type type =null;
		
		//type defined by previous
		EObject container = context.eContainer();
		if (container.eContainer() instanceof Reference) {
			Reference previous = (Reference) container.eContainer();
			type = getTypeOfReferencedElement(previous);
			if (type == null) {
				return null;
			}
			if (isInternalProxy((InternalEObject) type)) {
				throw new UnresolvedProxiesException();
			}
			URI externalProxyURI = null;
			if (type.eIsProxy()) {	
				externalProxyURI = 
					((InternalEObject) type).eProxyURI();
			}
			else {
				//the reference can be declared in an external superclass, create a porxy
				CompilationUnit cu = (CompilationUnit) EcoreUtil.getRootContainer(type);
				externalProxyURI = JavaUniquePathConstructor.getClassifierURI(
						JavaUniquePathConstructor.packageName(cu), ((NamedElement)type).getName());
			}
			String fragment = externalProxyURI.fragment();
			String fragmentPart =  JavaUniquePathConstructor.getMemberURIFragmentPart((PrimaryReference) context, id);
			if (fragmentPart == null) {
				//can not yet be resolved
				return null;
			}
			fragment = fragment + "/" + fragmentPart;
			externalProxyURI = externalProxyURI.appendFragment(fragment);
			proxy.eSetProxyURI(externalProxyURI);
			return proxy;
		}
		else {
			return findTypeInImports(id, context);
		}

		

	}
	
	@SuppressWarnings("unchecked")
	protected Type findTypeInImports(String id, EObject context) {
		CompilationUnit cu = (CompilationUnit) EcoreUtil.getRootContainer(context);
		
		for(Import i : cu.getImports()) {
			InternalEList<InternalEObject> extProxies = (InternalEList<InternalEObject>) 
				i.eGet(JavaPackage.Literals.IMPORT__CLASSIFIERS, 
				false /*do not resolved!*/);
			
			
			for(Iterator<InternalEObject> candIt = extProxies.basicIterator(); candIt.hasNext(); ) {
				InternalEObject cand = candIt.next();
				if(JavaUniquePathConstructor.pointsAtClassifie(cand.eProxyURI(), id)) { 
					return (Type) cand;
				}
			}
		}
		
		//TODO do the same for defaults, there should be one getAllImportend classifiers method on CU
		EList<Classifier> extProxies = 
			JavaClasspath.INSTANCE.getDefaultImports(
					JavaUniquePathConstructor.packageName(cu));
		
		for(Iterator<Classifier> candIt = extProxies.iterator(); candIt.hasNext(); ) {
			InternalEObject cand = (InternalEObject) candIt.next();
			if(JavaUniquePathConstructor.pointsAtClassifie(cand.eProxyURI(), id)) { 
				return (Type) cand;
			}
		}
		
		//assume type to be in own package (but not yet registered)
		InternalEObject classifierProxy = (InternalEObject) JavaFactory.eINSTANCE.createClass();
		classifierProxy.eSetProxyURI(JavaUniquePathConstructor.getClassifierURI(JavaUniquePathConstructor.packageName(cu), id));
		
		return (Type) classifierProxy;
	}
	
	
	protected boolean isInternalProxy(InternalEObject proxy) {
		if (!proxy.eIsProxy()) {
			return false;
		}
		
		if (!proxy.eProxyURI().trimFragment().equals(myResource.getURI())) { //TODO condition should use own URI
			return false;
		}
		return true;
	}

}
