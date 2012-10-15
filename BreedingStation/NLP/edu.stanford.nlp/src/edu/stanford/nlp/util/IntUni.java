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
 * Just a single integer
 *
 * @author Kristina Toutanova (kristina@cs.stanford.edu)
 */

public class IntUni extends IntTuple {

  public IntUni() {
    super(1);
  }


  public IntUni(int src) {
    super(1);
    elements[0] = src;
  }


  public int getSource() {
    return elements[0];
  }

  public void setSource(int src) {
    elements[0] = src;
  }


  @Override
  public IntTuple getCopy() {
    IntUni nT = new IntUni(elements[0]);
    return nT;
  }

  public void add(int val) {
    elements[0] += val;
  }

  private static final long serialVersionUID = -7182556672628741200L;

}
