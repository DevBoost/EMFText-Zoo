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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import edu.stanford.nlp.ling.Label;
import edu.stanford.nlp.ling.Tag;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.stats.ClassicCounter;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.Index;

public class ChineseUnknownWordModelTrainer 
  extends AbstractUnknownWordModelTrainer 
{
  // Records the number of times word/tag pair was seen in training data.
  ClassicCounter<IntTaggedWord> seenCounter;
  ClassicCounter<IntTaggedWord> unSeenCounter;

  // c has a map from tags as Label to a Counter from word
  // signatures to Strings; it is used to collect counts that will
  // initialize the probabilities in tagHash
  HashMap<Label,ClassicCounter<String>> c;
  // tc record the marginal counts for each tag as an unknown.  It
  // should be the same as c's totalCount ??
  ClassicCounter<Label> tc;

  boolean useFirst, useGT, useUnicodeType;

  HashMap<Label, ClassicCounter<String>> tagHash;

  Set<String> seenFirst;

  double indexToStartUnkCounting;

  UnknownGTTrainer unknownGTTrainer;
  
  IntTaggedWord iTotal = new IntTaggedWord(nullWord, nullTag);

  UnknownWordModel model;
  
  @Override
  public void initializeTraining(Options op, Lexicon lex, 
                                 Index<String> wordIndex, 
                                 Index<String> tagIndex, double totalTrees) {
    super.initializeTraining(op, lex, wordIndex, tagIndex, totalTrees);

    boolean useGoodTuringUnknownWordModel = ChineseTreebankParserParams.DEFAULT_USE_GOOD_TURNING_UNKNOWN_WORD_MODEL;
    useFirst = true;
    useGT = (op.lexOptions.useUnknownWordSignatures == 0);
    if (lex instanceof ChineseLexicon) {
      useGoodTuringUnknownWordModel = ((ChineseLexicon) lex).useGoodTuringUnknownWordModel;
    } else if (op.tlpParams instanceof ChineseTreebankParserParams) {
      useGoodTuringUnknownWordModel = ((ChineseTreebankParserParams) op.tlpParams).useGoodTuringUnknownWordModel;
    }
    if (useGoodTuringUnknownWordModel) {
      this.useGT = true;
      this.useFirst = false;
    }

    this.useUnicodeType = op.lexOptions.useUnicodeType;

    if (useFirst) {
      System.err.println("ChineseUWM: treating unknown word as the average of their equivalents by first-character identity. useUnicodeType: " + useUnicodeType);
    }
    if (useGT) {
      System.err.println("ChineseUWM: using Good-Turing smoothing for unknown words.");
    }

    this.c = new HashMap<Label,ClassicCounter<String>>();
    this.tc = new ClassicCounter<Label>();
    this.unSeenCounter = new ClassicCounter<IntTaggedWord>();
    this.seenCounter = new ClassicCounter<IntTaggedWord>();
    this.seenFirst = new HashSet<String>();
    this.tagHash = new HashMap<Label, ClassicCounter<String>>();
    
    this.indexToStartUnkCounting = (totalTrees * op.trainOptions.fractionBeforeUnseenCounting);
    
    this.unknownGTTrainer = (useGT) ? new UnknownGTTrainer() : null;

    HashMap<String,Float> unknownGT = null;
    if (useGT) {
      unknownGT = unknownGTTrainer.unknownGT;
    }
    this.model = new ChineseUnknownWordModel(op, lex, wordIndex, tagIndex, 
                                             unSeenCounter, tagHash, 
                                             unknownGT, useGT, seenFirst);
  }
  
  /**
   * trains the first-character based unknown word model.
   *
   * @param tw The word we are currently training on
   * @param loc The position of that word
   * @param weight The weight to give this word in terms of training
   */
  public void train(TaggedWord tw, int loc, double weight) {
    if (useGT) {
      unknownGTTrainer.train(tw, weight);
    }
    
    String word = tw.word();
    Label tagL = new Tag(tw.tag());
    String first = word.substring(0, 1);
    if (useUnicodeType) {
      char ch = word.charAt(0);
      int type = Character.getType(ch);
      if (type != Character.OTHER_LETTER) {
        // standard Chinese characters are of type "OTHER_LETTER"!!
        first = Integer.toString(type);
      }
    }
    String tag = tw.tag();
    
    if ( ! c.containsKey(tagL)) {
      c.put(tagL, new ClassicCounter<String>());
    }
    c.get(tagL).incrementCount(first, weight);
    
    tc.incrementCount(tagL, weight);
          
    seenFirst.add(first);
    
    IntTaggedWord iW = new IntTaggedWord(word, IntTaggedWord.ANY, wordIndex, tagIndex);
    seenCounter.incrementCount(iW, weight);
    if (treesRead > indexToStartUnkCounting) {
      // start doing this once some way through trees; 
      // treesRead is 1 based counting
      if (seenCounter.getCount(iW) < 2) {
        IntTaggedWord iT = new IntTaggedWord(IntTaggedWord.ANY, tag, wordIndex, tagIndex);
        unSeenCounter.incrementCount(iT, weight);
        unSeenCounter.incrementCount(iTotal, weight);
      }
    }
  }
  
  public UnknownWordModel finishTraining() {
    HashMap<String,Float> unknownGT = null;
    if (useGT) {
      unknownGTTrainer.finishTraining();
      unknownGT = unknownGTTrainer.unknownGT;
    }
    
    for (Label tagLab : c.keySet()) {
      // outer iteration is over tags as Labels
      ClassicCounter<String> wc = c.get(tagLab); // counts for words given a tag
      
      if ( ! tagHash.containsKey(tagLab)) {
        tagHash.put(tagLab, new ClassicCounter<String>());
      }
      
      // the UNKNOWN first character is assumed to be seen once in
      // each tag
      // this is really sort of broken!  (why??)
      tc.incrementCount(tagLab);
      wc.setCount(unknown, 1.0);
      
      // inner iteration is over words  as strings
      for (String first : wc.keySet()) {
        double prob = Math.log(((wc.getCount(first))) / tc.getCount(tagLab));
        tagHash.get(tagLab).setCount(first, prob);
        //if (Test.verbose)
        //EncodingPrintWriter.out.println(tag + " rewrites as " + first + " firstchar with probability " + prob,encoding);
      }
    }

    return model;
  }
}

