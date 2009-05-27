package resolving_new.fields_2;

public class AClass {

	private AClass field1 // target:1
	;
	
	private AClass field2 // target:2
	;
	
	public void m() {
		// source:1:target
		field1.m();

		field1.
		// source:1:target
		field1.m();

		// source:2:target
		field2.m();

		field2.
		// source:2:target
		field2.m();

		field1.
		// source:2:target
		field2.m();

		field2.
		// source:1:target
		field1.m();
	}
}
