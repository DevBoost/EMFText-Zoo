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
package edu.stanford.nlp.trees.tregex;

import edu.stanford.nlp.stats.IntCounter;

import java.util.Map;
import java.util.HashMap;

/** A class that takes care of the stuff necessary for variable strings.
 *
 *  @author Roger Levy (rog@nlp.stanford.edu)
 */
class VariableStrings {

  private final Map<String, String> varsToStrings;
  private final IntCounter<String> numVarsSet;

  public VariableStrings() {
    varsToStrings = new HashMap<String,String>();
    numVarsSet = new IntCounter<String>();
  }

  public boolean isSet(String o) {
    return numVarsSet.getCount(o) >= 1;
  }

  public void setVar(String var, String string) {
    String oldString = varsToStrings.put(var,string);
    if(oldString != null && ! oldString.equals(string))
      throw new RuntimeException("Error -- can't setVar to a different string -- old: " + oldString + " new: " + string);
    numVarsSet.incrementCount(var);
  }

  public void unsetVar(String var) {
    if(numVarsSet.getCount(var) > 0)
      numVarsSet.decrementCount(var);
    if(numVarsSet.getCount(var)==0)
      varsToStrings.put(var,null);
  }

  public String getString(String var) {
    return varsToStrings.get(var);
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("{");
    boolean appended = false;
    for (String key : varsToStrings.keySet()) {
      if (appended) {
        s.append(",");
      } else {
        appended = true;
      }
      s.append(key);
      s.append("=(");
      s.append(varsToStrings.get(key));
      s.append(":");
      s.append(numVarsSet.getCount(key));
      s.append(")");
    }
    s.append("}");
    return s.toString();
  }

}
