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

import edu.stanford.nlp.ling.CategoryWordTag;
import edu.stanford.nlp.ling.Label;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeTransformer;

import java.util.*;

/**
 */
public class CNFTransformers {

  private CNFTransformers() {}


  static class ToCNFTransformer implements TreeTransformer {
    public Tree transformTree(Tree t) {
      if (t.isLeaf()) {
        return t.treeFactory().newLeaf(t.label());
      }
      Tree[] children = t.children();
      if (children.length > 1 || t.isPreTerminal() || t.label().value().startsWith("ROOT")) {
        Label label = t.label();
        Tree[] transformedChildren = new Tree[children.length];
        for (int childIndex = 0; childIndex < children.length; childIndex++) {
          Tree child = children[childIndex];
          transformedChildren[childIndex] = transformTree(child);
        }
        return t.treeFactory().newTreeNode(label, Arrays.asList(transformedChildren));
      }
      Tree tree = t;
      List<String> conjoinedList = new ArrayList<String>();
      while (tree.children().length == 1 && !tree.isPrePreTerminal()) {
        String nodeString = tree.label().value();
        if (!nodeString.startsWith("@")) {
          conjoinedList.add(nodeString);
        }
        tree = tree.children()[0];
      }
      String nodeString = tree.label().value();
      if (!nodeString.startsWith("@")) {
        conjoinedList.add(nodeString);
      }
      String conjoinedLabels;
      if (conjoinedList.size() > 1) {
        StringBuilder conjoinedLabelsBuilder = new StringBuilder();
        for (String s : conjoinedList) {
          conjoinedLabelsBuilder.append("&");
          conjoinedLabelsBuilder.append(s);
        }
        conjoinedLabels = conjoinedLabelsBuilder.toString();
      } else if (conjoinedList.size() == 1) {
        conjoinedLabels = conjoinedList.iterator().next();
      } else {
        return transformTree(t.children()[0]);
      }
      children = tree.children();
      Label label = t.label().labelFactory().newLabel(conjoinedLabels);
      Tree[] transformedChildren = new Tree[children.length];
      for (int childIndex = 0; childIndex < children.length; childIndex++) {
        Tree child = children[childIndex];
        transformedChildren[childIndex] = transformTree(child);
      }
      return t.treeFactory().newTreeNode(label, Arrays.asList(transformedChildren));
    }
  }

  static class FromCNFTransformer implements TreeTransformer {
    public Tree transformTree(Tree t) {
      if (t.isLeaf()) {
        return t.treeFactory().newLeaf(t.label());
      }
      Tree[] children = t.children();
      Tree[] transformedChildren = new Tree[children.length];
      for (int childIndex = 0; childIndex < children.length; childIndex++) {
        Tree child = children[childIndex];
        transformedChildren[childIndex] = transformTree(child);
      }
      Label label = t.label();
      if (!label.value().startsWith("&")) {
        return t.treeFactory().newTreeNode(label, Arrays.asList(transformedChildren));
      }
      String[] nodeStrings = label.value().split("&");
      int i = nodeStrings.length - 1;
      label = t.label().labelFactory().newLabel(nodeStrings[i]);
      Tree result = t.treeFactory().newTreeNode(label, Arrays.asList(transformedChildren));
      while (i > 1) {
        i--;
        label = t.label().labelFactory().newLabel(nodeStrings[i]);
        result = t.treeFactory().newTreeNode(label, Collections.singletonList(result));
      }
      return result;
    }
  }

  public static void main(String[] args) {
    CategoryWordTag.printWordTag = false;
    String path = args[0];
    List<Tree> trees = TreebankAnnotator.getTrees(path, 200, 219, 0, 10);
    List<Tree> annotatedTrees = new TreebankAnnotator(new Options(), path).annotateTrees(trees);
    for (Tree tree : annotatedTrees) {
      System.out.println("ORIGINAL:\n");
      tree.pennPrint();
      System.out.println("CNFed:\n");
      Tree cnfTree = new ToCNFTransformer().transformTree(tree);
      cnfTree.pennPrint();
      System.out.println("UnCNFed:\n");
      Tree unCNFTree = new FromCNFTransformer().transformTree(cnfTree);
      unCNFTree.pennPrint();
      System.out.println("\n\n");
    }
  }


}


