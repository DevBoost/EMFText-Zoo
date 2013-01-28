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

import java.util.*;
import java.io.Serializable;

public class LatticeEdge implements Serializable {

	public final String word;
	public String label = null;
	public double weight;
	public final int start;
	public final int end;
	
	public final Map<String,String> attrs;

	public LatticeEdge(String word, double weight, int start, int end) {
		this.word = word;
		this.weight = weight;
		this.start = start;
		this.end = end;
		
		attrs = new HashMap<String,String>();
	}

	public void setAttr(String key, String value) { attrs.put(key, value); }
	
	public String getAttr(String key) { return attrs.get(key); }
	
	public void setLabel(String l) { label = l; }
	
	public void setWeight(double w) { weight = w; }

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ " + word);
		sb.append(String.format(" start(%d) end(%d) wt(%f) ]", start,end,weight));
		if(label != null)
			sb.append(" / " + label);
		return sb.toString();
	}

	private static final long serialVersionUID = 4416189959485854286L;
}
