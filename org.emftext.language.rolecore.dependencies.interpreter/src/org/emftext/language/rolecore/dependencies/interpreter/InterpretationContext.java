package org.emftext.language.rolecore.dependencies.interpreter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.ChangeKind;
import org.eclipse.emf.ecore.change.FeatureChange;
import org.eclipse.emf.ecore.change.ListChange;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.rolecore.RCPackage;
import org.emftext.language.rolecore.dependencies.Domain;
import org.emftext.language.rolecore.dependencies.Graph;

/**
 * @author BluAngel
 *
 */
public class InterpretationContext {

	private RCPackage createdConstraintsModelPackage;
	private RCPackage creatingConstraintsModelPackage;
//	private Domain createdDomain;
//	private Domain creatingDomain;
	private Map<String, Graph> dependencies;
	private Stack<Object> stack = new Stack<Object>();
	private int changeKind = -1;
	// TODO set resources according to the domain name, this may change in the
	// future.
	private List<Resource> resources = new ArrayList<Resource>();
	private List<DomainRoot> domainRoots = new ArrayList<DomainRoot>();
	private boolean isResourceChanged = false;
	//TODO is needed?
	private boolean isCreated;

	private static final String ROLES_REFERENCE_SUFFIX = "Roles";
	private static final String CORE_REFERENCE_SUFFIX = "Core";
	private CreatingHelpClass creatingHelpClass;

	public List<Resource> getResources() {
		return resources;
	}

	//TODO should add the domain root of the resource here if available.
	public void addResource(Resource resource) {
		resources.add(resource);
		EList<EObject> contents = resource.getContents();
		if (contents!=null&&contents.size()>0&&contents.get(0) instanceof DomainRoot)
			domainRoots.add((DomainRoot) contents.get(0));
	}

	public InterpretationContext() {
	}

	public Object pop() {
		return stack.pop();
	}

	public void push(Object object) {
		stack.push(object);
	}

	public Map<String, Graph> getDependencies() {
		return dependencies;
	}

	/**
	 * TODO needed?
	 * 
	 * @return
	 */
	public RCPackage getConstraintsModelPackage(boolean isCreated) {
		if (isCreated)
			return createdConstraintsModelPackage;
		else
			return creatingConstraintsModelPackage;
	}

//	public Domain getDomain(boolean isCreated) {
//		if (isCreated)
//			return createdDomain;
//		else
//			return creatingDomain;
//	}

	/**
	 * Set the domain and the role core meta model according to the
	 * interpretation. The latter is used for constraints which lie in the meta
	 * model.
	 * 
	 * @param modelDomain
	 * @param isCreated
	 */
//	public void setPackage(Domain modelDomain, boolean isCreated) {
//		String baseURI = "../org.emftext.language.rolecore/";
//		if (isCreated) {
//			createdDomain = modelDomain;
//			// createdConstraintsModelPackage =
//			// loadModel(getRolecorePath(baseURI, modelDomain.getName()));
//		} else {
//			creatingDomain = modelDomain;
//			// creatingConstraintsModelPackage =
//			// loadModel(getRolecorePath(baseURI, modelDomain.getName()));
//		}
//	}

//	private String getRolecorePath(String baseURI, String modelName) {
//		return baseURI + "." + modelName + "metamodel/" + modelName + ".rolecore";
//	}

//	private RCPackage loadModel(String pathName) {
//		ResourceSet rs = new ResourceSetImpl();
//		Resource r = null;
//		try {
//			// r = rs.getResource(URI.createFileURI(pathName), true);
//			r = rs.getResource(URI.createPlatformResourceURI(pathName, true), true);
//			System.out.println(r.toString());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return (RCPackage) r.getContents().get(0);
//	}

	public void setDependencies(Map<String, Graph> dependencies) {
		this.dependencies = dependencies;
		for (Iterator<String> graphKeys = dependencies.keySet().iterator(); graphKeys.hasNext();) {
			Graph graph = dependencies.get(graphKeys.next());
			EList<Domain> domains = graph.getModelDomains();
			for (Domain domain : domains) {
				findOrCreateDomainRoot(domain.getName());
			}
		}
	}

	public DomainRoot findOrCreateDomainRoot(String domainName) {
		for (DomainRoot domainRoot : domainRoots) {
			if (domainName.equals(domainRoot.getName()))
				return domainRoot;
		}
		DomainRoot domainRoot = InterpreterPackage.eINSTANCE.getInterpreterFactory().createDomainRoot();
		domainRoot.setName(domainName);
		domainRoots.add(domainRoot);
		return domainRoot;
	}

