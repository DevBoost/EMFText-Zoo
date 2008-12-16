public class ExpressionsAsMethodArguments {
	public void method(int p1, int p2) {
		
	}
	
	public void callee() {
		int i = 0;
		method(i, i + 2);
		method(3, 1 - 2);
		i = i + 2;
	}
}
