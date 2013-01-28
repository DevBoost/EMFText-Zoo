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
package edu.stanford.nlp.trees;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.Label;
import edu.stanford.nlp.util.XMLUtils;

/**
 * An individual dependency between a head and a dependent.
 * The head and dependent are represented as a Label.
 * For example, these can be a
 * Word or a WordTag.  If one wishes the dependencies to preserve positions
 * in a sentence, then each can be a LabeledConstituent.
 *
 * @author Christopher Manning
 * @author Spence Green
 * 
 */
public class UnnamedDependency implements Dependency<Label, Label, Object> {

  private static final long serialVersionUID = -3768440215342256085L;

  // We store the text of the labels separately because it looks like
  // it is possible for an object to request a hash code using itself
  // in a partially reconstructed state when unserializing.  For
  // example, a TreeGraphNode might ask for the hash code of an
  // UnnamedDependency, which then uses an unfilled member of the same
  // TreeGraphNode to get the hash code.  Keeping the text of the
  // labels breaks that possible cycle.
  protected final String regentText;
  protected final String dependentText;

  private final Label regent;
  private final Label dependent;

  public UnnamedDependency(String regent, String dependent) {
    if (regent == null || dependent == null) {
      throw new IllegalArgumentException("governor or dependent cannot be null");
    }
    
    CoreLabel headLabel = new CoreLabel();
    headLabel.setValue(regent);
    headLabel.setWord(regent);
    this.regent = headLabel;
    
    CoreLabel depLabel = new CoreLabel();
    depLabel.setValue(dependent);
    depLabel.setWord(dependent);
    this.dependent = depLabel;

    regentText = regent;
    dependentText = dependent;
  }

  public UnnamedDependency(Label regent, Label dependent) {
    if (regent == null || dependent == null) {
      throw new IllegalArgumentException("governor or dependent cannot be null");
    }
    this.regent = regent;
    this.dependent = dependent;

    regentText = getText(regent);
    dependentText = getText(dependent);
  }

  public Label governor() {
    return regent;
  }

  public Label dependent() {
    return dependent;
  }

  public Object name() {
    return null;
  }
  
  protected String getText(Label label) {
    return ((label instanceof HasWord) ? 
            ((HasWord) label).word() : label.value());
  }

  @Override
  public int hashCode() {
    return regentText.hashCode() ^ dependentText.hashCode();
  }

  @Override
  public boolean equals(Object o) {
    return equalsIgnoreName(o);
  }
  
  public boolean equalsIgnoreName(Object o) {
     if (this == o) {
        return true;
      } else if( !(o instanceof UnnamedDependency)) {
        return false;
      }
      UnnamedDependency d = (UnnamedDependency) o;

      String thisHeadWord = regentText;
      String thisDepWord = dependentText;
      String headWord = d.regentText;
      String depWord = d.dependentText;

      return thisHeadWord.equals(headWord) && thisDepWord.equals(depWord);
  }

  @Override
  public String toString() {
    return String.format("%s --> %s", regentText, dependentText);
  }

  /**
   * Provide different printing options via a String keyword.
   * The recognized options are currently "xml", and "predicate".
   * Otherwise the default toString() is used.
   */
  public String toString(String format) {
    if ("xml".equals(format)) {
      return "  <dep>\n    <governor>" + XMLUtils.escapeXML(governor().value()) + "</governor>\n    <dependent>" + XMLUtils.escapeXML(dependent().value()) + "</dependent>\n  </dep>";
    } else if ("predicate".equals(format)) {
      return "dep(" + governor() + "," + dependent() + ")";
    } else {
      return toString();
    }
  }
  
  public DependencyFactory dependencyFactory() {
    return DependencyFactoryHolder.df;
  }
  
  public static DependencyFactory factory() {
    return DependencyFactoryHolder.df;
  }

  // extra class guarantees correct lazy loading (Bloch p.194)
  private static class DependencyFactoryHolder {
    private static final DependencyFactory df = new UnnamedDependencyFactory();
  }

  /**
   * A <code>DependencyFactory</code> acts as a factory for creating objects
   * of class <code>Dependency</code>
   */
  private static class UnnamedDependencyFactory implements DependencyFactory {
    /**
     * Create a new <code>Dependency</code>.
     */
    public Dependency<Label, Label, Object> newDependency(Label regent, Label dependent) {
      return newDependency(regent, dependent, null);
    }

    /**
     * Create a new <code>Dependency</code>.
     */
    public Dependency<Label, Label, Object> newDependency(Label regent, Label dependent, Object name) {
      return new UnnamedDependency(regent, dependent);
    }
  }
}
