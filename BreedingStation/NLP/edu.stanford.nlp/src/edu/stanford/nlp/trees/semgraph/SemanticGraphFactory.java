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
package edu.stanford.nlp.trees.semgraph;

import edu.stanford.nlp.ling.CoreAnnotations.ProjectedCategoryAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.IndexedWord;
import edu.stanford.nlp.trees.*;
import edu.stanford.nlp.util.Filter;
import edu.stanford.nlp.util.Filters;
import edu.stanford.nlp.util.Generics;

import java.util.*;

/**
 * Refactoring of static makers of SemanticGraphs in order to simplify
 * the SemanticGraph class.
 *
 * @author rafferty
 */
public class SemanticGraphFactory {

  private SemanticGraphFactory() {} // just static factory methods

  private static final boolean INCLUDE_PUNCTUATION_DEPENDENCIES = false;

  /**
   * Returns a new <code>SemanticGraph</code> constructed from a given {@link
   * Tree} with given options. <p/>
   *
   * This factory method is intended to replace a profusion of highly similar
   * factory methods, such as
   * <code>typedDependencies()</code>,
   * <code>typedDependenciesCollapsed()</code>,
   * <code>allTypedDependencies()</code>,
   * <code>allTypedDependenciesCollapsed()</code>, etc. <p/>
   *
   * For a fuller explanation of the meaning of the boolean arguments, see
   * {@link GrammaticalStructure}. <p/>
   *
   * @param tree A tree representing a phrase structure parse
   * @param collapse Whether to do "collapsing" of pairs of dependencies into
   * single dependencies, e.g., for prepositions and conjunctions
   * @param ccProcess Whether to do processing of CC complements resulting from
   * collapsing.  This argument is ignored unless <code>collapse</code> is
   * <code>true</code>
   * @param includeExtras Whether to include extra dependencies, which may
   * result in a non-tree
   * @param lemmatize Whether to compute lemma for each node
   * @param threadSafe Whether to make sure processing is thread-safe
   * @param filter A filter to exclude certain dependencies; ignored if null
   * @return A SemanticGraph
   */
  public static SemanticGraph makeFromTree(Tree tree,
      boolean collapse,
      boolean ccProcess,
      boolean includeExtras,
      boolean lemmatize, boolean threadSafe,
      Filter<TypedDependency> filter) {
    return makeFromTree(tree, collapse, ccProcess, includeExtras,
                        lemmatize, threadSafe, filter, "", 0);
  }


  /**
   * Returns a new <code>SemanticGraph</code> constructed from a given {@link
   * Tree} with given options. <p/>
   *
   * This factory method is intended to replace a profusion of highly similar
   * factory methods, such as
   * <code>typedDependencies()</code>,
   * <code>typedDependenciesCollapsed()</code>,
   * <code>allTypedDependencies()</code>,
   * <code>allTypedDependenciesCollapsed()</code>, etc. <p/>
   *
   * For a fuller explanation of the meaning of the boolean arguments, see
   * {@link GrammaticalStructure}. <p/>
   *
   * @param tree A tree representing a phrase structure parse
   * @param collapse Whether to do "collapsing" of pairs of dependencies into
   * single dependencies, e.g., for prepositions and conjunctions
   * @param ccProcess Whether to do processing of CC complements resulting from
   * collapsing.  This argument is ignored unless <code>collapse</code> is
   * <code>true</code>
   * @param includeExtras Whether to include extra dependencies, which may
   * result in a non-tree
   * @param lemmatize Whether to compute lemma for each node
   * @param threadSafe Whether to make sure processing is thread-safe
   * @param filter A filter to exclude certain dependencies; ignored if null
   * @param docID The docID that the tree came from
   * @param sentIndex The sentence number of the tree in the document
   * @return A SemanticGraph
   */
  public static SemanticGraph makeFromTree(Tree tree,
      boolean collapse,
      boolean ccProcess,
      boolean includeExtras,
      boolean lemmatize, boolean threadSafe,
      Filter<TypedDependency> filter,
      String docID, int sentIndex) {
    Filter<String> wordFilt;
    if (INCLUDE_PUNCTUATION_DEPENDENCIES) {
      wordFilt = Filters.acceptFilter();
    } else {
      wordFilt = new PennTreebankLanguagePack().punctuationWordRejectFilter();
    }
    GrammaticalStructure gs = new EnglishGrammaticalStructure(tree,
            wordFilt,
            new SemanticHeadFinder(true),
            threadSafe);
    return makeFromTree(gs, collapse, false, ccProcess, includeExtras,
                        lemmatize, threadSafe, filter, docID, sentIndex);
  }


