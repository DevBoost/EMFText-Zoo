package org.emftext.language.java.resource.java.analysis.decider;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.java.commons.NamedElement;
import org.emftext.language.java.containers.ContainersFactory;
import org.emftext.language.java.containers.JavaRoot;
import org.emftext.language.java.containers.Package;
import org.emftext.language.java.references.IdentifierReference;
import org.emftext.language.java.references.MethodCall;
import org.emftext.language.java.references.ReferencesPackage;
import org.emftext.language.java.util.JavaUtil;

public class PackageDecider extends AbstractDecider {
	
	public boolean canFindTargetsFor(EObject referenceContainer,
			EReference crossReference) {

		if (referenceContainer instanceof IdentifierReference) {
			IdentifierReference idReference = (IdentifierReference) referenceContainer;
			 //a classifier must follow
			if(idReference.getNext() == null || idReference.getNext() instanceof MethodCall) {
				return false;
			}
			if (!referenceContainer.eContainingFeature().equals(ReferencesPackage.Literals.REFERENCE__NEXT)) {
				//maybe the root package
				return true;			
			}
			if (referenceContainer.eContainingFeature().equals(ReferencesPackage.Literals.REFERENCE__NEXT) && 
					idReference.eContainer() instanceof IdentifierReference &&
					((IdentifierReference)idReference.eContainer()).getTarget() instanceof Package) {
				//maybe the next sub package
				return true;
			}
			
		}
		return false;
	}
	
	public EList<? extends EObject> getAdditionalCandidates(String identifier, EObject container)  {
		if (container instanceof JavaRoot && container.eResource() != null) {
			EList<EObject> resultList = new BasicEList<EObject>();
			
			Package p = ContainersFactory.eINSTANCE.createPackage();
			JavaUtil.setName(p, identifier);
			resultList.add(p);
			
			return resultList;
		}
		if (container instanceof Package) {
			EList<EObject> resultList = new BasicEList<EObject>();
			Package parentPackage = (Package) container;
			
			Package p = ContainersFactory.eINSTANCE.createPackage();
			JavaUtil.setName(p, identifier);
			p.setParent(parentPackage);
			p.getNamespaces().addAll(parentPackage.getNamespaces());
			p.getNamespaces().add(JavaUtil.getName(parentPackage));
			resultList.add(p);
			
			return resultList;
		}
		return null;
	}
	
	public boolean containsCandidates(EObject container,
			EReference containingReference) {
		return false;
	}

	public boolean isPossibleTarget(String id, EObject element) {
		if (element instanceof Package) {
			NamedElement ne = (NamedElement) element;
			return id.equals(JavaUtil.getName(ne));
		}
		return false;
	}


}
