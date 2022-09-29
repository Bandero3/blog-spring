package lt.codeacademy.blog.validator.annotation;

import lt.codeacademy.blog.validator.CompareFieldsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CompareFieldsValidator.class)
public @interface CompareFields {
    String message() default "{compareFields.constraint.invalid}";

    Class<?>[] groups() default {};

    Class<? extends Payload> [] payload() default {};

    String first();
    String second();
}
