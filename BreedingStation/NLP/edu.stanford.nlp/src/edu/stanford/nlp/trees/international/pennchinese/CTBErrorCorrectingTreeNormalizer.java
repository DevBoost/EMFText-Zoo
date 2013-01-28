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
package edu.stanford.nlp.trees.international.pennchinese;

import java.util.regex.Pattern;
import java.util.*;

import edu.stanford.nlp.trees.BobChrisTreeNormalizer;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeFactory;
import edu.stanford.nlp.trees.TreeTransformer;
import edu.stanford.nlp.util.Filter;
import edu.stanford.nlp.ling.Label;
import edu.stanford.nlp.io.EncodingPrintWriter;


/**
 * This was originally written to correct a few errors Galen found in CTB3.
 * The thinking was that perhaps when we get CTB4 they would be gone and we
 * could revert to BobChris.  Alas, CTB4 contained only more errors....
 * It has since been extended to allow some functional tags from CTB to be
 * maintained.  This is so far much easier than in NPTmpRetainingTN, since
 * we don't do any tag percolation (helped by CTB marking temporal nouns).
 * <p>
 * <i>Implementation note:</i> This now loads CharacterLevelTagExtender by
 * reflection if that option is invoked.
 *
 * @author Galen Andrew
 * @author Christopher Manning
 */
public class CTBErrorCorrectingTreeNormalizer extends BobChrisTreeNormalizer {

  private static final long serialVersionUID = -8203853817025401845L;

  private static final Pattern NPTmpPattern = Pattern.compile("NP.*-TMP.*");
  private static final Pattern PPTmpPattern = Pattern.compile("PP.*-TMP.*");
  private static final Pattern TmpPattern = Pattern.compile(".*-TMP.*");

  @SuppressWarnings({"NonSerializableFieldInSerializableClass"})
  private TreeTransformer tagExtender;

  private boolean splitNPTMP;
  private boolean splitPPTMP;
  private boolean splitXPTMP;

  /** Constructor with all of the options of the other constructor false */
  public CTBErrorCorrectingTreeNormalizer() {
    this(false, false, false, false);
  }

