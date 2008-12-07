@Annotations(t1 = 0, t2 = 1)
public @interface Annotations {
	
	public int t2();

	public int t1() default 1;
	
	public @interface A1 {
	}
	
	public @interface A2 {
		int[] value();
	}
	
	public @interface A3 {
		A4 t();
	}
	
	public @interface A4 {
		String[] value();
	}
	
	@Annotations(t1 = 0, t2 = 3)
	public int t2 = 0;

	@A1
	public int t3 = 1;

	@A2({1,2,3})
	public int t4 = 1;

	@A3(t = @A4({"a","b","c"}))
	public int t5 = 1;
}
