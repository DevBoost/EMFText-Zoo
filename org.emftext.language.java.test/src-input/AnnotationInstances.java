public class AnnotationInstances {
	public @interface A {
		B b();
	}
	
	public @interface B {
		
	}

	@A(b = @B)
	public void m() {
		
	}
}
