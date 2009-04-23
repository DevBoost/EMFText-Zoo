grammar Javabehavior;

options {
	superClass = AbstractEMFTextParser;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package org.emftext.language.java.javabehavior4uml.resource.javabehavior;
}

@lexer::members {
	public java.util.List<org.antlr.runtime.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime.RecognitionException>();
	public java.util.List<java.lang.Integer> lexerExceptionsPosition       = new java.util.ArrayList<java.lang.Integer>();
	
	public void reportError(org.antlr.runtime.RecognitionException e) {
		lexerExceptions.add(e);
		lexerExceptionsPosition.add(((org.antlr.runtime.ANTLRStringStream)input).index());
	}
}
@header{
	package org.emftext.language.java.javabehavior4uml.resource.javabehavior;
	
	import org.eclipse.emf.ecore.EObject;
	import org.eclipse.emf.ecore.InternalEObject;
	import org.eclipse.emf.common.util.URI;
	import org.emftext.runtime.resource.impl.AbstractEMFTextParser;
	import org.emftext.runtime.IOptions;
	import org.emftext.runtime.resource.impl.UnexpectedContentTypeException;
	import org.eclipse.emf.ecore.EClass;
}

@members{
	private org.emftext.runtime.resource.ITokenResolverFactory tokenResolverFactory = new JavabehaviorTokenResolverFactory();
	private int lastPosition;
	private org.emftext.runtime.resource.impl.TokenResolveResult tokenResolveResult = new org.emftext.runtime.resource.impl.TokenResolveResult();
	
	// This default constructor is only used to call createInstance() on it
	public JavabehaviorParser() {
		super();
	}
	
	protected EObject doParse() throws RecognitionException {
		lastPosition = 0;
		((JavabehaviorLexer)getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
		((JavabehaviorLexer)getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
		Object typeObject = null;
		Map<?,?> options = getOptions();
		if (options != null) {
			typeObject = options.get(IOptions.RESOURCE_CONTENT_TYPE);
		}
		if (typeObject == null) {
			return start();
		} else if (typeObject instanceof EClass) {
			EClass type = (EClass)typeObject;
			if (type.getInstanceClass() == org.emftext.language.java.javabehavior4uml.JavaMethodBehavior.class) {
				return javamethodbehavior();
			}
			if (type.getInstanceClass() == org.emftext.language.java.containers.EmptyModel.class) {
				return emptymodel();
			}
			if (type.getInstanceClass() == org.emftext.language.java.containers.Package.class) {
				return keywordpackage();
			}
			if (type.getInstanceClass() == org.emftext.language.java.containers.CompilationUnit.class) {
				return compilationunit();
			}
			if (type.getInstanceClass() == org.emftext.language.java.imports.ClassifierImport.class) {
				return classifierimport();
			}
			if (type.getInstanceClass() == org.emftext.language.java.imports.PackageImport.class) {
				return packageimport();
			}
			if (type.getInstanceClass() == org.emftext.language.java.imports.StaticMemberImport.class) {
				return staticmemberimport();
			}
			if (type.getInstanceClass() == org.emftext.language.java.imports.StaticClassifierImport.class) {
				return staticclassifierimport();
			}
			if (type.getInstanceClass() == org.emftext.language.java.classifiers.Class.class) {
				return keywordclass();
			}
			if (type.getInstanceClass() == org.emftext.language.java.classifiers.AnonymousClass.class) {
				return anonymousclass();
			}
			if (type.getInstanceClass() == org.emftext.language.java.classifiers.Interface.class) {
				return keywordinterface();
			}
			if (type.getInstanceClass() == org.emftext.language.java.classifiers.Enumeration.class) {
				return enumeration();
			}
			if (type.getInstanceClass() == org.emftext.language.java.classifiers.Annotation.class) {
				return annotation();
			}
			if (type.getInstanceClass() == org.emftext.language.java.annotations.AnnotationInstance.class) {
				return annotationinstance();
			}
			if (type.getInstanceClass() == org.emftext.language.java.annotations.SingleAnnotationParameter.class) {
				return singleannotationparameter();
			}
			if (type.getInstanceClass() == org.emftext.language.java.annotations.AnnotationParameterList.class) {
				return annotationparameterlist();
			}
			if (type.getInstanceClass() == org.emftext.language.java.annotations.AnnotationAttributeSetting.class) {
				return annotationattributesetting();
			}
			if (type.getInstanceClass() == org.emftext.language.java.generics.TypeParameter.class) {
				return typeparameter();
			}
			if (type.getInstanceClass() == org.emftext.language.java.members.EnumConstant.class) {
				return enumconstant();
			}
			if (type.getInstanceClass() == org.emftext.language.java.statements.Block.class) {
				return block();
			}
			if (type.getInstanceClass() == org.emftext.language.java.members.Constructor.class) {
				return constructor();
			}
			if (type.getInstanceClass() == org.emftext.language.java.members.InterfaceMethod.class) {
				return interfacemethod();
			}
			if (type.getInstanceClass() == org.emftext.language.java.members.ClassMethod.class) {
				return classmethod();
			}
			if (type.getInstanceClass() == org.emftext.language.java.annotations.AnnotationAttribute.class) {
				return annotationattribute();
			}
			if (type.getInstanceClass() == org.emftext.language.java.parameters.OrdinaryParameter.class) {
				return ordinaryparameter();
			}
			if (type.getInstanceClass() == org.emftext.language.java.parameters.VariableLengthParameter.class) {
				return variablelengthparameter();
			}
			if (type.getInstanceClass() == org.emftext.language.java.variables.LocalVariable.class) {
				return localvariable();
			}
			if (type.getInstanceClass() == org.emftext.language.java.statements.LocalVariableStatement.class) {
				return localvariablestatement();
			}
			if (type.getInstanceClass() == org.emftext.language.java.variables.AdditionalLocalVariable.class) {
				return additionallocalvariable();
			}
			if (type.getInstanceClass() == org.emftext.language.java.members.Field.class) {
				return field();
			}
			if (type.getInstanceClass() == org.emftext.language.java.members.AdditionalField.class) {
				return additionalfield();
			}
			if (type.getInstanceClass() == org.emftext.language.java.members.EmptyMember.class) {
				return emptymember();
			}
			if (type.getInstanceClass() == org.emftext.language.java.instantiations.NewConstructorCall.class) {
				return newconstructorcall();
			}
			if (type.getInstanceClass() == org.emftext.language.java.instantiations.ExplicitConstructorCall.class) {
				return explicitconstructorcall();
			}
			if (type.getInstanceClass() == org.emftext.language.java.arrays.ArrayInstantiationByValues.class) {
				return arrayinstantiationbyvalues();
			}
			if (type.getInstanceClass() == org.emftext.language.java.arrays.ArrayInstantiationBySize.class) {
				return arrayinstantiationbysize();
			}
			if (type.getInstanceClass() == org.emftext.language.java.arrays.ArrayInitializer.class) {
				return arrayinitializer();
			}
			if (type.getInstanceClass() == org.emftext.language.java.arrays.ArraySelector.class) {
				return arrayselector();
			}
			if (type.getInstanceClass() == org.emftext.language.java.types.NamespaceClassifierReference.class) {
				return namespaceclassifierreference();
			}
			if (type.getInstanceClass() == org.emftext.language.java.types.ClassifierReference.class) {
				return classifierreference();
			}
			if (type.getInstanceClass() == org.emftext.language.java.references.MethodCall.class) {
				return methodcall();
			}
			if (type.getInstanceClass() == org.emftext.language.java.references.IdentifierReference.class) {
				return identifierreference();
			}
			if (type.getInstanceClass() == org.emftext.language.java.references.ReflectiveClassReference.class) {
				return reflectiveclassreference();
			}
			if (type.getInstanceClass() == org.emftext.language.java.references.SelfReference.class) {
				return selfreference();
			}
			if (type.getInstanceClass() == org.emftext.language.java.references.PrimitiveTypeReference.class) {
				return primitivetypereference();
			}
			if (type.getInstanceClass() == org.emftext.language.java.literals.This.class) {
				return keywordthis();
			}
			if (type.getInstanceClass() == org.emftext.language.java.literals.Super.class) {
				return keywordsuper();
			}
			if (type.getInstanceClass() == org.emftext.language.java.references.StringReference.class) {
				return stringreference();
			}
			if (type.getInstanceClass() == org.emftext.language.java.generics.QualifiedTypeArgument.class) {
				return qualifiedtypeargument();
			}
			if (type.getInstanceClass() == org.emftext.language.java.generics.UnknownTypeArgument.class) {
				return unknowntypeargument();
			}
			if (type.getInstanceClass() == org.emftext.language.java.generics.ExtendsTypeArgument.class) {
				return extendstypeargument();
			}
			if (type.getInstanceClass() == org.emftext.language.java.generics.SuperTypeArgument.class) {
				return supertypeargument();
			}
			if (type.getInstanceClass() == org.emftext.language.java.statements.Assert.class) {
				return keywordassert();
			}
			if (type.getInstanceClass() == org.emftext.language.java.statements.Condition.class) {
				return condition();
			}
			if (type.getInstanceClass() == org.emftext.language.java.statements.ForLoop.class) {
				return forloop();
			}
			if (type.getInstanceClass() == org.emftext.language.java.statements.ForEachLoop.class) {
				return foreachloop();
			}
			if (type.getInstanceClass() == org.emftext.language.java.statements.WhileLoop.class) {
				return whileloop();
			}
			if (type.getInstanceClass() == org.emftext.language.java.statements.DoWhileLoop.class) {
				return dowhileloop();
			}
			if (type.getInstanceClass() == org.emftext.language.java.statements.EmptyStatement.class) {
				return emptystatement();
			}
			if (type.getInstanceClass() == org.emftext.language.java.statements.SynchronizedBlock.class) {
				return synchronizedblock();
			}
			if (type.getInstanceClass() == org.emftext.language.java.statements.TryBlock.class) {
				return tryblock();
			}
			if (type.getInstanceClass() == org.emftext.language.java.statements.CatchBlock.class) {
				return catchblock();
			}
			if (type.getInstanceClass() == org.emftext.language.java.statements.Switch.class) {
				return keywordswitch();
			}
			if (type.getInstanceClass() == org.emftext.language.java.statements.NormalSwitchCase.class) {
				return normalswitchcase();
			}
			if (type.getInstanceClass() == org.emftext.language.java.statements.DefaultSwitchCase.class) {
				return defaultswitchcase();
			}
			if (type.getInstanceClass() == org.emftext.language.java.statements.Return.class) {
				return keywordreturn();
			}
			if (type.getInstanceClass() == org.emftext.language.java.statements.Throw.class) {
				return keywordthrow();
			}
			if (type.getInstanceClass() == org.emftext.language.java.statements.Break.class) {
				return keywordbreak();
			}
			if (type.getInstanceClass() == org.emftext.language.java.statements.Continue.class) {
				return keywordcontinue();
			}
			if (type.getInstanceClass() == org.emftext.language.java.statements.JumpLabel.class) {
				return jumplabel();
			}
			if (type.getInstanceClass() == org.emftext.language.java.statements.ExpressionStatement.class) {
				return expressionstatement();
			}
			if (type.getInstanceClass() == org.emftext.language.java.expressions.ExpressionList.class) {
				return expressionlist();
			}
			if (type.getInstanceClass() == org.emftext.language.java.expressions.AssignmentExpression.class) {
				return assignmentexpression();
			}
			if (type.getInstanceClass() == org.emftext.language.java.expressions.ConditionalExpression.class) {
				return conditionalexpression();
			}
			if (type.getInstanceClass() == org.emftext.language.java.expressions.ConditionalOrExpression.class) {
				return conditionalorexpression();
			}
			if (type.getInstanceClass() == org.emftext.language.java.expressions.ConditionalAndExpression.class) {
				return conditionalandexpression();
			}
			if (type.getInstanceClass() == org.emftext.language.java.expressions.InclusiveOrExpression.class) {
				return inclusiveorexpression();
			}
			if (type.getInstanceClass() == org.emftext.language.java.expressions.ExclusiveOrExpression.class) {
				return exclusiveorexpression();
			}
			if (type.getInstanceClass() == org.emftext.language.java.expressions.AndExpression.class) {
				return andexpression();
			}
			if (type.getInstanceClass() == org.emftext.language.java.expressions.EqualityExpression.class) {
				return equalityexpression();
			}
			if (type.getInstanceClass() == org.emftext.language.java.expressions.InstanceOfExpression.class) {
				return instanceofexpression();
			}
			if (type.getInstanceClass() == org.emftext.language.java.expressions.RelationExpression.class) {
				return relationexpression();
			}
			if (type.getInstanceClass() == org.emftext.language.java.expressions.ShiftExpression.class) {
				return shiftexpression();
			}
			if (type.getInstanceClass() == org.emftext.language.java.expressions.AdditiveExpression.class) {
				return additiveexpression();
			}
			if (type.getInstanceClass() == org.emftext.language.java.expressions.MultiplicativeExpression.class) {
				return multiplicativeexpression();
			}
			if (type.getInstanceClass() == org.emftext.language.java.expressions.UnaryExpression.class) {
				return unaryexpression();
			}
			if (type.getInstanceClass() == org.emftext.language.java.expressions.SuffixUnaryModificationExpression.class) {
				return suffixunarymodificationexpression();
			}
			if (type.getInstanceClass() == org.emftext.language.java.expressions.PrefixUnaryModificationExpression.class) {
				return prefixunarymodificationexpression();
			}
			if (type.getInstanceClass() == org.emftext.language.java.expressions.CastExpression.class) {
				return castexpression();
			}
			if (type.getInstanceClass() == org.emftext.language.java.expressions.NestedExpression.class) {
				return nestedexpression();
			}
			if (type.getInstanceClass() == org.emftext.language.java.operators.Assignment.class) {
				return assignment();
			}
			if (type.getInstanceClass() == org.emftext.language.java.operators.AssignmentPlus.class) {
				return assignmentplus();
			}
			if (type.getInstanceClass() == org.emftext.language.java.operators.AssignmentMinus.class) {
				return assignmentminus();
			}
			if (type.getInstanceClass() == org.emftext.language.java.operators.AssignmentMultiplication.class) {
				return assignmentmultiplication();
			}
			if (type.getInstanceClass() == org.emftext.language.java.operators.AssignmentDivision.class) {
				return assignmentdivision();
			}
			if (type.getInstanceClass() == org.emftext.language.java.operators.AssignmentAnd.class) {
				return assignmentand();
			}
			if (type.getInstanceClass() == org.emftext.language.java.operators.AssignmentOr.class) {
				return assignmentor();
			}
			if (type.getInstanceClass() == org.emftext.language.java.operators.AssignmentExclusiveOr.class) {
				return assignmentexclusiveor();
			}
			if (type.getInstanceClass() == org.emftext.language.java.operators.AssignmentModulo.class) {
				return assignmentmodulo();
			}
			if (type.getInstanceClass() == org.emftext.language.java.operators.AssignmentLeftShift.class) {
				return assignmentleftshift();
			}
			if (type.getInstanceClass() == org.emftext.language.java.operators.AssignmentRightShift.class) {
				return assignmentrightshift();
			}
			if (type.getInstanceClass() == org.emftext.language.java.operators.AssignmentUnsignedRightShift.class) {
				return assignmentunsignedrightshift();
			}
			if (type.getInstanceClass() == org.emftext.language.java.operators.Addition.class) {
				return addition();
			}
			if (type.getInstanceClass() == org.emftext.language.java.operators.Subtraction.class) {
				return subtraction();
			}
			if (type.getInstanceClass() == org.emftext.language.java.operators.Multiplication.class) {
				return multiplication();
			}
			if (type.getInstanceClass() == org.emftext.language.java.operators.Division.class) {
				return division();
			}
			if (type.getInstanceClass() == org.emftext.language.java.operators.Remainder.class) {
				return remainder();
			}
			if (type.getInstanceClass() == org.emftext.language.java.operators.LessThan.class) {
				return lessthan();
			}
			if (type.getInstanceClass() == org.emftext.language.java.operators.LessThanOrEqual.class) {
				return lessthanorequal();
			}
			if (type.getInstanceClass() == org.emftext.language.java.operators.GreaterThan.class) {
				return greaterthan();
			}
			if (type.getInstanceClass() == org.emftext.language.java.operators.GreaterThanOrEqual.class) {
				return greaterthanorequal();
			}
			if (type.getInstanceClass() == org.emftext.language.java.operators.LeftShift.class) {
				return leftshift();
			}
			if (type.getInstanceClass() == org.emftext.language.java.operators.RightShift.class) {
				return rightshift();
			}
			if (type.getInstanceClass() == org.emftext.language.java.operators.UnsignedRightShift.class) {
				return unsignedrightshift();
			}
			if (type.getInstanceClass() == org.emftext.language.java.operators.Equal.class) {
				return equal();
			}
			if (type.getInstanceClass() == org.emftext.language.java.operators.NotEqual.class) {
				return notequal();
			}
			if (type.getInstanceClass() == org.emftext.language.java.operators.PlusPlus.class) {
				return plusplus();
			}
			if (type.getInstanceClass() == org.emftext.language.java.operators.MinusMinus.class) {
				return minusminus();
			}
			if (type.getInstanceClass() == org.emftext.language.java.operators.Complement.class) {
				return complement();
			}
			if (type.getInstanceClass() == org.emftext.language.java.operators.Negate.class) {
				return negate();
			}
			if (type.getInstanceClass() == org.emftext.language.java.arrays.ArrayDimension.class) {
				return arraydimension();
			}
			if (type.getInstanceClass() == org.emftext.language.java.literals.NullLiteral.class) {
				return nullliteral();
			}
			if (type.getInstanceClass() == org.emftext.language.java.modifiers.Public.class) {
				return keywordpublic();
			}
			if (type.getInstanceClass() == org.emftext.language.java.modifiers.Abstract.class) {
				return keywordabstract();
			}
			if (type.getInstanceClass() == org.emftext.language.java.modifiers.Protected.class) {
				return keywordprotected();
			}
			if (type.getInstanceClass() == org.emftext.language.java.modifiers.Private.class) {
				return keywordprivate();
			}
			if (type.getInstanceClass() == org.emftext.language.java.modifiers.Final.class) {
				return keywordfinal();
			}
			if (type.getInstanceClass() == org.emftext.language.java.modifiers.Static.class) {
				return keywordstatic();
			}
			if (type.getInstanceClass() == org.emftext.language.java.modifiers.Native.class) {
				return keywordnative();
			}
			if (type.getInstanceClass() == org.emftext.language.java.modifiers.Synchronized.class) {
				return keywordsynchronized();
			}
			if (type.getInstanceClass() == org.emftext.language.java.modifiers.Transient.class) {
				return keywordtransient();
			}
			if (type.getInstanceClass() == org.emftext.language.java.modifiers.Volatile.class) {
				return keywordvolatile();
			}
			if (type.getInstanceClass() == org.emftext.language.java.modifiers.Strictfp.class) {
				return keywordstrictfp();
			}
			if (type.getInstanceClass() == org.emftext.language.java.types.Void.class) {
				return keywordvoid();
			}
			if (type.getInstanceClass() == org.emftext.language.java.types.Boolean.class) {
				return keywordboolean();
			}
			if (type.getInstanceClass() == org.emftext.language.java.types.Char.class) {
				return keywordchar();
			}
			if (type.getInstanceClass() == org.emftext.language.java.types.Byte.class) {
				return keywordbyte();
			}
			if (type.getInstanceClass() == org.emftext.language.java.types.Short.class) {
				return keywordshort();
			}
			if (type.getInstanceClass() == org.emftext.language.java.types.Int.class) {
				return keywordint();
			}
			if (type.getInstanceClass() == org.emftext.language.java.types.Long.class) {
				return keywordlong();
			}
			if (type.getInstanceClass() == org.emftext.language.java.types.Float.class) {
				return keywordfloat();
			}
			if (type.getInstanceClass() == org.emftext.language.java.types.Double.class) {
				return keyworddouble();
			}
			if (type.getInstanceClass() == org.emftext.language.java.literals.DecimalLongLiteral.class) {
				return decimallongliteral();
			}
			if (type.getInstanceClass() == org.emftext.language.java.literals.DecimalFloatLiteral.class) {
				return decimalfloatliteral();
			}
			if (type.getInstanceClass() == org.emftext.language.java.literals.DecimalIntegerLiteral.class) {
				return decimalintegerliteral();
			}
			if (type.getInstanceClass() == org.emftext.language.java.literals.DecimalDoubleLiteral.class) {
				return decimaldoubleliteral();
			}
			if (type.getInstanceClass() == org.emftext.language.java.literals.HexLongLiteral.class) {
				return hexlongliteral();
			}
			if (type.getInstanceClass() == org.emftext.language.java.literals.HexFloatLiteral.class) {
				return hexfloatliteral();
			}
			if (type.getInstanceClass() == org.emftext.language.java.literals.HexDoubleLiteral.class) {
				return hexdoubleliteral();
			}
			if (type.getInstanceClass() == org.emftext.language.java.literals.HexIntegerLiteral.class) {
				return hexintegerliteral();
			}
			if (type.getInstanceClass() == org.emftext.language.java.literals.OctalLongLiteral.class) {
				return octallongliteral();
			}
			if (type.getInstanceClass() == org.emftext.language.java.literals.OctalIntegerLiteral.class) {
				return octalintegerliteral();
			}
			if (type.getInstanceClass() == org.emftext.language.java.literals.CharacterLiteral.class) {
				return characterliteral();
			}
			if (type.getInstanceClass() == org.emftext.language.java.literals.BooleanLiteral.class) {
				return booleanliteral();
			}
		}
		throw new org.emftext.runtime.resource.impl.UnexpectedContentTypeException(typeObject);
	}
	
	@SuppressWarnings("unchecked")
	private boolean addObjectToList(org.eclipse.emf.ecore.EObject element, int featureID, java.lang.Object proxy) {
		return ((java.util.List<java.lang.Object>) element.eGet(element.eClass().getEStructuralFeature(featureID))).add(proxy);
	}
	
	private org.emftext.runtime.resource.impl.TokenResolveResult getFreshTokenResolveResult() {
		tokenResolveResult.clear();
		return tokenResolveResult;
	}
	
	protected void collectHiddenTokens(org.eclipse.emf.ecore.EObject element) {
	}
	public org.emftext.runtime.resource.ITextParser createInstance(java.io.InputStream actualInputStream, java.lang.String encoding) {
		try {
			if (encoding == null) {
				return new JavabehaviorParser(new org.antlr.runtime.CommonTokenStream(new JavabehaviorLexer(new org.antlr.runtime.ANTLRInputStream(actualInputStream))));
			} else {
				return new JavabehaviorParser(new org.antlr.runtime.CommonTokenStream(new JavabehaviorLexer(new org.antlr.runtime.ANTLRInputStream(actualInputStream, encoding))));
			}
		} catch (java.io.IOException e) {
			org.emftext.runtime.EMFTextRuntimePlugin.logError("Error while creating parser.", e);
			return null;
		}
	}
}

start returns [ EObject element = null]
:
	(
		c0 = javamethodbehavior{ element = c0; }
	)
	EOF	
;

javamethodbehavior returns [org.emftext.language.java.javabehavior4uml.JavaMethodBehavior element = null]
@init{
}
:
	(
		a0 = IDENTIFIER		
		{
			if (element == null) {
				element = org.emftext.language.java.javabehavior4uml.Javabehavior4umlFactory.eINSTANCE.createJavaMethodBehavior();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.javabehavior4uml.Javabehavior4umlPackage.JAVA_METHOD_BEHAVIOR__SPECIFICATION), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
			}
			String resolved = (String) resolvedObject;
			org.eclipse.uml2.uml.Operation proxy = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createOperation();
			collectHiddenTokens(element);
			getResource().registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.eclipse.uml2.uml.Behavior, org.eclipse.uml2.uml.BehavioralFeature>(((org.emftext.language.java.javabehavior4uml.resource.javabehavior.JavabehaviorReferenceResolverSwitch) resource.getReferenceResolverSwitch()).getBehaviorSpecificationReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.java.javabehavior4uml.Javabehavior4umlPackage.JAVA_METHOD_BEHAVIOR__SPECIFICATION), resolved, proxy);
			if (proxy != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.javabehavior4uml.Javabehavior4umlPackage.JAVA_METHOD_BEHAVIOR__SPECIFICATION), proxy);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a0, element);
			copyLocalizationInfos((CommonToken) a0, proxy);
		}
	)
	
	a1 = ';' {
		if (element == null) {
			element = org.emftext.language.java.javabehavior4uml.Javabehavior4umlFactory.eINSTANCE.createJavaMethodBehavior();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	
	(
		(
			(
				a2_0 = keywordimport				{
					if (element == null) {
						element = org.emftext.language.java.javabehavior4uml.Javabehavior4umlFactory.eINSTANCE.createJavaMethodBehavior();
					}
					if (a2_0 != null) {
						addObjectToList(element, org.emftext.language.java.javabehavior4uml.Javabehavior4umlPackage.JAVA_METHOD_BEHAVIOR__IMPORTS, a2_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a2_0, element); 				}
			)
			
		)
		
	)*	
	(
		a3_0 = classmethod		{
			if (element == null) {
				element = org.emftext.language.java.javabehavior4uml.Javabehavior4umlFactory.eINSTANCE.createJavaMethodBehavior();
			}
			if (a3_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.javabehavior4uml.Javabehavior4umlPackage.JAVA_METHOD_BEHAVIOR__JAVA_METHOD), a3_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a3_0, element); 		}
	)
	
;

emptymodel returns [org.emftext.language.java.containers.EmptyModel element = null]
@init{
}
:
	(
		(
			(
				a0_0 = keywordimport				{
					if (element == null) {
						element = org.emftext.language.java.containers.ContainersFactory.eINSTANCE.createEmptyModel();
					}
					if (a0_0 != null) {
						addObjectToList(element, org.emftext.language.java.containers.ContainersPackage.EMPTY_MODEL__IMPORTS, a0_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a0_0, element); 				}
			)
			
			a1 = ';' {
				if (element == null) {
					element = org.emftext.language.java.containers.ContainersFactory.eINSTANCE.createEmptyModel();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a1, element);
			}
			
		)
		
	)*	
	(
		(
			a2 = ';' {
				if (element == null) {
					element = org.emftext.language.java.containers.ContainersFactory.eINSTANCE.createEmptyModel();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a2, element);
			}
			
		)
		
	)*	
;

keywordpackage returns [org.emftext.language.java.containers.Package element = null]
@init{
}
:
	(
		(
			a0_0 = annotationinstance			{
				if (element == null) {
					element = org.emftext.language.java.containers.ContainersFactory.eINSTANCE.createPackage();
				}
				if (a0_0 != null) {
					addObjectToList(element, org.emftext.language.java.containers.ContainersPackage.PACKAGE__ANNOTATIONS, a0_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a0_0, element); 			}
		)
		
	)*	
	a1 = 'package' {
		if (element == null) {
			element = org.emftext.language.java.containers.ContainersFactory.eINSTANCE.createPackage();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	
	(
		(
			(
				a2 = IDENTIFIER				
				{
					if (element == null) {
						element = org.emftext.language.java.containers.ContainersFactory.eINSTANCE.createPackage();
					}
					org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
					tokenResolver.setOptions(getOptions());
					org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.containers.ContainersPackage.PACKAGE__NAMESPACES), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						getResource().addError(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String)resolvedObject;
					if (resolved != null) {
						addObjectToList(element, org.emftext.language.java.containers.ContainersPackage.PACKAGE__NAMESPACES, resolved);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((CommonToken) a2, element);
				}
			)
			
			a3 = '.' {
				if (element == null) {
					element = org.emftext.language.java.containers.ContainersFactory.eINSTANCE.createPackage();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a3, element);
			}
			
		)
		
	)*	
	(
		a4 = IDENTIFIER		
		{
			if (element == null) {
				element = org.emftext.language.java.containers.ContainersFactory.eINSTANCE.createPackage();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.containers.ContainersPackage.PACKAGE__NAME), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a4).getLine(), ((CommonToken) a4).getCharPositionInLine(), ((CommonToken) a4).getStartIndex(), ((CommonToken) a4).getStopIndex());
			}
			java.lang.String resolved = (java.lang.String)resolvedObject;
			if (resolved != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.containers.ContainersPackage.PACKAGE__NAME), resolved);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a4, element);
		}
	)
	
	a5 = ';' {
		if (element == null) {
			element = org.emftext.language.java.containers.ContainersFactory.eINSTANCE.createPackage();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a5, element);
	}
	
	(
		(
			a6 = ';' {
				if (element == null) {
					element = org.emftext.language.java.containers.ContainersFactory.eINSTANCE.createPackage();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a6, element);
			}
			
		)
		
	)?	
	(
		(
			(
				a7_0 = keywordimport				{
					if (element == null) {
						element = org.emftext.language.java.containers.ContainersFactory.eINSTANCE.createPackage();
					}
					if (a7_0 != null) {
						addObjectToList(element, org.emftext.language.java.containers.ContainersPackage.PACKAGE__IMPORTS, a7_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a7_0, element); 				}
			)
			
		)
		
	)*	
	(
		(
			a8 = ';' {
				if (element == null) {
					element = org.emftext.language.java.containers.ContainersFactory.eINSTANCE.createPackage();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a8, element);
			}
			
		)
		
	)*	
;

compilationunit returns [org.emftext.language.java.containers.CompilationUnit element = null]
@init{
}
:
	(
		(
			a0 = 'package' {
				if (element == null) {
					element = org.emftext.language.java.containers.ContainersFactory.eINSTANCE.createCompilationUnit();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a0, element);
			}
			
			(
				a1 = IDENTIFIER				
				{
					if (element == null) {
						element = org.emftext.language.java.containers.ContainersFactory.eINSTANCE.createCompilationUnit();
					}
					org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
					tokenResolver.setOptions(getOptions());
					org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.containers.ContainersPackage.COMPILATION_UNIT__NAMESPACES), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						getResource().addError(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String)resolvedObject;
					if (resolved != null) {
						addObjectToList(element, org.emftext.language.java.containers.ContainersPackage.COMPILATION_UNIT__NAMESPACES, resolved);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((CommonToken) a1, element);
				}
			)
			
			(
				(
					a2 = '.' {
						if (element == null) {
							element = org.emftext.language.java.containers.ContainersFactory.eINSTANCE.createCompilationUnit();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken)a2, element);
					}
					
					(
						a3 = IDENTIFIER						
						{
							if (element == null) {
								element = org.emftext.language.java.containers.ContainersFactory.eINSTANCE.createCompilationUnit();
							}
							org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
							tokenResolver.setOptions(getOptions());
							org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
							tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.containers.ContainersPackage.COMPILATION_UNIT__NAMESPACES), result);
							Object resolvedObject = result.getResolvedToken();
							if (resolvedObject == null) {
								getResource().addError(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
							}
							java.lang.String resolved = (java.lang.String)resolvedObject;
							if (resolved != null) {
								addObjectToList(element, org.emftext.language.java.containers.ContainersPackage.COMPILATION_UNIT__NAMESPACES, resolved);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos((CommonToken) a3, element);
						}
					)
					
				)
				
			)*			
			a4 = ';' {
				if (element == null) {
					element = org.emftext.language.java.containers.ContainersFactory.eINSTANCE.createCompilationUnit();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a4, element);
			}
			
		)
		
	)?	
	(
		(
			(
				a5_0 = keywordimport				{
					if (element == null) {
						element = org.emftext.language.java.containers.ContainersFactory.eINSTANCE.createCompilationUnit();
					}
					if (a5_0 != null) {
						addObjectToList(element, org.emftext.language.java.containers.ContainersPackage.COMPILATION_UNIT__IMPORTS, a5_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a5_0, element); 				}
			)
			
		)
		
	)*	
	(
		(
			a6 = ';' {
				if (element == null) {
					element = org.emftext.language.java.containers.ContainersFactory.eINSTANCE.createCompilationUnit();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a6, element);
			}
			
		)
		
	)*	
	(
		(
			(
				a7_0 = concreteclassifier				{
					if (element == null) {
						element = org.emftext.language.java.containers.ContainersFactory.eINSTANCE.createCompilationUnit();
					}
					if (a7_0 != null) {
						addObjectToList(element, org.emftext.language.java.containers.ContainersPackage.COMPILATION_UNIT__CLASSIFIERS, a7_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a7_0, element); 				}
			)
			
			(
				(
					a8 = ';' {
						if (element == null) {
							element = org.emftext.language.java.containers.ContainersFactory.eINSTANCE.createCompilationUnit();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken)a8, element);
					}
					
				)
				
			)*			
		)
		
	)+	
	(
		(
			a9 = '\u001a' {
				if (element == null) {
					element = org.emftext.language.java.containers.ContainersFactory.eINSTANCE.createCompilationUnit();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a9, element);
			}
			
		)
		
	)?	
;

classifierimport returns [org.emftext.language.java.imports.ClassifierImport element = null]
@init{
}
:
	a0 = 'import' {
		if (element == null) {
			element = org.emftext.language.java.imports.ImportsFactory.eINSTANCE.createClassifierImport();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	(
		(
			(
				a1 = IDENTIFIER				
				{
					if (element == null) {
						element = org.emftext.language.java.imports.ImportsFactory.eINSTANCE.createClassifierImport();
					}
					org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
					tokenResolver.setOptions(getOptions());
					org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.imports.ImportsPackage.CLASSIFIER_IMPORT__NAMESPACES), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						getResource().addError(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String)resolvedObject;
					if (resolved != null) {
						addObjectToList(element, org.emftext.language.java.imports.ImportsPackage.CLASSIFIER_IMPORT__NAMESPACES, resolved);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((CommonToken) a1, element);
				}
			)
			
			a2 = '.' {
				if (element == null) {
					element = org.emftext.language.java.imports.ImportsFactory.eINSTANCE.createClassifierImport();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a2, element);
			}
			
		)
		
	)+	
	(
		a3 = IDENTIFIER		
		{
			if (element == null) {
				element = org.emftext.language.java.imports.ImportsFactory.eINSTANCE.createClassifierImport();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.imports.ImportsPackage.CLASSIFIER_IMPORT__CLASSIFIER), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
			}
			String resolved = (String) resolvedObject;
			org.emftext.language.java.classifiers.Class proxy = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createClass();
			collectHiddenTokens(element);
			getResource().registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.language.java.imports.ClassifierImport, org.emftext.language.java.classifiers.ConcreteClassifier>(((org.emftext.language.java.javabehavior4uml.resource.javabehavior.JavabehaviorReferenceResolverSwitch) resource.getReferenceResolverSwitch()).getClassifierImportClassifierReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.java.imports.ImportsPackage.CLASSIFIER_IMPORT__CLASSIFIER), resolved, proxy);
			if (proxy != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.imports.ImportsPackage.CLASSIFIER_IMPORT__CLASSIFIER), proxy);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a3, element);
			copyLocalizationInfos((CommonToken) a3, proxy);
		}
	)
	
	a4 = ';' {
		if (element == null) {
			element = org.emftext.language.java.imports.ImportsFactory.eINSTANCE.createClassifierImport();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a4, element);
	}
	
