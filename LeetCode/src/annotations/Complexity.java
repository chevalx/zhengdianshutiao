package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({
        ElementType.TYPE,
        ElementType.METHOD
})
public @interface Complexity {
    String bigO() default "none";
}
