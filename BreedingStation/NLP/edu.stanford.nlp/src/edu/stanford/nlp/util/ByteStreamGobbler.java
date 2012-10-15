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
package edu.stanford.nlp.util;

import java.io.*;

/**
 * Stream Gobbler that read and write bytes
 * (can be used to gobble byte based stdout from a process.exec into a file)
 *
 * @author Angel Chang
 */
public class ByteStreamGobbler extends Thread {
  InputStream inStream;
  OutputStream outStream;
  int bufferSize = 4096;

  public ByteStreamGobbler(InputStream is, OutputStream out) {
    this.inStream = new BufferedInputStream(is);
    this.outStream = new BufferedOutputStream(out);
  }

  public ByteStreamGobbler(String name, InputStream is, OutputStream out) {
    super(name);
    this.inStream = new BufferedInputStream(is);
    this.outStream = new BufferedOutputStream(out);
  }

  public ByteStreamGobbler(String name, InputStream is, OutputStream out, int bufferSize) {
    super(name);
    this.inStream = new BufferedInputStream(is);
    this.outStream = new BufferedOutputStream(out);
    if (bufferSize <= 0) {
      throw new IllegalArgumentException("Invalid buffer size " + bufferSize + ": must be larger than 0");
    }
    this.bufferSize = bufferSize;
  }

  public InputStream getInputStream()
  {
    return inStream;
  }

  public OutputStream getOutputStream()
  {
    return outStream;
  }

  public void run() {
    try {
      byte[] b = new byte[bufferSize];
      int bytesRead;
      while ((bytesRead = inStream.read(b)) >= 0) {
        if (bytesRead > 0) {
          outStream.write(b, 0, bytesRead);
        }
      }
      inStream.close();
    } catch (Exception ex) {
      System.out.println("Problem reading stream :"+inStream.getClass().getCanonicalName()+ " "+ ex);
      ex.printStackTrace();
    }
  }
}
