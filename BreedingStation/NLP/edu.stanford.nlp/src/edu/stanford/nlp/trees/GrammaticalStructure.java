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
package edu.stanford.nlp.trees;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.locks.Lock;

import edu.stanford.nlp.io.RuntimeIOException;
import edu.stanford.nlp.ling.CoreAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.Label;
import edu.stanford.nlp.ling.StringLabel;
import edu.stanford.nlp.ling.Word;
import edu.stanford.nlp.parser.lexparser.TreebankLangParserParams;
import edu.stanford.nlp.process.PTBTokenizer;
import edu.stanford.nlp.process.WhitespaceTokenizer;
import edu.stanford.nlp.trees.GrammaticalRelation.GrammaticalRelationAnnotation;
import edu.stanford.nlp.trees.TreeCoreAnnotations.HeadTagAnnotation;
import edu.stanford.nlp.trees.TreeCoreAnnotations.HeadWordAnnotation;
import edu.stanford.nlp.util.Filter;
import edu.stanford.nlp.util.Filters;
import edu.stanford.nlp.util.Function;
import edu.stanford.nlp.util.Generics;
import edu.stanford.nlp.util.ReflectionLoading;
import edu.stanford.nlp.util.StringUtils;

import static edu.stanford.nlp.trees.GrammaticalRelation.DEPENDENT;
import static edu.stanford.nlp.trees.GrammaticalRelation.GOVERNOR;
import static edu.stanford.nlp.trees.GrammaticalRelation.ROOT;




/**
 * A <code>GrammaticalStructure</code> is a {@link TreeGraph
 * <code>TreeGraph</code>} (that is, a tree with additional labeled
 * arcs between nodes) for representing the grammatical relations in a
 * parse tree.  A new <code>GrammaticalStructure</code> is constructed
 * from an existing parse tree with the help of {@link
 * GrammaticalRelation <code>GrammaticalRelation</code>}, which
 * defines a hierarchy of grammatical relations, along with
 * patterns for identifying them in parse trees.  The constructor for
 * <code>GrammaticalStructure</code> uses these definitions to
 * populate the new <code>GrammaticalStructure</code> with as many
 * labeled grammatical relations as it can.  Once constructed, the new
 * <code>GrammaticalStructure</code> can be printed in various
 * formats, or interrogated using the interface methods in this
 * class.
 * <p/>
 * <b>Caveat emptor!</b> This is a work in progress.
 * Nothing in here should be relied upon to function perfectly.
 * Feedback welcome.
 *
 * @author Bill MacCartney
 * @author Galen Andrew (refactoring English-specific stuff)
 * @author Ilya Sherman (dependencies)
 * @author Daniel Cer
 * @see EnglishGrammaticalRelations
 * @see GrammaticalRelation
 * @see EnglishGrammaticalStructure
 */
public abstract class GrammaticalStructure extends TreeGraph {

  private static final boolean PRINT_DEBUGGING = false;

  protected final Set<Dependency<Label, Label, Object>> dependencies;
  protected final List<TypedDependency> typedDependencies;
  protected final List<TypedDependency> allTypedDependencies;

  /**
   * Create a new GrammaticalStructure, analyzing the parse tree and
   * populate the GrammaticalStructure with as many labeled
   * grammatical relation arcs as possible.
   *
   * @param t             A Tree to analyze
   * @param relations     A set of GrammaticalRelations to consider
   * @param relationsLock Something needed to make this thread-safe
   * @param hf            A HeadFinder for analysis
   * @param puncFilter    A Filter to reject punctuation. To delete punctuation
   *                      dependencies, this filter should return false on
   *                      punctuation word strings, and true otherwise.
   *                      If punctuation dependencies should be kept, you
   *                      should pass in a Filters.&lt;String&gt;acceptFilter().
   */
  public GrammaticalStructure(Tree t, Collection<GrammaticalRelation> relations,
                              Lock relationsLock, HeadFinder hf, Filter<String> puncFilter) {
    super(t); // makes a Tree with TreeGraphNode nodes
    // add head word and tag to phrase nodes
    root.percolateHeads(hf);
    // add dependencies, using heads
    NoPunctFilter puncDepFilter = new NoPunctFilter(puncFilter);
    NoPunctTypedDependencyFilter puncTypedDepFilter = new NoPunctTypedDependencyFilter(puncFilter);
    dependencies = root.dependencies(puncDepFilter, null);
    for (Dependency<Label, Label, Object> p : dependencies) {
      //System.out.println("first dep found " + p);
      TreeGraphNode gov = (TreeGraphNode) p.governor();
      TreeGraphNode dep = (TreeGraphNode) p.dependent();
      dep.addArc(GrammaticalRelation.getAnnotationClass(GOVERNOR), gov);
    }
    // analyze the root (and its descendants, recursively)
    if (relationsLock != null) {
      relationsLock.lock();
    }
    try {
      analyzeNode(root, root, relations);
    }
    finally {
      if (relationsLock != null) {
        relationsLock.unlock();
      }
    }
    // add typed dependencies
    typedDependencies = getDeps(false, puncTypedDepFilter);
    allTypedDependencies = getDeps(true, puncTypedDepFilter);
  }


  private static void throwDepFormatException(String dep) {
     throw new RuntimeException(String.format("Dependencies should be for the format 'type(arg-idx, arg-idx)'. Could not parse '%s'", dep));
  }

  /**
   * Create a grammatical structure from its string representation.
   *
   * Like buildCoNNLXGrammaticStructure,
   * this method fakes up the parts of the tree structure that are not
   * used by the grammatical relation transformation operations.
   *
   * <i>Note:</i> Added by daniel cer
   *
   * @param tokens
   * @param posTags
   * @param deps
   */
  public static GrammaticalStructure fromStringReps(List<String> tokens,
         List<String> posTags, List<String> deps) {
      if (tokens.size() != posTags.size()) {
         throw new RuntimeException(String.format(
               "tokens.size(): %d != pos.size(): %d\n", tokens.size(), posTags
                     .size()));
      }

      List<TreeGraphNode> tgWordNodes = new ArrayList<TreeGraphNode>(tokens
            .size());
      List<TreeGraphNode> tgPOSNodes = new ArrayList<TreeGraphNode>(tokens
            .size());
      Iterator<String> tokensIter = tokens.iterator();
      Iterator<String> posIter = posTags.iterator();

      SemanticHeadFinder headFinder = new SemanticHeadFinder();

      while (tokensIter.hasNext()) {
         String wordString = tokensIter.next();
         String posString = posIter.next();
         TreeGraphNode word = new TreeGraphNode(new Word(wordString));
         TreeGraphNode pos = new TreeGraphNode(new Word(posString));
         tgWordNodes.add(word);
         tgPOSNodes.add(pos);
         TreeGraphNode[] childArr = { word };
         pos.setChildren(childArr);
         word.setParent(pos);
         pos.percolateHeads(headFinder);
      }

      TreeGraphNode root = new TreeGraphNode(new StringLabel("ROOT"));

      root
            .setChildren(tgPOSNodes
                  .toArray(new TreeGraphNode[tgPOSNodes.size()]));

      root.setIndex(0);

      // Build list of TypedDependencies
      List<TypedDependency> tdeps = new ArrayList<TypedDependency>(deps.size());

      for (String depString : deps) {
         int firstBracket = depString.indexOf('(');
         if (firstBracket == -1) throwDepFormatException(depString);


         String type = depString.substring(0, firstBracket);

         if (depString.charAt(depString.length() - 1) != ')') throwDepFormatException(depString);

         String args = depString.substring(firstBracket + 1,
               depString.length() - 1);

         int argSep = args.indexOf(", ");
         if (argSep == -1) throwDepFormatException(depString);

         String parentArg = args.substring(0, argSep);
         String childArg  = args.substring(argSep + 2);
         int parentDash = parentArg.lastIndexOf('-');
         if (parentDash == -1) throwDepFormatException(depString);
         int childDash = childArg.lastIndexOf('-');
         if (childDash == -1) throwDepFormatException(depString);
         //System.err.printf("parentArg: %s\n", parentArg);
         int parentIdx = Integer.parseInt(parentArg.substring(parentDash+1).replace("'", ""));

         int childIdx = Integer.parseInt(childArg.substring(childDash+1).replace("'", ""));

         GrammaticalRelation grel = new GrammaticalRelation(GrammaticalRelation.Language.Any, type, null, null, DEPENDENT);

         TypedDependency tdep =
            new TypedDependency(grel, (parentIdx == 0 ? root: tgWordNodes.get(parentIdx-1)),
                                tgWordNodes.get(childIdx-1));
         tdeps.add(tdep);
      }

      // TODO add some elegant way to construct language
      // appropriate GrammaticalStructures (e.g., English, Chinese, etc.)
      return new GrammaticalStructure(tdeps, root) {
         private static final long serialVersionUID = 1L;
      };
   }

