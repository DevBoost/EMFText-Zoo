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

import java.util.prefs.AbstractPreferences;
import java.util.prefs.BackingStoreException;

/**
 * A do-nothing Preferences implementation so that we can avoid the hassles
 * of the JVM Preference implementations.
 * Taken from: http://www.allaboutbalance.com/disableprefs/index.html
 *
 * @author Robert Slifka
 * @version 2003/03/24
 */
public class DisabledPreferences extends AbstractPreferences {

  public DisabledPreferences() {
    super(null, "");
  }

  @Override
  protected void putSpi(String key, String value) {

  }

  @Override
  protected String getSpi(String key) {
    return null;
  }

  @Override
  protected void removeSpi(String key) {

  }

  @Override
  protected void removeNodeSpi() throws BackingStoreException {

  }

  @Override
  protected String[] keysSpi() throws BackingStoreException {
    return new String[0];
  }

  @Override
  protected String[] childrenNamesSpi() throws BackingStoreException {
    return new String[0];
  }

  @Override
  protected AbstractPreferences childSpi(String name) {
    return null;
  }

  @Override
  protected void syncSpi() throws BackingStoreException {

  }

  @Override
  protected void flushSpi() throws BackingStoreException {

  }
}
