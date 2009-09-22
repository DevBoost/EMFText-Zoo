package org.emftext.language.quickuml.resource.quml.analysis;

import java.util.Map;

import org.emftext.language.quickuml.resource.quml.IQumlTokenResolveResult;
import org.emftext.language.quickuml.resource.quml.IQumlTokenResolver;

public class QumlTEXTTokenResolver implements IQumlTokenResolver {
	
	private QumlDefaultTokenResolver defaultResolver = new QumlDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, IQumlTokenResolveResult result) {
		defaultResolver.resolve(lexem, feature, result);
	}

	public void setOptions(Map<?, ?> options) {
	}
}
