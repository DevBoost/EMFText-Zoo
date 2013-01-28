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
package edu.stanford.nlp.parser.lexparser;

// Looks like the intended behavior of TestTagProjection is:
// 1) Include the basic category (everything before a '-' or '^' annotation)
// 2) Include any annotation introduced with '-'
// 3) Exclude any annotation introduced with '^'
// 4) Annotations introduced with other characters will be included or excluded
//    as determined by the previous annotation or basic category.
//
// This seems awfully haphazard :(
//
//  Roger


/** @author Dan Klein */
class TestTagProjection implements TagProjection {

  private static final long serialVersionUID = 9161675508802284114L;

  public String project(String tagStr) {
    StringBuilder sb = new StringBuilder();
    boolean good = true;
    for (int pos = 0, len = tagStr.length(); pos < len; pos++) {
      char c = tagStr.charAt(pos);
      if (c == '-') {
        good = true;
      } else if (c == '^') {
        good = false;
      }
      if (good) {
        sb.append(c);
      }
    }
    String ret = sb.toString();
    // System.err.println("TTP mapped " + tagStr + " to " + ret);
    return ret;
  }

}
