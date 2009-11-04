/*******************************************************************************
 * Copyright (c) 2006-2009 
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
package org.emftext.language.xml.resource.xml.analysis;

import org.emftext.language.xml.resource.xml.IXmlTokenResolveResult;
import org.emftext.language.xml.resource.xml.IXmlTokenResolver;

public class XmlPCDATATokenResolver implements IXmlTokenResolver {
	
	private XmlDefaultTokenResolver defaultTokenResolver = new XmlDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		result = ">" + result +"<";
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, IXmlTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
		result.setResolvedToken(lexem.substring(1, lexem.length()-1));
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
