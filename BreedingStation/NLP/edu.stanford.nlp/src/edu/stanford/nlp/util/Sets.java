/*******************************************************************************
 * Copyright (C) 2012
 * Jan Reimann (TU Dresden, Software Technology Group)
 * Mirko Seifert (DevBoost GmbH)
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

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


/**
 * Utilities for sets.
 *
 * @author Roger Levy, Bill MacCartney
 */
public class Sets {

  // private to prevent instantiation
  private Sets() {}


  /**
   * Returns the set cross product of s1 and s2, as <code>Pair</code>s
   */
  public static <E,F> Set<Pair<E,F>> cross(Set<E> s1, Set<F> s2) {
    Set<Pair<E,F>> s = new HashSet<Pair<E,F>>();
    for (E o1 : s1) {
      for (F o2 : s2) {
        s.add(new Pair<E,F>(o1, o2));
      }
    }
    return s;
  }

  /**
   * Returns the difference of sets s1 and s2.
   */
  public static <E> Set<E> diff(Set<E> s1, Set<E> s2) {
    Set<E> s = new HashSet<E>();
    for (E o : s1) {
      if (!s2.contains(o)) {
        s.add(o);
      }
    }
    return s;
  }

  /**
   * Returns the symmetric difference of sets s1 and s2 (i.e. all elements that are in only one of the two sets)
   */
  public static <E> Set<E> symmetricDiff(Set<E> s1, Set<E> s2) {
    Set<E> s = new HashSet<E>();
    for (E o : s1) {
      if (!s2.contains(o)) {
        s.add(o);
      }
    }
    for (E o : s2) {
      if (!s1.contains(o)) {
        s.add(o);
      }
    }
    return s;
  }

  /**
   * Returns the union of sets s1 and s2.
   */
  public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
    Set<E> s = new HashSet<E>();
    s.addAll(s1);
    s.addAll(s2);
    return s;
  }

  /**
   * Returns the intersection of sets s1 and s2.
   */
  public static <E> Set<E> intersection(Set<E> s1, Set<E> s2) {
    Set<E> s = new HashSet<E>();
    s.addAll(s1);
    s.retainAll(s2);
    return s;
  }

  /**
   * Returns true if there is at least element that is in both s1 and s2. Faster
   * than calling intersection(Set,Set) if you don't need the contents of the
   * intersection.
   */
  public static <E> boolean intersects(Set<E> s1, Set<E> s2) {
    // *ahem* It would seem that Java already had this method. Hopefully this
    // stub will help people find it better than I did.
    return !Collections.disjoint(s1, s2);
  }  

  /**
   * Returns the powerset (the set of all subsets) of set s.
   */
  public static <E> Set<Set<E>> powerSet(Set<E> s) {
    if (s.isEmpty()) {
      Set<Set<E>> h = new HashSet<Set<E>>();
      Set<E> h0 = new HashSet<E>(0);
      h.add(h0);
      return h;
    } else {
      Iterator<E> i = s.iterator();
      E elt = i.next();
      s.remove(elt);
      Set<Set<E>> pow = powerSet(s);
      Set<Set<E>> pow1 = powerSet(s);
      // for (Iterator j = pow1.iterator(); j.hasNext();) {
      for (Set<E> t : pow1) {
        // Set<E> t = new HashSet<E>((Set<E>) j.next());
        t.add(elt);
        pow.add(t);
      }
      s.add(elt);
      return pow;
    }
  }

  public static void main(String[] args) {
    Set<String> h = new HashSet<String>();
    h.add("a");
    h.add("b");
    h.add("c");
    Set<Set<String>> pow = powerSet(h);
    System.out.println(pow);
  }

}
