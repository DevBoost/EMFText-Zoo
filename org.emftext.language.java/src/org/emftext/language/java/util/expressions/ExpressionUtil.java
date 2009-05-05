package org.emftext.language.java.util.expressions;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.java.arrays.ArrayInstantiationBySize;
import org.emftext.language.java.arrays.ArrayTypeable;
import org.emftext.language.java.classifiers.Class;
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
import org.emftext.language.java.literals.Literal;
import org.emftext.language.java.members.AdditionalField;
import org.emftext.language.java.members.Field;
import org.emftext.language.java.references.ElementReference;
import org.emftext.language.java.references.Reference;
import org.emftext.language.java.types.Type;
import org.emftext.language.java.util.JavaClasspathUtil;
import org.emftext.language.java.util.arrays.ArrayTypeableUtil;
import org.emftext.language.java.util.literals.LiteralUtil;
import org.emftext.language.java.util.references.ReferenceUtil;
import org.emftext.language.java.util.types.TypeReferenceUtil;
import org.emftext.language.java.variables.AdditionalLocalVariable;
import org.emftext.language.java.variables.LocalVariable;

public class ExpressionUtil {
	

	/**
	 * Returns the type of the expression considering all concrete
	 * subtypes of Expression.
	 * 
	 * @param _this
	 * @return type of expression
	 */
	public static Type getType(Expression _this) {
		return getType(_this, false);
	}
	
	public static Type getAlternativeType(Expression _this) {
		return getType(_this, true);
	}
	
	
	private static Type getType(Expression _this, boolean alternative) {
		Class stringClass = JavaClasspathUtil.getStringClass(_this);
		
		Type type = null;

		if (_this instanceof Reference) {
			Reference reference = (Reference) _this;
			//navigate down references
			while(reference.getNext() != null) {
				reference = reference.getNext();
			}
			type = ReferenceUtil.getType(reference);
		}
		else if (_this instanceof Literal) {
			type = LiteralUtil.getType(
					((Literal) _this));
		}
		else if (_this instanceof CastExpression) {
			type = TypeReferenceUtil.getTarget(
					((CastExpression)_this).getType());
		}
		else if (_this instanceof AssignmentExpression) {
			type = ExpressionUtil.getType(((AssignmentExpression) _this).getChild(), alternative);
		}
		else if (_this instanceof ConditionalExpression &&
				((ConditionalExpression)_this).getExpressionIf() != null) {
			if (alternative) {
				type = ExpressionUtil.getType(((ConditionalExpression)_this).getExpressionIf(), alternative);
			}
			else {
				type = ExpressionUtil.getType(((ConditionalExpression)_this).getExpressionElse(), alternative);
			}
			
		}
		else if (_this instanceof EqualityExpression ||
				_this instanceof RelationExpression ||
				_this instanceof ConditionalOrExpression ||
				_this instanceof ConditionalAndExpression ||
				_this instanceof InstanceOfExpression ) {
			type = JavaClasspathUtil.getClass("Boolean", _this);
		}
		else if (_this instanceof AdditiveExpression ||
				_this instanceof MultiplicativeExpression ||
				_this instanceof InclusiveOrExpression ||
				_this instanceof ExclusiveOrExpression ||
				_this instanceof AndExpression ||
				_this instanceof ShiftExpression ) {
			
			if (_this instanceof AdditiveExpression) {
				AdditiveExpression additiveExpression = (AdditiveExpression) _this;
				for(Expression subExp : additiveExpression.getChildren()) {
					if (stringClass.equals(ExpressionUtil.getType(subExp, alternative))) {
						//special case: string concatenation
						return stringClass;
					}
				}
			}
			
			@SuppressWarnings("unchecked")
			Expression subExp = ((EList<Expression>) 
					_this.eGet(_this.eClass().getEStructuralFeature("children"))).get(0);
			
			return ExpressionUtil.getType(subExp, alternative);
		}
		else for(TreeIterator<EObject> i = _this.eAllContents(); i.hasNext(); ) {
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
					nextType = LiteralUtil.getType(
							((Literal) next));
				}
				else if (next instanceof CastExpression) {
					nextType = TypeReferenceUtil.getTarget(
							((CastExpression)next).getType(), null);
				}
				else {
					nextType = ReferenceUtil.getType(
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
	
	public static int getArrayDimension(Expression _this) {
		int size = 0;
		ArrayTypeable arrayType = null;
		if (_this instanceof NestedExpression && 
				((NestedExpression)_this).getNext() == null) {
			return getArrayDimension(((NestedExpression) _this).getExpression())
				- ((NestedExpression)_this).getArraySelectors().size();
		}
		if (_this instanceof ConditionalExpression &&
				((ConditionalExpression)_this).getExpressionIf() != null) {		
			return getArrayDimension(((ConditionalExpression)_this).getExpressionIf());
		}
		if (_this instanceof AssignmentExpression) {
			return getArrayDimension(((AssignmentExpression) _this).getValue());
		}
		if (_this instanceof InstanceOfExpression) {
			return 0;
		}
		if (_this instanceof Reference) {
			Reference reference = (Reference) _this;
			while (reference.getNext() != null) {
				reference = reference.getNext();
			}
			if (reference instanceof ElementReference) {
				ElementReference elementReference = (ElementReference) reference;
				if (elementReference.getTarget() instanceof ArrayTypeable) {
					arrayType = (ArrayTypeable) elementReference.getTarget();
				}
				if (elementReference.getTarget() instanceof AdditionalLocalVariable) {
					AdditionalLocalVariable additionalLocalVariable = (AdditionalLocalVariable) elementReference.getTarget();
					arrayType = (LocalVariable) additionalLocalVariable.eContainer();
					size += additionalLocalVariable.getArrayDimensionsAfter().size();
					size -= arrayType.getArrayDimensionsAfter().size();
				}
				if (elementReference.getTarget() instanceof AdditionalField) {
					AdditionalField additionalField = (AdditionalField) elementReference.getTarget();
					arrayType = (Field) additionalField.eContainer();
					size += additionalField.getArrayDimensionsAfter().size();
					size -= arrayType.getArrayDimensionsAfter().size();
				}
			}
			else if (_this instanceof ArrayTypeable) {
				arrayType = (ArrayTypeable) _this;
			}
			size -= reference.getArraySelectors().size();
		}
		else if (_this instanceof ArrayTypeable) {
			arrayType = (ArrayTypeable) _this;
		}
		
		if(_this instanceof ArrayInstantiationBySize) {
			size += ((ArrayInstantiationBySize)_this).getSizes().size();
		}
		
		size += ArrayTypeableUtil.getArrayDimension(arrayType);
		return size;
	}

}
