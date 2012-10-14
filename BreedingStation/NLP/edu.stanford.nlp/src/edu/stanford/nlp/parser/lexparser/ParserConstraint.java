/*******************************************************************************
 * Copyright (C) 2012
 * Jan Reimann (TU Dresden, Software Technology Group)
 * Mirko Seifert (DevBoost GmbH)
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

import java.io.Serializable;
import java.util.regex.Pattern;



/** 
 * A Constraint represents a restriction on possible parse trees to
 * consider.  It says that a parse cannot be postulated that would
 * contradict having a constituent from position start to end, and
 * that any constituent postulated with this span must match the
 * regular expression given by state.  Note, however, that it does not
 * strictly guarantee that such a constituent exists in a returned
 * parse.
 * <br>
 * The words in constraint bounds are counted starting from 0.
 * Furthermore, the end number is not included in the constraint.
 * For example, a constraint covering the first two words of a
 * sentence has a start of 0 and an end of 2.
 * <br>
 * state must successfully match states used internal to the parser,
 * not just the final states, so the pattern "NP" will not match
 * anything.  Better is "NP.*".  Note that this does run the risk of
 * matching states with the same prefix.  For example, there is SBAR
 * and SBARQ, so "SBAR.*" could have unexpected results.  The states
 * used internal to the parser extend the state name with
 * non-alphanumeric characters, so a fancy expression such as
 * "SBAR|SBAR[^a-zA-Z].*" would match SBAR but not SBARQ constituents.
 */
public class ParserConstraint implements Serializable {
  public int start;
  public int end;
  public Pattern state;
  
  private static final long serialVersionUID = 4955237758572202093L;

  public ParserConstraint() {}

  public ParserConstraint(int start, int end, String pattern) {
    this(start, end, Pattern.compile(pattern));
  }

  public ParserConstraint(int start, int end, Pattern state) {
    this.start = start;
    this.end = end;
    this.state = state;
  }
}
