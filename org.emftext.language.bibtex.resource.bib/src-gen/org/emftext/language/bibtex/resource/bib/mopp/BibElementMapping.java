/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.bibtex.resource.bib.mopp;

/**
 * A basic implementation of the
 * org.emftext.language.bibtex.resource.bib.IBibElementMapping interface.
 * 
 * @param <ReferenceType> the type of the reference that can be mapped to
 */
public class BibElementMapping<ReferenceType> implements org.emftext.language.bibtex.resource.bib.IBibElementMapping<ReferenceType> {
	
	private final ReferenceType target;
	private String identifier;
	private String warning;
	
	public BibElementMapping(String identifier, ReferenceType target, String warning) {
		super();
		this.target = target;
		this.identifier = identifier;
		this.warning = warning;
	}
	
	public ReferenceType getTargetElement() {
		return target;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public String getWarning() {
		return warning;
	}
	
}