;

packageimport returns [org.emftext.language.java.imports.PackageImport element = null]
@init{
}
:
	a0 = 'import' {
		if (element == null) {
			element = org.emftext.language.java.imports.ImportsFactory.eINSTANCE.createPackageImport();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	(
		(
			(
				a1 = IDENTIFIER				
				{
					if (element == null) {
						element = org.emftext.language.java.imports.ImportsFactory.eINSTANCE.createPackageImport();
					}
					org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
					tokenResolver.setOptions(getOptions());
					org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.imports.ImportsPackage.PACKAGE_IMPORT__NAMESPACES), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						getResource().addError(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String)resolvedObject;
					if (resolved != null) {
						addObjectToList(element, org.emftext.language.java.imports.ImportsPackage.PACKAGE_IMPORT__NAMESPACES, resolved);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((CommonToken) a1, element);
				}
			)
			
			a2 = '.' {
				if (element == null) {
					element = org.emftext.language.java.imports.ImportsFactory.eINSTANCE.createPackageImport();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a2, element);
			}
			
		)
		
	)+	
	a3 = '*' {
		if (element == null) {
			element = org.emftext.language.java.imports.ImportsFactory.eINSTANCE.createPackageImport();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a3, element);
	}
	
	a4 = ';' {
		if (element == null) {
			element = org.emftext.language.java.imports.ImportsFactory.eINSTANCE.createPackageImport();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a4, element);
	}
	
;

staticmemberimport returns [org.emftext.language.java.imports.StaticMemberImport element = null]
@init{
}
:
	a0 = 'import' {
		if (element == null) {
			element = org.emftext.language.java.imports.ImportsFactory.eINSTANCE.createStaticMemberImport();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	(
		a1_0 = keywordstatic		{
			if (element == null) {
				element = org.emftext.language.java.imports.ImportsFactory.eINSTANCE.createStaticMemberImport();
			}
			if (a1_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.imports.ImportsPackage.STATIC_MEMBER_IMPORT__STATIC), a1_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a1_0, element); 		}
	)
	
	(
		(
			(
				a2 = IDENTIFIER				
				{
					if (element == null) {
						element = org.emftext.language.java.imports.ImportsFactory.eINSTANCE.createStaticMemberImport();
					}
					org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
					tokenResolver.setOptions(getOptions());
					org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.imports.ImportsPackage.STATIC_MEMBER_IMPORT__NAMESPACES), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						getResource().addError(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String)resolvedObject;
					if (resolved != null) {
						addObjectToList(element, org.emftext.language.java.imports.ImportsPackage.STATIC_MEMBER_IMPORT__NAMESPACES, resolved);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((CommonToken) a2, element);
				}
			)
			
			a3 = '.' {
				if (element == null) {
					element = org.emftext.language.java.imports.ImportsFactory.eINSTANCE.createStaticMemberImport();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a3, element);
			}
			
		)
		
	)+	
	(
		a4 = IDENTIFIER		
		{
			if (element == null) {
				element = org.emftext.language.java.imports.ImportsFactory.eINSTANCE.createStaticMemberImport();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.imports.ImportsPackage.STATIC_MEMBER_IMPORT__STATIC_MEMBERS), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a4).getLine(), ((CommonToken) a4).getCharPositionInLine(), ((CommonToken) a4).getStartIndex(), ((CommonToken) a4).getStopIndex());
			}
			String resolved = (String) resolvedObject;
			org.emftext.language.java.annotations.AnnotationAttribute proxy = org.emftext.language.java.annotations.AnnotationsFactory.eINSTANCE.createAnnotationAttribute();
			collectHiddenTokens(element);
			getResource().registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.language.java.imports.StaticMemberImport, org.emftext.language.java.references.ReferenceableElement>(((org.emftext.language.java.javabehavior4uml.resource.javabehavior.JavabehaviorReferenceResolverSwitch) resource.getReferenceResolverSwitch()).getStaticMemberImportStaticMembersReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.java.imports.ImportsPackage.STATIC_MEMBER_IMPORT__STATIC_MEMBERS), resolved, proxy);
			if (proxy != null) {
				addObjectToList(element, org.emftext.language.java.imports.ImportsPackage.STATIC_MEMBER_IMPORT__STATIC_MEMBERS, proxy);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a4, element);
			copyLocalizationInfos((CommonToken) a4, proxy);
		}
	)
	
	a5 = ';' {
		if (element == null) {
			element = org.emftext.language.java.imports.ImportsFactory.eINSTANCE.createStaticMemberImport();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a5, element);
	}
	
;

staticclassifierimport returns [org.emftext.language.java.imports.StaticClassifierImport element = null]
@init{
}
:
	a0 = 'import' {
		if (element == null) {
			element = org.emftext.language.java.imports.ImportsFactory.eINSTANCE.createStaticClassifierImport();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	(
		a1_0 = keywordstatic		{
			if (element == null) {
				element = org.emftext.language.java.imports.ImportsFactory.eINSTANCE.createStaticClassifierImport();
			}
			if (a1_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.imports.ImportsPackage.STATIC_CLASSIFIER_IMPORT__STATIC), a1_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a1_0, element); 		}
	)
	
	(
		(
			(
				a2 = IDENTIFIER				
				{
					if (element == null) {
						element = org.emftext.language.java.imports.ImportsFactory.eINSTANCE.createStaticClassifierImport();
					}
					org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
					tokenResolver.setOptions(getOptions());
					org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.imports.ImportsPackage.STATIC_CLASSIFIER_IMPORT__NAMESPACES), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						getResource().addError(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String)resolvedObject;
					if (resolved != null) {
						addObjectToList(element, org.emftext.language.java.imports.ImportsPackage.STATIC_CLASSIFIER_IMPORT__NAMESPACES, resolved);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((CommonToken) a2, element);
				}
			)
			
			a3 = '.' {
				if (element == null) {
					element = org.emftext.language.java.imports.ImportsFactory.eINSTANCE.createStaticClassifierImport();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a3, element);
			}
			
		)
		
	)*	
	(
		a4 = IDENTIFIER		
		{
			if (element == null) {
				element = org.emftext.language.java.imports.ImportsFactory.eINSTANCE.createStaticClassifierImport();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.imports.ImportsPackage.STATIC_CLASSIFIER_IMPORT__STATIC_MEMBERS), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a4).getLine(), ((CommonToken) a4).getCharPositionInLine(), ((CommonToken) a4).getStartIndex(), ((CommonToken) a4).getStopIndex());
			}
			String resolved = (String) resolvedObject;
			org.emftext.language.java.annotations.AnnotationAttribute proxy = org.emftext.language.java.annotations.AnnotationsFactory.eINSTANCE.createAnnotationAttribute();
			collectHiddenTokens(element);
			getResource().registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.language.java.imports.StaticClassifierImport, org.emftext.language.java.references.ReferenceableElement>(((org.emftext.language.java.javabehavior4uml.resource.javabehavior.JavabehaviorReferenceResolverSwitch) resource.getReferenceResolverSwitch()).getStaticClassifierImportStaticMembersReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.java.imports.ImportsPackage.STATIC_CLASSIFIER_IMPORT__STATIC_MEMBERS), resolved, proxy);
			if (proxy != null) {
				addObjectToList(element, org.emftext.language.java.imports.ImportsPackage.STATIC_CLASSIFIER_IMPORT__STATIC_MEMBERS, proxy);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a4, element);
			copyLocalizationInfos((CommonToken) a4, proxy);
		}
	)
	
	a5 = '.' {
		if (element == null) {
			element = org.emftext.language.java.imports.ImportsFactory.eINSTANCE.createStaticClassifierImport();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a5, element);
	}
	
	a6 = '*' {
		if (element == null) {
			element = org.emftext.language.java.imports.ImportsFactory.eINSTANCE.createStaticClassifierImport();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a6, element);
	}
	
	a7 = ';' {
		if (element == null) {
			element = org.emftext.language.java.imports.ImportsFactory.eINSTANCE.createStaticClassifierImport();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a7, element);
	}
	
;

