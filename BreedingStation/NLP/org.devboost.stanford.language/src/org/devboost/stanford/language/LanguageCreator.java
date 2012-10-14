/**
* Copyright (C) 2012  
* Jan Reimann (TU Dresden, Software Technology Group)
* Mirko Seifert (DevBoost GmbH)
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
package org.devboost.stanford.language;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

import org.devboost.stanford.models.DummyClass;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.Label;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.process.DocumentPreprocessor;
import edu.stanford.nlp.trees.GrammaticalStructureFactory;
import edu.stanford.nlp.trees.PennTreebankLanguagePack;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreebankLanguagePack;

/**
 * @author jreimann
 *
 */
public class LanguageCreator {

	private LexicalizedParser lp;
	
	public LanguageCreator() {
		super();
		init();
	}

	public void init() {
		// TODO here the different languages must be passed.
		InputStream resource = DummyClass.class.getResourceAsStream("englishPCFG.ser.gz");
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new GZIPInputStream(resource));
			lp = LexicalizedParser.loadModel(ois);
			TreebankLanguagePack tlp = new PennTreebankLanguagePack();
		    GrammaticalStructureFactory gsf = tlp.grammaticalStructureFactory();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param reader
	 * @param lp
	 * @return
	 */
	public Document parse(InputStreamReader reader) {
		Document document = LanguageFactory.eINSTANCE.createDocument();
		for (List<HasWord> processedSentence : new DocumentPreprocessor(reader)) {
		  Tree parse = lp.apply(processedSentence);
		  Sentence sentence = LanguageFactory.eINSTANCE.createSentence();
		  List<Word> words = createWords(parse, parse);
		  sentence.getWords().addAll(words);
		  document.getSentences().add(sentence);
		}
		return document;
	}

	private static List<Word> createWords(Tree root, Tree tree) {
		List<Word> words = new ArrayList<Word>();
		Label label = tree.label();
		if (label instanceof CoreLabel) {
			CoreLabel coreLabel = (CoreLabel) label;
			int beginPosition = coreLabel.beginPosition();
			int endPosition = coreLabel.endPosition();
//			String category = coreLabel.category();
			String originalText = coreLabel.word();
			if(originalText != null){
//				Tree parent = tree.parent();
				Tree parent = tree.ancestor(1, root);
				Label parentLabel = parent.label();
				if(parentLabel instanceof CoreLabel){
					String parentCategory = ((CoreLabel) parentLabel).category();
					parentCategory = parentCategory.replaceAll("\\$", "S");
					if(parentCategory != null){
						EClassifier classifier = LanguagePackage.eINSTANCE.getEClassifier(parentCategory);
						if(classifier instanceof EClass){
							Word word = (Word) LanguageFactory.eINSTANCE.create((EClass) classifier);
							word.setText(originalText);
							word.setBegin(beginPosition);
							word.setEnd(endPosition);
							words.add(word);
						}
					}
				}
			}
		}
		List<Tree> children = tree.getChildrenAsList();
		for (Tree child : children) {
			words.addAll(createWords(root, child));
		}
		return words;
	}
}
