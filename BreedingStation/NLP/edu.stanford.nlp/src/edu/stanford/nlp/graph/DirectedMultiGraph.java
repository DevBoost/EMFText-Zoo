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
package edu.stanford.nlp.graph;

import java.util.*;

import edu.stanford.nlp.util.CollectionUtils;

/**
 * Simple graph library; this is directed for now. This class focuses on time
 * efficiency rather than memory efficiency.
 * 
 * @author sonalg
 * @author John Bauer
 * 
 * @param <V>
 *          Type of vertices
 * @param <E>
 *          Type of edges.
 */

public class DirectedMultiGraph<V, E> implements Graph<V, E> /* Serializable */{

  Map<V, Map<V, List<E>>> outgoingEdges = new HashMap<V, Map<V, List<E>>>();

  Map<V, Map<V, List<E>>> incomingEdges = new HashMap<V, Map<V, List<E>>>();

  public DirectedMultiGraph() {
  }

  /**
   * Be careful hashing these. They are mutable objects, and changing the object
   * will throw off the hash code, messing up your hash table
   */
  public int hashCode() {
    return outgoingEdges.hashCode();
  }

  @SuppressWarnings("unchecked")
  public boolean equals(Object that) {
    if (that == this)
      return true;
    if (!(that instanceof DirectedMultiGraph))
      return false;
    return outgoingEdges.equals(((DirectedMultiGraph) that).outgoingEdges);
  }

  /**
   * For adding a zero degree vertex
   * 
   * @param v
   */
  public boolean addVertex(V v) {
    if (outgoingEdges.containsKey(v))
      return false;
    outgoingEdges.put(v, new HashMap<V, List<E>>());
    incomingEdges.put(v, new HashMap<V, List<E>>());
    return true;
  }

  /**
   * adds vertices (if not already in the graph) and the edge between them
   * 
   * @param source
   * @param dest
   * @param data
   */
  public void add(V source, V dest, E data) {
    addVertex(source);
    addVertex(dest);

    Map<V, List<E>> outgoingMap = outgoingEdges.get(source);
    List<E> outgoingList = outgoingMap.get(dest);
    if (outgoingList == null) {
      outgoingList = new ArrayList<E>();
      outgoingMap.put(dest, outgoingList);
    }

    Map<V, List<E>> incomingMap = incomingEdges.get(dest);
    List<E> incomingList = incomingMap.get(source);
    if (incomingList == null) {
      incomingList = new ArrayList<E>();
      incomingMap.put(source, incomingList);
    }

    outgoingList.add(data);
    incomingList.add(data);
  }

  public boolean removeEdges(V source, V dest) {
    if (!outgoingEdges.containsKey(source)) {
      return false;
    }
    if (!incomingEdges.containsKey(dest)) {
      return false;
    }
    if (!outgoingEdges.get(source).containsKey(dest)) {
      return false;
    }
    outgoingEdges.get(source).remove(dest);
    incomingEdges.get(dest).remove(source);
    return true;
  }

  public boolean removeEdge(V source, V dest, E data) {
    if (!outgoingEdges.containsKey(source)) {
      return false;
    }
    if (!incomingEdges.containsKey(dest)) {
      return false;
    }
    if (!outgoingEdges.get(source).containsKey(dest)) {
      return false;
    }
    boolean foundOut = outgoingEdges.get(source).get(dest).remove(data);
    boolean foundIn = incomingEdges.get(dest).get(source).remove(data);
    if (foundOut && !foundIn) {
      throw new AssertionError("Edge found in outgoing but not incoming");
    }
    if (foundIn && !foundOut) {
      throw new AssertionError("Edge found in incoming but not outgoing");
    }
    // TODO: cut down the number of .get calls
    if (outgoingEdges.get(source).get(dest).size() == 0) {
      outgoingEdges.get(source).remove(dest);
    }
    if (incomingEdges.get(dest).get(source).size() == 0) {
      incomingEdges.get(dest).remove(source);
    }
    return foundOut;
  }

  /**
   * remove a vertex (and its edges) from the graph.
   * 
   * @param vertex
   * @return true if successfully removes the node
   */
  public boolean removeVertex(V vertex) {
    if (!outgoingEdges.containsKey(vertex)) {
      return false;
    }
    for (V other : outgoingEdges.get(vertex).keySet()) {
      incomingEdges.get(other).remove(vertex);
    }
    for (V other : incomingEdges.get(vertex).keySet()) {
      outgoingEdges.get(other).remove(vertex);
    }
    outgoingEdges.remove(vertex);
    incomingEdges.remove(vertex);
    return true;
  }

  public boolean removeVertices(Collection<V> vertices) {
    boolean changed = false;
    for (V v : vertices) {
      if (removeVertex(v)) {
        changed = true;
      }
    }
    return changed;
  }

  public int getNumVertices() {
    return outgoingEdges.size();
  }

