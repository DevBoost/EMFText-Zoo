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

import edu.stanford.nlp.util.Scored;


/** Abstract class for parse items.
 *
 *  @author Dan Klein
 */
abstract public class Item implements Scored {

  public int start;
  public int end;
  public int state;
  public int head;
  public int tag;
  public Edge backEdge;
  public double iScore = Double.NEGATIVE_INFINITY;
  public double oScore = Double.NEGATIVE_INFINITY;
  
  private final boolean exhaustiveTest;

  public Item(boolean exhaustiveTest) {
    this.exhaustiveTest = exhaustiveTest;
  }
  
  public Item(Item item) {
    start = item.start;
    end = item.end;
    state = item.state;
    head = item.head;
    tag = item.tag;
    backEdge = item.backEdge;
    iScore = item.iScore;
    oScore = item.oScore;
    this.exhaustiveTest = item.exhaustiveTest;
  }
  
  public double score() {
    if (exhaustiveTest) {
      return iScore;
    } else {
      return iScore + oScore;
    }
  }

  public boolean isEdge() {
    return false;
  }

  public boolean isPreHook() {
    return false;
  }

  public boolean isPostHook() {
    return false;
  }

}
