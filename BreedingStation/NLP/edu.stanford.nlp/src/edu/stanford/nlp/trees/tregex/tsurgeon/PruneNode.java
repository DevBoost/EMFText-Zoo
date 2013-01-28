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

/**  Pruning differs from deleting in that if a non-terminal node winds up having no children, it is pruned as well.
 * @author Roger Levy (rog@nlp.stanford.edu)
 */
class PruneNode extends TsurgeonPattern {

  public PruneNode(TsurgeonPattern[] children) {
    super("prune", children );
  }

  public PruneNode(List<TsurgeonPattern> children) {
    this(children.toArray(new TsurgeonPattern[children.size()]));
  }

  @Override
  public Tree evaluate(Tree t, TregexMatcher m) {
    boolean prunedWholeTree = false;
    for(TsurgeonPattern child : children) {
      final Tree nodeToPrune = child.evaluate(t,m);
      if(pruneHelper(t,nodeToPrune) == null)
        prunedWholeTree = true;
    }
    return prunedWholeTree ? null : t;
  }

  private static Tree pruneHelper(Tree root, Tree nodeToPrune) {
    if(nodeToPrune==root)
      return null;
    Tree parent = nodeToPrune.parent(root);
    parent.removeChild(Trees.objectEqualityIndexOf(parent,nodeToPrune));
    if(parent.children().length==0)
      return pruneHelper(root,parent);
    return root;
  }
}
