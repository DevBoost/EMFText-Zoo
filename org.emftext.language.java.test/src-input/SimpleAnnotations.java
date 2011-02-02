@SimpleAnnotations
public @interface SimpleAnnotations {
	public @interface A1 {
	}
	
	@A1
	public int f1 = 0;
}
