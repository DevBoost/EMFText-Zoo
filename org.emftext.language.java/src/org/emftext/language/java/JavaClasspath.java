package org.emftext.language.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.emftext.language.java.Classifier;
import org.emftext.language.java.JavaFactory;

public class JavaClasspath {

	public static final JavaClasspath INSTANCE = new JavaClasspath();
	
	public final Map<URI, URI> URI_MAP = URIConverter.URI_MAP;

	protected Map<String, List<String>> packageClassifierMap =
		new HashMap<String, List<String>>();
	
	public JavaClasspath() {
		try {
			// TODO implement this in a platform-independent way
			// maybe System.getProperty("sun.boot.class.path") is a
			// useful quick fix?
			//registerClassifierJar("/System/Library/Frameworks/JavaVM.framework/Classes/classes.jar");
			registerClassifierJar("C:\\Java\\JREs\\jre1.5.0_16\\lib\\rt.jar");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void registerClassifierJar(String path) throws IOException {
			
		//String classpathURI = 
		ZipFile zipFile = new ZipFile(path);
		
		Enumeration<? extends ZipEntry> entries = zipFile.entries();
		while (entries.hasMoreElements()) {
			ZipEntry entry = entries.nextElement();

			if (entry.getName().endsWith(".class") || entry.getName().endsWith(".java")) {
				String fullName = entry.getName();
				String packageName = fullName.substring(0, fullName.lastIndexOf("/")).replaceAll("/", ".");
				String className = fullName.substring(fullName.lastIndexOf("/") + 1, fullName.lastIndexOf("."));
				
				String uri = "archive:file:" + path + "!/" + fullName;
				
				registerClassifier(packageName, className, URI.createURI(uri));
			}
		}
	}
	

	public void registerClassifierSource(CompilationUnit cu, URI uri) {
		String packageName = JavaUniquePathConstructor.packageName(cu);
		for(TreeIterator<EObject> it = cu.eAllContents(); it.hasNext(); ) {
			EObject cand = it.next();
			if (cand instanceof Classifier) {
				registerClassifier(
						packageName, ((Classifier)cand).getName(), uri);
				it.prune();
			}
		}
		
	}
	
	public void registerClassifier(String packageName, String name, URI uri) {
		synchronized (packageClassifierMap) {
			if (!packageClassifierMap.containsKey(packageName)) {
				packageClassifierMap.put(packageName, new ArrayList<String>());
			}
			if (!packageClassifierMap.get(packageName).contains(name)) {
				packageClassifierMap.get(packageName).add(name);
			}
		}
		
		if (uri != null) {
			URI logicalUri = 
				JavaUniquePathConstructor.getClassifierResourceURI(packageName, name);
			
			if (URI_MAP.containsKey(logicalUri)) {
				//TODO where to put this warning?
				System.out.println("[JaMoPP] WARNING: Two versions of " + packageName + "." + name + 
						"\n[JaMoPP]   1) " + URI_MAP.get(logicalUri) +
						"\n[JaMoPP]   2) " + uri +
						"\n[JaMoPP] Version 1) will be ignored!");
			}
			
			URI_MAP.put(logicalUri, uri);
		}
	}
	
	private EList<Classifier> javaLangPackage = null;
	
	/**
	 * Constructs a list of proxies that point at the classifiers of the given package
	 * 
	 * @param packageName
	 * @return
	 */
	public EList<Classifier> getClassifiers(String packageName, String classifierQuery) {
		EList<Classifier> resultList = new BasicEList<Classifier>();
		
		synchronized (packageClassifierMap) {
			if(!packageClassifierMap.containsKey(packageName)) {
				return resultList;
			}
			
			for (String classifierName : packageClassifierMap.get(packageName)) {
				if (classifierQuery.equals("*") || classifierQuery.equals(classifierName)) {
					InternalEObject classifierProxy = (InternalEObject) JavaFactory.eINSTANCE.createClass();
					classifierProxy.eSetProxyURI(JavaUniquePathConstructor.getClassifierURI(packageName, classifierName));
					resultList.add((Classifier) classifierProxy);
				}
			}
		}
		
		return resultList;
	}

	public EList<Classifier> getDefaultImports(String packageName) {
		EList<Classifier> resultList = new BasicEList<Classifier>();
		//my package
		resultList.addAll(getClassifiers(packageName, "*"));

		//java.lang package	
		if (javaLangPackage == null) {
			javaLangPackage = new BasicEList<Classifier>();
			javaLangPackage.addAll(getClassifiers("java.lang", "*"));
		}
		
		resultList.addAll(javaLangPackage);
		
		return resultList;
	}

}
