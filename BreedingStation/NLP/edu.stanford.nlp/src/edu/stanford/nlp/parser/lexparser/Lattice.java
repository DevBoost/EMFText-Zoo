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

import java.io.*;
import java.util.*;

public class Lattice implements Serializable, Iterable<LatticeEdge> {

	private static final long serialVersionUID = 5135076134500512556L;
  
  private final List<ParserConstraint> constraints;
	
	private final List<LatticeEdge> edges;
	private final Set<Integer> nodes;
	private final Map<Integer,List<LatticeEdge>> edgeStartsAt;
	private int maxNode = -1;
	
	public Lattice() {
		edges = new ArrayList<LatticeEdge>();
		nodes = new HashSet<Integer>();
		constraints = new ArrayList<ParserConstraint>();
		edgeStartsAt = new HashMap<Integer,List<LatticeEdge>>();
	}

	//TODO Do node normalization here
	public void addEdge(LatticeEdge e) { 
		nodes.add(e.start);
		nodes.add(e.end);
		edges.add(e); 
		if(e.end > maxNode)
		  maxNode = e.end;
		
		if(edgeStartsAt.get(e.start) == null) {
		  List<LatticeEdge> edges = new ArrayList<LatticeEdge>();
		  edges.add(e);
		  edgeStartsAt.put(e.start, edges);
		} else {
		  edgeStartsAt.get(e.start).add(e);
		}
	}
	
	public void addConstraint(ParserConstraint c) { constraints.add(c); }
	
	public int getNumNodes() { return nodes.size(); }

	public List<ParserConstraint> getConstraints() {
	  return Collections.unmodifiableList(constraints);
	}
	
	public int getNumEdges() { return edges.size(); }
	
	public List<LatticeEdge> getEdgesOverSpan(int start, int end) {
	 
	  List<LatticeEdge> allEdges = edgeStartsAt.get(start);
	  List<LatticeEdge> spanningEdges = new ArrayList<LatticeEdge>();
	  if(allEdges != null)
	    for(LatticeEdge e : allEdges)
	      if(e.end == end)
	        spanningEdges.add(e);
	  
	  return spanningEdges;
	}
	
	
	@Override
	public String toString() {
	  StringBuilder sb = new StringBuilder();
	  sb.append(String.format("[ Lattice: %d edges  %d nodes ]\n",edges.size(), nodes.size()));
	  for(LatticeEdge e : edges)
	    sb.append("  " + e.toString() + "\n");
		return sb.toString();
	}

	public void setEdge(int id, LatticeEdge e) { edges.set(id, e); }
	
	public Iterator<LatticeEdge> iterator() { return edges.iterator(); }

  public void addBoundary() {
    //Log prob of 0.0 since we have to take this transition
    LatticeEdge boundary = new LatticeEdge(Lexicon.BOUNDARY, 0.0, maxNode, maxNode + 1);
    addEdge(boundary);
  }

}
