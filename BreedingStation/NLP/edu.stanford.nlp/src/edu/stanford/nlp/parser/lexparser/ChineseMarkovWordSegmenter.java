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

import java.util.*;

import edu.stanford.nlp.ling.*;
import edu.stanford.nlp.math.ArrayMath;
import edu.stanford.nlp.stats.ClassicCounter;
import edu.stanford.nlp.stats.Distribution;
import edu.stanford.nlp.stats.GeneralizedCounter;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.Treebank;
import edu.stanford.nlp.util.ErasureUtils;
import edu.stanford.nlp.util.Index;
import edu.stanford.nlp.process.WordSegmenter;


/**
 * Performs word segmentation with a hierarchical markov model over POS
 * and over characters given POS.
 *
 * @author Galen Andrew
 */
public class ChineseMarkovWordSegmenter implements WordSegmenter {

  private Distribution<String> initialPOSDist;
  private Map<String, Distribution> markovPOSDists;
  private ChineseCharacterBasedLexicon lex;
  private Set<String> POSes;

  private final Index<String> wordIndex;
  private final Index<String> tagIndex;

  public ChineseMarkovWordSegmenter(ChineseCharacterBasedLexicon lex, 
                                    Index<String> wordIndex,
                                    Index<String> tagIndex) {
    this.lex = lex;
    this.wordIndex = wordIndex;
    this.tagIndex = tagIndex;
  }

  public ChineseMarkovWordSegmenter(ChineseTreebankParserParams params,
                                    Index<String> wordIndex,
                                    Index<String> tagIndex) {
    lex = new ChineseCharacterBasedLexicon(params, wordIndex, tagIndex);
    this.wordIndex = wordIndex;
    this.tagIndex = tagIndex;
  }

  // Only used at training time
  private transient ClassicCounter<String> initial;
  private transient GeneralizedCounter ruleCounter;

  @Override
  public void initializeTraining(double numTrees) {
    lex.initializeTraining(numTrees);

    this.initial = new ClassicCounter<String>();
    this.ruleCounter = new GeneralizedCounter(2);
  }

  @Override
  public void train(Collection<Tree> trees) {
    for (Tree tree : trees) {
      train(tree);
    }
  }

  @Override
  public void train(Tree tree) {
    train(tree.taggedYield());
  }

  @Override
  public void train(List<TaggedWord> sentence) {
    lex.train(sentence, 1.0);
    
    String last = null;
    for (TaggedWord tagLabel : sentence) {
      String tag = tagLabel.tag();
      tagIndex.add(tag);
      if (last == null) {
        initial.incrementCount(tag);
      } else {
        ruleCounter.incrementCount2D(last, tag);
      }
      last = tag;
    }
  }

  @Override
  public void finishTraining() {
    lex.finishTraining();

    int numTags = tagIndex.size();
    POSes = new HashSet<String>(tagIndex.objectsList());
    initialPOSDist = Distribution.laplaceSmoothedDistribution(initial, numTags, 0.5);
    markovPOSDists = new HashMap<String, Distribution>();
    Set entries = ruleCounter.lowestLevelCounterEntrySet();
    for (Iterator iter = entries.iterator(); iter.hasNext();) {
      Map.Entry entry = (Map.Entry) iter.next();
      //      Map.Entry<List<String>, Counter> entry = (Map.Entry<List<String>, Counter>) iter.next();
      Distribution d = Distribution.laplaceSmoothedDistribution((ClassicCounter) entry.getValue(), numTags, 0.5);
      markovPOSDists.put(((List<String>) entry.getKey()).get(0), d);
    }
  }

  public List<HasWord> segment(String s) {
    return segmentWordsWithMarkov(s);
  }

  // CDM 2007: I wonder what this does differently from segmentWordsWithMarkov???
  private ArrayList<TaggedWord> basicSegmentWords(String s) {
    int length = s.length();
    //    Set<String> POSes = (Set<String>) POSDistribution.keySet();  // 1.5
    // best score of span
    double[][] scores = new double[length][length + 1];
    // best (last index of) first word for this span
    int[][] splitBacktrace = new int[length][length + 1];
    // best tag for word over this span
    int[][] POSbacktrace = new int[length][length + 1];
    for (int i = 0; i < length; i++) {
      Arrays.fill(scores[i], Double.NEGATIVE_INFINITY);
    }
    // first fill in word probabilities
    for (int diff = 1; diff <= 10; diff++) {
      for (int start = 0; start + diff <= length; start++) {
        int end = start + diff;
        StringBuilder wordBuf = new StringBuilder();
        for (int pos = start; pos < end; pos++) {
          wordBuf.append(s.charAt(pos));
        }
        String word = wordBuf.toString();
        //        for (String tag : POSes) {  // 1.5
        for (Iterator<String> iter = POSes.iterator(); iter.hasNext();) {
          String tag = iter.next();
          IntTaggedWord itw = new IntTaggedWord(word, tag, wordIndex, tagIndex);
          double newScore = lex.score(itw, 0, word, null) + Math.log(lex.getPOSDistribution().probabilityOf(tag));
          if (newScore > scores[start][end]) {
            scores[start][end] = newScore;
            splitBacktrace[start][end] = end;
            POSbacktrace[start][end] = itw.tag();
          }
        }
      }
    }
    // now fill in word combination probabilities
    for (int diff = 2; diff <= length; diff++) {
      for (int start = 0; start + diff <= length; start++) {
        int end = start + diff;
        for (int split = start + 1; split < end && split - start <= 10; split++) {
          if (splitBacktrace[start][split] != split) {
            continue; // only consider words on left
          }
          double newScore = scores[start][split] + scores[split][end];
          if (newScore > scores[start][end]) {
            scores[start][end] = newScore;
            splitBacktrace[start][end] = split;
          }
        }
      }
    }

    List<TaggedWord> words = new ArrayList<TaggedWord>();
    int start = 0;
    while (start < length) {
      int end = splitBacktrace[start][length];
      StringBuilder wordBuf = new StringBuilder();
      for (int pos = start; pos < end; pos++) {
        wordBuf.append(s.charAt(pos));
      }
      String word = wordBuf.toString();
      String tag = tagIndex.get(POSbacktrace[start][end]);

      words.add(new TaggedWord(word, tag));
      start = end;
    }

    return new ArrayList<TaggedWord>(words);
  }

