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
package edu.stanford.nlp.parser;

import edu.stanford.nlp.trees.Tree;

/**
 * The interface for Viterbi parsers.  Viterbi parsers support
 * getBestParse, which returns a best parse of the input, or
 * <code>null</code> if no parse exists.
 *
 * @author Dan Klein
 */

public interface ViterbiParser extends Parser {

  /**
   * Returns a best parse of the last sentence on which <code>parse</code> was
   * called, or null if none exists.
   *
   * @return The tree for the best parse
   */
  public Tree getBestParse();

}
