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
 * A <code>Tag</code> object acts as a Label by containing a
 * <code>String</code> that is a part-of-speech tag.
 *
 * @author Christopher Manning
 * @version 2003/02/15 (implements TagFactory correctly now)
 */
public class Tag extends StringLabel implements HasTag {

  /**
   * 
   */
  private static final long serialVersionUID = 1143434026005416755L;


  /**
   * Constructs a Tag object.
   */
  public Tag() {
    super();
  }

  /**
   * Constructs a Tag object.
   *
   * @param tag The tag name
   */
  public Tag(String tag) {
    super(tag);
  }


  /**
   * Creates a new tag whose tag value is the value of any
   * class that supports the <code>Label</code> interface.
   *
   * @param lab The label to be used as the basis of the new Tag
   */
  public Tag(Label lab) {
    super(lab);
  }


  public String tag() {
    return value();
  }


  public void setTag(String tag) {
    setValue(tag);
  }


  /**
   * A <code>TagFactory</code> acts as a factory for creating objects
   * of class <code>Tag</code>
   */
  private static class TagFactory implements LabelFactory {

    public TagFactory() {
    }


    /**
     * Create a new <code>Tag</code>, where the label is formed
     * from the <code>String</code> passed in.
     *
     * @param cat The cat that will go into the <code>Tag</code>
     */
    public Label newLabel(String cat) {
      return new Tag(cat);
    }


    /**
     * Create a new <code>Tag</code>, where the label is formed
     * from the <code>String</code> passed in.
     *
     * @param cat     The cat that will go into the <code>Tag</code>
     * @param options is ignored by a TagFactory
     */
    public Label newLabel(String cat, int options) {
      return new Tag(cat);
    }


    /**
     * Create a new <code>Tag</code>, where the label is formed
     * from the <code>String</code> passed in.
     *
     * @param cat The cat that will go into the <code>Tag</code>
     */
    public Label newLabelFromString(String cat) {
      return new Tag(cat);
    }


    /**
     * Create a new <code>Tag Label</code>, where the label is
     * formed from
     * the <code>Label</code> object passed in.  Depending on what fields
     * each label has, other things will be <code>null</code>.
     *
     * @param oldLabel The Label that the new label is being created from
     * @return a new label of a particular type
     */
    public Label newLabel(Label oldLabel) {
      return new Tag(oldLabel);
    }

  }


  // extra class guarantees correct lazy loading (Bloch p.194)
  private static class LabelFactoryHolder {

    private static final LabelFactory lf = new TagFactory();

  }


  /**
   * Return a factory for this kind of label
   * (i.e., <code>Tag</code>).
   * The factory returned is always the same one (a singleton).
   *
   * @return The label factory
   */
  @Override
  public LabelFactory labelFactory() {
    return LabelFactoryHolder.lf;
  }


  /**
   * Return a factory for this kind of label
   * (i.e., <code>Tag</code>).
   * The factory returned is always the same one (a singleton).
   *
   * @return The label factory
   */
  public static LabelFactory factory() {
    return LabelFactoryHolder.lf;
  }

}
