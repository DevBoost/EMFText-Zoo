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
package org.emftext.access;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;

import junit.framework.TestCase;

import org.emftext.access.resource.IMetaInformation;
import org.junit.Before;
import org.junit.Test;

public class AccessTest extends TestCase {
	
	@Before
	public void setUp() {
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.c_sharp.resource.csharp.mopp.CsharpMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.custom_sandwich.resource.custom_sandwich.mopp.Custom_sandwichMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.customer.resource.customer.mopp.CustomerMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.dot.resource.dot.mopp.DotMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.ecore.resource.facade.mopp.FacadeEcoreMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.ecore.resource.text.mopp.TextEcoreMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.xml.resource.xml.mopp.XmlMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.feature.resource.feature.mopp.FeatureMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.formular.resource.formular.mopp.FormularMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.java.resource.java.mopp.JavaMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.java.javabehavior4uml.resource.javabehavior.mopp.JavabehaviorMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.java.reusejava.resource.reusejava.mopp.ReusejavaMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.java.treejava.resource.treejava.mopp.TreejavaMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.regexp.resource.regexp.mopp.RegexpMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.simple_c.resource.c.mopp.CMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.simple_gui.resource.simplegui.mopp.SimpleguiMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.simple_math.resource.sm.mopp.SmMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.statemachine.resource.statemachine.mopp.StatemachineMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.template_concepts.call.resource.template_call.mopp.Template_callMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.textadventure.resource.tas.mopp.TasMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.threevaluedlogic.resource.tvl.mopp.TvlMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.forms.resource.forms.mopp.FormsMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.java.ejava.resource.ejava.mopp.EjavaMetaInformation());
	}
	

	@Test
	public void testAccessInterfaces() throws Exception {
		for(IMetaInformation metaInformation : EMFTextAccessPlugin.getConcreteSyntaxRegistry()) {
			invokeAllMethods(metaInformation, IMetaInformation.class);
		}
	}


	protected void invokeAllMethods(
			Object accessProxy, Class<?> accessInterface) throws Exception {
		for(Method method : accessInterface.getMethods()) {
			int argNo = method.getParameterTypes().length;
			Object[] emptyArgs = new Object [argNo];
			for(int i = 0; i < argNo; i++) {
				if (method.getParameterTypes() [i] == InputStream.class) {
					emptyArgs[i] = new ByteArrayInputStream(new byte[]{});
				}
				else if (method.getParameterTypes() [i] == String.class) {
					emptyArgs[i] = "UTF-8";
				}
				else {
					emptyArgs[i] = null;
				}
			}

			Object result = method.invoke(accessProxy, emptyArgs);
			//only an error is reported but no exception is thrown if the method is not found
			//the result will be null, but it can also be null because the impl method returns null
			//therefore, there is no assertion can be done here
							
			if (EMFTextAccessProxy.isAccessInterface(method.getReturnType())) {
				if (result != null) {
					invokeAllMethods(result, method.getReturnType());
				}
				else {
					System.err.println("WARNING: " + method + " returned null. Can not test " + method.getReturnType());
				}
			}
		}
	}

}
