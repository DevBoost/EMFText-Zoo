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
package edu.stanford.nlp.ling;

import java.util.Collection;

/**
 * Interface for Objects that have a label, whose label is an Object.
 * There are only two methods: Object label() and Collection labels().
 * If there is only one label, labels() will return a collection of one label.
 * If there are multiple labels, label() will return the primary label,
 * or a consistent arbitrary label if there is not primary label.
 *
 * @author Sepandar Kamvar (sdkamvar@stanford.edu)
 * 
 * Updated to take a specific type rather than just a blanket Object.  I'm hoping 
 * that it's true that the Collection will be of the same type as the primary label...
 * @author Sarah Spikes (sdspikes@cs.stanford.edu)
 */
public interface Labeled<E> {

  /**
   * Returns the primary label for this Object, or null if none have been set.
   */
  public E label();

  /**
   * Returns the complete list of labels for this Object, which may be empty.
   */
  public Collection<E> labels();

}
