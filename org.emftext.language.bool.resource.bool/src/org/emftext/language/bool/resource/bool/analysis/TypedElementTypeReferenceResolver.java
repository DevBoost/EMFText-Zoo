package org.emftext.language.bool.resource.bool.analysis;

import java.util.Collection;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.bool.BoolPackage;
import org.emftext.language.bool.Name;
import org.emftext.language.bool.NamedElementName;
import org.emftext.language.bool.TypedElementType;
import org.emftext.runtime.util.EObjectUtil;

public class TypedElementTypeReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.language.bool.TypedElement, org.emftext.language.bool.TypedElementType> {
	
	public void resolve(java.lang.String identifier, org.emftext.language.bool.TypedElement container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.emftext.language.bool.TypedElementType> result) {
		TreeIterator<EObject> iterator = container.eResource().getAllContents();
		Collection<TypedElementType> typedElements = EObjectUtil.getObjectsByType(iterator, BoolPackage.eINSTANCE.getTypedElementType());
		for (TypedElementType type : typedElements) {
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
	
	public java.lang.String deResolve(org.emftext.language.bool.TypedElementType element, org.emftext.language.bool.TypedElement container, org.eclipse.emf.ecore.EReference reference) {
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
