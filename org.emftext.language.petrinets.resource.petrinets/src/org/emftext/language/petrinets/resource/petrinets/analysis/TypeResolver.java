package org.emftext.language.petrinets.resource.petrinets.analysis;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.emftext.language.petrinets.ListFunction;
import org.emftext.language.petrinets.PList;
import org.emftext.language.petrinets.PetriNet;
import org.emftext.language.petrinets.resource.petrinets.IPetrinetsReferenceResolveResult;

public class TypeResolver {

	private static TypeResolver theInstance;

	private PetrinetsDefaultResolverDelegate<?, EClassifier> delegate = new PetrinetsDefaultResolverDelegate<EObject, EClassifier>();

	public static TypeResolver getInstance() {
		if (theInstance == null) {
			theInstance = new TypeResolver();
		}
		return theInstance;
	}

	public <T extends EClassifier> void resolve(String identifier,
			EObject container, IPetrinetsReferenceResolveResult<T> result) {
		EObject parent = container;
		while (parent != null) {
			if (parent instanceof ListFunction) {
				ListFunction lf = (ListFunction) parent;
				if (lf.getListTypeDef() != null
						&& lf.getListTypeDef().getName().equals(identifier)) {
					result.addMapping(identifier, (T) lf.getListTypeDef());
				}
				if (lf.getContext() instanceof PList) {
					PList plist = (PList) lf.getContext();

				}
			}
			parent = parent.eContainer();
		}
		EObject root = container.eResource().getContents().get(0);
		if (root instanceof PetriNet) {
			PetriNet pn = (PetriNet) root;
			List<EPackage> ePackages = new LinkedList<EPackage>();
			ePackages.addAll(pn.getEPackages());
			for (EPackage ePackage : ePackages) {
				EClassifier eClassifier = ePackage.getEClassifier(identifier);
				if (eClassifier != null) {
					result.addMapping(identifier, (T) eClassifier);
				}
			}
		}
	}
	
	public String deResolve(EClassifier type) {
		return type.getName();
	}
}
