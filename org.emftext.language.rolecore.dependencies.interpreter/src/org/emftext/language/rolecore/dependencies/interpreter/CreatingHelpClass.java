package org.emftext.language.rolecore.dependencies.interpreter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeKind;
import org.eclipse.emf.ecore.change.FeatureChange;
import org.eclipse.emf.ecore.change.ListChange;
import org.emftext.language.rolecore.dependencies.Block;
import org.emftext.language.rolecore.dependencies.CoreClass;
import org.emftext.language.rolecore.dependencies.Edge;
import org.emftext.language.rolecore.dependencies.Graph;
import org.emftext.language.rolecore.dependencies.Domain;
import org.emftext.language.rolecore.dependencies.RightTerm;
import org.emftext.language.rolecore.dependencies.SimpleTerm;

public class CreatingHelpClass {

	private HashMap<String, EObject> coreClassesMap;
	private Graph dependencies;
	private EMap<EObject, EList<FeatureChange>> mapOfObjectsToChange;
	private EMap<EObject, CoreClass> mapOfNextElements;
	private List<CoreClass> listOfCoreClassesToInterpret;

	public CreatingHelpClass(Graph dependencies) {
		this.dependencies = dependencies;
		coreClassesMap = new HashMap<String, EObject>();
		mapOfNextElements = new BasicEMap<EObject, CoreClass>(10);
		listOfCoreClassesToInterpret = new ArrayList<CoreClass>();
	}

	public void addEObjectCoreClass(String synchronizationName, EObject eObject) {
		coreClassesMap.put(synchronizationName, eObject);
	}

	/**
	 * Is this EObject in contained in the list already?
	 * 
	 * @param eObject
	 * @return
	 */
	public boolean hasEObjectCoreClass(EObject eObject) {
		for (Iterator<String> synchronizationNames = coreClassesMap.keySet().iterator(); synchronizationNames.hasNext();) {
			if (coreClassesMap.get(synchronizationNames).equals(eObject))
				return true;
		}
		return false;
	}

	public String getSynchronizationName(EObject eObject) {
		for (Iterator<String> synchronizationNames = coreClassesMap.keySet().iterator(); synchronizationNames.hasNext();) {
			String synchronizationName = synchronizationNames.next();
			if (coreClassesMap.get(synchronizationName).equals(eObject))
				return synchronizationName;
		}
		return null;
	}

	public Graph getDependencies() {
		return dependencies;
	}

	public CoreClass getDependenciesCoreClass(String synchronizationName) {
		CoreClass coreClass = null;
		for (Domain domain : dependencies.getModelDomains()) {
			coreClass = getDependenciesCoreClassFromBlock(synchronizationName, domain.getRequired());
			if (coreClass != null)
				return coreClass;
			coreClass = getDependenciesCoreClassFromBlock(synchronizationName, domain.getSemiRequired());
			if (coreClass != null)
				return coreClass;
			coreClass = getDependenciesCoreClassFromBlock(synchronizationName, domain.getCreate());
			if (coreClass != null)
				return coreClass;
		}

		return null;
	}

	public CoreClass getDependenciesCoreClassFromBlock(String synchronizationName, Block block) {
		for (CoreClass coreClass : block.getCoreClasses()) {
			if (coreClass.getName().equals(synchronizationName))
				return coreClass;
		}
		return null;
	}

	public EObject getEObjectCoreClass(String synchronizationName) {
		return coreClassesMap.get(synchronizationName);
	}

	/**
	 * Create the synchronization core classes of the given core class if they
	 * are not existed yet.
	 * 
	 * @param coreClass
	 * @param context
	 */
	public void createSynchronizationCoreClasses(CoreClass coreClass) {
		Set<CoreClass> synchCoreClasses = getSynchronizationCoreClasses(coreClass);
		if (synchCoreClasses != null && synchCoreClasses.size() > 0)
			for (CoreClass synchCoreClass : synchCoreClasses) {
				EObject synchCoreClassEObject = getEObjectCoreClass(synchCoreClass.getName());
				if (synchCoreClassEObject == null) {
					synchCoreClassEObject = synchCoreClass.getType().getEPackage().getEFactoryInstance().create(
							synchCoreClass.getType());
					coreClassesMap.put(synchCoreClass.getName(), synchCoreClassEObject);
				}
			}
	}

