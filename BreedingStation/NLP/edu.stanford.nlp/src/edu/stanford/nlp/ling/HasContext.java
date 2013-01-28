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
package edu.stanford.nlp.ling;

/**
 * @author grenager
 */
public interface HasContext {

  /**
   * @return the String before the word
   */
  public String before();

  /**
   * Set the whitespace String before the word.
   * @param before the whitespace String before the word
   */
  public void setBefore(String before);

  /**
   * Return the String which is the original character sequence of the token.
   *
   * @return The original character sequence of the token
   */
  public String originalText();

  /**
   * Set the String which is the original character sequence of the token.
   *
   * @param originalText The original character sequence of the token
   */
  public void setOriginalText(String originalText);

  /**
   * Return the whitespace String after the word.
   *
   * @return The whitespace String after the word
   */
  public String after();

  /**
   * Set the whitespace String after the word.
   *
   * @param after The whitespace String after the word
   */
  public void setAfter(String after);

}
