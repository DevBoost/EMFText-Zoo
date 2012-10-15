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

import edu.stanford.nlp.io.ExtensionFileFilter;

import java.io.File;
import java.io.FileFilter;

/**
 * The <code>FilePathProcessor</code> traverses a directory structure and
 * applies the <code>processFile</code> method to files meeting some
 * criterion.  It is implemented as static methods, not as an extension of
 * <code>File</code>.
 * <p>
 * <i>Note:</i> This is used in our old code in ling/trees, but newer code
 * should probably use io.FileSequentialCollection
 * @author Christopher Manning
 */
public class FilePathProcessor {

  private FilePathProcessor() {
  }


  /**
   * Apply a method to the files under a given directory and
   * perhaps its subdirectories.
   *
   * @param pathStr     file or directory to load from as a String
   * @param suffix      suffix (normally "File extension") of files to load
   * @param recursively true means descend into subdirectories as well
   * @param processor   The <code>FileProcessor</code> to apply to each
   *                    <code>File</code>
   */
  public static void processPath(String pathStr, String suffix, boolean recursively, FileProcessor processor) {
    processPath(new File(pathStr), new ExtensionFileFilter(suffix, recursively), processor);
  }


  /**
   * Apply a method to the files under a given directory and
   * perhaps its subdirectories.
   *
   * @param path        file or directory to load from
   * @param suffix      suffix (normally "File extension") of files to load
   * @param recursively true means descend into subdirectories as well
   * @param processor   The <code>FileProcessor</code> to apply to each
   *                    <code>File</code>
   */
  public static void processPath(File path, String suffix, boolean recursively, FileProcessor processor) {
    processPath(path, new ExtensionFileFilter(suffix, recursively), processor);
  }


  /**
   * Apply a function to the files under a given directory and
   * perhaps its subdirectories.  If the path is a directory then only
   * files within the directory (perhaps recursively) that satisfy the
   * filter are processed.  If the <code>path</code>is a file, then
   * that file is processed regardless of whether it satisfies the
   * filter.  (This semantics was adopted, since otherwise there was no
   * easy way to go through all the files in a directory without
   * descending recursively via the specification of a
   * <code>FileFilter</code>.)
   *
   * @param path      file or directory to load from
   * @param filter    a FileFilter of files to load.  The filter may be null,
   *     and then all files are processed.
   * @param processor The <code>FileProcessor</code> to apply to each
   *                  <code>File</code>
   */
  public static void processPath(File path, FileFilter filter, FileProcessor processor) {
    if (path.isDirectory()) {
      // if path is a directory, look into it
      File[] directoryListing = path.listFiles(filter);
      if (directoryListing == null) {
        throw new IllegalArgumentException("Directory access problem for: " + path);
      }
      for (File file : directoryListing) {
        processPath(file, filter, processor);
      }
    } else {
      // it's already passed the filter or was uniquely specified
      // if (filter.accept(path))
      processor.processFile(path);
    }
  }

}