keywordclass returns [org.emftext.language.java.classifiers.Class element = null]
@init{
}
:
	(
		(
			a0_0 = annotationinstanceormodifier			{
				if (element == null) {
					element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createClass();
				}
				if (a0_0 != null) {
					addObjectToList(element, org.emftext.language.java.classifiers.ClassifiersPackage.CLASS__ANNOTATIONS_AND_MODIFIERS, a0_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a0_0, element); 			}
		)
		
	)*	
	a1 = 'class' {
		if (element == null) {
			element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createClass();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	
	(
		a2 = IDENTIFIER		
		{
			if (element == null) {
				element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createClass();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.classifiers.ClassifiersPackage.CLASS__NAME), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
			}
			java.lang.String resolved = (java.lang.String)resolvedObject;
			if (resolved != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.classifiers.ClassifiersPackage.CLASS__NAME), resolved);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a2, element);
		}
	)
	
	(
		(
			a3 = '<' {
				if (element == null) {
					element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createClass();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a3, element);
			}
			
			(
				a4_0 = typeparameter				{
					if (element == null) {
						element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createClass();
					}
					if (a4_0 != null) {
						addObjectToList(element, org.emftext.language.java.classifiers.ClassifiersPackage.CLASS__TYPE_PARAMETERS, a4_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a4_0, element); 				}
			)
			
			(
				(
					a5 = ',' {
						if (element == null) {
							element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createClass();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken)a5, element);
					}
					
					(
						a6_0 = typeparameter						{
							if (element == null) {
								element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createClass();
							}
							if (a6_0 != null) {
								addObjectToList(element, org.emftext.language.java.classifiers.ClassifiersPackage.CLASS__TYPE_PARAMETERS, a6_0);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos(a6_0, element); 						}
					)
					
				)
				
			)*			
			a7 = '>' {
				if (element == null) {
					element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createClass();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a7, element);
			}
			
		)
		
	)?	
	(
		(
			a8 = 'extends' {
				if (element == null) {
					element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createClass();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a8, element);
			}
			
			(
				a9_0 = typereference				{
					if (element == null) {
						element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createClass();
					}
					if (a9_0 != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.classifiers.ClassifiersPackage.CLASS__EXTENDS), a9_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a9_0, element); 				}
			)
			
		)
		
	)?	
	(
		(
			a10 = 'implements' {
				if (element == null) {
					element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createClass();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a10, element);
			}
			
			(
				(
					a11_0 = typereference					{
						if (element == null) {
							element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createClass();
						}
						if (a11_0 != null) {
							addObjectToList(element, org.emftext.language.java.classifiers.ClassifiersPackage.CLASS__IMPLEMENTS, a11_0);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos(a11_0, element); 					}
				)
				
				(
					(
						a12 = ',' {
							if (element == null) {
								element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createClass();
							}
							collectHiddenTokens(element);
							copyLocalizationInfos((CommonToken)a12, element);
						}
						
						(
							a13_0 = typereference							{
								if (element == null) {
									element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createClass();
								}
								if (a13_0 != null) {
									addObjectToList(element, org.emftext.language.java.classifiers.ClassifiersPackage.CLASS__IMPLEMENTS, a13_0);
								}
								collectHiddenTokens(element);
								copyLocalizationInfos(a13_0, element); 							}
						)
						
					)
					
				)*				
			)
			
		)
		
	)?	
	a14 = '{' {
		if (element == null) {
			element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createClass();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a14, element);
	}
	
	(
		(
			(
				a15_0 = member				{
					if (element == null) {
						element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createClass();
					}
					if (a15_0 != null) {
						addObjectToList(element, org.emftext.language.java.classifiers.ClassifiersPackage.CLASS__MEMBERS, a15_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a15_0, element); 				}
			)
			
		)
		
	)*	
	a16 = '}' {
		if (element == null) {
			element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createClass();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a16, element);
	}
	
;

anonymousclass returns [org.emftext.language.java.classifiers.AnonymousClass element = null]
@init{
}
:
	a0 = '{' {
		if (element == null) {
			element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createAnonymousClass();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	(
		(
			(
				a1_0 = member				{
					if (element == null) {
						element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createAnonymousClass();
					}
					if (a1_0 != null) {
						addObjectToList(element, org.emftext.language.java.classifiers.ClassifiersPackage.ANONYMOUS_CLASS__MEMBERS, a1_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a1_0, element); 				}
			)
			
		)
		
	)*	
	a2 = '}' {
		if (element == null) {
			element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createAnonymousClass();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	
;

keywordinterface returns [org.emftext.language.java.classifiers.Interface element = null]
@init{
}
:
	(
		(
			a0_0 = annotationinstanceormodifier			{
				if (element == null) {
					element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createInterface();
				}
				if (a0_0 != null) {
					addObjectToList(element, org.emftext.language.java.classifiers.ClassifiersPackage.INTERFACE__ANNOTATIONS_AND_MODIFIERS, a0_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a0_0, element); 			}
		)
		
	)*	
	a1 = 'interface' {
		if (element == null) {
			element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createInterface();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	
	(
		a2 = IDENTIFIER		
		{
			if (element == null) {
				element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createInterface();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.classifiers.ClassifiersPackage.INTERFACE__NAME), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
			}
			java.lang.String resolved = (java.lang.String)resolvedObject;
			if (resolved != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.classifiers.ClassifiersPackage.INTERFACE__NAME), resolved);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a2, element);
		}
	)
	
	(
		(
			a3 = '<' {
				if (element == null) {
					element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createInterface();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a3, element);
			}
			
			(
				a4_0 = typeparameter				{
					if (element == null) {
						element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createInterface();
					}
					if (a4_0 != null) {
						addObjectToList(element, org.emftext.language.java.classifiers.ClassifiersPackage.INTERFACE__TYPE_PARAMETERS, a4_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a4_0, element); 				}
			)
			
			(
				(
					a5 = ',' {
						if (element == null) {
							element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createInterface();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken)a5, element);
					}
					
					(
						a6_0 = typeparameter						{
							if (element == null) {
								element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createInterface();
							}
							if (a6_0 != null) {
								addObjectToList(element, org.emftext.language.java.classifiers.ClassifiersPackage.INTERFACE__TYPE_PARAMETERS, a6_0);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos(a6_0, element); 						}
					)
					
				)
				
			)*			
			a7 = '>' {
				if (element == null) {
					element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createInterface();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a7, element);
			}
			
		)
		
	)?	
	(
		(
			a8 = 'extends' {
				if (element == null) {
					element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createInterface();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a8, element);
			}
			
			(
				(
					a9_0 = typereference					{
						if (element == null) {
							element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createInterface();
						}
						if (a9_0 != null) {
							addObjectToList(element, org.emftext.language.java.classifiers.ClassifiersPackage.INTERFACE__EXTENDS, a9_0);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos(a9_0, element); 					}
				)
				
				(
					(
						a10 = ',' {
							if (element == null) {
								element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createInterface();
							}
							collectHiddenTokens(element);
							copyLocalizationInfos((CommonToken)a10, element);
						}
						
						(
							a11_0 = typereference							{
								if (element == null) {
									element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createInterface();
								}
								if (a11_0 != null) {
									addObjectToList(element, org.emftext.language.java.classifiers.ClassifiersPackage.INTERFACE__EXTENDS, a11_0);
								}
								collectHiddenTokens(element);
								copyLocalizationInfos(a11_0, element); 							}
						)
						
					)
					
				)*				
			)
			
		)
		
	)?	
	a12 = '{' {
		if (element == null) {
			element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createInterface();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a12, element);
	}
	
	(
		(
			(
				a13_0 = member				{
					if (element == null) {
						element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createInterface();
					}
					if (a13_0 != null) {
						addObjectToList(element, org.emftext.language.java.classifiers.ClassifiersPackage.INTERFACE__MEMBERS, a13_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a13_0, element); 				}
			)
			
		)
		
	)*	
	a14 = '}' {
		if (element == null) {
			element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createInterface();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a14, element);
	}
	
;

enumeration returns [org.emftext.language.java.classifiers.Enumeration element = null]
@init{
}
:
	(
		(
			a0_0 = annotationinstanceormodifier			{
				if (element == null) {
					element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createEnumeration();
				}
				if (a0_0 != null) {
					addObjectToList(element, org.emftext.language.java.classifiers.ClassifiersPackage.ENUMERATION__ANNOTATIONS_AND_MODIFIERS, a0_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a0_0, element); 			}
		)
		
	)*	
	a1 = 'enum' {
		if (element == null) {
			element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createEnumeration();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	
	(
		a2 = IDENTIFIER		
		{
			if (element == null) {
				element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createEnumeration();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.classifiers.ClassifiersPackage.ENUMERATION__NAME), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
			}
			java.lang.String resolved = (java.lang.String)resolvedObject;
			if (resolved != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.classifiers.ClassifiersPackage.ENUMERATION__NAME), resolved);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a2, element);
		}
	)
	
	(
		(
			a3 = 'implements' {
				if (element == null) {
					element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createEnumeration();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a3, element);
			}
			
			(
				(
					a4_0 = typereference					{
						if (element == null) {
							element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createEnumeration();
						}
						if (a4_0 != null) {
							addObjectToList(element, org.emftext.language.java.classifiers.ClassifiersPackage.ENUMERATION__IMPLEMENTS, a4_0);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos(a4_0, element); 					}
				)
				
				(
					(
						a5 = ',' {
							if (element == null) {
								element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createEnumeration();
							}
							collectHiddenTokens(element);
							copyLocalizationInfos((CommonToken)a5, element);
						}
						
						(
							a6_0 = typereference							{
								if (element == null) {
									element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createEnumeration();
								}
								if (a6_0 != null) {
									addObjectToList(element, org.emftext.language.java.classifiers.ClassifiersPackage.ENUMERATION__IMPLEMENTS, a6_0);
								}
								collectHiddenTokens(element);
								copyLocalizationInfos(a6_0, element); 							}
						)
						
					)
					
				)*				
			)
			
		)
		
	)?	
	a7 = '{' {
		if (element == null) {
			element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createEnumeration();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a7, element);
	}
	
	(
		(
			(
				a8_0 = enumconstant				{
					if (element == null) {
						element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createEnumeration();
					}
					if (a8_0 != null) {
						addObjectToList(element, org.emftext.language.java.classifiers.ClassifiersPackage.ENUMERATION__CONSTANTS, a8_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a8_0, element); 				}
			)
			
			(
				(
					a9 = ',' {
						if (element == null) {
							element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createEnumeration();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken)a9, element);
					}
					
					(
						a10_0 = enumconstant						{
							if (element == null) {
								element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createEnumeration();
							}
							if (a10_0 != null) {
								addObjectToList(element, org.emftext.language.java.classifiers.ClassifiersPackage.ENUMERATION__CONSTANTS, a10_0);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos(a10_0, element); 						}
					)
					
				)
				
			)*			
		)
		
	)?	
	(
		(
			a11 = ',' {
				if (element == null) {
					element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createEnumeration();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a11, element);
			}
			
		)
		
	)?	
	(
		(
			a12 = ';' {
				if (element == null) {
					element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createEnumeration();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a12, element);
			}
			
			(
				(
					(
						a13_0 = member						{
							if (element == null) {
								element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createEnumeration();
							}
							if (a13_0 != null) {
								addObjectToList(element, org.emftext.language.java.classifiers.ClassifiersPackage.ENUMERATION__MEMBERS, a13_0);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos(a13_0, element); 						}
					)
					
				)
				
			)*			
		)
		
	)?	
	a14 = '}' {
		if (element == null) {
			element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createEnumeration();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a14, element);
	}
	
;

annotation returns [org.emftext.language.java.classifiers.Annotation element = null]
@init{
}
:
	(
		(
			a0_0 = annotationinstanceormodifier			{
				if (element == null) {
					element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createAnnotation();
				}
				if (a0_0 != null) {
					addObjectToList(element, org.emftext.language.java.classifiers.ClassifiersPackage.ANNOTATION__ANNOTATIONS_AND_MODIFIERS, a0_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a0_0, element); 			}
		)
		
	)*	
	a1 = '@' {
		if (element == null) {
			element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createAnnotation();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	
	a2 = 'interface' {
		if (element == null) {
			element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createAnnotation();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	
	(
		a3 = IDENTIFIER		
		{
			if (element == null) {
				element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createAnnotation();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.classifiers.ClassifiersPackage.ANNOTATION__NAME), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
			}
			java.lang.String resolved = (java.lang.String)resolvedObject;
			if (resolved != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.classifiers.ClassifiersPackage.ANNOTATION__NAME), resolved);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a3, element);
		}
	)
	
	a4 = '{' {
		if (element == null) {
			element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createAnnotation();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a4, element);
	}
	
	(
		(
			(
				a5_0 = member				{
					if (element == null) {
						element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createAnnotation();
					}
					if (a5_0 != null) {
						addObjectToList(element, org.emftext.language.java.classifiers.ClassifiersPackage.ANNOTATION__MEMBERS, a5_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a5_0, element); 				}
			)
			
		)
		
	)*	
	a6 = '}' {
		if (element == null) {
			element = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createAnnotation();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a6, element);
	}
	
;

annotationinstance returns [org.emftext.language.java.annotations.AnnotationInstance element = null]
@init{
}
:
	a0 = '@' {
		if (element == null) {
			element = org.emftext.language.java.annotations.AnnotationsFactory.eINSTANCE.createAnnotationInstance();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	(
		(
			(
				a1 = IDENTIFIER				
				{
					if (element == null) {
						element = org.emftext.language.java.annotations.AnnotationsFactory.eINSTANCE.createAnnotationInstance();
					}
					org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
					tokenResolver.setOptions(getOptions());
					org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.annotations.AnnotationsPackage.ANNOTATION_INSTANCE__NAMESPACES), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						getResource().addError(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String)resolvedObject;
					if (resolved != null) {
						addObjectToList(element, org.emftext.language.java.annotations.AnnotationsPackage.ANNOTATION_INSTANCE__NAMESPACES, resolved);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((CommonToken) a1, element);
				}
			)
			
			a2 = '.' {
				if (element == null) {
					element = org.emftext.language.java.annotations.AnnotationsFactory.eINSTANCE.createAnnotationInstance();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a2, element);
			}
			
		)
		
	)*	
	(
		a3 = IDENTIFIER		
		{
			if (element == null) {
				element = org.emftext.language.java.annotations.AnnotationsFactory.eINSTANCE.createAnnotationInstance();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.annotations.AnnotationsPackage.ANNOTATION_INSTANCE__ANNOTATION), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
			}
			String resolved = (String) resolvedObject;
			org.emftext.language.java.classifiers.Class proxy = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createClass();
			collectHiddenTokens(element);
			getResource().registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.language.java.annotations.AnnotationInstance, org.emftext.language.java.classifiers.Classifier>(((org.emftext.language.java.javabehavior4uml.resource.javabehavior.JavabehaviorReferenceResolverSwitch) resource.getReferenceResolverSwitch()).getAnnotationInstanceAnnotationReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.java.annotations.AnnotationsPackage.ANNOTATION_INSTANCE__ANNOTATION), resolved, proxy);
			if (proxy != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.annotations.AnnotationsPackage.ANNOTATION_INSTANCE__ANNOTATION), proxy);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a3, element);
			copyLocalizationInfos((CommonToken) a3, proxy);
		}
	)
	
	(
		(
			(
				a4_0 = annotationparameter				{
					if (element == null) {
						element = org.emftext.language.java.annotations.AnnotationsFactory.eINSTANCE.createAnnotationInstance();
					}
					if (a4_0 != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.annotations.AnnotationsPackage.ANNOTATION_INSTANCE__PARAMETER), a4_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a4_0, element); 				}
			)
			
		)
		
	)?	
;

singleannotationparameter returns [org.emftext.language.java.annotations.SingleAnnotationParameter element = null]
@init{
}
:
	a0 = '(' {
		if (element == null) {
			element = org.emftext.language.java.annotations.AnnotationsFactory.eINSTANCE.createSingleAnnotationParameter();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	(
		a1_0 = arrayinitializer		{
			if (element == null) {
				element = org.emftext.language.java.annotations.AnnotationsFactory.eINSTANCE.createSingleAnnotationParameter();
			}
			if (a1_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.annotations.AnnotationsPackage.SINGLE_ANNOTATION_PARAMETER__VALUE), a1_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a1_0, element); 		}
		|		a1_1 = conditionalexpression		{
			if (element == null) {
				element = org.emftext.language.java.annotations.AnnotationsFactory.eINSTANCE.createSingleAnnotationParameter();
			}
			if (a1_1 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.annotations.AnnotationsPackage.SINGLE_ANNOTATION_PARAMETER__VALUE), a1_1);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a1_1, element); 		}
	)
	
	a2 = ')' {
		if (element == null) {
			element = org.emftext.language.java.annotations.AnnotationsFactory.eINSTANCE.createSingleAnnotationParameter();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	
;

annotationparameterlist returns [org.emftext.language.java.annotations.AnnotationParameterList element = null]
@init{
}
:
	a0 = '(' {
		if (element == null) {
			element = org.emftext.language.java.annotations.AnnotationsFactory.eINSTANCE.createAnnotationParameterList();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	(
		(
			(
				a1_0 = annotationattributesetting				{
					if (element == null) {
						element = org.emftext.language.java.annotations.AnnotationsFactory.eINSTANCE.createAnnotationParameterList();
					}
					if (a1_0 != null) {
						addObjectToList(element, org.emftext.language.java.annotations.AnnotationsPackage.ANNOTATION_PARAMETER_LIST__SETTINGS, a1_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a1_0, element); 				}
			)
			
			(
				(
					a2 = ',' {
						if (element == null) {
							element = org.emftext.language.java.annotations.AnnotationsFactory.eINSTANCE.createAnnotationParameterList();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken)a2, element);
					}
					
					(
						a3_0 = annotationattributesetting						{
							if (element == null) {
								element = org.emftext.language.java.annotations.AnnotationsFactory.eINSTANCE.createAnnotationParameterList();
							}
							if (a3_0 != null) {
								addObjectToList(element, org.emftext.language.java.annotations.AnnotationsPackage.ANNOTATION_PARAMETER_LIST__SETTINGS, a3_0);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos(a3_0, element); 						}
					)
					
				)
				
			)*			
		)
		
	)?	
	a4 = ')' {
		if (element == null) {
			element = org.emftext.language.java.annotations.AnnotationsFactory.eINSTANCE.createAnnotationParameterList();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a4, element);
	}
	
;

annotationattributesetting returns [org.emftext.language.java.annotations.AnnotationAttributeSetting element = null]
@init{
}
:
	(
		a0 = IDENTIFIER		
		{
			if (element == null) {
				element = org.emftext.language.java.annotations.AnnotationsFactory.eINSTANCE.createAnnotationAttributeSetting();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.annotations.AnnotationsPackage.ANNOTATION_ATTRIBUTE_SETTING__ATTRIBUTE), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
			}
			String resolved = (String) resolvedObject;
			org.emftext.language.java.members.InterfaceMethod proxy = org.emftext.language.java.members.MembersFactory.eINSTANCE.createInterfaceMethod();
			collectHiddenTokens(element);
			getResource().registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.language.java.annotations.AnnotationAttributeSetting, org.emftext.language.java.members.InterfaceMethod>(((org.emftext.language.java.javabehavior4uml.resource.javabehavior.JavabehaviorReferenceResolverSwitch) resource.getReferenceResolverSwitch()).getAnnotationAttributeSettingAttributeReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.java.annotations.AnnotationsPackage.ANNOTATION_ATTRIBUTE_SETTING__ATTRIBUTE), resolved, proxy);
			if (proxy != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.annotations.AnnotationsPackage.ANNOTATION_ATTRIBUTE_SETTING__ATTRIBUTE), proxy);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a0, element);
			copyLocalizationInfos((CommonToken) a0, proxy);
		}
	)
	
	a1 = '=' {
		if (element == null) {
			element = org.emftext.language.java.annotations.AnnotationsFactory.eINSTANCE.createAnnotationAttributeSetting();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	
	(
		a2_0 = arrayinitializer		{
			if (element == null) {
				element = org.emftext.language.java.annotations.AnnotationsFactory.eINSTANCE.createAnnotationAttributeSetting();
			}
			if (a2_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.annotations.AnnotationsPackage.ANNOTATION_ATTRIBUTE_SETTING__VALUE), a2_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a2_0, element); 		}
		|		a2_1 = conditionalexpression		{
			if (element == null) {
				element = org.emftext.language.java.annotations.AnnotationsFactory.eINSTANCE.createAnnotationAttributeSetting();
			}
			if (a2_1 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.annotations.AnnotationsPackage.ANNOTATION_ATTRIBUTE_SETTING__VALUE), a2_1);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a2_1, element); 		}
	)
	
;

typeparameter returns [org.emftext.language.java.generics.TypeParameter element = null]
@init{
}
:
	(
		a0 = IDENTIFIER		
		{
			if (element == null) {
				element = org.emftext.language.java.generics.GenericsFactory.eINSTANCE.createTypeParameter();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.generics.GenericsPackage.TYPE_PARAMETER__NAME), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
			}
			java.lang.String resolved = (java.lang.String)resolvedObject;
			if (resolved != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.generics.GenericsPackage.TYPE_PARAMETER__NAME), resolved);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a0, element);
		}
	)
	
	(
		(
			a1 = 'extends' {
				if (element == null) {
					element = org.emftext.language.java.generics.GenericsFactory.eINSTANCE.createTypeParameter();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a1, element);
			}
			
			(
				a2_0 = typereference				{
					if (element == null) {
						element = org.emftext.language.java.generics.GenericsFactory.eINSTANCE.createTypeParameter();
					}
					if (a2_0 != null) {
						addObjectToList(element, org.emftext.language.java.generics.GenericsPackage.TYPE_PARAMETER__EXTEND_TYPES, a2_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a2_0, element); 				}
			)
			
			(
				(
					a3 = '&' {
						if (element == null) {
							element = org.emftext.language.java.generics.GenericsFactory.eINSTANCE.createTypeParameter();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken)a3, element);
					}
					
					(
						a4_0 = typereference						{
							if (element == null) {
								element = org.emftext.language.java.generics.GenericsFactory.eINSTANCE.createTypeParameter();
							}
							if (a4_0 != null) {
								addObjectToList(element, org.emftext.language.java.generics.GenericsPackage.TYPE_PARAMETER__EXTEND_TYPES, a4_0);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos(a4_0, element); 						}
					)
					
				)
				
			)*			
		)
		
	)?	
;

enumconstant returns [org.emftext.language.java.members.EnumConstant element = null]
@init{
}
:
	(
		(
			a0_0 = annotationinstance			{
				if (element == null) {
					element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createEnumConstant();
				}
				if (a0_0 != null) {
					addObjectToList(element, org.emftext.language.java.members.MembersPackage.ENUM_CONSTANT__ANNOTATIONS, a0_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a0_0, element); 			}
		)
		
	)*	
	(
		a1 = IDENTIFIER		
		{
			if (element == null) {
				element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createEnumConstant();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.members.MembersPackage.ENUM_CONSTANT__NAME), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
			}
			java.lang.String resolved = (java.lang.String)resolvedObject;
			if (resolved != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.members.MembersPackage.ENUM_CONSTANT__NAME), resolved);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a1, element);
		}
	)
	
	(
		(
			a2 = '(' {
				if (element == null) {
					element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createEnumConstant();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a2, element);
			}
			
			(
				(
					(
						a3_0 = assignmentexpression						{
							if (element == null) {
								element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createEnumConstant();
							}
							if (a3_0 != null) {
								addObjectToList(element, org.emftext.language.java.members.MembersPackage.ENUM_CONSTANT__ARGUMENTS, a3_0);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos(a3_0, element); 						}
					)
					
					(
						(
							a4 = ',' {
								if (element == null) {
									element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createEnumConstant();
								}
								collectHiddenTokens(element);
								copyLocalizationInfos((CommonToken)a4, element);
							}
							
							(
								a5_0 = assignmentexpression								{
									if (element == null) {
										element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createEnumConstant();
									}
									if (a5_0 != null) {
										addObjectToList(element, org.emftext.language.java.members.MembersPackage.ENUM_CONSTANT__ARGUMENTS, a5_0);
									}
									collectHiddenTokens(element);
									copyLocalizationInfos(a5_0, element); 								}
							)
							
						)
						
					)*					
				)
				
			)?			
			a6 = ')' {
				if (element == null) {
					element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createEnumConstant();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a6, element);
			}
			
		)
		
	)?	
	(
		(
			a7 = '{' {
				if (element == null) {
					element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createEnumConstant();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a7, element);
			}
			
			(
				(
					(
						a8_0 = member						{
							if (element == null) {
								element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createEnumConstant();
							}
							if (a8_0 != null) {
								addObjectToList(element, org.emftext.language.java.members.MembersPackage.ENUM_CONSTANT__MEMBERS, a8_0);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos(a8_0, element); 						}
					)
					
				)
				
			)*			
			a9 = '}' {
				if (element == null) {
					element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createEnumConstant();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a9, element);
			}
			
		)
		
	)?	
;

block returns [org.emftext.language.java.statements.Block element = null]
@init{
}
:
	(
		(
			a0_0 = modifier			{
				if (element == null) {
					element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createBlock();
				}
				if (a0_0 != null) {
					addObjectToList(element, org.emftext.language.java.statements.StatementsPackage.BLOCK__MODIFIERS, a0_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a0_0, element); 			}
		)
		
	)*	
	a1 = '{' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createBlock();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	
	(
		(
			a2_0 = statement			{
				if (element == null) {
					element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createBlock();
				}
				if (a2_0 != null) {
					addObjectToList(element, org.emftext.language.java.statements.StatementsPackage.BLOCK__STATEMENTS, a2_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a2_0, element); 			}
		)
		
	)*	
	a3 = '}' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createBlock();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a3, element);
	}
	
;

constructor returns [org.emftext.language.java.members.Constructor element = null]
@init{
}
:
	(
		(
			a0_0 = annotationinstanceormodifier			{
				if (element == null) {
					element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createConstructor();
				}
				if (a0_0 != null) {
					addObjectToList(element, org.emftext.language.java.members.MembersPackage.CONSTRUCTOR__ANNOTATIONS_AND_MODIFIERS, a0_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a0_0, element); 			}
		)
		
	)*	
	(
		(
			a1 = '<' {
				if (element == null) {
					element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createConstructor();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a1, element);
			}
			
			(
				a2_0 = typeparameter				{
					if (element == null) {
						element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createConstructor();
					}
					if (a2_0 != null) {
						addObjectToList(element, org.emftext.language.java.members.MembersPackage.CONSTRUCTOR__TYPE_PARAMETERS, a2_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a2_0, element); 				}
			)
			
			(
				(
					a3 = ',' {
						if (element == null) {
							element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createConstructor();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken)a3, element);
					}
					
					(
						a4_0 = typeparameter						{
							if (element == null) {
								element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createConstructor();
							}
							if (a4_0 != null) {
								addObjectToList(element, org.emftext.language.java.members.MembersPackage.CONSTRUCTOR__TYPE_PARAMETERS, a4_0);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos(a4_0, element); 						}
					)
					
				)
				
			)*			
			a5 = '>' {
				if (element == null) {
					element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createConstructor();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a5, element);
			}
			
		)
		
	)?	
	(
		a6 = IDENTIFIER		
		{
			if (element == null) {
				element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createConstructor();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.members.MembersPackage.CONSTRUCTOR__NAME), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a6).getLine(), ((CommonToken) a6).getCharPositionInLine(), ((CommonToken) a6).getStartIndex(), ((CommonToken) a6).getStopIndex());
			}
			java.lang.String resolved = (java.lang.String)resolvedObject;
			if (resolved != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.members.MembersPackage.CONSTRUCTOR__NAME), resolved);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a6, element);
		}
	)
	
	a7 = '(' {
		if (element == null) {
			element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createConstructor();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a7, element);
	}
	
	(
		(
			(
				a8_0 = parameter				{
					if (element == null) {
						element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createConstructor();
					}
					if (a8_0 != null) {
						addObjectToList(element, org.emftext.language.java.members.MembersPackage.CONSTRUCTOR__PARAMETERS, a8_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a8_0, element); 				}
			)
			
			(
				(
					a9 = ',' {
						if (element == null) {
							element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createConstructor();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken)a9, element);
					}
					
					(
						a10_0 = parameter						{
							if (element == null) {
								element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createConstructor();
							}
							if (a10_0 != null) {
								addObjectToList(element, org.emftext.language.java.members.MembersPackage.CONSTRUCTOR__PARAMETERS, a10_0);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos(a10_0, element); 						}
					)
					
				)
				
			)*			
		)
		
	)?	
	a11 = ')' {
		if (element == null) {
			element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createConstructor();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a11, element);
	}
	
	(
		(
			a12 = 'throws' {
				if (element == null) {
					element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createConstructor();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a12, element);
			}
			
			(
				a13_0 = namespaceclassifierreference				{
					if (element == null) {
						element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createConstructor();
					}
					if (a13_0 != null) {
						addObjectToList(element, org.emftext.language.java.members.MembersPackage.CONSTRUCTOR__EXCEPTIONS, a13_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a13_0, element); 				}
			)
			
			(
				(
					a14 = ',' {
						if (element == null) {
							element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createConstructor();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken)a14, element);
					}
					
					(
						a15_0 = namespaceclassifierreference						{
							if (element == null) {
								element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createConstructor();
							}
							if (a15_0 != null) {
								addObjectToList(element, org.emftext.language.java.members.MembersPackage.CONSTRUCTOR__EXCEPTIONS, a15_0);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos(a15_0, element); 						}
					)
					
				)
				
			)*			
		)
		
	)?	
	a16 = '{' {
		if (element == null) {
			element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createConstructor();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a16, element);
	}
	
	(
		(
			a17_0 = statement			{
				if (element == null) {
					element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createConstructor();
				}
				if (a17_0 != null) {
					addObjectToList(element, org.emftext.language.java.members.MembersPackage.CONSTRUCTOR__STATEMENTS, a17_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a17_0, element); 			}
		)
		
	)*	
	a18 = '}' {
		if (element == null) {
			element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createConstructor();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a18, element);
	}
	
;

interfacemethod returns [org.emftext.language.java.members.InterfaceMethod element = null]
@init{
}
:
	(
		(
			a0_0 = annotationinstanceormodifier			{
				if (element == null) {
					element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createInterfaceMethod();
				}
				if (a0_0 != null) {
					addObjectToList(element, org.emftext.language.java.members.MembersPackage.INTERFACE_METHOD__ANNOTATIONS_AND_MODIFIERS, a0_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a0_0, element); 			}
		)
		
	)*	
	(
		(
			a1 = '<' {
				if (element == null) {
					element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createInterfaceMethod();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a1, element);
			}
			
			(
				a2_0 = typeparameter				{
					if (element == null) {
						element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createInterfaceMethod();
					}
					if (a2_0 != null) {
						addObjectToList(element, org.emftext.language.java.members.MembersPackage.INTERFACE_METHOD__TYPE_PARAMETERS, a2_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a2_0, element); 				}
			)
			
			(
				(
					a3 = ',' {
						if (element == null) {
							element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createInterfaceMethod();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken)a3, element);
					}
					
					(
						a4_0 = typeparameter						{
							if (element == null) {
								element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createInterfaceMethod();
							}
							if (a4_0 != null) {
								addObjectToList(element, org.emftext.language.java.members.MembersPackage.INTERFACE_METHOD__TYPE_PARAMETERS, a4_0);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos(a4_0, element); 						}
					)
					
				)
				
			)*			
			a5 = '>' {
				if (element == null) {
					element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createInterfaceMethod();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a5, element);
			}
			
		)
		
	)?	
	(
		(
			a6_0 = typereference			{
				if (element == null) {
					element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createInterfaceMethod();
				}
				if (a6_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.members.MembersPackage.INTERFACE_METHOD__TYPE), a6_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a6_0, element); 			}
		)
		
		(
			(
				a7_0 = arraydimension				{
					if (element == null) {
						element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createInterfaceMethod();
					}
					if (a7_0 != null) {
						addObjectToList(element, org.emftext.language.java.members.MembersPackage.INTERFACE_METHOD__ARRAY_DIMENSIONS_BEFORE, a7_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a7_0, element); 				}
			)
			
		)*		
	)
	
	(
		a8 = IDENTIFIER		
		{
			if (element == null) {
				element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createInterfaceMethod();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.members.MembersPackage.INTERFACE_METHOD__NAME), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a8).getLine(), ((CommonToken) a8).getCharPositionInLine(), ((CommonToken) a8).getStartIndex(), ((CommonToken) a8).getStopIndex());
			}
			java.lang.String resolved = (java.lang.String)resolvedObject;
			if (resolved != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.members.MembersPackage.INTERFACE_METHOD__NAME), resolved);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a8, element);
		}
	)
	
	a9 = '(' {
		if (element == null) {
			element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createInterfaceMethod();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a9, element);
	}
	
	(
		(
			(
				a10_0 = parameter				{
					if (element == null) {
						element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createInterfaceMethod();
					}
					if (a10_0 != null) {
						addObjectToList(element, org.emftext.language.java.members.MembersPackage.INTERFACE_METHOD__PARAMETERS, a10_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a10_0, element); 				}
			)
			
			(
				(
					a11 = ',' {
						if (element == null) {
							element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createInterfaceMethod();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken)a11, element);
					}
					
					(
						a12_0 = parameter						{
							if (element == null) {
								element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createInterfaceMethod();
							}
							if (a12_0 != null) {
								addObjectToList(element, org.emftext.language.java.members.MembersPackage.INTERFACE_METHOD__PARAMETERS, a12_0);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos(a12_0, element); 						}
					)
					
				)
				
			)*			
		)
		
	)?	
	a13 = ')' {
		if (element == null) {
			element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createInterfaceMethod();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a13, element);
	}
	
	(
		(
			a14_0 = arraydimension			{
				if (element == null) {
					element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createInterfaceMethod();
				}
				if (a14_0 != null) {
					addObjectToList(element, org.emftext.language.java.members.MembersPackage.INTERFACE_METHOD__ARRAY_DIMENSIONS_AFTER, a14_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a14_0, element); 			}
		)
		
	)*	
	(
		(
			a15 = 'throws' {
				if (element == null) {
					element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createInterfaceMethod();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a15, element);
			}
			
			(
				a16_0 = namespaceclassifierreference				{
					if (element == null) {
						element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createInterfaceMethod();
					}
					if (a16_0 != null) {
						addObjectToList(element, org.emftext.language.java.members.MembersPackage.INTERFACE_METHOD__EXCEPTIONS, a16_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a16_0, element); 				}
			)
			
			(
				(
					a17 = ',' {
						if (element == null) {
							element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createInterfaceMethod();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken)a17, element);
					}
					
					(
						a18_0 = namespaceclassifierreference						{
							if (element == null) {
								element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createInterfaceMethod();
							}
							if (a18_0 != null) {
								addObjectToList(element, org.emftext.language.java.members.MembersPackage.INTERFACE_METHOD__EXCEPTIONS, a18_0);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos(a18_0, element); 						}
					)
					
				)
				
			)*			
		)
		
	)?	
	a19 = ';' {
		if (element == null) {
			element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createInterfaceMethod();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a19, element);
	}
	
	|//derived choice rules for sub-classes: 
	
	c0 = annotationattribute{ element = c0; }
	
;

classmethod returns [org.emftext.language.java.members.ClassMethod element = null]
@init{
}
:
	(
		(
			a0_0 = annotationinstanceormodifier			{
				if (element == null) {
					element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createClassMethod();
				}
				if (a0_0 != null) {
					addObjectToList(element, org.emftext.language.java.members.MembersPackage.CLASS_METHOD__ANNOTATIONS_AND_MODIFIERS, a0_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a0_0, element); 			}
		)
		
	)*	
	(
		(
			a1 = '<' {
				if (element == null) {
					element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createClassMethod();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a1, element);
			}
			
			(
				a2_0 = typeparameter				{
					if (element == null) {
						element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createClassMethod();
					}
					if (a2_0 != null) {
						addObjectToList(element, org.emftext.language.java.members.MembersPackage.CLASS_METHOD__TYPE_PARAMETERS, a2_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a2_0, element); 				}
			)
			
			(
				(
					a3 = ',' {
						if (element == null) {
							element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createClassMethod();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken)a3, element);
					}
					
					(
						a4_0 = typeparameter						{
							if (element == null) {
								element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createClassMethod();
							}
							if (a4_0 != null) {
								addObjectToList(element, org.emftext.language.java.members.MembersPackage.CLASS_METHOD__TYPE_PARAMETERS, a4_0);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos(a4_0, element); 						}
					)
					
				)
				
			)*			
			a5 = '>' {
				if (element == null) {
					element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createClassMethod();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a5, element);
			}
			
		)
		
	)?	
	(
		(
			a6_0 = typereference			{
				if (element == null) {
					element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createClassMethod();
				}
				if (a6_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.members.MembersPackage.CLASS_METHOD__TYPE), a6_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a6_0, element); 			}
		)
		
		(
			(
				a7_0 = arraydimension				{
					if (element == null) {
						element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createClassMethod();
					}
					if (a7_0 != null) {
						addObjectToList(element, org.emftext.language.java.members.MembersPackage.CLASS_METHOD__ARRAY_DIMENSIONS_BEFORE, a7_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a7_0, element); 				}
			)
			
		)*		
	)
	
	(
		a8 = IDENTIFIER		
		{
			if (element == null) {
				element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createClassMethod();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.members.MembersPackage.CLASS_METHOD__NAME), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a8).getLine(), ((CommonToken) a8).getCharPositionInLine(), ((CommonToken) a8).getStartIndex(), ((CommonToken) a8).getStopIndex());
			}
			java.lang.String resolved = (java.lang.String)resolvedObject;
			if (resolved != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.members.MembersPackage.CLASS_METHOD__NAME), resolved);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a8, element);
		}
	)
	
	a9 = '(' {
		if (element == null) {
			element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createClassMethod();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a9, element);
	}
	
	(
		(
			(
				a10_0 = parameter				{
					if (element == null) {
						element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createClassMethod();
					}
					if (a10_0 != null) {
						addObjectToList(element, org.emftext.language.java.members.MembersPackage.CLASS_METHOD__PARAMETERS, a10_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a10_0, element); 				}
			)
			
			(
				(
					a11 = ',' {
						if (element == null) {
							element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createClassMethod();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken)a11, element);
					}
					
					(
						a12_0 = parameter						{
							if (element == null) {
								element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createClassMethod();
							}
							if (a12_0 != null) {
								addObjectToList(element, org.emftext.language.java.members.MembersPackage.CLASS_METHOD__PARAMETERS, a12_0);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos(a12_0, element); 						}
					)
					
				)
				
			)*			
		)
		
	)?	
	a13 = ')' {
		if (element == null) {
			element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createClassMethod();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a13, element);
	}
	
	(
		(
			a14_0 = arraydimension			{
				if (element == null) {
					element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createClassMethod();
				}
				if (a14_0 != null) {
					addObjectToList(element, org.emftext.language.java.members.MembersPackage.CLASS_METHOD__ARRAY_DIMENSIONS_AFTER, a14_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a14_0, element); 			}
		)
		
	)*	
	(
		(
			a15 = 'throws' {
				if (element == null) {
					element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createClassMethod();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a15, element);
			}
			
			(
				a16_0 = namespaceclassifierreference				{
					if (element == null) {
						element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createClassMethod();
					}
					if (a16_0 != null) {
						addObjectToList(element, org.emftext.language.java.members.MembersPackage.CLASS_METHOD__EXCEPTIONS, a16_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a16_0, element); 				}
			)
			
			(
				(
					a17 = ',' {
						if (element == null) {
							element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createClassMethod();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken)a17, element);
					}
					
					(
						a18_0 = namespaceclassifierreference						{
							if (element == null) {
								element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createClassMethod();
							}
							if (a18_0 != null) {
								addObjectToList(element, org.emftext.language.java.members.MembersPackage.CLASS_METHOD__EXCEPTIONS, a18_0);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos(a18_0, element); 						}
					)
					
				)
				
			)*			
		)
		
	)?	
	a19 = '{' {
		if (element == null) {
			element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createClassMethod();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a19, element);
	}
	
	(
		(
			a20_0 = statement			{
				if (element == null) {
					element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createClassMethod();
				}
				if (a20_0 != null) {
					addObjectToList(element, org.emftext.language.java.members.MembersPackage.CLASS_METHOD__STATEMENTS, a20_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a20_0, element); 			}
		)
		
	)*	
	a21 = '}' {
		if (element == null) {
			element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createClassMethod();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a21, element);
	}
	
;

annotationattribute returns [org.emftext.language.java.annotations.AnnotationAttribute element = null]
@init{
}
:
	(
		(
			a0_0 = annotationinstanceormodifier			{
				if (element == null) {
					element = org.emftext.language.java.annotations.AnnotationsFactory.eINSTANCE.createAnnotationAttribute();
				}
				if (a0_0 != null) {
					addObjectToList(element, org.emftext.language.java.annotations.AnnotationsPackage.ANNOTATION_ATTRIBUTE__ANNOTATIONS_AND_MODIFIERS, a0_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a0_0, element); 			}
		)
		
	)*	
	(
		(
			a1 = '<' {
				if (element == null) {
					element = org.emftext.language.java.annotations.AnnotationsFactory.eINSTANCE.createAnnotationAttribute();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a1, element);
			}
			
			(
				a2_0 = typeparameter				{
					if (element == null) {
						element = org.emftext.language.java.annotations.AnnotationsFactory.eINSTANCE.createAnnotationAttribute();
					}
					if (a2_0 != null) {
						addObjectToList(element, org.emftext.language.java.annotations.AnnotationsPackage.ANNOTATION_ATTRIBUTE__TYPE_PARAMETERS, a2_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a2_0, element); 				}
			)
			
			(
				(
					a3 = ',' {
						if (element == null) {
							element = org.emftext.language.java.annotations.AnnotationsFactory.eINSTANCE.createAnnotationAttribute();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken)a3, element);
					}
					
					(
						a4_0 = typeparameter						{
							if (element == null) {
								element = org.emftext.language.java.annotations.AnnotationsFactory.eINSTANCE.createAnnotationAttribute();
							}
							if (a4_0 != null) {
								addObjectToList(element, org.emftext.language.java.annotations.AnnotationsPackage.ANNOTATION_ATTRIBUTE__TYPE_PARAMETERS, a4_0);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos(a4_0, element); 						}
					)
					
				)
				
			)*			
			a5 = '>' {
				if (element == null) {
					element = org.emftext.language.java.annotations.AnnotationsFactory.eINSTANCE.createAnnotationAttribute();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a5, element);
			}
			
		)
		
	)?	
	(
		(
			a6_0 = typereference			{
				if (element == null) {
					element = org.emftext.language.java.annotations.AnnotationsFactory.eINSTANCE.createAnnotationAttribute();
				}
				if (a6_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.annotations.AnnotationsPackage.ANNOTATION_ATTRIBUTE__TYPE), a6_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a6_0, element); 			}
		)
		
		(
			(
				a7_0 = arraydimension				{
					if (element == null) {
						element = org.emftext.language.java.annotations.AnnotationsFactory.eINSTANCE.createAnnotationAttribute();
					}
					if (a7_0 != null) {
						addObjectToList(element, org.emftext.language.java.annotations.AnnotationsPackage.ANNOTATION_ATTRIBUTE__ARRAY_DIMENSIONS_BEFORE, a7_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a7_0, element); 				}
			)
			
		)*		
	)
	
	(
		a8 = IDENTIFIER		
		{
			if (element == null) {
				element = org.emftext.language.java.annotations.AnnotationsFactory.eINSTANCE.createAnnotationAttribute();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.annotations.AnnotationsPackage.ANNOTATION_ATTRIBUTE__NAME), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a8).getLine(), ((CommonToken) a8).getCharPositionInLine(), ((CommonToken) a8).getStartIndex(), ((CommonToken) a8).getStopIndex());
			}
			java.lang.String resolved = (java.lang.String)resolvedObject;
			if (resolved != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.annotations.AnnotationsPackage.ANNOTATION_ATTRIBUTE__NAME), resolved);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a8, element);
		}
	)
	
	a9 = '(' {
		if (element == null) {
			element = org.emftext.language.java.annotations.AnnotationsFactory.eINSTANCE.createAnnotationAttribute();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a9, element);
	}
	
	(
		(
			(
				a10_0 = parameter				{
					if (element == null) {
						element = org.emftext.language.java.annotations.AnnotationsFactory.eINSTANCE.createAnnotationAttribute();
					}
					if (a10_0 != null) {
						addObjectToList(element, org.emftext.language.java.annotations.AnnotationsPackage.ANNOTATION_ATTRIBUTE__PARAMETERS, a10_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a10_0, element); 				}
			)
			
			(
				(
					a11 = ',' {
						if (element == null) {
							element = org.emftext.language.java.annotations.AnnotationsFactory.eINSTANCE.createAnnotationAttribute();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken)a11, element);
					}
					
					(
						a12_0 = parameter						{
							if (element == null) {
								element = org.emftext.language.java.annotations.AnnotationsFactory.eINSTANCE.createAnnotationAttribute();
							}
							if (a12_0 != null) {
								addObjectToList(element, org.emftext.language.java.annotations.AnnotationsPackage.ANNOTATION_ATTRIBUTE__PARAMETERS, a12_0);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos(a12_0, element); 						}
					)
					
				)
				
			)*			
		)
		
	)?	
	a13 = ')' {
		if (element == null) {
			element = org.emftext.language.java.annotations.AnnotationsFactory.eINSTANCE.createAnnotationAttribute();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a13, element);
	}
	
	(
		(
			a14_0 = arraydimension			{
				if (element == null) {
					element = org.emftext.language.java.annotations.AnnotationsFactory.eINSTANCE.createAnnotationAttribute();
				}
				if (a14_0 != null) {
					addObjectToList(element, org.emftext.language.java.annotations.AnnotationsPackage.ANNOTATION_ATTRIBUTE__ARRAY_DIMENSIONS_AFTER, a14_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a14_0, element); 			}
		)
		
	)*	
	(
		(
			a15 = 'throws' {
				if (element == null) {
					element = org.emftext.language.java.annotations.AnnotationsFactory.eINSTANCE.createAnnotationAttribute();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a15, element);
			}
			
			(
				a16_0 = namespaceclassifierreference				{
					if (element == null) {
						element = org.emftext.language.java.annotations.AnnotationsFactory.eINSTANCE.createAnnotationAttribute();
					}
					if (a16_0 != null) {
						addObjectToList(element, org.emftext.language.java.annotations.AnnotationsPackage.ANNOTATION_ATTRIBUTE__EXCEPTIONS, a16_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a16_0, element); 				}
			)
			
			(
				(
					a17 = ',' {
						if (element == null) {
							element = org.emftext.language.java.annotations.AnnotationsFactory.eINSTANCE.createAnnotationAttribute();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken)a17, element);
					}
					
					(
						a18_0 = namespaceclassifierreference						{
							if (element == null) {
								element = org.emftext.language.java.annotations.AnnotationsFactory.eINSTANCE.createAnnotationAttribute();
							}
							if (a18_0 != null) {
								addObjectToList(element, org.emftext.language.java.annotations.AnnotationsPackage.ANNOTATION_ATTRIBUTE__EXCEPTIONS, a18_0);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos(a18_0, element); 						}
					)
					
				)
				
			)*			
		)
		
	)?	
	a19 = 'default' {
		if (element == null) {
			element = org.emftext.language.java.annotations.AnnotationsFactory.eINSTANCE.createAnnotationAttribute();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a19, element);
	}
	
	(
		a20_0 = assignmentexpression		{
			if (element == null) {
				element = org.emftext.language.java.annotations.AnnotationsFactory.eINSTANCE.createAnnotationAttribute();
			}
			if (a20_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.annotations.AnnotationsPackage.ANNOTATION_ATTRIBUTE__DEFAULT_VALUE), a20_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a20_0, element); 		}
	)
	
	a21 = ';' {
		if (element == null) {
			element = org.emftext.language.java.annotations.AnnotationsFactory.eINSTANCE.createAnnotationAttribute();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a21, element);
	}
	
;

ordinaryparameter returns [org.emftext.language.java.parameters.OrdinaryParameter element = null]
@init{
}
:
	(
		(
			a0_0 = annotationinstanceormodifier			{
				if (element == null) {
					element = org.emftext.language.java.parameters.ParametersFactory.eINSTANCE.createOrdinaryParameter();
				}
				if (a0_0 != null) {
					addObjectToList(element, org.emftext.language.java.parameters.ParametersPackage.ORDINARY_PARAMETER__ANNOTATIONS_AND_MODIFIERS, a0_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a0_0, element); 			}
		)
		
	)*	
	(
		a1_0 = typereference		{
			if (element == null) {
				element = org.emftext.language.java.parameters.ParametersFactory.eINSTANCE.createOrdinaryParameter();
			}
			if (a1_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.parameters.ParametersPackage.ORDINARY_PARAMETER__TYPE), a1_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a1_0, element); 		}
	)
	
	(
		(
			a2_0 = arraydimension			{
				if (element == null) {
					element = org.emftext.language.java.parameters.ParametersFactory.eINSTANCE.createOrdinaryParameter();
				}
				if (a2_0 != null) {
					addObjectToList(element, org.emftext.language.java.parameters.ParametersPackage.ORDINARY_PARAMETER__ARRAY_DIMENSIONS_BEFORE, a2_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a2_0, element); 			}
		)
		
	)*	
	(
		(
			a3 = '<' {
				if (element == null) {
					element = org.emftext.language.java.parameters.ParametersFactory.eINSTANCE.createOrdinaryParameter();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a3, element);
			}
			
			(
				a4_0 = typeargument				{
					if (element == null) {
						element = org.emftext.language.java.parameters.ParametersFactory.eINSTANCE.createOrdinaryParameter();
					}
					if (a4_0 != null) {
						addObjectToList(element, org.emftext.language.java.parameters.ParametersPackage.ORDINARY_PARAMETER__TYPE_ARGUMENTS, a4_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a4_0, element); 				}
			)
			
			(
				(
					a5 = ',' {
						if (element == null) {
							element = org.emftext.language.java.parameters.ParametersFactory.eINSTANCE.createOrdinaryParameter();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken)a5, element);
					}
					
					(
						a6_0 = typeargument						{
							if (element == null) {
								element = org.emftext.language.java.parameters.ParametersFactory.eINSTANCE.createOrdinaryParameter();
							}
							if (a6_0 != null) {
								addObjectToList(element, org.emftext.language.java.parameters.ParametersPackage.ORDINARY_PARAMETER__TYPE_ARGUMENTS, a6_0);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos(a6_0, element); 						}
					)
					
				)
				
			)*			
			a7 = '>' {
				if (element == null) {
					element = org.emftext.language.java.parameters.ParametersFactory.eINSTANCE.createOrdinaryParameter();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a7, element);
			}
			
		)
		
	)?	
	(
		a8 = IDENTIFIER		
		{
			if (element == null) {
				element = org.emftext.language.java.parameters.ParametersFactory.eINSTANCE.createOrdinaryParameter();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.parameters.ParametersPackage.ORDINARY_PARAMETER__NAME), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a8).getLine(), ((CommonToken) a8).getCharPositionInLine(), ((CommonToken) a8).getStartIndex(), ((CommonToken) a8).getStopIndex());
			}
			java.lang.String resolved = (java.lang.String)resolvedObject;
			if (resolved != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.parameters.ParametersPackage.ORDINARY_PARAMETER__NAME), resolved);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a8, element);
		}
	)
	
	(
		(
			a9_0 = arraydimension			{
				if (element == null) {
					element = org.emftext.language.java.parameters.ParametersFactory.eINSTANCE.createOrdinaryParameter();
				}
				if (a9_0 != null) {
					addObjectToList(element, org.emftext.language.java.parameters.ParametersPackage.ORDINARY_PARAMETER__ARRAY_DIMENSIONS_AFTER, a9_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a9_0, element); 			}
		)
		
	)*	
;

variablelengthparameter returns [org.emftext.language.java.parameters.VariableLengthParameter element = null]
@init{
}
:
	(
		(
			a0_0 = annotationinstanceormodifier			{
				if (element == null) {
					element = org.emftext.language.java.parameters.ParametersFactory.eINSTANCE.createVariableLengthParameter();
				}
				if (a0_0 != null) {
					addObjectToList(element, org.emftext.language.java.parameters.ParametersPackage.VARIABLE_LENGTH_PARAMETER__ANNOTATIONS_AND_MODIFIERS, a0_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a0_0, element); 			}
		)
		
	)*	
	(
		a1_0 = typereference		{
			if (element == null) {
				element = org.emftext.language.java.parameters.ParametersFactory.eINSTANCE.createVariableLengthParameter();
			}
			if (a1_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.parameters.ParametersPackage.VARIABLE_LENGTH_PARAMETER__TYPE), a1_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a1_0, element); 		}
	)
	
	(
		(
			a2_0 = arraydimension			{
				if (element == null) {
					element = org.emftext.language.java.parameters.ParametersFactory.eINSTANCE.createVariableLengthParameter();
				}
				if (a2_0 != null) {
					addObjectToList(element, org.emftext.language.java.parameters.ParametersPackage.VARIABLE_LENGTH_PARAMETER__ARRAY_DIMENSIONS_BEFORE, a2_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a2_0, element); 			}
		)
		
	)*	
	(
		(
			a3 = '<' {
				if (element == null) {
					element = org.emftext.language.java.parameters.ParametersFactory.eINSTANCE.createVariableLengthParameter();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a3, element);
			}
			
			(
				a4_0 = typeargument				{
					if (element == null) {
						element = org.emftext.language.java.parameters.ParametersFactory.eINSTANCE.createVariableLengthParameter();
					}
					if (a4_0 != null) {
						addObjectToList(element, org.emftext.language.java.parameters.ParametersPackage.VARIABLE_LENGTH_PARAMETER__TYPE_ARGUMENTS, a4_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a4_0, element); 				}
			)
			
			(
				(
					a5 = ',' {
						if (element == null) {
							element = org.emftext.language.java.parameters.ParametersFactory.eINSTANCE.createVariableLengthParameter();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken)a5, element);
					}
					
					(
						a6_0 = typeargument						{
							if (element == null) {
								element = org.emftext.language.java.parameters.ParametersFactory.eINSTANCE.createVariableLengthParameter();
							}
							if (a6_0 != null) {
								addObjectToList(element, org.emftext.language.java.parameters.ParametersPackage.VARIABLE_LENGTH_PARAMETER__TYPE_ARGUMENTS, a6_0);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos(a6_0, element); 						}
					)
					
				)
				
			)*			
			a7 = '>' {
				if (element == null) {
					element = org.emftext.language.java.parameters.ParametersFactory.eINSTANCE.createVariableLengthParameter();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a7, element);
			}
			
		)
		
	)?	
	a8 = '...' {
		if (element == null) {
			element = org.emftext.language.java.parameters.ParametersFactory.eINSTANCE.createVariableLengthParameter();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a8, element);
	}
	
	(
		a9 = IDENTIFIER		
		{
			if (element == null) {
				element = org.emftext.language.java.parameters.ParametersFactory.eINSTANCE.createVariableLengthParameter();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a9.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.parameters.ParametersPackage.VARIABLE_LENGTH_PARAMETER__NAME), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a9).getLine(), ((CommonToken) a9).getCharPositionInLine(), ((CommonToken) a9).getStartIndex(), ((CommonToken) a9).getStopIndex());
			}
			java.lang.String resolved = (java.lang.String)resolvedObject;
			if (resolved != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.parameters.ParametersPackage.VARIABLE_LENGTH_PARAMETER__NAME), resolved);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a9, element);
		}
	)
	
;

localvariable returns [org.emftext.language.java.variables.LocalVariable element = null]
@init{
}
:
	(
		(
			a0_0 = annotationinstanceormodifier			{
				if (element == null) {
					element = org.emftext.language.java.variables.VariablesFactory.eINSTANCE.createLocalVariable();
				}
				if (a0_0 != null) {
					addObjectToList(element, org.emftext.language.java.variables.VariablesPackage.LOCAL_VARIABLE__ANNOTATIONS_AND_MODIFIERS, a0_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a0_0, element); 			}
		)
		
	)*	
	(
		a1_0 = typereference		{
			if (element == null) {
				element = org.emftext.language.java.variables.VariablesFactory.eINSTANCE.createLocalVariable();
			}
			if (a1_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.variables.VariablesPackage.LOCAL_VARIABLE__TYPE), a1_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a1_0, element); 		}
	)
	
	(
		(
			a2_0 = arraydimension			{
				if (element == null) {
					element = org.emftext.language.java.variables.VariablesFactory.eINSTANCE.createLocalVariable();
				}
				if (a2_0 != null) {
					addObjectToList(element, org.emftext.language.java.variables.VariablesPackage.LOCAL_VARIABLE__ARRAY_DIMENSIONS_BEFORE, a2_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a2_0, element); 			}
		)
		
	)*	
	(
		(
			a3 = '<' {
				if (element == null) {
					element = org.emftext.language.java.variables.VariablesFactory.eINSTANCE.createLocalVariable();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a3, element);
			}
			
			(
				a4_0 = typeargument				{
					if (element == null) {
						element = org.emftext.language.java.variables.VariablesFactory.eINSTANCE.createLocalVariable();
					}
					if (a4_0 != null) {
						addObjectToList(element, org.emftext.language.java.variables.VariablesPackage.LOCAL_VARIABLE__TYPE_ARGUMENTS, a4_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a4_0, element); 				}
			)
			
			(
				(
					a5 = ',' {
						if (element == null) {
							element = org.emftext.language.java.variables.VariablesFactory.eINSTANCE.createLocalVariable();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken)a5, element);
					}
					
					(
						a6_0 = typeargument						{
							if (element == null) {
								element = org.emftext.language.java.variables.VariablesFactory.eINSTANCE.createLocalVariable();
							}
							if (a6_0 != null) {
								addObjectToList(element, org.emftext.language.java.variables.VariablesPackage.LOCAL_VARIABLE__TYPE_ARGUMENTS, a6_0);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos(a6_0, element); 						}
					)
					
				)
				
			)*			
			a7 = '>' {
				if (element == null) {
					element = org.emftext.language.java.variables.VariablesFactory.eINSTANCE.createLocalVariable();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a7, element);
			}
			
		)
		
	)?	
	(
		a8 = IDENTIFIER		
		{
			if (element == null) {
				element = org.emftext.language.java.variables.VariablesFactory.eINSTANCE.createLocalVariable();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.variables.VariablesPackage.LOCAL_VARIABLE__NAME), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a8).getLine(), ((CommonToken) a8).getCharPositionInLine(), ((CommonToken) a8).getStartIndex(), ((CommonToken) a8).getStopIndex());
			}
			java.lang.String resolved = (java.lang.String)resolvedObject;
			if (resolved != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.variables.VariablesPackage.LOCAL_VARIABLE__NAME), resolved);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a8, element);
		}
	)
	
	(
		(
			a9_0 = arraydimension			{
				if (element == null) {
					element = org.emftext.language.java.variables.VariablesFactory.eINSTANCE.createLocalVariable();
				}
				if (a9_0 != null) {
					addObjectToList(element, org.emftext.language.java.variables.VariablesPackage.LOCAL_VARIABLE__ARRAY_DIMENSIONS_AFTER, a9_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a9_0, element); 			}
		)
		
	)*	
	(
		(
			a10 = '=' {
				if (element == null) {
					element = org.emftext.language.java.variables.VariablesFactory.eINSTANCE.createLocalVariable();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a10, element);
			}
			
			(
				a11_0 = assignmentexpression				{
					if (element == null) {
						element = org.emftext.language.java.variables.VariablesFactory.eINSTANCE.createLocalVariable();
					}
					if (a11_0 != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.variables.VariablesPackage.LOCAL_VARIABLE__INITIAL_VALUE), a11_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a11_0, element); 				}
			)
			
		)
		
	)?	
	(
		(
			a12 = ',' {
				if (element == null) {
					element = org.emftext.language.java.variables.VariablesFactory.eINSTANCE.createLocalVariable();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a12, element);
			}
			
			(
				a13_0 = additionallocalvariable				{
					if (element == null) {
						element = org.emftext.language.java.variables.VariablesFactory.eINSTANCE.createLocalVariable();
					}
					if (a13_0 != null) {
						addObjectToList(element, org.emftext.language.java.variables.VariablesPackage.LOCAL_VARIABLE__ADDITIONAL_LOCAL_VARIABLES, a13_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a13_0, element); 				}
			)
			
		)
		
	)*	
;

localvariablestatement returns [org.emftext.language.java.statements.LocalVariableStatement element = null]
@init{
}
:
	(
		a0_0 = localvariable		{
			if (element == null) {
				element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createLocalVariableStatement();
			}
			if (a0_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.statements.StatementsPackage.LOCAL_VARIABLE_STATEMENT__VARIABLE), a0_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a0_0, element); 		}
	)
	
	a1 = ';' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createLocalVariableStatement();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	
;

additionallocalvariable returns [org.emftext.language.java.variables.AdditionalLocalVariable element = null]
@init{
}
:
	(
		a0 = IDENTIFIER		
		{
			if (element == null) {
				element = org.emftext.language.java.variables.VariablesFactory.eINSTANCE.createAdditionalLocalVariable();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.variables.VariablesPackage.ADDITIONAL_LOCAL_VARIABLE__NAME), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
			}
			java.lang.String resolved = (java.lang.String)resolvedObject;
			if (resolved != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.variables.VariablesPackage.ADDITIONAL_LOCAL_VARIABLE__NAME), resolved);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a0, element);
		}
	)
	
	(
		(
			a1_0 = arraydimension			{
				if (element == null) {
					element = org.emftext.language.java.variables.VariablesFactory.eINSTANCE.createAdditionalLocalVariable();
				}
				if (a1_0 != null) {
					addObjectToList(element, org.emftext.language.java.variables.VariablesPackage.ADDITIONAL_LOCAL_VARIABLE__ARRAY_DIMENSIONS_AFTER, a1_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a1_0, element); 			}
		)
		
	)*	
	(
		(
			a2 = '=' {
				if (element == null) {
					element = org.emftext.language.java.variables.VariablesFactory.eINSTANCE.createAdditionalLocalVariable();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a2, element);
			}
			
			(
				a3_0 = assignmentexpression				{
					if (element == null) {
						element = org.emftext.language.java.variables.VariablesFactory.eINSTANCE.createAdditionalLocalVariable();
					}
					if (a3_0 != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.variables.VariablesPackage.ADDITIONAL_LOCAL_VARIABLE__INITIAL_VALUE), a3_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a3_0, element); 				}
			)
			
		)
		
	)?	
