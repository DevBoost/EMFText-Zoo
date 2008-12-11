package org.emftext.language.java.resource.java.analysis;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.Annotation;
import org.emftext.language.java.Assignment;
import org.emftext.language.java.Class;
import org.emftext.language.java.ClassLiteral;
import org.emftext.language.java.Classifier;
import org.emftext.language.java.CompilationUnit;
import org.emftext.language.java.Expression;
import org.emftext.language.java.Field;
import org.emftext.language.java.Interface;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.JavaFactory;
import org.emftext.language.java.JavaPackage;
import org.emftext.language.java.JavaUniquePathConstructor;
import org.emftext.language.java.Member;
import org.emftext.language.java.Method;
import org.emftext.language.java.NamedElement;
import org.emftext.language.java.PackageOrClassifierOrMethodOrVariableReference;
import org.emftext.language.java.PrimaryReference;
import org.emftext.language.java.QualifiedTypeArgument;
import org.emftext.language.java.Reference;
import org.emftext.language.java.ReferenceableElement;
import org.emftext.language.java.Super;
import org.emftext.language.java.This;
import org.emftext.language.java.Type;
import org.emftext.language.java.TypeReferenceSequence;
import org.emftext.language.java.TypedElement;
import org.emftext.language.java.UnresolvedProxiesException;
import org.emftext.runtime.resource.ResolveResult;
import org.emftext.runtime.resource.TextResource;
import org.emftext.runtime.resource.impl.ReferenceResolverImpl;

public abstract class JavaReferenceResolver extends ReferenceResolverImpl {

	
	protected TextResource myResource = null;
	
	//candidates for template methods
	
	protected boolean breakIfNext(EObject element, EClass typeToResolve) {
		//nothing can be defined before the compilation unit (root element)
		if (element instanceof org.emftext.language.java.CompilationUnit) {
			return false;
		}
		//order of classifier declarations is arbitrary
		if (element instanceof org.emftext.language.java.Classifier) {
			return false;
		}
		//in all other cases, the order requires consideration
		return true;
	}
	
