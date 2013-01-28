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
package edu.stanford.nlp.trees.international.pennchinese;

import java.util.List;
import java.util.ArrayList;
import java.util.regex.*;

import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.util.Function;
import edu.stanford.nlp.util.StringUtils;

/**
 * An Escaper for Chinese normalization to match Treebank.
 * Currently normalizes "ASCII" characters into the full-width
 * range used inside the Penn Chinese Treebank.
 * <p/>
 * <i>Notes:</i> Smart quotes appear in CTB, and are left unchanged.
 * I think you get various hyphen types from U+2000 range too - certainly,
 * Roger lists them in LanguagePack.
 *
 * @author Christopher Manning
 */
public class ChineseEscaper implements Function<List<HasWord>, List<HasWord>> {

  /** IBM entity normalization patterns */
  private static final Pattern p2 = Pattern.compile("\\$[a-z]+_\\((.*?)\\|\\|.*?\\)");


  /** <i>Note:</i> At present this clobbers the input list items.
   *  This should be fixed.
   */
  public List<HasWord> apply(List<HasWord> arg) {
    List<HasWord> ans = new ArrayList<HasWord>(arg);
    for (HasWord wd : ans) {
      String w = wd.word();
      Matcher m2 = p2.matcher(w);
      // System.err.println("Escaper: w is " + w);
      if (m2.find()) {
        // System.err.println("  Found pattern.");
        w = m2.replaceAll("$1");
        // System.err.println("  Changed it to: " + w);
      }
      String newW = StringUtils.tr(w,
                                   "!\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~",
                                   "\uFF01\uFF02\uFF03\uFF04\uFF05\uFF06\uFF07\uFF08\uFF09\uFF0A\uFF0B\uFF0C\uFF0D\uFF0E\uFF0F\uFF10\uFF11\uFF12\uFF13\uFF14\uFF15\uFF16\uFF17\uFF18\uFF19\uFF1A\uFF1B\uFF1C\uFF1D\uFF1E\uFF1F\uFF20\uFF21\uFF22\uFF23\uFF24\uFF25\uFF26\uFF27\uFF28\uFF29\uFF2A\uFF2B\uFF2C\uFF2D\uFF2E\uFF2F\uFF30\uFF31\uFF32\uFF33\uFF34\uFF35\uFF36\uFF37\uFF38\uFF39\uFF3A\uFF3B\uFF3C\uFF3D\uFF3E\uFF3F\uFF40\uFF41\uFF42\uFF43\uFF44\uFF45\uFF46\uFF47\uFF48\uFF49\uFF4A\uFF4B\uFF4C\uFF4D\uFF4E\uFF4F\uFF50\uFF51\uFF52\uFF53\uFF54\uFF55\uFF56\uFF57\uFF58\uFF59\uFF5A\uFF5B\uFF5C\uFF5D\uFF5E");
      wd.setWord(newW);
    }
    return ans;
  }

}

