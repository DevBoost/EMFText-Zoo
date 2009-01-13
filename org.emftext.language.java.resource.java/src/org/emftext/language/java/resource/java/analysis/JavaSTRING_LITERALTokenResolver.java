package org.emftext.language.java.resource.java.analysis;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.language.java.resource.java.analysis.helper.CharacterEscaper;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.resource.ITokenResolver;
import org.emftext.runtime.resource.impl.JavaBasedTokenResolver;

public class JavaSTRING_LITERALTokenResolver extends JavaBasedTokenResolver implements ITokenResolver{ 

	@Override
	public String deResolve(Object value, EStructuralFeature feature, EObject container) {
		String result = super.deResolve(value,feature,container);
		
		//escape escapes
		result = CharacterEscaper.escapeEscapedCharacters(result);
		
		result = '"' + result + '"';
		return result;
	}

	@Override
	public Object resolve(String lexem, EStructuralFeature feature, EObject container, ITextResource resource) {
		// remove double quotes
		assert lexem.charAt(0) == '"';
		assert lexem.charAt(lexem.length() - 1) == '"';
		lexem = lexem.substring(1, lexem.length() - 1);
		// handle escaped characters: 
		// escape sequences: \b \t \n \f \r \" \' \\
		// octal characters: \0 to \377
		// unicode characters (e.g., \u0000)
		
		//TODO @mseifert: either implement escaping (inverse of unescapeEscapedCharacters) 
		//     for deResolve or leave the below .
		lexem = CharacterEscaper.unescapeEscapedCharacters(lexem);
		
		return lexem;
	}
}
