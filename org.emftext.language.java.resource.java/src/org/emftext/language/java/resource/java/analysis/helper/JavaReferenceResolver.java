package org.emftext.language.java.resource.java.analysis.helper;

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
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.JavaUniquePathConstructor;
import org.emftext.language.java.UnresolvedProxiesException;
import org.emftext.language.java.annotations.Annotation;
import org.emftext.language.java.annotations.AnnotationInstance;
import org.emftext.language.java.core.AdditionalField;
import org.emftext.language.java.core.AdditionalLocalVariable;
import org.emftext.language.java.core.Block;
import org.emftext.language.java.core.Class;
import org.emftext.language.java.core.ClassLiteral;
import org.emftext.language.java.core.Classifier;
import org.emftext.language.java.core.ClassifierImport;
import org.emftext.language.java.core.CompilationUnit;
import org.emftext.language.java.core.CoreFactory;
import org.emftext.language.java.core.CorePackage;
import org.emftext.language.java.core.Field;
import org.emftext.language.java.core.Import;
import org.emftext.language.java.core.Interface;
import org.emftext.language.java.core.Member;
import org.emftext.language.java.core.MemberContainer;
import org.emftext.language.java.core.Method;
import org.emftext.language.java.core.NamedElement;
import org.emftext.language.java.core.NewConstructorCall;
import org.emftext.language.java.core.PackageDescriptor;
import org.emftext.language.java.core.PackageOrClassifierOrMethodOrVariableReference;
import org.emftext.language.java.core.PackageOrClassifierReference;
import org.emftext.language.java.core.Primary;
import org.emftext.language.java.core.PrimaryReference;
import org.emftext.language.java.core.QualifiedTypeArgument;
import org.emftext.language.java.core.Reference;
import org.emftext.language.java.core.ReferenceableElement;
import org.emftext.language.java.core.StaticImport;
import org.emftext.language.java.core.Super;
import org.emftext.language.java.core.This;
import org.emftext.language.java.core.TypeParameter;
import org.emftext.language.java.core.Variable;
import org.emftext.language.java.expressions.Expression;
import org.emftext.language.java.literals.BooleanLiteral;
import org.emftext.language.java.literals.CharacterLiteral;
import org.emftext.language.java.literals.FloatingPointLiteral;
import org.emftext.language.java.literals.IntegerLiteral;
import org.emftext.language.java.literals.Literal;
import org.emftext.language.java.literals.NullLiteral;
import org.emftext.language.java.literals.StringLiteral;
import org.emftext.language.java.types.Boolean;
import org.emftext.language.java.types.Byte;
import org.emftext.language.java.types.Char;
import org.emftext.language.java.types.Double;
import org.emftext.language.java.types.Float;
import org.emftext.language.java.types.Int;
import org.emftext.language.java.types.Long;
import org.emftext.language.java.types.PrimitiveType;
import org.emftext.language.java.types.Short;
import org.emftext.language.java.types.Type;
import org.emftext.language.java.types.TypeReference;
import org.emftext.language.java.types.TypeReferenceSequence;
import org.emftext.language.java.types.TypedElement;
import org.emftext.language.java.types.TypesFactory;
import org.emftext.language.java.types.VoidLiteral;
import org.emftext.runtime.resource.IResolveResult;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.resource.impl.ReferenceResolverImpl;

public abstract class JavaReferenceResolver extends ReferenceResolverImpl {

	public static final String UNRESOLVED_REFERENCE_STRING =
		"UNKNOWN";
	
	protected ITextResource myResource = null;
	
