package org.emftext.language.java.resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.apache.bcel.classfile.Utility;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.arrays.ArraysFactory;
import org.emftext.language.java.classifiers.Class;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.classifiers.ClassifiersFactory;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.classifiers.Enumeration;
import org.emftext.language.java.classifiers.Interface;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.containers.ContainersFactory;
import org.emftext.language.java.generics.GenericsFactory;
import org.emftext.language.java.generics.QualifiedTypeArgument;
import org.emftext.language.java.members.Field;
import org.emftext.language.java.members.MemberContainer;
import org.emftext.language.java.members.MembersFactory;
import org.emftext.language.java.members.Method;
import org.emftext.language.java.parameters.Parameter;
import org.emftext.language.java.parameters.ParametersFactory;
import org.emftext.language.java.types.ClassifierReference;
import org.emftext.language.java.types.TypeReference;
import org.emftext.language.java.types.TypesFactory;

/**
 * Extends JavaResource to make use of proxy resolving
 * 
 *
 */
public class ClassFileParser {
	
	protected ClassifiersFactory qualifiersFactory = ClassifiersFactory.eINSTANCE;
	protected MembersFactory     membersFactory    = MembersFactory.eINSTANCE;
	protected TypesFactory       typesFactory      = TypesFactory.eINSTANCE;
	protected ParametersFactory  parametersFactory = ParametersFactory.eINSTANCE;
	
	public CompilationUnit parse(InputStream inputStream, String classFileName)
			throws IOException {

		org.apache.bcel.classfile.JavaClass myClass =
			new org.apache.bcel.classfile.ClassParser(
					inputStream, classFileName).parse();
		
		ConcreteClassifier classifier = constructClassifier(myClass);
		CompilationUnit cu = ContainersFactory.eINSTANCE.createCompilationUnit();
		cu.setName(classFileName);
		List<String> namespace = Arrays.asList(myClass.getPackageName().split("\\."));
		cu.getNamespace().addAll(namespace);
		cu.getClassifiers().add(classifier);
		return cu;
	}
	
	protected ConcreteClassifier constructClassifier(org.apache.bcel.classfile.JavaClass clazz) {
		ConcreteClassifier emfClassifier = null;
		if (clazz.isEnum()) { //check first, because enum is also class
			emfClassifier = qualifiersFactory.createEnumeration();
		}
		else if (clazz.isClass()) {
			emfClassifier = qualifiersFactory.createClass();
		}
		else if (clazz.isInterface()) {
			emfClassifier = qualifiersFactory.createInterface();
		}
		else {
			assert(false);
		}
		
		//super class
		if (clazz.isClass() && !clazz.isEnum()) {
			org.emftext.language.java.classifiers.Class emfClass = 
				(Class) emfClassifier;
			if (clazz.getSuperclassName() != null) {
				QualifiedTypeArgument typeArg = GenericsFactory.eINSTANCE.createQualifiedTypeArgument();
				typeArg.setType(createReferenceToClassifier(clazz.getSuperclassName()));
				emfClass.setExtends(typeArg);
			}
		}
		//interfaces
		for(String ifName : clazz.getInterfaceNames()) {
			QualifiedTypeArgument typeArg = GenericsFactory.eINSTANCE.createQualifiedTypeArgument();
			typeArg.setType(createReferenceToClassifier(ifName));
			if (clazz.isEnum()) { //check first, because enum is also class
				((Enumeration)emfClassifier).getImplements().add(typeArg); 
			}
			else if (clazz.isClass()) {
				((Class)emfClassifier).getImplements().add(typeArg);
			}
			else if (clazz.isInterface()) {
				((Interface)emfClassifier).getExtends().add(typeArg);
			}
		}
		
		String className = clazz.getClassName();
		int idx = clazz.getClassName().lastIndexOf("$");
		if (idx >= 0) {
			className = className.substring(idx + 1);
		}
		else {
			idx = clazz.getClassName().lastIndexOf(".");
			if (idx >= 0) {
				className = className.substring(idx + 1);
			}
		}
		
		emfClassifier.setName(className);
		
		for(org.apache.bcel.classfile.Field filed : clazz.getFields()) {
			((MemberContainer) emfClassifier).getMembers().add(constructField(filed));
		}
		for(org.apache.bcel.classfile.Method method : clazz.getMethods()) {
			if(!method.isSynthetic()) {
				Method emfMethod = constructMethod(method, false);
				//If the last parameter has an array type it could also be a variable length parameter.
				//The java compiler compiles variable length arguments down to array arguments.
				//Then the arguments are wrapped into an array. As far as I know, there is no
				//way to tell the difference from byte code. Therefore we create two versions
				//of the method: one with array argument and one with variable length
				if (!emfMethod.getParameters().isEmpty() && 
						!emfMethod.getParameters().get(
								emfMethod.getParameters().size()-1).getArrayDimensionsBefore().isEmpty()) {
					
					Method emfMethod2 = constructMethod(method, true);
					((MemberContainer) emfClassifier).getMembers().add(emfMethod2);
				}
				else {
					((MemberContainer) emfClassifier).getMembers().add(emfMethod);
				}
			}

		}
		return emfClassifier;
	}
	
