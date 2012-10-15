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

import java.util.Comparator;

/**
 * A <code>TreeLengthComparator</code> orders trees by their yield sentence
 * lengths.
 *
 * @author Christopher Manning
 * @version 2003/03/24
 */
public class TreeLengthComparator implements Comparator<Tree> {

  /**
   * Create a new <code>TreeLengthComparator</code>.
   */
  public TreeLengthComparator() {
  }


  /**
   * Compare the two objects.
   */
  public int compare(Tree t1, Tree t2) {
    if (t1 == t2) {
      return 0;
    }
    int len1 = t1.yield().size();
    int len2 = t2.yield().size();
    if (len1 > len2) {
      return 1;
    } else if (len1 < len2) {
      return -1;
    } else {
      return 0;
    }
  }

}
