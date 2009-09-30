package org.emftext.language.uml_class.resource.uml_class.mopp;

/**
* This is the printer class used by EMFText.
* Users may implement own behavior by overriding printing methods in the printer base.
* The baseclass contains a pretty printer implementation generated by EMFText which
* is not granted to work in all cases, but should work in most cases.
*/
public class Uml_classPrinter extends Uml_classPrinterBase {
	
	public Uml_classPrinter(java.io.OutputStream o, org.emftext.language.uml_class.resource.uml_class.IUml_classTextResource resource) {
		super(o, resource);
	}
}
