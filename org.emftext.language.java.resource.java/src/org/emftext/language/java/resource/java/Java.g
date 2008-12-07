grammar Java;
options {superClass = EMFTextParserImpl; backtrack = true;}

@lexer::header{
package org.emftext.language.java.resource.java;

}

@lexer::members{
	public java.util.List<RecognitionException> lexerExceptions  = new java.util.ArrayList<RecognitionException>();
	public java.util.List<Integer> lexerExceptionsPosition       = new java.util.ArrayList<Integer>();

	public void reportError(RecognitionException e) {
		lexerExceptions.add(e);

		lexerExceptionsPosition.add(((ANTLRStringStream)input).index());
	}
}
@header{
package org.emftext.language.java.resource.java;

//+++++++++++++++++++++++imports for org.emftext.language.java begin++++++++++++++++++++++
import org.emftext.language.java.CompilationUnit;
//Implementation: org.emftext.language.java.impl.CompilationUnitImpl
import org.emftext.language.java.Import;
//Implementation: org.emftext.language.java.impl.ImportImpl
import org.emftext.language.java.NamedElement;
//Implementation: org.emftext.language.java.impl.NamedElementImpl
import org.emftext.language.java.Type;
//Implementation: org.emftext.language.java.impl.TypeImpl
import org.emftext.language.java.TypeReference;
//Implementation: org.emftext.language.java.impl.TypeReferenceImpl
import org.emftext.language.java.TypedElement;
//Implementation: org.emftext.language.java.impl.TypedElementImpl
import org.emftext.language.java.ReferenceableElement;
//Implementation: org.emftext.language.java.impl.ReferenceableElementImpl
import org.emftext.language.java.TypeReferenceSequence;
//Implementation: org.emftext.language.java.impl.TypeReferenceSequenceImpl
import org.emftext.language.java.PrimaryReference;
//Implementation: org.emftext.language.java.impl.PrimaryReferenceImpl
import org.emftext.language.java.Reference;
//Implementation: org.emftext.language.java.impl.ReferenceImpl
import org.emftext.language.java.PackageOrClassifierReference;
//Implementation: org.emftext.language.java.impl.PackageOrClassifierReferenceImpl
import org.emftext.language.java.PackageOrClassifierOrMethodOrVariableReference;
//Implementation: org.emftext.language.java.impl.PackageOrClassifierOrMethodOrVariableReferenceImpl
import org.emftext.language.java.ExplicitGenericInvocation;
//Implementation: org.emftext.language.java.impl.ExplicitGenericInvocationImpl
import org.emftext.language.java.TypeParameter;
//Implementation: org.emftext.language.java.impl.TypeParameterImpl
import org.emftext.language.java.TypeArgument;
//Implementation: org.emftext.language.java.impl.TypeArgumentImpl
import org.emftext.language.java.QualifiedTypeArgument;
//Implementation: org.emftext.language.java.impl.QualifiedTypeArgumentImpl
import org.emftext.language.java.ExtendsTypeArgument;
//Implementation: org.emftext.language.java.impl.ExtendsTypeArgumentImpl
import org.emftext.language.java.SuperTypeArgument;
//Implementation: org.emftext.language.java.impl.SuperTypeArgumentImpl
import org.emftext.language.java.UnknownTypeArgument;
//Implementation: org.emftext.language.java.impl.UnknownTypeArgumentImpl
import org.emftext.language.java.TypeParametrizable;
//Implementation: org.emftext.language.java.impl.TypeParametrizableImpl
import org.emftext.language.java.Parametrizable;
//Implementation: org.emftext.language.java.impl.ParametrizableImpl
import org.emftext.language.java.Initializable;
//Implementation: org.emftext.language.java.impl.InitializableImpl
import org.emftext.language.java.InitialValue;
//Implementation: org.emftext.language.java.impl.InitialValueImpl
import org.emftext.language.java.ArrayTypable;
//Implementation: org.emftext.language.java.impl.ArrayTypableImpl
import org.emftext.language.java.Instantiation;
//Implementation: org.emftext.language.java.impl.InstantiationImpl
import org.emftext.language.java.NewConstructorCall;
//Implementation: org.emftext.language.java.impl.NewConstructorCallImpl
import org.emftext.language.java.ExplicitConstructorCall;
//Implementation: org.emftext.language.java.impl.ExplicitConstructorCallImpl
import org.emftext.language.java.ArrayInstantiationBySize;
//Implementation: org.emftext.language.java.impl.ArrayInstantiationBySizeImpl
import org.emftext.language.java.ArrayInstantiationByValues;
//Implementation: org.emftext.language.java.impl.ArrayInstantiationByValuesImpl
import org.emftext.language.java.Classifier;
//Implementation: org.emftext.language.java.impl.ClassifierImpl
import org.emftext.language.java.MemberContainer;
//Implementation: org.emftext.language.java.impl.MemberContainerImpl
import org.emftext.language.java.Class;
//Implementation: org.emftext.language.java.impl.ClassImpl
import org.emftext.language.java.Interface;
//Implementation: org.emftext.language.java.impl.InterfaceImpl
import org.emftext.language.java.Annotation;
//Implementation: org.emftext.language.java.impl.AnnotationImpl
import org.emftext.language.java.AnnotationInstance;
//Implementation: org.emftext.language.java.impl.AnnotationInstanceImpl
import org.emftext.language.java.AnnotationElementValuePair;
//Implementation: org.emftext.language.java.impl.AnnotationElementValuePairImpl
import org.emftext.language.java.AnnotationElementValue;
//Implementation: org.emftext.language.java.impl.AnnotationElementValueImpl
import org.emftext.language.java.AnnotationElementValueArray;
//Implementation: org.emftext.language.java.impl.AnnotationElementValueArrayImpl
import org.emftext.language.java.AnnotationMethod;
//Implementation: org.emftext.language.java.impl.AnnotationMethodImpl
import org.emftext.language.java.Enumeration;
//Implementation: org.emftext.language.java.impl.EnumerationImpl
import org.emftext.language.java.EnumConstant;
//Implementation: org.emftext.language.java.impl.EnumConstantImpl
import org.emftext.language.java.Member;
//Implementation: org.emftext.language.java.impl.MemberImpl
import org.emftext.language.java.Constructor;
//Implementation: org.emftext.language.java.impl.ConstructorImpl
import org.emftext.language.java.Field;
//Implementation: org.emftext.language.java.impl.FieldImpl
import org.emftext.language.java.AdditionalField;
//Implementation: org.emftext.language.java.impl.AdditionalFieldImpl
import org.emftext.language.java.Method;
//Implementation: org.emftext.language.java.impl.MethodImpl
import org.emftext.language.java.Variable;
//Implementation: org.emftext.language.java.impl.VariableImpl
import org.emftext.language.java.Parameter;
//Implementation: org.emftext.language.java.impl.ParameterImpl
import org.emftext.language.java.OrdinaryParameter;
//Implementation: org.emftext.language.java.impl.OrdinaryParameterImpl
import org.emftext.language.java.VariableLengthParameter;
//Implementation: org.emftext.language.java.impl.VariableLengthParameterImpl
import org.emftext.language.java.LocalVariable;
//Implementation: org.emftext.language.java.impl.LocalVariableImpl
import org.emftext.language.java.LocalVariableStatement;
//Implementation: org.emftext.language.java.impl.LocalVariableStatementImpl
import org.emftext.language.java.AdditionalLocalVariable;
//Implementation: org.emftext.language.java.impl.AdditionalLocalVariableImpl
import org.emftext.language.java.Statement;
//Implementation: org.emftext.language.java.impl.StatementImpl
import org.emftext.language.java.Block;
//Implementation: org.emftext.language.java.impl.BlockImpl
import org.emftext.language.java.ArrayDimension;
//Implementation: org.emftext.language.java.impl.ArrayDimensionImpl
import org.emftext.language.java.Assert;
//Implementation: org.emftext.language.java.impl.AssertImpl
import org.emftext.language.java.Condition;
//Implementation: org.emftext.language.java.impl.ConditionImpl
import org.emftext.language.java.Switch;
//Implementation: org.emftext.language.java.impl.SwitchImpl
import org.emftext.language.java.SwitchCase;
//Implementation: org.emftext.language.java.impl.SwitchCaseImpl
import org.emftext.language.java.NormalSwitchCase;
//Implementation: org.emftext.language.java.impl.NormalSwitchCaseImpl
import org.emftext.language.java.DefaultSwitchCase;
//Implementation: org.emftext.language.java.impl.DefaultSwitchCaseImpl
import org.emftext.language.java.ForLoop;
//Implementation: org.emftext.language.java.impl.ForLoopImpl
import org.emftext.language.java.ForLoopInitializer;
//Implementation: org.emftext.language.java.impl.ForLoopInitializerImpl
import org.emftext.language.java.ForEachLoop;
//Implementation: org.emftext.language.java.impl.ForEachLoopImpl
import org.emftext.language.java.WhileLoop;
//Implementation: org.emftext.language.java.impl.WhileLoopImpl
import org.emftext.language.java.DoWhileLoop;
//Implementation: org.emftext.language.java.impl.DoWhileLoopImpl
import org.emftext.language.java.TryBlock;
//Implementation: org.emftext.language.java.impl.TryBlockImpl
import org.emftext.language.java.CatchClause;
//Implementation: org.emftext.language.java.impl.CatchClauseImpl
import org.emftext.language.java.SynchronizedBlock;
//Implementation: org.emftext.language.java.impl.SynchronizedBlockImpl
import org.emftext.language.java.Return;
//Implementation: org.emftext.language.java.impl.ReturnImpl
import org.emftext.language.java.Throw;
//Implementation: org.emftext.language.java.impl.ThrowImpl
import org.emftext.language.java.Break;
//Implementation: org.emftext.language.java.impl.BreakImpl
import org.emftext.language.java.Continue;
//Implementation: org.emftext.language.java.impl.ContinueImpl
import org.emftext.language.java.EmptyStatement;
//Implementation: org.emftext.language.java.impl.EmptyStatementImpl
import org.emftext.language.java.JumpLabel;
//Implementation: org.emftext.language.java.impl.JumpLabelImpl
import org.emftext.language.java.Assignment;
//Implementation: org.emftext.language.java.impl.AssignmentImpl
import org.emftext.language.java.ExpressionStatement;
//Implementation: org.emftext.language.java.impl.ExpressionStatementImpl
import org.emftext.language.java.Expression;
//Implementation: org.emftext.language.java.impl.ExpressionImpl
import org.emftext.language.java.ParExpression;
//Implementation: org.emftext.language.java.impl.ParExpressionImpl
import org.emftext.language.java.RelationExpression;
//Implementation: org.emftext.language.java.impl.RelationExpressionImpl
import org.emftext.language.java.ShiftExpression;
//Implementation: org.emftext.language.java.impl.ShiftExpressionImpl
import org.emftext.language.java.AdditiveExpression;
//Implementation: org.emftext.language.java.impl.AdditiveExpressionImpl
import org.emftext.language.java.MultiplicativeExpression;
//Implementation: org.emftext.language.java.impl.MultiplicativeExpressionImpl
import org.emftext.language.java.UnaryExpression;
//Implementation: org.emftext.language.java.impl.UnaryExpressionImpl
import org.emftext.language.java.UnaryExpressionNotPlusMinus;
//Implementation: org.emftext.language.java.impl.UnaryExpressionNotPlusMinusImpl
import org.emftext.language.java.CastExpression;
//Implementation: org.emftext.language.java.impl.CastExpressionImpl
import org.emftext.language.java.Primary;
//Implementation: org.emftext.language.java.impl.PrimaryImpl
import org.emftext.language.java.RelationOperator;
//Implementation: org.emftext.language.java.impl.RelationOperatorImpl
import org.emftext.language.java.LessThan;
//Implementation: org.emftext.language.java.impl.LessThanImpl
import org.emftext.language.java.LessThanOrEqual;
//Implementation: org.emftext.language.java.impl.LessThanOrEqualImpl
import org.emftext.language.java.GreaterThan;
//Implementation: org.emftext.language.java.impl.GreaterThanImpl
import org.emftext.language.java.GreaterThanOrEqual;
//Implementation: org.emftext.language.java.impl.GreaterThanOrEqualImpl
import org.emftext.language.java.ShiftOperator;
//Implementation: org.emftext.language.java.impl.ShiftOperatorImpl
import org.emftext.language.java.AdditiveOperator;
//Implementation: org.emftext.language.java.impl.AdditiveOperatorImpl
import org.emftext.language.java.MultiplicativeOperator;
//Implementation: org.emftext.language.java.impl.MultiplicativeOperatorImpl
import org.emftext.language.java.LeftShift;
//Implementation: org.emftext.language.java.impl.LeftShiftImpl
import org.emftext.language.java.RightShift;
//Implementation: org.emftext.language.java.impl.RightShiftImpl
import org.emftext.language.java.UnsignedRightShift;
//Implementation: org.emftext.language.java.impl.UnsignedRightShiftImpl
import org.emftext.language.java.PlusPlus;
//Implementation: org.emftext.language.java.impl.PlusPlusImpl
import org.emftext.language.java.MinusMinus;
//Implementation: org.emftext.language.java.impl.MinusMinusImpl
import org.emftext.language.java.Complement;
//Implementation: org.emftext.language.java.impl.ComplementImpl
import org.emftext.language.java.Negate;
//Implementation: org.emftext.language.java.impl.NegateImpl
import org.emftext.language.java.ExpressionList;
//Implementation: org.emftext.language.java.impl.ExpressionListImpl
import org.emftext.language.java.BooleanExpression;
//Implementation: org.emftext.language.java.impl.BooleanExpressionImpl
import org.emftext.language.java.Modifier;
//Implementation: org.emftext.language.java.impl.ModifierImpl
import org.emftext.language.java.Public;
//Implementation: org.emftext.language.java.impl.PublicImpl
import org.emftext.language.java.Abstract;
//Implementation: org.emftext.language.java.impl.AbstractImpl
import org.emftext.language.java.Protected;
//Implementation: org.emftext.language.java.impl.ProtectedImpl
import org.emftext.language.java.Private;
//Implementation: org.emftext.language.java.impl.PrivateImpl
import org.emftext.language.java.Final;
//Implementation: org.emftext.language.java.impl.FinalImpl
import org.emftext.language.java.Static;
//Implementation: org.emftext.language.java.impl.StaticImpl
import org.emftext.language.java.Native;
//Implementation: org.emftext.language.java.impl.NativeImpl
import org.emftext.language.java.Synchronized;
//Implementation: org.emftext.language.java.impl.SynchronizedImpl
import org.emftext.language.java.Transient;
//Implementation: org.emftext.language.java.impl.TransientImpl
import org.emftext.language.java.Volatile;
//Implementation: org.emftext.language.java.impl.VolatileImpl
import org.emftext.language.java.Strictfp;
//Implementation: org.emftext.language.java.impl.StrictfpImpl
import org.emftext.language.java.PrimitiveType;
//Implementation: org.emftext.language.java.impl.PrimitiveTypeImpl
import org.emftext.language.java.Boolean;
//Implementation: org.emftext.language.java.impl.BooleanImpl
import org.emftext.language.java.Char;
//Implementation: org.emftext.language.java.impl.CharImpl
import org.emftext.language.java.Byte;
//Implementation: org.emftext.language.java.impl.ByteImpl
import org.emftext.language.java.Short;
//Implementation: org.emftext.language.java.impl.ShortImpl
import org.emftext.language.java.Int;
//Implementation: org.emftext.language.java.impl.IntImpl
import org.emftext.language.java.Long;
//Implementation: org.emftext.language.java.impl.LongImpl
import org.emftext.language.java.Float;
//Implementation: org.emftext.language.java.impl.FloatImpl
import org.emftext.language.java.Double;
//Implementation: org.emftext.language.java.impl.DoubleImpl
import org.emftext.language.java.VoidLiteral;
//Implementation: org.emftext.language.java.impl.VoidLiteralImpl
import org.emftext.language.java.Literal;
//Implementation: org.emftext.language.java.impl.LiteralImpl
import org.emftext.language.java.IntegerLiteral;
//Implementation: org.emftext.language.java.impl.IntegerLiteralImpl
import org.emftext.language.java.FloatingPointLiteral;
//Implementation: org.emftext.language.java.impl.FloatingPointLiteralImpl
import org.emftext.language.java.CharacterLiteral;
//Implementation: org.emftext.language.java.impl.CharacterLiteralImpl
import org.emftext.language.java.StringLiteral;
//Implementation: org.emftext.language.java.impl.StringLiteralImpl
import org.emftext.language.java.BooleanLiteral;
//Implementation: org.emftext.language.java.impl.BooleanLiteralImpl
import org.emftext.language.java.NullLiteral;
//Implementation: org.emftext.language.java.impl.NullLiteralImpl
import org.emftext.language.java.SelfReference;
//Implementation: org.emftext.language.java.impl.SelfReferenceImpl
import org.emftext.language.java.This;
//Implementation: org.emftext.language.java.impl.ThisImpl
import org.emftext.language.java.Super;
//Implementation: org.emftext.language.java.impl.SuperImpl
import org.emftext.language.java.ClassLiteral;
//Implementation: org.emftext.language.java.impl.ClassLiteralImpl
import org.emftext.language.java.Comment;
//Implementation: org.emftext.language.java.impl.CommentImpl
import org.emftext.language.java.SingleLineComment;
//Implementation: org.emftext.language.java.impl.SingleLineCommentImpl
import org.emftext.language.java.MultiLineComment;
//Implementation: org.emftext.language.java.impl.MultiLineCommentImpl
import org.emftext.language.java.Commentable;
//Implementation: org.emftext.language.java.impl.CommentableImpl
import org.emftext.language.java.*;
import org.emftext.runtime.resource.*;
import org.emftext.runtime.resource.impl.*;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.common.util.URI;
}

