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
package edu.stanford.nlp.trees.international.french;

import java.io.Reader;
import java.io.Serializable;

import edu.stanford.nlp.trees.*;

/**
 * A class for reading French Treebank trees that have been converted
 * from XML to PTB format.
 * 
 * @author Spence Green
 *
 */
public class FrenchTreeReaderFactory implements TreeReaderFactory, Serializable {

  private static final long serialVersionUID = 6928967570430642163L;
 
  private final boolean readPennFormat;
  
  public FrenchTreeReaderFactory() {
    this(false);
  }
  
  public FrenchTreeReaderFactory(boolean pennFormat) {
    readPennFormat = pennFormat;
  }
  
  public TreeReader newTreeReader(Reader in) {
    if(readPennFormat) {
      return new PennTreeReader(in, new LabeledScoredTreeFactory(), new FrenchTreeNormalizer(),new PennTreebankTokenizer(in));
    }
    return new FrenchTreeReader(in);
  }
}
