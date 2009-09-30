package org.emftext.language.uml_class.resource.uml_class;

// Implementors of this interface can be used to post-process
// parsed text resources. This can be useful to validate or
// modify the model that was instantiated for the text.
public interface IUml_classResourcePostProcessor {
	
	// Processes the resource after it was parsed.
	//
	// @param resource the resource to validate of modify
	public void process(org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classResource resource);
}