@members{
	private TokenResolverFactory tokenResolverFactory = new JavaTokenResolverFactory();

	protected EObject doParse() throws RecognitionException {
		((JavaLexer)getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
		((JavaLexer)getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
		return start();
	}
}

start
returns [ EObject element = null]
:  
c0 = compilationunit{ element = c0; }

;

compilationunit returns [CompilationUnit element = null]
@init{
	element = JavaFactory.eINSTANCE.createCompilationUnit();
}
:
	(
		a0 = comment{((List) element.eGet(element.eClass().getEStructuralFeature("comments"))).add(a0); copyLocalizationInfos(a0, element); }
	)*
	(
		a1 = annotationinstance{((List) element.eGet(element.eClass().getEStructuralFeature("annotations"))).add(a1); copyLocalizationInfos(a1, element); }
	)*
	(
		a2 = comment{((List) element.eGet(element.eClass().getEStructuralFeature("comments"))).add(a2); copyLocalizationInfos(a2, element); }
	)*
	(
		(
			a3 = 'package'{copyLocalizationInfos((CommonToken)a3, element); }
			a4 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("package"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;((List) element.eGet(element.eClass().getEStructuralFeature("package"))).add(resolved); copyLocalizationInfos((CommonToken) a4, element); }
			(
				(
					a5 = '.'{copyLocalizationInfos((CommonToken)a5, element); }
					a6 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a6.getText(),element.eClass().getEStructuralFeature("package"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a6,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;((List) element.eGet(element.eClass().getEStructuralFeature("package"))).add(resolved); copyLocalizationInfos((CommonToken) a6, element); }
				)
			)*
			a7 = ';'{copyLocalizationInfos((CommonToken)a7, element); }
		)
	)?
	(
		a8 = comment{((List) element.eGet(element.eClass().getEStructuralFeature("comments"))).add(a8); copyLocalizationInfos(a8, element); }
	)*
	(
		(
			a9 = 'import'{copyLocalizationInfos((CommonToken)a9, element); }
			a10 = keywordimport{((List) element.eGet(element.eClass().getEStructuralFeature("imports"))).add(a10); copyLocalizationInfos(a10, element); }
			a11 = ';'{copyLocalizationInfos((CommonToken)a11, element); }
		)
	)*
	(
		(
			a12 = classifier{((List) element.eGet(element.eClass().getEStructuralFeature("classifiers"))).add(a12); copyLocalizationInfos(a12, element); }
		)
	)+
;

keywordimport returns [Import element = null]
@init{
	element = JavaFactory.eINSTANCE.createImport();
}
:
	(
		a0 = keywordstatic{element.eSet(element.eClass().getEStructuralFeature("static"), a0); copyLocalizationInfos(a0, element); }
	)?
	a1 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("package"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;((List) element.eGet(element.eClass().getEStructuralFeature("package"))).add(resolved); copyLocalizationInfos((CommonToken) a1, element); }
	(
		(
			a2 = '.'{copyLocalizationInfos((CommonToken)a2, element); }
			a3 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a3.getText(),element.eClass().getEStructuralFeature("package"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a3,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;((List) element.eGet(element.eClass().getEStructuralFeature("package"))).add(resolved); copyLocalizationInfos((CommonToken) a3, element); }
		)
	)*
	a4 = '.'{copyLocalizationInfos((CommonToken)a4, element); }
	a5 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("classifiers"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Class proxy = JavaFactory.eINSTANCE.createClass();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("classifiers"))).add(proxy); copyLocalizationInfos((CommonToken) a5, element); copyLocalizationInfos((CommonToken) a5, proxy); }
;

keywordclass returns [Class element = null]
@init{
	element = JavaFactory.eINSTANCE.createClass();
}
:
	(
		a0 = modifier{((List) element.eGet(element.eClass().getEStructuralFeature("modifiers"))).add(a0); copyLocalizationInfos(a0, element); }
	)*
	a1 = 'class'{copyLocalizationInfos((CommonToken)a1, element); }
	a2 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a2, element); }
	(
		(
			a3 = '<'{copyLocalizationInfos((CommonToken)a3, element); }
			a4 = typeparameter{((List) element.eGet(element.eClass().getEStructuralFeature("typeParameters"))).add(a4); copyLocalizationInfos(a4, element); }
			(
				(
					a5 = ','{copyLocalizationInfos((CommonToken)a5, element); }
					a6 = typeparameter{((List) element.eGet(element.eClass().getEStructuralFeature("typeParameters"))).add(a6); copyLocalizationInfos(a6, element); }
				)
			)*
			a7 = '>'{copyLocalizationInfos((CommonToken)a7, element); }
		)
	)?
	(
		(
			a8 = 'extends'{copyLocalizationInfos((CommonToken)a8, element); }
			a9 = qualifiedtypeargument{element.eSet(element.eClass().getEStructuralFeature("extends"), a9); copyLocalizationInfos(a9, element); }
		)
	)?
	(
		(
			a10 = 'implements'{copyLocalizationInfos((CommonToken)a10, element); }
			a11 = qualifiedtypeargument{((List) element.eGet(element.eClass().getEStructuralFeature("implements"))).add(a11); copyLocalizationInfos(a11, element); }
		)
	)?
	a12 = '{'{copyLocalizationInfos((CommonToken)a12, element); }
	(
		(
			a13 = member{((List) element.eGet(element.eClass().getEStructuralFeature("members"))).add(a13); copyLocalizationInfos(a13, element); }
			(
				(
					a14 = ';'{copyLocalizationInfos((CommonToken)a14, element); }
				)
			)?
		)
	)*
	a15 = '}'{copyLocalizationInfos((CommonToken)a15, element); }
;

keywordinterface returns [Interface element = null]
@init{
	element = JavaFactory.eINSTANCE.createInterface();
}
:
	(
		a0 = modifier{((List) element.eGet(element.eClass().getEStructuralFeature("modifiers"))).add(a0); copyLocalizationInfos(a0, element); }
	)*
	a1 = 'interface'{copyLocalizationInfos((CommonToken)a1, element); }
	a2 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a2, element); }
	(
		(
			a3 = '<'{copyLocalizationInfos((CommonToken)a3, element); }
			a4 = typeparameter{((List) element.eGet(element.eClass().getEStructuralFeature("typeParameters"))).add(a4); copyLocalizationInfos(a4, element); }
			(
				(
					a5 = ','{copyLocalizationInfos((CommonToken)a5, element); }
					a6 = typeparameter{((List) element.eGet(element.eClass().getEStructuralFeature("typeParameters"))).add(a6); copyLocalizationInfos(a6, element); }
				)
			)*
			a7 = '>'{copyLocalizationInfos((CommonToken)a7, element); }
		)
	)?
	(
		(
			a8 = 'extends'{copyLocalizationInfos((CommonToken)a8, element); }
			(
				a9 = qualifiedtypeargument{((List) element.eGet(element.eClass().getEStructuralFeature("extends"))).add(a9); copyLocalizationInfos(a9, element); }
				(
					(
						a10 = ','{copyLocalizationInfos((CommonToken)a10, element); }
						a11 = qualifiedtypeargument{((List) element.eGet(element.eClass().getEStructuralFeature("extends"))).add(a11); copyLocalizationInfos(a11, element); }
					)
				)*
			)
		)
	)?
	a12 = '{'{copyLocalizationInfos((CommonToken)a12, element); }
	(
		(
			(
				a13 = member{((List) element.eGet(element.eClass().getEStructuralFeature("members"))).add(a13); copyLocalizationInfos(a13, element); }
				(
					(
						a14 = ';'{copyLocalizationInfos((CommonToken)a14, element); }
					)
				)?
			)

			|
			(
				(
					a15 = ';'{copyLocalizationInfos((CommonToken)a15, element); }
				)
			)?
		)
	)*
	a16 = '}'{copyLocalizationInfos((CommonToken)a16, element); }
;

annotation returns [Annotation element = null]
@init{
	element = JavaFactory.eINSTANCE.createAnnotation();
}
:
	(
		a0 = modifier{((List) element.eGet(element.eClass().getEStructuralFeature("modifiers"))).add(a0); copyLocalizationInfos(a0, element); }
	)*
	a1 = '@'{copyLocalizationInfos((CommonToken)a1, element); }
	a2 = 'interface'{copyLocalizationInfos((CommonToken)a2, element); }
	a3 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a3.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a3,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a3, element); }
	a4 = '{'{copyLocalizationInfos((CommonToken)a4, element); }
	(
		(
			(
				a5 = member{((List) element.eGet(element.eClass().getEStructuralFeature("members"))).add(a5); copyLocalizationInfos(a5, element); }
				(
					(
						a6 = ';'{copyLocalizationInfos((CommonToken)a6, element); }
					)
				)?
			)

			|
			(
				(
					a7 = ';'{copyLocalizationInfos((CommonToken)a7, element); }
				)
			)?
		)
	)*
	a8 = '}'{copyLocalizationInfos((CommonToken)a8, element); }
;

annotationinstance returns [AnnotationInstance element = null]
@init{
	element = JavaFactory.eINSTANCE.createAnnotationInstance();
}
:
	a0 = '@'{copyLocalizationInfos((CommonToken)a0, element); }
	a1 = reference{element.eSet(element.eClass().getEStructuralFeature("annotation"), a1); copyLocalizationInfos(a1, element); }
	(
		(
			a2 = '('{copyLocalizationInfos((CommonToken)a2, element); }
			(
				a3 = annotationelementvalue{element.eSet(element.eClass().getEStructuralFeature("elementValue"), a3); copyLocalizationInfos(a3, element); }

				|
				(
					a4 = annotationelementvaluepair{((List) element.eGet(element.eClass().getEStructuralFeature("elementValuePairs"))).add(a4); copyLocalizationInfos(a4, element); }
					(
						(
							a5 = ','{copyLocalizationInfos((CommonToken)a5, element); }
							a6 = annotationelementvaluepair{((List) element.eGet(element.eClass().getEStructuralFeature("elementValuePairs"))).add(a6); copyLocalizationInfos(a6, element); }
						)
					)*
				)
			)
			a7 = ')'{copyLocalizationInfos((CommonToken)a7, element); }
		)
	)?
