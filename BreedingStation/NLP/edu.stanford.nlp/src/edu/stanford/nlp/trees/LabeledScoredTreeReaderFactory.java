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

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.LabelFactory;

import java.io.Reader;

/**
 * This class implements a <code>TreeReaderFactory</code> that produces
 * labeled, scored array-based Trees, which have been cleaned up to
 * delete empties, etc.   This seems to be a common case (for English).
 * By default, the labels are of type CategoryWordTag,
 * but a different Label type can be specified by the user.
 *
 * @author Christopher Manning
 */
public class LabeledScoredTreeReaderFactory implements TreeReaderFactory {

  private final LabelFactory lf;
  private final TreeNormalizer tm;

  /**
   * Create a new TreeReaderFactory with CategoryWordTag labels.
   */
  public LabeledScoredTreeReaderFactory() {
    lf = CoreLabel.factory();
    tm = new BobChrisTreeNormalizer();
  }

  public LabeledScoredTreeReaderFactory(LabelFactory lf) {
    this.lf = lf;
    tm = new BobChrisTreeNormalizer();
  }

  public LabeledScoredTreeReaderFactory(TreeNormalizer tm) {
    lf = CoreLabel.factory();
    this.tm = tm;
  }

  /**
   * An implementation of the <code>TreeReaderFactory</code> interface.
   * It creates a <code>TreeReader</code> which normalizes trees using
   * the <code>BobChrisTreeNormalizer</code>, and makes
   * <code>LabeledScoredTree</code> objects with
   * <code>CategoryWordTag</code> labels (unless otherwise specified on
   * construction).
   */
  public TreeReader newTreeReader(Reader in) {
    return new PennTreeReader(in, new LabeledScoredTreeFactory(lf), tm);
  }
}
