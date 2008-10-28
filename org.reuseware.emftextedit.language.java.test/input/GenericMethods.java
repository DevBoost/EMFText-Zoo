public class GenericMethods {
	public static <T> void methodWithOneTypeParameter() {
	}

	public static <T extends GenericMethods> void methodWithExtendsTypeParameter() {
	}

	public static <T1, T2> void methodWithTwoTypeParameters() {
	}

	public static <T1 extends GenericMethods, T2 extends T1> void methodWithTwoBoundedTypeParameter() {
	}

	public static <T1, T2, T3> void methodWithThreeTypeParameters() {
	}
}
