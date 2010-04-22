package org.emftext.language.rolecore.dependencies.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.ChangeFactory;
import org.eclipse.emf.ecore.change.FeatureChange;
import org.eclipse.emf.ecore.change.ListChange;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.rolecore.blockclassbase.BlockclassbaseFactory;
import org.emftext.language.rolecore.blockclassbase.BlockclassbasePackage;
import org.emftext.language.rolecore.blockclassbase.Name;
import org.emftext.language.rolecore.blockdomain.BlockDiagram;
import org.emftext.language.rolecore.blockdomain.BlockdomainFactory;
import org.emftext.language.rolecore.blockdomain.BlockdomainPackage;
import org.emftext.language.rolecore.blockdomain.SystemBlock;
import org.emftext.language.rolecore.classdomain.ClassDiagram;
import org.emftext.language.rolecore.classdomain.ClassdomainFactory;
import org.emftext.language.rolecore.dependencies.interpreter.DomainRoot;
import org.emftext.language.rolecore.dependencies.interpreter.InterpretationContext;
import org.emftext.language.rolecore.dependencies.interpreter.InterpreterPackage;
import org.emftext.language.rolecore.families.FamiliesPackage;
import org.emftext.language.rolecore.families.FamilyDomainCore;
import org.emftext.language.rolecore.interfaces.RCCore;
import org.emftext.language.rolecore.riehle97base.Riehle97basePackage;

public class ChangeDescriptionCreator {

	private InterpretationContext context;
	private String inputURI;

	ChangeDescriptionCreator(InterpretationContext interpretationContext, String inputURI) {
		context = interpretationContext;
		this.inputURI = inputURI;
	}

	private void addAttributeToRole(EObject role, Object attribute, ChangeDescription changeDescription) {
		Entry<EObject, EList<FeatureChange>> entry = ChangeFactory.eINSTANCE.createEObjectToChangesMapEntry(role);
		String featureName = role.eClass().getName();
		featureName = featureName.substring(0, 1).toLowerCase() + featureName.substring(1);
		FeatureChange featureChange = null;
		for (EAttribute feature : role.eClass().getEAttributes()) {
			if (feature.getName().equals(featureName)) {
				featureChange = ChangeFactory.eINSTANCE.createFeatureChange(feature, attribute, true);
				break;
			}
		}
		if (featureChange == null) {
			return;
		}
		changeDescription.getObjectChanges().add(entry);
		entry.getValue().add(featureChange);
	}

	private void addCoresToChangeDescription(EObject core, ChangeDescription cd) {
		if (core == null) {
			return;
		}
		cd.getObjectsToAttach().add(core);
		Object coreObject = core.eGet(context.getCoreStructuralFeature());
		if (coreObject instanceof RCCore) {
			addCoresToChangeDescription((EObject) coreObject, cd);
		}
	}

	private void addCoreToDomainRoot(DomainRoot domainRoot, EObject coreClass, ChangeDescription changeDescription) {
		Entry<EObject, EList<FeatureChange>> entry = ChangeFactory.eINSTANCE.createEObjectToChangesMapEntry(domainRoot);
		FeatureChange featureChange = ChangeFactory.eINSTANCE.createFeatureChange();
		ListChange listChange = ChangeFactory.eINSTANCE.createListChange();
		changeDescription.getObjectChanges().add(entry);
		entry.getValue().add(featureChange);
		featureChange.setFeature(InterpreterPackage.eINSTANCE.getDomainRoot_EObjects());
		featureChange.getListChanges().add(listChange);
		listChange.getReferenceValues().add(coreClass);
		addCoresToChangeDescription(coreClass, changeDescription);
	}

	private void addCoreToRole(EObject core, EObject role, ChangeDescription changeDescription) {
		Entry<EObject, EList<FeatureChange>> entry = ChangeFactory.eINSTANCE.createEObjectToChangesMapEntry(role);
		FeatureChange featureChange = ChangeFactory.eINSTANCE.createFeatureChange();
		changeDescription.getObjectChanges().add(entry);
		entry.getValue().add(featureChange);
		featureChange.setFeature(context.getCoreStructuralFeature());
		featureChange.setReferenceValue(core);
		// assume the core existed in the resource, no add to change description
	}

