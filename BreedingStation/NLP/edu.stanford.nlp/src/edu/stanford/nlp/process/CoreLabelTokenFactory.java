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
package edu.stanford.nlp.process;

import java.io.Serializable;

import edu.stanford.nlp.ling.CoreAnnotations.CharacterOffsetBeginAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.CharacterOffsetEndAnnotation;
import edu.stanford.nlp.ling.CoreLabel;

/**
 * Constructs {@link CoreLabel}s from Strings optionally with
 * beginning and ending (character after the end) offset positions in
 * an original text.  The makeToken method will put the token in the
 * OriginalTextAnnotation AND TextAnnotation keys (2 places!),
 * and optionally records
 * begin and position after offsets in BeginPositionAnnotation and
 * EndPositionAnnotation.  If the tokens are built in PTBTokenizer with
 * an "invertible" tokenizer, you will also get a BeforeAnnotation and for
 * the last token an AfterAnnotation.You can also get an empty CoreLabel token
 *
 * @author Anna Rafferty
 * @author Sonal Gupta (now implements CoreTokenFactory, you can make tokens using many options)
 */
public class CoreLabelTokenFactory implements CoreTokenFactory<CoreLabel>, LexedTokenFactory<CoreLabel>, Serializable {

  final boolean addIndices;

  /**
   * Constructor for a new token factory which will add in the word, the
   * "current" annotation, and the begin/end position annotations.
   */
  public CoreLabelTokenFactory() {
    this(true);
  }

  /**
   * Constructor that allows one to choose if index annotation
   * indicating begin/end position will be included in the label.
   *
   * @param addIndices if true, begin and end position annotations will be included (this is the default)
   */
  public CoreLabelTokenFactory(boolean addIndices) {
    super();
    this.addIndices = addIndices;
  }

  /**
   * Constructs a CoreLabel as a String with a corresponding BEGIN and END position.
   * (Does not take substring).
   */
  public CoreLabel makeToken(String tokenText, int begin, int length) {
    return makeToken(tokenText, tokenText, begin, length);
  }

  /**
   * Constructs a CoreLabel as a String with a corresponding BEGIN and END position, 
   * when the original OriginalTextAnnotation is different from TextAnnotation
   * (Does not take substring).
   */
  public CoreLabel makeToken(String tokenText, String originalText, int begin, int length) {
    CoreLabel cl = addIndices ? new CoreLabel(5) : new CoreLabel();
    cl.setValue(tokenText);
    cl.setWord(tokenText);
    cl.setOriginalText(originalText);
    if(addIndices) {
      cl.set(CharacterOffsetBeginAnnotation.class, begin);
      cl.set(CharacterOffsetEndAnnotation.class, begin+length);
    }
    return cl;
  }

  public CoreLabel makeToken() {
    CoreLabel l = new CoreLabel();
    return l;
  }

  public CoreLabel makeToken(String[] keys, String[] values) {
    CoreLabel l = new CoreLabel(keys, values);
    return l;
  }

  public CoreLabel makeToken(CoreLabel labelToBeCopied) {
    CoreLabel l = new CoreLabel(labelToBeCopied);
    return l;
  }

  private static final long serialVersionUID = 4L;
}
