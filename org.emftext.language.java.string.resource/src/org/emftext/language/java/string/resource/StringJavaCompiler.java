package org.emftext.language.java.string.resource;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.arrays.ArrayDimension;
import org.emftext.language.java.arrays.ArrayInitializationValue;
import org.emftext.language.java.arrays.ArrayInstantiationBySize;
import org.emftext.language.java.arrays.ArrayInstantiationByValues;
import org.emftext.language.java.arrays.ArrayTypeable;
import org.emftext.language.java.classifiers.ClassifiersFactory;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.expressions.AdditiveExpression;
import org.emftext.language.java.expressions.Expression;
import org.emftext.language.java.expressions.ExpressionsFactory;
import org.emftext.language.java.imports.ClassifierImport;
import org.emftext.language.java.imports.ImportsFactory;
import org.emftext.language.java.instantiations.Instantiation;
import org.emftext.language.java.instantiations.NewConstructorCall;
import org.emftext.language.java.literals.BooleanLiteral;
import org.emftext.language.java.literals.CharacterLiteral;
import org.emftext.language.java.literals.DecimalDoubleLiteral;
import org.emftext.language.java.literals.DecimalFloatLiteral;
import org.emftext.language.java.literals.DecimalIntegerLiteral;
import org.emftext.language.java.literals.DecimalLongLiteral;
import org.emftext.language.java.literals.HexDoubleLiteral;
import org.emftext.language.java.literals.HexFloatLiteral;
import org.emftext.language.java.literals.HexIntegerLiteral;
import org.emftext.language.java.literals.HexLongLiteral;
import org.emftext.language.java.literals.Literal;
import org.emftext.language.java.literals.OctalIntegerLiteral;
import org.emftext.language.java.literals.OctalLongLiteral;
import org.emftext.language.java.members.ClassMethod;
import org.emftext.language.java.members.Field;
import org.emftext.language.java.members.MemberContainer;
import org.emftext.language.java.members.MembersFactory;
import org.emftext.language.java.members.MembersPackage;
import org.emftext.language.java.modifiers.AnnotationInstanceOrModifier;
import org.emftext.language.java.operators.AdditiveOperator;
import org.emftext.language.java.operators.OperatorsFactory;
import org.emftext.language.java.references.Reference;
import org.emftext.language.java.references.ReferencesFactory;
import org.emftext.language.java.references.StringReference;
import org.emftext.language.java.statements.Return;
import org.emftext.language.java.statements.StatementsFactory;
import org.emftext.language.java.string.AutomaticString;
import org.emftext.language.java.string.StringPackage;
import org.emftext.language.java.string.resource.stringjava.IStringjavaOptionProvider;
import org.emftext.language.java.string.resource.stringjava.IStringjavaOptions;
import org.emftext.language.java.string.resource.stringjava.IStringjavaResourcePostProcessor;
import org.emftext.language.java.string.resource.stringjava.IStringjavaResourcePostProcessorProvider;
import org.emftext.language.java.string.resource.stringjava.mopp.StringjavaResource;
import org.emftext.language.java.string.resource.stringjava.util.StringjavaEObjectUtil;
import org.emftext.language.java.types.ClassifierReference;
import org.emftext.language.java.types.NamespaceClassifierReference;
import org.emftext.language.java.types.TypeReference;
import org.emftext.language.java.types.TypesFactory;

