package resolving_new.shadowedField_1;

public class AClass {

	private int duplicateName;
	
	public void shadow() {
		int
		// target:1
		duplicateName;
		
		// source:1:target
		duplicateName = 0;
	}
}
