public class TempLiterals {
	public static long long1 = -2147483648;
	public static float float8 = 0x1.fP+1f;
	public static float float11 = 0x1.fP+1F;
	public static double double8 = 0x1.fP+1D;
	public static double double11 = 0x1.fP+1D;
	public static float float13 = 0xA34P-9f;

	public static void main(String[] a) {
		System.out.println("TempLiterals.main() " + long1);
		System.out.println("TempLiterals.main() " + Integer.MAX_VALUE);
	}
}
