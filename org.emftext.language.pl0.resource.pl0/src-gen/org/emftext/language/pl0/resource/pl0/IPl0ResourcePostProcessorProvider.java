/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.pl0.resource.pl0;

// Implementors of this interface can provide a post-processor
// for text resources.
public interface IPl0ResourcePostProcessorProvider {
	
	// Returns the processor that shall be called after text
	// resource are successfully parsed.
	public org.emftext.language.pl0.resource.pl0.IPl0ResourcePostProcessor getResourcePostProcessor();
}
