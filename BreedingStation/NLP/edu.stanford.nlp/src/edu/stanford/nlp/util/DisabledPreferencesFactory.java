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
package edu.stanford.nlp.util;

import java.util.prefs.Preferences;
import java.util.prefs.PreferencesFactory;

/**
 * Returns do-nothing Preferences implementation.  We don't use this
 * facility, so we want to avoid the hassles that come with the JVM's
 * implementation.
 * Taken from: http://www.allaboutbalance.com/disableprefs/index.html
 *
 * @author Robert Slifka
 * @author Christopher Manning
 * @version 2003/03/24
 */
public class DisabledPreferencesFactory implements PreferencesFactory {

  public Preferences systemRoot() {
    return new DisabledPreferences();
  }

  public Preferences userRoot() {
    return new DisabledPreferences();
  }

  public static void install() {
    try {
      System.setProperty("java.util.prefs.PreferencesFactory", "edu.stanford.nlp.util.DisabledPreferencesFactory");
    } catch (SecurityException e) {
      // oh well we couldn't do it...
    }
  }

}