	protected boolean breakIfChild(EObject element, EClass typeToResolve)  {
		//do not go into other classifier declarations
		if (typeToResolve.equals(JavaPackage.Literals.METHOD) &&
				element instanceof org.emftext.language.java.Classifier) {
			return true;
		}
		//go not go into a new block
		if (element instanceof org.emftext.language.java.Block) {
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
	protected void doResolve(String identifier, EObject container,
			EReference reference, int position, boolean resolveFuzzy,
			ResolveResult result) {
		
		myResource = (TextResource) container.eResource();
		
		try {
			EObject targetObject = null;
			
			if (!(container.eContainer() instanceof Reference)) {
				//direct primary reference: resolve in scope of the current compilation unit
				targetObject =  findScoped(identifier, container, container, reference.getEReferenceType());
			}
			else {
				Reference ref = (Reference) container.eContainer();
	
				if (ref.eContainer() instanceof Reference) {
					//chained reference: scope given by previous element in chain
					Type previousType = getTypeOfReferencedElement((Reference)ref.eContainer());
					if (previousType != null) {
						targetObject = find(identifier, container, null, previousType, reference.getEReferenceType());
					}
				}
				else {
					//reference in scope of the current compilation unit
					targetObject = findScoped(identifier, container, container, reference.getEReferenceType());
				}
			}
			
			if (targetObject != null) {
				result.addMapping(identifier, targetObject);
			}
			else {
				//in cases we reference something that is probably a package
				
				//it should start with a lower letter
				String firstLetter = identifier.substring(0,1);
				if(!firstLetter.toLowerCase().equals(firstLetter)) {
					return;
				}
				//it hat to be target of a reference
				if (! (reference.equals(JavaPackage.Literals.PACKAGE_OR_CLASSIFIER_REFERENCE__TARGET)
						|| reference.equals(JavaPackage.Literals.PACKAGE_OR_CLASSIFIER_OR_METHOD_OR_VARIABLE_REFERENCE__TARGET))) {
					return;
				}
				//there must be something following up
				if (((Reference)container.eContainer()).getNext() != null) {
					Class dummyPackageClass = JavaFactory.eINSTANCE.createClass();
					dummyPackageClass.setName(identifier);
					result.addMapping(identifier, dummyPackageClass);
				}
			}
		} catch (UnresolvedProxiesException e) {
			// do nothing
		}
	}

	protected EObject findScoped(String proxyURIFragment, EObject context, EObject endOfScopeElement,
			EClass type) throws UnresolvedProxiesException {
		
		EObject container = endOfScopeElement.eContainer();
		
		//termination, no more scope to search in
		if(container == null) {
			return null;
		}
		
		EObject result = find(proxyURIFragment, context, endOfScopeElement, container, type);

		if (result != null) {
			return result;
		}
		
		//search in next scope
		return findScoped(proxyURIFragment, context, container, type);
	}

	protected EObject find(String id, EObject context, EObject element,  EObject container, EClass type) throws UnresolvedProxiesException {
		EList<EObject> contentsList = new BasicEList<EObject>();
		contentsList.addAll(container.eContents());
		
		//also consider default imports
		if (container instanceof CompilationUnit) {
			CompilationUnit cu = (CompilationUnit) container;
			String packageName = JavaUniquePathConstructor.packageName(cu);
			
			EList<Classifier> defaultImports = JavaClasspath.INSTANCE.getDefaultImports(packageName);
			contentsList.addAll(defaultImports);
		}
		if (container instanceof Classifier) {
			//consider upper types --> can be optimized
			contentsList.addAll(getAllMemebers((Classifier) container));
		}
		
		for(EObject cand : contentsList) {
			if (cand.eIsProxy()) {
				cand = EcoreUtil.resolve(cand, myResource);
			}
			//the reference may have to be defined prior to the referencing element
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
				TypeReferenceSequence typeRefSequence = ((TypedElement) primaryRef).getType();
				type = getReferencedType(typeRefSequence);
			}
			//element points to this
			else if (primaryRef instanceof This) {
				return findContainingClass(value);
			}
			//element points to super
			else if(primaryRef instanceof Super) {
				return getSuperType(findContainingClass(value));
			}
			//element points to the object's class object
			else if(primaryRef instanceof ClassLiteral) {
				return getSuperType(getClassObject());
			}
			//referenced element points to an element with a type
			else if (primaryRef instanceof PackageOrClassifierOrMethodOrVariableReference) {
				ReferenceableElement target = 
					(ReferenceableElement) ((PackageOrClassifierOrMethodOrVariableReference) primaryRef).getTarget();
				if (target.eIsProxy()) {
					throw new UnresolvedProxiesException();
				}
				
				else if (target instanceof TypedElement) {
					TypeReferenceSequence typeRefSequence = ((TypedElement) target).getType();
					type = getReferencedType(typeRefSequence);
				}
			}
			else {
				assert(false);
			}
		}
		else {
			assert(false);
		}
		
		return type;
	}
	
	public Classifier getReferencedType(TypeReferenceSequence typeRefSequence) throws UnresolvedProxiesException {
		Classifier type = null;

		//TODO consider package names...
		type =  typeRefSequence.getParts().get(typeRefSequence.getParts().size() -1).getTarget();
		if (type.eIsProxy()) {
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
		
		if(referencedElement instanceof ReferenceableElement) {
			result = id.equals(((NamedElement) referencedElement).getName());
			if (!result) {
				return result;
			}
			
			
			if (referencedElement instanceof Classifier) {
				//TODO check type parameters
			}
			//else if (referencedElement instanceof Package) { //? TODO
			//	
			//}
			//in case of Methods the paramter types need to be checked
			if (referencedElement instanceof Field) {
				//nothing else to do
			}
			else if (referencedElement instanceof Method) {
				org.emftext.language.java.Method method = (Method) referencedElement;
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
			} else {
				assert(false);
			}
		}
		return result;
	}
	
	protected Class findContainingClass(EObject value) {
		while (!(value instanceof Class) && value != null) {
			value = value.eContainer();
		}
		return (Class) value;
	}


	protected EList<Member> getAllMemebers(Classifier javaClassifier) throws UnresolvedProxiesException {
		EList<Member> memberList = new BasicEList<Member>();
		for (Classifier superClassifier : getAllSuperTypes(javaClassifier)) {
			if (superClassifier instanceof Class) {
				memberList.addAll(((Class) superClassifier).getMembers());
			}
			else {
				//TODO
			}
		}
		
		
		return memberList;
	}
	
	protected EList<Classifier> getAllSuperTypes(Classifier javaClassifier) throws UnresolvedProxiesException {
		EList<Classifier> superClassifierList = new BasicEList<Classifier>();
		EList<Interface> ifList = new BasicEList<Interface>();
		javaClassifier = (Classifier) EcoreUtil.resolve(javaClassifier, myResource);
		if (javaClassifier instanceof Class) {
			Class superClass = (Class) javaClassifier;
			while (!superClass.eIsProxy() && !superClass.getName().equals("Object")) {
				superClass = getSuperType(superClass);
				superClassifierList.add(superClass);
			}
		} else if (javaClassifier instanceof Annotation) {
			//TODO
		} else if (javaClassifier instanceof Interface) {
			//TODO
		} else {
			//TODO annotations
			assert(false);
		}
		return superClassifierList;

	}

	protected Class getSuperType(Class superClass) throws UnresolvedProxiesException {
		if (superClass.getExtends() != null) {
			superClass = (Class) getReferencedType(superClass.getExtends().getType());
		} else {
			superClass = (Class) JavaClasspath.INSTANCE.getClassifiers(
					"java.lang", "Object").get(0);
		}
		superClass = (Class) EcoreUtil.resolve(superClass, myResource);
		return superClass;
	}

	protected void collectAllImplementedInterfaces(
			EList<Interface> interfaceList) {
		for (Interface javaIf : new BasicEList<Interface>(interfaceList)) {
			for (QualifiedTypeArgument typeArg : javaIf.getExtends()) {
				typeArg.getType();
			}
		}
	}
	
	protected Class getClassObject() {
		Class classObject = (Class) JavaClasspath.INSTANCE.getClassifiers(
				"java.lang", "Class").get(0);
		classObject = (Class) EcoreUtil.resolve(classObject, myResource);
		return classObject;
	}

}
