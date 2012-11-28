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

import edu.stanford.nlp.ling.CoreAnnotations.CharacterOffsetBeginAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.CharacterOffsetEndAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.CyclicCoreLabel;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.Label;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.process.DocumentPreprocessor;
import edu.stanford.nlp.trees.GrammaticalRelation;
import edu.stanford.nlp.trees.GrammaticalStructure;
import edu.stanford.nlp.trees.GrammaticalStructureFactory;
import edu.stanford.nlp.trees.PennTreebankLanguagePack;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeGraphNode;
import edu.stanford.nlp.trees.TreebankLanguagePack;
import edu.stanford.nlp.trees.TypedDependency;

/**
 * @author jreimann
 *
 */
public class LanguageCreator {

	private static final String DEPENDENCY_PREFIX	= "D";

	private LexicalizedParser lp;
	private GrammaticalStructureFactory gsf;

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
			gsf = tlp.grammaticalStructureFactory();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param reader
	 * @param lp
	 * @return
	 */
	public NLPParagraph parse(InputStreamReader reader) {
		NLPParagraph nlpParagraph = LanguageFactory.eINSTANCE.createNLPParagraph();
		for (List<HasWord> processedSentence : new DocumentPreprocessor(reader)) {
			Tree parse = lp.apply(processedSentence);
			Sentence sentence = LanguageFactory.eINSTANCE.createSentence();
			List<Word> words = createWords(parse, parse);
			sentence.getWords().addAll(words);
			GrammaticalStructure gs = gsf.newGrammaticalStructure(parse);
			createDependencies(gs, sentence);
			nlpParagraph.getSentences().add(sentence);
		}
		return nlpParagraph;
	}
	
	/**
	 * @param content
	 * @param lp
	 * @return
	 */
	public NLPParagraph parse(String content) {
		NLPParagraph nlpParagraph = LanguageFactory.eINSTANCE.createNLPParagraph();
		
		//the string must contain some words otherwise an exception will be thrown
		if(content.trim().length() > 0) {
			Tree parse = lp.apply(content);
			Sentence sentence = LanguageFactory.eINSTANCE.createSentence();
			List<Word> words = createWords(parse, parse);
			sentence.getWords().addAll(words);
			GrammaticalStructure gs = gsf.newGrammaticalStructure(parse);
			createDependencies(gs, sentence);
			nlpParagraph.getSentences().add(sentence);
			
			return nlpParagraph;
		} else {
			return null;			
		}
	}

	private List<Dependency> createDependencies(GrammaticalStructure gs, Sentence sentence) {
		List<Dependency> dependencies = new ArrayList<Dependency>();
		List<TypedDependency> typedDependencies = gs.typedDependenciesCollapsed(true);
		for (TypedDependency typedDependency : typedDependencies) {
			TreeGraphNode dep = typedDependency.dep();
			TreeGraphNode gov = typedDependency.gov();
			GrammaticalRelation relation = typedDependency.reln();
			String shortName = relation.getShortName();
			String specific = relation.getSpecific();
			EClassifier classifier = LanguagePackage.eINSTANCE.getEClassifier(DEPENDENCY_PREFIX + shortName);
			if(classifier instanceof EClass){
				Dependency dependency = (Dependency) LanguageFactory.eINSTANCE.create((EClass) classifier);
				Word dependant = getWordInSentence(sentence, dep);
				Word governor = null;
				if(!gov.label().word().equals("ROOT")){
					governor = getWordInSentence(sentence, gov);
				}
				if(governor != null){
					dependency.setGovernor(governor);
				}
				if(dependant != null){
					dependency.setDependent(dependant);
					sentence.getDependencies().add(dependency);
				}
				if(specific != null){
					List<Word> words = sentence.findWords(specific);
					if(dependency instanceof Collapse){
						if(words.size() == 1){
							((Collapse) dependency).setCollapsedWord(words.get(0));
						}
						((Collapse) dependency).setCollapsedWordString(specific);
					}
				}
			}
		}
		return dependencies;
	}

	private Word getWordInSentence(Sentence sentence, TreeGraphNode node) {
		CyclicCoreLabel label = node.label();
		int begin = label.get(CharacterOffsetBeginAnnotation.class);
		int end = label.get(CharacterOffsetEndAnnotation.class);
		Word word = sentence.getWord(begin, end);
		return word;
	}

	private static List<Word> createWords(Tree root, Tree tree) {
		List<Word> words = new ArrayList<Word>();
		Label label = tree.label();
		if (label instanceof CoreLabel) {
			CoreLabel coreLabel = (CoreLabel) label;
			int beginPosition = coreLabel.beginPosition();
			int endPosition = coreLabel.endPosition();
			String originalText = coreLabel.word();
			if(originalText != null){
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
