/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.pl0extended.resource.pl0extended.ui;

/**
 * A proposal for completing an incomplete document.
 */
public class Pl0extendedCompletionProposal implements java.lang.Comparable<Pl0extendedCompletionProposal> {
	private java.lang.String insertString;
	private java.lang.String prefix;
	private boolean startsWithPrefix;
	private boolean structuralFeature;
	private org.eclipse.swt.graphics.Image image;
	
	public Pl0extendedCompletionProposal(java.lang.String insertString, java.lang.String prefix, boolean startsWithPrefix, boolean structuralFeature, org.eclipse.swt.graphics.Image image) {
		this(insertString, prefix, startsWithPrefix, structuralFeature);
		this.image = image;
	}
	
	public Pl0extendedCompletionProposal(java.lang.String insertString, java.lang.String prefix, boolean startsWithPrefix, boolean structuralFeature) {
		super();
		this.insertString = insertString;
		this.prefix = prefix;
		this.startsWithPrefix = startsWithPrefix;
		this.structuralFeature = structuralFeature;
	}
	
	public java.lang.String getInsertString() {
		return insertString;
	}
	
	public java.lang.String getPrefix() {
		return prefix;
	}
	
	public boolean getStartsWithPrefix() {
		return startsWithPrefix;
	}
	
	public org.eclipse.swt.graphics.Image getImage() {
		return image;
	}
	
	public boolean isStructuralFeature() {
		return structuralFeature;
	}
	
	public boolean equals(Object object) {
		if (object instanceof Pl0extendedCompletionProposal) {
			Pl0extendedCompletionProposal other = (Pl0extendedCompletionProposal) object;
			return other.getInsertString().equals(getInsertString());
		}
		return false;
	}
	
	public int hashCode() {
		return getInsertString().hashCode();
	}
	
	public int compareTo(Pl0extendedCompletionProposal object) {
		if (object instanceof Pl0extendedCompletionProposal) {
			Pl0extendedCompletionProposal other = (Pl0extendedCompletionProposal) object;
			// proposals that start with the prefix are preferred over the ones that do not
			int startCompare = (startsWithPrefix ? 1 : 0) - (other.getStartsWithPrefix() ? 1 : 0);
			// if both proposals start with the prefix of both do not the insert string is
			// compared
			return startCompare == 0 ? getInsertString().compareTo(other.getInsertString()) : -startCompare;
		}
		return -1;
	}
	
}
