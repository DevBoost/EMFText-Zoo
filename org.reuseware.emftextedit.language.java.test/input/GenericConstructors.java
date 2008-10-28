public class GenericConstructors {
	public <T> GenericConstructors() {
		<GenericConstructors, GenericConstructors>this(null);
	}

	public <T1, T2> GenericConstructors(GenericConstructors dummyParameter) {
	}

	public <T1 extends GenericConstructors> GenericConstructors(GenericConstructors dummyParameter1, GenericConstructors dummyParameter2) {
	}

	public <T1 extends GenericConstructors, T2 extends GenericConstructors> GenericConstructors(GenericConstructors dummyParameter1, GenericConstructors dummyParameter2, GenericConstructors dummyParameter3) {
	}
}
