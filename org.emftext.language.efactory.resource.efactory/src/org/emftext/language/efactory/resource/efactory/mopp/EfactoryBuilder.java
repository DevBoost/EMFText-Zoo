/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.efactory.resource.efactory.mopp;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.emftext.language.efactory.Factory;
import org.emftext.language.efactory.builder.Builder;

public class EfactoryBuilder implements org.emftext.language.efactory.resource.efactory.IEfactoryBuilder {
	
	public org.eclipse.core.runtime.IStatus build(org.emftext.language.efactory.resource.efactory.mopp.EfactoryResource resource, org.eclipse.core.runtime.IProgressMonitor monitor) {
		if (resource.getErrors().size() == 0) {
			EList<EObject> contents = resource.getContents();
			if (contents.size() > 0) {
				EObject rootObject = contents.get(0);
				if (rootObject instanceof Factory) {
					Factory factory = (Factory) rootObject;
					Builder builder = new Builder();
					List<EObject> roots = builder.build(factory);
					URI xmiURI = resource.getURI().trimFileExtension().appendFileExtension("xmi");
					Resource xmiResource = new ResourceSetImpl().createResource(xmiURI);
					xmiResource.getContents().addAll(roots);
					try {
						Map<Object, Object> options = new HashMap<Object, Object>();
						options.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
						xmiResource.save(options);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return org.eclipse.core.runtime.Status.OK_STATUS;
	}

	public boolean isBuildingNeeded(URI uri) {
		return true;
	}
}
