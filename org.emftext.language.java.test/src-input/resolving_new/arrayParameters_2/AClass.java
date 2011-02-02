package resolving_new.arrayParameters_2;

public class AClass {

	public void m // target:1
	(String string) {
		System.out.println("m(String)");
	}
	
	public void m // target:2
		(String[] strings) {
		System.out.println("m(String...)");
	}
	
	public static void main(String[] args) {
		AClass a = new AClass();
		
		a.
		m // source:1:target
		("");

		a.
		m // source:2:target
		(new String[] {"", ""});
		
		String [] aStringArray = {"1", "3"};
		
		a.
		m // source:2:target
		(aStringArray);
		
		a.
		m // source:1:target
		(aStringArray[1]);
	}
}
