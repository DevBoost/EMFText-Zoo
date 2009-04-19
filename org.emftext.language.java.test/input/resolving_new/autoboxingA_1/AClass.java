package resolving_new.autoboxingA_1;

public class AClass {
	
	public void // target:1 
	methodWithPrimitiveTypeParameter(int i) {}

	public void callWithIntegerObjectArgument() {
		// source:1:target
		methodWithPrimitiveTypeParameter(new Integer(1));
	}
}
