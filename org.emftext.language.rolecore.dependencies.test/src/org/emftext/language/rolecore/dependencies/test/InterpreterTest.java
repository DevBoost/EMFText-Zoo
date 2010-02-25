package org.emftext.language.rolecore.dependencies.test;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeFactory;
import org.eclipse.emf.ecore.change.FeatureChange;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.rolecore.dependencies.interpreter.InterpretationContext;
import org.emftext.language.rolecore.dependencies.interpreter.Interpreter;

import junit.framework.TestCase;

public class InterpreterTest extends TestCase {

	public void setUp() {
		// TODO register XMI resource factory
		// TODO register dependencies resource factory
	}
	
	public void testInterpretation() {
		// load instance models (family model and person model)
		EObject familyModel = loadModel("input/mueller.xmi");
		EObject personModel = loadModel("input/people.xmi");
		// load dependency models
		EObject dependencyModel = loadModel("input/families2persons.dependencies");
		
		// create change in memory (http://www.eclipse.org/emf/2003/Change)
		FeatureChange change = ChangeFactory.eINSTANCE.createFeatureChange();
		// TODO set change properties
		
		// execute interpreter
		Interpreter interpreter = new Interpreter();
		interpreter.interprete(dependencyModel, new InterpretationContext());
		
		// check result
	}

	private EObject loadModel(String pathName) {
		ResourceSet rs = new ResourceSetImpl();
		Resource r = rs.getResource(URI.createFileURI(pathName), true);
		return r.getContents().get(0);
	}
}
