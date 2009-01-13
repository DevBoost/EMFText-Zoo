import java.lang.annotation.*;

public class AnnotationsForAnnotations {
	@Target({ElementType.FIELD,ElementType.METHOD, ElementType.ANNOTATION_TYPE})
	@Retention(RetentionPolicy.CLASS)
	@MyAnnotation(something=true)
	@MyAnnotation2(something=true)
	@SuppressWarnings("unchecked")
	public @interface MyAnnotation {
		@MyAnnotation(something=true)
		boolean something();
	}
	
	public @interface MyAnnotation2 {
		@MyAnnotation(something=true)
		boolean something();
	}
}
