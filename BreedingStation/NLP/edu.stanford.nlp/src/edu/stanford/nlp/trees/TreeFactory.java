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
 * A <code>TreeFactory</code> acts as a factory for creating objects of
 * class <code>Tree</code>, or some descendant class.
 * Methods implementing this interface may assume that the <code>List</code>
 * of children passed to them is a list that actually contains trees, but
 * this can't be enforced in Java without polymorphic types.
 * The methods with a String argument do not guarantee
 * that the tree label() will be a String -- the TreeFactory may
 * convert it into some other type.
 *
 * @author Christopher Manning
 * @version 2000/12/20
 */
public interface TreeFactory {

  /**
   * Create a new tree leaf node, where the label is formed from
   * the <code>String</code> passed in.
   *
   * @param word The word that will go into the tree label.
   * @return The new leaf
   */
  public Tree newLeaf(String word);


  /**
   * Create a new tree non-leaf node, where the label is formed from
   * the <code>String</code> passed in.
   *
   * @param parent   The string that will go into the parent tree label.
   * @param children The list of daughters of this tree.  The children
   *                 may be a (possibly empty) <code>List</code> of children or
   *                 <code>null</code>
   * @return The new interior tree node
   */
  public Tree newTreeNode(String parent, List<Tree> children);


  /**
   * Create a new tree leaf node, with the given label.
   *
   * @param label The label for the leaf node
   * @return The new leaf
   */
  public Tree newLeaf(Label label);


  /**
   * Create a new tree non-leaf node, with the given label.
   *
   * @param label    The label for the parent tree node.
   * @param children The list of daughters of this tree.  The children
   *                 may be a (possibly empty) <code>List</code> of children or
   *                 <code>null</code>
   * @return The new interior tree node
   */
  public Tree newTreeNode(Label label, List<Tree> children);

}
