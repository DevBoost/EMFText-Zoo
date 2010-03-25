package org.emftext.language.rolecore.dependencies.interpreter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.rolecore.dependencies.CoreClass;
import org.emftext.language.rolecore.dependencies.Domain;
import org.emftext.language.rolecore.dependencies.Edge;
import org.emftext.language.rolecore.dependencies.Graph;
import org.emftext.language.rolecore.dependencies.resource.dependencies.util.AbstractDependenciesInterpreter;

import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.ChangeKind;
import org.eclipse.emf.ecore.change.FeatureChange;
import org.eclipse.emf.ecore.change.ListChange;
import org.eclipse.emf.ecore.change.util.*;
import org.eclipse.emf.ecore.resource.Resource;

public class Interpreter extends AbstractDependenciesInterpreter<Boolean, InterpretationContext> {

	private List<ChangeRecorder> changeRecorders;

	/**
	 * This method gets a change description about an applied feature change. A
	 * resource change is not considered yet. There are three kinds of object
	 * changes:
	 * <ul>
	 * <li><b>Add</b>: A core class gets a new role class. Because it is
	 * multiple valued there are two list changes in the feature change. One for
	 * attach the role to core and one for core to role.</li>
	 * <li><b>Remove</b>: A core class loses a role class.</li>
	 * <li><b>Change</b>: It is only for an attribute. The changed value is
	 * either the referenceValue or the value in feature change.</li>
	 * </ul>
	 * This method determines the kind of change, records all changes and resets
	 * them if the further interpretation was not successful. Next step is to
	 * see which dependencies fits the added EObject. ADD requires dependencies.
	 * REMOVE and CHANGE need it?
	 */
	@Override
	public Boolean interprete(EObject eObject, InterpretationContext context) {
		System.out.println("Enter interprete");
		if (context.getDependencies() == null || !(eObject instanceof ChangeDescription))
			return false;
		ChangeDescription changeDescription = (ChangeDescription) eObject;
		if (!context.setChangeKind(changeDescription)) {
			System.out.println("Too many ChangeKinds in this description!");
			return false;
		}
		int i = 0;
		for (Iterator<String> it = context.getDependencies().keySet().iterator(); it.hasNext();) {
			// TODO record the changes differently if there are more
			// dependencies for one object
			Graph dependencies = context.getDependencies().get(it.next());
			// TODO handle REMOVE with dependencies
			if (context.isChangeKind(ChangeKind.ADD)) {
				context.push(eObject);
				// TODO interpret all dependencies now, but only one can be
				// applied, which?
				interprete_org_emftext_language_rolecore_dependencies_Graph(dependencies, context);
				i++;
				resetChangeKind(context);
				if (i == 1)
					return true;
				if (i == 0)
					System.out.println("Cannot find the dependencies!");
				if (i > 1)
					System.out.println("There are " + i + " dependencies!");
			}
		}
		return false;
	}

	/**
	 * Interpret each domain, if it returns true, apply the others (if there are
	 * more)
	 */
	@Override
	public Boolean interprete_org_emftext_language_rolecore_dependencies_Graph(Graph object,
			InterpretationContext context) {
		System.out.println("Enter interprete Graph");
		ChangeDescription cd = (ChangeDescription) context.pop();

		for (Domain domain : object.getModelDomains()) {
			context.push(cd);
			setChangeRecorders(context.getResources());
			context.resetCreatingHelpClass(object);
			if (interprete_org_emftext_language_rolecore_dependencies_Domain(domain, context)) {
				// TODO to remove
				System.out.println("Interpret successfully!");
				List<Domain> otherDomains = getOtherDomains(object, domain);
				for (Domain otherDomain : otherDomains) {
					if (!apply_org_emftext_language_rolecore_dependencies_Domain(otherDomain, context)) {
						System.out.println("Invalid Dependencies!");
						resetChanges();
						return false;
					}
				}
				//context.addCreatingDependencies();
				return true;
			} else {
				resetChanges();
			}
		}
		return false;
	}

	private boolean apply_org_emftext_language_rolecore_dependencies_Domain(Domain otherDomain,
			InterpretationContext context) {
		// TODO apply the changes and create this domain
		return true;

	}

	private List<Domain> getOtherDomains(Graph object, Domain domain) {
		if (object == null || domain == null)
			return null;
		List<Domain> domains = new ArrayList<Domain>();
		for (Domain otherDomain : object.getModelDomains()) {
			if (!domain.getName().equals(otherDomain.getName()))
				domains.add(otherDomain);
		}
		return null;
	}

	/**
	 * TODO Resource changes must be applied here.
	 */
	public Boolean interprete_org_emftext_language_rolecore_dependencies_Domain(Domain object,
			InterpretationContext context) {
		System.out.println("Enter interprete Domain");
		ChangeDescription cd = (ChangeDescription) context.pop();
		CreatingHelpClass creatingHelpClass = context.getCreatingHelpClass();
		creatingHelpClass.setListsAndMaps(cd.getObjectChanges(), object);
		// maybe just start with the 1st element in mapOfObjectsToChange
		DomainRoot domainRoot = context.findOrCreateDomainRoot(object.getName());
		// TODO these feature changes are applied here, so it must be removed
		EList<FeatureChange> featureChanges = cd.getObjectChanges().get(domainRoot);
		if (featureChanges != null) {// resource change
			System.out.println("resource change");
			if (!creatingHelpClass.addNextElementsFromRoot(featureChanges, object))
				return false;
			// apply the "resource changes"
			applyResourceChanges(creatingHelpClass, domainRoot, featureChanges, object);
		} else {// normal feature change, which starts in Required
			System.out.println("feature change");
			if (!creatingHelpClass.addNextElementsFromCreate(object))
				return false;
		}
		// interpret the root, the others have to interpret automatically
		Entry<EObject, CoreClass> entry = creatingHelpClass.popNextElement();
		context.push(entry.getKey());
		if (interprete_org_emftext_language_rolecore_dependencies_CoreClass(entry.getValue(), context))
			return true;
		return false;
	}

