package org.emftext.language.java.resource.java.analysis;

import org.emftext.language.java.literals.LiteralsPackage;
import org.emftext.language.java.literals.OctalIntegerLiteral;
import static org.emftext.language.java.resource.java.analysis.helper.LiteralConstants.OCT_PREFIX;

public class JavaOCTAL_INTEGER_LITERALTokenResolver extends org.emftext.runtime.resource.impl.JavaBasedTokenResolver implements org.emftext.runtime.resource.ITokenResolver {
	@Override
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		assert container == null || container instanceof OctalIntegerLiteral;
		assert value instanceof Long;

		return OCT_PREFIX + Long.toOctalString((Long) value);
	}

	@Override
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.runtime.resource.ITokenResolveResult result) {
		assert feature == null || feature.getEContainingClass().equals(LiteralsPackage.eINSTANCE.getIntegerLiteral());
		
		JavaDECIMAL_LONG_LITERALTokenResolver.parseToLong(lexem, 8, result);
	}
}
