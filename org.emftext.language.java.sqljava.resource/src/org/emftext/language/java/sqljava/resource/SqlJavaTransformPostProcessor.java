/*******************************************************************************
 * Copyright (c) 2006-2010 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.java.sqljava.resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.expressions.AdditiveExpression;
import org.emftext.language.java.expressions.ExpressionsFactory;
import org.emftext.language.java.imports.ClassifierImport;
import org.emftext.language.java.imports.ImportsFactory;
import org.emftext.language.java.members.ClassMethod;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.references.ElementReference;
import org.emftext.language.java.references.IdentifierReference;
import org.emftext.language.java.references.MethodCall;
import org.emftext.language.java.references.Reference;
import org.emftext.language.java.references.ReferenceableElement;
import org.emftext.language.java.references.ReferencesFactory;
import org.emftext.language.java.references.StringReference;
import org.emftext.language.java.resource.java.IJavaReferenceMapping;
import org.emftext.language.java.resource.java.IJavaReferenceResolveResult;
import org.emftext.language.java.resource.java.analysis.ClassifierImportClassifierReferenceResolver;
import org.emftext.language.java.resource.java.analysis.ClassifierReferenceTargetReferenceResolver;
import org.emftext.language.java.resource.java.analysis.ElementReferenceTargetReferenceResolver;
import org.emftext.language.java.resource.java.mopp.JavaResource;
import org.emftext.language.java.sqljava.Connection;
import org.emftext.language.java.sqljava.Query;
import org.emftext.language.java.sqljava.RegisterDriver;
import org.emftext.language.java.sqljava.SqljavaPackage;
import org.emftext.language.java.sqljava.resource.sqljava.ISqljavaOptionProvider;
import org.emftext.language.java.sqljava.resource.sqljava.ISqljavaOptions;
import org.emftext.language.java.sqljava.resource.sqljava.ISqljavaResourcePostProcessor;
import org.emftext.language.java.sqljava.resource.sqljava.ISqljavaResourcePostProcessorProvider;
import org.emftext.language.java.sqljava.resource.sqljava.mopp.SqljavaResource;
import org.emftext.language.java.sqljava.resource.sqljava.util.SqljavaEObjectUtil;
import org.emftext.language.java.statements.ExpressionStatement;
import org.emftext.language.java.statements.LocalVariableStatement;
import org.emftext.language.java.statements.StatementsFactory;
import org.emftext.language.java.types.ClassifierReference;
import org.emftext.language.java.types.NamespaceClassifierReference;
import org.emftext.language.java.types.TypesFactory;
import org.emftext.language.java.variables.LocalVariable;
import org.emftext.language.java.variables.VariablesFactory;
import org.emftext.language.sql.select.ColumnExpression;
import org.emftext.language.sql.select.SelectExpression;
import org.emftext.language.sql.select.SingleColumnExpression;

/**
 * Post processor that performs 
 * <i>cast repair</i>,
 * <i>expression simplification</i> and 
 * <i>java model completion</i>
 * on a resource after parsing using the JavaModelRepairer.
 */
public class SqlJavaTransformPostProcessor implements ISqljavaOptionProvider, ISqljavaResourcePostProcessor, ISqljavaResourcePostProcessorProvider {
	
	LocalVariable connection = null;
	
	public Map<?, ?> getOptions() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(ISqljavaOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
		return map;
	}

	public void process(final SqljavaResource resource) {
		
		Thread worker = new Thread(new Runnable(){
			@Override
			public void run() {
				convert(resource);
			}
		});
		
		worker.start();
	}

	public ISqljavaResourcePostProcessor getResourcePostProcessor() {
		return this;
	}
	
