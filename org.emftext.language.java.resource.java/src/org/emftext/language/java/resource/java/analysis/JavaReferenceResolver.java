package org.emftext.language.java.resource.java.analysis;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.JavaUniquePathConstructor;
import org.emftext.language.java.UnresolvedProxiesException;
import org.emftext.language.java.core.Annotation;
import org.emftext.language.java.core.AnnotationInstance;
import org.emftext.language.java.core.Assignment;
import org.emftext.language.java.core.Block;
import org.emftext.language.java.core.Class;
import org.emftext.language.java.core.ClassLiteral;
import org.emftext.language.java.core.Classifier;
import org.emftext.language.java.core.CompilationUnit;
import org.emftext.language.java.core.CoreFactory;
import org.emftext.language.java.core.CorePackage;
import org.emftext.language.java.core.Expression;
import org.emftext.language.java.core.Field;
import org.emftext.language.java.core.Interface;
import org.emftext.language.java.core.Member;
import org.emftext.language.java.core.Method;
import org.emftext.language.java.core.NamedElement;
import org.emftext.language.java.core.PackageDescriptor;
import org.emftext.language.java.core.PackageOrClassifierOrMethodOrVariableReference;
import org.emftext.language.java.core.PrimaryReference;
import org.emftext.language.java.core.QualifiedTypeArgument;
import org.emftext.language.java.core.Reference;
import org.emftext.language.java.core.ReferenceableElement;
import org.emftext.language.java.core.Super;
import org.emftext.language.java.core.This;
import org.emftext.language.java.types.PrimitiveType;
import org.emftext.language.java.types.Type;
import org.emftext.language.java.types.TypeReference;
import org.emftext.language.java.types.TypeReferenceSequence;
import org.emftext.language.java.types.TypedElement;
import org.emftext.runtime.resource.ResolveResult;
import org.emftext.runtime.resource.TextResource;
import org.emftext.runtime.resource.impl.ReferenceResolverImpl;

public abstract class JavaReferenceResolver extends ReferenceResolverImpl {
	
	protected TextResource myResource = null;
	
	//candidates for template methods
	
	protected boolean breakIfNext(EObject element, EClass typeToResolve) {
		//nothing can be defined before the compilation unit (root element)
		if (element instanceof CompilationUnit) {
			return false;
		}
		//order of classifier declarations is arbitrary
		if (element instanceof Classifier) {
			return false;
		}
		//in all other cases, the order requires consideration
		return true;
	}
	
	protected boolean breakIfChild(EObject element, EClass typeToResolve)  {
		//do not go into other classifier declarations
		if (element instanceof Classifier) {
			return true;
		}
		//go not go into a new block
		if (element instanceof Block) {
			return true;
		}
		return false;
	}
	
