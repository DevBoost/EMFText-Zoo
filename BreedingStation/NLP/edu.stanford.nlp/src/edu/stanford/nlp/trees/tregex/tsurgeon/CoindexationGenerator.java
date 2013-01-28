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

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * @author Roger Levy (rog@nlp.stanford.edu)
 */
class CoindexationGenerator {

  private static final Pattern coindexationPattern = Pattern.compile("-([0-9]+)$");

  private int lastIndex;

  public void setLastIndex(Tree t) {
    lastIndex = 0;
    for (Tree node : t) {
      String value = node.label().value();
      if (value != null) {
        Matcher m = coindexationPattern.matcher(value);
        if (m.find()) {
          int thisIndex = Integer.parseInt(m.group(1));
          lastIndex = Math.max(thisIndex, lastIndex);
        }
      }
    }
  }

  public int generateIndex() {
    lastIndex = lastIndex+1;
    return lastIndex;
  }

}
