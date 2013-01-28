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
package edu.stanford.nlp.trees.tregex.tsurgeon;

import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.tregex.TregexMatcher;

/** Adjoin in a tree (like in TAG).
 *
 *  @author Roger Levy (rog@nlp.stanford.edu)
 */
class AdjoinNode extends TsurgeonPattern {

  private final AuxiliaryTree adjunctionTree;

  public AdjoinNode(AuxiliaryTree t, TsurgeonPattern p) {
    super("adjoin", new TsurgeonPattern[] {p});
    if (t == null || p == null) {
      throw new NullPointerException("AdjoinNode: illegal null argument, t=" + t + ", p=" + p);
    }
    adjunctionTree = t;
  }

  protected AuxiliaryTree adjunctionTree() {
    return adjunctionTree;
  }

  @Override
  public Tree evaluate(Tree t, TregexMatcher m) {
    // find match and get its parent
    Tree targetNode = children[0].evaluate(t,m);
    Tree parent = targetNode.parent(t);
    // put children underneath target in foot of auxilary tree
    AuxiliaryTree ft = adjunctionTree.copy(this);
    ft.foot.setChildren(targetNode.getChildrenAsList());
    // replace match with root of auxiliary tree
    if (parent==null) {
      return ft.tree;
    } else {
      int i = parent.indexOf(targetNode);
      parent.setChild(i,ft.tree);
      return t;
    }
  }

  @Override
  public String toString() {
    return super.toString() + "<-" + adjunctionTree.toString();
  }

}
