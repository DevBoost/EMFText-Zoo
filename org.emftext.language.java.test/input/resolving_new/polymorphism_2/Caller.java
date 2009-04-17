package resolving_new.polymorphism_2;

public class Caller {
	
	public void 
	// target:1
	m(SuperClass sc) {
	}

	public void 
	// target:2
	m(Caller c) {
	}

	public void polymorphicCalls() {
		SubClassA a = new SubClassA();
		SubClassB b = new SubClassB();
		
		// source:1:target
		m(a);
		// source:1:target
		m(b);
		// source:2:target
		m(this);
	}
}
