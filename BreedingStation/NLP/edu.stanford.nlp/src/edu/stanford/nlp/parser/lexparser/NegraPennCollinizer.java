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

import java.util.ArrayList;
import java.util.List;

import edu.stanford.nlp.ling.Label;
import edu.stanford.nlp.ling.StringLabel;
import edu.stanford.nlp.trees.LabeledScoredTreeFactory;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeFactory;
import edu.stanford.nlp.trees.TreeTransformer;


class NegraPennCollinizer implements TreeTransformer {

  private TreebankLangParserParams tlpp; 
  private final boolean deletePunct;

  public NegraPennCollinizer(TreebankLangParserParams tlpp) {
    this(tlpp, true);
  }

  public NegraPennCollinizer(TreebankLangParserParams tlpp, boolean deletePunct) {
    this.tlpp = tlpp;
    this.deletePunct = deletePunct;
  }

  protected TreeFactory tf = new LabeledScoredTreeFactory();

  public Tree transformTree(Tree tree) {
    Label l = tree.label();
    if (tree.isLeaf()) {
      return tf.newLeaf(l);
    }
    String s = l.value();
    s = tlpp.treebankLanguagePack().basicCategory(s);
    if (deletePunct) {
      // this is broken as it's not the right thing to do when there
      // is any tag ambiguity -- and there is for ' (POS/'').  Sentences
      // can then have more or less words.  It's also unnecessary for EVALB,
      // since it ignores punctuation anyway
      if (tree.isPreTerminal() && tlpp.treebankLanguagePack().isEvalBIgnoredPunctuationTag(s)) {
        return null;
      }
    }
    // TEMPORARY: eliminate the TOPP constituent
    if (tree.children()[0].label().value().equals("TOPP")) {
      System.err.println("Found a TOPP");
      tree.setChildren(tree.children()[0].children());
    }

    // Negra has lots of non-unary roots; delete unary roots
    if (tlpp.treebankLanguagePack().isStartSymbol(s) && tree.numChildren() == 1) {
      // NB: This deletes the boundary symbol, which is in the tree!
      return transformTree(tree.getChild(0));
    }
    List<Tree> children = new ArrayList<Tree>();
    for (int cNum = 0, numC = tree.numChildren(); cNum < numC; cNum++) {
      Tree child = tree.getChild(cNum);
      Tree newChild = transformTree(child);
      if (newChild != null) {
        children.add(newChild);
      }
    }
    if (children.isEmpty()) {
      return null;
    }
    return tf.newTreeNode(new StringLabel(s), children);
  }
}
