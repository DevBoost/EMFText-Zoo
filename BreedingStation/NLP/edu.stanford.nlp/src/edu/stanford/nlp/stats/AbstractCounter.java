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
package edu.stanford.nlp.stats;

import edu.stanford.nlp.math.SloppyMath;

/**
 * Default implementations of all the convenience methods provided by
 * {@link Counter}.
 *
 * @author dramage
 */
public abstract class AbstractCounter<E> implements Counter<E> {

  public double logIncrementCount(E key, double amount) {
    double count = SloppyMath.logAdd(getCount(key), amount);
    setCount(key, count);
    return getCount(key);
  }

  public double incrementCount(E key, double amount) {
    double count = getCount(key) + amount;
    setCount(key, count);
    // get the value just to make sure it agrees with what is in the counter
    // (in case it's a float or int)
    return getCount(key);
  }

  public double incrementCount(E key) {
    return incrementCount(key, 1.0);
  }

  public double decrementCount(E key, double amount) {
    return incrementCount(key, -amount);
  }

  public double decrementCount(E key) {
    return incrementCount(key, -1.0);
  }

  /** {@inheritDoc} */
  public void addAll(Counter<E> counter) {
    Counters.addInPlace(this, counter);
  }

}
