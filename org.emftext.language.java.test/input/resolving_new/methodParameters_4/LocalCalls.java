package resolving_new.methodParameters_4;

public class LocalCalls {

	public void // target:1 
	m() {}
	
	public void // target:2
	m(int a) {}
	
	public void // target:3
	m(int a, int b) {}
	
	public void // target:4
	m(Object a) {}
	
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
