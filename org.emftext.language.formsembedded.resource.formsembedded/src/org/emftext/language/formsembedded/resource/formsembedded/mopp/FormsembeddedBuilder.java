
package org.emftext.language.formsembedded.resource.formsembedded.mopp;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.formsembedded.EmbeddedForm;
import org.emftext.language.formsembedded.FormsembeddedPackage;
import org.emftext.language.formsembedded.resource.formsembedded.IFormsembeddedBuilder;
import org.emftext.language.formsembedded.resource.formsembedded.util.FormsembeddedEObjectUtil;
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
import org.emftext.language.java.types.ClassifierReference;
import org.emftext.language.java.types.TypesFactory;

public class FormsembeddedBuilder implements IFormsembeddedBuilder {

	public boolean isBuildingNeeded(URI uri) {
		return true;
	}

	public IStatus build(FormsembeddedResource resource, IProgressMonitor monitor) {
		if (resource.getWarnings().size() + resource.getErrors().size() > 0) {
			return org.eclipse.core.runtime.Status.CANCEL_STATUS;
		}
		
		EObject root = resource.getContents().get(0);
		TreeIterator<EObject> eAllContents = root.eAllContents();
		Collection<EmbeddedForm> embeddedFoms = FormsembeddedEObjectUtil.getObjectsByType(eAllContents, FormsembeddedPackage.eINSTANCE.getEmbeddedForm());
		for (EmbeddedForm embeddedForm : embeddedFoms) {
			// prepare URIs
			URI formsUri = resource.getURI().appendFileExtension("forms");
			URI javaUri = resource.getURI().trimFileExtension().appendFileExtension("java");
			Resource formResource = resource.getResourceSet().createResource(formsUri);
			formResource.getContents().add(embeddedForm.getForm());

			// call interpreter constructor
			NewConstructorCall constructorCall = InstantiationsFactory.eINSTANCE.createNewConstructorCall();
			ClassifierReference classifierRef = TypesFactory.eINSTANCE.createClassifierReference();
			Class clazz = ClassifiersFactory.eINSTANCE.createClass();
			clazz.setFullName("org.emftext.language.forms.interpreter.FormInterpreter");
			classifierRef.setTarget(clazz);
			constructorCall.setTypeReference(classifierRef);
			
			// load form
			MethodCall methodCall = ReferencesFactory.eINSTANCE.createMethodCall();
			ClassMethod callMethod = MembersFactory.eINSTANCE.createClassMethod();
			callMethod.setName("load");
			methodCall.setTarget(callMethod);
			StringReference stringExpression = ReferencesFactory.eINSTANCE.createStringReference();
			stringExpression.setValue(formsUri.toString());
			methodCall.getArguments().add(stringExpression);
			constructorCall.setNext(methodCall);

			// loaded form
			Class formClass = ClassifiersFactory.eINSTANCE.createClass();
			formClass.setFullName("org.emftext.language.forms.Form");
			
			CastExpression ce = ExpressionsFactory.eINSTANCE.createCastExpression();
			ClassifierReference castClassifierRef = TypesFactory.eINSTANCE.createClassifierReference();
			castClassifierRef.setTarget(formClass);
			ce.setTypeReference(castClassifierRef);
			ce.setChild(constructorCall);
			
			EcoreUtil.replace(embeddedForm, ce);

			// create according java resource
			Resource javaResource = resource.getResourceSet().createResource(javaUri);
			javaResource.getContents().add(root);

			try {
				javaResource.save(Collections.EMPTY_MAP);
				formResource.save(Collections.EMPTY_MAP);
			} catch (IOException e) {
				e.printStackTrace();
				return org.eclipse.core.runtime.Status.CANCEL_STATUS;
			}
		}
		return org.eclipse.core.runtime.Status.OK_STATUS;
	}
}
