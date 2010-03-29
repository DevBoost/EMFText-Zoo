package org.emftext.language.rolecore.dependencies.test;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.ChangePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.emftext.language.rolecore.dependencies.Graph;
import org.emftext.language.rolecore.dependencies.interpreter.DomainRoot;
import org.emftext.language.rolecore.dependencies.interpreter.EqualTraceLink;
import org.emftext.language.rolecore.dependencies.interpreter.InterpretationContext;
import org.emftext.language.rolecore.dependencies.interpreter.Interpreter;
import org.emftext.language.rolecore.dependencies.interpreter.InterpreterPackage;
import org.emftext.language.rolecore.dependencies.resource.dependencies.mopp.DependenciesMetaInformation;
import org.emftext.language.rolecore.dependencies.resource.dependencies.mopp.DependenciesResourceFactory;
import org.emftext.language.rolecore.riehle97.Riehle97Package;
import org.emftext.language.rolecore.families.FamiliesPackage;
import org.emftext.language.rolecore.persons.PersonsPackage;
import org.emftext.language.rolecore.resource.rolecore.mopp.RolecoreMetaInformation;
import org.emftext.language.rolecore.resource.rolecore.mopp.RolecoreResourceFactory;

import junit.framework.TestCase;

public class InterpreterTest extends TestCase {

	public void setUp() {
		// register the Factories
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				new RolecoreMetaInformation().getSyntaxName(), new RolecoreResourceFactory());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				new DependenciesMetaInformation().getSyntaxName(), new DependenciesResourceFactory());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("change", new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		// register the Packages
		register(FamiliesPackage.eINSTANCE);
		register(PersonsPackage.eINSTANCE);
		register(Riehle97Package.eINSTANCE);
		register(InterpreterPackage.eINSTANCE);
		register(ChangePackage.eINSTANCE);
	}

	public void testInterpretation() {
		InterpretationContext interpretationContext = new InterpretationContext();
		String inputURI = "./input/";
		String outputURI = "./output/";
		// create the source to test, can be removed after getting the resources
		ChangeDescriptionCreator cdCreator = new ChangeDescriptionCreator(interpretationContext, inputURI);

		// load instance models
		interpretationContext.addResource(interpretationContext.loadResource(inputURI + "customersA.xmi"));
		interpretationContext.addResource(interpretationContext.loadResource(inputURI + "customersB.xmi"));

		// load dependency models
		Map<String, Graph> dependencies = new HashMap<String, Graph>();
		dependencies.put("customer", (Graph) interpretationContext.loadResource(inputURI + "customer.dependencies")
				.getContents().get(0));
		interpretationContext.setDependencies(dependencies);
		// create change in memory (http://www.eclipse.org/emf/2003/Change)
		ChangeDescription addCustomerToCustomerADC = cdCreator.createAddCustomerToResourceCD(interpretationContext
				.getResources().get(0));
		// execute interpreter
		Interpreter interpreter = new Interpreter();
		if (interpreter.interprete(addCustomerToCustomerADC, interpretationContext)) {
			System.out.println("Synchronization is successful!");
		}
		// save things to output
		interpretationContext.saveResource(addCustomerToCustomerADC, outputURI + "addCustomerToCustomersA.change.xmi");
		interpretationContext.saveResource(interpretationContext.getResources().get(0), outputURI + "customersA.xmi");
		interpretationContext.saveResource(interpretationContext.getResources().get(1), outputURI + "customersB.xmi");
		interpretationContext.saveResource(interpretationContext.findOrCreateTraceLinksDomainRoot(), outputURI
				+ "customersABTraceLinks.xmi");
		// check result
		DomainRoot customersADR = interpretationContext.findOrCreateDomainRoot("customersA");
		DomainRoot customersBDR = interpretationContext.findOrCreateDomainRoot("customersB");
		DomainRoot traceLinksDR = interpretationContext.findOrCreateTraceLinksDomainRoot();
		assertNotNull("Domain root customersA doesn't exist", customersADR);
		assertNotNull("Domain root customersB doesn't exist", customersBDR);
		assertNotNull("Domain root trace links doens't exist", traceLinksDR);
		assertTrue("customersA has no elements", customersADR.getEObjects().size()>0);
		assertNotNull("CustomerCore is not in customersA", customersADR.getEObjects().get(0));
		EObject customerA = customersADR.getEObjects().get(0);
		assertTrue("customersB has no elements", customersBDR.getEObjects().size()>0);
		assertNotNull("CustomerCore is not in customersB", customersBDR.getEObjects().get(0));
		EObject customerB = customersBDR.getEObjects().get(0);
		assertNotNull("A trace link doesn't exist", traceLinksDR.getEObjects().get(0));
		assertTrue("The first object is not an equal trace link", traceLinksDR.getEObjects().get(0) instanceof EqualTraceLink);
		EqualTraceLink equalTraceLink = (EqualTraceLink) traceLinksDR.getEObjects().get(0);
		assertEquals(customerA, equalTraceLink.getSource());
		assertEquals(customerB, equalTraceLink.getTarget());
	}

	private void register(EPackage ePackage) {
		String nsURI = ePackage.getNsURI();
		System.out.println("LoadTest.register() " + nsURI);
		EPackage.Registry.INSTANCE.put(nsURI, ePackage);
		EList<EPackage> eSubpackages = ePackage.getESubpackages();
		for (EPackage subPackage : eSubpackages) {
			register(subPackage);
		}
	}
}