;

annotationelementvaluepair returns [AnnotationElementValuePair element = null]
@init{
	element = JavaFactory.eINSTANCE.createAnnotationElementValuePair();
}
:
	a0 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("key"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Class proxy = JavaFactory.eINSTANCE.createClass();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("key"), proxy); copyLocalizationInfos((CommonToken) a0, element); copyLocalizationInfos((CommonToken) a0, proxy); }
	a1 = '='{copyLocalizationInfos((CommonToken)a1, element); }
	a2 = annotationelementvalue{element.eSet(element.eClass().getEStructuralFeature("value"), a2); copyLocalizationInfos(a2, element); }
;

annotationelementvaluearray returns [AnnotationElementValueArray element = null]
@init{
	element = JavaFactory.eINSTANCE.createAnnotationElementValueArray();
}
:
	a0 = '{'{copyLocalizationInfos((CommonToken)a0, element); }
	(
		(
			a1 = annotationelementvalue{((List) element.eGet(element.eClass().getEStructuralFeature("values"))).add(a1); copyLocalizationInfos(a1, element); }
			(
				(
					a2 = ','{copyLocalizationInfos((CommonToken)a2, element); }
					a3 = annotationelementvalue{((List) element.eGet(element.eClass().getEStructuralFeature("values"))).add(a3); copyLocalizationInfos(a3, element); }
				)
			)*
		)
	)?
	(
		(
			a4 = ','{copyLocalizationInfos((CommonToken)a4, element); }
		)
	)?
	a5 = '}'{copyLocalizationInfos((CommonToken)a5, element); }
;

enumeration returns [Enumeration element = null]
@init{
	element = JavaFactory.eINSTANCE.createEnumeration();
}
:
	(
		a0 = modifier{((List) element.eGet(element.eClass().getEStructuralFeature("modifiers"))).add(a0); copyLocalizationInfos(a0, element); }
	)*
	a1 = 'enum'{copyLocalizationInfos((CommonToken)a1, element); }
	a2 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a2, element); }
	(
		(
			a3 = 'implements'{copyLocalizationInfos((CommonToken)a3, element); }
			(
				a4 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("implements"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Class proxy = JavaFactory.eINSTANCE.createClass();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("implements"))).add(proxy); copyLocalizationInfos((CommonToken) a4, element); copyLocalizationInfos((CommonToken) a4, proxy); }
				(
					(
						a5 = ','{copyLocalizationInfos((CommonToken)a5, element); }
						a6 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a6.getText(),element.eClass().getEStructuralFeature("implements"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a6,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Class proxy = JavaFactory.eINSTANCE.createClass();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("implements"))).add(proxy); copyLocalizationInfos((CommonToken) a6, element); copyLocalizationInfos((CommonToken) a6, proxy); }
					)
				)*
			)
		)
	)?
	a7 = '{'{copyLocalizationInfos((CommonToken)a7, element); }
	(
		(
			a8 = enumconstant{((List) element.eGet(element.eClass().getEStructuralFeature("constants"))).add(a8); copyLocalizationInfos(a8, element); }
			(
				(
					a9 = ','{copyLocalizationInfos((CommonToken)a9, element); }
					a10 = enumconstant{((List) element.eGet(element.eClass().getEStructuralFeature("constants"))).add(a10); copyLocalizationInfos(a10, element); }
				)
			)*
		)
	)?
	(
		(
			a11 = ','{copyLocalizationInfos((CommonToken)a11, element); }
		)
	)?
	(
		(
			(
				a12 = ';'{copyLocalizationInfos((CommonToken)a12, element); }
				(
					a13 = member{((List) element.eGet(element.eClass().getEStructuralFeature("members"))).add(a13); copyLocalizationInfos(a13, element); }
				)*
			)
		)?

		|
		(
			(
				a14 = ';'{copyLocalizationInfos((CommonToken)a14, element); }
			)
		)?
	)
	a15 = '}'{copyLocalizationInfos((CommonToken)a15, element); }
;

typeparameter returns [TypeParameter element = null]
@init{
	element = JavaFactory.eINSTANCE.createTypeParameter();
}
:
	a0 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a0, element); }
	(
		(
			a1 = 'extends'{copyLocalizationInfos((CommonToken)a1, element); }
			a2 = reference{((List) element.eGet(element.eClass().getEStructuralFeature("extendTypes"))).add(a2); copyLocalizationInfos(a2, element); }
			(
				(
					a3 = '&'{copyLocalizationInfos((CommonToken)a3, element); }
					a4 = reference{((List) element.eGet(element.eClass().getEStructuralFeature("extendTypes"))).add(a4); copyLocalizationInfos(a4, element); }
				)
			)*
		)
	)?
;

enumconstant returns [EnumConstant element = null]
@init{
	element = JavaFactory.eINSTANCE.createEnumConstant();
}
:
	a0 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a0, element); }
	(
		(
			a1 = '('{copyLocalizationInfos((CommonToken)a1, element); }
			a2 = expression{((List) element.eGet(element.eClass().getEStructuralFeature("arguments"))).add(a2); copyLocalizationInfos(a2, element); }
			(
				(
					a3 = ','{copyLocalizationInfos((CommonToken)a3, element); }
					a4 = expression{((List) element.eGet(element.eClass().getEStructuralFeature("arguments"))).add(a4); copyLocalizationInfos(a4, element); }
				)
			)*
			a5 = ')'{copyLocalizationInfos((CommonToken)a5, element); }
		)
	)?
	(
		a6 = member{((List) element.eGet(element.eClass().getEStructuralFeature("members"))).add(a6); copyLocalizationInfos(a6, element); }
	)*
;

block returns [Block element = null]
@init{
	element = JavaFactory.eINSTANCE.createBlock();
}
:
	(
		a0 = modifier{((List) element.eGet(element.eClass().getEStructuralFeature("modifiers"))).add(a0); copyLocalizationInfos(a0, element); }
	)*
	a1 = '{'{copyLocalizationInfos((CommonToken)a1, element); }
	(
		a2 = statement{((List) element.eGet(element.eClass().getEStructuralFeature("statements"))).add(a2); copyLocalizationInfos(a2, element); }
	)*
	a3 = '}'{copyLocalizationInfos((CommonToken)a3, element); }
;

constructor returns [Constructor element = null]
@init{
	element = JavaFactory.eINSTANCE.createConstructor();
}
:
	(
		a0 = annotationinstance{((List) element.eGet(element.eClass().getEStructuralFeature("annotations"))).add(a0); copyLocalizationInfos(a0, element); }
	)*
	(
		a1 = modifier{((List) element.eGet(element.eClass().getEStructuralFeature("modifiers"))).add(a1); copyLocalizationInfos(a1, element); }
	)*
	(
		(
			a2 = '<'{copyLocalizationInfos((CommonToken)a2, element); }
			a3 = typeparameter{((List) element.eGet(element.eClass().getEStructuralFeature("typeParameters"))).add(a3); copyLocalizationInfos(a3, element); }
			(
				(
					a4 = ','{copyLocalizationInfos((CommonToken)a4, element); }
					a5 = typeparameter{((List) element.eGet(element.eClass().getEStructuralFeature("typeParameters"))).add(a5); copyLocalizationInfos(a5, element); }
				)
			)*
			a6 = '>'{copyLocalizationInfos((CommonToken)a6, element); }
		)
	)?
	a7 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a7.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a7,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a7, element); }
	a8 = '('{copyLocalizationInfos((CommonToken)a8, element); }
	(
		(
			a9 = parameter{((List) element.eGet(element.eClass().getEStructuralFeature("parameters"))).add(a9); copyLocalizationInfos(a9, element); }
			(
				(
					a10 = ','{copyLocalizationInfos((CommonToken)a10, element); }
					a11 = parameter{((List) element.eGet(element.eClass().getEStructuralFeature("parameters"))).add(a11); copyLocalizationInfos(a11, element); }
				)
			)*
		)
	)?
	a12 = ')'{copyLocalizationInfos((CommonToken)a12, element); }
	(
		(
			a13 = 'throws'{copyLocalizationInfos((CommonToken)a13, element); }
			a14 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a14.getText(),element.eClass().getEStructuralFeature("exceptions"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a14,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Class proxy = JavaFactory.eINSTANCE.createClass();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("exceptions"))).add(proxy); copyLocalizationInfos((CommonToken) a14, element); copyLocalizationInfos((CommonToken) a14, proxy); }
			(
				(
					a15 = ','{copyLocalizationInfos((CommonToken)a15, element); }
					a16 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a16.getText(),element.eClass().getEStructuralFeature("exceptions"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a16,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Class proxy = JavaFactory.eINSTANCE.createClass();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("exceptions"))).add(proxy); copyLocalizationInfos((CommonToken) a16, element); copyLocalizationInfos((CommonToken) a16, proxy); }
				)
			)?
		)
	)?
	a17 = block{element.eSet(element.eClass().getEStructuralFeature("body"), a17); copyLocalizationInfos(a17, element); }
;

method returns [Method element = null]
@init{
	element = JavaFactory.eINSTANCE.createMethod();
}
:
	(
		a0 = annotationinstance{((List) element.eGet(element.eClass().getEStructuralFeature("annotations"))).add(a0); copyLocalizationInfos(a0, element); }
	)*
	(
		a1 = modifier{((List) element.eGet(element.eClass().getEStructuralFeature("modifiers"))).add(a1); copyLocalizationInfos(a1, element); }
	)*
	(
		(
			a2 = '<'{copyLocalizationInfos((CommonToken)a2, element); }
			a3 = typeparameter{((List) element.eGet(element.eClass().getEStructuralFeature("typeParameters"))).add(a3); copyLocalizationInfos(a3, element); }
			(
				(
					a4 = ','{copyLocalizationInfos((CommonToken)a4, element); }
					a5 = typeparameter{((List) element.eGet(element.eClass().getEStructuralFeature("typeParameters"))).add(a5); copyLocalizationInfos(a5, element); }
				)
			)*
			a6 = '>'{copyLocalizationInfos((CommonToken)a6, element); }
		)
	)?
	(
		a7 = typereference{element.eSet(element.eClass().getEStructuralFeature("type"), a7); copyLocalizationInfos(a7, element); }
		(
			a8 = arraydimension{((List) element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"))).add(a8); copyLocalizationInfos(a8, element); }
		)*
	)
	a9 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a9.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a9,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a9, element); }
	a10 = '('{copyLocalizationInfos((CommonToken)a10, element); }
	(
		(
			a11 = parameter{((List) element.eGet(element.eClass().getEStructuralFeature("parameters"))).add(a11); copyLocalizationInfos(a11, element); }
			(
				(
					a12 = ','{copyLocalizationInfos((CommonToken)a12, element); }
					a13 = parameter{((List) element.eGet(element.eClass().getEStructuralFeature("parameters"))).add(a13); copyLocalizationInfos(a13, element); }
				)
			)*
		)
	)?
	a14 = ')'{copyLocalizationInfos((CommonToken)a14, element); }
	(
		a15 = arraydimension{((List) element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"))).add(a15); copyLocalizationInfos(a15, element); }
	)*
	(
		(
			a16 = 'throws'{copyLocalizationInfos((CommonToken)a16, element); }
			a17 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a17.getText(),element.eClass().getEStructuralFeature("exceptions"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a17,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Class proxy = JavaFactory.eINSTANCE.createClass();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("exceptions"))).add(proxy); copyLocalizationInfos((CommonToken) a17, element); copyLocalizationInfos((CommonToken) a17, proxy); }
			(
				(
					a18 = ','{copyLocalizationInfos((CommonToken)a18, element); }
					a19 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a19.getText(),element.eClass().getEStructuralFeature("exceptions"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a19,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Class proxy = JavaFactory.eINSTANCE.createClass();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("exceptions"))).add(proxy); copyLocalizationInfos((CommonToken) a19, element); copyLocalizationInfos((CommonToken) a19, proxy); }
				)
			)?
		)
	)?
	(
		a20 = block{element.eSet(element.eClass().getEStructuralFeature("body"), a20); copyLocalizationInfos(a20, element); }

		|
		a21 = ';'{copyLocalizationInfos((CommonToken)a21, element); }
	)
	|//derived choice rules for sub-classes: 
	c0 = annotationmethod{ element = c0; }
;

