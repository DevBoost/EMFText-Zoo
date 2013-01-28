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

import edu.stanford.nlp.ling.Label;
import edu.stanford.nlp.ling.LabelFactory;
import edu.stanford.nlp.ling.CyclicCoreLabel;

import java.util.List;


/**
 * A <code>TreeGraphNodeFactory</code> acts as a factory for creating
 * nodes in a {@link TreeGraph <code>TreeGraph</code>}.  Unless
 * another {@link LabelFactory <code>LabelFactory</code>} is
 * supplied, it will use a CyclicCoreLabelFactory
 * by default.
 *
 * @author Bill MacCartney
 */
public class TreeGraphNodeFactory implements TreeFactory {

  private LabelFactory mlf;

  /**
   * Make a <code>TreeFactory</code> that produces
   * <code>TreeGraphNode</code>s.  The labels are of class
   * <code>CyclicCoreLabel</code>.
   */
  public TreeGraphNodeFactory() {
    this(CyclicCoreLabel.factory());
  }

  public TreeGraphNodeFactory(LabelFactory mlf) {
    this.mlf = mlf;
  }

  // docs inherited
  public Tree newLeaf(final String word) {
    return newLeaf(mlf.newLabel(word));
  }

  // docs inherited
  public Tree newLeaf(Label label) {
    return new TreeGraphNode(label);
  }

  // docs inherited
  public Tree newTreeNode(final String parent, final List<Tree> children) {
    return newTreeNode(mlf.newLabel(parent), children);
  }

  // docs inherited
  public Tree newTreeNode(Label parentLabel, List<Tree> children) {
    return new TreeGraphNode(parentLabel, children);
  }

}

