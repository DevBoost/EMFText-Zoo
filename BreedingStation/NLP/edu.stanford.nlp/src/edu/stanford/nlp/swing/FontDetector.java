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
package edu.stanford.nlp.swing;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Detects which Fonts can be used to display unicode characters in a given language.
 *
 * @author Huy Nguyen (htnguyen@cs.stanford.edu)
 * @author Christopher Manning
 */
public class FontDetector {

  public static final int NUM_LANGUAGES = 2;
  public static final int CHINESE = 0;
  public static final int ARABIC = 1;


  public static final String[][] unicodeRanges = new String[NUM_LANGUAGES][];

  static {
    unicodeRanges[CHINESE] = new String[]{"\u3001", "\uFF01", "\uFFEE", "\u0374", "\u3126"};
    // The U+FB50-U+FDFF range is Arabic Presentation forms A.
    // The U+FE70=U+FEFE range is Araic presentation forms B. We probably won't need them.
    unicodeRanges[ARABIC] = new String[]{"\uFB50", "\uFE70"};
  }


  private FontDetector() {}


  /**
   * Returns which Fonts on the system can display the sample string.
   *
   * @param language the numerical code for the language to check
   * @return a list of Fonts which can display the sample String
   */
  public static List<Font> supportedFonts(int language) {
    if (language < 0 || language > NUM_LANGUAGES) {
      throw new IllegalArgumentException();
    }

    List<Font> fonts = new ArrayList<Font>();
    Font[] systemFonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
    for (Font systemFont : systemFonts) {
      boolean canDisplay = true;
      for (int j = 0; j < unicodeRanges[language].length; j++) {
        if (systemFont.canDisplayUpTo(unicodeRanges[language][j]) != -1) {
          canDisplay = false;
          break;
        }
      }
      if (canDisplay) {
        fonts.add(systemFont);
      }
    }
    return fonts;
  }

  public static boolean hasFont(String fontName) {
    Font[] systemFonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
    for (Font systemFont : systemFonts) {
      if (systemFont.getName().equalsIgnoreCase(fontName)) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    List<Font> fonts = supportedFonts(ARABIC);
    System.err.println("Has MS Mincho? " + hasFont("MS Mincho"));
    for (Font font : fonts) {
      System.out.println(font.getName());
    }
  }

}
