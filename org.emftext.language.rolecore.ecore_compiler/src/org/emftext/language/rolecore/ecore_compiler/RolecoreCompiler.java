package org.emftext.language.rolecore.ecore_compiler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.rolecore.CoreClass;
import org.emftext.language.rolecore.RCPackage;
import org.emftext.language.rolecore.Role;
import org.emftext.language.rolecore.resource.rolecore.IRolecoreOptionProvider;
import org.emftext.language.rolecore.resource.rolecore.IRolecoreOptions;
import org.emftext.language.rolecore.resource.rolecore.IRolecoreResourcePostProcessor;
import org.emftext.language.rolecore.resource.rolecore.IRolecoreResourcePostProcessorProvider;
import org.emftext.language.rolecore.resource.rolecore.mopp.RolecorePlugin;
import org.emftext.language.rolecore.resource.rolecore.mopp.RolecoreResource;

// TODO add code that delegates calls in role to core
// TODO add code for playsRole(), addRole(), removeRole()
public class RolecoreCompiler implements IRolecoreOptionProvider, IRolecoreResourcePostProcessorProvider, IRolecoreResourcePostProcessor {

	private static final String ROLES_REFERENCE_NAME = "roles";
	private static final String CORE_REFERENCE_NAME = "core";
	
	private Set<EClass> copyTargets = new LinkedHashSet<EClass>();

	public void process(final RolecoreResource resource) {
		List<EObject> contents = resource.getContents();
		if (contents == null) {
			return;
		}
		if (contents.size() == 0) {
			return;
		}
		RCPackage metaModel = (RCPackage) contents.get(0);
		final EPackage ePackage = compile(metaModel);

        new Job("saving derived Ecore model") {
        	
        	@Override
        	protected IStatus run(IProgressMonitor monitor) {
        		try {
        			URI uri = resource.getURI();
        			URI newUri = uri.trimFileExtension().appendFileExtension("ecore");
        			Resource eCoreResource = resource.getResourceSet().createResource(newUri);
        			eCoreResource.getContents().add(ePackage);
        			eCoreResource.save(null);
        		} catch (IOException e) {
        			RolecorePlugin.logError("Can't save compiled Ecore model.", e);
        		}
        		return Status.OK_STATUS;
        	}
        }.schedule();
	}
	
	private EPackage compile(RCPackage metaModel) {
		EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
		ePackage.setName(metaModel.getName());
		compileCoreClasses(metaModel.getCoreClasses(), ePackage);
		compileRoles(metaModel.getRoles(), ePackage);
		return ePackage;
	}

	private void compileCoreClasses(EList<CoreClass> coreClasses, EPackage ePackage) {
		for (CoreClass coreClass : coreClasses) {
			compileCoreClass(ePackage, coreClass);
		}
	}

	private void compileCoreClass(EPackage ePackage, CoreClass coreClass) {
		// create an interface for the core class
		findOrCreateCoreInterface(ePackage, coreClass);
		// create an implementation for the core class
		findOrCreateCoreClass(ePackage, coreClass);
	}

	private void compileRoles(EList<Role> roles, EPackage ePackage) {
		for (Role role : roles) {
			compileRole(ePackage, role);
		}
	}

	private void compileRole(EPackage ePackage, Role role) {
		// create an implementation for the role class
		// (must inherit from the core interface)
		findOrCreateConcreteRoleClass(ePackage, role);
	}

	private EClass findOrCreateConcreteRoleClass(EPackage ePackage, Role role) {
		CoreClass player = role.getPlayer();
		EClass abstractRoleClass = findOrCreateAbstractRoleClass(ePackage, player);
		EClass concreteRoleClass = findOrCreateEClass(ePackage, role, "", false, false, abstractRoleClass);
		copyEClassContents(role, concreteRoleClass);
		return concreteRoleClass;
	}

	private EClass findOrCreateAbstractRoleClass(EPackage ePackage, CoreClass coreClass) {
		EClass playerInterface = findOrCreateCoreInterface(ePackage, coreClass);
		EClass abstractRoleClass = findOrCreateEClass(ePackage, coreClass, "Role", true, false, playerInterface);
		// add a reference to the core
		findOrCreateCoreReference(abstractRoleClass, coreClass);
		//copyEClassContents(coreClass, abstractRoleClass);
		return abstractRoleClass;
	}

	private EClass findOrCreateCoreClass(EPackage ePackage, CoreClass coreClass) {
		EClass coreEInterface = findOrCreateCoreInterface(ePackage, coreClass);
		return findOrCreateEClass(ePackage, coreClass, "Core", false, false, coreEInterface);
	}
	
