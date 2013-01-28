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
package edu.stanford.nlp.process;


import java.util.Iterator;
import java.util.List;

/**
 * Tokenizers break up text into individual Objects. These objects may be
 * Strings, Words, or other Objects.  A Tokenizer extends the Iterator
 * interface, but provides a lookahead operation <code>peek()</code>.  An
 * implementation of this interface is expected to have a constructor that
 * takes a single argument, a Reader.
 *
 * @author Teg Grenager (grenager@stanford.edu)
 */
public interface Tokenizer<T> extends Iterator<T> {

  /**
   * Returns the next token from this Tokenizer.
   *
   * @return the next token in the token stream.
   * @throws java.util.NoSuchElementException
   *          if the token stream has no more tokens.
   */
  public T next();

  /**
   * Returns <code>true</code> if and only if this Tokenizer has more elements.
   */
  public boolean hasNext();

  /**
   * Removes from the underlying collection the last element returned by
   * the iterator.  This is an optional operation for Iterators - a
   * Tokenizer normally would not support it. This method can be called
   * only once per call to next.
   */
  public void remove();

  /**
   * Returns the next token, without removing it, from the Tokenizer, so
   * that the same token will be again returned on the next call to
   * next() or peek().
   *
   * @return the next token in the token stream.
   * @throws java.util.NoSuchElementException
   *          if the token stream has no more tokens.
   */
  public T peek();

  /**
   * Returns all tokens of this Tokenizer as a List for convenience.
   */
  public List<T> tokenize();

}
