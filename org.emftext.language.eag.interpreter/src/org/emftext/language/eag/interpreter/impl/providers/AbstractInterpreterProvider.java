package org.emftext.language.eag.interpreter.impl.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.emftext.language.eag.interpreter.IOperationProvider;
import org.emftext.language.eag.interpreter.ITypeConverter;
import org.emftext.language.eag.interpreter.impl.references.IReference;
import org.emftext.language.eag.interpreter.impl.references.ReferenceFactory;
import org.emftext.language.eag.interpreter.numbers.NumberConverter;

public abstract class AbstractInterpreterProvider {

	public ITypeConverter[] typeConverters = new ITypeConverter[] {
		new NumberConverter()
	};
	
	public <OperatorType> IReference interpretWithConversion(Collection<IOperationProvider<OperatorType>> providers,
			OperatorType operator, Object left, Object right) {
		IReference result = interpretInternal(providers, operator, left, right);
		if (result != null) {
			return result;
		}
		// no operation found, try converting types
		List<Object> leftConversions = findConversions(left);
		List<Object> rightConversions = findConversions(right);
		for (Object leftConverted : leftConversions) {
			for (Object rightConverted : rightConversions) {
				result = interpretInternal(providers, operator, leftConverted, rightConverted);
				if (result != null) {
					return result;
				}
			}
		}
		throw new RuntimeException("Can't find provider to handle binary expression " + operator + " on " + left + ", " + right);
	}
	
	public <OperatorType> IReference interpretInternal(Collection<IOperationProvider<OperatorType>> providers, OperatorType operator, Object left,
			Object right) {
		log("interpretInternal(" + left + ", " + right + ")");
		for (IOperationProvider<OperatorType> nextProvider : providers) {
			if (nextProvider.canHandle(operator, left.getClass(), right.getClass())) {
				Object result = nextProvider.interpret(operator, left, right);
				if (result != null) {
					return ReferenceFactory.INSTANCE.createReference(result);
				}
			}
		}
		return null;
	}

	public List<Object> findConversions(Object object) {
		List<Object> conversions = new ArrayList<Object>();
		for (ITypeConverter typeConverter : typeConverters) {
			Class<?>[] availableConversions = typeConverter.getAvailableConversions(object.getClass());
			if (availableConversions != null) {
				for (Class<?> targetType : availableConversions) {
					Object converted = typeConverter.convertTo(object, targetType);
					conversions.add(converted);
				}
			}
		}
		return conversions;
	}

	protected void log(String string) {
	}
}
