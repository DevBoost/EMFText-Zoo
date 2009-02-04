package org.emftext.language.java.resource.java.analysis.helper;

import java.util.Collections;
import java.util.Comparator;

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
import org.emftext.language.java.annotations.AnnotationInstance;
import org.emftext.language.java.classifiers.Annotation;
import org.emftext.language.java.classifiers.AnonymousClass;
import org.emftext.language.java.classifiers.Class;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.classifiers.Enumeration;
import org.emftext.language.java.classifiers.Interface;
import org.emftext.language.java.commons.NamedElement;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.containers.ContainersFactory;
import org.emftext.language.java.containers.Package;
import org.emftext.language.java.expressions.AdditiveExpression;
import org.emftext.language.java.expressions.AndExpression;
import org.emftext.language.java.expressions.AssignmentExpression;
import org.emftext.language.java.expressions.CastExpression;
import org.emftext.language.java.expressions.ConditionalAndExpression;
import org.emftext.language.java.expressions.ConditionalExpression;
import org.emftext.language.java.expressions.ConditionalOrExpression;
import org.emftext.language.java.expressions.EqualityExpression;
import org.emftext.language.java.expressions.ExclusiveOrExpression;
import org.emftext.language.java.expressions.Expression;
import org.emftext.language.java.expressions.InclusiveOrExpression;
import org.emftext.language.java.expressions.InstanceOfExpression;
import org.emftext.language.java.expressions.MultiplicativeExpression;
import org.emftext.language.java.expressions.NestedExpression;
import org.emftext.language.java.expressions.PrimaryExpression;
import org.emftext.language.java.expressions.RelationExpression;
import org.emftext.language.java.expressions.ShiftExpression;
import org.emftext.language.java.generics.QualifiedTypeArgument;
import org.emftext.language.java.generics.TypeArgument;
import org.emftext.language.java.generics.TypeParameter;
import org.emftext.language.java.imports.ClassifierImport;
import org.emftext.language.java.imports.Import;
import org.emftext.language.java.imports.PackageImport;
import org.emftext.language.java.imports.StaticClassifierImport;
import org.emftext.language.java.imports.StaticMemberImport;
import org.emftext.language.java.instantiations.Instantiation;
import org.emftext.language.java.instantiations.NewConstructorCall;
import org.emftext.language.java.literals.BooleanLiteral;
import org.emftext.language.java.literals.CharacterLiteral;
import org.emftext.language.java.literals.DoubleLiteral;
import org.emftext.language.java.literals.FloatLiteral;
import org.emftext.language.java.literals.IntegerLiteral;
import org.emftext.language.java.literals.Literal;
import org.emftext.language.java.literals.LongLiteral;
import org.emftext.language.java.literals.NullLiteral;
import org.emftext.language.java.members.AdditionalField;
import org.emftext.language.java.members.EnumConstant;
import org.emftext.language.java.members.Field;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.members.MemberContainer;
import org.emftext.language.java.members.MembersFactory;
import org.emftext.language.java.members.Method;
import org.emftext.language.java.parameters.Parameter;
import org.emftext.language.java.parameters.VariableLengthParameter;
import org.emftext.language.java.references.ArgumentList;
import org.emftext.language.java.references.IdentifierReference;
import org.emftext.language.java.references.Reference;
import org.emftext.language.java.references.ReferenceableElement;
import org.emftext.language.java.references.ReferencesPackage;
import org.emftext.language.java.references.ReflectiveClassReference;
import org.emftext.language.java.references.SelfReference;
import org.emftext.language.java.references.StringReference;
import org.emftext.language.java.statements.Block;
import org.emftext.language.java.statements.ForLoop;
import org.emftext.language.java.statements.WhileLoop;
import org.emftext.language.java.types.Boolean;
import org.emftext.language.java.types.Byte;
import org.emftext.language.java.types.Char;
import org.emftext.language.java.types.ClassifierReference;
import org.emftext.language.java.types.Double;
import org.emftext.language.java.types.Float;
import org.emftext.language.java.types.Int;
import org.emftext.language.java.types.Long;
import org.emftext.language.java.types.NamespaceClassifierReference;
import org.emftext.language.java.types.PrimitiveType;
import org.emftext.language.java.types.Short;
import org.emftext.language.java.types.Type;
import org.emftext.language.java.types.TypeReference;
import org.emftext.language.java.types.TypedElement;
import org.emftext.language.java.types.TypesFactory;
import org.emftext.language.java.types.TypesPackage;
import org.emftext.language.java.types.Void;
import org.emftext.language.java.variables.AdditionalLocalVariable;
import org.emftext.language.java.variables.Variable;
import org.emftext.runtime.resource.IResolveResult;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.resource.impl.AbstractReferenceResolver;



public abstract class JavaReferenceResolver<T extends EObject> extends AbstractReferenceResolver<T> {

	public static final String UNRESOLVED_REFERENCE_STRING =
		"UNKNOWN";
	
	protected ITextResource myResource = null;
	
