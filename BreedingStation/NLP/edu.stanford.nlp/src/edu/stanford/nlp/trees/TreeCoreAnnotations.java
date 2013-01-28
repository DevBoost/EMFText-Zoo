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

import edu.stanford.nlp.ling.CoreAnnotation;


/**
 * Set of common annotations for {@link edu.stanford.nlp.util.CoreMap}s 
 * that require classes from the trees package.  See 
 * {@link edu.stanford.nlp.ling.CoreAnnotations} for more information.
 * This class exists so that
 * {@link edu.stanford.nlp.ling.CoreAnnotations} need not depend on
 * trees classes, making distributions easier.
 * @author Anna Rafferty
 *
 */

public class TreeCoreAnnotations {
  
  private TreeCoreAnnotations() {} // only static members

  /**
   * The CoreMap key for getting the syntactic parse tree of a sentence.
   *
   * This key is typically set on sentence annotations.
   */
  public static class TreeAnnotation implements CoreAnnotation<Tree> {
    public Class<Tree> getType() {
      return Tree.class;
    }
  }

  /**
   * The standard key for storing a head word in the map as a pointer to
   * another node.
   */
  public static class HeadWordAnnotation implements CoreAnnotation<Tree> {
    public Class<Tree> getType() {  return Tree.class; } }

  /**
   * The standard key for storing a head tag in the map as a pointer to
   * another node.
   */
  public static class HeadTagAnnotation implements CoreAnnotation<Tree> {
    public Class<Tree> getType() {  return Tree.class; } }

}
