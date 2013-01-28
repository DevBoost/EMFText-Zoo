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

/** Class for parse edges.
 *
 *  @author Dan Klein
 */
public class Edge extends Item {

  public Hook backHook;

  public Edge(boolean exhaustiveTest) {
  	super(exhaustiveTest);
  }
  
  public Edge(Edge e) {
  	super(e);
  	backHook = e.backHook;
  }
  
  @Override
  public boolean isEdge() {
    return true;
  }

  @Override
  public String toString() {
    // TODO: used to contain more useful information
    //return "Edge(" + Numberer.getGlobalNumberer("states").object(state) + ":" + start + "-" + end + "," + head + "/" + Numberer.getGlobalNumberer("tags").object(tag) + ")";
    return "Edge(" + state + ":" + start + "-" + end + "," + head + "/" + tag + ")";
  }

  @Override
  public int hashCode() {
    return (state << 1) ^ (head << 8) ^ (tag << 16) ^ (start << 4) ^ (end << 24);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    } else if (o instanceof Edge) {
      Edge e = (Edge) o;
      if (state == e.state && head == e.head && tag == e.tag && start == e.start && end == e.end) {
        return true;
      }
    }
    return false;
  }

}
