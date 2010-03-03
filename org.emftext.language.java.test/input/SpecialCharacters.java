import java.util.HashMap;
import java.util.Map;

public class SpecialCharacters {

	void m1() {
		char aChar = ' ';
		int x = 0;
		StringBuffer outBuffer = new StringBuffer();
		boolean escapeSpace = true;

		switch (aChar) {

		case ' ':

			if (x == 0 || escapeSpace)

				outBuffer.append('\\');

			outBuffer.append(' ');

			break;

		case '\t':
			outBuffer.append('\\');
			outBuffer.append('t');

			break;

		case '\n':
			outBuffer.append('\\');
			outBuffer.append('n');

			break;

		case '\r':
			outBuffer.append('\\');
			outBuffer.append('r');

			break;

		case '\f':
			outBuffer.append('\\');
			outBuffer.append('f');
			
			break;
		case '\37': //octal format
			break;

		case '=': // Fall through

		case ':': // Fall through

		case '#': // Fall through

		case '!':

			outBuffer.append('\\');
			outBuffer.append(aChar);

			break;

		default:

			if (((aChar < 0x0020) || (aChar > 0x007e))) {

				outBuffer.append('\\');

				outBuffer.append('u');

			} else {

				outBuffer.append(aChar);

			}

		}
	}

	private static Map<String, Character> entities;

	static {

		entities = new HashMap<String, Character>();

		entities.put("&lt;", '<');

		entities.put("&gt;", '>');

		entities.put("&amp;", '&');

		entities.put("&quot;", '"');

		entities.put("&acute;", (char) 180);

		entities.put("&sect;", (char) 167);

		entities.put("&#39;", '\'');

	}

}