	/**
	 * Assume there is only one core class synchronization.
	 * 
	 * @param coreClass
	 * @param context
	 * @return
	 */
	private Set<CoreClass> getSynchronizationCoreClasses(CoreClass coreClass) {
		EList<Edge> edges = dependencies.getModelEquivalence().getEdges();
		Set<CoreClass> synchCoreClasses = new HashSet<CoreClass>();
		for (Edge edge : edges) {
			SimpleTerm simpleTerm = edge.getSimpleTerm();
			RightTerm rightTerm = edge.getRightTerm();
			// if the core class in left term and there is no role, so it is a
			// synchronization,
			// else look the right term
			if (coreClass.getName().equals(simpleTerm.getCoreClass().getName()) && simpleTerm.getRole() == null) {
				for (SimpleTerm rightSimpleTerm : edge.getRightTerm().getSimpleTerms()) {
					synchCoreClasses.add(rightSimpleTerm.getCoreClass());
				}
				return synchCoreClasses;
			} else {
				for (SimpleTerm rightSimpleTerm : rightTerm.getSimpleTerms()) {
					if (coreClass.getName().equals(rightSimpleTerm.getCoreClass().getName())
							&& rightSimpleTerm.getRole() == null) {
						synchCoreClasses.add(simpleTerm.getCoreClass());
						return synchCoreClasses;
					}
				}
			}
		}
		return synchCoreClasses;
	}

	public void setListsAndMaps(EMap<EObject, EList<FeatureChange>> objectChanges, Domain domain) {
		mapOfObjectsToChange = objectChanges;
		addCoreClassesToListOfCoreClassesToInterpret(domain.getRequired());
		addCoreClassesToListOfCoreClassesToInterpret(domain.getCreate());
		addCoreClassesToListOfCoreClassesToInterpret(domain.getSemiRequired());
	}
	
	private void addCoreClassesToListOfCoreClassesToInterpret(Block block) {
		if (block != null && block.getCoreClasses()!=null)
			for (CoreClass coreClass : block.getCoreClasses()) {
				listOfCoreClassesToInterpret.add(coreClass);
			}
	}

	public EMap<EObject, EList<FeatureChange>> getListOfObjectsToChange(){
		return mapOfObjectsToChange;
	}
	
//	public List<CoreClass> getListOfCoreClassesToInterpret(){
//		return listOfCoreClassesToInterpret;
//	}
	/**
	 * 
	 */
	public Entry<EObject, CoreClass> popNextElement(){
		if (mapOfNextElements.size()==0)
			return null;
		return mapOfNextElements.get(0);
	}
	
	public boolean pushNextElement(EObject key, CoreClass value){
		if (coreClassesMap.containsValue(key))
			return false;
		mapOfNextElements.put(key, value);
		return true;
	}

	/**
	 * The first element is in Create or SemiCreate because of domain root. 
	 * If it is a containment reference then it is in Create. Now assume it is in Create first.
	 * @param featureChanges
	 */
	public boolean addNextElementsFromRoot(EList<FeatureChange> featureChanges, Domain domain) {
		//TODO should be applied these feature changes here?
		if (featureChanges==null)
			return false;
		for (FeatureChange featureChange : featureChanges) {
			EList<ListChange> listChanges = featureChange.getListChanges();
			for (ListChange listChange : listChanges) {
				if (listChange.getKind().equals(ChangeKind.ADD_LITERAL)){
					EList<EObject> coreClassEObjects =listChange.getReferenceValues();
					for (EObject eObject : coreClassEObjects) {
						CoreClass coreClass = getCoreClassFromBlock(eObject.eClass(),domain.getCreate());
						if (coreClass==null)
							coreClass = getCoreClassFromBlock(eObject.eClass(), domain.getSemiRequired());
						if (coreClass!=null)
							mapOfNextElements.put(eObject,coreClass);
						else return false;
					}
				}
			}
		}
		return true;
	}

	private CoreClass getCoreClassFromBlock(EClass eClass, Block block) {
		if (block!=null&&block.getCoreClasses()!=null&&block.getCoreClasses().size()>0)
			for (CoreClass coreClass : block.getCoreClasses()) {
				if (coreClass.getType().equals(eClass))
					return coreClass;
			}
		return null;
	}

	public boolean addNextElementsFromCreate(Domain domain) {
		if(mapOfObjectsToChange.size()==0)
			return false;
		Entry<EObject, EList<FeatureChange>> entry = mapOfObjectsToChange.get(0);
		CoreClass coreClass = getCoreClassFromBlock(entry.getKey().eClass(), domain.getRequired());
		if (coreClass!=null)
			mapOfNextElements.put(entry.getKey(), coreClass);
		return false;
	}

	public EMap<EObject,CoreClass> getMapOfNextElements() {
		return mapOfNextElements;
	}

}
