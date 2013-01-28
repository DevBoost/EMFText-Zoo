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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import edu.stanford.nlp.ling.Label;
import edu.stanford.nlp.stats.ClassicCounter;
import edu.stanford.nlp.util.Index;
import edu.stanford.nlp.util.Index;

/**
 * An unknown word model for German; relies on BaseUnknownWordModel plus number matching.
 * An assumption of this model is that numbers (arabic digit sequences)
 * are tagged CARD. This is correct for all of NEGRA/Tiger/TuebaDZ.
 *
 * @author Roger Levy
 * @author Greg Donaker (corrections and modeling improvements)
 * @author Christopher Manning (generalized and improved what Greg did)
 */
public class GermanUnknownWordModel extends BaseUnknownWordModel {

  private static final long serialVersionUID = 221L;

  private static final String numberMatch = "[0-9]+(?:\\.[0-9]*)";

  public GermanUnknownWordModel(Options op, Lexicon lex,
                                Index<String> wordIndex,
                                Index<String> tagIndex,
                                ClassicCounter<IntTaggedWord> unSeenCounter,
                                HashMap<Label,ClassicCounter<String>> tagHash,
                                HashMap<String,Float> unknownGT,
                                Set<String> seenEnd) {
    super(op, lex, wordIndex, tagIndex, 
          unSeenCounter, tagHash, unknownGT, seenEnd);
  }


  /**
   * This constructor creates an UWM with empty data structures.  Only
   * use if loading in the data separately, such as by reading in text
   * lines containing the data.
   */
  public GermanUnknownWordModel(Options op, Lexicon lex,
                                Index<String> wordIndex, 
                                Index<String> tagIndex) {
    this(op, lex, wordIndex, tagIndex, 
         new ClassicCounter<IntTaggedWord>(),
         new HashMap<Label,ClassicCounter<String>>(),
         new HashMap<String,Float>(),
         new HashSet<String>());
  }


  /** Calculate the log-prob score of a particular TaggedWord in the
   *  unknown word model.
   *
   *  @param itw the tag->word production in IntTaggedWord form
   *  @return The log-prob score of a particular TaggedWord.
   */
  @Override
  public float score(IntTaggedWord itw, String word) {
    String tag = itw.tagString(tagIndex);

    if (word.matches(numberMatch)) {
      //EncodingPrintWriter.out.println("Number match for " + word,encoding);
      if (tag.equals("CARD")) {
        return 0.0f;
      } else {
        //EncodingPrintWriter.out.println("Unknown word estimate for " + word + " as " + tag + ": " + logProb,encoding); //debugging
        return Float.NEGATIVE_INFINITY;
      }
    } else {
      return super.score(itw, word);
    }
  }

}

