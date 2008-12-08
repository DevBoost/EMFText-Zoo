package org.emftext.language.java.resource.java;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.java.CompilationUnit;
import org.emftext.language.java.Import;
import org.emftext.language.java.Class;
import org.emftext.language.java.Interface;
import org.emftext.language.java.Annotation;
import org.emftext.language.java.AnnotationInstance;
import org.emftext.language.java.AnnotationElementValuePair;
import org.emftext.language.java.AnnotationElementValueArray;
import org.emftext.language.java.Enumeration;
import org.emftext.language.java.TypeParameter;
import org.emftext.language.java.EnumConstant;
import org.emftext.language.java.Block;
import org.emftext.language.java.Constructor;
import org.emftext.language.java.Method;
import org.emftext.language.java.AnnotationMethod;
import org.emftext.language.java.OrdinaryParameter;
import org.emftext.language.java.VariableLengthParameter;
import org.emftext.language.java.LocalVariable;
import org.emftext.language.java.LocalVariableStatement;
import org.emftext.language.java.AdditionalLocalVariable;
import org.emftext.language.java.Field;
import org.emftext.language.java.AdditionalField;
import org.emftext.language.java.NewConstructorCall;
import org.emftext.language.java.ExplicitConstructorCall;
import org.emftext.language.java.ArrayInstantiationByValues;
import org.emftext.language.java.ArrayInstantiationBySize;
import org.emftext.language.java.Reference;
import org.emftext.language.java.TypeReferenceSequence;
import org.emftext.language.java.PackageOrClassifierReference;
import org.emftext.language.java.PackageOrClassifierOrMethodOrVariableReference;
import org.emftext.language.java.ExplicitGenericInvocation;
import org.emftext.language.java.QualifiedTypeArgument;
import org.emftext.language.java.UnknownTypeArgument;
import org.emftext.language.java.ExtendsTypeArgument;
import org.emftext.language.java.SuperTypeArgument;
import org.emftext.language.java.Assert;
import org.emftext.language.java.Condition;
import org.emftext.language.java.ForLoop;
import org.emftext.language.java.ForEachLoop;
import org.emftext.language.java.WhileLoop;
import org.emftext.language.java.DoWhileLoop;
import org.emftext.language.java.EmptyStatement;
import org.emftext.language.java.SynchronizedBlock;
import org.emftext.language.java.TryBlock;
import org.emftext.language.java.CatchClause;
import org.emftext.language.java.Switch;
import org.emftext.language.java.NormalSwitchCase;
import org.emftext.language.java.DefaultSwitchCase;
import org.emftext.language.java.Return;
import org.emftext.language.java.Throw;
import org.emftext.language.java.Break;
import org.emftext.language.java.Continue;
import org.emftext.language.java.JumpLabel;
import org.emftext.language.java.Assignment;
import org.emftext.language.java.ExpressionStatement;
import org.emftext.language.java.ExpressionList;
import org.emftext.language.java.ParExpression;
import org.emftext.language.java.RelationExpression;
import org.emftext.language.java.ShiftExpression;
import org.emftext.language.java.AdditiveExpression;
import org.emftext.language.java.MultiplicativeExpression;
import org.emftext.language.java.UnaryExpression;
import org.emftext.language.java.UnaryExpressionNotPlusMinus;
import org.emftext.language.java.CastExpression;
import org.emftext.language.java.Primary;
import org.emftext.language.java.AdditiveOperator;
import org.emftext.language.java.MultiplicativeOperator;
import org.emftext.language.java.LessThan;
import org.emftext.language.java.LessThanOrEqual;
import org.emftext.language.java.GreaterThan;
import org.emftext.language.java.GreaterThanOrEqual;
import org.emftext.language.java.LeftShift;
import org.emftext.language.java.RightShift;
import org.emftext.language.java.UnsignedRightShift;
import org.emftext.language.java.PlusPlus;
import org.emftext.language.java.MinusMinus;
import org.emftext.language.java.Complement;
import org.emftext.language.java.Negate;
import org.emftext.language.java.BooleanExpression;
import org.emftext.language.java.ArrayDimension;
import org.emftext.language.java.NullLiteral;
import org.emftext.language.java.VoidLiteral;
import org.emftext.language.java.ClassLiteral;
import org.emftext.language.java.This;
import org.emftext.language.java.Super;
import org.emftext.language.java.Public;
import org.emftext.language.java.Abstract;
import org.emftext.language.java.Protected;
import org.emftext.language.java.Private;
import org.emftext.language.java.Final;
import org.emftext.language.java.Static;
import org.emftext.language.java.Native;
import org.emftext.language.java.Synchronized;
import org.emftext.language.java.Transient;
import org.emftext.language.java.Volatile;
import org.emftext.language.java.Strictfp;
import org.emftext.language.java.Boolean;
import org.emftext.language.java.Char;
import org.emftext.language.java.Byte;
import org.emftext.language.java.Short;
import org.emftext.language.java.Int;
import org.emftext.language.java.Long;
import org.emftext.language.java.Float;
import org.emftext.language.java.Double;
import org.emftext.language.java.IntegerLiteral;
import org.emftext.language.java.FloatingPointLiteral;
import org.emftext.language.java.CharacterLiteral;
import org.emftext.language.java.StringLiteral;
import org.emftext.language.java.BooleanLiteral;
import org.emftext.language.java.SingleLineComment;
import org.emftext.language.java.MultiLineComment;
import java.util.List;
import java.util.Collection;
import java.util.ListIterator;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Map;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.emftext.runtime.resource.*;
import org.emftext.runtime.resource.impl.*;

public abstract class JavaPrinterBase extends EMFTextPrinterImpl {

	protected TokenResolverFactory tokenResolverFactory = new JavaTokenResolverFactory();
	protected EMFTextTreeAnalyser treeAnalyser = new JavaTreeAnalyser();

	public JavaPrinterBase(OutputStream o, TextResource resource) {

		super(o, resource);
	}

	protected static int matchCount(Map<java.lang.String, java.lang.Integer> featureCounter, Collection<java.lang.String> needed){
		int pos = 0;
		int neg = 0;

		for(String featureName:featureCounter.keySet()){
			if(needed.contains(featureName)){
				int value = featureCounter.get(featureName);
				if(value==0)
					neg+=1;
				else
					pos+=1;
			}
		}
		return neg>0?-neg:pos;
	}