	// TODO test
	private void addReferenceToRole(EObject role, EObject referenceCore, ChangeDescription changeDescription) {
		Entry<EObject, EList<FeatureChange>> entry = ChangeFactory.eINSTANCE.createEObjectToChangesMapEntry(role);
		FeatureChange featureChange = ChangeFactory.eINSTANCE.createFeatureChange();
		// ListChange listChange = ChangeFactory.eINSTANCE.createListChange();
		// assumed a reference role has exact one reference for the core class
		EStructuralFeature structuralFeature = role.eClass().getEReferences().get(0);
		changeDescription.getObjectChanges().add(entry);
		entry.getValue().add(featureChange);
		featureChange.setFeature(structuralFeature);
		featureChange.setReferenceValue(referenceCore);
		if (referenceCore.eContainer() == null) {
			changeDescription.getObjectsToAttach().add(referenceCore);
		}
	}

	private void addRoleToCore(EObject role, EObject core, ChangeDescription changeDescription) {
		Entry<EObject, EList<FeatureChange>> entry = ChangeFactory.eINSTANCE.createEObjectToChangesMapEntry(core);
		FeatureChange featureChange = ChangeFactory.eINSTANCE.createFeatureChange();
		ListChange listChange = ChangeFactory.eINSTANCE.createListChange();
		changeDescription.getObjectChanges().add(entry);
		entry.getValue().add(featureChange);
		featureChange.setFeature(context.getRolesStructuralFeature());
		featureChange.getListChanges().add(listChange);
		listChange.getReferenceValues().add(role);
		changeDescription.getObjectsToAttach().add(role);
	}

	private void addRoleToCoreAndReverse(EObject role, EObject core, ChangeDescription changeDescription) {
		addRoleToCore(role, core, changeDescription);
		addCoreToRole(core, role, changeDescription);
	}

	public ChangeDescription createAddClassDiagram(String domainName) {
		DomainRoot dr = context.findOrCreateDomainRoot(domainName);
		ClassDiagram classDiagram = ClassdomainFactory.eINSTANCE.createClassDiagramCore();
		ChangeDescription cd = ChangeFactory.eINSTANCE.createChangeDescription();
		Entry<EObject, EList<FeatureChange>> entry = ChangeFactory.eINSTANCE.createEObjectToChangesMapEntry(dr);
		FeatureChange fc = ChangeFactory.eINSTANCE.createFeatureChange();
		ListChange lc = ChangeFactory.eINSTANCE.createListChange();
		cd.getObjectChanges().add(entry);
		entry.getValue().add(fc);
		fc.setFeature(InterpreterPackage.eINSTANCE.getDomainRoot_EObjects());
		fc.getListChanges().add(lc);
		lc.getReferenceValues().add(classDiagram);
		cd.getObjectsToAttach().add(classDiagram);
		return cd;
	}

	/**
	 * Create a change description for the given resource which add a Customer.
	 * Save this change description in the inputURI.
	 * 
	 * @param cResource
	 * @return
	 */
	public ChangeDescription createAddCustomerToResourceCD(Resource cResource) {
		DomainRoot domainRoot = (DomainRoot) cResource.getContents().get(0);
		Riehle97basePackage cEPackage = Riehle97basePackage.eINSTANCE;
		EObject customerCore = context.createCoreClass(cEPackage.getCustomerCore());

		ChangeDescription cd = ChangeFactory.eINSTANCE.createChangeDescription();
		Entry<EObject, EList<FeatureChange>> entry = ChangeFactory.eINSTANCE.createEObjectToChangesMapEntry(domainRoot);
		FeatureChange fc = ChangeFactory.eINSTANCE.createFeatureChange();
		ListChange lc = ChangeFactory.eINSTANCE.createListChange();
		cd.getObjectChanges().add(entry);
		entry.getValue().add(fc);
		fc.setFeature(InterpreterPackage.eINSTANCE.getDomainRoot_EObjects());
		fc.getListChanges().add(lc);
		lc.getReferenceValues().add(customerCore);
		cd.getObjectsToAttach().add(customerCore);
		context.saveResource(cd, inputURI + "addCustomerToCustomersA.change.xmi");
		return cd;
	}

