/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.language.ecore.resource;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.emftext.runtime.EMFTextRuntimePlugin;

/**
 * This resource factory delegates to different resource factories
 * that can handle Ecore models of different syntax registered by the 
 * <code>org.emftext.language.ecore.resource.additional_ecore_extension_parser</code>
 * extension point.
 * If no parser is registered for a given URI, it delegates to the default
 * <code>org.emftext.language.ecore.resource.EcoreResourceFactoryImpl</code>.
 *
 */
public class EcoreResourceFactoryDegator implements Resource.Factory {
	
	public static final String EP_PARSER = "org.emftext.language.ecore.resource.additional_ecore_extension_parser";
	
	private final static Map<String, Resource.Factory> ecoreFactories =
		new HashMap<String, Resource.Factory>();
	
	private final static Resource.Factory defaultEcoreFactory = 
		new EcoreResourceFactoryImpl();
	
	protected void init() {
		if (ecoreFactories.isEmpty() && Platform.isRunning()) {
	        IExtensionPoint csExtensionPoint = Platform.getExtensionRegistry().getExtensionPoint(EP_PARSER);
	        if (csExtensionPoint != null) {
		        IConfigurationElement[] parserPoints = csExtensionPoint.getConfigurationElements();
		        for(int i = 0;i < parserPoints.length;i++) {
					try {
			        	String           type    = parserPoints[i].getAttribute("type");
			            Resource.Factory factory =
			            	(Resource.Factory) parserPoints[i].createExecutableExtension("class");
			            
			            ecoreFactories.put(type, factory);
					} catch (CoreException e) {
						EMFTextRuntimePlugin.logError(
								"Error while instatiating: " + parserPoints[i].getAttribute("class"), e);
					}
		        }
	        }
		}
	}
	
	public Map<String, Resource.Factory> getEcoreResourceFactoriesMap() {
		return ecoreFactories;
	}
	
	public Resource.Factory getFactoryForURI(URI uri) {
		URI trimmedURI = uri.trimFileExtension();
		String secondaryFileExtension = trimmedURI.fileExtension();
		
		Resource.Factory factory = ecoreFactories.get(secondaryFileExtension);
		
		if (factory == null) {
			factory = defaultEcoreFactory;
		}
		return factory;
	}
	
	public EcoreResourceFactoryDegator() {
		init();
	}
	
	public Resource createResource(URI uri) {
		return getFactoryForURI(uri).createResource(uri);
	}
}
