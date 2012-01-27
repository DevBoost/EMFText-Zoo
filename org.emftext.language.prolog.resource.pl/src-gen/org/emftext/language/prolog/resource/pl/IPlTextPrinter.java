/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl;

/**
 * Converts a tree of <code>org.eclipse.emf.ecore.EObject</code>s into a plain
 * text.
 */
public interface IPlTextPrinter extends org.emftext.language.prolog.resource.pl.IPlConfigurable {
	
	/**
	 * Prints the given <code>org.eclipse.emf.ecore.EObject</code> and its content to
	 * the underlying output stream that was passed to this printer upon creation.
	 * 
	 * @param element The element to print.
	 * 
	 * @throws java.io.IOException if printing to the underlying stream or device
	 * fails.
	 */
	public void print(org.eclipse.emf.ecore.EObject element) throws java.io.IOException;
	
}
