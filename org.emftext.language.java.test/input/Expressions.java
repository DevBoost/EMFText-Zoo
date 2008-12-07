public class Expressions {
	public int i;
	public boolean bool;
	{
		i = 1 + 2;
		i = (3);
		i = ((3));
		i = ((4+5));
		
		i = 4 << 2;
		i = 4 >> 2;
		i = i >>> 2;
		
		bool = i < 2;
		bool = i > 2;
		bool = i <= 2;
		bool = i >= 2;
		
		i = 4 & 2;
		i = 4 | 2;
		i = 4 == 2 ? 1 : 0;
		i = (int) i;
	}	
}
