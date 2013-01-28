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


import edu.stanford.nlp.io.Lexer;
import edu.stanford.nlp.io.RuntimeIOException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;


/**
 * An implementation of {@link Tokenizer} designed to work with
 * {@link Lexer} implementing classes.  Throw in a {@link Lexer} on
 * construction and you get a {@link Tokenizer}.
 *
 * @author Roger Levy
 */
public class LexerTokenizer extends AbstractTokenizer<String> {

  private Lexer lexer;

  /**
   * Internally fetches the next token.
   *
   * @return the next token in the token stream, or null if none exists.
   */
  @Override
  protected String getNext() {
    String token = null;
    try {
      int a = Lexer.IGNORE;
      while ((a = lexer.yylex()) == Lexer.IGNORE) {
        ; // skip tokens to be ignored
      }
      if (a == lexer.getYYEOF()) {
        token = null;
      } else {
        token = lexer.yytext();
      }
    } catch (IOException e) {
      // do nothing, return null
    }
    return token;
  }

  /* Constructs a tokenizer from a {@link Lexer}
   */
  public LexerTokenizer(Lexer l) {
    if (l == null) {
      throw new IllegalArgumentException("You can't make a Tokenizer out of a null Lexer!");
    } else {
      this.lexer = l;
    }
  }

  /* Constructs a tokenizer from a {@link Lexer} and makes a {@link
   * Reader} the active input stream for the tokenizer.
   */
  public LexerTokenizer(Lexer l, Reader r) {
    this(l);

    try {
      l.yyreset(r);
    } catch (IOException e) {
      throw new RuntimeIOException(e.getMessage());
    }

    getNext();
  }


  /**
   * for testing only
   */
  public static void main(String[] args) throws IOException {
    Tokenizer<String> t = new LexerTokenizer(new JFlexDummyLexer((Reader) null), new BufferedReader(new FileReader(args[0])));
    while (t.hasNext()) {
      System.out.println("token " + t.next());
    }
  }

}
