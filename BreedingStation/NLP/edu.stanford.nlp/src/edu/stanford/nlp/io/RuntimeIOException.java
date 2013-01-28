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
package edu.stanford.nlp.io;


/**
 * An unchecked version of {@link java.io.IOException}. Thrown by
 * {@link edu.stanford.nlp.process.Tokenizer} implementing classes,
 * among other things.
 *
 * @author Roger Levy
 * @author Christopher Manning
 */
public class RuntimeIOException extends RuntimeException {

  private static final long serialVersionUID = -8572218999165094626L;

  /**
   * Creates a new exception.
   */
  public RuntimeIOException() {
  }


  /**
   * Creates a new exception with a message.
   *
   * @param message the message for the exception
   */
  public RuntimeIOException(String message) {
    super(message);
  }

  /**
   * Creates a new exception with an embedded cause.
   *
   * @param cause The cause for the exception
   */
  public RuntimeIOException(Throwable cause) {
    super(cause);
  }

  /**
   * Creates a new exception with a message and an embedded cause.
   *
   * @param message the message for the exception
   * @param cause   The cause for the exception
   */
  public RuntimeIOException(String message, Throwable cause) {
    super(message, cause);
  }

}
