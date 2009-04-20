package resolving_new.typeArgumentsA_1;

public class GenericClass<
	ParameterA,
	ParameterB> {

	public void m() {
		Object o = new GenericClass<
			// source:1:target
			SimpleClass, 
			// source:1:target
			SimpleClass>();
	}
}
