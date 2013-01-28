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

public class IntQuadruple extends IntTuple {

  private static final long serialVersionUID = 7154973101012473479L;


  public IntQuadruple() {
    super(4);
  }

  public IntQuadruple(int src, int mid, int trgt, int trgt2) {
    super(4);
    elements[0] = src;
    elements[1] = mid;
    elements[2] = trgt;
    elements[3] = trgt2;
  }


  @Override
  public IntTuple getCopy() {
    IntQuadruple nT = new IntQuadruple(elements[0], elements[1], elements[2], elements[3]);
    return nT;
  }


  public int getSource() {
    return get(0);
  }


  public int getMiddle() {
    return get(1);
  }

  public int getTarget() {
    return get(2);
  }

  public int getTarget2() {
    return get(3);
  }
}
