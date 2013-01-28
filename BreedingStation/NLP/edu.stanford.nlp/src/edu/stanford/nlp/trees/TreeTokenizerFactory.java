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

import edu.stanford.nlp.objectbank.TokenizerFactory;
import edu.stanford.nlp.process.Tokenizer;
import edu.stanford.nlp.process.AbstractTokenizer;

import java.io.Reader;
import java.io.IOException;
import java.util.Iterator;

/** Wrapper for TreeReaderFactory.  Any IOException in the readTree() method
 *  of the TreeReader will result in a null
 *  tree returned.
 *
 *  @author Roger Levy (rog@stanford.edu)
 *  @author javanlp
 */
public class TreeTokenizerFactory implements TokenizerFactory<Tree> {

  /** Create a TreeTokenizerFactory from a TreeReaderFactory. */
  public TreeTokenizerFactory(TreeReaderFactory trf) {
    this.trf = trf;
  }

  private TreeReaderFactory trf;

  /** Gets a tokenizer from a reader.*/
  public Tokenizer<Tree> getTokenizer(final Reader r) {
    return new AbstractTokenizer<Tree>() {
      TreeReader tr = trf.newTreeReader(r);
      @Override
      public Tree getNext() {
        try {
          return tr.readTree();
        }
        catch(IOException e) {
          System.err.println("Error in reading tree.");
          return null;
        }
      }
    };
  }

  public Tokenizer<Tree> getTokenizer(final Reader r, String extraOptions) {
    // Silently ignore extra options
    return getTokenizer(r);
  }

  /** Same as getTokenizer().  */
  public Iterator<Tree> getIterator(Reader r) {
    return null;
  }

  public void setOptions(String options) {
    //Silently ignore
  }
}
