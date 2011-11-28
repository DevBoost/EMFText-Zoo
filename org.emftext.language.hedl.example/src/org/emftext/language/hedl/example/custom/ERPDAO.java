package org.emftext.language.hedl.example.custom;

import org.emftext.language.hedl.example.dao.ERPDAOBase;

// this class is only generated once. it can be customized and all changes
// will be preserved.
public class ERPDAO extends ERPDAOBase {
	
	public void handleException(Exception e, boolean retry) {
		e.printStackTrace();
	}
}
