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

/**
 * The goal of this class is to make it easier to load stuff by
 * reflection.  You can hide all of the ugly exception catching, etc
 * by using the static methods in this class.
 *
 * @author John Bauer
 * @author Gabor Angeli (changed)
 */

public class ReflectionLoading {
  // static methods only
  private ReflectionLoading() {}

  /**
   * You can use this as follows:
   * <br>
   *  String s = 
   *    ReflectionLoading.loadByReflection("java.lang.String", "foo");
   * <br>
   *  String s =
   *    ReflectionLoading.loadByReflection("java.lang.String");
   * <br>
   * Note that this uses generics for convenience, but this does
   * nothing for compile-time error checking.  You can do
   * <br>
   *  Integer i = 
   *    ReflectionLoading.loadByReflection("java.lang.String");
   * <br>
   * and it will compile just fine, but will result in a ClassCastException.
   */
   @SuppressWarnings("unchecked")
  static public <T> T loadByReflection(String className, 
                                       Object ... arguments) {    
    try{
      return (T) new MetaClass(className).createInstance(arguments);
    } catch(Exception e){
      throw new ReflectionLoadingException(e);
    }
  }

  /**
   * This class encapsulates all of the exceptions that can be thrown
   * when loading something by reflection.
   */
  static public class ReflectionLoadingException extends RuntimeException {
    public ReflectionLoadingException(Throwable reason) {
      super(reason);
    }
  }
}