	@Override
	protected String doDeResolve(EObject element, EObject container,
			EReference reference) {
		
		String fullID = UNRESOLVED_REFERENCE_STRING; 
		
		if (!element.eIsProxy() && (element instanceof NamedElement)) {
			fullID = ((NamedElement) element).getName();
		}
		
		/* TODO In cases where element is a classifier this method 
		 * should inspect the context of the element to
		 * determine if the classifier is properly referenced
		 * (full qualified path) or imported. This might not
		 * be the case if the model is constructed by a model 
		 * transformation. In this case, the full qualified path
		 * should be returned. Even if this means that the model
		 * graph will be different after re-parsing.
		 */
		if (element instanceof Classifier) {
			if (container.eContainer() instanceof TypeReferenceSequence) {
				int idx = ((TypeReferenceSequence)container.eContainer()).getParts().indexOf(container);
				if (idx == 0 && element.eResource() != null) {
					URI resourceURI = element.eResource().getURI();
					if (resourceURI.toString().startsWith(JavaUniquePathConstructor.JAVA_CLASSIFIER_PATHMAP)) {
						String qualifiedName = resourceURI.trimFileExtension().toString().substring(
								JavaUniquePathConstructor.JAVA_CLASSIFIER_PATHMAP.length());
						qualifiedName = qualifiedName.replaceAll("\\$", ".");
						
						if (qualifiedName.startsWith("java.lang.")) {
							//default import
							fullID = ((NamedElement) element).getName();
						}
						else {
							fullID = qualifiedName;
							CompilationUnit cu = findContainingCompilationUnit(container);
							String packageName = "";
							if (fullID.contains(".")) {
								packageName = fullID.substring(0,fullID.lastIndexOf("."));
							}
							
							if (JavaUniquePathConstructor.packageName(cu).equals(packageName)) {
								//same package
								fullID = ((NamedElement) element).getName();
							}
							else for(Import imp : cu.getImports()) {
								if(imp instanceof ClassifierImport) {
									ClassifierImport classifierImport = (ClassifierImport) imp;
									if (classifierImport.getClassifiers().contains(element)) {
										//the element is imported -> simple name
										fullID = ((NamedElement) element).getName();
									}
								}
								else if (imp instanceof StaticImport) {
									StaticImport staticImport = (StaticImport) imp;
									if (staticImport.getStaticMembers().contains(element)) {
										//the element is imported -> simple name
										fullID = ((NamedElement) element).getName();
									}
								}
							}
						}
					}
				}
			}
		}
		
		if (element instanceof Method && !(element.eContainer() instanceof Annotation)) { //TODO introduce common superclass for Method and AnnotationMethod
			Method method = (Method) element;
			if (method.getParameters().isEmpty()) {
				fullID += "()";
			}
		}
		
		return fullID;
	}
	
	
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
		//consider imports and default imports
		if (container instanceof CompilationUnit) {
			CompilationUnit cu = (CompilationUnit) container;
			
			for(Import explicitImport : cu.getImports()) {
				if (explicitImport instanceof ClassifierImport) {
					EList<Classifier> explicitImports = 
						((ClassifierImport)explicitImport).getClassifiers();
					contentsList.addAll(explicitImports);
				}
				else if (explicitImport instanceof StaticImport) {
					EList<Member> staticMembers = 
						((StaticImport)explicitImport).getStaticMembers();
					contentsList.addAll(staticMembers);
				}
				else {
					assert(false);
				}
			}
			
			String packageName = JavaUniquePathConstructor.packageName(cu);
			EList<Classifier> defaultImports = JavaClasspath.INSTANCE.getDefaultImports(packageName);
			contentsList.addAll(defaultImports);
		}
		//consider qualified package names
		if (container instanceof PackageDescriptor) {
			PackageDescriptor packageDescriptor = (PackageDescriptor) container;
			String fullPackageName = packageDescriptor.getName();
			PackageDescriptor parent = packageDescriptor.getParent();
			while(parent != null) {
				fullPackageName = parent.getName() + "." + fullPackageName;
				parent = parent.getParent();
			}
			
			contentsList.addAll(JavaClasspath.INSTANCE.getClassifiers(fullPackageName + ".", "*"));
		}
		else if (container instanceof Classifier) {
			//consider upper types --> can be optimized
			contentsList.addAll(getAllMemebers((Classifier) container));
		}

	}
	
	
	//-------------

	@Override
	protected void doResolve(String identifier, EObject container,
			EReference reference, int position, boolean resolveFuzzy,
			IResolveResult result) {
		myResource = (ITextResource) container.eResource();
		
		try {
			EObject targetObject = null;

			EObject scopeCand  = container.eContainer();
			
			Type previousType = null;
			AnnotationInstance annotationInstance = findContainingAnnotationInstance(container);
			boolean definitlyPackage = false;
			
			//navigate through constructor calls
			if (scopeCand.eContainer() instanceof NewConstructorCall) {
				EObject previouseRef = scopeCand.eContainer().eContainer().eContainer();
				if (previouseRef instanceof Reference) {
					previousType = getTypeOfReferencedElement((Reference)previouseRef);
				}
			}
			
			//chained reference (1)
			if (scopeCand instanceof Reference && scopeCand.eContainer() instanceof Reference) {
				//chained reference: scope given by previous element may be a type and may define a new scope
				previousType = getTypeOfReferencedElement((Reference)scopeCand.eContainer());
			}
			//chained reference (2)
			if (scopeCand instanceof TypeReferenceSequence) {
				//chained reference: scope given by previous element may be a type and may define a new scope
				TypeReferenceSequence typeRefSequence = (TypeReferenceSequence)scopeCand;
				int idx = typeRefSequence.getParts().indexOf(container);
				if (idx > 0) {
					previousType = typeRefSequence.getParts().get(idx - 1).getTarget();
				}

			}
			//similar as before... could be unified in metamodel
			if (scopeCand instanceof Import) {
				//chained reference: scope given by previous element may be a type and may define a new scope
				Import theImport = (Import)scopeCand;
				int idx = theImport.getParts().indexOf(container);
				if (idx > 0) {
					previousType = theImport.getParts().get(idx - 1).getTarget();
				}
				else {
					definitlyPackage = true; //to avoid searching for this which would lead to recursive import resolution attempst
				}
			}
			//inside annotation instance 
			else if (annotationInstance != null && annotationInstance != scopeCand.eContainer() /*not the AnnotationInstance itself*/) {
				previousType = getTypeOfReferencedElement(annotationInstance.getAnnotation());
			}
			//no previouseType, search local
			if (!definitlyPackage) {
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
				//it hat to be target of a reference: there are two referencing possibilities
				// (1)
				if (reference.equals(
						CorePackage.Literals.PACKAGE_OR_CLASSIFIER_OR_METHOD_OR_VARIABLE_REFERENCE__TARGET)) {
					Reference ref = ((Reference)container.eContainer());
					//there must be something (a classifier reference) following up
					PackageDescriptor packageDescriptor = CoreFactory.eINSTANCE.createPackageDescriptor();
					packageDescriptor.setName(identifier);
					result.addMapping(identifier, packageDescriptor);
					
					if(ref.eContainer() instanceof Reference) {
						ref = (Reference) ref.eContainer();
						if (ref.getPrimary() instanceof PackageOrClassifierOrMethodOrVariableReference) {
							PackageOrClassifierOrMethodOrVariableReference primaryRef = 
								(PackageOrClassifierOrMethodOrVariableReference) ref.getPrimary();
							if(primaryRef.getTarget() instanceof PackageDescriptor) {
								packageDescriptor.setParent((PackageDescriptor) primaryRef.getTarget());
							}
						}
					}
					
				}
				// (2)
				else if (reference.equals(
						CorePackage.Literals.PACKAGE_OR_CLASSIFIER_REFERENCE__TARGET)) {
					EList<?> parts = null;
					if (container.eContainer() instanceof TypeReferenceSequence) {
						TypeReferenceSequence refSequence = ((TypeReferenceSequence)container.eContainer());
						parts = refSequence.getParts();
					}
					else if (container.eContainer() instanceof Import) {
						Import theImport = ((Import)container.eContainer());
						parts = theImport.getParts();
					}
					else {
						assert(false);
					}
					int pos = parts.indexOf(container);
					
					PackageDescriptor packageDescriptor = CoreFactory.eINSTANCE.createPackageDescriptor();
					packageDescriptor.setName(identifier);
					result.addMapping(identifier, packageDescriptor);
					
					if (pos > 0) {
						Type parent = ((PackageOrClassifierReference)parts.get(pos - 1)).getTarget();
						if (parent instanceof PackageDescriptor ) {
							packageDescriptor.setParent((PackageDescriptor) parent);
						}
					}
					
				}
			}
		} catch (UnresolvedProxiesException e) {
			assert(false);
			// do nothing
		}
	}
	
	protected EObject findScoped(String identifier, EObject context, EObject endOfScopeElement,
			EClass type) throws UnresolvedProxiesException {
		
		EObject container = endOfScopeElement.eContainer();
		
		//termination, no more scope to search in
		if(container == null) {
			return null;
		}
		
		EObject result = find(identifier, context, endOfScopeElement, container, type);

		if (result != null) {
			return result;
		}
		
		//search in next scope
		return findScoped(identifier, context, container, type);
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
	
	protected Type getTypeOfReferencedElement(Primary primary) throws UnresolvedProxiesException {
		if (primary.getReference() != null) {
			return getTypeOfReferencedElement(primary.getReference());
		}
		else if (primary.getLiteral() != null) {
			return getTypeOfReferencedElement(primary.getLiteral());
		}
		
		assert(false);
		return null;
	}
	
	protected Type getTypeOfReferencedElement(Literal literal) throws UnresolvedProxiesException {
		TypesFactory javaTypeFactory = TypesFactory.eINSTANCE;
		if (literal instanceof NullLiteral) {
			return javaTypeFactory.createVoidLiteral();
		}
		else if (literal instanceof BooleanLiteral) {
			return javaTypeFactory.createBoolean();
		}
		else if (literal instanceof FloatingPointLiteral) {
			return javaTypeFactory.createDouble();
		}
		else if (literal instanceof IntegerLiteral) {
			return javaTypeFactory.createInt();
		}
		else if (literal instanceof CharacterLiteral) {
			return javaTypeFactory.createChar();
		}
		else if (literal instanceof StringLiteral) {
			return JavaClasspath.INSTANCE.getClassifier("java.lang.String");
		}
		
		assert(false);
		return null;
	}
	
	/**
	 * Determines the <code>Type</code> of the reference, considering all kinds of referencing mechanisms
	 * used in the Java metamodel.
	 * 
	 * @param reference
	 * @return the determined type
	 * @throws UnresolvedProxiesException
	 */
	protected Type getTypeOfReferencedElement(Reference reference) throws UnresolvedProxiesException {
		Type type = null;

		PrimaryReference primaryRef = reference.getPrimary();

		//referenced element point to a type
		if (primaryRef instanceof TypedElement /*NewConstructorCall*/) {
			TypeReference typeRef = ((TypedElement) primaryRef).getType();
			type = getReferencedType(typeRef);
		}
		//element points to this
		else if (primaryRef instanceof This) {
			return findContainingClass(reference);
		}
		//element points to super
		else if(primaryRef instanceof Super) {
			return getSuperType(findContainingClass(reference));
		}
		//element points to the object's class object
		else if(primaryRef instanceof ClassLiteral) {
			return getSuperType(getClassObjectModelElement());
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
		
		return type;
	}
	
	/**
	 * Returns the type referenced by the given <code>TypeReference</code>
	 * considering all concrete subclasses of <code>TypeReference</code> used
	 * by the Java metamodel.
	 * 
	 * @param typeReference the type reference 
	 * @return the type
	 * @throws UnresolvedProxiesException
	 */
	protected Type getReferencedType(TypeReference typeReference) throws UnresolvedProxiesException {
		/*
		 * TODO this method needs to investigate the context of typeReferene to check
		 * additional constrains. E.g., if the typeReference is used to define a 
		 * super interface of an interface the returned type must be an interface. 
		 */
		
		Type type = null;

		if (typeReference instanceof TypeReferenceSequence) {
			TypeReferenceSequence typeRefSequence = (TypeReferenceSequence) typeReference;
			// TODO the next line throws NPEs!
			type =  typeRefSequence.getParts().get(typeRefSequence.getParts().size() -1).getTarget();
		}
		else if(typeReference instanceof PrimitiveType) {
			return (PrimitiveType) typeReference;
		}
		else {
			assert(false);
		}
		
		// TODO the next line throws NPEs!
		if (type.eIsProxy()) {
			//this may happen, when e.g. a super type is resolved. It is ok.
			return null;
		}

		return type;
	}
	
	
	protected EList<Type> getArgumentTypes(PackageOrClassifierOrMethodOrVariableReference primaryRef) throws UnresolvedProxiesException {
		
		EList<Type> resultList = new BasicEList<Type>();
		
		for(Expression exp : primaryRef.getArguments()) {
			//find the reference at the end of the expression
			Type type = null;
			for(Iterator<EObject> i = exp.eAllContents(); i.hasNext(); ) {
				EObject next = i.next();
				if (next instanceof Primary) {
					type = getTypeOfReferencedElement(
							((Primary) next));
					break;
				}
			}
			assert(type != null);
			
			resultList.add(type);
		}
		return resultList;
	}
	
	
	protected boolean isReferencedElement(String id, EObject context, EObject referencedElement) throws UnresolvedProxiesException {
		boolean result = false;
		
		if(referencedElement instanceof ReferenceableElement) {
			result = id.equals(((NamedElement) referencedElement).getName());
			if (!result) {
				return false;
			}
			if (referencedElement instanceof Classifier) {
				//nothing else to do
			}
			else if (referencedElement instanceof Field) {
				//nothing else to do
			}
			else if (referencedElement instanceof AdditionalField) {
				//nothing else to do
			}
			else if (referencedElement instanceof Variable) {
				//nothing else to do (includes LocalVariable and Parameter)
			}
			else if (referencedElement instanceof AdditionalLocalVariable) {
				//nothing else to do
			}
			else if (referencedElement instanceof TypeParameter) {
				//nothing else to do
			}
			else if (referencedElement instanceof Method) {
				//in case of Methods the parameter types need to be checked
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
								if(!compareTypes(type, argumentType)) {
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
			else {
				assert(false);
			}
		}
		return result;
	}


	protected boolean compareTypes(EObject type1,
			EObject type2) {
		
		if (type1 instanceof PrimitiveType && type2 instanceof PrimitiveType) {
			if (type1 instanceof Boolean) {
				if (type2 instanceof Boolean) {
					return true;
				}
				else {
					return false;
				}
			}
			if (type1 instanceof Char) {
				if (type2 instanceof Char) {
					return true;
				}
				else {
					return false;
				}
			}
			if (type1 instanceof Byte ||
					type1 instanceof Int ||
					type1 instanceof Short ||
					type1 instanceof Long) {
				if (type2 instanceof Byte ||
						type2 instanceof Int ||
						type2 instanceof Short ||
						type2 instanceof Long) {
					return true;
				}
				else {
					return false;
				}
			}
			if (type1 instanceof Float ||
					type1 instanceof Double) {
				if (type2 instanceof Byte ||
						type2 instanceof Float ||
						type2 instanceof Double) {
					return true;
				}
				else {
					return false;
				}
			}
			if (type1 instanceof VoidLiteral) {
				if (type2 instanceof VoidLiteral) {
					return true;
				}
				else {
					return false;
				}
			}
		}
		return type1.equals(type2);
	}
	
	protected Class findContainingClass(EObject value) {
		while (!(value instanceof Class) && value != null) {
			value = value.eContainer();
		}
		return (Class) value;
	}
	
	protected CompilationUnit findContainingCompilationUnit(EObject value) {
		while (!(value instanceof CompilationUnit) && value != null) {
			value = value.eContainer();
		}
		return (CompilationUnit) value;
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
			if (superClassifier instanceof MemberContainer /*Class and Interface*/) {
				memberList.addAll(((MemberContainer) superClassifier).getMembers());
			}
			else {
				//nothing
				assert(false);
			}
		}
		
		
		return memberList;
	}
	
	protected EList<Classifier> getAllSuperTypes(Classifier javaClassifier) throws UnresolvedProxiesException {
		EList<Classifier> superClassifierList = new BasicEList<Classifier>();
		javaClassifier = (Classifier) EcoreUtil.resolve(javaClassifier, myResource);
		if (javaClassifier instanceof Class) {
			Class javaClass = (Class) javaClassifier;
			collectAllSuperClassifiers(javaClass, superClassifierList);
		} else if (javaClassifier instanceof Interface) {
			Interface javaInterface = (Interface) javaClassifier;
			collectAllSuperInterfaces(javaInterface.getExtends(), superClassifierList);
		} else if (javaClassifier instanceof Annotation) {
			//nothing
			//Annotations do not have super classes
		} else {
			//there are no other kinds of classifiers 
			assert(false);
		}
		return superClassifierList;

	}

	/**
	 * Returns all superclasses of the given class. Returns
	 * <code>java.lang.Object</code> if nothing is specified in the model.
	 * 
	 * @param subClass the class
	 * @return the superclasses
	 * @throws UnresolvedProxiesException
	 */
	protected Class getSuperType(Class subClass) throws UnresolvedProxiesException {
		Class superClass = null;
		if (subClass.getExtends() != null) {
			superClass = (Class) getReferencedType(subClass.getExtends().getType());
		} 
		if (superClass == null ) {
			superClass = (Class) JavaClasspath.INSTANCE.getClassifiers(
					"java.lang.", "Object").get(0);
		}
		superClass = (Class) EcoreUtil.resolve(superClass, myResource);
		return superClass;
	}
	
	/**
	 * Collects all superclassifiers (extended classes and implemented interfaces)
	 * of the given class.
	 * 
	 * @param javaClass the class
	 * @param resultClassifierList the list for the result
	 * @throws UnresolvedProxiesException
	 */
	private void collectAllSuperClassifiers( Class javaClass, 
			EList<Classifier> resultClassifierList)
			throws UnresolvedProxiesException {
		//collects all superclasses
		Class superClass = javaClass;
		while (!superClass.eIsProxy() && !superClass.getName().equals("Object")) {
			superClass = getSuperType(superClass);
			resultClassifierList.add(superClass);
		}
		//collect all implemented interfaces
		collectAllSuperInterfaces(
				javaClass.getImplements(), resultClassifierList);
	}

	/**
	 * Recursively collects all interfaces and their superinterfaces
	 * referenced by the given list of references to interfaces.
	 * 
	 * @param interfaceReferences a list of references to interfaces
	 * @param resultInterfaceList the list with the reuslt
	 * @throws UnresolvedProxiesException 
	 */
	protected void collectAllSuperInterfaces(EList<QualifiedTypeArgument> interfaceReferences,
		EList<Classifier> resultInterfaceList) throws UnresolvedProxiesException {
	
		for (QualifiedTypeArgument typeArg : interfaceReferences) {
			Type type = getReferencedType(typeArg.getType());
			if (type instanceof Interface) {
				Interface superInterface = (Interface) type;
				resultInterfaceList.add(superInterface);
				collectAllSuperInterfaces(superInterface.getExtends(), resultInterfaceList);
			}
			else {
				//A superinterface of an interface has to be an interface
				assert(false);
			}
		}
	}
	
	/**
	 * Finds the model element representing <code>java.lang.Class</code>.
	 * @return class object model element
	 */
	protected Class getClassObjectModelElement() {
		Class classObject = (Class) JavaClasspath.INSTANCE.getClassifiers(
				"java.lang.", "Class").get(0);
		classObject = (Class) EcoreUtil.resolve(classObject, myResource);
		return classObject;
	}

}
