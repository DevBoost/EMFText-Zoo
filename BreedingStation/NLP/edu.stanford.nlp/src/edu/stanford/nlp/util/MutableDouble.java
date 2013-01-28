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
 * A class for Double objects that you can change.
 *
 * @author Dan Klein
 */
public final class MutableDouble extends Number implements Comparable<MutableDouble> {

  private double d;

  // Mutable
  public void set(double d) {
    this.d = d;
  }

  @Override
  public int hashCode() {
    long bits = Double.doubleToLongBits(d);
    return (int) (bits ^ (bits >>> 32));
  }

  /**
   * Compares this object to the specified object.  The result is
   * <code>true</code> if and only if the argument is not
   * <code>null</code> and is an <code>MutableDouble</code> object that
   * contains the same <code>double</code> value as this object.
   * Note that a MutableDouble isn't and can't be equal to an Double.
   *
   * @param obj the object to compare with.
   * @return <code>true</code> if the objects are the same;
   *         <code>false</code> otherwise.
   */
  @Override
  public boolean equals(Object obj) {
    return obj instanceof MutableDouble && d == ((MutableDouble) obj).d;
  }

  @Override
  public String toString() {
    return Double.toString(d);
  }

  // Comparable interface

  /**
   * Compares two <code>MutableDouble</code> objects numerically.
   *
   * @param anotherMutableDouble the <code>MutableDouble</code> to be
   *                             compared.
   * @return Tthe value <code>0</code> if this <code>MutableDouble</code> is
   *         equal to the argument <code>MutableDouble</code>; a value less than
   *         <code>0</code> if this <code>MutableDouble</code> is numerically less
   *         than the argument <code>MutableDouble</code>; and a value greater
   *         than <code>0</code> if this <code>MutableDouble</code> is numerically
   *         greater than the argument <code>MutableDouble</code> (signed
   *         comparison).
   */
  public int compareTo(MutableDouble anotherMutableDouble) {
    double thisVal = this.d;
    double anotherVal = anotherMutableDouble.d;
    return (thisVal < anotherVal ? -1 : (thisVal == anotherVal ? 0 : 1));
  }

  // Number interface
  @Override
  public int intValue() {
    return (int) d;
  }

  @Override
  public long longValue() {
    return (long) d;
  }

  @Override
  public short shortValue() {
    return (short) d;
  }

  @Override
  public byte byteValue() {
    return (byte) d;
  }

  @Override
  public float floatValue() {
    return (float) d;
  }

  @Override
  public double doubleValue() {
    return d;
  }

  public MutableDouble() {
    this(0.0);
  }

  public MutableDouble(double d) {
    this.d = d;
  }

  public MutableDouble(Number num) {
    this.d = num.doubleValue();
  }

  private static final long serialVersionUID = 624465615824626762L;

}
