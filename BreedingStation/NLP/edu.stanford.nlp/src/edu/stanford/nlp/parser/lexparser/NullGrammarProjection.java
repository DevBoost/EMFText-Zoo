/*******************************************************************************
 * Copyright (C) 2012
 * Jan Reimann (TU Dresden, Software Technology Group)
 * Mirko Seifert (DevBoost GmbH)
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

/** @author Dan Klein */
class NullGrammarProjection implements GrammarProjection {
  UnaryGrammar ug;
  BinaryGrammar bg;

  public int project(int state) {
    return state;
  }

  public UnaryGrammar sourceUG() {
    return ug;
  }

  public BinaryGrammar sourceBG() {
    return bg;
  }

  public UnaryGrammar targetUG() {
    return ug;
  }

  public BinaryGrammar targetBG() {
    return bg;
  }

  NullGrammarProjection(BinaryGrammar bg, UnaryGrammar ug) {
    this.ug = ug;
    this.bg = bg;
  }
}
