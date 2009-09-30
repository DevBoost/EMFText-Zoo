package org.emftext.language.uml_class.resource.uml_class;

// A simple interface for commands that can be executed
// and that return information about the success of their
// execution.
public interface IUml_classCommand<ContextType> {
	
	public boolean execute(ContextType context);
}