  /**
   * Build a CTBErrorCorrectingTreeNormalizer.
   *
   * @param splitNPTMP Temporal annotation on NPs
   * @param splitPPTMP Temporal annotation on PPs
   * @param splitXPTMP Temporal annotation on any phrase marked in CTB
   * @param charTags Whether you wish to push POS tags down on to the
   *           characters of a word (for unsegmented text)
   */
  public CTBErrorCorrectingTreeNormalizer(boolean splitNPTMP, boolean splitPPTMP, boolean splitXPTMP, boolean charTags) {
    this.splitNPTMP = splitNPTMP;
    this.splitPPTMP = splitPPTMP;
    this.splitXPTMP = splitXPTMP;
    if (charTags) {
      try {
        tagExtender = (TreeTransformer) Class.forName("edu.stanford.nlp.trees.international.pennchinese.CharacterLevelTagExtender").newInstance();
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
  }


  /**
   * Remove things like hyphened functional tags and equals from the
   * end of a node label.  But keep occasional functional tags as
   * determined by class parameters, particularly TMP
   *
   * @param label The label to be cleaned up
   */
  @Override
  protected String cleanUpLabel(String label) {
    if (label == null) {
      return "ROOT";
    } else {
      boolean nptemp = NPTmpPattern.matcher(label).matches();
      boolean pptemp = PPTmpPattern.matcher(label).matches();
      boolean anytemp = TmpPattern.matcher(label).matches();
      label = tlp.basicCategory(label);
      if (anytemp && splitXPTMP) {
        label += "-TMP";
      } else if (pptemp && splitPPTMP) {
        label = label + "-TMP";
      } else if (nptemp && splitNPTMP) {
        label = label + "-TMP";
      }
      return label;
    }
  }


  private static class ChineseEmptyFilter implements Filter<Tree> {

    private static final long serialVersionUID = 8914098359495987617L;

    /** Doesn't accept nodes that only cover an empty. */
    public boolean accept(Tree t) {
      Tree[] kids = t.children();
      Label l = t.label();
      if ((l != null) && l.value() != null && // there appears to be a mistake in CTB3 where the label "-NONE-1" is used once
              // presumably it should be "-NONE-" and be spliced out here.
              (l.value().matches("-NONE-.*")) && !t.isLeaf() && kids.length == 1 && kids[0].isLeaf()) {
        // Delete empty/trace nodes (ones marked '-NONE-')
        if ( ! l.value().equals("-NONE-")) {
          EncodingPrintWriter.err.println("Deleting errant node " + l.value() + " as if -NONE-: " + t, ChineseTreebankLanguagePack.ENCODING);
        }
        return false;
      }
      return true;
    }

  }

  private Filter<Tree> chineseEmptyFilter = new ChineseEmptyFilter();


  @Override
  public Tree normalizeWholeTree(Tree tree, TreeFactory tf) {
    Tree newTree = tree.prune(chineseEmptyFilter, tf).spliceOut(aOverAFilter);

    // Report non-unary initial rewrites & fix 'obvious ones'
    Tree[] kids = newTree.children();
    if (kids.length > 1) {
    /* -------------- don't do this as probably shouldn't for test set (and doesn't help anyway)
      if (kids.length == 2 &&
          "PU".equals(kids[kids.length - 1].value()) &&
          kids[0].isPhrasal()) {
        printlnErr("Correcting error: non-unary initial rewrite fixed by tucking punctuation inside constituent: " + newTree.localTree());
        List kidkids = kids[0].getChildrenAsList();
        kidkids.add(kids[1]);
        Tree bigger = tf.newTreeNode(kids[0].label(), kidkids);
        newTree = tf.newTreeNode(newTree.label(), Collections.singletonList(bigger));
      } else {
    -------------------- */
      EncodingPrintWriter.err.println("Possible error: non-unary initial rewrite: " +
                             newTree.localTree(), ChineseTreebankLanguagePack.ENCODING);
      // }
    } else {
      if (kids.length > 0) {
        Tree child = kids[0];
        if ( ! child.isPhrasal()) {
          EncodingPrintWriter.err.println("Correcting error: treebank tree is not phrasal; wrapping in FRAG: " + child, ChineseTreebankLanguagePack.ENCODING);
          Tree added = tf.newTreeNode("FRAG", Arrays.asList(kids));
          newTree.setChild(0, added);
        }
      } else {
        EncodingPrintWriter.err.println("Error: tree with no children: " + tree, ChineseTreebankLanguagePack.ENCODING);
      }
    }
    // note that there's also at least 1 tree that is an IP with no surrounding ROOT node

    // there are also several places where "NP" is used as a preterminal tag
    // and presumably should be "NN"
    // a couple of other random errors are corrected here
    for (Tree subtree : newTree) {
      if (subtree.value().equals("ROOT") && subtree.firstChild().isLeaf() && "CP".equals(subtree.firstChild().value())) {
        EncodingPrintWriter.err.println("Correcting error: seriously messed up tree in CTB6: " + newTree, ChineseTreebankLanguagePack.ENCODING);
        List<Tree> children = subtree.getChildrenAsList();
        children = children.subList(1,children.size() - 1);
        subtree.setChildren(children);
      }
      if (subtree.isPreTerminal()) {
        if (subtree.value().matches("NP")) {
          if (ChineseTreebankLanguagePack.chineseDouHaoAcceptFilter().accept(subtree.firstChild().value())) {
            EncodingPrintWriter.err.println("Correcting error: NP preterminal over douhao; preterminal changed to PU: " + subtree, ChineseTreebankLanguagePack.ENCODING);
            subtree.setValue("PU");
          } else if (subtree.parent(newTree).value().matches("NP")) {
            EncodingPrintWriter.err.println("Correcting error: NP preterminal w/ NP parent; preterminal changed to NN: " + subtree.parent(newTree), ChineseTreebankLanguagePack.ENCODING);
            subtree.setValue("NN");
          } else {
            EncodingPrintWriter.err.println("Correcting error: NP preterminal w/o NP parent, changing preterminal to NN: " + subtree.parent(newTree), ChineseTreebankLanguagePack.ENCODING);
            // Tree newChild = tf.newTreeNode("NN", Collections.singletonList(subtree.firstChild()));
            // subtree.setChildren(Collections.singletonList(newChild));
            subtree.setValue("NN");
          }
        } else if (subtree.value().matches("PU")) {
          if (subtree.firstChild().value().matches("\u4ed6")) {
            EncodingPrintWriter.err.println("Correcting error: \"\u4ed6\" under PU tag; tag changed to PN: " + subtree, ChineseTreebankLanguagePack.ENCODING);
            subtree.setValue("PN");
          } else if (subtree.firstChild().value().matches("tw|\u534A\u7A74\u5F0F")) {
            EncodingPrintWriter.err.println("Correcting error: \"" + subtree.firstChild().value() + "\" under PU tag; tag changed to NN: " + subtree, ChineseTreebankLanguagePack.ENCODING);
            subtree.setValue("NN");
          } else if (subtree.firstChild().value().matches("33")) {
            EncodingPrintWriter.err.println("Correcting error: \"33\" under PU tag; tag changed to CD: " + subtree, ChineseTreebankLanguagePack.ENCODING);
            subtree.setValue("CD");
          }
        }
      } else if (subtree.value().matches("NN")) {
        EncodingPrintWriter.err.println("Correcting error: NN phrasal tag changed to NP: " + subtree, ChineseTreebankLanguagePack.ENCODING);
        subtree.setValue("NP");
      } else if (subtree.value().matches("MSP")) {
        EncodingPrintWriter.err.println("Correcting error: MSP phrasal tag changed to VP: " + subtree, ChineseTreebankLanguagePack.ENCODING);
        subtree.setValue("VP");
      }
    }

    if (tagExtender != null) {
      newTree = tagExtender.transformTree(newTree);
    }
    return newTree;
  }

} // end class CTBErrorCorrectingTreeNormalizer
