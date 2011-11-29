/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.notes.resource.notes;

/**
 * A simple interface for commands that can be executed and that return
 * information about the success of their execution.
 */
public interface INotesCommand<ContextType> {
	
	public boolean execute(ContextType context);
}
