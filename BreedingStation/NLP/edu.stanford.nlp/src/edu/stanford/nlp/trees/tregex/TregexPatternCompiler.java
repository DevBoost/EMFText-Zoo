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
// TregexPatternCompiler
// Copyright (c) 2004-2007 The Board of Trustees of
// The Leland Stanford Junior University. All Rights Reserved.
//
// This program is free software; you can redistribute it and/or
// modify it under the terms of the GNU General Public License
// as published by the Free Software Foundation; either version 2
// of the License, or (at your option) any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
//
//
// For more information, bug reports, fixes, contact:
//    Christopher Manning
//    Dept of Computer Science, Gates 1A
//    Stanford CA 94305-9010
//    USA
//    Support/Questions: parser-user@lists.stanford.edu
//    Licensing: parser-support@lists.stanford.edu
//    http://www-nlp.stanford.edu/software/tregex.shtml

package edu.stanford.nlp.trees.tregex;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import edu.stanford.nlp.util.Function;
import edu.stanford.nlp.util.Pair;
import edu.stanford.nlp.trees.CollinsHeadFinder;
import edu.stanford.nlp.trees.HeadFinder;
import edu.stanford.nlp.trees.PennTreebankLanguagePack;

/**
 * A class for compiling TregexPatterns with specific HeadFinders and or
 * basicCategoryFunctions.
 *
 * @author Galen Andrew
 */
public class TregexPatternCompiler {

  static final Function<String, String> DEFAULT_BASIC_CAT_FUNCTION =
    new PennTreebankLanguagePack().getBasicCategoryFunction();

  static final HeadFinder DEFAULT_HEAD_FINDER = new CollinsHeadFinder();

  private final Function<String,String> basicCatFunction;
  private final HeadFinder headFinder;

  private final List<Pair<String, String>> macros =
    new ArrayList<Pair<String, String>>();

  public static final TregexPatternCompiler defaultCompiler =
    new TregexPatternCompiler();

  public TregexPatternCompiler() {
    this(DEFAULT_HEAD_FINDER, DEFAULT_BASIC_CAT_FUNCTION);
  }

  /**
   * A compiler that uses this basicCatFunction and the default HeadFinder.
   *
   * @param basicCatFunction the function mapping Strings to Strings
   */
  public TregexPatternCompiler(Function<String,String> basicCatFunction) {
    this(DEFAULT_HEAD_FINDER, basicCatFunction);
  }

  /**
   * A compiler that uses this HeadFinder and the default basicCategoryFunction
   *
   * @param headFinder the HeadFinder
   */
  public TregexPatternCompiler(HeadFinder headFinder) {
    this(headFinder, DEFAULT_BASIC_CAT_FUNCTION);
  }

  /**
   * A compiler that uses this HeadFinder and this basicCategoryFunction
   *
   * @param headFinder       the HeadFinder
   * @param basicCatFunction The function mapping Strings to Strings
   */
  public TregexPatternCompiler(HeadFinder headFinder,
                               Function<String,String> basicCatFunction) {
    this.headFinder = headFinder;
    this.basicCatFunction = basicCatFunction;
  }

  public void addMacro(String original, String replacement) {
    macros.add(new Pair<String, String>(original, replacement));
  }

  /**
   * Create a TregexPattern from this tregex string using the headFinder and
   * basicCat function this TregexPatternCompiler was created with.
   *
   * <i>Implementation note:</i> If there is an invalid token in the Tregex
   * parser, JavaCC will throw a TokenMgrError.  This is a class
   * that extends Error, not Exception (OMG! - bad!), and so rather than
   * requiring clients to catch it, we wrap it in a ParseException.
   * (The original Error's are thrown in TregexParserTokenManager.)
   *
   * @param tregex The pattern to parse
   * @return A new TregexPattern object based on this string
   * @throws TregexParseException If the expression is syntactically invalid
   */
  public TregexPattern compile(String tregex) {
    for (Pair<String, String> macro : macros) {
      tregex = tregex.replaceAll(macro.first(), macro.second());
    }
    TregexPattern pattern;
    try {
      TregexParser parser = new TregexParser(new StringReader(tregex + '\n'),
                                             basicCatFunction, headFinder);
      pattern = parser.Root();
    } catch (TokenMgrError tme) {
      throw new TregexParseException("Could not parse " + tregex, tme);
    } catch (ParseException e) {
      throw new TregexParseException("Could not parse " + tregex, e);
    }
    pattern.setPatternString(tregex);
    return pattern;
  }

}
