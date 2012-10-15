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

import java.util.*;


public class Comparators {

  // Copied from edu.stanford.nlp.natlog.util
  /**
   * Returns a new <code>Comparator</code> which is the result of chaining the
   * given <code>Comparator</code>s.  If the first <code>Comparator</code>
   * considers two objects unequal, its result is returned; otherwise, the
   * result of the second <code>Comparator</code> is returned.  Facilitates
   * sorting on primary and secondary keys.
   */
  public static <T> Comparator<T> chain(final Comparator<T> c1,
                                        final Comparator<T> c2) {
    return new Comparator<T>() {
      public int compare(T o1, T o2) {
        int x = c1.compare(o1, o2);
        return (x == 0 ? c2.compare(o1, o2) : x);
      }
    };
  }

  // Copied from edu.stanford.nlp.natlog.util
  /**
   * Returns a new <code>Comparator</code> which is the result of chaining the
   * given <code>Comparator</code>s.  Facilitates sorting on multiple keys.
   */
  public static <T> Comparator<T> chain(final List<Comparator<T>> c) {
    return new Comparator<T>() {
      public int compare(T o1, T o2) {
        int x = 0;
        Iterator<Comparator<T>> it = c.iterator();
        while (x == 0 && it.hasNext()) {
          x = it.next().compare(o1, o2);
        }
        return x;
      }
    };
  }

  public static <T> Comparator<T> chain(Comparator<T>... c) {
    return chain(Arrays.asList(c));
  }

  /**
   * Returns a consistent ordering over two elements even if one of them is null
   * (as long as compareTo() is stable, of course).
   * 
   * Adapted from http://stackoverflow.com/a/481836
   */
  public static <T extends Comparable<? super T>> int nullSafeComparator(final T one, final T two) {
    if (one == null ^ two == null) {
      return (one == null) ? -1 : 1;
    }

    if (one == null && two == null) {
      return 0;
    }

    return one.compareTo(two);
  }
}
