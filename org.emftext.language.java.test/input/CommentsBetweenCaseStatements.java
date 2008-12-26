public class CommentsBetweenCaseStatements {
	final int STOP = 0;
	final int RETURN = 1;
	
	public void m() {
		int result = 2;
		switch (result) {
			case STOP :
				return;// comment between case statements
			case RETURN :
				return;
		}
	}
}
