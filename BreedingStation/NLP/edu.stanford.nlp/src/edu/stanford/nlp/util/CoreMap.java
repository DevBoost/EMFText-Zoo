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

import edu.stanford.nlp.util.logging.PrettyLoggable;

/**
 * <p>
 * Base type for all annotatable core objects. Should usually be instantiated as
 * {@link ArrayCoreMap}. Many common key definitions live in
 * {@link edu.stanford.nlp.ling.CoreAnnotations}, but others may be defined elsewhere. See
 * {@link edu.stanford.nlp.ling.CoreAnnotations} for details.
 * </p>
 * 
 * <p>
 * Note that implementations of this interface must take care to implement
 * equality correctly: by default, two CoreMaps are .equal if they contain the
 * same keys and all corresponding values are .equal. Subclasses that wish to
 * change this behavior (such as {@link HashableCoreMap}) must make sure that
 * all other CoreMap implementations have a special case in their .equals to use
 * that equality definition when appropriate. Similarly, care must be taken when
 * defining hashcodes. The default hashcode is 37 * sum of all keys' hashcodes
 * plus the sum of all values' hashcodes. However, use of this class as HashMap
 * keys is discouraged because the hashcode can change over time. Consider using
 * a {@link HashableCoreMap}.
 * </p>
 * 
 * @author dramage
 * @author rafferty
 */
public interface CoreMap extends TypesafeMap<CoreMap>, PrettyLoggable { }
