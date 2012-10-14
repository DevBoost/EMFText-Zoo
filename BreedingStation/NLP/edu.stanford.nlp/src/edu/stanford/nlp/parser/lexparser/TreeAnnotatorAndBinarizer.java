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

import java.util.*;
import java.io.FileFilter;

import edu.stanford.nlp.io.NumberRangesFileFilter;
import edu.stanford.nlp.io.NumberRangeFileFilter;
import edu.stanford.nlp.ling.Label;
import edu.stanford.nlp.ling.CategoryWordTag;
import edu.stanford.nlp.ling.CategoryWordTagFactory;
import edu.stanford.nlp.ling.StringLabelFactory;
import edu.stanford.nlp.ling.Word;
import edu.stanford.nlp.stats.ClassicCounter;
import edu.stanford.nlp.trees.*;


public class TreeAnnotatorAndBinarizer implements TreeTransformer {

  private TreeFactory tf;
  private TreebankLanguagePack tlp;
  private TreeTransformer annotator;
  private TreeTransformer binarizer;
  private TreeTransformer postSplitter;
  private boolean forceCNF;
  private ClassicCounter<Tree> annotatedRuleCounts;
  private ClassicCounter<String> annotatedStateCounts;
  private TrainOptions trainOptions;

  public TreeAnnotatorAndBinarizer(TreebankLangParserParams tlpParams, boolean forceCNF, boolean insideFactor, boolean doSubcategorization, Options op) {
    this(tlpParams.headFinder(), tlpParams.headFinder(), tlpParams, forceCNF, insideFactor, doSubcategorization, op);
  }

  public TreeAnnotatorAndBinarizer(HeadFinder annotationHF, HeadFinder binarizationHF, TreebankLangParserParams tlpParams, boolean forceCNF, boolean insideFactor, boolean doSubcategorization, Options op) {
    this.trainOptions = op.trainOptions;
    if (doSubcategorization) {
      annotator = new TreeAnnotator(annotationHF, tlpParams, op);
    } else {
      annotator = new TreeNullAnnotator(annotationHF);
    }
    binarizer = new TreeBinarizer(binarizationHF, tlpParams.treebankLanguagePack(), insideFactor, trainOptions.markovFactor, trainOptions.markovOrder, trainOptions.compactGrammar() > 0, trainOptions.compactGrammar() > 1, trainOptions.HSEL_CUT, trainOptions.markFinalStates);
    if (trainOptions.selectivePostSplit) {
      postSplitter = new PostSplitter(tlpParams, op);
    }
    this.tf = new LabeledScoredTreeFactory(new CategoryWordTagFactory());
    this.tlp = tlpParams.treebankLanguagePack();
    this.forceCNF = forceCNF;
    if (trainOptions.printAnnotatedRuleCounts) {
      annotatedRuleCounts = new ClassicCounter<Tree>();
    }
    if (trainOptions.printAnnotatedStateCounts) {
      annotatedStateCounts = new ClassicCounter<String>();
    }
  }

  public void dumpStats() {
    if (trainOptions.selectivePostSplit) {
      ((PostSplitter) postSplitter).dumpStats();
    }
  }

  public void setDoSelectiveSplit(boolean doSelectiveSplit) {
    ((TreeBinarizer) binarizer).setDoSelectiveSplit(doSelectiveSplit);
  }

  /**
   * Changes the ROOT label, and adds a Lexicon.BOUNDARY daughter to it.
   * This is needed for the dependency parser.
   * <i>Note:</i> This is a destructive operation on the tree passed in!!
   *
   * @param t The current tree into which a boundary is inserted
   */
  public void addRoot(Tree t) {
    if (t.isLeaf()) {
      System.err.println("Warning: tree is leaf: " + t);
      t = tf.newTreeNode(tlp.startSymbol(), Collections.singletonList(t));
    }
    t.setLabel(new CategoryWordTag(tlp.startSymbol(), Lexicon.BOUNDARY, Lexicon.BOUNDARY_TAG));
    List<Tree> preTermChildList = new ArrayList<Tree>();
    Tree boundaryTerm = tf.newLeaf(new Word(Lexicon.BOUNDARY));//CategoryWordTag(Lexicon.BOUNDARY,Lexicon.BOUNDARY,""));
    preTermChildList.add(boundaryTerm);
    Tree boundaryPreTerm = tf.newTreeNode(new CategoryWordTag(Lexicon.BOUNDARY_TAG, Lexicon.BOUNDARY, Lexicon.BOUNDARY_TAG), preTermChildList);
    List<Tree> childList = t.getChildrenAsList();
    childList.add(boundaryPreTerm);
    t.setChildren(childList);
  }

  /** The tree t is normally expected to be a Penn-Treebank-style tree
   *  in which the top node is an extra node that rewrites unarily.
   *  If this isn't the case, an extra node is added and the user is
   *  warned.
   */

