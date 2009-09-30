package org.emftext.language.uml_class.resource.uml_class;

// Implementors of this interface can provide InputStreamProcessors. These
// processors can be used to pre-process input stream before a text resource
// is actually lexed and parsed. This can be for example useful to do an
// encoding conversion.
//
// TODO use EMF's load option Resource.OPTION_CIPHER instead
public interface IUml_classInputStreamProcessorProvider {
	
	// Return a processor for the given input stream.
	//
	// @param inputStream the actual stream that provides the content of a resource
	// @return a processor that pre-processes the input stream
	public org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classInputStreamProcessor getInputStreamProcessor(java.io.InputStream inputStream);
}
