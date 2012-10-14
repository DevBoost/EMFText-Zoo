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
package edu.stanford.nlp.trees.tregex.tsurgeon;

import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.Trees;
import edu.stanford.nlp.trees.tregex.TregexMatcher;
import edu.stanford.nlp.util.Pair;

/** Does a delete (NOT prune!) + insert operation
 * @author Roger Levy (rog@stanford.edu)
 */
class MoveNode extends TsurgeonPattern {
  TreeLocation l;

  public MoveNode(TsurgeonPattern child, TreeLocation l) {
    super("move", new TsurgeonPattern[] { child });
    this.l = l;
  }

  @Override
  protected void setRoot(TsurgeonPatternRoot root) {
    super.setRoot(root);
    l.setRoot(root);
  }

  @Override
  public Tree evaluate(Tree t, TregexMatcher m) {
    Tree nodeToMove = children[0].evaluate(t,m);
    Tree oldParent = nodeToMove.parent(t);
    oldParent.removeChild(Trees.objectEqualityIndexOf(oldParent,nodeToMove));
    Pair<Tree,Integer> position = l.evaluate(t,m);
    position.first().insertDtr(nodeToMove,position.second());
    return t;
  }

  @Override
  public String toString() {
    return label + "(" + children[0] + " " + l + ")"; 
  }


}
