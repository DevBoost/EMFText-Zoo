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

import java.io.Reader;

/** Vends {@link PennTreeReader} objects.
 *
 *  @author Roger Levy (rog@nlp.stanford.edu)
 */
public class PennTreeReaderFactory implements TreeReaderFactory {

  private final TreeFactory tf;
  private final TreeNormalizer tn;

  /**
   * Default constructor; uses a {@link LabeledScoredTreeFactory},
   * with StringLabels, a {@link PennTreebankTokenizer},
   * and a {@link TreeNormalizer}.
   */
  public PennTreeReaderFactory() {
    this(new LabeledScoredTreeFactory());
  }

  /**
   * Specify your own {@link TreeFactory};
   * uses a {@link PennTreebankTokenizer}, and a {@link TreeNormalizer}.
   *
   * @param tf The TreeFactory to use in building Tree objects to return.
   */
  public PennTreeReaderFactory(TreeFactory tf) {
    this(tf, new TreeNormalizer());
  }


  /**
   * Specify your own {@link TreeNormalizer};
   * uses a {@link PennTreebankTokenizer}, and a {@link LabeledScoredTreeFactory}.
   *
   * @param tn The TreeNormalizer to use in building Tree objects to return.
   */
  public PennTreeReaderFactory(TreeNormalizer tn) {
    this(new LabeledScoredTreeFactory(), tn);
  }


  /**
   * Specify your own {@link TreeFactory};
   * uses a {@link PennTreebankTokenizer}, and a {@link TreeNormalizer}.
   *
   * @param tf The TreeFactory to use in building Tree objects to return.
   * @param tn The TreeNormalizer to use
   */
  public PennTreeReaderFactory(TreeFactory tf, TreeNormalizer tn) {
    this.tf = tf;
    this.tn = tn;
  }


  public TreeReader newTreeReader(Reader in) {
    return new PennTreeReader(in, tf, tn, new PennTreebankTokenizer(in));
  }

}
