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
package edu.stanford.nlp.trees;

import edu.stanford.nlp.ling.Label;

import java.io.Serializable;


/**
 * An individual dependency between a governor and a dependent.
 * The governor and dependent are represented as a Label.
 * For example, these can be a
 * Word or a WordTag.  If one wishes the dependencies to preserve positions
 * in a sentence, then each can be a LabeledConstituent or CoreLabel.
 * Dependencies support an Object naming the dependency type.  This may be
 * null.  Dependencies have factories.
 *
 * @author Christopher Manning
 */
public interface Dependency<G extends Label,D extends Label,N> extends Serializable {

  /**
   * Describes the governor (regent/head) of the dependency relation.
   * @return The governor of this dependency
   */
  public G governor();

  /**
   * Describes the dependent (argument/modifier) of
   * the dependency relation.
   * @return the dependent of this dependency
   */
  public D dependent();

  /**
   * Names the type of dependency (subject, instrument, ...).
   * This might be a String in the simplest case, but can provide for
   * arbitrary object types.
   * @return the name for this dependency type
   */
  public N name();

  /**
   * Are two dependencies equal if you ignore the dependency name.
   * @param o The thing to compare against ignoring name
   * @return true iff the head and dependent are the same.
   */
  public boolean equalsIgnoreName(Object o);

  /**
   * Provide different printing options via a String keyword.
   * The main recognized option currently is "xml".  Otherwise the
   * default toString() is used.
   * @param format A format string, either "xml" or you get the default
   * @return A String representation of the dependency
   */
  public String toString(String format);

  /**
   * Provide a factory for this kind of dependency
   * @return A DependencyFactory
   */
  public DependencyFactory dependencyFactory();

}
