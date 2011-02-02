public class CommentsBetweenConstructorArguments {

	public CommentsBetweenConstructorArguments(int a, int b, int c) {
		
	}
	
	{
		new CommentsBetweenConstructorArguments(1, // some comment 
				2 /* another comment */, 3);
	}
}
