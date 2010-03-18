package org.emftext.language.efactory.test;

import java.io.File;
import java.io.FileFilter;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.emftext.language.efactory.Factory;
import org.emftext.language.efactory.builder.Builder;
import org.emftext.language.efactory.resource.efactory.mopp.EfactoryMetaInformation;
import org.emftext.language.efactory.resource.efactory.mopp.EfactoryResourceFactory;

public class LoadTest extends TestCase {

	private final static String EFACTORY_EXTENSION = new EfactoryMetaInformation().getSyntaxName();
	
	private ResourceSet rs = new ResourceSetImpl();

	public void setUp() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore",
				new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				EFACTORY_EXTENSION,
				new EfactoryResourceFactory());

		registerEPackages();
	}

	private void registerEPackages() {
		File metamodelFolder = new File("." + File.separator + "metamodels");
		File[] metamodels = metamodelFolder.listFiles(new FileFilter() {
			
			public boolean accept(File file) {
				return file.getName().endsWith(".ecore");
			}
		});
		for (File metamodel : metamodels) {
			Resource resource = rs.getResource(URI.createFileURI(metamodel.getAbsolutePath()), true);
			assertNotNull(resource);
			EcoreUtil.resolveAll(resource);
			EList<EObject> contents = resource.getContents();
			for (EObject eObject : contents) {
				if (eObject instanceof EPackage) {
					EPackage ePackage = (EPackage) eObject;
					register(ePackage);
				}
			}
		}
	}

	private void register(EPackage ePackage) {
		String nsURI = ePackage.getNsURI();
		System.out.println("LoadTest.register() " + nsURI);
		Registry registry = EPackage.Registry.INSTANCE;
		if (registry.containsKey(nsURI)) {
			//return;
		}
		registry.put(nsURI, ePackage);
		EList<EPackage> eSubpackages = ePackage.getESubpackages();
		for (EPackage subPackage : eSubpackages) {
			register(subPackage);
		}
	}

	public void testLoadLargeModel() {
		testLoadModel("large.efactory");
	}

	public void testLoadSmallModels() {
		testLoadModel("enumtest.efactory");
		testLoadModel("small.efactory");
	}
	
	private void testLoadModel(String filename) {
		System.out.println("loading " + filename + "...");
		Resource resource = rs.getResource(URI.createFileURI("." + File.separator + "input_load" + File.separator + filename), true);
		EList<Diagnostic> errors = resource.getErrors();
		EList<Diagnostic> warnings = resource.getWarnings();
		print(errors, "Error: ");
		print(warnings, "Warning: ");
		assertEquals(0, errors.size());
		assertEquals(0, warnings.size());
		System.out.println("resolving " + filename + "...");
		EcoreUtil.resolveAll(resource);

		Builder builder = new Builder();

		System.out.println("building " + filename + "...");
		EList<EObject> contents = resource.getContents();
		for (EObject eObject : contents) {
			if (eObject instanceof Factory) {
				Factory eFactory = (Factory) eObject;
				EObject root = builder.build(eFactory);
				assertNotNull(root);
			}
		}
	}

	private void print(EList<Diagnostic> diagnostics, String string) {
		for (Diagnostic diagnostic : diagnostics) {
			System.out.println(string + diagnostic.getMessage());
		}
	}
}
