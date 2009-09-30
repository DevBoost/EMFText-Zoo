package org.emftext.language.uml_class.resource.uml_class;

// Implementors of this interface can provide a post-processor
// for text resources.
public interface IUml_classResourcePostProcessorProvider {
	
	// Returns the processor that shall be called after text
	// resource are successfully parsed.
	public org.emftext.language.uml_class.resource.uml_class.IUml_classResourcePostProcessor getResourcePostProcessor();
}
