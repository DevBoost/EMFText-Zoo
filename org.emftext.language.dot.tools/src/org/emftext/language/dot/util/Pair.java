/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.dot.util;

public class Pair<S, T> {
	
	private S left;
	private T right;

	public Pair(S left, T right) {
		this.left = left;
		this.right = right;
	}

	public S getLeft() {
		return left;
	}

	public T getRight() {
		return right;
	}
	
	@Override
	public String toString() {
		return "[" + left + ", " + right + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}
}
