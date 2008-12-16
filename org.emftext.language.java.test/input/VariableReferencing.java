

public class VariableReferencing {
	public VariableReferencing var;
	
	public void method() {
		// a reference to a member variable
		var = null; // statement1
		
		VariableReferencing var; // statement2
		
		// a reference to a local variable
		var = null; // statement3
		
		{ // statement4 (a block)
			
			// a reference to a local variable from inside a block
			var = null;
			// a reference to a local variable from inside a conditional statement
			if (true) {
				var = null;
			}
		}
		var = new VariableReferencing();
		var.method();
	}
}
