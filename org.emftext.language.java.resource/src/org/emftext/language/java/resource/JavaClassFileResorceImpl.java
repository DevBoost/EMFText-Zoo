package org.emftext.language.java.resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.apache.bcel.classfile.Utility;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.JavaUniquePathConstructor;
import org.emftext.language.java.arrays.ArraysFactory;
import org.emftext.language.java.classifiers.Class;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.classifiers.ClassifiersFactory;
import org.emftext.language.java.classifiers.Enumeration;
import org.emftext.language.java.classifiers.Interface;
import org.emftext.language.java.commons.NamedElement;
import org.emftext.language.java.generics.GenericsFactory;
import org.emftext.language.java.generics.QualifiedTypeArgument;
import org.emftext.language.java.members.Field;
import org.emftext.language.java.members.MemberContainer;
import org.emftext.language.java.members.MembersFactory;
import org.emftext.language.java.members.Method;
import org.emftext.language.java.parameters.Parameter;
import org.emftext.language.java.parameters.ParametersFactory;
import org.emftext.language.java.resource.java.JavaResource;
import org.emftext.language.java.types.ClassifierReference;
import org.emftext.language.java.types.TypeReference;
import org.emftext.language.java.types.TypesFactory;

/**
 * Extends JavaResource to make use of proxy resolving
 * 
 *
 */
public class JavaClassFileResorceImpl extends JavaResource {

	//one resource per type
	protected org.apache.bcel.classfile.JavaClass myClass;
	
	protected ClassifiersFactory qualifiersFactory = ClassifiersFactory.eINSTANCE;
	protected MembersFactory membersFactory = MembersFactory.eINSTANCE;
	protected TypesFactory typesFactory = TypesFactory.eINSTANCE;

	private ParametersFactory parametersFactory = ParametersFactory.eINSTANCE;
	
	public JavaClassFileResorceImpl(URI uri) {
		super(uri);
	}
	
	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options)
			throws IOException {

		myClass =
			new org.apache.bcel.classfile.ClassParser(
					inputStream, getURI().lastSegment()).parse();
		
		Classifier classifier = constructClassifier(myClass);
		getContents().add(classifier);
	}

	@Override
	protected void doSave(OutputStream outputStream, Map<?, ?> options)
			throws IOException {
		// can not be saved
	}

	@Override
	public EObject getEObject(String id) {
		EObject result = null;
		if (id.startsWith(JavaUniquePathConstructor.CLASSIFIERS_ROOT_PATH_PREFIX)) {
			if (!getContents().isEmpty()) {
				//in a class file, there is always only one classifier as root element: 
				//id path can be ignored
				return contents.get(0);
			}
			else {
				assert(false);
			}
		}
		else {
			result = super.getEObject(id);;
		}
		return result;
	}
	
	protected Classifier constructClassifier(org.apache.bcel.classfile.JavaClass clazz) {
		Classifier emfClassifier = null;
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
		
		((NamedElement)emfClassifier).setName(className);
		
		for(org.apache.bcel.classfile.Field filed : clazz.getFields()) {
			((MemberContainer) emfClassifier).getMembers().add(constructField(filed));
		}
		for(org.apache.bcel.classfile.Method method : clazz.getMethods()) {
			if(!method.isSynthetic()) {
				Method emfMethod = constructMethod(method, false);
				((MemberContainer) emfClassifier).getMembers().add(emfMethod);
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
