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
package edu.stanford.nlp.trees.international.negra;

import java.io.*;

import edu.stanford.nlp.trees.LabeledScoredTreeFactory;
import edu.stanford.nlp.trees.PennTreeReader;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeReader;
import edu.stanford.nlp.trees.TreeReaderFactory;
import edu.stanford.nlp.trees.TreebankLanguagePack;

/** A TreeReaderFactory for the Negra and Tiger treebanks in their
 *  Penn Treebank compatible export format.
 *
 *  @author Roger Levy
 */
public class NegraPennTreeReaderFactory implements TreeReaderFactory, Serializable {

  private static final long serialVersionUID = 5731352106152470304L;

  private final int nodeCleanup; // = 0;
  private final TreebankLanguagePack tlp;
  private final boolean treeNormalizerInsertNPinPP; // = false;


  public NegraPennTreeReaderFactory(TreebankLanguagePack tlp) {
    this(0, false, false, tlp);
  }

  public NegraPennTreeReaderFactory(int nodeCleanup, boolean treeNormalizerInsertNPinPP,
                                    boolean treeNormalizerLeaveGF, TreebankLanguagePack tlp) {
    this.nodeCleanup = nodeCleanup;
    this.treeNormalizerInsertNPinPP = treeNormalizerInsertNPinPP;
    this.tlp = tlp;
  }

  public TreeReader newTreeReader(Reader in) {
    final NegraPennTreeNormalizer tn = new NegraPennTreeNormalizer(tlp, nodeCleanup);
    if (treeNormalizerInsertNPinPP)
      tn.setInsertNPinPP(true);

    return new PennTreeReader(in, new LabeledScoredTreeFactory(), tn, new NegraPennTokenizer(in));
  }
  
  /**
   * 
   * @param args
   */
  public static void main(String[] args) {
    if(args.length < 1) {
      System.out.printf("Usage: java %s tree_file\n", NegraPennTreeReaderFactory.class.getName());
      System.exit(-1);
    }
    
    TreebankLanguagePack tlp = new NegraPennLanguagePack();
    TreeReaderFactory trf = new NegraPennTreeReaderFactory(2,false,false,tlp);
    
    try {
      TreeReader tr = trf.newTreeReader(new InputStreamReader(new BufferedInputStream(new FileInputStream(new File(args[0]))),tlp.getEncoding()));
      
      Tree t;
      while((t = tr.readTree()) != null)
        t.pennPrint();
      
      tr.close();
    
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
