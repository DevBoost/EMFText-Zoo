package org.emftext.language.primitive_types.helper;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.emftext.language.primitive_types.Primitive_typesPackage;

public class PrimitiveTypesHelper {

	public static Object getPrimitiveType(Object type) {
		if (!(type instanceof EClass)) {
			return type;
		}
		EClass typeClass = (EClass) type;
		List<EClass> superTypes = typeClass.getEAllSuperTypes();
		for (EClass superType : superTypes) {
			if (Primitive_typesPackage.eINSTANCE.getNsURI().equals(superType.getEPackage().getNsURI())) {
				return superType;
			}
		}
		return null;
	}
}
