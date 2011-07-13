
package sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.analysis;

import static sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.analysis.helper.LiteralConstants.DOUBLE_SUFFIX;

import java.math.BigDecimal;
import java.util.Map;

import sg.edu.nus.comp.simTL.language.java.simTL4J.literals.DecimalDoubleLiteral;
import sg.edu.nus.comp.simTL.language.java.simTL4J.literals.LiteralsPackage;
import sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.ISimTL4JTokenResolveResult;

public class SimTL4JDECIMAL_DOUBLE_LITERALTokenResolver implements sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.ISimTL4JTokenResolver {
	
	private sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.analysis.SimTL4JDefaultTokenResolver defaultTokenResolver = new sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.analysis.SimTL4JDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		assert container == null || container instanceof DecimalDoubleLiteral;
		assert value instanceof Double;
		return value.toString();
	}

	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, ISimTL4JTokenResolveResult result) {
		assert feature == null || feature.getEContainingClass().equals(LiteralsPackage.eINSTANCE.getDoubleLiteral());
		
		if (lexem.toLowerCase().endsWith(DOUBLE_SUFFIX)) {
			lexem = lexem.substring(0, lexem.length() - 1);
		}
		
		parseToDouble(lexem, result);
	}


	public static void parseToDouble(String lexem, ISimTL4JTokenResolveResult result) {
		try {
			BigDecimal tempDecimal = new BigDecimal(lexem);
			Double value = tempDecimal.doubleValue();
			result.setResolvedToken(value);
		} catch (NumberFormatException nfe) {
			result.setErrorMessage(nfe.getClass().getSimpleName() + ": " + nfe.getMessage());
		}
	}
	
	public void setOptions(Map<?, ?> options) {
	}
	
}
