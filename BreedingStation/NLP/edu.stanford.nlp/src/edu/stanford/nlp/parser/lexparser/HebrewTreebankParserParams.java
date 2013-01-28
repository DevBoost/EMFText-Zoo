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
package edu.stanford.nlp.parser.lexparser;

import java.util.List;

import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.Sentence;
import edu.stanford.nlp.trees.DiskTreebank;
import edu.stanford.nlp.trees.HeadFinder;
import edu.stanford.nlp.trees.LeftHeadFinder;
import edu.stanford.nlp.trees.MemoryTreebank;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeReaderFactory;
import edu.stanford.nlp.trees.TreeTransformer;
import edu.stanford.nlp.trees.TreebankLanguagePack;
import edu.stanford.nlp.trees.international.hebrew.HebrewTreeReaderFactory;
import edu.stanford.nlp.trees.international.hebrew.HebrewTreebankLanguagePack;

/**
 * Initial version of a parser pack for the HTB. Not yet integrated
 * into the Stanford parser.
 * <p>
 * This package assumes the romanized orthographic form of Hebrew as
 * used in the treebank. 
 * 
 * @author Spence Green
 *
 */
public class HebrewTreebankParserParams extends AbstractTreebankParserParams {

  private static final long serialVersionUID = -3466519995341208619L;

  private final StringBuilder optionsString;
  private static final String[] EMPTY_STRING_ARRAY = new String[0];

  public HebrewTreebankParserParams() {
    this(new HebrewTreebankLanguagePack());
  }

  protected HebrewTreebankParserParams(TreebankLanguagePack tlp) {
    super(tlp);
    optionsString = new StringBuilder();
    optionsString.append("HebrewTreebankParserParams\n");
  }

  @Override
  public TreeTransformer collinizer() {
    return new TreeCollinizer(tlp, true, false);
  }

  /**
   * Stand-in collinizer does nothing to the tree.
   */
  @Override
  public TreeTransformer collinizerEvalb() {
    return collinizer();
  }

  @Override
  public MemoryTreebank memoryTreebank() {
    return new MemoryTreebank(treeReaderFactory(), inputEncoding);
  }

  @Override
  public DiskTreebank diskTreebank() {
    return new DiskTreebank(treeReaderFactory(), inputEncoding);
  }

  @Override
  public void display() {
    System.err.println(optionsString.toString());
  }

  //TODO Add Reut's rules (from her thesis).
  @Override
  public HeadFinder headFinder() {
    return new LeftHeadFinder();
  }

  @Override
  public HeadFinder typedDependencyHeadFinder() {
    return headFinder();
  }

  @Override
  public String[] sisterSplitters() {
    return EMPTY_STRING_ARRAY;
  }

  @Override
  public Tree transformTree(Tree t, Tree root) {
    return t;
  }


  public List<? extends HasWord> defaultTestSentence() {
    String[] sent = {"H", "MWX", "MTPLC", "LA", "RQ", "M", "H", "TWPEH", "H", "MBIFH", "ALA", "GM", "M", "DRKI", "H", "HERMH", "yyDOT"};
    return Sentence.toWordList(sent);
  }

  public TreeReaderFactory treeReaderFactory() {
    return new HebrewTreeReaderFactory();
  }

}
