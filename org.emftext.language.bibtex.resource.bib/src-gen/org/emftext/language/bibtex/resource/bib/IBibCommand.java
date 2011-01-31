/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.bibtex.resource.bib;

/**
 * A simple interface for commands that can be executed and that return
 * information about the success of their execution.
 */
public interface IBibCommand<ContextType> {
	
	public boolean execute(ContextType context);
}
