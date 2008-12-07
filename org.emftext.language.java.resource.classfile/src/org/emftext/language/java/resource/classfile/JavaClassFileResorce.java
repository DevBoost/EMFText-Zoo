package org.emftext.language.java.resource.classfile;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.apache.bcel.classfile.Attribute;
import org.apache.bcel.classfile.ClassParser;
import org.apache.bcel.classfile.JavaClass;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.emftext.language.java.Classifier;
import org.emftext.language.java.CompilationUnit;
import org.emftext.language.java.Field;
import org.emftext.language.java.JavaFactory;
import org.emftext.language.java.Method;
import org.emftext.language.java.Parameter;
import org.emftext.language.java.TypeReferenceSequence;

public class JavaClassFileResorce extends ResourceImpl {

	//one resource per type
	protected JavaClass myClass;
	
	protected JavaFactory javaFactory = JavaFactory.eINSTANCE;
	
	public JavaClassFileResorce(URI uri) {
		super(uri);
	}
	
	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options)
			throws IOException {

		myClass =
			new ClassParser(inputStream, getURI().lastSegment()).parse();
		
		Classifier classifier = constructClassifier(myClass);
		CompilationUnit cu = javaFactory.createCompilationUnit();
		cu.getClassifiers().add(classifier);
		getContents().add(cu);
	}

	@Override
	protected void doSave(OutputStream outputStream, Map<?, ?> options)
			throws IOException {
		// can not be saved
	}

	protected Classifier constructClassifier(JavaClass clazz) {
		org.emftext.language.java.Class classifier = javaFactory.createClass(); //TODO This is not always a class
		classifier.setName(clazz.getClassName().substring(clazz.getClassName().lastIndexOf(".") + 1));
		
		for(org.apache.bcel.classfile.Field filed : clazz.getFields()) {
			classifier.getMembers().add(constructField(filed));
		}
		for(org.apache.bcel.classfile.Method method : clazz.getMethods()) {
			classifier.getMembers().add(constructMethod(method));
		}

		//TODO set the types of all Methods and fields, construct first and set during init, or use proxies?
		
		return classifier;
	}
	
	protected Method constructMethod(org.apache.bcel.classfile.Method method) {
		Method emfMethod = javaFactory.createMethod();
		emfMethod.setName(method.getName());
		for(Attribute a : method.getAttributes()) {
			emfMethod.getParameters().add(constructParameter(a));
		}
		return emfMethod;
	}
	
	protected Parameter constructParameter(Attribute attr) {
		org.emftext.language.java.Parameter param = javaFactory.createOrdinaryParameter();
		//
		//TODO type...
		return param;
	}

	protected Field constructField(org.apache.bcel.classfile.Field field) {
		Field emfFieled = javaFactory.createField();
		emfFieled.setName(field.getName());
		TypeReferenceSequence typeRef = javaFactory.createTypeReferenceSequence();
		//TODO create other elements of ref chain (extract in extra method and reuse for methods and parameters)
		emfFieled.setType(typeRef);
		return emfFieled;
	}
	
	
}
