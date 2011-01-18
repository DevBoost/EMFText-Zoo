package org.emftext.language.modelquery.resource.modelquery.mopp;

import java.lang.ref.WeakReference;
import java.util.Set;

import org.reuseware.sokan.ID;
import org.reuseware.sokan.index.notify.IndexListener;
import org.reuseware.sokan.index.util.IndexUtil;

public class CustomModelqueryResourceIndexListener implements IndexListener {

	private WeakReference<CustomModelqueryResource> resourceRef = null;
	
	public CustomModelqueryResourceIndexListener(
			CustomModelqueryResource resource) {
		this.resourceRef = new WeakReference<CustomModelqueryResource>(resource);
	}

	public void indexChanged(Set<ID> delta) {
		CustomModelqueryResource resource = resourceRef.get();
		if (resource != null) {
			resource.executeQuery();
		}
		else {
			IndexUtil.INSTANCE.removeListener(this);
		}
	}

}
