/*******************************************************************************
 * Copyright (C) 2012
 * The Stanford Natural Language Processing Group 
 * http://nlp.stanford.edu/
 * This Eclipse plugin matches the Stanford CoreNLP version 1.3.3
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
 ******************************************************************************/
package edu.stanford.nlp.trees;

import edu.stanford.nlp.ling.Word;
import edu.stanford.nlp.objectbank.TokenizerFactory;
import edu.stanford.nlp.process.PTBTokenizer;
import edu.stanford.nlp.util.Filter;


/**
 * Specifies the treebank/language specific components needed for
 * parsing the English Penn Treebank.
 *
 * @author Christopher Manning
 * @version 1.1
 */
public class PennTreebankLanguagePack extends AbstractTreebankLanguagePack {

  /**
   * Gives a handle to the TreebankLanguagePack
   */
  public PennTreebankLanguagePack() {
  }


  private static String[] pennPunctTags = {"''", "``", "-LRB-", "-RRB-", ".", ":", ","};

  private static String[] pennSFPunctTags = {"."};

  private static String[] collinsPunctTags = {"''", "``", ".", ":", ","};

  private static String[] pennPunctWords = {"''", "'", "``", "`", "-LRB-", "-RRB-", "-LCB-", "-RCB-", ".", "?", "!", ",", ":", "-", "--", "...", ";"};

  private static String[] pennSFPunctWords = {".", "!", "?"};


  /**
   * The first 3 are used by the Penn Treebank; # is used by the
   * BLLIP corpus, and ^ and ~ are used by Klein's lexparser.
   * Teg added the last one _ (let me know if it hurts).
   */
  private static char[] annotationIntroducingChars = {'-', '=', '|', '#', '^', '~', '_'};

  /**
   * This is valid for "BobChrisTreeNormalizer" conventions only.
   */
  private static String[] pennStartSymbols = {"ROOT", "TOP"};


  /**
   * Returns a String array of punctuation tags for this treebank/language.
   *
   * @return The punctuation tags
   */
  @Override
  public String[] punctuationTags() {
    return pennPunctTags;
  }


  /**
   * Returns a String array of punctuation words for this treebank/language.
   *
   * @return The punctuation words
   */
  @Override
  public String[] punctuationWords() {
    return pennPunctWords;
  }


  /**
   * Returns a String array of sentence final punctuation tags for this
   * treebank/language.
   *
   * @return The sentence final punctuation tags
   */
  @Override
  public String[] sentenceFinalPunctuationTags() {
    return pennSFPunctTags;
  }

  /**
   * Returns a String array of sentence final punctuation words for this
   * treebank/language.
   *
   * @return The sentence final punctuation tags
   */
  public String[] sentenceFinalPunctuationWords() {
    return pennSFPunctWords;
  }

  /**
   * Returns a String array of punctuation tags that EVALB-style evaluation
   * should ignore for this treebank/language.
   * Traditionally, EVALB has ignored a subset of the total set of
   * punctuation tags in the English Penn Treebank (quotes and
   * period, comma, colon, etc., but not brackets)
   *
   * @return Whether this is a EVALB-ignored punctuation tag
   */
  @Override
  public String[] evalBIgnoredPunctuationTags() {
    return collinsPunctTags;
  }


  /**
   * Return an array of characters at which a String should be
   * truncated to give the basic syntactic category of a label.
   * The idea here is that Penn treebank style labels follow a syntactic
   * category with various functional and crossreferencing information
   * introduced by special characters (such as "NP-SBJ=1").  This would
   * be truncated to "NP" by the array containing '-' and "=".
   *
   * @return An array of characters that set off label name suffixes
   */
  @Override
  public char[] labelAnnotationIntroducingCharacters() {
    return annotationIntroducingChars;
  }


  /**
   * Returns a String array of treebank start symbols.
   *
   * @return The start symbols
   */
  @Override
  public String[] startSymbols() {
    return pennStartSymbols;
  }

  /**
   * Returns a factory for {@link PTBTokenizer}.
   *
   * @return A tokenizer
   */
  @Override
  public TokenizerFactory<Word> getTokenizerFactory() {
    return PTBTokenizer.factory();
  }

  /**
   * Returns the extension of treebank files for this treebank.
   * This is "mrg".
   */
  public String treebankFileExtension() {
    return "mrg";
  }

  /**
   * Return a GrammaticalStructure suitable for this language/treebank.
   *
   * @return A GrammaticalStructure suitable for this language/treebank.
   */
  @Override
  public GrammaticalStructureFactory grammaticalStructureFactory() {
    return new GrammaticalStructureFactory("edu.stanford.nlp.trees.EnglishGrammaticalStructure");
  }

  /**
   * Return a GrammaticalStructure suitable for this language/treebank.
   * <p>
   * <i>Note:</i> This is loaded by reflection so basic treebank use does not require all the Stanford Dependencies code.
   *
   * @return A GrammaticalStructure suitable for this language/treebank.
   */
  @Override
  public GrammaticalStructureFactory grammaticalStructureFactory(Filter<String> puncFilter) {
    return new GrammaticalStructureFactory("edu.stanford.nlp.trees.EnglishGrammaticalStructure", puncFilter);
  }

  @Override
  public GrammaticalStructureFactory grammaticalStructureFactory(Filter<String> puncFilter, HeadFinder hf) {
    return new GrammaticalStructureFactory("edu.stanford.nlp.trees.EnglishGrammaticalStructure", puncFilter, hf);
  }

  /** {@inheritDoc} */
  public HeadFinder headFinder() {
    return new ModCollinsHeadFinder(this);
  }

  /** {@inheritDoc} */
  public HeadFinder typedDependencyHeadFinder() {
    return new SemanticHeadFinder(this, true);
  }


  /** Prints a few aspects of the TreebankLanguagePack, just for debugging.
   */
  public static void main(String[] args) {
    TreebankLanguagePack tlp = new PennTreebankLanguagePack();
    System.out.println("Start symbol: " + tlp.startSymbol());
    String start = tlp.startSymbol();
    System.out.println("Should be true: " + (tlp.isStartSymbol(start)));
    String[] strs = {"-", "-LLB-", "NP-2", "NP=3", "NP-LGS", "NP-TMP=3"};
    for (String str : strs) {
      System.out.println("String: " + str + " basic: " + tlp.basicCategory(str) + " basicAndFunc: " + tlp.categoryAndFunction(str));
    }
  }

  private static final long serialVersionUID = 9081305982861675328L;

}
