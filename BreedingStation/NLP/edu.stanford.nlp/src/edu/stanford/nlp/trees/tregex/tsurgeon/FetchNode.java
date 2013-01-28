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
package edu.stanford.nlp.trees.tregex.tsurgeon;

import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.tregex.TregexMatcher;

/**
 * @author Roger Levy (rog@stanford.edu)
 */
class FetchNode extends TsurgeonPattern {

  public FetchNode(String nodeName) {
    super(nodeName, TsurgeonPattern.EMPTY_TSURGEON_PATTERN_ARRAY);
  }

  @Override
  public Tree evaluate(Tree t, TregexMatcher m) {
    Tree result = root.newNodeNames.get(label);
    if (result == null) {
      result = m.getNode(label);
    }
    if (result == null) {
      System.err.println("Warning -- null node fetched by Tsurgeon operation for node: " + this +
              " (either no node labeled this, or the labeled node didn't match anything)");
    }
    return result;
  }
}