	private void convert(SqljavaResource resource){
		
		URI javaURI = resource.getURI().trimFileExtension().appendFileExtension("java");
		JavaResource javaResource = (JavaResource)resource.getResourceSet().createResource(javaURI);
		
		//--
		
		convertRegisterDriver(resource);
		convertConnection(resource);
		convertQuery(resource);
		//--
		
		javaResource.getContents().addAll(resource.getContents());
		
		try {
			javaResource.save(null);
		} catch (IOException e) {}
	}
	
	private ReferenceableElement getResolvedElement(String name, ElementReference reference){
		
		JavaReferenceResolveResult<ReferenceableElement> result =
			new JavaReferenceResolveResult<ReferenceableElement>();
		
		resolve(name, reference, null, -1, false, result);
		ReferenceableElement referencableElement = null;
		
		if(result.wasResolved())
			referencableElement = ((JavaReferenceMapping<ReferenceableElement>)result.getMappings().iterator().next()).getElement();
		return referencableElement;
		
	}
	
	private ConcreteClassifier getResolvedClassifier(String name, ClassifierImport reference){
		
		JavaReferenceResolveResult<ConcreteClassifier> result =
			new JavaReferenceResolveResult<ConcreteClassifier>();
		
		resolve(name, reference, null, -1, false, result);
		ConcreteClassifier concreteClassifier = null;
		
		if(result.wasResolved())
			concreteClassifier = (ConcreteClassifier)((JavaReferenceMapping<ConcreteClassifier>)result.getMappings().iterator().next()).getElement();
		return concreteClassifier;
		
	} 
	
	private ConcreteClassifier getResolvedClassifier(String name, ClassifierReference reference){
		
		JavaReferenceResolveResult<Classifier> result =
			new JavaReferenceResolveResult<Classifier>();
		
		resolve(name, reference, null, -1, false, result);
		ConcreteClassifier concreteClassifier = null;
		
		if(result.wasResolved())
			concreteClassifier = (ConcreteClassifier)((JavaReferenceMapping<Classifier>)result.getMappings().iterator().next()).getElement();
		return concreteClassifier;
		
	} 
	
	private ClassMethod getClassMethod(ConcreteClassifier concreteClassifier, String methodName ){
		for(Member member : concreteClassifier.getMembers()){
			if(member instanceof ClassMethod){
				if(member.getName().equals(methodName))
					return (ClassMethod)member;
			}
		}
		return null;
	}
	
	private void getResolvedImport(List<String> namespaces, String className, SqljavaResource resource){

		CompilationUnit complationUnit = 
			(CompilationUnit)SqljavaEObjectUtil.findRootContainer(resource.getContents().get(0));
		
		
		ClassifierImport classifierImport = ImportsFactory.eINSTANCE.createClassifierImport();
		complationUnit.getImports().add(classifierImport);
		classifierImport.setClassifier(
				(ConcreteClassifier)JavaClasspath.get(resource).getClassifier(className));
		classifierImport.getNamespaces().addAll(namespaces);
		ConcreteClassifier concreteClassifier = 
			getResolvedClassifier(className, classifierImport);
		if(concreteClassifier==null)
			EcoreUtil.delete(classifierImport);
		else
			classifierImport.setClassifier(concreteClassifier);
	}
	
	protected void convertRegisterDriver(SqljavaResource resource){
		
		Collection<RegisterDriver> drivers = 
			SqljavaEObjectUtil.getObjectsByType(resource.getAllContents(), SqljavaPackage.eINSTANCE.getRegisterDriver());
	
		getResolvedImport(Arrays.asList("java","lang"), "Class", resource);
		
		for(RegisterDriver driver : drivers){
			
						
			ExpressionStatement expressionStatement = 
				StatementsFactory.eINSTANCE.createExpressionStatement();
			
			EcoreUtil.replace(driver,expressionStatement);
			
			IdentifierReference identifierReference =
				ReferencesFactory.eINSTANCE.createIdentifierReference();
			
			expressionStatement.setExpression(identifierReference);
			
			ConcreteClassifier concreteClassifier = 
				(ConcreteClassifier)getResolvedElement("Class", identifierReference);
			if(concreteClassifier == null)
				continue;
						
			identifierReference.setTarget(concreteClassifier);
			
			MethodCall methodCall = ReferencesFactory.eINSTANCE.createMethodCall();
			ClassMethod method = getClassMethod(concreteClassifier, "forName");
			methodCall.setTarget(method);
			
			identifierReference.setNext(methodCall);
			
			StringReference stringReference = ReferencesFactory.eINSTANCE.createStringReference();
			stringReference.setValue(driver.getDriver());
			methodCall.getArguments().add(stringReference);
			
		}
	}
	
