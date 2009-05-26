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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
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
public class JavaClasspath extends AdapterImpl {

	/**
	 * If this option is set to true in a resource set, each classifier loaded is registered
	 * in the URI map of the resource set's <code>URIConverter</code>.
	 * <p>
	 * If the option is set to false (default), each classifier loaded is registered
	 * in the global <code>URIConverter.URI_MAP</code>.
	 */
	public static final String OPTION_USE_LOCAL_CLASSPATH = "OPTION_USE_LOCAL_CLASSPATH";
	
	/**
	 * If this option is set to true (default) in a resource set, the Java standard library
	 * (i.e., rt.jar or classes.jar) is registered automatically based on
	 * <code>System.getProperty("sun.boot.class.path")</code>. 
	 */
	public static final String OPTION_REGISTER_STD_LIB = "OPTION_REGISTER_STD_LIB";
	
	/**
	 * Singleton instance.
	 */
	public static final JavaClasspath globalClasspath =
		new JavaClasspath(URIConverter.URI_MAP);
	
	static {
		globalClasspath.registerStdLib();
	}
	
	public static JavaClasspath get() {
		return globalClasspath;
	}
	
	public static JavaClasspath get(EObject objectContext) {
		if (objectContext == null) {
			return globalClasspath;
		}
		else {
			return get(objectContext.eResource());
		}
	}
	
	public static JavaClasspath get(Resource resource) {
		if(resource == null) {
			return globalClasspath;
		}
		else {
			return get(resource.getResourceSet());
		}
	}
	
	public static JavaClasspath get(ResourceSet resourceSet) {
		if (resourceSet == null) {
			return globalClasspath;
		}
		
		Object localClasspathOption = resourceSet.getLoadOptions().get(OPTION_USE_LOCAL_CLASSPATH);
		Object registerStdLibOption = resourceSet.getLoadOptions().get(OPTION_REGISTER_STD_LIB);
		if (registerStdLibOption == null) {
			registerStdLibOption = Boolean.TRUE;
		}
		
		if(Boolean.TRUE.equals(localClasspathOption))  {
			for(Adapter a : resourceSet.eAdapters()) {
				if (a instanceof JavaClasspath) {
					return (JavaClasspath)a;
				}
			}
			JavaClasspath myClasspath = new JavaClasspath(
					resourceSet.getURIConverter().getURIMap());
			resourceSet.eAdapters().add(myClasspath);

			if(Boolean.TRUE.equals(registerStdLibOption))  {
				myClasspath.registerStdLib();
			}
			
			return myClasspath;
		}
		
		return globalClasspath;
	}
	
	public JavaClasspath(Map<URI, URI> uriMap) {
		this.uriMap = uriMap;
	}
	
	protected Map<URI, URI> uriMap = null;
	protected Map<String, List<String>> packageClassifierMap =
		new HashMap<String, List<String>>();

