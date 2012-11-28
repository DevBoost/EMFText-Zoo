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
package org.devboost.stanford.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import org.devboost.stanford.language.LanguageCreator;
import org.devboost.stanford.language.NLPParagraph;
import org.devboost.stanford.language.Sentence;
import org.devboost.stanford.language.Word;

public class ParserModelDemo {

	public static void main(String[] args) {
		NLPParagraph document;
		try {
			LanguageCreator creator = new LanguageCreator();
			document = creator.parse(new FileReader(new File(args[0])));
			printDocument(document);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void printDocument(NLPParagraph document) {
		List<Sentence> sentences = document.getSentences();
		for (Sentence sentence : sentences) {
			System.out.println(printSentence(sentence) + "\n");
		}
	}

	private static String printSentence(Sentence sentence) {
		List<Word> words = sentence.getWords();
		StringBuffer buffer = new StringBuffer();
		for (Word word : words) {
			buffer.append(word.getText() + "(" + word.eClass().getName() + ":" + word.getBegin() + ":" + word.getEnd() + ")");
		}
		return buffer.toString();
	}
}
