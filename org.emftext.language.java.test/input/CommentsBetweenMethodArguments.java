public class CommentsBetweenMethodArguments {
	public void m(int a, int b, int c) {
		m(1, // some comment
			2 /* another comment */, 3);
	}
}