	@Override
	protected String doDeResolve(EObject element, T container,
			EReference reference) {
		
		String fullID = UNRESOLVED_REFERENCE_STRING; 
		
		if (!element.eIsProxy() && (element instanceof NamedElement)) {
			fullID = ((NamedElement) element).getName();
		}

		/* TODO implement this correctly in the future
		 * 
		 * if (element instanceof Classifier) {
			if (container instanceof IdentifierReference) {
				if (!(container.eContainer() instanceof IdentifierReference)) {
					URI resourceURI = element.eResource().getURI();
					if (!resourceURI.toString().startsWith(JavaUniquePathConstructor.JAVA_CLASSIFIER_PATHMAP)) {
						String qualifiedName = resourceURI.trimFileExtension().toString().substring(
								JavaUniquePathConstructor.JAVA_CLASSIFIER_PATHMAP.length());
						//inner classes directly contained in outer
						EObject inner = element;
						String innerName = "";
						while(inner.eContainer() instanceof Classifier) {
							innerName =  "$" + ((Classifier)inner).getName() + innerName;
							inner = inner.eContainer();
						}
						qualifiedName = qualifiedName + innerName;
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
							//fullID = fullID.replaceAll("\\$", ".");
							if (fullID.contains("$")) {
								//TODO full ref for inner classes, code below
								fullID = ((NamedElement) element).getName();
							}
							else if (JavaUniquePathConstructor.packageName(cu).equals(packageName)) {
								//same package
								fullID = ((NamedElement) element).getName();
							}
							else {
								//a inner class?
								Class containersClass = findContainingClass(container);
								if (containersClass != null) {
									EList<Classifier> innerClasses = JavaClasspath.INSTANCE.getInternalClassifiers(containersClass);
									for (Classifier superClass : getAllSuperTypes(containersClass)) {
										innerClasses.addAll(
												JavaClasspath.INSTANCE.getInternalClassifiers(superClass));
									}
									for(Classifier innerCand : innerClasses) {
										if (element.equals(EcoreUtil.resolve(innerCand, myResource))) {
											//TODO fullID = ((NamedElement) element).getName();
										}
									}
								}
								for(Import imp : cu.getImports()) {
									if(imp instanceof ClassifierImport) {
										ClassifierImport classifierImport = (ClassifierImport) imp;
										if (element.equals(classifierImport.getClassifier())) {
											//the element is imported -> simple name
											fullID = ((NamedElement) element).getName();
										}
									}
									if(imp instanceof PackageImport) {
										String name = ((NamedElement) element).getName();
										EList<ConcreteClassifier> importedClassifiers =  
											JavaClasspath.INSTANCE.getClassifiers(imp);
										for(Classifier classifierProxy : importedClassifiers) {
											if (name.equals(classifierProxy.getName())) {
												fullID = name;
												break;
											}
										}
										
									}
									else if (imp instanceof StaticMemberImport) {
										StaticMemberImport staticImport = (StaticMemberImport) imp;
										if (element.equals(staticImport.getStaticMember())) {
											//the element is imported -> simple name
											fullID = ((NamedElement) element).getName();
										}
									}
									else if (imp instanceof StaticClassifierImport) {
										StaticClassifierImport staticImport = (StaticClassifierImport) imp;
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
		}*/
		
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
		//do not break after the body of an anonymous class
		if (element instanceof AnonymousClass) {
			return false;
		}
		//in all other cases, the order requires consideration
		return true;
	}
	
	protected boolean breakIfChild(EObject element, EClass typeToResolve)  {
		//do not go into other classifier declarations (but enums --> or better static fields of all?)
		if (element instanceof Class || element instanceof Interface) {
			return true;
		}
		//do not look into parameters or contents of other methods
		if (element instanceof Method) {
			return true;
		}
		//go not go into a new block
		if (element instanceof Block) {
			return true;
		}
		//go not go into loops
		if (element instanceof ForLoop) {
			return true;
		}
		if (element instanceof WhileLoop) {
			return true;
		}
		return false;
	}
	
	protected EList<EObject> getOrderedContents(EObject container) {
		if (container instanceof NewConstructorCall) {
			NewConstructorCall ncc = (NewConstructorCall) container;
			if (ncc.getAnonymousClass() != null) {
				EList<EObject> result = new BasicEList<EObject>();
				result.addAll(ncc.getAnonymousClass().getMembers());
				return result;
			}
		}
		if (container instanceof MemberContainer) {
			//fields have priority over constructor calls
			EList<EObject> result = new BasicEList<EObject>(container.eContents());
			Collections.sort(result, new Comparator<EObject>() {

				public int compare(EObject o1, EObject o2) {
					if (o1 instanceof Field) {
						return -1;
					}
					return 1;
				}

			});
			return result;
		}
		return container.eContents();
	}
	
	protected Field STANDARD_ARRAY_LENGTH_FIELD = null;

