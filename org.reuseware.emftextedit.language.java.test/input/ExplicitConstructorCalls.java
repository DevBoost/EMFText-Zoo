public class ExplicitConstructorCalls {

	public ExplicitConstructorCalls() {
		super();
	}

	public ExplicitConstructorCalls(ExplicitConstructorCalls p1) {
		this();
	}

	public ExplicitConstructorCalls(ExplicitConstructorCalls p1, ExplicitConstructorCalls p2) {
		this(p1);
	}
}
