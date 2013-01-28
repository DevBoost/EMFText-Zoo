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

import java.util.List;

import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeTransformer;

/**
 * Removes a boundary symbol (Lexicon.BOUNDARY_TAG or Lexicon.BOUNDARY), which
 * is the rightmost daughter of a tree.  Otherwise does nothing.
 * This is needed because the dependency parser uses such symbols.
 * <i>Note:</i> the transformTree method is destructive.
 *
 * @author Christopher Manning
 */
public class BoundaryRemover implements TreeTransformer {

  public BoundaryRemover() {
  }

  public Tree transformTree(Tree tree) {
    Tree last = tree.lastChild();
    if (last.label().value().equals(Lexicon.BOUNDARY_TAG) ||
        last.label().value().equals(Lexicon.BOUNDARY)) {
      List<Tree> childList = tree.getChildrenAsList();
      List<Tree> lastGoneList = childList.subList(0, childList.size() - 1);
      return tree.treeFactory().newTreeNode(tree.label(), lastGoneList);
    } else {
      return tree;
    }
  }

} // end class BoundaryRemover
