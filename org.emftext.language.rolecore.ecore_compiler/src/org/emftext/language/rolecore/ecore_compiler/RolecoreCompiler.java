/*******************************************************************************
 * Copyright (c) 2006-2010 
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
import java.util.LinkedHashSet;
import java.util.List;
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

// TODO add code that delegates calls in role to core
// TODO add code for playsRole(), addRole(), removeRole()
public class RolecoreCompiler  {

	private static final String ROLES_REFERENCE_NAME = "Roles";
	private static final String CORE_REFERENCE_NAME = "Core";
	private static final String HAS_ROLE_OPERATION_NAME = "hasRole";
	private static final String GET_ROLE_OPERATION_NAME = "getRole";
	private static final String GET_ROLES_OPERATION_NAME = "getRoles";
	private static final String ADD_ROLE_OPERATION_NAME = "addRole";
	
	private Set<EClass> copyTargets = new LinkedHashSet<EClass>();
	private EClass rcRole; 
	
	public IStatus process(final List<EObject> contents) {
		if (contents == null) {
    		return Status.OK_STATUS;
		}
		if (contents.size() == 0) {
    		return Status.OK_STATUS;
		}
		RCPackage metaModel = (RCPackage) contents.get(0);
		final Resource resource = metaModel.eResource();
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
		        		return new Status(IStatus.ERROR, "org.emftext.language.rolecore.ecore_compiler", "Can't save compiled Ecore model.");
	        		}
	        		return Status.OK_STATUS;
	        	}
	        }.schedule();
    		return Status.OK_STATUS;
		} catch (Exception e) {
    		return new Status(IStatus.ERROR, "org.emftext.language.rolecore.ecore_compiler", e.getMessage());
		}
	}
	
	private EPackage compile(RCPackage metaModel) {
		EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
		ePackage.setName(metaModel.getName());
		ePackage.setNsPrefix(metaModel.getNsPrefix());
		ePackage.setNsURI(metaModel.getNsURI());
		
		rcRole = EcoreFactory.eINSTANCE.createEClass();
		rcRole.setName("RCRole");
		rcRole = findOrCreateEClass(ePackage, rcRole, "", true, true); 
		
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
			// TK Test, the opposite reference get the an opposite if there is none
			EReference opposite = eReference.getEOpposite();
			if (opposite!=null)
				if (opposite.getEOpposite()==null)
					opposite.setEOpposite(eReference);
		}
	}

	private void compileCoreClasses(EList<CoreClass> coreClasses, EPackage ePackage) {
		// add operations to the RCRole interface
		addHasRoleOperation();
		addGetRoleOperation();
		addGetRolesOperation(); 
		for (CoreClass coreClass : coreClasses) {
			compileCoreClass(ePackage, coreClass);
		}
	}

	private void compileCoreClass(EPackage ePackage, CoreClass coreClass) {
		// create an interface for the core class
		EClass coreInterface = findOrCreateCoreInterface(ePackage, coreClass);
		//if the core interface is handles, return
		if (copyTargets.contains(coreInterface)) {
			return;
		}
		// create an implementation for the core class and the abstract role class
		EClass core = findOrCreateCoreClass(ePackage, coreClass);
		EClass abstractRoleClass = findOrCreateAbstractRoleClass(coreInterface.getEPackage(), coreClass);
		String coreName = coreClass.getName().toLowerCase();
		// add reference to the roles that can by played by the core class
		findOrCreateCoreReference(abstractRoleClass, core, coreName+CORE_REFERENCE_NAME);
		// add reference to the core interface which contains the roles
		findOrCreateRolesReference(core, abstractRoleClass, coreName+ROLES_REFERENCE_NAME);
		
		copyTargets.add(coreInterface);
		copyEClassContents(coreClass, coreInterface);
		addRoleHandlingMethods(coreClass, coreInterface);
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
		CoreClass player = role.getPlayedBy();
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
		//copyEClassContents(coreClass, abstractRoleClass);
		return abstractRoleClass;
	}

	private EClass findOrCreateCoreClass(EPackage ePackage, CoreClass coreClass) {
		EClass coreEInterface = findOrCreateCoreInterface(ePackage, coreClass);
		return findOrCreateEClass(ePackage, coreClass, "Core", false, false, coreEInterface);
	}
	
	private EClass findOrCreateCoreInterface(EPackage ePackage, CoreClass coreClass) {
		//EClass coreInterface = findOrCreateEClass(ePackage, coreClass, "", true, true);
		//EClass coreInterface = null;
		CoreClass superCoreClass = coreClass.getSuper();
		if (superCoreClass==null)
			return findOrCreateEClass(ePackage, coreClass, "", true, true, rcRole);
		else
		{
			EClass superCoreInterface = findOrCreateEClass(ePackage, superCoreClass, "Role", true, true);
			return findOrCreateEClass(ePackage, coreClass, "", false, false, superCoreInterface);
		}
		//return coreInterface; 
	}
	
	private void addRoleHandlingMethods(CoreClass coreClass, EClass coreInterface) {
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

	private void addGetRoleOperation() {
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
		
		rcRole.getEOperations().add(getRoleOperation);
	}
	
	private void addGetRolesOperation() {
		ETypeParameter typeParameterT = EcoreFactory.eINSTANCE.createETypeParameter();
		typeParameterT.setName("T");
		
		EOperation getRoleOperation = EcoreFactory.eINSTANCE.createEOperation();
		getRoleOperation.setName(GET_ROLES_OPERATION_NAME);
		getRoleOperation.setEGenericType(createT(typeParameterT));
		getRoleOperation.getETypeParameters().add(typeParameterT);
		getRoleOperation.setLowerBound(0);
		getRoleOperation.setUpperBound(-1);
		EParameter roleClassParameter = EcoreFactory.eINSTANCE.createEParameter();
		roleClassParameter.setName("roleClass");

		roleClassParameter.setEGenericType(createClassT(typeParameterT));
		
		getRoleOperation.getEParameters().add(roleClassParameter);
		
		rcRole.getEOperations().add(getRoleOperation);
	}

	private void addHasRoleOperation() {
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
		rcRole.getEOperations().add(hasRoleOperation);
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
			EClass core, String coreReferenceName) {
		EReference coreReference = (EReference)abstractRoleClass.getEStructuralFeature(coreReferenceName);
		if (coreReference != null && coreReference.getEType().equals(core)) {
			return;
		}
		coreReference = EcoreFactory.eINSTANCE.createEReference();
		coreReference.setName(coreReferenceName);
		coreReference.setLowerBound(1);
		coreReference.setUpperBound(1);
		coreReference.setContainment(false);
		abstractRoleClass.getEStructuralFeatures().add(coreReference);

		coreReference.setEType(core);
	}

	private void findOrCreateRolesReference(EClass core,
			EClass abstractRole, String rolesReferenceName) {
		EReference rolesReference = (EReference) core.getEStructuralFeature(rolesReferenceName);
		if (rolesReference != null && rolesReference.getEType().equals(abstractRole)) {
			return;
		}
		rolesReference = EcoreFactory.eINSTANCE.createEReference();
		rolesReference.setName(rolesReferenceName);
		rolesReference.setLowerBound(0);
		rolesReference.setUpperBound(-1);
		// Due to the recursive role object pattern of Riehle, 
		//the Containment reference is not possible
		rolesReference.setContainment(true);
		core.getEStructuralFeatures().add(rolesReference);

		rolesReference.setEType(abstractRole); 
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
}
