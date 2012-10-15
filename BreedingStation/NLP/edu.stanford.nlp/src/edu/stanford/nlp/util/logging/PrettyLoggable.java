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
package edu.stanford.nlp.util.logging;

import edu.stanford.nlp.util.logging.Redwood.RedwoodChannels;

/**
 * Indicates that a class supports "pretty logging". Pretty logging is a type of
 * pretty-printing that uses the Redwood logging system to structure itself.
 * 
 * When pretty logging the contents of your object, you should check to see if
 * each object (call it <code>obj</code>) is dispatchable with
 * <code>PrettyLogger.dispatchable(obj)</code> if you don't know their type. If
 * true, you should call <code>channels.prettyLog(obj)</code> to pretty log it.
 * Otherwise, use its <code>toString()</code> method.
 * 
 * @see PrettyLogger
 * @author David McClosky
 * 
 */
public interface PrettyLoggable {
  /**
   * Pretty logs the current object to specific Redwood channels.
   * 
   * @param channels
   *          the channels which should be logged to -- all logging calls should
   *          use logging methods on the channels (e.g. channels.log(), etc.)
   * @param description
   *          The description of the object. It will potentially identify the
   *          object's functional role or (failing that) its class. This is
   *          typically used as a track name surrounding the contents of this
   *          object.
   */
  public void prettyLog(RedwoodChannels channels, String description);
}
