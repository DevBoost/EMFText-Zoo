/*******************************************************************************
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
 ******************************************************************************/
package edu.stanford.nlp.parser.lexparser;

import edu.stanford.nlp.trees.TreeTransformer;
import edu.stanford.nlp.trees.TreeFactory;
import edu.stanford.nlp.trees.HeadFinder;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.stats.ClassicCounter;
import edu.stanford.nlp.stats.Counters;
import edu.stanford.nlp.ling.CategoryWordTag;
import edu.stanford.nlp.ling.Word;

import java.util.*;


/**
 * This class splits on parents using the same algorithm as the earlier
 * parent (selective) annotation algorithms, but applied AFTER the tree
 * has been annotated.
 *
 * @author Christopher Manning
 */
class PostSplitter implements TreeTransformer {

  private ClassicCounter<String> nonTerms = new ClassicCounter<String>();
  private TreebankLangParserParams tlpParams;
  private TreeFactory tf;
  private HeadFinder hf;
  private final TrainOptions trainOptions;

  public Tree transformTree(Tree t) {
    tf = t.treeFactory();
    return transformTreeHelper(t, t);
  }

  public Tree transformTreeHelper(Tree t, Tree root) {
    Tree result;
    Tree parent;
    Tree grandParent;
    String parentStr;
    String grandParentStr;
    if (root == null || t.equals(root)) {
      parent = null;
      parentStr = "";
    } else {
      parent = t.parent(root);
      parentStr = parent.label().value();
    }
    if (parent == null || parent.equals(root)) {
      grandParent = null;
      grandParentStr = "";
    } else {
      grandParent = parent.parent(root);
      grandParentStr = grandParent.label().value();
    }
    String cat = t.label().value();
    String baseParentStr = tlpParams.treebankLanguagePack().basicCategory(parentStr);
    String baseGrandParentStr = tlpParams.treebankLanguagePack().basicCategory(grandParentStr);
    if (t.isLeaf()) {
      return tf.newLeaf(new Word(t.label().value()));
    }
    String word = t.headTerminal(hf).value();
    if (t.isPreTerminal()) {
      nonTerms.incrementCount(t.label().value());
    } else {
      nonTerms.incrementCount(t.label().value());
      if (trainOptions.postPA && !trainOptions.smoothing && baseParentStr.length() > 0) {
        String cat2;
        if (trainOptions.postSplitWithBaseCategory) {
          cat2 = cat + "^" + baseParentStr;
        } else {
          cat2 = cat + "^" + parentStr;
        }
        if (!trainOptions.selectivePostSplit || trainOptions.postSplitters.contains(cat2)) {
          cat = cat2;
        }
      }
      if (trainOptions.postGPA && !trainOptions.smoothing && grandParentStr.length() > 0) {
        String cat2;
        if (trainOptions.postSplitWithBaseCategory) {
          cat2 = cat + "~" + baseGrandParentStr;
        } else {
          cat2 = cat + "~" + grandParentStr;
        }
        if (trainOptions.selectivePostSplit) {
          if (cat.contains("^") && trainOptions.postSplitters.contains(cat2)) {
            cat = cat2;
          }
        } else {
          cat = cat2;
        }
      }
    }
    result = tf.newTreeNode(new CategoryWordTag(cat, word, cat), Collections.EMPTY_LIST);
    ArrayList<Tree> newKids = new ArrayList<Tree>();
    Tree[] kids = t.children();
    for (Tree kid : kids) {
      newKids.add(transformTreeHelper(kid, root));
    }
    result.setChildren(newKids);
    return result;
  }

  public void dumpStats() {
    System.out.println("%% Counts of nonterminals:");
    List<String> biggestCounts = new ArrayList<String>(nonTerms.keySet());
    Collections.sort(biggestCounts, Counters.toComparatorDescending(nonTerms));
    for (String str : biggestCounts) {
      System.out.println(str + ": " + nonTerms.getCount(str));
    }
  }

  public PostSplitter(TreebankLangParserParams tlpParams, Options op) {
    this.tlpParams = tlpParams;
    this.hf = tlpParams.headFinder();
    this.trainOptions = op.trainOptions;
  }

} // end class PostSplitter

