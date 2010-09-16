package org.emftext.language.eocl.staticsemantics.provider;

import java.util.HashMap;
import java.util.Map;

import org.emftext.language.eocl.resource.eocl.IEoclOptionProvider;
import org.emftext.language.eocl.resource.eocl.IEoclOptions;
import org.emftext.language.eocl.resource.eocl.IEoclResourcePostProcessorProvider;

import tudresden.ocl20.pivot.language.ocl.resource.ocl.IOclReferenceResolveHelper;
import tudresden.ocl20.pivot.language.ocl.staticsemantics.postporcessor.OclReferenceResolveHelper;

public class EOclLoadOptionsProvider implements IEoclOptionProvider {

	private IEoclResourcePostProcessorProvider oclResourcePostProcessorProvider;
	private IOclReferenceResolveHelper oclReferenceResolveHelper;
	
	public EOclLoadOptionsProvider() {
		oclResourcePostProcessorProvider = new EOclResourcePostProcessorProvider();
		oclReferenceResolveHelper = new OclReferenceResolveHelper();
	}

	public Map<?, ?> getOptions() {
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		result.put(IEoclOptions.RESOURCE_POSTPROCESSOR_PROVIDER, oclResourcePostProcessorProvider);
		result.put("ReferenceResolveHelper", oclReferenceResolveHelper);
		return result;
	}

}

