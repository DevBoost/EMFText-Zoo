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

public class IntPair extends IntTuple {

  private static final long serialVersionUID = 1L;


  public IntPair() {
    super(2);
  }

  public IntPair(int src, int trgt) {
    super(2);
    elements[0] = src;
    elements[1] = trgt;
  }


  public int getSource() {
    return get(0);
  }

  public int getTarget() {
    return get(1);
  }


  @Override
  public IntTuple getCopy() {
    return new IntPair(elements[0], elements[1]);
  }

  @Override
  public boolean equals(Object iO) {
    if(!(iO instanceof IntPair)) {
      return false;
    }
    IntPair i = (IntPair) iO;
    return elements[0] == i.get(0) && elements[1] == i.get(1);
  }

  @Override
  public int hashCode() {
    return elements[0] * 17 + elements[1];
  }

}
