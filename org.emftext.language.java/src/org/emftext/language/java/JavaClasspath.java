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
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.emftext.language.java.classifiers.Class;
import org.emftext.language.java.classifiers.ClassifiersFactory;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.commons.NamespaceAwareElement;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.members.MemberContainer;
import org.emftext.language.java.util.JavaUtil;

/**
 * This class is responsible for managing an retrieving Java resources to
 * establish inter-model references between different Java classes represented
 * as EMF-models.
 *
 */
public class JavaClasspath {

	/**
	 * Singleton instance.
	 */
	public static final JavaClasspath INSTANCE = new JavaClasspath();
	
	/**
	 * Convenient access to <code>URIConverter.URI_MAP</code>.
	 */
	public final Map<URI, URI> URI_MAP = URIConverter.URI_MAP;

	protected Map<String, List<String>> packageClassifierMap =
		new HashMap<String, List<String>>();
	
	public JavaClasspath() {
		registerStdLib(URI_MAP);
	}

	/**
	 * Registers all classes of the Java standard library 
	 * <code>classes.jar</code> located at 
	 * <code>System.getProperty("sun.boot.class.path")</code>.
	 */
	public void registerStdLib() {
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
	
	/**
	 * Registers all class files contained in the jar file located
	 * at the given URI.
	 * 
	 * @param jarURI
	 * @throws IOException
	 */
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

	/**
	 * Registers all classes defined in the given compilation unit.
	 * 
	 * @param compilationUnit
	 * @throws IOException
	 */
	public void registerClassifierSource(CompilationUnit compilationUnit, URI uri) {
		registerClassifierSource(compilationUnit, uri, URI_MAP);
	}
	
	public void registerClassifierSource(
			CompilationUnit compilationUnit, 
			URI uri, 
			Map<URI, URI> localURI_MAP) {
		
		String packageName = JavaUniquePathConstructor.packageName(compilationUnit);
		
		for(ConcreteClassifier classifier : compilationUnit.getClassifiers()) {
			registerClassifier(
					packageName, classifier.getName(), uri, localURI_MAP);
			registerInnerClassifiers(
					classifier, packageName, classifier.getName(), uri, localURI_MAP);
		}
	}
	
	/**
	 * Registers the classifier with the given name and package that is physically
	 * located at the given URI.
	 * 
	 * @param packageName
	 * @param classifierName
	 * @param uri
	 */
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
	
	private void registerInnerClassifiers(ConcreteClassifier classifier, String packageName, String className, URI uri, Map<URI, URI> localURI_MAP) {
		for(Member innerCand : ((MemberContainer)classifier).getMembers()) {
			if (innerCand instanceof ConcreteClassifier) {
				String newClassName = className + JavaUniquePathConstructor.CLASSIFIER_SEPARATOR + innerCand.getName();
				registerClassifier(packageName, newClassName, uri, localURI_MAP);
				registerInnerClassifiers((ConcreteClassifier)innerCand, packageName, newClassName, uri, localURI_MAP);
			}
		}
	}

	/**
	 * Removes the classifier identified by its package and name from the
	 * class path.
	 * 
	 * @param packageName
	 * @param classifierName
	 */
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
	
	public EList<ConcreteClassifier> getInnnerClassifiers(ConcreteClassifier container) {
		if(container == null) {
			return ECollections.emptyEList();
		}

		String fullName = "";
		EObject parentContainer = JavaUtil.findContainingClassifier(container.eContainer());
		
		while (parentContainer instanceof ConcreteClassifier) {
			fullName = ((ConcreteClassifier)parentContainer).getName() + JavaUniquePathConstructor.CLASSIFIER_SEPARATOR + fullName;
			parentContainer = JavaUtil.findContainingClassifier(parentContainer.eContainer());
		}
		
		EObject rootContainer = JavaUtil.findContainingCompilationUnit(container);
		if (rootContainer instanceof CompilationUnit) {
			CompilationUnit compilationUnit = (CompilationUnit) rootContainer;
		    fullName = getContainerNameFromNamespace(compilationUnit) + fullName + 
		    	container.getName() + JavaUniquePathConstructor.CLASSIFIER_SEPARATOR;
			return getClassifiers(fullName, "*");
		}
		
		return ECollections.emptyEList();
	}
	
	/**
	 * Constructs a list of proxies that point at all classifiers 
	 * of the given package present in the class path.
	 * <p>
	 * Each proxy will have the <code>name</code> attribute set correctly such
	 * that name comparison can be done without resolving the proxy.
	 * 
	 * @param packageName
	 * @return list of proxies
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
	 * Constructs a proxy pointing at the classifier identified by its 
	 * fully qualified name.
	 * 
	 * @param fullQualifiedName
	 * @return proxy element
	 */
	public ConcreteClassifier getClassifier(String fullQualifiedName) {
		InternalEObject classifierProxy = (InternalEObject) ClassifiersFactory.eINSTANCE.createClass();
		URI proxyURI = JavaUniquePathConstructor.getClassifierURI(fullQualifiedName);
		classifierProxy.eSetProxyURI(proxyURI);
		//set also the name to reason about it without resolving the proxy
		((Class)classifierProxy).setName(JavaUniquePathConstructor.getSimpleClassName(fullQualifiedName));
		return (ConcreteClassifier) classifierProxy;
	}
	
	/**
	 * Converts the namespaces array of the given namespace aware element into
	 * a String representation using package (.) and class ($) delimiters. The method
	 * uses the classpath to determine for each element of the namespace if it 
	 * identifies a package or a class.
	 * 
	 * @param naElement
	 * @return single string representation of namespace
	 */
	public String getContainerNameFromNamespace(NamespaceAwareElement naElement) {
		String containerName = "";
		for(Iterator<String> it = naElement.getNamespaces().iterator(); it.hasNext(); ) {
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
	
	private EList<ConcreteClassifier> javaLangPackage = null;
	
	/**
	 * Returns a list of proxies for all classes <code>java.lang.*</code>.
	 * 
	 * @return list of proxies 
	 */
	public EList<ConcreteClassifier> getDefaultImports() {
		EList<ConcreteClassifier> resultList = new BasicEList<ConcreteClassifier>();
		
		//java.lang package	
		if (javaLangPackage == null) {
			javaLangPackage = new BasicEList<ConcreteClassifier>();
			javaLangPackage.addAll(getClassifiers("java.lang.", "*"));
		}		
		
		resultList.addAll(javaLangPackage);

		return resultList;
	}
}
