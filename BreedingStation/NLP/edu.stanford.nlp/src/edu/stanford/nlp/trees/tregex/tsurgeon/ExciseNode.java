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
import edu.stanford.nlp.trees.Trees;
import edu.stanford.nlp.trees.tregex.TregexMatcher;

/** Excises all nodes from the top to the bottom, and puts all the children of bottom node in where the top was.
 * @author Roger Levy (rog@stanford.edu)
 */
class ExciseNode extends TsurgeonPattern {

  /**
   * Top should evaluate to a node that dominates bottom, but this is not checked!
   */
  public ExciseNode(TsurgeonPattern top, TsurgeonPattern bottom) {
    super("excise", new TsurgeonPattern[] { top, bottom });
  }

  /**
   * Excises only the directed node.
   */
  public ExciseNode(TsurgeonPattern node) {
    super("excise", new TsurgeonPattern[] { node,node });
  }

  @Override
  public Tree evaluate(Tree t, TregexMatcher m) {
    Tree topNode = children[0].evaluate(t,m);
    Tree bottomNode = children[1].evaluate(t,m);
    if(Tsurgeon.verbose) {
      System.err.println("Excising...original tree:");
      t.pennPrint(System.err);
      System.err.println("top: " + topNode + "\nbottom:" + bottomNode);
    }
    if(topNode==t)
      return null;
    Tree parent = topNode.parent(t);
    if(Tsurgeon.verbose)
      System.err.println("Parent: " + parent);
    int i = Trees.objectEqualityIndexOf(parent,topNode);
    parent.removeChild(i);
    for(Tree child : bottomNode.children()) {
      parent.addChild(i,child);
      i++;
    }
    if(Tsurgeon.verbose)
      t.pennPrint(System.err);
    return t;
  }
}