	// TODO manage the sharing
	private void applyResourceChanges(CreatingHelpClass creatingDependencies, EObject eObject,
			EList<FeatureChange> featureChanges, Domain domain) {
		for (FeatureChange featureChange : featureChanges) {
			EList<ListChange> listChanges = featureChange.getListChanges();
			for (ListChange listChange : listChanges) {
				EList<EObject> eObjectsToAdd = listChange.getReferenceValues();
				for (EObject eObjectToAdd : eObjectsToAdd) {
					CoreClass coreClassToAdd = creatingDependencies.getMapOfNextElements().get(eObjectToAdd);
					creatingDependencies.addEObjectCoreClass(coreClassToAdd.getName(), eObjectToAdd);
					// creating and adding the correspondence core classes
					creatingDependencies.createSynchronizationCoreClasses(coreClassToAdd);
				}
			}
		}
	}

	/**
	 * Recursive interpretation of CoreClass. Remove from mapOfObjectsToChange.
	 * If successful add next elements, apply (add corresponding objects and add
	 * to coreClassesMap), add to coreClassesMap, remove from
	 * listOfCoreClassesToInterpret. Interpret the next in mapOfNextElements.
	 * Else return false. In case of not determinable in further interpretation.
	 * All changes must be reset and return false in order to try next object.
	 */
	@Override
	public Boolean interprete_org_emftext_language_rolecore_dependencies_CoreClass(CoreClass object,
			InterpretationContext context) {
		// assume type of CoreClass and eObject are the same.
		// TODO Hoang-Kim in this case there this no references in the core class
		System.out.println("Enter interprete CoreClass");
		EObject eObject = (EObject) context.pop();
		CreatingHelpClass creatingHelpClass = context.getCreatingHelpClass();
		// feature changes from core class to roles
		// remove from listOfObjectsToChange
		EList<FeatureChange> coreToRolesFC = creatingHelpClass.getListOfObjectsToChange().removeKey(eObject);
		EList<Edge> edges = object.getEdges();
		// maximal satisfy - for each the feature change, minimal satisfy - for
		// each the edges
		for (FeatureChange featureChange : coreToRolesFC) {
			// TODO validated edges have to take out of the list to prevent
			// further validation
			EList<ListChange> listChanges = featureChange.getListChanges();
			for (ListChange listChange : listChanges) {
				EObject role = listChange.getReferenceValues().get(0);
				if (!containsRole(role.eClass(), edges)) {
					return false;
				} else {
					// after the role is valid, the referred core must be valid
					// to and will be add to the next elements
				}
			}
		}

		// TODO validate the next element
		return true;
	}

	private boolean containsRole(EClass eClass, EList<Edge> edges) {
		for (Edge edge : edges) {
			if (edge.getSimpleTerm().getRole().equals(eClass))
				return true;
		}
		return false;
	}

	// @SuppressWarnings("unchecked")
	// @Override
	// public Boolean
	// interprete_org_emftext_language_rolecore_dependencies_Edge(Edge object,
	// InterpretationContext context) {
	// if (context.isCreated()) {
	// EObject eObject = object.eContainer().eContainer();
	// if (eObject instanceof CoreClass) {
	// String coreClassName = ((CoreClass) eObject).getName();
	// EObject coreClassEObject =
	// context.getCreatingDependencies().getEObjectCoreClass(coreClassName);
	// context.push(coreClassEObject);
	// if
	// (interprete_org_emftext_language_rolecore_dependencies_Left(object.getLeftTerm(),
	// context)) {
	// EList<EObject> leftRoleEObjects = (EList<EObject>) context.pop();
	// if (object.isReferTo()) {
	// if
	// (interprete_org_emftext_language_rolecore_dependencies_Right(object.getRightTerms().get(0),
	// context)) {
	// EObject rightCoreClassEObject = (EObject) context.pop();
	// for (EObject leftRole : leftRoleEObjects) {
	// EList<EStructuralFeature> roleStructuralFeatures = leftRole.eClass()
	// .getEAllStructuralFeatures();
	// for (EStructuralFeature eStructuralFeature : roleStructuralFeatures) {
	// Object referencedObject = leftRole.eGet(eStructuralFeature);
	// if (referencedObject != null &&
	// referencedObject.equals(rightCoreClassEObject))
	// return true;
	// }
	// }
	// } else
	// return false;
	// }
	// // TODO for the isSet property
	// } else
	// return false;
	// }
	// }
	// //for the creating one the reference must have to be set.
	// return true;
	// }

	private void resetChangeKind(InterpretationContext context) {
		context.setChangeKind(-1);
		context.setResourceChanged(false);
	}

	private void resetChanges() {
		for (int i = 0; i < changeRecorders.size(); i++) {
			changeRecorders.get(i).endRecording().apply();
		}
		changeRecorders = null;
	}

	private void setChangeRecorders(List<Resource> resources) {
		changeRecorders = new ArrayList<ChangeRecorder>();
		for (int i = 0; i < resources.size(); i++) {
			changeRecorders.add(new ChangeRecorder(resources.get(i)));
		}
	}
}
