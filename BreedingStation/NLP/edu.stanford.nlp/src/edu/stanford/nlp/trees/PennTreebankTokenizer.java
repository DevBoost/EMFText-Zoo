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

import edu.stanford.nlp.process.TokenizerAdapter;

import java.io.Reader;
import java.io.StreamTokenizer;


/**
 * Builds a tokenizer for English PennTreebank (release 2) trees.
 * This is currently internally implemented via a java.io.StreamTokenizer.
 *
 * @author Christopher Manning
 * @author Roger Levy
 * @version 2003/01/15
 */
public class PennTreebankTokenizer extends TokenizerAdapter {

  /**
   * A StreamTokenizer for PennTreebank trees.
   */
  private static class EnglishTreebankStreamTokenizer extends StreamTokenizer {

    /**
     * Create a StreamTokenizer for PennTreebank trees.
     * This sets up all the character meanings for treebank trees
     *
     * @param r The reader steam
     */
    private EnglishTreebankStreamTokenizer(Reader r) {
      super(r);
      // start with new tokenizer syntax -- everything ordinary
      resetSyntax();
      // treat parens as symbols themselves -- done by reset
      // ordinaryChar(')');
      // ordinaryChar('(');

      // treat chars in words as words, like a-zA-Z
      // treat all the typewriter keyboard symbols as parts of words
      // You need to look at an ASCII table to understand this!
      wordChars('!', '\'');  // non-space non-ctrl symbols before '('
      wordChars('*', '/');   // after ')' till before numbers
      wordChars('0', '9');   // numbers
      wordChars(':', '@');   // symbols between numbers, letters
      wordChars('A', 'Z');   // uppercase letters
      wordChars('[', '`');   // symbols between ucase and lcase
      wordChars('a', 'z');   // lowercase letters
      wordChars('{', '~');   // symbols before DEL
      wordChars(128, 255);   // C.Thompson, added 11/02

      // take the normal white space charaters, including tab, return,
      // space
      whitespaceChars(0, ' ');
    }
  }

  public PennTreebankTokenizer(Reader r) {
    super(new EnglishTreebankStreamTokenizer(r));
  }

}
