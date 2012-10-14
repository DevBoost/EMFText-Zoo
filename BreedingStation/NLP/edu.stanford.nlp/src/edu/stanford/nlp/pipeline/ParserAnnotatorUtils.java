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
package edu.stanford.nlp.pipeline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.HasTag;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.Label;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.trees.LabeledScoredTreeFactory;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeFactory;
import edu.stanford.nlp.trees.TreeCoreAnnotations.TreeAnnotation;
import edu.stanford.nlp.trees.semgraph.SemanticGraph;
import edu.stanford.nlp.trees.semgraph.SemanticGraphCoreAnnotations;
import edu.stanford.nlp.trees.semgraph.SemanticGraphFactory;
import edu.stanford.nlp.util.CoreMap;

/** @author David McClosky */
public class ParserAnnotatorUtils {

  private ParserAnnotatorUtils() {} // static methods


  public static SemanticGraph generateDependencies(Tree tree,
      boolean collapse,
      boolean ccProcess,
      boolean includeExtras,
      boolean lemmatize,
      boolean threadSafe) {
    SemanticGraph deps = SemanticGraphFactory.makeFromTree(tree, collapse, ccProcess, includeExtras, lemmatize, threadSafe);
    return deps;
  }

  public static SemanticGraph generateUncollapsedDependencies(Tree tree) {
    return generateDependencies(tree, false, false, false, true, true);
  }

  public static SemanticGraph generateCollapsedDependencies(Tree tree) {
    return generateDependencies(tree, true, false, false, true, true);
  }

  public static SemanticGraph generateCCProcessedDependencies(Tree tree) {
    return generateDependencies(tree, true, true, false, true, true);
  }

  public static void fillInParseAnnotations(boolean verbose, CoreMap sentence, Tree tree) {
    // make sure all tree nodes are CoreLabels
    // TODO: why isn't this always true? something fishy is going on
    ParserAnnotatorUtils.convertToCoreLabels(tree);

    // index nodes, i.e., add start and end token positions to all nodes
    // this is needed by other annotators down stream, e.g., the NFLAnnotator
    tree.indexSpans(0);

    sentence.set(TreeAnnotation.class, tree);
    if (verbose) {
      System.err.println("Tree is:");
      tree.pennPrint(System.err);
    }

    // generate the dependency graph
    SemanticGraph deps = generateCollapsedDependencies(tree);
    SemanticGraph uncollapsedDeps = generateUncollapsedDependencies(tree);
    SemanticGraph ccDeps = generateCCProcessedDependencies(tree);
    if (verbose) {
      System.err.println("SDs:");
      System.err.println(deps.toString("plain"));
    }
    sentence.set(SemanticGraphCoreAnnotations.CollapsedDependenciesAnnotation.class, deps);
    sentence.set(SemanticGraphCoreAnnotations.BasicDependenciesAnnotation.class, uncollapsedDeps);
    sentence.set(SemanticGraphCoreAnnotations.CollapsedCCProcessedDependenciesAnnotation.class, ccDeps);

    setMissingTags(sentence, tree);
  }

  /**
   * Set the tags of the original tokens and the leaves if they
   * aren't already set
   */
  public static void setMissingTags(CoreMap sentence, Tree tree) {
    List<TaggedWord> taggedWords = null;
    List<Label> leaves = null;
    List<CoreLabel> tokens = sentence.get(TokensAnnotation.class);
    for (int i = 0; i < tokens.size(); ++i) {
      CoreLabel token = tokens.get(i);
      if (token.tag() == null) {
        if (taggedWords == null) {
          taggedWords = tree.taggedYield();
        }
        if (leaves == null) {
          leaves = tree.yield();
        }
        token.setTag(taggedWords.get(i).tag());
        Label leaf = leaves.get(i);
        if (leaf instanceof HasTag) {
          ((HasTag) leaf).setTag(taggedWords.get(i).tag());
        }
      }
    }
  }

  /**
   * Converts the tree labels to CoreLabels.
   * We need this because we store additional info in the CoreLabel, like token span.
   * @param tree
   */
  public static void convertToCoreLabels(Tree tree) {
    Label l = tree.label();
    if (!(l instanceof CoreLabel)) {
      CoreLabel cl = new CoreLabel();
      cl.setValue(l.value());
      tree.setLabel(cl);
    }

    for (Tree kid : tree.children()) {
      convertToCoreLabels(kid);
    }
  }

  /**
   * Construct a fall through tree in case we can't parse this sentence
   * @param words
   * @return a tree with X for all the internal nodes
   */
  public static Tree xTree(List<? extends HasWord> words) {
    TreeFactory lstf = new LabeledScoredTreeFactory();
    List<Tree> lst2 = new ArrayList<Tree>();
    for (HasWord obj : words) {
      String s = obj.word();
      Tree t = lstf.newLeaf(s);
      Tree t2 = lstf.newTreeNode("X", Collections.singletonList(t));
      lst2.add(t2);
    }
    return lstf.newTreeNode("X", lst2);
  }

}