	protected void convertConnection(SqljavaResource resource){
		
		Collection<Connection> connections = 
			SqljavaEObjectUtil.getObjectsByType(resource.getAllContents(), SqljavaPackage.eINSTANCE.getConnection());
	
		getResolvedImport(Arrays.asList("java","sql"), "DriverManager", resource);
		getResolvedImport(Arrays.asList("java","sql"), "Connection", resource);
		
		for(Connection connection : connections){
			
			LocalVariableStatement localVariableStatement = StatementsFactory.eINSTANCE.createLocalVariableStatement();
			EcoreUtil.replace(connection, localVariableStatement);
			
			LocalVariable localVariable = VariablesFactory.eINSTANCE.createLocalVariable();
			localVariable.setName(connection.getName());
			localVariableStatement.setVariable(localVariable);
			this.connection = localVariable;
			
			NamespaceClassifierReference namespaceReference = TypesFactory.eINSTANCE.createNamespaceClassifierReference();
			localVariable.setTypeReference(namespaceReference);
			
			ClassifierReference reference = TypesFactory.eINSTANCE.createClassifierReference();
			namespaceReference.getClassifierReferences().add(reference);
	
			ConcreteClassifier connectionClass =
				getResolvedClassifier("Connection", reference);
			if(connectionClass == null)
				continue;
			reference.setTarget(connectionClass);
			
			IdentifierReference identifierReference =
				ReferencesFactory.eINSTANCE.createIdentifierReference();
			localVariable.setInitialValue(identifierReference);

			ConcreteClassifier driverManager =
				(ConcreteClassifier)getResolvedElement("DriverManager", identifierReference);
			if(driverManager == null)
				continue;
			identifierReference.setTarget(driverManager);
			
			MethodCall methodCall = ReferencesFactory.eINSTANCE.createMethodCall();
			identifierReference.setNext(methodCall);
			
			ClassMethod method = getClassMethod(driverManager, "getConnection");
			methodCall.setTarget(method);
			
			StringReference stringReference = ReferencesFactory.eINSTANCE.createStringReference();
			stringReference.setValue(connection.getConnectionString());
			methodCall.getArguments().add(stringReference);
		}
		
	}
	
	protected void convertQuery(SqljavaResource resource){
		
		Collection<Query> queries = 
			SqljavaEObjectUtil.getObjectsByType(resource.getAllContents(), SqljavaPackage.eINSTANCE.getQuery());
	
		for(Query query : queries){
			IdentifierReference identifierReference = ReferencesFactory.eINSTANCE.createIdentifierReference();
			identifierReference.setTarget(this.connection);
			EcoreUtil.replace(query, identifierReference);
			
			MethodCall methodCall = ReferencesFactory.eINSTANCE.createMethodCall();
			identifierReference.setNext(methodCall);
			
			ClassMethod createStatement = (ClassMethod)getResolvedElement("createStatement", methodCall);
			methodCall.setTarget(createStatement);
			
			MethodCall methodCall2 = ReferencesFactory.eINSTANCE.createMethodCall();
			methodCall.setNext(methodCall2);
			
			ClassMethod executeQuery = (ClassMethod)getResolvedElement("executeQuery", methodCall);
			methodCall2.setTarget(createStatement);
			
			AdditiveExpression additiveExpression = ExpressionsFactory.eINSTANCE.createAdditiveExpression();
			methodCall2.getArguments().add(additiveExpression);
			
			SelectExpression selectExpression = query.getSqlString();
			
			StringReference stringReference = ReferencesFactory.eINSTANCE.createStringReference();
			stringReference.setValue("SELECT");
			additiveExpression.getChildren().add(stringReference);
			
			selectExpression.getColumns().getColumnExpressions()
			
			selectExpression.getFrom().getTables()
			
		}
	}
	
