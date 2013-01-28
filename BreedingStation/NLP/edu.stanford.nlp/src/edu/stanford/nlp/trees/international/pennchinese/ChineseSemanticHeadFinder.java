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

import edu.stanford.nlp.trees.TreebankLanguagePack;


/**
 * Implements a 'semantic head' variant of the the HeadFinder found in Chinese Head Finder
 * 
 *
 * @author Pi-Chuan Chang
 * @author Huihsin Tseng
 */
public class ChineseSemanticHeadFinder extends ChineseHeadFinder {

  public ChineseSemanticHeadFinder() {
    this(new ChineseTreebankLanguagePack());
  }

  public ChineseSemanticHeadFinder(TreebankLanguagePack tlp) {
    super(tlp);
    ruleChanges();
  }

  //makes modifications of head finder rules to better fit with semantic notions of heads
  private void ruleChanges() {
    nonTerminalInfo.remove("VP");
    nonTerminalInfo.put("VP", new String[][]{{"left", "VP", "VCD", "VPT", "VV", "VCP", "VA", "VE", "VC","IP", "VSB", "VCP", "VRD", "VNV"}, leftExceptPunct});

    nonTerminalInfo.remove("CP");
    nonTerminalInfo.put("CP", new String[][]{{"right", "CP", "IP", "VP"}, rightExceptPunct});

    nonTerminalInfo.remove("DNP");
    nonTerminalInfo.put("DNP", new String[][]{{"leftdis", "NP" }});    

    nonTerminalInfo.remove("DVP");
    nonTerminalInfo.put("DVP", new String[][]{{"leftdis", "VP" ,"ADVP"}});

    nonTerminalInfo.remove("LST");
    nonTerminalInfo.put("LST", new String[][]{{"right", "CD", "NP", "QP", "PU"}});
  }

  private static final long serialVersionUID = 2L;

}
