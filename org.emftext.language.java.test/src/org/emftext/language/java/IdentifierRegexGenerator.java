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
		boolean isFirst = true;
		boolean wasTrue = false;
		int lastChar = 0;
		for (int x = 0; x <= 0xFFFF; x++) {
			if (check.check(x)) {
				if (!wasTrue) {
					if (!isFirst) {
						System.out.print("|");
						isFirst = false;
					}
					System.out.print("'\\u" + format(Integer.toHexString(x)) + "'");
					lastChar = x;
				}
				wasTrue = true;
			} else {
				if (wasTrue) {
					if (x - 1 != lastChar) {
						System.out.print("..'\\u" + format(Integer.toHexString(x - 1)) + "'");
					} else {
						System.out.print("|");
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
