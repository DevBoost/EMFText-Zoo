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
 * Simple utility class: reads the environment variable in
 * ENV_VARIABLE and provides a method that converts strings which
 * start with that environment variable to file paths.  For example,
 * you can send it
 * "$NLP_DATA_HOME/data/pos-tagger/wsj3t0-18-left3words"
 * and it will convert that to
 * "/u/nlp/data/pos-tagger/wsj3t0-18-left3words"
 * unless you have set $NLP_DATA_HOME to something else.
 * <br>
 * The only environment variable expanded is that defined by
 * ENV_VARIABLE, and the only place in the string it is expanded is at
 * the start of the string.
 *
 * @author John Bauer
 */

public class DataFilePaths {
  private DataFilePaths() {}

  static final String NLP_DATA_VARIABLE = "NLP_DATA_HOME";
  static final String NLP_DATA_VARIABLE_PREFIX = "$" + NLP_DATA_VARIABLE;

  static final String NLP_DATA_HOME = 
    ((System.getenv(NLP_DATA_VARIABLE) != null) ?
     System.getenv(NLP_DATA_VARIABLE) : "/u/nlp");

  static final String JAVANLP_VARIABLE = "JAVANLP_HOME";
  static final String JAVANLP_VARIABLE_PREFIX = "$" + JAVANLP_VARIABLE;

  static final String JAVANLP_HOME = 
    ((System.getenv(JAVANLP_VARIABLE) != null) ?
     System.getenv(JAVANLP_VARIABLE) : ".");

  static public String convert(String path) {
    if (path.startsWith(NLP_DATA_VARIABLE_PREFIX))
      return NLP_DATA_HOME + path.substring(NLP_DATA_VARIABLE_PREFIX.length());
    if (path.startsWith(JAVANLP_VARIABLE_PREFIX))
      return JAVANLP_HOME + path.substring(JAVANLP_VARIABLE_PREFIX.length());
    return path;
  }
}