  public Tree transformTree(Tree t) {
    if (trainOptions.printTreeTransformations > 0) {
      trainOptions.printTrainTree(null, "ORIGINAL TREE:", t);
    }
    Tree trTree = annotator.transformTree(t);
    if (trainOptions.selectivePostSplit) {
      trTree = postSplitter.transformTree(trTree);
    }
    if (trainOptions.printTreeTransformations > 0) {
      trainOptions.printTrainTree(trainOptions.printAnnotatedPW, "ANNOTATED TREE:", trTree);
    }
    if (trainOptions.printAnnotatedRuleCounts) {
      Tree tr2 = trTree.deepCopy(new LabeledScoredTreeFactory(), new StringLabelFactory());
      Set<Tree> localTrees = tr2.localTrees();
      for (Tree tr : localTrees) {
        annotatedRuleCounts.incrementCount(tr);
      }
    }
    if (trainOptions.printAnnotatedStateCounts) {
      for (Tree subt : trTree) {
        if ( ! subt.isLeaf()) {
          annotatedStateCounts.incrementCount(subt.label().value());
        }
      }
    }

    // if we add the ROOT first, then we don't know how to percolate the heads at the top
    addRoot(trTree); // this creates a few non-binarized rules at the top

    Tree binarizedTree = binarizer.transformTree(trTree);
    if (trainOptions.printTreeTransformations > 0) {
      trainOptions.printTrainTree(trainOptions.printBinarizedPW, "BINARIZED TREE:", binarizedTree);
      trainOptions.printTreeTransformations--;
    }
    if (forceCNF) {
      binarizedTree = new CNFTransformers.ToCNFTransformer().transformTree(binarizedTree);
      //        System.out.println("BinarizedCNF:\n");
      //        binarizedTree.pennPrint();
    }
    return binarizedTree;
  }

  public void printRuleCounts() {
    System.err.println();
    for (Tree t : annotatedRuleCounts.keySet()) {
      System.err.print(annotatedRuleCounts.getCount(t) + "\t" +
                       t.label().value() + " -->");
      for (Tree dtr : t.getChildrenAsList()) {
        System.err.print(" ");
        System.err.print(dtr.label().value());
      }
      System.err.println();
    }
  }

  public void printStateCounts() {
    System.err.println();
    System.err.println("Annotated state counts");
    Set<String> keys = annotatedStateCounts.keySet();
    List<String> keyList = new ArrayList<String>(keys);
    Collections.sort(keyList);
    for (String s : keyList) {
      System.err.println(s + "\t" + annotatedStateCounts.getCount(s));
    }
  }





  // main helper function
  private static int numSubArgs(String[] args, int index) {
    int i = index;
    while (i + 1 < args.length && args[i + 1].charAt(0) != '-') {
      i++;
    }
    return i - index;
  }

  /** Let's you test out the TreeAnnotatorAndBinarizer on the command line.
   *
   *  @param args Command line arguments: All flags accepted by FactoredParser.setOptionFlag
   *     and -train treebankPath [fileRanges]
   */
  public static void main(String[] args) {
    Options op = new Options();
    String treebankPath = null;
    FileFilter trainFilter = null;

    int i = 0;
    while (i < args.length && args[i].startsWith("-")) {
      if (args[i].equalsIgnoreCase("-train")) {
        int numSubArgs = numSubArgs(args, i);
        i++;
        if (numSubArgs >= 1) {
          treebankPath = args[i];
          i++;
        } else {
          throw new RuntimeException("Error: -train option must have treebankPath as first argument.");
        }
        if (numSubArgs == 2) {
          trainFilter = new NumberRangesFileFilter(args[i++], true);
        } else if (numSubArgs >= 3) {
          int low = Integer.parseInt(args[i]);
          int high = Integer.parseInt(args[i + 1]);
          trainFilter = new NumberRangeFileFilter(low, high, true);
          i += 2;
        }
      } else {
        i = op.setOption(args, i);
      }
    }
    if (i < args.length) {
      System.err.println("usage: java TreeAnnotatorAndBinarizer options*");
      System.err.println("  Options are like for lexicalized parser including -train treebankPath fileRange]");
      System.exit(0);
    }

    System.err.println("Annotating from treebank dir: " + treebankPath);
    Treebank trainTreebank = op.tlpParams.diskTreebank();
    if (trainFilter == null) {
      trainTreebank.loadPath(treebankPath);
    } else {
      trainTreebank.loadPath(treebankPath, trainFilter);
    }

    Treebank binaryTrainTreebank = LexicalizedParser.getAnnotatedBinaryTreebankFromTreebank(trainTreebank, null, null, op).first();

    Iterator<Tree> it = trainTreebank.iterator();
    for (Tree t : binaryTrainTreebank) {
      System.out.println("Original tree:");
      it.next().pennPrint();
      System.out.println("Binarized tree:");
      t.pennPrint();
      System.out.println();
    }
  } // end main




  /** This does nothing but a function to change the tree nodes into
   *  CategoryWordTag, while the leaves are StringLabels. That's what the
   *  rest of the code assumes.
   */
  static class TreeNullAnnotator implements TreeTransformer {

    private TreeFactory tf =
      new LabeledScoredTreeFactory(new CategoryWordTagFactory());
    private HeadFinder hf;

    public Tree transformTree(Tree t) {
      // make a defensive copy which the helper method can then mangle
      Tree copy = t.treeSkeletonCopy(tf);
      return transformTreeHelper(copy);
    }

    private Tree transformTreeHelper(Tree t) {
      if (t == null) {
      } else {
        String cat = t.label().value();
        if (t.isLeaf()) {
          Label label = new Word(cat); //new CategoryWordTag(cat,cat,"");
          t.setLabel(label);
        } else {
          Tree[] kids = t.children();
          for (Tree child : kids) {
            transformTreeHelper(child); // recursive call
          }
          Tree headChild = hf.determineHead(t);
          String tag;
          String word;
          if (headChild == null) {
            System.err.println("ERROR: null head for tree\n" + t.toString());
            word = null;
            tag = null;
          } else if (headChild.isLeaf()) {
            tag = cat;
            word = headChild.label().value();
          } else {
            CategoryWordTag headLabel = (CategoryWordTag) headChild.label();
            word = headLabel.word();
            tag = headLabel.tag();
          }
          Label label = new CategoryWordTag(cat, word, tag);
          t.setLabel(label);
        }
      }
      return t;
    }

    public TreeNullAnnotator(HeadFinder hf) {
      this.hf = hf;
    }

  } // end static class TreeNullAnnotator

} // end class TreeAnnotatorAndBinarizer
