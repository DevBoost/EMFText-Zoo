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
 * Wrapper class for holding a scored object
 *
 * @author Dan Klein
 * @version 2/7/01
 */
public class ScoredObject<T> implements Scored {

  private double score;

  public double score() {
    return score;
  }

  public void setScore(double score) {
    this.score = score;
  }


  private T object;

  public T object() {
    return object;
  }

  public void setObject(T object) {
    this.object = object;
  }

  public ScoredObject() {
  }

  public ScoredObject(T object, double score) {
    this.object = object;
    this.score = score;
  }

  @Override
  public String toString() {
    return object + " @ " + score;
  }

}
