package org.emftext.language.java.util.members;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.emftext.language.java.members.Method;
import org.emftext.language.java.parameters.Parameter;
import org.emftext.language.java.parameters.VariableLengthParameter;
import org.emftext.language.java.references.MethodCall;
import org.emftext.language.java.types.Type;
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
		EList<Parameter> parameters = new BasicEList<Parameter>(_this.getParameters());
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
			for (int i = 0; i < argumentTypes.size(); i++) {
				Type parameterType = TypeReferenceUtil.getTarget(parameters.get(i).getType(), methodCall);
				Type argumentType  = argumentTypes.get(i);
				if (argumentType == null) {
					return false;
				}
				
				if (parameterType != null && argumentType != null) {
					if (!parameterType.eIsProxy() || !argumentType.eIsProxy()) {
						if (needsPerfectMatch) {
							return TypeUtil.equalsType(argumentType, parameterType);
						}
						else {
							return TypeUtil.isSuperType(argumentType, parameterType);
						}
					}
					else {
						return false;
					}
				}
				else {
					return false;
				}
			}
			return true;
		}
		return false;
		
	}
	


}
