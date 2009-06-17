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
