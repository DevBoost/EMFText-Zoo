package org.emftext.language.java.resource.java.analysis;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.language.java.resource.java.analysis.helper.CharacterEscaper;
import org.emftext.runtime.resource.ITokenResolver;
import org.emftext.runtime.resource.impl.JavaBasedTokenResolver;

public class JavaCHARACTER_LITERALTokenResolver extends JavaBasedTokenResolver implements ITokenResolver{ 
	@Override
	public String deResolve(Object value, EStructuralFeature feature, EObject container) {
		String result = super.deResolve(value,feature,container);
		result = CharacterEscaper.escapeEscapedCharacters(result);
		result = '\'' + result + '\'';
		return result;
	}

	@Override
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.runtime.resource.ITokenResolveResult result) {
		assert lexem.length() == 3;
		// remove single quotes
		assert lexem.charAt(0) == '\'';
		assert lexem.charAt(lexem.length() - 1) == '\'';
		lexem = lexem.substring(1, lexem.length() - 1);
		Character character = Character.valueOf(lexem.charAt(0));
		result.setResolvedToken(character);
	}
}
