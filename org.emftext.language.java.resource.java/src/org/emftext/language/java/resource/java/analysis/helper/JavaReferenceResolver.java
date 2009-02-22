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
import org.emftext.language.java.annotations.AnnotationAttribute;
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
import org.emftext.language.java.generics.TypeParametrizable;
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
import org.emftext.language.java.members.Constructor;
import org.emftext.language.java.members.EnumConstant;
import org.emftext.language.java.members.Field;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.members.MemberContainer;
import org.emftext.language.java.members.MembersFactory;
import org.emftext.language.java.members.Method;
import org.emftext.language.java.parameters.Parameter;
import org.emftext.language.java.parameters.ParametersFactory;
import org.emftext.language.java.parameters.VariableLengthParameter;
import org.emftext.language.java.references.Argumentable;
import org.emftext.language.java.references.ElementReference;
import org.emftext.language.java.references.IdentifierReference;
import org.emftext.language.java.references.MethodCall;
import org.emftext.language.java.references.Reference;
import org.emftext.language.java.references.ReferenceableElement;
import org.emftext.language.java.references.ReferencesPackage;
import org.emftext.language.java.references.ReflectiveClassReference;
import org.emftext.language.java.references.SelfReference;
import org.emftext.language.java.references.StringReference;
import org.emftext.language.java.statements.NormalSwitchCase;
import org.emftext.language.java.statements.StatementContainer;
import org.emftext.language.java.statements.StatementListContainer;
import org.emftext.language.java.statements.StatementsPackage;
import org.emftext.language.java.statements.Switch;
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
import org.emftext.runtime.resource.IReferenceResolveResult;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.resource.impl.AbstractReferenceResolver;



