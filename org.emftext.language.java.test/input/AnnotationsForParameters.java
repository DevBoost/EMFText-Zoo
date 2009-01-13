public class AnnotationsForParameters {

	public @interface A {
		String value();
	}
	@A("a") public int i = 1;
	
	@A("a") public void m(@A("something") int x) {
		@A("a") 
		AnnotationsForParameters a = new AnnotationsForParameters();
	}
}
