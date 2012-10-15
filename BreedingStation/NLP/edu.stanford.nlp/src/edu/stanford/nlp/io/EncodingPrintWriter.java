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
package edu.stanford.nlp.io;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * A convenience IO class with print and println statements to
 * standard output and standard error allowing encoding in an
 * arbitrary character set.  It also provides methods which use UTF-8
 * always, overriding the system default charset.
 *
 * @author Roger Levy
 * @author Christopher Manning
 */

public class EncodingPrintWriter {

  private static final String DEFAULT_ENCODING = "UTF-8";

  private static PrintWriter cachedErrWriter;
  private static String cachedErrEncoding = "";

  private static PrintWriter cachedOutWriter;
  private static String cachedOutEncoding = "";

  // uninstantiable
  private EncodingPrintWriter() {}

  /**
   * Print methods wrapped around System.err
   */
  public static class err {

    private err() {} // uninstantiable

    private static void setupErrWriter(String encoding) {
      if (encoding == null) {
        encoding = DEFAULT_ENCODING;
      }
      if (cachedErrWriter == null || ! cachedErrEncoding.equals(encoding)) {
        try {
          cachedErrWriter = new PrintWriter(new OutputStreamWriter(System.err, encoding), true);
          cachedErrEncoding = encoding;
        } catch (UnsupportedEncodingException e) {
          System.err.println("Error " + e + "Printing as default encoding.");
          cachedErrWriter = new PrintWriter(new OutputStreamWriter(System.err), true);
          cachedErrEncoding = "";
        }
      }
    }

    public static void println(String o, String encoding) {
      setupErrWriter(encoding);
      cachedErrWriter.println(o);
    }

    public static void print(String o, String encoding) {
      setupErrWriter(encoding);
      cachedErrWriter.print(o);
      cachedErrWriter.flush();
    }

    public static void println(String o) {
      println(o, null);
    }

    public static void print(String o) {
      print(o, null);
    }

  } // end static class err


  /**
   * Print methods wrapped around System.out
   */
  public static class out {

    private out() {} // uninstantiable

    private static void setupOutWriter(String encoding) {
      if (encoding == null) {
        encoding = DEFAULT_ENCODING;
      }
      if (cachedOutWriter == null || ! cachedOutEncoding.equals(encoding)) {
        try {
          cachedOutWriter = new PrintWriter(new OutputStreamWriter(System.out, encoding), true);
          cachedOutEncoding = encoding;
        } catch (UnsupportedEncodingException e) {
          System.err.println("Error " + e + "Printing as default encoding.");
          cachedOutWriter = new PrintWriter(new OutputStreamWriter(System.out), true);
          cachedOutEncoding = "";
        }
      }
    }

    public static void println(String o, String encoding) {
      setupOutWriter(encoding);
      cachedOutWriter.println(o);

    }

    public static void print(String o, String encoding) {
      setupOutWriter(encoding);
      cachedOutWriter.print(o);
      cachedOutWriter.flush();
    }

    /** Print the argument plus a NEWLINE in UTF-8, regardless of
     *  the platform default.
     *
     *  @param o String to print
     */
    public static void println(String o) {
      println(o, null);
    }

    public static void print(String o) {
      print(o, null);
    }

  } // end static class out

}
