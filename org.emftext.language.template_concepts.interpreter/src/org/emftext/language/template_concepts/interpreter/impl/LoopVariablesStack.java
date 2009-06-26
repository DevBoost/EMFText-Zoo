/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.language.template_concepts.interpreter.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.eclipse.emf.ecore.EObject;

public class LoopVariablesStack {
	
	private class LoopVariable {
		private String name;
		private EObject value;
		
		public LoopVariable(String name, EObject value) {
			super();
			this.name = name;
			this.value = value;
		}
		
		public String getName() {
			return name;
		}
		
		public EObject getValue() {
			return value;
		}
	}
	
	private Stack<LoopVariable> variableStack = new Stack<LoopVariable>();

	public void push(String name, EObject value) {
		variableStack.push(new LoopVariable(name, value));
	}

	public void pop() {
		variableStack.pop();
	}

	/**
	 * Returns unmodifiable map of uppermost variables on stack. 
	 * Key is variable name and value the respective value. <br>
	 * The returned map is unmodifiable as the developer must not change this map externally 
	 * @return Returns unmodifiable map of uppermost variables on stack.
	 */
	public Map<String, EObject> getTopMostVariables() {
		Map<String, EObject> result = new HashMap<String, EObject>();
		for (LoopVariable variable : variableStack) {
			//mboehme: stack is a LIFO queue. So uppermost values are first ones
			if(result.get(variable.getName())==null){
				result.put(variable.getName(), variable.getValue());
			}
		}
		return Collections.unmodifiableMap(result);
	}
}
