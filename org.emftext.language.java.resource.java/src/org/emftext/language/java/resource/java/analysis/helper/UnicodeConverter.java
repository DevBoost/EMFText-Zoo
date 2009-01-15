package org.emftext.language.java.resource.java.analysis.helper;

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

	// we use -2 instead of -1, because -1 is EOF
	private static final int EMPTY_LOOK_AHEAD_CHARACTER = -2;

	private static final char BACKSLASH = '\\';

	/**
	 * The original input stream.
	 */
	private InputStream inputStream;
	
	/**
	 * Holds the character that is read from the original
	 * stream if a backslash is found. This character is 
	 * returned upon the next call to read().
	 */
	private int lookAheadCharacter;

	/**
	 * Creates a new UnicodeConverter that reads from the given
	 * stream.
	 * 
	 * @param inputStream the original stream to read from
	 */
	public UnicodeConverter(InputStream inputStream) {
		this.inputStream = inputStream;
		this.lookAheadCharacter = EMPTY_LOOK_AHEAD_CHARACTER;
	}

	/**
	 * Reads one character from the stream. Escaped unicode characters are
	 * converted to real characters (i.e., one integer value).
	 */
	@Override
	public int read() throws IOException {
		if (lookAheadCharacter >= 0) {
			int result = lookAheadCharacter;
			lookAheadCharacter = EMPTY_LOOK_AHEAD_CHARACTER;
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
							// this case can never happen if the unicode
							// escape sequences are correct
							v = 0; // clear the accumulator
							break;
						}
					} // for each of the 4 digits

					if (complete) { // We got a full conversion
						return v;
					}
				} else {
					lookAheadCharacter = next;
				}
			}
		}
		return read;
	}
	
	public static int unsignedByteToInt(byte b) {
		return (int) b & 0xFF;
	}
}