	/**
	 * TODO recode
	 */
	@SuppressWarnings("unused")
	private void createAddFamilyChangeDescription() {
		FamiliesPackage familiesEPackage = (FamiliesPackage) EPackage.Registry.INSTANCE
				.getEPackage("http://www.emftext.org/language/rolecore/families");
		List<EObject> eObjectList = new ArrayList<EObject>();
		Resource familiesResource = context.saveResource(eObjectList, inputURI + "families.xmi");

		FamilyDomainCore familyDomainCore = (FamilyDomainCore) familiesResource.getContents().get(0);
		FamiliesPackage ePackage = (FamiliesPackage) EPackage.Registry.INSTANCE
				.getEPackage("http://www.emftext.org/language/rolecore/families");
		EClass familyRole = ePackage.getFamilydomainFamilyFamiliesRole();
		EClass familyCoreEClass = (EClass) ePackage.getEClassifier("FamilyCore");
		EObject familyCoreClass = context.createCoreClass(familyCoreEClass);
		EClass lastNameRole = (EClass) ePackage.getEClassifier("LastName");
		context.addRoleToCore(familyCoreClass, lastNameRole, "March", "lastName");
		eObjectList.add(getAddRoleToCoreChangeDescription(familyDomainCore, familyRole, context
				.getRootCore(familyCoreClass), ePackage.getFamilydomainFamilyFamiliesRole_Families().getName()));

		EClass fatherCoreEClass = (EClass) ePackage.getEClassifier("MemberCore");
		EObject fatherCoreClass = context.createCoreClass(fatherCoreEClass);

		EClass fatherNameEClass = (EClass) ePackage.getEClassifier("FirstName");
		context.addRoleToCore(fatherCoreClass, fatherNameEClass, "Jim", "firstName");
		EClass fatherFamilyRoleEClass = (EClass) ePackage.getEClassifier("MemberFamilyFamilyfatherRole");
		context.addRoleToCore(fatherCoreClass, fatherFamilyRoleEClass, familyCoreClass, "familyFather");
		EClass familyFatherRoleEClass = (EClass) ePackage.getEClassifier("FamilyMemberFatherRole");
		context.addRoleToCore(familyCoreClass, familyFatherRoleEClass, fatherCoreClass, "father");

		EClass motherCoreEClass = (EClass) ePackage.getEClassifier("MemberCore");
		EObject motherCoreClass = context.createCoreClass(motherCoreEClass);

		EClass motherNameEClass = (EClass) ePackage.getEClassifier("FirstName");
		context.addRoleToCore(motherCoreClass, motherNameEClass, "Cindy", "firstName");
		EClass motherFamilyRoleEClass = (EClass) ePackage.getEClassifier("MemberFamilyFamilymotherRole");
		context.addRoleToCore(motherCoreClass, motherFamilyRoleEClass, familyCoreClass, "familyMother");
		EClass familyMotherRoleEClass = (EClass) ePackage.getEClassifier("FamilyMemberMotherRole");
		context.addRoleToCore(familyCoreClass, familyMotherRoleEClass, motherCoreClass, "mother");

		context.saveResource(eObjectList, inputURI + "addFamily.change");
	}

