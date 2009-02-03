package org.emftext.language.java;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.emftext.language.java.classifiers.Class;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.classifiers.ClassifiersFactory;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.commons.NamespaceAwareElement;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.imports.Import;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.members.MemberContainer;

public class JavaClasspath {

	public static final JavaClasspath INSTANCE = new JavaClasspath();
	
	public final Map<URI, URI> URI_MAP = URIConverter.URI_MAP;

	protected Map<String, List<String>> packageClassifierMap =
		new HashMap<String, List<String>>();
	
	public JavaClasspath() {
		registerStdLib(URI_MAP);
	}

	public void registerStdLib(Map<URI, URI> localURI_MAP) {
		try {
			String classpath = System.getProperty("sun.boot.class.path");
			String[] classpathEntries = classpath.split(File.pathSeparator);
			
			for (int idx = 0; idx < classpathEntries.length; idx++) {
				String classpathEntry = classpathEntries[idx];
				if (classpathEntry.endsWith("classes.jar") || classpathEntry.endsWith("rt.jar")) {
					URI uri = URI.createFileURI(classpathEntries[idx]);
					registerClassifierJar(uri, localURI_MAP);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void registerClassifierJar(URI jarURI) throws IOException {
		registerClassifierJar(jarURI, URI_MAP);
	}
	
	public void registerClassifierJar(URI jarURI, Map<URI, URI> localURI_MAP) throws IOException {
		ZipFile zipFile = new ZipFile(jarURI.toFileString());
		
		Enumeration<? extends ZipEntry> entries = zipFile.entries();
		while (entries.hasMoreElements()) {
			ZipEntry entry = entries.nextElement();

			if (entry.getName().endsWith(".class")) {
				String fullName = entry.getName();
				String uri = "archive:" + jarURI.toString() + "!/" + fullName;
				
				fullName = fullName.replaceAll("/", "."); 
				
				String packageName = "";
				String className   = "";
				
				int idx = fullName.lastIndexOf(".");
				idx = fullName.substring(0, idx).lastIndexOf(".");
				if (idx >= 0) {
					packageName = fullName.substring(0, idx);
					className   = fullName.substring(idx + 1, fullName.lastIndexOf("."));
				}				
				registerClassifier(packageName, className, URI.createURI(uri), localURI_MAP);
			}
		}
		
	}

	public void registerClassifierSource(CompilationUnit cu, URI uri) {
		registerClassifierSource(cu, uri, URI_MAP);
	}
	
	public void registerClassifierSource(CompilationUnit cu, URI uri, Map<URI, URI> localURI_MAP) {
		String packageName = JavaUniquePathConstructor.packageName(cu);
		
		for(Classifier classifier : cu.getClassifiers()) {
			registerClassifier(
					packageName, classifier.getName(), uri, localURI_MAP);
			registerInnerClassifiers(
					classifier, packageName, classifier.getName(), uri, localURI_MAP);
		}
	}
	
	protected void registerInnerClassifiers(Classifier classifier, String packageName, String className, URI uri, Map<URI, URI> localURI_MAP) {
		for(Member innerCand : ((MemberContainer)classifier).getMembers()) {
			if (innerCand instanceof Classifier) {
				String newClassName = className + JavaUniquePathConstructor.CLASSIFIER_SEPARATOR + innerCand.getName();
				registerClassifier(packageName, newClassName, uri, localURI_MAP);
				registerInnerClassifiers((Classifier)innerCand, packageName, newClassName, uri, localURI_MAP);
			}
		}
	}
	
	public void registerClassifier(String packageName, String classifierName, URI uri) {
		registerClassifier(packageName, classifierName, uri, URI_MAP);
	}
	
	public void registerClassifier(String packageName, String classifierName, URI uri, Map<URI, URI> localURI_MAP) {
		if (classifierName == null || classifierName.equals("") || uri == null) {
			return;
		}
		
		if (!packageName.endsWith(".")) {
			packageName = packageName + ".";
		}
		
		String innerName = classifierName;
		String outerName = "";
		String qualifiedName = packageName;
		
		int idx = classifierName.lastIndexOf(JavaUniquePathConstructor.CLASSIFIER_SEPARATOR);
		if (idx >= 0) {
			innerName = classifierName.substring(idx + 1);
			outerName = classifierName.substring(0, idx + 1);
			if (".".equals(packageName)) {
				qualifiedName = outerName;
			}
			else {
				qualifiedName = packageName + outerName;
			}
		}
		
		synchronized (this) {
			if (!packageClassifierMap.containsKey(qualifiedName)) {
				packageClassifierMap.put(qualifiedName, new ArrayList<String>());
			}
			if (!packageClassifierMap.get(qualifiedName).contains(innerName)) {
				packageClassifierMap.get(qualifiedName).add(innerName);
			}
			
			if (uri != null) {
				String fullName = null;
				if (".".equals(packageName)) {
					fullName = classifierName;
				}
				else {
					fullName = packageName + classifierName;
				}
				
				URI logicalUri = 
					JavaUniquePathConstructor.getJavaFileResourceURI(fullName);
				
				URI existinMapping = localURI_MAP.get(logicalUri);
				
				if (existinMapping != null && !uri.equals(existinMapping)) {
					//TODO where to put this warning?
					/*System.out.println("[JaMoPP] WARNING: Two versions of " + fullName + 
							"\n[JaMoPP]   1) " + URI_MAP.get(logicalUri) +
							"\n[JaMoPP]   2) " + uri +
							"\n[JaMoPP] Version 1) will be ignored!");*/
				}
				
				localURI_MAP.put(logicalUri, uri);
			}
		}
	}
	
	private EList<ConcreteClassifier> javaLangPackage = null;
	
	
	public EList<ConcreteClassifier> getInternalClassifiers(Classifier container) {
		String uri = null;
		if(container.eIsProxy()) {
			uri = ((InternalEObject)container).eProxyURI().trimFragment().toString();
		}
		else {
			Resource resource = container.eResource();
			if (resource != null){
				uri = container.eResource().getURI().toString();
			}
		}

		if (uri != null){
			if (uri.startsWith(JavaUniquePathConstructor.JAVA_CLASSIFIER_PATHMAP)) {
				String className = uri.substring(
						JavaUniquePathConstructor.JAVA_CLASSIFIER_PATHMAP.length());
				className = className.substring(0,className.length()-5) + "$";
				return getClassifiers(className, "*");	
			}
		}
		return new BasicEList<ConcreteClassifier>();
	}
	
	/**
	 * Constructs a list of proxies that point at the classifiers of the given package
	 * 
	 * @param packageName
	 * @return
	 */
	public EList<ConcreteClassifier> getClassifiers(String packageName, String classifierQuery) {
		if (!packageName.endsWith(JavaUniquePathConstructor.PACKAGE_SEPARATOR) &&
				!packageName.endsWith(JavaUniquePathConstructor.CLASSIFIER_SEPARATOR)) {
			packageName = packageName + JavaUniquePathConstructor.PACKAGE_SEPARATOR;
		}
		
		EList<ConcreteClassifier> resultList = new BasicEList<ConcreteClassifier>();

		synchronized (this) {
			if(!packageClassifierMap.containsKey(packageName)) {
				return resultList;
			}
			
			for (String classifierName : packageClassifierMap.get(packageName)) {
				if (classifierQuery.equals("*") || classifierQuery.equals(classifierName)) {
					InternalEObject classifierProxy = (InternalEObject) ClassifiersFactory.eINSTANCE.createClass();
					String fullQualifiedName = null;
					if ("".equals(packageName) || ".".equals(packageName)) {
						fullQualifiedName = classifierName;
					}
					else {
						fullQualifiedName = packageName + classifierName;
					}
					classifierProxy.eSetProxyURI(JavaUniquePathConstructor.getClassifierURI(fullQualifiedName));
					//set also the name to reason about it without resolving the proxy
					((Class)classifierProxy).setName(JavaUniquePathConstructor.getSimpleClassName(fullQualifiedName));
					resultList.add((ConcreteClassifier) classifierProxy);
				}
			}
		}
		
		return resultList;
	}
	
	/**
	 * 
	 * @param theImport that points at the package
	 * @param classifierName the name of the classifier in the given package
	 * @return
	 */
	public Classifier getClassifier(Import theImport, String classifierName) {
		String containerName = getContainerNameFromNamespace(theImport, "");
		if (containerName == null) {
			return null;
		}
		
		String fullQualifiedName = containerName + classifierName;
		return getClassifier(fullQualifiedName);
	}

	/**
	 * 
	 * @param theImport that points directly at the classifier
	 * @return
	 */
	public Classifier getClassifier(Import theImport) {
		String fullQualifiedName = getContainerNameFromNamespace(theImport, "");
		if (fullQualifiedName == null || fullQualifiedName.endsWith(JavaUniquePathConstructor.PACKAGE_SEPARATOR)) {
			return null;
		}
		//cut the trailing separator
		fullQualifiedName = fullQualifiedName.substring(0,fullQualifiedName.length() -1);
		
		return getClassifier(fullQualifiedName);
	}
	
	public EList<ConcreteClassifier> getClassifiers(Import theImport) {
		String containerName = getContainerNameFromNamespace(theImport, "");
		if (containerName == null) {
			return new BasicEList<ConcreteClassifier>();
		}
		
		EList<ConcreteClassifier> result = getClassifiers(containerName, "*");
		return result;
	}
	
	public String getContainerNameFromNamespace(NamespaceAwareElement theImport, String prefix) {
		String containerName = prefix;
		for(Iterator<String> it = theImport.getNamespace().iterator(); it.hasNext(); ) {
			String namespaceFragment = it.next();
			//does it point at a classifier or a package as container?
			String assumedPackageName    = containerName + namespaceFragment + JavaUniquePathConstructor.PACKAGE_SEPARATOR;
			String assumedClassifierName = containerName + namespaceFragment + JavaUniquePathConstructor.CLASSIFIER_SEPARATOR;
			
			if (it.hasNext()) {
				if (packageClassifierMap.containsKey(assumedClassifierName)) {
					containerName = assumedClassifierName;
				}
				else {
					//assume package
					containerName = assumedPackageName;
				}
			}
			else {
				if (packageClassifierMap.containsKey(assumedPackageName)) {
					//a package is always available as key
					containerName = assumedPackageName;
				}
				else {
					//assume classifier that is not key, but value in the map
					containerName = assumedClassifierName;
				}
			}
		}
		
		return containerName;
	}
	
	public Classifier getClassifier(String fullQualifiedName) {
		InternalEObject classifierProxy = (InternalEObject) ClassifiersFactory.eINSTANCE.createClass();
		URI proxyURI = JavaUniquePathConstructor.getClassifierURI(fullQualifiedName);
		classifierProxy.eSetProxyURI(proxyURI);
		//set also the name to reason about it without resolving the proxy
		((Class)classifierProxy).setName(JavaUniquePathConstructor.getSimpleClassName(fullQualifiedName));
		return (Classifier) classifierProxy;
	}
	
	public EList<ConcreteClassifier> getDefaultImports(String packageName) {
		EList<ConcreteClassifier> resultList = new BasicEList<ConcreteClassifier>();

		//my package
		EList<ConcreteClassifier> myPackage = getClassifiers(packageName + ".", "*");
		
		//java.lang package	
		if (javaLangPackage == null) {
			javaLangPackage = new BasicEList<ConcreteClassifier>();
			javaLangPackage.addAll(getClassifiers("java.lang.", "*"));
		}		
		
		if(packageName.equals("")) {
			//reverse order of java.lang and default package
			//TODO this works for tests. 
			//Is this the desired behavior? Usually default package is not used.
			resultList.addAll(javaLangPackage);
			resultList.addAll(myPackage);
		}
		else {
			resultList.addAll(myPackage);
			resultList.addAll(javaLangPackage);
		}

		return resultList;
	}

	public void unRegisterClassifier(String packageName, String classifierName) {
		if (classifierName == null || classifierName.equals("")) {
			return;
		}
		
		if (!packageName.endsWith(".")) {
			packageName = packageName + ".";
		}
		
		String innerName = classifierName;
		String outerName = "";
		String qualifiedName = packageName;
		
		int idx = classifierName.lastIndexOf(JavaUniquePathConstructor.CLASSIFIER_SEPARATOR);
		if (idx >= 0) {
			innerName = classifierName.substring(idx + 1);
			outerName = classifierName.substring(0, idx + 1);
			if (".".equals(packageName)) {
				qualifiedName = outerName;
			}
			else {
				qualifiedName = packageName + outerName;
			}
		}
		
		synchronized (this) {
			if (packageClassifierMap.containsKey(qualifiedName)) {
				packageClassifierMap.get(qualifiedName).remove(innerName);
			}
			
			String fullName = null;
			if (".".equals(packageName)) {
				fullName = classifierName;
			}
			else {
				fullName = packageName + classifierName;
			}
				
			URI logicalUri = 
				JavaUniquePathConstructor.getJavaFileResourceURI(fullName);
			
			URI_MAP.remove(logicalUri);
		}
	}

}
