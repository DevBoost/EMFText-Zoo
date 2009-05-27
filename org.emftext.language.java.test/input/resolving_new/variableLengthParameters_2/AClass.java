package resolving_new.variableLengthParameters_2;

public class AClass {

	public void m // target:1
		(String string) {
		System.out.println("m(String)");
	}
	
	public void m // target:2
		(String... strings) {
		System.out.println("m(String...)");
	}
	
	public static void main(String[] args) {
		AClass a = new AClass();
		
		a.// source:1:target
		m("");
		
		a.// source:2:target
		m("", "");

		a.// source:2:target
		m(new String[] {"", ""});
	}
}
