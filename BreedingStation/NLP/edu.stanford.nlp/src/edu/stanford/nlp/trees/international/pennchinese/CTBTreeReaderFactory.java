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
package edu.stanford.nlp.trees.international.pennchinese;

import java.io.Reader;

import edu.stanford.nlp.trees.*;


/**
 * The <code>CTBTreeReaderFactory</code> is a factory for creating a
 * TreeReader suitable for the Penn CTB.
 *
 * @author Christopher Manning
 */
public class CTBTreeReaderFactory implements TreeReaderFactory {

  private final TreeNormalizer tn;
  private final boolean discardFrags;

  public CTBTreeReaderFactory() {
    this(new TreeNormalizer());
  }

  public CTBTreeReaderFactory(TreeNormalizer tn) {
    this(tn, false);
  }

  public CTBTreeReaderFactory(TreeNormalizer tn, boolean discardFrags) {
    this.tn = tn;
    this.discardFrags = discardFrags;
  }

  /**
   * Create a new <code>TreeReader</code> using the provided
   * <code>Reader</code>.
   *
   * @param in The <code>Reader</code> to build on
   * @return The new TreeReader
   */
  public TreeReader newTreeReader(Reader in) {
    if (discardFrags) {
      return new FragDiscardingPennTreeReader(in, new LabeledScoredTreeFactory(), tn, new CHTBTokenizer(in));
    } else {
      return new PennTreeReader(in, new LabeledScoredTreeFactory(), tn, new CHTBTokenizer(in));
    }
  }
}
