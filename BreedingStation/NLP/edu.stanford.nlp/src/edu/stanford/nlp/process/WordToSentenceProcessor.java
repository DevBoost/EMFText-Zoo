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
package edu.stanford.nlp.process;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.stanford.nlp.io.EncodingPrintWriter;
import edu.stanford.nlp.ling.Document;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.util.CoreMap;
import edu.stanford.nlp.util.Generics;

// todo [cdm Feb 2012]: Rewrite the Set's as List's since while conceptually
// sets, we just don't need to be hashing things here!

/**
 * Transforms a Document of Words into a Document of Sentences by grouping the
 * Words.  The word stream is assumed to already be adequately tokenized,
 * and this class just divides the list into sentences, perhaps discarding
 * some separator tokens based on the setting of the following three sets:
 * <ul>
 * <li>sentenceBoundaryTokens are tokens that are left in a sentence, but are
 * to be regarded as ending a sentence.  A canonical example is a period.
 * If two of these follow each other, the second will be a sentence
 * consisting of only the sentenceBoundaryToken.
 * <li>sentenceBoundaryFollowers are tokens that are left in a sentence, and
 * which can follow a sentenceBoundaryToken while still belonging to
 * the previous sentence.  They cannot begin a sentence (except at the
 * beginning of a document).  A canonical example is a close parenthesis
 * ')'.
 * <li>sentenceBoundaryToDiscard are tokens which separate sentences and
 * which should be thrown away.  In web documents, a typical example would
 * be a '{@code <p>}' tag.  If two of these follow each other, they are
 * coalesced: no empty Sentence is output.  The end-of-file is not
 * represented in this Set, but the code behaves as if it were a member.
 * <li>sentenceRegionBeginPattern A regular expression for marking the start
 * of a sentence region.  Not included in the sentence.
 * <li>sentenceRegionEndPattern A regular expression for marking the end
 * of a sentence region.  Not included in the sentence.
 * </ul>
 * See DocumentPreprocessor for a class with a main method that will call this
 * and cut a text file up into sentences.
 *
 * @author Joseph Smarr (jsmarr@stanford.edu)
 * @author Christopher Manning
 * @author Teg Grenager (grenager@stanford.edu)
 * @author Sarah Spikes (sdspikes@cs.stanford.edu) (Templatization)
 *
 * @param <IN> The type of the tokens in the sentences
 */
public class WordToSentenceProcessor<IN> implements ListProcessor<IN, List<IN>> {

  private static final boolean DEBUG = false;

  /**
   * Regex for tokens (Strings) that qualify as sentence-final tokens.
   */
  private final Pattern sentenceBoundaryTokenPattern;

  /**
   * Set of tokens (Strings) that qualify as tokens that can follow
   * what normally counts as an end of sentence token, and which are
   * attributed to the preceding sentence.  For example ")" coming after
   * a period.
   */
  private final Set<String> sentenceBoundaryFollowers;

  /**
   * List of regex Pattern that are sentence boundaries to be discarded.
   */
  private List<Pattern> sentenceBoundaryToDiscard;

  private final Pattern sentenceRegionBeginPattern;

  private final Pattern sentenceRegionEndPattern;

  private boolean isOneSentence;


  public void setSentenceBoundaryToDiscard(Set<String> regexSet) {
    sentenceBoundaryToDiscard = new ArrayList<Pattern>(regexSet.size());
    for (String s: regexSet) {
      sentenceBoundaryToDiscard.add(Pattern.compile(Pattern.quote(s)));
    }
  }

  public boolean isOneSentence() {
    return isOneSentence;
  }

  public void setOneSentence(boolean oneSentence) {
    isOneSentence = oneSentence;
  }

  public void addHtmlSentenceBoundaryToDiscard(Set<String> set) {
    if (sentenceBoundaryToDiscard == null) {
      sentenceBoundaryToDiscard = new ArrayList<Pattern>();
    }
    for (String s: set) {
      sentenceBoundaryToDiscard.add(Pattern.compile("<\\s*/?\\s*" + s + "\\s*/?\\s*>", Pattern.CASE_INSENSITIVE));
      sentenceBoundaryToDiscard.add(Pattern.compile("<\\s*" + s + "\\s+[^>]+>", Pattern.CASE_INSENSITIVE));
    }
  }

