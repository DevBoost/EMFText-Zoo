package resolving_new.typeparametersA_2;

public class GenericClass<
	T // target:1
	,
	S // target:2
	> {

	public void m(
		// source:1:target
		T t,
		// source:2:target
		S s) {
		
	}
}
