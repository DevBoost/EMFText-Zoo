package org.emftext.language.uml_class.resource.uml_class;

// Implementors of this interface can be configured by a
// map of options (or parameters).
public interface IUml_classConfigurable {
	
	// Passed the options given by the map to the configurable
	// object.
	public void setOptions(java.util.Map<?,?> options);
}
