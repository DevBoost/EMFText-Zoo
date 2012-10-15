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
 * Scored: This is a simple interface that says that an object can answer
 * requests for the score, or goodness of the object.
 * <p>
 * JavaNLP includes companion classes {@link ScoredObject} which is a simple
 * composite of another object and a score, and {@link ScoredComparator}
 * which compares Scored objects.
 *
 * @author Dan Klein
 * @version 12/4/2000
 */
public interface Scored {

  /**
   * @return The score of this thing.
   */
  public double score();

}
