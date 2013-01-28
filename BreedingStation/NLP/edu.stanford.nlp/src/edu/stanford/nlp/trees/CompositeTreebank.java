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
import java.util.Collection;

/**
 * @author Galen Andrew
 */
public class CompositeTreebank extends Treebank {
  private Treebank t1;
  private Treebank t2;

  public CompositeTreebank(Treebank t1, Treebank t2) {
    this.t1 = t1;
    this.t2 = t2;
  }

  @Override
  public void clear() {
    t1.clear();
    t2.clear();
  }

  @Override
  public void loadPath(File path, FileFilter filt) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void apply(TreeVisitor tp) {
    for (Tree tree : this) {
      tp.visitTree(tree);
    }
  }


  @Override
  public Iterator<Tree> iterator() {
    return new CompositeTreebankIterator(t1, t2);
  }


  private static class CompositeTreebankIterator implements Iterator<Tree> {

    private final Iterator<Tree> it1;
    private final Iterator<Tree> it2;

    public CompositeTreebankIterator(Collection<Tree> c1, Collection<Tree> c2) {
      it1 = c1.iterator();
      it2 = c2.iterator();
    }

    public boolean hasNext() {
      return (it1.hasNext() || it2.hasNext());
    }

    public Tree next() {
      Tree tree = it1.hasNext() ? it1.next() : it2.next();
      return tree;
    }

    public void remove() {
      throw new UnsupportedOperationException();
    }

  } // end static class CompositeTreebankIterator

}