	protected void doPrint(EObject element,PrintWriter out,String globaltab) {
		if (element == null||out == null) throw new NullPointerException("Nothing to write or to write on.");

		if(element instanceof CompilationUnit){
			printCompilationUnit((CompilationUnit) element,globaltab,out);
			return;
		}
		if(element instanceof Import){
			printImport((Import) element,globaltab,out);
			return;
		}
		if(element instanceof Class){
			printClass((Class) element,globaltab,out);
			return;
		}
		if(element instanceof Interface){
			printInterface((Interface) element,globaltab,out);
			return;
		}
		if(element instanceof Annotation){
			printAnnotation((Annotation) element,globaltab,out);
			return;
		}
		if(element instanceof AnnotationInstance){
			printAnnotationInstance((AnnotationInstance) element,globaltab,out);
			return;
		}
		if(element instanceof AnnotationElementValuePair){
			printAnnotationElementValuePair((AnnotationElementValuePair) element,globaltab,out);
			return;
		}
		if(element instanceof AnnotationElementValueArray){
			printAnnotationElementValueArray((AnnotationElementValueArray) element,globaltab,out);
			return;
		}
		if(element instanceof Enumeration){
			printEnumeration((Enumeration) element,globaltab,out);
			return;
		}
		if(element instanceof TypeParameter){
			printTypeParameter((TypeParameter) element,globaltab,out);
			return;
		}
		if(element instanceof EnumConstant){
			printEnumConstant((EnumConstant) element,globaltab,out);
			return;
		}
		if(element instanceof Block){
			printBlock((Block) element,globaltab,out);
			return;
		}
		if(element instanceof Constructor){
			printConstructor((Constructor) element,globaltab,out);
			return;
		}
		if(element instanceof AnnotationMethod){
			printAnnotationMethod((AnnotationMethod) element,globaltab,out);
			return;
		}
		if(element instanceof OrdinaryParameter){
			printOrdinaryParameter((OrdinaryParameter) element,globaltab,out);
			return;
		}
		if(element instanceof VariableLengthParameter){
			printVariableLengthParameter((VariableLengthParameter) element,globaltab,out);
			return;
		}
		if(element instanceof LocalVariable){
			printLocalVariable((LocalVariable) element,globaltab,out);
			return;
		}
		if(element instanceof LocalVariableStatement){
			printLocalVariableStatement((LocalVariableStatement) element,globaltab,out);
			return;
		}
		if(element instanceof AdditionalLocalVariable){
			printAdditionalLocalVariable((AdditionalLocalVariable) element,globaltab,out);
			return;
		}
		if(element instanceof Field){
			printField((Field) element,globaltab,out);
			return;
		}
		if(element instanceof AdditionalField){
			printAdditionalField((AdditionalField) element,globaltab,out);
			return;
		}
		if(element instanceof NewConstructorCall){
			printNewConstructorCall((NewConstructorCall) element,globaltab,out);
			return;
		}
		if(element instanceof ExplicitConstructorCall){
			printExplicitConstructorCall((ExplicitConstructorCall) element,globaltab,out);
			return;
		}
		if(element instanceof ArrayInstantiationByValues){
			printArrayInstantiationByValues((ArrayInstantiationByValues) element,globaltab,out);
			return;
		}
		if(element instanceof ArrayInstantiationBySize){
			printArrayInstantiationBySize((ArrayInstantiationBySize) element,globaltab,out);
			return;
		}
		if(element instanceof Reference){
			printReference((Reference) element,globaltab,out);
			return;
		}
		if(element instanceof TypeReferenceSequence){
			printTypeReferenceSequence((TypeReferenceSequence) element,globaltab,out);
			return;
		}
		if(element instanceof PackageOrClassifierReference){
			printPackageOrClassifierReference((PackageOrClassifierReference) element,globaltab,out);
			return;
		}
		if(element instanceof ExplicitGenericInvocation){
			printExplicitGenericInvocation((ExplicitGenericInvocation) element,globaltab,out);
			return;
		}
		if(element instanceof QualifiedTypeArgument){
			printQualifiedTypeArgument((QualifiedTypeArgument) element,globaltab,out);
			return;
		}
		if(element instanceof UnknownTypeArgument){
			printUnknownTypeArgument((UnknownTypeArgument) element,globaltab,out);
			return;
		}
		if(element instanceof ExtendsTypeArgument){
			printExtendsTypeArgument((ExtendsTypeArgument) element,globaltab,out);
			return;
		}
		if(element instanceof SuperTypeArgument){
			printSuperTypeArgument((SuperTypeArgument) element,globaltab,out);
			return;
		}
		if(element instanceof Assert){
			printAssert((Assert) element,globaltab,out);
			return;
		}
		if(element instanceof Condition){
			printCondition((Condition) element,globaltab,out);
			return;
		}
		if(element instanceof ForLoop){
			printForLoop((ForLoop) element,globaltab,out);
			return;
		}
		if(element instanceof ForEachLoop){
			printForEachLoop((ForEachLoop) element,globaltab,out);
			return;
		}
		if(element instanceof DoWhileLoop){
			printDoWhileLoop((DoWhileLoop) element,globaltab,out);
			return;
		}
		if(element instanceof EmptyStatement){
			printEmptyStatement((EmptyStatement) element,globaltab,out);
			return;
		}
		if(element instanceof SynchronizedBlock){
			printSynchronizedBlock((SynchronizedBlock) element,globaltab,out);
			return;
		}
		if(element instanceof TryBlock){
			printTryBlock((TryBlock) element,globaltab,out);
			return;
		}
		if(element instanceof CatchClause){
			printCatchClause((CatchClause) element,globaltab,out);
			return;
		}
		if(element instanceof Switch){
			printSwitch((Switch) element,globaltab,out);
			return;
		}
		if(element instanceof NormalSwitchCase){
			printNormalSwitchCase((NormalSwitchCase) element,globaltab,out);
			return;
		}
		if(element instanceof DefaultSwitchCase){
			printDefaultSwitchCase((DefaultSwitchCase) element,globaltab,out);
			return;
		}
		if(element instanceof Return){
			printReturn((Return) element,globaltab,out);
			return;
		}
		if(element instanceof Throw){
			printThrow((Throw) element,globaltab,out);
			return;
		}
		if(element instanceof Break){
			printBreak((Break) element,globaltab,out);
			return;
		}
		if(element instanceof Continue){
			printContinue((Continue) element,globaltab,out);
			return;
		}
		if(element instanceof JumpLabel){
			printJumpLabel((JumpLabel) element,globaltab,out);
			return;
		}
		if(element instanceof Assignment){
			printAssignment((Assignment) element,globaltab,out);
			return;
		}
		if(element instanceof ExpressionStatement){
			printExpressionStatement((ExpressionStatement) element,globaltab,out);
			return;
		}
		if(element instanceof ExpressionList){
			printExpressionList((ExpressionList) element,globaltab,out);
			return;
		}
		if(element instanceof ParExpression){
			printParExpression((ParExpression) element,globaltab,out);
			return;
		}
		if(element instanceof RelationExpression){
			printRelationExpression((RelationExpression) element,globaltab,out);
			return;
		}
		if(element instanceof ShiftExpression){
			printShiftExpression((ShiftExpression) element,globaltab,out);
			return;
		}
		if(element instanceof AdditiveExpression){
			printAdditiveExpression((AdditiveExpression) element,globaltab,out);
			return;
		}
		if(element instanceof MultiplicativeExpression){
			printMultiplicativeExpression((MultiplicativeExpression) element,globaltab,out);
			return;
		}
		if(element instanceof UnaryExpression){
			printUnaryExpression((UnaryExpression) element,globaltab,out);
			return;
		}
		if(element instanceof UnaryExpressionNotPlusMinus){
			printUnaryExpressionNotPlusMinus((UnaryExpressionNotPlusMinus) element,globaltab,out);
			return;
		}
		if(element instanceof CastExpression){
			printCastExpression((CastExpression) element,globaltab,out);
			return;
		}
		if(element instanceof Primary){
			printPrimary((Primary) element,globaltab,out);
			return;
		}
		if(element instanceof AdditiveOperator){
			printAdditiveOperator((AdditiveOperator) element,globaltab,out);
			return;
		}
		if(element instanceof MultiplicativeOperator){
			printMultiplicativeOperator((MultiplicativeOperator) element,globaltab,out);
			return;
		}
		if(element instanceof LessThan){
			printLessThan((LessThan) element,globaltab,out);
			return;
		}
		if(element instanceof LessThanOrEqual){
			printLessThanOrEqual((LessThanOrEqual) element,globaltab,out);
			return;
		}
		if(element instanceof GreaterThan){
			printGreaterThan((GreaterThan) element,globaltab,out);
			return;
		}
		if(element instanceof GreaterThanOrEqual){
			printGreaterThanOrEqual((GreaterThanOrEqual) element,globaltab,out);
			return;
		}
		if(element instanceof LeftShift){
			printLeftShift((LeftShift) element,globaltab,out);
			return;
		}
		if(element instanceof RightShift){
			printRightShift((RightShift) element,globaltab,out);
			return;
		}
		if(element instanceof UnsignedRightShift){
			printUnsignedRightShift((UnsignedRightShift) element,globaltab,out);
			return;
		}
		if(element instanceof PlusPlus){
			printPlusPlus((PlusPlus) element,globaltab,out);
			return;
		}
		if(element instanceof MinusMinus){
			printMinusMinus((MinusMinus) element,globaltab,out);
			return;
		}
		if(element instanceof Complement){
			printComplement((Complement) element,globaltab,out);
			return;
		}
		if(element instanceof Negate){
			printNegate((Negate) element,globaltab,out);
			return;
		}
		if(element instanceof BooleanExpression){
			printBooleanExpression((BooleanExpression) element,globaltab,out);
			return;
		}
		if(element instanceof ArrayDimension){
			printArrayDimension((ArrayDimension) element,globaltab,out);
			return;
		}
		if(element instanceof NullLiteral){
			printNullLiteral((NullLiteral) element,globaltab,out);
			return;
		}
		if(element instanceof VoidLiteral){
			printVoidLiteral((VoidLiteral) element,globaltab,out);
			return;
		}
		if(element instanceof ClassLiteral){
			printClassLiteral((ClassLiteral) element,globaltab,out);
			return;
		}
		if(element instanceof This){
			printThis((This) element,globaltab,out);
			return;
		}
		if(element instanceof Super){
			printSuper((Super) element,globaltab,out);
			return;
		}
		if(element instanceof Public){
			printPublic((Public) element,globaltab,out);
			return;
		}
		if(element instanceof Abstract){
			printAbstract((Abstract) element,globaltab,out);
			return;
		}
		if(element instanceof Protected){
			printProtected((Protected) element,globaltab,out);
			return;
		}
		if(element instanceof Private){
			printPrivate((Private) element,globaltab,out);
			return;
		}
		if(element instanceof Final){
			printFinal((Final) element,globaltab,out);
			return;
		}
		if(element instanceof Static){
			printStatic((Static) element,globaltab,out);
			return;
		}
		if(element instanceof Native){
			printNative((Native) element,globaltab,out);
			return;
		}
		if(element instanceof Synchronized){
			printSynchronized((Synchronized) element,globaltab,out);
			return;
		}
		if(element instanceof Transient){
			printTransient((Transient) element,globaltab,out);
			return;
		}
		if(element instanceof Volatile){
			printVolatile((Volatile) element,globaltab,out);
			return;
		}
		if(element instanceof Strictfp){
			printStrictfp((Strictfp) element,globaltab,out);
			return;
		}
		if(element instanceof Boolean){
			printBoolean((Boolean) element,globaltab,out);
			return;
		}
		if(element instanceof Char){
			printChar((Char) element,globaltab,out);
			return;
		}
		if(element instanceof Byte){
			printByte((Byte) element,globaltab,out);
			return;
		}
		if(element instanceof Short){
			printShort((Short) element,globaltab,out);
			return;
		}
		if(element instanceof Int){
			printInt((Int) element,globaltab,out);
			return;
		}
		if(element instanceof Long){
			printLong((Long) element,globaltab,out);
			return;
		}
		if(element instanceof Float){
			printFloat((Float) element,globaltab,out);
			return;
		}
		if(element instanceof Double){
			printDouble((Double) element,globaltab,out);
			return;
		}
		if(element instanceof IntegerLiteral){
			printIntegerLiteral((IntegerLiteral) element,globaltab,out);
			return;
		}
		if(element instanceof FloatingPointLiteral){
			printFloatingPointLiteral((FloatingPointLiteral) element,globaltab,out);
			return;
		}
		if(element instanceof CharacterLiteral){
			printCharacterLiteral((CharacterLiteral) element,globaltab,out);
			return;
		}
		if(element instanceof StringLiteral){
			printStringLiteral((StringLiteral) element,globaltab,out);
			return;
		}
		if(element instanceof BooleanLiteral){
			printBooleanLiteral((BooleanLiteral) element,globaltab,out);
			return;
		}
		if(element instanceof SingleLineComment){
			printSingleLineComment((SingleLineComment) element,globaltab,out);
			return;
		}
		if(element instanceof MultiLineComment){
			printMultiLineComment((MultiLineComment) element,globaltab,out);
			return;
		}
		if(element instanceof Method){
			printMethod((Method) element,globaltab,out);
			return;
		}
		if(element instanceof PackageOrClassifierOrMethodOrVariableReference){
			printPackageOrClassifierOrMethodOrVariableReference((PackageOrClassifierOrMethodOrVariableReference) element,globaltab,out);
			return;
		}
		if(element instanceof WhileLoop){
			printWhileLoop((WhileLoop) element,globaltab,out);
			return;
		}

		resource.addWarning("The cs printer can not handle " + element.eClass().getName() + " elements", element);
	}

