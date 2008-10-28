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

	public void loops() {
		// for
		for (;condition;) {
			continue;
		}
		
		// while
		while (condition) {
			break;
		}
		
		// empty statement
		;
		
		// do
		do {
			
		} while(condition);
	}
	
	{
		for(int i = 0;condition;){}
		for(int i = 0, j = 1;condition;){}
	}

	public void expressionListInit() {
		int i;
		int j;
		i=0;
		for(i=0,j=0;condition;){}
	}

	public void expressionListCondition() {
		int i = 0;
		int j = 0;
		for(;condition;i=j,j=i){}
	}

	private static boolean condition = false;
}