annotationmethod returns [AnnotationMethod element = null]
@init{
	element = JavaFactory.eINSTANCE.createAnnotationMethod();
}
:
	(
		a0 = annotationinstance{((List) element.eGet(element.eClass().getEStructuralFeature("annotations"))).add(a0); copyLocalizationInfos(a0, element); }
	)*
	(
		a1 = modifier{((List) element.eGet(element.eClass().getEStructuralFeature("modifiers"))).add(a1); copyLocalizationInfos(a1, element); }
	)*
	(
		(
			a2 = '<'{copyLocalizationInfos((CommonToken)a2, element); }
			a3 = typeparameter{((List) element.eGet(element.eClass().getEStructuralFeature("typeParameters"))).add(a3); copyLocalizationInfos(a3, element); }
			(
				(
					a4 = ','{copyLocalizationInfos((CommonToken)a4, element); }
					a5 = typeparameter{((List) element.eGet(element.eClass().getEStructuralFeature("typeParameters"))).add(a5); copyLocalizationInfos(a5, element); }
				)
			)*
			a6 = '>'{copyLocalizationInfos((CommonToken)a6, element); }
		)
	)?
	(
		a7 = typereference{element.eSet(element.eClass().getEStructuralFeature("type"), a7); copyLocalizationInfos(a7, element); }
		(
			a8 = arraydimension{((List) element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"))).add(a8); copyLocalizationInfos(a8, element); }
		)*
	)
	a9 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a9.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a9,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a9, element); }
	a10 = '('{copyLocalizationInfos((CommonToken)a10, element); }
	(
		(
			a11 = parameter{((List) element.eGet(element.eClass().getEStructuralFeature("parameters"))).add(a11); copyLocalizationInfos(a11, element); }
			(
				(
					a12 = ','{copyLocalizationInfos((CommonToken)a12, element); }
					a13 = parameter{((List) element.eGet(element.eClass().getEStructuralFeature("parameters"))).add(a13); copyLocalizationInfos(a13, element); }
				)
			)*
		)
	)?
	a14 = ')'{copyLocalizationInfos((CommonToken)a14, element); }
	(
		a15 = arraydimension{((List) element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"))).add(a15); copyLocalizationInfos(a15, element); }
	)*
	(
		(
			a16 = 'throws'{copyLocalizationInfos((CommonToken)a16, element); }
			a17 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a17.getText(),element.eClass().getEStructuralFeature("exceptions"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a17,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Class proxy = JavaFactory.eINSTANCE.createClass();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("exceptions"))).add(proxy); copyLocalizationInfos((CommonToken) a17, element); copyLocalizationInfos((CommonToken) a17, proxy); }
			(
				(
					a18 = ','{copyLocalizationInfos((CommonToken)a18, element); }
					a19 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a19.getText(),element.eClass().getEStructuralFeature("exceptions"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a19,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Class proxy = JavaFactory.eINSTANCE.createClass();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("exceptions"))).add(proxy); copyLocalizationInfos((CommonToken) a19, element); copyLocalizationInfos((CommonToken) a19, proxy); }
				)
			)?
		)
	)?
	a20 = 'default'{copyLocalizationInfos((CommonToken)a20, element); }
	a21 = annotationelementvalue{element.eSet(element.eClass().getEStructuralFeature("defaultValue"), a21); copyLocalizationInfos(a21, element); }
	(
		a22 = block{element.eSet(element.eClass().getEStructuralFeature("body"), a22); copyLocalizationInfos(a22, element); }

		|
		a23 = ';'{copyLocalizationInfos((CommonToken)a23, element); }
	)
;

ordinaryparameter returns [OrdinaryParameter element = null]
@init{
	element = JavaFactory.eINSTANCE.createOrdinaryParameter();
}
:
	(
		a0 = modifier{((List) element.eGet(element.eClass().getEStructuralFeature("modifiers"))).add(a0); copyLocalizationInfos(a0, element); }
	)*
	a1 = typereference{element.eSet(element.eClass().getEStructuralFeature("type"), a1); copyLocalizationInfos(a1, element); }
	(
		a2 = arraydimension{((List) element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"))).add(a2); copyLocalizationInfos(a2, element); }
	)*
	(
		(
			a3 = '<'{copyLocalizationInfos((CommonToken)a3, element); }
			a4 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("typeArguments"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Class proxy = JavaFactory.eINSTANCE.createClass();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("typeArguments"))).add(proxy); copyLocalizationInfos((CommonToken) a4, element); copyLocalizationInfos((CommonToken) a4, proxy); }
			(
				(
					a5 = ','{copyLocalizationInfos((CommonToken)a5, element); }
					a6 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a6.getText(),element.eClass().getEStructuralFeature("typeArguments"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a6,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Class proxy = JavaFactory.eINSTANCE.createClass();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("typeArguments"))).add(proxy); copyLocalizationInfos((CommonToken) a6, element); copyLocalizationInfos((CommonToken) a6, proxy); }
				)
			)*
			a7 = '>'{copyLocalizationInfos((CommonToken)a7, element); }
		)
	)?
	a8 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a8.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a8,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a8, element); }
	(
		a9 = arraydimension{((List) element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"))).add(a9); copyLocalizationInfos(a9, element); }
	)*
;

variablelengthparameter returns [VariableLengthParameter element = null]
@init{
	element = JavaFactory.eINSTANCE.createVariableLengthParameter();
}
:
	(
		a0 = modifier{((List) element.eGet(element.eClass().getEStructuralFeature("modifiers"))).add(a0); copyLocalizationInfos(a0, element); }
	)*
	a1 = typereference{element.eSet(element.eClass().getEStructuralFeature("type"), a1); copyLocalizationInfos(a1, element); }
	(
		a2 = arraydimension{((List) element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"))).add(a2); copyLocalizationInfos(a2, element); }
	)*
	(
		(
			a3 = '<'{copyLocalizationInfos((CommonToken)a3, element); }
			a4 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("typeArguments"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Class proxy = JavaFactory.eINSTANCE.createClass();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("typeArguments"))).add(proxy); copyLocalizationInfos((CommonToken) a4, element); copyLocalizationInfos((CommonToken) a4, proxy); }
			(
				(
					a5 = ','{copyLocalizationInfos((CommonToken)a5, element); }
					a6 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a6.getText(),element.eClass().getEStructuralFeature("typeArguments"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a6,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Class proxy = JavaFactory.eINSTANCE.createClass();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("typeArguments"))).add(proxy); copyLocalizationInfos((CommonToken) a6, element); copyLocalizationInfos((CommonToken) a6, proxy); }
				)
			)*
			a7 = '>'{copyLocalizationInfos((CommonToken)a7, element); }
		)
	)?
	a8 = '...'{copyLocalizationInfos((CommonToken)a8, element); }
	a9 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a9.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a9,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a9, element); }
;

localvariable returns [LocalVariable element = null]
@init{
	element = JavaFactory.eINSTANCE.createLocalVariable();
}
:
	(
		a0 = modifier{((List) element.eGet(element.eClass().getEStructuralFeature("modifiers"))).add(a0); copyLocalizationInfos(a0, element); }
	)*
	a1 = typereference{element.eSet(element.eClass().getEStructuralFeature("type"), a1); copyLocalizationInfos(a1, element); }
	(
		a2 = arraydimension{((List) element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"))).add(a2); copyLocalizationInfos(a2, element); }
	)*
	(
		(
			a3 = '<'{copyLocalizationInfos((CommonToken)a3, element); }
			a4 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("typeArguments"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Class proxy = JavaFactory.eINSTANCE.createClass();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("typeArguments"))).add(proxy); copyLocalizationInfos((CommonToken) a4, element); copyLocalizationInfos((CommonToken) a4, proxy); }
			(
				(
					a5 = ','{copyLocalizationInfos((CommonToken)a5, element); }
					a6 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a6.getText(),element.eClass().getEStructuralFeature("typeArguments"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a6,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Class proxy = JavaFactory.eINSTANCE.createClass();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("typeArguments"))).add(proxy); copyLocalizationInfos((CommonToken) a6, element); copyLocalizationInfos((CommonToken) a6, proxy); }
				)
			)*
			a7 = '>'{copyLocalizationInfos((CommonToken)a7, element); }
		)
	)?
	a8 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a8.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a8,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a8, element); }
	(
		a9 = arraydimension{((List) element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"))).add(a9); copyLocalizationInfos(a9, element); }
	)*
	(
		(
			a10 = '='{copyLocalizationInfos((CommonToken)a10, element); }
			a11 = initialvalue{element.eSet(element.eClass().getEStructuralFeature("initialValue"), a11); copyLocalizationInfos(a11, element); }
		)
	)?
	(
		(
			a12 = ','{copyLocalizationInfos((CommonToken)a12, element); }
			a13 = additionallocalvariable{((List) element.eGet(element.eClass().getEStructuralFeature("additionalLocalVariables"))).add(a13); copyLocalizationInfos(a13, element); }
		)
	)*
;

localvariablestatement returns [LocalVariableStatement element = null]
@init{
	element = JavaFactory.eINSTANCE.createLocalVariableStatement();
}
:
	a0 = localvariable{element.eSet(element.eClass().getEStructuralFeature("variable"), a0); copyLocalizationInfos(a0, element); }
	a1 = ';'{copyLocalizationInfos((CommonToken)a1, element); }
;

additionallocalvariable returns [AdditionalLocalVariable element = null]
@init{
	element = JavaFactory.eINSTANCE.createAdditionalLocalVariable();
}
:
	a0 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a0, element); }
	(
		a1 = arraydimension{((List) element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"))).add(a1); copyLocalizationInfos(a1, element); }
	)*
	(
		(
			a2 = '='{copyLocalizationInfos((CommonToken)a2, element); }
			a3 = initialvalue{element.eSet(element.eClass().getEStructuralFeature("initialValue"), a3); copyLocalizationInfos(a3, element); }
		)
	)?
;

field returns [Field element = null]
@init{
	element = JavaFactory.eINSTANCE.createField();
}
:
	(
		a0 = annotationinstance{((List) element.eGet(element.eClass().getEStructuralFeature("annotations"))).add(a0); copyLocalizationInfos(a0, element); }
	)*
	(
		a1 = modifier{((List) element.eGet(element.eClass().getEStructuralFeature("modifiers"))).add(a1); copyLocalizationInfos(a1, element); }
	)*
	a2 = typereference{element.eSet(element.eClass().getEStructuralFeature("type"), a2); copyLocalizationInfos(a2, element); }
	(
		a3 = arraydimension{((List) element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"))).add(a3); copyLocalizationInfos(a3, element); }
	)*
	(
		(
			a4 = '<'{copyLocalizationInfos((CommonToken)a4, element); }
			a5 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("typeArguments"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Class proxy = JavaFactory.eINSTANCE.createClass();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("typeArguments"))).add(proxy); copyLocalizationInfos((CommonToken) a5, element); copyLocalizationInfos((CommonToken) a5, proxy); }
			(
				(
					a6 = ','{copyLocalizationInfos((CommonToken)a6, element); }
					a7 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a7.getText(),element.eClass().getEStructuralFeature("typeArguments"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a7,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Class proxy = JavaFactory.eINSTANCE.createClass();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("typeArguments"))).add(proxy); copyLocalizationInfos((CommonToken) a7, element); copyLocalizationInfos((CommonToken) a7, proxy); }
				)
			)*
			a8 = '>'{copyLocalizationInfos((CommonToken)a8, element); }
		)
	)?
	a9 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a9.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a9,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a9, element); }
	(
		a10 = arraydimension{((List) element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"))).add(a10); copyLocalizationInfos(a10, element); }
	)*
	(
		(
			a11 = '='{copyLocalizationInfos((CommonToken)a11, element); }
			a12 = initialvalue{element.eSet(element.eClass().getEStructuralFeature("initialValue"), a12); copyLocalizationInfos(a12, element); }
		)
	)?
	(
		(
			a13 = ','{copyLocalizationInfos((CommonToken)a13, element); }
			a14 = additionallocalvariable{((List) element.eGet(element.eClass().getEStructuralFeature("additionalFields"))).add(a14); copyLocalizationInfos(a14, element); }
		)
	)*
;

additionalfield returns [AdditionalField element = null]
@init{
	element = JavaFactory.eINSTANCE.createAdditionalField();
}
:
	a0 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a0, element); }
	(
		a1 = arraydimension{((List) element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"))).add(a1); copyLocalizationInfos(a1, element); }
	)*
	(
		(
			a2 = '='{copyLocalizationInfos((CommonToken)a2, element); }
			a3 = initialvalue{element.eSet(element.eClass().getEStructuralFeature("initialValue"), a3); copyLocalizationInfos(a3, element); }
		)
	)?
;

newconstructorcall returns [NewConstructorCall element = null]
@init{
	element = JavaFactory.eINSTANCE.createNewConstructorCall();
}
:
	a0 = 'new'{copyLocalizationInfos((CommonToken)a0, element); }
	(
		(
			a1 = '<'{copyLocalizationInfos((CommonToken)a1, element); }
			a2 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("typeArguments"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Class proxy = JavaFactory.eINSTANCE.createClass();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("typeArguments"))).add(proxy); copyLocalizationInfos((CommonToken) a2, element); copyLocalizationInfos((CommonToken) a2, proxy); }
			(
				(
					a3 = ','{copyLocalizationInfos((CommonToken)a3, element); }
					a4 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("typeArguments"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Class proxy = JavaFactory.eINSTANCE.createClass();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("typeArguments"))).add(proxy); copyLocalizationInfos((CommonToken) a4, element); copyLocalizationInfos((CommonToken) a4, proxy); }
				)
			)*
			a5 = '>'{copyLocalizationInfos((CommonToken)a5, element); }
		)
	)?
	a6 = typereference{element.eSet(element.eClass().getEStructuralFeature("type"), a6); copyLocalizationInfos(a6, element); }
	(
		(
			a7 = '<'{copyLocalizationInfos((CommonToken)a7, element); }
			a8 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a8.getText(),element.eClass().getEStructuralFeature("classTypeArguments"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a8,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Class proxy = JavaFactory.eINSTANCE.createClass();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("classTypeArguments"))).add(proxy); copyLocalizationInfos((CommonToken) a8, element); copyLocalizationInfos((CommonToken) a8, proxy); }
			(
				(
					a9 = ','{copyLocalizationInfos((CommonToken)a9, element); }
					a10 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a10.getText(),element.eClass().getEStructuralFeature("classTypeArguments"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a10,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Class proxy = JavaFactory.eINSTANCE.createClass();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("classTypeArguments"))).add(proxy); copyLocalizationInfos((CommonToken) a10, element); copyLocalizationInfos((CommonToken) a10, proxy); }
				)
			)*
			a11 = '>'{copyLocalizationInfos((CommonToken)a11, element); }
		)
	)?
	a12 = '('{copyLocalizationInfos((CommonToken)a12, element); }
	(
		(
			a13 = expression{((List) element.eGet(element.eClass().getEStructuralFeature("arguments"))).add(a13); copyLocalizationInfos(a13, element); }
			(
				(
					a14 = ','{copyLocalizationInfos((CommonToken)a14, element); }
					a15 = expression{((List) element.eGet(element.eClass().getEStructuralFeature("arguments"))).add(a15); copyLocalizationInfos(a15, element); }
				)
			)*
		)
	)?
	a16 = ')'{copyLocalizationInfos((CommonToken)a16, element); }
	(
		(
			a17 = '{'{copyLocalizationInfos((CommonToken)a17, element); }
			(
				(
					a18 = member{((List) element.eGet(element.eClass().getEStructuralFeature("members"))).add(a18); copyLocalizationInfos(a18, element); }
					(
						(
							a19 = ';'{copyLocalizationInfos((CommonToken)a19, element); }
						)
					)?
				)
			)*
			a20 = '}'{copyLocalizationInfos((CommonToken)a20, element); }
		)
	)?
