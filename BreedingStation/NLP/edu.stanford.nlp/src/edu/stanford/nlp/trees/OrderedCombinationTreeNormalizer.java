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

import java.util.ArrayList;
import java.util.List;

/**
 * This class combines multiple tree normalizers.  Given a list of tree normalizer,
 * it applies each tree normalizer from the first to the last for each of the normalize
 * nonterminal, normalize terminal, and normalize whole tree methods.
 * 
 * 
 * @author Anna Rafferty
 *
 */
public class OrderedCombinationTreeNormalizer extends TreeNormalizer {
  private static final long serialVersionUID = 326L;
  
  private List<TreeNormalizer> tns = new ArrayList<TreeNormalizer>();
  
  public OrderedCombinationTreeNormalizer() {
  }
  
  
  public OrderedCombinationTreeNormalizer(List<TreeNormalizer> tns) {
    this.tns = tns;
  }
  
  /**
   * Adds the given tree normalizer to this combination; the tree normalizers
   * are applied in the order they were added, with the first to be added being
   * the first to be applied.
   */
  public void addTreeNormalizer(TreeNormalizer tn) {
    this.tns.add(tn);
  }
  
  
  @Override
  public String normalizeNonterminal(String category) {
    for(TreeNormalizer tn : tns) {
      category = tn.normalizeNonterminal(category);
    }
    return category;
  }
  
  @Override
  public String normalizeTerminal(String leaf) {
    for(TreeNormalizer tn : tns) {
      leaf = tn.normalizeTerminal(leaf);
    }
    return leaf;
  }
  
  @Override
  public Tree normalizeWholeTree(Tree tree, TreeFactory tf) {
    for(TreeNormalizer tn : tns) {
      tree = tn.normalizeWholeTree(tree, tf);
    }
    return tree;
    
  }
}