	protected void cosiderAddittionalScope(EObject container,
			EList<EObject> contentsList, boolean lookIntoSuper) {
		//consider imports and default imports
		if (container instanceof CompilationUnit) {
			CompilationUnit cu = (CompilationUnit) container;
			
			//classifier first
			for(Import explicitImport : cu.getImports()) {
				if (explicitImport instanceof ClassifierImport) {
					ConcreteClassifier classifierImport = 
						((ClassifierImport)explicitImport).getClassifier();
					contentsList.add(classifierImport);
				}
				else if (explicitImport instanceof StaticMemberImport) {
					Member staticMember = 
						((StaticMemberImport)explicitImport).getStaticMember();
					contentsList.add(staticMember);
				}
				else if (explicitImport instanceof StaticClassifierImport) {
					EList<Member> staticMembers = 
						((StaticClassifierImport)explicitImport).getStaticMembers();
					contentsList.addAll(staticMembers);
				}
			}
			for(Import explicitImport : cu.getImports()) {
				if (explicitImport instanceof PackageImport) {
					EList<ConcreteClassifier> importedClassifiers =  
						JavaClasspath.INSTANCE.getClassifiers(explicitImport);
					contentsList.addAll(importedClassifiers);
				
				}
			}
			String packageName = JavaUniquePathConstructor.packageName(cu);
			EList<ConcreteClassifier> defaultImports = JavaClasspath.INSTANCE.getDefaultImports(packageName);
			contentsList.addAll(defaultImports);
		}
		//consider qualified package names
		if (container instanceof Package) {
			Package packageDescriptor = (Package) container;
			String fullPackageName = packageDescriptor.getName();
			Package parent = packageDescriptor.getParent();
			while(parent != null) {
				fullPackageName = parent.getName() + "." + fullPackageName;
				parent = parent.getParent();
			}
			
			contentsList.addAll(JavaClasspath.INSTANCE.getClassifiers(fullPackageName + ".", "*"));
		}
		else if (container instanceof Type) {
			//consider upper types --> can be optimized
			if (container instanceof PrimitiveType) {
				contentsList.addAll(getAllMemebers((PrimitiveType) container));
			}
			if (container instanceof ConcreteClassifier) {
				if (lookIntoSuper)
					contentsList.addAll(getAllMemebers((Classifier) container));
			}
			if (container instanceof AnonymousClass) {
				if (lookIntoSuper)
					contentsList.addAll(getAllMemebers((AnonymousClass) container));
			}
			else {
				//PARAMETER TYPE
			}
			//TODO 
			//Arrays have the additional member field "length"
			//We always add a field to the very end since we do not know if we have an array or not
			if (STANDARD_ARRAY_LENGTH_FIELD == null) {
				//init
				STANDARD_ARRAY_LENGTH_FIELD = MembersFactory.eINSTANCE.createField();
				STANDARD_ARRAY_LENGTH_FIELD.setName("length");
				STANDARD_ARRAY_LENGTH_FIELD.setType(
						TypesFactory.eINSTANCE.createInt());
			}
			contentsList.add(STANDARD_ARRAY_LENGTH_FIELD);
		}
		
		if (container instanceof AnonymousClass) {
			NewConstructorCall newCC = (NewConstructorCall) container.eContainer();
			Type type = getReferencedType(newCC.getType());
			if (type instanceof Classifier) {
				if (type instanceof MemberContainer) {
					contentsList.addAll(((MemberContainer)type).getMembers());
				}
				contentsList.addAll(getAllMemebers((Classifier) type));
			}
		}
	}
	
	
	//-------------

	@Override
	protected void doResolve(String identifier, T container,
			EReference reference, int position, boolean resolveFuzzy,
			IResolveResult result) {
		myResource = (ITextResource) container.eResource(); 

		//the element we are looking for
		EObject targetObject = null;
		//the parent of the container which might define the scope to search in
		EObject containerContainer = container.eContainer();
		
		//The search scope given by a type; if none, we will search in the local scope
		Type previousType = null;
		
		//type reference (2)
		if (containerContainer instanceof TypeReference && !(containerContainer.eContainer() instanceof QualifiedTypeArgument)) {
			//chained reference: scope given by previous element may be a type and may define a new scope
			previousType = getReferencedType((TypeReference) containerContainer);
		}
		
		//---- SPECIAL CASES ----
		
		AnnotationInstance annotationInstance = findContainingAnnotationInstance(container);
		AnonymousClass anonymousClass = null;
		
		//navigate through constructor calls: The constructor itself
		if (containerContainer.eContainer() instanceof NewConstructorCall 
				&& containerContainer.eContainingFeature().equals(TypesPackage.Literals.TYPED_ELEMENT__TYPE)
				&& containerContainer.eContainer().eContainmentFeature().equals(ReferencesPackage.Literals.REFERENCE__NEXT)) {
			EObject previouseRef = containerContainer.eContainer().eContainer();
			if (previouseRef instanceof Reference) {
				if (previouseRef instanceof NewConstructorCall) {
					anonymousClass = ((NewConstructorCall) previouseRef).getAnonymousClass();
				}
				previousType = getTypeOfReferencedElement((Reference)previouseRef);
			}
		}
		
		//in the special case that we have a NestedExpression that contains only(!) a NewConstructorCall with a possible anonymous class, we discard the NestedExpression
		if (containerContainer instanceof NestedExpression) {
			NestedExpression nextNested = (NestedExpression) containerContainer;
			while (true) {		
				if (nextNested.getExpression() instanceof NewConstructorCall) {
					containerContainer = nextNested.getExpression();
					break;
				}
				else if (nextNested.getExpression() instanceof NestedExpression) {
					nextNested = (NestedExpression) nextNested.getExpression();
				}
				else {
					break;
				}
			}
		}
		
		//consider inner classes
		if (containerContainer instanceof NewConstructorCall && container.eContainingFeature().equals(ReferencesPackage.Literals.REFERENCE__NEXT)) {
			TypeReference typeReference = ((NewConstructorCall)containerContainer).getType();
			previousType = getReferencedType(typeReference);
			anonymousClass = ((NewConstructorCall) containerContainer).getAnonymousClass();
		}
		
		//--------------------------------
		
		//normal reference (1)
		if (container instanceof Reference && container.eContainingFeature().equals(ReferencesPackage.Literals.REFERENCE__NEXT)) {
			//do not leave the local scope in case of anonymous class declarations
			if (containerContainer instanceof Instantiation) {
				//
			}
			else {	
				previousType = getTypeOfReferencedElement((Reference)containerContainer);
			}
		}

		
		//inside annotation instance 
		else if (previousType == null && annotationInstance != null && annotationInstance != containerContainer.eContainer() /*not the AnnotationInstance itself*/) {
			TypeReference typeReference = annotationInstance.getAnnotation();
			if (containerContainer instanceof ClassifierReference || containerContainer instanceof NamespaceClassifierReference) {
				ClassifierReference classifierReference = convertToClassifierReference(typeReference);
				if (classifierReference != null) {
					previousType = classifierReference.getTarget();
				}
			} 
		}
		
		//2) search in scope
		if (previousType == null) {
			//no previouseType, search local
			//reference in scope of the current compilation unit
			targetObject = findScoped(identifier, container, container, reference.getEReferenceType());
		}
		else {
			//we have another scope to search in
			if (anonymousClass != null) {
				targetObject = find(identifier, container, null, anonymousClass, reference.getEReferenceType());
			}
			if (targetObject == null) {
				targetObject = find(identifier, container, null, previousType, reference.getEReferenceType());
				if (targetObject == null && annotationInstance != null && container instanceof Reference) {
					//possibly type reference 
					targetObject = findScoped(identifier, container, container, reference.getEReferenceType());
				}
			}
		}
		
		//3) return the result if any
		if (targetObject != null) {
			//Now we can (and have to) resolve class proxies
			if (targetObject.eIsProxy()) {
				targetObject = EcoreUtil.resolve(targetObject, myResource);
			}
			result.addMapping(identifier, targetObject);
		}
		else if(previousType == null) {
			//in this cases we  may reference something that is probably a package
			if (reference.equals(
					ReferencesPackage.Literals.IDENTIFIER_REFERENCE__TARGET)) {
				Reference ref = (Reference)container;
				//there must be something (a classifier reference) following up
				if (ref.getNext() != null) {
					Package packageDescriptor = ContainersFactory.eINSTANCE.createPackage();
					packageDescriptor.setName(identifier);
					result.addMapping(identifier, packageDescriptor);
					
					if(ref.eContainer() instanceof Reference) {
						ref = (Reference) ref.eContainer();
						if (ref instanceof IdentifierReference) {
							IdentifierReference identifierReference = 
								(IdentifierReference) ref;
							if(identifierReference.getTarget() instanceof Package) {
								packageDescriptor.setParent((Package) identifierReference.getTarget());
							}
						}
					}
				}
				
			}
		}
}