  public GrammaticalStructure(List<TypedDependency> projectiveDependencies, TreeGraphNode root) {
    super(root);
    allTypedDependencies = typedDependencies = new ArrayList<TypedDependency>(projectiveDependencies);
    dependencies = new HashSet<Dependency<Label, Label, Object>>();
    for (TypedDependency tdep : projectiveDependencies) {
      dependencies.add(new NamedDependency(tdep.gov().toString(), tdep.dep().toString(), tdep.reln()));
    }
  }

  public GrammaticalStructure(Tree t, Collection<GrammaticalRelation> relations,
                              HeadFinder hf, Filter<String> puncFilter) {
    this(t, relations, null, hf, puncFilter);
  }

  // @Override
  // public String toString() {
    // StringBuilder sb = new StringBuilder(super.toString());
    //    sb.append("Dependencies:");
    //    sb.append("\n" + dependencies);
    //    sb.append("Typed Dependencies:");
    //    sb.append("\n" + typedDependencies);
    //    sb.append("More Typed Dependencies:");
    //    sb.append("\n" + moreTypedDependencies());
    // return sb.toString();
  // }


  // cdm dec 2009: I changed this to automatically fail on preterminal nodes, since they shouldn't match for GR parent patterns.  Should speed it up.
  private static void analyzeNode(TreeGraphNode t, TreeGraphNode root, Collection<GrammaticalRelation> relations) {
    // if (t.numChildren() > 0) {          // don't do leaves
    if (t.isPhrasal()) {    // don't do leaves or preterminals!
      TreeGraphNode tHigh = t.highestNodeWithSameHead();
      for (GrammaticalRelation egr : relations) {
        if (egr.isApplicable(t)) {
          for (Tree u : egr.getRelatedNodes(t, root)) {
            tHigh.addArc(GrammaticalRelation.getAnnotationClass(egr), (TreeGraphNode) u);
          }
        }
      }
      // now recurse into children
      for (TreeGraphNode kid : t.children()) {
        analyzeNode(kid, root, relations);
      }
    }
  }


  /**
   * The constructor builds a list of typed dependencies using
   * information from a <code>GrammaticalStructure</code>.
   *
   * @param getExtra If true, the list of typed dependencies will contain extra ones.
   *              If false, the list of typed dependencies will respect the tree structure.
   */
  private List<TypedDependency> getDeps(boolean getExtra, Filter<TypedDependency> f) {
    List<TypedDependency> basicDep = Generics.newArrayList();

    for (Dependency<Label, Label, Object> d : dependencies()) {
      TreeGraphNode gov = (TreeGraphNode) d.governor();
      TreeGraphNode dep = (TreeGraphNode) d.dependent();
        //System.out.println("Gov: " + gov);
        //System.out.println("Dep: " + dep);
      GrammaticalRelation reln = getGrammaticalRelation(gov, dep);
        //System.out.println("Reln: " + reln);
      basicDep.add(new TypedDependency(reln, gov, dep));
    }

    // add the root
    TreeGraphNode dependencyRoot = new TreeGraphNode(new Word("ROOT"));
    dependencyRoot.setIndex(0);
    TreeGraphNode rootDep = null;
    Collection<TypedDependency> roots = getRoots(basicDep);
    if (roots.size() == 0) {
      // This can happen if the sentence has only one non-punctuation
      // word.  In that case, we still want to add the root->word
      // dependency, but we won't find any roots using the getRoots()
      // method.  Instead we use the HeadFinder and the tree.
      List<Tree> leaves = Trees.leaves(root());
      if (leaves.size() > 0) {
        Tree leaf = leaves.get(0);
        if (!(leaf instanceof TreeGraphNode)) {
          throw new AssertionError("Leaves should be TreeGraphNodes");
        }
        rootDep = (TreeGraphNode) leaf;
        if (rootDep.headWordNode() != null) {
          rootDep = rootDep.headWordNode();
        }
      }
    } else {
      // since roots.size() > 0, there must be at least one element
      Iterator<TypedDependency> iterator = roots.iterator();
      rootDep = iterator.next().gov();
    }
    if (rootDep != null) {
      TypedDependency rootTypedDep =
        new TypedDependency(ROOT, dependencyRoot, rootDep);
      if (f.accept(rootTypedDep)) {
        basicDep.add(rootTypedDep);
      }
    }

    if (getExtra) {
      TreeGraphNode rootTree = root();
      getDep(rootTree, basicDep, f); // adds stuff to basicDep
    }
    Collections.sort(basicDep);

    return basicDep;
  }


  /** Look through the tree t and adds to the List basicDep dependencies
   *  which aren't in it but which satisfy the filter f.
   *
   * @param t The tree to examine (not changed)
   * @param basicDep The list of dependencies which may be augmented
   * @param f Additional dependencies are added only if they pass this filter
   */
  private static void getDep(TreeGraphNode t, List<TypedDependency> basicDep,
                             Filter<TypedDependency> f) {
    if (t.isPhrasal()) {          // don't do leaves of POS tags (chris changed this from numChildren > 0 in 2010)
      Map<Class<? extends CoreAnnotation>, Set<TreeGraphNode>> depMap = getAllDependents(t);
      for (Class<? extends CoreAnnotation> depName : depMap.keySet()) {
        for (TreeGraphNode depNode : depMap.get(depName)) {
          TreeGraphNode gov = t.headWordNode();
          TreeGraphNode dep = depNode.headWordNode();
          if (gov != dep) {
            List<GrammaticalRelation> rels = getListGrammaticalRelation(t, depNode);
            if (!rels.isEmpty()) {
              for (GrammaticalRelation rel : rels) {
                TypedDependency newDep = new TypedDependency(rel, gov, dep);
                if (!basicDep.contains(newDep) && f.accept(newDep)) {
                  newDep.setExtra();
                  basicDep.add(newDep);
                }
              }
            }
          }
        }
      }
      // now recurse into children
      for (Tree kid : t.children()) {
        getDep((TreeGraphNode) kid, basicDep, f);
      }
    }
  }

  private static class NoPunctFilter implements Filter<Dependency<Label, Label, Object>> {
    private Filter<String> npf;

    NoPunctFilter(Filter<String> f) {
      this.npf = f;
    }

    public boolean accept(Dependency<Label, Label, Object> d) {
      if (d == null) {
        return false;
      }
      Label lab = d.dependent();
      if (lab == null) {
        return false;
      }
      return npf.accept(lab.value());
    }

    // Automatically generated by Eclipse
    private static final long serialVersionUID = -2319891944796663180L;
  } // end static class NoPunctFilter


  private static class NoPunctTypedDependencyFilter implements Filter<TypedDependency> {
    private Filter<String> npf;

    NoPunctTypedDependencyFilter(Filter<String> f) {
      this.npf = f;
    }

    public boolean accept(TypedDependency d) {
      if (d == null) return false;

      TreeGraphNode s = d.dep();
      if (s == null) return false;

      Label l = s.label();
      if (l == null) return false;

      return npf.accept(l.value());
    }

    // Automatically generated by Eclipse
    private static final long serialVersionUID = -2872766864289207468L;
  } // end static class NoPunctTypedDependencyFilter


  /**
   * Returns the set of (governor, dependent) dependencies in this
   * <code>GrammaticalStructure</code>.
   * @return The set of (governor, dependent) dependencies in this
   * <code>GrammaticalStructure</code>.
   */
  public Set<Dependency<Label, Label, Object>> dependencies() {
    return dependencies;
  }

