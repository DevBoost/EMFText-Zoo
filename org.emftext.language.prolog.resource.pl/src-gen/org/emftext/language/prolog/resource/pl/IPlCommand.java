/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl;

/**
 * A simple interface for commands that can be executed and that return
 * information about the success of their execution.
 */
public interface IPlCommand<ContextType> {
	
	public boolean execute(ContextType context);
}