	protected Type getTypeOfExpression(Expression exp) {
		Class stringClass = (Class) EcoreUtil.resolve(
				JavaClasspath.INSTANCE.getClassifier("java.lang.String"), myResource);
		
		Type type = null;

		if (exp instanceof Reference) {
			Reference ref = (Reference) exp;
			//navigate down references
			while(ref.getNext() != null) {
				ref = ref.getNext();
			}
			type = getTypeOfReferencedElement(ref);
		}
		else if (exp instanceof NestedExpression) {
			type = getTypeOfExpression(((NestedExpression) exp).getExpression());
		}
		else if (exp instanceof Literal) {
			type = getTypeOfReferencedElement(
					((Literal) exp));
		}
		else if (exp instanceof CastExpression) {
			type = getReferencedType(
					((CastExpression)exp).getTypeReference());
		}
		else if (exp instanceof AssignmentExpression) {
			type = getTypeOfExpression(((AssignmentExpression) exp).getChild());
		}
		else if (exp instanceof ConditionalExpression &&
				((ConditionalExpression)exp).getExpressionIf() != null) {
			
			type = getTypeOfExpression(((ConditionalExpression)exp).getExpressionIf());
		}
		else if (exp instanceof EqualityExpression ||
				exp instanceof RelationExpression ||
				exp instanceof ConditionalOrExpression ||
				exp instanceof ConditionalAndExpression ||
				exp instanceof InstanceOfExpression ) {
			type = TypesFactory.eINSTANCE.createBoolean();
		}
		else if (exp instanceof AdditiveExpression ||
				exp instanceof MultiplicativeExpression ||
				exp instanceof InclusiveOrExpression ||
				exp instanceof ExclusiveOrExpression ||
				exp instanceof AndExpression ||
				exp instanceof ShiftExpression ) {
			
			if (exp instanceof AdditiveExpression) {
				AdditiveExpression additiveExpression = (AdditiveExpression) exp;
				for(Expression subExp : additiveExpression.getChildren()) {
					if (stringClass.equals(getTypeOfExpression(subExp))) {
						//special case: string concatenation
						return stringClass;
					}
				}
			}
			
			type = TypesFactory.eINSTANCE.createInt();
		}
		else for(TreeIterator<EObject> i = exp.eAllContents(); i.hasNext(); ) {
			EObject next = i.next();
			Type nextType = null;

			if (next instanceof PrimaryExpression) {

				if (next instanceof Reference) {
					Reference ref = (Reference) next;
					//navigate down references
					while(ref.getNext() != null) {
						ref = ref.getNext();
					}
					next = ref;
				}
				if (next instanceof Literal) {
					nextType = getTypeOfReferencedElement(
							((Literal) next));
				}
				else if (next instanceof CastExpression) {
					nextType = getReferencedType(
							((CastExpression)next).getTypeReference());
				}
				else {
					nextType = getTypeOfReferencedElement(
							((Reference) next));
				}
				i.prune();

			}
			if (nextType != null) {
				type = nextType;
				//in the special case that this is an expression with
				//some string included, everything is converted to string
				if (stringClass.equals(type)) {
					break;
				}
			}
		}
		assert(type != null);

		return type;
	}
	
