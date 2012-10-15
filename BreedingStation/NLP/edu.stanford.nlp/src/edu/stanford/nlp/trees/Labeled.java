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

import java.util.Collection;

/**
 * Interface for Objects which have a <code>Label</code>.
 * For instance, they may be hand-classified with one or more tags.
 * Note that it is for things that possess
 * a label via composition, rather than for things that implement
 * the <code>Label</code> interface.
 * An implementor might choose to be read-only and throw an
 * UnsupportedOperationException on the setLabel(s)() commands, but should
 * minimally implement both commands to return Label(s).
 *
 * @author Sep Kamvar
 * @author Christopher Manning
 * @author Sarah Spikes (sdspikes@cs.stanford.edu) - filled in types
 */

public interface Labeled {

  /**
   * Returns the Object's label.
   *
   * @return One of the labels of the object (if there are multiple labels,
   *         preferably the primary label, if it exists).
   *         Returns null if there is no label.
   */

  public Label label();


  /**
   * Sets the label associated with this object.
   *
   * @param label The Label value
   */

  public void setLabel(final Label label);


  /**
   * Gives back all labels for this thing.
   *
   * @return A Collection of the Object's labels.  Returns an empty
   *         Collection if there are no labels.
   */

  public Collection<Label> labels();


  /**
   * Sets the labels associated with this object.
   *
   * @param labels The set of Label values
   */

  public void setLabels(final Collection<Label> labels);

}
