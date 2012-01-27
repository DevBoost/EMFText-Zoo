/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl;

/**
 * An interface used to access the result of parsing a document.
 */
public interface IPlParseResult {
	
	/**
	 * Returns the root object of the document.
	 */
	public org.eclipse.emf.ecore.EObject getRoot();
	
	/**
	 * Returns a list of commands that must be executed after parsing the document.
	 */
	public java.util.Collection<org.emftext.language.prolog.resource.pl.IPlCommand<org.emftext.language.prolog.resource.pl.IPlTextResource>> getPostParseCommands();
	
}