public class StringJavaCompiler implements
		IStringjavaResourcePostProcessor,
		IStringjavaResourcePostProcessorProvider, 
		IStringjavaOptionProvider {

	@Override
	public void process(StringjavaResource resource) {
		
		URI javaURI = resource.getURI().trimFileExtension().appendFileExtension("java");
		final Resource javaResource = resource.getResourceSet().createResource(javaURI);
		javaResource.getContents().addAll(
				EcoreUtil.copyAll(resource.getContents()));
		
		
		Collection<AutomaticString> properties = 
			StringjavaEObjectUtil.getObjectsByType(
					javaResource.getAllContents(), 
					StringPackage.eINSTANCE.getAutomaticString());
		
		// only one string id is necessary
		if(properties.size() > 0){
			AutomaticString automaticString = properties.iterator().next();
			convertToStringMethod(javaResource, automaticString);
		}
		
		
		try {
			javaResource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void convertToStringMethod(
			Resource javaResource, 
			AutomaticString automaticString){
		
		MemberContainer mc = (MemberContainer)automaticString.eContainer();
		
		ClassMethod method = createMethod(createReturnExpression(javaResource));
			
		EcoreUtil.replace(automaticString, method);
			
		if(mc != null){
			EObject container = mc.eContainer();
			if(container instanceof CompilationUnit){
				((CompilationUnit)container).getImports().add(createStringImport());
				
			}
		}	
	}
	
	private Expression createReturnExpression(Resource javaResource){
		
//		String returnString;
//		returnString = "[";
		
		Collection<Field> fields =
			StringjavaEObjectUtil.getObjectsByType(
					javaResource.getAllContents(),
					MembersPackage.eINSTANCE.getField());
		
		AdditiveExpression additiveExpression =
			ExpressionsFactory.eINSTANCE.createAdditiveExpression();
		
		
		
		for(Field field : fields){
			
			String returnString = "";
			
			returnString += "[";
			for(AnnotationInstanceOrModifier modifier : 
				field.getAnnotationsAndModifiers()){
				
				returnString += modifier.eClass().getName().toLowerCase();
				returnString += " ";
			}
			
			
			returnString += getTypeReference(field.getTypeReference());
			
			
			for(int i=0;i<field.getArrayDimensionsBefore().size();i++){
				returnString += "[]";
			}
			
			returnString += " ";
			returnString += field.getName();
			returnString += " = ";
			
			Expression expression = findLeafExpression(field.getInitialValue());
			
			returnString += getValueOfExpression(expression);
			
			returnString += "]";
			
			StringReference stringRef = 
				ReferencesFactory.eINSTANCE.createStringReference();
			stringRef.setValue(returnString);
			
			additiveExpression.getChildren().add(stringRef);
			
			AdditiveOperator plus = OperatorsFactory.eINSTANCE.createAddition();
			additiveExpression.getAdditiveOperators().add(plus);
		}
		
//		returnString += "]";
		
//		return returnString;
		return additiveExpression;
	}
	
	private String getValueOfExpression(Expression expression){
		
		String returnString = "";
		
		if(expression instanceof Literal)
			returnString += getLiteralValue((Literal)expression);
		if(expression instanceof Reference)
			returnString += getReferenceValue((Reference)expression);
		if(expression instanceof ArrayTypeable)
			returnString += getArrayInitializationValue((ArrayTypeable)expression);
		if(expression instanceof Instantiation)
			returnString += getInstantiationValue((Instantiation)expression);
		
		return returnString;
	}
	
	private String getTypeReference(TypeReference typeReference){
		
		String returnString = "";
		
		if(typeReference == null)
			return "";
		
		if(typeReference instanceof NamespaceClassifierReference){
			returnString += ((NamespaceClassifierReference)typeReference)
							.getPureClassifierReference().getTarget().getName();
		}
		else{
			returnString += typeReference.getTarget().eClass().getName().toLowerCase();
		}
		
		return returnString;
	}
	
	private String getInstantiationValue( Instantiation instantiation){
		
		String returnString = "";
		
		if(instantiation instanceof NewConstructorCall){
			returnString += getTypeReference(((NewConstructorCall)instantiation).getTypeReference());
			returnString += "(";
			
			for(Expression expression : ((NewConstructorCall)instantiation).getArguments()){
				
				Expression leafExpression = findLeafExpression(expression);
				returnString += getValueOfExpression(leafExpression);
				returnString += ",";
			}
			returnString = returnString.substring(0, returnString.length()-1);
			
			returnString += ")";
		}
		
		return returnString;
	}
	
	private String getArrayInitializationValue(ArrayTypeable arrayType){
		
		String returnString = "";
		
		if(arrayType instanceof ArrayInstantiationByValues){
			
			String sTypeReference = getTypeReference(((ArrayInstantiationByValues)arrayType).getTypeReference());
			if(!sTypeReference.equals(""))
				returnString += sTypeReference;
			
			if(((ArrayInstantiationByValues)arrayType).getArrayDimensionsBefore() != null){
				for(int i=0;i<((ArrayInstantiationByValues)arrayType).getArrayDimensionsBefore().size();i++){
					returnString += "[]";
				}
			}
			
			returnString += "{";
			
			for(Expression expression : 
				(EList<? extends Expression>)
					((ArrayInstantiationByValues)arrayType).getArrayInitializer().getInitialValues()){
				
					Expression leafExpression = findLeafExpression(expression);
					returnString += getValueOfExpression(leafExpression);
				
				
				returnString += ",";
			}
			
			returnString = returnString.substring(0, returnString.length()-1);
			returnString += "}";
		}
		if(arrayType instanceof ArrayInstantiationBySize){
			
			returnString += getTypeReference(
					((ArrayInstantiationBySize)arrayType).getTypeReference());
			
			for(Expression expression : ((ArrayInstantiationBySize)arrayType).getSizes()){
				
				returnString += "[";
				
				Expression leafExpression = findLeafExpression(expression);
				returnString += getValueOfExpression(leafExpression);
				
				returnString += "]";
			}
		}
		
		return returnString;
	}
	
	private String getLiteralValue( Literal literal){
		
		String returnString = "";
		
		if(literal instanceof BooleanLiteral ||
			literal instanceof CharacterLiteral){
			
			try {
				returnString = String.valueOf(literal.eGet(literal.eClass()
						.getEStructuralFeature("value")));
			} catch (Exception e) {}
		}
		if(literal instanceof DecimalDoubleLiteral ||
		    literal instanceof DecimalFloatLiteral ||
		    literal instanceof DecimalLongLiteral ||
		    literal instanceof DecimalIntegerLiteral){
			
			try {
				returnString = String.valueOf(literal.eGet(literal.eClass()
						.getEStructuralFeature("decimalValue")));
			} catch (Exception e) {}
		}
		if(literal instanceof HexDoubleLiteral ||
			literal instanceof HexFloatLiteral ||
			literal instanceof HexLongLiteral ||
			literal instanceof HexIntegerLiteral){
					
					try {
						returnString = String.valueOf(literal.eGet(literal.eClass()
								.getEStructuralFeature("hexValue")));
					} catch (Exception e) {}
		}
		if(literal instanceof OctalIntegerLiteral ||
			literal instanceof OctalLongLiteral){
					
					try {
						returnString = String.valueOf(literal.eGet(literal.eClass()
								.getEStructuralFeature("octalValue")));
					} catch (Exception e) {}
		}
		
		return returnString;
	}
	
	private String getReferenceValue(Reference reference){
		
		String returnString = "";
		
		if(reference instanceof StringReference){
			returnString = ((StringReference)reference).getValue();
		}
		
		return returnString;
	}
	
	private Expression findLeafExpression(Expression rootExpression){
		
		Expression expression = rootExpression;
		
		if(expression == null)
			return null;
		
		do{
			
			Object object = null;
			
			try {
				object = expression.eGet(
						expression.eClass().getEStructuralFeature("child"));
			} catch (Exception e) {}
			
			try {
				if(object == null)
					object = expression.eGet(
							expression.eClass().getEStructuralFeature("children"));
			} catch (Exception e) {}
			
			if(object == null)
				break;
			
			if(object instanceof EObject){
				EObject eObject = (EObject)object;
				if(eObject instanceof Expression)
					expression = (Expression) eObject;
				else
					break;
			}
			if(object instanceof EList<?>){
				EList<?> eList = (EList<?>)object;
				if(eList.isEmpty())
					break;
				EObject eObject = (EObject)eList.get(0);
				if(eObject instanceof Expression)
					expression = (Expression) eObject;
				else
					break;
			}
		}
		while(true);
		
		return expression;
	}
	
	private ClassMethod createMethod(Expression returnExpression){
		
		ClassMethod toStringMethod = MembersFactory.eINSTANCE.createClassMethod();
		toStringMethod.setName("toString");
		
		org.emftext.language.java.classifiers.Class stringClassifier =
			ClassifiersFactory.eINSTANCE.createClass();
		stringClassifier.setFullName("String");
		stringClassifier.setName("String");
		
		ClassifierReference stringReference = 
			TypesFactory.eINSTANCE.createClassifierReference();
		stringReference.setTarget(stringClassifier);
		
		NamespaceClassifierReference stringNamespaceReference = 
			TypesFactory.eINSTANCE.createNamespaceClassifierReference();
		
		stringNamespaceReference.getClassifierReferences().add(stringReference);
		
		toStringMethod.setTypeReference(stringReference);
		
//		StringReference stringRef = ReferencesFactory.eINSTANCE.createStringReference();
//		stringRef.setValue(returnString);
		
		Return returnStatement = StatementsFactory.eINSTANCE.createReturn();
		returnStatement.setReturnValue(returnExpression);
		
		toStringMethod.getStatements().add(returnStatement);
		
		return toStringMethod;
		
	}
	
	private ClassifierImport createStringImport(){
		
		ClassifierImport stringImport = 
			ImportsFactory.eINSTANCE.createClassifierImport();
		
		stringImport.getNamespaces().add("java");
		stringImport.getNamespaces().add("lang");
				
		org.emftext.language.java.classifiers.Class stringClassifier =
			ClassifiersFactory.eINSTANCE.createClass();
		
		stringClassifier.setFullName("String");
		stringClassifier.setName("String");
		
		stringImport.setClassifier(stringClassifier);
		
		return stringImport;
	}
	
	@Override
	public IStringjavaResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	@Override
	public Map<?, ?> getOptions() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(IStringjavaOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
		return map;
	}

}
