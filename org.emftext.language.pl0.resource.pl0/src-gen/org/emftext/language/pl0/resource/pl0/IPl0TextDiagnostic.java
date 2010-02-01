/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.pl0.resource.pl0;

// An extended diagnostic that gives access to the exact position of the problem
// in a character stream.
public interface IPl0TextDiagnostic extends org.eclipse.emf.ecore.resource.Resource.Diagnostic {
	
	// @return Position of the first character of the problem area.
	public int getCharStart();
	
	// @return Position of the last character of the problem area.
	public int getCharEnd();
	
	// @return The column of the problem area.
	public int getColumn();
	
	// @return The line that contains the problem area.
	public int getLine();
	
	// Returns the problem that was found.
	//
	// @return
	public org.emftext.language.pl0.resource.pl0.IPl0Problem getProblem();
	
	// Checks whether the problem was caused by the given element.
	public boolean wasCausedBy(org.eclipse.emf.ecore.EObject element);
}