;

explicitconstructorcall returns [ExplicitConstructorCall element = null]
@init{
	element = JavaFactory.eINSTANCE.createExplicitConstructorCall();
}
:
	(
		(
			a0 = '<'{copyLocalizationInfos((CommonToken)a0, element); }
			a1 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("typeArguments"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Class proxy = JavaFactory.eINSTANCE.createClass();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("typeArguments"))).add(proxy); copyLocalizationInfos((CommonToken) a1, element); copyLocalizationInfos((CommonToken) a1, proxy); }
			(
				(
					a2 = ','{copyLocalizationInfos((CommonToken)a2, element); }
					a3 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a3.getText(),element.eClass().getEStructuralFeature("typeArguments"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a3,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Class proxy = JavaFactory.eINSTANCE.createClass();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("typeArguments"))).add(proxy); copyLocalizationInfos((CommonToken) a3, element); copyLocalizationInfos((CommonToken) a3, proxy); }
				)
			)*
			a4 = '>'{copyLocalizationInfos((CommonToken)a4, element); }
		)
	)?
	a5 = selfreference{element.eSet(element.eClass().getEStructuralFeature("callTarget"), a5); copyLocalizationInfos(a5, element); }
	a6 = '('{copyLocalizationInfos((CommonToken)a6, element); }
	(
		(
			a7 = expression{((List) element.eGet(element.eClass().getEStructuralFeature("arguments"))).add(a7); copyLocalizationInfos(a7, element); }
			(
				(
					a8 = ','{copyLocalizationInfos((CommonToken)a8, element); }
					a9 = expression{((List) element.eGet(element.eClass().getEStructuralFeature("arguments"))).add(a9); copyLocalizationInfos(a9, element); }
				)
			)*
		)
	)?
	a10 = ')'{copyLocalizationInfos((CommonToken)a10, element); }
;

arrayinstantiationbyvalues returns [ArrayInstantiationByValues element = null]
@init{
	element = JavaFactory.eINSTANCE.createArrayInstantiationByValues();
}
:
	a0 = 'new'{copyLocalizationInfos((CommonToken)a0, element); }
	a1 = typereference{element.eSet(element.eClass().getEStructuralFeature("type"), a1); copyLocalizationInfos(a1, element); }
	(
		a2 = arraydimension{((List) element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"))).add(a2); copyLocalizationInfos(a2, element); }
	)+
	a3 = '{'{copyLocalizationInfos((CommonToken)a3, element); }
	(
		(
			a4 = initialvalue{((List) element.eGet(element.eClass().getEStructuralFeature("initialValues"))).add(a4); copyLocalizationInfos(a4, element); }
			(
				(
					(
						a5 = ','{copyLocalizationInfos((CommonToken)a5, element); }
					)
					a6 = initialvalue{((List) element.eGet(element.eClass().getEStructuralFeature("initialValues"))).add(a6); copyLocalizationInfos(a6, element); }
				)
			)*
			(
				(
					a7 = ','{copyLocalizationInfos((CommonToken)a7, element); }
				)
			)?
		)
	)?
	a8 = '}'{copyLocalizationInfos((CommonToken)a8, element); }
;

arrayinstantiationbysize returns [ArrayInstantiationBySize element = null]
@init{
	element = JavaFactory.eINSTANCE.createArrayInstantiationBySize();
}
:
	a0 = 'new'{copyLocalizationInfos((CommonToken)a0, element); }
	a1 = typereference{element.eSet(element.eClass().getEStructuralFeature("type"), a1); copyLocalizationInfos(a1, element); }
	(
		(
			a2 = '['{copyLocalizationInfos((CommonToken)a2, element); }
			a3 = expression{((List) element.eGet(element.eClass().getEStructuralFeature("sizes"))).add(a3); copyLocalizationInfos(a3, element); }
			a4 = ']'{copyLocalizationInfos((CommonToken)a4, element); }
		)
	)+
	(
		a5 = arraydimension{((List) element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"))).add(a5); copyLocalizationInfos(a5, element); }
	)*
;

reference returns [Reference element = null]
@init{
	element = JavaFactory.eINSTANCE.createReference();
}
:
	a0 = primaryreference{element.eSet(element.eClass().getEStructuralFeature("primary"), a0); copyLocalizationInfos(a0, element); }
	(
		(
			a1 = '['{copyLocalizationInfos((CommonToken)a1, element); }
			(
				a2 = expression{((List) element.eGet(element.eClass().getEStructuralFeature("arraySelectors"))).add(a2); copyLocalizationInfos(a2, element); }
			)?
			a3 = ']'{copyLocalizationInfos((CommonToken)a3, element); }
		)
	)*
	(
		(
			a4 = '.'{copyLocalizationInfos((CommonToken)a4, element); }
			a5 = reference{((List) element.eGet(element.eClass().getEStructuralFeature("next"))).add(a5); copyLocalizationInfos(a5, element); }
		)
	)?
;

typereferencesequence returns [TypeReferenceSequence element = null]
@init{
	element = JavaFactory.eINSTANCE.createTypeReferenceSequence();
}
:
	a0 = packageorclassifierreference{((List) element.eGet(element.eClass().getEStructuralFeature("parts"))).add(a0); copyLocalizationInfos(a0, element); }
	(
		(
			a1 = '.'{copyLocalizationInfos((CommonToken)a1, element); }
			a2 = packageorclassifierreference{((List) element.eGet(element.eClass().getEStructuralFeature("parts"))).add(a2); copyLocalizationInfos(a2, element); }
		)
	)*
;

packageorclassifierreference returns [PackageOrClassifierReference element = null]
@init{
	element = JavaFactory.eINSTANCE.createPackageOrClassifierReference();
}
:
	a0 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("target"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;Class proxy = JavaFactory.eINSTANCE.createClass();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("target"), proxy); copyLocalizationInfos((CommonToken) a0, element); copyLocalizationInfos((CommonToken) a0, proxy); }
	(
		(
			a1 = '<'{copyLocalizationInfos((CommonToken)a1, element); }
			a2 = typeargument{((List) element.eGet(element.eClass().getEStructuralFeature("typeArguments"))).add(a2); copyLocalizationInfos(a2, element); }
			(
				(
					a3 = ','{copyLocalizationInfos((CommonToken)a3, element); }
					a4 = typeargument{((List) element.eGet(element.eClass().getEStructuralFeature("typeArguments"))).add(a4); copyLocalizationInfos(a4, element); }
				)
			)*
			a5 = '>'{copyLocalizationInfos((CommonToken)a5, element); }
		)
	)?
;

packageorclassifierormethodorvariablereference returns [PackageOrClassifierOrMethodOrVariableReference element = null]
@init{
	element = JavaFactory.eINSTANCE.createPackageOrClassifierOrMethodOrVariableReference();
}
:
	a0 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("target"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;AnnotationMethod proxy = JavaFactory.eINSTANCE.createAnnotationMethod();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("target"), proxy); copyLocalizationInfos((CommonToken) a0, element); copyLocalizationInfos((CommonToken) a0, proxy); }
	(
		(
			a1 = '<'{copyLocalizationInfos((CommonToken)a1, element); }
			a2 = typeargument{((List) element.eGet(element.eClass().getEStructuralFeature("typeArguments"))).add(a2); copyLocalizationInfos(a2, element); }
			(
				(
					a3 = ','{copyLocalizationInfos((CommonToken)a3, element); }
					a4 = typeargument{((List) element.eGet(element.eClass().getEStructuralFeature("typeArguments"))).add(a4); copyLocalizationInfos(a4, element); }
				)
			)*
			a5 = '>'{copyLocalizationInfos((CommonToken)a5, element); }
		)
	)?
	(
		(
			a6 = '('{copyLocalizationInfos((CommonToken)a6, element); }
			(
				(
					a7 = expression{((List) element.eGet(element.eClass().getEStructuralFeature("arguments"))).add(a7); copyLocalizationInfos(a7, element); }
					(
						(
							a8 = ','{copyLocalizationInfos((CommonToken)a8, element); }
							a9 = expression{((List) element.eGet(element.eClass().getEStructuralFeature("arguments"))).add(a9); copyLocalizationInfos(a9, element); }
						)
					)*
				)
			)?
			a10 = ')'{copyLocalizationInfos((CommonToken)a10, element); }
		)
	)?
	|//derived choice rules for sub-classes: 
	c0 = explicitgenericinvocation{ element = c0; }
;

explicitgenericinvocation returns [ExplicitGenericInvocation element = null]
@init{
	element = JavaFactory.eINSTANCE.createExplicitGenericInvocation();
}
:
	(
		(
			a0 = '<'{copyLocalizationInfos((CommonToken)a0, element); }
			a1 = typeargument{((List) element.eGet(element.eClass().getEStructuralFeature("typeArguments"))).add(a1); copyLocalizationInfos(a1, element); }
			(
				(
					a2 = ','{copyLocalizationInfos((CommonToken)a2, element); }
					a3 = typeargument{((List) element.eGet(element.eClass().getEStructuralFeature("typeArguments"))).add(a3); copyLocalizationInfos(a3, element); }
				)
			)*
			a4 = '>'{copyLocalizationInfos((CommonToken)a4, element); }
		)
	)?
	a5 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("target"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;AnnotationMethod proxy = JavaFactory.eINSTANCE.createAnnotationMethod();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("target"), proxy); copyLocalizationInfos((CommonToken) a5, element); copyLocalizationInfos((CommonToken) a5, proxy); }
	(
		(
			a6 = '('{copyLocalizationInfos((CommonToken)a6, element); }
			(
				(
					a7 = expression{((List) element.eGet(element.eClass().getEStructuralFeature("arguments"))).add(a7); copyLocalizationInfos(a7, element); }
					(
						(
							a8 = ','{copyLocalizationInfos((CommonToken)a8, element); }
							a9 = expression{((List) element.eGet(element.eClass().getEStructuralFeature("arguments"))).add(a9); copyLocalizationInfos(a9, element); }
						)
					)*
				)
			)?
			a10 = ')'{copyLocalizationInfos((CommonToken)a10, element); }
		)
	)?
;

qualifiedtypeargument returns [QualifiedTypeArgument element = null]
@init{
	element = JavaFactory.eINSTANCE.createQualifiedTypeArgument();
}
:
	a0 = typereference{element.eSet(element.eClass().getEStructuralFeature("type"), a0); copyLocalizationInfos(a0, element); }
;

unknowntypeargument returns [UnknownTypeArgument element = null]
@init{
	element = JavaFactory.eINSTANCE.createUnknownTypeArgument();
}
:
	a0 = '?'{copyLocalizationInfos((CommonToken)a0, element); }
;

extendstypeargument returns [ExtendsTypeArgument element = null]
@init{
	element = JavaFactory.eINSTANCE.createExtendsTypeArgument();
}
:
	a0 = '?'{copyLocalizationInfos((CommonToken)a0, element); }
	a1 = 'extends'{copyLocalizationInfos((CommonToken)a1, element); }
	a2 = reference{((List) element.eGet(element.eClass().getEStructuralFeature("extendTypes"))).add(a2); copyLocalizationInfos(a2, element); }
	(
		(
			a3 = '&'{copyLocalizationInfos((CommonToken)a3, element); }
			a4 = reference{((List) element.eGet(element.eClass().getEStructuralFeature("extendTypes"))).add(a4); copyLocalizationInfos(a4, element); }
		)
	)*
;

supertypeargument returns [SuperTypeArgument element = null]
@init{
	element = JavaFactory.eINSTANCE.createSuperTypeArgument();
}
:
	a0 = '?'{copyLocalizationInfos((CommonToken)a0, element); }
	a1 = 'super'{copyLocalizationInfos((CommonToken)a1, element); }
	a2 = reference{element.eSet(element.eClass().getEStructuralFeature("superType"), a2); copyLocalizationInfos(a2, element); }
;

keywordassert returns [Assert element = null]
@init{
	element = JavaFactory.eINSTANCE.createAssert();
}
:
	a0 = 'assert'{copyLocalizationInfos((CommonToken)a0, element); }
	a1 = expression{element.eSet(element.eClass().getEStructuralFeature("expression1"), a1); copyLocalizationInfos(a1, element); }
	(
		(
			a2 = ':'{copyLocalizationInfos((CommonToken)a2, element); }
			a3 = expression{element.eSet(element.eClass().getEStructuralFeature("expression2"), a3); copyLocalizationInfos(a3, element); }
		)
	)?
	a4 = ';'{copyLocalizationInfos((CommonToken)a4, element); }
;

condition returns [Condition element = null]
@init{
	element = JavaFactory.eINSTANCE.createCondition();
}
:
	a0 = 'if'{copyLocalizationInfos((CommonToken)a0, element); }
	a1 = '('{copyLocalizationInfos((CommonToken)a1, element); }
	a2 = expression{element.eSet(element.eClass().getEStructuralFeature("expression"), a2); copyLocalizationInfos(a2, element); }
	a3 = ')'{copyLocalizationInfos((CommonToken)a3, element); }
	a4 = statement{element.eSet(element.eClass().getEStructuralFeature("ifStatement"), a4); copyLocalizationInfos(a4, element); }
	(
		(
			a5 = 'else'{copyLocalizationInfos((CommonToken)a5, element); }
			a6 = statement{element.eSet(element.eClass().getEStructuralFeature("elseStatement"), a6); copyLocalizationInfos(a6, element); }
		)
	)?
;

forloop returns [ForLoop element = null]
@init{
	element = JavaFactory.eINSTANCE.createForLoop();
}
:
	a0 = 'for'{copyLocalizationInfos((CommonToken)a0, element); }
	a1 = '('{copyLocalizationInfos((CommonToken)a1, element); }
	(
		a2 = forloopinitializer{element.eSet(element.eClass().getEStructuralFeature("init"), a2); copyLocalizationInfos(a2, element); }
	)?
	a3 = ';'{copyLocalizationInfos((CommonToken)a3, element); }
	(
		a4 = expression{element.eSet(element.eClass().getEStructuralFeature("condition"), a4); copyLocalizationInfos(a4, element); }
	)?
	a5 = ';'{copyLocalizationInfos((CommonToken)a5, element); }
	(
		(
			a6 = expression{((List) element.eGet(element.eClass().getEStructuralFeature("updates"))).add(a6); copyLocalizationInfos(a6, element); }
			(
				(
					a7 = ','{copyLocalizationInfos((CommonToken)a7, element); }
					a8 = expression{((List) element.eGet(element.eClass().getEStructuralFeature("updates"))).add(a8); copyLocalizationInfos(a8, element); }
				)
			)*
		)
	)?
	a9 = ')'{copyLocalizationInfos((CommonToken)a9, element); }
	a10 = block{element.eSet(element.eClass().getEStructuralFeature("body"), a10); copyLocalizationInfos(a10, element); }
;

foreachloop returns [ForEachLoop element = null]
@init{
	element = JavaFactory.eINSTANCE.createForEachLoop();
}
:
	a0 = 'for'{copyLocalizationInfos((CommonToken)a0, element); }
	a1 = '('{copyLocalizationInfos((CommonToken)a1, element); }
	a2 = ordinaryparameter{element.eSet(element.eClass().getEStructuralFeature("next"), a2); copyLocalizationInfos(a2, element); }
	a3 = ':'{copyLocalizationInfos((CommonToken)a3, element); }
	a4 = expression{element.eSet(element.eClass().getEStructuralFeature("collection"), a4); copyLocalizationInfos(a4, element); }
	a5 = ')'{copyLocalizationInfos((CommonToken)a5, element); }
	a6 = block{element.eSet(element.eClass().getEStructuralFeature("body"), a6); copyLocalizationInfos(a6, element); }
;

whileloop returns [WhileLoop element = null]
@init{
	element = JavaFactory.eINSTANCE.createWhileLoop();
}
:
	a0 = 'while'{copyLocalizationInfos((CommonToken)a0, element); }
	a1 = '('{copyLocalizationInfos((CommonToken)a1, element); }
	a2 = expression{element.eSet(element.eClass().getEStructuralFeature("condition"), a2); copyLocalizationInfos(a2, element); }
	a3 = ')'{copyLocalizationInfos((CommonToken)a3, element); }
	a4 = block{element.eSet(element.eClass().getEStructuralFeature("body"), a4); copyLocalizationInfos(a4, element); }
	|//derived choice rules for sub-classes: 
	c0 = dowhileloop{ element = c0; }
;

dowhileloop returns [DoWhileLoop element = null]
@init{
	element = JavaFactory.eINSTANCE.createDoWhileLoop();
}
:
	a0 = 'do'{copyLocalizationInfos((CommonToken)a0, element); }
	a1 = block{element.eSet(element.eClass().getEStructuralFeature("body"), a1); copyLocalizationInfos(a1, element); }
	a2 = 'while'{copyLocalizationInfos((CommonToken)a2, element); }
	a3 = '('{copyLocalizationInfos((CommonToken)a3, element); }
	a4 = expression{element.eSet(element.eClass().getEStructuralFeature("condition"), a4); copyLocalizationInfos(a4, element); }
	a5 = ')'{copyLocalizationInfos((CommonToken)a5, element); }
	a6 = ';'{copyLocalizationInfos((CommonToken)a6, element); }
;

emptystatement returns [EmptyStatement element = null]
@init{
	element = JavaFactory.eINSTANCE.createEmptyStatement();
}
:
	a0 = ';'{copyLocalizationInfos((CommonToken)a0, element); }
;

synchronizedblock returns [SynchronizedBlock element = null]
@init{
	element = JavaFactory.eINSTANCE.createSynchronizedBlock();
}
:
	a0 = 'synchronized'{copyLocalizationInfos((CommonToken)a0, element); }
	a1 = '('{copyLocalizationInfos((CommonToken)a1, element); }
	a2 = expression{element.eSet(element.eClass().getEStructuralFeature("lockExpression"), a2); copyLocalizationInfos(a2, element); }
	a3 = ')'{copyLocalizationInfos((CommonToken)a3, element); }
	a4 = block{element.eSet(element.eClass().getEStructuralFeature("body"), a4); copyLocalizationInfos(a4, element); }
;

tryblock returns [TryBlock element = null]
@init{
	element = JavaFactory.eINSTANCE.createTryBlock();
}
:
	a0 = 'try'{copyLocalizationInfos((CommonToken)a0, element); }
	a1 = block{element.eSet(element.eClass().getEStructuralFeature("tryBlock"), a1); copyLocalizationInfos(a1, element); }
	(
		a2 = catchclause{((List) element.eGet(element.eClass().getEStructuralFeature("catches"))).add(a2); copyLocalizationInfos(a2, element); }
	)*
	(
		(
			a3 = 'finally'{copyLocalizationInfos((CommonToken)a3, element); }
			a4 = block{element.eSet(element.eClass().getEStructuralFeature("finallyBlock"), a4); copyLocalizationInfos(a4, element); }
		)
	)?
;

catchclause returns [CatchClause element = null]
@init{
	element = JavaFactory.eINSTANCE.createCatchClause();
}
:
	a0 = 'catch'{copyLocalizationInfos((CommonToken)a0, element); }
	a1 = '('{copyLocalizationInfos((CommonToken)a1, element); }
	a2 = ordinaryparameter{element.eSet(element.eClass().getEStructuralFeature("parameter"), a2); copyLocalizationInfos(a2, element); }
	a3 = ')'{copyLocalizationInfos((CommonToken)a3, element); }
	a4 = block{element.eSet(element.eClass().getEStructuralFeature("catchBlock"), a4); copyLocalizationInfos(a4, element); }
;

keywordswitch returns [Switch element = null]
@init{
	element = JavaFactory.eINSTANCE.createSwitch();
}
:
	a0 = 'switch'{copyLocalizationInfos((CommonToken)a0, element); }
	a1 = '('{copyLocalizationInfos((CommonToken)a1, element); }
	a2 = expression{element.eSet(element.eClass().getEStructuralFeature("variable"), a2); copyLocalizationInfos(a2, element); }
	a3 = ')'{copyLocalizationInfos((CommonToken)a3, element); }
	a4 = '{'{copyLocalizationInfos((CommonToken)a4, element); }
	(
		a5 = normalswitchcase{((List) element.eGet(element.eClass().getEStructuralFeature("cases"))).add(a5); copyLocalizationInfos(a5, element); }
	)*
	(
		a6 = defaultswitchcase{element.eSet(element.eClass().getEStructuralFeature("default"), a6); copyLocalizationInfos(a6, element); }
	)?
	a7 = '}'{copyLocalizationInfos((CommonToken)a7, element); }
;

normalswitchcase returns [NormalSwitchCase element = null]
@init{
	element = JavaFactory.eINSTANCE.createNormalSwitchCase();
}
:
	a0 = 'case'{copyLocalizationInfos((CommonToken)a0, element); }
	a1 = expression{element.eSet(element.eClass().getEStructuralFeature("condition"), a1); copyLocalizationInfos(a1, element); }
	a2 = ':'{copyLocalizationInfos((CommonToken)a2, element); }
	(
		a3 = statement{((List) element.eGet(element.eClass().getEStructuralFeature("body"))).add(a3); copyLocalizationInfos(a3, element); }
	)*
;

defaultswitchcase returns [DefaultSwitchCase element = null]
@init{
	element = JavaFactory.eINSTANCE.createDefaultSwitchCase();
}
:
	a0 = 'default'{copyLocalizationInfos((CommonToken)a0, element); }
	a1 = ':'{copyLocalizationInfos((CommonToken)a1, element); }
	(
		a2 = statement{((List) element.eGet(element.eClass().getEStructuralFeature("body"))).add(a2); copyLocalizationInfos(a2, element); }
	)*
;

keywordreturn returns [Return element = null]
@init{
	element = JavaFactory.eINSTANCE.createReturn();
}
:
	a0 = 'return'{copyLocalizationInfos((CommonToken)a0, element); }
	(
		a1 = expression{element.eSet(element.eClass().getEStructuralFeature("expression"), a1); copyLocalizationInfos(a1, element); }
	)?
	a2 = ';'{copyLocalizationInfos((CommonToken)a2, element); }
;

keywordthrow returns [Throw element = null]
@init{
	element = JavaFactory.eINSTANCE.createThrow();
}
:
	a0 = 'throw'{copyLocalizationInfos((CommonToken)a0, element); }
	a1 = expression{element.eSet(element.eClass().getEStructuralFeature("expression"), a1); copyLocalizationInfos(a1, element); }
	a2 = ';'{copyLocalizationInfos((CommonToken)a2, element); }
;

keywordbreak returns [Break element = null]
@init{
	element = JavaFactory.eINSTANCE.createBreak();
}
:
	a0 = 'break'{copyLocalizationInfos((CommonToken)a0, element); }
	a1 = ';'{copyLocalizationInfos((CommonToken)a1, element); }
;

keywordcontinue returns [Continue element = null]
@init{
	element = JavaFactory.eINSTANCE.createContinue();
}
:
	a0 = 'continue'{copyLocalizationInfos((CommonToken)a0, element); }
	a1 = ';'{copyLocalizationInfos((CommonToken)a1, element); }
;

jumplabel returns [JumpLabel element = null]
@init{
	element = JavaFactory.eINSTANCE.createJumpLabel();
}
:
	a0 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a0, element); }
	a1 = ':'{copyLocalizationInfos((CommonToken)a1, element); }
	a2 = statement{element.eSet(element.eClass().getEStructuralFeature("statement"), a2); copyLocalizationInfos(a2, element); }