  // todo: improve the interface here: we don't really have a whole set of booleans; really basic, collapse, tree, and ccProcess are an enum; only the later ones crosscut.
  public static SemanticGraph makeFromTree(GrammaticalStructure gs,
      boolean collapse,
      boolean tree,
      boolean ccProcess,
      boolean includeExtras,
      boolean lemmatize,
      boolean threadSafe,
      Filter<TypedDependency> filter,
      String docID, int sentIndex) {
    addProjectedCategoriesToGrammaticalStructure(gs);
    Collection<TypedDependency> deps;
    if (tree) {
      deps = gs.typedDependenciesCollapsedTree();
    }
    else if (collapse) {
      if (ccProcess) {
        deps = gs.typedDependenciesCCprocessed(includeExtras);
      } else {
        deps = gs.typedDependenciesCollapsed(includeExtras);
      }
    } else {
      deps = gs.typedDependencies(includeExtras);
    }

    if (filter != null) {
      List<TypedDependency> depsFiltered = Generics.newArrayList();
      for (TypedDependency td : deps) {
        if (filter.accept(td)) {
          depsFiltered.add(td);
        }
      }
      deps = depsFiltered;
    }

    Collection<TreeGraphNode> roots = Generics.newHashSet();

    // there used to be an if clause that filtered out the case of empty
    // dependencies. However, I could not understand (or replicate) the error
    // it alluded to, and it led to empty dependency graphs for very short fragments,
    // which meant they were ignored by the RTE system. Changed. (pado)
    // See also the SemanticGraph constructor.

    if (gs.root().headWordNode() != null) {
      roots.add(gs.root().headWordNode());
    }
    //System.err.println(deps.toString());
    return new SemanticGraph(deps, roots, docID, sentIndex, lemmatize, threadSafe);
  }


  public static SemanticGraph makeFromTree(GrammaticalStructure structure,
      String docID, int sentIndex) {
    return makeFromTree(structure, false, false, false, false,
                        false, false, null, docID, sentIndex);
  }


  public static SemanticGraph makeFromTree(Tree tree,
      boolean collapse,
      boolean ccProcess,
      boolean includeExtras,
      Filter<TypedDependency> filter) {
    return makeFromTree(tree, collapse, ccProcess, includeExtras,
                        false, false, filter);
  }


  public static SemanticGraph makeFromTree(Tree tree,
      boolean collapse,
      boolean ccProcess,
      boolean includeExtras,
      boolean lemmatize, boolean threadSafe) {
    return makeFromTree(tree, collapse, ccProcess, includeExtras,
                        lemmatize, threadSafe, null);
  }


  /**
   * Returns a new SemanticGraph constructed from the given tree.  Dependencies are collapsed
   * according to the parameter "collapse", and extra dependencies are not included
   * @param tree tree from which to make new semantic graph
   * @param collapse collapse dependencies iff this parameter is true
   */
  public static SemanticGraph makeFromTree(Tree tree, boolean collapse) {
    return makeFromTree(tree, collapse, false, false, false, false, null);
  }

  /**
   * Returns a new SemanticGraph constructed from the given tree.  Dependencies are collapsed,
   * and extra dependencies are not included (convenience method for makeFromTree(Tree tree, boolean collapse))
   */
  public static SemanticGraph makeFromTree(Tree tree) {
    return makeFromTree(tree, true, false, false, false, false, null);
  }


  /**
   * Returns a new SemanticGraph constructed from the given tree. Collapsing
   * of dependencies is performed according to "collapse". The list includes extra
   * dependencies which do not respect a tree structure of the
   * dependencies. <p/>
   *
   * (Internally, this invokes (@link
   * edu.stanford.nlp.trees.GrammaticalStructure#allTypedDependencies()
   * GrammaticalStructure.allTypedDependencies()).)
   *
   * @param tree tree from which to make new semantic graph
   * @param collapse collapse dependencies iff this parameter is true
   */
  // todo: Should we now update this to do CC process by default?
  public static SemanticGraph allTypedDependencies(Tree tree, boolean collapse) {
    return makeFromTree(tree, collapse, false, true, null);
  }

