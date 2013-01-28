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
package edu.stanford.nlp.process.treebank;

import java.io.File;

/**
 * Generic interface for mapping one string to another given some contextual evidence.
 * 
 * @author Spence Green
 *
 */
public interface Mapper {
  
  /**
   * Perform initialization prior to the first call to <code>map</code>.
   * 
   * @param path A filename for data on disk used during mapping
   * @param options Variable length array of strings for options. Option format may
   * vary for the particular class instance.
   */
  public void setup(File path, String... options);
  
  /**
   * Maps from one string representation to another.
   * 
   * @param parent <code>element</code>'s context (e.g., the parent node in a parse tree)
   * @param element The string to be transformed.
   * @return The transformed string
   */
  public String map(String parent, String element);
  
  /**
   * Indicates whether <code>child</code> can be converted to another encoding. In the ATB, for example, 
   * if a punctuation character is labeled with the "PUNC" POS tag, then that character should not
   * be converted from Buckwalter to UTF-8.
   * 
   * @param parent <code>element</code>'s context (e.g., the parent node in a parse tree)
   * @param child The string to be transformed.
   * @return True if the string encoding can be changed. False otherwise.
   */
  public boolean canChangeEncoding(String parent, String child);
}
