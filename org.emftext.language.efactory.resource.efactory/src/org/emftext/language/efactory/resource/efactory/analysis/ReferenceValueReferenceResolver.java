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
package org.emftext.language.efactory.resource.efactory.analysis;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.efactory.Feature;
import org.emftext.language.efactory.NewObject;
import org.emftext.language.efactory.Reference;
import org.emftext.language.efactory.resource.efactory.IEfactoryElementMapping;
import org.emftext.language.efactory.resource.efactory.IEfactoryReferenceMapping;
import org.emftext.language.efactory.resource.efactory.IEfactoryReferenceResolveResult;
import org.emftext.language.efactory.resource.efactory.IEfactoryReferenceResolver;
import org.emftext.language.efactory.resource.efactory.mopp.EfactoryReferenceResolveResult;

public class ReferenceValueReferenceResolver implements IEfactoryReferenceResolver<Reference, EObject> {
	
	// TODO mseifert: use cache in default reference resolver instead
	private static class ReferenceCache implements Adapter {

		private Map<String, Object> cache = new LinkedHashMap<String, Object>();
		private Notifier target;

		public Notifier getTarget() {
			return target;
		}

		public boolean isAdapterForType(Object arg0) {
			return false;
		}

		public void notifyChanged(Notification arg0) {
		}

		public void setTarget(Notifier arg0) {
			target = arg0;
		}

		public Object getNewObject(String identifier) {
			return cache.get(identifier);
		}

		public void put(String identifier, Object newObject) {
			cache.put(identifier, newObject);
		}
	}
	
	private EfactoryDefaultResolverDelegate<Reference, EObject> delegate = new EfactoryDefaultResolverDelegate<Reference, EObject>();
	
	public void resolve(String identifier, Reference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final IEfactoryReferenceResolveResult<EObject> result) {
		ReferenceCache cache = getCache(container);
		
		if (cache != null && !resolveFuzzy) {
			Object newObject = cache.getNewObject(identifier);
			if (newObject != null) {
				result.addMapping(identifier, (EObject) newObject);
				return;
			}
		}
		//always resolve fuzzy to filter found objects afterwards
		EfactoryReferenceResolveResult<EObject> delegateResult = new EfactoryReferenceResolveResult<EObject>(true);
		delegate.resolve(identifier, container, reference, position, true, delegateResult);
		Collection<IEfactoryReferenceMapping<EObject>> mappings = delegateResult.getMappings();
		
		EClass realType = null;
		Feature feature = (Feature) container.eContainer();
		if (feature.getEFeature() instanceof EReference) {
			EReference realReference = (EReference) feature.getEFeature();
			realType = realReference.getEReferenceType();
		}
		
		IEfactoryElementMapping<EObject> validMapping = null;
		
		if (mappings != null) {
			for (Iterator<IEfactoryReferenceMapping<EObject>> i = mappings.iterator(); i.hasNext(); ) {
				IEfactoryReferenceMapping<EObject> next = i.next();
				if (next instanceof IEfactoryElementMapping<?>) {
					IEfactoryElementMapping<EObject> mapping = (IEfactoryElementMapping<EObject>) next;
					if (!mapping.getIdentifier().equals(identifier)) {
						i.remove();
						continue;
					}
					
					EObject targetElement = mapping.getTargetElement();
					EClass targetType = null;
					if (targetElement instanceof NewObject) {
						targetType = ((NewObject) targetElement).getEClass();
					} else {
						targetType = targetElement.eClass();
					}
					
					if (!targetType.equals(realType)) {
						i.remove();
					} else {
						cache.put(mapping.getIdentifier(), mapping.getTargetElement());
						validMapping = mapping;
						break;
					}
				}
			}
		}
		
		if (validMapping != null) {
			result.addMapping(identifier, validMapping.getTargetElement());
		}
	}

	private ReferenceCache getCache(EObject object) {
		EObject root = findRoot(object);
		EList<Adapter> eAdapters = root.eAdapters();
		for (Adapter adapter : eAdapters) {
			if (adapter instanceof ReferenceCache) {
				ReferenceCache cache = (ReferenceCache) adapter;
				return cache;
			}
		}
		ReferenceCache cache = new ReferenceCache();
		root.eAdapters().add(cache);
		return cache;
	}
	
	private EObject findRoot(EObject object) {
		EObject parent = object.eContainer();
		if (parent != null) {
			return findRoot(parent);
		}
		return object;
	}

	public java.lang.String deResolve(EObject element, Reference container, EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