  /**
   * Modifies the given GrammaticalStructure by adding some annotations to the
   * MapLabels of certain nodes. <p/>
   *
   * For each word (leaf node), we add an annotation which indicates the
   * syntactic category of the maximal constituent headed by the word.
   */
  static void addProjectedCategoriesToGrammaticalStructure(GrammaticalStructure gs) {
    // Our strategy: (1) assume every node in GrammaticalStructure is already
    // annotated with head word, (2) traverse nodes of GrammaticalStructure in
    // reverse of pre-order (bottom up), and (3) at each, get head word and
    // annotate it with category of this node.
    List<TreeGraphNode> nodes = new ArrayList<TreeGraphNode>();
    for (Tree node : gs.root()) {       // pre-order traversal
      nodes.add((TreeGraphNode) node);
    }
    Collections.reverse(nodes);         // reverse
    for (TreeGraphNode node : nodes) {
      if (!"ROOT".equals(node.value())) { // main verb should get PROJ_CAT "S", not "ROOT"
        CoreLabel label = node.label();
        Tree hw = label.get(TreeCoreAnnotations.HeadWordAnnotation.class);
        if (hw != null) {
          TreeGraphNode hwn = (TreeGraphNode) hw;
          CoreLabel hwLabel = hwn.label();
          hwLabel.set(ProjectedCategoryAnnotation.class, node.value());
        }
      }
    }
  }

  /**
   * Given a list of edges, attempts to create and return a rooted SemanticGraph.
   * <p>
   * TODO: throw Exceptions, or flag warnings on conditions for concern (no root, etc)
   */
  public static SemanticGraph makeFromEdges(Iterable<SemanticGraphEdge> edges) {
    // Identify the root(s) of this graph
    SemanticGraph sg = new SemanticGraph();
    Collection<IndexedWord> vertices = getVerticesFromEdgeSet(edges);
    for (IndexedWord vertex : vertices) {
      sg.addVertex(vertex);
    }
    for (SemanticGraphEdge edge : edges) {
      sg.addEdge(edge.getSource(),edge.getTarget(), edge.getRelation(), edge.getWeight());
    }

    sg.resetRoots();
    return sg;
  }

  /**
   * Given an iterable set of edges, returns the set of  vertices covered by these edges.
   * <p>
   * Note: CDM changed the return of this from a List to a Set in 2011. This seemed more
   * sensible.  Hopefully it doesn't break anything....
   */
  // XXX why is this a List rather than a Set (i.e. are the duplicates useful)?
  public static Set<IndexedWord> getVerticesFromEdgeSet(Iterable<SemanticGraphEdge> edges) {
    Set<IndexedWord> retSet = new HashSet<IndexedWord>();
    for (SemanticGraphEdge edge : edges) {
      retSet.add(edge.getGovernor());
      retSet.add(edge.getDependent());
    }
    return retSet;
  }


  /**
   * Given a set of vertices, and the source graph they are drawn from, create a path composed
   * of the minimum paths between the vertices.  i.e. this is a simple brain-dead attempt at getting
   * something approximating a minimum spanning graph.
   *
   * NOTE: the hope is the vertices will already be contiguous, but facilities are added just in case for
   * adding additional nodes.
   */
  public static SemanticGraph makeFromVertices(SemanticGraph sg, Collection<IndexedWord> nodes) {
    List<SemanticGraphEdge> edgesToAdd = new ArrayList<SemanticGraphEdge>();
    List<IndexedWord> nodesToAdd = new ArrayList<IndexedWord>(nodes);
    for (IndexedWord nodeA :nodes) {
      for (IndexedWord nodeB : nodes) {
        if (nodeA != nodeB) {
          List<SemanticGraphEdge> edges = sg.getShortestDirectedPathEdges(nodeA, nodeB);
          if (edges != null) {
            edgesToAdd.addAll(edges);
            for (SemanticGraphEdge edge : edges) {
              IndexedWord gov = edge.getGovernor();
              IndexedWord dep = edge.getDependent();
              if (gov != null && !nodesToAdd.contains(gov)) {
                nodesToAdd.add(gov);
              }
              if (dep != null && !nodesToAdd.contains(dep)) {
                nodesToAdd.add(dep);
              }
            }
          }
        }
      }
    }

    SemanticGraph retSg = new SemanticGraph();
    for (IndexedWord node : nodesToAdd) {
      retSg.addVertex(node);
    }
    for (SemanticGraphEdge edge : edgesToAdd) {
      retSg.addEdge(edge.getGovernor(), edge.getDependent(), edge.getRelation(), edge.getWeight());
    }

    retSg.resetRoots();
    return retSg;
  }