	private EClass findOrCreateCoreInterface(EPackage ePackage, CoreClass coreClass) {
		EClass coreInterface = findOrCreateEClass(ePackage, coreClass, "", true, true);
		// add reference to the roles that can by played by the core class
		findOrCreateRolesReference(coreInterface, coreClass);
		copyEClassContents(coreClass, coreInterface);
		return coreInterface;
	}
	
	/**
	 * Copies the content of 'from' (e.g., attributes, structural features,
	 * annotations and operations) to 'to':
	 * 
	 * @param from
	 * @param to
	 */
	private void copyEClassContents(EClass from, EClass to) {
		if (copyTargets.contains(to)) {
			return;
		}
		copyTargets.add(to);
		// TODO is this needed, or is it covers by copying the
		// structural features?
		List<EAttribute> attributes = from.getEAttributes();
		for (EAttribute attribute : attributes) {
			to.getEAttributes().add((EAttribute) EcoreUtil.copy(attribute));
		}

		List<EOperation> operations = from.getEOperations();
		for (EOperation operation : operations) {
			to.getEOperations().add((EOperation) EcoreUtil.copy(operation));
		}

		List<EStructuralFeature> features = from.getEStructuralFeatures();
		for (EStructuralFeature feature : features) {
			to.getEStructuralFeatures().add((EStructuralFeature) EcoreUtil.copy(feature));
		}
		
		// TODO copy annotations
	}

	private void findOrCreateCoreReference(EClass abstractRoleClass,
			CoreClass coreClass) {
		if (abstractRoleClass.getEStructuralFeature(CORE_REFERENCE_NAME) != null) {
			return;
		}
		EReference coreReference = EcoreFactory.eINSTANCE.createEReference();
		coreReference.setName(CORE_REFERENCE_NAME);
		coreReference.setLowerBound(1);
		coreReference.setUpperBound(1);
		coreReference.setContainment(false);
		abstractRoleClass.getEStructuralFeatures().add(coreReference);

		EClass coreEClass = findOrCreateCoreClass(abstractRoleClass.getEPackage(), coreClass);
		coreReference.setEType(coreEClass);
	}

	private void findOrCreateRolesReference(EClass coreInterface,
			CoreClass coreClass) {
		if (coreInterface.getEStructuralFeature(ROLES_REFERENCE_NAME) != null) {
			return;
		}
		EReference rolesReference = EcoreFactory.eINSTANCE.createEReference();
		rolesReference.setName(ROLES_REFERENCE_NAME);
		rolesReference.setLowerBound(0);
		rolesReference.setUpperBound(-1);
		rolesReference.setContainment(true);
		coreInterface.getEStructuralFeatures().add(rolesReference);

		EClass abstractRoleClass = findOrCreateAbstractRoleClass(coreInterface.getEPackage(), coreClass);
		rolesReference.setEType(abstractRoleClass);
	}

	private EClass findOrCreateEClass(EPackage ePackage, EClass roleOrCoreClass, String nameSuffix, boolean isAbstract, boolean isInterface) {
		List<EClass> superTypes = new ArrayList<EClass>();
		return findOrCreateEClass(ePackage, roleOrCoreClass, nameSuffix, isAbstract, isInterface, superTypes);
	}
	
	private EClass findOrCreateEClass(EPackage ePackage, EClass roleOrCoreClass, String nameSuffix, boolean isAbstract, boolean isInterface, EClass superType) {
		List<EClass> superTypes = new ArrayList<EClass>();
		superTypes.add(superType);
		return findOrCreateEClass(ePackage, roleOrCoreClass, nameSuffix, isAbstract, isInterface, superTypes);
	}
	
	private EClass findOrCreateEClass(EPackage ePackage, EClass roleOrCoreClass, String nameSuffix, boolean isAbstract, boolean isInterface, Collection<EClass> superTypes) {
		String name = roleOrCoreClass.getName() + nameSuffix;
		EClass coreEClass = (EClass) ePackage.getEClassifier(name);
		if (coreEClass == null) {
			// eClass does not exist yet
			coreEClass = EcoreFactory.eINSTANCE.createEClass();
			coreEClass.setName(name);
			coreEClass.setAbstract(isAbstract);
			coreEClass.setInterface(isInterface);
			if (superTypes != null) {
				for (EClass superType : superTypes) {
					coreEClass.getESuperTypes().add(superType);
				}
			}
			ePackage.getEClassifiers().add(coreEClass);
			return coreEClass;
		} else {
			// eClass was created before
			return coreEClass;
		}
	}

	public Map<?, ?> getOptions() {
		Map<String, Object> options = new LinkedHashMap<String, Object>();
		options.put(IRolecoreOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
		return options;
	}

	public IRolecoreResourcePostProcessor getResourcePostProcessor() {
		return new RolecoreCompiler();
	}
}
