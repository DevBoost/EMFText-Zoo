public class LocalVariableDeclarations {
	// multiple variables in one declaration
	{
		int i,j;
		j = 0;
		// some assignments to avoid warnings
		i = j;
		j = i;
	}

	// multiple variables in one declaration with initialization
	{
		int i,j = 0;
		// some assignments to avoid warnings
		i = j;
		j = i;
	}
}
