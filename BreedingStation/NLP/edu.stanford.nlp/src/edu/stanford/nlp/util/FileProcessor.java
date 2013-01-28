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
package edu.stanford.nlp.util;

import java.io.File;

/**
 * Interface for a Visitor pattern for Files.
 * This interface is used by some existing code, but new code should
 * probably use FileArrayList or FileSequentialCollection, which fit
 * better with the Collections orientation of recent Java releases.
 *
 * @author Christopher Manning
 */
public interface FileProcessor {

  /**
   * Apply this predicate to a <code>File</code>.  This method can
   * assume the <code>file</code> is a file and not a directory.
   *
   * @see FilePathProcessor for traversing directories
   */
  public void processFile(File file);

}
