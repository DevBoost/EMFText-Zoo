/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.formsembedded.resource.formsembedded.mopp;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.formsembedded.EmbeddedForm;
import org.emftext.language.java.classifiers.Class;
import org.emftext.language.java.classifiers.ClassifiersFactory;
import org.emftext.language.java.expressions.CastExpression;
import org.emftext.language.java.expressions.ExpressionsFactory;
import org.emftext.language.java.instantiations.InstantiationsFactory;
import org.emftext.language.java.instantiations.NewConstructorCall;
import org.emftext.language.java.members.ClassMethod;
import org.emftext.language.java.members.MembersFactory;
import org.emftext.language.java.references.MethodCall;
import org.emftext.language.java.references.ReferencesFactory;
import org.emftext.language.java.references.StringReference;
import org.emftext.language.java.statements.LocalVariableStatement;
import org.emftext.language.java.statements.StatementListContainer;
import org.emftext.language.java.statements.StatementsFactory;
import org.emftext.language.java.types.ClassifierReference;
import org.emftext.language.java.types.TypesFactory;
import org.emftext.language.java.variables.LocalVariable;
import org.emftext.language.java.variables.VariablesFactory;

public class FormsembeddedBuilder
		implements
		org.emftext.language.formsembedded.resource.formsembedded.IFormsembeddedBuilder {

	public boolean isBuildingNeeded(org.eclipse.emf.common.util.URI uri) {
		return true;
	}

	public org.eclipse.core.runtime.IStatus build(
			org.emftext.language.formsembedded.resource.formsembedded.mopp.FormsembeddedResource resource,
			org.eclipse.core.runtime.IProgressMonitor monitor) {
		if (resource.getWarnings().size() + resource.getErrors().size() > 0)
			return org.eclipse.core.runtime.Status.CANCEL_STATUS;
		EObject root = resource.getContents().get(0);
		TreeIterator<EObject> eAllContents = root.eAllContents();
		while (eAllContents.hasNext()) {
			EObject eObject = (EObject) eAllContents.next();
			if (eObject instanceof EmbeddedForm) {
				EmbeddedForm ef = (EmbeddedForm) eObject;
				// prepare uris
				URI formsUri = resource.getURI().appendFileExtension("forms");
				URI javaUri = resource.getURI().trimFileExtension()
						.appendFileExtension("java");
				Resource formResource = resource.getResourceSet()
						.createResource(formsUri);
				formResource.getContents().add(ef.getForm());

				// call interpreter constructor
				NewConstructorCall constructorCall = InstantiationsFactory.eINSTANCE
						.createNewConstructorCall();
				ClassifierReference classifierRef = TypesFactory.eINSTANCE
						.createClassifierReference();
				Class clazz = ClassifiersFactory.eINSTANCE.createClass();
				clazz
						.setFullName("org.emftext.language.formular.interpreter.FormInterpreter");
				classifierRef.setTarget(clazz);
				constructorCall.setTypeReference(classifierRef);

				
				// load form
				MethodCall methodCall = ReferencesFactory.eINSTANCE
						.createMethodCall();
				ClassMethod callMethod = MembersFactory.eINSTANCE
						.createClassMethod();
				callMethod.setName("load");
				methodCall.setTarget(callMethod);
				StringReference stringExpression = ReferencesFactory.eINSTANCE
						.createStringReference();
				stringExpression.setValue(formsUri.toString());
				methodCall.getArguments().add(stringExpression);
				constructorCall.setNext(methodCall);

				// assign loaded form to variable
				LocalVariableStatement variableStatement = StatementsFactory.eINSTANCE
						.createLocalVariableStatement();
				LocalVariable variable = VariablesFactory.eINSTANCE
						.createLocalVariable();
				variableStatement.setVariable(variable);
				variable.setName(ef.getName());
				Class formClass = ClassifiersFactory.eINSTANCE.createClass();
				formClass.setFullName("org.emftext.language.forms.Form");
				ClassifierReference formClassifierRef = TypesFactory.eINSTANCE
						.createClassifierReference();
				formClassifierRef.setTarget(formClass);
				variable.setTypeReference(formClassifierRef);
		
				
				CastExpression ce = ExpressionsFactory.eINSTANCE.createCastExpression();
				ClassifierReference castClassifierRef = TypesFactory.eINSTANCE
				.createClassifierReference();
				castClassifierRef.setTarget(formClass);
				ce.setTypeReference(castClassifierRef);
				ce.setChild(constructorCall);
				
				variable.setInitialValue(ce);

				
				// replace embedded form declaration with local variable
				StatementListContainer statementListContainer = (StatementListContainer) ef
						.eContainer();
				int formIndex = statementListContainer.getStatements().indexOf(
						ef);
				statementListContainer.getStatements().remove(formIndex);
				statementListContainer.getStatements()
						.add(formIndex, variableStatement);

				// create according java resource
				Resource javaResource = resource.getResourceSet()
						.createResource(javaUri);
				javaResource.getContents().add(root);

				try {
					javaResource.save(Collections.EMPTY_MAP);
					formResource.save(Collections.EMPTY_MAP);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return org.eclipse.core.runtime.Status.CANCEL_STATUS;
				}

			}
		}
		return org.eclipse.core.runtime.Status.OK_STATUS;
	}

}
