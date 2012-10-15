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
package edu.stanford.nlp.parser.lexparser;

/**
 * 
 * @author Spence Green
 *
 */
public class FactoredLexiconEvent {

  private final int wordId;
  private final int lemmaId;
  private final int tagId;
  private final int morphId;
  private final int loc;
  private final String word;
  private final String featureStr;
  
  public FactoredLexiconEvent(int wordId, int tagId, int lemmaId, int morphId, int loc, String word, String featureStr) {
    this.wordId = wordId;
    this.tagId = tagId;
    this.lemmaId = lemmaId;
    this.morphId = morphId;
    this.loc = loc;
    this.word = word;
    this.featureStr = featureStr;
  }
  
  public int wordId() { return wordId; }
  public int tagId() { return tagId; }
  public int morphId() { return morphId; }
  public int lemmaId() { return lemmaId; }
  public int getLoc() { return loc; }
  public String word() { return word; }
  
  public String featureStr() { return featureStr; }
  
  @Override
  public String toString() {
    return word;
  }
}
