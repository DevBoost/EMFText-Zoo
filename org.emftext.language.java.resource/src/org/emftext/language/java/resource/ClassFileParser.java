package org.emftext.language.java.resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.apache.bcel.classfile.Attribute;
import org.apache.bcel.classfile.Utility;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
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
import org.emftext.language.java.generics.TypeParameter;
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
		cu.getNamespaces().addAll(namespace);
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
		else if (clazz.isAnnotation()) {
			emfClassifier = qualifiersFactory.createAnnotation();
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
 			
		for(Attribute a : clazz.getAttributes()){
			String signature = a.toString();
			if(signature.startsWith("Signature(")) {
				EList<TypeParameter> tpList = constructTypeParameters(signature);
				emfClassifier.getTypeParameters().addAll(tpList);
			}
		}
	
		for(org.apache.bcel.classfile.Field filed : clazz.getFields()) {
			((MemberContainer) emfClassifier).getMembers().add(constructField(filed));
		}
		for(org.apache.bcel.classfile.Method method : clazz.getMethods()) {
			if(!method.isSynthetic()) {
				Method emfMethod = constructMethod(method, emfClassifier, false);
				//If the last parameter has an array type it could also be a variable length parameter.
				//The java compiler compiles variable length arguments down to array arguments.
				//Then the arguments are wrapped into an array. As far as I know, there is no
				//way to tell the difference from byte code. Therefore we create two versions
				//of the method: one with array argument and one with variable length
				if (!emfMethod.getParameters().isEmpty() && 
						!emfMethod.getParameters().get(
								emfMethod.getParameters().size()-1).getArrayDimensionsBefore().isEmpty()) {
					
					Method emfMethod2 = constructMethod(method, emfClassifier, true);
					((MemberContainer) emfClassifier).getMembers().add(emfMethod2);
				}
				else {
					((MemberContainer) emfClassifier).getMembers().add(emfMethod);
				}
			}

		}

		if(clazz.getClassName().equals("java.lang.annotation.Annotation")) {
			Method valueMethod = MembersFactory.eINSTANCE.createMethod();
			valueMethod.setName("value");
			valueMethod.setType(createReferenceToClassifier("java.lang.String"));
			emfClassifier.getMembers().add(valueMethod);
			
		}
		
		return emfClassifier;
	}
	
	protected Method constructMethod(org.apache.bcel.classfile.Method method, ConcreteClassifier emfClassifier, boolean withVaraibleLength) {
		Method emfMethod = membersFactory.createMethod();
		emfMethod.setName(method.getName());
		
		String signature = method.getReturnType().getSignature();
		String plainSignature = "";
		
		for(Attribute a : method.getAttributes()){
			String s = a.toString();
			if(s.startsWith("Signature(")) {
				plainSignature = s;
			}
		}
		
		emfMethod.getTypeParameters().addAll(constructTypeParameters(plainSignature));
		
		TypeReference typeRef = createReferenceToType(signature);
		TypeReference typeParamRef = constructReturnTypeParameterReference(plainSignature, emfMethod, emfClassifier);
		if(typeParamRef != null) {
			((TypeParameter)((ClassifierReference)typeParamRef).getTarget()).getExtendTypes().add(typeRef);
			typeRef = typeParamRef;
		}

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
		
		EList<TypeParameter> tpList = constructMethodTypeParameterReferences(plainSignature, emfMethod, emfClassifier);
		for(int i = 0; i<tpList.size(); i++) {
			TypeParameter typeParameter = tpList.get(i);
			if(typeParameter != null) {
				TypeReference typeReference = emfMethod.getParameters().get(i).getType();
				if(typeReference instanceof ClassifierReference) {
					//replace with parameter there is one
					typeParameter.getExtendTypes().add(typeReference);
					((ClassifierReference) typeReference).setTarget(typeParameter);
				}
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
	
	protected ClassifierReference constructReturnTypeParameterReference(String signature, Method method, ConcreteClassifier emfClassifier) {
		int idx = signature.indexOf(")T");
		if(idx == -1) {
			return null;
		}
		signature = signature.substring(idx + 2);
		
		idx = signature.indexOf(";");
		String name = signature.substring(0,idx);
		
		TypeParameter typeParameter =  null;
		for(TypeParameter cand : method.getTypeParameters()) {
			if(cand.getName().equals(name)) {
				typeParameter = cand;
			}
		}
		if (typeParameter == null) {
			for(TypeParameter cand : emfClassifier.getTypeParameters()) {
				if(cand.getName().equals(name)) {
					typeParameter = cand;
				}
			}
		}
		
		if(typeParameter == null) {
			//FIXME this happens, because type parameter can also be declared on methods.
			//These also need to be contructed and can then be referred here!
			return null;
		}
		
		ClassifierReference classifierReference = 
			TypesFactory.eINSTANCE.createClassifierReference();
		classifierReference.setTarget(typeParameter);
		
		return classifierReference;
	}
	
	protected EList<TypeParameter> constructMethodTypeParameterReferences(String signature, Method method, ConcreteClassifier emfClassifier) {
		EList<TypeParameter> result = new BasicEList<TypeParameter>();
		
		int idx1 = signature.indexOf("((");
		if (idx1 == -1) {
			idx1 = signature.indexOf(">(");	
		}
		int idx2 = signature.indexOf(")");
		
		if(idx1 == -1 || idx2 == -1) {
			return result;
		}
		
		signature = signature.substring(idx1 + 2, idx2);
		
		//cut away all the inner type arguments
		while(signature.contains("<")) {
			int idx = signature.indexOf("<");
			String start = signature.substring(0, idx);
			String end = signature.substring(idx + 1);
			int bracketCount = 1;
			while (bracketCount > 0) {
				if(end.startsWith("<")) {
					bracketCount++;
				}
				if(end.startsWith(">")) {
					bracketCount--;
				}
				end = end.substring(1,end.length());
			}
			signature = start + end;
		}
		
		while(signature.contains(";")) {
			int idx = signature.indexOf(";");
			if (signature.startsWith("T")) {
				String name = signature.substring(1,idx);
				TypeParameter typeParameter = null;
				for(TypeParameter cand : method.getTypeParameters()) {
					if(cand.getName().equals(name)) {
						typeParameter = cand;
					}
				}
				if (typeParameter == null) {
					for(TypeParameter cand : emfClassifier.getTypeParameters()) {
						if(cand.getName().equals(name)) {
							typeParameter = cand;
						}
					}
				}
				if(typeParameter == null) {
					//FIXME this happens, because type parameter can also be declared on methods.
					//These also need to be contructed and can then be referred here!
					return null;
				}
				result.add(typeParameter);
			}
			else {
				result.add(null);
			}
			
			signature = signature.substring(signature.indexOf(";") + 1);
		}
		
		return result;
	}
	
	protected EList<TypeParameter> constructTypeParameters(String signature) {
		EList<TypeParameter> result = new BasicEList<TypeParameter>();
		if(signature.contains("((") || !signature.contains("<")) {
			//method without parameter
			return result;
		}
		signature = signature.substring(signature.indexOf("<") + 1);
		int endIdx = signature.indexOf(">(");
		if (endIdx > 0) {
			signature = signature.substring(0,endIdx);
		}
		
		while(signature.contains(":")) {
			int idx = signature.indexOf(":");
			String name = signature.substring(0,idx);
			if (!name.equals("")) {
				TypeParameter typeParameter = GenericsFactory.eINSTANCE.createTypeParameter();
				typeParameter.setName(name);
				result.add(typeParameter);				
			}
			signature = signature.substring(idx + 1);
			
			int sepIdx = signature.indexOf(";");
			int colonIdx = signature.indexOf(":");
			while(sepIdx < colonIdx && sepIdx > 0) {
				signature = signature.substring(sepIdx + 1);
				sepIdx = signature.indexOf(";");
				colonIdx = signature.indexOf(":");
			}
			
			
		}
		
		return result;
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
