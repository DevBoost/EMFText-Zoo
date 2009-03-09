package org.emftext.language.plugin;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.ModelEntry;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.emftext.runtime.IResourcePostProcessor;
import org.emftext.runtime.IResourcePostProcessorProvider;
import org.emftext.runtime.resource.ITextResource;
import org.osgi.framework.Bundle;

public class PluginDataInitializer implements IResourcePostProcessorProvider,
		IResourcePostProcessor {

	private static final String BUNDLE_NAME = "Bundle-Name";
	private static final Object BUNDLE_VENDOR = "Bundle-Vendor";
	private static final Object BUNDLE_VERSION = "Bundle-Version";
	private static final Object REQUIRE_BUNDLE = "Require-Bundle";
	private Map<String, ExtensionPoint> ids2eps = new HashMap<String, ExtensionPoint>();
	private ITextResource resource;;

	public void process(ITextResource resource) {
		this.resource = resource;
		EList<EObject> contents = resource.getContents();
		for (EObject root : contents) {
			if (root instanceof ToolProductFamily) {
				initialise((ToolProductFamily) root);
			}
		}
	}

	private void initialise(ToolProductFamily family) {
		family.setRequiredPlugins(PluginFactory.eINSTANCE.createRequiredPlugins());
		for (Plugin plugin : family.getPlugins()) {
			initialise(family, plugin);
		}
	}

	private void initialise(ToolProductFamily family, Plugin plugin) {
		initialisePluginInformation(plugin, family);
		initialiseExtensionPoints(plugin, family);
		initialiseExtensions(plugin, family);
	}

	private void initialiseExtensions(Plugin plugin, ToolProductFamily family) {
		IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
		IExtension[] extensions = extensionRegistry.getExtensions(plugin
				.getPluginId());
		for (IExtension extension : extensions) {
			if (!containsExtension(plugin.getExtensions(), extension
					.getUniqueIdentifier())) {
				Extension es = PluginFactory.eINSTANCE.createExtension();
				es.setExtensionId(extension.getUniqueIdentifier());
				es.setName(extension.getLabel());
				plugin.getExtensions().add(es);
			
			
				String extensionPointUniqueIdentifier = extension.getExtensionPointUniqueIdentifier();
				IExtensionPoint extensionPoint = Platform.getExtensionRegistry().getExtensionPoint(extensionPointUniqueIdentifier);
				IContributor contributor = extensionPoint.getContributor();
				if (getPlugin(contributor.getName(), family) == null) {
					String contributorName = contributor.getName();
					Plugin imported = PluginFactory.eINSTANCE.createPlugin();
					imported.setPluginId(contributorName);
					family.getRequiredPlugins().getRequired().add(imported);
					initialise(family, imported);
					initialiseExtensionPoints(imported, family);
					initialiseExtensions(imported, family);
				}
				es.setBinds(lookupExtensionPoint(extensionPointUniqueIdentifier));
			}	
		}
	}

	
	private ExtensionPoint lookupExtensionPoint(
			String extensionPointUniqueIdentifier) {
		return ids2eps.get(extensionPointUniqueIdentifier);
	}

	private void initialiseExtensionPoints(Plugin plugin,
			ToolProductFamily family) {
		IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
		IExtensionPoint[] extensionPoints = extensionRegistry
				.getExtensionPoints(plugin.getPluginId());
		for (IExtensionPoint extensionPoint : extensionPoints) {
			if (!containsExtensionPoint(plugin.getExtensionPoints(),
					extensionPoint.getUniqueIdentifier())) {
				ExtensionPoint ep = PluginFactory.eINSTANCE.createExtensionPoint();
				ep.setName(extensionPoint.getLabel());
				ep.setExtensionPointId(extensionPoint.getUniqueIdentifier());
				ep.setSchema(extensionPoint.getSchemaReference());
				plugin.getExtensionPoints().add(ep);
				
				ids2eps.put(ep.getExtensionPointId(), ep);
			
				if (family.getPlugins().contains(plugin)) {
					IExtension[] pointsExtensions = extensionPoint.getExtensions();
					for (IExtension extension : pointsExtensions) {
						IContributor contributor = extension.getContributor();
						if (getPlugin(contributor.getName(), family) == null) {
							String contributorName = contributor.getName();
							this.resource.addWarning("The plug-in " + contributorName + " extends the families extension point " + ep.getExtensionPointId() + " and " +
									"should be considered as plug-in of the tool product family." , plugin);
						}
						
					}
				}
			}			
		}
	}

	private void initialisePluginInformation(Plugin plugin, ToolProductFamily family) {
		
		ModelEntry entry = PluginRegistry.findEntry(plugin.getPluginId()) ;
		if (entry == null) {
			this.resource.addError("Plug-In was not found" , plugin);
		}
		IPluginModelBase model = entry.getModel();		
		plugin.setName(model.getBundleDescription().getName());
		plugin.setVersion(model.getBundleDescription().getVersion().toString());

		
	}

	

	public IResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	private boolean containsExtension(EList<Extension> extensions,
			String uniqueIdentifier) {
		for (Extension extension : extensions) {
			if ( extension.getExtensionId() != null && extension.getExtensionId().equals(uniqueIdentifier))
				return true;
		}
		return false;
	}

	private boolean containsExtensionPoint(
			EList<ExtensionPoint> extensionPoints, String uniqueIdentifier) {
		for (ExtensionPoint ep : extensionPoints) {
			if ( ep.getExtensionPointId() != null && ep.getExtensionPointId().equals(uniqueIdentifier))
				return true;
		}
		return false;
	}

	
	private Plugin getPlugin(String name, ToolProductFamily family) {
		for (Plugin p : family.getPlugins()) {
			if (p.getPluginId() != null && p.getPluginId().equals(name)) return p;
		}
		for (Plugin p : family.getRequiredPlugins().getRequired()) {
			if (p.getPluginId() != null && p.getPluginId().equals(name)) return p;
		}

		return null;
	}
	
}