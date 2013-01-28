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

import java.io.Serializable;

/**
 * An interface for finding the "head" daughter of a phrase structure tree.
 * This could potentially be any sense of "head", but has mainly been used
 * to find the lexical head for lexicalized PCFG parsing.
 *
 * @author Christopher Manning
 */
public interface HeadFinder extends Serializable {

  /**
   * Determine which daughter of the current parse tree is the head.
   * It assumes that the daughters already have had their heads
   * determined. Another method has to do the tree walking.
   *
   * @param t The parse tree to examine the daughters of
   * @return The parse tree that is the head.  The convention has been
   *         that this returns <code>null</code> if no head is found.
   *         But maybe it should throw an exception?
   */
  public Tree determineHead(Tree t);


  /**
   * Determine which daughter of the current parse tree is the head given the parent of
   * the tree.
   * It assumes that the daughters already have had their heads
   * determined. Another method has to do the tree walking.
   *
   * @param t The parse tree to examine the daughters of
   * @param parent The parent of tree t
   * @return The parse tree that is the head.  The convention has been
   *         that this returns <code>null</code> if no head is found.
   *         But maybe it should throw an exception?
   */
  public Tree determineHead(Tree t, Tree parent);




}
