package org.emftext.language.efactory.builder;

import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.language.efactory.Attribute;
import org.emftext.language.efactory.BooleanAttribute;
import org.emftext.language.efactory.Containment;
import org.emftext.language.efactory.DateAttribute;
import org.emftext.language.efactory.DoubleAttribute;
import org.emftext.language.efactory.EnumAttribute;
import org.emftext.language.efactory.Factory;
import org.emftext.language.efactory.Feature;
import org.emftext.language.efactory.IntegerAttribute;
import org.emftext.language.efactory.NewObject;
import org.emftext.language.efactory.NullAttribute;
import org.emftext.language.efactory.Reference;
import org.emftext.language.efactory.StringAttribute;
import org.emftext.language.efactory.Value;

/**
 * A Builder can be used to obtain a model instance from the
 * EFactory model.
 */
public class Builder {

	public EObject build(Factory eFactory) {
		NewObject root = eFactory.getRoot();
		return createEObject(root);
	}

	private EObject createEObject(NewObject newObject) {
		EClass eClass = newObject.getEClass();
		EObject eObject = eClass.getEPackage().getEFactoryInstance().create(eClass);
		
		EList<Feature> features = newObject.getFeatures();
		for (Feature feature : features) {
			boolean isMany = feature.isIsMany();
			EStructuralFeature eFeature = feature.getEFeature();
			Value value = feature.getValue();
			setFeature(eObject, eFeature, value, isMany);
		}
		return eObject;
	}

	@SuppressWarnings("unchecked")
	private void setFeature(EObject object, EStructuralFeature eFeature,
			Value value, boolean isMany) {
		Object newValue = getValue(eFeature, value);
		int upperBound = eFeature.getUpperBound();
		if (upperBound > 1 || upperBound < 0) {
			Object oldValue = object.eGet(eFeature);
			if (oldValue instanceof List<?>) {
				List<Object> list = (List<Object>) oldValue;
				if (!isMany) {
					list.clear();
				}
				list.add(newValue);
			} else {
				assert false;
			}
		} else {
			object.eSet(eFeature, newValue);
		}
	}

	private Object getValue(EStructuralFeature eFeature, Value value) {
		if (value instanceof Reference) {
			Reference reference = (Reference) value;
			return reference.getValue();
		} else if (value instanceof Containment) {
			Containment containment = (Containment) value;
			return createEObject(containment.getValue());
		} else if (value instanceof Attribute) {
			return createAttributeValue(eFeature, (Attribute) value);
		} else {
			// unknown sub-type of Value
			assert false;
			return null;
		}
	}

	private Object createAttributeValue(EStructuralFeature eFeature, Attribute value) {
		if (value instanceof EnumAttribute) {
			EnumAttribute enumAttribute = (EnumAttribute) value;
			EEnumLiteral literal = enumAttribute.getValue();
			return literal;
		} else if (value instanceof StringAttribute) {
			StringAttribute stringAttribute = (StringAttribute) value;
			String string = stringAttribute.getValue();
			return string;
		} else if (value instanceof IntegerAttribute) {
			IntegerAttribute integerAttribute = (IntegerAttribute) value;
			if (eFeature.getEType().getInstanceClassName().equals(Long.class.getName())) {
				Long longValue = integerAttribute.getValue();
				return longValue;
			} else {
				Integer integerValue = (int) integerAttribute.getValue();
				return integerValue;
			}
		} else if (value instanceof DoubleAttribute) {
			DoubleAttribute doubleAttribute = (DoubleAttribute) value;
			if (eFeature.getEType().getInstanceClassName().equals(Double.class.getName())) {
				Double doubleValue = doubleAttribute.getValue();
				return doubleValue;
			} else {
				Float floatValue = (float) doubleAttribute.getValue();
				return floatValue;
			}
		} else if (value instanceof DateAttribute) {
			DateAttribute dateAttribute = (DateAttribute) value;
			Date date = dateAttribute.getValue();
			return date;
		} else if (value instanceof NullAttribute) {
			return null;
		} else if (value instanceof BooleanAttribute) {
			return Boolean.TRUE;
		} else {
			// unknown sub-type of Attribute
			assert false;
			return null;
		}
	}
}
