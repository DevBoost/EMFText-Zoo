public class AnnotationsForParameters {

	public @interface A {
		String value();
	}
	@A("a") public int i = 1;
	
	@A("a") public void m(@A("something") int x) {
		@A("a") 
		AnnotationsForParameters a = new AnnotationsForParameters();
	}
	
	public void m2(final @A("foo") int x) {
		
	}

	public void m3(final @A("foo") int... x) {
		
	}

	public void m4() {
		final @A("foo") int x;
	}
	
	public @A("foo") int x;
	
	public @A("foo") class Inner1 {
	};

	public @A("foo") interface Inner2 {
	};

	public @A("foo") enum Inner3 {
	};

	public @A("foo") @interface Inner4 {
	};

}
