package resolving_new.autoboxingA_1;

public class AClass {
	
	public void methodWithPrimitiveTypeParameter // target:1
		(int i) {}

	public void callWithIntegerObjectArgument() {
		methodWithPrimitiveTypeParameter // source:1:target
		(new Integer(1));
	}
}
