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
import java.util.List;

import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.Index;


public abstract class AbstractUnknownWordModelTrainer 
  implements UnknownWordModelTrainer 
{
  double treesRead;
  double totalTrees;

  Index<String> wordIndex, tagIndex;

  Options op;
  Lexicon lex;

  @Override
  public void initializeTraining(Options op, Lexicon lex, 
                                 Index<String> wordIndex, 
                                 Index<String> tagIndex, double totalTrees) {
    this.totalTrees = totalTrees;
    this.treesRead = 0;

    this.wordIndex = wordIndex;
    this.tagIndex = tagIndex;
    this.op = op;
    this.lex = lex;
  }



  public final void train(Collection<Tree> trees) {
    train(trees, 1.0);
  }

  public final void train(Collection<Tree> trees, double weight) {
    for (Tree tree : trees) {
      train(tree, weight);
    }
  }


  public final void train(Tree tree, double weight) {
    incrementTreesRead(weight);
    int loc = 0;
    List<TaggedWord> yield = tree.taggedYield();
    for (TaggedWord tw : yield) {
      train(tw, loc, weight);
      ++loc;
    }
  }

  public void incrementTreesRead(double weight) {
    treesRead += weight;
  }
}
