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

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import edu.stanford.nlp.trees.Tree;

public class EvalbFormatWriter {
  public final static String DEFAULT_GOLD_FILENAME = "parses.gld";
  public final static String DEFAULT_TEST_FILENAME = "parses.tst";
  private PrintWriter goldWriter;
  private PrintWriter testWriter;
  private int count = 0;
  private final static EvalbFormatWriter DEFAULT_WRITER = new EvalbFormatWriter();

  public void initFiles(TreebankLangParserParams tlpParams, String goldFilename, String testFilename) {
    try {
      goldWriter = tlpParams.pw(new FileOutputStream(goldFilename));
      testWriter = tlpParams.pw(new FileOutputStream(testFilename));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    count = 0;
  }

  public void initFiles(TreebankLangParserParams tlpParams, String testFilename) {
    try {
      goldWriter = null;
      testWriter = tlpParams.pw(new FileOutputStream(testFilename));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    count = 0;
  }

  public void writeTree(Tree test)
  {
    testWriter.println((test == null) ? "(())" : test.toString());
    count++;
//    System.err.println("Wrote EVALB lines.");
  }

  public void writeTrees(Tree gold, Tree test)
  {
    goldWriter.println((gold == null) ? "(())" : gold.toString());
    testWriter.println((test == null) ? "(())" : test.toString());
    count++;
//    System.err.println("Wrote EVALB lines.");
  }

  public void closeFiles() {
    if (goldWriter != null) goldWriter.close();
    if (testWriter != null) testWriter.close();
    System.err.println("Wrote " + count + " EVALB lines.");
  }

  public static void initEVALBfiles(TreebankLangParserParams tlpParams) {
    DEFAULT_WRITER.initFiles(tlpParams, DEFAULT_GOLD_FILENAME, DEFAULT_TEST_FILENAME);
  }

  public static void closeEVALBfiles() {
    DEFAULT_WRITER.closeFiles();
  }

  public static void writeEVALBline(Tree gold, Tree test) {
    DEFAULT_WRITER.writeTrees(gold, test);    
  }
}
