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
 * This is a simple interface for a function that alters a
 * local <code>Tree</code>.
 *
 * @author Christopher Manning.
 */
public interface TreeTransformer {

  /**
   * Does whatever one needs to do to a particular tree.
   * This routine is passed a whole <code>Tree</code>, and could itself
   * work recursively, but the canonical usage is to invoke this method
   * via the <code>Tree.transform()</code> method, which will apply the
   * transformer in a bottom-up manner to each local <code>Tree</code>,
   * and hence the implementation of <code>TreeTransformer</code> should
   * merely examine and change a local (one-level) <code>Tree</code>.
   *
   * @param t  A tree.  Classes implementing this interface can assume
   *           that the tree passed in is not <code>null</code>.
   * @return the transformed <code>Tree</code>
   */
  public Tree transformTree(Tree t); 

}
