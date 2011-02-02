public class SynchronizedStatements {
	{
		synchronized (new Object()) {
		}
	}
	
	public void synchronizedStatement() {
		synchronized (new Object()) {
		}
	}

	public void multiple() {
		synchronized (new Object()) {
		}
		synchronized (new Object()) {
		};
		synchronized (new Object()) {
		}
	}
}