  /** Do max language model markov segmentation.
   *  Note that this algorithm inherently tags words as it goes, but that
   *  we throw away the tags in the final result so that the segmented words
   *  are untagged.  (Note: for a couple of years till Aug 2007, a tagged
   *  result was returned, but this messed up the parser, because it could
   *  use no tagging but the given tagging, which often wasn't very good.
   *  Or in particular it was a subcategorized tagging which never worked
   *  with the current forceTags option which assumes that gold taggings are
   *  inherently basic taggings.)
   *
   *  @param s A String to segment
   *  @return The list of segmented words.
   */
  private ArrayList<HasWord> segmentWordsWithMarkov(String s) {
    int length = s.length();
    //    Set<String> POSes = (Set<String>) POSDistribution.keySet();  // 1.5
    int numTags = POSes.size();
    // score of span with initial word of this tag
    double[][][] scores = new double[length][length + 1][numTags];
    // best (length of) first word for this span with this tag
    int[][][] splitBacktrace = new int[length][length + 1][numTags];
    // best tag for second word over this span, if first is this tag
    int[][][] POSbacktrace = new int[length][length + 1][numTags];
    for (int i = 0; i < length; i++) {
      for (int j = 0; j < length + 1; j++) {
        Arrays.fill(scores[i][j], Double.NEGATIVE_INFINITY);
      }
    }
    // first fill in word probabilities
    for (int diff = 1; diff <= 10; diff++) {
      for (int start = 0; start + diff <= length; start++) {
        int end = start + diff;
        StringBuilder wordBuf = new StringBuilder();
        for (int pos = start; pos < end; pos++) {
          wordBuf.append(s.charAt(pos));
        }
        String word = wordBuf.toString();
        for (String tag : POSes) {
          IntTaggedWord itw = new IntTaggedWord(word, tag, wordIndex, tagIndex);
          double score = lex.score(itw, 0, word, null);
          if (start == 0) {
            score += Math.log(initialPOSDist.probabilityOf(tag));
          }
          scores[start][end][itw.tag()] = score;
          splitBacktrace[start][end][itw.tag()] = end;
        }
      }
    }
    // now fill in word combination probabilities
    for (int diff = 2; diff <= length; diff++) {
      for (int start = 0; start + diff <= length; start++) {
        int end = start + diff;
        for (int split = start + 1; split < end && split - start <= 10; split++) {
          for (String tag : POSes) {
            int tagNum = tagIndex.indexOf(tag, true);
            if (splitBacktrace[start][split][tagNum] != split) {
              continue;
            }
            Distribution<String> rTagDist = markovPOSDists.get(tag);
            if (rTagDist == null) {
              continue; // this happens with "*" POS
            }
            for (String rTag : POSes) {
              int rTagNum = tagIndex.indexOf(rTag, true);
              double newScore = scores[start][split][tagNum] + scores[split][end][rTagNum] + Math.log(rTagDist.probabilityOf(rTag));
              if (newScore > scores[start][end][tagNum]) {
                scores[start][end][tagNum] = newScore;
                splitBacktrace[start][end][tagNum] = split;
                POSbacktrace[start][end][tagNum] = rTagNum;
              }
            }
          }
        }
      }
    }
    int nextPOS = ArrayMath.argmax(scores[0][length]);
    ArrayList<HasWord> words = new ArrayList<HasWord>();

    int start = 0;
    while (start < length) {
      int split = splitBacktrace[start][length][nextPOS];
      StringBuilder wordBuf = new StringBuilder();
      for (int i = start; i < split; i++) {
        wordBuf.append(s.charAt(i));
      }
      String word = wordBuf.toString();
      // String tag = tagIndex.get(nextPOS);
      // words.add(new TaggedWord(word, tag));
      words.add(new Word(word));
      if (split < length) {
        nextPOS = POSbacktrace[start][length][nextPOS];
      }
      start = split;
    }

    return words;
  }

  private Distribution<Integer> getSegmentedWordLengthDistribution(Treebank tb) {
    // CharacterLevelTagExtender ext = new CharacterLevelTagExtender();
    ClassicCounter<Integer> c = new ClassicCounter<Integer>();
    for (Iterator iterator = tb.iterator(); iterator.hasNext();) {
      Tree gold = (Tree) iterator.next();
      StringBuilder goldChars = new StringBuilder();
      ArrayList goldYield = gold.yield();
      for (Iterator wordIter = goldYield.iterator(); wordIter.hasNext();) {
        Word word = (Word) wordIter.next();
        goldChars.append(word);
      }
      List<HasWord> ourWords = segment(goldChars.toString());
      for (int i = 0; i < ourWords.size(); i++) {
        c.incrementCount(Integer.valueOf(ourWords.get(i).word().length()));
      }
    }
    return Distribution.getDistribution(c);
  }

  public void loadSegmenter(String filename) {
    throw new UnsupportedOperationException();
  }

  private static final long serialVersionUID = 1559606198270645508L;
}
