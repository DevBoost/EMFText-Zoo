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
package edu.stanford.nlp.util.logging;

/**
 * ANSI supported styles (rather, a subset of)
 * These values are mirrored in Redwood.Util
 * @author Gabor Angeli (angeli at cs.stanford)
 */
public enum Style {
  NONE(""), BOLD("\033[1m"), DIM("\033[2m"), ITALIC("\033[3m"), UNDERLINE("\033[4m"), BLINK("\033[5m"), CROSS_OUT("\033[9m");
  public final String ansiCode;
  private Style(String ansiCode){
    this.ansiCode = ansiCode;
  }
}
