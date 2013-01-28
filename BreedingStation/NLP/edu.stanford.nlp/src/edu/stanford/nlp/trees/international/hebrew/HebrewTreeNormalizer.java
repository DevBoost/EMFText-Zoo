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
package edu.stanford.nlp.trees.international.hebrew;

import java.util.Collections;

import edu.stanford.nlp.trees.BobChrisTreeNormalizer;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeFactory;
import edu.stanford.nlp.util.Filter;

/**
 * 
 * @author Spence Green
 *
 */
public class HebrewTreeNormalizer extends BobChrisTreeNormalizer {

  private static final long serialVersionUID = -3129547164200725933L;

  private final Filter<Tree> hebrewEmptyFilter;

  public HebrewTreeNormalizer() {
    super(new HebrewTreebankLanguagePack());
    hebrewEmptyFilter = new HebrewEmptyFilter();
  }

  /**
   * Remove traces and pronoun deletion markers.
   */
  public static class HebrewEmptyFilter implements Filter<Tree> {

    private static final long serialVersionUID = -7256461296718287280L;

    public boolean accept(Tree t) {
      return ! (t.isPreTerminal() && t.value().equals("-NONE-"));
    }
  }

  @Override
  public Tree normalizeWholeTree(Tree tree, TreeFactory tf) {
    tree = tree.prune(hebrewEmptyFilter, tf).spliceOut(aOverAFilter, tf);

    //Add start symbol so that the root has only one sub-state. Escape any enclosing brackets.
    //If the "tree" consists entirely of enclosing brackets e.g. ((())) then this method
    //will return null. In this case, readers e.g. PennTreeReader will try to read the next tree.
    while(tree != null && (tree.value() == null || tree.value().equals("")) && tree.numChildren() <= 1)
      tree = tree.firstChild();

    if(tree != null && !tree.value().equals(tlp.startSymbol()))
      tree = tf.newTreeNode(tlp.startSymbol(), Collections.singletonList(tree));

    return tree;
  }

}
