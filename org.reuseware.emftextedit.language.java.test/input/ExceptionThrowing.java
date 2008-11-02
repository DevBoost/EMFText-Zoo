public class ExceptionThrowing extends Exception {
	
	public ExceptionThrowing() throws ExceptionThrowing {
	}

	public ExceptionThrowing(ExceptionThrowing dummyParameter) throws ExceptionThrowing, Exception {
	}

	public void methodThatThrows() throws ExceptionThrowing {
	}

	public void methodThatThrowsMultiple() throws ExceptionThrowing, Exception {
	}

	private static final long serialVersionUID = 1;
}
