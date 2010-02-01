/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.pl0.resource.pl0.mopp;

public class Pl0TokenStyleInformationProvider {
	
	public class TokenStyleImpl implements org.emftext.language.pl0.resource.pl0.IPl0TokenStyle {
		
		private int[] color;
		private boolean bold;
		private boolean italic;
		private boolean strikethrough;
		private boolean underline;
		
		public TokenStyleImpl(int[] color, boolean bold, boolean italic, boolean striketrough, boolean underline) {
			super();
			this.color = color;
			this.bold = bold;
			this.italic = italic;
			this.strikethrough = striketrough;
			this.underline = underline;
		}
		
		public int[] getColorAsRGB() {
			return color;
		}
		
		public boolean isBold() {
			return bold;
		}
		
		public boolean isItalic() {
			return italic;
		}
		
		public boolean isStrikethrough() {
			return strikethrough;
		}
		
		public boolean isUnderline() {
			return underline;
		}
	}
	
	public org.emftext.language.pl0.resource.pl0.IPl0TokenStyle getDefaultTokenStyle(java.lang.String tokenName) {
		if ("SL_COMMENT".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x3a, 0x73, 0x2e}, false, false, false, false);
		}
		if ("ML_COMMENT".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x3a, 0x73, 0x2e}, false, false, false, false);
		}
		if ("QUOTED_34_34".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0xFF, 0x00, 0x00}, true, false, false, false);
		}
		if ("PL0ID".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x00, 0x00, 0xFF}, false, false, false, false);
		}
		if ("NUMBER".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x00, 0xFF, 0x00}, false, true, false, false);
		}
		if ("program".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x7F, 0x00, 0x85}, true, false, false, false);
		}
		if ("const".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x7F, 0x00, 0x85}, true, false, false, false);
		}
		if ("var".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x7F, 0x00, 0x85}, true, false, false, false);
		}
		if ("odd".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x7F, 0x00, 0x85}, true, false, false, false);
		}
		if ("begin".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x7F, 0x00, 0x85}, true, false, false, false);
		}
		if ("end".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x7F, 0x00, 0x85}, true, false, false, false);
		}
		if ("while".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x7F, 0x00, 0x85}, true, false, false, false);
		}
		if ("do".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x7F, 0x00, 0x85}, true, false, false, false);
		}
		if ("then".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x7F, 0x00, 0x85}, true, false, false, false);
		}
		if ("else".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x7F, 0x00, 0x85}, true, false, false, false);
		}
		if (":=".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x00, 0x00, 0x00}, true, false, false, false);
		}
		if ("PROGRAM".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x80, 0x00, 0x55}, true, false, false, false);
		}
		if ("CONST".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x80, 0x00, 0x55}, true, false, false, false);
		}
		if ("VAR".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x80, 0x00, 0x55}, true, false, false, false);
		}
		if ("procedure".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x80, 0x00, 0x55}, true, false, false, false);
		}
		if ("PROCEDURE".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x80, 0x00, 0x55}, true, false, false, false);
		}
		if ("BEGIN".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x80, 0x00, 0x55}, true, false, false, false);
		}
		if ("END".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x80, 0x00, 0x55}, true, false, false, false);
		}
		if ("call".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x80, 0x00, 0x55}, true, false, false, false);
		}
		if ("CALL".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x80, 0x00, 0x55}, true, false, false, false);
		}
		if ("WHILE".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x80, 0x00, 0x55}, true, false, false, false);
		}
		if ("DO".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x80, 0x00, 0x55}, true, false, false, false);
		}
		if ("if".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x80, 0x00, 0x55}, true, false, false, false);
		}
		if ("IF".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x80, 0x00, 0x55}, true, false, false, false);
		}
		if ("THEN".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x80, 0x00, 0x55}, true, false, false, false);
		}
		if ("ELSE".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x80, 0x00, 0x55}, true, false, false, false);
		}
		if ("ODD".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x80, 0x00, 0x55}, true, false, false, false);
		}
		return null;
	}
	
}
