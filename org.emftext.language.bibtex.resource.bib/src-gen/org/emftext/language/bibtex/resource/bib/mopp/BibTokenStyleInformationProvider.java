/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.bibtex.resource.bib.mopp;

public class BibTokenStyleInformationProvider {
	
	public org.emftext.language.bibtex.resource.bib.IBibTokenStyle getDefaultTokenStyle(String tokenName) {
		if ("COMMENT".equals(tokenName)) {
			return new org.emftext.language.bibtex.resource.bib.mopp.BibTokenStyle(new int[] {0x00, 0x80, 0x00}, null, false, false, false, false);
		}
		if ("title".equals(tokenName)) {
			return new org.emftext.language.bibtex.resource.bib.mopp.BibTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("booktitle".equals(tokenName)) {
			return new org.emftext.language.bibtex.resource.bib.mopp.BibTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("year".equals(tokenName)) {
			return new org.emftext.language.bibtex.resource.bib.mopp.BibTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("author".equals(tokenName)) {
			return new org.emftext.language.bibtex.resource.bib.mopp.BibTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("and".equals(tokenName)) {
			return new org.emftext.language.bibtex.resource.bib.mopp.BibTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("journal".equals(tokenName)) {
			return new org.emftext.language.bibtex.resource.bib.mopp.BibTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("volume".equals(tokenName)) {
			return new org.emftext.language.bibtex.resource.bib.mopp.BibTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("pages".equals(tokenName)) {
			return new org.emftext.language.bibtex.resource.bib.mopp.BibTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("QUOTED_34_34".equals(tokenName)) {
			return new org.emftext.language.bibtex.resource.bib.mopp.BibTokenStyle(new int[] {0x2A, 0x00, 0xFF}, null, false, false, false, false);
		}
		return null;
	}
	
}
