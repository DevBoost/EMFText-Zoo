package org.emftext.language.featherweight_java.resource.fj.analysis.helper;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.featherweight_java.Class;
import org.emftext.language.featherweight_java.Featherweight_javaFactory;
import org.emftext.runtime.resource.IReferenceResolveResult;
import org.emftext.runtime.util.EObjectUtil;

// TODO maybe we should add resolving for files that are in the same directory
public class ClassResolver {
	
	private final static org.emftext.language.featherweight_java.Class OBJECT = Featherweight_javaFactory.eINSTANCE.createClass();
	
	static {
		OBJECT.setName("Object");
	}

	public void resolve(String identifier, EObject container,
			IReferenceResolveResult<Class> result) {

		Resource resource = container.eResource();
		Collection<org.emftext.language.featherweight_java.Class> classes = EObjectUtil.getObjectsByType(resource.getAllContents(), org.emftext.language.featherweight_java.Featherweight_javaPackage.eINSTANCE.getClass_());
		for (Class nextClass : classes) {
			if (identifier.equals(nextClass.getName())) {
				result.addMapping(identifier, nextClass);
				return;
			}
		}
		if (identifier.equals(OBJECT.getName())) {
			result.addMapping(identifier, OBJECT);
		}
	}

	public String deResolve(Class element, EObject container, EReference reference) {
		return element.getName();
	}
}
