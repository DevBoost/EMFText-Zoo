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

import edu.stanford.nlp.stats.EquivalenceClassEval;

/**
 * An EqualityChecker for WordCatConstituents.  
 * Words only have to have the correct span
 * while tags (word/POS) and cats (labeled brackets) must have correct span
 * and label.
 *
 * @author Galen Andrew
 */
public class WordCatEqualityChecker implements EquivalenceClassEval.EqualityChecker {

  public boolean areEqual(Object o, Object o2) {
    WordCatConstituent span = (WordCatConstituent) o;
    WordCatConstituent span2 = (WordCatConstituent) o2;
    if (span.type != span2.type) {
      return false;
    } else if (span.start() != span2.start() || span.end() != span2.end()) {
      return false;
    } else if (span.type != WordCatConstituent.wordType && !span.value().equals(span2.value())) {
      return false;
    } else {
      return true;
    }
  }
}
