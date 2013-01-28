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
package edu.stanford.nlp.trees.semgraph;

import edu.stanford.nlp.ling.CoreAnnotation;


/** Keeps SemanticGraphCoreAnnotations so they do not introduce
 *  dependencies for code not using the jgrapht library.
 *
 *  @author Christopher Manning
 */
public class SemanticGraphCoreAnnotations {

  /**
   * The CoreMap key for getting the syntactic dependencies of a sentence.
   * These are collapsed dependencies!
   *
   * This key is typically set on sentence annotations.
   */
  public static class CollapsedDependenciesAnnotation implements CoreAnnotation<SemanticGraph> {
    public Class<SemanticGraph> getType() {
      return SemanticGraph.class;
    }
  }


  /**
   * The CoreMap key for getting the syntactic dependencies of a sentence.
   * These are basic dependencies without any post-processing!
   *
   * This key is typically set on sentence annotations.
   */
  public static class BasicDependenciesAnnotation implements CoreAnnotation<SemanticGraph> {
    public Class<SemanticGraph> getType() {
      return SemanticGraph.class;
    }
  }


  /**
   * The CoreMap key for getting the syntactic dependencies of a sentence.
   * These are dependencies that are both collapsed and have CC processing!
   *
   * This key is typically set on sentence annotations.
   */
  public static class CollapsedCCProcessedDependenciesAnnotation implements CoreAnnotation<SemanticGraph> {
    public Class<SemanticGraph> getType() {
      return SemanticGraph.class;
    }
  }

}
