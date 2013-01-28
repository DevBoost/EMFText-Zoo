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
package edu.stanford.nlp.trees.international.arabic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.Sentence;
import edu.stanford.nlp.trees.LabeledScoredTreeFactory;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeFactory;
import edu.stanford.nlp.trees.international.arabic.ArabicTreeNormalizer.ArabicEmptyFilter;
import edu.stanford.nlp.util.Filter;

/**
 * Various static convenience methods for processing Arabic parse trees.
 *
 * @author Spence Green
 *
 */
public class ATBTreeUtils {

  private static final Filter<Tree> emptyFilter = new ArabicEmptyFilter();
  private static final TreeFactory tf = new LabeledScoredTreeFactory();

  //The default segmentation marker. Can be changed for processing e.g. IBM Arabic.
  public static String segMarker = "-";
  
  //The default morpheme boundary marker. Present only in the vocalized sections.
  public static final String morphBoundary = "+";
  
  //Global tag for all punctuation
  public static final String puncTag = "PUNC";
  
  //Reserved tokens class
  private static final String reservedWordList = "-PLUS- -LRB- -RRB-";
  public static final Set<String> reservedWords = new HashSet<String>();
  static {
  	reservedWords.addAll(Arrays.asList(reservedWordList.split("\\s+")));
  }
  
  private ATBTreeUtils() {}  // static class

  /**
   * Escapes tokens from flat strings that are reserved for usage in the ATB.
   *
   * @param s - An Arabic string
   * @return A string with all reserved words replaced by the appropriate tokens
   */
  public static String escape(String s) {
    if(s == null) return null;

    //LDC escape sequences (as of ATB3p3)
    s = s.replaceAll("\\(", "-LRB-");
    s = s.replaceAll("\\)", "-RRB-");
    s = s.replaceAll("\\+", "-PLUS-");

    return s;
  }

  /**
   * Reverts escaping from a flat string.
   *
   * @param s - An Arabic string
   * @return A string with all reserved words inserted into the appropriate locations
   */
  public static String unEscape(String s) {
    if(s == null) return null;

    //LDC escape sequences (as of ATB3p3)
    s = s.replaceAll("-LRB-", "(");
    s = s.replaceAll("-RRB-", ")");
    s = s.replaceAll("-PLUS-", "+");

    return s;
  }

  /**
   * Returns the string associated with the input parse tree. Traces and
   * ATB-specific escape sequences (e.g., "-RRB-" for ")") are removed.
   *
   * @param t - A parse tree
   * @return The yield of the input parse tree
   */
  public static String flattenTree(Tree t) {
    t = t.prune(emptyFilter, tf);

    String flatString = Sentence.listToString(t.yield());

    return flatString;
  }
  
  /**
   * Converts a parse tree into a string of tokens. Each token is a word and
   * its POS tag separated by the delimiter specified by <code>separator</code>
   * 
   * @param t - A parse tree
   * @param removeEscaping - If true, remove LDC escape characters. Otherwise, leave them.
   * @param separator Word/tag separator
   * @return A string of tagged words
   */
  public static String taggedStringFromTree(Tree t, boolean removeEscaping, String separator) {
    t = t.prune(emptyFilter, tf);
    List<CoreLabel> taggedSentence = t.taggedLabeledYield();
    for (CoreLabel token : taggedSentence) {
      String word = (removeEscaping) ? unEscape(token.word()) : token.word();
      token.setWord(word);
      token.setValue(word);
    }
    return Sentence.listToString(taggedSentence, false, separator);
  }

  public static void main(String[] args) {
    String debug = "( the big lion ) + (the small rabbit)";
    String escaped = ATBTreeUtils.escape(debug);
    System.out.println(escaped);
  }

}
