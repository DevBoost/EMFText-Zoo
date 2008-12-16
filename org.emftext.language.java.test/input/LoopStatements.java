public class LoopStatements {
	{
		// for
		for (;condition;) {
		}
	}

	{
		// for
		for (;condition;) {
			continue;
		}
	}
	
	{
		// while
		while (condition) {
			break;
		}
	}
	
	{
		// empty statement
		;
	}
	
	{
		// do
		do {
			
		} while(condition);
	}

	{
        do break;
        while (condition);
	}
	
	public void loops() {
		// for
		for (;condition;) {
			continue;
		}
		
		for (;condition;) break;
		
		// while
		while (condition) {
			break;
		}
		
		while (condition) break;
		
		// empty statement
		;
		
		// do
		do {
			
		} while(condition);
	}
	
	{
		int x = 0;
		for(int i = 0;condition;){
			x = i;
		}
		for(int i = 0, j = 1;condition;){
			x = i;
			j = x;
			i = j;
		}
	}

	public void expressionListInit() {
		int i;
		int j;
		i=0;
		for(i=0,j=0;condition;){
			i = j;
			j = i;
		}
	}

	public void expressionListCondition() {
		int i = 0;
		int j = 0;
		for(;condition;i=j,j=i){}
	}

	private static boolean condition = false;
}
