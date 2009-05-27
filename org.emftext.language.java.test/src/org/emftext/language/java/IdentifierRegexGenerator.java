/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.language.java;

public class IdentifierRegexGenerator {
	
	public interface Check {
		public boolean check(int x);
	}

	public static void main(String[] args) {
		System.out.print("$(");
		iterate(new Check() {
			public boolean check(int x) {
				return Character.isJavaIdentifierStart(x);
			}
		});
		System.out.print(")(");
		iterate(new Check() {
			public boolean check(int x) {
				return Character.isJavaIdentifierPart(x);
			}
		});
		System.out.print(")*$;");
	}

	private static void iterate(Check check) {
		boolean needsOption = false;
		boolean wasTrue = false;
		int lastChar = 0;
		for (int x = 0; x <= 0xFFFF; x++) {
			if (check.check(x)) {
				if (!wasTrue) {
					if (needsOption) {
						System.out.print("|");
					}
					System.out.print("'\\u" + format(Integer.toHexString(x)) + "'");
					lastChar = x;
				}
				wasTrue = true;
			} else {
				if (wasTrue) {
					needsOption = true;
					if (x - 1 != lastChar) {
						System.out.print("..'\\u" + format(Integer.toHexString(x - 1)) + "'");
					}
				}
				wasTrue = false;
			}
		}
	}

	private static String format(String hexString) {
		int length = hexString.length();
		int missingLeft = 4 -length;
		for (int i = 0; i < missingLeft; i++) {
			hexString = "0" + hexString;
		}
		return hexString;
	}
}