  /**
   * Tries to return a <code>Set</code> of leaf (terminal) nodes
   * which are the {@link GrammaticalRelation#DEPENDENT
   * <code>DEPENDENT</code>}s of the given node <code>t</code>.
   * Probably, <code>t</code> should be a leaf node as well.
   *
   * @param t a leaf node in this <code>GrammaticalStructure</code>
   * @return a <code>Set</code> of nodes which are dependents of
   *         node <code>t</code>, or else <code>null</code>
   */
  public Set<TreeGraphNode> getDependents(TreeGraphNode t) {
    Set<TreeGraphNode> deps = Generics.newTreeSet();
    // todo [cdm]: Explore replacing this with direct iteration over Tree
    Set<Tree> nodes = root.subTrees();
    for (Iterator<Tree> it = nodes.iterator(); it.hasNext();) {
      TreeGraphNode node = (TreeGraphNode) it.next();
      TreeGraphNode gov = getGovernor(node);
      if (gov != null && gov == t) {
        deps.add(node);
      }
    }
    return deps;
  }

  /**
   * Tries to return a leaf (terminal) node which is the {@link
   * GrammaticalRelation#GOVERNOR
   * <code>GOVERNOR</code>} of the given node <code>t</code>.
   * Probably, <code>t</code> should be a leaf node as well.
   *
   * @param t a leaf node in this <code>GrammaticalStructure</code>
   * @return a node which is the governor for node
   *         <code>t</code>, or else <code>null</code>
   */
  public static TreeGraphNode getGovernor(TreeGraphNode t) {
    return getNodeInRelation(t, GOVERNOR);
  }

  public static TreeGraphNode getNodeInRelation(TreeGraphNode t, GrammaticalRelation r) {
    return t.followArcToNode(GrammaticalRelation.getAnnotationClass(r));
  }

  /**
   * Get GrammaticalRelation between gov and dep, and null if gov  is not the
   * governor of dep
   */
  public GrammaticalRelation getGrammaticalRelation(int govIndex, int depIndex) {
    TreeGraphNode gov = getNodeByIndex(govIndex);
    TreeGraphNode dep = getNodeByIndex(depIndex);
    return getGrammaticalRelation(gov, dep);
  }

  /**
   * Get GrammaticalRelation between gov and dep, and null if gov is not the
   * governor of dep
   */
  public static GrammaticalRelation getGrammaticalRelation(TreeGraphNode gov, TreeGraphNode dep) {
    GrammaticalRelation reln = GrammaticalRelation.DEPENDENT;
    TreeGraphNode govH = gov.highestNodeWithSameHead();
    TreeGraphNode depH = dep.highestNodeWithSameHead();
    /*System.out.println("gov node " + gov);
    System.out.println("govH " + govH);
    System.out.println("dep node " + dep);
    System.out.println("depH " + depH);*/

    // Set sortedSet = new TreeSet(new NameComparator());
    // sortedSet.addAll(govH.arcLabelsToNode(depH));
    // Set<Class<? extends GrammaticalRelationAnnotation>> arcLabels = sortedSet;
    Set<Class<? extends GrammaticalRelationAnnotation>> arcLabels = new TreeSet<Class<? extends GrammaticalRelationAnnotation>>(new NameComparator<Class<? extends GrammaticalRelationAnnotation>>());
    arcLabels.addAll(govH.arcLabelsToNode(depH));

    //System.out.println("arcLabels: " + arcLabels);

    for (Class<? extends GrammaticalRelationAnnotation> arcLabel : arcLabels) {
      if (arcLabel != null) {
        GrammaticalRelation reln2;
        try {
          reln2 = GrammaticalRelation.getRelation(arcLabel);
        } catch (Exception e) {
          continue;
        }
        //GrammaticalRelation reln2 = r;
        if (reln.isAncestor(reln2)) {
          reln = reln2;
        } else if (PRINT_DEBUGGING && ! reln2.isAncestor(reln)) {
          System.err.println("@@@\t" + reln + "\t" + reln2 + "\t" +
                             govH.label().get(CoreAnnotations.ValueAnnotation.class) + "\t" + depH.label().get(CoreAnnotations.ValueAnnotation.class));
        }
      }
    }
    if (PRINT_DEBUGGING && reln.equals(GrammaticalRelation.DEPENDENT)) {
      String topCat = govH.label().get(CoreAnnotations.ValueAnnotation.class);
      String topTag = govH.label().get(HeadTagAnnotation.class).value();
      String topWord = govH.label().get(HeadWordAnnotation.class).value();
      String botCat = depH.label().get(CoreAnnotations.ValueAnnotation.class);
      String botTag = depH.label().get(HeadTagAnnotation.class).value();
      String botWord = depH.label().get(HeadWordAnnotation.class).value();
      System.err.println("### dep\t" + topCat + "\t" + topTag + "\t" + topWord +
                         "\t" + botCat + "\t" + botTag + "\t" + botWord + "\t");
    }
    return reln;
  }


  /**
   * Get a list of GrammaticalRelation between gov and dep. Useful for getting extra dependencies, in which
   * two nodes can be linked by multiple arcs.
   */
  public static List<GrammaticalRelation> getListGrammaticalRelation(TreeGraphNode gov, TreeGraphNode dep) {
    List<GrammaticalRelation> list = new ArrayList<GrammaticalRelation>();
    TreeGraphNode govH = gov.highestNodeWithSameHead();
    TreeGraphNode depH = dep.highestNodeWithSameHead();

    /*System.out.println("Extra gov node " + gov);
    System.out.println("govH " + govH);
    System.out.println("dep node " + dep);
    System.out.println("depH " + depH);*/

    Set<Class<? extends GrammaticalRelationAnnotation>> arcLabels = govH.arcLabelsToNode(depH);
    //System.out.println("arcLabels: " + arcLabels);
    if (dep != depH) {
      Set<Class<? extends GrammaticalRelationAnnotation>> arcLabels2 = govH.arcLabelsToNode(dep);
      //System.out.println("arcLabels2: " + arcLabels2);
      arcLabels.addAll(arcLabels2);
    }
    //System.out.println("arcLabels: " + arcLabels);

    for (Class<? extends GrammaticalRelationAnnotation> arcLabel : arcLabels) {
      if (arcLabel != null) {
        GrammaticalRelation reln2 = GrammaticalRelation.getRelation(arcLabel);
        if (!list.isEmpty()) {
          for (int i = 0; i < list.size(); i++) {
            GrammaticalRelation gr = list.get(i);
            //if the element in the list is an ancestor of the current relation, replace it
            if (gr.isAncestor(reln2)) {
              int index = list.indexOf(gr);
              list.set(index, reln2);
            }
            //if the relation is not an ancestor of an element in the list, we add the relation
            else if (!reln2.isAncestor(gr)) {
              list.add(reln2);
            }

          }
        } else {
          list.add(reln2);
        }
      }
    }
    //System.out.println("in list " + list);
    return list;
  }

  /**
   * Returns the typed dependencies of this grammatical structure.  These
   * are basic word-level typed dependencies, where each word other than the
   * root of the sentence is dependent on one other word, and the
   * dependencies have a tree structure.
   *
   * @return The typed dependencies of this grammatical structure
   */
  public Collection<TypedDependency> typedDependencies() {
    return typedDependencies(false);
  }


  /**
   * Returns all the typed dependencies of this grammatical structure.
   * These are like the basic (uncollapsed) dependencies, but may include
   * extra arcs for control relationships, etc.
   */
  public Collection<TypedDependency> allTypedDependencies() {
    return typedDependencies(true);
  }


  /**
   * Returns the typed dependencies of this grammatical structure.
   * <p/>
   * If the boolean argument is true, the list of typed dependencies
   * returned may include "extras", and does not follow a tree structure.
   */
  public List<TypedDependency> typedDependencies(boolean includeExtras) {
    List<TypedDependency> deps = includeExtras ? allTypedDependencies
                                                       : typedDependencies;
    correctDependencies(deps);
    return deps;
  }

  /**
   * Get the typed dependencies after collapsing them.
   * Collapsing dependencies refers to turning certain function words
   * such as prepositions and conjunctions into arcs, so they disappear from
   * the set of nodes.
   * There is no guarantee that the dependencies are a tree. While the
   * dependencies are normally tree-like, the collapsing may introduce
   * not only re-entrancies but even small cycles.
   *
   * @return A set of collapsed dependencies
   */
  public Collection<TypedDependency> typedDependenciesCollapsed() {
    return typedDependenciesCollapsed(false);
  }

