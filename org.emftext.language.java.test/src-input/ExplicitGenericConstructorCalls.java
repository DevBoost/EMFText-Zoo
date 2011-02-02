public class ExplicitGenericConstructorCalls {
	public <T> ExplicitGenericConstructorCalls() {
		<ExplicitGenericConstructorCalls, ExplicitGenericConstructorCalls>this(null);
	}

	public <T1, T2> ExplicitGenericConstructorCalls(ExplicitGenericConstructorCalls dummyParameter) {
	}

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
}
