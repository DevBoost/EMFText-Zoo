/*******************************************************************************
 * Copyright (c) 2006-2009 
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
package org.emftext.language.java.properties.resource;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.expressions.AssignmentExpression;
import org.emftext.language.java.expressions.ExpressionsFactory;
import org.emftext.language.java.members.ClassMethod;
import org.emftext.language.java.members.Field;
import org.emftext.language.java.members.MemberContainer;
import org.emftext.language.java.members.MembersFactory;
import org.emftext.language.java.modifiers.ModifiersFactory;
import org.emftext.language.java.operators.OperatorsFactory;
import org.emftext.language.java.parameters.OrdinaryParameter;
import org.emftext.language.java.parameters.ParametersFactory;
import org.emftext.language.java.properties.PropertiesPackage;
import org.emftext.language.java.properties.Property;
import org.emftext.language.java.properties.resource.propjava.IPropjavaOptionProvider;
import org.emftext.language.java.properties.resource.propjava.IPropjavaOptions;
import org.emftext.language.java.properties.resource.propjava.IPropjavaResourcePostProcessor;
import org.emftext.language.java.properties.resource.propjava.IPropjavaResourcePostProcessorProvider;
import org.emftext.language.java.properties.resource.propjava.mopp.PropjavaResource;
import org.emftext.language.java.properties.resource.propjava.util.PropjavaEObjectUtil;
import org.emftext.language.java.properties.resource.propjava.util.PropjavaStringUtil;
import org.emftext.language.java.references.IdentifierReference;
import org.emftext.language.java.references.ReferencesFactory;
import org.emftext.language.java.statements.ExpressionStatement;
import org.emftext.language.java.statements.Return;
import org.emftext.language.java.statements.StatementsFactory;
import org.emftext.language.java.types.TypeReference;
import org.emftext.language.java.types.TypesFactory;

public class PropertiesJavaPostProcessor implements IPropjavaResourcePostProcessor,
	IPropjavaResourcePostProcessorProvider, IPropjavaOptionProvider {

	public static void main(String[] args) {
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(URI.createFileURI("pathToPropJavaFile.propjava"));
		if (resource instanceof PropjavaResource) {
			new PropertiesJavaPostProcessor().process((PropjavaResource) resource);
		}
	}
	
	public void process(PropjavaResource resource) {
		URI javaURI = resource.getURI().trimFileExtension().appendFileExtension("java");
		Resource javaResource = resource.getResourceSet().createResource(javaURI);
		javaResource.getContents().addAll(
				EcoreUtil.copyAll(resource.getContents()));
		
		boolean changed = true;
		
		while (changed) {
			changed = false;
			Collection<Property> properties = PropjavaEObjectUtil.getObjectsByType(javaResource.getAllContents(), PropertiesPackage.eINSTANCE.getProperty());
			for (Property property : properties) {
				convertToField(property);
				changed = true;
				break;
			}
		}
		
		try {
			javaResource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void convertToField(Property property) {
		Field field = createField(property);
		// create getter
		createGetter(property, field);
		// create setter
		if (!property.isReadonly()) {
			createSetter(property, field);
		}
		
		EcoreUtil.replace(property, field);
	}

	private void createSetter(Property property, Field field) {
		ClassMethod setterMethod = MembersFactory.eINSTANCE.createClassMethod();
		setterMethod.setName("set" + PropjavaStringUtil.capitalize(property.getName()));
		setterMethod.setTypeReference(TypesFactory.eINSTANCE.createVoid());
		
		OrdinaryParameter parameter = ParametersFactory.eINSTANCE.createOrdinaryParameter();
		parameter.setName("newValue");
		TypeReference typeReference = field.getTypeReference();
		TypeReference tReferenceCopy = (TypeReference) EcoreUtil.copy(typeReference);
		parameter.setTypeReference(tReferenceCopy);
		setterMethod.getParameters().add(parameter);
		
		AssignmentExpression assignment = ExpressionsFactory.eINSTANCE.createAssignmentExpression();
		assignment.setAssignmentOperator(OperatorsFactory.eINSTANCE.createAssignment());
		
		IdentifierReference parameterRef = ReferencesFactory.eINSTANCE.createIdentifierReference();
		parameterRef.setTarget(parameter);
		assignment.setValue(parameterRef);
		IdentifierReference fieldRef = ReferencesFactory.eINSTANCE.createIdentifierReference();
		fieldRef.setTarget(field);
		assignment.setChild(fieldRef);
		
		ExpressionStatement assignmentStatement = StatementsFactory.eINSTANCE.createExpressionStatement();
		assignmentStatement.setExpression(assignment);
		setterMethod.getStatements().add(assignmentStatement);
		((MemberContainer) property.eContainer()).getMembers().add(setterMethod);
	}

	private void createGetter(Property property, Field field) {
		// create getter
		ClassMethod getterMethod = MembersFactory.eINSTANCE.createClassMethod();
		getterMethod.setName("get" + PropjavaStringUtil.capitalize(property.getName()));
		
		Return returnStatement = StatementsFactory.eINSTANCE.createReturn();
		IdentifierReference fieldRef = ReferencesFactory.eINSTANCE.createIdentifierReference();
		fieldRef.setTarget(field);
		returnStatement.setReturnValue(fieldRef);
		
		getterMethod.getStatements().add(returnStatement);
		
		TypeReference typeReference = field.getTypeReference();
		TypeReference tReferenceCopy = (TypeReference) EcoreUtil.copy(typeReference);
		getterMethod.setTypeReference(tReferenceCopy);
		
		((MemberContainer) property.eContainer()).getMembers().add(getterMethod);
	}

	private Field createField(Property property) {
		// create field
		Field field = MembersFactory.eINSTANCE.createField();
		field.setName(property.getName());
		TypeReference typeReference = property.getTypeReference();
		field.setTypeReference(typeReference);
		field.getAnnotationsAndModifiers().add(ModifiersFactory.eINSTANCE.createPrivate());
		return field;
	}

	public IPropjavaResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	public Map<?, ?> getOptions() {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put(IPropjavaOptions.RESOURCE_POSTPROCESSOR_PROVIDER, new PropertiesJavaPostProcessor());
		return options;
	}
}