	public ChangeDescription createSystemBlock(String domainName) {
		DomainRoot dr = context.findOrCreateDomainRoot(domainName);
		BlockDiagram bd = null;
		for (EObject eObject : dr.getEObjects()) {
			if (eObject instanceof BlockDiagram) {
				bd = (BlockDiagram) eObject;
				break;
			}
		}
		SystemBlock sb = (SystemBlock) context.createCoreClass(BlockdomainPackage.eINSTANCE.getSystemBlockCore());
		Name name = BlockclassbaseFactory.eINSTANCE.createName();
		EObject mebdRole = BlockclassbaseFactory.eINSTANCE.createModelelementBlockdiagramRole();
		EObject bdeRole = BlockdomainFactory.eINSTANCE.createBlockdiagramElementsRole();

		ChangeDescription cd = ChangeFactory.eINSTANCE.createChangeDescription();
		// add SystemBlock to DomainRoot
		addCoreToDomainRoot(dr, sb, cd);
		// add role Name to SystemBlock and SystemBlock to role Name
		EObject modelElementCore = getSuperCore(sb, BlockclassbasePackage.eINSTANCE.getModelElementCore());
		addRoleToCoreAndReverse(name, modelElementCore, cd);
		// set attribute Name
		addAttributeToRole(name, "ProSys", cd);
		// add ModelelementBlockdiagramRole to SystemBlock and reverse
		addRoleToCoreAndReverse(mebdRole, modelElementCore, cd);
		// add BlockDiagram to ModelelementBlockdiagramRole
		addReferenceToRole(mebdRole, bd, cd);
		// add BlockdiagramElementsRole to BlockDiagram
		addRoleToCoreAndReverse(bdeRole, bd, cd);
		// add SystemBlock to BlockdiagramElementsRole
		addReferenceToRole(bdeRole, sb, cd);
		return cd;
	}

	/**
	 * TODO recode
	 * 
	 * @param coreClass
	 * @param roleEClass
	 * @param eObject
	 * @param featureName
	 * @return
	 */
	public ChangeDescription getAddRoleToCoreChangeDescription(EObject coreClass, EClass roleEClass, EObject eObject,
			String featureName) {
		EFactory eFactory = roleEClass.getEPackage().getEFactoryInstance();
		EClass coreOfRoleEClass = (EClass) context.getCoreStructuralFeature().getEType();
		if (coreClass.eClass().equals(coreOfRoleEClass)) {
			// Add a role to the core class, multiple valued
			EObject roleClass = eFactory.create(roleEClass);
			ChangeDescription changeDescription = ChangeFactory.eINSTANCE.createChangeDescription();
			changeDescription.getObjectsToAttach().add(roleClass);
			Entry<EObject, EList<FeatureChange>> roleToCoreEntry = ChangeFactory.eINSTANCE
					.createEObjectToChangesMapEntry(coreClass);
			changeDescription.getObjectChanges().add(roleToCoreEntry);
			FeatureChange roleToCoreFeatureChange = ChangeFactory.eINSTANCE.createFeatureChange();
			roleToCoreFeatureChange.setFeature(context.getRolesStructuralFeature());
			roleToCoreEntry.getValue().add(roleToCoreFeatureChange);
			ListChange listChange = ChangeFactory.eINSTANCE.createListChange();
			listChange.getReferenceValues().add(roleClass);
			roleToCoreFeatureChange.getListChanges().add(listChange);

			// Add the core to the role class. single valued
			changeDescription.getObjectsToAttach().add(coreClass);
			Entry<EObject, EList<FeatureChange>> coreToRoleEntry = ChangeFactory.eINSTANCE
					.createEObjectToChangesMapEntry(roleClass);
			FeatureChange coreToRoleFeatureChange = ChangeFactory.eINSTANCE.createFeatureChange();
			coreToRoleFeatureChange.setFeature(context.getCoreStructuralFeature());
			coreToRoleFeatureChange.setReferenceValue(coreClass);
			changeDescription.getObjectChanges().add(coreToRoleEntry);
			coreToRoleEntry.getValue().add(coreToRoleFeatureChange);
			try {
				// set the reference of the role class, is not in
				// ChangeDescription
				roleClass.eSet(context.getStructuralFeature(roleEClass, featureName), eObject);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return changeDescription;
		} else {
			EStructuralFeature coreStructuralFeature = context.getCoreStructuralFeature();
			if (coreStructuralFeature == null) {
				return null;
			}
			EObject superCoreClass = (EObject) coreClass.eGet(coreStructuralFeature);
			return getAddRoleToCoreChangeDescription(superCoreClass, roleEClass, eObject, featureName);
		}
	}

	private EObject getSuperCore(EObject coreClass, EClass superCoreEClass) {
		if (coreClass.eClass().equals(superCoreEClass)) {
			return coreClass;
		}
		EObject superCoreClass = (EObject) coreClass.eGet(context.getCoreStructuralFeature());
		if (superCoreClass != null) {
			return getSuperCore(superCoreClass, superCoreEClass);
		}
		return null;
	}
}
