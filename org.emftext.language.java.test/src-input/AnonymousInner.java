public class AnonymousInner {
	
	public class Inner {
	}
	
	public void createInner1() {
		// declaration of anonymous inner class
		AnonymousInner ai = new AnonymousInner() {
			public AnonymousInner field;
		};
	}

	public void createInner2() {
		// declaration of anonymous inner class
		this.new Inner() {
			
		};
	}
}
