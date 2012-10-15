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
 * A <code>StringLabelFactory</code> object makes a simple
 * <code>StringLabel</code> out of a <code>String</code>.
 *
 * @author Christopher Manning
 */
public class StringLabelFactory implements LabelFactory {

  /**
   * Make a new label with this <code>String</code> as the "name".
   *
   * @param labelStr A string that determines the content of the label.
   *                 For a StringLabel, it is exactly the given string
   * @return The created label
   */
  public Label newLabel(String labelStr) {
    return new StringLabel(labelStr);
  }


  /**
   * Make a new label with this <code>String</code> as the "name".
   *
   * @param labelStr A string that determines the content of the label.
   *                 For a StringLabel, it is exactly the given string
   * @param options  The options are ignored by a StringLabelFactory
   * @return The created label
   */
  public Label newLabel(String labelStr, int options) {
    return new StringLabel(labelStr);
  }


  /**
   * Make a new label with this <code>String</code> as the "name".
   * This version does no decoding -- StringLabels just have a value.
   *
   * @param labelStr A string that determines the content of the label.
   *                 For a StringLabel, it is exactly the given string
   * @return The created label
   */
  public Label newLabelFromString(String labelStr) {
    return new StringLabel(labelStr);
  }


  /**
   * Create a new <code>StringLabel</code>, where the label is
   * formed from
   * the <code>Label</code> object passed in.  Depending on what fields
   * each label has, other things will be <code>null</code>.
   *
   * @param oldLabel The Label that the new label is being created from
   * @return a new label of a particular type
   */
  public Label newLabel(Label oldLabel) {
    return new StringLabel(oldLabel);
  }

}
