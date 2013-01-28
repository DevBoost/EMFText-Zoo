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

import java.io.Reader;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.objectbank.TokenizerFactory;
import edu.stanford.nlp.process.WordSegmenter;

/** A tokenizer that works by calling a WordSegmenter.
 *  This is used for Chinese and Arabic.
 *
 *  @author Galen Andrew
 *  @author Spence Green
 */
public class WordSegmentingTokenizer extends AbstractTokenizer<HasWord> {
  
  private Iterator<HasWord> wordIter;
  private Tokenizer<CoreLabel> tok;
  private WordSegmenter wordSegmenter;

  public WordSegmentingTokenizer(WordSegmenter segmenter, Reader r) {
    this(segmenter, WhitespaceTokenizer.newCoreLabelWhitespaceTokenizer(r));
  }
  
  public WordSegmentingTokenizer(WordSegmenter segmenter, Tokenizer<CoreLabel> tokenizer) {
    wordSegmenter = segmenter;
    tok = tokenizer;    
  }
  
  @Override
  protected HasWord getNext() {
    while (wordIter == null || ! wordIter.hasNext()) {
      if ( ! tok.hasNext()) {
        return null;
      }
      String s = tok.next().word();
      if (s == null) {
        return null;
      }
      List<HasWord> se = wordSegmenter.segment(s);
      wordIter = se.iterator();
    }
    return wordIter.next();
  }

  public static TokenizerFactory<HasWord> factory(WordSegmenter wordSegmenter) {
    return new WordSegmentingTokenizerFactory(wordSegmenter);
  }

  private static class WordSegmentingTokenizerFactory implements TokenizerFactory<HasWord>, Serializable {
    private static final long serialVersionUID = -4697961121607489828L;

    private WordSegmenter segmenter;

    public WordSegmentingTokenizerFactory(WordSegmenter wordSegmenter) {
      segmenter = wordSegmenter;
    }

    public Iterator<HasWord> getIterator(Reader r) {
      return getTokenizer(r);
    }

    public Tokenizer<HasWord> getTokenizer(Reader r) {
      return new WordSegmentingTokenizer(segmenter, r);
    }

    public Tokenizer<HasWord> getTokenizer(Reader r, String extraOptions) {
      setOptions(extraOptions);
      return getTokenizer(r);
    }

    public void setOptions(String options) {}
  }
}
