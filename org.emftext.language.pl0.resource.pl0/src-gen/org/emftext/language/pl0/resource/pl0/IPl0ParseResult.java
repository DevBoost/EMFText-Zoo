/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.pl0.resource.pl0;

// An interface used to access the result of parsing a
// document.
public interface IPl0ParseResult {
	
	public org.eclipse.emf.ecore.EObject getRoot();
	
	public java.util.Collection<org.emftext.language.pl0.resource.pl0.IPl0Command<org.emftext.language.pl0.resource.pl0.IPl0TextResource>> getPostParseCommands();
}
