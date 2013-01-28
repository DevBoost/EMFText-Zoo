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
package edu.stanford.nlp.trees;

import edu.stanford.nlp.trees.international.pennchinese.CharacterLevelTagExtender;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author Galen Andrew
 */
public class TreeToBracketProcessor {
  public List evalTypes = new ArrayList();
  public static CharacterLevelTagExtender ext = new CharacterLevelTagExtender();

  public TreeToBracketProcessor(List evalTypes) {
    this.evalTypes = evalTypes;
  }

  public Collection allBrackets(Tree root) {
    boolean words = evalTypes.contains(WordCatConstituent.wordType);
    boolean tags = evalTypes.contains(WordCatConstituent.tagType);
    boolean cats = evalTypes.contains(WordCatConstituent.catType);
    List brackets = new ArrayList();
    if (words || cats || tags) {
      root = ext.transformTree(root);
      for (Iterator iterator = root.iterator(); iterator.hasNext();) {
        Tree tree = (Tree) iterator.next();
        if (tree.isPrePreTerminal() && !tree.value().equals("ROOT")) {
          if (words) {
            brackets.add(new WordCatConstituent(tree, root, WordCatConstituent.wordType));
          }
          if (tags) {
            brackets.add(new WordCatConstituent(tree, root, WordCatConstituent.tagType));
          }
        } else if (cats && tree.isPhrasal() && !tree.value().equals("ROOT")) {
          brackets.add(new WordCatConstituent(tree, root, WordCatConstituent.catType));
        }
      }
    }

    return brackets;
  }

  public Collection commonWordTagTypeBrackets(Tree root1, Tree root2) {
    root1 = ext.transformTree(root1);
    root2 = ext.transformTree(root2);

    List firstPreTerms = new ArrayList();
    for (Iterator iterator = root1.iterator(); iterator.hasNext();) {
      Tree tree = (Tree) iterator.next();
      if (tree.isPrePreTerminal()) {
        firstPreTerms.add(tree);
      }
    }

    List brackets = new ArrayList();
    for (Iterator pretermIter = firstPreTerms.iterator(); pretermIter.hasNext();) {
      Tree preTerm = (Tree) pretermIter.next();
      for (Iterator iter = root2.iterator(); iter.hasNext();) {
        Tree tree = (Tree) iter.next();
        if (!tree.isPrePreTerminal()) {
          continue;
        }
        if (Trees.leftEdge(tree, root2) == Trees.leftEdge(preTerm, root1) && Trees.rightEdge(tree, root2) == Trees.rightEdge(preTerm, root1)) {
          brackets.add(new WordCatConstituent(preTerm, root1, WordCatConstituent.goodWordTagType));
          break;
        }
      }
    }

    return brackets;
  }
}
