package org.emftext.language.java.ejava.resource.ejava;

import java.io.OutputStream;

import org.emftext.language.java.ejava.EClassifierWrapper;
import org.emftext.language.java.ejava.EPackageWrapper;
import org.emftext.language.java.types.Type;
import org.emftext.language.java.types.TypeReference;
import org.emftext.language.java.util.types.TypeReferenceUtil;
import org.emftext.runtime.resource.ITextResource;

/**
 * A printer that prints EJava specific elements to corresponding
 * Java code by using information from the GenModel.
 *
 */
public class PlainJavaEjavaPrinter extends EjavaPrinter {

	public PlainJavaEjavaPrinter(OutputStream o, ITextResource resource) {
		super(o, resource);
	}
	
	public void print_org_emftext_language_java_ejava_EObjectInstantiation(org.emftext.language.java.ejava.EObjectInstantiation element, java.lang.String outertab, java.io.PrintWriter out) {
		TypeReference typeReference = element.getType();
		Type type = TypeReferenceUtil.getTarget(typeReference);
		
		if(!(type instanceof EClassifierWrapper)) {
			out.print("/* Can only instantiate EObjects */");
			return;
		}
		
		EClassifierWrapper classifierWrapper = (EClassifierWrapper) type;
		EPackageWrapper packageWrapper = (EPackageWrapper) classifierWrapper.eContainer();
		
		out.print(packageWrapper.getGenPackage().getBasePackage());
		out.print(".");
		out.print(packageWrapper.getEPackage().getName());
		out.print(".");
		out.print(packageWrapper.getGenPackage().getFactoryName());
		out.print(".eINSTANCE.create");
		out.print(classifierWrapper.getEClassifier().getName());
		out.print("()");
	}

}
