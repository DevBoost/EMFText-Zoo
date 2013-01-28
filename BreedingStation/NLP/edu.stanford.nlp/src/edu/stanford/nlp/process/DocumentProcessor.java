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
import edu.stanford.nlp.ling.Document;

/**
 * Top-level interface for transforming Documents.
 *
 * @author Sepandar Kamvar (sdkamvar@stanford.edu)
 * @see #processDocument
 * @author Sarah Spikes (sdspikes@cs.stanford.edu) (Templatization)
 *
 * @param <L> The type of the labels 
 */
public interface DocumentProcessor<IN,OUT, L, F> {

  /**
   * Converts a Document to a different Document, by transforming
   * or filtering the original Document. The general contract of this method
   * is to not modify the <code>in</code> Document in any way, and to
   * preserve the metadata of the <code>in</code> Document in the
   * returned Document.
   *
   * @see FunctionProcessor
   */
  public Document<L, F, OUT> processDocument(Document<L, F, IN> in);

}
