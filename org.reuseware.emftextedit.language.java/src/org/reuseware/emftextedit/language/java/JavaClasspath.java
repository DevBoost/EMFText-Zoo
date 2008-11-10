package org.reuseware.emftextedit.language.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.reuseware.emftextedit.language.java.Classifier;
import org.reuseware.emftextedit.language.java.JavaFactory;

public class JavaClasspath {

	public static final JavaClasspath INSTANCE = new JavaClasspath();
	
	protected Map<URI, URI> URI_MAP = URIConverter.URI_MAP;

	protected Map<String, List<String>> packageClassifierMap =
		new HashMap<String, List<String>>();
	
	public void registerClassifier(String packageName, String name, URI uri) {
		if (!packageClassifierMap.containsKey(packageName)) {
			packageClassifierMap.put(packageName, new ArrayList<String>());
		}
		if (!packageClassifierMap.get(packageName).contains(name)) {
			packageClassifierMap.get(packageName).add(name);
		}
		
		if (uri != null) {
			URI logicalUri = 
				JavaUniquePathConstructor.getClassifierResourceURI(packageName, name);
			
			URI_MAP.put(logicalUri, uri);
		}
	}
	
	/**
	 * Constructs a list of proxies that point at the classifiers of the given package
	 * 
	 * @param packageName
	 * @return
	 */
	public EList<Classifier> getClassifiers(String packageName, String classifierQuery) {
		EList<Classifier> resultList = new BasicEList<Classifier>();
		
		if(!packageClassifierMap.containsKey(packageName)) {
			return resultList;
		}
		
		
		for(String classifierName : packageClassifierMap.get(packageName)) {
			if (classifierQuery.equals("*") || classifierQuery.equals(classifierName)) {
				InternalEObject classifierProxy = (InternalEObject) JavaFactory.eINSTANCE.createClass();
				classifierProxy.eSetProxyURI(JavaUniquePathConstructor.getClassifierURI(packageName, classifierName));
				resultList.add((Classifier) classifierProxy);
			}
		}
		
		return resultList;
	}

}
