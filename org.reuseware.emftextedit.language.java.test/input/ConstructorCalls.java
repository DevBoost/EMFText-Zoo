public class ConstructorCalls {
	
	public class Generic<T> {
		public <S> Generic() {
		}
		
		public Generic(ConstructorCalls cc) {
			<ConstructorCalls> this();
		}
	}
	
	public class SubGeneric extends Generic<ConstructorCalls> {
		public SubGeneric() {
			<ConstructorCalls> super();
		}
	}
	
	public static class Inner {
		public Inner() {
		}

		public Inner(Inner i) {
			this();
		}
	}
	
	public ConstructorCalls() {
		super();
	}

	public ConstructorCalls(ConstructorCalls p1) {
		this();
	}

	public ConstructorCalls(ConstructorCalls p1, ConstructorCalls p2) {
		this(p1);
	}
	
	public void method() {
		ConstructorCalls cc = new ConstructorCalls(new ConstructorCalls());
	}
}
