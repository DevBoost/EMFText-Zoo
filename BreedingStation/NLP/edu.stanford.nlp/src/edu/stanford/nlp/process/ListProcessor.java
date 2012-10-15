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


import java.util.List;

/**
 * An interface for things that operate on a List.  This is seen as
 * a lighter weight and more general interface than the Processor interface
 * for documents.  IN and OUT are the type of the objects in the List.
 * The <code>process</code> method acts on a List of IN and produces a List
 * of OUT.
 *
 * @author Teg Grenager
 */
public interface ListProcessor<IN,OUT> {

  /**
   * Take a List (including a Sentence) of input, and return a
   * List that has been processed in some way.
   */
  public List<OUT> process(List<? extends IN> list);

}
