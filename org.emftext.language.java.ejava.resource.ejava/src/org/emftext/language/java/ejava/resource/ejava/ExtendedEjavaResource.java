package org.emftext.language.java.ejava.resource.ejava;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.ejava.EOperationWrapper;
import org.emftext.language.java.ejava.EPackageWrapper;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.statements.FeatureStatementListContainerStatements;

/**
 * Extension of generate resource implementation that prints all operations into
 * the corresponding EAnnotation each time the model is loaded.
 */
public class ExtendedEjavaResource extends EjavaResource {
	
	public ExtendedEjavaResource(URI uri) {
		super(uri);
	}

	public void load(java.util.Map<?, ?> options) throws java.io.IOException {
		java.util.Map<java.lang.Object, java.lang.Object> loadOptions = addDefaultLoadOptions(options);
		super.load(loadOptions);
		if (!getContents().isEmpty()) {
			createBodyAnnotations((EPackageWrapper) getContents().get(0));
		}
	}
	
	private void createBodyAnnotations(EPackageWrapper ePackageWrapper) {
		EcoreUtil.resolveAll(this);
		
		if (!getErrors().isEmpty()) {
			return;
		}
		
		for(Resource r : new ArrayList<Resource>(getResourceSet().getResources())) {
			if(!r.getContents().isEmpty()) {
				if(r.getContents().get(0) instanceof EPackageWrapper) {
					setToRealJavaPackage((EPackageWrapper) r.getContents().get(0));
				}
			}
		}
		
		getResourceSet().getLoadOptions().put(
				JavaClasspath.OPTION_ALWAYS_USE_FULLY_QUALIFIED_NAMES, Boolean.TRUE);
		
		for(ConcreteClassifier concreteClassifier : ePackageWrapper.getClassifiers()) {
			for(Member member : concreteClassifier.getMembers()) {
				if (member instanceof EOperationWrapper) {
					EOperationWrapper wrapper = (EOperationWrapper) member;
					if (!wrapper.getStatements().isEmpty()) {
						EOperation eOperation = wrapper.getEOperation();
						EAnnotation genModelAnnotation = eOperation.getEAnnotation(GenModelPackage.eNS_URI);
						if (genModelAnnotation == null) {
							genModelAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();	
							eOperation.getEAnnotations().add(genModelAnnotation);
						}
						genModelAnnotation.setSource(GenModelPackage.eNS_URI);
						genModelAnnotation.getDetails().put("body", printBody(wrapper));
						String documentation = "";
						for(String s : wrapper.getComments()) {
							s = s.trim();
							if (s.startsWith("/**") && s.endsWith("*/")) {
								s = s.substring(3, s.length() - 1);
								s = s.replaceAll("\n.*\\*", "\n");
								documentation += s;
							}
							
						}
						genModelAnnotation.getDetails().put("documentation", documentation);
					}
				}
			}
		}

		Resource ecoreResource = ePackageWrapper.getEPackage().eResource();
		try {
			ecoreResource.save(ecoreResource.getResourceSet().getLoadOptions());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private void setToRealJavaPackage(EPackageWrapper wrapper) {
		// the only way to find the base package is to go to the genmodel
		wrapper.getNamespaces().clear();
		wrapper.getNamespaces().addAll(
				Arrays.asList(wrapper.getGenPackage().getBasePackage().split("\\.")));
		wrapper.getNamespaces().add(wrapper.getEPackage().getName());

	}
	
	private String printBody(EOperationWrapper wrapper) {
		byte[] lineBreak = System.getProperty ("line.separator").getBytes();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		EjavaPrinter printer = new PlainJavaEjavaPrinter(outputStream, this);
		for(FeatureStatementListContainerStatements statement : wrapper.getStatements()) {
			printer.print(statement);
			try {
				printer.outputStream.write(lineBreak);
			} catch (IOException e) {}
		}
		return outputStream.toString();
	}
}