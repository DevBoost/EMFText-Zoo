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


/**
 * A class storing information about a constituent in a character-based tree.
 * This is used for evaluation of character-based Chinese parsing.
 * The constituent can be of type "word" (for words), "cat" (for phrases) or "tag" (for POS).
 * @author Galen Andrew
 */
public class WordCatConstituent extends LabeledConstituent {
  public String type;
  public static final String wordType = "word";
  public static final String tagType = "tag";
  public static final String catType = "cat";
  // this one is for POS tag of correctly segmented words only
  public static final String goodWordTagType = "goodWordTag";

  public WordCatConstituent(Tree subTree, Tree root, String type) {
    setStart(Trees.leftEdge(subTree, root));
    setEnd(Trees.rightEdge(subTree, root));
    setFromString(subTree.value());
    this.type = type;
  }


}
