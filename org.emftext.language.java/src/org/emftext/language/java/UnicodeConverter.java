package org.emftext.language.java;

import java.io.IOException;
import java.io.InputStream;

import org.emftext.runtime.InputStreamProcessor;

/**
 * A UnicodeConverter can read an input stream and convert
 * unicode escape sequences (backslash + uXXXX) to actual
 * unicode characters. Each escaped unicode sequence (6 bytes)
 * is replaced by the respective unicode character (2 bytes).
 * 
 * TODO mseifert: information about replaced sequences must be 
 * passed to the LocationMap or parser to make sure that the 
 * positions of elements found in the stream are correct.
 */
public class UnicodeConverter extends InputStreamProcessor {

	private static final char BACKSLASH = '\\';

	private InputStream inputStream;
	private int[] stack;
	private int stackPosition;

	public UnicodeConverter(InputStream inputStream) {
		this.inputStream = inputStream;
		this.stack = new int[4];
		this.stackPosition = 0;
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
		if (!isEmpty()) {
			int result = pop();
			return result;
		}
		int read = inputStream.read();

		// Must have format \\uXXXX where XXXX is a hex number
		if (read >= 0) {
			char c = (char) read;

			if (c == BACKSLASH) {
				int next = inputStream.read();
				char nextChar = (char) next;
				if (nextChar == 'u') {
					// Now we found the 'u' we need to find another 4 hex digits
					// Note: shifting left by 4 is the same as multiplying by 16
					int v = 0; // Accumulator
					boolean complete = true;
					int j = 0;
					while (j < 4) {
						next = inputStream.read();
						nextChar = (char) next;
						if (nextChar == 'u') {
							// ignore more u characters
							continue;
						}
						j++;
						push(next);
						if (next < 0) {
							complete = false;
							break;
						}
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
							v = 0; // clear the accumulator
							break;
						}
					} // for each of the 4 digits

					if (complete) { // We got a full conversion
						pop();
						pop();
						pop();
						pop();
						return v;
					}
				} else {
					push(next);
				}
			}
		}
		return read;
	}
	
	public static int unsignedByteToInt(byte b) {
		return (int) b & 0xFF;
	}
	  
	private boolean isEmpty() {
		return stackPosition == 0;
	}
	
	private int pop() {
		stackPosition--;
		return stack[stackPosition];
	}
	
	private void push(int c) {
		stack[stackPosition] = c;
		stackPosition++;
	}
}