	protected EObject findScoped(String identifier, EObject context, EObject endOfScopeElement,
			EClass type) {
		
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

	protected EObject find(String id, EObject context, EObject element,  EObject container, EClass type) {
		//try the container
		if(hasCorrectType(container, type)) {
			if (isReferencedElement(id, context, container)) {
				return container;
			}
		}
		
		EList<EObject> contentsList = new BasicEList<EObject>();
		contentsList.addAll(getOrderedContents(container));
		//TODO this avoids when resolving a super type to consider the supertype itself as additional scope; should be structured better
		boolean lookIntoSuper = true;
		if (container instanceof Classifier && element instanceof QualifiedTypeArgument) {
			lookIntoSuper = false;
		}	
		cosiderAddittionalScope(container, contentsList, lookIntoSuper);
		for(EObject cand : contentsList) {
			if (cand == null) {
				//TODO clarify how this happens
				continue;
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
			
			if (cand.eIsProxy()) {
				//now we need to look inside classifiers
				cand = EcoreUtil.resolve(cand, myResource);
			}
			
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
	
	/**
	 * Determines the <code>Type</code> of the reference, considering all kinds of referencing mechanisms
	 * used in the Java metamodel.
	 * 
	 * @param reference
	 * @return the determined type
	 * @throws UnresolvedProxiesException
	 */
	protected Type getTypeOfReferencedElement(Literal literal) {
		TypesFactory javaTypeFactory = TypesFactory.eINSTANCE;
		if (literal instanceof NullLiteral) {
			return javaTypeFactory.createVoid();
		}
		else if (literal instanceof BooleanLiteral) {
			return javaTypeFactory.createBoolean();
		}
		else if (literal instanceof DoubleLiteral) {
			return javaTypeFactory.createDouble();
		}
		else if (literal instanceof FloatLiteral) {
			return javaTypeFactory.createFloat();
		}
		else if (literal instanceof IntegerLiteral) {
			return javaTypeFactory.createInt();
		}
		else if (literal instanceof LongLiteral) {
			return javaTypeFactory.createLong();
		}
		else if (literal instanceof CharacterLiteral) {
			return javaTypeFactory.createChar();
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
	protected Type getTypeOfReferencedElement(Reference reference) {
		Type type = null;

		//referenced element point to a type
		if (reference instanceof TypedElement) {
			TypeReference typeRef = ((TypedElement) reference).getType();
			type = getReferencedType(typeRef);
		}
		//element points to this or super
		else if (reference instanceof SelfReference) {
			if (reference.eContainer() instanceof Reference && reference.eContainingFeature().equals(ReferencesPackage.Literals.REFERENCE__NEXT)) {
				return getTypeOfReferencedElement((Reference)reference.eContainer());
			}
			else {
				//if (((SelfReference) reference).getSelf() instanceof This) {
				
				AnonymousClass anonymousContainer = findContainingAnonymousClass(reference);
				if (anonymousContainer != null) {
					NewConstructorCall ncCall = (NewConstructorCall) anonymousContainer.eContainer();
					return getReferencedType(ncCall.getType());
				}
				else {
					return findContainingClassifier(reference);	
				}
				//}
				// super may also reference to itself or an interface...	
				//else if (((SelfReference) reference).getSelf() instanceof Super) {
				//	return getSuperType(findContainingClass(reference));
				//}
			}

		}
		//element points to the object's class object
		else if(reference instanceof ReflectiveClassReference) {
			return getClassClassModelElement();
		}
		//referenced element points to an element with a type
		else if (reference instanceof IdentifierReference) {
			ReferenceableElement target = 
				(ReferenceableElement) ((IdentifierReference) reference).getTarget();
			if (target.eIsProxy()) {
				type = null;
			}
			
			//Navigate through AdditionalLocalVariable or Field
			if(target instanceof AdditionalLocalVariable) {
				target = (ReferenceableElement) target.eContainer();
			}
			if(target instanceof AdditionalField) {
				target = (ReferenceableElement) target.eContainer();
			}
			
			if (target instanceof TypedElement) {
				TypeReference typeRef = ((TypedElement) target).getType();
				type = getReferencedType(typeRef);
				if(reference.eContainer() instanceof IdentifierReference) {
					ReferenceableElement prevRef = ((IdentifierReference) reference.eContainer()).getTarget();
					
					if (prevRef instanceof TypedElement) {
						TypeReference prevType = ((TypedElement) prevRef).getType();
						if (prevType instanceof TypeReference || prevType instanceof NamespaceClassifierReference) {
							ClassifierReference classifierReference = convertToClassifierReference(prevType);
							if (classifierReference != null && !classifierReference.getTypeArguments().isEmpty()) {
								//naive implementation for using type arguments as return types
								if (type.equals(getObjectModelElement())) {
									TypeArgument arg = classifierReference.getTypeArguments().get(0);
									if (arg instanceof QualifiedTypeArgument) {
										type = getReferencedType(((QualifiedTypeArgument) arg).getType());
									}
								}
								
							}
						}
					}
				}
			}
			else if (target instanceof Type /*e.g. Annotation*/ ) {
				return (Type) target;
			}
		}
		//Strings may also appear as reference
		else if (reference instanceof StringReference) {
			Class stringClass = (Class) EcoreUtil.resolve(
					JavaClasspath.INSTANCE.getClassifier("java.lang.String"), myResource);
			return stringClass;
		}
		else if (reference instanceof NestedExpression) {
			type = getTypeOfExpression(((NestedExpression) reference).getExpression());
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
	protected Type getReferencedType(TypeReference typeReference) {
		/*
		 * TODO this method needs to investigate the context of typeReferene to check
		 * additional constrains. E.g., if the typeReference is used to define a 
		 * super interface of an interface the returned type must be an interface. 
		 */
		
		Type type = null;
		if (typeReference instanceof ClassifierReference || 
				typeReference instanceof NamespaceClassifierReference) {
			ClassifierReference classifierRef = convertToClassifierReference(typeReference);
			if (classifierRef != null) {
				type = classifierRef.getTarget();
			}
		}

		else if(typeReference instanceof PrimitiveType) {
			return (PrimitiveType) typeReference;
		}
		else {
			assert(false);
		}

		if (type != null && type.eIsProxy()) {
			//this may happen, when e.g. a super type is resolved. It is ok.
			return null;
		}
		
		if (type instanceof TypeParameter) {
			//TODO do we need to consider typeParameter.getExtendTypes()?
			//TypeParameter typeParameter = (TypeParameter) type;
			type = (Class) EcoreUtil.resolve(
					JavaClasspath.INSTANCE.getClassifier("java.lang.Object"), myResource);
		}

		return type;
	}
	
	
	protected ClassifierReference convertToClassifierReference(TypeReference typeReference) {
		ClassifierReference classifierRef = null;
		if (typeReference instanceof ClassifierReference) {
			ClassifierReference classifierReference = (ClassifierReference) typeReference;
			classifierRef = classifierReference;
		}
		if (typeReference instanceof NamespaceClassifierReference) {
			NamespaceClassifierReference classifierReference = (NamespaceClassifierReference) typeReference;
			if (!classifierReference.getClassifierReferences().isEmpty()) {
				int lastIndex = classifierReference.getClassifierReferences().size() - 1;
				classifierRef = classifierReference.getClassifierReferences().get(lastIndex);
			}
		}
		return classifierRef;
	}


	protected EList<Type> getArgumentTypes(ArgumentList argList) {
		
		EList<Type> resultList = new BasicEList<Type>();

		
		for(Expression exp : argList.getArguments()) {
			//find the reference at the end of the expression
			Type type = getTypeOfExpression(exp);
			resultList.add(type);
		}
		return resultList;
	}
	
	protected boolean isReferencedElement(String id, EObject context, EObject candidate) {
		//we either look for a ReferenceableElement element or a Classifier
		if (!(candidate instanceof NamedElement)) {
			//no name
			return false;
		}
		if (id.equals(((NamedElement)candidate).getName())) {
			if (candidate instanceof Classifier) {
				//should never happen here
				return checkClassifier(id, context, (Classifier) candidate);
			}
			if (candidate instanceof ReferenceableElement) {
				return checkReferencableElement(id, context, (ReferenceableElement) candidate);
			}
		}
		return false;
	}
	
	protected boolean checkClassifier(String id, EObject context, Classifier referencedElement) {
		if (context instanceof ClassifierReference) {
			if (context.eContainer() instanceof NamespaceClassifierReference) {
				NamespaceClassifierReference nsClassifierReference = (NamespaceClassifierReference) context.eContainer();
				if (!nsClassifierReference.getNamespace().isEmpty()) {
					//done later
					return false;
				}
			}			
			return true;
		}
		if (context instanceof IdentifierReference) {
			return true;
		}
		return false;
	}


	protected boolean checkReferencableElement(String id, EObject context, ReferenceableElement referencableElement) {
		boolean result = false;

		if (referencableElement instanceof ReferenceableElement) {
			boolean isMethodCall = false;
			if(context instanceof IdentifierReference) {
				isMethodCall = ((IdentifierReference) context).getArgumentList() != null;
			}
			
			if(!isMethodCall) {
				if (referencableElement instanceof Field) {
					//nothing else to do
					result = true;
				}
				else if (referencableElement instanceof AdditionalField) {
					//nothing else to do
					result = true;
				}
				else if (referencableElement instanceof Variable) {
					//nothing else to do (includes LocalVariable and Parameter)
					result = true;
				}
				else if (referencableElement instanceof AdditionalLocalVariable) {
					//nothing else to do
					result = true;
				}
				else if (referencableElement instanceof TypeParameter) {
					//nothing else to do
					result = true;
				}
				else if (referencableElement instanceof EnumConstant) {
					//nothing else to do
					result = true;
				}
				else {
					result = false;
				}
			}
			else {
				if (referencableElement instanceof Method) {
					//in case of Methods the parameter types need to be checked
					Method method = (Method) referencableElement;
					if (context instanceof IdentifierReference) {
						IdentifierReference reference = (IdentifierReference) context;
						EList<Type> argumentTypes = getArgumentTypes(reference.getArgumentList());
						EList<Parameter> parameters = new BasicEList<Parameter>(method.getParameters());
						if (!parameters.isEmpty()) {
							//in case of variable length add/remove some parameters
							Parameter lastParameter = parameters.get(parameters.size() - 1);
							if (lastParameter instanceof VariableLengthParameter) {
								while(parameters.size() < argumentTypes.size()) {
									parameters.add(lastParameter);
								}
								if(parameters.size() > argumentTypes.size()) {
									parameters.remove(lastParameter);
								}
							}
						}
						
						if (parameters.size() == argumentTypes.size()) {
							result = true;
							for (int i = 0; i < argumentTypes.size(); i++) {
								InternalEObject type = (InternalEObject) getReferencedType(parameters.get(i).getType());
								InternalEObject argumentType = (InternalEObject) argumentTypes.get(i);
								if (argumentType == null) {
									result = false;
									break;
								}
								
								if (type != null && argumentType != null) {
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
								else {
									result = false;
									break;
								}
							}
							if (result) {
								result = isBestFit(method, argumentTypes, parameters);
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
		}
		return result;
	}

	protected boolean isBestFit(Method m, EList<Type> argumentTypes, EList<Parameter> parameters) {
		//TODO in a revised implementation this code might go somewhere else to avoid duplicated checks
		String name = m.getName();
		boolean thisIsPerfect = true;
		for (int i = 0; i < argumentTypes.size(); i++) {
			InternalEObject type = (InternalEObject) getReferencedType(parameters.get(i).getType());
			InternalEObject argumentType = (InternalEObject) argumentTypes.get(i);
			if (argumentType == null) {
				break;
			}
			
			if (type != null && argumentType != null) {
				if (!type.eIsProxy() || !argumentType.eIsProxy()) {
					if(!compareTypesStrict(type, argumentType)) {
						thisIsPerfect = false;
					}
				}
			}
		}
		
		if(thisIsPerfect) {
			return true;
		}
		
		if (!(m.eContainer() instanceof Classifier) || !(m.eContainer() instanceof MemberContainer)) {
			//should not happen
			return true;
		}
		
		EList<Member> completeMemberList = new BasicEList<Member>(((MemberContainer)m.eContainer()).getMembers());
		//only add super members which are not yet added -> extend getAllMembersMethod to exclude some
		//completeMemberList.addAll(getAllMemebers((Classifier) m.eContainer()));
		
		for(Member otherMember : completeMemberList) {
			if (otherMember instanceof Method) {
				Method potentialBetterFit = (Method) otherMember;
				parameters = potentialBetterFit.getParameters();
				if (!m.equals(potentialBetterFit) &&
						name.equals(potentialBetterFit.getName()) &&
						argumentTypes.size() == potentialBetterFit.getParameters().size()) {
					
					boolean strictMatch = true;
					
					for (int i = 0; i < argumentTypes.size(); i++) {
						InternalEObject type = (InternalEObject) getReferencedType(parameters.get(i).getType());
						InternalEObject argumentType = (InternalEObject) argumentTypes.get(i);
						if (argumentType == null) {
							break;
						}
						
						if (type != null && argumentType != null) {
							if (!type.eIsProxy() || !argumentType.eIsProxy()) {
								if(compareTypesStrict(type, argumentType)) {
									//there is a better fit, which will be found later
									strictMatch = false;
									continue;
									//TODO still need to check for "nearest subtype" here
								}
							}
						}
						strictMatch = true;
						break;
					}
					if(!strictMatch) {
						return false;
					}
				}	
			}
		}
		return true;
	}

	protected boolean compareTypesStrict(EObject moreGeneral,
			EObject lessGeneral) {
		
		if (moreGeneral instanceof Classifier && lessGeneral instanceof Classifier &&
				(moreGeneral.equals(lessGeneral))) {
			
			return true;
		}
		else if (moreGeneral instanceof PrimitiveType && lessGeneral instanceof PrimitiveType && 
				moreGeneral.eClass().equals(lessGeneral.eClass())) {
			return true;
		}
		
		return false;
	}
			
	protected boolean compareTypes(EObject moreGeneral,
			EObject lessGeneral) { //type
		
		Class objectClass = getObjectModelElement();
		
		//if parameter type is void, always match
		if (lessGeneral instanceof Void) {
			return true;
		}

		if (lessGeneral instanceof Boolean) {
			if (moreGeneral instanceof Boolean ||
					moreGeneral.equals(objectClass)) {
				return true;
			}
			else {
				return false;
			}
		}
		if (lessGeneral instanceof Byte ||
				lessGeneral instanceof Int ||
				lessGeneral instanceof Short ||
				lessGeneral instanceof Long ||
				lessGeneral instanceof Char) {
			if (moreGeneral instanceof Byte ||
					moreGeneral instanceof Int ||
					moreGeneral instanceof Short ||
					moreGeneral instanceof Long ||
					moreGeneral instanceof Char ||
					moreGeneral instanceof Float ||
					moreGeneral instanceof Double ||
					moreGeneral.equals(objectClass)) {
				return true;
			}
			else {
				return false;
			}
		}
		if (lessGeneral instanceof Float ||
				lessGeneral instanceof Double) {
			if (moreGeneral instanceof Float ||
					moreGeneral instanceof Double ||
					moreGeneral.equals(objectClass)) {
				return true;
			}
			else {
				return false;
			}
		}

		if (moreGeneral instanceof Classifier && lessGeneral instanceof Classifier &&
				(moreGeneral.equals(lessGeneral) || getAllSuperTypes((Classifier)lessGeneral).contains(moreGeneral))) {
			
			return true;
		}
		
		if (moreGeneral instanceof Classifier) {
			//everything can be implicitly casted to string
			return moreGeneral.equals(EcoreUtil.resolve(
						JavaClasspath.INSTANCE.getClassifier("java.lang.CharSequence"), myResource))||
				getAllSuperTypes((Classifier)moreGeneral).contains(EcoreUtil.resolve(
						JavaClasspath.INSTANCE.getClassifier("java.lang.CharSequence"), myResource));
		}

		return false;
	}
	
	protected ConcreteClassifier findContainingClassifier(EObject value) {
		while (!(value instanceof ConcreteClassifier) && value != null) {
			value = value.eContainer();
		}
		return (ConcreteClassifier) value;
	}
	
	protected AnonymousClass findContainingAnonymousClass(EObject value) {
		while (!(value instanceof AnonymousClass) 
				&& !(value instanceof ConcreteClassifier) //do not jump over other classifiers 
				&&value != null) {
			value = value.eContainer();
		}
		if (!(value instanceof AnonymousClass)) {
			return null;
		}
		return (AnonymousClass) value;
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
	
	protected EList<Member> getAllMemebers(PrimitiveType primitiveType) {
		Classifier javaClassifier = null;
		//automatic wrapping of primitive types
		if (primitiveType instanceof Boolean) {
			javaClassifier = JavaClasspath.INSTANCE.getClassifier("java.lang.Boolean");
		}
		if (primitiveType instanceof Byte) {
			javaClassifier = JavaClasspath.INSTANCE.getClassifier("java.lang.Byte");
		}
		if (primitiveType instanceof Char) {
			javaClassifier = JavaClasspath.INSTANCE.getClassifier("java.lang.Character");
		}
		if (primitiveType instanceof Double) {
			javaClassifier = JavaClasspath.INSTANCE.getClassifier("java.lang.Double");
		}
		if (primitiveType instanceof Float) {
			javaClassifier = JavaClasspath.INSTANCE.getClassifier("java.lang.Float");
		}
		if (primitiveType instanceof Int) {
			javaClassifier = JavaClasspath.INSTANCE.getClassifier("java.lang.Integer");
		}
		if (primitiveType instanceof Long) {
			javaClassifier = JavaClasspath.INSTANCE.getClassifier("java.lang.Long");
		}
		if (primitiveType instanceof Short) {
			javaClassifier = JavaClasspath.INSTANCE.getClassifier("java.lang.Short");
		}
		if (primitiveType instanceof Void) {
			javaClassifier = JavaClasspath.INSTANCE.getClassifier("java.lang.Void");
		}	
		
		javaClassifier = (Classifier) EcoreUtil.resolve(javaClassifier, myResource);
		
		return getAllMemebers(javaClassifier);
	}
	
	protected EList<Member> getAllMemebers(AnonymousClass anonymousClass) {
		NewConstructorCall ncCall = (NewConstructorCall) anonymousClass.eContainer();
		if (ncCall == null) {
			return new BasicEList<Member>();
		}
		else {
			return getAllMemebers((Classifier)getReferencedType(ncCall.getType()));
		}
	}
	
	protected EList<Member> getAllMemebers(Classifier javaClassifier) {
		EList<Member> memberList = new BasicEList<Member>();
		//because inner classes are found in separate class files
		memberList.addAll(
				JavaClasspath.INSTANCE.getInternalClassifiers(javaClassifier));
		for (Classifier superClassifier : getAllSuperTypes(javaClassifier)) {
			if (superClassifier instanceof MemberContainer /*Class and Interface*/) {
				memberList.addAll(((MemberContainer) superClassifier).getMembers());
				memberList.addAll(
						JavaClasspath.INSTANCE.getInternalClassifiers(superClassifier));
			}
			else {
				//nothing
				assert(false);
			}
		}
		return memberList;
	}
	
	protected EList<ConcreteClassifier> getAllSuperTypes(Classifier javaClassifier) {
		EList<ConcreteClassifier> superClassifierList = new BasicEList<ConcreteClassifier>();
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
		} else if (javaClassifier instanceof Enumeration) {
			//enumerations inherit from java.lang.Enum
			Class enumClass = (Class) EcoreUtil.resolve(
					JavaClasspath.INSTANCE.getClassifier("java.lang.Enum"), myResource);
			superClassifierList.add(enumClass);
			collectAllSuperClassifiers(enumClass, superClassifierList);
			
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
	protected Class getSuperType(Class subClass) {
		Class superClass = null;
		if (subClass.getExtends() != null) {
			Type superType = getReferencedType(subClass.getExtends().getType());
			if (superType instanceof Class) {
				superClass = (Class) superType;
			}
		} 
		if (superClass == null ) {
			superClass = getObjectModelElement();
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
			EList<ConcreteClassifier> resultClassifierList)
			{
		//collects all superclasses
		Class superClass = javaClass;
		while (!superClass.eIsProxy() && !superClass.getName().equals("Object")) {
			superClass = getSuperType(superClass);
			resultClassifierList.add(superClass);
		}
		
		EList<ConcreteClassifier> onlyClasses = new BasicEList<ConcreteClassifier>(resultClassifierList);
		
		//collect all implemented interfaces
		collectAllSuperInterfaces(
				javaClass.getImplements(), resultClassifierList);
		for(Classifier superClassifier : onlyClasses) {
			if (superClassifier instanceof Class) {
			collectAllSuperInterfaces(
					((Class)superClassifier).getImplements(), resultClassifierList);
			}
		}
	}

	/**
	 * Recursively collects all interfaces and their superinterfaces
	 * referenced by the given list of references to interfaces.
	 * 
	 * @param interfaceReferences a list of references to interfaces
	 * @param resultInterfaceList the list with the reuslt
	 * @
	 */
	protected void collectAllSuperInterfaces(EList<QualifiedTypeArgument> interfaceReferences,
		EList<ConcreteClassifier> resultInterfaceList) {
	
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
		if (interfaceReferences.isEmpty()) {
			//object is also supertype of all interfaces
			resultInterfaceList.add(getObjectModelElement());
		}
	}
	
	/**
	 * Finds the model element representing <code>java.lang.Class</code>.
	 * @return class object model element
	 */
	protected Class getClassClassModelElement() {
		Class classClass = (Class) JavaClasspath.INSTANCE.getClassifier(
				"java.lang.Class");
		classClass = (Class) EcoreUtil.resolve(classClass, myResource);
		return classClass;
	}
	
	protected Class getObjectModelElement() {
		Class objectClass = (Class) JavaClasspath.INSTANCE.getClassifier(
				"java.lang.Object");
		objectClass = (Class) EcoreUtil.resolve(objectClass, myResource);
		return objectClass;
	}

}
