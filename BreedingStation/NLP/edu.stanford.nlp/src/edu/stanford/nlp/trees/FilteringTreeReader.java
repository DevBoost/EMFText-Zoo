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

import java.io.IOException;

import edu.stanford.nlp.util.Filter;

/**
 * A <code>FilteringTreeReader</code> filters the output of another TreeReader.
 * It applies a Filter&lt;Tree&gt; to each returned tree and only returns trees 
 * that are accepted by the Filter.  The Filter should accept trees that it 
 * wants returned.
 *
 * @author Christopher Manning
 * @version 2006/11
 */
public class FilteringTreeReader implements TreeReader {

  private TreeReader tr;
  private Filter<Tree> f;

  public FilteringTreeReader(TreeReader tr, Filter<Tree> f) {
    this.tr = tr;
    this.f = f;
  }

  /**
   * Reads a single tree.
   *
   * @return A single tree, or <code>null</code> at end of file.
   */
  public Tree readTree() throws IOException {
    Tree t;
    do {
      t = tr.readTree();
    } while (t != null && ! f.accept(t));
    return t;
  }

  /**
   * Close the Reader behind this <code>TreeReader</code>.
   */
  public void close() throws IOException {
    tr.close();
  }

}
