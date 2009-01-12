package org.emftext.language.java.resource.classfile;

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
import org.emftext.language.java.references.ParameterizedPackageOrClassifierReference;
import org.emftext.language.java.references.ReferencesFactory;
import org.emftext.language.java.resource.java.JavaResourceImpl;
import org.emftext.language.java.types.TypeReference;
import org.emftext.language.java.types.TypeReferenceSequence;
import org.emftext.language.java.types.TypesFactory;

/**
 * Extends JavaResource to make use of proxy resolving
 * 
 * @author jj2
 *
 */
public class JavaClassFileResorceImpl extends JavaResourceImpl {

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
		
		String className = clazz.getClassName().substring( + 1);
		int idx = clazz.getClassName().lastIndexOf("$");
		if (idx >= 0) {
			className = className.substring(idx);
		}
		else {
			idx = clazz.getClassName().lastIndexOf(".");
			if (idx >= 0) {
				className = className.substring(idx);
			}
		}
		
		((NamedElement)emfClassifier).setName(className);
		
		for(org.apache.bcel.classfile.Field filed : clazz.getFields()) {
			((MemberContainer) emfClassifier).getMembers().add(constructField(filed));
		}
		for(org.apache.bcel.classfile.Method method : clazz.getMethods()) {
			((MemberContainer) emfClassifier).getMembers().add(constructMethod(method));
		}
		
		return emfClassifier;
	}
	
	protected Method constructMethod(org.apache.bcel.classfile.Method method) {
		Method emfMethod = membersFactory.createMethod();
		emfMethod.setName(method.getName());
		
		for(org.apache.bcel.generic.Type argType : method.getArgumentTypes()) {
			emfMethod.getParameters().add(
					constructParameter(argType));
		}
		return emfMethod;
	}
	
	protected Parameter constructParameter(org.apache.bcel.generic.Type attrType) {
		Parameter emfParameter = parametersFactory.createOrdinaryParameter();
		TypeReference emfTypeReference = null;

		String signature = attrType.getSignature();
		int arrayDimension = 0;
		while(signature.startsWith("[")) {
			signature = signature.substring(1);
			arrayDimension++;
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
        
        for(int i = 0; i < arrayDimension; i++) {
        	emfParameter.getArrayDimensions().add(
        			ArraysFactory.eINSTANCE.createArrayDimension());
        }
		emfParameter.setType(emfTypeReference);
		return emfParameter;
	}

	private TypeReference createReferenceToClassifier(String fullClassifierName) { 
		TypeReferenceSequence typeRefSequence = TypesFactory.eINSTANCE.createTypeReferenceSequence();
		Classifier classifier = JavaClasspath.INSTANCE.getClassifier(fullClassifierName);
		ParameterizedPackageOrClassifierReference classifierReference = 
			ReferencesFactory.eINSTANCE.createParameterizedPackageOrClassifierReference();
		classifierReference.setTarget(classifier);
		typeRefSequence.getParts().add(classifierReference);
		return typeRefSequence;
	}
	

	protected Field constructField(org.apache.bcel.classfile.Field field) {
		Field emfFieled = membersFactory.createField();
		emfFieled.setName(field.getName());
		TypeReferenceSequence typeRef = typesFactory.createTypeReferenceSequence();
		//TODO create other elements of ref chain (extract in extra method and reuse for methods and parameters)
		emfFieled.setType(typeRef);
		return emfFieled;
	}
	
}
