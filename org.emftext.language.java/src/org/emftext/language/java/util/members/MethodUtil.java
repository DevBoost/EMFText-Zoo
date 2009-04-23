package org.emftext.language.java.util.members;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.arrays.ArrayTypable;
import org.emftext.language.java.arrays.ArraysFactory;
import org.emftext.language.java.expressions.Expression;
import org.emftext.language.java.members.Method;
import org.emftext.language.java.parameters.Parameter;
import org.emftext.language.java.parameters.VariableLengthParameter;
import org.emftext.language.java.references.MethodCall;
import org.emftext.language.java.types.Type;
import org.emftext.language.java.util.arrays.ArrayTypeableUtil;
import org.emftext.language.java.util.expressions.ExpressionUtil;
import org.emftext.language.java.util.references.ArgumentableUtil;
import org.emftext.language.java.util.types.TypeReferenceUtil;
import org.emftext.language.java.util.types.TypeUtil;

public class MethodUtil {
	
	/**
	 * Decides if the given method matches the given call. 
	 * 
	 * @param _this
	 * @param methodCall
	 * @param reference
	 * @return
	 */
	public static boolean isMethodForCall(Method _this, MethodCall methodCall) {
		return isMethodForCall(_this, methodCall, false);
	}

	/**
	 * Only returns true if the given Method is a better match for the given calls than the
	 * otherMethod given.
	 * 
	 * @param _this
	 * @param otherMetho
	 * @param methodCall
	 * @param reference
	 * @return
	 */
	public static boolean isMethodForCall(Method _this, Method otherMethod, MethodCall methodCall) {
		if (!isMethodForCall(_this, methodCall, false)) {
			return false;
		}
		if (isMethodForCall(otherMethod, methodCall, true)) {
			//the other already matches perfectly; I am not better
			return false;
		}
		if (!isMethodForCall(otherMethod, methodCall, false)) {
			//I match, but the other does not
			return true;
		}
		//we both match, I am only better if I match perfectly <- 
		//TODO @jjohannes this is not enough: we need to check for "nearest subtype" here		
		return isMethodForCall(_this, methodCall, true);
	}

	private static boolean isMethodForCall(Method _this, MethodCall methodCall, boolean needsPerfectMatch) {
		EList<Type> argumentTypes = ArgumentableUtil.getArgumentTypes(methodCall);
		EList<Parameter> parameterList = new BasicEList<Parameter>(_this.getParameters());

		if (!parameterList.isEmpty()) {
			Parameter lastParameter = parameterList.get(parameterList.size() - 1);
			if (lastParameter instanceof VariableLengthParameter) {
				Expression lastArgument = null;
				if (!methodCall.getArguments().isEmpty()) {
					lastArgument = methodCall.getArguments().get(methodCall.getArguments().size() - 1);
				}

				if (parameterList.size() == argumentTypes.size() && 
						ExpressionUtil.getArrayDimension(lastArgument) == 1) {
					//in case the last argument is an array, the VariableLengthParameter needs to be handled as array		
					parameterList.remove(lastParameter);
					Parameter arrayTypedParameter = (Parameter) EcoreUtil.copy(lastParameter);
					arrayTypedParameter.getArrayDimensionsAfter().add(ArraysFactory.eINSTANCE.createArrayDimension());
					parameterList.add(arrayTypedParameter);
				}
				else {
					//in case of variable length add/remove some parameters
					while(parameterList.size() < argumentTypes.size()) {
						parameterList.add(lastParameter);
					}
					if(parameterList.size() > argumentTypes.size()) {
						parameterList.remove(lastParameter);
					}
				}
			}
		}
		
		if (parameterList.size() == argumentTypes.size()) { 
			for (int i = 0; i < argumentTypes.size(); i++) {
				Parameter  parameter = parameterList.get(i);
				Expression argument = methodCall.getArguments().get(i);

				Type parameterType = TypeReferenceUtil.getTarget(parameter.getType(), methodCall);
				Type argumentType  = argumentTypes.get(i);
				
				if (argumentType == null || parameterType == null) {
					return false;
				}
				
				boolean parametersMatch = true;
				if (parameterType != null && argumentType != null) {
					if (!parameterType.eIsProxy() || !argumentType.eIsProxy()) {
						if (needsPerfectMatch) {
							parametersMatch = parametersMatch
								&& ArrayTypeableUtil.getArrayDimension(parameter) == ExpressionUtil.getArrayDimension(argument)
								&& TypeUtil.equalsType(argumentType, parameterType);
						}
						else {
							parametersMatch = parametersMatch 
								&& ArrayTypeableUtil.getArrayDimension(parameter) == ExpressionUtil.getArrayDimension(argument)
								&& TypeUtil.isSuperType(argumentType, parameterType);
						}
					}
					else {
						return false;
					}
				}
				else {
					return false;
				}
				return parametersMatch; 
			}
			return true;
		} 
		return false;
		
	}

}
