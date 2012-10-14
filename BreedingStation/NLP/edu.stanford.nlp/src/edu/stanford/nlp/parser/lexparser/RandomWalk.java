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
package edu.stanford.nlp.parser.lexparser;

import edu.stanford.nlp.stats.ClassicCounter;
import edu.stanford.nlp.stats.Counter;
import edu.stanford.nlp.util.Pair;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.io.Serializable;


class RandomWalk implements Serializable {

  private static final long serialVersionUID = -5284941866796561664L;

  private final HashMap<Object,Counter> model = new HashMap<Object,Counter>();

  private final HashMap<Object,Counter> hiddenToSeen = new HashMap<Object,Counter>();
  private final HashMap<Object,Counter> seenToHidden = new HashMap<Object,Counter>();

  private static final double LAMBDA = 0.01;

  /**
   * Uses the initialized values
   */
  public double score(Object hidden, Object seen) {
    return model.get(hidden).getCount(seen) / model.get(hidden).totalCount();
  }

  /* score with flexible number of steps */
  public double score(Object hidden, Object seen, int steps) {
    double total = 0;
    for (int i = 0; i <= steps; i++) {
      total += Math.pow(LAMBDA, steps) * step(hidden, seen, steps);
    }
    return total;
  }

  /* returns probability of hidden -> seen with <code>steps</code>
   * random walk steps */
  public double step(Object hidden, Object seen, int steps) {
    if (steps < 1) {
      return hiddenToSeen.get(hidden).getCount(seen) / hiddenToSeen.get(hidden).totalCount();
    } else {
      double total = 0;
      for (Object seen1 : seenToHidden.keySet()) {
        for (Object hidden1 : hiddenToSeen.keySet()) {
          double subtotal = hiddenToSeen.get(hidden).getCount(seen1) / hiddenToSeen.get(hidden).totalCount() * (seenToHidden.get(seen1).getCount(hidden1) / seenToHidden.get(seen1).totalCount());
          subtotal += score(hidden1, seen, steps - 1);
          total += subtotal;
        }
      }
      return total;
    }
  }


  public void train(Collection<Pair<?,?>> data) {
    for (Pair p : data) {
      Object seen = p.first();
      Object hidden = p.second();
      if (!hiddenToSeen.keySet().contains(hidden)) {
        hiddenToSeen.put(hidden, new ClassicCounter());
      }
      hiddenToSeen.get(hidden).incrementCount(seen);

      if (!seenToHidden.keySet().contains(seen)) {
        seenToHidden.put(seen, new ClassicCounter());
      }
      seenToHidden.get(seen).incrementCount(hidden);
    }
  }

  /**
   * builds a random walk model with n steps.
   *
   * @param data A collection of seen/hidden event <code>Pair</code>s
   */
  public RandomWalk(Collection<Pair<?,?>> data, int steps) {
    Map m = new HashMap();
    train(data);
    for (Iterator i = seenToHidden.keySet().iterator(); i.hasNext();) {
      Object seen = i.next();
      if (!model.containsKey(seen)) {
        model.put(seen, new ClassicCounter());
      }
      for (Iterator j = hiddenToSeen.keySet().iterator(); j.hasNext();) {
        Object hidden = j.next();
        model.get(seen).setCount(hidden, score(seen, hidden, steps));
      }
    }
  }

}
