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
 * An interace for drawing samples from the label
 * space of an object.  The classifiers themselves are
 * {@link Sampleable}.  For instance, a parser can
 * {@link Sampleable} and then vends Sampler instances
 * based on specific inputs (words in the sentence).
 * The Sampler would then return parse trees (over
 * that particular sentence, not over all sentences)
 * drawn from
 * the underlying distribution.
 *
 * @author Jenny Finkel
 */
public interface Sampler<T> {

  /**
   * @return labels (of type T) drawn from the underlying
   * distribution for the observation this Sampler was
   * created for.
   */
  public T drawSample();

}
