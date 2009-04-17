package resolving_new.typeparametersB_0;

public class Caller {

	public void callMethodWithBoundTypeParameter() {
		SubClass sub = new SubClass();
		
		sub.m().
		// source:1:target
		methodInClassA();
	}
}
