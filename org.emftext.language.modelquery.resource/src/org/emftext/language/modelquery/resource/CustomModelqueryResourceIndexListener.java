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
package org.emftext.language.modelquery.resource;

import java.lang.ref.WeakReference;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.reuseware.sokan.ID;
import org.reuseware.sokan.index.notify.IndexListener;
import org.reuseware.sokan.index.util.IndexUtil;

public class CustomModelqueryResourceIndexListener implements IndexListener {

	private WeakReference<CustomModelqueryResource> resourceRef = null;
	private URI resourceURI = null;
	
	public CustomModelqueryResourceIndexListener(
			CustomModelqueryResource resource) {
		this.resourceRef = new WeakReference<CustomModelqueryResource>(resource);
		this.resourceURI = resource.getURI();
	}

	public void indexChanged(Set<ID> delta) {
		CustomModelqueryResource resource = resourceRef.get();
		if (resource != null) {
			resource.executeQuery();
		}
		else {
			System.err.println("[Modelquery] Removing Index Listener for: " + resourceURI.toString());
			IndexUtil.INSTANCE.removeListener(this);
		}
	}

}