;

field returns [org.emftext.language.java.members.Field element = null]
@init{
}
:
	(
		(
			a0_0 = annotationinstanceormodifier			{
				if (element == null) {
					element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createField();
				}
				if (a0_0 != null) {
					addObjectToList(element, org.emftext.language.java.members.MembersPackage.FIELD__ANNOTATIONS_AND_MODIFIERS, a0_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a0_0, element); 			}
		)
		
	)*	
	(
		a1_0 = typereference		{
			if (element == null) {
				element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createField();
			}
			if (a1_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.members.MembersPackage.FIELD__TYPE), a1_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a1_0, element); 		}
	)
	
	(
		(
			a2_0 = arraydimension			{
				if (element == null) {
					element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createField();
				}
				if (a2_0 != null) {
					addObjectToList(element, org.emftext.language.java.members.MembersPackage.FIELD__ARRAY_DIMENSIONS_BEFORE, a2_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a2_0, element); 			}
		)
		
	)*	
	(
		(
			a3 = '<' {
				if (element == null) {
					element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createField();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a3, element);
			}
			
			(
				a4_0 = typeargument				{
					if (element == null) {
						element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createField();
					}
					if (a4_0 != null) {
						addObjectToList(element, org.emftext.language.java.members.MembersPackage.FIELD__TYPE_ARGUMENTS, a4_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a4_0, element); 				}
			)
			
			(
				(
					a5 = ',' {
						if (element == null) {
							element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createField();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken)a5, element);
					}
					
					(
						a6_0 = typeargument						{
							if (element == null) {
								element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createField();
							}
							if (a6_0 != null) {
								addObjectToList(element, org.emftext.language.java.members.MembersPackage.FIELD__TYPE_ARGUMENTS, a6_0);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos(a6_0, element); 						}
					)
					
				)
				
			)*			
			a7 = '>' {
				if (element == null) {
					element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createField();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a7, element);
			}
			
		)
		
	)?	
	(
		a8 = IDENTIFIER		
		{
			if (element == null) {
				element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createField();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.members.MembersPackage.FIELD__NAME), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a8).getLine(), ((CommonToken) a8).getCharPositionInLine(), ((CommonToken) a8).getStartIndex(), ((CommonToken) a8).getStopIndex());
			}
			java.lang.String resolved = (java.lang.String)resolvedObject;
			if (resolved != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.members.MembersPackage.FIELD__NAME), resolved);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a8, element);
		}
	)
	
	(
		(
			a9_0 = arraydimension			{
				if (element == null) {
					element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createField();
				}
				if (a9_0 != null) {
					addObjectToList(element, org.emftext.language.java.members.MembersPackage.FIELD__ARRAY_DIMENSIONS_AFTER, a9_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a9_0, element); 			}
		)
		
	)*	
	(
		(
			a10 = '=' {
				if (element == null) {
					element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createField();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a10, element);
			}
			
			(
				a11_0 = assignmentexpression				{
					if (element == null) {
						element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createField();
					}
					if (a11_0 != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.members.MembersPackage.FIELD__INITIAL_VALUE), a11_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a11_0, element); 				}
			)
			
		)
		
	)?	
	(
		(
			a12 = ',' {
				if (element == null) {
					element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createField();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a12, element);
			}
			
			(
				a13_0 = additionalfield				{
					if (element == null) {
						element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createField();
					}
					if (a13_0 != null) {
						addObjectToList(element, org.emftext.language.java.members.MembersPackage.FIELD__ADDITIONAL_FIELDS, a13_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a13_0, element); 				}
			)
			
		)
		
	)*	
	a14 = ';' {
		if (element == null) {
			element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createField();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a14, element);
	}
	
;

additionalfield returns [org.emftext.language.java.members.AdditionalField element = null]
@init{
}
:
	(
		a0 = IDENTIFIER		
		{
			if (element == null) {
				element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createAdditionalField();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.members.MembersPackage.ADDITIONAL_FIELD__NAME), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
			}
			java.lang.String resolved = (java.lang.String)resolvedObject;
			if (resolved != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.members.MembersPackage.ADDITIONAL_FIELD__NAME), resolved);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a0, element);
		}
	)
	
	(
		(
			a1_0 = arraydimension			{
				if (element == null) {
					element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createAdditionalField();
				}
				if (a1_0 != null) {
					addObjectToList(element, org.emftext.language.java.members.MembersPackage.ADDITIONAL_FIELD__ARRAY_DIMENSIONS_AFTER, a1_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a1_0, element); 			}
		)
		
	)*	
	(
		(
			a2 = '=' {
				if (element == null) {
					element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createAdditionalField();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a2, element);
			}
			
			(
				a3_0 = assignmentexpression				{
					if (element == null) {
						element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createAdditionalField();
					}
					if (a3_0 != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.members.MembersPackage.ADDITIONAL_FIELD__INITIAL_VALUE), a3_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a3_0, element); 				}
			)
			
		)
		
	)?	
;