	protected void cosiderAddittionalScope(EObject container,
			EList<EObject> contentsList) throws UnresolvedProxiesException {
		//also consider default imports
		if (container instanceof CompilationUnit) {
			CompilationUnit cu = (CompilationUnit) container;
			String packageName = JavaUniquePathConstructor.packageName(cu);
			
			EList<Classifier> defaultImports = JavaClasspath.INSTANCE.getDefaultImports(packageName);
			contentsList.addAll(defaultImports);
		}
		//consider qualified package names
		if (container instanceof PackageDescriptor) {
			PackageDescriptor packageDescriptor = (PackageDescriptor) container;
			contentsList.addAll(packageDescriptor.getClassifiers());
		}
		else if (container instanceof Classifier) {
			//consider upper types --> can be optimized
			contentsList.addAll(getAllMemebers((Classifier) container));
		}

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
			if (!(container.eContainer() instanceof Reference) && !(container.eContainer()  instanceof AnnotationInstance)) {
				//direct primary reference: resolve in scope of the current compilation unit
				targetObject =  findScoped(identifier, container, container, reference.getEReferenceType());
			}
			else {
				EObject ref = container.eContainer();

				Type previousType = null;
				AnnotationInstance annotationInstance = findContainingAnnotationInstance(container);
				
				//chained reference
				if (ref instanceof Reference && ref.eContainer() instanceof Reference) {
					//chained reference: scope given by previous element may be a type and may define a new scope
					previousType = getTypeOfReferencedElement((Reference)ref.eContainer());

				}
				//inside annotation instance 
				else if (annotationInstance != null && annotationInstance != ref.eContainer() /*not the AnnotationInstance itself*/) {
					previousType = getTypeOfReferencedElement(annotationInstance.getAnnotation());
				}
				//no previouseType, search local
				if (previousType == null) {
					//reference in scope of the current compilation unit
					targetObject = findScoped(identifier, container, container, reference.getEReferenceType());
				}
				else {
					targetObject = find(identifier, container, null, previousType, reference.getEReferenceType());
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
				if (! (reference.equals(CorePackage.Literals.PACKAGE_OR_CLASSIFIER_REFERENCE__TARGET)
						|| reference.equals(CorePackage.Literals.PACKAGE_OR_CLASSIFIER_OR_METHOD_OR_VARIABLE_REFERENCE__TARGET))) {
					return;
				}
				//there must be something following up
				Reference ref = ((Reference)container.eContainer());
				if (ref.getNext() != null) {
					PackageDescriptor packageDescriptor = CoreFactory.eINSTANCE.createPackageDescriptor();
					packageDescriptor.setName(identifier);
					result.addMapping(identifier, packageDescriptor);
					
					String fullPackageName = getPreviouseReferenceAsPackageName(ref) + identifier;
					EList<Classifier> packageContent = JavaClasspath.INSTANCE.getClassifiers(fullPackageName, "*");
					packageDescriptor.getClassifiers().addAll(packageContent);
				}
			}
		} catch (UnresolvedProxiesException e) {
			assert(false);
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
		cosiderAddittionalScope(container, contentsList);
		
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
			if (breakIfChild(cand, type)) {
				continue;
			}
			//consider also children
			for(TreeIterator<EObject> it = cand.eAllContents(); it.hasNext(); ) {
				EObject subCand = it.next();
				if(hasCorrectType(subCand, type)) {
					if (isReferencedElement(id, context, subCand)) {
						return subCand;
					}
				}
				if (breakIfChild(subCand, type)) {
					it.prune();
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
	
	protected Type getTypeOfReferencedElement(EObject value) throws UnresolvedProxiesException {
		Type type = null;
		
		if (value instanceof Reference) {
			Reference reference = (Reference) value;
			PrimaryReference primaryRef = reference.getPrimary();
			//referenced element point to a type
			if (primaryRef instanceof TypedElement /*NewConstructorCall*/) {
				TypeReference typeRef = ((TypedElement) primaryRef).getType();
				type = getReferencedType(typeRef);
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
					TypeReference typeRef = ((TypedElement) target).getType();
					type = getReferencedType(typeRef);
				}
				else if (target instanceof Type /*e.g. Annotation*/ ) {
					return (Type) target;
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
	
	protected Type getReferencedType(TypeReference typeRef) throws UnresolvedProxiesException {
		Classifier type = null;

		if (typeRef instanceof TypeReferenceSequence) {
			TypeReferenceSequence typeRefSequence = (TypeReferenceSequence) typeRef;
			//TODO consider package names...
			type =  typeRefSequence.getParts().get(typeRefSequence.getParts().size() -1).getTarget();
		}
		else if(typeRef instanceof PrimitiveType) {
			return (PrimitiveType) typeRef;
		}
		else {
			assert(false);
		}
		
		if (type.eIsProxy()) {
			throw new UnresolvedProxiesException();
		}

		return type;
	}
	
	
	protected EList<Type> getArgumentTypes(PackageOrClassifierOrMethodOrVariableReference primaryRef) throws UnresolvedProxiesException {
		
		EList<Type> resultList = new BasicEList<Type>();
		
		for(Expression arg : primaryRef.getArguments()) {
			if (arg instanceof Assignment) {
				Assignment assignment = (Assignment) arg;
				Reference reference = assignment.getTarget();
				while (reference.getNext() != null) {
					//find the last reference
					reference = reference.getNext();
				}
				Type type = getTypeOfReferencedElement(assignment.getTarget());
				resultList.add(type);
			}
			else {
				//TODO when expressions are finished
				assert(false);
			}
		}
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
			//in case of Methods the paramter types need to be checked
			if (referencedElement instanceof Field) {
				//nothing else to do
			}
			else if (referencedElement instanceof Method) {
				Method method = (Method) referencedElement;
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
	
	protected String getPreviouseReferenceAsPackageName(Reference ref) {
		String packageName = "";
		while(ref.eContainer() instanceof Reference) {
			ref = (Reference) ref.eContainer();
			if (ref.getPrimary() instanceof PackageOrClassifierOrMethodOrVariableReference) {
				PackageOrClassifierOrMethodOrVariableReference primaryRef = 
					(PackageOrClassifierOrMethodOrVariableReference) ref.getPrimary();
				packageName = primaryRef.getTarget().getName() + "." + packageName;
			}
			else {
				//primitive type
				return "";
			}
		}
		return packageName;
	}
	
	
	protected Class findContainingClass(EObject value) {
		while (!(value instanceof Class) && value != null) {
			value = value.eContainer();
		}
		return (Class) value;
	}

	protected AnnotationInstance findContainingAnnotationInstance(EObject value) {
		while (!(value instanceof AnnotationInstance) && value != null) {
			value = value.eContainer();
		}
		return (AnnotationInstance) value;
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
			assert(false);
		} else if (javaClassifier instanceof Interface) {
			//TODO
			assert(false);
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
