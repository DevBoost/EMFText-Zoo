package pkg;
public class EscapedStrings {
	public static String unicode = "\u0001\uFfFf";
	public static String notUnicode = "\\u0000\\uFfFf";
	public static String octal1 = "\0\07\007\0007";
	public static String octal2 = "\377\388";
	public static String escapes1 = "\b\n\t\r\n\\";
	public static String escapes2 = "\"'\'";
}
