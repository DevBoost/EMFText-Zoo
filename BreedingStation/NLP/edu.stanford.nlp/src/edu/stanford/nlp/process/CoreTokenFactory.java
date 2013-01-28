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

import edu.stanford.nlp.util.CoreMap;

/**
 * To make tokens like CoreMap or CoreLabel. An alternative to LexedTokenFactory
 * since this one has option to make tokens differently, which would have been
 * an overhead for LexedTokenFactory
 * 
 * @author Sonal Gupta
 * 
 * @param <IN>
 */
public interface CoreTokenFactory<IN extends CoreMap> {
  public IN makeToken();

  public IN makeToken(String[] keys, String[] values);

  public IN makeToken(IN tokenToBeCopied);

}
