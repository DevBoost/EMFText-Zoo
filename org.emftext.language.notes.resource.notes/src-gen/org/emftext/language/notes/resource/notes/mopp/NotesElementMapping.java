/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.notes.resource.notes.mopp;

/**
 * A basic implementation of the
 * org.emftext.language.notes.resource.notes.INotesElementMapping interface.
 * 
 * @param <ReferenceType> the type of the reference that can be mapped to
 */
public class NotesElementMapping<ReferenceType> implements org.emftext.language.notes.resource.notes.INotesElementMapping<ReferenceType> {
	
	private final ReferenceType target;
	private String identifier;
	private String warning;
	
	public NotesElementMapping(String identifier, ReferenceType target, String warning) {
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
