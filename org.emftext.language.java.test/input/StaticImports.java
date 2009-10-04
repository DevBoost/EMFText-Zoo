import static pkg.EscapedStrings.*;
import pkg.EmptyClass;

public class StaticImports {
	{
		escapes1.toString();
		
		escapes2.toString();
		
		m1();
		
		new C1<StaticImports>();
		new EmptyClass();
	}
}
