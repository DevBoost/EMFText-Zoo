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
package edu.stanford.nlp.io;

import edu.stanford.nlp.util.Pair;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Implements a file filter that examines a number in a filename to
 * determine acceptance.  This is useful for wanting to process ranges
 * of numbered files in collections where each file has some name, part
 * of which is alphabetic and constant, and part of which is numeric.
 * The test is evaluated based on the rightmost natural number found in
 * the filename string.  (It only looks in the final filename, not in other
 * components of the path.)  Number ranges are inclusive.
 * <p/>
 * This filter can select multiple discontinuous ranges based on a format
 * similar to page selection ranges in various formatting software, such as
 * "34,52-65,67,93-95".  The constructor takes a String of this sort and
 * deconstructs it into a list of ranges.  The accepted syntax is:<p>
 * ranges = range <br>
 * ranges = range "," ranges <br>
 * range = integer <br>
 * range = integer "-" integer <p>
 * Whitespace will be ignored.  If the filter constructor is passed anything
 * that is not a list of numeric ranges of this sort, including being passed
 * an empty String, then an <code>IllegalArgumentException</code> will be
 * thrown.
 *
 * @author Christopher Manning
 * @version 2003/03/31
 */
public class NumberRangesFileFilter implements FileFilter {

  private List<Pair<Integer,Integer>> ranges = new ArrayList<Pair<Integer,Integer>>();
  private boolean recursively;


  /**
   * Sets up a NumberRangesFileFilter by specifying the ranges of numbers
   * to accept, and whether to also traverse
   * folders for recursive search.
   *
   * @param ranges  The ranges of numbers to accept (see class documentation)
   * @param recurse Whether to go into subfolders
   * @throws IllegalArgumentException If the String ranges does not
   *                                  contain a suitable ranges format
   */
  public NumberRangesFileFilter(String ranges, boolean recurse) {
    recursively = recurse;
    try {
      String[] ra = ranges.split(",");
      for (String range : ra) {
        String[] one = range.split("-");
        if (one.length > 2) {
          throw new IllegalArgumentException("Constructor argument not valid list of number ranges (too many hyphens): ");
        } else {
          int low = Integer.parseInt(one[0].trim());
          int high;
          if (one.length == 2) {
            high = Integer.parseInt(one[1].trim());
          } else {
            high = low;
          }
          Pair<Integer, Integer> p = new Pair<Integer, Integer>(Integer.valueOf(low), Integer.valueOf(high));
          this.ranges.add(p);
        }
      }
    } catch (Exception e) {
      IllegalArgumentException iae = new IllegalArgumentException("Constructor argument not valid list of number ranges: " + ranges);
      iae.initCause(e);
      throw iae;
    }
  }


  /**
   * Checks whether a file satisfies the number range selection filter.
   * The test is evaluated based on the rightmost natural number found in
   * the filename string (proper, not including directories in a path).
   *
   * @param file The file
   * @return true If the file is within the ranges filtered for
   */
  public boolean accept(File file) {
    if (file.isDirectory()) {
      return recursively;
    } else {
      String filename = file.getName();
      return accept(filename);
    }
  }


  /**
   * Checks whether a String satisfies the number range selection filter.
   * The test is evaluated based on the rightmost natural number found in
   * the String.   Note that this is just evaluated on the String as given.
   * It is not trying to interpret it as a filename and to decide whether
   * the file exists, is a directory or anything like that.
   *
   * @param str The String to check for a number in
   * @return true If the String is within the ranges filtered for
   */
  public boolean accept(String str) {
    int k = str.length() - 1;
    char c = str.charAt(k);
    while (k >= 0 && !Character.isDigit(c)) {
      k--;
      if (k >= 0) {
        c = str.charAt(k);
      }
    }
    if (k < 0) {
      return false;
    }
    int j = k;
    c = str.charAt(j);
    while (j >= 0 && Character.isDigit(c)) {
      j--;
      if (j >= 0) {
        c = str.charAt(j);
      }
    }
    j++;
    k++;
    String theNumber = str.substring(j, k);
    int number = Integer.parseInt(theNumber);
    for (Pair<Integer,Integer> p : ranges) {
      int low = p.first().intValue();
      int high = p.second().intValue();
      if (number >= low && number <= high) {
        return true;
      }
    }
    return false;
  }


  @Override
  public String toString() {
    StringBuilder sb;
    if (recursively) {
      sb = new StringBuilder("recursively ");
    } else {
      sb = new StringBuilder();
    }
    for (Iterator<Pair<Integer,Integer>> it = ranges.iterator(); it.hasNext(); ) {
      Pair<Integer,Integer> p = it.next();
      int low = p.first().intValue();
      int high = p.second().intValue();
      if (low == high) {
        sb.append(low);
      } else {
        sb.append(low);
        sb.append('-');
        sb.append(high);
      }
      if (it.hasNext()) {
        sb.append(',');
      }
    }
    return sb.toString();
  }

}
