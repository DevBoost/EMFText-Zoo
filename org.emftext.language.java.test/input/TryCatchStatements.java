public class TryCatchStatements extends RuntimeException {

	private static final long serialVersionUID = 1;

	{
		try {
			
		} catch (TryCatchStatements re) {
		}
	}
	public void tryStatements() {
		try {
			
		} catch (TryCatchStatements re) {
			return;
		}
	}
	
	public void tryModifiers() {
		try {
			
		} catch (final TryCatchStatements re) {
			return;
		}
	}
}
