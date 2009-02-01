public class AnnotationsForMethods {

	public @interface A {
	}
	
	public @interface B {
		public @A A m();
	}
	
	public @A AnnotationsForMethods() {
	}
	
	@A
	public void m1() {
	}

	public @A void m2() {
	}

	public @A <T> void m3() {
	}
}
