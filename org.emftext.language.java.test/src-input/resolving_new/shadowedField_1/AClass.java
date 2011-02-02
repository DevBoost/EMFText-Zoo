package resolving_new.shadowedField_1;

public class AClass {

	private int duplicateName;
	
	public void shadow() {
		int duplicateName // target:1
		= 0;
		
		// source:1:target
		duplicateName = 0;
	}
}
