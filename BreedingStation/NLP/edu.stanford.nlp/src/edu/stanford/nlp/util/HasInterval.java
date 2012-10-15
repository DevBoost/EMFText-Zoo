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

import java.util.Comparator;

/**
 * HasInterval interface
 *
 * @author Angel Chang
 */
public interface HasInterval<E extends Comparable<E>> {
  /**
   * Returns the interval
   * @return interval
   */
  public Interval<E> getInterval();

  public final static Comparator<HasInterval<Integer>> LENGTH_COMPARATOR =
          new Comparator<HasInterval<Integer>>() {
            public int compare(HasInterval<Integer> e1, HasInterval<Integer> e2) {
              int len1 = e1.getInterval().getEnd() - e1.getInterval().getBegin();
              int len2 = e2.getInterval().getEnd() - e2.getInterval().getBegin();
              if (len1 == len2) {
                return 0;
              } else {
                return (len1 > len2)? -1:1;
              }
            }
          };

  public final static Comparator<HasInterval> ENDPOINTS_COMPARATOR =
          new Comparator<HasInterval>() {
            public int compare(HasInterval e1, HasInterval e2) {
              return (e1.getInterval().compareTo(e2.getInterval()));
            }
          };

  public final static Comparator<HasInterval> NESTED_FIRST_COMPARATOR =
          new Comparator<HasInterval>() {
            public int compare(HasInterval e1, HasInterval e2) {
              Interval.RelType rel = e1.getInterval().getRelation(e2.getInterval());
              if (rel.equals(Interval.RelType.CONTAIN)) {
                return 1;
              } else if (rel.equals(Interval.RelType.INSIDE)) {
                return -1;
              } else {
                return (e1.getInterval().compareTo(e2.getInterval()));
              }
            }
          };

  public final static Comparator<HasInterval> CONTAINS_FIRST_COMPARATOR =
          new Comparator<HasInterval>() {
            public int compare(HasInterval e1, HasInterval e2) {
              Interval.RelType rel = e1.getInterval().getRelation(e2.getInterval());
              if (rel.equals(Interval.RelType.CONTAIN)) {
                return -1;
              } else if (rel.equals(Interval.RelType.INSIDE)) {
                return 1;
              } else {
                return 0;
              }
            }
          };
  public final static Comparator<HasInterval> CONTAINS_FIRST_ENDPOINTS_COMPARATOR =
          Comparators.chain(CONTAINS_FIRST_COMPARATOR, ENDPOINTS_COMPARATOR);
  public final static Comparator<HasInterval> NESTED_FIRST_ENDPOINTS_COMPARATOR =
          Comparators.chain(NESTED_FIRST_COMPARATOR, ENDPOINTS_COMPARATOR);

}
