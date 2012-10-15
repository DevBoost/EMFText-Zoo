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

import java.util.Iterator;
import java.util.List;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.trees.DiskTreebank;
import edu.stanford.nlp.trees.LabeledScoredTreeReaderFactory;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.Treebank;
import edu.stanford.nlp.trees.TreeNormalizer;
import edu.stanford.nlp.trees.TreeReaderFactory;
import edu.stanford.nlp.trees.TreeTransformer;
import edu.stanford.nlp.util.Filter;

public class TreeTaggedFileReader implements TaggedFileReader {
  final Treebank treebank;
  final String filename;
  final TreeReaderFactory trf;
  final TreeTransformer transformer;
  final TreeNormalizer normalizer;
  final Filter<Tree> treeFilter;

  final Iterator<Tree> treeIterator;

  Tree next = null;
  
  int numSentences = 0;

  public TreeTaggedFileReader(TaggedFileRecord record) {
    filename = record.file;
    trf = new LabeledScoredTreeReaderFactory();
    transformer = record.treeTransformer;
    normalizer = record.treeNormalizer;
    treeFilter = record.treeFilter;

    treebank = new DiskTreebank(trf, record.encoding);
    if (record.treeRange != null) {
      treebank.loadPath(filename, record.treeRange);
    } else {
      treebank.loadPath(filename);
    }

    treeIterator = treebank.iterator();
    findNext();
  }

  public Iterator<List<TaggedWord>> iterator() { return this; }

  public String filename() { return filename; }

  public boolean hasNext() { return next != null; }

  public List<TaggedWord> next() {
    Tree t = next;
    if (normalizer != null) {
      t = normalizer.normalizeWholeTree(t, t.treeFactory());
    }
    if (transformer != null) {
      t = t.transform(transformer);
    }
    findNext();
    return t.taggedYield();
  }

  /**
   * Skips ahead in the iterator to the next non-filtered tree.
   */
  private void findNext() {
    while (treeIterator.hasNext()) {
      next = treeIterator.next();
      if (treeFilter == null || treeFilter.accept(next)) {
        return;
      }
    }
    next = null;
  }

  public void remove() { throw new UnsupportedOperationException(); }
}
