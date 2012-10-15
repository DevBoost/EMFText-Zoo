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
package edu.stanford.nlp.trees.international.hebrew;

import edu.stanford.nlp.trees.AbstractTreebankLanguagePack;
import edu.stanford.nlp.trees.HeadFinder;
import edu.stanford.nlp.trees.LeftHeadFinder;
import edu.stanford.nlp.trees.TreeReaderFactory;

/**
 * 
 * @author Spence Green
 *
 */
public class HebrewTreebankLanguagePack extends AbstractTreebankLanguagePack {

  private static final long serialVersionUID = 4787589385598144401L;

  private static final String[] pennPunctTags = {"yyCLN", "yyCM","yyDASH","yyDOT","yyEXCL","yyLRB","yyQM","yyQUOT","yyRRB","yySCLN"};
  
  private static final String[] pennSFPunctTags = {"yyDOT","yyEXCL","yyQM"};

  private static final String[] collinsPunctTags = {"-NONE-","yyCLN", "yyCM","yyDASH","yyDOT","yyEXCL","yyLRB","yyQM","yyQUOT","yyRRB","yySCLN"};;

  private static final char[] annotationIntroducingChars = {'-', '=', '|', '#', '^', '~'};

  /**
   * wsg: This is the convention in Reut's preprocessed version of the treebank, and the Collins stuff.
   * But we could change it to ROOT....
   */
  private static final String[] pennStartSymbols = {"TOP"};
  
  @Override
  public String[] punctuationTags() {
    return pennPunctTags;
  }

  @Override
  public String[] punctuationWords() {
    return pennPunctTags;//Same as PTB
  }

  @Override
  public String[] sentenceFinalPunctuationTags() {
    return pennSFPunctTags;
  }

  @Override
  public String[] startSymbols() {
    return pennStartSymbols;
  }

  //TODO: Need to add Reut's rules
  public HeadFinder headFinder() {
    return new LeftHeadFinder();
  }

  //TODO: Need to add Reut's rules
  public HeadFinder typedDependencyHeadFinder() {
    return new LeftHeadFinder();
  }

  public String[] sentenceFinalPunctuationWords() {
    return pennSFPunctTags;
  }
  
  @Override
  public String[] evalBIgnoredPunctuationTags() {
    return collinsPunctTags;
  }

  public String treebankFileExtension() {
    return "tree";
  }
  
  @Override
  public char[] labelAnnotationIntroducingCharacters() {
    return annotationIntroducingChars;
  }
  
  @Override
  public TreeReaderFactory treeReaderFactory() {
    return new HebrewTreeReaderFactory();
  }
}
