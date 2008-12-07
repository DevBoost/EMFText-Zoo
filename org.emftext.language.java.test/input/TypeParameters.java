public class TypeParameters {
	
	public class Inner<T> {
	}
	public class Inner2<T extends TypeParameters> {
	}
	
	public class Inner3<T extends TypeParameters & IOneMethod> {
	}
	
	public Inner<TypeParameters> field0;
	public Inner<?> field1;
	public Inner<? extends TypeParameters> field2;
	public Inner<? extends Inner<TypeParameters>> field3;
	public Inner<? super TypeParameters> field4;
	
	public <T> void method1() {}
	public <T extends TypeParameters> void method2() {}
	public <T> void method4() {}
}
