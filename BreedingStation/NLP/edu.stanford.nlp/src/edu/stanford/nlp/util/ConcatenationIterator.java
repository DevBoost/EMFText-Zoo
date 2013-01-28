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

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/**
 * Iterator that represents the concatenation of two other iterators.
 * <p/>
 * User: Dan Klein (klein@cs.stanford.edu)
 * Date: Oct 22, 2003
 * Time: 7:27:39 PM
 */
public class ConcatenationIterator<T> implements Iterator<T> {
  Iterator<T> first = null;
  Iterator<T> second = null;

  Iterator<T> current() {
    if (first.hasNext()) {
      return first;
    }
    return second;
  }

  public boolean hasNext() {
    return current().hasNext();
  }

  public T next() {
    return current().next();
  }

  public void remove() {
    current().remove();
  }

  public ConcatenationIterator(Iterator<T> first, Iterator<T> second) {
    this.first = first;
    this.second = second;
  }

  public static void main(String[] args) {
    Collection<String> c1 = Collections.singleton("a");
    Collection<String> c2 = Collections.singleton("b");
    Iterator<String> i = new ConcatenationIterator<String>(c1.iterator(), c2.iterator());
    while (i.hasNext()) {
      System.out.println(i.next() + " ");
    }
  }
}

