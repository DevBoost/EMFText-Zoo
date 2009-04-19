package resolving_new.variableLengthParameters_2;

public class AClass {

	public void // target:1 
	m(String string) {
		System.out.println("m(String)");
	}
	
	public void // target:2
	m(String... strings) {
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
