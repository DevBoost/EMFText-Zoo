package org.emftext.language.java.closures.resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.classifiers.AnonymousClass;
import org.emftext.language.java.classifiers.ClassifiersFactory;
import org.emftext.language.java.classifiers.Interface;
import org.emftext.language.java.closures.AbstractClosure;
import org.emftext.language.java.closures.AbstractClosureCall;
import org.emftext.language.java.closures.Closure;
import org.emftext.language.java.closures.ClosureCall;
import org.emftext.language.java.closures.ClosuresPackage;
import org.emftext.language.java.closures.ParameterClosureAssignment;
import org.emftext.language.java.closures.resource.closure.IClosureOptionProvider;
import org.emftext.language.java.closures.resource.closure.IClosureOptions;
import org.emftext.language.java.closures.resource.closure.IClosureResourcePostProcessor;
import org.emftext.language.java.closures.resource.closure.IClosureResourcePostProcessorProvider;
import org.emftext.language.java.closures.resource.closure.mopp.ClosureResource;
import org.emftext.language.java.closures.resource.closure.util.ClosureEObjectUtil;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.containers.ContainersFactory;
import org.emftext.language.java.expressions.Expression;
import org.emftext.language.java.instantiations.InstantiationsFactory;
import org.emftext.language.java.instantiations.NewConstructorCall;
import org.emftext.language.java.members.ClassMethod;
import org.emftext.language.java.members.InterfaceMethod;
import org.emftext.language.java.members.MembersFactory;
import org.emftext.language.java.modifiers.ModifiersFactory;
import org.emftext.language.java.parameters.Parameter;
import org.emftext.language.java.references.IdentifierReference;
import org.emftext.language.java.references.MethodCall;
import org.emftext.language.java.references.ReferencesFactory;
import org.emftext.language.java.references.ReferencesPackage;
import org.emftext.language.java.resource.java.mopp.JavaResource;
import org.emftext.language.java.resource.java.util.JavaEObjectUtil;
import org.emftext.language.java.resource.util.JavaPostProcessor;
import org.emftext.language.java.statements.ExpressionStatement;
import org.emftext.language.java.statements.Return;
import org.emftext.language.java.statements.StatementsFactory;
import org.emftext.language.java.types.ClassifierReference;
import org.emftext.language.java.types.NamespaceClassifierReference;
import org.emftext.language.java.types.TypeReference;
import org.emftext.language.java.types.TypesFactory;
import org.emftext.language.java.variables.LocalVariable;