	/**
	 * TODO test for sub roles
	 * 
	 * @param eFactory
	 * @param ePackage
	 * @param coreEClass
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public EObject createCoreClass(EClass coreEClass) {
		EFactory eFactory = coreEClass.getEPackage().getEFactoryInstance();
		if (!coreEClass.getName().endsWith(CORE_REFERENCE_SUFFIX))
			return null;
		// Create the core class
		EObject coreClass = eFactory.create(coreEClass);
		if (coreClass == null)
			return null;

		// determine the super core class
		// 1st is the core interface, 2nd the role interface
		EClass roleInterfaceEClass = coreEClass.getESuperTypes().get(0).getESuperTypes().get(0);
		EClass rcRole = (EClass) coreEClass.getEPackage().getEClassifier("RCRole");
		if (!roleInterfaceEClass.equals(rcRole)) {
			EClass superCoreEClass = (EClass) getStructuralFeature(coreEClass, CORE_REFERENCE_SUFFIX).getEType();
			EObject superCoreClass = createCoreClass(superCoreEClass);

			EStructuralFeature rolesStructuralFeature = getStructuralFeature(superCoreEClass, ROLES_REFERENCE_SUFFIX);
			EList<EObject> roles = (EList<EObject>) superCoreClass.eGet(rolesStructuralFeature);
			roles.add(coreClass);
			// set the super core class to the core class as core
			EStructuralFeature coreStructuralFeature = getStructuralFeature(coreEClass, CORE_REFERENCE_SUFFIX);
			try {
				coreClass.eSet(coreStructuralFeature, superCoreClass);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// do the same to the super core class
		}
		return coreClass;
	}

	public EStructuralFeature getStructuralFeature(EClass eClass, String suffix) {
		if (eClass != null) {
			EList<EStructuralFeature> structuralFeatures = eClass.getEAllStructuralFeatures();
			for (EStructuralFeature structuralFeature : structuralFeatures) {
				if (structuralFeature.getName().endsWith(suffix))
					return structuralFeature;
			}
		}
		return null;
	}

	public EStructuralFeature getCoreStructuralFeature(EClass roleEClass) {
		return getStructuralFeature(roleEClass, CORE_REFERENCE_SUFFIX);
	}

	public EStructuralFeature getRolesStructuralFeature(EClass coreEClass) {
		return getStructuralFeature(coreEClass, ROLES_REFERENCE_SUFFIX);
	}

	/**
	 * In a domain one core class can have only one root core class and one leaf
	 * core class. The root is needed to be added in a container, the leaf
	 * represent this object and is needed to be used.
	 * 
	 * @param coreClass
	 * @return the root core class
	 */
	public EObject getRootCore(EObject coreClass) {
		EStructuralFeature coreStructuralFeature = getCoreStructuralFeature(coreClass.eClass());
		if (coreStructuralFeature == null)
			return coreClass;
		return getRootCore((EObject) coreClass.eGet(coreStructuralFeature));
	}

