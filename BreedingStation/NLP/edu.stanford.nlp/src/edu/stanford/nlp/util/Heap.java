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

import java.util.Iterator;

/**
 * Heap interface.
 * These heaps implement a decreaseKey operation, which requires
 * a separate Object to Index map, and for objects to be unique in the Heap.
 * <p/>
 * An interface cannot specify constructors, but it is nevertheless
 * expected that an implementation of this interface has a constructor
 * that takes a Comparator, which is used for ordering ("scoring")
 * objects:
 * <code>public Heap(Comparator cmp) {}</code>
 *
 * @author Dan Klein
 * @version 12/14/00
 */
public interface Heap<E> {

  /**
   * Returns the minimum object, then removes that object from the heap.
   *
   * @return the minimum object
   */
  public E extractMin();

  /**
   * Returns the minimum Object in this heap. The heap is not modified.
   *
   * @return the minimum object
   */
  public E min();

  /**
   * Adds the object to the heap.  If the object is in the heap, this
   * should act as a decrease-key (if the new version has better
   * priority) or a no-op (otherwise).
   *
   * @param o a new element
   * @return true, always
   */
  public boolean add(E o);

  /**
   * The number of elements currently in the heap.
   *
   * @return the heap's size
   */
  public int size();

  /**
   * Returns true iff the heap is empty.
   *
   * @return a <code>boolean</code> value
   */
  public boolean isEmpty();

  /**
   * Raises the priority of an object in the heap.  This works in a
   * somewhat unusual way -- the object <code>o</code> should have
   * changed with respect to the comparator passed in to the heap on
   * construction.  However, it should NOT have changed with respect
   * to its equals() method.  This is unlike the Java SortedSet where
   * the comparator should be consistent with equals(); here they
   * should not match.
   *
   * @param o an <code>Object</code> value which has changed wrt the heap's ordering
   * @return the cost of the decrease-key operation, for analysis
   */
  public int decreaseKey(E o); // should be void; int for analysis

  /**
   * Returns an iterator over its elements, in order.
   *
   * @return an <code>Iterator</code> value
   */
  public Iterator<E> iterator();

}
