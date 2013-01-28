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
 * A <code>Word</code> object acts as a Label by containing a String.
 * This class is in essence identical to a <code>StringLabel</code>, but
 * it also uses the value to implement the <code>HasWord</code> interface.
 *
 * @author Christopher Manning
 * @version 2000/12/20
 */
public class Word extends StringLabel implements HasWord {

  /**
   * String representation of an empty.
   */
  public static final String EMPTYSTRING = "*t*";

  /**
   * Word representation of an empty.
   */
  public static final Word EMPTY = new Word(EMPTYSTRING);

  /**
   * Construct a new word with a <code>null</code> value.
   */
  public Word() {
    super();
  }

  /**
   * Construct a new word, with the given value.
   *
   * @param word String value of the Word
   */
  public Word(String word) {
    super(word);
  }

  /**
   * Construct a new word, with the given value.
   *
   * @param word String value of the Word
   */
  public Word(String word, int beginPosition, int endPosition) {
    super(word, beginPosition, endPosition);
  }


  /**
   * Creates a new word whose word value is the value of any
   * class that supports the <code>Label</code> interface.
   *
   * @param lab The label to be used as the basis of the new Word
   */
  public Word(Label lab) {
    super(lab);
  }


  public String word() {
    return value();
  }


  public void setWord(String word) {
    setValue(word);
  }

  // extra class guarantees correct lazy loading (Bloch p.194)
  private static class WordFactoryHolder {

    private static final LabelFactory lf = new WordFactory();

  }

  /**
   * Return a factory for this kind of label (i.e., <code>Word</code>).
   * The factory returned is always the same one (a singleton).
   *
   * @return The label factory
   */
  @Override
  public LabelFactory labelFactory() {
    return WordFactoryHolder.lf;
  }


  /**
   * Return a factory for this kind of label.
   *
   * @return The label factory
   */
  public static LabelFactory factory() {
    return WordFactoryHolder.lf;
  }

  private static final long serialVersionUID = -4817252915997034058L;

}
