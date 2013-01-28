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


/**
 * Tree normalizer for cleaning up labels and preserving the whole node label,
 * the grammatical function and category information from the label, or only
 * the category information.  Only normalization occurs on nonterminals.
 * @author Anna Rafferty
 *
 */
public class GrammaticalFunctionTreeNormalizer extends TreeNormalizer {
  private static final long serialVersionUID = -2270472762938163327L;
  
  /** How to clean up node labels: 0 = do nothing, 1 = keep category and
   *  function, 2 = just category.
   */
  private final int nodeCleanup;
  private final String root;
  protected final TreebankLanguagePack tlp;
  
  public GrammaticalFunctionTreeNormalizer(TreebankLanguagePack tlp, int nodeCleanup) {
    this.tlp = tlp;
    this.nodeCleanup = nodeCleanup;
    root = tlp.startSymbol();
  }


  /**
   * Normalizes a nonterminal contents.
   * This implementation strips functional tags, etc. and interns the
   * nonterminal.
   */
  @Override
  public String normalizeNonterminal(String category) {
    return cleanUpLabel(category).intern();
  }

  /**
   * Remove things like hyphened functional tags and equals from the
   * end of a node label.
   */
  protected String cleanUpLabel(String label) {
    if (label == null) {
      return root;
    } else if (nodeCleanup == 1) {
      return tlp.categoryAndFunction(label);
    } else if (nodeCleanup == 2) {
      return tlp.basicCategory(label);
    } else {
      return label;
    }
  }
}
