/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.notes.resource.notes;

/**
 * Implementors of this interface can provide a post-processor for text resources.
 */
public interface INotesResourcePostProcessorProvider {
	
	/**
	 * Returns the processor that shall be called after text resource are successfully
	 * parsed.
	 */
	public org.emftext.language.notes.resource.notes.INotesResourcePostProcessor getResourcePostProcessor();
	
}
