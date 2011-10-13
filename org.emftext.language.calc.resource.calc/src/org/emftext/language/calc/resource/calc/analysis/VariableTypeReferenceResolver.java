/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.calc.resource.calc.analysis;

import java.util.Map;

import org.eclipse.emf.ecore.EReference;
import org.emftext.language.calc.CalcFactory;
import org.emftext.language.calc.Type;
import org.emftext.language.calc.Variable;
import org.emftext.language.calc.resource.calc.ICalcReferenceResolveResult;
import org.emftext.language.calc.resource.calc.ICalcReferenceResolver;

public class VariableTypeReferenceResolver implements ICalcReferenceResolver<Variable, Type> {
	
	private static final Type DOUBLE = CalcFactory.eINSTANCE.createType();
	private static final Type STRING = CalcFactory.eINSTANCE.createType();
	{
		DOUBLE.setName("double");
		STRING.setName("string");
	}
	
	private final static Type[] BUILT_IN_TYPES = new Type[] {
		DOUBLE, STRING
	};
	
	public void resolve(String identifier, Variable container, EReference reference, int position, boolean resolveFuzzy, final ICalcReferenceResolveResult<Type> result) {
		for (Type type : BUILT_IN_TYPES) {
			String name = type.getName();
			if (name.equals(identifier) || resolveFuzzy) {
				result.addMapping(name, type);
				if (!resolveFuzzy) {
					return;
				}
			}
		}
	}
	
	public String deResolve(Type element, Variable container, EReference reference) {
		return element.getName();
	}
	
	public void setOptions(Map<?,?> options) {
		// not needed
	}
}
