import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

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
