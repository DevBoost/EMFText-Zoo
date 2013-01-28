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

import edu.stanford.nlp.util.Index;

import java.io.*;
import java.util.*;

/**
 * Maintains efficient indexing of binary grammar rules.
 *
 * @author Dan Klein
 * @author Christopher Manning (generified and optimized storage)
 */
public class BinaryGrammar implements Serializable, Iterable<BinaryRule> {

  // private static final BinaryRule[] EMPTY_BINARY_RULE_ARRAY = new BinaryRule[0];

  private final Index<String> index;

  private final List<BinaryRule> allRules;

  private transient List<BinaryRule>[] rulesWithParent;
  private transient List<BinaryRule>[] rulesWithLC;
  private transient List<BinaryRule>[] rulesWithRC;
  private transient Set<BinaryRule>[] ruleSetWithLC;
  private transient Set<BinaryRule>[] ruleSetWithRC;
  private transient BinaryRule[][] splitRulesWithLC;
  private transient BinaryRule[][] splitRulesWithRC;
  //  private transient BinaryRule[][] splitRulesWithParent = null;
  private transient Map<BinaryRule,BinaryRule> ruleMap;
  // for super speed! (maybe)
  private transient boolean[] synthetic;


  public int numRules() {
    return allRules.size();
  }

  public List<BinaryRule> rules() {
    return allRules;
  }

  public boolean isSynthetic(int state) {
    return synthetic[state];
  }

  /**
   * Populates the "splitRules" accessor lists using the existing rule lists.
   * If the state is synthetic, these lists contain all rules for the state.
   * If the state is NOT synthetic, these lists contain only the rules in
   * which both children are not synthetic.
   * <p>
   * <i>This method must be called before the grammar is
   * used, either after training or deserializing grammar.</i>
   */
  public void splitRules() {
    // first initialize the synthetic array
    int numStates = index.size();
    synthetic = new boolean[numStates];
    for (int s = 0; s < numStates; s++) {
      try {
        //System.out.println(((String)index.get(s))); // debugging
        synthetic[s] = (index.get(s).charAt(0) == '@');
      } catch (NullPointerException e) {
        synthetic[s] = true;
      }
    }

    splitRulesWithLC = new BinaryRule[numStates][];
    splitRulesWithRC = new BinaryRule[numStates][];
    //    splitRulesWithParent = new BinaryRule[numStates][];
    // rules accessed by their "synthetic" child or left child if none
    for (int state = 0; state < numStates; state++) {
      //      System.out.println("Splitting rules for state: " + index.get(state));
      // check synthetic
      if (isSynthetic(state)) {
        splitRulesWithLC[state] = rulesWithLC[state].toArray(new BinaryRule[rulesWithLC[state].size()]);
        splitRulesWithRC[state] = rulesWithRC[state].toArray(new BinaryRule[rulesWithRC[state].size()]);
      } else {
        // if state is not synthetic, we add rule to splitRules only if both children are not synthetic
        // do left
        List<BinaryRule> ruleList = new ArrayList<BinaryRule>();
        for (BinaryRule br : rulesWithLC[state]) {
          if ( ! isSynthetic(br.rightChild)) {
            ruleList.add(br);
          }
        }
        splitRulesWithLC[state] = ruleList.toArray(new BinaryRule[ruleList.size()]);
        // do right
        ruleList.clear();
        for (BinaryRule br : rulesWithRC[state]) {
          if ( ! isSynthetic(br.leftChild)) {
            ruleList.add(br);
          }
        }
        splitRulesWithRC[state] = ruleList.toArray(new BinaryRule[ruleList.size()]);
      }
      // parent accessor
      //      splitRulesWithParent[state] = toBRArray(rulesWithParent[state]);
    }
  }

  public BinaryRule[] splitRulesWithLC(int state) {
    // if (state >= splitRulesWithLC.length) {
    //   return EMPTY_BINARY_RULE_ARRAY;
    // }
    return splitRulesWithLC[state];
  }

  public BinaryRule[] splitRulesWithRC(int state) {
    // if (state >= splitRulesWithRC.length) {
    //   return EMPTY_BINARY_RULE_ARRAY;
    // }
    return splitRulesWithRC[state];
  }

  //  public BinaryRule[] splitRulesWithParent(int state) {
  //    return splitRulesWithParent[state];
  //  }

  // the sensible version

  public double scoreRule(BinaryRule br) {
    BinaryRule rule = ruleMap.get(br);
    return (rule != null ? rule.score : Double.NEGATIVE_INFINITY);
  }

