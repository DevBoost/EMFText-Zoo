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

public class BaseUnknownWordModelTrainer
  extends AbstractUnknownWordModelTrainer 
{
  // Records the number of times word/tag pair was seen in training data.
  ClassicCounter<IntTaggedWord> seenCounter;
  // Counts of each tag (stored as a Label) on unknown words.
  ClassicCounter<Label> tc;
  
  // tag (Label) --> signature --> count
  HashMap<Label,ClassicCounter<String>> c;
  
  ClassicCounter<IntTaggedWord> unSeenCounter;

  HashMap<Label,ClassicCounter<String>> tagHash;

  Set<String> seenEnd;

  double indexToStartUnkCounting = 0;
  
  UnknownGTTrainer unknownGTTrainer;

  boolean useEnd, useFirst, useFirstCap, useGT;

  UnknownWordModel model;

  @Override
  public void initializeTraining(Options op, Lexicon lex, 
                                 Index<String> wordIndex, 
                                 Index<String> tagIndex, double totalTrees) {
    super.initializeTraining(op, lex, wordIndex, tagIndex, totalTrees);

    seenCounter = new ClassicCounter<IntTaggedWord>();;
    unSeenCounter = new ClassicCounter<IntTaggedWord>();
    tagHash = new HashMap<Label,ClassicCounter<String>>();
    tc = new ClassicCounter<Label>();
    c = new HashMap<Label,ClassicCounter<String>>();
    seenEnd = new HashSet<String>();

    useEnd = (op.lexOptions.unknownSuffixSize > 0 && 
              op.lexOptions.useUnknownWordSignatures > 0);
    useFirstCap = op.lexOptions.useUnknownWordSignatures > 0;
    useGT = (op.lexOptions.useUnknownWordSignatures == 0);
    useFirst = false;

    if (useFirst) {
      System.err.println("Including first letter for unknown words.");
    }
    if (useFirstCap) {
      System.err.println("Including whether first letter is capitalized for unknown words");
    }
    if (useEnd) {
      System.err.println("Classing unknown word as the average of their equivalents by identity of last " + op.lexOptions.unknownSuffixSize + " letters.");
    }
    if (useGT) {
      System.err.println("Using Good-Turing smoothing for unknown words.");
    }
    
    this.indexToStartUnkCounting = (totalTrees * op.trainOptions.fractionBeforeUnseenCounting);
    
    this.unknownGTTrainer = (useGT) ? new UnknownGTTrainer() : null;

    this.model = buildUWM();
  }
  
  public void train(TaggedWord tw, int loc, double weight) {
    if (useGT) {
      unknownGTTrainer.train(tw, weight);
    }
    
    // scan data
    String word = tw.word();
    String subString = model.getSignature(word, loc);
          
    Label tag = new Tag(tw.tag());;
    if ( ! c.containsKey(tag)) {
      c.put(tag, new ClassicCounter<String>());
    }
    c.get(tag).incrementCount(subString, weight);
    
    tc.incrementCount(tag, weight);
    
    seenEnd.add(subString);
    
    String tagStr = tw.tag();
    IntTaggedWord iW = new IntTaggedWord(word, IntTaggedWord.ANY, wordIndex, tagIndex);
    seenCounter.incrementCount(iW, weight);
    if (treesRead > indexToStartUnkCounting) {
      // start doing this once some way through trees; 
      // treesRead is 1 based counting
      if (seenCounter.getCount(iW) < 2) {
        IntTaggedWord iT = new IntTaggedWord(IntTaggedWord.ANY, tagStr, wordIndex, tagIndex);
        unSeenCounter.incrementCount(iT, weight);
        unSeenCounter.incrementCount(NULL_ITW, weight);
      }
    }
  }
  
  public UnknownWordModel finishTraining() {
    if (useGT) {
      unknownGTTrainer.finishTraining();
    }
    
    for (Label tag : c.keySet()) {
      /* outer iteration is over tags */
      ClassicCounter<String> wc = c.get(tag); // counts for words given a tag
      
      if (!tagHash.containsKey(tag)) {
        tagHash.put(tag, new ClassicCounter<String>());
      }
      
      /* the UNKNOWN sequence is assumed to be seen once in each tag */
      // This is sort of broken, but you can regard it as a Dirichlet prior.
      tc.incrementCount(tag);
      wc.setCount(unknown, 1.0);
      
      /* inner iteration is over words */
      for (String end : wc.keySet()) {
        double prob = Math.log((wc.getCount(end)) / (tc.getCount(tag)));  // p(sig|tag)
        tagHash.get(tag).setCount(end, prob);
        //if (Test.verbose)
        //EncodingPrintWriter.out.println(tag + " rewrites as " + end + " endchar with probability " + prob,encoding);
      }
    }

    return model;
  }

  protected UnknownWordModel buildUWM() {
    HashMap<String,Float> unknownGT = null;
    if (useGT) {
      unknownGT = unknownGTTrainer.unknownGT;
    }
    return new BaseUnknownWordModel(op, lex, wordIndex, tagIndex, 
                                    unSeenCounter, tagHash, 
                                    unknownGT, seenEnd);
  }
}

