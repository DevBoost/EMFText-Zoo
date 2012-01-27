/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl.mopp;

/**
 * A basic implementation of the
 * org.emftext.language.prolog.resource.pl.IPlElementMapping interface.
 * 
 * @param <ReferenceType> the type of the reference that can be mapped to
 */
public class PlElementMapping<ReferenceType> implements org.emftext.language.prolog.resource.pl.IPlElementMapping<ReferenceType> {
	
	private final ReferenceType target;
	private String identifier;
	private String warning;
	
	public PlElementMapping(String identifier, ReferenceType target, String warning) {
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
