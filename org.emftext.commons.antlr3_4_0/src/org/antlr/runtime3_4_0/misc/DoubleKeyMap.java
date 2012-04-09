/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.antlr.runtime3_4_0.misc;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/** Sometimes we need to map a key to a value but key is two pieces of data.
 *  This nested hash table saves creating a single key each time we access
 *  map; avoids mem creation.
 */
public class DoubleKeyMap<Key1, Key2, Value> {
	Map<Key1, Map<Key2, Value>> data = new LinkedHashMap<Key1, Map<Key2, Value>>();

	public Value put(Key1 k1, Key2 k2, Value v) {
		Map<Key2, Value> data2 = data.get(k1);
		Value prev = null;
		if ( data2==null ) {
			data2 = new LinkedHashMap<Key2, Value>();
			data.put(k1, data2);
		}
		else {
			prev = data2.get(k2);
		}
		data2.put(k2, v);
		return prev;
	}

	public Value get(Key1 k1, Key2 k2) {
		Map<Key2, Value> data2 = data.get(k1);
		if ( data2==null ) return null;
		return data2.get(k2);
	}

	public Map<Key2, Value> get(Key1 k1) { return data.get(k1); }

	/** Get all values associated with primary key */
	public Collection<Value> values(Key1 k1) {
		Map<Key2, Value> data2 = data.get(k1);
		if ( data2==null ) return null;
		return data2.values();
	}

	/** get all primary keys */
	public Set<Key1> keySet() {
		return data.keySet();
	}

	/** get all secondary keys associated with a primary key */
	public Set<Key2> keySet(Key1 k1) {
		Map<Key2, Value> data2 = data.get(k1);
		if ( data2==null ) return null;
		return data2.keySet();
	}

	public Collection<Value> values() {
		Set<Value> s = new HashSet<Value>();
		for (Map<Key2, Value> k2 : data.values()) {
			for (Value v : k2.values()) {
				s.add(v);
			}
		}
		return s;
	}
}
