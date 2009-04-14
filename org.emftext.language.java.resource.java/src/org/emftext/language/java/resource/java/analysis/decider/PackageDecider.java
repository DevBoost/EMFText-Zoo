package org.emftext.language.java.resource.java.analysis.decider;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.containers.ContainersFactory;
import org.emftext.language.java.containers.Package;
import org.emftext.language.java.references.IdentifierReference;
import org.emftext.language.java.references.ReferencesPackage;

public class PackageDecider extends AbstractDecider {
	
	public boolean canFindTargetsFor(EObject referenceContainer,
			EReference crossReference) {

		if (referenceContainer instanceof IdentifierReference) {
			IdentifierReference idReference = (IdentifierReference) referenceContainer;
			if (!referenceContainer.eContainingFeature().equals(ReferencesPackage.Literals.REFERENCE__NEXT)) {
				//maybe the root package
				return true;			
			}
			if (referenceContainer.eContainingFeature().equals(ReferencesPackage.Literals.REFERENCE__NEXT) && 
					idReference.eContainer() instanceof IdentifierReference) {
				//maybe the next sub package
				return true;
			}
			
		}
		return false;
	}
	
	public EList<? extends EObject> getAdditionalCandidates(String identifier, EObject container)  {
		if (container instanceof CompilationUnit) {
			EList<EObject> resultList = new BasicEList<EObject>();
			
			Package p = ContainersFactory.eINSTANCE.createPackage();
			p.setName(identifier);
			resultList.add(p);
			
			return resultList;
		}
		if (container instanceof Package) {
			EList<EObject> resultList = new BasicEList<EObject>();
			
			Package p = ContainersFactory.eINSTANCE.createPackage();
			p.setName(identifier);
			p.setParent((Package) container);
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
		return element instanceof Package;
	}


}
