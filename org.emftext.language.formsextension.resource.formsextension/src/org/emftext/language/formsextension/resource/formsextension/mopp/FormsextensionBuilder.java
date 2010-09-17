/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.formsextension.resource.formsextension.mopp;

import java.io.IOException;
import java.io.StringReader;
import java.util.Collections;
import java.util.HashMap;

import org.eclipse.core.internal.resources.WorkspaceRoot;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.PlatformResourceURIHandlerImpl.WorkbenchHelper;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.emftext.language.formsextension.ExtendedForm;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.JavaPackage;
import org.emftext.language.java.classifiers.Class;
import org.emftext.language.java.classifiers.ClassifiersFactory;
import org.emftext.language.java.expressions.Expression;
import org.emftext.language.java.expressions.ExpressionsFactory;
import org.emftext.language.java.expressions.impl.ExpressionsFactoryImpl;
import org.emftext.language.java.instantiations.InstantiationsFactory;
import org.emftext.language.java.instantiations.NewConstructorCall;
import org.emftext.language.java.members.ClassMethod;
import org.emftext.language.java.members.MembersFactory;
import org.emftext.language.java.references.MethodCall;
import org.emftext.language.java.references.ReferencesFactory;
import org.emftext.language.java.references.StringReference;
import org.emftext.language.java.statements.ExpressionStatement;
import org.emftext.language.java.statements.Statement;
import org.emftext.language.java.statements.StatementsFactory;
import org.emftext.language.java.types.ClassifierReference;
import org.emftext.language.java.types.NamespaceClassifierReference;
import org.emftext.language.java.types.TypesFactory;

public class FormsextensionBuilder implements org.emftext.language.formsextension.resource.formsextension.IFormsextensionBuilder {
	
	public boolean isBuildingNeeded(org.eclipse.emf.common.util.URI uri) {
		// change this to return true to enable building of all resources
		return true;
	}
	public org.eclipse.core.runtime.IStatus build(org.emftext.language.formsextension.resource.formsextension.mopp.FormsextensionResource resource, org.eclipse.core.runtime.IProgressMonitor monitor) {
		if (resource.getWarnings().size() + resource.getErrors().size() > 0) return org.eclipse.core.runtime.Status.CANCEL_STATUS; 
		EObject root = resource.getContents().get(0);
		if (root instanceof ExtendedForm) {
			ExtendedForm eform = (ExtendedForm) root;
			ClassMethod javaMethod = eform.getJavaMethod();
			EList<Statement> body = javaMethod.getStatements();
			
			NewConstructorCall constructorCall = InstantiationsFactory.eINSTANCE.createNewConstructorCall();
			ClassifierReference classifierRef = TypesFactory.eINSTANCE.createClassifierReference();
			
			Class clazz = ClassifiersFactory.eINSTANCE.createClass();
			clazz.setFullName("org.emftext.language.formular.interpreter.FormInterpreter");
			classifierRef.setTarget(clazz);
			constructorCall.setTypeReference(classifierRef);
			
			ExpressionStatement statement = StatementsFactory.eINSTANCE.createExpressionStatement();
			statement.setExpression(constructorCall);
			body.clear();
			body.add(statement);
			MethodCall methodCall = ReferencesFactory.eINSTANCE.createMethodCall();
			ClassMethod callMethod = MembersFactory.eINSTANCE.createClassMethod();
			callMethod.setName("interprete");
			methodCall.setTarget(callMethod);
			StringReference stringExpression = ReferencesFactory.eINSTANCE.createStringReference();
			IFile file = WorkspaceSynchronizer.getFile(resource);
			String uri = file.getProjectRelativePath().toString();
			stringExpression.setValue(uri);
			methodCall.getArguments().add(stringExpression );
			
			constructorCall.setNext(methodCall);
			
			
			try {
				
				javaMethod.eResource().save(Collections.EMPTY_MAP);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return org.eclipse.core.runtime.Status.CANCEL_STATUS;
			}
		}
		
		return org.eclipse.core.runtime.Status.OK_STATUS;
	}
	
}
