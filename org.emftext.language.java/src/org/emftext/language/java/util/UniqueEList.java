package org.emftext.language.java.util;


public class UniqueEList<E> extends org.eclipse.emf.common.util.UniqueEList<E> {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Ignores duplicates and throws NO IllegalArgumentException Exception.
	 */
	@Override
	public void add(int index, E object) {
		int size = size();
		if (index > size)
			throw new BasicIndexOutOfBoundsException(index, size);

		if (isUnique() && contains(object)) {
			//throw new IllegalArgumentException("The 'no duplicates' constraint is violated");
			return;
		}

		addUnique(index, object);
	}

}
