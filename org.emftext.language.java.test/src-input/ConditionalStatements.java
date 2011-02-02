public class ConditionalStatements {
	
	public void conditions() {
		// if
		if (true) {
			
		}
		
		// if/else
		if (false) {
			
		} else {
			
		}
	}

	public void conditionsWithSingleStatements() {
		// if
		if (true) return;
		
		// if/else
		if (false) return; else return;
	}
	
	public void ConditionsWithCascades(){
		if(false){
		}else{
			if(false){
			}else{
				if(true){
					return;
				}
			}
		}
	}
	
	public void conditionsWithElseIf(){
		if(false){}
		else if(false){}
		else if (true) return;
		
	}
}