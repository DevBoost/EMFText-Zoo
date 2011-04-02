/*******************************************************************************
 * Copyright (c) 2006-2011
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

package org.emftext.language.mecore.resource.mecore.analysis;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.mecore.MClass;
import org.emftext.language.mecore.MDataType;
import org.emftext.language.mecore.MEnum;
import org.emftext.language.mecore.MFeature;
import org.emftext.language.mecore.MType;
import org.emftext.language.mecore.MecoreFactory;
import org.emftext.language.mecore.resource.mecore.IMecoreReferenceResolveResult;
import org.emftext.language.mecore.resource.mecore.IMecoreReferenceResolver;

public class MFeatureTypeReferenceResolver implements IMecoreReferenceResolver<MFeature, MType> {
	
	private MecoreDefaultResolverDelegate<MFeature, MType> delegate = new MecoreDefaultResolverDelegate<MFeature, MType>();
	private Map<EClassifier, MDataType> dataTypeMap = new LinkedHashMap<EClassifier, MDataType>();
	
	public void resolve(String identifier, MFeature container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final IMecoreReferenceResolveResult<MType> result) {
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

	public String deResolve(MType element, MFeature container, EReference reference) {
		if (element instanceof MClass) {
			return ((MClass) element).getName();
		} else if (element instanceof MEnum) {
			return ((MEnum) element).getName();
		} else if (element instanceof MDataType) {
			MDataType mDataType = (MDataType) element;
			return mDataType.getEDataType().getName();
		}
		return null;
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
