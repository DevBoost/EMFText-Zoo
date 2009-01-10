import java.lang.annotation.*;

public class AnnotationsForAnnotations {
	@Target({ElementType.FIELD,ElementType.METHOD, ElementType.ANNOTATION_TYPE})
	@Retention(RetentionPolicy.CLASS)
	@MyAnnotation(something=true)
	@SuppressWarnings("unchecked")
	public @interface MyAnnotation {
		boolean something();
	}
}
