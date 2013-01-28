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
package edu.stanford.nlp.parser;

/**
 * The interface for Viterbi parsers with options.  Viterbi parsers support
 * getBestParse, which returns a best parse of the input, or
 * <code>null</code> if no parse exists.
 *
 * @author Christopher Manning
 */
public interface ViterbiParserWithOptions extends ViterbiParser {

  /**
   * This will set options to a parser, in a way generally equivalent to
   * passing in the same sequence of command-line arguments.  This is a useful
   * convenience method when building a parser programmatically. The options
   * passed in should
   * be specified like command-line arguments, including with an initial
   * minus sign.
   *
   * @param flags Arguments to the parser, for example,
   *              {"-outputFormat", "typedDependencies", "-maxLength", "70"}
   * @throws IllegalArgumentException If an unknown flag is passed in
   */
  public void setOptionFlags(String... flags);

}
