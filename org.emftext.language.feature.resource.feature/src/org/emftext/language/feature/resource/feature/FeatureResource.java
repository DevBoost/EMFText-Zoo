package org.emftext.language.feature.resource.feature;

public class FeatureResource extends org.emftext.runtime.resource.impl.AbstractTextResource {
	
	private org.emftext.runtime.resource.IReferenceResolverSwitch resolverSwitch;
	
	public FeatureResource() {
		super();
	}
	
	public FeatureResource(org.eclipse.emf.common.util.URI uri) {
		super(uri);
	}
	
	protected void doLoad(java.io.InputStream inputStream, java.util.Map<?,?> options) throws java.io.IOException {
		resetLocationMap();
		java.lang.String encoding = null;
		java.io.InputStream actualInputStream = inputStream;
		java.lang.Object inputStreamPreProcessorProvider = null;
		if (options!=null) {
			inputStreamPreProcessorProvider = options.get(org.emftext.runtime.IOptions.INPUT_STREAM_PREPROCESSOR_PROVIDER);
		}
		if (inputStreamPreProcessorProvider != null) {
			if (inputStreamPreProcessorProvider instanceof org.emftext.runtime.IInputStreamProcessorProvider) {
				org.emftext.runtime.IInputStreamProcessorProvider provider = (org.emftext.runtime.IInputStreamProcessorProvider) inputStreamPreProcessorProvider;
				org.emftext.runtime.InputStreamProcessor processor = provider.getInputStreamProcessor(inputStream);
				actualInputStream = processor;
				encoding = processor.getOutputEncoding();
			}
		}
		
		org.emftext.runtime.resource.ITextParser parser = new org.emftext.language.feature.resource.feature.FeatureParser().createInstance(actualInputStream, encoding);
		parser.setResource(this);
		parser.setOptions(options);
		org.emftext.runtime.resource.IReferenceResolverSwitch referenceResolverSwitch = getReferenceResolverSwitch();
		referenceResolverSwitch.setOptions(options);
		org.eclipse.emf.ecore.EObject root = parser.parse();
		if (root != null) {
			getContents().add(root);
		}
		getReferenceResolverSwitch().setOptions(options);
		runPostProcessors(options);
	}
	
	protected void doSave(java.io.OutputStream outputStream, java.util.Map<?,?> options) throws java.io.IOException {
		org.emftext.language.feature.resource.feature.FeaturePrinter printer = new org.emftext.language.feature.resource.feature.FeaturePrinter(outputStream, this);
		org.emftext.runtime.resource.IReferenceResolverSwitch referenceResolverSwitch = getReferenceResolverSwitch();
		referenceResolverSwitch.setOptions(options);
		for(org.eclipse.emf.ecore.EObject root : getContents()) {
			printer.print(root);
		}
	}
	
	public String[] getTokenNames() {
		return new FeatureParser(null).getTokenNames();
	}
	
	@Override 	protected String getSyntaxName() {
		return "feature";
	}
	
	public Object getScanner() {
		return new FeatureLexer();
	}
	
	public org.emftext.runtime.resource.IReferenceResolverSwitch getReferenceResolverSwitch() {
		if (resolverSwitch == null) {
			resolverSwitch = new org.emftext.language.feature.resource.feature.FeatureReferenceResolverSwitch();
		}
		return resolverSwitch;
	}
	
	protected void doUnload(){
		super.doUnload();
		resolverSwitch = null;
	}
	
	public org.emftext.runtime.resource.ITokenStyle getDefaultTokenStyle(java.lang.String tokenName) {
		return null;
	}
}
