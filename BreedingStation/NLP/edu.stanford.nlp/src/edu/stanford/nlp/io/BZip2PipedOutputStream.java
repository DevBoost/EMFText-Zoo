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

import edu.stanford.nlp.util.ByteStreamGobbler;
import edu.stanford.nlp.util.StreamGobbler;

import java.io.*;

/**
* Opens a outputstream for writing into a bzip2 file by piping into the bzip2 command.
* Output from bzip2 command is written into the specified file.
* 
* @author Angel Chang
*/
public class BZip2PipedOutputStream extends OutputStream
{
  private String filename;
  private Process process;
  private ByteStreamGobbler outGobbler;
  private StreamGobbler errGobbler;
  private PrintWriter errWriter;

  public BZip2PipedOutputStream(String filename) throws IOException {
    this(filename, System.err);
  }

  public BZip2PipedOutputStream(String filename, OutputStream err) throws IOException {
    String bzip2 = System.getProperty("bzip2", "bzip2");
    String cmd = bzip2; // + " > " + filename;
    //System.err.println("getBZip2PipedOutputStream: Running command: "+cmd);
    ProcessBuilder pb = new ProcessBuilder();
    pb.command(cmd);
    this.process = pb.start();
    this.filename = filename;
    OutputStream outStream = new FileOutputStream(filename);
    errWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(err)));
    outGobbler = new ByteStreamGobbler("Output stream gobbler: " + cmd + " " + filename,
            process.getInputStream(), outStream);
    errGobbler = new StreamGobbler(process.getErrorStream(), errWriter);
    outGobbler.start();
    errGobbler.start();
  }

  public void flush() throws IOException
  {
    process.getOutputStream().flush();
  }

  public void write(int b) throws IOException
  {
    process.getOutputStream().write(b);
  }

  public void close() throws IOException
  {
    process.getOutputStream().close();
    try {
      outGobbler.join();
      errGobbler.join();
      outGobbler.getOutputStream().close();
      process.waitFor();
    } catch (InterruptedException ex) {}
    //System.err.println("getBZip2PipedOutputStream: Closed. ");
  }
}
