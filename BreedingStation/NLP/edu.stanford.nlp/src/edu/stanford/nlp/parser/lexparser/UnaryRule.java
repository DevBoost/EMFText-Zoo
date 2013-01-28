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
package edu.stanford.nlp.parser.lexparser;

import java.io.Serializable;

import edu.stanford.nlp.util.Index;
import edu.stanford.nlp.util.StringUtils;

/**
 * Unary grammar rules (with ints for parent and child).
 *
 * @author Dan Klein
 * @author Christopher Manning
 */
public class UnaryRule implements Rule, Comparable<UnaryRule>, Serializable {

  public int parent;
  /**
   * Score should be a log probability
   */
  public float score;
  public int child;

  /** The score is set to Float.NaN by default.
   *
   *  @param parent Parent state
   *  @param child Child state
   */
  public UnaryRule(int parent, int child) {
    this.parent = parent;
    this.child = child;
    this.score = Float.NaN;
  }

  public UnaryRule(int parent, int child, double score) {
    this.parent = parent;
    this.child = child;
    this.score = (float) score;
  }

  /** Decode a UnaryRule out of a String representation with help from
   *  an Index.
   *
   *  @param s The String representation
   *  @param index The Index used to convert String to int
   */
  public UnaryRule(String s, Index<String> index) {
    String[] fields = StringUtils.splitOnCharWithQuoting(s, ' ', '\"', '\\');
    //    System.out.println("fields:\n" + fields[0] + "\n" + fields[2] + "\n" + fields[3]);
    this.parent = index.indexOf(fields[0]);
    this.child = index.indexOf(fields[2]);
    this.score = Float.parseFloat(fields[3]);
  }

  public float score() {
    return score;
  }

  public int parent() {
    return parent;
  }

  @Override
  public int hashCode() {
    return (parent << 16) ^ child;
  }

  /** A UnaryRule is equal to another UnaryRule with the same parent and child.
   *  The score is not included in the equality computation.
   *
   * @param o Object to be compared with
   * @return Whether the object is equal to this
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o instanceof UnaryRule) {
      UnaryRule ur = (UnaryRule) o;
      if (parent == ur.parent && child == ur.child) {
        return true;
      }
    }
    return false;
  }

  public int compareTo(UnaryRule ur) {
    if (parent < ur.parent) {
      return -1;
    }
    if (parent > ur.parent) {
      return 1;
    }
    if (child < ur.child) {
      return -1;
    }
    if (child > ur.child) {
      return 1;
    }
    return 0;
  }

  private static final char[] charsToEscape = { '\"' };

  @Override
  public String toString() {
    return parent + " -> " + child + ' ' + score;
  }

  public String toString(Index<String> index) {
    return '\"' + StringUtils.escapeString(index.get(parent), charsToEscape, '\\') + "\" -> \"" + StringUtils.escapeString(index.get(child), charsToEscape, '\\') + "\" " + score;
  }

  private transient String cached; // = null;

  public String toStringNoScore(Index<String> index) {
    if (cached == null) {
      cached = '\"' + StringUtils.escapeString(index.get(parent), charsToEscape, '\\') + "\" -> \"" + StringUtils.escapeString(index.get(child), charsToEscape, '\\');
    }
    return cached;
  }

  private static final long serialVersionUID = 1L;

}

