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

/** Adjoin in a tree (like in TAG), but retain the target of adjunction as the foot of the auxiliary tree.
 * @author Roger Levy (rog@nlp.stanford.edu)
 */
class AdjoinToFootNode extends AdjoinNode {

  public AdjoinToFootNode(AuxiliaryTree t, TsurgeonPattern p) {
    super(t, p);
  }

  @Override
  public Tree evaluate(Tree t, TregexMatcher m) {
    // find match and get its parent
    Tree targetNode = children[0].evaluate(t,m);
    Tree parent = targetNode.parent(t);
    // substitute original node for foot of auxiliary tree.  Foot node is ignored
    AuxiliaryTree ft = adjunctionTree().copy(this);
    // System.err.println("ft=" + ft + "; ft.foot=" + ft.foot + "; ft.tree=" + ft.tree);
    Tree parentOfFoot = ft.foot.parent(ft.tree);
    if (parentOfFoot == null) {
      System.err.println("Warning: adjoin to foot for depth-1 auxiliary tree has no effect.");
      return t;
    }
    int i = parentOfFoot.indexOf(ft.foot);
    if (parent==null) {
      parentOfFoot.setChild(i,targetNode);
      return ft.tree;
    } else {
      int j = parent.indexOf(targetNode);
      parent.setChild(j,ft.tree);
      parentOfFoot.setChild(i,targetNode);
      return t;
    }
  }

}
