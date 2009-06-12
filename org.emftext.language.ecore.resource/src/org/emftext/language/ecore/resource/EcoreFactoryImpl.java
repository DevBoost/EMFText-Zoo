package org.emftext.language.ecore.resource;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * This class does not extend or change the functionality of 
 * <code>org.eclipse.emf.ecore.impl.EcoreFactoryImpl</code>.
 * It is used in the 
 * <code>org.eclipse.emf.ecore.factory_override</code>
 * extension point to be instantiated when the ecore model
 * processing machinery starts. It then replaces the
 * <code>org.emftext.language.ecore.resource.EcoreResourceFactoryImpl</code>
 * with the delegating factory
 * <code>EcoreResourceFactoryDegator</code>
 * to support multiple Ecore formats that are specified though hierarchical 
 * file names (e.g., ".tecore.ecore").
 * 
 *
 */
public class EcoreFactoryImpl extends
		org.eclipse.emf.ecore.impl.EcoreFactoryImpl {

	public EcoreFactoryImpl() {
		super();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", new EcoreResourceFactoryDelegator());
	}
}