  private boolean matchesSentenceBoundaryToDiscard(String word) {
    for(Pattern p: sentenceBoundaryToDiscard){
      Matcher m = p.matcher(word);
      if(m.matches()){
        return true;
      }
    }
    return false;
  }

  public List<List<IN>> process(List<? extends IN> words) {
    if (isOneSentence) {
      List<List<IN>> sentences = Generics.newArrayList();
      sentences.add(new ArrayList<IN>(words));
      return sentences;
    } else {
      return wordsToSentences(words);
    }
  }

  /**
   * Returns a List of Lists where each element is built from a run
   * of Words in the input Document. Specifically, reads through each word in
   * the input document and breaks off a sentence after finding a valid
   * sentence boundary token or end of file.
   * Note that for this to work, the words in the
   * input document must have been tokenized with a tokenizer that makes
   * sentence boundary tokens their own tokens (e.g., {@link PTBTokenizer}).
   *
   * @param words A list of already tokenized words (must implement HasWord or be a String)
   * @return A list of Sentence
   * @see #WordToSentenceProcessor(String, Set, Set, Pattern, Pattern)
   */
  public List<List<IN>> wordsToSentences(List<? extends IN> words) {
    List<List<IN>> sentences = Generics.newArrayList();
    List<IN> currentSentence = null;
    List<IN> lastSentence = null;
    boolean insideRegion = false;
    for (IN o: words) {
      String word;
      if (o instanceof HasWord) {
        HasWord h = (HasWord) o;
        word = h.word();
      } else if (o instanceof String) {
        word = (String) o;
      } else if (o instanceof CoreMap) {
        word = ((CoreMap)o).get(CoreAnnotations.TextAnnotation.class);
      } else {
        throw new RuntimeException("Expected token to be either Word or String.");
      }

      boolean forcedEnd = false;
      if (o instanceof CoreMap) {
        Boolean forcedEndValue =
          ((CoreMap)o).get(CoreAnnotations.ForcedSentenceEndAnnotation.class);
        if (forcedEndValue != null)
          forcedEnd = forcedEndValue;
      }

      if (DEBUG) {
        EncodingPrintWriter.err.println("Word is " + word, "UTF-8");
      }
      if (currentSentence == null) {
        currentSentence = new ArrayList<IN>();
      }
      if (sentenceRegionBeginPattern != null && ! insideRegion) {
        if (sentenceRegionBeginPattern.matcher(word).matches()) {
          insideRegion = true;
        }
        if (DEBUG) {
          System.err.println("  outside region");
        }
        continue;
      }
      if (sentenceBoundaryFollowers.contains(word) && lastSentence != null && currentSentence.isEmpty()) {
        lastSentence.add(o);
        if (DEBUG) {
          System.err.println("  added to last");
        }
      } else {
        boolean newSent = false;
        if (matchesSentenceBoundaryToDiscard(word)) {
          newSent = true;
        } else if (sentenceRegionEndPattern != null && sentenceRegionEndPattern.matcher(word).matches()) {
          insideRegion = false;
          newSent = true;
        } else if (sentenceBoundaryTokenPattern.matcher(word).matches()) {
          currentSentence.add(o);
          if (DEBUG) {
            System.err.println("  is sentence boundary; added to current");
          }
          newSent = true;
        } else if (forcedEnd) {
          currentSentence.add(o);
          newSent = true;
          if (DEBUG) {
            System.err.println("  annotated to be the end of a sentence");
          }
        } else {
          currentSentence.add(o);
          if (DEBUG) {
            System.err.println("  added to current");
          }
        }
        if (newSent && currentSentence.size() > 0) {
          if (DEBUG) {
            System.err.println("  beginning new sentence");
          }
          sentences.add(currentSentence);
          // adds this sentence now that it's complete
          lastSentence = currentSentence;
          currentSentence = null; // clears the current sentence
        }
      }
    }

    // add any words at the end, even if there isn't a sentence
    // terminator at the end of file
    if (currentSentence != null && currentSentence.size() > 0) {
      sentences.add(currentSentence); // adds last sentence
    }
    return sentences;
  }



