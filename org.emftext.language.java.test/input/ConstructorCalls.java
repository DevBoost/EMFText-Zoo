public class ConstructorCalls {
	
	public static class Inner {
		public Inner() {
		}

		public Inner(Inner i) {
			this();
		}
	}
	
	public ConstructorCalls() {
	}

	public ConstructorCalls(ConstructorCalls constructorCalls) {
	}

	public void method() {
		ConstructorCalls cc = new ConstructorCalls(new ConstructorCalls());
		cc.method();
	}
}
