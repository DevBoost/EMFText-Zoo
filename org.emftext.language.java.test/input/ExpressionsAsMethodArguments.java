public class ExpressionsAsMethodArguments {
	public void method1(int p1, int p2) {
		
	}
	
	public void method2(String s1) {
		
	}
	
	public void callee() {
		int i = 0;
		method1(i, i + 2);
		method1(3, 1 - 2);
		method2(3 + "1");
		i = i + 2;
	}
}