;

assignment returns [Assignment element = null]
@init{
	element = JavaFactory.eINSTANCE.createAssignment();
}
:
	a0 = reference{element.eSet(element.eClass().getEStructuralFeature("target"), a0); copyLocalizationInfos(a0, element); }
	a1 = '='{copyLocalizationInfos((CommonToken)a1, element); }
	a2 = expression{element.eSet(element.eClass().getEStructuralFeature("value"), a2); copyLocalizationInfos(a2, element); }
;

expressionstatement returns [ExpressionStatement element = null]
@init{
	element = JavaFactory.eINSTANCE.createExpressionStatement();
}
:
	a0 = expression{element.eSet(element.eClass().getEStructuralFeature("expression"), a0); copyLocalizationInfos(a0, element); }
	a1 = ';'{copyLocalizationInfos((CommonToken)a1, element); }
;

expressionlist returns [ExpressionList element = null]
@init{
	element = JavaFactory.eINSTANCE.createExpressionList();
}
:
	a0 = expression{((List) element.eGet(element.eClass().getEStructuralFeature("expressions"))).add(a0); copyLocalizationInfos(a0, element); }
	(
		(
			a1 = ','{copyLocalizationInfos((CommonToken)a1, element); }
			a2 = expression{((List) element.eGet(element.eClass().getEStructuralFeature("expressions"))).add(a2); copyLocalizationInfos(a2, element); }
		)
	)*
;

parexpression returns [ParExpression element = null]
@init{
	element = JavaFactory.eINSTANCE.createParExpression();
}
:
	a0 = '('{copyLocalizationInfos((CommonToken)a0, element); }
	a1 = expression{element.eSet(element.eClass().getEStructuralFeature("expression"), a1); copyLocalizationInfos(a1, element); }
	a2 = ')'{copyLocalizationInfos((CommonToken)a2, element); }
;

relationexpression returns [RelationExpression element = null]
@init{
	element = JavaFactory.eINSTANCE.createRelationExpression();
}
:
	a0 = shiftexpression{((List) element.eGet(element.eClass().getEStructuralFeature("shiftExpression"))).add(a0); copyLocalizationInfos(a0, element); }
	(
		(
			a1 = relationoperator{((List) element.eGet(element.eClass().getEStructuralFeature("relationOperator"))).add(a1); copyLocalizationInfos(a1, element); }
			a2 = shiftexpression{((List) element.eGet(element.eClass().getEStructuralFeature("shiftExpression"))).add(a2); copyLocalizationInfos(a2, element); }
		)
	)*
;

shiftexpression returns [ShiftExpression element = null]
@init{
	element = JavaFactory.eINSTANCE.createShiftExpression();
}
:
	a0 = additiveexpression{((List) element.eGet(element.eClass().getEStructuralFeature("additiveExpression"))).add(a0); copyLocalizationInfos(a0, element); }
	(
		(
			a1 = shiftoperator{((List) element.eGet(element.eClass().getEStructuralFeature("shiftOperator"))).add(a1); copyLocalizationInfos(a1, element); }
			a2 = additiveexpression{((List) element.eGet(element.eClass().getEStructuralFeature("additiveExpression"))).add(a2); copyLocalizationInfos(a2, element); }
		)
	)*
;

additiveexpression returns [AdditiveExpression element = null]
@init{
	element = JavaFactory.eINSTANCE.createAdditiveExpression();
}
:
	a0 = multiplicativeexpression{((List) element.eGet(element.eClass().getEStructuralFeature("multiplicativeExpression"))).add(a0); copyLocalizationInfos(a0, element); }
	(
		(
			a1 = additiveoperator{((List) element.eGet(element.eClass().getEStructuralFeature("additiveOperator"))).add(a1); copyLocalizationInfos(a1, element); }
			a2 = multiplicativeexpression{((List) element.eGet(element.eClass().getEStructuralFeature("multiplicativeExpression"))).add(a2); copyLocalizationInfos(a2, element); }
		)
	)*
;

multiplicativeexpression returns [MultiplicativeExpression element = null]
@init{
	element = JavaFactory.eINSTANCE.createMultiplicativeExpression();
}
:
	a0 = unaryexpression{((List) element.eGet(element.eClass().getEStructuralFeature("unaryExpression"))).add(a0); copyLocalizationInfos(a0, element); }
	(
		(
			a1 = multiplicativeoperator{((List) element.eGet(element.eClass().getEStructuralFeature("multiplicativeOperator"))).add(a1); copyLocalizationInfos(a1, element); }
			a2 = unaryexpression{((List) element.eGet(element.eClass().getEStructuralFeature("unaryExpression"))).add(a2); copyLocalizationInfos(a2, element); }
		)
	)*