  public List<E> getOutgoingEdges(V v) {
    return CollectionUtils.flatten(outgoingEdges.get(v).values());
  }

  public List<E> getIncomingEdges(V v) {
    return CollectionUtils.flatten(incomingEdges.get(v).values());
  }

  public int getNumEdges() {
    int count = 0;
    for (Map.Entry<V, Map<V, List<E>>> sourceEntry : outgoingEdges.entrySet()) {
      for (Map.Entry<V, List<E>> destEntry : sourceEntry.getValue().entrySet()) {
        count += destEntry.getValue().size();
      }
    }
    return count;
  }

  public Set<V> getParents(V vertex) {
    Map<V, List<E>> parentMap = incomingEdges.get(vertex);
    if (parentMap == null)
      return null;
    return Collections.unmodifiableSet(parentMap.keySet());
  }

  public Set<V> getChildren(V vertex) {
    Map<V, List<E>> childMap = outgoingEdges.get(vertex);
    if (childMap == null)
      return null;
    return Collections.unmodifiableSet(childMap.keySet());
  }

  /**
   * Gets both parents and children nodes
   * 
   * @param v
   */
  public Set<V> getNeighbors(V v) {
    // TODO: pity we have to copy the sets... is there a combination set?
    Set<V> children = getChildren(v);
    Set<V> parents = getParents(v);

    if (children == null && parents == null)
      return null;
    Set<V> neighbors = new HashSet<V>();
    neighbors.addAll(children);
    neighbors.addAll(parents);
    return neighbors;
  }

  /**
   * clears the graph, removes all edges and nodes
   */
  public void clear() {
    incomingEdges.clear();
    outgoingEdges.clear();
  }

  public boolean containsVertex(V v) {
    return outgoingEdges.containsKey(v);
  }

  /**
   * only checks if there is an edge from source to dest. To check if it is
   * connected in either direction, use isNeighbor
   * 
   * @param source
   * @param dest
   */
  public boolean isEdge(V source, V dest) {
    Map<V, List<E>> childrenMap = outgoingEdges.get(source);
    if (childrenMap == null || childrenMap.isEmpty())
      return false;
    List<E> edges = childrenMap.get(dest);
    if (edges == null || edges.isEmpty())
      return false;
    return edges.size() > 0;
  }

  public boolean isNeighbor(V source, V dest) {
    return isEdge(source, dest) || isEdge(dest, source);
  }

  public Set<V> getAllVertices() {
    return Collections.unmodifiableSet(outgoingEdges.keySet());
  }

  public List<E> getAllEdges() {
    List<E> edges = new ArrayList<E>();
    for (Map<V, List<E>> e : outgoingEdges.values()) {
      for (List<E> ee : e.values()) {
        edges.addAll(ee);
      }
    }
    return edges;
  }

  /**
   * False if there are any vertices in the graph, true otherwise. Does not care
   * about the number of edges.
   */
  public boolean isEmpty() {
    return outgoingEdges.isEmpty();
  }

  /**
   * Deletes nodes with zero incoming and zero outgoing edges
   */
  public void removeZeroDegreeNodes() {
    List<V> toDelete = new ArrayList<V>();
    for (V vertex : outgoingEdges.keySet()) {
      if (outgoingEdges.get(vertex).size() == 0 && incomingEdges.get(vertex).size() == 0) {
        toDelete.add(vertex);
      }
    }
    for (V vertex : toDelete) {
      outgoingEdges.remove(vertex);
      incomingEdges.remove(vertex);
    }
  }

  public List<E> getEdges(V source, V dest) {
    Map<V, List<E>> childrenMap = outgoingEdges.get(source);
    if (childrenMap == null) {
      return Collections.emptyList();
    }
    List<E> edges = childrenMap.get(dest);
    if (edges == null) {
      return Collections.emptyList();
    }
    return Collections.unmodifiableList(edges);
  }

  /**
   * direction insensitive (the paths can go "up" or through the parents)
   */
  public List<V> getShortestPath(V node1, V node2) {
    if (!outgoingEdges.containsKey(node1) || !outgoingEdges.containsKey(node2)) {
      return null;
    }
    return getShortestPath(node1, node2, false);
  }

  public List<E> getShortestPathEdges(V node1, V node2) {
    return convertPath(getShortestPath(node1, node2), false);
  }

  /**
   * can specify the direction sensitivity
   * 
   * @param node1
   * @param node2
   * @param directionSensitive
   *          - whether the path can go through the parents
   * @return the list of nodes you get through to get there
   */
  public List<V> getShortestPath(V node1, V node2, boolean directionSensitive) {
    if (!outgoingEdges.containsKey(node1) || !outgoingEdges.containsKey(node2)) {
      return null;
    }
    return DijkstraShortestPath.getShortestPath(this, node1, node2, directionSensitive);
  }

  public List<E> getShortestPathEdges(V node1, V node2, boolean directionSensitive) {
    return convertPath(getShortestPath(node1, node2, directionSensitive), directionSensitive);
  }

