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


import java.util.ArrayList;
import java.util.List;

import edu.stanford.nlp.ling.Document;

/**
 * Class AbstractListProcessor
 *
 * @author Teg Grenager
 * @author Sarah Spikes (sdspikes@cs.stanford.edu) (Templatization)
 *
 * @param <IN> The type of the input document tokens
 * @param <OUT> The type of the output document tokens
 * @param <L> The type of the labels (for the document for classification)
 * @param <F> The type of the features (for the document for classification)
 */
public abstract class AbstractListProcessor<IN,OUT,L,F> implements ListProcessor<IN,OUT>, DocumentProcessor<IN,OUT, L, F> {

  public AbstractListProcessor() {
  }

  public Document<L, F, OUT> processDocument(Document<L, F, IN> in) {
    Document<L, F, OUT> doc = in.blankDocument();
    doc.addAll(process(in));
    return doc;
  }

  /** Process a list of lists of tokens.  For example this might be a
   *  list of lists of words.
   *
   * @param lists a List of objects of type List
   * @return a List of objects of type List, each of which has been processed.
   */
  public List<List<OUT>> processLists(List<List<IN>> lists) {
    List<List<OUT>> result = new ArrayList<List<OUT>>(lists.size());
    for (List<IN> list : lists) {
      List<OUT> outList = process(list);
      result.add(outList);
    }
    return result;
  }

}
