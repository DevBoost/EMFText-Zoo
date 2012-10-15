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

import java.util.Collection;
import java.util.List;

import edu.stanford.nlp.io.EncodingPrintWriter;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.stats.ClassicCounter;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.Index;

public class ArabicUnknownWordModelTrainer
  extends AbstractUnknownWordModelTrainer 
{
  // Records the number of times word/tag pair was seen in training data.
  ClassicCounter<IntTaggedWord> seenCounter;

  ClassicCounter<IntTaggedWord> unSeenCounter;

  double indexToStartUnkCounting;

  private static final boolean DOCUMENT_UNKNOWNS = false;
  // if UNK were a word, counts would merge
  private static final String UNKNOWN_WORD = "UNK";
  // boundary tag -- assumed not a real tag
  private static final String BOUNDARY_TAG = ".$$.";

  UnknownWordModel model;

  @Override
  public void initializeTraining(Options op, Lexicon lex, 
                                 Index<String> wordIndex, 
                                 Index<String> tagIndex, double totalTrees) {
    super.initializeTraining(op, lex, wordIndex, tagIndex, totalTrees);

    this.totalTrees = totalTrees;
    indexToStartUnkCounting = (totalTrees * op.trainOptions.fractionBeforeUnseenCounting);

    seenCounter = new ClassicCounter<IntTaggedWord>(20000);
    unSeenCounter = new ClassicCounter<IntTaggedWord>(20000);

    model = new ArabicUnknownWordModel(op, lex, wordIndex, tagIndex, 
                                       unSeenCounter);

    if (DOCUMENT_UNKNOWNS) {
      System.err.println("Collecting " + UNKNOWN_WORD + " from trees " +
                         (indexToStartUnkCounting + 1) + " to " + totalTrees);
    }
  }
  
  /**
   * Trains this lexicon on the Collection of trees.
   */
  public void train(TaggedWord tw, int loc, double weight) {
    IntTaggedWord iTW = 
      new IntTaggedWord(tw.word(), tw.tag(), wordIndex, tagIndex);
    IntTaggedWord iT = new IntTaggedWord(nullWord, iTW.tag);
    IntTaggedWord iW = new IntTaggedWord(iTW.word, nullTag);
    seenCounter.incrementCount(iW, weight);
    IntTaggedWord i = NULL_ITW;
    
    if (treesRead > indexToStartUnkCounting) {
      // start doing this once some way through trees; 
      // treesRead is 1 based counting
      if (seenCounter.getCount(iW) < 2) {
        // it's an entirely unknown word
        int s = model.getSignatureIndex(iTW.word, loc, 
                                        wordIndex.get(iTW.word));
        if (DOCUMENT_UNKNOWNS) {
          String wStr = wordIndex.get(iTW.word);
          String tStr = tagIndex.get(iTW.tag);
          String sStr = wordIndex.get(s);
          EncodingPrintWriter.err.println("Unknown word/tag/sig:\t" +
                                          wStr + '\t' + tStr + '\t' + 
                                          sStr, "UTF-8");
        }
        IntTaggedWord iTS = new IntTaggedWord(s, iTW.tag);
        IntTaggedWord iS = new IntTaggedWord(s, nullTag);
        unSeenCounter.incrementCount(iTS, weight);
        unSeenCounter.incrementCount(iT, weight);
        unSeenCounter.incrementCount(iS, weight);
        unSeenCounter.incrementCount(i, weight);
      } // else {
    }
  }

  public UnknownWordModel finishTraining() {
    // make sure the unseen counter isn't empty!  If it is, put in
    // a uniform unseen over tags
    if (unSeenCounter.isEmpty()) {
      int numTags = tagIndex.size();
      for (int tt = 0; tt < numTags; tt++) {
        if ( ! BOUNDARY_TAG.equals(tagIndex.get(tt))) {
          IntTaggedWord iT = new IntTaggedWord(nullWord, tt);
          IntTaggedWord i = NULL_ITW;
          unSeenCounter.incrementCount(iT);
          unSeenCounter.incrementCount(i);
        }
      }
    }
    // index the possible tags for each word
    // numWords = wordIndex.size();
    // unknownWordIndex = wordIndex.indexOf(Lexicon.UNKNOWN_WORD, true);
    // initRulesWithWord();

    return model;
  }
}