  /**
   * Get the typed dependencies after mostly collapsing them, but keep a tree
   * structure.  In order to do this, the code does:
   * <ol>
   * <li> no relative clause processing
   * <li> no xsubj relations
   * <li> no propagation of conjuncts
   * </ol>
   *
   * @return collapsed dependencies keeping a tree structure
   */
  public Collection<TypedDependency> typedDependenciesCollapsedTree() {
    List<TypedDependency> tdl = typedDependencies(false);
    collapseDependenciesTree(tdl);
    return tdl;
  }

  /**
   * Get the typed dependencies after collapsing them.
   * <p/>
   * If the boolean argument is true, the list of typed dependencies
   * returned may include "extras".
   *
   * @return collapsed dependencies
   */
  public List<TypedDependency> typedDependenciesCollapsed(boolean includeExtras) {
    List<TypedDependency> tdl = typedDependencies(includeExtras);
    collapseDependencies(tdl, false);
    return tdl;
  }


  /**
   * Get the typed dependencies after collapsing them and processing eventual
   * CC complements.  The effect of this part is to distributed conjoined
   * arguments across relations or conjoined predicates across their arguments.
   * This is generally useful, and we generally recommend using the output of
   * this method with the second argument being <code>true</code>.
   *
   * @param includeExtras If true, the list of typed dependencies
   * returned may include "extras", such as controlled subject links.
   * @return collapsed dependencies with CC processed
   */
  public List<TypedDependency> typedDependenciesCCprocessed(boolean includeExtras) {
    List<TypedDependency> tdl = typedDependencies(includeExtras);
    collapseDependencies(tdl, true);
    return tdl;
  }


  /**
   * Get a list of the typed dependencies, including extras like control
   * dependencies, collapsing them and distributing relations across
   * coordination.  This method is generally recommended for best
   * representing the semantic and syntactic relations of a sentence. In
   * general it returns a directed graph (i.e., the output may not be a tree
   * and it may contain (small) cycles).
   *
   * @return collapsed dependencies with CC processed
   */
  public List<TypedDependency> typedDependenciesCCprocessed() {
    return typedDependenciesCCprocessed(true);
  }


  /**
   * Destructively modify the <code>Collection&lt;TypedDependency&gt;</code> to collapse
   * language-dependent transitive dependencies.
   * <p/>
   * Default is no-op; to be over-ridden in subclasses.
   *
   * @param list A list of dependencies to process for possible collapsing
   * @param CCprocess apply CC process?
   */
  protected void collapseDependencies(List<TypedDependency> list, boolean CCprocess) {
    // do nothing as default operation
  }

  /**
   * Destructively modify the <code>Collection&lt;TypedDependency&gt;</code> to collapse
   * language-dependent transitive dependencies but keeping a tree structure.
   * <p/>
   * Default is no-op; to be over-ridden in subclasses.
   *
   * @param list A list of dependencies to process for possible collapsing
   *
   */
  protected void collapseDependenciesTree(List<TypedDependency> list) {
    // do nothing as default operation
  }


  /**
   * Destructively modify the <code>TypedDependencyGraph</code> to correct
   * language-dependent dependencies. (e.g., nsubjpass in a relative clause)
   * <p/>
   * Default is no-op; to be over-ridden in subclasses.
   *
   */
  protected void correctDependencies(Collection<TypedDependency> list) {
    // do nothing as default operation
  }


  /**
   * Returns the dependency path as a list of String, from node to root, it is assumed that
   * that root is an ancestor of node
   *
   * @return A list of dependency labels
   */
  public List<String> getDependencyPath(int nodeIndex, int rootIndex) {
    TreeGraphNode node = getNodeByIndex(nodeIndex);
    TreeGraphNode rootTree = getNodeByIndex(rootIndex);
    return getDependencyPath(node, rootTree);
  }

  /**
   * Returns the dependency path as a list of String, from node to root, it is assumed that
   * that root is an ancestor of node
   *
   * @param node Note to return path from
   * @param root The root of the tree, an ancestor of node
   * @return A list of dependency labels
   */
  // used only by unused method above.
  private static List<String> getDependencyPath(TreeGraphNode node, TreeGraphNode root) {
    List<String> path = new ArrayList<String>();
    while (!node.equals(root)) {
      TreeGraphNode gov = getGovernor(node);
      // System.out.println("Governor for \"" + node.value() + "\": \"" + gov.value() + "\"");
      List<GrammaticalRelation> relations = getListGrammaticalRelation(gov, node);
      StringBuilder sb = new StringBuilder();
      for (GrammaticalRelation relation : relations) {
        //if (!arcLabel.equals(GOVERNOR))
        sb.append((sb.length() == 0 ? "" : "+")).append(relation.toString());
      }
      path.add(sb.toString());
      node = gov;
    }
    return path;
  }

  /**
   * Returns all the dependencies of a certain node.
   *
   * @param node The node to return dependents for
   * @return map of dependencies
   */
  private static Map<Class<? extends CoreAnnotation>, Set<TreeGraphNode>> getAllDependents(TreeGraphNode node) {
    Map<Class<? extends CoreAnnotation>, Set<TreeGraphNode>> newMap = Generics.newHashMap();

    for (Class<?> o : node.label.keySet()) {
      try {
        // The line below will exception unless it's a GrammaticalRelationAnnotation,
        // so the effect is that only the GrammaticalRelationAnnotation things get put into newMap
        o.asSubclass(GrammaticalRelationAnnotation.class);
        newMap.put((Class<? extends CoreAnnotation>) o, (Set<TreeGraphNode>) node.label.get((Class<? extends CoreAnnotation>) o));//javac doesn't compile properly if generics are fully specified (but eclipse does...)
      } catch (Exception e) {
        // ignore a non-GrammaticalRelationAnnotation element
      }
    }
    return newMap;
  }


  /**
   * Checks if all the typeDependencies are connected
   * @param list a list of typedDependencies
   * @return true if the list represents a connected graph, false otherwise
   */
  public static boolean isConnected(Collection<TypedDependency> list) {
    return getRoots(list).size() <= 1; // there should be no more than one root to have a connected graph
                                         // there might be no root in the way we look when you have a relative clause
                                         // ex.: Apple is a society that sells computers
                                         // (the root "society" will also be the nsubj of "sells")
  }

  /**
   * Return a list of TypedDependencies which are not dependent on any node from the list.
   *
   * @param list The list of TypedDependencies to check
   * @return A list of TypedDependencies which are not dependent on any node from the list
   */
  public static Collection<TypedDependency> getRoots(Collection<TypedDependency> list) {

    Collection<TypedDependency> roots = new ArrayList<TypedDependency>();

    // need to see if more than one governor is not listed somewhere as a dependent
    // first take all the deps
    Collection<TreeGraphNode> deps = new HashSet<TreeGraphNode>();
    for (TypedDependency typedDep : list) {
      deps.add(typedDep.dep());
    }

    // go through the list and add typedDependency for which the gov is not a dep
    Collection<TreeGraphNode> govs = new HashSet<TreeGraphNode>();
    for (TypedDependency typedDep : list) {
      TreeGraphNode gov = typedDep.gov();
      if (!deps.contains(gov) && !govs.contains(gov)) {
        roots.add(typedDep);
      }
      govs.add(gov);
    }
    return roots;
  }

  private static final long serialVersionUID = 2286294455343892678L;

  private static class NameComparator<X> implements Comparator<X> {
    public int compare(X o1, X o2) {
      String n1 = o1.toString();
      String n2 = o2.toString();
      return n1.compareTo(n2);
    }
  }


  public static final String DEFAULT_PARSER_FILE = "/u/nlp/data/lexparser/englishPCFG.ser.gz";

