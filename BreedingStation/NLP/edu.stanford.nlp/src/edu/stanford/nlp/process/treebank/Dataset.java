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
package edu.stanford.nlp.process.treebank;

import java.util.List;
import java.util.Properties;

import edu.stanford.nlp.process.treebank.ConfigParser;
import edu.stanford.nlp.process.treebank.TreebankPreprocessor;

/**
 * A generic interface loading, processing, and writing a data set. Classes
 * that implement this interface may be specified in the configuration file
 * using the <code>TYPE</code> parameter. {@link TreebankPreprocessor} will
 * then call {@link #setOptions}, {@link #build} and {@link #getFilenames()}
 * in that order.
 * 
 * @author Spence Green
 *
 */
public interface Dataset {

  public enum Encoding {Buckwalter,UTF8};
  
  /**
   * Sets options for a dataset.
   * 
   * @param opts A map from parameter types defined in {@link ConfigParser} to
   * values
   * @return true if opts contains all required options. false, otherwise.
   */
  public boolean setOptions(Properties opts);
  
  /**
   * Generic method for loading, processing, and writing a dataset.
   */
  public void build();
  
  /**
   * Returns the filenames written by {@link #build()}.
   * 
   * @return A collection of filenames
   */
  public List<String> getFilenames();  
}
