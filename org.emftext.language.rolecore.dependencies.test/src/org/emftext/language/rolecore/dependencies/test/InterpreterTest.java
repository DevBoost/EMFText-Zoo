package org.emftext.language.rolecore.dependencies.test;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.ChangePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.emftext.language.rolecore.RolecorePackage;
import org.emftext.language.rolecore.blockclassbase.BlockclassbasePackage;
import org.emftext.language.rolecore.blockclassbase.Name;
import org.emftext.language.rolecore.blockdomain.BlockDiagramCore;
import org.emftext.language.rolecore.blockdomain.BlockdomainPackage;
import org.emftext.language.rolecore.classdomain.ClassDiagramCore;
import org.emftext.language.rolecore.classdomain.ClassdomainPackage;
import org.emftext.language.rolecore.classdomain.StereotypeCore;
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

	private String inputURI = "./input/";
	private String outputURI = "./output/";
	private ChangeDescriptionCreator cdCreator;
	private InterpretationContext context;
	private List<Graph> dependencies;
	
	public void setUp() {
		// register the Factories
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				new RolecoreMetaInformation().getSyntaxName(), new RolecoreResourceFactory());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				new DependenciesMetaInformation().getSyntaxName(), new DependenciesResourceFactory());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("change", new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		// register the Packages
		/*register(FamiliesPackage.eINSTANCE);
		register(PersonsPackage.eINSTANCE);*/
		register(Riehle97Package.eINSTANCE);
		register(InterpreterPackage.eINSTANCE);
		register(ChangePackage.eINSTANCE);
		register(BlockdomainPackage.eINSTANCE);
		register(ClassdomainPackage.eINSTANCE);
		register(BlockclassbasePackage.eINSTANCE);
		register(RolecorePackage.eINSTANCE);
		context = new InterpretationContext();
		cdCreator = new ChangeDescriptionCreator(context, inputURI);
		dependencies = new ArrayList<Graph>();
	}

	public void testAddCustomer() {
		// load instance models
		Resource customerAResource = context.loadResource(inputURI + "customersA.xmi");
		Resource customerBResource = context.loadResource(inputURI + "customersB.xmi");
		context.addResource(customerAResource);
		context.addResource(customerBResource);

		// load dependency models
		dependencies.add((Graph) context.loadResource(inputURI + "customer.dependencies").getContents()
				.get(0));
		context.setDependencies(dependencies);
		// create change in memory (http://www.eclipse.org/emf/2003/Change)
		ChangeDescription addCustomerToCustomerADC = cdCreator.createAddCustomerToResourceCD(customerAResource);
		// execute interpreter
		Interpreter interpreter = new Interpreter();
		if (interpreter.interprete(addCustomerToCustomerADC, context)) {
			System.out.println("Synchronization is successful!");
		}
		// save things to output
		context.saveResource(addCustomerToCustomerADC, outputURI + "addCustomerToCustomersA.change.xmi");
		context.saveResource(customerAResource, outputURI + "customersA.xmi");
		context.saveResource(customerBResource, outputURI + "customersB.xmi");
		context.saveResource(context.findOrCreateTraceLinksDomainRoot(), outputURI
				+ "customersABTraceLinks.xmi");
		// check result
		DomainRoot customersADR = context.findOrCreateDomainRoot("customersA");
		DomainRoot customersBDR = context.findOrCreateDomainRoot("customersB");
		DomainRoot traceLinksDR = context.findOrCreateTraceLinksDomainRoot();
		assertNotNull("Domain root customersA doesn't exist", customersADR);
		assertNotNull("Domain root customersB doesn't exist", customersBDR);
		assertNotNull("Domain root trace links doens't exist", traceLinksDR);
		assertTrue("customersA has no elements", customersADR.getEObjects().size() > 0);
		assertNotNull("CustomerCore is not in customersA", customersADR.getEObjects().get(0));
		EObject customerA = customersADR.getEObjects().get(0);
		assertTrue("customersB has no elements", customersBDR.getEObjects().size() > 0);
		assertNotNull("CustomerCore is not in customersB", customersBDR.getEObjects().get(0));
		EObject customerB = customersBDR.getEObjects().get(0);
		assertNotNull("A trace link doesn't exist", traceLinksDR.getEObjects().get(0));
		assertTrue("The first object is not an equal trace link",
				traceLinksDR.getEObjects().get(0) instanceof EqualTraceLink);
		EqualTraceLink equalTraceLink = (EqualTraceLink) traceLinksDR.getEObjects().get(0);
		assertEquals(customerA, equalTraceLink.getSource());
		assertEquals(customerB, equalTraceLink.getTarget());
	}

	public void testAddClassDiagram() {
		// load dependency models
		// TODO add more dependencies
		dependencies.add((Graph) context.loadResource(inputURI + "bctest01.dependencies").getContents()
				.get(0));
		context.setDependencies(dependencies);
		// create change in memory (http://www.eclipse.org/emf/2003/Change)
		ChangeDescription addClassDiagramDC = cdCreator.createAddClassDiagram("classDomain");
		// execute interpreter
		Interpreter interpreter = new Interpreter();
		if (interpreter.interprete(addClassDiagramDC, context)) {
			System.out.println("Synchronization is successful!");
		}
		// save things to output
		saveDomainRootsToResources(context, outputURI, "Scene01");
		// check result
		DomainRoot classDomainDR = context.findOrCreateDomainRoot("classDomain");
		DomainRoot blockDomainDR = context.findOrCreateDomainRoot("blockDomain");
		DomainRoot traceLinksDR = context.findOrCreateTraceLinksDomainRoot();
		assertNotNull(classDomainDR);
		assertNotNull(blockDomainDR);
		assertNotNull(traceLinksDR);
		assertTrue(classDomainDR.getEObjects().size() > 0);
		assertNotNull(classDomainDR.getEObjects().get(0));
		EObject classDiagram = classDomainDR.getEObjects().get(0);
		assertTrue(classDiagram instanceof ClassDiagramCore);
		assertTrue(blockDomainDR.getEObjects().size() > 0);
		assertNotNull(blockDomainDR.getEObjects().get(0));
		EObject blockDiagram = blockDomainDR.getEObjects().get(0);
		assertTrue(blockDiagram instanceof BlockDiagramCore);
		assertNotNull(traceLinksDR.getEObjects().get(0));
		assertTrue(traceLinksDR.getEObjects().get(0) instanceof EqualTraceLink);
		EqualTraceLink equalTraceLink = (EqualTraceLink) traceLinksDR.getEObjects().get(0);
		// this is based on dependencies specification
		assertEquals(blockDiagram, equalTraceLink.getSource());
		assertEquals(classDiagram, equalTraceLink.getTarget());
	}
	
	public void testAddSystemBlock(){
		//load resources
		context.addResource(context.loadResource(inputURI+"Scene02blockDomain.xmi"));
		context.addResource(context.loadResource(inputURI+"Scene02classDomain.xmi"));
		context.addResource(context.loadResource(inputURI+"Scene02TraceLinks.xmi"));
		// load dependency models
		// TODO test more dependencies
		dependencies.add((Graph) context.loadResource(inputURI + "bctest01.dependencies").getContents()
				.get(0));
		dependencies.add((Graph) context.loadResource(inputURI + "bctest02.dependencies").getContents()
				.get(0));
		context.setDependencies(dependencies);
		// create change in memory (http://www.eclipse.org/emf/2003/Change)
		// domain name is in the dependencies
		ChangeDescription addSystemBlockDC = cdCreator.createSystemBlock("blockDomain");
		// execute interpreter
		Interpreter interpreter = new Interpreter();
		if (interpreter.interprete(addSystemBlockDC, context)) {
			System.out.println("Synchronization is successful!");
		}
		// save domain roots to output, there is a base resource
		saveDomainRootsToResources(context, outputURI, "Scene02");
		// check result
		DomainRoot classDomainDR = context.findOrCreateDomainRoot("classDomain");
		DomainRoot blockDomainDR = context.findOrCreateDomainRoot("blockDomain");
		DomainRoot traceLinksDR = context.findOrCreateTraceLinksDomainRoot();
		EObject stereotype = getCoreEObject(classDomainDR, ClassdomainPackage.eINSTANCE.getStereotypeCore());
		assertNotNull(stereotype);
		EClass name = BlockclassbasePackage.eINSTANCE.getName_();
		Name stereotypeName = (Name) getRoleOf(stereotype, name); 
		assertNotNull(stereotypeName);
		assertEquals("system", stereotypeName.getName());
		EObject classEObject = getCoreEObject(classDomainDR, ClassdomainPackage.eINSTANCE.getClassCore());
		assertNotNull(classEObject);
		EObject systemBlock = getCoreEObject(blockDomainDR, BlockdomainPackage.eINSTANCE.getSystemBlockCore());
		assertNotNull(systemBlock);
		EObject synchSystemBlock = getSynchronizedObject(classEObject, traceLinksDR);
		assertNotNull(synchSystemBlock);
		assertEquals(systemBlock, synchSystemBlock);
		EObject className = getRoleOf(classEObject, name);
		assertNotNull(className);
		EObject systemBlockName = getRoleOf(systemBlock, name);
		assertEquals(className, systemBlockName);
	}

	private EObject getSynchronizedObject(EObject coreEObject, DomainRoot traceLinksDR) {
		for (EObject eObject : traceLinksDR.getEObjects()) {
			if(eObject instanceof EqualTraceLink){
				EqualTraceLink link = (EqualTraceLink) eObject;
				if (link.getSource().equals(coreEObject)){
					return link.getTarget();
				}
				if (link.getTarget().equals(coreEObject)){
					return link.getSource();
				}
			}
		}
		return null;
	}

	private EObject getRoleOf(EObject coreEObject, EClass role) {
		List<EObject> roles = context.getRoleEObjects(coreEObject, role);
		if (roles!=null&&roles.size()>0){
			return roles.get(0);
		}
		return null;
	}

	private EObject getCoreEObject(DomainRoot domainRoot, EClass coreEClass) {
		List<EObject> coreEObjects = getCoreEObjects(domainRoot, coreEClass);
		if (coreEObjects.size()>0){
			return coreEObjects.get(0);
		}
		return null;
	}

	private List<EObject> getCoreEObjects(DomainRoot classDomainDR, EClass coreEClass) {
		List<EObject> coreEObjects = new ArrayList<EObject>();
		for (EObject eObject : classDomainDR.getEObjects()) {
			if (eObject.eClass().equals(coreEClass)){
				coreEObjects.add(eObject);
			}
		}
		return coreEObjects;
	}

	private void saveDomainRootsToResources(InterpretationContext context, String location, String prefix) {
		ResourceSet resourceSet = new ResourceSetImpl();
		List<Resource> resources = new ArrayList<Resource>();
		for (DomainRoot domainRoot : context.getDomainRoots()) {
			Resource resource = resourceSet.createResource(URI.createFileURI(location + prefix + domainRoot.getName() + ".xmi"));
			resource.getContents().add(domainRoot);
			resources.add(resource);
		}
		for (Resource resource : resources) {
			context.saveResource(resource, null);
		}
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
