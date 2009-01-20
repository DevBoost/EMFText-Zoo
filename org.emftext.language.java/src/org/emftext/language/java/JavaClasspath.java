package org.emftext.language.java;

import java.io.File;
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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.emftext.language.java.classifiers.Class;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.classifiers.ClassifiersFactory;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.containers.Package;
import org.emftext.language.java.imports.Import;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.members.MemberContainer;
import org.emftext.language.java.types.PackageOrClassifierReference;
import org.emftext.language.java.types.Type;

public class JavaClasspath {

	public static final JavaClasspath INSTANCE = new JavaClasspath();
	
	public final Map<URI, URI> URI_MAP = URIConverter.URI_MAP;

	protected Map<String, List<String>> packageClassifierMap =
		new HashMap<String, List<String>>();
	
	public JavaClasspath() {
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
	
	public void registerClassifierJar(URI jarURI) throws IOException {
			
		ZipFile zipFile = new ZipFile(jarURI.toFileString());
		
		Enumeration<? extends ZipEntry> entries = zipFile.entries();
		while (entries.hasMoreElements()) {
			ZipEntry entry = entries.nextElement();

			if (entry.getName().endsWith(".class") || entry.getName().endsWith(".java")) {
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
				registerClassifier(packageName, className, URI.createURI(uri));
			}
		}
	}
	

	public void registerClassifierSource(CompilationUnit cu, URI uri) {
		String packageName = JavaUniquePathConstructor.packageName(cu);
		
		for(Classifier classifier : cu.getClassifiers()) {
			registerClassifier(
					packageName, classifier.getName(), uri);
			registerInnerClassifiers(
					classifier, packageName, classifier.getName(), uri);
		}
	}
	
	protected void registerInnerClassifiers(Classifier classifier, String packageName, String className, URI uri) {
		for(Member innerCand : ((MemberContainer)classifier).getMembers()) {
			if (innerCand instanceof Classifier) {
				String newClassName = className + JavaUniquePathConstructor.CLASSIFIER_SEPARATOR + innerCand.getName();
				registerClassifier(packageName, newClassName, uri);
				registerInnerClassifiers((Classifier)innerCand, packageName, newClassName, uri);
			}
		}
	}
	
	public void registerClassifier(String packageName, String classifierName, URI uri) {
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
		
		synchronized (packageClassifierMap) {
			if (!packageClassifierMap.containsKey(qualifiedName)) {
				packageClassifierMap.put(qualifiedName, new ArrayList<String>());
			}
			if (!packageClassifierMap.get(qualifiedName).contains(innerName)) {
				packageClassifierMap.get(qualifiedName).add(innerName);
			}
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
			
			if (URI_MAP.containsKey(logicalUri)) {
				//TODO where to put this warning?
				System.out.println("[JaMoPP] WARNING: Two versions of " + fullName + 
						"\n[JaMoPP]   1) " + URI_MAP.get(logicalUri) +
						"\n[JaMoPP]   2) " + uri +
						"\n[JaMoPP] Version 1) will be ignored!");
			}
			
			URI_MAP.put(logicalUri, uri);
		}
	}
	
	private EList<Classifier> javaLangPackage = null;
	
	
	public EList<Classifier> getClassifiers(Import theImport, String packageName) {
		String fullQualifiedName = getQualifiedNameFromImport(theImport);
		
		String fullQualifiedPackageName = fullQualifiedName + packageName + ".";
		EList<Classifier> result = getClassifiers(fullQualifiedPackageName, "*");
		
		if (result.isEmpty()) {
			//try as "Class" because the "package" can indeed be a "class"
			String fullQualifiedClassPackageName = fullQualifiedName + packageName + "$";
			result = getClassifiers(fullQualifiedClassPackageName, "*");
		}
		return result;
	}
	
	/**
	 * Constructs a list of proxies that point at the classifiers of the given package
	 * 
	 * @param packageName
	 * @return
	 */
	public EList<Classifier> getClassifiers(String packageName, String classifierQuery) {
		if (!packageName.endsWith(JavaUniquePathConstructor.PACKAGE_SEPARATOR) &&
				!packageName.endsWith(JavaUniquePathConstructor.CLASSIFIER_SEPARATOR)) {
			packageName = packageName + JavaUniquePathConstructor.PACKAGE_SEPARATOR;
		}
		
		EList<Classifier> resultList = new BasicEList<Classifier>();

		synchronized (packageClassifierMap) {
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
					resultList.add((Classifier) classifierProxy);
				}
			}
		}
		
		return resultList;
	}
	
	/**
	 * 
	 * @param theImport that points directly at the classifier
	 * @return
	 */
	public Classifier getClassifier(Import theImport) {
		String fullQualifiedName = getQualifiedNameFromImport(theImport);
		//cut the trailing separator
		fullQualifiedName = fullQualifiedName.substring(0,fullQualifiedName.length() -1);
		
		return getClassifier(fullQualifiedName);
	}
	
	/**
	 * 
	 * @param theImport that points at the package
	 * @param classifierName the name of the classifier in the given package
	 * @return
	 */
	public Classifier getClassifier(Import theImport, String classifierName) {
		String fullQualifiedName = getQualifiedNameFromImport(theImport);
		fullQualifiedName = fullQualifiedName + classifierName;
		
		return getClassifier(fullQualifiedName);
	}

	private String getQualifiedNameFromImport(Import theImport) {
		String fullQualifiedName = "";
		for(PackageOrClassifierReference ref : theImport.getParts()) {
			if (!ref.getTarget().eIsProxy()) {
				Type type = ref.getTarget();
				if (type.eIsProxy()) {
					type = ref.getTarget();
				}
	
				if (type instanceof Package) {
					fullQualifiedName = fullQualifiedName + ((Package) type).getName() + 
						JavaUniquePathConstructor.PACKAGE_SEPARATOR;
				}
				else if (type instanceof Classifier) {
					fullQualifiedName = fullQualifiedName + ((Classifier) type).getName() + 
						JavaUniquePathConstructor.CLASSIFIER_SEPARATOR;
				}
				else {
					assert(false);
				}
			}
		}
		
		return fullQualifiedName;
	}
	
	public Classifier getClassifier(String fullQualifiedName) {
		InternalEObject classifierProxy = (InternalEObject) ClassifiersFactory.eINSTANCE.createClass();
		URI proxyURI = JavaUniquePathConstructor.getClassifierURI(fullQualifiedName);
		classifierProxy.eSetProxyURI(proxyURI);
		//set also the name to reason about it without resolving the proxy
		((Class)classifierProxy).setName(JavaUniquePathConstructor.getSimpleClassName(fullQualifiedName));
		return (Classifier) classifierProxy;
	}
	
	public EList<Classifier> getDefaultImports(String packageName) {
		EList<Classifier> resultList = new BasicEList<Classifier>();
		//my package
		resultList.addAll(getClassifiers(packageName + ".", "*"));

		//java.lang package	
		if (javaLangPackage == null) {
			javaLangPackage = new BasicEList<Classifier>();
			javaLangPackage.addAll(getClassifiers("java.lang.", "*"));
		}
		
		resultList.addAll(javaLangPackage);
		
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
		
		synchronized (packageClassifierMap) {
			if (packageClassifierMap.containsKey(qualifiedName)) {
				packageClassifierMap.get(qualifiedName).remove(innerName);
			}
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
