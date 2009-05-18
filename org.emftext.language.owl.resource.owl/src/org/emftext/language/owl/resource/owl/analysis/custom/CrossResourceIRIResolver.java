package org.emftext.language.owl.resource.owl.analysis.custom;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.owl.IRIIdentified;
import org.emftext.language.owl.Namespace;
import org.emftext.language.owl.OntologyDocument;
import org.emftext.language.owl.OwlFactory;
import org.emftext.language.owl.OwlPackage;
import org.emftext.language.owl.loading.RemoteLoader;
import org.emftext.runtime.resource.IReferenceResolveResult;

public class CrossResourceIRIResolver {
	
	private static CrossResourceIRIResolver instance;
	static private Map<String, String> standardNamespaces = new HashMap<String, String>();
	static {
		standardNamespaces.put("rdf","http://www.w3.org/1999/02/22-rdf-syntax-ns#");
		standardNamespaces.put("rdfs","http://www.w3.org/2000/01/rdf-schema#");
		standardNamespaces.put("xsd","http://www.w3.org/2001/XMLSchema#");
		standardNamespaces.put("owl","http://www.w3.org/2002/07/owl#");
		
	}

	private RemoteLoader remoteLoader;
	
	private CrossResourceIRIResolver() {
		remoteLoader = new RemoteLoader();
	}

	public static CrossResourceIRIResolver theInstance() {
		if (instance == null) {
			instance = new CrossResourceIRIResolver();
		}
		return instance;
	}
	
	
	public <RESULT extends IRIIdentified> void doResolve(String identifier,
			EObject containerObject, boolean resolveFuzzy,
			 IReferenceResolveResult<RESULT> result, Class<RESULT> c) {
		RESULT r = null;
		if (!hasPrefix(identifier)) return;
		String iriPrefix = getPrefix(identifier);
		identifier = getId(identifier);
		
		IRIIdentified entity = getOntologyEntity(iriPrefix, containerObject, identifier);
		if (entity != null) {
			String name = entity.getIri();
			EClass classifier = (EClass) OwlPackage.eINSTANCE.getEClassifier(c.getSimpleName());
			r = (RESULT) OwlFactory.eINSTANCE.create(classifier);
			r.setIri(name);
			result.addMapping(name, r);		
		}
	}

	private String getId(String identifier) {
		int startIdx = identifier.indexOf(":");
		if ((startIdx == -1)) return "";
		else return identifier.substring(startIdx+1);
	
	}

	private IRIIdentified getOntologyEntity(String iriPrefix, EObject containerObject, String identifier) {
		
		EList<EObject> contents = containerObject.eResource().getContents();
		for (EObject object : contents) {
			if (object instanceof OntologyDocument) {
				IRIIdentified entity = searchOntologyEntity(iriPrefix, (OntologyDocument) object, identifier);
				return entity;
			}
		}
		return null;
	}

	private IRIIdentified searchOntologyEntity(String iriPrefix, OntologyDocument ontologyDocument, String identifier) {
		String uri = standardNamespaces.get(iriPrefix); 
		if (uri != null) {
			remoteLoader.loadOntology(uri);
			IRIIdentified entity = remoteLoader.getOntologyElement(identifier);
			return entity;
		}
	
		EList<Namespace> namespaces = ontologyDocument.getNamespace();
		for (Namespace namespace : namespaces) {
			if (iriPrefix.equals(namespace.getPrefix())) {
				uri = namespace.getUri(); 
				remoteLoader.loadOntology(uri);
				IRIIdentified entity = remoteLoader.getOntologyElement(identifier);
				return entity;
			}
		}
		return null;
	}

	private String getPrefix(String identifier) {
		int startIdx = identifier.indexOf(":");
		if ((startIdx == -1)) return "";
		else return identifier.substring(0, startIdx);
	}

	private boolean hasPrefix(String identifier) {
		return (!(identifier.indexOf(":") == -1));
	}
	

}