	/**
	 * Registers all classes of the Java standard library 
	 * <code>classes.jar</code> located at 
	 * <code>System.getProperty("sun.boot.class.path")</code>.
	 */
	public void registerStdLib() {
		try {
			String classpath = System.getProperty("sun.boot.class.path");
			String[] classpathEntries = classpath.split(File.pathSeparator);
			
			for (int idx = 0; idx < classpathEntries.length; idx++) {
				String classpathEntry = classpathEntries[idx];
				if (classpathEntry.endsWith("classes.jar") || classpathEntry.endsWith("rt.jar")) {
					URI uri = URI.createFileURI(classpathEntries[idx]);
					registerClassifierJar(uri);
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
		registerClassifierJar(jarURI, "");
	}
	
	public void registerClassifierJar(URI jarURI, String prefix) throws IOException {
		ZipFile zipFile = new ZipFile(jarURI.toFileString());
		
		Enumeration<? extends ZipEntry> entries = zipFile.entries();
		while (entries.hasMoreElements()) {
			ZipEntry entry = entries.nextElement();

			if (entry.getName().endsWith(".class") && entry.getName().startsWith(prefix)) {
				String fullName = entry.getName();
				
				String uri = "archive:" + jarURI.toString() + "!/" + fullName;
				
				fullName = fullName.substring(prefix.length());
				fullName = fullName.replaceAll("/", "."); 
				
				String packageName = "";
				String className   = "";
				
				int idx = fullName.lastIndexOf(".");
				idx = fullName.substring(0, idx).lastIndexOf(".");
				if (idx >= 0) {
					packageName = fullName.substring(0, idx);
					className   = fullName.substring(idx + 1, fullName.lastIndexOf("."));
				}
				else {
					className = fullName.substring(0, fullName.lastIndexOf("."));
				}
				registerClassifier(packageName, className, URI.createURI(uri));
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
		
		String packageName = JavaUniquePathConstructor.packageName(compilationUnit);

		int endIdx = -1;
		if(JavaUtil.getName(compilationUnit) != null) {
			endIdx = JavaUtil.getName(compilationUnit).lastIndexOf("$");
		}
		if (endIdx > -1) { 
			char[] nameParts = JavaUtil.getName(compilationUnit).toCharArray();
			for(int i= 0; i< endIdx; i++) {
				if(nameParts[i] == '$') {
					int idx = packageName.lastIndexOf(".");
					packageName = packageName.substring(0, idx) + "$" + packageName.substring(idx + 1);
				}
			}
		}
		
		if (JavaUtil.getName(compilationUnit) != null && JavaUtil.getName(compilationUnit).contains("$")) {
			packageName = packageName + "$";
		}
		
		for(ConcreteClassifier classifier : compilationUnit.getClassifiers()) {
			registerClassifier(
					packageName, JavaUtil.getName(classifier), uri);
			registerInnerClassifiers(
					classifier, packageName, JavaUtil.getName(classifier), uri);
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
		if (classifierName == null || uri == null) {
			return;
		}
		
		if (!packageName.endsWith(".") && !packageName.endsWith("$")) {
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
				
				URI existinMapping = uriMap.get(logicalUri);
				
				if (existinMapping != null && !uri.equals(existinMapping)) {
					//do nothing: silently replace old with new version
				}
				
				uriMap.put(logicalUri, uri);
				
				String outerPackage = qualifiedName;
				while(outerPackage.endsWith("$")) {
					//make sure outer classes are registered;
					//This is required when class names contain $ symbols
					outerPackage = outerPackage.substring(0, outerPackage.length() - 1);
					idx = outerPackage.lastIndexOf("$");
					if (idx == -1) {
						idx = outerPackage.lastIndexOf(".");
					}
					String outerClassifier = outerPackage.substring(idx + 1);
					outerPackage = outerPackage.substring(0, idx + 1);
					
					if (!packageClassifierMap.containsKey(outerPackage)) {
						packageClassifierMap.put(outerPackage, new ArrayList<String>());
					}
					if (!packageClassifierMap.get(outerPackage).contains(outerClassifier)) {
						packageClassifierMap.get(outerPackage).add(outerClassifier);
					}
				}
			}
		}
	}
	
	private void registerInnerClassifiers(ConcreteClassifier classifier, String packageName, String className, URI uri) {
		for(Member innerCand : ((MemberContainer)classifier).getMembers()) {
			if (innerCand instanceof ConcreteClassifier) {
				String newClassName = className + JavaUniquePathConstructor.CLASSIFIER_SEPARATOR + JavaUtil.getName(innerCand);
				registerClassifier(packageName, newClassName, uri);
				registerInnerClassifiers((ConcreteClassifier)innerCand, packageName, newClassName, uri);
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
			
			uriMap.remove(logicalUri);
		}
	}
	
	public EList<ConcreteClassifier> getInnnerClassifiers(ConcreteClassifier container) {
		if(container == null) {
			return ECollections.emptyEList();
		}
		if (container.eIsProxy()) {
			 String uriString = ((InternalEObject)container).eProxyURI().trimFragment().toString();
			 String fullName = uriString.substring(JavaUniquePathConstructor.JAVA_CLASSIFIER_PATHMAP.length(), 
					 uriString.length() - ".java".length()) + "$";
			 return getClassifiers(fullName, "*");
		}
		else {
			String suffix = "";
			ConcreteClassifier containingClass = container;
			while (containingClass.eContainer() instanceof ConcreteClassifier) {
				containingClass = (ConcreteClassifier) containingClass.eContainer();
				suffix = JavaUtil.getName(containingClass) + JavaUniquePathConstructor.CLASSIFIER_SEPARATOR + suffix;
			}
			if (containingClass.eContainer() instanceof CompilationUnit) {
				CompilationUnit compilationUnit = (CompilationUnit) containingClass.eContainer();
			    String fullName = getContainerNameFromNamespace(compilationUnit) + suffix + 
			    	JavaUtil.getName(container) + JavaUniquePathConstructor.CLASSIFIER_SEPARATOR;
			    return getClassifiers(fullName, "*");
			}
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
		int idx = classifierQuery.lastIndexOf("$");
		if (idx >= 0) {
			packageName = packageName + classifierQuery.substring(0, idx + 1);
			classifierQuery = classifierQuery.substring(idx + 1);
		}
		
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
					JavaUtil.setName((Class)classifierProxy, JavaUniquePathConstructor.getSimpleClassName(fullQualifiedName));
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
		JavaUtil.setName((Class)classifierProxy, JavaUniquePathConstructor.getSimpleClassName(fullQualifiedName));
		return (ConcreteClassifier) classifierProxy;
	}
	
	public boolean isRegistered(String fullQualifiedName) {
		int idx = fullQualifiedName.lastIndexOf(JavaUniquePathConstructor.CLASSIFIER_SEPARATOR);
		if(idx == -1) {
			idx = fullQualifiedName.lastIndexOf(JavaUniquePathConstructor.PACKAGE_SEPARATOR);
		}
		if(idx == -1) {
			idx = -1;
		}
		String containerName = fullQualifiedName.substring(0, idx + 1);
		String classifierName = fullQualifiedName.substring(idx + 1);
		List<String> containerContent = packageClassifierMap.get(containerName);
		if(containerContent == null) {
			return false;
		}
		return containerContent.contains(classifierName);
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

	public Map<String, List<String>> getPackageClassifierMap() {
		return packageClassifierMap;
	}
	
	
}
