public class AnnotationsBetweenKeywords {
	public @interface A {
	}
	
	// field
	public @A final int x = 0;
	
	// method
	public @A static void m() {
	}

	// constructors are not possible, because they can only use on keyword at most
	
	// inner class
	public @A static class InnerClass {
	}

	// enumeration
	public @A static enum InnerEnum {
	}

	// interfacer
	public @A static interface InnerInterface {
	}

	// annotation
	public @A static @interface InnerAnnotation {
	}
}
