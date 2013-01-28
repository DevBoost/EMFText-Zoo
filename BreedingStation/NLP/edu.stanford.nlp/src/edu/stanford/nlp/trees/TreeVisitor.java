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
 * This is a simple strategy-type interface for operations that are applied to
 * <code>Tree</code>. It typically is called iteratively over
 * trees in a <code>Treebank</code>.  The convention is for <code>TreeVisitor</code> implementing
 * classes not to affect <code>Tree</code> instances they operate on, but to accomplish things via
 * side effects (like counting statistics over trees, etc.).
 *
 * @author Christopher Manning
 * @author Roger Levy
 */
public interface TreeVisitor {

  /**
   * Does whatever one needs to do to a particular parse tree.
   *
   * @param t A tree.  Classes implementing this interface can assume
   *          that the tree passed in is not <code>null</code>.
   */
  public void visitTree(Tree t);

}

