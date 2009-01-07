public class AnnotationsForInnerTypes {

	public @interface A {
	}

	@A
	public class AChild {}
	
	@A
	public interface AIntf {}
	
	@A
	public enum AEnum {A,B}
}
