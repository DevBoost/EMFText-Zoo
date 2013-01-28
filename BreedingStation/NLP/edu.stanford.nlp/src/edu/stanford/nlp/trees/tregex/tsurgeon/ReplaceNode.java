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

/**
 * @author Roger Levy (rog@stanford.edu)
 */
class ReplaceNode extends TsurgeonPattern {

  public ReplaceNode(TsurgeonPattern oldNode, TsurgeonPattern newNode) {
    super("replace", new TsurgeonPattern[] { oldNode, newNode });
  }

  public ReplaceNode(TsurgeonPattern oldNode, AuxiliaryTree t) {
    this(oldNode, new HoldTreeNode(t));
  }

  @Override
  public Tree evaluate(Tree t, TregexMatcher m) {
    Tree oldNode = children[0].evaluate(t,m);
    Tree newNode = children[1].evaluate(t,m);
    if(oldNode==t)
      return newNode;
    Tree parent = oldNode.parent(t);
    int i = parent.indexOf(oldNode);
    parent.removeChild(i);
    parent.insertDtr(newNode.deepCopy(),i);
    return t;
  }
}
