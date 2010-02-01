/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.pl0.resource.pl0.mopp;

// A InputStreamProcessor can be used like a normal java.io.InputStream,
// but provides information about the encoding that is used to
// represent characters as bytes.
public abstract class Pl0InputStreamProcessor extends java.io.InputStream {
	
	// Returns the encoding of the characters that can be read
	// from this InputStreamProcessor. This encoding is passed
	// to subsequent streams (e.g., the ANTLRInputStream).
	public abstract String getOutputEncoding();
}
