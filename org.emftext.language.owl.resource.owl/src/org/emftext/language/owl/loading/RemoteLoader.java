/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.owl.loading;

import java.io.File;
import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emftext.language.owl.AnnotationProperty;
import org.emftext.language.owl.Class;
import org.emftext.language.owl.DataProperty;
import org.emftext.language.owl.Datatype;
import org.emftext.language.owl.Frame;
import org.emftext.language.owl.IRIIdentified;
import org.emftext.language.owl.Individual;
import org.emftext.language.owl.ObjectProperty;
import org.emftext.language.owl.Ontology;
import org.emftext.language.owl.OntologyDocument;
import org.emftext.language.owl.OwlFactory;
import org.semanticweb.owl.apibinding.OWLManager;
import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLDataProperty;
import org.semanticweb.owl.model.OWLIndividual;
import org.semanticweb.owl.model.OWLObjectProperty;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyChangeException;
import org.semanticweb.owl.model.OWLOntologyCreationException;
import org.semanticweb.owl.model.OWLOntologyManager;

public class RemoteLoader {

	private Ontology ontology;
	private static OwlFactory factory = OwlFactory.eINSTANCE;
	private static Map<String, Ontology> url2ontologies 
						= new HashMap<String, Ontology>();
	private Map<String, Map<String, Frame>> url2irimaps = new HashMap<String, Map<String, Frame>>();

	
	static {
		
		Ontology o = factory.createOntology();
		String uri = "http://www.w3.org/2001/XMLSchema#";
		o.setUri(uri);
		String[] types = new String[]{"string", "integer", "float","decimal"};
		for (String type : types ) {
			Datatype datatype = factory.createDatatype();
			datatype.setIri(type);
			o.getFrames().add(datatype);
		}
		url2ontologies.put(uri, o);

	}

	
	

	public RemoteLoader() {
		
	}
		
	public Ontology loadOntology(String uri,  EObject container) {
		ontology = url2ontologies.get(uri);
		if (ontology == null) {
			initialise(uri, container);
			ontology = url2ontologies.get(uri);
		}
		return ontology;
	}
	
	public org.eclipse.emf.common.util.URI getLocationHintURI(String locationHint, EObject container) {
		org.eclipse.emf.common.util.URI hintURI = null;
		
		if (locationHint.contains(":")) {
			// locationHint is an absolute path - we can use it as it is
			hintURI = org.eclipse.emf.common.util.URI.createURI(locationHint);
		} else {
			// locationHint is an relative path - we must resolve it
			org.eclipse.emf.common.util.URI containerURI = container.eResource().getURI();
			if(containerURI.isRelative()) {
				URI f = new File(".").getAbsoluteFile().toURI();
				org.eclipse.emf.common.util.URI baseURI = org.eclipse.emf.common.util.URI.createURI(f.toString());
				containerURI = containerURI.resolve(baseURI);
			} 
				hintURI = org.eclipse.emf.common.util.URI.createURI(locationHint).resolve(containerURI);
					
			}
		
		return hintURI;
	}
	
	private void initialise(String uri, EObject container) {
		if (uri.startsWith("http")) {
			initialiseRemoteUri(uri);
		}
		else {
			initialiseLocalUri(uri, container);	
		}
	}

	private void initialiseLocalUri(String uri, EObject container) {
		ResourceSet rs = container.eResource().getResourceSet();
		
		if (uri == null) {
			return;
		}
		org.eclipse.emf.common.util.URI loadUri = getLocationHintURI(uri, container);
		if ("owl".equals(loadUri.fileExtension())) {
			Resource csResource = null;
			
			try {
				csResource = rs.getResource(loadUri, true);
			} catch (Exception e) {
				System.out.println(e);
			}
			
			EList<EObject> contents = null; 
			if (csResource != null) {
				contents = csResource.getContents();	
			}
			if (contents != null && contents.size() > 0) {
				if(contents.get(0) instanceof OntologyDocument) {
					OntologyDocument d = (OntologyDocument) contents.get(0);
					ontology = d.getOntology();
					url2ontologies.put(uri, ontology);
				}
			}
		}
	}

	private void initialiseRemoteUri(String uri) {
		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		// Load the ontology 
		try {
			OWLOntology owlOnto = manager.loadOntology( URI.create( uri ) );
			ontology = propagate(owlOnto);
			ontology.setUri(uri);
		} catch (OWLOntologyCreationException e) {
			// TODO Auto-generated catch block
			try {
				ontology = propagate(manager.
						createOntology(Collections.EMPTY_SET));
			} catch (OWLOntologyCreationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (OWLOntologyChangeException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//e.printStackTrace();
		}
		url2ontologies.put(uri, ontology);
	}

	

	private Ontology propagate(OWLOntology owlOntology) {
		final Ontology o = factory.createOntology();
		o.setUri(owlOntology.getURI().toString());
		Set<OWLClass> classes = owlOntology.getClassesInSignature();
		for (OWLClass clazz : classes) {
			Class newClass = factory.createClass();
			newClass.setIri(clazz.getURI().getFragment());
			o.getFrames().add(newClass);
		}
		Set<OWLObjectProperty> objectProperties = owlOntology.getObjectPropertiesInSignature();
		for (OWLObjectProperty objectProperty : objectProperties) {
			ObjectProperty newOP = factory.createObjectProperty();
			newOP.setIri(objectProperty.getURI().getFragment());
			o.getFrames().add(newOP);
		}
		Set<OWLDataProperty> dataPropertiesInSignature = owlOntology.getDataPropertiesInSignature();
		for (OWLDataProperty dataProperty : dataPropertiesInSignature) {
			DataProperty newDP = factory.createDataProperty();
			newDP.setIri(dataProperty.getURI().getFragment());
			o.getFrames().add(newDP);
		}
		Set<OWLIndividual> individualsInSignature = owlOntology.getIndividualsInSignature();
		for (OWLIndividual individual : individualsInSignature) {
			Individual newIndividual = factory.createIndividual();
			newIndividual.setIri(individual.getURI().getFragment());
			o.getFrames().add(newIndividual);
		}
		Set<URI> annotationURIs = owlOntology.getAnnotationURIs();
		for (URI uri : annotationURIs) {
			AnnotationProperty newAnnotationProperty = factory.createAnnotationProperty();
			newAnnotationProperty.setIri(uri.getFragment());
			o.getFrames().add(newAnnotationProperty);
		}
		return o;
	}

	
	public Ontology getOntology() {
		return this.ontology;
	}

	public IRIIdentified getOntologyElement(String identifier) {
		return findEntity(identifier, ontology);
	}

	private IRIIdentified findEntity(String identifier, Ontology onto) {
		Map<String, Frame> iriMap = url2irimaps.get(onto);
		if (iriMap == null) {
			iriMap = intialiseIriMap(onto);
		}
		Frame frame = iriMap.get(identifier);
		return frame;
	}

	private Map<String, Frame> intialiseIriMap(Ontology onto) {
		Map<String, Frame> iriMap = new HashMap<String, Frame>();
		if (onto == null) return iriMap;
		
		EList<Frame> frames = onto.getFrames();
		for (Frame frame : frames) {
			if(frame.getIri() != null ) {
				iriMap.put(frame.getIri(), frame);
			}	
		}
		url2irimaps.put(onto.getUri(), iriMap);
		return iriMap;
	}

}
