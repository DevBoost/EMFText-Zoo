/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.devboost.stanford.analysis.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.devboost.stanford.language.Dconj;
import org.devboost.stanford.language.Dependency;
import org.devboost.stanford.language.Dnsubjpass;
import org.devboost.stanford.language.Document;
import org.devboost.stanford.language.Dprep;
import org.devboost.stanford.language.LanguagePackage;
import org.devboost.stanford.language.NNPS;
import org.devboost.stanford.language.NNS;
import org.devboost.stanford.language.Sentence;
import org.devboost.stanford.language.Word;
import org.devboost.stanford.language.resource.txt.mopp.TxtResourceFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.ecore.resource.text.mopp.TextEcoreResourceFactory;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author jreimann
 *
 */
public class AnalysisPassiveConceptsTest {

	private static final String INPUT_TEXT_FILE		= "input/roleModel.txt";
	private static final String OUTPUT_TEXT_FILE	= "output/metamodel.text.ecore";
	private static List<String> CHILD_TERMS;
	private static List<String> PARENT_PREPOSITION_TERMS;
	private static List<String> ENUMERATION_TERMS;
	
	private static Resource resource;
	private static Resource outputResource;
	private static Document document;
	private static EPackage ePackage;
	
	@BeforeClass
	public static void init(){
		initAnalysisTerms();
		initRegistry();
		// input
		File input = new File(INPUT_TEXT_FILE);
		assertTrue("file must exist", input.exists());
		ResourceSet rs = new ResourceSetImpl();
		URI uri = URI.createFileURI(input.getAbsolutePath());
		resource = rs.getResource(uri, true);
		assertNotNull("resource must not be null", resource);
		document = (Document) resource.getContents().get(0);
		assertNotNull("document must not be null", document);
		// output
		File output = new File(OUTPUT_TEXT_FILE);
		if(output.exists()){
			output.delete();
		}
		assertFalse(OUTPUT_TEXT_FILE + "must not exist", output.exists());
		uri = URI.createFileURI(output.getAbsolutePath());
		outputResource = rs.createResource(uri);
		assertNotNull("output resource must not be null", outputResource);
	}

	private static void initAnalysisTerms() {
		initChildTerms();
		initParentPrepositionTerms();
		initEnumerationTerms();
	}

	private static void initEnumerationTerms() {
		ENUMERATION_TERMS = new ArrayList<String>();
		ENUMERATION_TERMS.add("marked");
		ENUMERATION_TERMS.add("annotated");
	}

	private static void initParentPrepositionTerms() {
		PARENT_PREPOSITION_TERMS = new ArrayList<String>();
		PARENT_PREPOSITION_TERMS.add("in");
	}

	private static void initChildTerms() {
		CHILD_TERMS = new ArrayList<String>();
		CHILD_TERMS.add("contained");
		CHILD_TERMS.add("contains");
		CHILD_TERMS.add("contain");
	}

	private static void initRegistry() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("txt", new TxtResourceFactory());
		EPackage.Registry.INSTANCE.put(LanguagePackage.eNS_URI, LanguagePackage.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new TextEcoreResourceFactory());
	}
	
	@Test
	public void analysisTest(){
		List<Sentence> sentences = document.getSentences();
		for (Sentence sentence : sentences) {
			analyseSentence(sentence);
		}
		outputResource.getContents().add(ePackage);
		try {
			outputResource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void analyseSentence(Sentence sentence) {
		List<Dependency> dependencies = sentence.getDependencies();
		Map<String, EClassifier> metamodel = new HashMap<String, EClassifier>();
		for (Dependency dependency : dependencies) {
			Word governor = dependency.getGovernor();
			Word dependent = dependency.getDependent();
			if(dependency instanceof Dnsubjpass){
				if(CHILD_TERMS.contains(governor.getText())){
					createCompositeStructure(metamodel, governor, dependent);
				} else if(ENUMERATION_TERMS.contains(governor.getText())){
					createEnumeration(metamodel, governor, dependent);
				}
			}
		}
		if(ePackage == null){
			ePackage = EcoreFactory.eINSTANCE.createEPackage();
			ePackage.setName("test");
			ePackage.setNsPrefix("test");
			ePackage.setNsURI("http://test.org");
		}
		for (EClassifier classifier : metamodel.values()) {
			ePackage.getEClassifiers().add(classifier);
		}
	}

	private void createEnumeration(Map<String, EClassifier> metamodel, Word governor, Word dependent) {
		
	}

	private void createCompositeStructure(Map<String, EClassifier> metamodel, Word governor, Word dependent) {
		Set<String> childrenNames = new HashSet<String>();
		childrenNames.add(dependent.getText());
		analyseConjunctionChain(dependent, childrenNames);
		for (String childName : childrenNames) {
			EClass metaclass = EcoreFactory.eINSTANCE.createEClass();
			metaclass.setName(childName);
			if(metamodel.get(childName) == null){
				metamodel.put(childName, metaclass);
			}
		}
		List<Dependency> governorDependents = governor.getDependents();
		for (Dependency governorDependency : governorDependents) {
			if(governorDependency instanceof Dprep){
				if(PARENT_PREPOSITION_TERMS.contains(((Dprep) governorDependency).getCollapsedWordString())){
					String parentName = getSingularName(governorDependency.getDependent());
					EClass metaclass = EcoreFactory.eINSTANCE.createEClass();
					metaclass.setName(parentName);
					if(metamodel.get(parentName) == null){
						metamodel.put(parentName, metaclass);
					} else {
						EClassifier classifier = metamodel.get(parentName);
						assertTrue(parentName + " must be an EClass", classifier instanceof EClass);
						metaclass = (EClass) classifier;
					}
					for (String childName : childrenNames) {
						EClassifier classifier = metamodel.get(childName);
						assertTrue(childName + " must be an EClass", classifier instanceof EClass);
						EClass subclass = (EClass) classifier;
						if(!subclass.getESuperTypes().contains(metaclass)){
							subclass.getESuperTypes().add(metaclass);
						}
					}
				}
			}
		}
	}

	private void analyseConjunctionChain(Word word, Set<String> childrenNames) {
		List<Dependency> dependents = word.getDependents();
		for (Dependency dependency : dependents) {
			if(dependency instanceof Dconj){
				// TODO analyse kind (for constraint generation): and, or
				Word dependent = dependency.getDependent();
				String childName = getSingularName(dependent); 
				childrenNames.add(childName);
				analyseConjunctionChain(dependent, childrenNames);
			}
		}
	}

	private String getSingularName(Word dependent) {
		String childName = dependent.getText();
		if(dependent instanceof NNS || dependent instanceof NNPS){
			childName = childName.substring(0, childName.length() - 2);
		}
		return childName;
	}
}
