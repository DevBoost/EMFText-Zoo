public class AnnotationsForParameters {

	public @interface A {
		String value();
	}
	
	public void m(@A("something") int x) {
		
	}
}
