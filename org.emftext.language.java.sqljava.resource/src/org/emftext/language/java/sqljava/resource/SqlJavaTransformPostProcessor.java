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
import org.emftext.language.sql.select.BetweenCondition;
import org.emftext.language.sql.select.ColumnOperation;
import org.emftext.language.sql.select.ColumnOperationAvg;
import org.emftext.language.sql.select.ColumnOperationCount;
import org.emftext.language.sql.select.ColumnOperationEvery;
import org.emftext.language.sql.select.ColumnOperationMax;
import org.emftext.language.sql.select.ColumnOperationMin;
import org.emftext.language.sql.select.ColumnOperationSome;
import org.emftext.language.sql.select.ColumnOperationSum;
import org.emftext.language.sql.select.Condition;
import org.emftext.language.sql.select.ConditionOperation;
import org.emftext.language.sql.select.ConditionOperationEqual;
import org.emftext.language.sql.select.ConditionOperationGreatEqual;
import org.emftext.language.sql.select.ConditionOperationGreater;
import org.emftext.language.sql.select.ConditionOperationLessEqual;
import org.emftext.language.sql.select.ConditionOperationLesser;
import org.emftext.language.sql.select.ConditionOperationUnEqual;
import org.emftext.language.sql.select.ConditionOperationUnEqual2;
import org.emftext.language.sql.select.ConditionValue;
import org.emftext.language.sql.select.ExistsCondition;
import org.emftext.language.sql.select.Expression;
import org.emftext.language.sql.select.ExpressionOperation;
import org.emftext.language.sql.select.ExpressionOperationAnd;
import org.emftext.language.sql.select.ExpressionOperationNot;
import org.emftext.language.sql.select.ExpressionOperationOr;
import org.emftext.language.sql.select.FunctionValue;
import org.emftext.language.sql.select.InCondition;
import org.emftext.language.sql.select.IsNullCondition;
import org.emftext.language.sql.select.JoinOperation;
import org.emftext.language.sql.select.JoinOperationInner;
import org.emftext.language.sql.select.JoinOperationLeft;
import org.emftext.language.sql.select.JoinOperationOuter;
import org.emftext.language.sql.select.JoinOperationRight;
import org.emftext.language.sql.select.JoinTableExpression;
import org.emftext.language.sql.select.LikeCondition;
import org.emftext.language.sql.select.LimitExpression;
import org.emftext.language.sql.select.OperationCondition;
import org.emftext.language.sql.select.OrderByAliasExpression;
import org.emftext.language.sql.select.OrderByColumnExpression;
import org.emftext.language.sql.select.OrderByParameter;
import org.emftext.language.sql.select.OrderByParameterAsc;
import org.emftext.language.sql.select.OrderByParameterDesc;
import org.emftext.language.sql.select.OrderBySelectExpression;
import org.emftext.language.sql.select.SelectExpression;
import org.emftext.language.sql.select.SelectParameter;
import org.emftext.language.sql.select.SelectParameterAll;
import org.emftext.language.sql.select.SelectParameterDistinct;
import org.emftext.language.sql.select.SetExpression;
import org.emftext.language.sql.select.SetOperation;
import org.emftext.language.sql.select.SetOperationExcept;
import org.emftext.language.sql.select.SetOperationIntersect;
import org.emftext.language.sql.select.SetOperationMinus;
import org.emftext.language.sql.select.SetOperationUnion;
import org.emftext.language.sql.select.SimpleCondition;
import org.emftext.language.sql.select.SimpleExpression;
import org.emftext.language.sql.select.SimpleValue;
import org.emftext.language.sql.select.SingleColumnExpression;
import org.emftext.language.sql.select.TableExpression;
import org.emftext.language.sql.select.TableListExpression;
import org.emftext.language.sql.select.Value;
import org.emftext.language.sql.select.ValueOperation;
import org.emftext.language.sql.select.ValueOperationDivide;
import org.emftext.language.sql.select.ValueOperationMinus;
import org.emftext.language.sql.select.ValueOperationMultiply;
import org.emftext.language.sql.select.ValueOperationParallel;
import org.emftext.language.sql.select.ValueOperationPlus;

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
			
			methodCall.getArguments().add(getNewStringReference(driver.getDriver()));
			
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
			
			methodCall.getArguments().add(getNewStringReference(connection.getConnectionString()));
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
			
			List<Reference> references = convertSelectExpression(query.getSqlString());

		}
	}
	
	private Reference convertSelectParameter(SelectParameter selectParameter){
		if(selectParameter instanceof SelectParameterAll){
			return getNewStringReference("ALL");
		}
		if(selectParameter instanceof SelectParameterDistinct){
			return getNewStringReference("DISTINCT");
		}
		return null;
	}
	
	private List<Reference> convertSelectExpression(SelectExpression selectExpression){
		
		List<Reference> references = new ArrayList<Reference>();
		
		StringReference stringReference = ReferencesFactory.eINSTANCE.createStringReference();
		stringReference.setValue("SELECT");
		references.add(stringReference);
		
		// parameter
		if(selectExpression.getParameter() != null)
			references.add(convertSelectParameter(selectExpression.getParameter()));
		
		// columns
		for(SingleColumnExpression singleColumnExpression : selectExpression.getColumns().getColumnExpressions()){
			references.addAll(convertColumnExpression(singleColumnExpression));
			references.add(getNewStringReference(","));
		}
		references.remove(references.size()-1); // delete last ','
		
		// from
		for(TableListExpression tableListExpression : selectExpression.getFrom().getTables()){
			references.addAll(convertTableListExpression(tableListExpression));
			references.add(getNewStringReference(","));
		}
		references.remove(references.size()-1); // delete last ','
		
		// where
		if(selectExpression.getWhere() != null)
			references.addAll(convertExpression(selectExpression.getWhere().getExpression()));
		
		// group by
		if(selectExpression.getGroupBy() != null){
			for(Expression expression : selectExpression.getGroupBy().getExpression()){
				references.addAll(convertExpression(expression);
				references.add(getNewStringReference(","));
			}
			references.remove(references.size()-1); // delete last ','
		}

		// having
		if(selectExpression.getHaving() != null){
			references.addAll(convertExpression(selectExpression.getHaving().getExpression()));
		}
		
		// set
		if(selectExpression.getSet() != null){
			references.addAll(convertSetExpression(selectExpression.getSet()));
		}

		// order by
		if(selectExpression.getOrderBy() != null){
			references.addAll(convertOrderByExpression(selectExpression.getOrderBy().getParameter()));
		}
		
		// limit
		if(selectExpression.getLimit() != null){
			references.addAll(convertLimitExpression(selectExpression.getLimit()));
		}
		
		// TODO
		return references;
	}

	private List<Reference> convertColumnExpression(SingleColumnExpression singleColumnExpression){
		
		List<Reference> references = new ArrayList<Reference>();
		if(singleColumnExpression.getOperation() != null){
			references.add(convertColumnOperation(singleColumnExpression.getOperation()));
			
			references.add(getNewStringReference("("));
			
			if(singleColumnExpression.getParameter() != null)
				references.add(convertSelectParameter(singleColumnExpression.getParameter()));
				
			if(singleColumnExpression.getExpression() != null)
				references.addAll(convertExpression(singleColumnExpression.getExpression()));
			
			references.add(getNewStringReference(")"));
		}
		else{
			if(singleColumnExpression.getExpression() != null)
				references.addAll(convertExpression(singleColumnExpression.getExpression()));
		}
		
		if(singleColumnExpression.getAlias() != null){
			references.add(getNewStringReference("AS"));
			references.add(getNewStringReference(singleColumnExpression.getAlias()));
		}
		
		return references;
	}
	
	private Reference convertColumnOperation(ColumnOperation columnOperation){
		
		if(columnOperation instanceof ColumnOperationCount){
			return getNewStringReference("COUNT");
		}
		if(columnOperation instanceof ColumnOperationMin){
			return getNewStringReference("MIN");
		}
		if(columnOperation instanceof ColumnOperationMax){
			return getNewStringReference("MAX");
		}
		if(columnOperation instanceof ColumnOperationSum){
			return getNewStringReference("SUM");
		}
		if(columnOperation instanceof ColumnOperationAvg){
			return getNewStringReference("AVG");
		}
		if(columnOperation instanceof ColumnOperationEvery){
			return getNewStringReference("EVERY");
		}
		if(columnOperation instanceof ColumnOperationSome){
			return getNewStringReference("SOME");
		}
		return null;
	}
	
	private List<Reference> convertTableListExpression(TableListExpression tableListExpression){
		
		List<Reference> references = new ArrayList<Reference>();
		references.addAll(convertTableExpression(tableListExpression.getTable()));
		
		if(tableListExpression.getJoinTable() != null){
			references.addAll(convertJoinTableExpression(tableListExpression.getJoinTable()));
		}
		
		return references;
	}
	
	private List<Reference> convertTableExpression(TableExpression tableExpression){
		
		List<Reference> references = new ArrayList<Reference>();
		if(tableExpression.getSelectExpression() != null){
			references.addAll(convertSelectExpression(tableExpression.getSelectExpression()));
			if(tableExpression.getLabel() != null){
				references.add(getNewStringReference("AS"));
				references.add(getNewStringReference(tableExpression.getLabel()));
			}
		}
		else{
			references.add(getNewStringReference(tableExpression.getTable().getName()));
		}
		return references;
	}
	
	private List<Reference> convertJoinTableExpression(JoinTableExpression joinTableExpression){
		
		List<Reference> references = new ArrayList<Reference>();
		references.add(convertJoinOperation(joinTableExpression.getJoin()));
		references.addAll(convertTableExpression(joinTableExpression.getJoinTable()));
		references.add(getNewStringReference("ON"));
		references.addAll(convertExpression(joinTableExpression.getExpression()));
	}
	
	private Reference convertJoinOperation(JoinOperation joinOperation){
		
		if(joinOperation instanceof JoinOperationInner){
			return getNewStringReference("INNER JOIN");
		}
		if(joinOperation instanceof JoinOperationLeft){
			return getNewStringReference("LEFT OUTER JOIN");
		}
		if(joinOperation instanceof JoinOperationRight){
			return getNewStringReference("RIGHT OUTER JOIN");
		}
		if(joinOperation instanceof JoinOperationOuter){
			return getNewStringReference("OUTER JOIN");
		}
		return null;
	}
	
	private List<Reference> convertSetExpression(SetExpression setExpression){

		List<Reference> references = new ArrayList<Reference>();
		references.addAll(convertSetOperation(setExpression.getSetOperation()));
		references.addAll(convertSelectExpression(setExpression.getSelectExpression()));
		return references;
	}
	
	private List<Reference> convertSetOperation(SetOperation setOperation){
		
		List<Reference> references = new ArrayList<Reference>();
		
		if(setOperation instanceof SetOperationUnion){
			references.add(getNewStringReference("UNION"));
			references.add(convertSelectParameter(((SetOperationUnion)setOperation).getSelectParameter()));
		}
		if(setOperation instanceof SetOperationMinus){
			references.add(getNewStringReference("MINUS"));
			references.add(convertSelectParameter(((SetOperationUnion)setOperation).getSelectParameter()));
		}
		if(setOperation instanceof SetOperationExcept){
			references.add(getNewStringReference("EXCEPT"));
			references.add(convertSelectParameter(((SetOperationUnion)setOperation).getSelectParameter()));
		}
		if(setOperation instanceof SetOperationIntersect){
			references.add(getNewStringReference("INTERSECT"));
			references.add(convertSelectParameter(((SetOperationUnion)setOperation).getSelectParameter()));
		}
		return null;
	}
	
	private List<Reference> convertOrderByExpression(OrderByParameter orderByParameter){
		
		List<Reference> references = new ArrayList<Reference>();
		
		if(orderByParameter instanceof OrderByColumnExpression){
			references.add(getNewStringReference(
					((OrderByColumnExpression)orderByParameter).getColumnReference().getName()));
			references.add(convertOrderByParameter(orderByParameter.getParameter()));
		}
		if(orderByParameter instanceof OrderByAliasExpression){
			references.add(getNewStringReference(
					((OrderByAliasExpression)orderByParameter).getAlias()));
			references.add(convertOrderByParameter(orderByParameter.getParameter()));
		}
		if(orderByParameter instanceof OrderBySelectExpression){
			references.addAll(convertSelectExpression(
					((OrderBySelectExpression)orderByParameter).getSelectExpression()));
			references.add(convertOrderByParameter(orderByParameter.getParameter()));
		}
	}
	
	private Reference convertOrderByParameter(OrderByParameter orderByParameter){
		
		if(orderByParameter instanceof OrderByParameterAsc){
			return getNewStringReference("ASC");
		}
		if(orderByParameter instanceof OrderByParameterDesc){
			return getNewStringReference("DESC");
		}
		return null;
	}
	
	private List<Reference> convertLimitExpression(LimitExpression limitExpression) {
		
		List<Reference> references = new ArrayList<Reference>();
		references.add(getNewStringReference(limitExpression.getLimit()));
		
		if(limitExpression.getOffset() != null){
			references.add(getNewStringReference("OFFSET"));
			references.add(getNewStringReference(limitExpression.getOffset()));
		}
		return references;
	}
	
	private List<Reference> convertExpression(Expression expression){
		
		List<Reference> references = new ArrayList<Reference>();
		
		if(expression instanceof SimpleExpression){
			references.add(convertExpressionOperation(((SimpleExpression)expression).getNotOperation()));
		}
		
		if(((SimpleExpression)expression).getOperations() != null){
			references.addAll(convertCondition(((SimpleExpression)expression).getConditions().get(0)));
			references.add(convertExpressionOperation(((SimpleExpression)expression).getOperations()));
			references.addAll(convertCondition(((SimpleExpression)expression).getConditions().get(1)));
		}
		else{
			references.addAll(convertCondition(((SimpleExpression)expression).getConditions().get(0)));
		}
	}
	
	private Reference convertExpressionOperation(ExpressionOperation expressionOperation){
		
		if(expressionOperation instanceof ExpressionOperationNot){
			return getNewStringReference("NOT");
		}
		if(expressionOperation instanceof ExpressionOperationAnd){
			return getNewStringReference("AND");
		}
		if(expressionOperation instanceof ExpressionOperationOr){
			return getNewStringReference("OR");
		}
		return null;
	}
	
	private List<Reference> convertCondition(Condition condition){
	
		List<Reference> references = new ArrayList<Reference>();
		
		if(condition instanceof SimpleCondition){
			for(Value value : ((SimpleCondition)condition).getValues()){
				references.addAll(convertValue(value));
			}
		}
		if(condition instanceof OperationCondition){
			references.addAll(convertValue(((OperationCondition)condition).getValues().get(0)));
			references.add(convertConditionOperation(((OperationCondition)condition).getOperation()));
			references.addAll(convertValue(((OperationCondition)condition).getValues().get(1)));
		}
		if(condition instanceof IsNullCondition){
			references.addAll(convertValue(((OperationCondition)condition).getValues().get(0)));
			references.add(getNewStringReference("IS"));
			if(((IsNullCondition)condition).getOperationNot() != null)
				references.add(convertExpressionOperation(((IsNullCondition)condition).getOperationNot()));
			references.add(getNewStringReference("NULL"));
		}
		if(condition instanceof ExistsCondition){
			references.add(getNewStringReference("EXISTS"));
			references.add(getNewStringReference("("));
			references.addAll(convertSelectExpression((((ExistsCondition)condition).getSelectExpression())));
			references.add(getNewStringReference(")"));
		}
		if(condition instanceof BetweenCondition){
			references.addAll(convertValue(((OperationCondition)condition).getValues().get(0)));
			references.add(getNewStringReference("BETWEEN"));
			references.addAll(convertValue(((OperationCondition)condition).getValues().get(1)));
			references.addAll(convertValue(((OperationCondition)condition).getValues().get(2)));
			references.add(getNewStringReference("AND"));
		}
		if(condition instanceof InCondition){
			
			references.addAll(convertValue(((OperationCondition)condition).getValues().get(0)));
			if(((InCondition)condition).getOperationNot() != null)
				references.add(convertExpressionOperation(((InCondition)condition).getOperationNot()));
			references.add(getNewStringReference("IN"));
			
			if(((InCondition)condition).getSelectExpression() != null){
				references.addAll(convertSelectExpression(((InCondition)condition).getSelectExpression()));
			}
			else{
				boolean wasFirst = false;
				for(Value value : ((OperationCondition)condition).getValues()){
					if(wasFirst){
						references.addAll(convertValue(value));
						wasFirst = true;
					}
				}
			}
		}
		if(condition instanceof LikeCondition){
			references.addAll(convertValue(((OperationCondition)condition).getValues().get(0)));
			if(((LikeCondition)condition).getOperationNot() != null)
				references.add(convertExpressionOperation(((LikeCondition)condition).getOperationNot()));
			references.add(getNewStringReference("LIKE"));
			references.addAll(convertValue(((OperationCondition)condition).getValues().get(1)));
		}
		return references;
		
	}
	
	private Reference convertConditionOperation(ConditionOperation conditionOperation){
		if(conditionOperation instanceof ConditionOperationEqual){
			return getNewStringReference("=");
		}
		if(conditionOperation instanceof ConditionOperationLesser){
			return getNewStringReference("<");
		}
		if(conditionOperation instanceof ConditionOperationLessEqual){
			return getNewStringReference("<=");
		}
		if(conditionOperation instanceof ConditionOperationGreater){
			return getNewStringReference(">");
		}
		if(conditionOperation instanceof ConditionOperationGreatEqual){
			return getNewStringReference(">=");
		}
		if(conditionOperation instanceof ConditionOperationUnEqual){
			return getNewStringReference("<>");
		}
		if(conditionOperation instanceof ConditionOperationUnEqual2){
			return getNewStringReference("!=");
		}
		return null;
	}
	
	private List<Reference> convertValue(Value value){
		
		List<Reference> references = new ArrayList<Reference>();
		
		if(value instanceof SimpleValue){
			if(((SimpleValue)value).getFrontOperation() != null)
				references.add(convertValueOperation(((SimpleValue)value).getFrontOperation()));
			references.addAll(convertTerm(((SimpleValue)value).getTerms().get(0)));
			if(((SimpleValue)value).getOperations() != null){
				references.add(convertValueOperation(((SimpleValue)value).getOperations()));
				references.addAll(convertTerm(((SimpleValue)value).getTerms().get(1)));
			}
		}
		if(value instanceof ConditionValue){
			references.add(getNewStringReference("("));
			references.addAll(convertCondition(((ConditionValue)value).getCondition()));
			references.add(getNewStringReference(")"));
		}
		if(value instanceof FunctionValue){
			references.add(getNewStringReference(((FunctionValue)value).getFunctionName()));
			references.add(getNewStringReference("("));
			for(Value parameter : ((FunctionValue)value).getParameters()){
				references.addAll(convertValue(parameter));
				references.add(getNewStringReference(","));
			}
			references.remove(references.size()-1); // delete last ','
			references.add(getNewStringReference(")"));
		}	
		
	}
	
	private Reference convertValueOperation(ValueOperation valueOperation){
		if(valueOperation instanceof ValueOperationPlus){
			return getNewStringReference("+");
		}
		if(valueOperation instanceof ValueOperationMinus){
			return getNewStringReference("-");
		}
		if(valueOperation instanceof ValueOperationMultiply){
			return getNewStringReference("*");
		}
		if(valueOperation instanceof ValueOperationDivide){
			return getNewStringReference("/");
		}
		if(valueOperation instanceof ValueOperationParallel){
			return getNewStringReference("||");
		}
		return null;
	}
	
	// -----------
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
	
	private StringReference getNewStringReference(String value){
		
		StringReference stringReference = ReferencesFactory.eINSTANCE.createStringReference();
		stringReference.setValue(value);
		return stringReference;
	}

}
