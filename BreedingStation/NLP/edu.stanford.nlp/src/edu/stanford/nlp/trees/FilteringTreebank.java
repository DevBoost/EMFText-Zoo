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
package edu.stanford.nlp.trees;

import java.io.File;
import java.io.FileFilter;
import java.util.Iterator;
import edu.stanford.nlp.util.Filter;

/** 
 * This class wraps another Treebank, and will vend trees that passed
 * a Filter<Tree>.
 *
 *  @author John Bauer
 */
public class FilteringTreebank extends Treebank {
  private Filter<Tree> filter;
  private Treebank treebank;

  private static final boolean VERBOSE = false;

  public FilteringTreebank(Treebank treebank, Filter<Tree> filter) {
    this.filter = filter;
    this.treebank = treebank;
  }

  /**
   * Empty a <code>Treebank</code>.
   */
  @Override
  public void clear() {
    treebank.clear();
    filter = null;
  }

  /**
   * Load trees from given path specification.  Not supported for this
   * type of treebank.
   *
   * @param path file or directory to load from
   * @param filt a FilenameFilter of files to load
   */
  @Override
  public void loadPath(File path, FileFilter filt) {
    throw new UnsupportedOperationException();
  }

  /**
   * Applies the TreeVisitor, but only to the trees that pass the
   * filter.  Applies the visitor to a copy of the tree.
   *
   * @param tv A class that can process trees.
   */
  @Override
  public void apply(TreeVisitor tv) {
    if (VERBOSE) {
      System.out.println("Applying " + tv + " to treebank");
    }
    for (Tree t : treebank) {
      if (!filter.accept(t)) {
        if (VERBOSE) System.out.println("  Skipping " + t);
        continue;
      }
      Tree tmpT = t.deepCopy();
      if (VERBOSE) System.out.println("  Applying to " + tmpT);
      tv.visitTree(tmpT);
    }
  }

  /**
   */
  @Override
  public Iterator<Tree> iterator() {
    return new FilteringTreebankIterator(treebank.iterator(), filter);
  }


  private static class FilteringTreebankIterator implements Iterator<Tree> {
    private Iterator<Tree> iter;
    private Filter<Tree> filter;

    Tree next;

    FilteringTreebankIterator (Iterator<Tree> iter, Filter<Tree> filter) {
      this.iter = iter;
      this.filter = filter;
      primeNext();
    }

    public boolean hasNext() {
      return (next != null);
    }

    public Tree next() {
      Tree answer = next;
      primeNext();
      return answer;
    }

    public void primeNext() {
      while (iter.hasNext()) {
        next = iter.next();
        if (filter.accept(next)) {
          return;
        }
      }
      next = null;
    }

    public void remove() {
      throw new UnsupportedOperationException();
    }
  }
}

