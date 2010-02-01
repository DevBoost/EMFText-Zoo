/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.pl0.resource.pl0;

// A simple interface for commands that can be executed
// and that return information about the success of their
// execution.
public interface IPl0Command<ContextType> {
	
	public boolean execute(ContextType context);
}
