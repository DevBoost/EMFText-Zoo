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
package edu.stanford.nlp.trees;

import edu.stanford.nlp.ling.Label;
import edu.stanford.nlp.util.Function;

/**
 * Applies a Function to the labels in a tree.  
 *
 * @author John Bauer
 */
public class TreeLeafLabelTransformer implements TreeTransformer {
  Function<String, String> transform;

  public TreeLeafLabelTransformer(Function<String, String> transform) {
    this.transform = transform;
  }

  public Tree transformTree(Tree tree) {
    for (Tree leaf : tree.getLeaves()) {
      Label label = leaf.label();
      label.setValue(transform.apply(label.value()));
    }
    return tree;
  }
}
