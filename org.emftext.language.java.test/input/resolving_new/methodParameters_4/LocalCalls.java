package resolving_new.methodParameters_4;

public class LocalCalls {

	public void m // target:1
	() {}
	
	public void m // target:2
	(int a) {}
	
	public void m // target:3
	(int a, int b) {}
	
	public void m // target:4
	(Object a) {}
	
	public void call() {
		// source:1:target
		m();

		// source:2:target
		m(1);
		
		// source:3:target
		m(1, 2);

		// source:4:target
		m(new LocalCalls());
	}
}
