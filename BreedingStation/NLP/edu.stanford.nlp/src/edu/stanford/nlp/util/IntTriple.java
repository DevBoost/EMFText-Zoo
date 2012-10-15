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

public class IntTriple extends IntTuple {

  private static final long serialVersionUID = -3744404627253652799L;

  public IntTriple() {
    super(3);
  }

  public IntTriple(int src, int mid, int trgt) {
    super(3);
    elements[0] = src;
    elements[1] = mid;
    elements[2] = trgt;
  }


  @Override
  public IntTuple getCopy() {
    IntTriple nT = new IntTriple(elements[0], elements[1], elements[2]);
    return nT;
  }


  public int getSource() {
    return elements[0];
  }

  public int getTarget() {
    return elements[2];
  }

  public int getMiddle() {
    return elements[1];
  }

}