emptymember returns [org.emftext.language.java.members.EmptyMember element = null]
@init{
}
:
	a0 = ';' {
		if (element == null) {
			element = org.emftext.language.java.members.MembersFactory.eINSTANCE.createEmptyMember();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

newconstructorcall returns [org.emftext.language.java.instantiations.NewConstructorCall element = null]
@init{
}
:
	a0 = 'new' {
		if (element == null) {
			element = org.emftext.language.java.instantiations.InstantiationsFactory.eINSTANCE.createNewConstructorCall();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	(
		(
			a1 = '<' {
				if (element == null) {
					element = org.emftext.language.java.instantiations.InstantiationsFactory.eINSTANCE.createNewConstructorCall();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a1, element);
			}
			
			(
				a2_0 = typeargument				{
					if (element == null) {
						element = org.emftext.language.java.instantiations.InstantiationsFactory.eINSTANCE.createNewConstructorCall();
					}
					if (a2_0 != null) {
						addObjectToList(element, org.emftext.language.java.instantiations.InstantiationsPackage.NEW_CONSTRUCTOR_CALL__TYPE_ARGUMENTS, a2_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a2_0, element); 				}
			)
			
			(
				(
					a3 = ',' {
						if (element == null) {
							element = org.emftext.language.java.instantiations.InstantiationsFactory.eINSTANCE.createNewConstructorCall();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken)a3, element);
					}
					
					(
						a4_0 = typeargument						{
							if (element == null) {
								element = org.emftext.language.java.instantiations.InstantiationsFactory.eINSTANCE.createNewConstructorCall();
							}
							if (a4_0 != null) {
								addObjectToList(element, org.emftext.language.java.instantiations.InstantiationsPackage.NEW_CONSTRUCTOR_CALL__TYPE_ARGUMENTS, a4_0);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos(a4_0, element); 						}
					)
					
				)
				
			)*			
			a5 = '>' {
				if (element == null) {
					element = org.emftext.language.java.instantiations.InstantiationsFactory.eINSTANCE.createNewConstructorCall();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a5, element);
			}
			
		)
		
	)?	
	(
		a6_0 = typereference		{
			if (element == null) {
				element = org.emftext.language.java.instantiations.InstantiationsFactory.eINSTANCE.createNewConstructorCall();
			}
			if (a6_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.instantiations.InstantiationsPackage.NEW_CONSTRUCTOR_CALL__TYPE), a6_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a6_0, element); 		}
	)
	
	(
		(
			a7 = '<' {
				if (element == null) {
					element = org.emftext.language.java.instantiations.InstantiationsFactory.eINSTANCE.createNewConstructorCall();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a7, element);
			}
			
			(
				a8_0 = typeargument				{
					if (element == null) {
						element = org.emftext.language.java.instantiations.InstantiationsFactory.eINSTANCE.createNewConstructorCall();
					}
					if (a8_0 != null) {
						addObjectToList(element, org.emftext.language.java.instantiations.InstantiationsPackage.NEW_CONSTRUCTOR_CALL__CALL_TYPE_ARGUMENTS, a8_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a8_0, element); 				}
			)
			
			(
				(
					a9 = ',' {
						if (element == null) {
							element = org.emftext.language.java.instantiations.InstantiationsFactory.eINSTANCE.createNewConstructorCall();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken)a9, element);
					}
					
					(
						a10_0 = typeargument						{
							if (element == null) {
								element = org.emftext.language.java.instantiations.InstantiationsFactory.eINSTANCE.createNewConstructorCall();
							}
							if (a10_0 != null) {
								addObjectToList(element, org.emftext.language.java.instantiations.InstantiationsPackage.NEW_CONSTRUCTOR_CALL__CALL_TYPE_ARGUMENTS, a10_0);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos(a10_0, element); 						}
					)
					
				)
				
			)*			
			a11 = '>' {
				if (element == null) {
					element = org.emftext.language.java.instantiations.InstantiationsFactory.eINSTANCE.createNewConstructorCall();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a11, element);
			}
			
		)
		
	)?	
	a12 = '(' {
		if (element == null) {
			element = org.emftext.language.java.instantiations.InstantiationsFactory.eINSTANCE.createNewConstructorCall();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a12, element);
	}
	
	(
		(
			(
				a13_0 = assignmentexpression				{
					if (element == null) {
						element = org.emftext.language.java.instantiations.InstantiationsFactory.eINSTANCE.createNewConstructorCall();
					}
					if (a13_0 != null) {
						addObjectToList(element, org.emftext.language.java.instantiations.InstantiationsPackage.NEW_CONSTRUCTOR_CALL__ARGUMENTS, a13_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a13_0, element); 				}
			)
			
			(
				(
					a14 = ',' {
						if (element == null) {
							element = org.emftext.language.java.instantiations.InstantiationsFactory.eINSTANCE.createNewConstructorCall();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken)a14, element);
					}
					
					(
						a15_0 = assignmentexpression						{
							if (element == null) {
								element = org.emftext.language.java.instantiations.InstantiationsFactory.eINSTANCE.createNewConstructorCall();
							}
							if (a15_0 != null) {
								addObjectToList(element, org.emftext.language.java.instantiations.InstantiationsPackage.NEW_CONSTRUCTOR_CALL__ARGUMENTS, a15_0);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos(a15_0, element); 						}
					)
					
				)
				
			)*			
		)
		
	)?	
	a16 = ')' {
		if (element == null) {
			element = org.emftext.language.java.instantiations.InstantiationsFactory.eINSTANCE.createNewConstructorCall();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a16, element);
	}
	
	(
		(
			a17_0 = anonymousclass			{
				if (element == null) {
					element = org.emftext.language.java.instantiations.InstantiationsFactory.eINSTANCE.createNewConstructorCall();
				}
				if (a17_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.instantiations.InstantiationsPackage.NEW_CONSTRUCTOR_CALL__ANONYMOUS_CLASS), a17_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a17_0, element); 			}
		)
		
	)?	
	(
		(
			a18 = '.' {
				if (element == null) {
					element = org.emftext.language.java.instantiations.InstantiationsFactory.eINSTANCE.createNewConstructorCall();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a18, element);
			}
			
			(
				a19_0 = reference				{
					if (element == null) {
						element = org.emftext.language.java.instantiations.InstantiationsFactory.eINSTANCE.createNewConstructorCall();
					}
					if (a19_0 != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.instantiations.InstantiationsPackage.NEW_CONSTRUCTOR_CALL__NEXT), a19_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a19_0, element); 				}
			)
			
		)
		
	)?	
;

explicitconstructorcall returns [org.emftext.language.java.instantiations.ExplicitConstructorCall element = null]
@init{
}
:
	(
		(
			a0 = '<' {
				if (element == null) {
					element = org.emftext.language.java.instantiations.InstantiationsFactory.eINSTANCE.createExplicitConstructorCall();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a0, element);
			}
			
			(
				a1_0 = typeargument				{
					if (element == null) {
						element = org.emftext.language.java.instantiations.InstantiationsFactory.eINSTANCE.createExplicitConstructorCall();
					}
					if (a1_0 != null) {
						addObjectToList(element, org.emftext.language.java.instantiations.InstantiationsPackage.EXPLICIT_CONSTRUCTOR_CALL__TYPE_ARGUMENTS, a1_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a1_0, element); 				}
			)
			
			(
				(
					a2 = ',' {
						if (element == null) {
							element = org.emftext.language.java.instantiations.InstantiationsFactory.eINSTANCE.createExplicitConstructorCall();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken)a2, element);
					}
					
					(
						a3_0 = typeargument						{
							if (element == null) {
								element = org.emftext.language.java.instantiations.InstantiationsFactory.eINSTANCE.createExplicitConstructorCall();
							}
							if (a3_0 != null) {
								addObjectToList(element, org.emftext.language.java.instantiations.InstantiationsPackage.EXPLICIT_CONSTRUCTOR_CALL__TYPE_ARGUMENTS, a3_0);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos(a3_0, element); 						}
					)
					
				)
				
			)*			
			a4 = '>' {
				if (element == null) {
					element = org.emftext.language.java.instantiations.InstantiationsFactory.eINSTANCE.createExplicitConstructorCall();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a4, element);
			}
			
		)
		
	)?	
	(
		a5_0 = self		{
			if (element == null) {
				element = org.emftext.language.java.instantiations.InstantiationsFactory.eINSTANCE.createExplicitConstructorCall();
			}
			if (a5_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.instantiations.InstantiationsPackage.EXPLICIT_CONSTRUCTOR_CALL__CALL_TARGET), a5_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a5_0, element); 		}
	)
	
	a6 = '(' {
		if (element == null) {
			element = org.emftext.language.java.instantiations.InstantiationsFactory.eINSTANCE.createExplicitConstructorCall();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a6, element);
	}
	
	(
		(
			(
				a7_0 = assignmentexpression				{
					if (element == null) {
						element = org.emftext.language.java.instantiations.InstantiationsFactory.eINSTANCE.createExplicitConstructorCall();
					}
					if (a7_0 != null) {
						addObjectToList(element, org.emftext.language.java.instantiations.InstantiationsPackage.EXPLICIT_CONSTRUCTOR_CALL__ARGUMENTS, a7_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a7_0, element); 				}
			)
			
			(
				(
					a8 = ',' {
						if (element == null) {
							element = org.emftext.language.java.instantiations.InstantiationsFactory.eINSTANCE.createExplicitConstructorCall();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken)a8, element);
					}
					
					(
						a9_0 = assignmentexpression						{
							if (element == null) {
								element = org.emftext.language.java.instantiations.InstantiationsFactory.eINSTANCE.createExplicitConstructorCall();
							}
							if (a9_0 != null) {
								addObjectToList(element, org.emftext.language.java.instantiations.InstantiationsPackage.EXPLICIT_CONSTRUCTOR_CALL__ARGUMENTS, a9_0);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos(a9_0, element); 						}
					)
					
				)
				
			)*			
		)
		
	)?	
	a10 = ')' {
		if (element == null) {
			element = org.emftext.language.java.instantiations.InstantiationsFactory.eINSTANCE.createExplicitConstructorCall();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a10, element);
	}
	
	(
		(
			a11 = '.' {
				if (element == null) {
					element = org.emftext.language.java.instantiations.InstantiationsFactory.eINSTANCE.createExplicitConstructorCall();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a11, element);
			}
			
			(
				a12_0 = reference				{
					if (element == null) {
						element = org.emftext.language.java.instantiations.InstantiationsFactory.eINSTANCE.createExplicitConstructorCall();
					}
					if (a12_0 != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.instantiations.InstantiationsPackage.EXPLICIT_CONSTRUCTOR_CALL__NEXT), a12_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a12_0, element); 				}
			)
			
		)
		
	)?	
;

arrayinstantiationbyvalues returns [org.emftext.language.java.arrays.ArrayInstantiationByValues element = null]
@init{
}
:
	(
		(
			a0 = 'new' {
				if (element == null) {
					element = org.emftext.language.java.arrays.ArraysFactory.eINSTANCE.createArrayInstantiationByValues();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a0, element);
			}
			
			(
				a1_0 = typereference				{
					if (element == null) {
						element = org.emftext.language.java.arrays.ArraysFactory.eINSTANCE.createArrayInstantiationByValues();
					}
					if (a1_0 != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.arrays.ArraysPackage.ARRAY_INSTANTIATION_BY_VALUES__TYPE), a1_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a1_0, element); 				}
			)
			
			(
				(
					a2_0 = arraydimension					{
						if (element == null) {
							element = org.emftext.language.java.arrays.ArraysFactory.eINSTANCE.createArrayInstantiationByValues();
						}
						if (a2_0 != null) {
							addObjectToList(element, org.emftext.language.java.arrays.ArraysPackage.ARRAY_INSTANTIATION_BY_VALUES__ARRAY_DIMENSIONS_BEFORE, a2_0);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos(a2_0, element); 					}
				)
				
			)+			
		)
		
	)?	
	(
		a3_0 = arrayinitializer		{
			if (element == null) {
				element = org.emftext.language.java.arrays.ArraysFactory.eINSTANCE.createArrayInstantiationByValues();
			}
			if (a3_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.arrays.ArraysPackage.ARRAY_INSTANTIATION_BY_VALUES__ARRAY_INITIALIZER), a3_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a3_0, element); 		}
	)
	
	(
		(
			a4_0 = arrayselector			{
				if (element == null) {
					element = org.emftext.language.java.arrays.ArraysFactory.eINSTANCE.createArrayInstantiationByValues();
				}
				if (a4_0 != null) {
					addObjectToList(element, org.emftext.language.java.arrays.ArraysPackage.ARRAY_INSTANTIATION_BY_VALUES__ARRAY_SELECTORS, a4_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a4_0, element); 			}
		)
		
	)*	
	(
		(
			a5 = '.' {
				if (element == null) {
					element = org.emftext.language.java.arrays.ArraysFactory.eINSTANCE.createArrayInstantiationByValues();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a5, element);
			}
			
			(
				a6_0 = reference				{
					if (element == null) {
						element = org.emftext.language.java.arrays.ArraysFactory.eINSTANCE.createArrayInstantiationByValues();
					}
					if (a6_0 != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.arrays.ArraysPackage.ARRAY_INSTANTIATION_BY_VALUES__NEXT), a6_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a6_0, element); 				}
			)
			
		)
		
	)?	
;

arrayinstantiationbysize returns [org.emftext.language.java.arrays.ArrayInstantiationBySize element = null]
@init{
}
:
	a0 = 'new' {
		if (element == null) {
			element = org.emftext.language.java.arrays.ArraysFactory.eINSTANCE.createArrayInstantiationBySize();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	(
		a1_0 = typereference		{
			if (element == null) {
				element = org.emftext.language.java.arrays.ArraysFactory.eINSTANCE.createArrayInstantiationBySize();
			}
			if (a1_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.arrays.ArraysPackage.ARRAY_INSTANTIATION_BY_SIZE__TYPE), a1_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a1_0, element); 		}
	)
	
	(
		(
			a2 = '[' {
				if (element == null) {
					element = org.emftext.language.java.arrays.ArraysFactory.eINSTANCE.createArrayInstantiationBySize();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a2, element);
			}
			
			(
				a3_0 = assignmentexpression				{
					if (element == null) {
						element = org.emftext.language.java.arrays.ArraysFactory.eINSTANCE.createArrayInstantiationBySize();
					}
					if (a3_0 != null) {
						addObjectToList(element, org.emftext.language.java.arrays.ArraysPackage.ARRAY_INSTANTIATION_BY_SIZE__SIZES, a3_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a3_0, element); 				}
			)
			
			a4 = ']' {
				if (element == null) {
					element = org.emftext.language.java.arrays.ArraysFactory.eINSTANCE.createArrayInstantiationBySize();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a4, element);
			}
			
		)
		
	)+	
	(
		(
			a5_0 = arraydimension			{
				if (element == null) {
					element = org.emftext.language.java.arrays.ArraysFactory.eINSTANCE.createArrayInstantiationBySize();
				}
				if (a5_0 != null) {
					addObjectToList(element, org.emftext.language.java.arrays.ArraysPackage.ARRAY_INSTANTIATION_BY_SIZE__ARRAY_DIMENSIONS_BEFORE, a5_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a5_0, element); 			}
		)
		
	)*	
	(
		(
			a6 = '.' {
				if (element == null) {
					element = org.emftext.language.java.arrays.ArraysFactory.eINSTANCE.createArrayInstantiationBySize();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a6, element);
			}
			
			(
				a7_0 = reference				{
					if (element == null) {
						element = org.emftext.language.java.arrays.ArraysFactory.eINSTANCE.createArrayInstantiationBySize();
					}
					if (a7_0 != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.arrays.ArraysPackage.ARRAY_INSTANTIATION_BY_SIZE__NEXT), a7_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a7_0, element); 				}
			)
			
		)
		
	)?	
;

arrayinitializer returns [org.emftext.language.java.arrays.ArrayInitializer element = null]
@init{
}
:
	a0 = '{' {
		if (element == null) {
			element = org.emftext.language.java.arrays.ArraysFactory.eINSTANCE.createArrayInitializer();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	(
		(
			(
				a1_0 = assignmentexpression				{
					if (element == null) {
						element = org.emftext.language.java.arrays.ArraysFactory.eINSTANCE.createArrayInitializer();
					}
					if (a1_0 != null) {
						addObjectToList(element, org.emftext.language.java.arrays.ArraysPackage.ARRAY_INITIALIZER__INITIAL_VALUES, a1_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a1_0, element); 				}
				|				a1_1 = arrayinitializer				{
					if (element == null) {
						element = org.emftext.language.java.arrays.ArraysFactory.eINSTANCE.createArrayInitializer();
					}
					if (a1_1 != null) {
						addObjectToList(element, org.emftext.language.java.arrays.ArraysPackage.ARRAY_INITIALIZER__INITIAL_VALUES, a1_1);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a1_1, element); 				}
			)
			
			(
				(
					a2 = ',' {
						if (element == null) {
							element = org.emftext.language.java.arrays.ArraysFactory.eINSTANCE.createArrayInitializer();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken)a2, element);
					}
					
					(
						a3_0 = assignmentexpression						{
							if (element == null) {
								element = org.emftext.language.java.arrays.ArraysFactory.eINSTANCE.createArrayInitializer();
							}
							if (a3_0 != null) {
								addObjectToList(element, org.emftext.language.java.arrays.ArraysPackage.ARRAY_INITIALIZER__INITIAL_VALUES, a3_0);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos(a3_0, element); 						}
						|						a3_1 = arrayinitializer						{
							if (element == null) {
								element = org.emftext.language.java.arrays.ArraysFactory.eINSTANCE.createArrayInitializer();
							}
							if (a3_1 != null) {
								addObjectToList(element, org.emftext.language.java.arrays.ArraysPackage.ARRAY_INITIALIZER__INITIAL_VALUES, a3_1);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos(a3_1, element); 						}
					)
					
				)
				
			)*			
		)
		
	)?	
	(
		(
			a4 = ',' {
				if (element == null) {
					element = org.emftext.language.java.arrays.ArraysFactory.eINSTANCE.createArrayInitializer();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a4, element);
			}
			
		)
		
	)?	
	a5 = '}' {
		if (element == null) {
			element = org.emftext.language.java.arrays.ArraysFactory.eINSTANCE.createArrayInitializer();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a5, element);
	}
	
;

arrayselector returns [org.emftext.language.java.arrays.ArraySelector element = null]
@init{
}
:
	a0 = '[' {
		if (element == null) {
			element = org.emftext.language.java.arrays.ArraysFactory.eINSTANCE.createArraySelector();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	(
		(
			a1_0 = assignmentexpression			{
				if (element == null) {
					element = org.emftext.language.java.arrays.ArraysFactory.eINSTANCE.createArraySelector();
				}
				if (a1_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.arrays.ArraysPackage.ARRAY_SELECTOR__POSITION), a1_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a1_0, element); 			}
		)
		
	)?	
	a2 = ']' {
		if (element == null) {
			element = org.emftext.language.java.arrays.ArraysFactory.eINSTANCE.createArraySelector();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	
;

namespaceclassifierreference returns [org.emftext.language.java.types.NamespaceClassifierReference element = null]
@init{
}
:
	(
		(
			(
				a0 = IDENTIFIER				
				{
					if (element == null) {
						element = org.emftext.language.java.types.TypesFactory.eINSTANCE.createNamespaceClassifierReference();
					}
					org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
					tokenResolver.setOptions(getOptions());
					org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.types.TypesPackage.NAMESPACE_CLASSIFIER_REFERENCE__NAMESPACES), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						getResource().addError(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String)resolvedObject;
					if (resolved != null) {
						addObjectToList(element, org.emftext.language.java.types.TypesPackage.NAMESPACE_CLASSIFIER_REFERENCE__NAMESPACES, resolved);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((CommonToken) a0, element);
				}
			)
			
			a1 = '.' {
				if (element == null) {
					element = org.emftext.language.java.types.TypesFactory.eINSTANCE.createNamespaceClassifierReference();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a1, element);
			}
			
		)
		
	)*	
	(
		(
			(
				a2_0 = classifierreference				{
					if (element == null) {
						element = org.emftext.language.java.types.TypesFactory.eINSTANCE.createNamespaceClassifierReference();
					}
					if (a2_0 != null) {
						addObjectToList(element, org.emftext.language.java.types.TypesPackage.NAMESPACE_CLASSIFIER_REFERENCE__CLASSIFIER_REFERENCES, a2_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a2_0, element); 				}
			)
			
			a3 = '.' {
				if (element == null) {
					element = org.emftext.language.java.types.TypesFactory.eINSTANCE.createNamespaceClassifierReference();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a3, element);
			}
			
		)
		
	)*	
	(
		a4_0 = classifierreference		{
			if (element == null) {
				element = org.emftext.language.java.types.TypesFactory.eINSTANCE.createNamespaceClassifierReference();
			}
			if (a4_0 != null) {
				addObjectToList(element, org.emftext.language.java.types.TypesPackage.NAMESPACE_CLASSIFIER_REFERENCE__CLASSIFIER_REFERENCES, a4_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a4_0, element); 		}
	)
	
;

classifierreference returns [org.emftext.language.java.types.ClassifierReference element = null]
@init{
}
:
	(
		a0 = IDENTIFIER		
		{
			if (element == null) {
				element = org.emftext.language.java.types.TypesFactory.eINSTANCE.createClassifierReference();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.types.TypesPackage.CLASSIFIER_REFERENCE__TARGET), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
			}
			String resolved = (String) resolvedObject;
			org.emftext.language.java.classifiers.Class proxy = org.emftext.language.java.classifiers.ClassifiersFactory.eINSTANCE.createClass();
			collectHiddenTokens(element);
			getResource().registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.language.java.types.ClassifierReference, org.emftext.language.java.classifiers.Classifier>(((org.emftext.language.java.javabehavior4uml.resource.javabehavior.JavabehaviorReferenceResolverSwitch) resource.getReferenceResolverSwitch()).getClassifierReferenceTargetReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.java.types.TypesPackage.CLASSIFIER_REFERENCE__TARGET), resolved, proxy);
			if (proxy != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.types.TypesPackage.CLASSIFIER_REFERENCE__TARGET), proxy);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a0, element);
			copyLocalizationInfos((CommonToken) a0, proxy);
		}
	)
	
	(
		(
			a1 = '<' {
				if (element == null) {
					element = org.emftext.language.java.types.TypesFactory.eINSTANCE.createClassifierReference();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a1, element);
			}
			
			(
				a2_0 = typeargument				{
					if (element == null) {
						element = org.emftext.language.java.types.TypesFactory.eINSTANCE.createClassifierReference();
					}
					if (a2_0 != null) {
						addObjectToList(element, org.emftext.language.java.types.TypesPackage.CLASSIFIER_REFERENCE__TYPE_ARGUMENTS, a2_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a2_0, element); 				}
			)
			
			(
				(
					a3 = ',' {
						if (element == null) {
							element = org.emftext.language.java.types.TypesFactory.eINSTANCE.createClassifierReference();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken)a3, element);
					}
					
					(
						a4_0 = typeargument						{
							if (element == null) {
								element = org.emftext.language.java.types.TypesFactory.eINSTANCE.createClassifierReference();
							}
							if (a4_0 != null) {
								addObjectToList(element, org.emftext.language.java.types.TypesPackage.CLASSIFIER_REFERENCE__TYPE_ARGUMENTS, a4_0);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos(a4_0, element); 						}
					)
					
				)
				
			)*			
			a5 = '>' {
				if (element == null) {
					element = org.emftext.language.java.types.TypesFactory.eINSTANCE.createClassifierReference();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a5, element);
			}
			
		)
		
	)?	
;

methodcall returns [org.emftext.language.java.references.MethodCall element = null]
@init{
}
:
	(
		(
			a0 = '<' {
				if (element == null) {
					element = org.emftext.language.java.references.ReferencesFactory.eINSTANCE.createMethodCall();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a0, element);
			}
			
			(
				a1_0 = typeargument				{
					if (element == null) {
						element = org.emftext.language.java.references.ReferencesFactory.eINSTANCE.createMethodCall();
					}
					if (a1_0 != null) {
						addObjectToList(element, org.emftext.language.java.references.ReferencesPackage.METHOD_CALL__CALL_TYPE_ARGUMENTS, a1_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a1_0, element); 				}
			)
			
			(
				(
					a2 = ',' {
						if (element == null) {
							element = org.emftext.language.java.references.ReferencesFactory.eINSTANCE.createMethodCall();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken)a2, element);
					}
					
					(
						a3_0 = typeargument						{
							if (element == null) {
								element = org.emftext.language.java.references.ReferencesFactory.eINSTANCE.createMethodCall();
							}
							if (a3_0 != null) {
								addObjectToList(element, org.emftext.language.java.references.ReferencesPackage.METHOD_CALL__CALL_TYPE_ARGUMENTS, a3_0);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos(a3_0, element); 						}
					)
					
				)
				
			)*			
			a4 = '>' {
				if (element == null) {
					element = org.emftext.language.java.references.ReferencesFactory.eINSTANCE.createMethodCall();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a4, element);
			}
			
		)
		
	)?	
	(
		a5 = IDENTIFIER		
		{
			if (element == null) {
				element = org.emftext.language.java.references.ReferencesFactory.eINSTANCE.createMethodCall();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.references.ReferencesPackage.METHOD_CALL__TARGET), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a5).getLine(), ((CommonToken) a5).getCharPositionInLine(), ((CommonToken) a5).getStartIndex(), ((CommonToken) a5).getStopIndex());
			}
			String resolved = (String) resolvedObject;
			org.emftext.language.java.annotations.AnnotationAttribute proxy = org.emftext.language.java.annotations.AnnotationsFactory.eINSTANCE.createAnnotationAttribute();
			collectHiddenTokens(element);
			getResource().registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.language.java.references.ElementReference, org.emftext.language.java.references.ReferenceableElement>(((org.emftext.language.java.javabehavior4uml.resource.javabehavior.JavabehaviorReferenceResolverSwitch) resource.getReferenceResolverSwitch()).getElementReferenceTargetReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.java.references.ReferencesPackage.METHOD_CALL__TARGET), resolved, proxy);
			if (proxy != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.references.ReferencesPackage.METHOD_CALL__TARGET), proxy);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a5, element);
			copyLocalizationInfos((CommonToken) a5, proxy);
		}
	)
	
	(
		(
			a6 = '<' {
				if (element == null) {
					element = org.emftext.language.java.references.ReferencesFactory.eINSTANCE.createMethodCall();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a6, element);
			}
			
			(
				a7_0 = typeargument				{
					if (element == null) {
						element = org.emftext.language.java.references.ReferencesFactory.eINSTANCE.createMethodCall();
					}
					if (a7_0 != null) {
						addObjectToList(element, org.emftext.language.java.references.ReferencesPackage.METHOD_CALL__TYPE_ARGUMENTS, a7_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a7_0, element); 				}
			)
			
			(
				(
					a8 = ',' {
						if (element == null) {
							element = org.emftext.language.java.references.ReferencesFactory.eINSTANCE.createMethodCall();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken)a8, element);
					}
					
					(
						a9_0 = typeargument						{
							if (element == null) {
								element = org.emftext.language.java.references.ReferencesFactory.eINSTANCE.createMethodCall();
							}
							if (a9_0 != null) {
								addObjectToList(element, org.emftext.language.java.references.ReferencesPackage.METHOD_CALL__TYPE_ARGUMENTS, a9_0);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos(a9_0, element); 						}
					)
					
				)
				
			)*			
			a10 = '>' {
				if (element == null) {
					element = org.emftext.language.java.references.ReferencesFactory.eINSTANCE.createMethodCall();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a10, element);
			}
			
		)
		
	)?	
	a11 = '(' {
		if (element == null) {
			element = org.emftext.language.java.references.ReferencesFactory.eINSTANCE.createMethodCall();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a11, element);
	}
	
	(
		(
			(
				a12_0 = assignmentexpression				{
					if (element == null) {
						element = org.emftext.language.java.references.ReferencesFactory.eINSTANCE.createMethodCall();
					}
					if (a12_0 != null) {
						addObjectToList(element, org.emftext.language.java.references.ReferencesPackage.METHOD_CALL__ARGUMENTS, a12_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a12_0, element); 				}
			)
			
			(
				(
					a13 = ',' {
						if (element == null) {
							element = org.emftext.language.java.references.ReferencesFactory.eINSTANCE.createMethodCall();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken)a13, element);
					}
					
					(
						a14_0 = assignmentexpression						{
							if (element == null) {
								element = org.emftext.language.java.references.ReferencesFactory.eINSTANCE.createMethodCall();
							}
							if (a14_0 != null) {
								addObjectToList(element, org.emftext.language.java.references.ReferencesPackage.METHOD_CALL__ARGUMENTS, a14_0);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos(a14_0, element); 						}
					)
					
				)
				
			)*			
		)
		
	)?	
	a15 = ')' {
		if (element == null) {
			element = org.emftext.language.java.references.ReferencesFactory.eINSTANCE.createMethodCall();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a15, element);
	}
	
	(
		(
			a16_0 = arrayselector			{
				if (element == null) {
					element = org.emftext.language.java.references.ReferencesFactory.eINSTANCE.createMethodCall();
				}
				if (a16_0 != null) {
					addObjectToList(element, org.emftext.language.java.references.ReferencesPackage.METHOD_CALL__ARRAY_SELECTORS, a16_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a16_0, element); 			}
		)
		
	)*	
	(
		(
			a17 = '.' {
				if (element == null) {
					element = org.emftext.language.java.references.ReferencesFactory.eINSTANCE.createMethodCall();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a17, element);
			}
			
			(
				a18_0 = reference				{
					if (element == null) {
						element = org.emftext.language.java.references.ReferencesFactory.eINSTANCE.createMethodCall();
					}
					if (a18_0 != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.references.ReferencesPackage.METHOD_CALL__NEXT), a18_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a18_0, element); 				}
			)
			
		)
		
	)?	
;

identifierreference returns [org.emftext.language.java.references.IdentifierReference element = null]
@init{
}
:
	(
		a0 = IDENTIFIER		
		{
			if (element == null) {
				element = org.emftext.language.java.references.ReferencesFactory.eINSTANCE.createIdentifierReference();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.references.ReferencesPackage.IDENTIFIER_REFERENCE__TARGET), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
			}
			String resolved = (String) resolvedObject;
			org.emftext.language.java.annotations.AnnotationAttribute proxy = org.emftext.language.java.annotations.AnnotationsFactory.eINSTANCE.createAnnotationAttribute();
			collectHiddenTokens(element);
			getResource().registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.language.java.references.ElementReference, org.emftext.language.java.references.ReferenceableElement>(((org.emftext.language.java.javabehavior4uml.resource.javabehavior.JavabehaviorReferenceResolverSwitch) resource.getReferenceResolverSwitch()).getElementReferenceTargetReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.java.references.ReferencesPackage.IDENTIFIER_REFERENCE__TARGET), resolved, proxy);
			if (proxy != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.references.ReferencesPackage.IDENTIFIER_REFERENCE__TARGET), proxy);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a0, element);
			copyLocalizationInfos((CommonToken) a0, proxy);
		}
	)
	
	(
		(
			a1 = '<' {
				if (element == null) {
					element = org.emftext.language.java.references.ReferencesFactory.eINSTANCE.createIdentifierReference();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a1, element);
			}
			
			(
				a2_0 = typeargument				{
					if (element == null) {
						element = org.emftext.language.java.references.ReferencesFactory.eINSTANCE.createIdentifierReference();
					}
					if (a2_0 != null) {
						addObjectToList(element, org.emftext.language.java.references.ReferencesPackage.IDENTIFIER_REFERENCE__TYPE_ARGUMENTS, a2_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a2_0, element); 				}
			)
			
			(
				(
					a3 = ',' {
						if (element == null) {
							element = org.emftext.language.java.references.ReferencesFactory.eINSTANCE.createIdentifierReference();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken)a3, element);
					}
					
					(
						a4_0 = typeargument						{
							if (element == null) {
								element = org.emftext.language.java.references.ReferencesFactory.eINSTANCE.createIdentifierReference();
							}
							if (a4_0 != null) {
								addObjectToList(element, org.emftext.language.java.references.ReferencesPackage.IDENTIFIER_REFERENCE__TYPE_ARGUMENTS, a4_0);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos(a4_0, element); 						}
					)
					
				)
				
			)*			
			a5 = '>' {
				if (element == null) {
					element = org.emftext.language.java.references.ReferencesFactory.eINSTANCE.createIdentifierReference();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a5, element);
			}
			
		)
		
	)?	
	(
		(
			a6_0 = arrayselector			{
				if (element == null) {
					element = org.emftext.language.java.references.ReferencesFactory.eINSTANCE.createIdentifierReference();
				}
				if (a6_0 != null) {
					addObjectToList(element, org.emftext.language.java.references.ReferencesPackage.IDENTIFIER_REFERENCE__ARRAY_SELECTORS, a6_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a6_0, element); 			}
		)
		
	)*	
	(
		(
			a7 = '.' {
				if (element == null) {
					element = org.emftext.language.java.references.ReferencesFactory.eINSTANCE.createIdentifierReference();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a7, element);
			}
			
			(
				a8_0 = reference				{
					if (element == null) {
						element = org.emftext.language.java.references.ReferencesFactory.eINSTANCE.createIdentifierReference();
					}
					if (a8_0 != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.references.ReferencesPackage.IDENTIFIER_REFERENCE__NEXT), a8_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a8_0, element); 				}
			)
			
		)
		
	)?	
;

reflectiveclassreference returns [org.emftext.language.java.references.ReflectiveClassReference element = null]
@init{
}
:
	a0 = 'class' {
		if (element == null) {
			element = org.emftext.language.java.references.ReferencesFactory.eINSTANCE.createReflectiveClassReference();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	(
		(
			a1 = '.' {
				if (element == null) {
					element = org.emftext.language.java.references.ReferencesFactory.eINSTANCE.createReflectiveClassReference();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a1, element);
			}
			
			(
				a2_0 = reference				{
					if (element == null) {
						element = org.emftext.language.java.references.ReferencesFactory.eINSTANCE.createReflectiveClassReference();
					}
					if (a2_0 != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.references.ReferencesPackage.REFLECTIVE_CLASS_REFERENCE__NEXT), a2_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a2_0, element); 				}
			)
			
		)
		
	)?	
;

selfreference returns [org.emftext.language.java.references.SelfReference element = null]
@init{
}
:
	(
		a0_0 = self		{
			if (element == null) {
				element = org.emftext.language.java.references.ReferencesFactory.eINSTANCE.createSelfReference();
			}
			if (a0_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.references.ReferencesPackage.SELF_REFERENCE__SELF), a0_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a0_0, element); 		}
	)
	
	(
		(
			a1 = '.' {
				if (element == null) {
					element = org.emftext.language.java.references.ReferencesFactory.eINSTANCE.createSelfReference();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a1, element);
			}
			
			(
				a2_0 = reference				{
					if (element == null) {
						element = org.emftext.language.java.references.ReferencesFactory.eINSTANCE.createSelfReference();
					}
					if (a2_0 != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.references.ReferencesPackage.SELF_REFERENCE__NEXT), a2_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a2_0, element); 				}
			)
			
		)
		
	)?	
;

primitivetypereference returns [org.emftext.language.java.references.PrimitiveTypeReference element = null]
@init{
}
:
	(
		a0_0 = primitivetype		{
			if (element == null) {
				element = org.emftext.language.java.references.ReferencesFactory.eINSTANCE.createPrimitiveTypeReference();
			}
			if (a0_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.references.ReferencesPackage.PRIMITIVE_TYPE_REFERENCE__TYPE), a0_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a0_0, element); 		}
	)
	
	(
		(
			a1_0 = arrayselector			{
				if (element == null) {
					element = org.emftext.language.java.references.ReferencesFactory.eINSTANCE.createPrimitiveTypeReference();
				}
				if (a1_0 != null) {
					addObjectToList(element, org.emftext.language.java.references.ReferencesPackage.PRIMITIVE_TYPE_REFERENCE__ARRAY_SELECTORS, a1_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a1_0, element); 			}
		)
		
	)*	
	(
		(
			a2 = '.' {
				if (element == null) {
					element = org.emftext.language.java.references.ReferencesFactory.eINSTANCE.createPrimitiveTypeReference();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a2, element);
			}
			
			(
				a3_0 = reference				{
					if (element == null) {
						element = org.emftext.language.java.references.ReferencesFactory.eINSTANCE.createPrimitiveTypeReference();
					}
					if (a3_0 != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.references.ReferencesPackage.PRIMITIVE_TYPE_REFERENCE__NEXT), a3_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a3_0, element); 				}
			)
			
		)
		
	)?	
;

keywordthis returns [org.emftext.language.java.literals.This element = null]
@init{
}
:
	a0 = 'this' {
		if (element == null) {
			element = org.emftext.language.java.literals.LiteralsFactory.eINSTANCE.createThis();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

keywordsuper returns [org.emftext.language.java.literals.Super element = null]
@init{
}
:
	a0 = 'super' {
		if (element == null) {
			element = org.emftext.language.java.literals.LiteralsFactory.eINSTANCE.createSuper();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

stringreference returns [org.emftext.language.java.references.StringReference element = null]
@init{
}
:
	(
		a0 = STRING_LITERAL		
		{
			if (element == null) {
				element = org.emftext.language.java.references.ReferencesFactory.eINSTANCE.createStringReference();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("STRING_LITERAL");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.references.ReferencesPackage.STRING_REFERENCE__VALUE), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
			}
			java.lang.String resolved = (java.lang.String)resolvedObject;
			if (resolved != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.references.ReferencesPackage.STRING_REFERENCE__VALUE), resolved);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a0, element);
		}
	)
	
	(
		(
			a1 = '.' {
				if (element == null) {
					element = org.emftext.language.java.references.ReferencesFactory.eINSTANCE.createStringReference();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a1, element);
			}
			
			(
				a2_0 = reference				{
					if (element == null) {
						element = org.emftext.language.java.references.ReferencesFactory.eINSTANCE.createStringReference();
					}
					if (a2_0 != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.references.ReferencesPackage.STRING_REFERENCE__NEXT), a2_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a2_0, element); 				}
			)
			
		)
		
	)?	
;

qualifiedtypeargument returns [org.emftext.language.java.generics.QualifiedTypeArgument element = null]
@init{
}
:
	(
		a0_0 = typereference		{
			if (element == null) {
				element = org.emftext.language.java.generics.GenericsFactory.eINSTANCE.createQualifiedTypeArgument();
			}
			if (a0_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.generics.GenericsPackage.QUALIFIED_TYPE_ARGUMENT__TYPE), a0_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a0_0, element); 		}
	)
	
	(
		(
			a1_0 = arraydimension			{
				if (element == null) {
					element = org.emftext.language.java.generics.GenericsFactory.eINSTANCE.createQualifiedTypeArgument();
				}
				if (a1_0 != null) {
					addObjectToList(element, org.emftext.language.java.generics.GenericsPackage.QUALIFIED_TYPE_ARGUMENT__ARRAY_DIMENSIONS_BEFORE, a1_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a1_0, element); 			}
		)
		
	)*	
;

unknowntypeargument returns [org.emftext.language.java.generics.UnknownTypeArgument element = null]
@init{
}
:
	a0 = '?' {
		if (element == null) {
			element = org.emftext.language.java.generics.GenericsFactory.eINSTANCE.createUnknownTypeArgument();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

extendstypeargument returns [org.emftext.language.java.generics.ExtendsTypeArgument element = null]
@init{
}
:
	a0 = '?' {
		if (element == null) {
			element = org.emftext.language.java.generics.GenericsFactory.eINSTANCE.createExtendsTypeArgument();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	a1 = 'extends' {
		if (element == null) {
			element = org.emftext.language.java.generics.GenericsFactory.eINSTANCE.createExtendsTypeArgument();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	
	(
		a2_0 = typereference		{
			if (element == null) {
				element = org.emftext.language.java.generics.GenericsFactory.eINSTANCE.createExtendsTypeArgument();
			}
			if (a2_0 != null) {
				addObjectToList(element, org.emftext.language.java.generics.GenericsPackage.EXTENDS_TYPE_ARGUMENT__EXTEND_TYPES, a2_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a2_0, element); 		}
	)
	
	(
		(
			a3 = '&' {
				if (element == null) {
					element = org.emftext.language.java.generics.GenericsFactory.eINSTANCE.createExtendsTypeArgument();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a3, element);
			}
			
			(
				a4_0 = typereference				{
					if (element == null) {
						element = org.emftext.language.java.generics.GenericsFactory.eINSTANCE.createExtendsTypeArgument();
					}
					if (a4_0 != null) {
						addObjectToList(element, org.emftext.language.java.generics.GenericsPackage.EXTENDS_TYPE_ARGUMENT__EXTEND_TYPES, a4_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a4_0, element); 				}
			)
			
		)
		
	)*	
	(
		(
			a5_0 = arraydimension			{
				if (element == null) {
					element = org.emftext.language.java.generics.GenericsFactory.eINSTANCE.createExtendsTypeArgument();
				}
				if (a5_0 != null) {
					addObjectToList(element, org.emftext.language.java.generics.GenericsPackage.EXTENDS_TYPE_ARGUMENT__ARRAY_DIMENSIONS_BEFORE, a5_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a5_0, element); 			}
		)
		
	)*	
;

supertypeargument returns [org.emftext.language.java.generics.SuperTypeArgument element = null]
@init{
}
:
	a0 = '?' {
		if (element == null) {
			element = org.emftext.language.java.generics.GenericsFactory.eINSTANCE.createSuperTypeArgument();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	a1 = 'super' {
		if (element == null) {
			element = org.emftext.language.java.generics.GenericsFactory.eINSTANCE.createSuperTypeArgument();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	
	(
		a2_0 = typereference		{
			if (element == null) {
				element = org.emftext.language.java.generics.GenericsFactory.eINSTANCE.createSuperTypeArgument();
			}
			if (a2_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.generics.GenericsPackage.SUPER_TYPE_ARGUMENT__SUPER_TYPE), a2_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a2_0, element); 		}
	)
	
	(
		(
			a3_0 = arraydimension			{
				if (element == null) {
					element = org.emftext.language.java.generics.GenericsFactory.eINSTANCE.createSuperTypeArgument();
				}
				if (a3_0 != null) {
					addObjectToList(element, org.emftext.language.java.generics.GenericsPackage.SUPER_TYPE_ARGUMENT__ARRAY_DIMENSIONS_BEFORE, a3_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a3_0, element); 			}
		)
		
	)*	
;

keywordassert returns [org.emftext.language.java.statements.Assert element = null]
@init{
}
:
	a0 = 'assert' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createAssert();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	(
		a1_0 = assignmentexpression		{
			if (element == null) {
				element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createAssert();
			}
			if (a1_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.statements.StatementsPackage.ASSERT__CONDITION), a1_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a1_0, element); 		}
	)
	
	(
		(
			a2 = ':' {
				if (element == null) {
					element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createAssert();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a2, element);
			}
			
			(
				a3_0 = assignmentexpression				{
					if (element == null) {
						element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createAssert();
					}
					if (a3_0 != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.statements.StatementsPackage.ASSERT__ERROR_MESSAGE), a3_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a3_0, element); 				}
			)
			
		)
		
	)?	
	a4 = ';' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createAssert();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a4, element);
	}
	
;

condition returns [org.emftext.language.java.statements.Condition element = null]
@init{
}
:
	a0 = 'if' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createCondition();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createCondition();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	
	(
		a2_0 = assignmentexpression		{
			if (element == null) {
				element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createCondition();
			}
			if (a2_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.statements.StatementsPackage.CONDITION__CONDITION), a2_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a2_0, element); 		}
	)
	
	a3 = ')' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createCondition();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a3, element);
	}
	
	(
		a4_0 = statement		{
			if (element == null) {
				element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createCondition();
			}
			if (a4_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.statements.StatementsPackage.CONDITION__STATEMENT), a4_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a4_0, element); 		}
	)
	
	(
		(
			a5 = 'else' {
				if (element == null) {
					element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createCondition();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a5, element);
			}
			
			(
				a6_0 = statement				{
					if (element == null) {
						element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createCondition();
					}
					if (a6_0 != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.statements.StatementsPackage.CONDITION__ELSE_STATEMENT), a6_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a6_0, element); 				}
			)
			
		)
		
	)?	
;

forloop returns [org.emftext.language.java.statements.ForLoop element = null]
@init{
}
:
	a0 = 'for' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createForLoop();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createForLoop();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	
	(
		(
			a2_0 = forloopinitializer			{
				if (element == null) {
					element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createForLoop();
				}
				if (a2_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.statements.StatementsPackage.FOR_LOOP__INIT), a2_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a2_0, element); 			}
		)
		
	)?	
	a3 = ';' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createForLoop();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a3, element);
	}
	
	(
		(
			a4_0 = assignmentexpression			{
				if (element == null) {
					element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createForLoop();
				}
				if (a4_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.statements.StatementsPackage.FOR_LOOP__CONDITION), a4_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a4_0, element); 			}
		)
		
	)?	
	a5 = ';' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createForLoop();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a5, element);
	}
	
	(
		(
			(
				a6_0 = assignmentexpression				{
					if (element == null) {
						element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createForLoop();
					}
					if (a6_0 != null) {
						addObjectToList(element, org.emftext.language.java.statements.StatementsPackage.FOR_LOOP__UPDATES, a6_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a6_0, element); 				}
			)
			
			(
				(
					a7 = ',' {
						if (element == null) {
							element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createForLoop();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken)a7, element);
					}
					
					(
						a8_0 = assignmentexpression						{
							if (element == null) {
								element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createForLoop();
							}
							if (a8_0 != null) {
								addObjectToList(element, org.emftext.language.java.statements.StatementsPackage.FOR_LOOP__UPDATES, a8_0);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos(a8_0, element); 						}
					)
					
				)
				
			)*			
		)
		
	)?	
	a9 = ')' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createForLoop();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a9, element);
	}
	
	(
		a10_0 = statement		{
			if (element == null) {
				element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createForLoop();
			}
			if (a10_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.statements.StatementsPackage.FOR_LOOP__STATEMENT), a10_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a10_0, element); 		}
	)
	
;