  /**
   * Print typed dependencies in either the Stanford dependency representation
   * or in the conllx format.
   *
   * @param deps
   *          Typed dependencies to print
   * @param tree
   *          Tree corresponding to typed dependencies (only necessary if conllx
   *          == true)
   * @param conllx
   *          If true use conllx format, otherwise use Stanford representation
   * @param extraSep
   *          If true, in the Stanford representation, the extra dependencies
   *          (which do not preserve the tree structure) are printed after the
   *          basic dependencies
   */
  public static void printDependencies(GrammaticalStructure gs, Collection<TypedDependency> deps, Tree tree, boolean conllx, boolean extraSep) {
    System.out.println(dependenciesToString(gs, deps, tree, conllx, extraSep));
  }

  public static String dependenciesToString(GrammaticalStructure gs, Collection<TypedDependency> deps, Tree tree, boolean conllx, boolean extraSep) {
    StringBuilder bf = new StringBuilder();

    Map<Integer, Integer> indexToPos = new HashMap<Integer, Integer>();
    indexToPos.put(0,0); // to deal with the special node "ROOT"
    List<Tree> gsLeaves = gs.root.getLeaves();
    for (int i = 0; i < gsLeaves.size(); i++) {
      TreeGraphNode leaf = (TreeGraphNode) gsLeaves.get(i);
      indexToPos.put(leaf.label.index(), i + 1);
    }

    if (conllx) {
      List<Tree> leaves = tree.getLeaves();
      List<String> words = new ArrayList<String>(leaves.size());
      List<String> pos = new ArrayList<String>(leaves.size());
      String[] relns = new String[leaves.size()];
      int[] govs = new int[leaves.size()];

      for (Tree leaf : leaves) {
        words.add(leaf.value());
        pos.add(leaf.parent(tree).value()); // use slow, but safe, parent look up
      }

      for (TypedDependency dep : deps) {
        int depPos = indexToPos.get(dep.dep().index()) - 1;
        govs[depPos] = indexToPos.get(dep.gov().index());
        relns[depPos] = dep.reln().toString();
      }

      for (int i = 0; i < relns.length; i++) {
        String out = String.format("%d\t%s\t_\t%s\t%s\t_\t%d\t%s\t_\t_\n", i + 1, words.get(i), pos.get(i), pos.get(i), govs[i], (relns[i] != null ? relns[i] : "erased"));
        bf.append(out);
      }

    } else {
      if (extraSep) {
        List<TypedDependency> extraDeps = new ArrayList<TypedDependency>();
        for (TypedDependency dep : deps) {
          if (dep.extra()) {
            extraDeps.add(dep);
          } else {
            bf.append(toStringIndex(dep, indexToPos));
            bf.append("\n");
          }
        }
        // now we print the separator for extra dependencies, and print these if
        // there are some
        if (!extraDeps.isEmpty()) {
          bf.append("======\n");
          for (TypedDependency dep : extraDeps) {
            bf.append(toStringIndex(dep, indexToPos));
            bf.append("\n");
          }
        }
      } else {
        for (TypedDependency dep : deps) {
          bf.append(toStringIndex(dep, indexToPos));
          bf.append("\n");
        }
      }
    }

    return bf.toString();
  }

  private static String toStringIndex(TypedDependency td, Map<Integer, Integer> indexToPos) {
    TreeGraphNode gov = td.gov();
    TreeGraphNode dep = td.dep();
    return td.reln() + "(" + gov.value() + "-" + indexToPos.get(gov.index()) + gov.toPrimes() + ", " + dep.value() + "-" + indexToPos.get(dep.index()) + dep.toPrimes() + ")";
  }


  // Note that these field constants are 0-based whereas much documentation is 1-based

  public static final int CoNLLX_WordField = 1;
  public static final int CoNLLX_POSField = 3;
  public static final int CoNLLX_GovField = 6;
  public static final int CoNLLX_RelnField = 7;

  public static final int CoNLLX_FieldCount = 10;

  /**
   * Read in a file containing a CoNLL-X dependency treebank and return a
   * corresponding list of GrammaticalStructures.
   *
   * @throws IOException
   */
  public static List<GrammaticalStructure> readCoNLLXGrammaticStructureCollection(String fileName, Map<String, GrammaticalRelation> shortNameToGRel, GrammaticalStructureFromDependenciesFactory factory) throws IOException {
    LineNumberReader reader = new LineNumberReader(new FileReader(fileName));
    List<GrammaticalStructure> gsList = new LinkedList<GrammaticalStructure>();

    List<List<String>> tokenFields = new ArrayList<List<String>>();

    for (String inline = reader.readLine(); inline != null;
         inline = reader.readLine()) {
      if (!"".equals(inline)) {
        // read in a single sentence token by token
        List<String> fields = Arrays.asList(inline.split("\t"));
        if (fields.size() != CoNLLX_FieldCount) {
          throw new RuntimeException(String.format("Error (line %d): 10 fields expected but %d are present", reader.getLineNumber(), fields.size()));
        }
        tokenFields.add(fields);
      } else {
        if (tokenFields.isEmpty())
          continue; // skip excess empty lines

        gsList.add(buildCoNNLXGrammaticStructure(tokenFields, shortNameToGRel, factory));
        tokenFields = new ArrayList<List<String>>();
      }
    }

    return gsList;
  }

  public static GrammaticalStructure
  buildCoNNLXGrammaticStructure(List<List<String>> tokenFields,
                                Map<String, GrammaticalRelation> shortNameToGRel,
                                GrammaticalStructureFromDependenciesFactory factory) {
    List<TreeGraphNode> tgWordNodes =
      new ArrayList<TreeGraphNode>(tokenFields.size());
    List<TreeGraphNode> tgPOSNodes =
      new ArrayList<TreeGraphNode>(tokenFields.size());

    SemanticHeadFinder headFinder = new SemanticHeadFinder();

    // Construct TreeGraphNodes for words and POS tags
    for (List<String> fields : tokenFields) {
      TreeGraphNode word =
        new TreeGraphNode(new Word(fields.get(CoNLLX_WordField)));
      TreeGraphNode pos =
        new TreeGraphNode(new Word(fields.get(CoNLLX_POSField)));
      tgWordNodes.add(word);
      tgPOSNodes.add(pos);
      TreeGraphNode[] childArr = { word };
      pos.setChildren(childArr);
      word.setParent(pos);
      pos.percolateHeads(headFinder);
    }

    // We fake up the parts of the tree structure that are not
    // actually used by the grammatical relation transformation
    // operations.
    //
    // That is, the constructed TreeGraphs consist of a flat tree,
    // without any phrase bracketing, but that does preserve the
    // parent child relationship between words and their POS tags.
    //
    // e.g. (ROOT (PRP I) (VBD hit) (DT the) (NN ball) (. .))
    // cdm Nov 2009: This next bit wasn't used so I commented it out
    // List<List<Integer>> children = new
    // ArrayList<List<Integer>>(tokenFields.size());
    // for (int i = 0; i < tgWordNodes.size(); i++) {
    //   children.add(new ArrayList<Integer>());
    // }
    
    TreeGraphNode root = 
      new TreeGraphNode(new Word("ROOT-" + (tgWordNodes.size() + 1)));
    root.setChildren(tgPOSNodes.toArray(new TreeGraphNode[tgPOSNodes.size()]));

    // Build list of TypedDependencies
    List<TypedDependency> tdeps =
      new ArrayList<TypedDependency>(tgWordNodes.size());

    for (int i = 0; i < tgWordNodes.size(); i++) {
      String parentIdStr = tokenFields.get(i).get(CoNLLX_GovField);
      if (parentIdStr == null || parentIdStr.equals(""))
        continue;
      int parentId = Integer.parseInt(parentIdStr) - 1;
      String grelString = tokenFields.get(i).get(CoNLLX_RelnField);
      if (grelString.equals("null"))
        continue;
      GrammaticalRelation grel = shortNameToGRel.get(grelString.toLowerCase());
      if (grel == null && grelString.toLowerCase().equals("root")) continue;
      
      if (grel == null) {
        
        throw new RuntimeException("Unknown grammatical relation '" +
                                   grelString + "' fields: " +
                                   tokenFields.get(i) + "\nNode: " +
                                   tgWordNodes.get(i) + "\n" +
                                   "Known Grammatical relations: ["+shortNameToGRel.keySet()+"]" );
        
      }
      TypedDependency tdep =
        new TypedDependency(grel, (parentId == -1 ? root : tgWordNodes.get(parentId)),
                            tgWordNodes.get(i));
      tdeps.add(tdep);
    }
    return factory.build(tdeps, root);
  }


