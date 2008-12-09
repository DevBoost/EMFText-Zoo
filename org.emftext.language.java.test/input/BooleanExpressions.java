public class BooleanExpressions {
	boolean z = true;
	boolean x;
	int i = 2;
	{		
		x = true;
		
		x = true && false;
		x = true || false;
		
		x = true == false;
		x = true != false;
		
		z = true == false ? true : false;
		
		z = i < 2;
		z = i > 2;
		z = i <= 2;
		z = i >= 2;
	}
}
