package resolving_new.polymorphism_2;

public class Caller {
	
	public void m // target:1
		(SuperClass sc) {
	}

	public void m // target:2
		(Caller c) {
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
