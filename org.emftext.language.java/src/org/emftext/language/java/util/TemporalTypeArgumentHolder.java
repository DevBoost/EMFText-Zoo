package org.emftext.language.java.util;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.common.util.EList;
import org.emftext.language.java.generics.TypeArgument;


/**
 * This adapter is used to attach type arguments to a type when it is passed through
 * several getBoundType() calls recursively. A better solution might be
 * to pass type references along whenever possible. 
 * <p>
 * This however will require major changes in the API.
 */
public class TemporalTypeArgumentHolder extends AdapterImpl {
	private EList<TypeArgument> typeArguments = new UniqueEList<TypeArgument>();
	
	public EList<TypeArgument> getTypeArguments() {
		return typeArguments;
	}
}
