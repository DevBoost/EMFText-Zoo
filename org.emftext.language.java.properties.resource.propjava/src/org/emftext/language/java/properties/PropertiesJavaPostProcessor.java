package org.emftext.language.java.properties;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.access.resource.ITextResource;
import org.emftext.language.java.literals.LiteralsFactory;
import org.emftext.language.java.members.ClassMethod;
import org.emftext.language.java.members.Field;
import org.emftext.language.java.members.MembersFactory;
import org.emftext.language.java.modifiers.ModifiersFactory;
import org.emftext.language.java.properties.resource.propjava.IPropjavaOptionProvider;
import org.emftext.language.java.properties.resource.propjava.IPropjavaOptions;
import org.emftext.language.java.properties.resource.propjava.IPropjavaResourcePostProcessor;
import org.emftext.language.java.properties.resource.propjava.IPropjavaResourcePostProcessorProvider;
import org.emftext.language.java.properties.resource.propjava.mopp.PropjavaResource;
import org.emftext.language.java.properties.resource.propjava.util.PropjavaEObjectUtil;
import org.emftext.language.java.properties.resource.propjava.util.PropjavaStringUtil;
import org.emftext.language.java.statements.Return;
import org.emftext.language.java.statements.StatementsFactory;
import org.emftext.language.java.types.TypeReference;

public class PropertiesJavaPostProcessor implements IPropjavaResourcePostProcessor,
	IPropjavaResourcePostProcessorProvider, IPropjavaOptionProvider {

	public static void main(String[] args) {
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(URI.createFileURI("pathToPropJavaFile.propjava"));
		if (resource instanceof ITextResource) {
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
		Field field = MembersFactory.eINSTANCE.createField();
		field.setName(property.getName());
		TypeReference typeReference = property.getTypeReference();
		field.setTypeReference(typeReference);
		field.getAnnotationsAndModifiers().add(ModifiersFactory.eINSTANCE.createPrivate());
		
		ClassMethod getterMethod = MembersFactory.eINSTANCE.createClassMethod();
		getterMethod.setName("get" + PropjavaStringUtil.capitalize(property.getName()));
		
		Return returnStatement = StatementsFactory.eINSTANCE.createReturn();
		// TODO return field instead of null
		returnStatement.setReturnValue(LiteralsFactory.eINSTANCE.createNullLiteral());
		
		getterMethod.getStatements().add(returnStatement);
		
		TypeReference tReferenceCopy = (TypeReference) EcoreUtil.copy(typeReference);
		getterMethod.setTypeReference(tReferenceCopy);
		
		property.getContainer().getMembers().add(getterMethod);
		EcoreUtil.replace(property, field);
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
