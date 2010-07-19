package org.emftext.language.java.sqljava.resource.helper;

import org.emftext.language.java.references.IdentifierReference;
import org.emftext.language.java.references.ReferenceableElement;
import org.emftext.language.java.references.ReferencesFactory;
import org.emftext.language.java.references.StringReference;

public class ReferenceHelper {

	public static StringReference getNewStringReference(String value){
		
		StringReference stringReference = ReferencesFactory.eINSTANCE.createStringReference();
		stringReference.setValue(value);
		return stringReference;
	}
	
	public static IdentifierReference getNewIdentifierReference(ReferenceableElement element){
		
		IdentifierReference identifierReference = ReferencesFactory.eINSTANCE.createIdentifierReference();
		identifierReference.setTarget(element);
		return identifierReference;
	}
}
