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

import java.util.List;


/**
 * A <code>SimpleTreeFactory</code> acts as a factory for creating objects
 * of class <code>SimpleTree</code>.
 * <p/>
 * <i>NB: A SimpleTree stores tree geometries but no node labels.  Make sure
 * this is what you really want.</i>
 *
 * @author Christopher Manning
 */
public class SimpleTreeFactory implements TreeFactory {

  /**
   * Creates a new <code>TreeFactory</code>.  A
   * <code>SimpleTree</code> stores no <code>Label</code>, so no
   * <code>LabelFactory</code> is built.
   */
  public SimpleTreeFactory() {
  }

  public Tree newLeaf(final String word) {
    return new SimpleTree();
  }

  public Tree newLeaf(final Label word) {
    return new SimpleTree();
  }

  public Tree newTreeNode(final String parent, final List<Tree> children) {
    return new SimpleTree(null, children);
  }

  public Tree newTreeNode(final Label parentLabel, final List<Tree> children) {
    return new SimpleTree(parentLabel, children);
  }

}