foreachloop returns [org.emftext.language.java.statements.ForEachLoop element = null]
@init{
}
:
	a0 = 'for' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createForEachLoop();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createForEachLoop();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	
	(
		a2_0 = ordinaryparameter		{
			if (element == null) {
				element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createForEachLoop();
			}
			if (a2_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.statements.StatementsPackage.FOR_EACH_LOOP__NEXT), a2_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a2_0, element); 		}
	)
	
	a3 = ':' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createForEachLoop();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a3, element);
	}
	
	(
		a4_0 = assignmentexpression		{
			if (element == null) {
				element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createForEachLoop();
			}
			if (a4_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.statements.StatementsPackage.FOR_EACH_LOOP__COLLECTION), a4_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a4_0, element); 		}
	)
	
	a5 = ')' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createForEachLoop();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a5, element);
	}
	
	(
		a6_0 = statement		{
			if (element == null) {
				element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createForEachLoop();
			}
			if (a6_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.statements.StatementsPackage.FOR_EACH_LOOP__STATEMENT), a6_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a6_0, element); 		}
	)
	
;

whileloop returns [org.emftext.language.java.statements.WhileLoop element = null]
@init{
}
:
	a0 = 'while' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createWhileLoop();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createWhileLoop();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	
	(
		a2_0 = assignmentexpression		{
			if (element == null) {
				element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createWhileLoop();
			}
			if (a2_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.statements.StatementsPackage.WHILE_LOOP__CONDITION), a2_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a2_0, element); 		}
	)
	
	a3 = ')' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createWhileLoop();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a3, element);
	}
	
	(
		a4_0 = statement		{
			if (element == null) {
				element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createWhileLoop();
			}
			if (a4_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.statements.StatementsPackage.WHILE_LOOP__STATEMENT), a4_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a4_0, element); 		}
	)
	
	|//derived choice rules for sub-classes: 
	
	c0 = dowhileloop{ element = c0; }
	
;

dowhileloop returns [org.emftext.language.java.statements.DoWhileLoop element = null]
@init{
}
:
	a0 = 'do' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createDoWhileLoop();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	(
		a1_0 = statement		{
			if (element == null) {
				element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createDoWhileLoop();
			}
			if (a1_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.statements.StatementsPackage.DO_WHILE_LOOP__STATEMENT), a1_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a1_0, element); 		}
	)
	
	a2 = 'while' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createDoWhileLoop();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	
	a3 = '(' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createDoWhileLoop();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a3, element);
	}
	
	(
		a4_0 = assignmentexpression		{
			if (element == null) {
				element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createDoWhileLoop();
			}
			if (a4_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.statements.StatementsPackage.DO_WHILE_LOOP__CONDITION), a4_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a4_0, element); 		}
	)
	
	a5 = ')' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createDoWhileLoop();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a5, element);
	}
	
	a6 = ';' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createDoWhileLoop();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a6, element);
	}
	
;

emptystatement returns [org.emftext.language.java.statements.EmptyStatement element = null]
@init{
}
:
	a0 = ';' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createEmptyStatement();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

synchronizedblock returns [org.emftext.language.java.statements.SynchronizedBlock element = null]
@init{
}
:
	a0 = 'synchronized' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createSynchronizedBlock();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createSynchronizedBlock();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	
	(
		a2_0 = assignmentexpression		{
			if (element == null) {
				element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createSynchronizedBlock();
			}
			if (a2_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.statements.StatementsPackage.SYNCHRONIZED_BLOCK__LOCK_PROVIDER), a2_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a2_0, element); 		}
	)
	
	a3 = ')' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createSynchronizedBlock();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a3, element);
	}
	
	a4 = '{' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createSynchronizedBlock();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a4, element);
	}
	
	(
		(
			a5_0 = statement			{
				if (element == null) {
					element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createSynchronizedBlock();
				}
				if (a5_0 != null) {
					addObjectToList(element, org.emftext.language.java.statements.StatementsPackage.SYNCHRONIZED_BLOCK__STATEMENTS, a5_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a5_0, element); 			}
		)
		
	)*	
	a6 = '}' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createSynchronizedBlock();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a6, element);
	}
	
;

tryblock returns [org.emftext.language.java.statements.TryBlock element = null]
@init{
}
:
	a0 = 'try' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createTryBlock();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	a1 = '{' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createTryBlock();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	
	(
		(
			a2_0 = statement			{
				if (element == null) {
					element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createTryBlock();
				}
				if (a2_0 != null) {
					addObjectToList(element, org.emftext.language.java.statements.StatementsPackage.TRY_BLOCK__STATEMENTS, a2_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a2_0, element); 			}
		)
		
	)*	
	a3 = '}' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createTryBlock();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a3, element);
	}
	
	(
		(
			a4_0 = catchblock			{
				if (element == null) {
					element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createTryBlock();
				}
				if (a4_0 != null) {
					addObjectToList(element, org.emftext.language.java.statements.StatementsPackage.TRY_BLOCK__CATCHE_BLOCKS, a4_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a4_0, element); 			}
		)
		
	)*	
	(
		(
			a5 = 'finally' {
				if (element == null) {
					element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createTryBlock();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a5, element);
			}
			
			(
				a6_0 = block				{
					if (element == null) {
						element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createTryBlock();
					}
					if (a6_0 != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.statements.StatementsPackage.TRY_BLOCK__FINALLY_BLOCK), a6_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a6_0, element); 				}
			)
			
		)
		
	)?	
;

catchblock returns [org.emftext.language.java.statements.CatchBlock element = null]
@init{
}
:
	a0 = 'catch' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createCatchBlock();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createCatchBlock();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	
	(
		a2_0 = ordinaryparameter		{
			if (element == null) {
				element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createCatchBlock();
			}
			if (a2_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.statements.StatementsPackage.CATCH_BLOCK__PARAMETER), a2_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a2_0, element); 		}
	)
	
	a3 = ')' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createCatchBlock();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a3, element);
	}
	
	a4 = '{' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createCatchBlock();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a4, element);
	}
	
	(
		(
			a5_0 = statement			{
				if (element == null) {
					element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createCatchBlock();
				}
				if (a5_0 != null) {
					addObjectToList(element, org.emftext.language.java.statements.StatementsPackage.CATCH_BLOCK__STATEMENTS, a5_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a5_0, element); 			}
		)
		
	)*	
	a6 = '}' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createCatchBlock();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a6, element);
	}
	
;

keywordswitch returns [org.emftext.language.java.statements.Switch element = null]
@init{
}
:
	a0 = 'switch' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createSwitch();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createSwitch();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	
	(
		a2_0 = assignmentexpression		{
			if (element == null) {
				element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createSwitch();
			}
			if (a2_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.statements.StatementsPackage.SWITCH__VARIABLE), a2_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a2_0, element); 		}
	)
	
	a3 = ')' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createSwitch();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a3, element);
	}
	
	a4 = '{' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createSwitch();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a4, element);
	}
	
	(
		(
			(
				a5_0 = switchcase				{
					if (element == null) {
						element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createSwitch();
					}
					if (a5_0 != null) {
						addObjectToList(element, org.emftext.language.java.statements.StatementsPackage.SWITCH__CASES, a5_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a5_0, element); 				}
			)
			
		)*		
	)
	
	a6 = '}' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createSwitch();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a6, element);
	}
	
;

normalswitchcase returns [org.emftext.language.java.statements.NormalSwitchCase element = null]
@init{
}
:
	a0 = 'case' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createNormalSwitchCase();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	(
		a1_0 = assignmentexpression		{
			if (element == null) {
				element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createNormalSwitchCase();
			}
			if (a1_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.statements.StatementsPackage.NORMAL_SWITCH_CASE__CONDITION), a1_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a1_0, element); 		}
	)
	
	a2 = ':' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createNormalSwitchCase();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	
	(
		(
			a3_0 = statement			{
				if (element == null) {
					element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createNormalSwitchCase();
				}
				if (a3_0 != null) {
					addObjectToList(element, org.emftext.language.java.statements.StatementsPackage.NORMAL_SWITCH_CASE__STATEMENTS, a3_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a3_0, element); 			}
		)
		
	)*	
;

defaultswitchcase returns [org.emftext.language.java.statements.DefaultSwitchCase element = null]
@init{
}
:
	a0 = 'default' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createDefaultSwitchCase();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	a1 = ':' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createDefaultSwitchCase();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	
	(
		(
			a2_0 = statement			{
				if (element == null) {
					element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createDefaultSwitchCase();
				}
				if (a2_0 != null) {
					addObjectToList(element, org.emftext.language.java.statements.StatementsPackage.DEFAULT_SWITCH_CASE__STATEMENTS, a2_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a2_0, element); 			}
		)
		
	)*	
;

keywordreturn returns [org.emftext.language.java.statements.Return element = null]
@init{
}
:
	a0 = 'return' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createReturn();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	(
		(
			a1_0 = assignmentexpression			{
				if (element == null) {
					element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createReturn();
				}
				if (a1_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.statements.StatementsPackage.RETURN__RETURN_VALUE), a1_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a1_0, element); 			}
		)
		
	)?	
	a2 = ';' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createReturn();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	
;

keywordthrow returns [org.emftext.language.java.statements.Throw element = null]
@init{
}
:
	a0 = 'throw' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createThrow();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	(
		a1_0 = assignmentexpression		{
			if (element == null) {
				element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createThrow();
			}
			if (a1_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.statements.StatementsPackage.THROW__THROWABLE), a1_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a1_0, element); 		}
	)
	
	a2 = ';' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createThrow();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	
;

keywordbreak returns [org.emftext.language.java.statements.Break element = null]
@init{
}
:
	a0 = 'break' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createBreak();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	(
		(
			(
				a1 = IDENTIFIER				
				{
					if (element == null) {
						element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createBreak();
					}
					org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
					tokenResolver.setOptions(getOptions());
					org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.statements.StatementsPackage.BREAK__TARGET), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						getResource().addError(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
					}
					String resolved = (String) resolvedObject;
					org.emftext.language.java.statements.JumpLabel proxy = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createJumpLabel();
					collectHiddenTokens(element);
					getResource().registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.language.java.statements.Jump, org.emftext.language.java.statements.JumpLabel>(((org.emftext.language.java.javabehavior4uml.resource.javabehavior.JavabehaviorReferenceResolverSwitch) resource.getReferenceResolverSwitch()).getJumpTargetReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.java.statements.StatementsPackage.BREAK__TARGET), resolved, proxy);
					if (proxy != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.statements.StatementsPackage.BREAK__TARGET), proxy);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((CommonToken) a1, element);
					copyLocalizationInfos((CommonToken) a1, proxy);
				}
			)
			
		)
		
	)?	
	a2 = ';' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createBreak();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	
;

keywordcontinue returns [org.emftext.language.java.statements.Continue element = null]
@init{
}
:
	a0 = 'continue' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createContinue();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	(
		(
			(
				a1 = IDENTIFIER				
				{
					if (element == null) {
						element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createContinue();
					}
					org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
					tokenResolver.setOptions(getOptions());
					org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.statements.StatementsPackage.CONTINUE__TARGET), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						getResource().addError(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
					}
					String resolved = (String) resolvedObject;
					org.emftext.language.java.statements.JumpLabel proxy = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createJumpLabel();
					collectHiddenTokens(element);
					getResource().registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.language.java.statements.Jump, org.emftext.language.java.statements.JumpLabel>(((org.emftext.language.java.javabehavior4uml.resource.javabehavior.JavabehaviorReferenceResolverSwitch) resource.getReferenceResolverSwitch()).getJumpTargetReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.language.java.statements.StatementsPackage.CONTINUE__TARGET), resolved, proxy);
					if (proxy != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.statements.StatementsPackage.CONTINUE__TARGET), proxy);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((CommonToken) a1, element);
					copyLocalizationInfos((CommonToken) a1, proxy);
				}
			)
			
		)
		
	)?	
	a2 = ';' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createContinue();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	
;

jumplabel returns [org.emftext.language.java.statements.JumpLabel element = null]
@init{
}
:
	(
		a0 = IDENTIFIER		
		{
			if (element == null) {
				element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createJumpLabel();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.statements.StatementsPackage.JUMP_LABEL__NAME), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
			}
			java.lang.String resolved = (java.lang.String)resolvedObject;
			if (resolved != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.statements.StatementsPackage.JUMP_LABEL__NAME), resolved);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a0, element);
		}
	)
	
	a1 = ':' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createJumpLabel();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	
	(
		a2_0 = statement		{
			if (element == null) {
				element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createJumpLabel();
			}
			if (a2_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.statements.StatementsPackage.JUMP_LABEL__STATEMENT), a2_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a2_0, element); 		}
	)
	
;

expressionstatement returns [org.emftext.language.java.statements.ExpressionStatement element = null]
@init{
}
:
	(
		a0_0 = assignmentexpression		{
			if (element == null) {
				element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createExpressionStatement();
			}
			if (a0_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.statements.StatementsPackage.EXPRESSION_STATEMENT__EXPRESSION), a0_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a0_0, element); 		}
	)
	
	a1 = ';' {
		if (element == null) {
			element = org.emftext.language.java.statements.StatementsFactory.eINSTANCE.createExpressionStatement();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	
;

expressionlist returns [org.emftext.language.java.expressions.ExpressionList element = null]
@init{
}
:
	(
		a0_0 = assignmentexpression		{
			if (element == null) {
				element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createExpressionList();
			}
			if (a0_0 != null) {
				addObjectToList(element, org.emftext.language.java.expressions.ExpressionsPackage.EXPRESSION_LIST__EXPRESSIONS, a0_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a0_0, element); 		}
	)
	
	(
		(
			a1 = ',' {
				if (element == null) {
					element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createExpressionList();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a1, element);
			}
			
			(
				a2_0 = assignmentexpression				{
					if (element == null) {
						element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createExpressionList();
					}
					if (a2_0 != null) {
						addObjectToList(element, org.emftext.language.java.expressions.ExpressionsPackage.EXPRESSION_LIST__EXPRESSIONS, a2_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a2_0, element); 				}
			)
			
		)
		
	)*	
;

assignmentexpression returns [org.emftext.language.java.expressions.AssignmentExpression element = null]
@init{
}
:
	(
		a0_0 = conditionalexpression		{
			if (element == null) {
				element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createAssignmentExpression();
			}
			if (a0_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.expressions.ExpressionsPackage.ASSIGNMENT_EXPRESSION__CHILD), a0_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a0_0, element); 		}
	)
	
	(
		(
			(
				a1_0 = assignmentoperator				{
					if (element == null) {
						element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createAssignmentExpression();
					}
					if (a1_0 != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.expressions.ExpressionsPackage.ASSIGNMENT_EXPRESSION__ASSIGNMENT_OPERATOR), a1_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a1_0, element); 				}
			)
			
			(
				a2_0 = assignmentexpression				{
					if (element == null) {
						element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createAssignmentExpression();
					}
					if (a2_0 != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.expressions.ExpressionsPackage.ASSIGNMENT_EXPRESSION__VALUE), a2_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a2_0, element); 				}
			)
			
		)
		
	)?	
;

conditionalexpression returns [org.emftext.language.java.expressions.ConditionalExpression element = null]
@init{
}
:
	(
		a0_0 = conditionalorexpression		{
			if (element == null) {
				element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createConditionalExpression();
			}
			if (a0_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.expressions.ExpressionsPackage.CONDITIONAL_EXPRESSION__CHILD), a0_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a0_0, element); 		}
	)
	
	(
		(
			a1 = '?' {
				if (element == null) {
					element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createConditionalExpression();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a1, element);
			}
			
			(
				a2_0 = assignmentexpression				{
					if (element == null) {
						element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createConditionalExpression();
					}
					if (a2_0 != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.expressions.ExpressionsPackage.CONDITIONAL_EXPRESSION__EXPRESSION_IF), a2_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a2_0, element); 				}
			)
			
			a3 = ':' {
				if (element == null) {
					element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createConditionalExpression();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a3, element);
			}
			
			(
				a4_0 = conditionalexpression				{
					if (element == null) {
						element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createConditionalExpression();
					}
					if (a4_0 != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.expressions.ExpressionsPackage.CONDITIONAL_EXPRESSION__EXPRESSION_ELSE), a4_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a4_0, element); 				}
			)
			
		)
		
	)?	
;

