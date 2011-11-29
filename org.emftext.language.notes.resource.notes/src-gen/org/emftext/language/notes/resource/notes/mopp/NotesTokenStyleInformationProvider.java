/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.notes.resource.notes.mopp;

public class NotesTokenStyleInformationProvider {
	
	public org.emftext.language.notes.resource.notes.INotesTokenStyle getDefaultTokenStyle(String tokenName) {
		if ("QUOTED_91_93".equals(tokenName)) {
			return new org.emftext.language.notes.resource.notes.mopp.NotesTokenStyle(new int[] {0x2A, 0x00, 0xFF}, null, false, false, false, false);
		}
		if ("QUOTED_95_95".equals(tokenName)) {
			return new org.emftext.language.notes.resource.notes.mopp.NotesTokenStyle(new int[] {0x2A, 0x00, 0xFF}, null, false, false, false, false);
		}
		if ("QUOTED_35_35".equals(tokenName)) {
			return new org.emftext.language.notes.resource.notes.mopp.NotesTokenStyle(new int[] {0x2A, 0x00, 0xFF}, null, false, false, false, false);
		}
		if ("QUOTED_64_64".equals(tokenName)) {
			return new org.emftext.language.notes.resource.notes.mopp.NotesTokenStyle(new int[] {0x2A, 0x00, 0xFF}, null, false, false, false, false);
		}
		return null;
	}
	
}
