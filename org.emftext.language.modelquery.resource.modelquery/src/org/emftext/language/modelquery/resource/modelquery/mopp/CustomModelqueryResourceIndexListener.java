package org.emftext.language.modelquery.resource.modelquery.mopp;

import org.reuseware.sokan.IndexDelta;
import org.reuseware.sokan.index.notify.IndexListener;

public class CustomModelqueryResourceIndexListener implements IndexListener {

	CustomModelqueryResource resource = null;
	
	public CustomModelqueryResourceIndexListener(
			CustomModelqueryResource resource) {
		this.resource = resource;
	}

	public void indexChanged(IndexDelta delta) {
		resource.executeQuery();
	}

}
