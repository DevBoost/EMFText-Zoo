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

import edu.stanford.nlp.util.CoreMap;
import edu.stanford.nlp.util.TypesafeMap;

/**
 * The base class for any annotation that can be marked on a {@link CoreMap},
 * parameterized by the type of the value associated with the annotation.
 * Subclasses of this class are the keys in the {@link CoreMap}, so they are
 * instantiated only by utility methods in {@link CoreAnnotations}.
 * 
 * @author dramage
 * @author rafferty
 */
public interface CoreAnnotation<V>
  extends TypesafeMap.Key<CoreMap, V> {

  /**
   * Returns the type associated with this annotation.  This method must
   * return the same class type as its value type parameter.  It feels like
   * one should be able to get away without this method, but because Java
   * erases the generic type signature, that info disappears at runtime.
   */
  public Class<V> getType();
}
