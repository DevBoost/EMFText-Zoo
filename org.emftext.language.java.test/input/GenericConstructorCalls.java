public class GenericConstructorCalls {
	
	public class DummyType {
	}
	
	public class GenericClass<S> {
		public GenericClass() {}
	}
	
	public class GenericClassWithGenericConstructor<S> {
		public <T> GenericClassWithGenericConstructor() {}
	}
	
	public class NonGenericClassWithGenericConstructor {
		public <T> NonGenericClassWithGenericConstructor() {}
	}
	
	public void examples() {
		new GenericClass<DummyType>();
		new GenericClassWithGenericConstructor<DummyType>();
		new <DummyType>GenericClassWithGenericConstructor<DummyType>();
		new <DummyType>NonGenericClassWithGenericConstructor();
	}
}
