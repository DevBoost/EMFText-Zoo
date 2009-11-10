package org.emftext.language.forms.resource.forms;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class FormsGeneratorPlugin extends Plugin {

	public static final String PLUGIN_ID = "org.emftext.language.forms.generator";
	
	private static FormsGeneratorPlugin plugin;
	
	public FormsGeneratorPlugin() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static FormsGeneratorPlugin getDefault() {
		return plugin;
	}
}
