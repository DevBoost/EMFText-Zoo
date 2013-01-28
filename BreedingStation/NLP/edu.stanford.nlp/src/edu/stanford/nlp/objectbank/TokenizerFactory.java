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
package edu.stanford.nlp.objectbank;

import edu.stanford.nlp.process.Tokenizer;

import java.io.Reader;

/**
 * A TokenizerFactory is used to convert a java.io.Reader
 * into a Tokenizer (or an Iterator) over the Objects represented by the text
 * in the java.io.Reader.  It's mainly a convenience, since you could cast
 * down anyway.
 *
 * <i>Note:</i> A TokenizerFactory should also provide a static method: <br><code>
 * public static TokenizerFactory&lt;? extends HasWord&gt; newTokenizerFactory();
 * </code><br>
 * This is expected by certain JavaNLP code which wants to produce a
 * TokenizerFactory by reflection.
 * 
 * @author Christopher Manning
 *
 * @param <T> The type of the tokens returned by the Tokenizer
 */
public interface TokenizerFactory<T> extends IteratorFromReaderFactory<T> {

  public Tokenizer<T> getTokenizer(Reader r);
  
  public Tokenizer<T> getTokenizer(Reader r, String extraOptions);
  
  public void setOptions(String options);
}
