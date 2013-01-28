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
package edu.stanford.nlp.parser.lexparser;

import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.Index;
import edu.stanford.nlp.util.Pair;

import java.util.Collection;
import java.util.Collections;


/**
 * A lexicon class for Chinese.  Extends the (English) BaseLexicon class,
 * overriding its score and train methods to include a
 * ChineseUnknownWordModel.
 *
 * @author Roger Levy
 */
public class ChineseLexicon extends BaseLexicon {

  private static final long serialVersionUID = -7836464391021114960L;

  public final boolean useCharBasedUnknownWordModel;
  // public static final boolean useMaxentUnknownWordModel;
  public final boolean useGoodTuringUnknownWordModel;

  //private ChineseUnknownWordModel unknown;
  // private ChineseMaxentLexicon cml;
  private static final int STEPS = 1;
  private RandomWalk probRandomWalk;


  public ChineseLexicon(Options op, ChineseTreebankParserParams params, Index<String> wordIndex, Index<String> tagIndex) {
    super(op, wordIndex, tagIndex);
    useCharBasedUnknownWordModel = params.useCharBasedUnknownWordModel;
    useGoodTuringUnknownWordModel = params.useGoodTuringUnknownWordModel;
    // if (useMaxentUnknownWordModel) {
    //  cml = new ChineseMaxentLexicon();
    // } else {
    //unknown = new ChineseUnknownWordModel();
    //this.setUnknownWordModel(new ChineseUnknownWordModel(op));
    // this.getUnknownWordModel().setLexicon(this);
    // }
  }



  @Override
  public float score(IntTaggedWord iTW, int loc, String word, String featureSpec) {
    double c_W = seenCounter.getCount(iTW);
    boolean seen = (c_W > 0.0);

    if (seen) {
      return super.score(iTW, loc, word, featureSpec);
    } else {
      float score;
      // if (useMaxentUnknownWordModel) {
      //  score = cml.score(iTW, 0);
      // } else {
      score = this.getUnknownWordModel().score(iTW, loc, 0.0, 0.0, 0.0, word); // ChineseUnknownWordModel doesn't use the final three params
      // }
      return score;
    }
  }
}
