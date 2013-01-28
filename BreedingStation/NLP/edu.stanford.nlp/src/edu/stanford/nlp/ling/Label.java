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
package edu.stanford.nlp.ling;

/**
 * Something that implements the <code>Label</code> interface can act as a
 * constituent, node, or word label with linguistic attributes.
 * A <code>Label</code> is required to have a "primary" <code>String</code>
 * <code>value()</code> (although this may be null).  This is referred to as
 * its <code>value</code>.
 * <p>
 * Implementations of Label split into two groups with
 * respect to equality. Classes that extend ValueLabel define equality
 * solely in terms of String equality of its value (secondary facets may be
 * present but are ignored for purposes of equality), and have equals and
 * compareTo defined across all subclasses of ValueLabel. This behavior
 * should not be changed. Other classes that implement Label define equality only
 * with their own type and require all fields of the type to be equal.
 * <p>
 * A subclass that extends another Label class <i>should</i> override
 * the definition of <code>labelFactory()</code>, since the contract for
 * this method is that it should return a factory for labels of the
 * exact same object type.

 * @author Christopher Manning
 */
public interface Label {

  /**
   * Return a String representation of just the "main" value of this label.
   *
   * @return the "value" of the label
   */
  public String value();


  /**
   * Set the value for the label (if one is stored).
   *
   * @param value - the value for the label
   */
  public void setValue(String value);


  /**
   * Return a String representation of the label.  For a multipart label,
   * this will return all parts.  The <code>toString()</code> method
   * causes a label to spill its guts.  It should always return an
   * empty string rather than <code>null</code> if there is no value.
   *
   * @return a text representation of the full label contents
   */
  public String toString();


  /**
   * Set the contents of this label to this <code>String</code>
   * representing the
   * complete contents of the label.  A class implementing label may
   * throw an <code>UnsupportedOperationException</code> for this
   * method (only).  Typically, this method would do
   * some appropriate decoding of the string in a way that sets
   * multiple fields in an inverse of the <code>toString()</code>
   * method.
   *
   * @param labelStr the String that translates into the content of the
   *                 label
   */
  public void setFromString(String labelStr);

  /**
   * Returns a factory that makes labels of the exact same type as this one.
   * May return <code>null</code> if no appropriate factory is known.
   *
   * @return the LabelFactory for this kind of label
   */
  public LabelFactory labelFactory();

}
