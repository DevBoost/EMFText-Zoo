/*******************************************************************************
 * Copyright (c) 2006-2010 
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

import static org.emftext.language.java.resource.java.analysis.helper.LiteralConstants.FLOAT_SUFFIX;

import java.math.BigDecimal;
import java.util.Map;

import org.emftext.language.java.literals.DecimalFloatLiteral;
import org.emftext.language.java.literals.LiteralsPackage;
import org.emftext.language.java.resource.java.IJavaTokenResolveResult;
import org.emftext.language.java.resource.java.IJavaTokenResolver;

public class JavaDECIMAL_FLOAT_LITERALTokenResolver implements IJavaTokenResolver {
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		assert container == null || container instanceof DecimalFloatLiteral;
		assert value instanceof Float;
		return value.toString() + FLOAT_SUFFIX;
	}

	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, IJavaTokenResolveResult result) {
		assert feature == null || feature.getEContainingClass().equals(LiteralsPackage.eINSTANCE.getFloatLiteral());
		assert lexem.toLowerCase().endsWith(FLOAT_SUFFIX);

		lexem = lexem.substring(0, lexem.length() - 1);
		parseToFloat(lexem, result);
	}

	public static void parseToFloat(String lexem, IJavaTokenResolveResult result) {
		try {
			BigDecimal tempDecimal = new BigDecimal(lexem);
			Float value = tempDecimal.floatValue();
			result.setResolvedToken(value);
		} catch (NumberFormatException nfe) {
			result.setErrorMessage(nfe.getClass().getSimpleName() + ": " + nfe.getMessage());
		}
	}

	public void setOptions(Map<?, ?> options) {
	}
}
