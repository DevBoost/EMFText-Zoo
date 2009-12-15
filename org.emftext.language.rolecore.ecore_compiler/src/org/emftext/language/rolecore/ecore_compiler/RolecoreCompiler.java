/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
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
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EContentsEList;
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
	private static final String HAS_ROLE_OPERATION_NAME = "hasRole";
	private static final String GET_ROLE_OPERATION_NAME = "getRole";
	private static final String ADD_ROLE_OPERATION_NAME = "addRole";
	
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
		// TODO validate 'metaModel' and exit processing if
		// 'metaModel' is invalid
		try {
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
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private EPackage compile(RCPackage metaModel) {
		EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
		ePackage.setName(metaModel.getName());
		ePackage.setNsPrefix(metaModel.getNsPrefix());
		ePackage.setNsURI(metaModel.getNsURI());
		
		compileCoreClasses(metaModel.getCoreClasses(), ePackage);
		compileRoles(metaModel.getRoles(), ePackage);
		replaceReferencesToRolesAndCoreClasses(ePackage);
		return ePackage;
	}

	private void replaceReferencesToRolesAndCoreClasses(EPackage ePackage) {
		replaceCrossReferences(ePackage, ePackage);
	}

	private void replaceCrossReferences(EPackage ePackage, EObject current) {
		EContentsEList.FeatureIterator<EObject> featureIterator = (EContentsEList.FeatureIterator<EObject>) current.eCrossReferences().iterator();
		while (featureIterator.hasNext()) {
		    EObject eObject = (EObject) featureIterator.next();
		    EReference eReference = (EReference) featureIterator.feature();
		  
			if (eObject instanceof Role) {
				// TODO maybe we need to use the abstract role class here?
				EClass concreteRoleClass = findOrCreateConcreteRoleClass(ePackage, (Role) eObject);
				replace(current, eObject, eReference, concreteRoleClass);
			}
			if (eObject instanceof CoreClass) {
				EClass coreClassInterface = findOrCreateCoreInterface(ePackage, (CoreClass) eObject);
				replace(current, eObject, eReference, coreClassInterface);
			}
		}
		for (EObject eObject : current.eContents()) {
			replaceCrossReferences(ePackage, eObject);
		}
	}

	private void replace(EObject referencingObject, EObject oldReferencedObject,
			EReference eReference, EObject newReferencedObject) {
		Object referenceValue = referencingObject.eGet(eReference);
		if (referenceValue instanceof List<?>) {
			List<EObject> referenceList = (List<EObject>) referenceValue;
			int oldIndex = referenceList.indexOf(oldReferencedObject);
			referenceList.remove(oldIndex);
			if (oldIndex == referenceList.size()) {
				referenceList.add(newReferencedObject);
			} else {
				referenceList.add(oldIndex, newReferencedObject);
			}
		} else {
			referencingObject.eSet(eReference, newReferencedObject);
		}
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
		if (copyTargets.contains(concreteRoleClass)) {
			return concreteRoleClass;
		}
		copyTargets.add(concreteRoleClass);
		// TODO is this needed? the concrete role classes inherit from
		// the core interface anyway?
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
		if (copyTargets.contains(coreInterface)) {
			return coreInterface;
		}
		copyTargets.add(coreInterface);
		copyEClassContents(coreClass, coreInterface);
		addRoleHandlingMethods(coreClass, coreInterface);
		return coreInterface;
	}
	
	private void addRoleHandlingMethods(CoreClass coreClass, EClass coreInterface) {
		addHasRoleOperation(coreInterface);
		addGetRoleOperation(coreInterface);
		addAddRoleOperation(coreClass, coreInterface);
	}

	private void addAddRoleOperation(CoreClass coreClass, EClass coreInterface) {
		//EClass eObject = EcorePackage.eINSTANCE.getEObject();
		EClass abstractRoleClass = findOrCreateAbstractRoleClass(coreInterface.getEPackage(), coreClass);

		ETypeParameter typeParameterT = EcoreFactory.eINSTANCE.createETypeParameter();
		typeParameterT.setName("T");
		EGenericType lowerBound = EcoreFactory.eINSTANCE.createEGenericType();
		lowerBound.setEClassifier(abstractRoleClass);
		EGenericType lower = EcoreFactory.eINSTANCE.createEGenericType();
		lower.setELowerBound(lowerBound);
		typeParameterT.getEBounds().add(lowerBound);

		EOperation addRoleOperation = EcoreFactory.eINSTANCE.createEOperation();
		addRoleOperation.setName(ADD_ROLE_OPERATION_NAME);

		addRoleOperation.getETypeParameters().add(typeParameterT);
		
		EParameter roleParameter = EcoreFactory.eINSTANCE.createEParameter();
		roleParameter.setName("role");
		roleParameter.setEGenericType(createT(typeParameterT));
		
		addRoleOperation.getEParameters().add(roleParameter);
		
		coreInterface.getEOperations().add(addRoleOperation);
	}

	private void addGetRoleOperation(EClass coreInterface) {
		ETypeParameter typeParameterT = EcoreFactory.eINSTANCE.createETypeParameter();
		typeParameterT.setName("T");

		EOperation getRoleOperation = EcoreFactory.eINSTANCE.createEOperation();
		getRoleOperation.setName(GET_ROLE_OPERATION_NAME);
		getRoleOperation.setEGenericType(createT(typeParameterT));
		getRoleOperation.getETypeParameters().add(typeParameterT);
		
		EParameter roleClassParameter = EcoreFactory.eINSTANCE.createEParameter();
		roleClassParameter.setName("roleClass");

		roleClassParameter.setEGenericType(createClassT(typeParameterT));
		
		getRoleOperation.getEParameters().add(roleClassParameter);
		
		coreInterface.getEOperations().add(getRoleOperation);
	}

	private void addHasRoleOperation(EClass coreInterface) {
		EDataType eBoolean = EcorePackage.eINSTANCE.getEBoolean();

		ETypeParameter typeParameterT = EcoreFactory.eINSTANCE.createETypeParameter();
		typeParameterT.setName("T");

		EOperation hasRoleOperation = EcoreFactory.eINSTANCE.createEOperation();
		hasRoleOperation.setName(HAS_ROLE_OPERATION_NAME);
		hasRoleOperation.setEType(eBoolean);
		hasRoleOperation.getETypeParameters().add(typeParameterT);
		
		EParameter roleClassParameter = EcoreFactory.eINSTANCE.createEParameter();
		roleClassParameter.setName("roleClass");
		roleClassParameter.setEGenericType(createClassT(typeParameterT));
		
		hasRoleOperation.getEParameters().add(roleClassParameter);
		coreInterface.getEOperations().add(hasRoleOperation);
	}

	private EGenericType getTExtends(ETypeParameter typeParameter, EClassifier lower) {
		EGenericType genericType = createT(typeParameter);
		EGenericType roleType = EcoreFactory.eINSTANCE.createEGenericType();
		roleType.setEClassifier(lower);
		genericType.setELowerBound(roleType);
		return genericType;
	}

	private EGenericType createClassT(ETypeParameter typeParameter) {
		EDataType javaClass = EcorePackage.eINSTANCE.getEJavaClass();
		EGenericType genericType = createT(typeParameter);
		EGenericType lowerBound = EcoreFactory.eINSTANCE.createEGenericType();
		lowerBound.setEClassifier(javaClass);
		lowerBound.getETypeArguments().add(genericType);
		return lowerBound;
	}

	private EGenericType createT(ETypeParameter typeParameter) {
		EGenericType genericType = EcoreFactory.eINSTANCE.createEGenericType();
		genericType.setETypeParameter(typeParameter);
		return genericType;
	}

	/**
	 * Copies the content of 'from' (e.g., attributes, structural features,
	 * annotations and operations) to 'to':
	 * 
	 * @param from
	 * @param to
	 */
	private void copyEClassContents(EClass from, EClass to) {
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
