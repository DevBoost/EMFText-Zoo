import static pkg.EscapedStrings.escapes1;
import static pkg.EscapedStrings.escapes2;
import static pkg.EscapedStrings.m1;
import pkg.EmptyClass;
import pkg.EscapedStrings.C1;

public class StaticImports {
	{
		escapes1.toString();
		
		escapes2.toString();
		
		m1();
		
		new C1<StaticImports>();
		new EmptyClass();
	}
}
