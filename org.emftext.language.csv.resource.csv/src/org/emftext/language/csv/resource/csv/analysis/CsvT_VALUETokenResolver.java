package org.emftext.language.csv.resource.csv.analysis;

import org.emftext.language.csv.resource.csv.ICsvTokenResolveResult;
import org.emftext.language.csv.resource.csv.ICsvTokenResolver;

public class CsvT_VALUETokenResolver implements ICsvTokenResolver {
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		assert value instanceof String;
		assert value != null;
		
		String valueAsString = (String) value;
		if (valueAsString.contains(",")) {
			// escape if the value contains a commata
			String escapedValue = valueAsString.replace("\\", "\\\\");
			escapedValue = escapedValue.replace("\"", "\\\"");
			return "\"" + escapedValue + "\"";
		} else {
			return valueAsString;
		}
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, ICsvTokenResolveResult result) {
		if (lexem.startsWith(",")) {
			lexem = lexem.substring(1);
		}
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
