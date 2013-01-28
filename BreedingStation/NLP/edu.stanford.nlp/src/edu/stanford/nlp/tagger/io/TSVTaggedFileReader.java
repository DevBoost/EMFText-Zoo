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
import edu.stanford.nlp.ling.TaggedWord;

public class TSVTaggedFileReader implements TaggedFileReader {
  final BufferedReader reader;
  final String filename;
  final int wordColumn, tagColumn;
  List<TaggedWord> next = null;
  int linesRead = 0;

  static final int DEFAULT_WORD_COLUMN = 0;
  static final int DEFAULT_TAG_COLUMN = 1;

  public TSVTaggedFileReader(TaggedFileRecord record) {
    filename = record.file;
    try {
      reader = new BufferedReader(new InputStreamReader
                                  (new FileInputStream(filename), 
                                   record.encoding));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    wordColumn = ((record.wordColumn == null) ? 
                  DEFAULT_WORD_COLUMN : record.wordColumn);
    tagColumn = ((record.tagColumn == null) ? 
                 DEFAULT_TAG_COLUMN : record.tagColumn);
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
    // eat all blank lines until we hit the next block of text
    String line = "";
    while (line.trim().equals("")) {
      try {
        line = reader.readLine();
        ++linesRead;
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
      if (line == null) {
        next = null;
        return;
      }
    }
    // we hit something with text, so now we read one line at a time
    // until we hit the next blank line.  the next blank line (or EOF)
    // ends the sentence.
    next = new ArrayList<TaggedWord>();
    while (line != null && !line.trim().equals("")) {
      String[] pieces = line.split("\t");
      if (pieces.length <= wordColumn || pieces.length <= wordColumn) {
        throw new IllegalArgumentException("File " + filename + " line #" + 
                                           linesRead + " too short");
      }
      String word = pieces[wordColumn];
      String tag = pieces[tagColumn];
      next.add(new TaggedWord(word, tag));
      try {
        line = reader.readLine();
        ++linesRead;
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  }

  public void remove() { throw new UnsupportedOperationException(); }
}
