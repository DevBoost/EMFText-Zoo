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
package edu.stanford.nlp.international;

import edu.stanford.nlp.parser.lexparser.ArabicTreebankParserParams;
import edu.stanford.nlp.parser.lexparser.ChineseTreebankParserParams;
import edu.stanford.nlp.parser.lexparser.EnglishTreebankParserParams;
import edu.stanford.nlp.parser.lexparser.FrenchTreebankParserParams;
import edu.stanford.nlp.parser.lexparser.HebrewTreebankParserParams;
import edu.stanford.nlp.parser.lexparser.NegraPennTreebankParserParams;
import edu.stanford.nlp.parser.lexparser.TreebankLangParserParams;

/**
 * Constants and parameters for multilingual parsing.
 *  
 * @author Spence Green
 *
 */
public class Languages {

  private Languages() {}

  public static enum Language {Arabic,Chinese,English,German,French,Hebrew}
  
  private static String langList;
  static {
    StringBuilder sb = new StringBuilder();
    for(Language lang : Language.values()) {
      sb.append(lang.toString());
      sb.append(" ");
    }
    langList = sb.toString().trim();
  }

  public static String listOfLanguages() {
    return langList;
  }

  public static TreebankLangParserParams getLanguageParams(String lang) {
    return getLanguageParams(Language.valueOf(lang));
  }

  public static TreebankLangParserParams getLanguageParams(Language lang) {
    TreebankLangParserParams tlpp; // initialized below
    switch(lang) {
    case Arabic:
      tlpp = new ArabicTreebankParserParams();
      break;
   
    case Chinese:
      tlpp = new ChineseTreebankParserParams();
      break;

    case German:
      tlpp = new NegraPennTreebankParserParams();
      break;

    case French:
      tlpp = new FrenchTreebankParserParams();
      break;

    case Hebrew:
      tlpp = new HebrewTreebankParserParams();
      break;

    default:
      tlpp = new EnglishTreebankParserParams();
    }
    return tlpp;
  }
}
