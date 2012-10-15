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

/** Class for parse table hooks.  A "hook" is the parse item that Eisner and
 *  Satta introduced to reduce the complexity of lexicalized parsing to 
 *  O(n^4).
 *
 *  @author Dan Klein
 */
public class Hook extends Item {

  public int subState;

  public Hook(boolean exhaustiveTest) {
  	super(exhaustiveTest);
  }
  
  public Hook(Hook h) {
  	super(h);
  	subState = h.subState;
  }
  
  @Override
  public boolean isPreHook() {
    return head < start;
  }

  @Override
  public boolean isPostHook() {
    return head >= end;
  }

  @Override
  public String toString() {
    // TODO: used to have more useful information
    //return (isPreHook() ? "Pre" : "Post") + "Hook(" + Numberer.getGlobalNumberer("states").object(state) + "|" + Numberer.getGlobalNumberer("states").object(subState) + ":" + start + "-" + end + "," + head + "/" + Numberer.getGlobalNumberer("tags").object(tag) + ")";
    return (isPreHook() ? "Pre" : "Post") + "Hook(" + state + "|" + subState + ":" + start + "-" + end + "," + head + "/" + tag + ")";
  }

  @Override
  public int hashCode() {
    return 1 + (state << 14) ^ (subState << 16) ^ (head << 22) ^ (tag << 27) ^ (start << 1) ^ (end << 7);
  }

  /** Hooks are equal if they have same state, substate, head, tag, start, 
   *  and end.
   */
  @Override
  public boolean equals(Object o) {
    // System.out.println("\nCHECKING HOOKS: " + this + " vs. " + o);
    if (this == o) {
      return true;
    }
    if (o instanceof Hook) {
      Hook e = (Hook) o;
      if (state == e.state && subState == e.subState && head == e.head &&
          tag == e.tag && start == e.start && end == e.end) {
        return true;
      }
    }
    return false;
  }

}
