public class ExplicitGenericInvocation {

	public static class A<T> {
		public <U> A() {
			
		}

		public static <R> void m() {}
	}

	public class B<S> extends A<S> {
		public B() {
			super.<S>m();
		}
	}
}
