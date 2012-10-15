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


import java.io.Serializable;

/**
 * An interface for classes that act as a function transforming one object
 * to another.
 * <p>
 * <i>Implementation note:</i> A function by itself is not serializable.
 * We do however also provide an interface
 * {@link edu.stanford.nlp.process.SerializableFunction} for
 * the common case of a function that should be Serializable.
 *
 * @author Dan Klein
 * @param <T1> The domain of the function
 * @param <T2> The range of the function
 */
public interface Function <T1,T2> {

  /**
   * Converts a T1 to a different T2.  For example, a Parser
   * will convert a Sentence to a Tree.  A Tagger will convert a Sentence
   * to a TaggedSentence.
   *
   * @param in The function's argument
   * @return The function's evaluated value
   */
  public T2 apply(T1 in);

}