  /**
   * This creates a new graph based off the given, but uses the existing nodes objects.
   */
  public static SemanticGraph duplicateKeepNodes(SemanticGraph sg) {
    SemanticGraph retSg = new SemanticGraph();
    for (IndexedWord node : sg.vertexSet()) {
      retSg.addVertex(node);
    }
    retSg.setRoots(sg.getRoots());
    for (SemanticGraphEdge edge : sg.edgeIterable()) {
      retSg.addEdge(edge.getGovernor(), edge.getDependent(), edge.getRelation(), edge.getWeight());
    }
    return retSg;
  }

  /**
   * Given a list of graphs, constructs a new graph combined from the
   * collection of graphs.  Original vertices are used, edges are
   * copied.  Graphs are ordered by the sentence index and index of
   * the original vertices.  Intent is to create a "mega graph"
   * similar to the graphs used in the RTE problem.
   * <br>
   * This method only works if the indexed words have different
   * sentence ids, as otherwise the maps used will confuse several of
   * the IndexedWords.
   */
  public static SemanticGraph makeFromGraphs(Collection<SemanticGraph> sgList) {
    SemanticGraph sg = new SemanticGraph();
    Collection<IndexedWord> newRoots = new HashSet<IndexedWord>();
    for (SemanticGraph currSg : sgList) {
      newRoots.addAll(currSg.getRoots());
      for (IndexedWord currVertex : currSg.vertexSet())
        sg.addVertex(currVertex);
      for (SemanticGraphEdge currEdge : currSg.edgeIterable())
        sg.addEdge(currEdge.getGovernor(), currEdge.getDependent(),
                   currEdge.getRelation(), currEdge.getWeight());
    }
    sg.setRoots(newRoots);
    return sg;
  }

  /**
   * Like makeFromGraphs, but it makes a deep copy of the graphs and
   * renumbers the index words.
   * <br>
   * <code>lengths</code> must be a vector containing the number of
   * tokens in each sentence.  This is used to reindex the tokens.
   */
  public static SemanticGraph deepCopyFromGraphs(List<SemanticGraph> graphs,
                                                 List<Integer> lengths) {
    SemanticGraph newGraph = new SemanticGraph();
    Map<Integer, IndexedWord> newWords = new HashMap<Integer, IndexedWord>();
    List<IndexedWord> newRoots = new ArrayList<IndexedWord>();
    int vertexOffset = 0;
    for (int i = 0; i < graphs.size(); ++i) {
      SemanticGraph graph = graphs.get(i);
      for (IndexedWord vertex : graph.vertexSet()) {
        IndexedWord newVertex = new IndexedWord(vertex);
        newVertex.setIndex(vertex.index() + vertexOffset);
        newGraph.addVertex(newVertex);
        newWords.put(newVertex.index(), newVertex);
      }
      for (SemanticGraphEdge edge : graph.edgeIterable()) {
        IndexedWord gov = newWords.get(edge.getGovernor().index() +
                                       vertexOffset);
        IndexedWord dep = newWords.get(edge.getDependent().index() +
                                       vertexOffset);
        if (gov == null || dep == null) {
          throw new AssertionError("Counting problem (or broken edge)");
        }
        newGraph.addEdge(gov, dep, edge.getRelation(), edge.getWeight());
      }
      for (IndexedWord root : graph.getRoots()) {
        newRoots.add(newWords.get(root.index() + vertexOffset));
      }
      vertexOffset += lengths.get(i);
    }
    newGraph.setRoots(newRoots);
    return newGraph;
  }

}
