/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.ecore.resource.mecore.analysis;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.mecore.MDataType;
import org.emftext.language.mecore.MType;
import org.emftext.language.mecore.MecoreFactory;

public class MFeatureTypeReferenceResolver implements org.emftext.language.ecore.resource.mecore.IMinEcoreReferenceResolver<org.emftext.language.mecore.MFeature, org.emftext.language.mecore.MType> {
	
	private org.emftext.language.ecore.resource.mecore.analysis.MinEcoreDefaultResolverDelegate<org.emftext.language.mecore.MFeature, org.emftext.language.mecore.MType> delegate = new org.emftext.language.ecore.resource.mecore.analysis.MinEcoreDefaultResolverDelegate<org.emftext.language.mecore.MFeature, org.emftext.language.mecore.MType>();
	private Map<EClassifier, MDataType> dataTypeMap = new LinkedHashMap<EClassifier, MDataType>();
	
	public void resolve(String identifier, org.emftext.language.mecore.MFeature container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.ecore.resource.mecore.IMinEcoreReferenceResolveResult<org.emftext.language.mecore.MType> result) {
		EObject root = EcoreUtil.getRootContainer(container);
		delegate.tryToResolveIdentifierInObjectTree(identifier, container, root, reference, position, resolveFuzzy, result, true);
		if (!result.wasResolved() || resolveFuzzy) {
			for (EClassifier eClassifier : EcorePackage.eINSTANCE.getEClassifiers()) {
				if (eClassifier instanceof EDataType) {
					String name = eClassifier.getName();
					if (identifier.equals(name) || resolveFuzzy) {
						result.addMapping(name, getMDataType((EDataType) eClassifier));
						if (!resolveFuzzy) {
							return;
						}
					}
				}
			}
		}
	}
	
	private MType getMDataType(EDataType eDataType) {
		if (!dataTypeMap.containsKey(eDataType)) {
			MDataType mDataType = MecoreFactory.eINSTANCE.createMDataType();
			mDataType.setEDataType(eDataType);
			dataTypeMap.put(eDataType, mDataType);
		}
		return dataTypeMap.get(eDataType);
	}

	public String deResolve(org.emftext.language.mecore.MType element, org.emftext.language.mecore.MFeature container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
