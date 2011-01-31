/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.bibtex.resource.bib;

/**
 * Implementors of this interface can provide a post-processor for text resources.
 */
public interface IBibResourcePostProcessorProvider {
	
	/**
	 * Returns the processor that shall be called after text resource are successfully
	 * parsed.
	 */
	public org.emftext.language.bibtex.resource.bib.IBibResourcePostProcessor getResourcePostProcessor();
	
}
