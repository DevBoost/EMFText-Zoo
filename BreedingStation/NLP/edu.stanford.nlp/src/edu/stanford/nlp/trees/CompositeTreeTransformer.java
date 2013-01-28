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

import java.util.List;
import java.util.ArrayList;

/**
 * A TreeTransformer that applies component TreeTransformers in order.
 * The order in which they are applied is the order in which they are added or
 * the order in which they appear in the List passed to the constructor.
 *
 * @author Galen Andrew
 */
public class CompositeTreeTransformer implements TreeTransformer {

  private final List<TreeTransformer> transformers = new ArrayList<TreeTransformer>();

  public CompositeTreeTransformer() {
  }

  public CompositeTreeTransformer(List<TreeTransformer> tt) {
    transformers.addAll(tt);
  }

  public void addTransformer(TreeTransformer tt) {
    transformers.add(tt);
  }

  public Tree transformTree(Tree t) {
    for (TreeTransformer tt : transformers) {
      t = tt.transformTree(t);
    }
    return t;
  }


  @Override
  public String toString() {
    return "CompositeTreeTransformer: " + transformers;
  }
}