  public List<E> convertPath(List<V> nodes, boolean directionSensitive) {
    if (nodes == null)
      return null;

    if (nodes.size() <= 1)
      return Collections.emptyList();

    List<E> path = new ArrayList<E>();
    Iterator<V> nodeIterator = nodes.iterator();
    V previous = nodeIterator.next();
    while (nodeIterator.hasNext()) {
      V next = nodeIterator.next();
      E connection = null;
      List<E> edges = getEdges(previous, next);
      if (edges.size() == 0 && !directionSensitive) {
        edges = getEdges(next, previous);
      }
      if (edges.size() > 0) {
        connection = edges.get(0);
      } else {
        throw new IllegalArgumentException("Path given with missing " + "edge connection");
      }
      path.add(connection);
      previous = next;
    }
    return path;
  }

  public int getInDegree(V vertex) {
    if (!containsVertex(vertex)) {
      throw new IllegalArgumentException("Unknown vertex " + vertex);
    }
    int result = 0;
    Map<V, List<E>> incoming = incomingEdges.get(vertex);
    for (List<E> edges : incoming.values()) {
      result += edges.size();
    }
    return result;
  }

  public int getOutDegree(V vertex) {
    int result = 0;
    Map<V, List<E>> outgoing = outgoingEdges.get(vertex);
    if (outgoing == null) {
      throw new IllegalArgumentException("Unknown vertex " + vertex);
    }
    for (List<E> edges : outgoing.values()) {
      result += edges.size();
    }
    return result;
  }

  public List<Set<V>> getConnectedComponents() {
    return ConnectedComponents.getConnectedComponents(this);
  }

  public Iterator<E> incomingEdgeIterator(final V vertex) {
    return new EdgeIterator<V, E>(incomingEdges, vertex);
  }

  public Iterable<E> incomingEdgeIterable(final V vertex) {
    return new Iterable<E>() {
      public Iterator<E> iterator() {
        return new EdgeIterator<V, E>(incomingEdges, vertex);
      }
    };
  }

  public Iterator<E> outgoingEdgeIterator(final V vertex) {
    return new EdgeIterator<V, E>(outgoingEdges, vertex);
  }

  public Iterable<E> outgoingEdgeIterable(final V vertex) {
    return new Iterable<E>() {
      public Iterator<E> iterator() {
        return new EdgeIterator<V, E>(outgoingEdges, vertex);
      }
    };
  }

  public Iterator<E> edgeIterator() {
    return new EdgeIterator<V, E>(this);
  }

  public Iterable<E> edgeIterable() {
    return new Iterable<E>() {
      public Iterator<E> iterator() {
        return new EdgeIterator<V, E>(DirectedMultiGraph.this);
      }
    };
  }

  static class EdgeIterator<V, E> implements Iterator<E> {
    private Iterator<Map<V, List<E>>> vertexIterator;
    private Iterator<List<E>> connectionIterator;
    private Iterator<E> edgeIterator;

    E next;

    public EdgeIterator(DirectedMultiGraph<V, E> graph) {
      vertexIterator = graph.outgoingEdges.values().iterator();
      primeNext();
    }

    public EdgeIterator(Map<V, Map<V, List<E>>> source, V startVertex) {
      Map<V, List<E>> neighbors = source.get(startVertex);
      if (neighbors == null) {
        return;
      }
      connectionIterator = neighbors.values().iterator();
      primeNext();
    }

    public boolean hasNext() {
      return next != null;
    }

    public E next() {
      if (next == null) {
        throw new NoSuchElementException("Graph edge iterator exhausted.");
      }
      E value = next;
      primeNext();
      return value;
    }

    private void primeNext() {
      while (true) {
        if (edgeIterator != null && edgeIterator.hasNext()) {
          next = edgeIterator.next();
          break;
        }

        if (connectionIterator != null && connectionIterator.hasNext()) {
          edgeIterator = connectionIterator.next().iterator();
          continue;
        }

        if (vertexIterator != null && vertexIterator.hasNext()) {
          connectionIterator = vertexIterator.next().values().iterator();
          continue;
        }

        next = null;
        break;
      }
    }

    public void remove() {
      throw new UnsupportedOperationException();
    }
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("{\n");
    s.append("Vertices:\n");
    for (V vertex : outgoingEdges.keySet()) {
      s.append("  ").append(vertex).append('\n');
    }
    s.append("Edges:\n");
    for (V source : outgoingEdges.keySet()) {
      for (V dest : outgoingEdges.get(source).keySet()) {
        for (E edge : outgoingEdges.get(source).get(dest)) {
          s.append("  ").append(source).append(" -> ").append(dest).append(" : ").append(edge).append('\n');
        }
      }
    }
    s.append('}');
    return s.toString();
  }

  private static final long serialVersionUID = 609823567298345145L;

}
