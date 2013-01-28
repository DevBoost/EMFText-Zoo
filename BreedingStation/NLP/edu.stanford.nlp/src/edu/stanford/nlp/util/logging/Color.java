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
 * ANSI supported colors
 * These values are mirrored in Redwood.Util
 * @author Gabor Angeli (angeli at cs.stanford)
 */
public enum Color {
  //note: NONE BLACK and WHITE must be first three (for random colors in OutputHandler to work)
  NONE(""), BLACK("\033[30m"), WHITE("\033[37m"), RED("\033[31m"), GREEN("\033[32m"), YELLOW("\033[33m"), BLUE("\033[34m"), MAGENTA("\033[35m"), CYAN("\033[36m");
  public final String ansiCode;
  private Color(String ansiCode){
    this.ansiCode = ansiCode;
  }
}