	/**
	 * In a domain one core class can have only one root core class and one leaf
	 * core class. The root is needed to be added in a container, the leaf
	 * represent this object and is needed to be used.
	 * 
	 * @param coreClass
	 * @return the leaf core class
	 */
	@SuppressWarnings("unchecked")
	public EObject getLeafCore(EObject coreClass) {
		EStructuralFeature rolesStructuralFeature = getRolesStructuralFeature(coreClass.eClass());
		if (rolesStructuralFeature != null) {
			EList<EObject> roles = (EList<EObject>) coreClass.eGet(rolesStructuralFeature);
			for (EObject role : roles) {
				EObject leafCore = getLeafCore(role);
				if (leafCore != null)
					return leafCore;
			}
			return coreClass;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public boolean addRoleToCore(EObject coreClass, EClass roleEClass, Object object, String featureName) {
		EFactory eFactory = roleEClass.getEPackage().getEFactoryInstance();
		EClass coreOfRoleEClass = (EClass) getCoreStructuralFeature(roleEClass).getEType();
		if (coreClass.eClass().equals(coreOfRoleEClass)) {
			EObject roleClass = eFactory.create(roleEClass);
			EList<EObject> rolesList = (EList<EObject>) coreClass.eGet(getRolesStructuralFeature(coreClass.eClass()));
			rolesList.add(roleClass);
			// add the core to its role
			try {
				roleClass.eSet(getCoreStructuralFeature(roleEClass), coreClass);
				roleClass.eSet(getStructuralFeature(roleEClass, featureName), object);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		} else {
			EStructuralFeature coreStructuralFeature = getStructuralFeature(coreClass.eClass(), CORE_REFERENCE_SUFFIX);
			if (coreStructuralFeature == null) {
				return false;
			}
			EObject superCoreClass = (EObject) coreClass.eGet(coreStructuralFeature);
			return addRoleToCore(superCoreClass, roleEClass, object, featureName);
		}
	}

	@SuppressWarnings("unchecked")
	public Resource saveResource(Object object, String fileURI) {
		// create resource set and resource
		ResourceSet resourceSet = new ResourceSetImpl();
		// Resource resource =
		Resource resource = resourceSet.createResource(URI.createFileURI(fileURI));
		// add the root object to the resource
		if (object instanceof List<?>)
			for (EObject element : (List<EObject>) object) {
				resource.getContents().add(element);
			}
		else if (object != null)
			resource.getContents().add((EObject) object);
		// serialize resource – you can specify also serialization
		// options which defined on org.eclipse.emf.ecore.xmi.XMIResource
		try {
			resource.save(null);
			return resource;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public void saveResource(Resource resource, String fileURI) {
		if (fileURI != null)
			resource.setURI(URI.createURI(fileURI));
		try {
			resource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// TODO remove because there is no resource!!
	public Resource loadResource(String fileURI) {
		// create resource set and resource
		ResourceSet resourceSet = new ResourceSetImpl();
		System.out.print(URI.createURI(fileURI).toFileString() + ": ");
		try {
			Resource resource = resourceSet.getResource(URI.createURI(fileURI), true);
			System.out.println(resource);
			return resource;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param changeKind
	 *            the changeKind to set ADD=0; REMOVE=1; CHANGE=2; else=-1
	 */
	public void setChangeKind(int changeKind) {
		this.changeKind = changeKind;
	}

	/**
	 * @return the changeKind
	 */
	public boolean isChangeKind(int kind) {
		return changeKind == kind;
	}

	/**
	 * @param isResourceChanged
	 *            the isResourceChanged to set
	 */
	public void setResourceChanged(boolean isResourceChanged) {
		this.isResourceChanged = isResourceChanged;
	}

	/**
	 * @return the isResourceChanged
	 */
	public boolean isResourceChanged() {
		return isResourceChanged;
	}

	/**
	 * @param creatingHelpClass
	 *            the creatingDependencies to set
	 */
	public void resetCreatingHelpClass(Graph dependencies) {
		this.creatingHelpClass = new CreatingHelpClass(dependencies);
	}

	/**
	 * @return the creatingDependencies
	 */
	public CreatingHelpClass getCreatingHelpClass() {
		return creatingHelpClass;
	}

	/**
	 * @param isCreated
	 *            the isCreated to set
	 */
	public void setCreated(boolean isCreated) {
		this.isCreated = isCreated;
	}

	/**
	 * @return the isCreated
	 */
	public boolean isCreated() {
		return isCreated;
	}

	@SuppressWarnings("unchecked")
	public EList<EObject> getRoleEObjects(EObject coreClassEObject, EClass role) {
		EList<EObject> roleEObjects = new BasicEList<EObject>();
		EList<EObject> rolesOfCore = (EList<EObject>) coreClassEObject.eGet(getRolesStructuralFeature(coreClassEObject
				.eClass()));
		for (EObject eObject : rolesOfCore) {
			if (eObject.eClass().equals(role))
				roleEObjects.add(eObject);
		}
		if (roleEObjects.size() == 0) {
			EStructuralFeature getCoreSF = getCoreStructuralFeature(coreClassEObject.eClass());
			if (getCoreSF != null) {
				EObject superCoreClass = (EObject) coreClassEObject.eGet(getCoreSF);
				return getRoleEObjects(superCoreClass, role);
			} else
				return null;
		}
		return roleEObjects;
	}

	/**
	 * If the description has only one kind, the kind is set accordingly
	 * and return true, else return false.
	 * TODO CHANGE + ADD is possible
	 * @param changeDescription
	 * @return
	 */
	public boolean setChangeKind(ChangeDescription changeDescription) {
		int isCHANGE = 1;
		int isADD = 0;
		int isREMOVE = 0;
		for (Iterator<EObject> eObjects = changeDescription.getObjectChanges().keySet().iterator(); eObjects.hasNext();) {
			EList<FeatureChange> featureChanges = changeDescription.getObjectChanges().get(eObjects.next());
			for (FeatureChange featureChange : featureChanges) {
				EList<ListChange> listChanges = featureChange.getListChanges();
				if (listChanges != null && listChanges.size() > 0) {
					isCHANGE = 0;
					for (ListChange listChange : listChanges) {
						if (listChange.getKind().equals(ChangeKind.ADD_LITERAL))
							isADD = 2;
						else if (listChange.getKind().equals(ChangeKind.REMOVE_LITERAL))
							isREMOVE = 4;
						if (isADD+isREMOVE==6)
							break;
					}
					if (isADD+isREMOVE==6)
						break;
				}
				if (isADD+isREMOVE==6)
					break;
			}
		}
		switch (isCHANGE+isADD+isREMOVE) {
		case 1:
			setChangeKind(ChangeKind.MOVE);
			return true;
		case 2:
			setChangeKind(ChangeKind.ADD);
			return true;
		case 4:
			setChangeKind(ChangeKind.REMOVE);
			return true;
		default:
			return false;
		}
	}
}
