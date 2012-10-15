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
 * A <code>LabeledWord</code> object contains a word and its tag.
 * The <code>value()</code> of a TaggedWord is the Word.  The tag
 * is, and is a Label instead of a String
 */
public class LabeledWord extends Word {

  private Label tag;
  
  private static final String DIVIDER = "/";

  /**
   * Create a new <code>TaggedWord</code>.
   * It will have <code>null</code> for its content fields.
   */
  public LabeledWord() {
    super();
  }

  /**
   * Create a new <code>TaggedWord</code>.
   *
   * @param word The word, which will have a <code>null</code> tag
   */
  public LabeledWord(String word) {
    super(word);
  }

  /**
   * Create a new <code>TaggedWord</code>.
   *
   * @param word The word
   * @param tag  The tag
   */
  public LabeledWord(String word, Label tag) {
    super(word);
    this.tag = tag;
  }

  public LabeledWord(Label word, Label tag) {
    super(word);
    this.tag = tag;
  }

  public Label tag() {
    return tag;
  }

  public void setTag(Label tag) {
    this.tag = tag;
  }

  @Override
  public String toString() {
    return toString(DIVIDER);
  }

  public String toString(String divider) {
    return word() + divider + tag;
  }

  // extra class guarantees correct lazy loading (Bloch p.194)
  private static class LabelFactoryHolder {

    private LabelFactoryHolder() {}

    private static final LabelFactory lf = new TaggedWordFactory();

  }

  /**
   * Return a factory for this kind of label
   * (i.e., <code>TaggedWord</code>).
   * The factory returned is always the same one (a singleton).
   *
   * @return The label factory
   */
  @Override
  public LabelFactory labelFactory() {
    return LabelFactoryHolder.lf;
  }


  /**
   * Return a factory for this kind of label.
   *
   * @return The label factory
   */
  public static LabelFactory factory() {
    return LabelFactoryHolder.lf;
  }

  private static final long serialVersionUID = -7252006452127051085L;

}
