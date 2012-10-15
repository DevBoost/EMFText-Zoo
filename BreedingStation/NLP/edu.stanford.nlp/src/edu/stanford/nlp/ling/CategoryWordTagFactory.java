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
 * A <code>CategoryWordTagFactory</code> is a factory that makes
 * a <code>Label</code> which is a <code>CategoryWordTag</code> triplet.
 *
 * @author Christopher Manning
 */
public class CategoryWordTagFactory implements LabelFactory {

  /**
   * Make a new label with this <code>String</code> as the "name".
   *
   * @param labelStr The string to use as a label
   * @return The newly created Label
   */
  public Label newLabel(String labelStr) {
    return new CategoryWordTag(labelStr);
  }

  /**
   * Make a new label with this <code>String</code> as the value.
   * This implementation ignores the options
   *
   * @param labelStr The String that will be used for balue
   * @param options  This argument is ignored
   * @return The newly created Label
   */
  public Label newLabel(String labelStr, int options) {
    return new CategoryWordTag(labelStr);
  }

  /**
   * Make a new label with this <code>String</code> as the "name".
   *
   * @param labelStr The string to use as a label
   * @return The newly created Label
   */
  public Label newLabelFromString(String labelStr) {
    CategoryWordTag cwt = new CategoryWordTag();
    cwt.setFromString(labelStr);
    return cwt;
  }

  /**
   * Create a new CategoryWordTag label, where the label is formed from
   * the various <code>String</code> objects passed in.
   *
   * @param word     The word part of the label
   * @param tag      The tag part of the label
   * @param category The category part of the label
   * @return The newly created Label
   */
  public Label newLabel(String word, String tag, String category) {
    // System.out.println("Making new CWT label: " + category + " | " +
    //		   word + " | " + tag);
    return new CategoryWordTag(category, word, tag);
  }

  /**
   * Create a new <code>CategoryWordTag Label</code>, where the label is
   * formed from
   * the <code>Label</code> object passed in.  Depending on what fields
   * each label has, other things will be <code>null</code>.
   *
   * @param oldLabel The Label that the new label is being created from
   * @return a new label of a particular type
   */
  public Label newLabel(Label oldLabel) {
    return new CategoryWordTag(oldLabel);
  }

}

