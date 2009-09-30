package org.emftext.language.uml_class.resource.uml_class.mopp;

// java.lang.Exception class to represent invalid content types for parser instances.
//
// @see org.emftext.language.uml_class.resource.uml_class.IUml_classOptions.RESOURCE_CONTENT_TYPE
public class Uml_classUnexpectedContentTypeException extends org.antlr.runtime.RecognitionException{
	
	private static final long serialVersionUID = 4791359811519433999L;
	
	private Object contentType = null;
	
	public  Uml_classUnexpectedContentTypeException(Object contentType) {
		this.contentType = contentType;
	}
	
	public Object getContentType() {
		return contentType;
	}
}
