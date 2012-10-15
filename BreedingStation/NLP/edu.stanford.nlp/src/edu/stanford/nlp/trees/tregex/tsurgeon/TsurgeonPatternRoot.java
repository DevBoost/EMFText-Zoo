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

import java.util.Map;
import java.util.HashMap;

/**
 * @author Roger Levy (rog@nlp.stanford.edu)
 */
class TsurgeonPatternRoot extends TsurgeonPattern {

  final CoindexationGenerator coindexer = new CoindexationGenerator();
  Map<String, Tree> newNodeNames;


  public TsurgeonPatternRoot(TsurgeonPattern[] children) {
    super("operations: ", children);
    setRoot(this);
  }


  /**
   * returns null if one of the surgeries eliminates the tree entirely.  The
   * operated-on tree is not to be trusted in this instance.
   */
  @Override
  public Tree evaluate(Tree t, TregexMatcher m) {
    newNodeNames = new HashMap<String,Tree>();
    coindexer.setLastIndex(t);
    for (TsurgeonPattern child : children) {
      t = child.evaluate(t, m);
      if (t == null) {
        return null;
      }
    }
    return t;
  }
}