  private static String[] parseClassConstructArgs(String namePlusArgs) {
    String[] args = StringUtils.EMPTY_STRING_ARRAY;
    String name = namePlusArgs;
    if (namePlusArgs.matches(".*\\([^)]*\\)$")) {
      String argStr = namePlusArgs.replaceFirst("^.*\\(([^)]*)\\)$", "$1");
      args = argStr.split(",");
      name = namePlusArgs.replaceFirst("\\([^)]*\\)$", "");
    }
    String[] tokens = new String[1 + args.length];
    tokens[0] = name;
    System.arraycopy(args, 0, tokens, 1, args.length);
    return tokens;
  }


  private static DependencyReader loadAlternateDependencyReader(String altDepReaderName) {
    Class<? extends DependencyReader> altDepReaderClass = null;
    String[] toks = parseClassConstructArgs(altDepReaderName);
    altDepReaderName = toks[0];
    String[] depReaderArgs = new String[toks.length - 1];
    System.arraycopy(toks, 1, depReaderArgs, 0, toks.length - 1);

    try {
      Class<?> cl = Class.forName(altDepReaderName);
      altDepReaderClass = cl.asSubclass(DependencyReader.class);
    } catch (ClassNotFoundException e) {
      // have a second go below
    }
    if (altDepReaderClass == null) {
      try {
        Class<?> cl = Class.forName("edu.stanford.nlp.trees." + altDepReaderName);
        altDepReaderClass = cl.asSubclass(DependencyReader.class);
      } catch (ClassNotFoundException e) {
          //
      }
    }
    if (altDepReaderClass == null) {
      System.err.println("Can't load dependency reader " + altDepReaderName + " or edu.stanford.nlp.trees." + altDepReaderName);
      return null;
    }

    DependencyReader altDepReader; // initialized below
    if (depReaderArgs.length == 0) {
      try {
        altDepReader = altDepReaderClass.newInstance();
      } catch (InstantiationException e) {
        throw new RuntimeException(e);
      } catch (IllegalAccessException e) {
        System.err.println("No argument constructor to " + altDepReaderName + " is not public");
        return null;
      }
    } else {
      try {
        altDepReader = altDepReaderClass.getConstructor(String[].class).newInstance((Object) depReaderArgs);
      } catch (IllegalArgumentException e) {
        throw new RuntimeException(e);
      } catch (SecurityException e) {
        throw new RuntimeException(e);
      } catch (InstantiationException e) {
        e.printStackTrace();
        return null;
      } catch (IllegalAccessException e) {
        System.err.println(depReaderArgs.length + " argument constructor to " + altDepReaderName + " is not public.");
        return null;
      } catch (InvocationTargetException e) {
        throw new RuntimeException(e);
      } catch (NoSuchMethodException e) {
        System.err.println("String arguments constructor to " + altDepReaderName + " does not exist.");
        return null;
      }
    }
    return altDepReader;
  }


  private static DependencyPrinter loadAlternateDependencyPrinter(String altDepPrinterName) {
    Class<? extends DependencyPrinter> altDepPrinterClass = null;
    String[] toks = parseClassConstructArgs(altDepPrinterName);
    altDepPrinterName = toks[0];
    String[] depPrintArgs = new String[toks.length - 1];
    System.arraycopy(toks, 1, depPrintArgs, 0, toks.length - 1);

    try {
      Class<?> cl = Class.forName(altDepPrinterName);
      altDepPrinterClass = cl.asSubclass(DependencyPrinter.class);
    } catch (ClassNotFoundException e) {
      //
    }
    if (altDepPrinterClass == null) {
      try {
        Class<?> cl = Class.forName("edu.stanford.nlp.trees." + altDepPrinterName);
        altDepPrinterClass = cl.asSubclass(DependencyPrinter.class);
      } catch (ClassNotFoundException e) {
        //
      }
    }
    if (altDepPrinterClass == null) {
      System.err.printf("Unable to load alternative printer %s or %s. Is your classpath set correctly?\n", altDepPrinterName, "edu.stanford.nlp.trees." + altDepPrinterName);
      return null;
    }
    try {
      DependencyPrinter depPrinter;
      if (depPrintArgs.length == 0) {
        depPrinter = altDepPrinterClass.newInstance();
      } else {
        depPrinter = altDepPrinterClass.getConstructor(String[].class).newInstance((Object) depPrintArgs);
      }
      return depPrinter;
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
      return null;
    } catch (SecurityException e) {
      e.printStackTrace();
      return null;
    } catch (InstantiationException e) {
      e.printStackTrace();
      return null;
    } catch (IllegalAccessException e) {
      e.printStackTrace();
      return null;
    } catch (InvocationTargetException e) {
      e.printStackTrace();
      return null;
    } catch (NoSuchMethodException e) {
      if (depPrintArgs == null) {
        System.err.printf("Can't find no-argument constructor %s().\n", altDepPrinterName);
      } else {
        System.err.printf("Can't find constructor %s(%s).\n", altDepPrinterName, Arrays.toString(depPrintArgs));
      }
      return null;
    }
  }

  private static Function<Object, Tree> loadParser(String parserFile, String parserOptions, boolean makeCopulaHead) {
    if (parserFile == null || "".equals(parserFile)) {
      parserFile = DEFAULT_PARSER_FILE;
      if (parserOptions == null) {
        parserOptions = "-retainTmpSubcategories";
      }
    }
    if (parserOptions == null) {
      parserOptions = "";
    }
    if (makeCopulaHead) {
      parserOptions = "-makeCopulaHead " + parserOptions;
    }
    parserOptions = parserOptions.trim();
    // Load parser by reflection, so that this class doesn't require parser
    // for runtime use
    // LexicalizedParser lp = new LexicalizedParser(parserFile);
    Function<Object, Tree> lp;
    try {
      Class<?>[] classes = new Class<?>[] { String.class, String[].class };
      Method method = Class.forName("edu.stanford.nlp.parser.lexparser.LexicalizedParser").getMethod("loadModel", classes);
      String[] opts = {};
      if (parserOptions.length() > 0) {
        opts = parserOptions.split(" +");
      }
      lp = (Function) method.invoke(null, parserFile, opts);
    } catch (Exception cnfe) {
      throw new RuntimeException(cnfe);
    }
    return lp;
  }