		public void printCompilationUnit(CompilationUnit element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(6);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("comments"));
			printCountingMap.put("comments", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("annotations"));
			printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("package"));
			printCountingMap.put("package", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("imports"));
			printCountingMap.put("imports", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("classifiers"));
			printCountingMap.put("classifiers", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("implicitImportedClassifiers"));
			printCountingMap.put("implicitImportedClassifiers", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("comments");
			if(count>0){
				ListIterator it  = ((List)element.eGet(element.eClass().getEStructuralFeature("comments"))).listIterator(((List)element.eGet(element.eClass().getEStructuralFeature("comments"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("comments",0);
			}
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("annotations");
			if(count>0){
				ListIterator it  = ((List)element.eGet(element.eClass().getEStructuralFeature("annotations"))).listIterator(((List)element.eGet(element.eClass().getEStructuralFeature("annotations"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("annotations",0);
			}
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("comments");
			if(count>0){
				ListIterator it  = ((List)element.eGet(element.eClass().getEStructuralFeature("comments"))).listIterator(((List)element.eGet(element.eClass().getEStructuralFeature("comments"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("comments",0);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printCompilationUnit_0(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			//////////////DEFINITION PART BEGINS (LineBreak):
			out.println();
			out.print(localtab);
			//////////////DEFINITION PART BEGINS (LineBreak):
			out.println();
			out.print(localtab);
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("comments");
			if(count>0){
				ListIterator it  = ((List)element.eGet(element.eClass().getEStructuralFeature("comments"))).listIterator(((List)element.eGet(element.eClass().getEStructuralFeature("comments"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("comments",0);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				sWriter = new StringWriter();
				out1 = new PrintWriter(sWriter);
				printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printCompilationUnit_1(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (LineBreak):
			out.println();
			out.print(localtab);
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			printCompilationUnit_2(element,localtab,out,printCountingMap);
			 iterate = true;
			while(iterate){
				sWriter = new StringWriter();
				out1 = new PrintWriter(sWriter);
				printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printCompilationUnit_2(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
		}
		public void printCompilationUnit_0(CompilationUnit element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("package");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("package");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("package"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("package"),element));
				out.print(" ");
				printCountingMap.put("package",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printCompilationUnit_0_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (WhiteSpaces):
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(";");
			out.print(" ");
		}
		public void printCompilationUnit_0_0(CompilationUnit element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (WhiteSpaces):
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(".");
			//////////////DEFINITION PART BEGINS (WhiteSpaces):
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("package");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("package"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("package"),element));
				out.print(" ");
				printCountingMap.put("package",count-1);
			}
		}
		public void printCompilationUnit_2(CompilationUnit element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("classifiers");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("classifiers"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("classifiers",count-1);
			}
			//////////////DEFINITION PART BEGINS (LineBreak):
			out.println();
			out.print(localtab);
			//////////////DEFINITION PART BEGINS (LineBreak):
			out.println();
			out.print(localtab);
		}
		public void printCompilationUnit_1(CompilationUnit element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("import");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("imports");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("imports"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("imports",count-1);
			}
			//////////////DEFINITION PART BEGINS (WhiteSpaces):
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(";");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (LineBreak):
			out.println();
			out.print(localtab);
		}
		public void printImport(Import element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(3);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("package"));
			printCountingMap.put("package", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("classifiers"));
			printCountingMap.put("classifiers", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("static"));
			printCountingMap.put("static", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("static");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("static"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("static",count-1);
			}
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("package");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("package"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("package"),element));
				
				printCountingMap.put("package",count-1);
			}
			//////////////DEFINITION PART BEGINS (WhiteSpaces):
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printImport_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (WhiteSpaces):
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(".");
			//////////////DEFINITION PART BEGINS (WhiteSpaces):
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("classifiers");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("classifiers"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("classifiers")),element.eClass().getEStructuralFeature("classifiers"),element));out.print(" ");
				printCountingMap.put("classifiers",count-1);
			}
		}
		public void printImport_0(Import element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(".");
			//////////////DEFINITION PART BEGINS (WhiteSpaces):
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("package");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("package"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("package"),element));
				out.print(" ");
				printCountingMap.put("package",count-1);
			}
		}
		public void printClass(Class element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(6);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("typeParameters"));
			printCountingMap.put("typeParameters", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("name"));
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("modifiers"));
			printCountingMap.put("modifiers", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("members"));
			printCountingMap.put("members", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("extends"));
			printCountingMap.put("extends", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("implements"));
			printCountingMap.put("implements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("modifiers");
			if(count>0){
				ListIterator it  = ((List)element.eGet(element.eClass().getEStructuralFeature("modifiers"))).listIterator(((List)element.eGet(element.eClass().getEStructuralFeature("modifiers"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("modifiers",0);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("class");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("name");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("name"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				out.print(" ");
				printCountingMap.put("name",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printClass_0(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			sWriter = new StringWriter();
			out1 = new PrintWriter(sWriter);
			printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printClass_1(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			sWriter = new StringWriter();
			out1 = new PrintWriter(sWriter);
			printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printClass_2(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				sWriter = new StringWriter();
				out1 = new PrintWriter(sWriter);
				printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printClass_3(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (LineBreak):
			out.println();
			out.print(localtab);
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
			out.print(" ");
		}
		public void printClass_0_0(Class element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(",");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("typeParameters");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("typeParameters"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("typeParameters",count-1);
			}
		}
		public void printClass_3_0(Class element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(";");
			out.print(" ");
		}
		public void printClass_2(Class element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("implements");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("implements");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("implements"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("implements",count-1);
			}
		}
		public void printClass_3(Class element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (LineBreak):
			localtab += "	";
			out.println();
			out.print(localtab);
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("members");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("members"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("members",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printClass_3_0(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		public void printClass_1(Class element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("extends");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("extends");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("extends"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("extends",count-1);
			}
		}
		public void printClass_0(Class element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("<");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("typeParameters");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("typeParameters"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("typeParameters",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printClass_0_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(">");
			out.print(" ");
		}
		public void printInterface(Interface element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(5);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("typeParameters"));
			printCountingMap.put("typeParameters", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("name"));
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("modifiers"));
			printCountingMap.put("modifiers", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("members"));
			printCountingMap.put("members", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("extends"));
			printCountingMap.put("extends", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("modifiers");
			if(count>0){
				ListIterator it  = ((List)element.eGet(element.eClass().getEStructuralFeature("modifiers"))).listIterator(((List)element.eGet(element.eClass().getEStructuralFeature("modifiers"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("modifiers",0);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("interface");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("name");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("name"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				out.print(" ");
				printCountingMap.put("name",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printInterface_0(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			sWriter = new StringWriter();
			out1 = new PrintWriter(sWriter);
			printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printInterface_1(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				sWriter = new StringWriter();
				out1 = new PrintWriter(sWriter);
				printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printInterface_2(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
			out.print(" ");
		}
		public void printInterface_2_0_0(Interface element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(";");
			out.print(" ");
		}
		public void printInterface_2(Interface element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("members"));
			int tempMatchCount;
			tempMatchCount=0;
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CompoundDefinition):
						StringWriter sWriter = new StringWriter();
						PrintWriter out1 = new PrintWriter(sWriter);
						HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
						printInterface_2_1(element,localtab,out1,printCountingMap1);
						if(printCountingMap.equals(printCountingMap1)){
							out1.close();
						}
						else{
							out1.flush();
							out1.close();
							out.print(sWriter.toString());
							printCountingMap.putAll(printCountingMap1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CompoundDefinition):
					printInterface_2_0(element,localtab,out,printCountingMap);
			}
		}
		public void printInterface_2_1(Interface element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(";");
			out.print(" ");
		}
		public void printInterface_0(Interface element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("<");
			//////////////DEFINITION PART BEGINS (WhiteSpaces):
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("typeParameters");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("typeParameters"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("typeParameters",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printInterface_0_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (WhiteSpaces):
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(">");
			out.print(" ");
		}
		public void printInterface_2_0(Interface element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("members");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("members"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("members",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printInterface_2_0_0(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		public void printInterface_1_0_0(Interface element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(",");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("extends");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("extends"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("extends",count-1);
			}
		}
		public void printInterface_1_0(Interface element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("extends");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("extends"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("extends",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printInterface_1_0_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
		}
		public void printInterface_0_0(Interface element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (WhiteSpaces):
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(",");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("typeParameters");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("typeParameters"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("typeParameters",count-1);
			}
		}
		public void printInterface_1(Interface element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("extends");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			printInterface_1_0(element,localtab,out,printCountingMap);
		}
		public void printAnnotation(Annotation element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(4);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("typeParameters"));
			printCountingMap.put("typeParameters", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("name"));
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("modifiers"));
			printCountingMap.put("modifiers", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("members"));
			printCountingMap.put("members", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("modifiers");
			if(count>0){
				ListIterator it  = ((List)element.eGet(element.eClass().getEStructuralFeature("modifiers"))).listIterator(((List)element.eGet(element.eClass().getEStructuralFeature("modifiers"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("modifiers",0);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("@");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("interface");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("name");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("name"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				out.print(" ");
				printCountingMap.put("name",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printAnnotation_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
			out.print(" ");
		}
		public void printAnnotation_0(Annotation element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("members"));
			int tempMatchCount;
			tempMatchCount=0;
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CompoundDefinition):
						StringWriter sWriter = new StringWriter();
						PrintWriter out1 = new PrintWriter(sWriter);
						HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
						printAnnotation_0_1(element,localtab,out1,printCountingMap1);
						if(printCountingMap.equals(printCountingMap1)){
							out1.close();
						}
						else{
							out1.flush();
							out1.close();
							out.print(sWriter.toString());
							printCountingMap.putAll(printCountingMap1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CompoundDefinition):
					printAnnotation_0_0(element,localtab,out,printCountingMap);
			}
		}
		public void printAnnotation_0_1(Annotation element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(";");
			out.print(" ");
		}
		public void printAnnotation_0_0_0(Annotation element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(";");
			out.print(" ");
		}
		public void printAnnotation_0_0(Annotation element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("members");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("members"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("members",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printAnnotation_0_0_0(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		public void printAnnotationInstance(AnnotationInstance element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(3);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("annotation"));
			printCountingMap.put("annotation", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("elementValuePairs"));
			printCountingMap.put("elementValuePairs", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("elementValue"));
			printCountingMap.put("elementValue", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("@");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("annotation");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("annotation"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("annotation",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printAnnotationInstance_0(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		public void printAnnotationInstance_0_0_0_0(AnnotationInstance element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(",");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("elementValuePairs");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("elementValuePairs"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("elementValuePairs",count-1);
			}
		}
		public void printAnnotationInstance_0(AnnotationInstance element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("(");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			printAnnotationInstance_0_0(element,localtab,out,printCountingMap);
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(")");
			out.print(" ");
		}
		public void printAnnotationInstance_0_0_0(AnnotationInstance element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("elementValuePairs");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("elementValuePairs"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("elementValuePairs",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printAnnotationInstance_0_0_0_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
		}
		public void printAnnotationInstance_0_0(AnnotationInstance element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("elementValue"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("elementValuePairs"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CompoundDefinition):
						printAnnotationInstance_0_0_0(element,localtab,out,printCountingMap);
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (Containment):
					count = printCountingMap.get("elementValue");
					if(count>0){
						Object o =element.eGet(element.eClass().getEStructuralFeature("elementValue"));
						doPrint((EObject)o,out,localtab);
						printCountingMap.put("elementValue",count-1);
					}
			}
		}
		public void printAnnotationElementValuePair(AnnotationElementValuePair element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("key"));
			printCountingMap.put("key", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("value"));
			printCountingMap.put("value", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("key");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("key"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("key")),element.eClass().getEStructuralFeature("key"),element));out.print(" ");
				printCountingMap.put("key",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("=");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("value");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("value"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("value",count-1);
			}
		}
		public void printAnnotationElementValueArray(AnnotationElementValueArray element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("values"));
			printCountingMap.put("values", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printAnnotationElementValueArray_0(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			sWriter = new StringWriter();
			out1 = new PrintWriter(sWriter);
			printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printAnnotationElementValueArray_1(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
			out.print(" ");
		}
		public void printAnnotationElementValueArray_0(AnnotationElementValueArray element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("values");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("values"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("values",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printAnnotationElementValueArray_0_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
		}
		public void printAnnotationElementValueArray_1(AnnotationElementValueArray element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(",");
			out.print(" ");
		}
		public void printAnnotationElementValueArray_0_0(AnnotationElementValueArray element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(",");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("values");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("values"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("values",count-1);
			}
		}
		public void printEnumeration(Enumeration element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(6);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("typeParameters"));
			printCountingMap.put("typeParameters", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("name"));
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("modifiers"));
			printCountingMap.put("modifiers", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("constants"));
			printCountingMap.put("constants", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("members"));
			printCountingMap.put("members", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("implements"));
			printCountingMap.put("implements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("modifiers");
			if(count>0){
				ListIterator it  = ((List)element.eGet(element.eClass().getEStructuralFeature("modifiers"))).listIterator(((List)element.eGet(element.eClass().getEStructuralFeature("modifiers"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("modifiers",0);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("enum");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("name");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("name"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				out.print(" ");
				printCountingMap.put("name",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printEnumeration_0(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			sWriter = new StringWriter();
			out1 = new PrintWriter(sWriter);
			printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printEnumeration_1(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			sWriter = new StringWriter();
			out1 = new PrintWriter(sWriter);
			printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printEnumeration_2(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			printEnumeration_3(element,localtab,out,printCountingMap);
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
			out.print(" ");
		}
		public void printEnumeration_3(Enumeration element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=0;
			int tempMatchCount;
			tempMatchCount=0;
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CompoundDefinition):
						StringWriter sWriter = new StringWriter();
						PrintWriter out1 = new PrintWriter(sWriter);
						HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
						printEnumeration_3_1(element,localtab,out1,printCountingMap1);
						if(printCountingMap.equals(printCountingMap1)){
							out1.close();
						}
						else{
							out1.flush();
							out1.close();
							out.print(sWriter.toString());
							printCountingMap.putAll(printCountingMap1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CompoundDefinition):
					StringWriter sWriter = new StringWriter();
					PrintWriter out1 = new PrintWriter(sWriter);
					HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
					printEnumeration_3_0(element,localtab,out1,printCountingMap1);
					if(printCountingMap.equals(printCountingMap1)){
						out1.close();
					}
					else{
						out1.flush();
						out1.close();
						out.print(sWriter.toString());
						printCountingMap.putAll(printCountingMap1);
					}
			}
		}
		public void printEnumeration_1_0(Enumeration element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(",");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("constants");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("constants"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("constants",count-1);
			}
		}
		public void printEnumeration_2(Enumeration element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(",");
			out.print(" ");
		}
		public void printEnumeration_0(Enumeration element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("implements");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			printEnumeration_0_0(element,localtab,out,printCountingMap);
		}
		public void printEnumeration_1(Enumeration element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("constants");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("constants"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("constants",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printEnumeration_1_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
		}
		public void printEnumeration_3_1(Enumeration element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(";");
			out.print(" ");
		}
		public void printEnumeration_0_0_0(Enumeration element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(",");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("implements");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("implements"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("implements")),element.eClass().getEStructuralFeature("implements"),element));out.print(" ");
				printCountingMap.put("implements",count-1);
			}
		}
		public void printEnumeration_3_0(Enumeration element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(";");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("members");
			if(count>0){
				ListIterator it  = ((List)element.eGet(element.eClass().getEStructuralFeature("members"))).listIterator(((List)element.eGet(element.eClass().getEStructuralFeature("members"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("members",0);
			}
		}
		public void printEnumeration_0_0(Enumeration element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("implements");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("implements"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("implements")),element.eClass().getEStructuralFeature("implements"),element));out.print(" ");
				printCountingMap.put("implements",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printEnumeration_0_0_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
		}
		public void printTypeParameter(TypeParameter element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("name"));
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("extendTypes"));
			printCountingMap.put("extendTypes", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("name");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("name"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				out.print(" ");
				printCountingMap.put("name",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printTypeParameter_0(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		public void printTypeParameter_0_0(TypeParameter element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("&");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("extendTypes");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("extendTypes"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("extendTypes",count-1);
			}
		}
		public void printTypeParameter_0(TypeParameter element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("extends");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("extendTypes");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("extendTypes"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("extendTypes",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printTypeParameter_0_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
		}
		public void printEnumConstant(EnumConstant element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(3);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("name"));
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("arguments"));
			printCountingMap.put("arguments", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("members"));
			printCountingMap.put("members", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("name");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("name"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				out.print(" ");
				printCountingMap.put("name",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printEnumConstant_0(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("members");
			if(count>0){
				ListIterator it  = ((List)element.eGet(element.eClass().getEStructuralFeature("members"))).listIterator(((List)element.eGet(element.eClass().getEStructuralFeature("members"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("members",0);
			}
		}
		public void printEnumConstant_0_0(EnumConstant element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(",");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("arguments");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("arguments"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("arguments",count-1);
			}
		}
		public void printEnumConstant_0(EnumConstant element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("(");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("arguments");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("arguments"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("arguments",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printEnumConstant_0_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(")");
			out.print(" ");
		}
		public void printBlock(Block element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(3);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("name"));
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("modifiers"));
			printCountingMap.put("modifiers", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("statements"));
			printCountingMap.put("statements", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("modifiers");
			if(count>0){
				ListIterator it  = ((List)element.eGet(element.eClass().getEStructuralFeature("modifiers"))).listIterator(((List)element.eGet(element.eClass().getEStructuralFeature("modifiers"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("modifiers",0);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (WhiteSpaces):
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("statements");
			if(count>0){
				ListIterator it  = ((List)element.eGet(element.eClass().getEStructuralFeature("statements"))).listIterator(((List)element.eGet(element.eClass().getEStructuralFeature("statements"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("statements",0);
			}
			//////////////DEFINITION PART BEGINS (WhiteSpaces):
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
			out.print(" ");
		}
		public void printConstructor(Constructor element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(7);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("name"));
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("parameters"));
			printCountingMap.put("parameters", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("modifiers"));
			printCountingMap.put("modifiers", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("exceptions"));
			printCountingMap.put("exceptions", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("body"));
			printCountingMap.put("body", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("typeParameters"));
			printCountingMap.put("typeParameters", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("annotations"));
			printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("annotations");
			if(count>0){
				ListIterator it  = ((List)element.eGet(element.eClass().getEStructuralFeature("annotations"))).listIterator(((List)element.eGet(element.eClass().getEStructuralFeature("annotations"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("annotations",0);
			}
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("modifiers");
			if(count>0){
				ListIterator it  = ((List)element.eGet(element.eClass().getEStructuralFeature("modifiers"))).listIterator(((List)element.eGet(element.eClass().getEStructuralFeature("modifiers"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("modifiers",0);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printConstructor_0(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("name");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("name"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				out.print(" ");
				printCountingMap.put("name",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("(");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			sWriter = new StringWriter();
			out1 = new PrintWriter(sWriter);
			printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printConstructor_1(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(")");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			sWriter = new StringWriter();
			out1 = new PrintWriter(sWriter);
			printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printConstructor_2(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("body");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("body"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("body",count-1);
			}
		}
		public void printConstructor_0_0(Constructor element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(",");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("typeParameters");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("typeParameters"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("typeParameters",count-1);
			}
		}
		public void printConstructor_1_0(Constructor element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(",");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("parameters");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("parameters"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("parameters",count-1);
			}
		}
		public void printConstructor_2(Constructor element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("throws");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("exceptions");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("exceptions"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("exceptions")),element.eClass().getEStructuralFeature("exceptions"),element));out.print(" ");
				printCountingMap.put("exceptions",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printConstructor_2_0(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		public void printConstructor_2_0(Constructor element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(",");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("exceptions");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("exceptions"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("exceptions")),element.eClass().getEStructuralFeature("exceptions"),element));out.print(" ");
				printCountingMap.put("exceptions",count-1);
			}
		}
		public void printConstructor_0(Constructor element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("<");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("typeParameters");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("typeParameters"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("typeParameters",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printConstructor_0_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(">");
			out.print(" ");
		}
		public void printConstructor_1(Constructor element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("parameters");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("parameters"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("parameters",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printConstructor_1_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
		}
		public void printMethod(Method element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(9);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("type"));
			printCountingMap.put("type", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"));
			printCountingMap.put("arrayDimensions", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("typeParameters"));
			printCountingMap.put("typeParameters", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("parameters"));
			printCountingMap.put("parameters", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("name"));
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("modifiers"));
			printCountingMap.put("modifiers", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("exceptions"));
			printCountingMap.put("exceptions", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("body"));
			printCountingMap.put("body", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("annotations"));
			printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("annotations");
			if(count>0){
				ListIterator it  = ((List)element.eGet(element.eClass().getEStructuralFeature("annotations"))).listIterator(((List)element.eGet(element.eClass().getEStructuralFeature("annotations"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("annotations",0);
			}
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("modifiers");
			if(count>0){
				ListIterator it  = ((List)element.eGet(element.eClass().getEStructuralFeature("modifiers"))).listIterator(((List)element.eGet(element.eClass().getEStructuralFeature("modifiers"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("modifiers",0);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printMethod_0(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			printMethod_1(element,localtab,out,printCountingMap);
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("name");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("name"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				out.print(" ");
				printCountingMap.put("name",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("(");
			//////////////DEFINITION PART BEGINS (WhiteSpaces):
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			sWriter = new StringWriter();
			out1 = new PrintWriter(sWriter);
			printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printMethod_2(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			//////////////DEFINITION PART BEGINS (WhiteSpaces):
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(")");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("arrayDimensions");
			if(count>0){
				ListIterator it  = ((List)element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"))).listIterator(((List)element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("arrayDimensions",0);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			sWriter = new StringWriter();
			out1 = new PrintWriter(sWriter);
			printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printMethod_3(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			printMethod_4(element,localtab,out,printCountingMap);
		}
		public void printMethod_2(Method element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("parameters");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("parameters"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("parameters",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printMethod_2_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
		}
		public void printMethod_1(Method element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("type");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("type"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("type",count-1);
			}
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("arrayDimensions");
			if(count>0){
				ListIterator it  = ((List)element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"))).listIterator(((List)element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("arrayDimensions",0);
			}
		}
		public void printMethod_0(Method element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("<");
			//////////////DEFINITION PART BEGINS (WhiteSpaces):
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("typeParameters");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("typeParameters"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("typeParameters",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printMethod_0_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (WhiteSpaces):
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(">");
			out.print(" ");
		}
		public void printMethod_2_0(Method element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(",");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("parameters");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("parameters"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("parameters",count-1);
			}
		}
		public void printMethod_3(Method element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("throws");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("exceptions");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("exceptions"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("exceptions")),element.eClass().getEStructuralFeature("exceptions"),element));out.print(" ");
				printCountingMap.put("exceptions",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printMethod_3_0(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		public void printMethod_4(Method element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("body"));
			int tempMatchCount;
			tempMatchCount=0;
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(";");
						out.print(" ");
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (Containment):
					count = printCountingMap.get("body");
					if(count>0){
						Object o =element.eGet(element.eClass().getEStructuralFeature("body"));
						doPrint((EObject)o,out,localtab);
						printCountingMap.put("body",count-1);
					}
			}
		}
		public void printMethod_3_0(Method element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(",");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("exceptions");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("exceptions"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("exceptions")),element.eClass().getEStructuralFeature("exceptions"),element));out.print(" ");
				printCountingMap.put("exceptions",count-1);
			}
		}
		public void printMethod_0_0(Method element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (WhiteSpaces):
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(",");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("typeParameters");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("typeParameters"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("typeParameters",count-1);
			}
		}
		public void printAnnotationMethod(AnnotationMethod element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(10);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("type"));
			printCountingMap.put("type", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"));
			printCountingMap.put("arrayDimensions", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("typeParameters"));
			printCountingMap.put("typeParameters", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("parameters"));
			printCountingMap.put("parameters", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("name"));
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("modifiers"));
			printCountingMap.put("modifiers", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("exceptions"));
			printCountingMap.put("exceptions", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("body"));
			printCountingMap.put("body", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("annotations"));
			printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("defaultValue"));
			printCountingMap.put("defaultValue", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("annotations");
			if(count>0){
				ListIterator it  = ((List)element.eGet(element.eClass().getEStructuralFeature("annotations"))).listIterator(((List)element.eGet(element.eClass().getEStructuralFeature("annotations"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("annotations",0);
			}
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("modifiers");
			if(count>0){
				ListIterator it  = ((List)element.eGet(element.eClass().getEStructuralFeature("modifiers"))).listIterator(((List)element.eGet(element.eClass().getEStructuralFeature("modifiers"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("modifiers",0);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printAnnotationMethod_0(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			printAnnotationMethod_1(element,localtab,out,printCountingMap);
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("name");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("name"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				out.print(" ");
				printCountingMap.put("name",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("(");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			sWriter = new StringWriter();
			out1 = new PrintWriter(sWriter);
			printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printAnnotationMethod_2(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(")");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("arrayDimensions");
			if(count>0){
				ListIterator it  = ((List)element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"))).listIterator(((List)element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("arrayDimensions",0);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			sWriter = new StringWriter();
			out1 = new PrintWriter(sWriter);
			printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printAnnotationMethod_3(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("default");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("defaultValue");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("defaultValue"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("defaultValue",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			printAnnotationMethod_4(element,localtab,out,printCountingMap);
		}
		public void printAnnotationMethod_4(AnnotationMethod element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("body"));
			int tempMatchCount;
			tempMatchCount=0;
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(";");
						out.print(" ");
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (Containment):
					count = printCountingMap.get("body");
					if(count>0){
						Object o =element.eGet(element.eClass().getEStructuralFeature("body"));
						doPrint((EObject)o,out,localtab);
						printCountingMap.put("body",count-1);
					}
			}
		}
		public void printAnnotationMethod_2(AnnotationMethod element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("parameters");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("parameters"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("parameters",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printAnnotationMethod_2_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
		}
		public void printAnnotationMethod_0(AnnotationMethod element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("<");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("typeParameters");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("typeParameters"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("typeParameters",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printAnnotationMethod_0_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(">");
			out.print(" ");
		}
		public void printAnnotationMethod_1(AnnotationMethod element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("type");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("type"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("type",count-1);
			}
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("arrayDimensions");
			if(count>0){
				ListIterator it  = ((List)element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"))).listIterator(((List)element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("arrayDimensions",0);
			}
		}
		public void printAnnotationMethod_0_0(AnnotationMethod element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(",");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("typeParameters");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("typeParameters"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("typeParameters",count-1);
			}
		}
		public void printAnnotationMethod_2_0(AnnotationMethod element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(",");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("parameters");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("parameters"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("parameters",count-1);
			}
		}
		public void printAnnotationMethod_3(AnnotationMethod element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("throws");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("exceptions");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("exceptions"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("exceptions")),element.eClass().getEStructuralFeature("exceptions"),element));out.print(" ");
				printCountingMap.put("exceptions",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printAnnotationMethod_3_0(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		public void printAnnotationMethod_3_0(AnnotationMethod element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(",");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("exceptions");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("exceptions"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("exceptions")),element.eClass().getEStructuralFeature("exceptions"),element));out.print(" ");
				printCountingMap.put("exceptions",count-1);
			}
		}
		public void printOrdinaryParameter(OrdinaryParameter element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(5);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("name"));
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("type"));
			printCountingMap.put("type", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"));
			printCountingMap.put("arrayDimensions", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("modifiers"));
			printCountingMap.put("modifiers", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("typeArguments"));
			printCountingMap.put("typeArguments", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("modifiers");
			if(count>0){
				ListIterator it  = ((List)element.eGet(element.eClass().getEStructuralFeature("modifiers"))).listIterator(((List)element.eGet(element.eClass().getEStructuralFeature("modifiers"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("modifiers",0);
			}
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("type");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("type"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("type",count-1);
			}
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("arrayDimensions");
			if(count>0){
				ListIterator it  = ((List)element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"))).listIterator(((List)element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("arrayDimensions",0);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printOrdinaryParameter_0(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("name");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("name"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				out.print(" ");
				printCountingMap.put("name",count-1);
			}
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("arrayDimensions");
			if(count>0){
				ListIterator it  = ((List)element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"))).listIterator(((List)element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("arrayDimensions",0);
			}
		}
		public void printOrdinaryParameter_0_0(OrdinaryParameter element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(",");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("typeArguments");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("typeArguments"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("typeArguments")),element.eClass().getEStructuralFeature("typeArguments"),element));out.print(" ");
				printCountingMap.put("typeArguments",count-1);
			}
		}
		public void printOrdinaryParameter_0(OrdinaryParameter element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("<");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("typeArguments");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("typeArguments"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("typeArguments")),element.eClass().getEStructuralFeature("typeArguments"),element));out.print(" ");
				printCountingMap.put("typeArguments",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printOrdinaryParameter_0_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(">");
			out.print(" ");
		}
		public void printVariableLengthParameter(VariableLengthParameter element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(5);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("name"));
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("type"));
			printCountingMap.put("type", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"));
			printCountingMap.put("arrayDimensions", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("modifiers"));
			printCountingMap.put("modifiers", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("typeArguments"));
			printCountingMap.put("typeArguments", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("modifiers");
			if(count>0){
				ListIterator it  = ((List)element.eGet(element.eClass().getEStructuralFeature("modifiers"))).listIterator(((List)element.eGet(element.eClass().getEStructuralFeature("modifiers"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("modifiers",0);
			}
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("type");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("type"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("type",count-1);
			}
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("arrayDimensions");
			if(count>0){
				ListIterator it  = ((List)element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"))).listIterator(((List)element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("arrayDimensions",0);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printVariableLengthParameter_0(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("...");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("name");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("name"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				out.print(" ");
				printCountingMap.put("name",count-1);
			}
		}
		public void printVariableLengthParameter_0_0(VariableLengthParameter element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(",");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("typeArguments");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("typeArguments"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("typeArguments")),element.eClass().getEStructuralFeature("typeArguments"),element));out.print(" ");
				printCountingMap.put("typeArguments",count-1);
			}
		}
		public void printVariableLengthParameter_0(VariableLengthParameter element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("<");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("typeArguments");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("typeArguments"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("typeArguments")),element.eClass().getEStructuralFeature("typeArguments"),element));out.print(" ");
				printCountingMap.put("typeArguments",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printVariableLengthParameter_0_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(">");
			out.print(" ");
		}
		public void printLocalVariable(LocalVariable element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(7);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("name"));
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("type"));
			printCountingMap.put("type", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"));
			printCountingMap.put("arrayDimensions", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("modifiers"));
			printCountingMap.put("modifiers", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("typeArguments"));
			printCountingMap.put("typeArguments", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("initialValue"));
			printCountingMap.put("initialValue", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("additionalLocalVariables"));
			printCountingMap.put("additionalLocalVariables", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("modifiers");
			if(count>0){
				ListIterator it  = ((List)element.eGet(element.eClass().getEStructuralFeature("modifiers"))).listIterator(((List)element.eGet(element.eClass().getEStructuralFeature("modifiers"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("modifiers",0);
			}
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("type");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("type"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("type",count-1);
			}
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("arrayDimensions");
			if(count>0){
				ListIterator it  = ((List)element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"))).listIterator(((List)element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("arrayDimensions",0);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printLocalVariable_0(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("name");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("name"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				out.print(" ");
				printCountingMap.put("name",count-1);
			}
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("arrayDimensions");
			if(count>0){
				ListIterator it  = ((List)element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"))).listIterator(((List)element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("arrayDimensions",0);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			sWriter = new StringWriter();
			out1 = new PrintWriter(sWriter);
			printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printLocalVariable_1(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				sWriter = new StringWriter();
				out1 = new PrintWriter(sWriter);
				printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printLocalVariable_2(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
		}
		public void printLocalVariable_0_0(LocalVariable element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(",");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("typeArguments");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("typeArguments"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("typeArguments")),element.eClass().getEStructuralFeature("typeArguments"),element));out.print(" ");
				printCountingMap.put("typeArguments",count-1);
			}
		}
		public void printLocalVariable_2(LocalVariable element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(",");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("additionalLocalVariables");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("additionalLocalVariables"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("additionalLocalVariables",count-1);
			}
		}
		public void printLocalVariable_0(LocalVariable element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("<");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("typeArguments");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("typeArguments"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("typeArguments")),element.eClass().getEStructuralFeature("typeArguments"),element));out.print(" ");
				printCountingMap.put("typeArguments",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printLocalVariable_0_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(">");
			out.print(" ");
		}
		public void printLocalVariable_1(LocalVariable element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("=");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("initialValue");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("initialValue"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("initialValue",count-1);
			}
		}
		public void printLocalVariableStatement(LocalVariableStatement element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("variable"));
			printCountingMap.put("variable", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("variable");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("variable"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("variable",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(";");
			out.print(" ");
		}
		public void printAdditionalLocalVariable(AdditionalLocalVariable element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(3);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("name"));
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"));
			printCountingMap.put("arrayDimensions", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("initialValue"));
			printCountingMap.put("initialValue", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("name");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("name"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				out.print(" ");
				printCountingMap.put("name",count-1);
			}
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("arrayDimensions");
			if(count>0){
				ListIterator it  = ((List)element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"))).listIterator(((List)element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("arrayDimensions",0);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printAdditionalLocalVariable_0(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		public void printAdditionalLocalVariable_0(AdditionalLocalVariable element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("=");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("initialValue");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("initialValue"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("initialValue",count-1);
			}
		}
		public void printField(Field element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(8);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("name"));
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("initialValue"));
			printCountingMap.put("initialValue", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("type"));
			printCountingMap.put("type", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"));
			printCountingMap.put("arrayDimensions", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("modifiers"));
			printCountingMap.put("modifiers", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("typeArguments"));
			printCountingMap.put("typeArguments", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("additionalFields"));
			printCountingMap.put("additionalFields", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("annotations"));
			printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("annotations");
			if(count>0){
				ListIterator it  = ((List)element.eGet(element.eClass().getEStructuralFeature("annotations"))).listIterator(((List)element.eGet(element.eClass().getEStructuralFeature("annotations"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("annotations",0);
			}
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("modifiers");
			if(count>0){
				ListIterator it  = ((List)element.eGet(element.eClass().getEStructuralFeature("modifiers"))).listIterator(((List)element.eGet(element.eClass().getEStructuralFeature("modifiers"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("modifiers",0);
			}
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("type");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("type"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("type",count-1);
			}
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("arrayDimensions");
			if(count>0){
				ListIterator it  = ((List)element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"))).listIterator(((List)element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("arrayDimensions",0);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printField_0(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("name");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("name"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				out.print(" ");
				printCountingMap.put("name",count-1);
			}
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("arrayDimensions");
			if(count>0){
				ListIterator it  = ((List)element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"))).listIterator(((List)element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("arrayDimensions",0);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			sWriter = new StringWriter();
			out1 = new PrintWriter(sWriter);
			printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printField_1(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				sWriter = new StringWriter();
				out1 = new PrintWriter(sWriter);
				printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printField_2(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
		}
		public void printField_1(Field element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("=");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("initialValue");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("initialValue"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("initialValue",count-1);
			}
		}
		public void printField_0_0(Field element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(",");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("typeArguments");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("typeArguments"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("typeArguments")),element.eClass().getEStructuralFeature("typeArguments"),element));out.print(" ");
				printCountingMap.put("typeArguments",count-1);
			}
		}
		public void printField_0(Field element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("<");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("typeArguments");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("typeArguments"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("typeArguments")),element.eClass().getEStructuralFeature("typeArguments"),element));out.print(" ");
				printCountingMap.put("typeArguments",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printField_0_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(">");
			out.print(" ");
		}
		public void printField_2(Field element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(",");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("additionalFields");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("additionalFields"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("additionalFields",count-1);
			}
		}
		public void printAdditionalField(AdditionalField element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(3);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("name"));
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"));
			printCountingMap.put("arrayDimensions", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("initialValue"));
			printCountingMap.put("initialValue", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("name");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("name"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				out.print(" ");
				printCountingMap.put("name",count-1);
			}
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("arrayDimensions");
			if(count>0){
				ListIterator it  = ((List)element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"))).listIterator(((List)element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("arrayDimensions",0);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printAdditionalField_0(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		public void printAdditionalField_0(AdditionalField element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("=");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("initialValue");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("initialValue"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("initialValue",count-1);
			}
		}
		public void printNewConstructorCall(NewConstructorCall element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(5);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("type"));
			printCountingMap.put("type", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("arguments"));
			printCountingMap.put("arguments", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("typeArguments"));
			printCountingMap.put("typeArguments", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("members"));
			printCountingMap.put("members", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("classTypeArguments"));
			printCountingMap.put("classTypeArguments", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("new");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printNewConstructorCall_0(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("type");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("type"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("type",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			sWriter = new StringWriter();
			out1 = new PrintWriter(sWriter);
			printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printNewConstructorCall_1(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("(");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			sWriter = new StringWriter();
			out1 = new PrintWriter(sWriter);
			printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printNewConstructorCall_2(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(")");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			sWriter = new StringWriter();
			out1 = new PrintWriter(sWriter);
			printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printNewConstructorCall_3(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		public void printNewConstructorCall_0_0(NewConstructorCall element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(",");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("typeArguments");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("typeArguments"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("typeArguments")),element.eClass().getEStructuralFeature("typeArguments"),element));out.print(" ");
				printCountingMap.put("typeArguments",count-1);
			}
		}
		public void printNewConstructorCall_3_0(NewConstructorCall element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("members");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("members"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("members",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printNewConstructorCall_3_0_0(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		public void printNewConstructorCall_2_0(NewConstructorCall element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(",");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("arguments");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("arguments"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("arguments",count-1);
			}
		}
		public void printNewConstructorCall_3_0_0(NewConstructorCall element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(";");
			out.print(" ");
		}
		public void printNewConstructorCall_1(NewConstructorCall element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("<");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("classTypeArguments");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("classTypeArguments"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("classTypeArguments")),element.eClass().getEStructuralFeature("classTypeArguments"),element));out.print(" ");
				printCountingMap.put("classTypeArguments",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printNewConstructorCall_1_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(">");
			out.print(" ");
		}
		public void printNewConstructorCall_0(NewConstructorCall element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("<");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("typeArguments");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("typeArguments"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("typeArguments")),element.eClass().getEStructuralFeature("typeArguments"),element));out.print(" ");
				printCountingMap.put("typeArguments",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printNewConstructorCall_0_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(">");
			out.print(" ");
		}
		public void printNewConstructorCall_2(NewConstructorCall element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("arguments");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("arguments"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("arguments",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printNewConstructorCall_2_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
		}
		public void printNewConstructorCall_3(NewConstructorCall element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printNewConstructorCall_3_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
			out.print(" ");
		}
		public void printNewConstructorCall_1_0(NewConstructorCall element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(",");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("classTypeArguments");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("classTypeArguments"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("classTypeArguments")),element.eClass().getEStructuralFeature("classTypeArguments"),element));out.print(" ");
				printCountingMap.put("classTypeArguments",count-1);
			}
		}
		public void printExplicitConstructorCall(ExplicitConstructorCall element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(4);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("type"));
			printCountingMap.put("type", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("arguments"));
			printCountingMap.put("arguments", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("typeArguments"));
			printCountingMap.put("typeArguments", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("callTarget"));
			printCountingMap.put("callTarget", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printExplicitConstructorCall_0(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("callTarget");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("callTarget"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("callTarget",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("(");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			sWriter = new StringWriter();
			out1 = new PrintWriter(sWriter);
			printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printExplicitConstructorCall_1(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(")");
			out.print(" ");
		}
		public void printExplicitConstructorCall_1(ExplicitConstructorCall element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("arguments");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("arguments"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("arguments",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printExplicitConstructorCall_1_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
		}
		public void printExplicitConstructorCall_1_0(ExplicitConstructorCall element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(",");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("arguments");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("arguments"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("arguments",count-1);
			}
		}
		public void printExplicitConstructorCall_0_0(ExplicitConstructorCall element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(",");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("typeArguments");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("typeArguments"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("typeArguments")),element.eClass().getEStructuralFeature("typeArguments"),element));out.print(" ");
				printCountingMap.put("typeArguments",count-1);
			}
		}
		public void printExplicitConstructorCall_0(ExplicitConstructorCall element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("<");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("typeArguments");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("typeArguments"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("typeArguments")),element.eClass().getEStructuralFeature("typeArguments"),element));out.print(" ");
				printCountingMap.put("typeArguments",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printExplicitConstructorCall_0_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(">");
			out.print(" ");
		}
		public void printArrayInstantiationByValues(ArrayInstantiationByValues element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(3);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("type"));
			printCountingMap.put("type", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"));
			printCountingMap.put("arrayDimensions", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("initialValues"));
			printCountingMap.put("initialValues", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("new");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("type");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("type"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("type",count-1);
			}
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("arrayDimensions");
			if(count>0){
				ListIterator it  = ((List)element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"))).listIterator(((List)element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("arrayDimensions",0);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printArrayInstantiationByValues_0(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
			out.print(" ");
		}
		public void printArrayInstantiationByValues_0_1(ArrayInstantiationByValues element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(",");
			out.print(" ");
		}
		public void printArrayInstantiationByValues_0_0(ArrayInstantiationByValues element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			printArrayInstantiationByValues_0_0_0(element,localtab,out,printCountingMap);
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("initialValues");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("initialValues"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("initialValues",count-1);
			}
		}
		public void printArrayInstantiationByValues_0(ArrayInstantiationByValues element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("initialValues");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("initialValues"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("initialValues",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printArrayInstantiationByValues_0_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printArrayInstantiationByValues_0_1(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		public void printArrayInstantiationByValues_0_0_0(ArrayInstantiationByValues element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(",");
			out.print(" ");
		}
		public void printArrayInstantiationBySize(ArrayInstantiationBySize element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(3);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("type"));
			printCountingMap.put("type", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"));
			printCountingMap.put("arrayDimensions", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("sizes"));
			printCountingMap.put("sizes", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("new");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("type");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("type"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("type",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			printArrayInstantiationBySize_0(element,localtab,out,printCountingMap);
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printArrayInstantiationBySize_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("arrayDimensions");
			if(count>0){
				ListIterator it  = ((List)element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"))).listIterator(((List)element.eGet(element.eClass().getEStructuralFeature("arrayDimensions"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("arrayDimensions",0);
			}
		}
		public void printArrayInstantiationBySize_0(ArrayInstantiationBySize element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("[");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("sizes");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("sizes"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("sizes",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("]");
			out.print(" ");
		}
		public void printReference(Reference element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(3);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("primary"));
			printCountingMap.put("primary", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("arraySelectors"));
			printCountingMap.put("arraySelectors", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("next"));
			printCountingMap.put("next", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("primary");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("primary"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("primary",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printReference_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printReference_1(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		public void printReference_0(Reference element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("[");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("arraySelectors");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("arraySelectors"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("arraySelectors",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("]");
			out.print(" ");
		}
		public void printReference_1(Reference element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (WhiteSpaces):
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(".");
			//////////////DEFINITION PART BEGINS (WhiteSpaces):
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("next");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("next"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("next",count-1);
			}
		}
		public void printTypeReferenceSequence(TypeReferenceSequence element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("parts"));
			printCountingMap.put("parts", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("parts");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("parts"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("parts",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printTypeReferenceSequence_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
		}
		public void printTypeReferenceSequence_0(TypeReferenceSequence element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (WhiteSpaces):
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(".");
			//////////////DEFINITION PART BEGINS (WhiteSpaces):
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("parts");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("parts"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("parts",count-1);
			}
		}
		public void printPackageOrClassifierReference(PackageOrClassifierReference element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("target"));
			printCountingMap.put("target", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("typeArguments"));
			printCountingMap.put("typeArguments", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("target");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("target"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("target")),element.eClass().getEStructuralFeature("target"),element));out.print(" ");
				printCountingMap.put("target",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printPackageOrClassifierReference_0(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		public void printPackageOrClassifierReference_0_0(PackageOrClassifierReference element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(",");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("typeArguments");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("typeArguments"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("typeArguments",count-1);
			}
		}
		public void printPackageOrClassifierReference_0(PackageOrClassifierReference element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("<");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("typeArguments");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("typeArguments"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("typeArguments",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printPackageOrClassifierReference_0_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(">");
			out.print(" ");
		}
		public void printPackageOrClassifierOrMethodOrVariableReference(PackageOrClassifierOrMethodOrVariableReference element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(3);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("target"));
			printCountingMap.put("target", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("typeArguments"));
			printCountingMap.put("typeArguments", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("arguments"));
			printCountingMap.put("arguments", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("target");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("target"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("target")),element.eClass().getEStructuralFeature("target"),element));out.print(" ");
				printCountingMap.put("target",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printPackageOrClassifierOrMethodOrVariableReference_0(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			sWriter = new StringWriter();
			out1 = new PrintWriter(sWriter);
			printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printPackageOrClassifierOrMethodOrVariableReference_1(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		public void printPackageOrClassifierOrMethodOrVariableReference_1_0_0(PackageOrClassifierOrMethodOrVariableReference element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(",");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("arguments");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("arguments"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("arguments",count-1);
			}
		}
		public void printPackageOrClassifierOrMethodOrVariableReference_1(PackageOrClassifierOrMethodOrVariableReference element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("(");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printPackageOrClassifierOrMethodOrVariableReference_1_0(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(")");
			out.print(" ");
		}
		public void printPackageOrClassifierOrMethodOrVariableReference_0_0(PackageOrClassifierOrMethodOrVariableReference element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(",");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("typeArguments");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("typeArguments"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("typeArguments",count-1);
			}
		}
		public void printPackageOrClassifierOrMethodOrVariableReference_0(PackageOrClassifierOrMethodOrVariableReference element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("<");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("typeArguments");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("typeArguments"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("typeArguments",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printPackageOrClassifierOrMethodOrVariableReference_0_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(">");
			out.print(" ");
		}
		public void printPackageOrClassifierOrMethodOrVariableReference_1_0(PackageOrClassifierOrMethodOrVariableReference element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("arguments");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("arguments"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("arguments",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printPackageOrClassifierOrMethodOrVariableReference_1_0_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
		}
		public void printExplicitGenericInvocation(ExplicitGenericInvocation element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(3);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("target"));
			printCountingMap.put("target", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("typeArguments"));
			printCountingMap.put("typeArguments", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("arguments"));
			printCountingMap.put("arguments", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printExplicitGenericInvocation_0(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("target");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("target"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("target")),element.eClass().getEStructuralFeature("target"),element));out.print(" ");
				printCountingMap.put("target",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			sWriter = new StringWriter();
			out1 = new PrintWriter(sWriter);
			printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printExplicitGenericInvocation_1(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		public void printExplicitGenericInvocation_1(ExplicitGenericInvocation element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("(");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printExplicitGenericInvocation_1_0(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(")");
			out.print(" ");
		}
		public void printExplicitGenericInvocation_0_0(ExplicitGenericInvocation element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(",");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("typeArguments");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("typeArguments"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("typeArguments",count-1);
			}
		}
		public void printExplicitGenericInvocation_0(ExplicitGenericInvocation element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("<");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("typeArguments");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("typeArguments"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("typeArguments",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printExplicitGenericInvocation_0_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(">");
			out.print(" ");
		}
		public void printExplicitGenericInvocation_1_0_0(ExplicitGenericInvocation element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(",");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("arguments");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("arguments"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("arguments",count-1);
			}
		}
		public void printExplicitGenericInvocation_1_0(ExplicitGenericInvocation element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("arguments");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("arguments"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("arguments",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printExplicitGenericInvocation_1_0_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
		}
		public void printQualifiedTypeArgument(QualifiedTypeArgument element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("type"));
			printCountingMap.put("type", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("type");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("type"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("type",count-1);
			}
		}
		public void printUnknownTypeArgument(UnknownTypeArgument element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("?");
			out.print(" ");
		}
		public void printExtendsTypeArgument(ExtendsTypeArgument element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("extendTypes"));
			printCountingMap.put("extendTypes", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("?");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("extends");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("extendTypes");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("extendTypes"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("extendTypes",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printExtendsTypeArgument_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
		}
		public void printExtendsTypeArgument_0(ExtendsTypeArgument element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("&");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("extendTypes");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("extendTypes"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("extendTypes",count-1);
			}
		}
		public void printSuperTypeArgument(SuperTypeArgument element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("superType"));
			printCountingMap.put("superType", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("?");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("super");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("superType");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("superType"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("superType",count-1);
			}
		}
		public void printAssert(Assert element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("expression1"));
			printCountingMap.put("expression1", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("expression2"));
			printCountingMap.put("expression2", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("assert");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("expression1");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("expression1"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("expression1",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printAssert_0(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(";");
			out.print(" ");
		}
		public void printAssert_0(Assert element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(":");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("expression2");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("expression2"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("expression2",count-1);
			}
		}
		public void printCondition(Condition element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(3);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("expression"));
			printCountingMap.put("expression", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("ifStatement"));
			printCountingMap.put("ifStatement", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("elseStatement"));
			printCountingMap.put("elseStatement", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("if");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("(");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("expression");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("expression"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("expression",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(")");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("ifStatement");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("ifStatement"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("ifStatement",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printCondition_0(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		public void printCondition_0(Condition element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("else");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("elseStatement");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("elseStatement"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("elseStatement",count-1);
			}
		}
		public void printForLoop(ForLoop element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(4);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("init"));
			printCountingMap.put("init", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("condition"));
			printCountingMap.put("condition", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("updates"));
			printCountingMap.put("updates", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("body"));
			printCountingMap.put("body", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("for");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("(");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("init");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("init"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("init",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(";");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("condition");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("condition"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("condition",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(";");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printForLoop_0(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(")");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("body");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("body"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("body",count-1);
			}
		}
		public void printForLoop_0(ForLoop element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("updates");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("updates"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("updates",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printForLoop_0_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
		}
		public void printForLoop_0_0(ForLoop element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(",");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("updates");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("updates"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("updates",count-1);
			}
		}
		public void printForEachLoop(ForEachLoop element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(3);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("next"));
			printCountingMap.put("next", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("collection"));
			printCountingMap.put("collection", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("body"));
			printCountingMap.put("body", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("for");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("(");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("next");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("next"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("next",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(":");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("collection");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("collection"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("collection",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(")");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("body");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("body"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("body",count-1);
			}
		}
		public void printWhileLoop(WhileLoop element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("condition"));
			printCountingMap.put("condition", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("body"));
			printCountingMap.put("body", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("while");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("(");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("condition");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("condition"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("condition",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(")");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("body");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("body"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("body",count-1);
			}
		}
		public void printDoWhileLoop(DoWhileLoop element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("condition"));
			printCountingMap.put("condition", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("body"));
			printCountingMap.put("body", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("do");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("body");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("body"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("body",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("while");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("(");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("condition");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("condition"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("condition",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(")");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(";");
			out.print(" ");
		}
		public void printEmptyStatement(EmptyStatement element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(";");
			out.print(" ");
		}
		public void printSynchronizedBlock(SynchronizedBlock element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("lockExpression"));
			printCountingMap.put("lockExpression", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("body"));
			printCountingMap.put("body", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("synchronized");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("(");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("lockExpression");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("lockExpression"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("lockExpression",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(")");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("body");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("body"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("body",count-1);
			}
		}
		public void printTryBlock(TryBlock element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(3);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("tryBlock"));
			printCountingMap.put("tryBlock", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("finallyBlock"));
			printCountingMap.put("finallyBlock", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("catches"));
			printCountingMap.put("catches", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("try");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("tryBlock");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("tryBlock"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("tryBlock",count-1);
			}
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("catches");
			if(count>0){
				ListIterator it  = ((List)element.eGet(element.eClass().getEStructuralFeature("catches"))).listIterator(((List)element.eGet(element.eClass().getEStructuralFeature("catches"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("catches",0);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printTryBlock_0(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		public void printTryBlock_0(TryBlock element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("finally");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("finallyBlock");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("finallyBlock"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("finallyBlock",count-1);
			}
		}
		public void printCatchClause(CatchClause element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("parameter"));
			printCountingMap.put("parameter", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("catchBlock"));
			printCountingMap.put("catchBlock", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("catch");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("(");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("parameter");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("parameter"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("parameter",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(")");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("catchBlock");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("catchBlock"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("catchBlock",count-1);
			}
		}
		public void printSwitch(Switch element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(3);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("cases"));
			printCountingMap.put("cases", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("default"));
			printCountingMap.put("default", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("variable"));
			printCountingMap.put("variable", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("switch");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("(");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("variable");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("variable"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("variable",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(")");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("cases");
			if(count>0){
				ListIterator it  = ((List)element.eGet(element.eClass().getEStructuralFeature("cases"))).listIterator(((List)element.eGet(element.eClass().getEStructuralFeature("cases"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("cases",0);
			}
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("default");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("default"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("default",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
			out.print(" ");
		}
		public void printNormalSwitchCase(NormalSwitchCase element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(3);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("condition"));
			printCountingMap.put("condition", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("body"));
			printCountingMap.put("body", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("break"));
			printCountingMap.put("break", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("case");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("condition");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("condition"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("condition",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(":");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("body");
			if(count>0){
				ListIterator it  = ((List)element.eGet(element.eClass().getEStructuralFeature("body"))).listIterator(((List)element.eGet(element.eClass().getEStructuralFeature("body"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("body",0);
			}
		}
		public void printDefaultSwitchCase(DefaultSwitchCase element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(3);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("condition"));
			printCountingMap.put("condition", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("body"));
			printCountingMap.put("body", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("break"));
			printCountingMap.put("break", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("default");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(":");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("body");
			if(count>0){
				ListIterator it  = ((List)element.eGet(element.eClass().getEStructuralFeature("body"))).listIterator(((List)element.eGet(element.eClass().getEStructuralFeature("body"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("body",0);
			}
		}
		public void printReturn(Return element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("expression"));
			printCountingMap.put("expression", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("return");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("expression");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("expression"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("expression",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(";");
			out.print(" ");
		}
		public void printThrow(Throw element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("expression"));
			printCountingMap.put("expression", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("throw");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("expression");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("expression"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("expression",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(";");
			out.print(" ");
		}
		public void printBreak(Break element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("break");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(";");
			out.print(" ");
		}
		public void printContinue(Continue element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("continue");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(";");
			out.print(" ");
		}
		public void printJumpLabel(JumpLabel element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("name"));
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("statement"));
			printCountingMap.put("statement", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("name");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("name"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				out.print(" ");
				printCountingMap.put("name",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(":");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("statement");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("statement"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("statement",count-1);
			}
		}
		public void printAssignment(Assignment element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("target"));
			printCountingMap.put("target", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("value"));
			printCountingMap.put("value", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("target");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("target"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("target",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("=");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("value");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("value"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("value",count-1);
			}
		}
		public void printExpressionStatement(ExpressionStatement element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("expression"));
			printCountingMap.put("expression", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("expression");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("expression"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("expression",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(";");
			out.print(" ");
		}
		public void printExpressionList(ExpressionList element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("expressions"));
			printCountingMap.put("expressions", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("expressions");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("expressions"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("expressions",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printExpressionList_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
		}
		public void printExpressionList_0(ExpressionList element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(",");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("expressions");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("expressions"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("expressions",count-1);
			}
		}
		public void printParExpression(ParExpression element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("expression"));
			printCountingMap.put("expression", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("(");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("expression");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("expression"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("expression",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(")");
			out.print(" ");
		}
		public void printRelationExpression(RelationExpression element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("shiftExpression"));
			printCountingMap.put("shiftExpression", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("relationOperator"));
			printCountingMap.put("relationOperator", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("shiftExpression");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("shiftExpression"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("shiftExpression",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printRelationExpression_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
		}
		public void printRelationExpression_0(RelationExpression element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("relationOperator");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("relationOperator"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("relationOperator",count-1);
			}
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("shiftExpression");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("shiftExpression"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("shiftExpression",count-1);
			}
		}
		public void printShiftExpression(ShiftExpression element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("additiveExpression"));
			printCountingMap.put("additiveExpression", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("shiftOperator"));
			printCountingMap.put("shiftOperator", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("additiveExpression");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("additiveExpression"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("additiveExpression",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printShiftExpression_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
		}
		public void printShiftExpression_0(ShiftExpression element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("shiftOperator");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("shiftOperator"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("shiftOperator",count-1);
			}
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("additiveExpression");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("additiveExpression"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("additiveExpression",count-1);
			}
		}
		public void printAdditiveExpression(AdditiveExpression element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("multiplicativeExpression"));
			printCountingMap.put("multiplicativeExpression", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("additiveOperator"));
			printCountingMap.put("additiveOperator", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("multiplicativeExpression");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("multiplicativeExpression"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("multiplicativeExpression",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printAdditiveExpression_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
		}
		public void printAdditiveExpression_0(AdditiveExpression element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("additiveOperator");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("additiveOperator"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("additiveOperator",count-1);
			}
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("multiplicativeExpression");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("multiplicativeExpression"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("multiplicativeExpression",count-1);
			}
		}
		public void printMultiplicativeExpression(MultiplicativeExpression element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("unaryExpression"));
			printCountingMap.put("unaryExpression", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("multiplicativeOperator"));
			printCountingMap.put("multiplicativeOperator", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("unaryExpression");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("unaryExpression"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("unaryExpression",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printMultiplicativeExpression_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
		}
		public void printMultiplicativeExpression_0(MultiplicativeExpression element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("multiplicativeOperator");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("multiplicativeOperator"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("multiplicativeOperator",count-1);
			}
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("unaryExpression");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("unaryExpression"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("unaryExpression",count-1);
			}
		}
		public void printUnaryExpression(UnaryExpression element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(4);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("additiveOperator"));
			printCountingMap.put("additiveOperator", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("plusplus"));
			printCountingMap.put("plusplus", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("minusminus"));
			printCountingMap.put("minusminus", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("unaryExpressionNotPlusMinus"));
			printCountingMap.put("unaryExpressionNotPlusMinus", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printUnaryExpression_0(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("unaryExpressionNotPlusMinus");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("unaryExpressionNotPlusMinus"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("unaryExpressionNotPlusMinus",count-1);
			}
		}
		public void printUnaryExpression_0(UnaryExpression element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("additiveOperator"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("plusplus"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("minusminus"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("plusplus");
						if(count>0){
							Object o =element.eGet(element.eClass().getEStructuralFeature("plusplus"));
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("plusplus",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("minusminus");
						if(count>0){
							Object o =element.eGet(element.eClass().getEStructuralFeature("minusminus"));
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("minusminus",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (Containment):
					count = printCountingMap.get("additiveOperator");
					if(count>0){
						Object o =element.eGet(element.eClass().getEStructuralFeature("additiveOperator"));
						doPrint((EObject)o,out,localtab);
						printCountingMap.put("additiveOperator",count-1);
					}
			}
		}
		public void printUnaryExpressionNotPlusMinus(UnaryExpressionNotPlusMinus element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(6);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("primary"));
			printCountingMap.put("primary", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("castExpression"));
			printCountingMap.put("castExpression", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("complement"));
			printCountingMap.put("complement", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("negate"));
			printCountingMap.put("negate", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("plusplus"));
			printCountingMap.put("plusplus", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("minusminus"));
			printCountingMap.put("minusminus", temp == null ? 0 : 1);
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("primary","complement","negate"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("castExpression"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("primary"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("castExpression");
						if(count>0){
							Object o =element.eGet(element.eClass().getEStructuralFeature("castExpression"));
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("castExpression",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("primary");
						if(count>0){
							Object o =element.eGet(element.eClass().getEStructuralFeature("primary"));
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("primary",count-1);
						}
						//////////////DEFINITION PART BEGINS (CompoundDefinition):
						StringWriter sWriter = new StringWriter();
						PrintWriter out1 = new PrintWriter(sWriter);
						HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
						printUnaryExpressionNotPlusMinus_1(element,localtab,out1,printCountingMap1);
						if(printCountingMap.equals(printCountingMap1)){
							out1.close();
						}
						else{
							out1.flush();
							out1.close();
							out.print(sWriter.toString());
							printCountingMap.putAll(printCountingMap1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CompoundDefinition):
					printUnaryExpressionNotPlusMinus_0(element,localtab,out,printCountingMap);
					//////////////DEFINITION PART BEGINS (Containment):
					count = printCountingMap.get("primary");
					if(count>0){
						Object o =element.eGet(element.eClass().getEStructuralFeature("primary"));
						doPrint((EObject)o,out,localtab);
						printCountingMap.put("primary",count-1);
					}
			}
		}
		public void printUnaryExpressionNotPlusMinus_1(UnaryExpressionNotPlusMinus element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("plusplus"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("minusminus"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("minusminus");
						if(count>0){
							Object o =element.eGet(element.eClass().getEStructuralFeature("minusminus"));
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("minusminus",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (Containment):
					count = printCountingMap.get("plusplus");
					if(count>0){
						Object o =element.eGet(element.eClass().getEStructuralFeature("plusplus"));
						doPrint((EObject)o,out,localtab);
						printCountingMap.put("plusplus",count-1);
					}
			}
		}
		public void printUnaryExpressionNotPlusMinus_0(UnaryExpressionNotPlusMinus element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("complement"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("negate"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("negate");
						if(count>0){
							Object o =element.eGet(element.eClass().getEStructuralFeature("negate"));
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("negate",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (Containment):
					count = printCountingMap.get("complement");
					if(count>0){
						Object o =element.eGet(element.eClass().getEStructuralFeature("complement"));
						doPrint((EObject)o,out,localtab);
						printCountingMap.put("complement",count-1);
					}
			}
		}
		public void printCastExpression(CastExpression element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(5);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("primitiveType"));
			printCountingMap.put("primitiveType", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("type"));
			printCountingMap.put("type", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("expression"));
			printCountingMap.put("expression", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("unaryExpression"));
			printCountingMap.put("unaryExpression", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("unaryExpressionNotPlusMinus"));
			printCountingMap.put("unaryExpressionNotPlusMinus", temp == null ? 0 : 1);
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("unaryExpression","primitiveType"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("type","unaryExpressionNotPlusMinus","expression"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("(");
						out.print(" ");
						//////////////DEFINITION PART BEGINS (CompoundDefinition):
						printCastExpression_0(element,localtab,out,printCountingMap);
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(")");
						out.print(" ");
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("unaryExpressionNotPlusMinus");
						if(count>0){
							Object o =element.eGet(element.eClass().getEStructuralFeature("unaryExpressionNotPlusMinus"));
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("unaryExpressionNotPlusMinus",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("(");
					out.print(" ");
					//////////////DEFINITION PART BEGINS (Containment):
					count = printCountingMap.get("primitiveType");
					if(count>0){
						Object o =element.eGet(element.eClass().getEStructuralFeature("primitiveType"));
						doPrint((EObject)o,out,localtab);
						printCountingMap.put("primitiveType",count-1);
					}
					//////////////DEFINITION PART BEGINS (CsString):
					out.print(")");
					out.print(" ");
					//////////////DEFINITION PART BEGINS (Containment):
					count = printCountingMap.get("unaryExpression");
					if(count>0){
						Object o =element.eGet(element.eClass().getEStructuralFeature("unaryExpression"));
						doPrint((EObject)o,out,localtab);
						printCountingMap.put("unaryExpression",count-1);
					}
			}
		}
		public void printCastExpression_0(CastExpression element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("type"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("expression"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("expression");
						if(count>0){
							Object o =element.eGet(element.eClass().getEStructuralFeature("expression"));
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("expression",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (Containment):
					count = printCountingMap.get("type");
					if(count>0){
						Object o =element.eGet(element.eClass().getEStructuralFeature("type"));
						doPrint((EObject)o,out,localtab);
						printCountingMap.put("type",count-1);
					}
			}
		}
		public void printPrimary(Primary element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(3);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("reference"));
			printCountingMap.put("reference", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("literal"));
			printCountingMap.put("literal", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("parExpression"));
			printCountingMap.put("parExpression", temp == null ? 0 : 1);
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("reference"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("literal"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("parExpression"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("literal");
						if(count>0){
							Object o =element.eGet(element.eClass().getEStructuralFeature("literal"));
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("literal",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (Containment):
						count = printCountingMap.get("parExpression");
						if(count>0){
							Object o =element.eGet(element.eClass().getEStructuralFeature("parExpression"));
							doPrint((EObject)o,out,localtab);
							printCountingMap.put("parExpression",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (Containment):
					count = printCountingMap.get("reference");
					if(count>0){
						Object o =element.eGet(element.eClass().getEStructuralFeature("reference"));
						doPrint((EObject)o,out,localtab);
						printCountingMap.put("reference",count-1);
					}
			}
		}
		public void printAdditiveOperator(AdditiveOperator element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("value"));
			printCountingMap.put("value", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (DefinedPlaceholder):
			count = printCountingMap.get("value");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("value"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("ADDITIVE_OPERATOR_LITERAL");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("value"),element));
				out.print(" ");
				printCountingMap.put("value",count-1);
			}
		}
		public void printMultiplicativeOperator(MultiplicativeOperator element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("value"));
			printCountingMap.put("value", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (DefinedPlaceholder):
			count = printCountingMap.get("value");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("value"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("MULTIPLICATIVE_OPERATOR_LITERAL");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("value"),element));
				out.print(" ");
				printCountingMap.put("value",count-1);
			}
		}
		public void printLessThan(LessThan element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("<");
			out.print(" ");
		}
		public void printLessThanOrEqual(LessThanOrEqual element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("<");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("=");
			out.print(" ");
		}
		public void printGreaterThan(GreaterThan element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(">");
			out.print(" ");
		}
		public void printGreaterThanOrEqual(GreaterThanOrEqual element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(">");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("=");
			out.print(" ");
		}
		public void printLeftShift(LeftShift element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("<");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("<");
			out.print(" ");
		}
		public void printRightShift(RightShift element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(">");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(">");
			out.print(" ");
		}
		public void printUnsignedRightShift(UnsignedRightShift element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(">");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(">");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(">");
			out.print(" ");
		}
		public void printPlusPlus(PlusPlus element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("++");
			out.print(" ");
		}
		public void printMinusMinus(MinusMinus element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("--");
			out.print(" ");
		}
		public void printComplement(Complement element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("~");
			out.print(" ");
		}
		public void printNegate(Negate element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("!");
			out.print(" ");
		}
		public void printBooleanExpression(BooleanExpression element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("left"));
			printCountingMap.put("left", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("right"));
			printCountingMap.put("right", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("left");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("left"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("left"),element));
				out.print(" ");
				printCountingMap.put("left",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			printBooleanExpression_0(element,localtab,out,printCountingMap);
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("right");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("right"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("right"),element));
				out.print(" ");
				printCountingMap.put("right",count-1);
			}
		}
		public void printBooleanExpression_0(BooleanExpression element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=0;
			int tempMatchCount;
			tempMatchCount=0;
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=0;
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			tempMatchCount=0;
			if (tempMatchCount > matches) {
				alt = 3;
				matches = tempMatchCount;
			}
			tempMatchCount=0;
			if (tempMatchCount > matches) {
				alt = 4;
				matches = tempMatchCount;
			}
			tempMatchCount=0;
			if (tempMatchCount > matches) {
				alt = 5;
				matches = tempMatchCount;
			}
			tempMatchCount=0;
			if (tempMatchCount > matches) {
				alt = 6;
				matches = tempMatchCount;
			}
			tempMatchCount=0;
			if (tempMatchCount > matches) {
				alt = 7;
				matches = tempMatchCount;
			}
			tempMatchCount=0;
			if (tempMatchCount > matches) {
				alt = 8;
				matches = tempMatchCount;
			}
			tempMatchCount=0;
			if (tempMatchCount > matches) {
				alt = 9;
				matches = tempMatchCount;
			}
			tempMatchCount=0;
			if (tempMatchCount > matches) {
				alt = 10;
				matches = tempMatchCount;
			}
			tempMatchCount=0;
			if (tempMatchCount > matches) {
				alt = 11;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("+=");
						out.print(" ");
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("-=");
						out.print(" ");
					}
				break;
				case 3:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("*=");
						out.print(" ");
					}
				break;
				case 4:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("/=");
						out.print(" ");
					}
				break;
				case 5:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("&=");
						out.print(" ");
					}
				break;
				case 6:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("|=");
						out.print(" ");
					}
				break;
				case 7:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("^=");
						out.print(" ");
					}
				break;
				case 8:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("%=");
						out.print(" ");
					}
				break;
				case 9:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("<");
						out.print(" ");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("<");
						out.print(" ");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("=");
						out.print(" ");
					}
				break;
				case 10:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(">");
						out.print(" ");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(">");
						out.print(" ");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("=");
						out.print(" ");
					}
				break;
				case 11:
					{
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(">");
						out.print(" ");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(">");
						out.print(" ");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print(">");
						out.print(" ");
						//////////////DEFINITION PART BEGINS (CsString):
						out.print("=");
						out.print(" ");
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (CsString):
					out.print("=");
					out.print(" ");
			}
		}
		public void printArrayDimension(ArrayDimension element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
			int count;
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			printArrayDimension_0(element,localtab,out,printCountingMap);
		}
		public void printArrayDimension_0(ArrayDimension element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("[");
			out.print(" ");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("]");
			out.print(" ");
		}
		public void printNullLiteral(NullLiteral element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("null");
			out.print(" ");
		}
		public void printVoidLiteral(VoidLiteral element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("void");
			out.print(" ");
		}
		public void printClassLiteral(ClassLiteral element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("class");
			out.print(" ");
		}
		public void printThis(This element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("this");
			out.print(" ");
		}
		public void printSuper(Super element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("super");
			out.print(" ");
		}
		public void printPublic(Public element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("public");
			out.print(" ");
		}
		public void printAbstract(Abstract element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("abstract");
			out.print(" ");
		}
		public void printProtected(Protected element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("protected");
			out.print(" ");
		}
		public void printPrivate(Private element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("private");
			out.print(" ");
		}
		public void printFinal(Final element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("final");
			out.print(" ");
		}
		public void printStatic(Static element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("static");
			out.print(" ");
		}
		public void printNative(Native element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("native");
			out.print(" ");
		}
		public void printSynchronized(Synchronized element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("synchronized");
			out.print(" ");
		}
		public void printTransient(Transient element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("transient");
			out.print(" ");
		}
		public void printVolatile(Volatile element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("volatile");
			out.print(" ");
		}
		public void printStrictfp(Strictfp element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("strictfp");
			out.print(" ");
		}
		public void printBoolean(Boolean element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("boolean");
			out.print(" ");
		}
		public void printChar(Char element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("char");
			out.print(" ");
		}
		public void printByte(Byte element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("byte");
			out.print(" ");
		}
		public void printShort(Short element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("short");
			out.print(" ");
		}
		public void printInt(Int element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("int");
			out.print(" ");
		}
		public void printLong(Long element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("long");
			out.print(" ");
		}
		public void printFloat(Float element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("float");
			out.print(" ");
		}
		public void printDouble(Double element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("double");
			out.print(" ");
		}
		public void printIntegerLiteral(IntegerLiteral element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("value"));
			printCountingMap.put("value", temp == null ? 0 : 1);
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("value"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("value"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("value"));
			if (tempMatchCount > matches) {
				alt = 2;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (DefinedPlaceholder):
						count = printCountingMap.get("value");
						if(count>0){
							Object o =element.eGet(element.eClass().getEStructuralFeature("value"));
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("HEX_LITERAL");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("value"),element));
				out.print(" ");
							printCountingMap.put("value",count-1);
						}
					}
				break;
				case 2:
					{
						//////////////DEFINITION PART BEGINS (DefinedPlaceholder):
						count = printCountingMap.get("value");
						if(count>0){
							Object o =element.eGet(element.eClass().getEStructuralFeature("value"));
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("OCTAL_LITERAL");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("value"),element));
				out.print(" ");
							printCountingMap.put("value",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (DefinedPlaceholder):
					count = printCountingMap.get("value");
					if(count>0){
						Object o =element.eGet(element.eClass().getEStructuralFeature("value"));
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("DECIMAL_LITERAL");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("value"),element));
				out.print(" ");
						printCountingMap.put("value",count-1);
					}
			}
		}
		public void printFloatingPointLiteral(FloatingPointLiteral element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("value"));
			printCountingMap.put("value", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (DefinedPlaceholder):
			count = printCountingMap.get("value");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("value"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("FLOATING_POINT_LITERAL");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("value"),element));
				out.print(" ");
				printCountingMap.put("value",count-1);
			}
		}
		public void printCharacterLiteral(CharacterLiteral element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("value"));
			printCountingMap.put("value", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (DefinedPlaceholder):
			count = printCountingMap.get("value");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("value"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("CHARACTER_LITERAL");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("value"),element));
				out.print(" ");
				printCountingMap.put("value",count-1);
			}
		}
		public void printStringLiteral(StringLiteral element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("value"));
			printCountingMap.put("value", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (DefinedPlaceholder):
			count = printCountingMap.get("value");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("value"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("STRING_LITERAL");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("value"),element));
				out.print(" ");
				printCountingMap.put("value",count-1);
			}
		}
		public void printBooleanLiteral(BooleanLiteral element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("value"));
			printCountingMap.put("value", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (DefinedPlaceholder):
			count = printCountingMap.get("value");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("value"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("BOOLEAN_LITERAL");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("value"),element));
				out.print(" ");
				printCountingMap.put("value",count-1);
			}
		}
		public void printSingleLineComment(SingleLineComment element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("name"));
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("content"));
			printCountingMap.put("content", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (DefinedPlaceholder):
			count = printCountingMap.get("content");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("content"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("SL_COMMENT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("content"),element));
				out.print(" ");
				printCountingMap.put("content",count-1);
			}
		}
		public void printMultiLineComment(MultiLineComment element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("name"));
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("content"));
			printCountingMap.put("content", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (DefinedPlaceholder):
			count = printCountingMap.get("content");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("content"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("ML_COMMENT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("content"),element));
				out.print(" ");
				printCountingMap.put("content",count-1);
			}
		}
		}
