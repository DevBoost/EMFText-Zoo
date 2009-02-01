public class AnnotationsAsAnnotationArguments {
	
	public @interface A1 {
	}
	
	public @interface A2 {
		public String property();
	}
	
	public @interface B1 {
		// using an annotation as argument for an annotation instance
		@B1(m = @A1)
		public A1 m();
	}

	public @interface B2 {
		// using an annotation as argument for an annotation instance
		@B2(m = @A2(property = "something"))
		public A2 m();
	}

	public @interface C0 {
		// using an array of strings as argument for an annotation instance
		@C0(m = {"", "", ""})
		public String[] m();
	}

	public @interface C1 {
		// using an array of annotations as argument for an annotation instance
		@C1(m = {@A1, @A1, @A1})
		public A1[] m();
	}

	public @interface C2 {
		// using an array of annotations as argument for an annotation instance
		@C2(m = {@A2(property="value1"), @A2(property="value2"), @A2(property="value3")})
		public A2[] m();
	}

	public @interface C3 {
		// using an array of annotations as argument for an annotation instance
		@C3({@A1, @A1, @A1})
		public A1[] value();
	}
}