;

unaryexpression returns [UnaryExpression element = null]
@init{
	element = JavaFactory.eINSTANCE.createUnaryExpression();
}
:
	(
		(
			a0 = additiveoperator{element.eSet(element.eClass().getEStructuralFeature("additiveOperator"), a0); copyLocalizationInfos(a0, element); }

			|
			a1 = plusplus{element.eSet(element.eClass().getEStructuralFeature("plusplus"), a1); copyLocalizationInfos(a1, element); }

			|
			a2 = minusminus{element.eSet(element.eClass().getEStructuralFeature("minusminus"), a2); copyLocalizationInfos(a2, element); }
		)
	)?
	a3 = unaryexpressionnotplusminus{element.eSet(element.eClass().getEStructuralFeature("unaryExpressionNotPlusMinus"), a3); copyLocalizationInfos(a3, element); }
;

unaryexpressionnotplusminus returns [UnaryExpressionNotPlusMinus element = null]
@init{
	element = JavaFactory.eINSTANCE.createUnaryExpressionNotPlusMinus();
}
:
	(
		a0 = complement{element.eSet(element.eClass().getEStructuralFeature("complement"), a0); copyLocalizationInfos(a0, element); }

		|
		a1 = negate{element.eSet(element.eClass().getEStructuralFeature("negate"), a1); copyLocalizationInfos(a1, element); }
	)
	a2 = primary{element.eSet(element.eClass().getEStructuralFeature("primary"), a2); copyLocalizationInfos(a2, element); }

	|
	a3 = castexpression{element.eSet(element.eClass().getEStructuralFeature("castExpression"), a3); copyLocalizationInfos(a3, element); }

	|
	a4 = primary{element.eSet(element.eClass().getEStructuralFeature("primary"), a4); copyLocalizationInfos(a4, element); }
	(
		(
			a5 = plusplus{element.eSet(element.eClass().getEStructuralFeature("plusplus"), a5); copyLocalizationInfos(a5, element); }

			|
			a6 = minusminus{element.eSet(element.eClass().getEStructuralFeature("minusminus"), a6); copyLocalizationInfos(a6, element); }
		)
	)?
;

castexpression returns [CastExpression element = null]
@init{
	element = JavaFactory.eINSTANCE.createCastExpression();
}
:
	a0 = '('{copyLocalizationInfos((CommonToken)a0, element); }
	a1 = primitivetype{element.eSet(element.eClass().getEStructuralFeature("primitiveType"), a1); copyLocalizationInfos(a1, element); }
	a2 = ')'{copyLocalizationInfos((CommonToken)a2, element); }
	a3 = unaryexpression{element.eSet(element.eClass().getEStructuralFeature("unaryExpression"), a3); copyLocalizationInfos(a3, element); }

	|
	a4 = '('{copyLocalizationInfos((CommonToken)a4, element); }
	(
		a5 = type{element.eSet(element.eClass().getEStructuralFeature("type"), a5); copyLocalizationInfos(a5, element); }

		|
		a6 = expression{element.eSet(element.eClass().getEStructuralFeature("expression"), a6); copyLocalizationInfos(a6, element); }
	)
	a7 = ')'{copyLocalizationInfos((CommonToken)a7, element); }
	a8 = unaryexpressionnotplusminus{element.eSet(element.eClass().getEStructuralFeature("unaryExpressionNotPlusMinus"), a8); copyLocalizationInfos(a8, element); }
;

primary returns [Primary element = null]
@init{
	element = JavaFactory.eINSTANCE.createPrimary();
}
:
	a0 = reference{element.eSet(element.eClass().getEStructuralFeature("reference"), a0); copyLocalizationInfos(a0, element); }

	|
	a1 = literal{element.eSet(element.eClass().getEStructuralFeature("literal"), a1); copyLocalizationInfos(a1, element); }

	|
	a2 = parexpression{element.eSet(element.eClass().getEStructuralFeature("parExpression"), a2); copyLocalizationInfos(a2, element); }
;

additiveoperator returns [AdditiveOperator element = null]
@init{
	element = JavaFactory.eINSTANCE.createAdditiveOperator();
}
:
	a0 = ADDITIVE_OPERATOR_LITERAL{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("ADDITIVE_OPERATOR_LITERAL");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("value"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("value"), resolved); copyLocalizationInfos((CommonToken) a0, element); }
;

multiplicativeoperator returns [MultiplicativeOperator element = null]
@init{
	element = JavaFactory.eINSTANCE.createMultiplicativeOperator();
}
:
	a0 = MULTIPLICATIVE_OPERATOR_LITERAL{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("MULTIPLICATIVE_OPERATOR_LITERAL");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("value"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("value"), resolved); copyLocalizationInfos((CommonToken) a0, element); }
;

lessthan returns [LessThan element = null]
@init{
	element = JavaFactory.eINSTANCE.createLessThan();
}
:
	a0 = '<'{copyLocalizationInfos((CommonToken)a0, element); }
;

lessthanorequal returns [LessThanOrEqual element = null]
@init{
	element = JavaFactory.eINSTANCE.createLessThanOrEqual();
}
:
	a0 = '<'{copyLocalizationInfos((CommonToken)a0, element); }
	a1 = '='{copyLocalizationInfos((CommonToken)a1, element); }
;

greaterthan returns [GreaterThan element = null]
@init{
	element = JavaFactory.eINSTANCE.createGreaterThan();
}
:
	a0 = '>'{copyLocalizationInfos((CommonToken)a0, element); }
;

greaterthanorequal returns [GreaterThanOrEqual element = null]
@init{
	element = JavaFactory.eINSTANCE.createGreaterThanOrEqual();
}
:
	a0 = '>'{copyLocalizationInfos((CommonToken)a0, element); }
	a1 = '='{copyLocalizationInfos((CommonToken)a1, element); }
;

leftshift returns [LeftShift element = null]
@init{
	element = JavaFactory.eINSTANCE.createLeftShift();
}
:
	a0 = '<'{copyLocalizationInfos((CommonToken)a0, element); }
	a1 = '<'{copyLocalizationInfos((CommonToken)a1, element); }
;

rightshift returns [RightShift element = null]
@init{
	element = JavaFactory.eINSTANCE.createRightShift();
}
:
	a0 = '>'{copyLocalizationInfos((CommonToken)a0, element); }
	a1 = '>'{copyLocalizationInfos((CommonToken)a1, element); }
;

unsignedrightshift returns [UnsignedRightShift element = null]
@init{
	element = JavaFactory.eINSTANCE.createUnsignedRightShift();
}
:
	a0 = '>'{copyLocalizationInfos((CommonToken)a0, element); }
	a1 = '>'{copyLocalizationInfos((CommonToken)a1, element); }
	a2 = '>'{copyLocalizationInfos((CommonToken)a2, element); }
;

plusplus returns [PlusPlus element = null]
@init{
	element = JavaFactory.eINSTANCE.createPlusPlus();
}
:
	a0 = '++'{copyLocalizationInfos((CommonToken)a0, element); }
;

minusminus returns [MinusMinus element = null]
@init{
	element = JavaFactory.eINSTANCE.createMinusMinus();
}
:
	a0 = '--'{copyLocalizationInfos((CommonToken)a0, element); }
;

complement returns [Complement element = null]
@init{
	element = JavaFactory.eINSTANCE.createComplement();
}
:
	a0 = '~'{copyLocalizationInfos((CommonToken)a0, element); }
;

negate returns [Negate element = null]
@init{
	element = JavaFactory.eINSTANCE.createNegate();
}
:
	a0 = '!'{copyLocalizationInfos((CommonToken)a0, element); }
;

booleanexpression returns [BooleanExpression element = null]
@init{
	element = JavaFactory.eINSTANCE.createBooleanExpression();
}
:
	a0 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("left"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("left"), resolved); copyLocalizationInfos((CommonToken) a0, element); }
	(
		a1 = '='{copyLocalizationInfos((CommonToken)a1, element); }

		|
		a2 = '+='{copyLocalizationInfos((CommonToken)a2, element); }

		|
		a3 = '-='{copyLocalizationInfos((CommonToken)a3, element); }

		|
		a4 = '*='{copyLocalizationInfos((CommonToken)a4, element); }

		|
		a5 = '/='{copyLocalizationInfos((CommonToken)a5, element); }

		|
		a6 = '&='{copyLocalizationInfos((CommonToken)a6, element); }

		|
		a7 = '|='{copyLocalizationInfos((CommonToken)a7, element); }

		|
		a8 = '^='{copyLocalizationInfos((CommonToken)a8, element); }

		|
		a9 = '%='{copyLocalizationInfos((CommonToken)a9, element); }

		|
		a10 = '<'{copyLocalizationInfos((CommonToken)a10, element); }
		a11 = '<'{copyLocalizationInfos((CommonToken)a11, element); }
		a12 = '='{copyLocalizationInfos((CommonToken)a12, element); }

		|
		a13 = '>'{copyLocalizationInfos((CommonToken)a13, element); }
		a14 = '>'{copyLocalizationInfos((CommonToken)a14, element); }
		a15 = '='{copyLocalizationInfos((CommonToken)a15, element); }

		|
		a16 = '>'{copyLocalizationInfos((CommonToken)a16, element); }
		a17 = '>'{copyLocalizationInfos((CommonToken)a17, element); }
		a18 = '>'{copyLocalizationInfos((CommonToken)a18, element); }
		a19 = '='{copyLocalizationInfos((CommonToken)a19, element); }
	)
	a20 = IDENTIFIER{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a20.getText(),element.eClass().getEStructuralFeature("right"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a20,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("right"), resolved); copyLocalizationInfos((CommonToken) a20, element); }
;

arraydimension returns [ArrayDimension element = null]
@init{
	element = JavaFactory.eINSTANCE.createArrayDimension();
}
:
	(
		a0 = '['{copyLocalizationInfos((CommonToken)a0, element); }
		a1 = ']'{copyLocalizationInfos((CommonToken)a1, element); }
	)
;

nullliteral returns [NullLiteral element = null]
@init{
	element = JavaFactory.eINSTANCE.createNullLiteral();
}
:
	a0 = 'null'{copyLocalizationInfos((CommonToken)a0, element); }
;

voidliteral returns [VoidLiteral element = null]
@init{
	element = JavaFactory.eINSTANCE.createVoidLiteral();
}
:
	a0 = 'void'{copyLocalizationInfos((CommonToken)a0, element); }
;

classliteral returns [ClassLiteral element = null]
@init{
	element = JavaFactory.eINSTANCE.createClassLiteral();
}
:
	a0 = 'class'{copyLocalizationInfos((CommonToken)a0, element); }
;

keywordthis returns [This element = null]
@init{
	element = JavaFactory.eINSTANCE.createThis();
}
:
	a0 = 'this'{copyLocalizationInfos((CommonToken)a0, element); }
;

keywordsuper returns [Super element = null]
@init{
	element = JavaFactory.eINSTANCE.createSuper();
}
:
	a0 = 'super'{copyLocalizationInfos((CommonToken)a0, element); }
;

keywordpublic returns [Public element = null]
@init{
	element = JavaFactory.eINSTANCE.createPublic();
}
:
	a0 = 'public'{copyLocalizationInfos((CommonToken)a0, element); }
;

keywordabstract returns [Abstract element = null]
@init{
	element = JavaFactory.eINSTANCE.createAbstract();
}
:
	a0 = 'abstract'{copyLocalizationInfos((CommonToken)a0, element); }
;

keywordprotected returns [Protected element = null]
@init{
	element = JavaFactory.eINSTANCE.createProtected();
}
:
	a0 = 'protected'{copyLocalizationInfos((CommonToken)a0, element); }
;

keywordprivate returns [Private element = null]
@init{
	element = JavaFactory.eINSTANCE.createPrivate();
}
:
	a0 = 'private'{copyLocalizationInfos((CommonToken)a0, element); }
;

keywordfinal returns [Final element = null]
@init{
	element = JavaFactory.eINSTANCE.createFinal();
}
:
	a0 = 'final'{copyLocalizationInfos((CommonToken)a0, element); }
;

keywordstatic returns [Static element = null]
@init{
	element = JavaFactory.eINSTANCE.createStatic();
}
:
	a0 = 'static'{copyLocalizationInfos((CommonToken)a0, element); }
;

keywordnative returns [Native element = null]
@init{
	element = JavaFactory.eINSTANCE.createNative();
}
:
	a0 = 'native'{copyLocalizationInfos((CommonToken)a0, element); }
;

keywordsynchronized returns [Synchronized element = null]
@init{
	element = JavaFactory.eINSTANCE.createSynchronized();
}
:
	a0 = 'synchronized'{copyLocalizationInfos((CommonToken)a0, element); }
;

keywordtransient returns [Transient element = null]
@init{
	element = JavaFactory.eINSTANCE.createTransient();
}
:
	a0 = 'transient'{copyLocalizationInfos((CommonToken)a0, element); }
;

keywordvolatile returns [Volatile element = null]
@init{
	element = JavaFactory.eINSTANCE.createVolatile();
}
:
	a0 = 'volatile'{copyLocalizationInfos((CommonToken)a0, element); }
;

keywordstrictfp returns [Strictfp element = null]
@init{
	element = JavaFactory.eINSTANCE.createStrictfp();
}
:
	a0 = 'strictfp'{copyLocalizationInfos((CommonToken)a0, element); }
;

keywordboolean returns [Boolean element = null]
@init{
	element = JavaFactory.eINSTANCE.createBoolean();
}
:
	a0 = 'boolean'{copyLocalizationInfos((CommonToken)a0, element); }
;

keywordchar returns [Char element = null]
@init{
	element = JavaFactory.eINSTANCE.createChar();
}
:
	a0 = 'char'{copyLocalizationInfos((CommonToken)a0, element); }