	protected Method constructMethod(org.apache.bcel.classfile.Method method, boolean withVaraibleLength) {
		Method emfMethod = membersFactory.createMethod();
		emfMethod.setName(method.getName());
		
		String signature = method.getReturnType().getSignature();
		TypeReference typeRef = createReferenceToType(signature);
		emfMethod.setType(typeRef);
		
		int arrayDimension = getArrayDimension(signature);
        for(int i = 0; i < arrayDimension; i++) {
        	emfMethod.getArrayDimensionsBefore().add(
        			ArraysFactory.eINSTANCE.createArrayDimension());
        }
		
		for(int i = 0; i < method.getArgumentTypes().length; i++) {
			org.apache.bcel.generic.Type argType = method.getArgumentTypes()[i];
			if (i == method.getArgumentTypes().length - 1 && withVaraibleLength) {
				emfMethod.getParameters().add(
						constructVariableLengthParameter(argType));	
			}
			else {
				emfMethod.getParameters().add(
						constructParameter(argType));		
			}
		}
		
		return emfMethod;
	}
	
	protected Parameter constructParameter(org.apache.bcel.generic.Type attrType) {
		Parameter emfParameter = parametersFactory.createOrdinaryParameter();
		String signature = attrType.getSignature();
		TypeReference emfTypeReference = createReferenceToType(signature);
		emfParameter.setType(emfTypeReference);
		
        int arrayDimension = getArrayDimension(signature);
        for(int i = 0; i < arrayDimension; i++) {
        	emfParameter.getArrayDimensionsBefore().add(
        			ArraysFactory.eINSTANCE.createArrayDimension());
        }
		
		return emfParameter;
	}
	
	protected Parameter constructVariableLengthParameter(org.apache.bcel.generic.Type attrType) {
		Parameter emfParameter = parametersFactory.createVariableLengthParameter();
		String signature = attrType.getSignature();
		TypeReference emfTypeReference = createReferenceToType(signature);
		emfParameter.setType(emfTypeReference);
		return emfParameter;
	}
	
	protected Field constructField(org.apache.bcel.classfile.Field field) {
		Field emfField = membersFactory.createField();
		emfField.setName(field.getName());
		String signature = field.getType().getSignature();
		TypeReference typeRef = createReferenceToType(signature);
		emfField.setType(typeRef);
		
		int arrayDimension = getArrayDimension(signature);
        for(int i = 0; i < arrayDimension; i++) {
        	emfField.getArrayDimensionsBefore().add(
        			ArraysFactory.eINSTANCE.createArrayDimension());
        }
		
		return emfField;
	}

	private TypeReference createReferenceToType(String signature) { 
		TypeReference emfTypeReference = null;

		while(signature.startsWith("[")) {
			signature = signature.substring(1);
		}
		
        switch (signature.charAt(0)) {
	        case 'B':
	            emfTypeReference = TypesFactory.eINSTANCE.createByte();
	            break;
	        case 'C':
	            emfTypeReference = TypesFactory.eINSTANCE.createChar();
	            break;
	        case 'D':
	            emfTypeReference = TypesFactory.eINSTANCE.createDouble();
	            break;
	        case 'F':
	            emfTypeReference = TypesFactory.eINSTANCE.createFloat();
	            break;
	        case 'I':
	            emfTypeReference = TypesFactory.eINSTANCE.createInt();
	            break;
	        case 'J':
	            emfTypeReference = TypesFactory.eINSTANCE.createLong();
	            break;
	        case 'L': { 
	        	// Full class name
	            String fullClassName = Utility.signatureToString(signature,false);
	        	emfTypeReference = createReferenceToClassifier(fullClassName);
	        	break;
	        }
	        case 'S':
	            emfTypeReference = TypesFactory.eINSTANCE.createShort();
	            break;
	        case 'Z':
	            emfTypeReference = TypesFactory.eINSTANCE.createBoolean();
	            break;
	        case 'V':
	            emfTypeReference = TypesFactory.eINSTANCE.createVoid();
	            break;
        }

        return emfTypeReference;
	}
	
	private TypeReference createReferenceToClassifier(String fullClassifierName) { 
		Classifier classifier = JavaClasspath.INSTANCE.getClassifier(fullClassifierName);
		ClassifierReference classifierReference = 
			TypesFactory.eINSTANCE.createClassifierReference();
		classifierReference.setTarget(classifier);
		return classifierReference;
	}
	
	private int getArrayDimension(String signature) {
		int arrayDimension = 0;
		while(signature.startsWith("[")) {
			signature = signature.substring(1);
			arrayDimension++;
		}
		return arrayDimension;
	}
	
}
