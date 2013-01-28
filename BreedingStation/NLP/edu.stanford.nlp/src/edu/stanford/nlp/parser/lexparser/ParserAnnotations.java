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
package edu.stanford.nlp.parser.lexparser;

import java.util.List;

import edu.stanford.nlp.ling.CoreAnnotation;
import edu.stanford.nlp.util.ErasureUtils;

/**
 * Parse time options for the Stanford lexicalized parser.  For
 * example, you can set a ConstraintAnnotation and the parser
 * annotator will extract that annotation and apply the constraints
 * when parsing.
 */

public class ParserAnnotations {
  
  private ParserAnnotations() {} // only static members



  /**
   * This CoreMap key represents a regular expression which the parser
   * will try to match when assigning tags.
   *
   * This key is typically set on token annotations.
   */
  public static class CandidatePartOfSpeechAnnotation implements CoreAnnotation<String> {
    public Class<String> getType() {
      return String.class;
    }
  }

  /**
   * The CoreMap key for getting a list of constraints to apply when parsing.
   */
  public static class ConstraintAnnotation 
    implements CoreAnnotation<List<ParserConstraint>> 
  {
    public Class<List<ParserConstraint>> getType() {
      return ErasureUtils.<Class<List<ParserConstraint>>> uncheckedCast(List.class);
    }
  }


}
