package org.emftext.language.formular.resource.formular;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class FormularGeneratorPlugin extends Plugin {

	public static final String PLUGIN_ID = "org.emftext.language.formular.generator";

	
	private static FormularGeneratorPlugin plugin;
	
	public FormularGeneratorPlugin() {
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
	public static FormularGeneratorPlugin getDefault() {
		return plugin;
	}
}
