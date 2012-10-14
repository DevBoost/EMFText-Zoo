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
package edu.stanford.nlp.util;

import java.io.*;

/**
 * Reads the output of a process started by Process.exec()
 *
 * Adapted from:
 *
 * http://www.velocityreviews.com/forums/t130884-process-runtimeexec-causes-subprocess-hang.html
 *
 * @author pado
 *
 */

public class StreamGobbler extends Thread {

  InputStream is;
  Writer outputFileHandle;

  public StreamGobbler (InputStream is, Writer outputFileHandle) {
    this.is = is;
    this.outputFileHandle = outputFileHandle;
  }

  public void run() {

    try {
      InputStreamReader isr = new InputStreamReader (is);
      BufferedReader br = new BufferedReader (isr);

      for (String s; (s = br.readLine()) != null; ) {
        outputFileHandle.write(s);
        outputFileHandle.write("\n");
      }

      isr.close();
      br.close();
      outputFileHandle.flush();
    } catch (Exception ex) {
      System.out.println ("Problem reading stream :"+is.getClass().getCanonicalName()+ " "+ ex);
      ex.printStackTrace ();
    }

  }
}
