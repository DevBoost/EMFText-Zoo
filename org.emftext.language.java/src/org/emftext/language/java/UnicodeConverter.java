package org.emftext.language.java;

import java.io.IOException;
import java.io.InputStream;

import org.emftext.runtime.InputStreamProcessor;

public class UnicodeConverter extends InputStreamProcessor {

	private static final char BACKSLASH = '\\';

	private InputStream inputStream;

	public UnicodeConverter(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	/**
	 * Given the input string with escaped unicode characters convert them to
	 * their native unicode characters and return the result. This is quite
	 * similar to the functionality found in property file handling. White space
	 * escapes are not processed (as they are consumed by the template library).
	 * Any bogus escape codes will remain in place.
	 * <p>
	 * When files are provided in another encoding, they can be converted to
	 * ascii using the native2ascii tool (a java sdk binary). This tool will
	 * escape all the non Latin1 ASCII characters and convert the file into
	 * Latin1 with unicode escapes.
	 * 
	 * This code is from http://www.antlr.org/wiki/display/ST/unicode_escapes
	 * but was modified and extended to support other escaped characters.
	 * 
	 * @param source
	 *            string with unicode escapes
	 * @return string with all unicode characters, all unicode escapes expanded.
	 * 
	 * @author Caleb Lyness (modified by Mirko Seifert)
	 */
	@Override
	public int read() throws IOException {
		int read = inputStream.read();

		// Must have format \\uXXXX where XXXX is a hexadecimal number
		if (read >= 0) {

			char c = (char) read;

			if (c == BACKSLASH) {
				int next = inputStream.read();
				char nextChar = (char) next;
				switch (nextChar) {
				case 'u': {
					// Now we found the 'u' we need to find another 4 hex digits
					// Note: shifting left by 4 is the same as multiplying by 16
					int v = 0; // Accumulator
					for (int j = 1; j < 5; j++) {
						next = inputStream.read();
						nextChar = (char) next;
						switch (nextChar) {
						case 48: // '0'
						case 49: // '1'
						case 50: // '2'
						case 51: // '3'
						case 52: // '4'
						case 53: // '5'
						case 54: // '6'
						case 55: // '7'
						case 56: // '8'
						case 57: // '9'
							v = ((v << 4) + nextChar) - 48;
							break;

						case 97: // 'a'
						case 98: // 'b'
						case 99: // 'c'
						case 100: // 'd'
						case 101: // 'e'
						case 102: // 'f'
							v = ((v << 4) + 10 + nextChar) - 97;
							break;

						case 65: // 'A'
						case 66: // 'B'
						case 67: // 'C'
						case 68: // 'D'
						case 69: // 'E'
						case 70: // 'F'
							v = ((v << 4) + 10 + nextChar) - 65;
							break;
						default:
							// almost but no go
							j = 6; // terminate the loop
							v = 0; // clear the accumulator
							break;
						}
					} // for each of the 4 digits

					if (v > 0) { // We got a full conversion
						return v;
					}
					break;
				}
				}
			}
		}
		return read;
	}
}
