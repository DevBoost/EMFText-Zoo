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
package edu.stanford.nlp.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.stanford.nlp.util.CollectionUtils;

/**
 * Finds connected components in the graph, currently uses inefficient list for
 * variable 'verticesLeft'. It might give a problem for big graphs
 * 
 * @author sonalg 08/08/11
 */
public class ConnectedComponents<V, E> {

  public static <V, E> List<Set<V>> getConnectedComponents(DirectedMultiGraph<V, E> graph) {
    List<Set<V>> ccs = new ArrayList<Set<V>>();
    LinkedList<V> todo = new LinkedList<V>();
    // TODO: why not a set?
    List<V> verticesLeft = CollectionUtils.toList(graph.getAllVertices());
    while (verticesLeft.size() > 0) {
      todo.add(verticesLeft.get(0));
      verticesLeft.remove(0);
      ccs.add(bfs(todo, graph, verticesLeft));
    }
    return ccs;
  }

  private static <V, E> Set<V> bfs(LinkedList<V> todo, DirectedMultiGraph<V, E> graph, List<V> verticesLeft) {
    Set<V> cc = new HashSet<V>();
    while (todo.size() > 0) {
      V node = todo.removeFirst();
      cc.add(node);
      for (V neighbor : graph.getNeighbors(node)) {
        if (verticesLeft.contains(neighbor)) {
          cc.add(neighbor);
          todo.add(neighbor);
          verticesLeft.remove(neighbor);
        }
      }
    }

    return cc;
  }

}
