/**
 * Copyright (C) 2012
 * Jan Reimann (TU Dresden, Software Technology Group)
 * Mirko Seifert (DevBoost GmbH)
 * Rolf-Helge Pfeiffer (IT University Copenhagen)
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
*/
package org.devboost.stanford.language.resource.txt;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.devboost.stanford.language.LanguageCreator;
import org.devboost.stanford.language.NLPParagraph;
import org.devboost.stanford.language.resource.txt.mopp.TxtExpectedTerminal;
import org.devboost.stanford.language.resource.txt.mopp.TxtParseResult;
import org.eclipse.emf.ecore.EClass;

/**
 * @author jreimann
 *
 */
public class StanfordParser implements ITxtTextParser {

	private InputStream inputStream;
	private String encoding;
	private static LanguageCreator languageCreator = new LanguageCreator();
	
	/**
	 * @param inputStream
	 * @param encoding
	 */
	public StanfordParser(InputStream inputStream, String encoding) {
		this.inputStream = inputStream;
		this.encoding = encoding;
	}

	@Override
	public ITxtParseResult parse() {
		try {
			NLPParagraph paragraph = null;
			if(encoding == null){
				paragraph = languageCreator.parse(new InputStreamReader(inputStream));
			} else {
				paragraph = languageCreator.parse(new InputStreamReader(inputStream, encoding));
			}
			TxtParseResult result = new TxtParseResult();
			result.setRoot(paragraph);
			return result;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<TxtExpectedTerminal> parseToExpectedElements(EClass type, ITxtTextResource dummyResource, int cursorOffset) {
		return Collections.emptyList();
	}

	@Override
	public void terminate() {

	}

	@Override
	public void setOptions(Map<?, ?> options) {
		
	}
}