  private static boolean loadTreebankByParsing(Treebank tb, String sentFileName, String encoding, boolean tokenized, Function<Object, Tree> lp) {
    BufferedReader reader;
    try {
      reader = new BufferedReader(new InputStreamReader(new FileInputStream(sentFileName), encoding));
    } catch (IOException e) {
      System.err.println("Cannot open file " + sentFileName);
      return true;
    }
    try {
      System.err.println("Processing sentence file " + sentFileName);
      for (String line; (line = reader.readLine()) != null;) {
        // System.out.println("Processing sentence: " + line);
        Reader lineReader = new StringReader(line);
        List<Word> words;
        if (tokenized) {
          words = WhitespaceTokenizer.newWordWhitespaceTokenizer(lineReader).tokenize();
        } else {
          words = PTBTokenizer.newPTBTokenizer(lineReader).tokenize();
        }
        if (!words.isEmpty()) {
          // the parser throws an exception if told to parse an empty sentence.
          Tree parseTree = lp.apply(words);
          tb.add(parseTree);
        }
      }
      reader.close();
    } catch (IOException e) {
      System.err.println("IOException reading key file " + sentFileName);
      e.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * Allow a collection of trees, that is a Treebank, appear to be a collection
   * of GrammaticalStructures.
   *
   * @author danielcer
   *
   */
  private static class TreeBankGrammaticalStructureWrapper extends AbstractCollection<GrammaticalStructure> {

    private final Treebank treebank;
    private final boolean keepPunct;
    private final TreebankLangParserParams params;

    private Map<GrammaticalStructure, Tree> origTrees = new WeakHashMap<GrammaticalStructure, Tree>();

    public TreeBankGrammaticalStructureWrapper(Treebank wrappedTreeBank, boolean keepPunct, TreebankLangParserParams params) {
      treebank = wrappedTreeBank;
      this.keepPunct = keepPunct;
      this.params = params;
    }

    @Override
    public Iterator<GrammaticalStructure> iterator() {
      return new GsIterator();
    }

    public Tree getOriginalTree(GrammaticalStructure gs) {
      return origTrees.get(gs);
    }

    private class GsIterator implements Iterator<GrammaticalStructure> {

      private final Iterator<Tree> tbIterator = treebank.iterator();
      private final Filter<String> puncFilter;
      private final HeadFinder hf;
      private GrammaticalStructure next;

      public GsIterator() {
        // TODO: this is very english specific
        if (keepPunct) {
          puncFilter = Filters.acceptFilter();
        } else {
          puncFilter = new PennTreebankLanguagePack().punctuationWordRejectFilter();
        }
        hf = params.typedDependencyHeadFinder();
        primeGs();
      }

      private void primeGs() {
        GrammaticalStructure gs = null;
        while (gs == null && tbIterator.hasNext()) {
          Tree t = tbIterator.next();
          if (t == null) {
            continue;
          }
          try {
            gs = params.getGrammaticalStructure(t, puncFilter, hf);
            origTrees.put(gs, t);
            next = gs;
            return;
          } catch (NullPointerException npe) {
            System.err.println("Bung (empty?) tree caused below dump. Continuing....");
            npe.printStackTrace();
          }
        }
        next = null;
      }

      public boolean hasNext() {
        return next != null;
      }

      public GrammaticalStructure next() {
        GrammaticalStructure ret = next;
        primeGs();
        return ret;
      }

      public void remove() {
        throw new UnsupportedOperationException();
      }

    }

    @Override
    public int size() {
      return treebank.size();
    }

  } // end static class TreebankGrammaticalStructureWrapper


  /**
   * Given sentences or trees, output the typed dependencies.
   * <p>

   * By default, the method outputs the collapsed typed dependencies with
   * processing of conjuncts. The input can be given as plain text (one sentence
   * by line) using the option -sentFile, or as trees using the option
   * -treeFile. For -sentFile, the input has to be strictly one sentence per
   * line. You can specify where to find a parser with -parserFile
   * serializedParserPath. See LexicalizedParser for more flexible processing of
   * text files (including with Stanford Dependencies output). The above options
   * assume a file as input. You can also feed trees (only) via stdin by using
   * the option -filter.  If one does not specify a -parserFile, one
   * can specify which language pack to use with -tLPP, This option
   * specifies a class which determines which GrammaticalStructure to
   * use, which HeadFinder to use, etc.  It will default to
   * edu.stanford.nlp.parser.lexparser.EnglishTreebankParserParams,
   * but any TreebankLangParserParams can be specified.
   * <p>
   * If no method of producing trees is given other than to use the
   * LexicalizedParser, but no parser is specified, a default parser
   * is used, the English parser.  You can specify options to load
   * with the parser using the -parserOpts flag.  If the default
   * parser is used, and no options are provided, the option
   * -retainTmpSubcategories is used.
   * <p>
   * The following options can be used to specify the types of dependencies
   * wanted: <br/>
   * -collapsed collapsed dependencies <br/>
   * -basic non-collapsed dependencies that preserve a tree structure<br/>
   * -nonCollapsed non-collapsed dependencies that do not preserve a tree
   * structure (the basic dependencies plus the extra ones)</br> -CCprocessed
   * collapsed dependencies and conjunctions processed (dependencies are added
   * for each conjunct) -- this is the default if no option are passed <br/>
   * -collapsedTree collapsed dependencies retaining a tree structure
   * -makeCopulaHead Contrary to the approach argued for in the SD papers,
   *  nevertheless make the verb 'to be' the head, not the predicate noun, adjective,
   *  etc.
   * <br/>
   * The -conllx option will output the dependencies into the CoNLL format,
   * instead of in the standard Stanford format (relation(governor,dependent)) and will retain punctuation by default
   * (where punctuation will be attached to the root of the sentence with the "punct" relation).
   * When used in the "collapsed" format, words such as prepositions, conjunctions which get collapsed into the grammatical relations
   * and are not part of the sentence per se anymore will be annotated with "erased" as grammatical relation and attached to the fake "ROOT" node
   * with index 0.
   * <p/>
   * There is also an option to retain dependencies involving punctuation:
   * -keepPunct <br/>
   * The -extraSep option used with -nonCollapsed will print the basic
   * dependencies first, then a separator ======, and then the extra
   * dependencies that do not preserve the tree structure. The -test option is
   * used for debugging: it prints the grammatical structure, as well as the
   * basic, collapsed and CCprocessed dependencies. It also checks the
   * connectivity of the collapsed dependencies. If the collapsed dependencies
   * list doesn't constitute a connected graph, it prints the possible offending
   * nodes (one of them is the real root of the graph).
   * <p/>
   * Using the -conllxFile, you can pass a file containing Stanford dependencies
   * in the CoNLL format (e.g., the basic dependencies), and obtain another
   * representation using one of the representation options.
   * <p/>
   * Usage: <br/>
   * <code>java edu.stanford.nlp.trees.GrammaticalStructure [-treeFile FILE | -sentFile FILE | -conllxFile FILE | -filter] <br>
   * [-collapsed -basic -CCprocessed -test]</code>
   *
   * @param args
   *          Command-line arguments, as above
   */
  @SuppressWarnings("unchecked")
  public static void main(String[] args) {

    // System.out.print("GrammaticalRelations under DEPENDENT:");
    // System.out.println(DEPENDENT.toPrettyString());

    MemoryTreebank tb = new MemoryTreebank(new TreeNormalizer());
    Collection<GrammaticalStructure> gsBank = null;
    Properties props = StringUtils.argsToProperties(args);

    String encoding = props.getProperty("encoding", "utf-8");
    try {
      System.setOut(new PrintStream(System.out, true, encoding));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    String treeFileName = props.getProperty("treeFile");
    String sentFileName = props.getProperty("sentFile");
    String conllXFileName = props.getProperty("conllxFile");
    String altDepPrinterName = props.getProperty("altprinter");
    String altDepReaderName = props.getProperty("altreader");
    String altDepReaderFilename = props.getProperty("altreaderfile");

    String filter = props.getProperty("filter");

    boolean makeCopulaHead = props.getProperty("makeCopulaHead") != null;

    // TODO: if a parser is specified, load this from the parser
    // instead of ever loading it from this way
    String tLPP = props.getProperty("tLPP", "edu.stanford.nlp.parser.lexparser.EnglishTreebankParserParams");
    TreebankLangParserParams params = ReflectionLoading.loadByReflection(tLPP);
    if (makeCopulaHead) {
      // TODO: generalize and allow for more options
      String[] options = { "-makeCopulaHead" };
      params.setOptionFlag(options, 0);
    }

    if (sentFileName == null && (altDepReaderName == null || altDepReaderFilename == null) && treeFileName == null && conllXFileName == null && filter == null) {
      try {
        System.err.println("Usage: java GrammaticalStructure [options]* [-sentFile|-treeFile|-conllxFile file] [-testGraph]");
        System.err.println("  options: -basic, -collapsed, -CCprocessed [the default], -collapsedTree, -parseTree, -test, -parserFile file, -conllx, -keepPunct, -altprinter -altreader -altreaderfile");
        TreeReader tr = new PennTreeReader(new StringReader("((S (NP (NNP Sam)) (VP (VBD died) (NP-TMP (NN today)))))"));
        tb.add(tr.readTree());
      } catch (Exception e) {
        System.err.println("Horrible error: " + e);
        e.printStackTrace();
      }
    } else if (altDepReaderName != null && altDepReaderFilename != null) {
      DependencyReader altDepReader = loadAlternateDependencyReader(altDepReaderName);
      try {
        gsBank = altDepReader.readDependencies(altDepReaderFilename);
      } catch (IOException e) {
        System.err.println("Error reading " + altDepReaderFilename);
        return;
      }
    } else if (treeFileName != null) {
      tb.loadPath(treeFileName);
    } else if (filter != null) {
      tb.load(new BufferedReader(new InputStreamReader(System.in)));
    } else if (conllXFileName != null) {
      try {
        gsBank = params.readGrammaticalStructureFromFile(conllXFileName);
      } catch (RuntimeIOException e) {
        System.err.println("Error reading " + conllXFileName);
        return;
      }
    } else {
      String parserFile = props.getProperty("parserFile");
      String parserOpts = props.getProperty("parserOpts");
      boolean tokenized = props.getProperty("tokenized") != null;
      Function<Object, Tree> lp = loadParser(parserFile, parserOpts, makeCopulaHead);
      if (!loadTreebankByParsing(tb, sentFileName, encoding, tokenized, lp))
        return;

      // Instead of getting this directly from the LP, use reflection
      // so that a package which uses GrammaticalStructure doesn't
      // necessarily have to use LexicalizedParser
      try {
        Method method = lp.getClass().getMethod("getTLPParams");
        params = (TreebankLangParserParams) method.invoke(lp);
      } catch (Exception cnfe) {
        throw new RuntimeException(cnfe);
      }
    }

    // treats the output according to the options passed
    boolean basic = props.getProperty("basic") != null;
    boolean collapsed = props.getProperty("collapsed") != null;
    boolean CCprocessed = props.getProperty("CCprocessed") != null;
    boolean tree = props.getProperty("collapsedTree") != null;
    boolean nonCollapsed = props.getProperty("nonCollapsed") != null;
    boolean extraSep = props.getProperty("extraSep") != null;
    boolean parseTree = props.getProperty("parseTree") != null;
    boolean test = props.getProperty("test") != null;
    boolean keepPunct = props.getProperty("keepPunct") != null;
    boolean conllx = props.getProperty("conllx") != null;
    boolean checkConnected = props.getProperty("checkConnected") != null;
    boolean portray = props.getProperty("portray") != null;

    // make keepPunct default if conllx is turned on
    if(conllx) {
      keepPunct = true;
    }

    // If requested load alternative printer
    DependencyPrinter altDepPrinter = null;
    if (altDepPrinterName != null) {
      altDepPrinter = loadAlternateDependencyPrinter(altDepPrinterName);
    }

    // System.err.println("First tree in tb is");
    // System.err.println(((MemoryTreebank) tb).get(0));

    Method m = null;
    if (test) {
      // see if we can use SemanticGraph(Factory) to check for being a DAG
      // Do this by reflection to avoid this becoming a dependency when we distribute the parser
      try {
        Class sgf = Class.forName("edu.stanford.nlp.trees.semgraph.SemanticGraphFactory");
        m = sgf.getDeclaredMethod("makeFromTree", GrammaticalStructure.class, boolean.class, boolean.class, boolean.class, boolean.class, boolean.class, boolean.class, Filter.class, String.class, int.class);
      } catch (Exception e) {
        System.err.println("Test cannot check for cycles in tree format (classes not available)");
      }
    }

    if (gsBank == null) {
      gsBank = new TreeBankGrammaticalStructureWrapper(tb, keepPunct, params);
    }

    for (GrammaticalStructure gs : gsBank) {

      Tree t;
      if (gsBank instanceof TreeBankGrammaticalStructureWrapper) {
        // System.err.println("Using TreeBankGrammaticalStructureWrapper branch");
        t = ((TreeBankGrammaticalStructureWrapper) gsBank).getOriginalTree(gs);
        // System.err.println("Tree is: ");
        // System.err.println(t);
      } else {
        // System.err.println("Using gs.root() branch");
        t = gs.root(); // recover tree
      }

      if (test) {// print the grammatical structure, the basic, collapsed and
        // CCprocessed

        System.out.println("============= parse tree =======================");
        t.pennPrint();
        System.out.println();

        System.out.println("------------- GrammaticalStructure -------------");
        System.out.println(gs);

        System.out.println("------------- basic dependencies ---------------");
        System.out.println(StringUtils.join(gs.typedDependencies(false), "\n"));

        System.out.println("------------- non-collapsed dependencies (basic + extra) ---------------");
        System.out.println(StringUtils.join(gs.typedDependencies(true), "\n"));

        System.out.println("------------- collapsed dependencies -----------");
        System.out.println(StringUtils.join(gs.typedDependenciesCollapsed(true), "\n"));

        System.out.println("------------- collapsed dependencies tree -----------");
        System.out.println(StringUtils.join(gs.typedDependenciesCollapsedTree(), "\n"));

        System.out.println("------------- CCprocessed dependencies --------");
        System.out.println(StringUtils.join(gs.typedDependenciesCCprocessed(true), "\n"));

        System.out.println("-----------------------------------------------");
        // connectivity test
        boolean connected = GrammaticalStructure.isConnected(gs.typedDependenciesCollapsed(true));
        System.out.println("collapsed dependencies form a connected graph: " + connected);
        if (!connected) {
          System.out.println("possible offending nodes: " + GrammaticalStructure.getRoots(gs.typedDependenciesCollapsed(true)));
        }

        // test for collapsed dependencies being a tree:
        // make sure at least it doesn't contain cycles (i.e., is a DAG)
        // Do this by reflection so parser doesn't need SemanticGraph and its
        // libraries
        if (m != null) {
          try {
            // the first arg is null because it's a static method....
            Object semGraph = m.invoke(null, gs, false, true, false, false, false, false, null, null, 0);
            Class sg = Class.forName("edu.stanford.nlp.trees.semgraph.SemanticGraph");
            Method mDag = sg.getDeclaredMethod("isDag");
            boolean isDag = (Boolean) mDag.invoke(semGraph);

            System.out.println("tree dependencies form a DAG: " + isDag);
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      }// end of "test" output

      else {
        if (parseTree) {
          System.out.println("============= parse tree =======================");
          t.pennPrint();
          System.out.println();
        }

        if (basic) {
          if (collapsed || CCprocessed || tree || nonCollapsed) {
            System.out.println("------------- basic dependencies ---------------");
          }
          if (altDepPrinter == null) {
            printDependencies(gs, gs.typedDependencies(false), t, conllx, false);
          } else {
            System.out.println(altDepPrinter.dependenciesToString(gs, gs.typedDependencies(false), t));
          }
        }

        if (nonCollapsed) {
          if (basic || CCprocessed || collapsed || tree) {
            System.out.println("----------- non-collapsed dependencies (basic + extra) -----------");
          }
          printDependencies(gs, gs.allTypedDependencies(), t, conllx, extraSep);
        }

        if (collapsed) {
          if (basic || CCprocessed || tree || nonCollapsed) {
            System.out.println("----------- collapsed dependencies -----------");
          }
          printDependencies(gs, gs.typedDependenciesCollapsed(true), t, conllx, false);
        }

        if (CCprocessed) {
          if (basic || collapsed || tree || nonCollapsed) {
            System.out.println("---------- CCprocessed dependencies ----------");
          }
          List<TypedDependency> deps = gs.typedDependenciesCCprocessed(true);
          if (checkConnected) {
            if (!GrammaticalStructure.isConnected(deps)) {
              System.err.println("Graph is not connected for:");
              System.err.println(t);
              System.err.println("possible offending nodes: " + GrammaticalStructure.getRoots(deps));
            }
          }
          printDependencies(gs, deps, t, conllx, false);
        }

        if (tree) {
          if (basic || CCprocessed || collapsed || nonCollapsed) {
            System.out.println("----------- collapsed dependencies tree -----------");
          }
          printDependencies(gs, gs.typedDependenciesCollapsedTree(), t, conllx, false);
        }

        // default use: CCprocessed (to parallel what happens within the parser)
        if (!basic && !collapsed && !CCprocessed && !tree && !nonCollapsed) {
          // System.out.println("----------- CCprocessed dependencies -----------");
          printDependencies(gs, gs.typedDependenciesCCprocessed(true), t, conllx, false);
        }
      }

      if (portray) {
        try {
          // put up a window showing it
          Class sgu = Class.forName("edu.stanford.nlp.trees.semgraph.SemanticGraphUtils");
          Method mRender = sgu.getDeclaredMethod("render", GrammaticalStructure.class, String.class);
          // the first arg is null because it's a static method....
          mRender.invoke(null, gs, "Collapsed, CC processed deps");
        } catch (Exception e) {
          throw new RuntimeException("Couldn't use swing to portray semantic graph", e);
        }
      }

    } // end for
  } // end main


}
