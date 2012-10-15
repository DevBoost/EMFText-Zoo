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
package edu.stanford.nlp.util;

/**
 * A class for Integer objects that you can change.
 *
 * @author Dan Klein
 */
public final class MutableInteger extends Number implements Comparable<MutableInteger> {

  private int i;

  // Mutable
  public void set(int i) {
    this.i = i;
  }

  @Override
  public int hashCode() {
    return i;
  }

  /**
   * Compares this object to the specified object.  The result is
   * <code>true</code> if and only if the argument is not
   * <code>null</code> and is an <code>MutableInteger</code> object that
   * contains the same <code>int</code> value as this object.
   * Note that a MutableInteger isn't and can't be equal to an Integer.
   *
   * @param obj the object to compare with.
   * @return <code>true</code> if the objects are the same;
   *         <code>false</code> otherwise.
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof MutableInteger) {
      return i == ((MutableInteger) obj).i;
    }
    return false;
  }

  @Override
  public String toString() {
    return Integer.toString(i);
  }

  // Comparable interface

  /**
   * Compares two <code>MutableInteger</code> objects numerically.
   *
   * @param anotherMutableInteger the <code>MutableInteger</code> to be
   *                              compared.
   * @return The value <code>0</code> if this <code>MutableInteger</code> is
   *         equal to the argument <code>MutableInteger</code>; a value less than
   *         <code>0</code> if this <code>MutableInteger</code> is numerically less
   *         than the argument <code>MutableInteger</code>; and a value greater
   *         than <code>0</code> if this <code>MutableInteger</code> is numerically
   *         greater than the argument <code>MutableInteger</code> (signed
   *         comparison).
   */
  public int compareTo(MutableInteger anotherMutableInteger) {
    int thisVal = this.i;
    int anotherVal = anotherMutableInteger.i;
    return (thisVal < anotherVal ? -1 : (thisVal == anotherVal ? 0 : 1));
  }


  // Number interface
  @Override
  public int intValue() {
    return i;
  }

  @Override
  public long longValue() {
    return i;
  }

  @Override
  public short shortValue() {
    return (short) i;
  }

  @Override
  public byte byteValue() {
    return (byte) i;
  }

  @Override
  public float floatValue() {
    return i;
  }

  @Override
  public double doubleValue() {
    return i;
  }

  /** Add the argument to the value of this integer.  A convenience method.
   *
   * @param val Value to be added to this integer
   */
  public void incValue(int val) {
    i += val;
  }

  public MutableInteger() {
    this(0);
  }

  public MutableInteger(int i) {
    this.i = i;
  }

  private static final long serialVersionUID = 624465615824626762L;
}
