package org.emftext.language.java.javabehavior4uml.resource.javabehavior;

public class JavabehaviorResource extends org.emftext.runtime.resource.impl.AbstractTextResource {
	
	private org.emftext.runtime.resource.IReferenceResolverSwitch resolverSwitch;
	
	public JavabehaviorResource() {
		super();
	}
	
	public JavabehaviorResource(org.eclipse.emf.common.util.URI uri) {
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
		
		org.emftext.runtime.resource.ITextParser parser = new org.emftext.language.java.javabehavior4uml.resource.javabehavior.JavabehaviorParser().createInstance(actualInputStream, encoding);
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
		org.emftext.language.java.javabehavior4uml.resource.javabehavior.JavabehaviorPrinter printer = new org.emftext.language.java.javabehavior4uml.resource.javabehavior.JavabehaviorPrinter(outputStream, this);
		org.emftext.runtime.resource.IReferenceResolverSwitch referenceResolverSwitch = getReferenceResolverSwitch();
		referenceResolverSwitch.setOptions(options);
		for(org.eclipse.emf.ecore.EObject root : getContents()) {
			printer.print(root);
		}
	}
	
	public String[] getTokenNames() {
		return new JavabehaviorParser(null).getTokenNames();
	}
	
	@Override 	protected String getSyntaxName() {
		return "javabehavior";
	}
	
	public Object getScanner() {
		return new JavabehaviorLexer();
	}
	
	public org.emftext.runtime.resource.IReferenceResolverSwitch getReferenceResolverSwitch() {
		if (resolverSwitch == null) {
			resolverSwitch = new org.emftext.language.java.javabehavior4uml.resource.javabehavior.JavabehaviorReferenceResolverSwitch();
		}
		return resolverSwitch;
	}
	
	protected void doUnload(){
		super.doUnload();
		resolverSwitch = null;
	}
	
	public org.emftext.runtime.resource.ITokenStyle getDefaultTokenStyle(java.lang.String tokenName) {
		if ("ML_COMMENT".equals(tokenName)) {
			return new org.emftext.runtime.resource.impl.BasicTokenStyle(new int[] {0x00, 0x80, 0x00}, false, true, false, false);
		}
		if ("SL_COMMENT".equals(tokenName)) {
			return new org.emftext.runtime.resource.impl.BasicTokenStyle(new int[] {0x00, 0x00, 0x80}, false, true, false, false);
		}
		if ("STRING_LITERAL".equals(tokenName)) {
			return new org.emftext.runtime.resource.impl.BasicTokenStyle(new int[] {0x2A, 0x00, 0xFF}, false, false, false, false);
		}
		if ("IDENTIFIER".equals(tokenName)) {
			return new org.emftext.runtime.resource.impl.BasicTokenStyle(new int[] {0x00, 0x00, 0x00}, false, false, false, false);
		}
		return null;
	}
}
