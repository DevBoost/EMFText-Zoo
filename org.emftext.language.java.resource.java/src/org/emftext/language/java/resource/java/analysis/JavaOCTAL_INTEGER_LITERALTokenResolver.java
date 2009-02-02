package org.emftext.language.java.resource.java.analysis;

import org.emftext.language.java.literals.OctalIntegerLiteral;
import static org.emftext.language.java.resource.java.analysis.helper.LiteralConstants.OCT_PREFIX;

public class JavaOCTAL_INTEGER_LITERALTokenResolver extends org.emftext.runtime.resource.impl.JavaBasedTokenResolver implements org.emftext.runtime.resource.ITokenResolver {
	@Override
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		assert container instanceof OctalIntegerLiteral;
		assert value instanceof Integer;

		return OCT_PREFIX + Integer.toOctalString((Integer) value);
	}

	@Override
	public java.lang.Object resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container, org.emftext.runtime.resource.ITextResource resource) {
		assert container instanceof OctalIntegerLiteral;
		
		Long result = JavaDECIMAL_LONG_LITERALTokenResolver.parseToLong(lexem, 8, resource);
		return new Integer(result.intValue());
	}
}
