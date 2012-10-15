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
package edu.stanford.nlp.process;

/**
 * Constructs a token (of arbitrary type) from a String and its position
 * in the underlying text.  This is used to create tokens in JFlex lexers
 * such as PTBTokenizer.
 */
public interface LexedTokenFactory<T> {

  /**
   * Constructs a token (of arbitrary type) from a String and its position
   * in the underlying text.
   *
   * @param str The String extracted by the lexer.
   * @param begin The offset in the document of the first character
   *  in this string.
   * @param length The number of characters the string takes up in
   *  the document.
   * @return The token of type T.
   */
  public T makeToken(String str, int begin, int length);
  
}
