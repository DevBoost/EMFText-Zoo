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
 * A <code>WordFactory</code> acts as a factory for creating objects of
 * class <code>Word</code>.
 *
 * @author Christopher Manning
 * @version 2000/12/20
 */
public class WordFactory implements LabelFactory {

  /**
   * Creates a new WordFactory.
   */
  public WordFactory() {
  }


  /**
   * Create a new word, where the label is formed from
   * the <code>String</code> passed in.
   *
   * @param word The word that will go into the <code>Word</code>
   * @return The new label
   */
  public Label newLabel(String word) {
    return new Word(word);
  }


  /**
   * Create a new word, where the label is formed from
   * the <code>String</code> passed in.
   *
   * @param word    The word that will go into the <code>Word</code>
   * @param options is ignored by a WordFactory
   * @return The new label
   */
  public Label newLabel(String word, int options) {
    return new Word(word);
  }


  /**
   * Create a new word, where the label is formed from
   * the <code>String</code> passed in.
   *
   * @param word The word that will go into the <code>Word</code>
   * @return The new label
   */
  public Label newLabelFromString(String word) {
    return new Word(word);
  }


  /**
   * Create a new <code>Word Label</code>, where the label is
   * formed from
   * the <code>Label</code> object passed in.  Depending on what fields
   * each label has, other things will be <code>null</code>.
   *
   * @param oldLabel The Label that the new label is being created from
   * @return a new label of a particular type
   */
  public Label newLabel(Label oldLabel) {
    return new Word(oldLabel);
  }

}
