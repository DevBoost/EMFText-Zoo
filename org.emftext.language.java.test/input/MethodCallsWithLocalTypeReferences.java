

public class MethodCallsWithLocalTypeReferences {

	public void m1() {
		m1();
	}

	public void m2() {
		m1();
		m2();
		m3();
		m3(new MethodCallsWithLocalTypeReferences());
	}

	public void m3() {
	}

	public void m3(MethodCallsWithLocalTypeReferences o) {
	}
}
