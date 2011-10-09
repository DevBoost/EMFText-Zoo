public class EnumValueMethodsUse {

	public static enum T {
		A
	}
	
	public void m() {
		T.values();
		T.valueOf("A");
		T.valueOf(T.class, "A");
	}
}
