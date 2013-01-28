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
 * Binary rules (ints for parent, left and right children)
 *
 * @author Dan Klein
 * @author Christopher Manning
 */
public class BinaryRule implements Rule, Comparable<BinaryRule>, Serializable {

  public int parent;
  /**
   * Score should be a log probability
   */
  public float score;
  public int leftChild;
  public int rightChild;

  /** Create a new BinaryRule with the parent and children coded as ints.
   *  Score defaults to Float.NaN.
   *  @param parent The parent int
   *  @param leftChild The left child int
   *  @param rightChild The right child int
   */
  public BinaryRule(int parent, int leftChild, int rightChild) {
    this.parent = parent;
    this.leftChild = leftChild;
    this.rightChild = rightChild;
    this.score = Float.NaN;
  }

  public BinaryRule(int parent, int leftChild, int rightChild, double score) {
    this.parent = parent;
    this.leftChild = leftChild;
    this.rightChild = rightChild;
    this.score = (float) score;
  }

  /**
   * Creates a BinaryRule from String s, assuming it was created using toString().
   *
   * @param s A String in which the binary rule is represented as parent,
   *     left-child, right-child, score, with the items quoted as needed
   * @param index Index used to convert String names to ints
   */
  public BinaryRule(String s, Index<String> index) {
    String[] fields = StringUtils.splitOnCharWithQuoting(s, ' ', '\"', '\\');
    //    System.out.println("fields:\n" + fields[0] + "\n" + fields[2] + "\n" + fields[3] + "\n" + fields[4]);
    this.parent = index.indexOf(fields[0], true);
    this.leftChild = index.indexOf(fields[2], true);
    this.rightChild = index.indexOf(fields[3], true);
    this.score = Float.parseFloat(fields[4]);
  }

  public float score() {
    return score;
  }

  public int parent() {
    return parent;
  }

  private int hashCode = -1;

  @Override
  public int hashCode() {
    if (hashCode < 0) {
      hashCode = (parent << 16) ^ (leftChild << 8) ^ rightChild;
    }
    return hashCode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o instanceof BinaryRule) {
      BinaryRule br = (BinaryRule) o;
      if (parent == br.parent && leftChild == br.leftChild && rightChild == br.rightChild) {
        return true;
      }
    }
    return false;
  }

  private static final char[] charsToEscape = { '\"' };


  public String toString() {
    return parent + " -> " + leftChild + ' ' + rightChild + ' ' + score;
  }

  public String toString(Index<String> index) {
    return '\"' + StringUtils.escapeString(index.get(parent), charsToEscape, '\\') + "\" -> \"" + StringUtils.escapeString(index.get(leftChild), charsToEscape, '\\') + "\" \"" + StringUtils.escapeString(index.get(rightChild), charsToEscape, '\\') + "\" " + score;
  }

  private transient String cached; // = null;

  public String toStringNoScore(Index<String> index) {
    if (cached == null) {
      cached = '\"' + StringUtils.escapeString(index.get(parent), charsToEscape, '\\') + "\" -> \"" + StringUtils.escapeString(index.get(leftChild), charsToEscape, '\\') + "\" \"" + StringUtils.escapeString(index.get(rightChild), charsToEscape, '\\');
    }
    return cached;
  }

  public int compareTo(BinaryRule br) {
    if (parent < br.parent) {
      return -1;
    }
    if (parent > br.parent) {
      return 1;
    }
    if (leftChild < br.leftChild) {
      return -1;
    }
    if (leftChild > br.leftChild) {
      return 1;
    }
    if (rightChild < br.rightChild) {
      return -1;
    }
    if (rightChild > br.rightChild) {
      return 1;
    }
    return 0;
  }

  private static final long serialVersionUID = 1L;

}
