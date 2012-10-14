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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.stanford.nlp.stats.ClassicCounter;
import edu.stanford.nlp.stats.Counter;
import edu.stanford.nlp.util.BinaryHeapPriorityQueue;
import edu.stanford.nlp.util.Pair;

public class DijkstraShortestPath {
  private DijkstraShortestPath() {} // static method only

  public static <V, E> List<V> getShortestPath(DirectedMultiGraph<V, E> graph, 
                                               V node1, V node2, 
                                               boolean directionSensitive) {
    if (node1.equals(node2)) {
      return Collections.singletonList(node2);
    }

    Set<V> visited = new HashSet<V>();
    
    Map<V, V> previous = new HashMap<V, V>();
    
    BinaryHeapPriorityQueue<V> unsettledNodes = 
      new BinaryHeapPriorityQueue<V>();

    unsettledNodes.add(node1, 0);

    while (unsettledNodes.size() > 0) {
      double distance = unsettledNodes.getPriority();
      V u = unsettledNodes.removeFirst();
      visited.add(u);

      if (u.equals(node2))
        break;

      unsettledNodes.remove(u);

      Set<V> candidates = ((directionSensitive) ? 
                           graph.getChildren(u) : graph.getNeighbors(u));
      for (V candidate : candidates) {
        double alt = distance - 1;
        // nodes not already present will have a priority of -inf
        if (alt > unsettledNodes.getPriority(candidate) &&
            !visited.contains(candidate)) {
          unsettledNodes.relaxPriority(candidate, alt);
          previous.put(candidate, u);
        }
      }
    }
    if (!previous.containsKey(node2))
      return null;
    ArrayList<V> path = new ArrayList<V>();
    path.add(node2);
    V n = node2;
    while (previous.containsKey(n)) {
      path.add(previous.get(n));
      n = previous.get(n);
    }
    Collections.reverse(path);
    return path;
  }

}
