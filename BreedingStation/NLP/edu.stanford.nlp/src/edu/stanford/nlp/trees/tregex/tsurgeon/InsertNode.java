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
import edu.stanford.nlp.trees.tregex.TregexMatcher;
import edu.stanford.nlp.util.Pair;

/**
 * @author Roger Levy (rog@stanford.edu)
 */
class InsertNode extends TsurgeonPattern {

  TreeLocation l;

  public InsertNode(TsurgeonPattern child, TreeLocation l) {
    super("insert", new TsurgeonPattern[] { child });
    this.l = l;
  }

  @Override
  protected void setRoot(TsurgeonPatternRoot root) {
    super.setRoot(root);
    l.setRoot(root);
  }

  public InsertNode(AuxiliaryTree t, TreeLocation l) {
    this(new HoldTreeNode(t),l);
  }

  @Override
  public Tree evaluate(Tree t, TregexMatcher m) {
    Tree nodeToInsert = children[0].evaluate(t,m);
    Pair<Tree,Integer> position = l.evaluate(t,m);
    position.first().insertDtr(nodeToInsert.deepCopy(),position.second());
    return t;
  }

  @Override
  public String toString() {
    return label + '(' + children[0] + ',' + l + ')';
  }


}
