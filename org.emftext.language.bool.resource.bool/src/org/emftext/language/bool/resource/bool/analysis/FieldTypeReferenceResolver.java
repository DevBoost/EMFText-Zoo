package org.emftext.language.bool.resource.bool.analysis;

import java.util.Collection;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.bool.BoolPackage;
import org.emftext.language.bool.FieldType;
import org.emftext.language.bool.Name;
import org.emftext.language.bool.NamedElementName;
import org.emftext.runtime.util.EObjectUtil;

public class FieldTypeReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.language.bool.Field, org.emftext.language.bool.FieldType> {
	
	public void resolve(java.lang.String identifier, org.emftext.language.bool.Field container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.emftext.language.bool.FieldType> result) {
		TreeIterator<EObject> iterator = container.eResource().getAllContents();
		Collection<FieldType> typedElements = EObjectUtil.getObjectsByType(iterator, BoolPackage.eINSTANCE.getFieldType());
		for (FieldType type : typedElements) {
			if (!(type instanceof org.emftext.language.bool.Class)) {
				continue;
			}
			org.emftext.language.bool.Class clazz = (org.emftext.language.bool.Class) type;
			NamedElementName nameRef = clazz.getName();
			if (!(nameRef instanceof Name)) {
				continue;
			}
			Name boxedName = (Name) nameRef;
			String name = boxedName.getValue();
			if (resolveFuzzy) {
				if (name.startsWith(identifier)) {
					result.addMapping(identifier, type);
					return;
				}
			} else {
				if (identifier.equals(name)) {
					result.addMapping(identifier, type);
					return;
				}
			}
		}
	}
	
	public java.lang.String deResolve(org.emftext.language.bool.FieldType element, org.emftext.language.bool.Field container, org.eclipse.emf.ecore.EReference reference) {
		assert element instanceof org.emftext.language.bool.Class;
		org.emftext.language.bool.Class clazz = (org.emftext.language.bool.Class) element;
		NamedElementName nameRef = clazz.getName();
		assert nameRef instanceof Name;
		Name boxedName = (Name) nameRef;
		return boxedName.getValue();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}
}
