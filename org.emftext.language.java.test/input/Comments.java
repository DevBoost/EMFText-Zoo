/**
 * A multi-line javadoc comment.
 */
/*
 * A multi-line class comment.
 */
public class Comments {
	/** A single-line javadoc comment. */
	/* A single-line method comment. */
	// A real single line comment.
	public void method1() {
		// another comment inside a method
	}

	/*****
	 * A comment with lots of stars.
	 *****/
	public void method2() {
		/* comment */
		// single before declaration
		Comments declaration = new Comments();
		Comments assignment;
		// single after declaration and before assignment
		assignment = new Comments();
	}
}
