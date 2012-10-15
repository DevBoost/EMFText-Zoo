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

import java.util.List;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.Trees;
import edu.stanford.nlp.trees.tregex.TregexMatcher;

/**
 * @author Roger Levy (rog@stanford.edu)
 */
class DeleteNode extends TsurgeonPattern {

  public DeleteNode(TsurgeonPattern[] children) {
    super("delete", children);
  }

  public DeleteNode(List<TsurgeonPattern> children) {
    this(children.toArray(new TsurgeonPattern[children.size()]));
  }


  @Override
  public Tree evaluate(Tree t, TregexMatcher m) {
    Tree result = t;
    for (TsurgeonPattern child : children) {
      Tree nodeToDelete = child.evaluate(t, m);
      if (nodeToDelete == t) {
        result = null;
      }
      Tree parent = nodeToDelete.parent(t);
      parent.removeChild(Trees.objectEqualityIndexOf(parent,nodeToDelete));
    }
    return result;
  }

}
