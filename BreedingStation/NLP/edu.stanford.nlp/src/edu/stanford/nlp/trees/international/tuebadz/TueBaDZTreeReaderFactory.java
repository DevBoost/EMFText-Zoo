/*******************************************************************************
 * Copyright (C) 2012
 * Jan Reimann (TU Dresden, Software Technology Group)
 * Mirko Seifert (DevBoost GmbH)
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
package edu.stanford.nlp.trees.international.tuebadz;

import java.io.Serializable;
import java.io.Reader;
import java.util.*;

import edu.stanford.nlp.trees.*;
import edu.stanford.nlp.ling.StringLabelFactory;


/** @author Christopher Manning */
public class TueBaDZTreeReaderFactory implements TreeReaderFactory, Serializable {

  private static final long serialVersionUID = 1614799885744961795L;

  private TreebankLanguagePack tlp;
  private int nodeCleanup;

  public TueBaDZTreeReaderFactory(TreebankLanguagePack tlp) {
    this(tlp, 0);
  }

  public TueBaDZTreeReaderFactory(TreebankLanguagePack tlp, int nodeCleanup) {
    this.tlp = tlp;
    this.nodeCleanup = nodeCleanup;
  }

  public TreeReader newTreeReader(Reader in) {
    final TreeNormalizer tn1 = new GrammaticalFunctionTreeNormalizer(tlp, nodeCleanup);
    final TueBaDZPennTreeNormalizer tn2 = new TueBaDZPennTreeNormalizer(tlp, nodeCleanup);
    final TreeNormalizer norm = new OrderedCombinationTreeNormalizer(Arrays.asList(tn1, tn2));

    return new PennTreeReader(in, new LabeledScoredTreeFactory(new StringLabelFactory()), norm);
  }

} // end class TueBaDZTreeReaderFactory
