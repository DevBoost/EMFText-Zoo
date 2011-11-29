/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.notes.resource.notes;

/**
 * Implementors of this interface provide an EMF resource.
 */
public interface INotesResourceProvider {
	
	/**
	 * Returns the resource.
	 */
	public org.emftext.language.notes.resource.notes.INotesTextResource getResource();
	
}
