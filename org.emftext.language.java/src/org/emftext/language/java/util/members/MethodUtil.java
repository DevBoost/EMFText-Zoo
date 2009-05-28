/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.language.java.util.members;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
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

/**
 * A utility class that provides methods that belong to class 
 * Method, but can not go there, because Method is generated.
 */
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
		//TODO #763: this is not enough: we need to check for "nearest subtype" here
		return isMethodForCall(_this, methodCall, true);
	}

	private static boolean isMethodForCall(Method _this, MethodCall methodCall, boolean needsPerfectMatch) {
		EList<Type> argumentTypeList = ArgumentableUtil.getArgumentTypes(methodCall);
		EList<Parameter> parameterList = new BasicEList<Parameter>(_this.getParameters());
		
		EList<Type> parameterTypeList = new BasicEList<Type>();
		for(Parameter parameter : parameterList)  {
			//determine types before messing with the parameters
			parameterTypeList.add(
					TypeReferenceUtil.getTarget(parameter.getType(), methodCall));
		}

		if (!parameterList.isEmpty()) {
			Parameter lastParameter = parameterList.get(parameterList.size() - 1);
			Type lastParameterType  = parameterTypeList.get(parameterTypeList.size() - 1);;
			if (lastParameter instanceof VariableLengthParameter) {
				//in case of variable length add/remove some parameters
				while(parameterList.size() < argumentTypeList.size()) {
					if (needsPerfectMatch) return false;
					parameterList.add(lastParameter);
					parameterTypeList.add(lastParameterType);
				}
				if(parameterList.size() > argumentTypeList.size()) {
					if (needsPerfectMatch) return false;
					parameterList.remove(lastParameter);
					parameterTypeList.remove(parameterTypeList.size() - 1);
				}
				
			}
		}
		
		if (parameterList.size() == argumentTypeList.size()) { 
			boolean parametersMatch = true;
			for (int i = 0; i < argumentTypeList.size(); i++) {
				Parameter  parameter = parameterList.get(i);
				Expression argument = methodCall.getArguments().get(i);

				Type parameterType = parameterTypeList.get(i);
				Type argumentType  = argumentTypeList.get(i);
				
				if (argumentType == null || parameterType == null) {
					return false;
				}
				
				if (parameterType != null && argumentType != null) {
					if (!parameterType.eIsProxy() || !argumentType.eIsProxy()) {
						if (needsPerfectMatch) {
							parametersMatch = parametersMatch
								&& TypeUtil.equalsType(argumentType, ExpressionUtil.getArrayDimension(argument),
										parameterType, ArrayTypeableUtil.getArrayDimension(parameter));
						}
						else {
							parametersMatch = parametersMatch 
								&& TypeUtil.isSuperType(argumentType, ExpressionUtil.getArrayDimension(argument),
										parameterType, parameter);
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
			return parametersMatch; 
		} 
		return false;		
	}

}
