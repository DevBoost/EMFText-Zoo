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
package org.emftext.language.csv.resource.csv.analysis.helper;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.language.csv.resource.csv.ICsvTokenResolveResult;
import org.emftext.language.csv.resource.csv.ICsvTokenResolver;

public abstract class VALUETokenResolver implements ICsvTokenResolver {

	public String deResolve(Object value, EStructuralFeature feature, EObject container) {
		assert value instanceof String;
		assert value != null;

		String valueAsString = (String) value;
		if (valueAsString.contains(",")) {
			// escape if the value contains a comma
			String escapedValue = valueAsString.replace("\\", "\\\\");
			escapedValue = escapedValue.replace("\"", "\\\"");
			return "\"" + escapedValue + "\"";
		} else {
			return valueAsString;
		}
	}

	public void resolve(String lexem, EStructuralFeature feature, ICsvTokenResolveResult result) {
		if (lexem.startsWith("\"")) {
			assert lexem.endsWith("\"");
			// remove quotes
			String unquotedLexem = lexem.substring(1, lexem.length() - 1);
			unquotedLexem = unquotedLexem.replace("\\\"", "\"");
			unquotedLexem = unquotedLexem.replace("\\\\", "\\");
			result.setResolvedToken(unquotedLexem);
		} else {
			result.setResolvedToken(lexem);
		}
	}

	public void setOptions(java.util.Map<?,?> options) {
		// do nothing - we don't need the options
	}
}
