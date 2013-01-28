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

import java.util.Map;
import java.util.Set;

/**
 * An extension of {@link ArrayCoreMap} with an immutable set of key,value
 * pairs that is used for equality and hashcode comparisons.
 * 
 * @author dramage
 */
public class HashableCoreMap extends ArrayCoreMap {

  /** Set of immutable keys */
  private final Set<Class<? extends TypesafeMap.Key<CoreMap, ?>>> immutableKeys;
  
  /** Pre-computed hashcode */
  private final int hashcode;
  
  /**
   * Creates an instance of HashableCoreMap with initial key,value pairs
   * for the immutable, hashable keys as provided in the given map.
   */
  @SuppressWarnings("unchecked")
  public HashableCoreMap(Map<Class<? extends TypesafeMap.Key<CoreMap, ?>>,Object> hashkey) {
    int keyHashcode = 0;
    int valueHashcode = 0;
    
    for (Map.Entry<Class<? extends TypesafeMap.Key<CoreMap, ?>>,Object> entry : hashkey.entrySet()) {
      // NB it is important to compose these hashcodes in an order-independent
      // way, so we just add them all here.
      keyHashcode += entry.getKey().hashCode();
      valueHashcode += entry.getValue().hashCode();
      
      super.set((Class<? extends TypesafeMap.Key>)entry.getKey(),
          entry.getValue());
    }
    
    this.immutableKeys = hashkey.keySet();
    this.hashcode = keyHashcode * 31 + valueHashcode;
  }
  
  /**
   * Creates an instance by copying values from the given other CoreMap,
   * using the values it associates with the given set of hashkeys for
   * the immutable, hashable keys used by hashcode and equals.
   */
  @SuppressWarnings("unchecked")
  public HashableCoreMap(ArrayCoreMap other, Set<Class<? extends TypesafeMap.Key<CoreMap, ?>>> hashkey) {
    super(other);
    
    int keyHashcode = 0;
    int valueHashcode = 0;
    
    for (Class<? extends TypesafeMap.Key<CoreMap, ?>> key : hashkey) {
      // NB it is important to compose these hashcodes in an order-independent
      // way, so we just add them all here.
      keyHashcode += key.hashCode();
      valueHashcode += super.get((Class)key).hashCode();
    }
    
    this.immutableKeys = hashkey;
    this.hashcode = keyHashcode * 31 + valueHashcode;
  }
  
  /**
   * Sets the value associated with the given key; if the the key is one
   * of the hashable keys, throws an exception.
   * 
   * @throws HashableCoreMapException Attempting to set the value for an
   *   immutable, hashable key.
   */
  @Override
  public <VALUEBASE, VALUE extends VALUEBASE, KEY extends Key<CoreMap, VALUEBASE>>
    VALUE set(Class<KEY> key, VALUE value) {
    
    if (immutableKeys.contains(key)) {
      throw new HashableCoreMapException("Attempt to change value " +
      		"of immutable field "+key.getSimpleName());
    }
    
    return super.set(key, value);
  }
  
  /**
   * Provides a hash code based on the immutable keys and values provided
   * to the constructor.
   */
  @Override
  public int hashCode() {
    return hashcode;
  }
  
  /**
   * If the provided object is a HashableCoreMap, equality is based only
   * upon the values of the immutable hashkeys; otherwise, defaults to
   * behavior of the superclass's equals method.
   */
  @SuppressWarnings("unchecked")
  @Override
  public boolean equals(Object o) {
    if (o instanceof HashableCoreMap) {
      HashableCoreMap other = (HashableCoreMap) o;
      if (!other.immutableKeys.equals(this.immutableKeys)) {
        return false;
      }
      for (Class<? extends TypesafeMap.Key<CoreMap, ?>> key : immutableKeys) {
        if (!this.get((Class)key).equals(other.get((Class)key))) {
          return false;
        }
      }
      return true;
    } else {
      return super.equals(o);
    }
  }
  
  private static final long serialVersionUID = 1L;
  
  //
  // Exception type
  //
  
  /**
   * An exception thrown when attempting to change the value associated
   * with an (immutable) hash key in a HashableCoreMap.
   * 
   * @author dramage
   */
  public static class HashableCoreMapException extends RuntimeException {

    public HashableCoreMapException(String message) {
      super(message);
    }
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
  }
  
}