  public void addRule(BinaryRule br) {
    //    System.out.println("BG adding rule " + br);
    rulesWithParent[br.parent].add(br);
    rulesWithLC[br.leftChild].add(br);
    rulesWithRC[br.rightChild].add(br);
    ruleSetWithLC[br.leftChild].add(br);
    ruleSetWithRC[br.rightChild].add(br);
    allRules.add(br);
    ruleMap.put(br, br);
  }


  public Iterator<BinaryRule> iterator() {
    return allRules.iterator();
  }

  public Iterator<BinaryRule> ruleIteratorByParent(int state) {
    if (state >= rulesWithParent.length) {
      return Collections.<BinaryRule>emptyList().iterator();
    }
    return rulesWithParent[state].iterator();
  }

  public Iterator<BinaryRule> ruleIteratorByRightChild(int state) {
    if (state >= rulesWithRC.length) {
      return Collections.<BinaryRule>emptyList().iterator();
    }
    return rulesWithRC[state].iterator();
  }

  public Iterator<BinaryRule> ruleIteratorByLeftChild(int state) {
    if (state >= rulesWithLC.length) {
      return Collections.<BinaryRule>emptyList().iterator();
    }
    return rulesWithLC[state].iterator();
  }

  public List<BinaryRule> ruleListByParent(int state) {
    if (state >= rulesWithParent.length) {
      return Collections.emptyList();
    }
    return rulesWithParent[state];
  }

  public List<BinaryRule> ruleListByRightChild(int state) {
    if (state >= rulesWithRC.length) {
      return Collections.emptyList();
    }
    return rulesWithRC[state];
  }

  public List<BinaryRule> ruleListByLeftChild(int state) {
    if (state >= rulesWithRC.length) {
      return Collections.emptyList();
    }
    return rulesWithLC[state];
  }

  /* ----
  public Set<BinaryRule> ruleSetByRightChild(int state) {
    if (state >= ruleSetWithRC.length) {
      return Collections.<BinaryRule>emptySet();
    }
    return ruleSetWithRC[state];
  }

  public Set<BinaryRule> ruleSetByLeftChild(int state) {
    if (state >= ruleSetWithRC.length) {
      return Collections.<BinaryRule>emptySet();
    }
    return ruleSetWithLC[state];
  }
  --- */


  private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
    stream.defaultReadObject();
    init();
    for (BinaryRule br : allRules) {
      rulesWithParent[br.parent].add(br);
      rulesWithLC[br.leftChild].add(br);
      rulesWithRC[br.rightChild].add(br);
      ruleMap.put(br, br);
    }
    splitRules();
  }

  @SuppressWarnings("unchecked")
  private void init() {
    ruleMap = new HashMap<BinaryRule,BinaryRule>();
    int numStates = index.size();
    rulesWithParent = new List[numStates];
    rulesWithLC = new List[numStates];
    rulesWithRC = new List[numStates];
    ruleSetWithLC = new Set[numStates];
    ruleSetWithRC = new Set[numStates];
    for (int s = 0; s < numStates; s++) {
      rulesWithParent[s] = new ArrayList<BinaryRule>();
      rulesWithLC[s] = new ArrayList<BinaryRule>();
      rulesWithRC[s] = new ArrayList<BinaryRule>();
      ruleSetWithLC[s] = new HashSet<BinaryRule>();
      ruleSetWithRC[s] = new HashSet<BinaryRule>();
    }
  }

  public BinaryGrammar(Index<String> stateIndex) {
    this.index = stateIndex;
    allRules = new ArrayList<BinaryRule>();
    init();
  }

  /**
   * Populates data in this BinaryGrammar from the character stream
   * given by the Reader r.
   *
   * @param in Where input is read from
   * @throws IOException If format is bung
   */
  public void readData(BufferedReader in) throws IOException {
    //if (Test.verbose) System.err.println(">> readData");
    String line;
    int lineNum = 1;
    line = in.readLine();
    while (line != null && line.length() > 0) {
      try {
        addRule(new BinaryRule(line, index));
      } catch (Exception e) {
        throw new IOException("Error on line " + lineNum);
      }
      lineNum++;
      line = in.readLine();
    }
    splitRules();
  }

  /**
   * Writes out data from this Object to the Writer w.
   *
   * @param w Where output is written
   * @throws IOException If data can't be written
   */
  public void writeData(Writer w) throws IOException {
    PrintWriter out = new PrintWriter(w);
    for (BinaryRule br : this) {
      out.println(br.toString(index));
    }
    out.flush();
  }

  private static final long serialVersionUID = 1L;

} // end class BinaryGrammar

