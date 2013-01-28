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

import java.util.Collection;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.Index;

/**
 * An interface for training an UnknownWordModel.  Once initialized,
 * you can feed it trees and then call finishTraining to get the
 * UnknownWordModel.
 *
 * @author John Bauer
 */
public interface UnknownWordModelTrainer {

  /**
   * Initialize the trainer with a few of the data structures it needs
   * to train.  Also, it is necessary to estimate the number of trees
   * that it will be given, as many of the UWMs switch training modes
   * after seeing a fraction of the trees.
   * <br>
   * This is an initialization method and not part of the constructor
   * because these Trainers are generally loaded by reflection, and
   * making this a method instead of a constructor lets the compiler
   * catch silly errors.
   */
  public void initializeTraining(Options op, Lexicon lex, 
                                 Index<String> wordIndex, 
                                 Index<String> tagIndex, double totalTrees);

  /**
   * Tallies statistics for this particular collection of trees.  Can
   * be called multiple times.
   */
  public void train(Collection<Tree> trees);

  /**
   * Tallies statistics for a weighted collection of trees.  Can
   * be called multiple times.
   */
  public void train(Collection<Tree> trees, double weight);

  /**
   * Tallies statistics for a single tree.  
   * Can be called multiple times.
   */
  public void train(Tree tree, double weight);

  /**
   * Tallies statistics for a single word.  
   * Can be called multiple times.
   */
  public void train(TaggedWord tw, int loc, double weight);

  public void incrementTreesRead(double weight);

  /**
   * Returns the trained UWM.  Many of the subclasses build exactly
   * one model, and some of the finishTraining methods manipulate the
   * data in permanent ways, so this should only be called once
   */
  public UnknownWordModel finishTraining();


  static public final String unknown = "UNK";

  static public final int nullWord = -1;
  static public final short nullTag = -1;

  static public final IntTaggedWord NULL_ITW = 
    new IntTaggedWord(nullWord, nullTag);

}
