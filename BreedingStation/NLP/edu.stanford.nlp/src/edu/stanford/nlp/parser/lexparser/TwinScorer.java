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

import java.util.List;

import edu.stanford.nlp.ling.HasWord;


/** @author Dan Klein */
class TwinScorer implements Scorer {

  private Scorer scorer1;
  private Scorer scorer2;

  public double oScore(Edge edge) {
    return scorer1.oScore(edge) + scorer2.oScore(edge);
  }

  public double iScore(Edge edge) {
    return scorer1.iScore(edge) + scorer2.iScore(edge);
  }

  public boolean oPossible(Hook hook) {
    return scorer1.oPossible(hook) && scorer2.oPossible(hook);
  }

  public boolean iPossible(Hook hook) {
    return scorer1.iPossible(hook) && scorer2.iPossible(hook);
  }

  public boolean parse(List<? extends HasWord> words) {
    boolean b1 = scorer1.parse(words);
    boolean b2 = scorer2.parse(words);
    return (b1 && b2);
  }

  public TwinScorer(Scorer scorer1, Scorer scorer2) {
    this.scorer1 = scorer1;
    this.scorer2 = scorer2;
  }

}
