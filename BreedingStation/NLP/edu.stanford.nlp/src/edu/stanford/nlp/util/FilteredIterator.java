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

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * Iterator that suppresses items in another iterator based on a filter function.
 *
 * @author Dan Klein (klein@cs.stanford.edu)
 */
public class FilteredIterator<T> implements Iterator<T> {
  Iterator<T> iterator = null;
  Filter<T> filter = null;
  T current = null;
  boolean hasCurrent = false;

  T currentCandidate() {
    return current;
  }

  void advanceCandidate() {
    if (!iterator.hasNext()) {
      hasCurrent = false;
      current = null;
      return;
    }
    hasCurrent = true;
    current = iterator.next();
  }

  boolean hasCurrentCandidate() {
    return hasCurrent;
  }

  boolean currentCandidateIsAcceptable() {
    return filter.accept(currentCandidate());
  }

  void skipUnacceptableCandidates() {
    while (hasCurrentCandidate() && !currentCandidateIsAcceptable()) {
      advanceCandidate();
    }
  }

  public boolean hasNext() {
    return hasCurrentCandidate();
  }

  public T next() {
    T result = currentCandidate();
    advanceCandidate();
    skipUnacceptableCandidates();
    return result;
  }

  public void remove() {
    throw new UnsupportedOperationException();
  }

  public FilteredIterator(Iterator<T> iterator, Filter<T> filter) {
    this.iterator = iterator;
    this.filter = filter;
    advanceCandidate();
    skipUnacceptableCandidates();
  }

  public static void main(String[] args) {
    Collection<String> c = Arrays.asList(new String[]{"a", "aa", "b", "bb", "cc"});
    Iterator<String> i = new FilteredIterator<String>(c.iterator(), new Filter<String>() {
      private static final long serialVersionUID = 1L;

      public boolean accept(String o) {
        return o.length() == 1;
      }
    });
    while (i.hasNext()) {
      System.out.println("Accepted: " + i.next());
    }
  }
}
