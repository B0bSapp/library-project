package com.epam.code.mie.library.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = AuthorExistsValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthorExists {
    String message() default "Author does not exist";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