  public <L, F> Document<L, F, List<IN>> processDocument(Document<L, F, IN> in) {
    Document<L, F, List<IN>> doc = in.blankDocument();
    doc.addAll(process(in));
    return doc;
  }

  /**
   * Create a <code>WordToSentenceProcessor</code> using a sensible default
   * list of tokens to split on.  The default set is: {".","?","!"} and
   * any combination of ! or ?, as in !!!?!?!?!!!?!!?!!!
   */
  public WordToSentenceProcessor() {
    this("\\.|[!?]+");
  }

  /**
   * Flexibly set the set of acceptable sentence boundary tokens, but with
   * a default set of allowed boundary following tokens (based on English
   * and Penn Treebank encoding).
   * The allowed set of boundary followers is:
   * {")","]","\"","\'", "''", "-RRB-", "-RSB-", "-RCB-"}.
   *
   * @param boundaryTokenRegex The set of boundary tokens
   */
  public WordToSentenceProcessor(String boundaryTokenRegex) {
    this(boundaryTokenRegex, Generics.newHashSet(Arrays.asList(")", "]", "\"", "\'", "''", "-RRB-", "-RSB-", "-RCB-")));
  }

  /**
   * Flexibly set the set of acceptable sentence boundary tokens and
   * also the set of tokens commonly following sentence boundaries, and
   * the set of discarded separator tokens.
   * The default set of discarded separator tokens is: {"\n"}.
   */
  public WordToSentenceProcessor(String boundaryTokenRegex, Set<String> boundaryFollowers) {
    this(boundaryTokenRegex, boundaryFollowers, Collections.singleton("\n"));
  }


  /**
   * Flexibly set the set of acceptable sentence boundary tokens,
   * the set of tokens commonly following sentence boundaries, and also
   * the set of tokens that are sentences boundaries that should be
   * discarded.
   */
  public WordToSentenceProcessor(String boundaryTokenRegex,
                                 Set<String> boundaryFollowers,
                                 Set<String> boundaryToDiscard) {
    this(boundaryTokenRegex, boundaryFollowers, boundaryToDiscard, null, null);
  }

  public WordToSentenceProcessor(Pattern regionBeginPattern, Pattern regionEndPattern) {
    this("", Collections.<String>emptySet(),
         Collections.<String>emptySet(), regionBeginPattern, regionEndPattern);
  }

  /**
   * Flexibly set a pattern that matches acceptable sentence boundaries,
   * the set of tokens commonly following sentence boundaries, and also
   * the set of tokens that are sentence boundaries that should be discarded.
   * This is private because it is a dangerous constructor. It's not clear what the semantics
   * should be if there are both boundary token sets, and patterns to match.
   */
  private WordToSentenceProcessor(String boundaryTokenRegex, Set<String> boundaryFollowers, Set<String> boundaryToDiscard, Pattern regionBeginPattern, Pattern regionEndPattern) {
    sentenceBoundaryTokenPattern = Pattern.compile(boundaryTokenRegex);
    sentenceBoundaryFollowers = boundaryFollowers;
    setSentenceBoundaryToDiscard(boundaryToDiscard);
    sentenceRegionBeginPattern = regionBeginPattern;
    sentenceRegionEndPattern = regionEndPattern;
    if (DEBUG) {
      EncodingPrintWriter.err.println("WordToSentenceProcessor: boundaryTokens=" + boundaryTokenRegex, "UTF-8");
      EncodingPrintWriter.err.println("  boundaryFollowers=" + boundaryFollowers, "UTF-8");
      EncodingPrintWriter.err.println("  boundaryToDiscard=" + boundaryToDiscard, "UTF-8");
    }
  }

}
