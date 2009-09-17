package org.emftext.access;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;

import junit.framework.TestCase;

import org.emftext.access.resource.ITextResourcePluginMetaInformation;
import org.junit.Before;
import org.junit.Test;

public class AccessTest extends TestCase {
	
	@Before
	public void setUp() {
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.c_sharp.resource.csharp.CsharpMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.custom_sandwich.resource.custom_sandwich.Custom_sandwichMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.customer.resource.customer.CustomerMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.dot.resource.dot.DotMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.ecore.resource.facade.FacadeEcoreMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.ecore.resource.text.TextEcoreMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.xml.resource.xml.XmlMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.feature.resource.feature.FeatureMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.formular.resource.formular.FormularMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.java.resource.java.JavaMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.java.javabehavior4uml.resource.javabehavior.JavabehaviorMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.java.reusejava.resource.reusejava.ReusejavaMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.java.treejava.resource.treejava.TreejavaMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.regexp.resource.regexp.RegexpMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.simple_c.resource.c.CMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.simple_gui.resource.simplegui.SimpleguiMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.simple_math.resource.sm.SmMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.statemachine.resource.statemachine.StatemachineMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.template_concepts.call.resource.template_call.Template_callMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.textadventure.resource.tas.TasMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.threevaluedlogic.resource.tvl.TvlMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.forms.resource.forms.FormsMetaInformation());
		EMFTextAccessPlugin.registerConcreteSyntax(
				new org.emftext.language.java.ejava.resource.ejava.EjavaMetaInformation());
	}
	

	@Test
	public void testAccessInterfaces() throws Exception {
		for(ITextResourcePluginMetaInformation metaInformation : EMFTextAccessPlugin.getConcreteSyntaxRegistry()) {
			invokeAllMethods(metaInformation, ITextResourcePluginMetaInformation.class);
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
