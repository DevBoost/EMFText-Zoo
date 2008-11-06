package org.reuseware.emftextedit.language.java.jdtconnector;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.core.ElementChangedEvent;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IElementChangedListener;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaElementDelta;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.reuseware.emftextedit.language.java.Classifier;
import org.reuseware.emftextedit.language.java.Field;
import org.reuseware.emftextedit.language.java.JavaFactory;
import org.reuseware.emftextedit.language.java.Method;
import org.reuseware.emftextedit.language.java.Package;
import org.reuseware.emftextedit.language.java.TypeReferenceSequence;

public class JavaEMFModelUpdateListener implements IElementChangedListener {

	public static final String JAVA_PATHMAP = "pathmap://java/";
	
	private ResourceSet javaResourceSet = new ResourceSetImpl();
	private Package defaultPackage;
	
	protected JavaFactory javaFactory = JavaFactory.eINSTANCE;
	
	public JavaEMFModelUpdateListener() {
		defaultPackage = javaFactory.createPackage();
		defaultPackage.setName("default"); 
	}
	
	public void elementChanged(ElementChangedEvent event) {
		for(IJavaElementDelta delta : event.getDelta().getAffectedChildren()) {
			IJavaProject project = (IJavaProject) delta.getElement();
			
			try {
				for(IPackageFragmentRoot pRoot : project.getPackageFragmentRoots()) {
					for(IJavaElement pFragment : pRoot.getChildren()) {
						if (pFragment instanceof IPackageFragment) {
							buildModel((IPackageFragment) pFragment);
							
						}
					}
				}
			} catch (JavaModelException e) {
				e.printStackTrace();
			}
		}

	}

	protected void buildModel(IPackageFragment pFragment) throws JavaModelException {
		Package emfPackage = ensurePackageExistence(pFragment.getElementName());
		
		for(ICompilationUnit cu : pFragment.getCompilationUnits()) {
			for(IType type : cu.getAllTypes()) {
				Classifier emfClassifier = ensureTypeExists(type, emfPackage);
			}
		}
	}
	
	protected Package ensurePackageExistence(String packageName) {
		String[] subPackageNames = packageName.split(".");
		Package parentPackage = defaultPackage;
		
		for(String name : subPackageNames) {
			parentPackage = ensureSubPackageExistence(name, parentPackage);
		}
		
		return parentPackage;
	}
	
	protected Package ensureSubPackageExistence(String name, Package parentPackage) {
		for(Package subPackage : parentPackage.getSubPackages()) {
			if(subPackage.getName().equals(name)) {
				return subPackage;
			}
		}
		
		Package subPackage = javaFactory.createPackage();
		subPackage.setName(name);
		parentPackage.getSubPackages().add(subPackage);
		
		return subPackage;
	}
	
	protected Classifier ensureTypeExists(IType type, Package p) throws JavaModelException {
		String typeName = type.getElementName();
		
		for(Classifier classifier : p.getClassifiers()) {
			if (classifier.getName().equals(typeName)) {
				return classifier;
			}
		}
		
		Classifier classifier = constructClassifier(type);
		p.getClassifiers().add(classifier);
		
		return classifier;
	}
	
	protected Classifier constructClassifier(IType type) throws JavaModelException {
		org.reuseware.emftextedit.language.java.Class classifier = javaFactory.createClass(); //TODO This is not always a class
		classifier.setName(type.getElementName());
		
		for(IField filed : type.getFields()) {
			classifier.getMembers().add(constructField(filed));
		}
		for(IMethod method : type.getMethods()) {
			classifier.getMembers().add(constructMethod(method));
		}

		//TODO set the types of all Methods and fields, construct first and set during init, or use proxies?
		
		return classifier;
	}
	
	protected Method constructMethod(IMethod method) throws JavaModelException {
		Method emfMethod = javaFactory.createMethod();
		emfMethod.setName(method.getElementName());
		for(String paramName : method.getParameterNames()) {
			emfMethod.getParameters().add(constructParameter(paramName));
		}
		return emfMethod;
	}
	
	protected org.reuseware.emftextedit.language.java.Parameter constructParameter(String paramName) {
		org.reuseware.emftextedit.language.java.Parameter param = javaFactory.createOrdinaryParameter();
		param.setName(paramName);
		//TODO type...
		return param;
	}

	protected Field constructField(IField field) {
		Field emfFieled = javaFactory.createField();
		emfFieled.setName(field.getElementName());
		TypeReferenceSequence typeRef = javaFactory.createTypeReferenceSequence();
		//TODO create other elements of ref chain (extract in extra method and reuse for methods and parameters)
		emfFieled.setType(typeRef);
		return emfFieled;
	}

}