conditionalorexpression returns [org.emftext.language.java.expressions.ConditionalOrExpression element = null]
@init{
}
:
	(
		a0_0 = conditionalandexpression		{
			if (element == null) {
				element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createConditionalOrExpression();
			}
			if (a0_0 != null) {
				addObjectToList(element, org.emftext.language.java.expressions.ExpressionsPackage.CONDITIONAL_OR_EXPRESSION__CHILDREN, a0_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a0_0, element); 		}
	)
	
	(
		(
			a1 = '||' {
				if (element == null) {
					element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createConditionalOrExpression();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a1, element);
			}
			
			(
				a2_0 = conditionalandexpression				{
					if (element == null) {
						element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createConditionalOrExpression();
					}
					if (a2_0 != null) {
						addObjectToList(element, org.emftext.language.java.expressions.ExpressionsPackage.CONDITIONAL_OR_EXPRESSION__CHILDREN, a2_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a2_0, element); 				}
			)
			
		)
		
	)*	
;

conditionalandexpression returns [org.emftext.language.java.expressions.ConditionalAndExpression element = null]
@init{
}
:
	(
		a0_0 = inclusiveorexpression		{
			if (element == null) {
				element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createConditionalAndExpression();
			}
			if (a0_0 != null) {
				addObjectToList(element, org.emftext.language.java.expressions.ExpressionsPackage.CONDITIONAL_AND_EXPRESSION__CHILDREN, a0_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a0_0, element); 		}
	)
	
	(
		(
			a1 = '&&' {
				if (element == null) {
					element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createConditionalAndExpression();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a1, element);
			}
			
			(
				a2_0 = inclusiveorexpression				{
					if (element == null) {
						element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createConditionalAndExpression();
					}
					if (a2_0 != null) {
						addObjectToList(element, org.emftext.language.java.expressions.ExpressionsPackage.CONDITIONAL_AND_EXPRESSION__CHILDREN, a2_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a2_0, element); 				}
			)
			
		)
		
	)*	
;

inclusiveorexpression returns [org.emftext.language.java.expressions.InclusiveOrExpression element = null]
@init{
}
:
	(
		a0_0 = exclusiveorexpression		{
			if (element == null) {
				element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createInclusiveOrExpression();
			}
			if (a0_0 != null) {
				addObjectToList(element, org.emftext.language.java.expressions.ExpressionsPackage.INCLUSIVE_OR_EXPRESSION__CHILDREN, a0_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a0_0, element); 		}
	)
	
	(
		(
			a1 = '|' {
				if (element == null) {
					element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createInclusiveOrExpression();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a1, element);
			}
			
			(
				a2_0 = exclusiveorexpression				{
					if (element == null) {
						element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createInclusiveOrExpression();
					}
					if (a2_0 != null) {
						addObjectToList(element, org.emftext.language.java.expressions.ExpressionsPackage.INCLUSIVE_OR_EXPRESSION__CHILDREN, a2_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a2_0, element); 				}
			)
			
		)
		
	)*	
;

exclusiveorexpression returns [org.emftext.language.java.expressions.ExclusiveOrExpression element = null]
@init{
}
:
	(
		a0_0 = andexpression		{
			if (element == null) {
				element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createExclusiveOrExpression();
			}
			if (a0_0 != null) {
				addObjectToList(element, org.emftext.language.java.expressions.ExpressionsPackage.EXCLUSIVE_OR_EXPRESSION__CHILDREN, a0_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a0_0, element); 		}
	)
	
	(
		(
			a1 = '^' {
				if (element == null) {
					element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createExclusiveOrExpression();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a1, element);
			}
			
			(
				a2_0 = andexpression				{
					if (element == null) {
						element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createExclusiveOrExpression();
					}
					if (a2_0 != null) {
						addObjectToList(element, org.emftext.language.java.expressions.ExpressionsPackage.EXCLUSIVE_OR_EXPRESSION__CHILDREN, a2_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a2_0, element); 				}
			)
			
		)
		
	)*	
;

andexpression returns [org.emftext.language.java.expressions.AndExpression element = null]
@init{
}
:
	(
		a0_0 = equalityexpression		{
			if (element == null) {
				element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createAndExpression();
			}
			if (a0_0 != null) {
				addObjectToList(element, org.emftext.language.java.expressions.ExpressionsPackage.AND_EXPRESSION__CHILDREN, a0_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a0_0, element); 		}
	)
	
	(
		(
			a1 = '&' {
				if (element == null) {
					element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createAndExpression();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a1, element);
			}
			
			(
				a2_0 = equalityexpression				{
					if (element == null) {
						element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createAndExpression();
					}
					if (a2_0 != null) {
						addObjectToList(element, org.emftext.language.java.expressions.ExpressionsPackage.AND_EXPRESSION__CHILDREN, a2_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a2_0, element); 				}
			)
			
		)
		
	)*	
;

equalityexpression returns [org.emftext.language.java.expressions.EqualityExpression element = null]
@init{
}
:
	(
		a0_0 = instanceofexpression		{
			if (element == null) {
				element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createEqualityExpression();
			}
			if (a0_0 != null) {
				addObjectToList(element, org.emftext.language.java.expressions.ExpressionsPackage.EQUALITY_EXPRESSION__CHILDREN, a0_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a0_0, element); 		}
	)
	
	(
		(
			(
				a1_0 = equalityoperator				{
					if (element == null) {
						element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createEqualityExpression();
					}
					if (a1_0 != null) {
						addObjectToList(element, org.emftext.language.java.expressions.ExpressionsPackage.EQUALITY_EXPRESSION__EQUALITY_OPERATORS, a1_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a1_0, element); 				}
			)
			
			(
				a2_0 = instanceofexpression				{
					if (element == null) {
						element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createEqualityExpression();
					}
					if (a2_0 != null) {
						addObjectToList(element, org.emftext.language.java.expressions.ExpressionsPackage.EQUALITY_EXPRESSION__CHILDREN, a2_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a2_0, element); 				}
			)
			
		)
		
	)*	
;

instanceofexpression returns [org.emftext.language.java.expressions.InstanceOfExpression element = null]
@init{
}
:
	(
		a0_0 = relationexpression		{
			if (element == null) {
				element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createInstanceOfExpression();
			}
			if (a0_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.expressions.ExpressionsPackage.INSTANCE_OF_EXPRESSION__CHILD), a0_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a0_0, element); 		}
	)
	
	(
		(
			a1 = 'instanceof' {
				if (element == null) {
					element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createInstanceOfExpression();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a1, element);
			}
			
			(
				a2_0 = typereference				{
					if (element == null) {
						element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createInstanceOfExpression();
					}
					if (a2_0 != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.expressions.ExpressionsPackage.INSTANCE_OF_EXPRESSION__TYPE), a2_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a2_0, element); 				}
			)
			
			(
				(
					a3_0 = arraydimension					{
						if (element == null) {
							element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createInstanceOfExpression();
						}
						if (a3_0 != null) {
							addObjectToList(element, org.emftext.language.java.expressions.ExpressionsPackage.INSTANCE_OF_EXPRESSION__ARRAY_DIMENSIONS_BEFORE, a3_0);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos(a3_0, element); 					}
				)
				
			)*			
		)
		
	)?	
;

relationexpression returns [org.emftext.language.java.expressions.RelationExpression element = null]
@init{
}
:
	(
		a0_0 = shiftexpression		{
			if (element == null) {
				element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createRelationExpression();
			}
			if (a0_0 != null) {
				addObjectToList(element, org.emftext.language.java.expressions.ExpressionsPackage.RELATION_EXPRESSION__CHILDREN, a0_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a0_0, element); 		}
	)
	
	(
		(
			(
				a1_0 = relationoperator				{
					if (element == null) {
						element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createRelationExpression();
					}
					if (a1_0 != null) {
						addObjectToList(element, org.emftext.language.java.expressions.ExpressionsPackage.RELATION_EXPRESSION__RELATION_OPERATORS, a1_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a1_0, element); 				}
			)
			
			(
				a2_0 = shiftexpression				{
					if (element == null) {
						element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createRelationExpression();
					}
					if (a2_0 != null) {
						addObjectToList(element, org.emftext.language.java.expressions.ExpressionsPackage.RELATION_EXPRESSION__CHILDREN, a2_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a2_0, element); 				}
			)
			
		)
		
	)*	
;

shiftexpression returns [org.emftext.language.java.expressions.ShiftExpression element = null]
@init{
}
:
	(
		a0_0 = additiveexpression		{
			if (element == null) {
				element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createShiftExpression();
			}
			if (a0_0 != null) {
				addObjectToList(element, org.emftext.language.java.expressions.ExpressionsPackage.SHIFT_EXPRESSION__CHILDREN, a0_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a0_0, element); 		}
	)
	
	(
		(
			(
				a1_0 = shiftoperator				{
					if (element == null) {
						element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createShiftExpression();
					}
					if (a1_0 != null) {
						addObjectToList(element, org.emftext.language.java.expressions.ExpressionsPackage.SHIFT_EXPRESSION__SHIFT_OPERATORS, a1_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a1_0, element); 				}
			)
			
			(
				a2_0 = additiveexpression				{
					if (element == null) {
						element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createShiftExpression();
					}
					if (a2_0 != null) {
						addObjectToList(element, org.emftext.language.java.expressions.ExpressionsPackage.SHIFT_EXPRESSION__CHILDREN, a2_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a2_0, element); 				}
			)
			
		)
		
	)*	
;

additiveexpression returns [org.emftext.language.java.expressions.AdditiveExpression element = null]
@init{
}
:
	(
		a0_0 = multiplicativeexpression		{
			if (element == null) {
				element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createAdditiveExpression();
			}
			if (a0_0 != null) {
				addObjectToList(element, org.emftext.language.java.expressions.ExpressionsPackage.ADDITIVE_EXPRESSION__CHILDREN, a0_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a0_0, element); 		}
	)
	
	(
		(
			(
				a1_0 = additiveoperator				{
					if (element == null) {
						element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createAdditiveExpression();
					}
					if (a1_0 != null) {
						addObjectToList(element, org.emftext.language.java.expressions.ExpressionsPackage.ADDITIVE_EXPRESSION__ADDITIVE_OPERATORS, a1_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a1_0, element); 				}
			)
			
			(
				a2_0 = multiplicativeexpression				{
					if (element == null) {
						element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createAdditiveExpression();
					}
					if (a2_0 != null) {
						addObjectToList(element, org.emftext.language.java.expressions.ExpressionsPackage.ADDITIVE_EXPRESSION__CHILDREN, a2_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a2_0, element); 				}
			)
			
		)
		
	)*	
;

multiplicativeexpression returns [org.emftext.language.java.expressions.MultiplicativeExpression element = null]
@init{
}
:
	(
		a0_0 = unaryexpression		{
			if (element == null) {
				element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createMultiplicativeExpression();
			}
			if (a0_0 != null) {
				addObjectToList(element, org.emftext.language.java.expressions.ExpressionsPackage.MULTIPLICATIVE_EXPRESSION__CHILDREN, a0_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a0_0, element); 		}
	)
	
	(
		(
			(
				a1_0 = multiplicativeoperator				{
					if (element == null) {
						element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createMultiplicativeExpression();
					}
					if (a1_0 != null) {
						addObjectToList(element, org.emftext.language.java.expressions.ExpressionsPackage.MULTIPLICATIVE_EXPRESSION__MULTIPLICATIVE_OPERATORS, a1_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a1_0, element); 				}
			)
			
			(
				a2_0 = unaryexpression				{
					if (element == null) {
						element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createMultiplicativeExpression();
					}
					if (a2_0 != null) {
						addObjectToList(element, org.emftext.language.java.expressions.ExpressionsPackage.MULTIPLICATIVE_EXPRESSION__CHILDREN, a2_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a2_0, element); 				}
			)
			
		)
		
	)*	
;

unaryexpression returns [org.emftext.language.java.expressions.UnaryExpression element = null]
@init{
}
:
	(
		(
			a0_0 = unaryoperator			{
				if (element == null) {
					element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createUnaryExpression();
				}
				if (a0_0 != null) {
					addObjectToList(element, org.emftext.language.java.expressions.ExpressionsPackage.UNARY_EXPRESSION__OPERATORS, a0_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a0_0, element); 			}
		)
		
	)*	
	(
		a1_0 = unarymodificationexpression		{
			if (element == null) {
				element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createUnaryExpression();
			}
			if (a1_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.expressions.ExpressionsPackage.UNARY_EXPRESSION__CHILD), a1_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a1_0, element); 		}
	)
	
;

suffixunarymodificationexpression returns [org.emftext.language.java.expressions.SuffixUnaryModificationExpression element = null]
@init{
}
:
	(
		a0_0 = unarymodificationexpressionchild		{
			if (element == null) {
				element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createSuffixUnaryModificationExpression();
			}
			if (a0_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.expressions.ExpressionsPackage.SUFFIX_UNARY_MODIFICATION_EXPRESSION__CHILD), a0_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a0_0, element); 		}
	)
	
	(
		(
			(
				a1_0 = unarymodificationoperator				{
					if (element == null) {
						element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createSuffixUnaryModificationExpression();
					}
					if (a1_0 != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.expressions.ExpressionsPackage.SUFFIX_UNARY_MODIFICATION_EXPRESSION__OPERATOR), a1_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a1_0, element); 				}
			)
			
		)
		
	)?	
;

prefixunarymodificationexpression returns [org.emftext.language.java.expressions.PrefixUnaryModificationExpression element = null]
@init{
}
:
	(
		(
			(
				a0_0 = unarymodificationoperator				{
					if (element == null) {
						element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createPrefixUnaryModificationExpression();
					}
					if (a0_0 != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.expressions.ExpressionsPackage.PREFIX_UNARY_MODIFICATION_EXPRESSION__OPERATOR), a0_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a0_0, element); 				}
			)
			
		)
		
	)?	
	(
		a1_0 = unarymodificationexpressionchild		{
			if (element == null) {
				element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createPrefixUnaryModificationExpression();
			}
			if (a1_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.expressions.ExpressionsPackage.PREFIX_UNARY_MODIFICATION_EXPRESSION__CHILD), a1_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a1_0, element); 		}
	)
	
;

castexpression returns [org.emftext.language.java.expressions.CastExpression element = null]
@init{
}
:
	a0 = '(' {
		if (element == null) {
			element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createCastExpression();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	(
		a1_0 = typereference		{
			if (element == null) {
				element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createCastExpression();
			}
			if (a1_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.expressions.ExpressionsPackage.CAST_EXPRESSION__TYPE), a1_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a1_0, element); 		}
	)
	
	(
		(
			a2_0 = arraydimension			{
				if (element == null) {
					element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createCastExpression();
				}
				if (a2_0 != null) {
					addObjectToList(element, org.emftext.language.java.expressions.ExpressionsPackage.CAST_EXPRESSION__ARRAY_DIMENSIONS_BEFORE, a2_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a2_0, element); 			}
		)
		
	)*	
	a3 = ')' {
		if (element == null) {
			element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createCastExpression();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a3, element);
	}
	
	(
		a4_0 = unaryexpression		{
			if (element == null) {
				element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createCastExpression();
			}
			if (a4_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.expressions.ExpressionsPackage.CAST_EXPRESSION__CHILD), a4_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a4_0, element); 		}
	)
	
;

nestedexpression returns [org.emftext.language.java.expressions.NestedExpression element = null]
@init{
}
:
	a0 = '(' {
		if (element == null) {
			element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createNestedExpression();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	(
		a1_0 = assignmentexpression		{
			if (element == null) {
				element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createNestedExpression();
			}
			if (a1_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.expressions.ExpressionsPackage.NESTED_EXPRESSION__EXPRESSION), a1_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a1_0, element); 		}
	)
	
	a2 = ')' {
		if (element == null) {
			element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createNestedExpression();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	
	(
		(
			a3_0 = arrayselector			{
				if (element == null) {
					element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createNestedExpression();
				}
				if (a3_0 != null) {
					addObjectToList(element, org.emftext.language.java.expressions.ExpressionsPackage.NESTED_EXPRESSION__ARRAY_SELECTORS, a3_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a3_0, element); 			}
		)
		
	)*	
	(
		(
			a4 = '.' {
				if (element == null) {
					element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createNestedExpression();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a4, element);
			}
			
			(
				a5_0 = reference				{
					if (element == null) {
						element = org.emftext.language.java.expressions.ExpressionsFactory.eINSTANCE.createNestedExpression();
					}
					if (a5_0 != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.expressions.ExpressionsPackage.NESTED_EXPRESSION__NEXT), a5_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a5_0, element); 				}
			)
			
		)
		
	)?	
;

assignment returns [org.emftext.language.java.operators.Assignment element = null]
@init{
}
:
	a0 = '=' {
		if (element == null) {
			element = org.emftext.language.java.operators.OperatorsFactory.eINSTANCE.createAssignment();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

assignmentplus returns [org.emftext.language.java.operators.AssignmentPlus element = null]
@init{
}
:
	a0 = '+=' {
		if (element == null) {
			element = org.emftext.language.java.operators.OperatorsFactory.eINSTANCE.createAssignmentPlus();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

assignmentminus returns [org.emftext.language.java.operators.AssignmentMinus element = null]
@init{
}
:
	a0 = '-=' {
		if (element == null) {
			element = org.emftext.language.java.operators.OperatorsFactory.eINSTANCE.createAssignmentMinus();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

assignmentmultiplication returns [org.emftext.language.java.operators.AssignmentMultiplication element = null]
@init{
}
:
	a0 = '*=' {
		if (element == null) {
			element = org.emftext.language.java.operators.OperatorsFactory.eINSTANCE.createAssignmentMultiplication();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

assignmentdivision returns [org.emftext.language.java.operators.AssignmentDivision element = null]
@init{
}
:
	a0 = '/=' {
		if (element == null) {
			element = org.emftext.language.java.operators.OperatorsFactory.eINSTANCE.createAssignmentDivision();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

assignmentand returns [org.emftext.language.java.operators.AssignmentAnd element = null]
@init{
}
:
	a0 = '&=' {
		if (element == null) {
			element = org.emftext.language.java.operators.OperatorsFactory.eINSTANCE.createAssignmentAnd();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

assignmentor returns [org.emftext.language.java.operators.AssignmentOr element = null]
@init{
}
:
	a0 = '|=' {
		if (element == null) {
			element = org.emftext.language.java.operators.OperatorsFactory.eINSTANCE.createAssignmentOr();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

assignmentexclusiveor returns [org.emftext.language.java.operators.AssignmentExclusiveOr element = null]
@init{
}
:
	a0 = '^=' {
		if (element == null) {
			element = org.emftext.language.java.operators.OperatorsFactory.eINSTANCE.createAssignmentExclusiveOr();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

assignmentmodulo returns [org.emftext.language.java.operators.AssignmentModulo element = null]
@init{
}
:
	a0 = '%=' {
		if (element == null) {
			element = org.emftext.language.java.operators.OperatorsFactory.eINSTANCE.createAssignmentModulo();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

assignmentleftshift returns [org.emftext.language.java.operators.AssignmentLeftShift element = null]
@init{
}
:
	a0 = '<' {
		if (element == null) {
			element = org.emftext.language.java.operators.OperatorsFactory.eINSTANCE.createAssignmentLeftShift();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	a1 = '<' {
		if (element == null) {
			element = org.emftext.language.java.operators.OperatorsFactory.eINSTANCE.createAssignmentLeftShift();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	
	a2 = '=' {
		if (element == null) {
			element = org.emftext.language.java.operators.OperatorsFactory.eINSTANCE.createAssignmentLeftShift();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	
;

assignmentrightshift returns [org.emftext.language.java.operators.AssignmentRightShift element = null]
@init{
}
:
	a0 = '>' {
		if (element == null) {
			element = org.emftext.language.java.operators.OperatorsFactory.eINSTANCE.createAssignmentRightShift();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	a1 = '>' {
		if (element == null) {
			element = org.emftext.language.java.operators.OperatorsFactory.eINSTANCE.createAssignmentRightShift();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	
	a2 = '=' {
		if (element == null) {
			element = org.emftext.language.java.operators.OperatorsFactory.eINSTANCE.createAssignmentRightShift();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	
;

assignmentunsignedrightshift returns [org.emftext.language.java.operators.AssignmentUnsignedRightShift element = null]
@init{
}
:
	a0 = '>' {
		if (element == null) {
			element = org.emftext.language.java.operators.OperatorsFactory.eINSTANCE.createAssignmentUnsignedRightShift();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	a1 = '>' {
		if (element == null) {
			element = org.emftext.language.java.operators.OperatorsFactory.eINSTANCE.createAssignmentUnsignedRightShift();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	
	a2 = '>' {
		if (element == null) {
			element = org.emftext.language.java.operators.OperatorsFactory.eINSTANCE.createAssignmentUnsignedRightShift();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	
	a3 = '=' {
		if (element == null) {
			element = org.emftext.language.java.operators.OperatorsFactory.eINSTANCE.createAssignmentUnsignedRightShift();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a3, element);
	}
	
;

addition returns [org.emftext.language.java.operators.Addition element = null]
@init{
}
:
	a0 = '+' {
		if (element == null) {
			element = org.emftext.language.java.operators.OperatorsFactory.eINSTANCE.createAddition();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

subtraction returns [org.emftext.language.java.operators.Subtraction element = null]
@init{
}
:
	a0 = '-' {
		if (element == null) {
			element = org.emftext.language.java.operators.OperatorsFactory.eINSTANCE.createSubtraction();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

multiplication returns [org.emftext.language.java.operators.Multiplication element = null]
@init{
}
:
	a0 = '*' {
		if (element == null) {
			element = org.emftext.language.java.operators.OperatorsFactory.eINSTANCE.createMultiplication();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

division returns [org.emftext.language.java.operators.Division element = null]
@init{
}
:
	a0 = '/' {
		if (element == null) {
			element = org.emftext.language.java.operators.OperatorsFactory.eINSTANCE.createDivision();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

remainder returns [org.emftext.language.java.operators.Remainder element = null]
@init{
}
:
	a0 = '%' {
		if (element == null) {
			element = org.emftext.language.java.operators.OperatorsFactory.eINSTANCE.createRemainder();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

lessthan returns [org.emftext.language.java.operators.LessThan element = null]
@init{
}
:
	a0 = '<' {
		if (element == null) {
			element = org.emftext.language.java.operators.OperatorsFactory.eINSTANCE.createLessThan();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

lessthanorequal returns [org.emftext.language.java.operators.LessThanOrEqual element = null]
@init{
}
:
	a0 = '<' {
		if (element == null) {
			element = org.emftext.language.java.operators.OperatorsFactory.eINSTANCE.createLessThanOrEqual();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	a1 = '=' {
		if (element == null) {
			element = org.emftext.language.java.operators.OperatorsFactory.eINSTANCE.createLessThanOrEqual();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	
;

greaterthan returns [org.emftext.language.java.operators.GreaterThan element = null]
@init{
}
:
	a0 = '>' {
		if (element == null) {
			element = org.emftext.language.java.operators.OperatorsFactory.eINSTANCE.createGreaterThan();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

greaterthanorequal returns [org.emftext.language.java.operators.GreaterThanOrEqual element = null]
@init{
}
:
	a0 = '>' {
		if (element == null) {
			element = org.emftext.language.java.operators.OperatorsFactory.eINSTANCE.createGreaterThanOrEqual();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	a1 = '=' {
		if (element == null) {
			element = org.emftext.language.java.operators.OperatorsFactory.eINSTANCE.createGreaterThanOrEqual();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	
;

leftshift returns [org.emftext.language.java.operators.LeftShift element = null]
@init{
}
:
	a0 = '<' {
		if (element == null) {
			element = org.emftext.language.java.operators.OperatorsFactory.eINSTANCE.createLeftShift();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	a1 = '<' {
		if (element == null) {
			element = org.emftext.language.java.operators.OperatorsFactory.eINSTANCE.createLeftShift();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	
;

rightshift returns [org.emftext.language.java.operators.RightShift element = null]
@init{
}
:
	a0 = '>' {
		if (element == null) {
			element = org.emftext.language.java.operators.OperatorsFactory.eINSTANCE.createRightShift();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	a1 = '>' {
		if (element == null) {
			element = org.emftext.language.java.operators.OperatorsFactory.eINSTANCE.createRightShift();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	
;

unsignedrightshift returns [org.emftext.language.java.operators.UnsignedRightShift element = null]
@init{
}
:
	a0 = '>' {
		if (element == null) {
			element = org.emftext.language.java.operators.OperatorsFactory.eINSTANCE.createUnsignedRightShift();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	a1 = '>' {
		if (element == null) {
			element = org.emftext.language.java.operators.OperatorsFactory.eINSTANCE.createUnsignedRightShift();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	
	a2 = '>' {
		if (element == null) {
			element = org.emftext.language.java.operators.OperatorsFactory.eINSTANCE.createUnsignedRightShift();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	
;

equal returns [org.emftext.language.java.operators.Equal element = null]
@init{
}
:
	a0 = '==' {
		if (element == null) {
			element = org.emftext.language.java.operators.OperatorsFactory.eINSTANCE.createEqual();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

notequal returns [org.emftext.language.java.operators.NotEqual element = null]
@init{
}
:
	a0 = '!=' {
		if (element == null) {
			element = org.emftext.language.java.operators.OperatorsFactory.eINSTANCE.createNotEqual();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

plusplus returns [org.emftext.language.java.operators.PlusPlus element = null]
@init{
}
:
	a0 = '++' {
		if (element == null) {
			element = org.emftext.language.java.operators.OperatorsFactory.eINSTANCE.createPlusPlus();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

minusminus returns [org.emftext.language.java.operators.MinusMinus element = null]
@init{
}
:
	a0 = '--' {
		if (element == null) {
			element = org.emftext.language.java.operators.OperatorsFactory.eINSTANCE.createMinusMinus();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

complement returns [org.emftext.language.java.operators.Complement element = null]
@init{
}
:
	a0 = '~' {
		if (element == null) {
			element = org.emftext.language.java.operators.OperatorsFactory.eINSTANCE.createComplement();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

negate returns [org.emftext.language.java.operators.Negate element = null]
@init{
}
:
	a0 = '!' {
		if (element == null) {
			element = org.emftext.language.java.operators.OperatorsFactory.eINSTANCE.createNegate();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

arraydimension returns [org.emftext.language.java.arrays.ArrayDimension element = null]
@init{
}
:
	(
		a0 = '[' {
			if (element == null) {
				element = org.emftext.language.java.arrays.ArraysFactory.eINSTANCE.createArrayDimension();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken)a0, element);
		}
		
		a1 = ']' {
			if (element == null) {
				element = org.emftext.language.java.arrays.ArraysFactory.eINSTANCE.createArrayDimension();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken)a1, element);
		}
		
	)
	
;

nullliteral returns [org.emftext.language.java.literals.NullLiteral element = null]
@init{
}
:
	a0 = 'null' {
		if (element == null) {
			element = org.emftext.language.java.literals.LiteralsFactory.eINSTANCE.createNullLiteral();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

keywordpublic returns [org.emftext.language.java.modifiers.Public element = null]
@init{
}
:
	a0 = 'public' {
		if (element == null) {
			element = org.emftext.language.java.modifiers.ModifiersFactory.eINSTANCE.createPublic();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

keywordabstract returns [org.emftext.language.java.modifiers.Abstract element = null]
@init{
}
:
	a0 = 'abstract' {
		if (element == null) {
			element = org.emftext.language.java.modifiers.ModifiersFactory.eINSTANCE.createAbstract();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

keywordprotected returns [org.emftext.language.java.modifiers.Protected element = null]
@init{
}
:
	a0 = 'protected' {
		if (element == null) {
			element = org.emftext.language.java.modifiers.ModifiersFactory.eINSTANCE.createProtected();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

keywordprivate returns [org.emftext.language.java.modifiers.Private element = null]
@init{
}
:
	a0 = 'private' {
		if (element == null) {
			element = org.emftext.language.java.modifiers.ModifiersFactory.eINSTANCE.createPrivate();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

keywordfinal returns [org.emftext.language.java.modifiers.Final element = null]
@init{
}
:
	a0 = 'final' {
		if (element == null) {
			element = org.emftext.language.java.modifiers.ModifiersFactory.eINSTANCE.createFinal();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

keywordstatic returns [org.emftext.language.java.modifiers.Static element = null]
@init{
}
:
	a0 = 'static' {
		if (element == null) {
			element = org.emftext.language.java.modifiers.ModifiersFactory.eINSTANCE.createStatic();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

keywordnative returns [org.emftext.language.java.modifiers.Native element = null]
@init{
}
:
	a0 = 'native' {
		if (element == null) {
			element = org.emftext.language.java.modifiers.ModifiersFactory.eINSTANCE.createNative();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

keywordsynchronized returns [org.emftext.language.java.modifiers.Synchronized element = null]
@init{
}
:
	a0 = 'synchronized' {
		if (element == null) {
			element = org.emftext.language.java.modifiers.ModifiersFactory.eINSTANCE.createSynchronized();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

keywordtransient returns [org.emftext.language.java.modifiers.Transient element = null]
@init{
}
:
	a0 = 'transient' {
		if (element == null) {
			element = org.emftext.language.java.modifiers.ModifiersFactory.eINSTANCE.createTransient();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

keywordvolatile returns [org.emftext.language.java.modifiers.Volatile element = null]
@init{
}
:
	a0 = 'volatile' {
		if (element == null) {
			element = org.emftext.language.java.modifiers.ModifiersFactory.eINSTANCE.createVolatile();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

keywordstrictfp returns [org.emftext.language.java.modifiers.Strictfp element = null]
@init{
}
:
	a0 = 'strictfp' {
		if (element == null) {
			element = org.emftext.language.java.modifiers.ModifiersFactory.eINSTANCE.createStrictfp();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

keywordvoid returns [org.emftext.language.java.types.Void element = null]
@init{
}
:
	a0 = 'void' {
		if (element == null) {
			element = org.emftext.language.java.types.TypesFactory.eINSTANCE.createVoid();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

keywordboolean returns [org.emftext.language.java.types.Boolean element = null]
@init{
}
:
	a0 = 'boolean' {
		if (element == null) {
			element = org.emftext.language.java.types.TypesFactory.eINSTANCE.createBoolean();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

keywordchar returns [org.emftext.language.java.types.Char element = null]
@init{
}
:
	a0 = 'char' {
		if (element == null) {
			element = org.emftext.language.java.types.TypesFactory.eINSTANCE.createChar();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

keywordbyte returns [org.emftext.language.java.types.Byte element = null]
@init{
}
:
	a0 = 'byte' {
		if (element == null) {
			element = org.emftext.language.java.types.TypesFactory.eINSTANCE.createByte();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

keywordshort returns [org.emftext.language.java.types.Short element = null]
@init{
}
:
	a0 = 'short' {
		if (element == null) {
			element = org.emftext.language.java.types.TypesFactory.eINSTANCE.createShort();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

keywordint returns [org.emftext.language.java.types.Int element = null]
@init{
}
:
	a0 = 'int' {
		if (element == null) {
			element = org.emftext.language.java.types.TypesFactory.eINSTANCE.createInt();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

keywordlong returns [org.emftext.language.java.types.Long element = null]
@init{
}
:
	a0 = 'long' {
		if (element == null) {
			element = org.emftext.language.java.types.TypesFactory.eINSTANCE.createLong();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

keywordfloat returns [org.emftext.language.java.types.Float element = null]
@init{
}
:
	a0 = 'float' {
		if (element == null) {
			element = org.emftext.language.java.types.TypesFactory.eINSTANCE.createFloat();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

keyworddouble returns [org.emftext.language.java.types.Double element = null]
@init{
}
:
	a0 = 'double' {
		if (element == null) {
			element = org.emftext.language.java.types.TypesFactory.eINSTANCE.createDouble();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

decimallongliteral returns [org.emftext.language.java.literals.DecimalLongLiteral element = null]
@init{
}
:
	(
		a0 = DECIMAL_LONG_LITERAL		
		{
			if (element == null) {
				element = org.emftext.language.java.literals.LiteralsFactory.eINSTANCE.createDecimalLongLiteral();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DECIMAL_LONG_LITERAL");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.literals.LiteralsPackage.DECIMAL_LONG_LITERAL__VALUE), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
			}
			java.lang.Long resolved = (java.lang.Long)resolvedObject;
			if (resolved != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.literals.LiteralsPackage.DECIMAL_LONG_LITERAL__VALUE), resolved);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a0, element);
		}
	)
	
;

decimalfloatliteral returns [org.emftext.language.java.literals.DecimalFloatLiteral element = null]
@init{
}
:
	(
		a0 = DECIMAL_FLOAT_LITERAL		
		{
			if (element == null) {
				element = org.emftext.language.java.literals.LiteralsFactory.eINSTANCE.createDecimalFloatLiteral();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DECIMAL_FLOAT_LITERAL");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.literals.LiteralsPackage.DECIMAL_FLOAT_LITERAL__VALUE), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
			}
			java.lang.Float resolved = (java.lang.Float)resolvedObject;
			if (resolved != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.literals.LiteralsPackage.DECIMAL_FLOAT_LITERAL__VALUE), resolved);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a0, element);
		}
	)
	
;

decimalintegerliteral returns [org.emftext.language.java.literals.DecimalIntegerLiteral element = null]
@init{
}
:
	(
		a0 = DECIMAL_INTEGER_LITERAL		
		{
			if (element == null) {
				element = org.emftext.language.java.literals.LiteralsFactory.eINSTANCE.createDecimalIntegerLiteral();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DECIMAL_INTEGER_LITERAL");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.literals.LiteralsPackage.DECIMAL_INTEGER_LITERAL__VALUE), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
			}
			java.lang.Integer resolved = (java.lang.Integer)resolvedObject;
			if (resolved != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.literals.LiteralsPackage.DECIMAL_INTEGER_LITERAL__VALUE), resolved);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a0, element);
		}
	)
	
;

decimaldoubleliteral returns [org.emftext.language.java.literals.DecimalDoubleLiteral element = null]
@init{
}
:
	(
		a0 = DECIMAL_DOUBLE_LITERAL		
		{
			if (element == null) {
				element = org.emftext.language.java.literals.LiteralsFactory.eINSTANCE.createDecimalDoubleLiteral();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DECIMAL_DOUBLE_LITERAL");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.literals.LiteralsPackage.DECIMAL_DOUBLE_LITERAL__VALUE), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
			}
			java.lang.Double resolved = (java.lang.Double)resolvedObject;
			if (resolved != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.literals.LiteralsPackage.DECIMAL_DOUBLE_LITERAL__VALUE), resolved);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a0, element);
		}
	)
	
;

hexlongliteral returns [org.emftext.language.java.literals.HexLongLiteral element = null]
@init{
}
:
	(
		a0 = HEX_LONG_LITERAL		
		{
			if (element == null) {
				element = org.emftext.language.java.literals.LiteralsFactory.eINSTANCE.createHexLongLiteral();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("HEX_LONG_LITERAL");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.literals.LiteralsPackage.HEX_LONG_LITERAL__VALUE), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
			}
			java.lang.Long resolved = (java.lang.Long)resolvedObject;
			if (resolved != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.literals.LiteralsPackage.HEX_LONG_LITERAL__VALUE), resolved);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a0, element);
		}
	)
	
;

hexfloatliteral returns [org.emftext.language.java.literals.HexFloatLiteral element = null]
@init{
}
:
	(
		a0 = HEX_FLOAT_LITERAL		
		{
			if (element == null) {
				element = org.emftext.language.java.literals.LiteralsFactory.eINSTANCE.createHexFloatLiteral();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("HEX_FLOAT_LITERAL");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.literals.LiteralsPackage.HEX_FLOAT_LITERAL__VALUE), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
			}
			java.lang.Float resolved = (java.lang.Float)resolvedObject;
			if (resolved != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.literals.LiteralsPackage.HEX_FLOAT_LITERAL__VALUE), resolved);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a0, element);
		}
	)
	
;

hexdoubleliteral returns [org.emftext.language.java.literals.HexDoubleLiteral element = null]
@init{
}
:
	(
		a0 = HEX_DOUBLE_LITERAL		
		{
			if (element == null) {
				element = org.emftext.language.java.literals.LiteralsFactory.eINSTANCE.createHexDoubleLiteral();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("HEX_DOUBLE_LITERAL");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.literals.LiteralsPackage.HEX_DOUBLE_LITERAL__VALUE), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
			}
			java.lang.Double resolved = (java.lang.Double)resolvedObject;
			if (resolved != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.literals.LiteralsPackage.HEX_DOUBLE_LITERAL__VALUE), resolved);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a0, element);
		}
	)
	
;

hexintegerliteral returns [org.emftext.language.java.literals.HexIntegerLiteral element = null]
@init{
}
:
	(
		a0 = HEX_INTEGER_LITERAL		
		{
			if (element == null) {
				element = org.emftext.language.java.literals.LiteralsFactory.eINSTANCE.createHexIntegerLiteral();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("HEX_INTEGER_LITERAL");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.literals.LiteralsPackage.HEX_INTEGER_LITERAL__VALUE), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
			}
			java.lang.Integer resolved = (java.lang.Integer)resolvedObject;
			if (resolved != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.literals.LiteralsPackage.HEX_INTEGER_LITERAL__VALUE), resolved);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a0, element);
		}
	)
	
;

octallongliteral returns [org.emftext.language.java.literals.OctalLongLiteral element = null]
@init{
}
:
	(
		a0 = OCTAL_LONG_LITERAL		
		{
			if (element == null) {
				element = org.emftext.language.java.literals.LiteralsFactory.eINSTANCE.createOctalLongLiteral();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("OCTAL_LONG_LITERAL");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.literals.LiteralsPackage.OCTAL_LONG_LITERAL__VALUE), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
			}
			java.lang.Long resolved = (java.lang.Long)resolvedObject;
			if (resolved != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.literals.LiteralsPackage.OCTAL_LONG_LITERAL__VALUE), resolved);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a0, element);
		}
	)
	
;

octalintegerliteral returns [org.emftext.language.java.literals.OctalIntegerLiteral element = null]
@init{
}
:
	(
		a0 = OCTAL_INTEGER_LITERAL		
		{
			if (element == null) {
				element = org.emftext.language.java.literals.LiteralsFactory.eINSTANCE.createOctalIntegerLiteral();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("OCTAL_INTEGER_LITERAL");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.literals.LiteralsPackage.OCTAL_INTEGER_LITERAL__VALUE), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
			}
			java.lang.Integer resolved = (java.lang.Integer)resolvedObject;
			if (resolved != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.literals.LiteralsPackage.OCTAL_INTEGER_LITERAL__VALUE), resolved);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a0, element);
		}
	)
	
;

characterliteral returns [org.emftext.language.java.literals.CharacterLiteral element = null]
@init{
}
:
	(
		a0 = CHARACTER_LITERAL		
		{
			if (element == null) {
				element = org.emftext.language.java.literals.LiteralsFactory.eINSTANCE.createCharacterLiteral();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("CHARACTER_LITERAL");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.literals.LiteralsPackage.CHARACTER_LITERAL__VALUE), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
			}
			java.lang.Character resolved = (java.lang.Character)resolvedObject;
			if (resolved != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.literals.LiteralsPackage.CHARACTER_LITERAL__VALUE), resolved);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a0, element);
		}
	)
	
;

booleanliteral returns [org.emftext.language.java.literals.BooleanLiteral element = null]
@init{
}
:
	(
		a0 = BOOLEAN_LITERAL		
		{
			if (element == null) {
				element = org.emftext.language.java.literals.LiteralsFactory.eINSTANCE.createBooleanLiteral();
			}
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("BOOLEAN_LITERAL");
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.java.literals.LiteralsPackage.BOOLEAN_LITERAL__VALUE), result);
			Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				getResource().addError(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
			}
			java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;
			if (resolved != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.java.literals.LiteralsPackage.BOOLEAN_LITERAL__VALUE), resolved);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a0, element);
		}
	)
	
;

keywordimport returns [org.emftext.language.java.imports.Import element = null]
:
	c0 = classifierimport{ element = c0; }
	|	c1 = packageimport{ element = c1; }
	|	c2 = staticmemberimport{ element = c2; }
	|	c3 = staticclassifierimport{ element = c3; }
	
;

concreteclassifier returns [org.emftext.language.java.classifiers.ConcreteClassifier element = null]
:
	c0 = keywordclass{ element = c0; }
	|	c1 = keywordinterface{ element = c1; }
	|	c2 = enumeration{ element = c2; }
	|	c3 = annotation{ element = c3; }
	
;

annotationinstanceormodifier returns [org.emftext.language.java.modifiers.AnnotationInstanceOrModifier element = null]
:
	c0 = annotationinstance{ element = c0; }
	|	c1 = keywordpublic{ element = c1; }
	|	c2 = keywordabstract{ element = c2; }
	|	c3 = keywordprotected{ element = c3; }
	|	c4 = keywordprivate{ element = c4; }
	|	c5 = keywordfinal{ element = c5; }
	|	c6 = keywordstatic{ element = c6; }
	|	c7 = keywordnative{ element = c7; }
	|	c8 = keywordsynchronized{ element = c8; }
	|	c9 = keywordtransient{ element = c9; }
	|	c10 = keywordvolatile{ element = c10; }
	|	c11 = keywordstrictfp{ element = c11; }
	
;

typereference returns [org.emftext.language.java.types.TypeReference element = null]
:
	c0 = namespaceclassifierreference{ element = c0; }
	|	c1 = classifierreference{ element = c1; }
	|	c2 = keywordvoid{ element = c2; }
	|	c3 = keywordboolean{ element = c3; }
	|	c4 = keywordchar{ element = c4; }
	|	c5 = keywordbyte{ element = c5; }
	|	c6 = keywordshort{ element = c6; }
	|	c7 = keywordint{ element = c7; }
	|	c8 = keywordlong{ element = c8; }
	|	c9 = keywordfloat{ element = c9; }
	|	c10 = keyworddouble{ element = c10; }
	
;

member returns [org.emftext.language.java.members.Member element = null]
:
	c0 = keywordclass{ element = c0; }
	|	c1 = keywordinterface{ element = c1; }
	|	c2 = enumeration{ element = c2; }
	|	c3 = annotation{ element = c3; }
	|	c4 = block{ element = c4; }
	|	c5 = constructor{ element = c5; }
	|	c6 = interfacemethod{ element = c6; }
	|	c7 = classmethod{ element = c7; }
	|	c8 = annotationattribute{ element = c8; }
	|	c9 = field{ element = c9; }
	|	c10 = emptymember{ element = c10; }
	
;

annotationparameter returns [org.emftext.language.java.annotations.AnnotationParameter element = null]
:
	c0 = singleannotationparameter{ element = c0; }
	|	c1 = annotationparameterlist{ element = c1; }
	
;

modifier returns [org.emftext.language.java.modifiers.Modifier element = null]
:
	c0 = keywordpublic{ element = c0; }
	|	c1 = keywordabstract{ element = c1; }
	|	c2 = keywordprotected{ element = c2; }
	|	c3 = keywordprivate{ element = c3; }
	|	c4 = keywordfinal{ element = c4; }
	|	c5 = keywordstatic{ element = c5; }
	|	c6 = keywordnative{ element = c6; }
	|	c7 = keywordsynchronized{ element = c7; }
	|	c8 = keywordtransient{ element = c8; }
	|	c9 = keywordvolatile{ element = c9; }
	|	c10 = keywordstrictfp{ element = c10; }
	
;

statement returns [org.emftext.language.java.statements.Statement element = null]
:
	c0 = keywordclass{ element = c0; }
	|	c1 = keywordinterface{ element = c1; }
	|	c2 = enumeration{ element = c2; }
	|	c3 = annotation{ element = c3; }
	|	c4 = block{ element = c4; }
	|	c5 = localvariablestatement{ element = c5; }
	|	c6 = keywordassert{ element = c6; }
	|	c7 = condition{ element = c7; }
	|	c8 = forloop{ element = c8; }
	|	c9 = foreachloop{ element = c9; }
	|	c10 = whileloop{ element = c10; }
	|	c11 = dowhileloop{ element = c11; }
	|	c12 = emptystatement{ element = c12; }
	|	c13 = synchronizedblock{ element = c13; }
	|	c14 = tryblock{ element = c14; }
	|	c15 = keywordswitch{ element = c15; }
	|	c16 = keywordreturn{ element = c16; }
	|	c17 = keywordthrow{ element = c17; }
	|	c18 = keywordbreak{ element = c18; }
	|	c19 = keywordcontinue{ element = c19; }
	|	c20 = jumplabel{ element = c20; }
	|	c21 = expressionstatement{ element = c21; }
	
;

parameter returns [org.emftext.language.java.parameters.Parameter element = null]
:
	c0 = ordinaryparameter{ element = c0; }
	|	c1 = variablelengthparameter{ element = c1; }
	
;

typeargument returns [org.emftext.language.java.generics.TypeArgument element = null]
:
	c0 = qualifiedtypeargument{ element = c0; }
	|	c1 = unknowntypeargument{ element = c1; }
	|	c2 = extendstypeargument{ element = c2; }
	|	c3 = supertypeargument{ element = c3; }
	
;

reference returns [org.emftext.language.java.references.Reference element = null]
:
	c0 = annotationinstance{ element = c0; }
	|	c1 = newconstructorcall{ element = c1; }
	|	c2 = explicitconstructorcall{ element = c2; }
	|	c3 = arrayinstantiationbyvalues{ element = c3; }
	|	c4 = arrayinstantiationbysize{ element = c4; }
	|	c5 = methodcall{ element = c5; }
	|	c6 = identifierreference{ element = c6; }
	|	c7 = reflectiveclassreference{ element = c7; }
	|	c8 = selfreference{ element = c8; }
	|	c9 = primitivetypereference{ element = c9; }
	|	c10 = stringreference{ element = c10; }
	|	c11 = nestedexpression{ element = c11; }
	
;

self returns [org.emftext.language.java.literals.Self element = null]
:
	c0 = keywordthis{ element = c0; }
	|	c1 = keywordsuper{ element = c1; }
	
;

primitivetype returns [org.emftext.language.java.types.PrimitiveType element = null]
:
	c0 = keywordvoid{ element = c0; }
	|	c1 = keywordboolean{ element = c1; }
	|	c2 = keywordchar{ element = c2; }
	|	c3 = keywordbyte{ element = c3; }
	|	c4 = keywordshort{ element = c4; }
	|	c5 = keywordint{ element = c5; }
	|	c6 = keywordlong{ element = c6; }
	|	c7 = keywordfloat{ element = c7; }
	|	c8 = keyworddouble{ element = c8; }
	
;

forloopinitializer returns [org.emftext.language.java.statements.ForLoopInitializer element = null]
:
	c0 = localvariable{ element = c0; }
	|	c1 = expressionlist{ element = c1; }
	
;

switchcase returns [org.emftext.language.java.statements.SwitchCase element = null]
:
	c0 = normalswitchcase{ element = c0; }
	|	c1 = defaultswitchcase{ element = c1; }
	
;

assignmentoperator returns [org.emftext.language.java.operators.AssignmentOperator element = null]
:
	c0 = assignment{ element = c0; }
	|	c1 = assignmentplus{ element = c1; }
	|	c2 = assignmentminus{ element = c2; }
	|	c3 = assignmentmultiplication{ element = c3; }
	|	c4 = assignmentdivision{ element = c4; }
	|	c5 = assignmentand{ element = c5; }
	|	c6 = assignmentor{ element = c6; }
	|	c7 = assignmentexclusiveor{ element = c7; }
	|	c8 = assignmentmodulo{ element = c8; }
	|	c9 = assignmentleftshift{ element = c9; }
	|	c10 = assignmentrightshift{ element = c10; }
	|	c11 = assignmentunsignedrightshift{ element = c11; }
	
;

equalityoperator returns [org.emftext.language.java.operators.EqualityOperator element = null]
:
	c0 = equal{ element = c0; }
	|	c1 = notequal{ element = c1; }
	
;

relationoperator returns [org.emftext.language.java.operators.RelationOperator element = null]
:
	c0 = lessthan{ element = c0; }
	|	c1 = lessthanorequal{ element = c1; }
	|	c2 = greaterthan{ element = c2; }
	|	c3 = greaterthanorequal{ element = c3; }
	
;

shiftoperator returns [org.emftext.language.java.operators.ShiftOperator element = null]
:
	c0 = leftshift{ element = c0; }
	|	c1 = rightshift{ element = c1; }
	|	c2 = unsignedrightshift{ element = c2; }
	
;

additiveoperator returns [org.emftext.language.java.operators.AdditiveOperator element = null]
:
	c0 = addition{ element = c0; }
	|	c1 = subtraction{ element = c1; }
	
;

multiplicativeoperator returns [org.emftext.language.java.operators.MultiplicativeOperator element = null]
:
	c0 = multiplication{ element = c0; }
	|	c1 = division{ element = c1; }
	|	c2 = remainder{ element = c2; }
	
;

unaryoperator returns [org.emftext.language.java.operators.UnaryOperator element = null]
:
	c0 = addition{ element = c0; }
	|	c1 = subtraction{ element = c1; }
	|	c2 = complement{ element = c2; }
	|	c3 = negate{ element = c3; }
	
;

unarymodificationexpression returns [org.emftext.language.java.expressions.UnaryModificationExpression element = null]
:
	c0 = suffixunarymodificationexpression{ element = c0; }
	|	c1 = prefixunarymodificationexpression{ element = c1; }
	
;

unarymodificationexpressionchild returns [org.emftext.language.java.expressions.UnaryModificationExpressionChild element = null]
:
	c0 = annotationinstance{ element = c0; }
	|	c1 = newconstructorcall{ element = c1; }
	|	c2 = explicitconstructorcall{ element = c2; }
	|	c3 = arrayinstantiationbyvalues{ element = c3; }
	|	c4 = arrayinstantiationbysize{ element = c4; }
	|	c5 = methodcall{ element = c5; }
	|	c6 = identifierreference{ element = c6; }
	|	c7 = reflectiveclassreference{ element = c7; }
	|	c8 = selfreference{ element = c8; }
	|	c9 = primitivetypereference{ element = c9; }
	|	c10 = stringreference{ element = c10; }
	|	c11 = castexpression{ element = c11; }
	|	c12 = nestedexpression{ element = c12; }
	|	c13 = nullliteral{ element = c13; }
	|	c14 = decimallongliteral{ element = c14; }
	|	c15 = decimalfloatliteral{ element = c15; }
	|	c16 = decimalintegerliteral{ element = c16; }
	|	c17 = decimaldoubleliteral{ element = c17; }
	|	c18 = hexlongliteral{ element = c18; }
	|	c19 = hexfloatliteral{ element = c19; }
	|	c20 = hexdoubleliteral{ element = c20; }
	|	c21 = hexintegerliteral{ element = c21; }
	|	c22 = octallongliteral{ element = c22; }
	|	c23 = octalintegerliteral{ element = c23; }
	|	c24 = characterliteral{ element = c24; }
	|	c25 = booleanliteral{ element = c25; }
	
;

unarymodificationoperator returns [org.emftext.language.java.operators.UnaryModificationOperator element = null]
:
	c0 = plusplus{ element = c0; }
	|	c1 = minusminus{ element = c1; }
	
;

SL_COMMENT:
	'//'(~('\n'|'\r'|'\uffff'))* 
	{ _channel = 99; }
;
ML_COMMENT:
	'/*'.*'*/'	{ _channel = 99; }
;
BOOLEAN_LITERAL:
	'true'|'false';
CHARACTER_LITERAL:
	'\''('\\'('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')|('\\''u'('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F'))|('\\'('0'..'3')('0'..'7')('0'..'7')|'\\'('0'..'7')('0'..'7')|'\\'('0'..'7'))|~('\''|'\\'))'\'';
STRING_LITERAL:
	'"'('\\'('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')|('\\''u'('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F'))|'\\'('0'..'7')|~('\\'|'"'))*'"';
IDENTIFIER:
	('\u0024'|'\u0041'..'\u005a'|'\u005f'|'\u0061'..'\u007a'|'\u00a2'..'\u00a5'|'\u00aa'|'\u00b5'|'\u00ba'|'\u00c0'..'\u00d6'|'\u00d8'..'\u00f6'|'\u00f8'..'\u0236'|'\u0250'..'\u02c1'|'\u02c6'..'\u02d1'|'\u02e0'..'\u02e4'|'\u02ee'|'\u037a'|'\u0386'|'\u0388'..'\u038a'|'\u038c'|'\u038e'..'\u03a1'|'\u03a3'..'\u03ce'|'\u03d0'..'\u03f5'|'\u03f7'..'\u03fb'|'\u0400'..'\u0481'|'\u048a'..'\u04ce'|'\u04d0'..'\u04f5'|'\u04f8'..'\u04f9'|'\u0500'..'\u050f'|'\u0531'..'\u0556'|'\u0559'|'\u0561'..'\u0587'|'\u05d0'..'\u05ea'|'\u05f0'..'\u05f2'|'\u0621'..'\u063a'|'\u0640'..'\u064a'|'\u066e'..'\u066f'|'\u0671'..'\u06d3'|'\u06d5'|'\u06e5'..'\u06e6'|'\u06ee'..'\u06ef'|'\u06fa'..'\u06fc'|'\u06ff'|'\u0710'|'\u0712'..'\u072f'|'\u074d'..'\u074f'|'\u0780'..'\u07a5'|'\u07b1'|'\u0904'..'\u0939'|'\u093d'|'\u0950'|'\u0958'..'\u0961'|'\u0985'..'\u098c'|'\u098f'..'\u0990'|'\u0993'..'\u09a8'|'\u09aa'..'\u09b0'|'\u09b2'|'\u09b6'..'\u09b9'|'\u09bd'|'\u09dc'..'\u09dd'|'\u09df'..'\u09e1'|'\u09f0'..'\u09f3'|'\u0a05'..'\u0a0a'|'\u0a0f'..'\u0a10'|'\u0a13'..'\u0a28'|'\u0a2a'..'\u0a30'|'\u0a32'..'\u0a33'|'\u0a35'..'\u0a36'|'\u0a38'..'\u0a39'|'\u0a59'..'\u0a5c'|'\u0a5e'|'\u0a72'..'\u0a74'|'\u0a85'..'\u0a8d'|'\u0a8f'..'\u0a91'|'\u0a93'..'\u0aa8'|'\u0aaa'..'\u0ab0'|'\u0ab2'..'\u0ab3'|'\u0ab5'..'\u0ab9'|'\u0abd'|'\u0ad0'|'\u0ae0'..'\u0ae1'|'\u0af1'|'\u0b05'..'\u0b0c'|'\u0b0f'..'\u0b10'|'\u0b13'..'\u0b28'|'\u0b2a'..'\u0b30'|'\u0b32'..'\u0b33'|'\u0b35'..'\u0b39'|'\u0b3d'|'\u0b5c'..'\u0b5d'|'\u0b5f'..'\u0b61'|'\u0b71'|'\u0b83'|'\u0b85'..'\u0b8a'|'\u0b8e'..'\u0b90'|'\u0b92'..'\u0b95'|'\u0b99'..'\u0b9a'|'\u0b9c'|'\u0b9e'..'\u0b9f'|'\u0ba3'..'\u0ba4'|'\u0ba8'..'\u0baa'|'\u0bae'..'\u0bb5'|'\u0bb7'..'\u0bb9'|'\u0bf9'|'\u0c05'..'\u0c0c'|'\u0c0e'..'\u0c10'|'\u0c12'..'\u0c28'|'\u0c2a'..'\u0c33'|'\u0c35'..'\u0c39'|'\u0c60'..'\u0c61'|'\u0c85'..'\u0c8c'|'\u0c8e'..'\u0c90'|'\u0c92'..'\u0ca8'|'\u0caa'..'\u0cb3'|'\u0cb5'..'\u0cb9'|'\u0cbd'|'\u0cde'|'\u0ce0'..'\u0ce1'|'\u0d05'..'\u0d0c'|'\u0d0e'..'\u0d10'|'\u0d12'..'\u0d28'|'\u0d2a'..'\u0d39'|'\u0d60'..'\u0d61'|'\u0d85'..'\u0d96'|'\u0d9a'..'\u0db1'|'\u0db3'..'\u0dbb'|'\u0dbd'|'\u0dc0'..'\u0dc6'|'\u0e01'..'\u0e30'|'\u0e32'..'\u0e33'|'\u0e3f'..'\u0e46'|'\u0e81'..'\u0e82'|'\u0e84'|'\u0e87'..'\u0e88'|'\u0e8a'|'\u0e8d'|'\u0e94'..'\u0e97'|'\u0e99'..'\u0e9f'|'\u0ea1'..'\u0ea3'|'\u0ea5'|'\u0ea7'|'\u0eaa'..'\u0eab'|'\u0ead'..'\u0eb0'|'\u0eb2'..'\u0eb3'|'\u0ebd'|'\u0ec0'..'\u0ec4'|'\u0ec6'|'\u0edc'..'\u0edd'|'\u0f00'|'\u0f40'..'\u0f47'|'\u0f49'..'\u0f6a'|'\u0f88'..'\u0f8b'|'\u1000'..'\u1021'|'\u1023'..'\u1027'|'\u1029'..'\u102a'|'\u1050'..'\u1055'|'\u10a0'..'\u10c5'|'\u10d0'..'\u10f8'|'\u1100'..'\u1159'|'\u115f'..'\u11a2'|'\u11a8'..'\u11f9'|'\u1200'..'\u1206'|'\u1208'..'\u1246'|'\u1248'|'\u124a'..'\u124d'|'\u1250'..'\u1256'|'\u1258'|'\u125a'..'\u125d'|'\u1260'..'\u1286'|'\u1288'|'\u128a'..'\u128d'|'\u1290'..'\u12ae'|'\u12b0'|'\u12b2'..'\u12b5'|'\u12b8'..'\u12be'|'\u12c0'|'\u12c2'..'\u12c5'|'\u12c8'..'\u12ce'|'\u12d0'..'\u12d6'|'\u12d8'..'\u12ee'|'\u12f0'..'\u130e'|'\u1310'|'\u1312'..'\u1315'|'\u1318'..'\u131e'|'\u1320'..'\u1346'|'\u1348'..'\u135a'|'\u13a0'..'\u13f4'|'\u1401'..'\u166c'|'\u166f'..'\u1676'|'\u1681'..'\u169a'|'\u16a0'..'\u16ea'|'\u16ee'..'\u16f0'|'\u1700'..'\u170c'|'\u170e'..'\u1711'|'\u1720'..'\u1731'|'\u1740'..'\u1751'|'\u1760'..'\u176c'|'\u176e'..'\u1770'|'\u1780'..'\u17b3'|'\u17d7'|'\u17db'..'\u17dc'|'\u1820'..'\u1877'|'\u1880'..'\u18a8'|'\u1900'..'\u191c'|'\u1950'..'\u196d'|'\u1970'..'\u1974'|'\u1d00'..'\u1d6b'|'\u1e00'..'\u1e9b'|'\u1ea0'..'\u1ef9'|'\u1f00'..'\u1f15'|'\u1f18'..'\u1f1d'|'\u1f20'..'\u1f45'|'\u1f48'..'\u1f4d'|'\u1f50'..'\u1f57'|'\u1f59'|'\u1f5b'|'\u1f5d'|'\u1f5f'..'\u1f7d'|'\u1f80'..'\u1fb4'|'\u1fb6'..'\u1fbc'|'\u1fbe'|'\u1fc2'..'\u1fc4'|'\u1fc6'..'\u1fcc'|'\u1fd0'..'\u1fd3'|'\u1fd6'..'\u1fdb'|'\u1fe0'..'\u1fec'|'\u1ff2'..'\u1ff4'|'\u1ff6'..'\u1ffc'|'\u203f'..'\u2040'|'\u2054'|'\u2071'|'\u207f'|'\u20a0'..'\u20b1'|'\u2102'|'\u2107'|'\u210a'..'\u2113'|'\u2115'|'\u2119'..'\u211d'|'\u2124'|'\u2126'|'\u2128'|'\u212a'..'\u212d'|'\u212f'..'\u2131'|'\u2133'..'\u2139'|'\u213d'..'\u213f'|'\u2145'..'\u2149'|'\u2160'..'\u2183'|'\u3005'..'\u3007'|'\u3021'..'\u3029'|'\u3031'..'\u3035'|'\u3038'..'\u303c'|'\u3041'..'\u3096'|'\u309d'..'\u309f'|'\u30a1'..'\u30ff'|'\u3105'..'\u312c'|'\u3131'..'\u318e'|'\u31a0'..'\u31b7'|'\u31f0'..'\u31ff'|'\u3400'..'\u4db5'|'\u4e00'..'\u9fa5'|'\ua000'..'\ua48c'|'\uac00'..'\ud7a3'|'\ud800'..'\udbff'|'\uf900'..'\ufa2d'|'\ufa30'..'\ufa6a'|'\ufb00'..'\ufb06'|'\ufb13'..'\ufb17'|'\ufb1d'|'\ufb1f'..'\ufb28'|'\ufb2a'..'\ufb36'|'\ufb38'..'\ufb3c'|'\ufb3e'|'\ufb40'..'\ufb41'|'\ufb43'..'\ufb44'|'\ufb46'..'\ufbb1'|'\ufbd3'..'\ufd3d'|'\ufd50'..'\ufd8f'|'\ufd92'..'\ufdc7'|'\ufdf0'..'\ufdfc'|'\ufe33'..'\ufe34'|'\ufe4d'..'\ufe4f'|'\ufe69'|'\ufe70'..'\ufe74'|'\ufe76'..'\ufefc'|'\uff04'|'\uff21'..'\uff3a'|'\uff3f'|'\uff41'..'\uff5a'|'\uff65'..'\uffbe'|'\uffc2'..'\uffc7'|'\uffca'..'\uffcf'|'\uffd2'..'\uffd7'|'\uffda'..'\uffdc'|'\uffe0'..'\uffe1'|'\uffe5'..'\uffe6')('\u0000'..'\u0008'|'\u000e'..'\u001b'|'\u0024'|'\u0030'..'\u0039'|'\u0041'..'\u005a'|'\u005f'|'\u0061'..'\u007a'|'\u007f'..'\u009f'|'\u00a2'..'\u00a5'|'\u00aa'|'\u00ad'|'\u00b5'|'\u00ba'|'\u00c0'..'\u00d6'|'\u00d8'..'\u00f6'|'\u00f8'..'\u0236'|'\u0250'..'\u02c1'|'\u02c6'..'\u02d1'|'\u02e0'..'\u02e4'|'\u02ee'|'\u0300'..'\u0357'|'\u035d'..'\u036f'|'\u037a'|'\u0386'|'\u0388'..'\u038a'|'\u038c'|'\u038e'..'\u03a1'|'\u03a3'..'\u03ce'|'\u03d0'..'\u03f5'|'\u03f7'..'\u03fb'|'\u0400'..'\u0481'|'\u0483'..'\u0486'|'\u048a'..'\u04ce'|'\u04d0'..'\u04f5'|'\u04f8'..'\u04f9'|'\u0500'..'\u050f'|'\u0531'..'\u0556'|'\u0559'|'\u0561'..'\u0587'|'\u0591'..'\u05a1'|'\u05a3'..'\u05b9'|'\u05bb'..'\u05bd'|'\u05bf'|'\u05c1'..'\u05c2'|'\u05c4'|'\u05d0'..'\u05ea'|'\u05f0'..'\u05f2'|'\u0600'..'\u0603'|'\u0610'..'\u0615'|'\u0621'..'\u063a'|'\u0640'..'\u0658'|'\u0660'..'\u0669'|'\u066e'..'\u06d3'|'\u06d5'..'\u06dd'|'\u06df'..'\u06e8'|'\u06ea'..'\u06fc'|'\u06ff'|'\u070f'..'\u074a'|'\u074d'..'\u074f'|'\u0780'..'\u07b1'|'\u0901'..'\u0939'|'\u093c'..'\u094d'|'\u0950'..'\u0954'|'\u0958'..'\u0963'|'\u0966'..'\u096f'|'\u0981'..'\u0983'|'\u0985'..'\u098c'|'\u098f'..'\u0990'|'\u0993'..'\u09a8'|'\u09aa'..'\u09b0'|'\u09b2'|'\u09b6'..'\u09b9'|'\u09bc'..'\u09c4'|'\u09c7'..'\u09c8'|'\u09cb'..'\u09cd'|'\u09d7'|'\u09dc'..'\u09dd'|'\u09df'..'\u09e3'|'\u09e6'..'\u09f3'|'\u0a01'..'\u0a03'|'\u0a05'..'\u0a0a'|'\u0a0f'..'\u0a10'|'\u0a13'..'\u0a28'|'\u0a2a'..'\u0a30'|'\u0a32'..'\u0a33'|'\u0a35'..'\u0a36'|'\u0a38'..'\u0a39'|'\u0a3c'|'\u0a3e'..'\u0a42'|'\u0a47'..'\u0a48'|'\u0a4b'..'\u0a4d'|'\u0a59'..'\u0a5c'|'\u0a5e'|'\u0a66'..'\u0a74'|'\u0a81'..'\u0a83'|'\u0a85'..'\u0a8d'|'\u0a8f'..'\u0a91'|'\u0a93'..'\u0aa8'|'\u0aaa'..'\u0ab0'|'\u0ab2'..'\u0ab3'|'\u0ab5'..'\u0ab9'|'\u0abc'..'\u0ac5'|'\u0ac7'..'\u0ac9'|'\u0acb'..'\u0acd'|'\u0ad0'|'\u0ae0'..'\u0ae3'|'\u0ae6'..'\u0aef'|'\u0af1'|'\u0b01'..'\u0b03'|'\u0b05'..'\u0b0c'|'\u0b0f'..'\u0b10'|'\u0b13'..'\u0b28'|'\u0b2a'..'\u0b30'|'\u0b32'..'\u0b33'|'\u0b35'..'\u0b39'|'\u0b3c'..'\u0b43'|'\u0b47'..'\u0b48'|'\u0b4b'..'\u0b4d'|'\u0b56'..'\u0b57'|'\u0b5c'..'\u0b5d'|'\u0b5f'..'\u0b61'|'\u0b66'..'\u0b6f'|'\u0b71'|'\u0b82'..'\u0b83'|'\u0b85'..'\u0b8a'|'\u0b8e'..'\u0b90'|'\u0b92'..'\u0b95'|'\u0b99'..'\u0b9a'|'\u0b9c'|'\u0b9e'..'\u0b9f'|'\u0ba3'..'\u0ba4'|'\u0ba8'..'\u0baa'|'\u0bae'..'\u0bb5'|'\u0bb7'..'\u0bb9'|'\u0bbe'..'\u0bc2'|'\u0bc6'..'\u0bc8'|'\u0bca'..'\u0bcd'|'\u0bd7'|'\u0be7'..'\u0bef'|'\u0bf9'|'\u0c01'..'\u0c03'|'\u0c05'..'\u0c0c'|'\u0c0e'..'\u0c10'|'\u0c12'..'\u0c28'|'\u0c2a'..'\u0c33'|'\u0c35'..'\u0c39'|'\u0c3e'..'\u0c44'|'\u0c46'..'\u0c48'|'\u0c4a'..'\u0c4d'|'\u0c55'..'\u0c56'|'\u0c60'..'\u0c61'|'\u0c66'..'\u0c6f'|'\u0c82'..'\u0c83'|'\u0c85'..'\u0c8c'|'\u0c8e'..'\u0c90'|'\u0c92'..'\u0ca8'|'\u0caa'..'\u0cb3'|'\u0cb5'..'\u0cb9'|'\u0cbc'..'\u0cc4'|'\u0cc6'..'\u0cc8'|'\u0cca'..'\u0ccd'|'\u0cd5'..'\u0cd6'|'\u0cde'|'\u0ce0'..'\u0ce1'|'\u0ce6'..'\u0cef'|'\u0d02'..'\u0d03'|'\u0d05'..'\u0d0c'|'\u0d0e'..'\u0d10'|'\u0d12'..'\u0d28'|'\u0d2a'..'\u0d39'|'\u0d3e'..'\u0d43'|'\u0d46'..'\u0d48'|'\u0d4a'..'\u0d4d'|'\u0d57'|'\u0d60'..'\u0d61'|'\u0d66'..'\u0d6f'|'\u0d82'..'\u0d83'|'\u0d85'..'\u0d96'|'\u0d9a'..'\u0db1'|'\u0db3'..'\u0dbb'|'\u0dbd'|'\u0dc0'..'\u0dc6'|'\u0dca'|'\u0dcf'..'\u0dd4'|'\u0dd6'|'\u0dd8'..'\u0ddf'|'\u0df2'..'\u0df3'|'\u0e01'..'\u0e3a'|'\u0e3f'..'\u0e4e'|'\u0e50'..'\u0e59'|'\u0e81'..'\u0e82'|'\u0e84'|'\u0e87'..'\u0e88'|'\u0e8a'|'\u0e8d'|'\u0e94'..'\u0e97'|'\u0e99'..'\u0e9f'|'\u0ea1'..'\u0ea3'|'\u0ea5'|'\u0ea7'|'\u0eaa'..'\u0eab'|'\u0ead'..'\u0eb9'|'\u0ebb'..'\u0ebd'|'\u0ec0'..'\u0ec4'|'\u0ec6'|'\u0ec8'..'\u0ecd'|'\u0ed0'..'\u0ed9'|'\u0edc'..'\u0edd'|'\u0f00'|'\u0f18'..'\u0f19'|'\u0f20'..'\u0f29'|'\u0f35'|'\u0f37'|'\u0f39'|'\u0f3e'..'\u0f47'|'\u0f49'..'\u0f6a'|'\u0f71'..'\u0f84'|'\u0f86'..'\u0f8b'|'\u0f90'..'\u0f97'|'\u0f99'..'\u0fbc'|'\u0fc6'|'\u1000'..'\u1021'|'\u1023'..'\u1027'|'\u1029'..'\u102a'|'\u102c'..'\u1032'|'\u1036'..'\u1039'|'\u1040'..'\u1049'|'\u1050'..'\u1059'|'\u10a0'..'\u10c5'|'\u10d0'..'\u10f8'|'\u1100'..'\u1159'|'\u115f'..'\u11a2'|'\u11a8'..'\u11f9'|'\u1200'..'\u1206'|'\u1208'..'\u1246'|'\u1248'|'\u124a'..'\u124d'|'\u1250'..'\u1256'|'\u1258'|'\u125a'..'\u125d'|'\u1260'..'\u1286'|'\u1288'|'\u128a'..'\u128d'|'\u1290'..'\u12ae'|'\u12b0'|'\u12b2'..'\u12b5'|'\u12b8'..'\u12be'|'\u12c0'|'\u12c2'..'\u12c5'|'\u12c8'..'\u12ce'|'\u12d0'..'\u12d6'|'\u12d8'..'\u12ee'|'\u12f0'..'\u130e'|'\u1310'|'\u1312'..'\u1315'|'\u1318'..'\u131e'|'\u1320'..'\u1346'|'\u1348'..'\u135a'|'\u1369'..'\u1371'|'\u13a0'..'\u13f4'|'\u1401'..'\u166c'|'\u166f'..'\u1676'|'\u1681'..'\u169a'|'\u16a0'..'\u16ea'|'\u16ee'..'\u16f0'|'\u1700'..'\u170c'|'\u170e'..'\u1714'|'\u1720'..'\u1734'|'\u1740'..'\u1753'|'\u1760'..'\u176c'|'\u176e'..'\u1770'|'\u1772'..'\u1773'|'\u1780'..'\u17d3'|'\u17d7'|'\u17db'..'\u17dd'|'\u17e0'..'\u17e9'|'\u180b'..'\u180d'|'\u1810'..'\u1819'|'\u1820'..'\u1877'|'\u1880'..'\u18a9'|'\u1900'..'\u191c'|'\u1920'..'\u192b'|'\u1930'..'\u193b'|'\u1946'..'\u196d'|'\u1970'..'\u1974'|'\u1d00'..'\u1d6b'|'\u1e00'..'\u1e9b'|'\u1ea0'..'\u1ef9'|'\u1f00'..'\u1f15'|'\u1f18'..'\u1f1d'|'\u1f20'..'\u1f45'|'\u1f48'..'\u1f4d'|'\u1f50'..'\u1f57'|'\u1f59'|'\u1f5b'|'\u1f5d'|'\u1f5f'..'\u1f7d'|'\u1f80'..'\u1fb4'|'\u1fb6'..'\u1fbc'|'\u1fbe'|'\u1fc2'..'\u1fc4'|'\u1fc6'..'\u1fcc'|'\u1fd0'..'\u1fd3'|'\u1fd6'..'\u1fdb'|'\u1fe0'..'\u1fec'|'\u1ff2'..'\u1ff4'|'\u1ff6'..'\u1ffc'|'\u200c'..'\u200f'|'\u202a'..'\u202e'|'\u203f'..'\u2040'|'\u2054'|'\u2060'..'\u2063'|'\u206a'..'\u206f'|'\u2071'|'\u207f'|'\u20a0'..'\u20b1'|'\u20d0'..'\u20dc'|'\u20e1'|'\u20e5'..'\u20ea'|'\u2102'|'\u2107'|'\u210a'..'\u2113'|'\u2115'|'\u2119'..'\u211d'|'\u2124'|'\u2126'|'\u2128'|'\u212a'..'\u212d'|'\u212f'..'\u2131'|'\u2133'..'\u2139'|'\u213d'..'\u213f'|'\u2145'..'\u2149'|'\u2160'..'\u2183'|'\u3005'..'\u3007'|'\u3021'..'\u302f'|'\u3031'..'\u3035'|'\u3038'..'\u303c'|'\u3041'..'\u3096'|'\u3099'..'\u309a'|'\u309d'..'\u309f'|'\u30a1'..'\u30ff'|'\u3105'..'\u312c'|'\u3131'..'\u318e'|'\u31a0'..'\u31b7'|'\u31f0'..'\u31ff'|'\u3400'..'\u4db5'|'\u4e00'..'\u9fa5'|'\ua000'..'\ua48c'|'\uac00'..'\ud7a3'|'\ud800'..'\udfff'|'\uf900'..'\ufa2d'|'\ufa30'..'\ufa6a'|'\ufb00'..'\ufb06'|'\ufb13'..'\ufb17'|'\ufb1d'..'\ufb28'|'\ufb2a'..'\ufb36'|'\ufb38'..'\ufb3c'|'\ufb3e'|'\ufb40'..'\ufb41'|'\ufb43'..'\ufb44'|'\ufb46'..'\ufbb1'|'\ufbd3'..'\ufd3d'|'\ufd50'..'\ufd8f'|'\ufd92'..'\ufdc7'|'\ufdf0'..'\ufdfc'|'\ufe00'..'\ufe0f'|'\ufe20'..'\ufe23'|'\ufe33'..'\ufe34'|'\ufe4d'..'\ufe4f'|'\ufe69'|'\ufe70'..'\ufe74'|'\ufe76'..'\ufefc'|'\ufeff'|'\uff04'|'\uff10'..'\uff19'|'\uff21'..'\uff3a'|'\uff3f'|'\uff41'..'\uff5a'|'\uff65'..'\uffbe'|'\uffc2'..'\uffc7'|'\uffca'..'\uffcf'|'\uffd2'..'\uffd7'|'\uffda'..'\uffdc'|'\uffe0'..'\uffe1'|'\uffe5'..'\uffe6'|'\ufff9'..'\ufffb')*;
HEX_FLOAT_LITERAL:
	'0'('x'|'X')('0'..'9'|'a'..'f'|'A'..'F')*  (('.' ('0'..'9'|'a'..'f'|'A'..'F')+ (('p'|'P') ('+'|'-')? ('0'..'9')+ ('f'|'F') )?) | ((('p'|'P') ('+'|'-')? ('0'..'9')+ ('f'|'F') )))
;
HEX_DOUBLE_LITERAL:
	'0'('x'|'X')('0'..'9'|'a'..'f'|'A'..'F')* (('.' ('0'..'9'|'a'..'f'|'A'..'F')+ (('p'|'P') ('+'|'-')? ('0'..'9')+ ('d'|'D')?)?) | ((('p'|'P') ('+'|'-')? ('0'..'9')+ ('d'|'D')?)))
;
HEX_LONG_LITERAL:
	'0'('x'|'X')('0'..'9'|'a'..'f'|'A'..'F')+ ('l'|'L')
;
HEX_INTEGER_LITERAL:
	'0'('x'|'X')('0'..'9'|'a'..'f'|'A'..'F')+;
DECIMAL_FLOAT_LITERAL:
	('0'..'9')+ '.' ('0'..'9')* (('e'|'E'|'p'|'P') ('+'|'-')? ('0'..'9')+)? ('f'|'F') | ('.' ('0'..'9')+ (('e'|'E'|'p'|'P') ('+'|'-')? ('0'..'9')+)?) ('f'|'F') | (('0'..'9')+ (('e'|'E'|'p'|'P') ('+'|'-')? ('0'..'9')+) ('f'|'F') | ('0'..'9')+ ('f'|'F'))
;
DECIMAL_DOUBLE_LITERAL:
	('0'..'9')+ '.' ('0'..'9')* (('e'|'E'|'p'|'P') ('+'|'-')? ('0'..'9')+)? ('d'|'D')? | ('.' ('0'..'9')+ (('e'|'E'|'p'|'P') ('+'|'-')? ('0'..'9')+)?) ('d'|'D')? | (('0'..'9')+ (('e'|'E'|'p'|'P') ('+'|'-')? ('0'..'9')+) ('d'|'D')? | ('0'..'9')+ ('d'|'D'))
;
DECIMAL_LONG_LITERAL:
	('0'|'1'..'9''0'..'9'*)('l'|'L')
;
DECIMAL_INTEGER_LITERAL:
	('0'|'1'..'9''0'..'9'*)
;
OCTAL_LONG_LITERAL:
	'0'('0'..'7')+('l'|'L')
;
OCTAL_INTEGER_LITERAL:
	'0'('0'..'7')+;
WHITESPACE:
	(' '|'\t'|'\f')
	{ _channel = 99; }
;
LINEBREAKS:
	('\r\n'|'\r'|'\n')
	{ _channel = 99; }
;
