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

/**
 * A strategy-type interface for specifying a function from {@link Object}s
 * to their equivalence classes.
 *
 * @author Roger Levy
 * @see EquivalenceClassEval
 * @author Sarah Spikes (sdspikes@cs.stanford.edu) (Re-templatization)
 *
 * @param <IN> The type being classified
 * @param <OUT> The class types
 */

public interface EquivalenceClasser <IN, OUT> {
  public OUT equivalenceClass(IN o);
}