;

keywordbyte returns [Byte element = null]
@init{
	element = JavaFactory.eINSTANCE.createByte();
}
:
	a0 = 'byte'{copyLocalizationInfos((CommonToken)a0, element); }
;

keywordshort returns [Short element = null]
@init{
	element = JavaFactory.eINSTANCE.createShort();
}
:
	a0 = 'short'{copyLocalizationInfos((CommonToken)a0, element); }
;

keywordint returns [Int element = null]
@init{
	element = JavaFactory.eINSTANCE.createInt();
}
:
	a0 = 'int'{copyLocalizationInfos((CommonToken)a0, element); }
;

keywordlong returns [Long element = null]
@init{
	element = JavaFactory.eINSTANCE.createLong();
}
:
	a0 = 'long'{copyLocalizationInfos((CommonToken)a0, element); }
;

keywordfloat returns [Float element = null]
@init{
	element = JavaFactory.eINSTANCE.createFloat();
}
:
	a0 = 'float'{copyLocalizationInfos((CommonToken)a0, element); }
;

keyworddouble returns [Double element = null]
@init{
	element = JavaFactory.eINSTANCE.createDouble();
}
:
	a0 = 'double'{copyLocalizationInfos((CommonToken)a0, element); }
;

integerliteral returns [IntegerLiteral element = null]
@init{
	element = JavaFactory.eINSTANCE.createIntegerLiteral();
}
:
	a0 = DECIMAL_LITERAL{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("DECIMAL_LITERAL");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("value"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());long resolved = (java.lang.Long)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("value"), resolved); copyLocalizationInfos((CommonToken) a0, element); }

	|
	a1 = HEX_LITERAL{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("HEX_LITERAL");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("value"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());long resolved = (java.lang.Long)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("value"), resolved); copyLocalizationInfos((CommonToken) a1, element); }

	|
	a2 = OCTAL_LITERAL{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("OCTAL_LITERAL");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("value"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());long resolved = (java.lang.Long)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("value"), resolved); copyLocalizationInfos((CommonToken) a2, element); }
;

floatingpointliteral returns [FloatingPointLiteral element = null]
@init{
	element = JavaFactory.eINSTANCE.createFloatingPointLiteral();
}
:
	a0 = FLOATING_POINT_LITERAL{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("FLOATING_POINT_LITERAL");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("value"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());double resolved = (java.lang.Double)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("value"), resolved); copyLocalizationInfos((CommonToken) a0, element); }
;

characterliteral returns [CharacterLiteral element = null]
@init{
	element = JavaFactory.eINSTANCE.createCharacterLiteral();
}
:
	a0 = CHARACTER_LITERAL{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("CHARACTER_LITERAL");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("value"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());char resolved = (java.lang.Character)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("value"), resolved); copyLocalizationInfos((CommonToken) a0, element); }
;

stringliteral returns [StringLiteral element = null]
@init{
	element = JavaFactory.eINSTANCE.createStringLiteral();
}
:
	a0 = STRING_LITERAL{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("STRING_LITERAL");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("value"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("value"), resolved); copyLocalizationInfos((CommonToken) a0, element); }
;

booleanliteral returns [BooleanLiteral element = null]
@init{
	element = JavaFactory.eINSTANCE.createBooleanLiteral();
}
:
	a0 = BOOLEAN_LITERAL{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("BOOLEAN_LITERAL");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("value"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());boolean resolved = (java.lang.Boolean)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("value"), resolved); copyLocalizationInfos((CommonToken) a0, element); }
;

singlelinecomment returns [SingleLineComment element = null]
@init{
	element = JavaFactory.eINSTANCE.createSingleLineComment();
}
:
	a0 = SL_COMMENT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("SL_COMMENT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("content"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("content"), resolved); copyLocalizationInfos((CommonToken) a0, element); }
;

multilinecomment returns [MultiLineComment element = null]
@init{
	element = JavaFactory.eINSTANCE.createMultiLineComment();
}
:
	a0 = ML_COMMENT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("ML_COMMENT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("content"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("content"), resolved); copyLocalizationInfos((CommonToken) a0, element); }
;

comment
returns [Comment element = null]
:
	c0 = singlelinecomment{ element = c0; }	|
	c1 = multilinecomment{ element = c1; }
;

classifier
returns [Classifier element = null]
:
	c0 = keywordclass{ element = c0; }	|
	c1 = keywordinterface{ element = c1; }	|
	c2 = annotation{ element = c2; }	|
	c3 = enumeration{ element = c3; }
;

modifier
returns [Modifier element = null]
:
	c0 = keywordpublic{ element = c0; }	|
	c1 = keywordabstract{ element = c1; }	|
	c2 = keywordprotected{ element = c2; }	|
	c3 = keywordprivate{ element = c3; }	|
	c4 = keywordfinal{ element = c4; }	|
	c5 = keywordstatic{ element = c5; }	|
	c6 = keywordnative{ element = c6; }	|
	c7 = keywordsynchronized{ element = c7; }	|
	c8 = keywordtransient{ element = c8; }	|
	c9 = keywordvolatile{ element = c9; }	|
	c10 = keywordstrictfp{ element = c10; }
;

member
returns [Member element = null]
:
	c0 = keywordclass{ element = c0; }	|
	c1 = keywordinterface{ element = c1; }	|
	c2 = annotation{ element = c2; }	|
	c3 = enumeration{ element = c3; }	|
	c4 = block{ element = c4; }	|
	c5 = constructor{ element = c5; }	|
	c6 = method{ element = c6; }	|
	c7 = annotationmethod{ element = c7; }	|
	c8 = field{ element = c8; }	|
	c9 = singlelinecomment{ element = c9; }	|
	c10 = multilinecomment{ element = c10; }
;

annotationelementvalue
returns [AnnotationElementValue element = null]
:
	c0 = annotationinstance{ element = c0; }	|
	c1 = annotationelementvaluearray{ element = c1; }	|
	c2 = nullliteral{ element = c2; }	|
	c3 = integerliteral{ element = c3; }	|
	c4 = floatingpointliteral{ element = c4; }	|
	c5 = characterliteral{ element = c5; }	|
	c6 = stringliteral{ element = c6; }	|
	c7 = booleanliteral{ element = c7; }
;

expression
returns [Expression element = null]
:
	c0 = arrayinstantiationbyvalues{ element = c0; }	|
	c1 = arrayinstantiationbysize{ element = c1; }	|
	c2 = assignment{ element = c2; }	|
	c3 = relationexpression{ element = c3; }
;

statement
returns [Statement element = null]
:
	c0 = keywordclass{ element = c0; }	|
	c1 = keywordinterface{ element = c1; }	|
	c2 = annotation{ element = c2; }	|
	c3 = enumeration{ element = c3; }	|
	c4 = block{ element = c4; }	|
	c5 = localvariablestatement{ element = c5; }	|
	c6 = keywordassert{ element = c6; }	|
	c7 = condition{ element = c7; }	|
	c8 = forloop{ element = c8; }	|
	c9 = foreachloop{ element = c9; }	|
	c10 = whileloop{ element = c10; }	|
	c11 = dowhileloop{ element = c11; }	|
	c12 = emptystatement{ element = c12; }	|
	c13 = synchronizedblock{ element = c13; }	|
	c14 = tryblock{ element = c14; }	|
	c15 = keywordswitch{ element = c15; }	|
	c16 = keywordreturn{ element = c16; }	|
	c17 = keywordthrow{ element = c17; }	|
	c18 = keywordbreak{ element = c18; }	|
	c19 = keywordcontinue{ element = c19; }	|
	c20 = jumplabel{ element = c20; }	|
	c21 = expressionstatement{ element = c21; }	|
	c22 = singlelinecomment{ element = c22; }	|
	c23 = multilinecomment{ element = c23; }
;

parameter
returns [Parameter element = null]
:
	c0 = ordinaryparameter{ element = c0; }	|
	c1 = variablelengthparameter{ element = c1; }
;

typereference
returns [TypeReference element = null]
:
	c0 = typereferencesequence{ element = c0; }	|
	c1 = voidliteral{ element = c1; }	|
	c2 = keywordboolean{ element = c2; }	|
	c3 = keywordchar{ element = c3; }	|
	c4 = keywordbyte{ element = c4; }	|
	c5 = keywordshort{ element = c5; }	|
	c6 = keywordint{ element = c6; }	|
	c7 = keywordlong{ element = c7; }	|
	c8 = keywordfloat{ element = c8; }	|
	c9 = keyworddouble{ element = c9; }
;

initialvalue
returns [InitialValue element = null]
:
	c0 = arrayinstantiationbyvalues{ element = c0; }	|
	c1 = arrayinstantiationbysize{ element = c1; }	|
	c2 = assignment{ element = c2; }	|
	c3 = relationexpression{ element = c3; }
;

selfreference
returns [SelfReference element = null]
:
	c0 = keywordthis{ element = c0; }	|
	c1 = keywordsuper{ element = c1; }
;

primaryreference
returns [PrimaryReference element = null]
:
	c0 = newconstructorcall{ element = c0; }	|
	c1 = explicitconstructorcall{ element = c1; }	|
	c2 = packageorclassifierormethodorvariablereference{ element = c2; }	|
	c3 = explicitgenericinvocation{ element = c3; }	|
	c4 = voidliteral{ element = c4; }	|
	c5 = classliteral{ element = c5; }	|
	c6 = keywordthis{ element = c6; }	|
	c7 = keywordsuper{ element = c7; }	|
	c8 = keywordboolean{ element = c8; }	|
	c9 = keywordchar{ element = c9; }	|
	c10 = keywordbyte{ element = c10; }	|
	c11 = keywordshort{ element = c11; }	|
	c12 = keywordint{ element = c12; }	|
	c13 = keywordlong{ element = c13; }	|
	c14 = keywordfloat{ element = c14; }	|
	c15 = keyworddouble{ element = c15; }
;

typeargument
returns [TypeArgument element = null]
:
	c0 = qualifiedtypeargument{ element = c0; }	|
	c1 = unknowntypeargument{ element = c1; }	|
	c2 = extendstypeargument{ element = c2; }	|
	c3 = supertypeargument{ element = c3; }
;

forloopinitializer
returns [ForLoopInitializer element = null]
:
	c0 = localvariable{ element = c0; }	|
	c1 = expressionlist{ element = c1; }
;

relationoperator
returns [RelationOperator element = null]
:
	c0 = lessthan{ element = c0; }	|
	c1 = lessthanorequal{ element = c1; }	|
	c2 = greaterthan{ element = c2; }	|
	c3 = greaterthanorequal{ element = c3; }
;

shiftoperator
returns [ShiftOperator element = null]
:
	c0 = leftshift{ element = c0; }	|
	c1 = rightshift{ element = c1; }	|
	c2 = unsignedrightshift{ element = c2; }
;

primitivetype
returns [PrimitiveType element = null]
:
	c0 = voidliteral{ element = c0; }	|
	c1 = keywordboolean{ element = c1; }	|
	c2 = keywordchar{ element = c2; }	|
	c3 = keywordbyte{ element = c3; }	|
	c4 = keywordshort{ element = c4; }	|
	c5 = keywordint{ element = c5; }	|
	c6 = keywordlong{ element = c6; }	|
	c7 = keywordfloat{ element = c7; }	|
	c8 = keyworddouble{ element = c8; }
;

type
returns [Type element = null]
:
	c0 = keywordclass{ element = c0; }	|
	c1 = keywordinterface{ element = c1; }	|
	c2 = annotation{ element = c2; }	|
	c3 = enumeration{ element = c3; }
;

literal
returns [Literal element = null]
:
	c0 = nullliteral{ element = c0; }	|
	c1 = integerliteral{ element = c1; }	|
	c2 = floatingpointliteral{ element = c2; }	|
	c3 = characterliteral{ element = c3; }	|
	c4 = stringliteral{ element = c4; }	|
	c5 = booleanliteral{ element = c5; }
;

SL_COMMENT
:
	'//'(~('\n'|'\r'))*
;
ML_COMMENT
:
	'/*'.*'*/'
;
FLOATING_POINT_LITERAL
:
	('0'..'9')+ '.' ('0'..'9')* (('e'|'E') ('+'|'-')? ('0'..'9')+)? (('f'|'F'|'d'|'D'))? |   ('.' ('0'..'9')+ (('e'|'E') ('+'|'-')? ('0'..'9')+)? (('f'|'F'|'d'|'D'))?) |   (('0'..'9')+ (('e'|'E') ('+'|'-')? ('0'..'9')+) (('f'|'F'|'d'|'D'))?) |   (('0'..'9')+ (('f'|'F'|'d'|'D')))
;
HEX_LITERAL
:
	'0'('x'|'X')('0'..'9'|'a'..'f'|'A'..'F')+('l'|'L')?
;
DECIMAL_LITERAL
:
	('0'|'1'..'9''0'..'9'*)('l'|'L')?
;
OCTAL_LITERAL
:
	'0'('0'..'7')+('l'|'L')?
;
BOOLEAN_LITERAL
:
	'true'|'false'
;
ADDITIVE_OPERATOR_LITERAL
:
	'+'|'-'
;
MULTIPLICATIVE_OPERATOR_LITERAL
:
	'*'|'/'|'%'
;
CHARACTER_LITERAL
:
	'\''('\\'('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')|('\\''u'('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F'))|('\\'('0'..'3')('0'..'7')('0'..'7')|'\\'('0'..'7')('0'..'7')|'\\'('0'..'7'))|~('\''|'\\'))'\''
;
STRING_LITERAL
:
	'"'('\\'('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')|('\\''u'('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F'))|'\\'('0'..'7')|~('\\'|'"'))*'"'
;
IDENTIFIER
:
	('A'..'Z'|'a'..'z'|'0'..'9'|'_')+
;
LB
:
	('\r\n' | '\r' | '\n'){ channel=99; }
;
WS
:
	(' ' | '\t' | '\f'){ channel=99; }
;
