/*******************************************************************************
 * Copyright (c) 2006-2011
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/

package org.emftext.language.bibtex.resource.bib.mopp;

public class BibTokenStyleInformationProvider {
	
	public org.emftext.language.bibtex.resource.bib.IBibTokenStyle getDefaultTokenStyle(String tokenName) {
		if ("COMMENT".equals(tokenName)) {
			return new org.emftext.language.bibtex.resource.bib.mopp.BibTokenStyle(new int[] {0x00, 0x80, 0x00}, null, false, false, false, false);
		}
		if ("@INPROCEEDINGS".equals(tokenName)) {
			return new org.emftext.language.bibtex.resource.bib.mopp.BibTokenStyle(new int[] {0x00, 0x00, 0x80}, null, false, false, false, false);
		}
		if ("@ARTICLE".equals(tokenName)) {
			return new org.emftext.language.bibtex.resource.bib.mopp.BibTokenStyle(new int[] {0x00, 0x00, 0x80}, null, false, false, false, false);
		}
		if ("author".equals(tokenName)) {
			return new org.emftext.language.bibtex.resource.bib.mopp.BibTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("and".equals(tokenName)) {
			return new org.emftext.language.bibtex.resource.bib.mopp.BibTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("editor".equals(tokenName)) {
			return new org.emftext.language.bibtex.resource.bib.mopp.BibTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("keywords".equals(tokenName)) {
			return new org.emftext.language.bibtex.resource.bib.mopp.BibTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("title".equals(tokenName)) {
			return new org.emftext.language.bibtex.resource.bib.mopp.BibTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("booktitle".equals(tokenName)) {
			return new org.emftext.language.bibtex.resource.bib.mopp.BibTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("series".equals(tokenName)) {
			return new org.emftext.language.bibtex.resource.bib.mopp.BibTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("address".equals(tokenName)) {
			return new org.emftext.language.bibtex.resource.bib.mopp.BibTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("month".equals(tokenName)) {
			return new org.emftext.language.bibtex.resource.bib.mopp.BibTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("organization".equals(tokenName)) {
			return new org.emftext.language.bibtex.resource.bib.mopp.BibTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("publisher".equals(tokenName)) {
			return new org.emftext.language.bibtex.resource.bib.mopp.BibTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("journal".equals(tokenName)) {
			return new org.emftext.language.bibtex.resource.bib.mopp.BibTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("note".equals(tokenName)) {
			return new org.emftext.language.bibtex.resource.bib.mopp.BibTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("eid".equals(tokenName)) {
			return new org.emftext.language.bibtex.resource.bib.mopp.BibTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("abstract".equals(tokenName)) {
			return new org.emftext.language.bibtex.resource.bib.mopp.BibTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("review".equals(tokenName)) {
			return new org.emftext.language.bibtex.resource.bib.mopp.BibTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("url".equals(tokenName)) {
			return new org.emftext.language.bibtex.resource.bib.mopp.BibTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("year".equals(tokenName)) {
			return new org.emftext.language.bibtex.resource.bib.mopp.BibTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("volume".equals(tokenName)) {
			return new org.emftext.language.bibtex.resource.bib.mopp.BibTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("part".equals(tokenName)) {
			return new org.emftext.language.bibtex.resource.bib.mopp.BibTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("number".equals(tokenName)) {
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
