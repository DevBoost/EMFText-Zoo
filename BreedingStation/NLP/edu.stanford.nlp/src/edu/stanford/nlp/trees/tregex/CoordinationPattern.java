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
package edu.stanford.nlp.trees.tregex;

import edu.stanford.nlp.trees.Tree;

import java.util.Iterator;
import java.util.List;
import java.util.IdentityHashMap;
import java.util.Map;

class CoordinationPattern extends TregexPattern {

  private final boolean isConj;
  private final List<TregexPattern> children;
  private final boolean changesVariables;

  /* if isConj is true, then it is an "AND" ; if it is false, it is an "OR".*/
  public CoordinationPattern(List<TregexPattern> children, boolean isConj) {
    if (children.size() < 2) {
      throw new RuntimeException("Coordination node must have at least 2 children.");
    }
    this.children = children;
    this.isConj = isConj;
    boolean changesVariables = false;
    for (TregexPattern child : children) {
      if (child.getChangesVariables()) {
        changesVariables = true;
      }
    }
    this.changesVariables = changesVariables;
    //    System.out.println("Made " + (isConj ? "and " : "or ") + "node with " + children.size() + " children.");
  }

  @Override
  public List<TregexPattern> getChildren() {
    return children;
  }

  @Override
  public String localString() {
    return (isConj ? "and" : "or");
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    if (isConj) {
      for (TregexPattern node : children) {
        sb.append(node.toString());
      }
    } else {
      sb.append('[');
      for (Iterator<TregexPattern> iter = children.iterator(); iter.hasNext();) {
        TregexPattern node = iter.next();
        sb.append(node.toString());
        if (iter.hasNext()) {
          sb.append(" |");
        }
      }
      sb.append(']');
    }
    return sb.toString();
  }

  @Override
  boolean getChangesVariables() {
    return changesVariables;
  }

  @Override
  public TregexMatcher matcher(Tree root, Tree tree, 
                               IdentityHashMap<Tree, Tree> nodesToParents,
                               Map<String, Tree> namesToNodes, 
                               VariableStrings variableStrings) {
    return new CoordinationMatcher(this, root, tree, nodesToParents, namesToNodes, variableStrings);
  }

  private static class CoordinationMatcher extends TregexMatcher {
    private TregexMatcher[] children;
    private final CoordinationPattern myNode;
    private int currChild;
    private final boolean considerAll;
    // do all con/dis-juncts have to be considered to determine a match?
    // i.e. true if conj and not negated or disj and negated

    public CoordinationMatcher(CoordinationPattern n, Tree root, Tree tree, 
                               IdentityHashMap<Tree, Tree> nodesToParents,
                               Map<String, Tree> namesToNodes, 
                               VariableStrings variableStrings) {
      super(root, tree, nodesToParents, namesToNodes, variableStrings);
      myNode = n;
      children = new TregexMatcher[myNode.children.size()];
      for (int i = 0; i < children.length; i++) {
        TregexPattern node = myNode.children.get(i);
        children[i] = node.matcher(root, tree, nodesToParents, 
                                   namesToNodes, variableStrings);
      }
      currChild = 0;
      considerAll = myNode.isConj ^ myNode.isNegated();
    }

    @Override
    void resetChildIter() {
      currChild = 0;
      for (int i = 0; i < children.length; i++) {
        children[i].resetChildIter();
      }
    }

    @Override
    void resetChildIter(Tree tree) {
      this.tree = tree;
      currChild = 0;
      for (int i = 0; i < children.length; i++) {
        children[i].resetChildIter(tree);
      }
    }

    @Override
    boolean getChangesVariables() {
      return myNode.getChangesVariables();
    }

    // find the next local match
    @Override
    public boolean matches() {  // also known as "FUN WITH LOGIC"
      if (considerAll) {
        // these are the cases where all children must be considered to match
        if (currChild < 0) {
          // a past call to this node either got that it failed
          // matching or that it was a negative match that succeeded,
          // which we only want to accept once
          return myNode.isOptional();
        }

        // we must have happily reached the end of a match the last
        // time we were here
        if (currChild == children.length) {
          --currChild;
        }

        while (true) {
          if (myNode.isNegated() != children[currChild].matches()) {
            // This node is set correctly.  Move on to the next node
            ++currChild;

            if (currChild == children.length) {
              // yay, all nodes matched.
              if (myNode.isNegated()) {
                // a negated node should only match once (before being reset)
                currChild = -1;
              }
              return true;
            }
          } else {
            // oops, this didn't work.
            children[currChild].resetChildIter();
            // go backwards to see if we can continue matching from an
            // earlier location.
            // TODO: perhaps there should be a version where we only
            // care about new assignments to the root, or new
            // assigments to the root and variables, in which case we
            // could make use of getChangesVariables() to optimize how
            // many nodes we can skip past
            --currChild;
            if (currChild < 0) {
              return myNode.isOptional();
            }
          }
        }
      } else { 
        // these are the cases where a single child node can make you match
        for (; currChild < children.length; currChild++) {
          if (myNode.isNegated() != children[currChild].matches()) {
            // a negated node should only match once (before being reset)
            if (myNode.isNegated()) {
              currChild = children.length;
            }
            return true;
          }
        }
        if (myNode.isNegated()) {
          currChild = children.length;
        }
        for (int resetChild = 0; resetChild < currChild; ++resetChild) {
          // clean up variables that may have been set in previously
          // accepted nodes
          children[resetChild].resetChildIter();
        }
        return myNode.isOptional();
      }
    }

    @Override
    public Tree getMatch() {
      // only DescriptionNodes can match
      throw new UnsupportedOperationException();
    }
  } // end private class CoordinationMatcher

  private static final long serialVersionUID = -7797084959452603087L;

}
