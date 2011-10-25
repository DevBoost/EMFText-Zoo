/*******************************************************************************
 * Copyright (c) 2006-2011
 * Software Technology Group, Dresden University of Technology
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.java.resource.java.analysis;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.language.java.resource.java.IJavaTokenResolveResult;
import org.emftext.language.java.resource.java.IJavaTokenResolver;
import org.emftext.language.java.util.CharacterEscaper;

// TODO @mseifert: add conversion of supplementary unicode characters
// These consist of two characters (high and low surrogate).
// The high surrogate is in the range of \ud800..\udbff.
// The low surrogate is in the range of \udc00..\udfff.
// The supplementary unicode characters can not be converted
// by the InputStreamConverter, because ANTLR does not support
// them.
public class JavaSTRING_LITERALTokenResolver implements IJavaTokenResolver {

	public String deResolve(Object value, EStructuralFeature feature, EObject container) {
		String result = CharacterEscaper.escapeEscapedCharacters(value.toString());
		result = '"' + result + '"';
		return result;
	}

	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, IJavaTokenResolveResult result) {
		// remove double quotes
		assert lexem.charAt(0) == '"';
		assert lexem.charAt(lexem.length() - 1) == '"';
		lexem = lexem.substring(1, lexem.length() - 1);
		// handle escaped characters:
		// escape sequences: \b \t \n \f \r \" \' \\
		// octal characters: \0 to \377
		// unicode characters (e.g., \u0000)
		lexem = CharacterEscaper.unescapeEscapedCharacters(lexem);
		result.setResolvedToken(lexem);
	}

	public void setOptions(Map<?, ?> options) { }
}
