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
package edu.stanford.nlp.parser.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.net.Socket;

import edu.stanford.nlp.trees.Tree;

/**
 * The sister class to LexicalizedParserServer.  This class connects
 * to the given host and port.  It can then either return a Tree or a
 * string with the output of the Tree, depending on the method called.
 * getParse gets the string output, getTree returns a Tree.
 */
public class LexicalizedParserClient {
  final String host;
  final int port;
  
  public LexicalizedParserClient(String host, int port) 
    throws IOException
  {
    this.host = host;
    this.port = port; 
  }

  /**
   * Returns the String output of the parse of the given query.
   * <br>
   * The "parse" method in the server is mostly useful for clients
   * using a language other than Java who don't want to import or wrap
   * Tree in any way.  However, it is useful to provide getParse to
   * test that functionality in the server.
   */
  public String getParse(String query)
    throws IOException
  {
    Socket socket = new Socket(host, port);

    Writer out = new OutputStreamWriter(socket.getOutputStream(), "utf-8");
    out.write("parse " + query + "\n");
    out.flush();

    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
    StringBuilder result = new StringBuilder();
    String line;
    while ((line = reader.readLine()) != null) {
      result.append(line);
    }

    socket.close();
    return result.toString();
  }

  /**
   * Returs a Tree from the server connected to at host:port.
   */
  public Tree getTree(String query) 
    throws IOException
  {
    Socket socket = new Socket(host, port);

    Writer out = new OutputStreamWriter(socket.getOutputStream(), "utf-8");
    out.write("tree " + query + "\n");
    out.flush();

    ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
    Object o;
    try {
      o = ois.readObject();
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
    if (!(o instanceof Tree)) {
      throw new IllegalArgumentException("Expected a tree");
    }
    Tree tree = (Tree) o;

    socket.close();
    return tree;
  }

  /**
   * Tell the server to exit
   */
  public void sendQuit() 
    throws IOException
  {
    Socket socket = new Socket(host, port);
    
    Writer out = new OutputStreamWriter(socket.getOutputStream(), "utf-8");
    out.write("quit\n");
    out.flush();    

    socket.close();
  }

  public static void main(String[] args) 
    throws IOException
  {
    System.setOut(new PrintStream(System.out, true, "utf-8"));
    System.setErr(new PrintStream(System.err, true, "utf-8"));

    LexicalizedParserClient client = 
      new LexicalizedParserClient("localhost", 
                                  LexicalizedParserServer.DEFAULT_PORT);
    String query = "John Bauer works at Stanford.";
    System.out.println(query);
    Tree tree = client.getTree(query);
    System.out.println(tree);
    String results = client.getParse(query);
    System.out.println(results);
  }
}
