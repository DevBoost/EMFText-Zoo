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
package edu.stanford.nlp.tagger.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import edu.stanford.nlp.ling.TaggedWord;

public class TextTaggedFileReader implements TaggedFileReader {
  final BufferedReader reader;
  final String tagSeparator;
  final String filename;

  int numSentences = 0;

  List<TaggedWord> next;

  public TextTaggedFileReader(TaggedFileRecord record) {
    filename = record.file;
    try {
      reader = new BufferedReader(new InputStreamReader
                                  (new FileInputStream(filename), 
                                   record.encoding));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    tagSeparator = record.tagSeparator;

    primeNext();
  }

  public Iterator<List<TaggedWord>> iterator() { return this; }

  public String filename() { return filename; }

  public boolean hasNext() { return next != null; }

  public List<TaggedWord> next() {
    if (next == null) {
      throw new NoSuchElementException();
    }
    List<TaggedWord> thisIteration = next;
    primeNext();
    return thisIteration;
  }

  void primeNext() {
    String line;
    try {
      line = reader.readLine();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    if (line == null) {
      next = null;
      return;
    }

    ++numSentences;
    next = new ArrayList<TaggedWord>();
    StringTokenizer st = new StringTokenizer(line);
    //loop over words in a single sentence

    while (st.hasMoreTokens()) {
      String token = st.nextToken();

      int indexUnd = token.lastIndexOf(tagSeparator);
      if (indexUnd < 0) {
        throw new IllegalArgumentException("Data format error: can't find delimiter \"" + tagSeparator + "\" in word \"" + token + "\" (line " + (numSentences+1) + " of " + filename + ')');
      }
      String word = token.substring(0, indexUnd).intern();
      String tag = token.substring(indexUnd + 1).intern();
      next.add(new TaggedWord(word, tag));
    }
  }

  public void remove() { throw new UnsupportedOperationException(); }
}
