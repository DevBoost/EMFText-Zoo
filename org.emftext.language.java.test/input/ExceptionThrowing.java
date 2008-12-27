public class ExceptionThrowing extends Exception {
	
	public class InnerException extends Exception {
	}
	
	public ExceptionThrowing() throws ExceptionThrowing {
	}

	public ExceptionThrowing(ExceptionThrowing dummyParameter) throws ExceptionThrowing, Exception {
	}

	public void methodThatThrows() throws ExceptionThrowing {
	}

	public void methodThatThrowsMultiple() throws ExceptionThrowing, Exception, NullPointerException {
	}

	public void methodThatThrowsInnerException() throws ExceptionThrowing.InnerException {
	}
	
	private static final long serialVersionUID = 1;
}
