package resolving_new.typeArgumentsA_2;

public class GenericClass<
	// target:1
	ParameterA,
	// target:2
	ParameterB> {

	public void m() {
		// TODO this test currently fails, because meta class
		// QualifiedTypeArgument does not have a reference to
		// the TypeParameter
		Object o = new GenericClass<
			// source:1:eContainer.eContainer.typeParameter
			Object, 
			// source:2:eContainer.eContainer.typeParameter
			Object>();
	}
}
