package resolving_new.autoboxingB_1;

public class AClass {
	
	public void  
	method(int i) {
		System.out.println("method with parameter type int");
	}

	public void // target:1 
	method(Integer i) {
		System.out.println("method with parameter type Integer");
	}

	public static void main(String[] args) {
		AClass a = new AClass();
		
		a.// source:1:target
		method(new Integer(1));
	}
}