	private List<Reference> convertColumnExpression(ColumnExpression columnExpression){
		
		List<Reference> references = new ArrayList<Reference>();
		for(SingleColumnExpression singeColumnExpression : 
			columnExpression.getColumnExpressions()){
			singeColumnExpression.s
		}
	}
	
	private class JavaReferenceMapping<ReferenceType> implements IJavaReferenceMapping<ReferenceType>{

		URI uri;
		ReferenceType element;
		String identifier;
		String warning;
		
		
		
		public JavaReferenceMapping(URI uri, ReferenceType element,
				String identifier, String warning) {
			super();
			this.uri = uri;
			this.element = element;
			this.identifier = identifier;
			this.warning = warning;
		}

		@Override
		public String getIdentifier() {
			return identifier;
		}

		@Override
		public String getWarning() {
			return warning;
		}

		public URI getUri() {
			return uri;
		}

		public ReferenceType getElement() {
			return element;
		}
	}
	
	class JavaReferenceResolveResult<ReferenceType> implements IJavaReferenceResolveResult<ReferenceType>{
		
		Collection<IJavaReferenceMapping<ReferenceType>> mappings = 
			new ArrayList<IJavaReferenceMapping<ReferenceType>>();
		
		String errorMessage = "";
		
		public boolean wasResolvedUniquely() {
			return false;
		}
		
		public boolean wasResolvedMultiple() {
			return mappings.size() > 1;
		}
		
		public boolean wasResolved() {
			return mappings.size() > 0;
		}
		
		public void setErrorMessage(String message) {
			errorMessage = message;
		}

		public Collection<IJavaReferenceMapping<ReferenceType>> getMappings() {
			return mappings;
		}

		public String getErrorMessage() {
			return errorMessage;
		}
		
		public void addMapping(String identifier, URI newIdentifier) {
			mappings.add(new JavaReferenceMapping<ReferenceType>(newIdentifier, null, identifier, ""));
		}
		
		public void addMapping(String identifier, URI newIdentifier, String warning) {
			mappings.add(new JavaReferenceMapping<ReferenceType>(newIdentifier, null, identifier, warning));
		}
		
		public void addMapping(String identifier, ReferenceType target) {
			mappings.add(new JavaReferenceMapping<ReferenceType>(null, target, identifier, ""));
		}
		
		public void addMapping(String identifier, ReferenceType target, String warning) {
			mappings.add(new JavaReferenceMapping<ReferenceType>(null, target, identifier, warning));
		}
	}
	
	public void resolve(String identifier, ElementReference container, EReference reference, int position, boolean resolveFuzzy, IJavaReferenceResolveResult<ReferenceableElement> result) {
		
		ElementReferenceTargetReferenceResolver delegate = 
			new ElementReferenceTargetReferenceResolver();
		
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
		
	}
	
	public void resolve(String identifier, ClassifierReference container, EReference reference, int position, boolean resolveFuzzy, IJavaReferenceResolveResult<Classifier> result){
		
		ClassifierReferenceTargetReferenceResolver delegate = 
			new ClassifierReferenceTargetReferenceResolver();
		
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public void resolve(String identifier, ClassifierImport container, EReference reference, int position, boolean resolveFuzzy, IJavaReferenceResolveResult<ConcreteClassifier> result){
		
	ClassifierImportClassifierReferenceResolver delegate = 
			new ClassifierImportClassifierReferenceResolver();
		
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}

}
