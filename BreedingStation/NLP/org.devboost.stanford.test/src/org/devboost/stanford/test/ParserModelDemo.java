/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.devboost.stanford.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import org.devboost.stanford.language.LanguageCreator;
import org.devboost.stanford.language.NLPParagraph;
import org.devboost.stanford.language.Sentence;
import org.devboost.stanford.language.Word;

/**
 * @author jreimann
 *
 */
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
