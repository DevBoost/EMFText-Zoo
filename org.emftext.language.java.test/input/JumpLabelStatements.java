public class JumpLabelStatements {
	{
		jumpLabel : ;
	}
	public void labelStatement() {
		jumpLabel : ;
	}
	public void labelInContinue() {
		jumpLabel : for (;;) {
			continue jumpLabel;
		}
	}
	public void labelInBreak() {
		jumpLabel : for (;;) {
			break jumpLabel;
		}
	}
}
