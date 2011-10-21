package org.emftext.language.hedl.example.custom;

import org.emftext.language.hedl.example.dao.OperationProviderBase;
import org.hibernate.classic.Session;

// this class is only generated once. it can be customized and all changes
// will be preserved.
public class OperationProvider extends OperationProviderBase implements IDBOperations {

	public OperationProvider(Session session) {
		super(session);
	}

}
