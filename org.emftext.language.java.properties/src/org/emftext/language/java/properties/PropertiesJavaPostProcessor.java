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
import org.emftext.language.java.literals.LiteralsFactory;
import org.emftext.language.java.members.ClassMethod;
import org.emftext.language.java.members.Field;
import org.emftext.language.java.members.MembersFactory;
import org.emftext.language.java.modifiers.ModifiersFactory;
import org.emftext.language.java.statements.Return;
import org.emftext.language.java.statements.StatementsFactory;
import org.emftext.language.java.types.TypeReference;
import org.emftext.runtime.IOptionProvider;
import org.emftext.runtime.IOptions;
import org.emftext.runtime.IResourcePostProcessor;
import org.emftext.runtime.IResourcePostProcessorProvider;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.util.EObjectUtil;
import org.emftext.runtime.util.StringUtil;

public class PropertiesJavaPostProcessor implements IResourcePostProcessor,
	IResourcePostProcessorProvider, IOptionProvider {

	public static void main(String[] args) {
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(URI.createFileURI("pathToPropJavaFile.propjava"));
		if (resource instanceof ITextResource) {
			new PropertiesJavaPostProcessor().process((ITextResource) resource);
		}
	}
	
	public void process(Resource resource) {
		URI javaURI = resource.getURI().trimFileExtension().appendFileExtension("java");
		Resource javaResource = resource.getResourceSet().createResource(javaURI);
		javaResource.getContents().addAll(
				EcoreUtil.copyAll(resource.getContents()));
		
		boolean changed = true;
		
		while (changed) {
			changed = false;
			Collection<Property> properties = EObjectUtil.getObjectsByType(javaResource.getAllContents(), PropertiesPackage.eINSTANCE.getProperty());
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
		getterMethod.setName("get" + StringUtil.capitalize(property.getName()));
		
		Return returnStatement = StatementsFactory.eINSTANCE.createReturn();
		// TODO return field instead of null
		returnStatement.setReturnValue(LiteralsFactory.eINSTANCE.createNullLiteral());
		
		getterMethod.getStatements().add(returnStatement);
		
		TypeReference tReferenceCopy = (TypeReference) EcoreUtil.copy(typeReference);
		getterMethod.setTypeReference(tReferenceCopy);
		
		property.getContainer().getMembers().add(getterMethod);
		EcoreUtil.replace(property, field);
	}

	public IResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	public Map<?, ?> getOptions() {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put(IOptions.RESOURCE_POSTPROCESSOR_PROVIDER, new PropertiesJavaPostProcessor());
		return options;
	}
}