public class ClosuresTransformationPostProcessor 
	implements IClosureOptionProvider,
		IClosureResourcePostProcessor, IClosureResourcePostProcessorProvider {

	
	@Override
	public IClosureResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	@Override
	public void process(final ClosureResource resource) {
		
		Thread workerThread = new Thread(new Runnable(){

			@Override
			public void run() {
				convert(resource);
			}
			
		});
		
		workerThread.start();
		
	}

	private void convert(ClosureResource resource){
		
		URI javaURI = resource.getURI().trimFileExtension().appendFileExtension("java");
		JavaResource javaResource = (JavaResource)resource.getResourceSet().createResource(javaURI);
		
//		try {
//			javaResource.load(null);
//		} catch (IOException e) {}
		
		javaResource.getContents().clear();
		
		javaResource.getContents().addAll(
				EcoreUtil.copyAll(resource.getContents()));
		
		// do normal Java post processing
		JavaPostProcessor jpp = new JavaPostProcessor();
		jpp.processBasic(javaResource);
		
		for (Iterator<EObject> i = javaResource.getAllContents(); i.hasNext(); ) {
			Notifier next = i.next();
			if (next instanceof EObject) {
				InternalEObject nextElement = (InternalEObject) next;
				for (EObject crElement : nextElement.eCrossReferences()) {
					crElement = EcoreUtil.resolve(crElement, javaResource.getResourceSet());
					if (crElement.eIsProxy()) {
						System.out.println("Can not find referenced element in classpath: "
								+ ((InternalEObject) crElement).eProxyURI());
					}
				}	
			}
		}
			
		// get all closures calls
		Collection<ClosureCall> closureCalls = 
			ClosureEObjectUtil.getObjectsByType(javaResource.getAllContents(), ClosuresPackage.eINSTANCE.getClosureCall());

		// get all member closures calls
		Collection<Closure> closures = 
			ClosureEObjectUtil.getObjectsByType(javaResource.getAllContents(), ClosuresPackage.eINSTANCE.getClosure  ());

		List<ClosureCall> memberClosureCalls = new ArrayList<ClosureCall>();
		List<ClosureCall> parameterClosureCalls = new ArrayList<ClosureCall>();
		List<Closure> methodClosures = new ArrayList<Closure>();
		
		for(ClosureCall closureCall : closureCalls){
			AbstractClosure aClosure = closureCall.getClosure();
			if(aClosure instanceof Closure){
				Closure closure = (Closure)aClosure;
				
				if(closure.getValueType()!= null && !closure.getStatements().isEmpty() && closure.getArguments().isEmpty()){
					memberClosureCalls.add(closureCall);
				}
				if(closure.getValueType()!= null && closure.getStatements().isEmpty() && closure.getArguments().isEmpty()){
					parameterClosureCalls.add(closureCall);
				}
			}
		}
		
		// convert member closures
		convertMemberClosureCalls(javaResource, memberClosureCalls);
		
		// convert parameter closures
		convertParameterClosureCall(javaResource, parameterClosureCalls);
		
		for(Closure closure : closures){
			
			if(closure.getValueType()!= null && !closure.getStatements().isEmpty() && !closure.getArguments().isEmpty()){
				methodClosures.add(closure);
			}
		}
		
		// convert method closures
		convertMethodClosure(javaResource, methodClosures);
		
		// get all closures which still are there
		// delete them because they are not called from any closure call
		
		// get all closures calls again
		closureCalls = 
			ClosureEObjectUtil.getObjectsByType(javaResource.getAllContents(), ClosuresPackage.eINSTANCE.getClosureCall());

		// get all member closures calls again
		closures = 
			ClosureEObjectUtil.getObjectsByType(javaResource.getAllContents(), ClosuresPackage.eINSTANCE.getClosure  ());
		
		for(Closure closure : closures){
			EcoreUtil.delete(closure);
		}
		for(ClosureCall closureCall : closureCalls){
			EcoreUtil.delete(closureCall);
		}
		
		// save java new resource
		try {
			javaResource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String firstToUpper(String string){
		
		if(string == null)
			return "";
		if(string.length() == 0)
			return "";
		if(string.length() == 1)
			return string.toUpperCase();
		else
			return string.substring(0, 1).toUpperCase().concat(string.substring(1));
	}
	
	private Resource createInterface(
			AbstractClosure memberClosure, 
			Resource resource,
			String methodName, 
			String closureName, 
			TypeReference valueType){
		
			// new resource for interface
			URI interfaceURI = resource.getURI().trimFileExtension().trimSegments(1);
			interfaceURI = interfaceURI.appendSegment(firstToUpper(closureName)).appendFileExtension("java");
			Resource interfaceResource = resource.getResourceSet().createResource(interfaceURI);
			
			try {
				interfaceResource.load(null);
			} catch (IOException e1) {}
			
			// new interface
			Interface _interface = ClassifiersFactory.eINSTANCE.createInterface();
			_interface.setName(firstToUpper(closureName));
			_interface.getAnnotationsAndModifiers().add(ModifiersFactory.eINSTANCE.createPublic());
			
			// method for interface
			InterfaceMethod interfaceMethod = MembersFactory.eINSTANCE.createInterfaceMethod();
			for(Parameter parameter : memberClosure.getParameters()){
				Parameter parameterCopy = EcoreUtil.copy(parameter);
				interfaceMethod.getParameters().add(parameterCopy);
			}
			interfaceMethod.getAnnotationsAndModifiers().add(ModifiersFactory.eINSTANCE.createPublic());
			interfaceMethod.setName(methodName);
			interfaceMethod.setTypeReference(valueType);
			
			// set method into interface
			_interface.getMembers().add(interfaceMethod);
			
			// set interface into resource
			CompilationUnit compilationUnit = ContainersFactory.eINSTANCE.createCompilationUnit();
			compilationUnit.setName(firstToUpper(closureName));
			compilationUnit.getClassifiers().add(_interface);
			interfaceResource.getContents().clear();
			interfaceResource.getContents().add(compilationUnit);
			
			//namespace
			compilationUnit.getNamespaces().addAll(((CompilationUnit)resource.getContents().get(0)).getNamespaces());
			
			// save
			try {
				interfaceResource.save(null);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return interfaceResource;
			
	}
	
	private MethodCall createAnonymousClass(
			AbstractClosureCall call,
			String methodName,
			String closureName, 
			TypeReference type, 
			AbstractClosure closure, 
			Resource resource){
		
		// create a interface for anonymous class
		Resource interfaceResource = createInterface(closure ,resource, methodName, closureName, type);
		
		// create constructor call for interface
		NewConstructorCall newConstructorCall = InstantiationsFactory.eINSTANCE.createNewConstructorCall();
		NamespaceClassifierReference namespaceClassifierReference = TypesFactory.eINSTANCE.createNamespaceClassifierReference();
		ClassifierReference classifierReference = TypesFactory.eINSTANCE.createClassifierReference();
		
		// set reference to interface
		if(interfaceResource.getContents().isEmpty())
				return null;
		classifierReference.setTarget(((CompilationUnit)interfaceResource.getContents().get(0)).getClassifiers().get(0));
		namespaceClassifierReference.getClassifierReferences().add(classifierReference);
		newConstructorCall.setTypeReference(namespaceClassifierReference);
		
		// create anonymous class with a invoke class method
		AnonymousClass anonymousClass = ClassifiersFactory.eINSTANCE.createAnonymousClass();
		ClassMethod classMethod = MembersFactory.eINSTANCE.createClassMethod();
		for(Parameter parameter : closure.getParameters()){
			Parameter parameterCopy = EcoreUtil.copy(parameter);
			classMethod.getParameters().add(parameterCopy);
		}
		classMethod.getAnnotationsAndModifiers().add(ModifiersFactory.eINSTANCE.createPublic());
		classMethod.setName(methodName);
		classMethod.setTypeReference(type);
		
		// set all statements of closure into new method
		// attention to a return type, put return into method when necessary
		if(type instanceof org.emftext.language.java.types.Void){
			classMethod.getStatements().addAll(closure.getStatements());
		}
		else{
			for(int i=0;i<closure.getStatements().size();i++){
				if(i<closure.getStatements().size()-1)
					classMethod.getStatements().add(EcoreUtil.copy(closure.getStatements().get(i)));
				else{
					Return _return = StatementsFactory.eINSTANCE.createReturn();
					if(closure.getStatements().get(i) instanceof ExpressionStatement){
						ExpressionStatement expression = 
							(ExpressionStatement)closure.getStatements().get(i);
						_return.setReturnValue(expression.getExpression()); 
					}
					
					classMethod.getStatements().add(_return);
				}
			}
		}
		
		// set invoke class method into anonymous class
		anonymousClass.getMembers().add(classMethod);
		
		// method call of inner invoke class method
		MethodCall methodCall = ReferencesFactory.eINSTANCE.createMethodCall();
		methodCall.setTarget(classMethod);
		
		for(Expression expression : call.getArguments()){
			Expression expressionCopy = EcoreUtil.copy(expression);
			methodCall.getArguments().add(expressionCopy);
		}
		
		// set anonymous class and a call of the inner invoke method
		newConstructorCall.setAnonymousClass(anonymousClass);
		newConstructorCall.setNext(methodCall);
	
		if(call.eContainer() instanceof LocalVariable){
			// replace call with new constructor call
			EcoreUtil.replace(call, newConstructorCall);
		}
		else{
			// expression statement is necessary 		
			ExpressionStatement expressionStatement = StatementsFactory.eINSTANCE.createExpressionStatement();
			expressionStatement.setExpression(newConstructorCall);
			
			// replace with new method call
			EcoreUtil.replace(call, expressionStatement);
			
			
		}
		
		
		return methodCall;
	}
	
	private void convertMemberClosureCalls(
			JavaResource resource, List<ClosureCall> memberClosureCalls){
		
		// get all member closures calls
//		Collection<MemberClosureCall> memberClosureCalls = 
//			ClosureEObjectUtil.getObjectsByType(resource.getAllContents(), ClosuresPackage.eINSTANCE.getMemberClosureCall());

		// convert them into method calls
		for (ClosureCall memberClosureCall : memberClosureCalls){
			
			if(memberClosureCall.getClosure() instanceof Closure){
			
				Closure memberClosure = (Closure)memberClosureCall.getClosure();
				
				createAnonymousClass(
						memberClosureCall, 
						memberClosureCall.getMethodName(), 
						memberClosure.getClosureName(), 
						memberClosure.getValueType(), 
						memberClosure, 
						resource);			
			
				EcoreUtil.delete(memberClosure);
			}
		}
	}
	
	private void convertMethodClosure(JavaResource resource, List<Closure> methodClosures){
		
		// get all method closures
//		Collection<MethodClosure> methodClosures = 
//			ClosureEObjectUtil.getObjectsByType(resource.getAllContents(), ClosuresPackage.eINSTANCE.getMethodClosure());

		int iCounter = 1;
		
		for (Closure methodClosure : methodClosures){
			
			String defaultName = "";
			if(methodClosure.getClosureName() == null){
				
				for(int i = iCounter; i>0;i--){
					defaultName += "I";
				}
				iCounter++;
			}
			else
				defaultName = methodClosure.getClosureName();
			
			
			// get class java.lang.Object
//			JavaClasspath javaClasspath = JavaClasspath.get(); 
//			EList<EObject> object = javaClasspath.getClassifiers("java.lang.", "Object");
//			
//			NamespaceClassifierReference namespaceClassifierReference = null;
//			
//			// create namespace classifier reference to Object
//			if(object.size() == 1){
//				namespaceClassifierReference =
//					TypesFactory.eINSTANCE.createNamespaceClassifierReference();
//				ClassifierReference classifierReference =
//					TypesFactory.eINSTANCE.createClassifierReference();
//				
//				classifierReference.setTarget((Classifier)object.get(0));
//				namespaceClassifierReference.getClassifierReferences().add(classifierReference);
//			}
			
			createAnonymousClass(
					methodClosure,
					methodClosure.getMethodName(),
					defaultName, 
					methodClosure.getValueType(), 
					methodClosure, resource);
		}
	}
	
	private void convertParameterClosureCall(
			JavaResource resource, List<ClosureCall> parameterClosureCalls){
		
		// get all method closures
//		Collection<ParameterClosureCall> parameterClosureCalls = 
//			ClosureEObjectUtil.getObjectsByType(resource.getAllContents(), ClosuresPackage.eINSTANCE.getParameterClosureCall());

		for (ClosureCall parameterClosureCall : parameterClosureCalls){
			
			if(parameterClosureCall.getClosure() instanceof Closure){
			
			
				// get referenced parameter closure from parameters of method
				Closure parameterClosure = (Closure)parameterClosureCall.getClosure();
	
				// get super class method of parameter closure
				EObject object = parameterClosure.eContainer();
				ClassMethod classMethod = null;
				
				if(object instanceof ClassMethod){
					classMethod = (ClassMethod)object;
				}
				
				if(classMethod == null)
					continue;
				
				int parameterCounter = 0;
				
				// search in parameters of class method the parameter closure
				for(Parameter parameter : classMethod.getParameters()){
					if(parameter.equals(parameterClosure))
						break;
					else
						parameterCounter++;
				}
				
				// find parameter closure assignment for this method in a method call
				ParameterClosureAssignment parameterClosureAssignment = null;
							
				Collection<MethodCall> methodCalls = 
					JavaEObjectUtil.getObjectsByType(resource.getAllContents(), ReferencesPackage.eINSTANCE.getMethodCall());
	
				MethodCall methodCall = null;
				
				// search not only for a parameter closure assignment
				// also the place on the parameter list in method call must be equal
				for(MethodCall mc : methodCalls){
					if(mc.getTarget().getName().equals(classMethod.getName())){
						methodCall = mc;
						int iCounter = 0;
						for(Expression argument : methodCall.getArguments()){
							if(argument instanceof ParameterClosureAssignment && iCounter == parameterCounter){
								parameterClosureAssignment =
									(ParameterClosureAssignment) argument;
							}
							else{
								iCounter++;
							}
						}
					}
				}
				
				if(parameterClosureAssignment == null)
					continue;
				
				// set statements from parameter closure assignment into parameter closure
				parameterClosure.getStatements().addAll(parameterClosureAssignment.getStatements());
				
				// set parameters from parameter closure assignment into parameter closure
				for(Parameter parameter : parameterClosureAssignment.getParameters()){
					Parameter parameterCopy = EcoreUtil.copy(parameter);
					parameterClosure.getParameters().add(parameterCopy);
				}
			
				// create the anonymous class with his interface
				MethodCall innerMethodCall = createAnonymousClass(
						parameterClosureCall, 
						parameterClosureCall.getMethodName(),
						parameterClosure.getClosureName(), 
						parameterClosure.getValueType(), 
						parameterClosure, 
						resource);
				
				// still something to do...
				
				// set parameters of parameter closure assignment also into super class method
				for(Parameter parameter : parameterClosureAssignment.getParameters()){
					Parameter parameterCopy = EcoreUtil.copy(parameter);
					classMethod.getParameters().add(parameterCopy);
				}
	
				// delete parameter closure in parameters list of super class method
				EcoreUtil.delete(parameterClosure);
				
				// set arguments in method call of super class method
				methodCall.getArguments().addAll(parameterClosureCall.getArguments());
				
				// set in inner method call of invoke class method of anonymous class
				// identifier references to the parameters of the super class method
				innerMethodCall.getArguments().clear();
	
				for(Parameter parameter : parameterClosureAssignment.getParameters()){
					IdentifierReference identifierReference = ReferencesFactory.eINSTANCE.createIdentifierReference();
					identifierReference.setTarget(parameter);
					innerMethodCall.getArguments().add(identifierReference);
				}
				
				// delete 
				EcoreUtil.delete(parameterClosureAssignment);	
			
			}
		}
	}
	
	@Override
	public Map<?, ?> getOptions() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(IClosureOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
		return map;
	}

}
