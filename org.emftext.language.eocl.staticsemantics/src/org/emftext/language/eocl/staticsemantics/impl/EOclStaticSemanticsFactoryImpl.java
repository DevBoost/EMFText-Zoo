package org.emftext.language.eocl.staticsemantics.impl;

import tudresden.ocl20.pivot.language.ocl.resource.ocl.mopp.IOclResource;
import tudresden.ocl20.pivot.language.ocl.staticsemantics.factory.OclStaticSemanticsFactory;

public class EOclStaticSemanticsFactoryImpl implements
		OclStaticSemanticsFactory {

	public EOclStaticSemanticsFactoryImpl() {
		
	}
	
	public tudresden.ocl20.pivot.language.ocl.staticsemantics.OclStaticSemantics createOclStaticSemantics(IOclResource _resource) {
		return org.emftext.language.eocl.staticsemantics.impl.EOclStaticSemanticsFactoryImplHelper.createOclStaticSemantics(_resource);
	}

}
