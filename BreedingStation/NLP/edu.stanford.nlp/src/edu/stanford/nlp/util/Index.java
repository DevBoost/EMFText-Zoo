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
package edu.stanford.nlp.util;

import java.io.Serializable;
import java.io.Writer;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * Minimalist interface for implementations of Index.
 *
 * This interface should allow HashIndex and OAIndex to be used interchangeably
 * in certain contexts.
 *
 * Originally extracted from util.Index on 3/13/2007.
 *
 * @author Daniel Cer
 *
 * @param <E> The type of objects in the Index
 */
public interface Index<E> extends Iterable<E>, Serializable {

    /**
     * Returns the number of indexed objects.
     * @return the number of indexed objects.
     */
    public abstract int size();

    /**
     * Gets the object whose index is the integer argument.
     * @param i the integer index to be queried for the corresponding argument
     * @return the object whose index is the integer argument.
     */
    public abstract E get(int i);

    /**
     * Returns the integer index of the Object in the Index or -1 if the Object is not already in the Index.
     * @param o the Object whose index is desired.
     * @return the index of the Object argument.  Returns -1 if the object is not in the index.
     */
    public abstract int indexOf(E o);

    /**
     * Takes an Object and returns the integer index of the Object,
     * perhaps adding it to the index first.
     * Returns -1 if the Object is not in the Index.
     * (Note: indexOf(x, true) is the direct replacement for the number(x)
     * method in the old Numberer class.)
     *
     * @param o the Object whose index is desired.
     * @param add Whether it is okay to add new items to the index
     * @return the index of the Object argument.  Returns -1 if the object is not in the index.
     */
    public abstract int indexOf(E o, boolean add);


    // mg2009. Methods below were temporarily added when IndexInterface was renamed
    // to Index. These methods are currently (2009-03-09) needed in order to have core classes
    // of JavaNLP (Dataset, LinearClassifier, etc.) use Index instead of HashIndex.
    // Possible javanlp task: delete some of these methods.

    /**
     * Returns a complete {@link List} of indexed objects, in the order of their indices.
     *
     * @return a complete {@link List} of indexed objects
     */
    public List<E> objectsList();

    /**
     * Looks up the objects corresponding to an array of indices, and returns them in a {@link Collection}.
     *
     * @param indices An array of indices
     * @return a {@link Collection} of the objects corresponding to the indices argument.
     */
    public Collection<E> objects(int[] indices);

    /**
     * Queries the Index for whether it's locked or not.
     * @return whether or not the Index is locked
     */
    public boolean isLocked();

    /**
     * Locks the Index.  A locked index cannot have new elements added to it (calls to {@link #add} will
     * leave the Index unchanged and return <code>false</code>).
     */
    public void lock();

    /**
     * Unlocks the Index.  A locked index cannot have new elements added to it (calls to {@link #add} will
     * leave the Index unchanged and return <code>false</code>).
     * */
    public void unlock();

    /**
     * Save the contents of this index into string form, as part of a larger
     * text-serialization.
     *
     * @param out Writer to save to.
     * @throws IOException Exception thrown if cannot save.
     */
    public void saveToWriter(Writer out) throws IOException;

    /**
     * Save the contents of this index into a file.
     *
     * @param s File name.
     */
    public void saveToFilename(String s);


    // Subset of the Collection interface.  These come from old uses of HashIndex. Particularly avoid using these.

    public boolean contains(Object o);

    public <T> T[] toArray(T[] a);

    public boolean add(E e);

    // public boolean remove(Object o);

    public boolean addAll(Collection<? extends E> c);

    public void clear();

}