public abstract class JavaReferenceResolver<T extends EObject> extends AbstractReferenceResolver<T, EObject> {

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
		//e.g. when resolving a type parameter
		if (element instanceof Method) {
			return false;
		}
		//in all other cases, the order requires consideration
		return true;
	}
	
	protected boolean breakIfChild(EObject parent, EObject child, EClass typeToResolve)  {
		if (parent == null) {
			return false;
		}
		
		//do not go into other classifier declarations (but enums --> or better static fields of all?)
		if (parent instanceof Class || parent instanceof Interface) {
			return true;
		}
		//do not look into parameters or contents of other methods
		if (parent instanceof Method) {
			return true;
		}
		if (parent instanceof Constructor) {
			return true;
		}
		
		if (child == null) {
			return false;
		}
		
		//go not go into a new block
		if (parent instanceof StatementListContainer && child.eContainingFeature().equals(StatementsPackage.STATEMENT_LIST_CONTAINER__STATEMENTS)) {
			return true;
		}

		//go not go into loops
		if (parent instanceof StatementContainer && child.eContainingFeature().equals(StatementsPackage.STATEMENT_CONTAINER__STATEMENT)) {
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

			//explicit classifier imports first
			for(Import explicitImport : cu.getImports()) {
				if (explicitImport instanceof ClassifierImport) {
					ConcreteClassifier classifierImport = 
						((ClassifierImport)explicitImport).getClassifier();
					contentsList.add(classifierImport);
				}
				else if (explicitImport instanceof StaticMemberImport) {
					contentsList.addAll(((StaticMemberImport)explicitImport).getStaticMembers());
				}
				else if (explicitImport instanceof StaticClassifierImport) {
					EList<Member> staticMembers = 
						((StaticClassifierImport)explicitImport).getStaticMembers();
					contentsList.addAll(staticMembers);
				}
			}
			
			String packageName = JavaUniquePathConstructor.packageName(cu);
			//classes in the same package
			if(!packageName.equals("")) {
				//put at the end when default package is used
				//TODO this works for tests. 
				//Is this the desired behavior? Usually default package is not used.
				contentsList.addAll(JavaClasspath.INSTANCE.getClassifiers(packageName + ".", "*"));
			}

			for(Import explicitImport : cu.getImports()) {
				if (explicitImport instanceof PackageImport) {
					EList<ConcreteClassifier> importedClassifiers =  
						JavaClasspath.INSTANCE.getClassifiers(explicitImport);
					contentsList.addAll(importedClassifiers);
				
				}
			}

			EList<ConcreteClassifier> defaultImports = JavaClasspath.INSTANCE.getDefaultImports();
			contentsList.addAll(defaultImports);
			if(packageName.equals("")) {
				contentsList.addAll(JavaClasspath.INSTANCE.getClassifiers(packageName + ".", "*"));
			}
			
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
				contentsList.addAll(getAllMembers((PrimitiveType) container));
			}
			if (container instanceof ConcreteClassifier) {
				if (lookIntoSuper) {
					contentsList.addAll(getAllMembers((Classifier) container));
				}
			}
			if (container instanceof AnonymousClass) {
				if (lookIntoSuper)
					contentsList.addAll(getAllMemebers((AnonymousClass) container));
			}
			if (container instanceof TypeParameter) {
				if (lookIntoSuper) {
					contentsList.addAll(getAllMembers((Classifier) container));
				}
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
			Type type = getReferencedType(newCC.getType(),null);
			if (type instanceof Classifier) {
				if (type instanceof MemberContainer) {
					contentsList.addAll(((MemberContainer)type).getMembers());
				}
				contentsList.addAll(getAllMembers((Classifier) type));
			}
		}
	}
	
	
	//-------------

	@Override
	protected void doResolve(String identifier, T container,
			EReference reference, int position, boolean resolveFuzzy,
			IReferenceResolveResult<EObject> result) {
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
			previousType = getReferencedType((TypeReference) containerContainer, null);
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
			previousType = getReferencedType(typeReference, null);
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
			TypeReference typeReference = annotationInstance.getType();
			previousType = getReferencedType(typeReference, null); 
		}
		
		if (previousType == null && containerContainer instanceof NormalSwitchCase) {
			Switch switchStatement = (Switch) containerContainer.eContainer();
			Type type = getTypeOfExpression(switchStatement.getVariable());
			if (type instanceof Enumeration) {
				//special scoping for switching enumerations
				previousType = type;
			}
		}
		
		//2) search in scope
		if (previousType == null) {
			//no previouseType, search local
			//reference in scope of the current compilation unit
			targetObject = findScoped(identifier, container, container, reference.getEReferenceType());
		}
		else {
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
		else {
			//in this cases we  may reference something that is probably a package
			if (reference.equals(
					ReferencesPackage.Literals.ELEMENT_REFERENCE__TARGET)) {
				Reference ref = (Reference)container;
				//there must be something (a classifier reference) following up
				if (ref.getNext() != null && ref instanceof IdentifierReference) {
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
					((CastExpression)exp).getType(), null);
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
			
			Expression subExp = ((EList<Expression>) exp.eGet(exp.eClass().getEStructuralFeature("children"))).get(0);
			return getTypeOfExpression(subExp);
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
							((CastExpression)next).getType(), null);
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
			if (breakIfChild(element, null, type)) {
				continue;
			}
			//consider also children
			
			if (cand.eIsProxy()) {
				//now we need to look inside classifiers
				cand = EcoreUtil.resolve(cand, myResource);
			}			

			for(TreeIterator<EObject> it = cand.eAllContents(); it.hasNext(); ) {
				EObject subCand = it.next();
				if (breakIfChild(subCand.eContainer(), subCand, type)) {
					it.prune();
				}

				if(hasCorrectType(subCand, type)) {
					if (isReferencedElement(id, context, subCand)) {
						return subCand;
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
			type = getReferencedType(typeRef, reference);
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
					return anonymousContainer;
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
		else if (reference instanceof ElementReference) {
			ReferenceableElement target = 
				(ReferenceableElement) ((ElementReference) reference).getTarget();
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
				type = getReferencedType(typeRef, reference);
			}
			else if (target instanceof Type /*e.g. Annotation*/ ) {
				return (Type) target;
			}
			else if(target instanceof EnumConstant) {
				type = (Enumeration)target.eContainer();
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
	protected Type getReferencedType(TypeReference typeReference, Reference reference) {
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
			//type = 
				//(Class) EcoreUtil.resolve(
				//	JavaClasspath.INSTANCE.getClassifier("java.lang.Object"), myResource);
		}

		type = findTypeForParameter(reference, type);
		
		return type;
	}


	protected Type findTypeForParameter(Reference reference, Type type) {
		if(!(type instanceof TypeParameter)) {
			return type;
		}
		
		TypeParameter typeParameter = (TypeParameter) type;
		TypeParametrizable typeParameterDeclarator = (TypeParametrizable) typeParameter.eContainer();
		int typeParameterIndex = -1;
		if (typeParameterDeclarator instanceof ConcreteClassifier) {
			typeParameterIndex = typeParameterDeclarator.getTypeParameters().indexOf(typeParameter);
			if(reference != null && reference.eContainer() instanceof ElementReference) {
				ReferenceableElement prevRef = ((ElementReference) reference.eContainer()).getTarget();
				if (prevRef instanceof TypedElement) {
					TypeReference prevTypeReference = ((TypedElement) prevRef).getType();
					if (prevTypeReference instanceof TypeReference || prevTypeReference instanceof NamespaceClassifierReference) {
						ClassifierReference classifierReference = convertToClassifierReference(prevTypeReference);
						Type prevType = getReferencedType(classifierReference, (ElementReference) reference.eContainer());
						if (classifierReference != null && !classifierReference.getTypeArguments().isEmpty() && prevType instanceof ConcreteClassifier) {
							TypeArgument arg = classifierReference.getTypeArguments().get(typeParameterIndex);
							if (arg instanceof QualifiedTypeArgument) {
								type = getReferencedType(((QualifiedTypeArgument) arg).getType(), null);
							}
						}
					}
				}
			}
		}
		
		if (typeParameterDeclarator instanceof Method) {
			Method method = (Method) typeParameterDeclarator;
			for(int i = 0; i < method.getParameters().size(); i++) {
				ClassifierReference classifierReference = convertToClassifierReference(method.getParameters().get(i).getType());
				if(classifierReference != null && typeParameter.equals(classifierReference.getTarget())) {
					typeParameterIndex = i;
					break;
				}
			}
			if (reference instanceof ElementReference) {
				ElementReference idReference = (ElementReference)reference;

				if (typeParameterIndex != -1 && typeParameterIndex < idReference.getTypeArguments().size()) {
					TypeArgument typeArgument = idReference.getTypeArguments().get(typeParameterIndex);
					if(typeArgument instanceof QualifiedTypeArgument) {
						type = getReferencedType(((QualifiedTypeArgument)typeArgument).getType(), null);
					}
				}
			}
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


	protected EList<Type> getArgumentTypes(Argumentable argList) {
		
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
				if (!nsClassifierReference.getNamespaces().isEmpty()) {
					//done later
					return false;
				}
			}			
			return true;
		}
		if (context instanceof ElementReference) {
			return true;
		}
		return false;
	}


	protected boolean checkReferencableElement(String id, EObject context, ReferenceableElement referencableElement) {
		boolean result = false;

		if (referencableElement instanceof ReferenceableElement) {
			boolean isMethodCall = false;
			if(context instanceof MethodCall) {
				isMethodCall = true;
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
				else if (referencableElement instanceof AnnotationAttribute) {
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
					if (context instanceof MethodCall) {
						MethodCall reference = (MethodCall) context;
						EList<Type> argumentTypes = getArgumentTypes(reference);
						EList<Parameter> parameters = new BasicEList<Parameter>(method.getParameters());
						boolean adjustedParameterCount = false;
						if (!parameters.isEmpty()) {
							//in case of variable length add/remove some parameters
							Parameter lastParameter = parameters.get(parameters.size() - 1);
							if (lastParameter instanceof VariableLengthParameter) {
								while(parameters.size() < argumentTypes.size()) {
									parameters.add(lastParameter);
									adjustedParameterCount=true;
								}
								if(parameters.size() > argumentTypes.size()) {
									parameters.remove(lastParameter);
									adjustedParameterCount=true;
								}
							}
						}
						
						if (parameters.size() == argumentTypes.size()) {
							result = true;
							for (int i = 0; i < argumentTypes.size(); i++) {
								InternalEObject type = (InternalEObject) getReferencedType(parameters.get(i).getType(), (Reference) context);
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
								result = isBestFit(method, argumentTypes, parameters, (Reference) context, adjustedParameterCount);
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

	protected boolean isBestFit(Method m, EList<Type> argumentTypes, EList<Parameter> parameters, Reference context, boolean adjustedParameterCount) {
		//TODO in a revised implementation this code might go somewhere else to avoid duplicated checks
		String name = m.getName();
		boolean thisIsPerfect = true;
		
		if(adjustedParameterCount) {
			thisIsPerfect = false;
		}
		
		for (int i = 0; i < argumentTypes.size(); i++) {
			InternalEObject type = (InternalEObject) getReferencedType(parameters.get(i).getType(), context);
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
					
					//if this stays true, there is a better fit, which will be found later
					boolean isBetterFit = true;
					
					for (int i = 0; i < argumentTypes.size(); i++) {
						InternalEObject type = (InternalEObject) getReferencedType(parameters.get(i).getType(), context);
						InternalEObject argumentType = (InternalEObject) argumentTypes.get(i);
						if (argumentType == null) {
							isBetterFit = false;
							break;
						}
						
						if (type != null && argumentType != null) {
							if (!type.eIsProxy() || !argumentType.eIsProxy()) {
								if(compareTypesStrict(type, argumentType)) {
									continue;
									//TODO still need to check for "nearest subtype" here
								}
							}
						}
						isBetterFit = false;
						break;
					}
					if(isBetterFit) {
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
		
		if(lessGeneral instanceof TypeParameter || moreGeneral instanceof TypeParameter ) {
			return true;
		}

		//first complex type compare
		if (lessGeneral instanceof PrimitiveType) {
			lessGeneral = wrapPrimitives((PrimitiveType) lessGeneral);
		}
		if (moreGeneral instanceof PrimitiveType) {
			moreGeneral = wrapPrimitives((PrimitiveType) moreGeneral);
		}
		
		if (moreGeneral instanceof Classifier && lessGeneral instanceof Classifier &&
				(moreGeneral.equals(lessGeneral) || getAllSuperTypes((Classifier)lessGeneral).contains(moreGeneral))) {
			
			return true;
		}
		
		if (moreGeneral instanceof Classifier && lessGeneral instanceof AnonymousClass &&
				getAllSuperTypes((AnonymousClass)lessGeneral).contains(moreGeneral)) {
			
			return true;
		}
		
		if (moreGeneral instanceof Classifier) {
			//everything can be implicitly casted to string
			if(moreGeneral.equals(EcoreUtil.resolve(
						JavaClasspath.INSTANCE.getClassifier("java.lang.CharSequence"), myResource))||
				getAllSuperTypes((Classifier)moreGeneral).contains(EcoreUtil.resolve(
						JavaClasspath.INSTANCE.getClassifier("java.lang.CharSequence"), myResource))) {
				return true;
			}
		}
		
		//specifics for primitive types
		if (moreGeneral instanceof ConcreteClassifier) {
			PrimitiveType primitiveType = unWrapPrimitives((ConcreteClassifier) moreGeneral);
			if(primitiveType != null) {
				moreGeneral = primitiveType;
			}
		}
		if (lessGeneral instanceof ConcreteClassifier) {
			PrimitiveType primitiveType = unWrapPrimitives((ConcreteClassifier) lessGeneral);
			if(primitiveType != null) {
				lessGeneral = primitiveType;
			}
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
	
	protected EList<Member> getAllMembers(PrimitiveType primitiveType) {
		Classifier javaClassifier = wrapPrimitives(primitiveType);	
		
		javaClassifier = (Classifier) EcoreUtil.resolve(javaClassifier, myResource);
		
		return getAllMembers(javaClassifier);
	}

	protected EObject resolve(EObject element) {
		return EcoreUtil.resolve(element, myResource);
	}
	
	protected PrimitiveType unWrapPrimitives(ConcreteClassifier primitiveTypeAsClass) {	
		if (resolve(JavaClasspath.INSTANCE.getClassifier("java.lang.Boolean")).equals(primitiveTypeAsClass)) {
			return TypesFactory.eINSTANCE.createBoolean();
		}
		if (resolve(JavaClasspath.INSTANCE.getClassifier("java.lang.Byte")).equals(primitiveTypeAsClass)) {
			return TypesFactory.eINSTANCE.createByte();
		}
		if (resolve(JavaClasspath.INSTANCE.getClassifier("java.lang.Character")).equals(primitiveTypeAsClass)) {
			return TypesFactory.eINSTANCE.createChar();
		}
		if (resolve(JavaClasspath.INSTANCE.getClassifier("java.lang.Float")).equals(primitiveTypeAsClass)) {
			return TypesFactory.eINSTANCE.createFloat();
		}
		if (resolve(JavaClasspath.INSTANCE.getClassifier("java.lang.Double")).equals(primitiveTypeAsClass)) {
			return TypesFactory.eINSTANCE.createDouble();
		}
		if (resolve(JavaClasspath.INSTANCE.getClassifier("java.lang.Integer")).equals(primitiveTypeAsClass)) {
			return TypesFactory.eINSTANCE.createInt();
		}
		if (resolve(JavaClasspath.INSTANCE.getClassifier("java.lang.Long")).equals(primitiveTypeAsClass)) {
			return TypesFactory.eINSTANCE.createLong();
		}
		if (resolve(JavaClasspath.INSTANCE.getClassifier("java.lang.Short")).equals(primitiveTypeAsClass)) {
			return TypesFactory.eINSTANCE.createShort();
		}
		if (resolve(JavaClasspath.INSTANCE.getClassifier("java.lang.Void")).equals(primitiveTypeAsClass)) {
			return TypesFactory.eINSTANCE.createVoid();
		}
		return null;
	}
	
	protected Classifier wrapPrimitives(PrimitiveType primitiveType) {
		Classifier javaClassifier = null;
		
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
		return (Classifier) EcoreUtil.resolve(javaClassifier, myResource);
	}
	
	protected EList<Member> getAllMemebers(AnonymousClass anonymousClass) {
		NewConstructorCall ncCall = (NewConstructorCall) anonymousClass.eContainer();
		if (ncCall == null) {
			return new BasicEList<Member>();
		}
		else {
			return getAllMembers((Classifier)getReferencedType(ncCall.getType(), null));
		}
	}
	
	protected EList<Member> getAllMembers(Classifier javaClassifier) {
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
		
		if(javaClassifier instanceof Enumeration)  {
			//add the default Enum methods. Might also go into a post processor...
			Method valuesMethod = MembersFactory.eINSTANCE.createInterfaceMethod();
			valuesMethod.setName("values");
			ClassifierReference type = TypesFactory.eINSTANCE.createClassifierReference();
			type.setTarget(javaClassifier);
			valuesMethod.setType(type);
			
			Method valueOfMethod = MembersFactory.eINSTANCE.createInterfaceMethod();
			valueOfMethod.setName("valueOf");
			type = TypesFactory.eINSTANCE.createClassifierReference();
			type.setTarget(javaClassifier);
			valueOfMethod.setType(type);
			
			Parameter strParameter = ParametersFactory.eINSTANCE.createOrdinaryParameter();
			strParameter.setName("str");
			type = TypesFactory.eINSTANCE.createClassifierReference();
			type.setTarget(JavaClasspath.INSTANCE.getClassifier("java.lang.String"));
			strParameter.setType(type);
			
			valueOfMethod.getParameters().add(strParameter);
			
			memberList.add(valuesMethod);
			memberList.add(valueOfMethod);
		}
		return memberList;
	}
	
	protected EList<ConcreteClassifier> getAllSuperTypes(AnonymousClass anonymousClass) {
		NewConstructorCall ncCall = (NewConstructorCall) anonymousClass.eContainer();
		Type superType = getReferencedType(ncCall.getType(), null);
		EList<ConcreteClassifier> superClassifierList = new BasicEList<ConcreteClassifier>();
		
		if (superType instanceof ConcreteClassifier ) {
			superClassifierList.add((ConcreteClassifier) superType);
			superClassifierList.addAll(getAllSuperTypes((ConcreteClassifier)superType));
		}
		else {
			superClassifierList.add(getObjectModelElement());
		}
		return superClassifierList;
	}
	
	protected EList<ConcreteClassifier> getAllSuperTypes(Classifier javaClassifier) {
		EList<ConcreteClassifier> superClassifierList = new BasicEList<ConcreteClassifier>();
		if(javaClassifier == null) {
			return superClassifierList;
		}
		javaClassifier = (Classifier) EcoreUtil.resolve(javaClassifier, myResource);
		if (javaClassifier instanceof Class) {
			Class javaClass = (Class) javaClassifier;
			collectAllSuperClassifiers(javaClass, superClassifierList);
		} else if (javaClassifier instanceof Interface) {
			Interface javaInterface = (Interface) javaClassifier;
			collectAllSuperInterfaces(javaInterface.getExtends(), superClassifierList);
		} else if (javaClassifier instanceof Annotation) {
			superClassifierList.add(getObjectModelElement());
		} else if (javaClassifier instanceof Enumeration) {
			collectAllSuperInterfaces(((Enumeration)javaClassifier).getImplements(), superClassifierList);
			//enumerations inherit from java.lang.Enum
			Class enumClass = (Class) EcoreUtil.resolve(
					JavaClasspath.INSTANCE.getClassifier("java.lang.Enum"), myResource);
			superClassifierList.add(enumClass);
			collectAllSuperClassifiers(enumClass, superClassifierList);
			
		} else if (javaClassifier instanceof TypeParameter) {
			TypeParameter typeParameter = (TypeParameter) javaClassifier;
			collectAllSuperClassifiers(typeParameter, superClassifierList);
		}
		else {
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
			Type superType = getReferencedType(subClass.getExtends(), null);
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

	private void collectAllSuperClassifiers( TypeParameter typeParameter, 
			EList<ConcreteClassifier> resultClassifierList)
			{
		
		for(TypeReference typeRef : typeParameter.getExtendTypes()) {
			Type type = (Classifier) getReferencedType(typeRef, null);
			if (type instanceof Interface) {
				Interface superInterface = (Interface) type;
				resultClassifierList.add(superInterface);
				collectAllSuperInterfaces(superInterface.getExtends(), resultClassifierList);
			}
			if (type instanceof Class) {
				Class superClass = (Class) type;
				resultClassifierList.add(superClass);
				collectAllSuperClassifiers(superClass, resultClassifierList);
			}
			if (type instanceof TypeParameter) {
				TypeParameter superTypeParameter = (TypeParameter) type;
				collectAllSuperClassifiers(superTypeParameter, resultClassifierList);
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
	protected void collectAllSuperInterfaces(EList<TypeReference> interfaceReferences,
		EList<ConcreteClassifier> resultInterfaceList) {
	
		for (TypeReference typeArg : interfaceReferences) {
			Type type = getReferencedType(typeArg, null);
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
