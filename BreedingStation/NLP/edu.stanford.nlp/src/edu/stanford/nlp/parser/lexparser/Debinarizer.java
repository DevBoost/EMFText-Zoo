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

import java.util.*;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.LabelFactory;
import edu.stanford.nlp.trees.LabeledScoredTreeFactory;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeFactory;
import edu.stanford.nlp.trees.TreeTransformer;

/** Debinarizes a binary tree from the parser.
 *  Node values with a '@' in them anywhere are assumed to be inserted
 *  nodes for the purpose of binarization, and are removed.
 *  The code also removes the last child of the root node, assuming
 *  that is an inserted dependency root.
 */
public class Debinarizer implements TreeTransformer {

  private final TreeFactory tf;
  private final boolean forceCNF;


  protected Tree transformTreeHelper(Tree t) {
    if (t.isLeaf()) {
      Tree leaf = tf.newLeaf(t.label());
      leaf.setScore(t.score());
      return leaf;
    }
    List<Tree> newChildren = new ArrayList<Tree>(20);
    for (int childNum = 0, numKids = t.numChildren(); childNum < numKids; childNum++) {
      Tree child = t.getChild(childNum);
      Tree newChild = transformTreeHelper(child);
      if ((!newChild.isLeaf()) && newChild.label().value().indexOf('@') >= 0) {
        newChildren.addAll(newChild.getChildrenAsList());
      } else {
        newChildren.add(newChild);
      }
    }
    Tree node = tf.newTreeNode(t.label(), newChildren);
    node.setScore(t.score());
    return node;
  }

  public Tree transformTree(Tree t) {
    Tree result = transformTreeHelper(t);
    if (forceCNF) {
      result = new CNFTransformers.FromCNFTransformer().transformTree(result);
    }
    return new BoundaryRemover().transformTree(result);
  }

  public Debinarizer(boolean forceCNF) {
    this(forceCNF, CoreLabel.factory());
  }

  public Debinarizer(boolean forceCNF, LabelFactory lf) {
    this.forceCNF = forceCNF;
    tf = new LabeledScoredTreeFactory(lf);
  }

} // end class Debinarizer
