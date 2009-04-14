package resolving_new.superclassmethod_2;

public class SubClass extends SuperClass {

	public void 
	// target:2
	m() {
		
	}

	public void callToClassMethod() {
		// source:2:target
		m();
	}

	public void callToSuperClassMethod() {
		super.
		// source:1:target
		m();
	}
}
