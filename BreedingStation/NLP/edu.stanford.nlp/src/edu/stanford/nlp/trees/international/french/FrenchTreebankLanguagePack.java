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
package edu.stanford.nlp.trees.international.french;

import edu.stanford.nlp.international.french.FrenchMorphoFeatureSpecification;
import edu.stanford.nlp.international.morph.MorphoFeatureSpecification;
import edu.stanford.nlp.trees.AbstractTreebankLanguagePack;
import edu.stanford.nlp.trees.HeadFinder;


/**
 * Language pack for the French treebank.
 *
 * @author mcdm
 */
public class FrenchTreebankLanguagePack extends AbstractTreebankLanguagePack {

  private static final long serialVersionUID = -7338244949063822519L;

  //wsg2011: The distributed treebank is encoding in ISO8859_1, but
  //the current FrenchTreebankParserParams is currently configured to
  //read UTF-8, PTB style trees that have been extracted from the XML
  //files.
  public static final String FTB_ENCODING = "ISO8859_1";

  //The raw treebank uses "PONCT". Change to LDC convention.
  private static final String[] frenchPunctTags = {"PUNC"};

  private static final String[] frenchSFPunctTags = {"PUNC"};

  private static final String[] frenchPunctWords = {"=","*","/","\\","]","[","\"","''", "'", "``", "`", "-LRB-", "-RRB-", "-LCB-", "-RCB-", ".", "?", "!", ",", ":", "-", "--", "...", ";", "&quot;"};

  private static final String[] frenchSFPunctWords = {".", "!", "?"};

  private static final char[] annotationIntroducingChars = {'-', '=', '|', '#', '^', '~'};

  private static final String[] frenchStartSymbols = {"ROOT"};


  @Override
  public String getEncoding() {
    return FTB_ENCODING;
  }
  
  /**
   * Returns a String array of punctuation tags for this treebank/language.
   *
   * @return The punctuation tags
   */
  @Override
  public String[] punctuationTags() {
    return frenchPunctTags;
  }


  /**
   * Returns a String array of punctuation words for this treebank/language.
   *
   * @return The punctuation words
   */
  @Override
  public String[] punctuationWords() {
    return frenchPunctWords;
  }


  /**
   * Returns a String array of sentence final punctuation tags for this
   * treebank/language.
   *
   * @return The sentence final punctuation tags
   */
  @Override
  public String[] sentenceFinalPunctuationTags() {
    return frenchSFPunctTags;
  }

  /**
   * Returns a String array of sentence final punctuation words for this
   * treebank/language.
   *
   * @return The sentence final punctuation tags
   */
  public String[] sentenceFinalPunctuationWords() {
    return frenchSFPunctWords;
  }


  /**
   * Return an array of characters at which a String should be
   * truncated to give the basic syntactic category of a label.
   * The idea here is that French treebank style labels follow a syntactic
   * category with various functional and crossreferencing information
   * introduced by special characters (such as "NP-SUBJ").  This would
   * be truncated to "NP" by the array containing '-'.
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
    return frenchStartSymbols;
  }


  /**
   * Returns the extension of treebank files for this treebank.
   */
  public String treebankFileExtension() {
    return "xml";
  }

  /** {@inheritDoc} */
  public HeadFinder headFinder() {
    return new FrenchHeadFinder(this);
  }
  
  /** {@inheritDoc} */
  public HeadFinder typedDependencyHeadFinder() {
    return new FrenchHeadFinder(this);
  }
  
  @Override
  public MorphoFeatureSpecification morphFeatureSpec() {
    return new FrenchMorphoFeatureSpecification();
  }

}
