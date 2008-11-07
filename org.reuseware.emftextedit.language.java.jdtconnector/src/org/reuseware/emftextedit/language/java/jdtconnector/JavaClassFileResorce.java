package org.reuseware.emftextedit.language.java.jdtconnector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.reuseware.emftextedit.language.java.Classifier;
import org.reuseware.emftextedit.language.java.Field;
import org.reuseware.emftextedit.language.java.JavaFactory;
import org.reuseware.emftextedit.language.java.Method;
import org.reuseware.emftextedit.language.java.TypeReferenceSequence;

public class JavaClassFileResorce extends ResourceImpl {

	//one resource per type
	protected IType myType;
	
	protected JavaFactory javaFactory = JavaFactory.eINSTANCE;
	
	public JavaClassFileResorce(URI uri, IType type) {
		super(uri);
		myType = type;
	}
	
	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options)
			throws IOException {

		try {
			Classifier classifier = constructClassifier(myType);
			getContents().add(classifier);
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doSave(OutputStream outputStream, Map<?, ?> options)
			throws IOException {
		// can not be saved
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
