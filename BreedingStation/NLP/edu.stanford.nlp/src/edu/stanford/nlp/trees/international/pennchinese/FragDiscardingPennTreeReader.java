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

import edu.stanford.nlp.process.Tokenizer;
import edu.stanford.nlp.trees.PennTreeReader;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeFactory;
import edu.stanford.nlp.trees.TreeNormalizer;

import java.io.*;

/**
 * @author Galen Andrew
 */
public class FragDiscardingPennTreeReader extends PennTreeReader {
  public FragDiscardingPennTreeReader(Reader in, TreeFactory tf, TreeNormalizer tn, Tokenizer<String> tk) {
    super(in, tf, tn, tk);
  }

//  private static PrintWriter pw;
//
//  static {
//    try {
//      if (false) {
//        pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("discardedFRAGs.chi"), "GB18030"), true);
//      }
//    } catch (Exception e) {
//      throw new RuntimeException("");
//    }
//  }

  @Override
  public Tree readTree() throws IOException {
    Tree tr = super.readTree();
    while (tr != null && tr.firstChild().value().equals("FRAG")) {
//      if (pw != null) {
//        pw.println("Discarding Tree:");
//        tr.pennPrint(pw);
//      }
      tr = super.readTree();
    }
    return tr;
  }
}
