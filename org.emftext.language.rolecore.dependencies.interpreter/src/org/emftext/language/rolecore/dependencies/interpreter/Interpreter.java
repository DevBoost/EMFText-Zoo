package org.emftext.language.rolecore.dependencies.interpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.rolecore.dependencies.CoreClass;
import org.emftext.language.rolecore.dependencies.Domain;
import org.emftext.language.rolecore.dependencies.Edge;
import org.emftext.language.rolecore.dependencies.Equivalence;
import org.emftext.language.rolecore.dependencies.Graph;
import org.emftext.language.rolecore.dependencies.SimpleTerm;
import org.emftext.language.rolecore.dependencies.resource.dependencies.util.AbstractDependenciesInterpreter;

import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.ChangeKind;
import org.eclipse.emf.ecore.change.FeatureChange;
import org.eclipse.emf.ecore.change.ListChange;
import org.eclipse.emf.ecore.change.util.*;
import org.eclipse.emf.ecore.resource.Resource;

public class Interpreter extends AbstractDependenciesInterpreter<Boolean, InterpretationContext> {

	private ChangeRecorder changeRecorder;

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
		boolean success = false;
		if (context.isChangeKind(ChangeKind.ADD)) {
			for (Graph dependencies : context.getDependencies()) {
				// TODO record the changes differently if there are more
				// dependencies for one object
				// TODO handle REMOVE with dependencies (maybe no need)
				context.push(eObject);
				// TODO determine which dependencies is the right one
				success = interprete_org_emftext_language_rolecore_dependencies_Graph(dependencies, context);
				if (success) {
					break;
				}
			}
		}
		resetChangeKind(context);
		return success;
	}

	/**
	 * Interpret each domain, if it returns true apply the others (if there are
	 * more)
	 */
	@Override
	public Boolean interprete_org_emftext_language_rolecore_dependencies_Graph(Graph object,
			InterpretationContext context) {
		System.out.println("\nEnter interprete Graph " + object.getName());
		ChangeDescription cd = (ChangeDescription) context.pop();

		for (Domain domain : object.getModelDomains()) {
			context.push(cd);
			changeRecorder = new ChangeRecorder(context.getResourceSet());
			context.resetCreatingHelpClass(object);
			if (interprete_org_emftext_language_rolecore_dependencies_Domain(domain, context)) {
				// TODO to remove
				System.out.println("Interpret successfully!");

				// apply changes
				cd.applyAndReverse();

				List<Domain> otherDomains = getOtherDomains(object, domain);
				// create correspondences
				if (otherDomains != null) {
					for (Domain otherDomain : otherDomains) {
						if (!createCoreClassesInDomain(otherDomain, context)) {
							System.out.println("Invalid Dependencies!");
							cd.apply();
							changeRecorder.endRecording().apply();
							return false;
						}
					}
					// create trace links (only for creates? trace links for
					// semi requires are created)
					createTraceLinks(object, context);
				}
				// add objects of this domain without container to domain root
				context.getCreatingHelpClass().addObjectsToRootDomain(domain);
				return true;
			} else {
				changeRecorder.endRecording().apply();
			}
		}
		return false;
	}

	private boolean createTraceLinks(Graph graph, InterpretationContext context) {
		// TODO create trace links
		// create for equal trace links
		Equivalence equivalence = graph.getModelEquivalence();
		CreatingHelpClass creatingHelpClass = context.getCreatingHelpClass();
		if (equivalence != null) {
			EList<Edge> edges = equivalence.getEdges();
			if (edges != null && edges.size() > 0) {
				for (Edge edge : edges) {
					if (edge.isEqual()) {
						if (!context.isAssignment(edge)) {
							EList<SimpleTerm> simpleTerms = edge.getRightTerm().getSimpleTerms();
							for (SimpleTerm simpleTerm : simpleTerms) {
								EObject sourceEObject = null;
								if (edge.getSimpleTerm().getRole() != null) {
									if (simpleTerms.size() == 1) {
										EClass rightRole = simpleTerms.get(0).getRole();
										if (edge.getSimpleTerm().getRole().equals(rightRole)) {
											break;
										}
									}
									List<EObject> roles = context.getRoleEObjects(context.getCreatingHelpClass()
											.getCoreEObjectFromMap(edge.getSimpleTerm().getCoreClass().getName()), edge
											.getSimpleTerm().getRole());
									if (roles != null & roles.size() == 1) {
										sourceEObject = roles.get(0);
									}
								}
								if (sourceEObject == null) {
									sourceEObject = creatingHelpClass.getCoreEObjectFromMap(edge.getSimpleTerm()
											.getCoreClass().getName());
								}
								EObject targetEObject = creatingHelpClass.getCoreEObjectFromMap(simpleTerm
										.getCoreClass().getName());
								context.addEqualTraceLink(sourceEObject, targetEObject);
							}
						} else {
							// TODO for assignment tracelink
						}
					}
				}
			}
		}
		return true;
	}

	private boolean createCoreClassesInDomain(Domain domain, InterpretationContext context) {
		// TODO remove
		System.out.println("\nCreating the domain " + domain.getName());
		// TODO map the Required
		// create and map SemiRequired
		if (domain.getSemiRequired() != null) {
			EList<CoreClass> semiRequiredCoreClasses = domain.getSemiRequired().getCoreClasses();
			if (semiRequiredCoreClasses != null && semiRequiredCoreClasses.size() > 0) {
				for (CoreClass coreClass : semiRequiredCoreClasses) {
					context.getCreatingHelpClass().handleSemiRequiredCoreClass(coreClass, domain);
				}
			}
		}

		// create and map Create
		EList<CoreClass> createCoreClasses = domain.getCreate().getCoreClasses();
		for (CoreClass coreClassToCreate : createCoreClasses) {
			context.createSynchronizationCoreClass(coreClassToCreate);
		}

		// create links
		context.getCreatingHelpClass().setAttributesAndCreateReferences(domain);

		// add core classes with no container to the root
		context.getCreatingHelpClass().addObjectsToRootDomain(domain);
		return true;
	}

	private List<Domain> getOtherDomains(Graph object, Domain domain) {
		if (object == null || domain == null)
			return null;
		List<Domain> domains = new ArrayList<Domain>();
		for (Domain otherDomain : object.getModelDomains()) {
			if (!domain.equals(otherDomain))
				domains.add(otherDomain);
		}
		return (domains.size() == 0) ? null : domains;
	}

	/**
	 * TODO Resource changes must be applied here.
	 */
	public Boolean interprete_org_emftext_language_rolecore_dependencies_Domain(Domain object,
			InterpretationContext context) {
		System.out.println("Enter interprete Domain " + object.getName());
		ChangeDescription cd = (ChangeDescription) context.pop();
		CreatingHelpClass creatingHelpClass = context.getCreatingHelpClass();
		creatingHelpClass.setListsAndMaps(cd.getObjectChanges(), object);
		// maybe just start with the 1st element in mapOfObjectsToChange
		DomainRoot domainRoot = context.findOrCreateDomainRoot(object.getName());
		List<FeatureChange> featureChanges = creatingHelpClass.getListOfObjectsToChange().remove(domainRoot);
		if (featureChanges != null) {// root change, its feature changes do not
			// need to interpret
			System.out.println("root change");
			if (!creatingHelpClass.addNextElementsFromRoot(featureChanges, object)) {
				return false;
			}
		} else {// normal feature change, which starts in Required
			System.out.println("feature change");
			if (!creatingHelpClass.addNextElementsFromRequired(object, cd.getObjectChanges().get(0)))
				return false;
		}
		// interpret the root, the others have to interpret automatically
		Entry<EObject, CoreClass> entry = creatingHelpClass.popNextElement();
		context.push(entry.getKey());
		return interprete_org_emftext_language_rolecore_dependencies_CoreClass(entry.getValue(), context);

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
		System.out.println("Enter interprete CoreClass " + object.getName());
		EObject eObject = (EObject) context.pop();
		CreatingHelpClass creatingHelpClass = context.getCreatingHelpClass();
		// feature changes from core class to roles
		// remove from listOfObjectsToChange
		// the leaf core is not always the core of this role, the feature
		// changes have to be of all the cores
		// EList<FeatureChange> coreToRolesFC =
		// creatingHelpClass.getListOfObjectsToChange().remove(eObject);
		List<FeatureChange> coreToRolesFC = new ArrayList<FeatureChange>();
		creatingHelpClass.removeFeatureChangesOf(eObject, coreToRolesFC, true);
		EList<Edge> edges = object.getEdges();
		// maximal satisfy - for each the feature change, minimal satisfy - for
		// each the edges
		if (edges == null || edges.size() == 0) {
			// TODO if there is no edges but there are feature change for this
			// object, it should return false
			return true;
		}
		List<Edge> edgesToInterpret = new ArrayList<Edge>();
		// TODO add more edges which are required not only by the domain, but
		// implicitly by equivalences
		for (Edge edge : edges) {
			edgesToInterpret.add(edge);
		}
		for (FeatureChange featureChange : coreToRolesFC) {
			// TODO validated edges have to take out of the list to prevent
			// further validation
			// TODO a core has only a roles feature, but changes for this
			// feature can be in different feature changes or list changes, have
			// to cover all this
			EList<ListChange> listChanges = featureChange.getListChanges();
			for (ListChange listChange : listChanges) {
				for (EObject role : listChange.getReferenceValues()) {
					boolean hasRole = false;
					for (Edge edge : edgesToInterpret) {
						context.push(role);
						if (interprete_org_emftext_language_rolecore_dependencies_Edge(edge, context)) {
							edgesToInterpret.remove(edge);
							hasRole = true;
							System.out.println(" and is from " + eObject.eClass().getName());
							break;
						}
					}
					if (!hasRole) {
						return false;
					}
				}
			}
		}
		// successful if all edges are used
		if (edgesToInterpret.size() != 0) {
			return false;
		}
		Entry<EObject, CoreClass> entry = creatingHelpClass.popNextElement();
		if (entry != null) {
			context.push(entry.getKey());
			return interprete_org_emftext_language_rolecore_dependencies_CoreClass(entry.getValue(), context);
		}
		return true;
	}

	@Override
	public Boolean interprete_org_emftext_language_rolecore_dependencies_Edge(Edge object, InterpretationContext context) {
		System.out.println("Enter interprete Edge");
		EObject role = (EObject) context.pop();
		if (object.getSimpleTerm().getCoreClass() == null && object.getSimpleTerm().getRole().equals(role.eClass())) {
			// TODO after the role is valid, its attribute must be valid,
			// too and the core will be added to the next elements
			List<FeatureChange> featureChanges = new ArrayList<FeatureChange>();
			context.getCreatingHelpClass().removeFeatureChangesOf(role, featureChanges, false);
			for (FeatureChange featureChange : featureChanges) {
				// there is one attribute to each role, no list change
				if (object.isEqual() && featureChange.getDataValue() != null) {
					// TODO remove
					System.out.print("\tRole " + role.eClass().getName() + " gets the value "
							+ featureChange.getDataValue());
					return true;
				}
				if (object.isReferredTo() && featureChange.getReferenceValue() != null) {
					EObject nextEObject = featureChange.getReferenceValue();
					EList<SimpleTerm> simpleTerms = object.getRightTerm().getSimpleTerms();
					if (simpleTerms != null && simpleTerms.size() > 0) {
						SimpleTerm simpleTerm = simpleTerms.get(0);
						if (simpleTerm.getRole() == null && simpleTerm.getCoreClass() != null) {
							EClass coreEClass = simpleTerm.getCoreClass().getType();
							if (coreEClass.equals(nextEObject.eClass())) {
								// add to the next element if it was not
								// interpreted
								CreatingHelpClass creatingHelpClass = context.getCreatingHelpClass();
								creatingHelpClass.addNextElement(simpleTerm.getCoreClass(), nextEObject);
								// TODO remove
								System.out.print("\tRole " + role.eClass().getName() + " refers to "
										+ nextEObject.eClass().getName());
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}

	private void resetChangeKind(InterpretationContext context) {
		context.setChangeKind(-1);
		context.setResourceChanged(false);
	}
}
